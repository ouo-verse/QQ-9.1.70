package com.tencent.qqlive.module.videoreport.report.scroll;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.traversal.OnViewTraverseListener;
import com.tencent.qqlive.module.videoreport.traversal.ViewTraverser;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class ScrollStateObserver implements AbsListView.OnScrollListener, OnViewTraverseListener, ViewGroup.OnHierarchyChangeListener {
    private static final String TAG = "ScrollStateObserver";
    private AndroidXRVScrollObserver androidxScrollObserver;
    private final IEventListener mEventListener;
    private final SupportRVScrollStateObserver supportScrollObserver;
    private final WeakHashMap<ViewPager, ViewPager.OnPageChangeListener> mViewPagerListeners = new WeakHashMap<>();
    private final Set<View> mScrollingViews = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class AndroidXRVScrollObserver extends RecyclerView.OnScrollListener implements RecyclerView.OnChildAttachStateChangeListener {
        AndroidXRVScrollObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NonNull View view) {
            ScrollStateObserver.this.onChildViewAttached(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NonNull View view) {
            ScrollStateObserver.this.onChildViewDetached(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            boolean z16;
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(ScrollStateObserver.TAG, "RecyclerView.onScrollStateChanged: newState = " + i3);
            }
            ScrollStateObserver scrollStateObserver = ScrollStateObserver.this;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            scrollStateObserver.updateScrollingView(recyclerView, z16);
            ScrollStateObserver.this.onScrollViewStateChanged(recyclerView, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class ScrollEventListener extends DefaultEventListener {
        ScrollEventListener() {
        }

        @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
        public void onChildViewAdded(View view, View view2) {
            ScrollStateObserver.this.onChildViewAdded(view, view2);
        }

        @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
        public void onChildViewRemoved(View view, View view2) {
            ScrollStateObserver.this.onChildViewRemoved(view, view2);
        }

        @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
        public void onListScrollStateChanged(AbsListView absListView, int i3) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(ScrollStateObserver.TAG, "onListScrollStateChanged: scrollState=" + i3);
            }
            ScrollStateObserver.this.onScrollStateChanged(absListView, i3);
        }

        @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
        public void onSetAndroidXRVAdapter(RecyclerView recyclerView) {
            ScrollStateObserver.this.inject(recyclerView);
        }

        @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
        public void onSetRecyclerViewAdapter(android.support.v7.widget.RecyclerView recyclerView) {
            ScrollStateObserver.this.inject(recyclerView);
        }

        @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
        public void onSetViewPagerAdapter(ViewPager viewPager) {
            ScrollStateObserver.this.inject(viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class SupportRVScrollStateObserver extends RecyclerView.OnScrollListener implements RecyclerView.OnChildAttachStateChangeListener {
        SupportRVScrollStateObserver() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            ScrollStateObserver.this.onChildViewAttached(view);
        }

        @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            ScrollStateObserver.this.onChildViewDetached(view);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull android.support.v7.widget.RecyclerView recyclerView, int i3) {
            boolean z16;
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(ScrollStateObserver.TAG, "RecyclerView.onScrollStateChanged: newState = " + i3);
            }
            ScrollStateObserver scrollStateObserver = ScrollStateObserver.this;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            scrollStateObserver.updateScrollingView(recyclerView, z16);
            ScrollStateObserver.this.onScrollViewStateChanged(recyclerView, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollStateObserver() {
        this.supportScrollObserver = new SupportRVScrollStateObserver();
        ScrollEventListener scrollEventListener = new ScrollEventListener();
        this.mEventListener = scrollEventListener;
        EventCollector.getInstance().registerEventListener(scrollEventListener);
        ViewTraverser.getInstance().setListener(this);
        if (VideoReportInner.getInstance().getConfiguration().enableAndroidXTVCollect()) {
            this.androidxScrollObserver = new AndroidXRVScrollObserver();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScrollingView(View view, boolean z16) {
        if (z16) {
            this.mScrollingViews.add(view);
        } else {
            this.mScrollingViews.remove(view);
        }
    }

    public void inject(View view) {
        if (VideoReportInner.getInstance().getConfiguration().enableAndroidXTVCollect() && (view instanceof androidx.recyclerview.widget.RecyclerView)) {
            if (ReportHelper.androidXRVExposureEnabled(view)) {
                injectXRV((androidx.recyclerview.widget.RecyclerView) view);
            }
        } else if (view instanceof AbsListView) {
            inject((AbsListView) view);
        } else if (view instanceof android.support.v7.widget.RecyclerView) {
            inject((android.support.v7.widget.RecyclerView) view);
        } else if (view instanceof ViewPager) {
            inject((ViewPager) view);
        }
    }

    public void injectXRV(androidx.recyclerview.widget.RecyclerView recyclerView) {
        AndroidXRVScrollObserver androidXRVScrollObserver = this.androidxScrollObserver;
        if (androidXRVScrollObserver != null) {
            recyclerView.removeOnScrollListener(androidXRVScrollObserver);
            recyclerView.addOnScrollListener(this.androidxScrollObserver);
            recyclerView.removeOnChildAttachStateChangeListener(this.androidxScrollObserver);
            if (observerChildAttachState(recyclerView)) {
                recyclerView.addOnChildAttachStateChangeListener(this.androidxScrollObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isScrolling() {
        if (this.mScrollingViews.size() > 0) {
            return true;
        }
        return false;
    }

    abstract boolean observerChildAttachState(View view);

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        EventCollector.getInstance().onChildViewAdded(view, view2);
        if (observerChildAttachState(view)) {
            onChildViewAttached(view2);
        }
    }

    abstract void onChildViewAttached(View view);

    abstract void onChildViewDetached(View view);

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        EventCollector.getInstance().onChildViewRemoved(view, view2);
        if (observerChildAttachState(view)) {
            onChildViewDetached(view2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i3) {
        boolean z16;
        EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "AbsListView.onScrollStateChanged: scrollState = " + i3);
        }
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        updateScrollingView(absListView, z16);
        onScrollViewStateChanged(absListView, i3);
    }

    abstract void onScrollViewStateChanged(View view, int i3);

    @Override // com.tencent.qqlive.module.videoreport.traversal.OnViewTraverseListener
    public void onViewVisited(View view) {
        inject(view);
    }

    public void inject(android.support.v7.widget.RecyclerView recyclerView) {
        recyclerView.removeOnScrollListener(this.supportScrollObserver);
        recyclerView.addOnScrollListener(this.supportScrollObserver);
        recyclerView.removeOnChildAttachStateChangeListener(this.supportScrollObserver);
        if (observerChildAttachState(recyclerView)) {
            recyclerView.addOnChildAttachStateChangeListener(this.supportScrollObserver);
        }
    }

    public void inject(AbsListView absListView) {
        if (UIUtils.getListScrollListener(absListView) == null) {
            absListView.setOnScrollListener(this);
        }
        Object listOnHierarchyChangeListener = UIUtils.getListOnHierarchyChangeListener(absListView);
        if (observerChildAttachState(absListView)) {
            if (listOnHierarchyChangeListener == null) {
                absListView.setOnHierarchyChangeListener(this);
            }
        } else if (listOnHierarchyChangeListener == this) {
            absListView.setOnHierarchyChangeListener(null);
        }
    }

    public void inject(ViewPager viewPager) {
        if (this.mViewPagerListeners.get(viewPager) == null) {
            PageChangeListenerImpl pageChangeListenerImpl = new PageChangeListenerImpl(viewPager);
            this.mViewPagerListeners.put(viewPager, pageChangeListenerImpl);
            viewPager.addOnPageChangeListener(pageChangeListenerImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class PageChangeListenerImpl implements ViewPager.OnPageChangeListener {
        private WeakReference<ViewPager> mViewPagerRef;

        PageChangeListenerImpl(ViewPager viewPager) {
            this.mViewPagerRef = new WeakReference<>(viewPager);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            boolean z16;
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(ScrollStateObserver.TAG, "ViewPager.onPageScrollStateChanged: state = " + i3);
            }
            ViewPager viewPager = this.mViewPagerRef.get();
            if (viewPager == null) {
                return;
            }
            ScrollStateObserver scrollStateObserver = ScrollStateObserver.this;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            scrollStateObserver.updateScrollingView(viewPager, z16);
            ScrollStateObserver.this.onScrollViewStateChanged(viewPager, i3);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
