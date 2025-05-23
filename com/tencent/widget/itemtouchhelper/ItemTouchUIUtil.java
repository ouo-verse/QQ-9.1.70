package com.tencent.widget.itemtouchhelper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16);

    void onSelected(View view);
}
