package com.tencent.qqlive.module.videoreport.report.scroll;

import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.EleExposeInfo;
import com.tencent.qqlive.module.videoreport.report.element.ExposurePolicyHelper;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ScrollableViewExposureReport {
    private static final long DETECTION_DELAY = 20;
    private static final int SCROLL_STATE_IDLE = 0;
    private static final String TAG = "ScrollableViewExposureHelper";
    private int mScrollState = 0;
    private ArrayList<DataEntity> mExposureAttachedList = new ArrayList<>();
    private ArrayList<DataEntity> mExposureReportList = new ArrayList<>();
    private ArrayList<DataEntity> mExposureEndReportList = new ArrayList<>();
    private DelayedIdleHandler mDelayedIdleHandler = new DelayedIdleHandler();
    private DetectionTask mDetectionTask = new DetectionTask();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class DetectionTask extends DelayedIdleHandler.DelayedRunnable {
        protected WeakReference<View> mWeakScrollView;

        DetectionTask() {
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.DelayedRunnable
        public void run(int i3) {
            WeakReference<View> weakReference = this.mWeakScrollView;
            if (weakReference != null && weakReference.get() != null) {
                ScrollableViewExposureReport.this.scrollEventReport(this.mWeakScrollView.get());
            }
        }

        public void setScrollViewRef(View view) {
            this.mWeakScrollView = new WeakReference<>(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ScrollableViewExposureReport INSTANCE = new ScrollableViewExposureReport();

        InstanceHolder() {
        }
    }

    ScrollableViewExposureReport() {
    }

    public static ScrollableViewExposureReport getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean isScrollExposureEnable(View view) {
        Object extendParam = DataRWProxy.getExtendParam(view, DTConstants.DTExtendMapKey.ELEMENT_SCROLL_EXPOSURE);
        if (extendParam instanceof Boolean) {
            return ((Boolean) extendParam).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollEventReport(View view) {
        SimpleTracer.begin("scrollEventReport");
        if (this.mScrollState != 0) {
            return;
        }
        PathData collect = ReversedDataCollector.collect(view);
        int size = this.mExposureReportList.size();
        SimpleTracer.begin("scrollEventReport start " + size);
        Iterator<DataEntity> it = this.mExposureReportList.iterator();
        while (it.hasNext()) {
            DataEntity next = it.next();
            PathData copy = collect.copy();
            copy.addFirst(next);
            triggleDataEntityReport(view, "imp", next, copy);
        }
        SimpleTracer.end("scrollEventReport start " + size);
        int size2 = this.mExposureEndReportList.size();
        SimpleTracer.begin("scrollEventReport end " + size2);
        Iterator<DataEntity> it5 = this.mExposureEndReportList.iterator();
        while (it5.hasNext()) {
            DataEntity next2 = it5.next();
            PathData copy2 = collect.copy();
            copy2.addFirst(next2);
            triggleDataEntityReport(view, "imp_end", next2, copy2);
        }
        SimpleTracer.end("scrollEventReport end " + size2);
        this.mExposureAttachedList.clear();
        this.mExposureReportList.clear();
        this.mExposureEndReportList.clear();
        SimpleTracer.end("scrollEventReport");
    }

    private void triggleDataEntityReport(View view, String str, DataEntity dataEntity, PathData pathData) {
        FinalData build = DataBuilderFactory.obtain().build(str, pathData);
        if (build == null) {
            return;
        }
        build.setEventKey(str);
        build.setEventType(DataRWProxy.getEventType(view));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(str, build.getEventParams());
        }
        build.put(DTParamKey.REPORT_KEY_SCROLL_FLAG, "1");
        if (str.equals("imp")) {
            build.put(DTParamKey.REPORT_KEY_ELE_IS_FIRST_SCROLL_IMP, DataRWProxy.getExtendParam(dataEntity, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_IS_FIRST_SCROLL_EXPOSURE));
            build.put(DTParamKey.REPORT_KEY_ELE_IS_FIRST_IMP, "0");
            build.put(DTParamKey.REPORT_KEY_ELE_REUSE_ID, DataRWProxy.getExtendParam(dataEntity, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_REUSE_ID));
        } else if (str.equals("imp_end")) {
            build.put("element_lvtm", DataRWProxy.getExtendParam(dataEntity, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_INTERVAL_TIME));
            build.put(DTParamKey.REPORT_KEY_ELEMENT_AREA, "");
            build.put(DTParamKey.REPORT_KEY_ELE_IMP_RATE, "");
            build.put(DTParamKey.REPORT_KEY_ELE_IMP_AREA, "");
        }
        FinalDataTarget.handle(null, build);
    }

    private EleExposeInfo updateScrollExposureInfo(Object obj, View view, String str) {
        EleExposeInfo orNewEleExposeInfo = getOrNewEleExposeInfo(obj, view, str);
        if (orNewEleExposeInfo.reportOverTime()) {
            orNewEleExposeInfo.resetReport();
        }
        orNewEleExposeInfo.onExpose();
        return orNewEleExposeInfo;
    }

    public EleExposeInfo getOrNewEleExposeInfo(Object obj, View view, String str) {
        EleExposeInfo eleExposeInfo = ExposurePolicyHelper.getEleExposeInfo(obj, view, str, true);
        if (eleExposeInfo == null) {
            EleExposeInfo eleExposeInfo2 = new EleExposeInfo();
            ExposurePolicyHelper.putEleExposeInfo(obj, view, str, eleExposeInfo2, true);
            return eleExposeInfo2;
        }
        return eleExposeInfo;
    }

    public void onChildViewAttached(View view) {
        String str;
        Object obj;
        SimpleTracer.begin("onChildViewAttached");
        if (this.mScrollState == 0) {
            return;
        }
        DataEntity dataEntity = DataRWProxy.getDataEntity(view, false);
        if (dataEntity != null) {
            DataRWProxy.putExtendParam(dataEntity, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_TIME, (Object) Long.valueOf(System.currentTimeMillis()));
            Object innerParam = DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_IDENTIFIER);
            Object obj2 = null;
            if (innerParam instanceof String) {
                str = (String) innerParam;
            } else {
                str = null;
            }
            PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
            if (currentPageInfo != null) {
                obj = currentPageInfo.getPage();
            } else {
                obj = null;
            }
            if (ReportHelper.reportExposure(obj, str, view, true)) {
                this.mExposureAttachedList.add(dataEntity);
                if (currentPageInfo != null) {
                    obj2 = currentPageInfo.getPage();
                }
                DataRWProxy.putExtendParam(dataEntity, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_IS_FIRST_SCROLL_EXPOSURE, (Object) String.valueOf(!updateScrollExposureInfo(obj2, view, str).hasReport() ? 1 : 0));
                DataRWProxy.putExtendParam(dataEntity, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_REUSE_ID, (Object) str);
            }
        }
        SimpleTracer.end("onChildViewAttached");
    }

    public void onChildViewDetached(View view) {
        String str;
        SimpleTracer.begin("onChildViewDetached");
        if (this.mScrollState == 0) {
            return;
        }
        DataEntity dataEntity = DataRWProxy.getDataEntity(view, false);
        if (this.mExposureAttachedList.contains(dataEntity)) {
            Object innerParam = DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_IDENTIFIER);
            Object obj = null;
            if (innerParam instanceof String) {
                str = (String) innerParam;
            } else {
                str = null;
            }
            PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
            if (currentPageInfo != null) {
                obj = currentPageInfo.getPage();
            }
            getOrNewEleExposeInfo(obj, view, str).onReport();
            this.mExposureAttachedList.remove(dataEntity);
            DataEntity copy = DataEntityOperator.copy(dataEntity);
            this.mExposureReportList.add(copy);
            DataRWProxy.putExtendParam(copy, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_INTERVAL_TIME, (Object) String.valueOf(System.currentTimeMillis() - ((Long) DataRWProxy.getExtendParam(copy, DTConstants.DTExtendMapKey.ELEMENT_EXPOSURE_TIME)).longValue()));
            if (ReportHelper.reportEndExposure(view, true)) {
                this.mExposureEndReportList.add(copy);
            }
        }
        SimpleTracer.end("onChildViewDetached");
    }

    public void onScrollStateChanged(View view, int i3) {
        this.mScrollState = i3;
        if (i3 != 0) {
            return;
        }
        this.mDetectionTask.setScrollViewRef(view);
        this.mDelayedIdleHandler.remove(this.mDetectionTask);
        this.mDelayedIdleHandler.post(this.mDetectionTask, 20L);
    }
}
