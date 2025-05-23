package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RoundRectLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private Path G;

    /* renamed from: d, reason: collision with root package name */
    private Paint f194392d;

    /* renamed from: e, reason: collision with root package name */
    private int f194393e;

    /* renamed from: f, reason: collision with root package name */
    private int f194394f;

    /* renamed from: h, reason: collision with root package name */
    private Path f194395h;

    /* renamed from: i, reason: collision with root package name */
    private int f194396i;

    /* renamed from: m, reason: collision with root package name */
    private int f194397m;

    public RoundRectLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        Paint paint = new Paint();
        this.f194392d = paint;
        paint.setAntiAlias(true);
        this.f194392d.setColor(-1);
        this.f194392d.setStyle(Paint.Style.FILL);
    }

    private void a() {
        if (this.f194395h == null) {
            this.f194395h = new Path();
        }
        this.f194395h.reset();
        if (this.C) {
            this.f194395h.moveTo(0.0f, this.f194394f);
            this.f194395h.lineTo(0.0f, 0.0f);
        } else {
            this.f194395h.moveTo(this.f194397m + 0, this.f194394f - 0);
            Path path = this.f194395h;
            float f16 = 0;
            int i3 = this.f194394f;
            int i16 = this.f194397m;
            path.arcTo(new RectF(f16, (i3 - (i16 * 2)) - 0, (i16 * 2) + 0, i3 - 0), 90.0f, 90.0f);
            Path path2 = this.f194395h;
            int i17 = this.f194397m;
            path2.arcTo(new RectF(f16, f16, (i17 * 2) + 0, (i17 * 2) + 0), 180.0f, 90.0f);
        }
        Path path3 = this.f194395h;
        int i18 = this.f194393e;
        int i19 = this.f194397m;
        path3.arcTo(new RectF((i18 - (i19 * 2)) - 0, 0, i18 - 0, (i19 * 2) + 0), -90.0f, 90.0f);
        Path path4 = this.f194395h;
        int i26 = this.f194393e;
        int i27 = this.f194397m;
        int i28 = this.f194394f;
        path4.arcTo(new RectF((i26 - (i27 * 2)) - 0, (i28 - (i27 * 2)) - 0, i26 - 0, i28 - 0), 0.0f, 90.0f);
        this.f194395h.close();
        if (this.E > 0) {
            Path path5 = new Path();
            this.G = path5;
            path5.reset();
            Path path6 = this.G;
            int i29 = this.F;
            path6.moveTo(this.E + i29, this.f194394f - i29);
            Path path7 = this.G;
            int i36 = this.F;
            int i37 = this.f194394f;
            int i38 = this.E;
            path7.arcTo(new RectF(i36, (i37 - (i38 * 2)) - i36, (i38 * 2) + i36, i37 - i36), 90.0f, 90.0f);
            Path path8 = this.G;
            int i39 = this.F;
            int i46 = this.E;
            path8.arcTo(new RectF(i39, i39, (i46 * 2) + i39, i39 + (i46 * 2)), 180.0f, 90.0f);
            Path path9 = this.G;
            int i47 = this.f194393e;
            int i48 = this.E;
            path9.arcTo(new RectF((i47 - (i48 * 2)) - r8, this.F, i47 - r8, r8 + (i48 * 2)), -90.0f, 90.0f);
            Path path10 = this.G;
            int i49 = this.f194393e;
            int i56 = this.E;
            int i57 = this.F;
            int i58 = this.f194394f;
            path10.arcTo(new RectF((i49 - (i56 * 2)) - i57, (i58 - (i56 * 2)) - i57, i49 - i57, i58 - i57), 0.0f, 90.0f);
            this.G.close();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        if (this.f194395h != null) {
            this.f194392d.setColor(this.f194396i);
            this.f194392d.setStyle(Paint.Style.FILL);
            canvas.drawPath(this.f194395h, this.f194392d);
        }
        if (this.E > 0 && this.G != null) {
            this.f194392d.setStyle(Paint.Style.STROKE);
            this.f194392d.setStrokeWidth(this.E);
            this.f194392d.setColor(this.D);
            canvas.drawPath(this.G, this.f194392d);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (i19 != this.f194393e || i26 != this.f194394f) {
            this.f194393e = i19;
            this.f194394f = i26;
            a();
        }
    }

    public void setInnerRoundRect(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.D = i3;
        this.E = i16;
        this.F = i17;
    }

    public void setRoundRect(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (this.f194397m != i3) {
            this.f194397m = i3;
            a();
        }
        this.f194396i = i16;
        this.C = z16;
    }

    public RoundRectLinearLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Paint paint = new Paint();
        this.f194392d = paint;
        paint.setAntiAlias(true);
        this.f194392d.setColor(-1);
        this.f194392d.setStyle(Paint.Style.FILL);
    }
}
