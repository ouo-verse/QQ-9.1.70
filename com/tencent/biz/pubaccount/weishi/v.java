package com.tencent.biz.pubaccount.weishi;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class v extends StaggeredGridLayoutManager {
    public v(int i3, int i16) {
        super(i3, i16);
    }

    @Override // android.support.v7.widget.StaggeredGridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            com.tencent.biz.pubaccount.weishi.util.x.f("WSStaggeredGridLayoutManager", "onLayoutChildren exception: " + e16.getLocalizedMessage());
        }
    }

    @Override // android.support.v7.widget.StaggeredGridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        try {
            super.scrollToPosition(i3);
        } catch (Exception e16) {
            com.tencent.biz.pubaccount.weishi.util.x.f("WSStaggeredGridLayoutManager", "scrollToPosition exception: " + e16.getLocalizedMessage());
        }
    }
}
