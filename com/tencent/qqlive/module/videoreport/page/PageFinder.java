package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.exposure.DetectionData;
import com.tencent.qqlive.module.videoreport.exposure.ExposureDetector;
import com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.traversal.ReversedViewTraverser;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes22.dex */
public class PageFinder {
    private static final String TAG = "page." + PageFinder.class.getSimpleName();

    /* loaded from: classes22.dex */
    static class PageExposureCallback implements IExposureDetectCallback<DetectionData> {
        private final Set<View> mPageAndParentViewSet;
        private boolean mShouldTerminate;
        private PageInfo mTargetPageInfo;

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public final DetectionData createDetectionData() {
            return new DetectionData();
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public Rect getExcludeRect() {
            return null;
        }

        public PageInfo getTargetPageInfo() {
            return this.mTargetPageInfo;
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public boolean onEnter(View view, DetectionData detectionData) {
            if (!this.mShouldTerminate && BaseUtils.contains(this.mPageAndParentViewSet, view)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public void onExposed(View view, DetectionData detectionData, @NonNull AreaInfo areaInfo) {
            PageInfo findRelatedPage;
            if (this.mShouldTerminate) {
                return;
            }
            double pageExposureMinRate = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(PageFinder.TAG, "onExposed: view = " + view + ", exposureInfo = " + areaInfo + ", exposureMinRate = " + pageExposureMinRate);
            }
            if (areaInfo.exposureRate >= Math.max(pageExposureMinRate, 0.0d) && (findRelatedPage = PageFinder.findRelatedPage(view)) != null && !PageFinder.isIgnorePageInOutEvent(findRelatedPage)) {
                PageInfo pageInfo = this.mTargetPageInfo;
                if (pageInfo == null) {
                    this.mTargetPageInfo = findRelatedPage;
                    this.mShouldTerminate = !ReportHelper.allPageReportEnabled(findRelatedPage);
                } else {
                    pageInfo.collectPage(findRelatedPage);
                }
            }
        }

        PageExposureCallback(Set<View> set) {
            this.mPageAndParentViewSet = set;
            this.mShouldTerminate = false;
        }

        @Override // com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback
        public void onLeave(View view, DetectionData detectionData) {
        }
    }

    static PageInfo assemblePageLink(PageInfo pageInfo) {
        if (isTerminatePage(pageInfo)) {
            return pageInfo;
        }
        View pageView = pageInfo.getPageView();
        PageInfo pageInfo2 = pageInfo;
        while (pageView != null) {
            View logicParentView = getLogicParentView(pageView);
            if (logicParentView == null) {
                pageView = getPhysicalParentView(pageView);
            } else {
                pageView = logicParentView;
            }
            if (pageView == null) {
                break;
            }
            pageInfo2 = updateTailPageInfo(pageInfo2, pageView);
            if (isTerminatePage(pageInfo2)) {
                break;
            }
        }
        return pageInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PageInfo findExposurePage(View view) {
        SimpleTracer.begin("PagePageFinder.findExposurePage");
        if (view == null || view.getRootView() == null) {
            return null;
        }
        PageExposureCallback pageExposureCallback = new PageExposureCallback(getPageViewAndParents(view.getRootView().getContext()));
        ExposureDetector.detect(view, false, pageExposureCallback, ReversedViewTraverser.getInstance());
        SimpleTracer.end("PagePageFinder.findExposurePage");
        PageInfo assemblePageLink = assemblePageLink(pageExposureCallback.getTargetPageInfo());
        printPageLink(assemblePageLink);
        printAllPages(assemblePageLink);
        return assemblePageLink;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r1 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PageInfo findOwnerPage(View view) {
        Object obj;
        while (obj instanceof View) {
            View view2 = (View) obj;
            PageInfo findRelatedPage = findRelatedPage(view2);
            if (findRelatedPage != null) {
                return findRelatedPage;
            }
            obj = view2.getParent();
        }
        return null;
    }

    public static PageInfo findRelatedPage(View view) {
        if (isPage(view)) {
            return new PageInfo(view, view);
        }
        Object boundContainer = ViewContainerBinder.getInstance().getBoundContainer(view);
        if (isPage(boundContainer)) {
            return new PageInfo(boundContainer, view);
        }
        return null;
    }

    private static View getDecorView(Window window) {
        if (window == null) {
            return null;
        }
        return window.getDecorView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View getLogicParentView(View view) {
        try {
            WeakReference weakReference = (WeakReference) DataRWProxy.getInnerParam(view, InnerKey.LOGIC_PARENT);
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        } catch (Exception unused) {
            return null;
        }
    }

    private static PageInfo getPageInfo(View view) {
        PageInfo findRelatedPage = findRelatedPage(view);
        if (findRelatedPage != null && !isIgnorePageInOutEvent(findRelatedPage)) {
            return findRelatedPage;
        }
        return null;
    }

    public static View getPageView(Object obj) {
        if (!isPage(obj)) {
            return null;
        }
        if (obj instanceof Activity) {
            return getDecorView(((Activity) obj).getWindow());
        }
        if (obj instanceof Dialog) {
            return getDecorView(((Dialog) obj).getWindow());
        }
        if (!(obj instanceof View)) {
            return null;
        }
        return (View) obj;
    }

    private static Set<View> getPageViewAndParents(@NonNull Context context) {
        Set<View> pageCache = VideoReportInner.getInstance().getPageCache(context);
        if (BaseUtils.isEmpty(pageCache)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (View view : pageCache) {
            if (view != null) {
                hashSet.add(view);
                for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                    hashSet.add((View) parent);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View getPhysicalParentView(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    public static boolean isIgnorePageInOutEvent(PageInfo pageInfo) {
        DataEntity dataEntity = DataBinder.getDataEntity(pageInfo.getPage());
        if (dataEntity == null) {
            return false;
        }
        Boolean bool = (Boolean) DataEntityOperator.getInnerParam(dataEntity, InnerKey.PAGE_REPORT_IGNORE);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "isIgnorePageInOutEvent: ignoreReport=" + bool);
        }
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean isPage(Object obj) {
        if (obj == null) {
            return false;
        }
        return !TextUtils.isEmpty(DataEntityOperator.getPageId(DataBinder.getDataEntity(obj)));
    }

    private static boolean isTerminatePage(PageInfo pageInfo) {
        if (pageInfo == null || pageInfo.getPageView() == null || !ReportHelper.isEnablePageLink(pageInfo.getPageView().getRootView())) {
            return true;
        }
        Integer pageSearchMode = VideoReportInner.getInstance().getPageSearchMode(pageInfo.getPage());
        if (pageSearchMode == null) {
            pageSearchMode = VideoReportInner.getInstance().getPageSearchMode(pageInfo.getPageView());
        }
        if (pageSearchMode != null && 1 == pageSearchMode.intValue()) {
            return true;
        }
        return false;
    }

    private static void printAllPages(PageInfo pageInfo) {
        if (!VideoReport.isDebugMode() || !ReportHelper.allPageReportEnabled(pageInfo)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("allPages : ");
        sb5.append(pageInfo.getPageId());
        sb5.append(" ");
        Iterator<PageInfo> it = pageInfo.getAllPages().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getPageId());
            sb5.append(" ");
        }
        Log.i(TAG, sb5.toString());
    }

    private static void printPageLink(PageInfo pageInfo) {
        if (pageInfo != null && VideoReport.isDebugMode()) {
            Log.i(TAG, "PageLink \u2014\u2014 " + pageInfo);
        }
    }

    private static PageInfo updateTailPageInfo(PageInfo pageInfo, View view) {
        PageInfo pageInfo2 = getPageInfo(view);
        if (pageInfo2 != null) {
            pageInfo.setParentPage(pageInfo2);
            return pageInfo2;
        }
        return pageInfo;
    }
}
