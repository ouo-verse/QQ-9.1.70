package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* renamed from: com.tencent.mobileqq.guild.widget.RoundRectUrlImageView, reason: case insensitive filesystem */
/* loaded from: classes14.dex */
public class C11728RoundRectUrlImageView extends URLImageView {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f236140d;

    /* renamed from: e, reason: collision with root package name */
    private int f236141e;

    /* renamed from: f, reason: collision with root package name */
    private int f236142f;

    /* renamed from: h, reason: collision with root package name */
    private int f236143h;

    /* renamed from: i, reason: collision with root package name */
    private int f236144i;

    /* renamed from: m, reason: collision with root package name */
    private Path f236145m;

    public C11728RoundRectUrlImageView(Context context) {
        super(context);
        this.C = false;
    }

    private void c() {
        Path path = new Path();
        this.f236145m = path;
        int i3 = this.f236140d;
        if (i3 == 0) {
            path.addRect(0.0f, 0.0f, this.f236141e, this.f236142f, Path.Direction.CCW);
            return;
        }
        float min = Math.min(i3 * 2, Math.min(this.f236141e, this.f236142f)) / 2;
        this.f236145m.addRoundRect(new RectF(0.0f, 0.0f, this.f236141e, this.f236142f), min, min, Path.Direction.CCW);
    }

    private void d() {
        float f16;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == this.f236143h && intrinsicHeight == this.f236144i) {
            return;
        }
        this.f236143h = intrinsicWidth;
        this.f236144i = intrinsicHeight;
        if (intrinsicWidth == 0 && intrinsicHeight == 0) {
            return;
        }
        int i3 = this.f236142f;
        int i16 = intrinsicWidth * i3;
        int i17 = this.f236141e;
        if (i16 > i17 * intrinsicHeight) {
            f16 = i3 / intrinsicHeight;
        } else {
            f16 = i17 / intrinsicWidth;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f16, f16);
        setImageMatrix(matrix);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Integer num;
        if (this.f236145m != null) {
            num = Integer.valueOf(canvas.save());
            canvas.clipPath(this.f236145m);
        } else {
            num = null;
        }
        super.dispatchDraw(canvas);
        if (num != null) {
            canvas.restoreToCount(num.intValue());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Integer num;
        d();
        if (this.f236145m != null) {
            num = Integer.valueOf(canvas.save());
            canvas.clipPath(this.f236145m);
        } else {
            num = null;
        }
        super.onDraw(canvas);
        if (num != null) {
            canvas.restoreToCount(num.intValue());
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f236141e && height == this.f236142f) {
            return;
        }
        this.f236141e = width;
        this.f236142f = height;
        c();
        d();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled() && this.C) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    com.tencent.mobileqq.guild.util.qqui.f.b(this);
                }
                return super.onTouchEvent(motionEvent);
            }
            com.tencent.mobileqq.guild.util.qqui.f.a(this);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAllRadius(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f236140d == i3) {
            return;
        }
        this.f236140d = i3;
        c();
        invalidate();
    }

    public void setEnableEffect(boolean z16) {
        this.C = z16;
    }

    public C11728RoundRectUrlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
    }

    public C11728RoundRectUrlImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
    }
}
