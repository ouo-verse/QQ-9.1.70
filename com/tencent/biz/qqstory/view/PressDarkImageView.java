package com.tencent.biz.qqstory.view;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

@TargetApi(14)
/* loaded from: classes5.dex */
public class PressDarkImageView extends URLImageView {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f94493i = {R.attr.fromAlpha, R.attr.toAlpha};

    /* renamed from: d, reason: collision with root package name */
    public float f94494d;

    /* renamed from: e, reason: collision with root package name */
    public float f94495e;

    /* renamed from: f, reason: collision with root package name */
    public int f94496f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f94497h;

    public PressDarkImageView(Context context) {
        this(context, null, 0);
    }

    public void c() {
        if (this.f94496f == 1) {
            super.clearColorFilter();
        } else {
            super.setImageAlpha((int) (this.f94494d * 255.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f94497h) {
            return;
        }
        if (isPressed()) {
            if (this.f94496f == 1) {
                super.setColorFilter(436207616);
                return;
            } else {
                super.setImageAlpha((int) (this.f94495e * 255.0f));
                return;
            }
        }
        c();
    }

    public void setFilterPressEffect(boolean z16) {
        this.f94497h = z16;
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94494d = 1.0f;
        this.f94495e = 0.5f;
        this.f94496f = 0;
        this.f94497h = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f94493i);
        this.f94494d = obtainStyledAttributes.getFloat(0, this.f94494d);
        this.f94495e = obtainStyledAttributes.getFloat(1, this.f94495e);
        obtainStyledAttributes.recycle();
    }
}
