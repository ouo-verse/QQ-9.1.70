package com.tencent.timi.game.liveroom.impl.room.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FadeEdgeHorizontalScrollView extends HorizontalScrollView {
    public FadeEdgeHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    public FadeEdgeHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FadeEdgeHorizontalScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
