package com.tencent.mobileqq.portal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StrokeTextView extends TextView {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private TextPaint f259347d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f259348e;

    /* renamed from: f, reason: collision with root package name */
    private int f259349f;

    /* renamed from: h, reason: collision with root package name */
    private int f259350h;

    /* renamed from: i, reason: collision with root package name */
    private int f259351i;

    /* renamed from: m, reason: collision with root package name */
    private float f259352m;

    public StrokeTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            this.f259348e = false;
            a();
        }
    }

    private void a() {
        this.f259347d = getPaint();
        this.f259348e = false;
        this.f259351i = BaseAIOUtils.f(2.0f, getResources());
        setLayerType(1, null);
    }

    private void b(int i3) {
        boolean z16 = true;
        try {
            Field declaredField = TextView.class.getDeclaredField("mCurTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i3));
            declaredField.setAccessible(false);
            z16 = false;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("StrokeTextView", 2, "innerSetTextColor, exception=" + th5.getMessage());
                th5.printStackTrace();
            }
        }
        if (!z16) {
            this.f259347d.setColor(i3);
            return;
        }
        this.f259348e = false;
        setTextColor(this.f259349f);
        setShadowLayer(this.f259352m, this.C, this.D, this.E);
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        if (this.f259348e) {
            b(this.f259350h);
            this.f259347d.setStrokeWidth(this.f259351i);
            this.f259347d.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f259347d.setShadowLayer(this.f259352m, this.C, this.D, this.E);
            super.onDraw(canvas);
            b(this.f259349f);
            this.f259347d.setStrokeWidth(0.0f);
            this.f259347d.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f259347d.setFakeBoldText(false);
            this.f259347d.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        super.onDraw(canvas);
    }

    public void setInnerTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f259349f = i3;
            setTextColor(i3);
        }
    }

    public void setShadow(float f16, float f17, float f18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i3));
            return;
        }
        this.f259352m = f16;
        this.C = f17;
        this.D = f18;
        this.E = i3;
    }

    public void setStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f259350h = i3;
        }
    }

    public void setStrokeEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f259348e = z16;
        }
    }

    public void setStrokeSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f259351i = i3;
        }
    }

    public void setTextBold(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f259347d.setFakeBoldText(z16);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) typeface);
        } else {
            super.setTypeface(typeface);
        }
    }

    @TargetApi(11)
    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f259348e = false;
            a();
        }
    }
}
