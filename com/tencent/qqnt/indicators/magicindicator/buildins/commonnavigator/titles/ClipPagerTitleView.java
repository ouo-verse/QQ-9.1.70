package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.buildins.a;
import com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b;

/* loaded from: classes24.dex */
public class ClipPagerTitleView extends View implements b {
    static IPatchRedirector $redirector_;
    private Rect C;

    /* renamed from: d, reason: collision with root package name */
    private String f357091d;

    /* renamed from: e, reason: collision with root package name */
    private int f357092e;

    /* renamed from: f, reason: collision with root package name */
    private int f357093f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f357094h;

    /* renamed from: i, reason: collision with root package name */
    private float f357095i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f357096m;

    public ClipPagerTitleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.C = new Rect();
            e(context);
        }
    }

    private void e(Context context) {
        int a16 = a.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f357096m = paint;
        paint.setTextSize(a16);
        int a17 = a.a(context, 10.0d);
        setPadding(a17, 0, a17, 0);
    }

    private int f(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return this.C.height() + getPaddingTop() + getPaddingBottom();
            }
            return size;
        }
        return Math.min(this.C.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    private void g() {
        int length;
        Paint paint = this.f357096m;
        String str = this.f357091d;
        if (str == null) {
            length = 0;
        } else {
            length = str.length();
        }
        paint.getTextBounds(str, 0, length, this.C);
    }

    private int h(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return this.C.width() + getPaddingLeft() + getPaddingRight();
            }
            return size;
        }
        return Math.min(this.C.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return getLeft() + (getWidth() / 2) + (this.C.width() / 2);
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        Paint.FontMetrics fontMetrics = this.f357096m.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return (getLeft() + (getWidth() / 2)) - (this.C.width() / 2);
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        Paint.FontMetrics fontMetrics = this.f357096m.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        int width = (getWidth() - this.C.width()) / 2;
        Paint.FontMetrics fontMetrics = this.f357096m.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f357096m.setColor(this.f357092e);
        float f16 = width;
        float f17 = height;
        canvas.drawText(this.f357091d, f16, f17, this.f357096m);
        canvas.save();
        if (this.f357094h) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.f357095i, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.f357095i), 0.0f, getWidth(), getHeight());
        }
        this.f357096m.setColor(this.f357093f);
        canvas.drawText(this.f357091d, f16, f17, this.f357096m);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            g();
            setMeasuredDimension(h(i3), f(i16));
        }
    }

    public void setClipColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f357093f = i3;
            invalidate();
        }
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f357091d = str;
            requestLayout();
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f357092e = i3;
            invalidate();
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.f357096m.setTextSize(f16);
            requestLayout();
        }
    }
}
