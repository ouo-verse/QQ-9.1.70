package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o extends LinearLayoutManager {
    public o(Context context) {
        super(context);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            QLog.e("WrapContentLinearLayoutManager", 1, "onLayoutChildren fail!", e16);
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollHorizontallyBy(i3, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            QLog.e("WrapContentLinearLayoutManager", 1, "scrollHorizontallyBy fail!", e16);
            return 0;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            QLog.e("WrapContentLinearLayoutManager", 1, "scrollVerticallyBy fail!", e16);
            return 0;
        }
    }

    public o(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }
}
