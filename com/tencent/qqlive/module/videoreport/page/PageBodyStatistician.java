package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ScrollReader;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes22.dex */
public class PageBodyStatistician {
    private static final String TAG = "page." + PageBodyStatistician.class.getSimpleName();
    private Map<View, BodyInfoHandler> mHandlerMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class BodyInfoHandler {
        private PageBodyInfo mPageBodyInfo = new PageBodyInfo();
        private PageInfo mPageInfo;
        private WeakReference<IScrollReader> mScrollReader;
        private WeakReference<View> mView;

        BodyInfoHandler(View view, IScrollReader iScrollReader) {
            this.mView = new WeakReference<>(view);
            this.mScrollReader = new WeakReference<>((IScrollReader) BaseUtils.nullAs(iScrollReader, ScrollReader.getScrollReader(view)));
            ScrollReader.injectScrollListener(view, new ScrollReader.OnScrollChangeListener() { // from class: com.tencent.qqlive.module.videoreport.page.PageBodyStatistician.BodyInfoHandler.1
                @Override // com.tencent.qqlive.module.videoreport.page.ScrollReader.OnScrollChangeListener
                public void onScrollChanged() {
                    BodyInfoHandler.this.updateScroll();
                }
            });
        }

        private void readInitScroll() {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.page.PageBodyStatistician.BodyInfoHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    BodyInfoHandler.this.updateScroll();
                }
            });
        }

        private void transferDataToPage() {
            Object page;
            PageInfo pageInfo = this.mPageInfo;
            if (pageInfo == null) {
                page = null;
            } else {
                page = pageInfo.getPage();
            }
            if (page != null) {
                DataRWProxy.setInnerParam(page, InnerKey.PAGE_BODY_INFO, this.mPageBodyInfo);
            }
        }

        private void tryGetPageInfo() {
            View view = this.mView.get();
            if (view != null && this.mPageInfo == null) {
                this.mPageInfo = PageFinder.findOwnerPage(view);
            }
        }

        private boolean updateProgress(PageBodyInfo pageBodyInfo, int i3) {
            double d16;
            int rangeStart = pageBodyInfo.getRangeStart();
            int rangeEnd = pageBodyInfo.getRangeEnd();
            int pageArea = pageBodyInfo.getPageArea();
            int max = (Math.max(rangeStart, Math.min(rangeEnd, i3)) - rangeStart) + 1;
            if (pageArea == 0) {
                d16 = 0.0d;
            } else {
                d16 = max / pageArea;
            }
            if (d16 > pageBodyInfo.getProgressRate()) {
                pageBodyInfo.setProgressArea(max);
                pageBodyInfo.setProgressRate(d16);
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateScroll() {
            IScrollReader iScrollReader = this.mScrollReader.get();
            View view = this.mView.get();
            if (iScrollReader != null && view != null) {
                onScrolled(iScrollReader.readScroll(view));
            }
        }

        public void onScrolled(int i3) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(PageBodyStatistician.TAG, "BodyInfoHandler.onScrolled: scrollEnd = " + i3);
            }
            if (updateProgress(this.mPageBodyInfo, i3)) {
                tryGetPageInfo();
                transferDataToPage();
            }
        }

        void updateRange(int i3, int i16) {
            this.mPageBodyInfo.setRangeStart(i3);
            this.mPageBodyInfo.setRangeEnd(i16);
            this.mPageBodyInfo.setPageArea(Math.max(0, (i16 - i3) + 1));
            tryGetPageInfo();
            transferDataToPage();
            readInitScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final PageBodyStatistician INSTANCE = new PageBodyStatistician();

        InstanceHolder() {
        }
    }

    public static PageBodyStatistician getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void markAsPageBodyView(View view, IScrollReader iScrollReader) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "markAsPageBodyView: view = " + view + ", scrollReader = " + iScrollReader);
        }
        if (view != null && !this.mHandlerMap.containsKey(view)) {
            this.mHandlerMap.put(view, new BodyInfoHandler(view, iScrollReader));
        }
    }

    public void setPageBodyContentRange(View view, int i3, int i16) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "setPageBodyContentRange: rangeStart = " + i3 + ", rangeEnd = " + i16 + ", view = " + view);
        }
        if (view == null) {
            return;
        }
        BodyInfoHandler bodyInfoHandler = this.mHandlerMap.get(view);
        if (bodyInfoHandler != null) {
            bodyInfoHandler.updateRange(i3, i16);
            return;
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "please mark view as page body first, view = " + view);
        }
    }

    PageBodyStatistician() {
        this.mHandlerMap = new WeakHashMap();
    }
}
