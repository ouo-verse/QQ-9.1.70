package com.tencent.aelight.camera.ae.gif.giftext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DrawableImageView extends ImageView {
    public DrawableImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public DrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
