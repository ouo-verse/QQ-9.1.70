package com.tencent.now.od.ui.game.meleegame.widget.scorebar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import tn3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RoundCornerImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private Path f338583d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f338584e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f338585f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f338586h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f338587i;

    public RoundCornerImageView(Context context) {
        this(context, null, 0);
    }

    private float c(float f16, boolean z16) {
        if (z16) {
            return f16;
        }
        return 0.0f;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f338583d.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + height);
        float f16 = (height / 2) * 1.0f;
        this.f338583d.addRoundRect(rectF, new float[]{c(f16, this.f338584e), c(f16, this.f338584e), c(f16, this.f338585f), c(f16, this.f338585f), c(f16, this.f338587i), c(f16, this.f338587i), c(f16, this.f338586h), c(f16, this.f338586h)}, Path.Direction.CCW);
        this.f338583d.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.f338583d);
        super.draw(canvas);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338583d = new Path();
        this.f338584e = false;
        this.f338585f = false;
        this.f338586h = false;
        this.f338587i = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f436890z5);
        this.f338584e = obtainStyledAttributes.getBoolean(a.C5, false);
        this.f338585f = obtainStyledAttributes.getBoolean(a.D5, false);
        this.f338586h = obtainStyledAttributes.getBoolean(a.A5, false);
        this.f338587i = obtainStyledAttributes.getBoolean(a.B5, false);
        obtainStyledAttributes.recycle();
        super.setLayerType(2, null);
    }
}
