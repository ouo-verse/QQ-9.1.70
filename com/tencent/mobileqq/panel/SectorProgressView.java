package com.tencent.mobileqq.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;

/* loaded from: classes16.dex */
public class SectorProgressView extends View {
    static IPatchRedirector $redirector_;
    private static int D;
    private static int E;
    private static int F;
    private static int G;
    private static Bitmap H;
    private static Rect I;
    public boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f257152d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f257153e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f257154f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f257155h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f257156i;

    /* renamed from: m, reason: collision with root package name */
    private Rect f257157m;

    public SectorProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f257155h = new Rect();
        this.f257156i = new RectF();
        this.f257157m = new Rect();
        this.C = false;
        a();
    }

    private void a() {
        if (D == 0) {
            D = x.c(getContext(), 26.0f);
        }
        if (E == 0) {
            E = x.c(getContext(), 3.0f);
        }
        if (F == 0) {
            F = x.c(getContext(), 18.0f);
        }
        if (G == 0) {
            G = x.c(getContext(), 8.0f);
        }
        if (H == null) {
            H = BaseImageUtil.decodeResourceStream(getResources(), R.drawable.fso);
            I = new Rect(0, 0, H.getWidth(), H.getHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (this.f257154f == null) {
            Paint paint = new Paint();
            this.f257154f = paint;
            paint.setAntiAlias(true);
        }
        this.f257155h.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (this.f257153e) {
            this.f257154f.setColor(1073741824);
            canvas.drawRect(this.f257155h, this.f257154f);
            float f16 = (this.f257152d * 360) / 100;
            this.f257156i.set((getMeasuredWidth() - D) / 2, (getMeasuredHeight() - D) / 2, (getMeasuredWidth() + D) / 2, (getMeasuredWidth() + D) / 2);
            this.f257154f.setColor(-8354924);
            this.f257154f.setStrokeWidth(E);
            this.f257154f.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, D / 2, this.f257154f);
            this.f257154f.setColor(-13646081);
            canvas.drawArc(this.f257156i, -90.0f, -f16, false, this.f257154f);
            return;
        }
        if (this.C) {
            int measuredWidth = (getMeasuredWidth() - G) - F;
            int measuredHeight = getMeasuredHeight() - G;
            int i3 = F;
            int i16 = measuredHeight - i3;
            this.f257157m.set(measuredWidth, i16, measuredWidth + i3, i3 + i16);
            canvas.drawBitmap(H, I, this.f257157m, this.f257154f);
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        int i16 = this.f257152d;
        this.f257152d = i3;
        if (i16 != i3) {
            invalidate();
        }
    }

    public SectorProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f257155h = new Rect();
        this.f257156i = new RectF();
        this.f257157m = new Rect();
        this.C = false;
        a();
    }

    public SectorProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f257155h = new Rect();
        this.f257156i = new RectF();
        this.f257157m = new Rect();
        this.C = false;
        a();
    }
}
