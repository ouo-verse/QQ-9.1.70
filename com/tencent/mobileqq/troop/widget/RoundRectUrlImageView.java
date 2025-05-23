package com.tencent.mobileqq.troop.widget;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoundRectUrlImageView extends URLImageView {
    static IPatchRedirector $redirector_;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f302411d;

    /* renamed from: e, reason: collision with root package name */
    private int f302412e;

    /* renamed from: f, reason: collision with root package name */
    private int f302413f;

    /* renamed from: h, reason: collision with root package name */
    private int f302414h;

    /* renamed from: i, reason: collision with root package name */
    private int f302415i;

    /* renamed from: m, reason: collision with root package name */
    private Path f302416m;

    public RoundRectUrlImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.C = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    private void c() {
        Path path = new Path();
        this.f302416m = path;
        int i3 = this.f302411d;
        if (i3 == 0) {
            path.addRect(0.0f, 0.0f, this.f302412e, this.f302413f, Path.Direction.CCW);
            return;
        }
        float min = Math.min(i3 * 2, Math.min(this.f302412e, this.f302413f)) / 2;
        this.f302416m.addRoundRect(new RectF(0.0f, 0.0f, this.f302412e, this.f302413f), min, min, Path.Direction.CCW);
    }

    private void d() {
        float f16;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == this.f302414h && intrinsicHeight == this.f302415i) {
            return;
        }
        this.f302414h = intrinsicWidth;
        this.f302415i = intrinsicHeight;
        if (intrinsicWidth == 0 && intrinsicHeight == 0) {
            return;
        }
        int i3 = this.f302413f;
        int i16 = intrinsicWidth * i3;
        int i17 = this.f302412e;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.f302416m != null) {
            num = Integer.valueOf(canvas.save());
            canvas.clipPath(this.f302416m);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        d();
        if (this.f302416m != null) {
            num = Integer.valueOf(canvas.save());
            canvas.clipPath(this.f302416m);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f302412e && height == this.f302413f) {
            return;
        }
        this.f302412e = width;
        this.f302413f = height;
        c();
        d();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (isClickable() && isEnabled() && this.C) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    j53.a.b(this);
                }
                return super.onTouchEvent(motionEvent);
            }
            j53.a.a(this);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAllRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f302411d == i3) {
            return;
        }
        this.f302411d = i3;
        c();
        invalidate();
    }

    public void setEnableEffect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    public RoundRectUrlImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.C = false;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public RoundRectUrlImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.C = false;
        } else {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
