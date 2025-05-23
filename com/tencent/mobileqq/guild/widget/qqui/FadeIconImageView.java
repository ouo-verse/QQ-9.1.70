package com.tencent.mobileqq.guild.widget.qqui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FadeIconImageView extends ImageView {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    public FadeIconImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (StateSet.stateSetMatches(ImageView.PRESSED_WINDOW_FOCUSED_STATE_SET, getDrawableState())) {
                drawable.setAlpha(66);
            } else {
                drawable.setAlpha(255);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public FadeIconImageView(Context context) {
        super(context);
    }

    public void setVisibilityHandler(a aVar) {
    }
}
