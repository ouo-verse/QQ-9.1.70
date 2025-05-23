package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AutoBgImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private float f315439d;

    public AutoBgImageView(Context context) {
        super(context);
        this.f315439d = 0.5f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        float f16;
        super.drawableStateChanged();
        if (isPressed()) {
            f16 = this.f315439d;
        } else {
            f16 = 1.0f;
        }
        setAlpha(f16);
        postInvalidate();
    }

    public void setPressedAlpha(float f16) {
        this.f315439d = f16;
    }

    public AutoBgImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315439d = 0.5f;
    }

    public AutoBgImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315439d = 0.5f;
    }
}
