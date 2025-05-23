package com.tencent.mobileqq.guild.widget.qqui;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

@TargetApi(14)
/* loaded from: classes14.dex */
public class PressDarkImageView extends URLImageView {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f236471h = {R.attr.fromAlpha, R.attr.toAlpha};

    /* renamed from: d, reason: collision with root package name */
    public float f236472d;

    /* renamed from: e, reason: collision with root package name */
    public float f236473e;

    /* renamed from: f, reason: collision with root package name */
    public int f236474f;

    public PressDarkImageView(Context context) {
        this(context, null, 0);
    }

    public void c() {
        if (this.f236474f == 1) {
            super.clearColorFilter();
        } else {
            super.setImageAlpha((int) (this.f236472d * 255.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (isPressed()) {
            if (this.f236474f == 1) {
                super.setColorFilter(436207616);
                return;
            } else {
                super.setImageAlpha((int) (this.f236473e * 255.0f));
                return;
            }
        }
        c();
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236472d = 1.0f;
        this.f236473e = 0.5f;
        this.f236474f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f236471h);
        this.f236472d = obtainStyledAttributes.getFloat(0, this.f236472d);
        this.f236473e = obtainStyledAttributes.getFloat(1, this.f236473e);
        obtainStyledAttributes.recycle();
    }
}
