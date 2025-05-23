package com.tencent.widget.pull2refresh;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IViewHolderItemDecoration {
    int getColor();

    void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state);
}
