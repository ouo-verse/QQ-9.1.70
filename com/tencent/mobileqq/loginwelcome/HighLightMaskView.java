package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class HighLightMaskView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Path f243062d;

    /* renamed from: e, reason: collision with root package name */
    Paint f243063e;

    /* renamed from: f, reason: collision with root package name */
    PorterDuffXfermode f243064f;

    public HighLightMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243063e = new Paint();
        this.f243064f = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        a();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f243062d == null) {
            this.f243062d = new Path();
        }
        this.f243062d.reset();
        if (VersionUtils.isHoneycomb()) {
            setLayerType(1, null);
        }
        this.f243063e.setColor(0);
        this.f243063e.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.drawColor(-1728053248);
        this.f243063e.setXfermode(this.f243064f);
        canvas.drawPath(this.f243062d, this.f243063e);
        this.f243063e.setXfermode(null);
    }

    public void setCircleSrc(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            this.f243062d.addCircle(f16, f17, f18, Path.Direction.CW);
        }
    }

    public void setHighLightRect(RectF rectF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rectF);
        } else {
            this.f243062d.addRect(rectF, Path.Direction.CW);
        }
    }

    public void setRoundSrc(RectF rectF, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rectF, (Object) fArr);
        } else {
            this.f243062d.addRoundRect(rectF, fArr, Path.Direction.CW);
        }
    }

    public HighLightMaskView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f243063e = new Paint();
        this.f243064f = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        a();
    }
}
