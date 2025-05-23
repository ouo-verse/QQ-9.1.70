package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class CircularProgressBar extends View {
    static IPatchRedirector $redirector_;
    private Paint C;
    private RectF D;
    private RectF E;
    private int F;
    private int G;
    private Handler H;
    private int I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private int f260379d;

    /* renamed from: e, reason: collision with root package name */
    private int f260380e;

    /* renamed from: f, reason: collision with root package name */
    private int f260381f;

    /* renamed from: h, reason: collision with root package name */
    private int f260382h;

    /* renamed from: i, reason: collision with root package name */
    private int f260383i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f260384m;

    /* loaded from: classes16.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CircularProgressBar.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            CircularProgressBar.this.invalidate();
            if (CircularProgressBar.this.J) {
                CircularProgressBar.this.I += CircularProgressBar.this.F;
                if (CircularProgressBar.this.I > 360) {
                    CircularProgressBar.this.I = 0;
                }
                CircularProgressBar.this.H.sendEmptyMessageDelayed(0, CircularProgressBar.this.G);
            }
        }
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f260379d = 60;
        this.f260380e = 5;
        this.f260381f = 5;
        this.f260382h = -1442840576;
        this.f260383i = -1428300323;
        this.f260384m = new Paint();
        this.C = new Paint();
        this.D = new RectF();
        this.E = new RectF();
        this.F = 2;
        this.G = 0;
        this.H = new a();
        this.I = 0;
        this.J = false;
    }

    private void g() {
        this.D = new RectF(0.0f, 0.0f, getLayoutParams().width, getLayoutParams().height);
        int i3 = this.f260380e;
        this.E = new RectF(i3, i3, getLayoutParams().width - this.f260380e, getLayoutParams().height - this.f260380e);
    }

    private void h() {
        this.f260384m.setColor(this.f260382h);
        this.f260384m.setAntiAlias(true);
        this.f260384m.setStyle(Paint.Style.STROKE);
        this.f260384m.setStrokeWidth(this.f260380e);
        this.C.setColor(this.f260383i);
        this.C.setAntiAlias(true);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(this.f260381f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.drawArc(this.E, 360.0f, 360.0f, false, this.C);
        if (this.J) {
            canvas.drawArc(this.E, this.I - 90, this.f260379d, false, this.f260384m);
        } else {
            canvas.drawArc(this.E, -90.0f, this.I, false, this.f260384m);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        g();
        h();
        invalidate();
    }

    public void setBarColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f260382h = i3;
        }
    }

    public void setBarLength(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f260379d = i3;
        }
    }

    public void setBarWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f260380e = i3;
        }
    }

    public void setDelayMillis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.J = false;
        this.I = i3;
        this.H.sendEmptyMessage(0);
    }

    public void setRimColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f260383i = i3;
        }
    }

    public void setRimShader(Shader shader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) shader);
        } else {
            this.C.setShader(shader);
        }
    }

    public void setRimWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f260381f = i3;
        }
    }

    public void setSpinSpeed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }
}
