package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class MaskView extends View {
    static IPatchRedirector $redirector_;
    private static final int F;
    private int C;
    private boolean D;
    private Drawable E;

    /* renamed from: d, reason: collision with root package name */
    private Rect f254870d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f254871e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f254872f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f254873h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f254874i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f254875m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73377);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            F = R.drawable.f161807f11;
        }
    }

    public MaskView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f254873h = new Paint();
        this.f254874i = false;
        this.D = false;
        c();
    }

    private void c() {
        this.f254875m = getResources().getDrawable(F);
        this.C = x.c(getContext(), 3.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (i3 >= i16) {
            i3 = i16;
            i16 = i3;
        }
        int c16 = i3 - x.c(getContext(), 18.0f);
        int i17 = (c16 * 424) / 680;
        int i18 = ((i3 - c16) / 2) + 0;
        int i19 = ((i16 - i17) / 2) + 0;
        int i26 = c16 + i18;
        int i27 = i17 + i19;
        this.f254870d = new Rect(i18, i19, i26, i27);
        int i28 = this.C;
        this.f254872f = new Rect(i18 + i28, i19 + i28, i26 - i28, i27 - i28);
        Rect rect = this.f254872f;
        float f16 = i3;
        float f17 = i16;
        this.f254871e = new RectF((rect.left * 1.0f) / f16, (rect.top * 1.0f) / f17, (rect.right * 1.0f) / f16, (rect.bottom * 1.0f) / f17);
        if (QLog.isColorLevel()) {
            QLog.d("MaskView", 2, "MaskView init mBoxRect:", this.f254870d, " screenHeight: ", Integer.valueOf(i16), " screenWidth: ", Integer.valueOf(i3), "mPreviewRect:", this.f254872f, "mPreviewRectF:", this.f254871e);
        }
    }

    public Rect a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Rect) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f254872f;
    }

    public RectF b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RectF) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f254871e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (!this.f254874i) {
            return;
        }
        if (this.D) {
            this.f254873h.setColor(-16777216);
        } else {
            this.f254873h.setColor(Integer.MIN_VALUE);
        }
        this.f254873h.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(0, 0, getWidth(), this.f254872f.top), this.f254873h);
        canvas.drawRect(new Rect(0, this.f254872f.bottom, getWidth(), getHeight()), this.f254873h);
        Rect rect = this.f254872f;
        canvas.drawRect(new Rect(0, rect.top, rect.left, rect.bottom), this.f254873h);
        Rect rect2 = this.f254872f;
        canvas.drawRect(new Rect(rect2.right, rect2.top, getHeight(), this.f254872f.bottom), this.f254873h);
        Drawable drawable = this.E;
        if (drawable != null && this.D) {
            drawable.setBounds(this.f254872f);
            this.E.draw(canvas);
        } else {
            this.f254875m.setBounds(this.f254870d);
            this.f254875m.draw(canvas);
        }
    }

    public void setIsDisplayRect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f254874i = z16;
        }
    }

    public void setModel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        this.D = z16;
        if (!z16) {
            this.E = null;
        }
        invalidate();
    }

    public void setPreviewDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.E = drawable;
            invalidate();
        }
    }

    public MaskView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f254873h = new Paint();
        this.f254874i = false;
        this.D = false;
        c();
    }

    public MaskView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f254873h = new Paint();
        this.f254874i = false;
        this.D = false;
        c();
    }
}
