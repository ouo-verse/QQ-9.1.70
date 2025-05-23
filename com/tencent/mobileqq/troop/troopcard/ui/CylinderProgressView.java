package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class CylinderProgressView extends View {
    static IPatchRedirector $redirector_;
    private int C;
    private float D;
    private int E;
    private RectF F;
    private RectF G;
    private RectF H;
    private Shader I;
    private int J;
    private int K;
    private int L;
    private int M;
    private TextView N;
    Runnable P;

    /* renamed from: d, reason: collision with root package name */
    private Paint f299860d;

    /* renamed from: e, reason: collision with root package name */
    private int f299861e;

    /* renamed from: f, reason: collision with root package name */
    private int f299862f;

    /* renamed from: h, reason: collision with root package name */
    private int f299863h;

    /* renamed from: i, reason: collision with root package name */
    private int f299864i;

    /* renamed from: m, reason: collision with root package name */
    private int f299865m;

    public CylinderProgressView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e(int i3) {
        this.M = i3;
        ThreadManager.getUIHandler().postDelayed(this.P, 15L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.f299860d.setAntiAlias(true);
        this.f299860d.setColor(this.f299861e);
        if (this.C == 0) {
            try {
                int i3 = this.f299865m;
                this.F.set(0.0f, 0.0f, this.f299864i, i3);
                float f16 = i3 / 2;
                canvas.drawRoundRect(this.F, f16, f16, this.f299860d);
                this.f299860d.setColor(this.f299863h);
                RectF rectF = this.G;
                int i16 = this.E;
                rectF.set(i16, i16, this.f299864i - i16, this.f299865m - i16);
                canvas.drawRoundRect(this.G, f16, f16, this.f299860d);
                float f17 = this.L / this.D;
                int i17 = this.f299864i;
                int i18 = this.E;
                float f18 = (i17 - i18) * f17;
                this.H.set(i18, i18, f18, this.f299865m - i18);
                if (f17 != 0.0f) {
                    int i19 = this.E;
                    LinearGradient linearGradient = new LinearGradient(i19, i19, f18, this.f299865m - i19, this.K, this.J, Shader.TileMode.CLAMP);
                    this.I = linearGradient;
                    this.f299860d.setShader(linearGradient);
                }
                canvas.drawRoundRect(this.H, f16, f16, this.f299860d);
                this.f299860d.setShader(null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        try {
            int i26 = this.f299864i;
            this.F.set(0.0f, 0.0f, i26, this.f299865m);
            float f19 = i26 / 2;
            canvas.drawRoundRect(this.F, f19, f19, this.f299860d);
            this.f299860d.setColor(this.f299863h);
            RectF rectF2 = this.G;
            int i27 = this.E;
            rectF2.set(i27, i27, this.f299864i - i27, this.f299865m - i27);
            canvas.drawRoundRect(this.G, f19, f19, this.f299860d);
            float f26 = this.L / this.D;
            int i28 = this.f299865m;
            float f27 = (i28 - r7) - ((i28 - (r7 * 2)) * f26);
            this.H.set(this.E, f27, this.f299864i - r7, i28 - r7);
            if (f26 != 0.0f) {
                LinearGradient linearGradient2 = new LinearGradient(this.E, f27, this.f299864i - r4, this.f299865m - r4, this.K, this.J, Shader.TileMode.CLAMP);
                this.I = linearGradient2;
                this.f299860d.setShader(linearGradient2);
            }
            canvas.drawRoundRect(this.H, f19, f19, this.f299860d);
            this.f299860d.setShader(null);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            this.f299864i = 0;
        } else {
            this.f299864i = size;
        }
        if (mode2 != 1073741824 && mode2 != Integer.MIN_VALUE) {
            this.f299865m = 0;
        } else {
            this.f299865m = size2;
        }
        setMeasuredDimension(this.f299864i, this.f299865m);
    }

    public synchronized void setMax(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            if (i3 >= 0) {
                this.D = i3;
                return;
            }
            throw new IllegalArgumentException("value can not be negative");
        }
    }

    public synchronized void setProgress(int i3, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) textView);
            return;
        }
        if (i3 >= 0) {
            float f16 = i3;
            float f17 = this.D;
            if (f16 > f17) {
                i3 = (int) f17;
            }
            this.N = textView;
            if (this.L != i3) {
                e(i3);
            } else {
                textView.setText(String.valueOf(i3));
            }
            return;
        }
        throw new IllegalArgumentException("value can not be negative");
    }

    public synchronized void setProgressEndColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.K = i3;
        }
    }

    public synchronized void setProgressStartColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public CylinderProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CylinderProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = 100.0f;
        this.P = new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.CylinderProgressView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CylinderProgressView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (CylinderProgressView.this.L < CylinderProgressView.this.M) {
                    CylinderProgressView.this.L++;
                    CylinderProgressView.this.postInvalidate();
                    if (CylinderProgressView.this.N != null) {
                        CylinderProgressView.this.N.setText(String.valueOf(CylinderProgressView.this.L));
                    }
                    ThreadManager.getUIHandler().postDelayed(this, 15L);
                    return;
                }
                if (CylinderProgressView.this.L > CylinderProgressView.this.M) {
                    CylinderProgressView cylinderProgressView = CylinderProgressView.this;
                    cylinderProgressView.L--;
                    CylinderProgressView.this.postInvalidate();
                    if (CylinderProgressView.this.N != null) {
                        CylinderProgressView.this.N.setText(String.valueOf(CylinderProgressView.this.L));
                    }
                    ThreadManager.getUIHandler().postDelayed(this, 15L);
                }
            }
        };
        this.f299860d = new Paint();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ss2.a.f434635y0);
        int i16 = ss2.a.C0;
        this.E = obtainStyledAttributes.getColor(i16, 0);
        this.f299861e = obtainStyledAttributes.getColor(i16, 0);
        this.f299862f = obtainStyledAttributes.getColor(ss2.a.B0, -16776961);
        this.f299863h = obtainStyledAttributes.getColor(ss2.a.f434643z0, Color.parseColor("#F5F6FA"));
        this.C = obtainStyledAttributes.getInt(ss2.a.A0, 1);
        obtainStyledAttributes.recycle();
    }
}
