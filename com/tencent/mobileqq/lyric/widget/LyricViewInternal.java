package com.tencent.mobileqq.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.data.d;
import com.tencent.mobileqq.lyric.data.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LyricViewInternal extends View {
    static IPatchRedirector $redirector_;
    protected int A0;
    protected final Handler B0;
    public int C;
    public boolean D;
    protected final Paint E;
    protected final Paint F;
    protected final Paint G;
    protected final Paint H;
    protected final Paint I;
    protected final Paint J;
    protected final Paint K;
    protected final Paint L;
    protected final Paint M;
    protected final Paint N;
    protected int P;
    protected com.tencent.mobileqq.lyric.data.b Q;
    protected com.tencent.mobileqq.lyric.data.b R;
    protected final String S;
    protected String T;
    protected int U;
    protected Scroller V;
    protected int W;

    /* renamed from: a0, reason: collision with root package name */
    protected int f243211a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f243212b0;

    /* renamed from: c0, reason: collision with root package name */
    protected int f243213c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f243214d;

    /* renamed from: d0, reason: collision with root package name */
    Bitmap f243215d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f243216e;

    /* renamed from: e0, reason: collision with root package name */
    Context f243217e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f243218f;

    /* renamed from: f0, reason: collision with root package name */
    protected float f243219f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f243220g0;

    /* renamed from: h, reason: collision with root package name */
    protected int f243221h;

    /* renamed from: h0, reason: collision with root package name */
    protected volatile boolean f243222h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f243223i;

    /* renamed from: i0, reason: collision with root package name */
    protected int f243224i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f243225j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f243226k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f243227l0;

    /* renamed from: m, reason: collision with root package name */
    protected int f243228m;

    /* renamed from: m0, reason: collision with root package name */
    protected int f243229m0;

    /* renamed from: n0, reason: collision with root package name */
    protected int f243230n0;

    /* renamed from: o0, reason: collision with root package name */
    protected volatile int f243231o0;

    /* renamed from: p0, reason: collision with root package name */
    protected Object f243232p0;

    /* renamed from: q0, reason: collision with root package name */
    protected volatile boolean f243233q0;

    /* renamed from: r0, reason: collision with root package name */
    protected volatile long f243234r0;

    /* renamed from: s0, reason: collision with root package name */
    protected volatile boolean f243235s0;

    /* renamed from: t0, reason: collision with root package name */
    protected volatile boolean f243236t0;

    /* renamed from: u0, reason: collision with root package name */
    protected int f243237u0;

    /* renamed from: v0, reason: collision with root package name */
    protected volatile boolean f243238v0;

    /* renamed from: w0, reason: collision with root package name */
    protected volatile boolean f243239w0;

    /* renamed from: x0, reason: collision with root package name */
    protected volatile boolean f243240x0;

    /* renamed from: y0, reason: collision with root package name */
    protected volatile boolean f243241y0;

    /* renamed from: z0, reason: collision with root package name */
    protected int f243242z0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternal.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else {
                LyricViewInternal.this.requestLayout();
                LyricViewInternal.this.invalidate();
            }
        }
    }

    public LyricViewInternal(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    protected void a(Canvas canvas, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) canvas, i3);
        }
    }

    protected void b(Canvas canvas, Paint paint, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, canvas, paint, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Rect rect = new Rect();
        String[] split = str.split("\n");
        int i17 = 0;
        for (int i18 = 0; i18 < split.length; i18++) {
            canvas.drawText(split[i18], ((this.U - ((int) this.E.measureText(split[i18]))) >> 1) + i3, i16 + i17, paint);
            String str2 = split[i18];
            paint.getTextBounds(str2, 0, str2.length(), rect);
            i17 += rect.height() + 20;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.f243211a0 == -1) {
            this.f243211a0 = (int) (this.f243219f0 * 43.0f);
        }
        return this.f243211a0;
    }

    public com.tencent.mobileqq.lyric.data.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.lyric.data.b) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tencent.mobileqq.lyric.data.b e() {
        return this.Q;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f243231o0;
    }

    public void g(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        this.Q = new com.tencent.mobileqq.lyric.data.b(2, 0, null);
        this.R = new com.tencent.mobileqq.lyric.data.b(2, 0, null);
        this.f243221h = bVar.f243261j;
        this.f243216e = bVar.f243255d;
        this.f243218f = bVar.f243260i;
        int i3 = bVar.f243256e;
        int i16 = bVar.f243257f;
        int i17 = bVar.f243258g;
        this.f243223i = bVar.f243259h;
        int i18 = bVar.f243253b;
        this.f243214d = bVar.f243252a;
        this.f243239w0 = bVar.f243263l;
        boolean z16 = bVar.f243264m;
        this.f243241y0 = true;
        this.f243242z0 = 3;
        this.A0 = 2;
        this.C = bVar.f243265n;
        this.D = bVar.f243266o;
        this.G.setAntiAlias(true);
        float f16 = i3;
        this.G.setTextSize(f16);
        this.G.setColor(i17);
        this.H.setAntiAlias(true);
        this.H.setTextSize(f16);
        this.H.setColor(i16);
        this.F.setAntiAlias(true);
        this.F.setTextSize(f16);
        this.F.setColor(i16);
        this.F.setFakeBoldText(z16);
        this.E.setAntiAlias(true);
        this.E.setTextSize(this.f243214d);
        this.E.setColor(i18);
        this.J.setAntiAlias(true);
        this.J.setTextSize(this.f243214d);
        this.J.setColor(i18);
        this.J.setAlpha(127);
        this.K.setAntiAlias(true);
        this.K.setTextSize(this.f243214d);
        this.K.setColor(i18);
        this.K.setAlpha(51);
        this.L.setAntiAlias(true);
        this.L.setTextSize(this.f243214d);
        this.L.setColor(i18);
        this.L.setAlpha(25);
        this.I.setAntiAlias(true);
        this.I.setTextSize(this.f243214d);
        this.M.setAntiAlias(true);
        this.M.setTextSize(this.f243214d);
        this.M.setColor(i18);
        this.M.setAlpha(255);
        this.N.setAntiAlias(true);
        this.N.setTextSize(f16);
        this.N.setColor(i18);
        this.N.setAlpha(255);
        this.f243228m = this.f243218f;
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        int i16 = (((i3 - this.f243228m) - this.f243223i) / (this.f243216e + this.f243218f)) + 1;
        this.f243242z0 = i16;
        if (i16 < 0) {
            this.f243242z0 = 2;
        }
    }

    public int i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        int i16 = this.f243229m0;
        this.f243235s0 = false;
        return i16;
    }

    public int j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        this.f243235s0 = true;
        return this.f243229m0;
    }

    public void k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f243229m0 = i3;
        this.f243230n0 = i16;
        t();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(d dVar, Canvas canvas, int i3, int i16, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, dVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint);
            return;
        }
        ArrayList<f> d16 = dVar.d();
        int i17 = this.f243216e + this.f243218f;
        for (int i18 = 0; i18 < d16.size(); i18++) {
            d16.get(i18).d(canvas, i3, i16 + this.f243218f, paint, false);
            i16 += i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(d dVar, Canvas canvas, int i3, int i16, boolean z16) {
        Paint paint;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, dVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        ArrayList<f> d16 = dVar.d();
        if (z16) {
            paint = this.F;
        } else {
            paint = this.E;
        }
        int i17 = this.f243216e + this.f243218f;
        for (int i18 = 0; i18 < d16.size(); i18++) {
            d16.get(i18).d(canvas, i3, i16 + this.f243218f, paint, z16);
            i16 += i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void n(d dVar, Canvas canvas, int i3, int i16) {
        int i17;
        char c16;
        int i18;
        int i19;
        int i26;
        float f16;
        float f17;
        int i27;
        float measureText;
        int i28;
        float measureText2;
        int i29;
        com.tencent.mobileqq.lyric.data.a aVar;
        float f18;
        float f19;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 2;
        int i36 = 1;
        int i37 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, dVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ArrayList<f> d16 = dVar.d();
        int i38 = this.f243230n0;
        Paint paint = this.F;
        int i39 = i16;
        int i46 = 0;
        while (i46 < d16.size()) {
            f fVar = d16.get(i46);
            if (fVar.f243164f == null) {
                c16 = c17;
                i18 = i36;
                i19 = i37;
                i26 = i46;
            } else {
                if (i46 == 0) {
                    i17 = this.f243218f;
                } else {
                    i17 = this.f243221h;
                }
                int i47 = i17;
                long j3 = i38;
                if (fVar.b() <= j3 && fVar.a() >= j3) {
                    int i48 = i37;
                    int i49 = i48;
                    com.tencent.mobileqq.lyric.data.a aVar2 = null;
                    while (i48 < fVar.f243164f.size()) {
                        aVar2 = fVar.f243164f.get(i48);
                        if (i48 < fVar.f243164f.size() - i36) {
                            aVar = fVar.f243164f.get(i48 + 1);
                        } else {
                            aVar = null;
                        }
                        long j16 = aVar2.f243137a;
                        if (j16 <= j3 && aVar != null && aVar.f243137a > j3) {
                            f18 = (float) (j3 - j16);
                            f19 = (float) aVar2.f243138b;
                        } else {
                            if (j16 <= j3) {
                                long j17 = aVar2.f243138b;
                                if (j16 + j17 >= j3) {
                                    f18 = (float) (j3 - j16);
                                    f19 = (float) j17;
                                }
                            }
                            i49 = i48;
                            i36 = 1;
                            i48++;
                        }
                        f16 = f18 / f19;
                        f17 = f16;
                        i27 = i48;
                    }
                    f16 = 0.0f;
                    f17 = 0.0f;
                    i27 = i49;
                    if (aVar2 != null) {
                        float f26 = i3;
                        if (i27 != 0) {
                            try {
                                int i56 = i27 - 1;
                                if (fVar.f243159a.length() >= fVar.f243164f.get(i56).f243140d) {
                                    measureText = this.F.measureText(fVar.f243159a.substring(0, fVar.f243164f.get(i56).f243140d));
                                } else {
                                    Paint paint2 = this.F;
                                    String str = fVar.f243159a;
                                    measureText = paint2.measureText(str.substring(0, str.length()));
                                }
                            } catch (StringIndexOutOfBoundsException unused) {
                                Paint paint3 = this.F;
                                String str2 = fVar.f243159a;
                                measureText = paint3.measureText(str2.substring(0, str2.length()));
                            }
                            f26 += measureText;
                        }
                        float f27 = f26;
                        try {
                            if (i27 == fVar.f243164f.size() - 1) {
                                Paint paint4 = this.H;
                                String str3 = fVar.f243159a;
                                measureText2 = paint4.measureText(str3.substring(aVar2.f243139c, str3.length()));
                            } else {
                                int length = fVar.f243159a.length();
                                int i57 = aVar2.f243140d;
                                if (length >= i57) {
                                    measureText2 = this.H.measureText(fVar.f243159a.substring(aVar2.f243139c, i57));
                                } else {
                                    Paint paint5 = this.H;
                                    String str4 = fVar.f243159a;
                                    measureText2 = paint5.measureText(str4.substring(aVar2.f243139c, str4.length()));
                                }
                            }
                            i29 = 2;
                            i28 = 0;
                        } catch (StringIndexOutOfBoundsException unused2) {
                            Paint paint6 = this.H;
                            String str5 = fVar.f243159a;
                            i28 = 0;
                            measureText2 = paint6.measureText(str5.substring(0, str5.length()));
                            i29 = 2;
                        }
                        int[] iArr = new int[i29];
                        iArr[i28] = paint.getColor();
                        i18 = 1;
                        iArr[1] = this.G.getColor();
                        float[] fArr = new float[2];
                        fArr[i28] = f16;
                        fArr[1] = f17;
                        c16 = 2;
                        i19 = i28;
                        i26 = i46;
                        fVar.c(canvas, i3, i39 + i47, this.G, paint, this.H, i27, measureText2, f27, iArr, fArr);
                    } else {
                        i19 = i37;
                        i26 = i46;
                        i18 = 1;
                        c16 = 2;
                    }
                } else {
                    c16 = c17;
                    i18 = i36;
                    i19 = i37;
                    i26 = i46;
                    if (fVar.a() < j3) {
                        fVar.d(canvas, i3, i39 + i47, paint, true);
                    } else {
                        fVar.d(canvas, i3, i39 + i47, this.G, true);
                    }
                }
                i39 += i47 + this.f243223i;
            }
            i46 = i26 + 1;
            i37 = i19;
            i36 = i18;
            c17 = c16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar, Canvas canvas, int i3, int i16, Paint paint, Paint paint2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, dVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2);
            return;
        }
        ArrayList<f> d16 = dVar.d();
        int i17 = this.f243216e + this.f243218f;
        for (int i18 = 0; i18 < d16.size(); i18++) {
            d16.get(i18).e(canvas, i3, i16 + this.f243218f, paint, paint2);
            i16 += i17;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        int measuredHeight = (getMeasuredHeight() >> 1) - this.f243216e;
        int i3 = this.W;
        if (i3 != 40 && i3 != 60) {
            if (i3 != 70) {
                if (this.T != null) {
                    scrollTo(0, 0);
                    this.V.setFinalX(0);
                    b(canvas, this.E, this.T, 0, measuredHeight);
                    return;
                }
                return;
            }
            a(canvas, 0);
            return;
        }
        if (this.S != null) {
            scrollTo(0, 0);
            this.V.setFinalX(0);
            b(canvas, this.E, this.S, 0, measuredHeight);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        com.tencent.mobileqq.lyric.data.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.W == 70) {
            int c16 = measuredWidth - (c() << 1);
            int i18 = this.f243216e + this.f243218f;
            if (this.D) {
                this.Q.f(this.F, this.E, c16, false, true);
            } else {
                this.Q.e(this.F, this.E, c16);
            }
            if (this.R != null && this.Q.l() == this.R.l()) {
                if (this.D) {
                    this.R.f(this.F, this.E, c16, false, true);
                } else {
                    this.R.e(this.F, this.E, c16);
                }
            }
            if (this.f243222h0) {
                for (int i19 = this.f243226k0; i19 <= this.f243227l0; i19++) {
                    if (this.Q.f243142b.get(i19) != null) {
                        i17 += this.Q.f243142b.get(i19).c();
                    }
                }
            } else {
                i17 = this.Q.i();
            }
            if (this.f243238v0 && (bVar = this.R) != null && bVar.f243142b != null) {
                if (this.f243222h0) {
                    for (int i26 = this.f243226k0; i26 <= this.f243227l0; i26++) {
                        if (i26 < this.R.f243142b.size() && i26 >= 0) {
                            i17 += this.R.f243142b.get(i26).c();
                        }
                    }
                } else {
                    i17 += this.R.i();
                }
            }
            int i27 = i17 * i18;
            this.f243212b0 = i27;
            setMeasuredDimension(measuredWidth, i27 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.f243222h0 = false;
        this.f243224i0 = -1;
        this.f243225j0 = -1;
        this.f243226k0 = 0;
        this.f243227l0 = 0;
        this.f243236t0 = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f243233q0 = false;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.lyric.widget.LyricViewInternal.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternal.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    LyricViewInternal.this.requestLayout();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(com.tencent.mobileqq.lyric.data.b bVar, com.tencent.mobileqq.lyric.data.b bVar2) {
        Log.d("ModuleLyricViewInternal", "setLyric begin");
        this.f243233q0 = true;
        this.f243236t0 = false;
        if (bVar != null) {
            p();
            com.tencent.mobileqq.lyric.data.b bVar3 = new com.tencent.mobileqq.lyric.data.b(2, 0, null);
            bVar3.a(bVar);
            this.Q = bVar3;
            if (bVar2 != null && bVar.l() == bVar2.l()) {
                com.tencent.mobileqq.lyric.data.b bVar4 = new com.tencent.mobileqq.lyric.data.b(2, 0, null);
                bVar4.a(bVar2);
                this.R = bVar4;
            } else {
                Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
                this.R = new com.tencent.mobileqq.lyric.data.b(2, 0, null);
            }
            setState(70);
        } else {
            Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
            setState(40);
        }
        Log.d("ModuleLyricViewInternal", "setLyric end");
    }

    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    public void setDrawAttachInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f243240x0 = z16;
        }
    }

    public void setHighlightCurrentLine(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.f243241y0 = z16;
        }
    }

    public void setHighlightLineNumber(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.A0 = i3;
        }
    }

    public void setIndicator(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) bitmap);
        }
    }

    public void setLeftAlign(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }

    public void setLyricColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.E.setColor(i3);
        }
    }

    public void setLyricHilightColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.H.setColor(i3);
            this.F.setColor(i3);
        }
    }

    public void setScore(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iArr);
        }
    }

    public void setSegment(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 >= 0 && i16 > i3) {
            com.tencent.mobileqq.lyric.data.b bVar = this.Q;
            if (bVar != null && !bVar.j()) {
                if (this.f243224i0 == i3 && this.f243225j0 == i16) {
                    Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
                    return;
                }
                this.f243224i0 = i3;
                this.f243225j0 = i16;
                this.f243226k0 = this.Q.d(i3);
                int b16 = this.Q.b(i16);
                this.f243227l0 = b16;
                if (this.f243226k0 >= 0 && b16 >= 0) {
                    this.f243222h0 = true;
                    this.f243236t0 = false;
                    return;
                } else {
                    Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
                    this.f243222h0 = false;
                    return;
                }
            }
            Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
            return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
    }

    public void setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.W = i3;
            this.B0.sendEmptyMessage(0);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @SuppressLint({"NewApi"})
    public LyricViewInternal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = new Paint();
        this.F = new Paint();
        this.G = new Paint();
        this.H = new Paint();
        this.I = new Paint();
        this.J = new Paint();
        this.K = new Paint();
        this.L = new Paint();
        this.M = new Paint();
        this.N = new Paint();
        this.P = 0;
        this.W = 0;
        this.f243211a0 = -1;
        this.f243212b0 = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        this.f243213c0 = -1;
        this.f243215d0 = null;
        this.f243224i0 = -1;
        this.f243225j0 = -1;
        this.f243226k0 = 0;
        this.f243227l0 = 0;
        this.f243229m0 = 0;
        this.f243230n0 = 0;
        this.f243231o0 = 0;
        this.f243232p0 = new Object();
        this.f243233q0 = true;
        this.f243234r0 = 0L;
        this.B0 = new a(Looper.getMainLooper());
        this.f243217e0 = context;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        this.f243220g0 = point.x;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f243219f0 = displayMetrics.density;
        this.S = context.getString(R.string.hnx);
        this.T = context.getString(R.string.hnw);
        this.V = new Scroller(context, new AccelerateDecelerateInterpolator());
    }
}
