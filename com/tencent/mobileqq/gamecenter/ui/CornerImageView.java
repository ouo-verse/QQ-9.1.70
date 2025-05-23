package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CornerImageView extends URLImageView {

    /* renamed from: i, reason: collision with root package name */
    public static ColorFilter f213230i = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);

    /* renamed from: d, reason: collision with root package name */
    boolean f213231d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f213232e;

    /* renamed from: f, reason: collision with root package name */
    private Path f213233f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f213234h;

    public CornerImageView(Context context) {
        super(context);
        this.f213231d = false;
        this.f213232e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f213234h = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (!this.f213231d) {
            return;
        }
        int[] drawableState = getDrawableState();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= drawableState.length) {
                break;
            }
            if (drawableState[i3] == 16842919) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (isPressed() | z16) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.setColorFilter(f213230i);
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 != null) {
            drawable2.setColorFilter(null);
            drawable2.invalidateSelf();
        }
    }

    public void e() {
        if (!VersionUtils.isKITKAT()) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f213233f == null) {
            this.f213233f = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.f213233f;
                RectF rectF = this.f213234h;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, this.f213232e, Path.Direction.CW);
                canvas.clipPath(path);
                d(canvas);
                super.onDraw(canvas);
                c(canvas);
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public void setPressMask(boolean z16) {
        this.f213231d = z16;
    }

    public void setRadius(float[] fArr) {
        this.f213232e = fArr;
        e();
    }

    public void setRadius(float f16) {
        this.f213232e = new float[]{f16, f16, f16, f16, f16, f16, f16, f16};
        e();
    }

    public CornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f213231d = false;
        this.f213232e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f213234h = new RectF();
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213231d = false;
        this.f213232e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f213234h = new RectF();
    }

    protected void c(Canvas canvas) {
    }

    protected void d(Canvas canvas) {
    }
}
