package com.tencent.mobileqq.stt.sub.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GuideBalloonArrow extends View {
    static IPatchRedirector $redirector_;
    private static final int D;
    private final float C;

    /* renamed from: d, reason: collision with root package name */
    private Path f290828d;

    /* renamed from: e, reason: collision with root package name */
    private float f290829e;

    /* renamed from: f, reason: collision with root package name */
    private int f290830f;

    /* renamed from: h, reason: collision with root package name */
    private int f290831h;

    /* renamed from: i, reason: collision with root package name */
    private float f290832i;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f290833m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            D = Color.parseColor("#03081A");
        }
    }

    public GuideBalloonArrow(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    private static Path a(float f16, float f17, float f18) {
        float f19 = f17 / 2.0f;
        float sqrt = (float) Math.sqrt((f19 * f19) + (f18 * f18));
        float f26 = f19 / sqrt;
        float f27 = (f18 / sqrt) * f16;
        float f28 = f16 / f26;
        float f29 = f28 - (f26 * f16);
        float f36 = f18 - f28;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(f17, 0.0f);
        float f37 = f18 - f29;
        path.lineTo(f19 + f27, f37);
        path.lineTo(f19 - f27, f37);
        path.lineTo(0.0f, 0.0f);
        Path path2 = new Path();
        path2.addCircle(f19, f36, f16, Path.Direction.CW);
        path.op(path2, Path.Op.UNION);
        return path;
    }

    private void b() {
        this.f290828d = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        float f16 = getResources().getDisplayMetrics().density * this.f290829e;
        if (this.f290828d == null) {
            this.f290828d = a(f16, getWidth(), getHeight());
        }
        canvas.clipPath(this.f290828d);
        canvas.drawColor(this.f290830f);
        if (this.f290831h != 0 && this.f290832i > 0.0f) {
            canvas.drawPath(this.f290828d, this.f290833m);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
            b();
        }
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f290830f = i3;
            postInvalidate();
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        this.f290829e = f16;
        b();
        postInvalidate();
    }

    public void setStroke(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        this.f290831h = i3;
        this.f290832i = f16;
        this.f290833m.setColor(i3);
        this.f290833m.setStrokeWidth(f16 * this.C);
        this.f290833m.setStyle(Paint.Style.STROKE);
        postInvalidate();
    }

    public GuideBalloonArrow(Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
    }

    public GuideBalloonArrow(Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f290828d = null;
        this.f290829e = 2.0f;
        this.f290830f = D;
        this.f290831h = 0;
        this.f290832i = 0.0f;
        this.f290833m = new Paint();
        this.C = context.getResources().getDisplayMetrics().density;
        setBackgroundColor(0);
    }
}
