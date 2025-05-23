package com.tencent.qqlive.module.videoreport.report.scroll;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ScrollableViewManager extends DefaultEventListener {
    private static final String TAG = "ScrollableViewObserver";
    private Handler mHandler;
    private PendingTask mPendingTask;
    private boolean mRecyclerViewTipsToasted;
    private ScrollStateHelper mScrollStateHelper;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ScrollableViewManager INSTANCE = new ScrollableViewManager();

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class PendingTask implements Runnable {
        private Set<View> mNotifyViewList;

        PendingTask() {
            this.mNotifyViewList = Collections.newSetFromMap(new WeakHashMap());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotifyView(View view) {
            this.mNotifyViewList.add(view);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mNotifyViewList.isEmpty()) {
                return;
            }
            Iterator<View> it = this.mNotifyViewList.iterator();
            while (it.hasNext()) {
                PageSwitchObserver.getInstance().onPageViewVisible(it.next());
            }
            this.mNotifyViewList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ScrollStateHelper extends ScrollStateObserver {
        ScrollStateHelper() {
        }

        @Override // com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver
        boolean observerChildAttachState(View view) {
            return ScrollableViewExposureReport.isScrollExposureEnable(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver
        void onChildViewAttached(View view) {
            ScrollableViewExposureReport.getInstance().onChildViewAttached(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver
        void onChildViewDetached(View view) {
            ScrollableViewExposureReport.getInstance().onChildViewDetached(view);
        }

        @Override // com.tencent.qqlive.module.videoreport.report.scroll.ScrollStateObserver
        void onScrollViewStateChanged(View view, int i3) {
            if (observerChildAttachState(view) && ((view instanceof AbsListView) || (view instanceof RecyclerView))) {
                ScrollableViewExposureReport.getInstance().onScrollStateChanged(view, i3);
            }
            if (i3 == 0) {
                PageSwitchObserver.getInstance().onPageViewVisible(view);
            }
        }
    }

    public static ScrollableViewManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void handleNotify(ViewGroup viewGroup) {
        if (!isIdle()) {
            return;
        }
        this.mHandler.removeCallbacks(this.mPendingTask);
        this.mPendingTask.setNotifyView(viewGroup);
        this.mHandler.post(this.mPendingTask);
    }

    private boolean isIdle() {
        return !this.mScrollStateHelper.isScrolling();
    }

    private void remindRecyclerViewVersionOld(View view) {
        String string = view.getContext().getString(R.string.f2207169v);
        if (!this.mRecyclerViewTipsToasted) {
            this.mRecyclerViewTipsToasted = true;
            Toast.makeText(ReportUtils.getContext(), string, 1).show();
        }
        Log.e(TAG, string);
    }

    public void inject(View view) {
        this.mScrollStateHelper.inject(view);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onViewReused(ViewGroup viewGroup, View view, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.i(TAG, "onViewReused: parent=" + viewGroup + ", view=" + view);
        }
        if (viewGroup == null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                remindRecyclerViewVersionOld(view);
                return;
            }
            return;
        }
        handleNotify(viewGroup);
    }

    ScrollableViewManager() {
        this.mPendingTask = new PendingTask();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScrollStateHelper = new ScrollStateHelper();
        this.mRecyclerViewTipsToasted = false;
        EventCollector.getInstance().registerEventListener(this);
    }
}
