package com.tencent.qqlive.module.videoreport.page;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes22.dex */
public class PageManager implements PageSwitchObserver.IPageSwitchListener, AppEventReporter.IAppEventListener, FinalDataTarget.IFinalDataHandleListener {
    private static final String TAG = "page." + PageManager.class.getSimpleName();
    private DataEntity mCurrentPageDataEntity;
    private PageInfo mCurrentPageInfo;
    private Handler mHandler;
    private InnerRunnable mInnerRunnable;
    private PageInteractiveFlagHandler mInteractiveFlagHandler;
    private boolean mLastPageIsDisappear;
    private ListenerMgr<IPageListener> mListenerMgr;
    private int mPgStp;

    /* loaded from: classes22.dex */
    public interface IPageListener {
        public static final int PG_IN_FROM_IDLE = 0;
        public static final int PG_IN_FROM_POST = 1;

        void onPageIn(@NonNull PageInfo pageInfo, @NonNull Set<PageInfo> set, int i3);

        void onPageOut(@NonNull PageInfo pageInfo, DataEntity dataEntity, @NonNull Set<PageInfo> set, boolean z16);

        void onPageUpdate(PageInfo pageInfo, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class InnerRunnable implements Runnable {
        int invokeFrom;
        PageInfo pageInfo;

        InnerRunnable() {
            this.invokeFrom = 0;
        }

        private boolean isPageVisible(@NonNull PageInfo pageInfo) {
            View pageView = pageInfo.getPageView();
            if (pageView == null) {
                return false;
            }
            double pageExposureMinRate = VideoReportInner.getInstance().getConfiguration().getPageExposureMinRate();
            double viewExposureRate = UIUtils.getViewExposureRate(pageView);
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.i(PageManager.TAG, "isPageVisible: pageInfo = " + pageInfo + ", exposureMinRate = " + pageExposureMinRate + ", exposureRate = " + viewExposureRate);
            }
            if (viewExposureRate <= 0.0d || viewExposureRate < pageExposureMinRate) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isPageVisible(this.pageInfo)) {
                return;
            }
            if (!PageManager.this.mLastPageIsDisappear && PageManager.this.mCurrentPageInfo != null && PageManager.this.mCurrentPageInfo.getPage() != this.pageInfo.getPage()) {
                PageManager pageManager = PageManager.this;
                pageManager.onPageOut(this.pageInfo, pageManager.mCurrentPageInfo, false);
            }
            PageInfo pageInfo = PageManager.this.mCurrentPageInfo;
            PageManager.this.mCurrentPageInfo = this.pageInfo;
            PageManager pageManager2 = PageManager.this;
            if (pageManager2.isPotentialPageChange(this.pageInfo, pageInfo, pageManager2.mLastPageIsDisappear)) {
                PageManager.this.onPageIn(this.pageInfo, pageInfo, this.invokeFrom);
            } else {
                PageManager.this.onPageUpdate(this.pageInfo, pageInfo, this.invokeFrom);
            }
            PageManager.this.mLastPageIsDisappear = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final PageManager INSTANCE;

        static {
            PageManager pageManager = new PageManager();
            INSTANCE = pageManager;
            pageManager.init();
        }

        InstanceHolder() {
        }
    }

    private void checkPageOut() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "checkPageOut, mCurrentPageInfo = " + this.mCurrentPageInfo);
        }
        if (this.mCurrentPageInfo != null && !this.mLastPageIsDisappear) {
            InnerRunnable innerRunnable = this.mInnerRunnable;
            if (innerRunnable.pageInfo != null) {
                this.mHandler.removeCallbacks(innerRunnable);
            }
            onPageOut(null, this.mCurrentPageInfo, true);
            this.mLastPageIsDisappear = true;
        }
    }

    private void copyCurPageInfo() {
        this.mCurrentPageDataEntity = DataEntityOperator.copy(this.mCurrentPageDataEntity);
    }

    private PageInfo findNewPageLinkHead(@NonNull PageInfo pageInfo, View view) {
        View pageView = pageInfo.getPageView();
        PageInfo pageInfo2 = pageInfo;
        while (pageView != null) {
            if (pageInfo2 != null && pageView == pageInfo2.getPageView()) {
                pageInfo2 = pageInfo2.getParentPage();
            }
            if (pageView == view) {
                return pageInfo2;
            }
            View logicParentView = PageFinder.getLogicParentView(pageView);
            if (logicParentView == null) {
                pageView = PageFinder.getPhysicalParentView(pageView);
            } else {
                pageView = logicParentView;
            }
        }
        return pageInfo;
    }

    @NonNull
    private Pair<DataEntity, Integer> getCreRefPageData(DataEntity dataEntity, int i3, PageContext pageContext) {
        DataEntity dataEntity2;
        if (pageContext != null && (dataEntity2 = pageContext.crePageData) != null) {
            return Pair.create(dataEntity2, Integer.valueOf(pageContext.crePageStep));
        }
        return Pair.create(dataEntity, Integer.valueOf(i3));
    }

    public static PageManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        PageSwitchObserver.getInstance().register(this);
        AppEventReporter.getInstance().register(this);
        FinalDataTarget.registerListener(this);
        this.mInteractiveFlagHandler = PageInteractiveFlagHandler.create(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPotentialPageChange(@NonNull PageInfo pageInfo, @Nullable PageInfo pageInfo2, boolean z16) {
        if (pageInfo2 == null || pageInfo.getPage() != pageInfo2.getPage()) {
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageIn(final PageInfo pageInfo, PageInfo pageInfo2, final int i3) {
        View view;
        if (VideoReportInner.getInstance().isDebugMode()) {
            String str = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onPageIn: pageInfo page=");
            sb5.append(pageInfo);
            sb5.append(", decorView=");
            if (pageInfo.getPageView() != null) {
                view = pageInfo.getPageView().getRootView();
            } else {
                view = null;
            }
            sb5.append(view);
            Log.d(str, sb5.toString());
        }
        int i16 = this.mPgStp;
        this.mPgStp = i16 + 1;
        DataEntity dataEntity = this.mCurrentPageDataEntity;
        this.mCurrentPageDataEntity = pageInfo.constructDataEntityLink();
        updatePageContext(pageInfo, pageInfo2, i16, dataEntity);
        final Set<PageInfo> findNewInPage = pageInfo.findNewInPage(pageInfo2);
        printInPageSet(findNewInPage);
        DataEntityOperator.removeInnerParam(this.mCurrentPageDataEntity, InnerKey.LAST_CLICK_ELEMENT);
        PageEventListenerMgr.notifyAfterPageIn(pageInfo.getPage());
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IPageListener>() { // from class: com.tencent.qqlive.module.videoreport.page.PageManager.1
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IPageListener iPageListener) {
                iPageListener.onPageIn(pageInfo, findNewInPage, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageOut(PageInfo pageInfo, @NonNull final PageInfo pageInfo2, final boolean z16) {
        Set<PageInfo> findNewOutPage;
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onPageOut: ");
        }
        copyCurPageInfo();
        if (pageInfo != null) {
            findNewOutPage = pageInfo.findNewOutPage(pageInfo2);
        } else {
            findNewOutPage = pageInfo2.findNewOutPage(pageInfo2);
        }
        final DataEntity dataEntity = this.mCurrentPageDataEntity;
        final Set<PageInfo> set = findNewOutPage;
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IPageListener>() { // from class: com.tencent.qqlive.module.videoreport.page.PageManager.2
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IPageListener iPageListener) {
                iPageListener.onPageOut(pageInfo2, dataEntity, set, z16);
            }
        });
        for (PageInfo pageInfo3 : findNewOutPage) {
            if (pageInfo3.getPage() != null) {
                PageContext pageContext = PageContextManager.getInstance().get(pageInfo3.getPageHashCode());
                if (pageContext != null) {
                    pageContext.disappear();
                }
            } else {
                PageContextManager.getInstance().remove(pageInfo3.getPageHashCode());
            }
        }
        DataEntity dataEntity2 = this.mCurrentPageDataEntity;
        if (dataEntity2 != null) {
            dataEntity2.unRegisterDynamicParamsProvider();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageUpdate(final PageInfo pageInfo, PageInfo pageInfo2, final int i3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onPageUpdate: ");
        }
        if (ReportHelper.allPageReportEnabled(pageInfo)) {
            Set<PageInfo> findInPagesWhenUpdate = pageInfo.findInPagesWhenUpdate(pageInfo2);
            pageInfo.setUpdateInPages(findInPagesWhenUpdate);
            updateInPagesContext(findInPagesWhenUpdate, pageInfo);
            pageInfo.setUpdateOutPages(pageInfo.findOutPagesWhenUpdate(pageInfo2));
        }
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IPageListener>() { // from class: com.tencent.qqlive.module.videoreport.page.PageManager.3
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IPageListener iPageListener) {
                iPageListener.onPageUpdate(pageInfo, i3);
            }
        });
    }

    private void printInPageSet(Set<PageInfo> set) {
        if (VideoReport.isDebugMode()) {
            StringBuilder sb5 = new StringBuilder("newInPages : ");
            Iterator<PageInfo> it = set.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().getPageId());
                sb5.append(" ");
            }
            Log.i(TAG, sb5.toString());
        }
    }

    private void resetCurPageDataEntity() {
        DataEntity dataEntity = new DataEntity();
        this.mCurrentPageDataEntity = dataEntity;
        DataEntityOperator.setPageId(dataEntity, PageUtils.VR_PAGE_NONE);
    }

    private void updateInPagesContext(Set<PageInfo> set, PageInfo pageInfo) {
        PageContext pageContext;
        if (BaseUtils.isEmpty(set) || (pageContext = PageContextManager.getInstance().get(pageInfo.getPageHashCode())) == null) {
            return;
        }
        for (PageInfo pageInfo2 : set) {
            PageContextManager.getInstance().set(pageInfo2.getPageHashCode(), new PageContext(pageContext.pageStep, pageContext.refPageStep, pageContext.crePageStep, DataBinder.getDataEntity(pageInfo2.getPage()), pageContext.refPageData, pageContext.crePageData));
        }
    }

    private void updatePageContext(PageInfo pageInfo, PageInfo pageInfo2, int i3, DataEntity dataEntity) {
        if (pageInfo == null) {
            return;
        }
        for (PageInfo pageInfo3 : pageInfo.findNewInPage(pageInfo2)) {
            Pair<DataEntity, Integer> creRefPageData = getCreRefPageData(dataEntity, i3, PageContextManager.getInstance().get(pageInfo3.getPageHashCode()));
            PageContextManager.getInstance().set(pageInfo3.getPageHashCode(), new PageContext(i3 + 1, i3, ((Integer) creRefPageData.second).intValue(), DataBinder.getDataEntity(pageInfo3.getPage()), dataEntity, (DataEntity) creRefPageData.first));
        }
    }

    public void addPgStep() {
        this.mPgStp++;
    }

    public void clearPageContext(Object obj) {
        if (!PageFinder.isPage(obj)) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "clearPageContext: object is not page, object = " + obj);
                return;
            }
            return;
        }
        PageContextManager.getInstance().remove(obj.hashCode());
    }

    public int getCurPgStp() {
        return this.mPgStp;
    }

    @Nullable
    public PageInfo getCurrentPageInfo() {
        return this.mCurrentPageInfo;
    }

    public PageInteractiveFlagHandler getInteractiveFlagHandler() {
        return this.mInteractiveFlagHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLastPageIsDisappear() {
        return this.mLastPageIsDisappear;
    }

    public void markInteractive(Object obj, Window window, MotionEvent motionEvent, boolean z16, boolean z17) {
        PageInteractiveFlagHandler pageInteractiveFlagHandler = this.mInteractiveFlagHandler;
        if (pageInteractiveFlagHandler != null) {
            pageInteractiveFlagHandler.onDispatchTouchEvent(obj, window, motionEvent, z16, z17);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppOut(boolean z16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onAppOut: ");
        }
        checkPageOut();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.FinalDataTarget.IFinalDataHandleListener
    public void onHandleFinalData(Object obj, @NonNull FinalData finalData, @NonNull Map<String, Object> map) {
        if ("clck".equals(finalData.eventKey) && (obj instanceof View)) {
            View view = (View) obj;
            if (TextUtils.isEmpty(DataRWProxy.getElementId(view))) {
                return;
            }
            Map<String, Object> viewTreeParamsForView = VideoReportInner.getInstance().viewTreeParamsForView("clck", view);
            if (BaseUtils.isEmpty(viewTreeParamsForView)) {
                return;
            }
            viewTreeParamsForView.remove(ParamKey.ELEMENT_PARAMS);
            DataEntityOperator.putInnerParam(this.mCurrentPageDataEntity, InnerKey.LAST_CLICK_ELEMENT, new PageLastClickEleInfo(viewTreeParamsForView));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.IPageSwitchListener
    public void onPageAppear(@NonNull PageInfo pageInfo, int i3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onPageAppear: page = " + pageInfo + ", pageStep = " + this.mPgStp);
        }
        if (isPotentialPageChange(pageInfo, this.mCurrentPageInfo, this.mLastPageIsDisappear)) {
            updatePageContext(pageInfo, this.mCurrentPageInfo, this.mPgStp, this.mCurrentPageDataEntity);
        }
        this.mHandler.removeCallbacks(this.mInnerRunnable);
        InnerRunnable innerRunnable = this.mInnerRunnable;
        innerRunnable.pageInfo = pageInfo;
        innerRunnable.invokeFrom = i3;
        this.mHandler.postDelayed(innerRunnable, VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime());
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.IPageSwitchListener
    public boolean onPageDestroyed(@NonNull View view) {
        boolean z16;
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onPageDestroyed, mCurrentPageInfo = " + this.mCurrentPageInfo + ", disappearingView = " + view);
        }
        PageInfo pageInfo = this.mCurrentPageInfo;
        if (pageInfo == null || this.mLastPageIsDisappear) {
            return false;
        }
        PageInfo findNewPageLinkHead = findNewPageLinkHead(pageInfo, view);
        PageInfo pageInfo2 = this.mCurrentPageInfo;
        if (findNewPageLinkHead != pageInfo2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            onPageOut(findNewPageLinkHead, pageInfo2, true);
        }
        if (findNewPageLinkHead == null) {
            this.mLastPageIsDisappear = true;
        } else {
            this.mCurrentPageInfo = findNewPageLinkHead;
            this.mLastPageIsDisappear = false;
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onPageDestroyed, hasNewPageOut = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.IPageSwitchListener
    public void onPageDisappear() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onPageDisappear");
        }
        checkPageOut();
    }

    public void register(IPageListener iPageListener) {
        this.mListenerMgr.register(iPageListener);
    }

    public void resetPagePath() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "resetPagePath: ");
        }
        this.mPgStp = 0;
        resetCurPageDataEntity();
        this.mCurrentPageInfo = null;
        this.mLastPageIsDisappear = false;
        PageContextManager.getInstance().clear();
        this.mHandler.removeCallbacks(this.mInnerRunnable);
    }

    public void unregister(IPageListener iPageListener) {
        this.mListenerMgr.unregister(iPageListener);
    }

    PageManager() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mInnerRunnable = new InnerRunnable();
        this.mListenerMgr = new ListenerMgr<>();
        resetCurPageDataEntity();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppIn() {
    }
}
