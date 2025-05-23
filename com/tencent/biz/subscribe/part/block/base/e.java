package com.tencent.biz.subscribe.part.block.base;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends StaggeredGridLayoutManager {
    public e(int i3, int i16) {
        super(i3, i16);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getPosition(View view) {
        try {
            return super.getPosition(view);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // android.support.v7.widget.StaggeredGridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("SafeStaggeredGridLayoutManager", 4, e16, new Object[0]);
        }
    }

    @Override // android.support.v7.widget.StaggeredGridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }
}
