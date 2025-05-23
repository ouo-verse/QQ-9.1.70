package com.tencent.qqlive.module.videoreport.report.element;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.apm.DTApmManager;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.exposure.DetectionData;
import com.tencent.qqlive.module.videoreport.exposure.ExposureDetector;
import com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.bizready.IBizReadyListener;
import com.tencent.qqlive.module.videoreport.report.bizready.IElementBizReady;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder;
import com.tencent.qqlive.module.videoreport.report.element.PendingQueue;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;
import com.tencent.qqlive.module.videoreport.sample.SampleInfo;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.traversal.ViewTraverser;
import com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ElementExposureReporter implements PageManager.IPageListener, AppEventReporter.IAppEventListener, IBizReadyListener<ExposureElementInfo> {
    private static final long DETECT_DELAY_FROM_IDLE = 0;
    private static final long DETECT_DELAY_FROM_POST = 320;
    private static final String TAG = "ElementExposure.ElementExposureReporter";
    private DelayedIdleHandler mDelayedIdleHandler;
    private DetectionTask mDetectionTask;
    private IElementBizReady mElementBizReady;
    private final Map<Long, String> mExposedIds;
    private IExposureRecorder mExposureRecorder;
    private PageInfo mFrontPageInfo;
    private ListenerMgr<OnElementTraverseListener> mListenerMgr;
    private PendingQueue mPendingQueue;
    private List<ExposureElementInfo> mPreExposedViewInfoList;
    private final ListenerMgr.INotifyCallback<OnElementTraverseListener> mTraverseEndCallback;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class DetectionTask extends DelayedIdleHandler.DelayedRunnable {
        private PageInfo pageInfo;

        public DetectionTask() {
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.DelayedRunnable
        public void run(int i3) {
            ElementExposureReporter.this.elementReport(this.pageInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ElementExposureCallBack implements IExposureDetectCallback<ReportDetectionData> {
        private Rect mExcludeArea;
        private Set<View> mNeedVisitViews;

        ElementExposureCallBack(Rect rect, Set<View> set) {
            this.mNeedVisitViews = set;
            this.mExcludeArea = rect;
        }

        private PathData getPathData(ReportDetectionData reportDetectionData, View view, DataEntity dataEntity) {
            PathData pathData;
            if (reportDetectionData.pathDatas.containsKey(view)) {
                return reportDetectionData.pathDatas.get(view);
            }
            PageInfo findRelatedPage = PageFinder.findRelatedPage(view);
            if (findRelatedPage != null) {
                PathData pathData2 = new PathData();
                pathData2.setPage(findRelatedPage.getPage());
                if (PathDataUtils.canCollect(dataEntity)) {
                    pathData2.addFirst(dataEntity);
                }
                reportDetectionData.pathDatas.put(view, pathData2);
                return pathData2;
            }
            View findPathParent = ReportHelper.findPathParent(view, dataEntity);
            if (findPathParent == null) {
                PathData pathData3 = new PathData();
                pathData3.addFirst(dataEntity);
                reportDetectionData.pathDatas.put(view, pathData3);
                return pathData3;
            }
            PathData pathData4 = getPathData(reportDetectionData, findPathParent, DataBinder.getDataEntity(findPathParent));
            if (pathData4 != null) {
                pathData = pathData4.copy();
                pathData.addFirst(dataEntity);
            } else {
                pathData = null;
            }
            reportDetectionData.pathDatas.put(view, pathData);
            return pathData;
        }

        private void updateEleExpose(View view, String str, PathData pathData) {
            Object page = pathData.getPage();
            EleExposeInfo eleExposeInfo = ExposurePolicyHelper.getEleExposeInfo(page, view, str, false);
            if (eleExposeInfo == null) {
                eleExposeInfo = new EleExposeInfo();
                ExposurePolicyHelper.putEleExposeInfo(page, view, str, eleExposeInfo, false);
            }
            if (eleExposeInfo.reportOverTime()) {
                eleExposeInfo.resetReport();
            }
            eleExposeInfo.onExpose();
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public Rect getExcludeRect() {
            return this.mExcludeArea;
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public void onLeave(View view, ReportDetectionData reportDetectionData) {
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public ReportDetectionData createDetectionData() {
            return new ReportDetectionData();
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public boolean onEnter(View view, ReportDetectionData reportDetectionData) {
            if (ElementExposureReporter.this.mFrontPageInfo != null && view == ElementExposureReporter.this.mFrontPageInfo.getPageView()) {
                this.mExcludeArea = null;
            }
            Boolean bool = (Boolean) DataRWProxy.getInnerParam(view, InnerKey.ELEMENT_DETECTION_ENABLE);
            if (bool != null) {
                return bool.booleanValue();
            }
            Set<View> set = this.mNeedVisitViews;
            return set != null && set.contains(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public void onExposed(View view, ReportDetectionData reportDetectionData, @NonNull AreaInfo areaInfo) {
            DataEntity dataEntity = DataBinder.getDataEntity(view);
            if (dataEntity == null) {
                return;
            }
            String elementId = DataEntityOperator.getElementId(dataEntity);
            if (TextUtils.isEmpty(elementId)) {
                return;
            }
            SampleInfoManager.getInstance().startSample(2, view);
            Object innerParam = DataRWProxy.getInnerParam(view, InnerKey.ELEMENT_IDENTIFIER);
            String str = innerParam instanceof String ? (String) innerParam : null;
            long calcElementUniqueId = ReportUtils.calcElementUniqueId(view);
            PathData pathData = getPathData(reportDetectionData, view, dataEntity);
            if (pathData != null) {
                if (ElementExposureReporter.this.exposureNotReported(calcElementUniqueId)) {
                    ExposureElementInfo exposureElementInfo = new ExposureElementInfo();
                    exposureElementInfo.setView(view);
                    exposureElementInfo.setPage(pathData.getPage());
                    exposureElementInfo.setIdentifier(str);
                    exposureElementInfo.setUniqueId(calcElementUniqueId);
                    exposureElementInfo.setPathData(pathData);
                    ReportHelper.ExposureReason checkExposureReason = ReportHelper.checkExposureReason(exposureElementInfo.getPage(), str, view);
                    if (!checkExposureReason.canReport) {
                        Log.d(ElementExposureReporter.TAG, "onExposed(), can't report Exposure, reason: " + checkExposureReason.message + ", elementId = " + elementId + ", uniqueId = " + calcElementUniqueId + ", identifier = " + str);
                    }
                    exposureElementInfo.setCanReport(checkExposureReason.canReport);
                    exposureElementInfo.setFinalData(ElementExposureReporter.this.getFinalData(view, pathData));
                    ElementExposureReporter.this.mPreExposedViewInfoList.add(exposureElementInfo);
                } else if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.d(ElementExposureReporter.TAG, "onExposed(), exposure have reported, elementId = " + elementId + ", uniqueId = " + calcElementUniqueId + ", identifier = " + str);
                }
                ElementExposureReporter.this.mExposureRecorder.updateAreaInfo(calcElementUniqueId, areaInfo);
                updateEleExpose(view, str, pathData);
                Map map = ElementExposureReporter.this.mExposedIds;
                Long valueOf = Long.valueOf(calcElementUniqueId);
                if (str == null) {
                    str = "";
                }
                map.put(valueOf, str);
                return;
            }
            Log.w(ElementExposureReporter.TAG, "onExposed(), not found owned page, ignore exposure, elementId = " + elementId + ", uniqueId = " + calcElementUniqueId + ", identifier = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ElementExposureReporter INSTANCE;

        static {
            ElementExposureReporter elementExposureReporter = new ElementExposureReporter();
            INSTANCE = elementExposureReporter;
            elementExposureReporter.init();
        }

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ReportDetectionData extends DetectionData {
        final Map<View, PathData> pathDatas = new ArrayMap();

        ReportDetectionData() {
        }
    }

    private void addKeySampleRate(View view, FinalData finalData) {
        SampleInfo elementSampleInfoByObject = SampleInfoManager.getInstance().getElementSampleInfoByObject(view, "imp");
        if (elementSampleInfoByObject != null) {
            finalData.put(DTParamKey.REPORT_KEY_ELE_SAMPLE_RATE, Float.valueOf(elementSampleInfoByObject.getSampleRate()));
        }
    }

    private void clearPreExposedContent() {
        this.mPreExposedViewInfoList.clear();
        this.mExposedIds.clear();
    }

    private boolean collectNeedVisitViews(View view, Set<View> set) {
        boolean z16;
        boolean z17 = false;
        if (view == null) {
            return false;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z16 = false;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                if (collectNeedVisitViews(viewGroup.getChildAt(i3), set)) {
                    z16 = true;
                }
            }
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(DataRWProxy.getElementId(view)) || z16 || !TextUtils.isEmpty(DataRWProxy.getPageId(view))) {
            z17 = true;
        }
        if (z17) {
            set.add(view);
        }
        return z17;
    }

    private void detect(View view, Rect rect) {
        SimpleTracer.begin("ElementExposureReporter.detect");
        PageInfo pageInfo = this.mFrontPageInfo;
        if (pageInfo != null && view == pageInfo.getPageView()) {
            rect = null;
        }
        ExposureDetector.detect(view, true, new ElementExposureCallBack(rect, getNeedVisitViewSet(view)), ViewTraverser.getInstance());
        SimpleTracer.end("ElementExposureReporter.detect");
    }

    private void dispatchElementReport(PageInfo pageInfo, int i3) {
        long j3;
        Log.d(TAG, "dispatchElementReport(), dispatch element exposure detect delay task, pageId = " + pageInfo.getPageId());
        this.mDelayedIdleHandler.remove(this.mDetectionTask);
        this.mDetectionTask.pageInfo = pageInfo;
        if (i3 == 0) {
            j3 = 0;
        } else {
            j3 = DETECT_DELAY_FROM_POST;
        }
        this.mDelayedIdleHandler.post(this.mDetectionTask, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elementReport(PageInfo pageInfo) {
        Log.d(TAG, "elementReport(), start element exposure detect task, pageInfo = " + pageInfo);
        long currentTimeMillis = System.currentTimeMillis();
        SimpleTracer.begin("ElementExposureReporter.elementReport");
        View pageView = pageInfo.getPageView();
        if (pageView == null) {
            return;
        }
        Rect rect = new Rect();
        if (!pageView.getGlobalVisibleRect(rect)) {
            rect = null;
        }
        this.mFrontPageInfo = pageInfo;
        boolean run = run(getAllEntryViews(pageView), -VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime(), rect);
        this.mListenerMgr.startNotify(this.mTraverseEndCallback);
        SimpleTracer.end("ElementExposureReporter.elementReport");
        DTApmManager.getInstance().onElementDetect(run, System.currentTimeMillis() - currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean exposureNotReported(long j3) {
        return !this.mExposureRecorder.isExposed(j3);
    }

    private List<View> getAllEntryViews(View view) {
        Dialog dialog;
        View rootView = view.getRootView();
        Activity findAttachedActivity = UIUtils.findAttachedActivity(view);
        if (findAttachedActivity == null) {
            return Collections.singletonList(rootView);
        }
        List<WeakReference<Dialog>> dialogList = DialogListUtil.getDialogList(findAttachedActivity);
        LinkedList linkedList = new LinkedList();
        if (dialogList != null) {
            for (int size = dialogList.size() - 1; size >= 0; size--) {
                WeakReference<Dialog> weakReference = dialogList.get(size);
                if (weakReference == null) {
                    dialog = null;
                } else {
                    dialog = weakReference.get();
                }
                if (dialog != null && dialog.getWindow() != null) {
                    View decorView = dialog.getWindow().getDecorView();
                    if (decorView == rootView) {
                        break;
                    }
                    linkedList.add(decorView);
                }
            }
        }
        linkedList.add(rootView);
        return new ArrayList(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FinalData getFinalData(View view, PathData pathData) {
        FinalData build = DataBuilderFactory.obtain().build("imp", pathData);
        if (build != null) {
            build.setEventKey("imp");
            build.setEventType(DataRWProxy.getEventType(view));
        }
        return build;
    }

    public static ElementExposureReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private Set<View> getNeedVisitViewSet(View view) {
        HashSet hashSet = new HashSet();
        collectNeedVisitViews(view, hashSet);
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        PageManager.getInstance().register(this);
        AppEventReporter.getInstance().register(this);
        this.mPendingQueue.setOnQueueListener(new PendingQueue.OnQueueListener() { // from class: com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.2
            @Override // com.tencent.qqlive.module.videoreport.report.element.PendingQueue.OnQueueListener
            public void onDequeue(ExposureElementInfo exposureElementInfo) {
                ElementExposureReporter.this.reportFinalData(exposureElementInfo);
            }
        });
        ElementBizReadyImp elementBizReadyImp = new ElementBizReadyImp();
        this.mElementBizReady = elementBizReadyImp;
        elementBizReadyImp.setOnBizReadyListener(this);
    }

    private boolean makeDirty(Set<Long> set) {
        HashSet hashSet = new HashSet();
        for (Long l3 : this.mExposureRecorder.getExposedRecords().keySet()) {
            if (l3 != null && !set.contains(l3)) {
                hashSet.add(l3);
            }
        }
        this.mExposureRecorder.markUnexposed(hashSet);
        if (hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    private void markUnexposed(PageInfo pageInfo) {
        Object obj;
        if (pageInfo == null || this.mExposureRecorder.getExposedRecords().size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, IExposureRecorder.ExposureInfoWrapper> entry : this.mExposureRecorder.getExposedRecords().entrySet()) {
            if (entry != null && entry.getValue() != null) {
                obj = entry.getValue().attachedPage.get();
            } else {
                obj = null;
            }
            if (obj != null && obj.equals(pageInfo.getPage())) {
                arrayList.add(entry.getKey());
            }
        }
        this.mExposureRecorder.markUnexposed(arrayList);
    }

    private void printDebug() {
        if (VideoReport.isDebugMode()) {
            Log.d(TAG, "run(), element exposure detect have " + this.mPreExposedViewInfoList.size() + " exposed view found");
            HashMap hashMap = new HashMap(this.mExposedIds);
            Log.d(TAG, "run(), new exposed view: count = " + this.mPreExposedViewInfoList.size());
            ArrayList arrayList = new ArrayList(this.mPreExposedViewInfoList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ExposureElementInfo exposureElementInfo = (ExposureElementInfo) arrayList.get(i3);
                if (exposureElementInfo != null) {
                    Log.d(TAG, "    elementId = " + DataRWProxy.getElementId(exposureElementInfo.getView()) + ", identifier = " + exposureElementInfo.getIdentifier() + ", uniqueId = " + exposureElementInfo.getUniqueId());
                    hashMap.remove(Long.valueOf(exposureElementInfo.getUniqueId()));
                }
            }
            Log.d(TAG, "run(), duplicate exposed view: count = " + hashMap.size());
            for (Map.Entry entry : hashMap.entrySet()) {
                Log.d(TAG, "    identifier = " + ((String) entry.getValue()) + ", uniqueId: " + entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportFinalData(ExposureElementInfo exposureElementInfo) {
        if (exposureElementInfo == null) {
            return;
        }
        View view = exposureElementInfo.getView();
        AreaInfo exposureAreaInfo = UIUtils.getExposureAreaInfo(view);
        long uniqueId = exposureElementInfo.getUniqueId();
        String identifier = exposureElementInfo.getIdentifier();
        String elementId = DataRWProxy.getElementId(view);
        if (exposureAreaInfo == null) {
            Log.w(TAG, "reportFinalData(), areaInfo is null, elementId = " + elementId + ", uniqueId = " + uniqueId + ", identifier = " + identifier);
            return;
        }
        if (!ReportHelper.isViewExposed(view, exposureAreaInfo.exposureRate) && this.mElementBizReady.isElementNotCached(view)) {
            Log.w(TAG, "reportFinalData(), exposure rate is too small, elementId = " + elementId + ", uniqueId = " + uniqueId + ", identifier = " + identifier);
            return;
        }
        if (!exposureNotReported(uniqueId) && this.mElementBizReady.isElementNotCached(view)) {
            Log.d(TAG, "reportFinalData(), exposure have reported, elementId = " + elementId + ", uniqueId = " + uniqueId + ", identifier = " + identifier);
            return;
        }
        this.mExposureRecorder.markExposed(exposureElementInfo);
        this.mExposureRecorder.updateAreaInfo(uniqueId, exposureAreaInfo);
        ExposureElementInfo handleExposureInfo = this.mElementBizReady.handleExposureInfo(exposureElementInfo);
        if (handleExposureInfo == null) {
            Log.d(TAG, "ElementExposureReporter.reportFinalData() -> finalExposureElementInfo == null,so return....");
            return;
        }
        if (!handleExposureInfo.canReport()) {
            Log.w(TAG, "reportFinalData(), exposure can't report, elementId = " + elementId + ", uniqueId = " + uniqueId + ", identifier = " + identifier);
            return;
        }
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        FinalData finalData = handleExposureInfo.getFinalData();
        if (finalData == null) {
            Log.w(TAG, "reportFinalData(), finalData is null, elementId = " + elementId + ", uniqueId = " + uniqueId + ", identifier = " + identifier);
            return;
        }
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("imp", finalData.getEventParams());
        }
        finalData.put(DTParamKey.REPORT_KEY_ELE_REUSE_ID, identifier);
        Object page = handleExposureInfo.getPage();
        EleExposeInfo eleExposeInfo = ExposurePolicyHelper.getEleExposeInfo(page, view, identifier, false);
        if (eleExposeInfo == null) {
            eleExposeInfo = new EleExposeInfo();
            ExposurePolicyHelper.putEleExposeInfo(page, view, identifier, eleExposeInfo, false);
        }
        finalData.put(DTParamKey.REPORT_KEY_ELE_IS_FIRST_IMP, String.valueOf(!eleExposeInfo.hasReport() ? 1 : 0));
        finalData.put(DTParamKey.REPORT_KEY_ELE_IS_FIRST_SCROLL_IMP, "0");
        finalData.put(DTParamKey.REPORT_KEY_SCROLL_FLAG, "0");
        addKeySampleRate(view, finalData);
        FinalDataTarget.handle(view, finalData);
        eleExposeInfo.onReport();
    }

    private boolean run(@NonNull List<View> list, long j3, Rect rect) {
        Rect rect2;
        clearPreExposedContent();
        boolean z16 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            View view = list.get(i3);
            if (i3 == list.size() - 1) {
                rect2 = rect;
            } else {
                rect2 = null;
            }
            detect(view, rect2);
        }
        printDebug();
        boolean makeDirty = makeDirty(this.mExposedIds.keySet());
        this.mPendingQueue.enqueue(this.mPreExposedViewInfoList, j3);
        if (makeDirty || this.mPreExposedViewInfoList.size() > 0) {
            z16 = true;
        }
        clearPreExposedContent();
        return z16;
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppIn() {
        Log.i(TAG, "onAppIn()");
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppOut(boolean z16) {
        Log.d(TAG, "onAppOut(), clear exposure recorder!");
        this.mExposureRecorder.clearExposure();
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageIn(@NonNull PageInfo pageInfo, @NonNull Set<PageInfo> set, int i3) {
        Log.d(TAG, "onPageIn(), pageId = " + pageInfo.getPageId());
        dispatchElementReport(pageInfo, i3);
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageOut(@NonNull PageInfo pageInfo, DataEntity dataEntity, @NonNull Set<PageInfo> set, boolean z16) {
        Log.d(TAG, "onPageOut(), pageId = " + pageInfo.getPageId());
        Iterator<PageInfo> it = set.iterator();
        while (it.hasNext()) {
            markUnexposed(it.next());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageUpdate(PageInfo pageInfo, int i3) {
        Log.d(TAG, "onPageUpdate(), pageId = " + pageInfo.getPageId());
        dispatchElementReport(pageInfo, i3);
    }

    public void registerTraverseListener(OnElementTraverseListener onElementTraverseListener) {
        this.mListenerMgr.register(onElementTraverseListener);
    }

    public void reportNotBizReadyElement(long j3) {
        this.mElementBizReady.reportNotBizReadyElement(j3);
    }

    public void setElementBizReady(Object obj, boolean z16) {
        this.mElementBizReady.setBizReady(obj, z16);
    }

    public void traverseExposure() {
        PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
        if (currentPageInfo != null) {
            elementReport(currentPageInfo);
        }
    }

    ElementExposureReporter() {
        this.mExposureRecorder = IExposureRecorder.Factory.getInstance();
        this.mPendingQueue = new PendingQueue();
        this.mPreExposedViewInfoList = new ArrayList();
        this.mExposedIds = new ConcurrentHashMap();
        this.mListenerMgr = new ListenerMgr<>();
        this.mTraverseEndCallback = new ListenerMgr.INotifyCallback<OnElementTraverseListener>() { // from class: com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.1
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(OnElementTraverseListener onElementTraverseListener) {
                onElementTraverseListener.onTraverseEnd();
            }
        };
        this.mDelayedIdleHandler = new DelayedIdleHandler();
        this.mDetectionTask = new DetectionTask();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReadyListener
    public void onBizReady(ExposureElementInfo exposureElementInfo) {
        if (exposureElementInfo == null) {
            return;
        }
        exposureElementInfo.setFinalData(getFinalData(exposureElementInfo.getView(), exposureElementInfo.getPathData()));
        reportFinalData(exposureElementInfo);
    }
}
