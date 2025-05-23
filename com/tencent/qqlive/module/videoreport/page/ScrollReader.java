package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
class ScrollReader {
    private static final IScrollReader DEFAULT_READER;
    private static final Set<View> INJECTED_VIEWS = Collections.newSetFromMap(new WeakHashMap());
    private static final Map<Class<?>, IScrollReader> SCROLL_READERS;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class AbsListViewScrollReader implements IScrollReader {
        AbsListViewScrollReader() {
        }

        @Override // com.tencent.qqlive.module.videoreport.page.IScrollReader
        public int readScroll(View view) {
            return ((AbsListView) view).getLastVisiblePosition();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class CommonViewScrollReader implements IScrollReader {
        CommonViewScrollReader() {
        }

        @Override // com.tencent.qqlive.module.videoreport.page.IScrollReader
        public int readScroll(View view) {
            return view.getScrollY() + view.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnScrollChangeListener {
        void onScrollChanged();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class RecyclerViewScrollReader implements IScrollReader {
        private int[] mVisiblePos;

        RecyclerViewScrollReader() {
        }

        @Override // com.tencent.qqlive.module.videoreport.page.IScrollReader
        public int readScroll(View view) {
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            int i3 = -1;
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int spanCount = staggeredGridLayoutManager.getSpanCount();
                int[] iArr = this.mVisiblePos;
                if (iArr == null || iArr.length < spanCount) {
                    this.mVisiblePos = new int[spanCount];
                }
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.mVisiblePos);
                for (int i16 = 0; i16 < spanCount; i16++) {
                    i3 = Math.max(i3, this.mVisiblePos[i16]);
                }
            }
            return i3;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        SCROLL_READERS = hashMap;
        hashMap.put(RecyclerView.class, new RecyclerViewScrollReader());
        hashMap.put(AbsListView.class, new AbsListViewScrollReader());
        DEFAULT_READER = new CommonViewScrollReader();
    }

    ScrollReader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static IScrollReader getScrollReader(View view) {
        for (Map.Entry<Class<?>, IScrollReader> entry : SCROLL_READERS.entrySet()) {
            if (entry.getKey().isInstance(view)) {
                return entry.getValue();
            }
        }
        return DEFAULT_READER;
    }

    private static void injectCommonViewScroll(View view, final OnScrollChangeListener onScrollChangeListener) {
        view.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.qqlive.module.videoreport.page.ScrollReader.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                OnScrollChangeListener.this.onScrollChanged();
            }
        });
    }

    private static void injectRecyclerViewScroll(RecyclerView recyclerView, @NonNull final OnScrollChangeListener onScrollChangeListener) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qqlive.module.videoreport.page.ScrollReader.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i3) {
                if (i3 == 0) {
                    OnScrollChangeListener.this.onScrollChanged();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void injectScrollListener(View view, OnScrollChangeListener onScrollChangeListener) {
        if (view != null && onScrollChangeListener != null) {
            Set<View> set = INJECTED_VIEWS;
            if (!set.contains(view)) {
                set.add(view);
                if (view instanceof RecyclerView) {
                    injectRecyclerViewScroll((RecyclerView) view, onScrollChangeListener);
                } else {
                    injectCommonViewScroll(view, onScrollChangeListener);
                }
            }
        }
    }
}
