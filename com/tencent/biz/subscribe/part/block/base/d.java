package com.tencent.biz.subscribe.part.block.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends LinearLayoutManager {
    public d(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            e16.printStackTrace();
            return 0;
        }
    }
}
