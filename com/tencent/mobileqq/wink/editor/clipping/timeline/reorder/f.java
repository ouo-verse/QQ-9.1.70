package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f implements e {
    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.e
    public void clearView(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.e
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
        view.setTranslationX(f16);
        view.setTranslationY(f17);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.e
    public void onSelected(View view) {
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.e
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
    }
}
