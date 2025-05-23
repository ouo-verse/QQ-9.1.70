package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class EdgeTransparentView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private int[] F;
    private float[] G;

    /* renamed from: d, reason: collision with root package name */
    private Paint f241365d;

    /* renamed from: e, reason: collision with root package name */
    private int f241366e;

    /* renamed from: f, reason: collision with root package name */
    private float f241367f;

    /* renamed from: h, reason: collision with root package name */
    private int f241368h;

    /* renamed from: i, reason: collision with root package name */
    private int f241369i;

    /* renamed from: m, reason: collision with root package name */
    private int f241370m;

    public EdgeTransparentView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint(1);
        this.f241365d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f241365d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.H);
        this.f241366e = obtainStyledAttributes.getInt(u51.a.I, 0);
        this.f241367f = obtainStyledAttributes.getDimension(u51.a.J, 40.0f);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        this.f241365d.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f241367f, this.F, this.G, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, canvas, view, Long.valueOf(j3))).booleanValue();
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, view, j3);
        int i3 = this.f241366e;
        if (i3 == 0 || (i3 & this.f241368h) != 0) {
            canvas.drawRect(0.0f, 0.0f, this.D, this.f241367f, this.f241365d);
        }
        int i16 = this.f241366e;
        if (i16 == 0 || (i16 & this.f241369i) != 0) {
            int save = canvas.save();
            canvas.rotate(180.0f, this.D / 2.0f, this.E / 2.0f);
            canvas.drawRect(0.0f, 0.0f, this.D, this.f241367f, this.f241365d);
            canvas.restoreToCount(save);
        }
        float f16 = (this.E - this.D) / 2.0f;
        int i17 = this.f241366e;
        if (i17 == 0 || (i17 & this.f241370m) != 0) {
            int save2 = canvas.save();
            canvas.rotate(270.0f, this.D / 2.0f, this.E / 2.0f);
            canvas.translate(0.0f, f16);
            canvas.drawRect(0.0f - f16, 0.0f, this.D + f16, this.f241367f, this.f241365d);
            canvas.restoreToCount(save2);
        }
        int i18 = this.f241366e;
        if (i18 == 0 || (i18 & this.C) != 0) {
            int save3 = canvas.save();
            canvas.rotate(90.0f, this.D / 2.0f, this.E / 2.0f);
            canvas.translate(0.0f, f16);
            canvas.drawRect(0.0f - f16, 0.0f, this.D + f16, this.f241367f, this.f241365d);
            canvas.restoreToCount(save3);
        }
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        b();
        this.D = getWidth();
        this.E = getHeight();
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f241368h = 1;
        this.f241369i = 1 << 1;
        this.f241370m = 1 << 2;
        this.C = 1 << 3;
        this.F = new int[]{-1, -1, 16777215};
        this.G = new float[]{0.0f, 0.5f, 1.0f};
        a(context, attributeSet);
    }
}
