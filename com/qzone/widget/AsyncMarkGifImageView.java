package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsyncMarkGifImageView extends AsyncMarkImageView {
    public AsyncMarkGifImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getDrawable() == null || getDrawable().getCallback() == this) {
            return;
        }
        getDrawable().setCallback(this);
    }

    public AsyncMarkGifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AsyncMarkGifImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
