package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface e {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16);

    void onSelected(View view);
}
