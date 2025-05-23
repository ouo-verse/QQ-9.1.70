package com.tencent.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class LyricViewInternalBase extends View implements b {
    static IPatchRedirector $redirector_;
    protected volatile boolean A0;
    protected volatile boolean B0;
    protected int C;
    protected int C0;
    protected int D;
    protected int D0;
    protected int E;
    protected int E0;
    protected volatile boolean F;
    protected volatile boolean F0;
    protected int G;
    protected volatile boolean G0;
    protected int H;
    protected int H0;
    public int I;
    protected int I0;
    public boolean J;
    protected int[] J0;
    protected int K;
    protected int K0;
    protected int L;
    protected int L0;
    protected final Paint M;
    protected boolean M0;
    protected final Paint N;
    protected int N0;
    protected ArrayList<int[]> O0;
    protected final Paint P;
    protected ArrayList<Bitmap> P0;
    protected final Paint Q;
    protected Paint Q0;
    protected final Paint R;
    protected Paint R0;
    protected final Paint S;
    protected boolean S0;
    protected int T;
    protected boolean T0;
    protected com.tencent.lyric.data.a U;
    protected boolean U0;
    protected com.tencent.lyric.data.a V;
    protected Paint V0;
    protected final String W;
    protected boolean W0;
    protected final Handler X0;
    protected int Y0;
    protected int Z0;

    /* renamed from: a0, reason: collision with root package name */
    protected Scroller f147174a0;

    /* renamed from: a1, reason: collision with root package name */
    protected int f147175a1;

    /* renamed from: b0, reason: collision with root package name */
    protected int f147176b0;

    /* renamed from: b1, reason: collision with root package name */
    protected boolean f147177b1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f147178c0;

    /* renamed from: c1, reason: collision with root package name */
    protected int f147179c1;

    /* renamed from: d, reason: collision with root package name */
    protected int f147180d;

    /* renamed from: d0, reason: collision with root package name */
    protected int f147181d0;

    /* renamed from: d1, reason: collision with root package name */
    protected int f147182d1;

    /* renamed from: e, reason: collision with root package name */
    protected int f147183e;

    /* renamed from: e0, reason: collision with root package name */
    protected int f147184e0;

    /* renamed from: e1, reason: collision with root package name */
    protected int f147185e1;

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f147186f;

    /* renamed from: f0, reason: collision with root package name */
    Bitmap f147187f0;

    /* renamed from: f1, reason: collision with root package name */
    protected int f147188f1;

    /* renamed from: g0, reason: collision with root package name */
    Context f147189g0;

    /* renamed from: g1, reason: collision with root package name */
    protected int f147190g1;

    /* renamed from: h, reason: collision with root package name */
    protected int f147191h;

    /* renamed from: h0, reason: collision with root package name */
    protected float f147192h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f147193i;

    /* renamed from: i0, reason: collision with root package name */
    protected int f147194i0;

    /* renamed from: j0, reason: collision with root package name */
    protected volatile boolean f147195j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f147196k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f147197l0;

    /* renamed from: m, reason: collision with root package name */
    protected int f147198m;

    /* renamed from: m0, reason: collision with root package name */
    protected int f147199m0;

    /* renamed from: n0, reason: collision with root package name */
    protected int f147200n0;

    /* renamed from: o0, reason: collision with root package name */
    protected int f147201o0;

    /* renamed from: p0, reason: collision with root package name */
    protected int f147202p0;

    /* renamed from: q0, reason: collision with root package name */
    protected volatile int f147203q0;

    /* renamed from: r0, reason: collision with root package name */
    protected Object f147204r0;

    /* renamed from: s0, reason: collision with root package name */
    protected volatile boolean f147205s0;

    /* renamed from: t0, reason: collision with root package name */
    protected volatile long f147206t0;

    /* renamed from: u0, reason: collision with root package name */
    protected volatile boolean f147207u0;

    /* renamed from: v0, reason: collision with root package name */
    protected int f147208v0;

    /* renamed from: w0, reason: collision with root package name */
    protected volatile boolean f147209w0;

    /* renamed from: x0, reason: collision with root package name */
    protected int f147210x0;

    /* renamed from: y0, reason: collision with root package name */
    protected volatile boolean f147211y0;

    /* renamed from: z0, reason: collision with root package name */
    protected volatile int f147212z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternalBase.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            Log.i("ModuleLyricViewInternal", "handleMessage -> requestLayout and invalidate");
            LyricViewInternalBase.this.requestLayout();
            LyricViewInternalBase.this.invalidate();
        }
    }

    public LyricViewInternalBase(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void B() {
        if (this.f147175a1 == com.tencent.lyric.util.d.f147093c) {
            this.f147177b1 = true;
        } else {
            this.f147177b1 = false;
        }
        p();
    }

    private synchronized void D(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2) {
        if (aVar != null) {
            h();
            com.tencent.lyric.data.a aVar3 = new com.tencent.lyric.data.a(2, 0, null);
            aVar3.a(aVar);
            this.U = aVar3;
            if (aVar2 != null && aVar.v() == aVar2.v()) {
                com.tencent.lyric.data.a aVar4 = new com.tencent.lyric.data.a(2, 0, null);
                aVar4.a(aVar2);
                this.V = aVar4;
            } else {
                this.V = new com.tencent.lyric.data.a(2, 0, null);
            }
            setState(70);
        } else {
            setState(40);
            this.U = new com.tencent.lyric.data.a(2, 0, null);
            this.V = new com.tencent.lyric.data.a(2, 0, null);
        }
    }

    protected static boolean o(com.tencent.lyric.data.a aVar) {
        ArrayList<com.tencent.lyric.data.e> arrayList;
        if (aVar == null || aVar.f147055a != 2 || (arrayList = aVar.f147056b) == null) {
            return false;
        }
        Iterator<com.tencent.lyric.data.e> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<com.tencent.lyric.data.b> arrayList2 = it.next().f147074e;
            if (arrayList2 == null || arrayList2.size() != 1) {
                return false;
            }
        }
        return true;
    }

    private void p() {
        if (this.f147175a1 == com.tencent.lyric.util.d.f147093c) {
            Paint paint = this.P;
            if (paint != null) {
                paint.setShadowLayer(this.f147179c1, this.f147182d1, this.f147185e1, this.f147188f1);
            }
            Paint paint2 = this.Q;
            if (paint2 != null) {
                paint2.setShadowLayer(this.f147179c1, this.f147182d1, this.f147185e1, this.f147188f1);
            }
            Paint paint3 = this.N;
            if (paint3 != null) {
                paint3.setShadowLayer(this.f147179c1, this.f147182d1, this.f147185e1, this.f147188f1);
            }
            Paint paint4 = this.M;
            if (paint4 != null) {
                paint4.setShadowLayer(this.f147179c1, this.f147182d1, this.f147185e1, this.f147188f1);
            }
            Paint paint5 = this.Q0;
            if (paint5 != null) {
                paint5.setShadowLayer(this.f147179c1, this.f147182d1, this.f147185e1, this.f147188f1);
            }
            Paint paint6 = this.R0;
            if (paint6 != null) {
                paint6.setShadowLayer(this.f147179c1, this.f147182d1, this.f147185e1, this.f147188f1);
                return;
            }
            return;
        }
        Paint paint7 = this.P;
        if (paint7 != null) {
            paint7.clearShadowLayer();
        }
        Paint paint8 = this.Q;
        if (paint8 != null) {
            paint8.clearShadowLayer();
        }
        Paint paint9 = this.N;
        if (paint9 != null) {
            paint9.clearShadowLayer();
        }
        Paint paint10 = this.M;
        if (paint10 != null) {
            paint10.clearShadowLayer();
        }
        Paint paint11 = this.Q0;
        if (paint11 != null) {
            paint11.clearShadowLayer();
        }
        Paint paint12 = this.R0;
        if (paint12 != null) {
            paint12.clearShadowLayer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else if (this.T0) {
            this.W0 = z16;
        } else {
            this.W0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void C(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        boolean z16 = this.f147195j0;
        int i3 = this.f147196k0;
        int i16 = this.f147197l0;
        D(aVar, aVar2);
        if (z16) {
            setSegment(i3, i16);
        }
    }

    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        this.f147207u0 = true;
        return this.f147201o0;
    }

    @Override // com.tencent.lyric.widget.b
    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        int i16 = this.f147201o0;
        this.f147207u0 = false;
        return i16;
    }

    @Override // com.tencent.lyric.widget.b
    public com.tencent.lyric.data.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.lyric.data.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.U;
    }

    @Override // com.tencent.lyric.widget.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f147203q0;
    }

    @Override // com.tencent.lyric.widget.b
    public void e(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f147201o0 = i3;
        this.f147202p0 = i16;
        f();
        postInvalidate();
    }

    public abstract void f();

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
        }
    }

    @Override // com.tencent.lyric.widget.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.f147195j0 = false;
        this.f147196k0 = -1;
        this.f147197l0 = -1;
        this.f147199m0 = 0;
        this.f147200n0 = 0;
        y();
    }

    protected void i(Canvas canvas, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) canvas, i3);
        }
    }

    protected void j(Canvas canvas, Paint paint, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, canvas, paint, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Log.i("ModuleLyricViewInternal", "drawString -> str:" + str + ", y:" + i16);
        Rect rect = new Rect();
        String[] split = str.split("\n");
        int i17 = this.f147193i;
        for (int i18 = 0; i18 < split.length; i18++) {
            canvas.drawText(split[i18], ((getWidth() - ((int) this.M.measureText(split[i18]))) >> 1) + i3, i16 + i17, paint);
            String str2 = split[i18];
            paint.getTextBounds(str2, 0, str2.length(), rect);
            i17 += rect.height() + 20;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (this.f147178c0 == -1) {
            this.f147178c0 = this.E0;
        }
        return this.f147178c0;
    }

    public void l(d dVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        this.U = new com.tencent.lyric.data.a(2, 0, null);
        this.V = new com.tencent.lyric.data.a(2, 0, null);
        this.f147198m = dVar.f147276l;
        this.f147191h = dVar.f147269e;
        this.f147193i = dVar.f147275k;
        this.D = dVar.f147270f;
        this.E = dVar.f147271g;
        this.F = dVar.f147272h;
        this.G = dVar.f147273i;
        int i16 = dVar.f147274j;
        this.C = i16;
        if (i16 == 20 && i16 < (i3 = this.f147191h)) {
            this.C = i3;
        }
        this.f147183e = dVar.f147267c;
        this.f147186f = dVar.f147266b;
        this.f147180d = dVar.f147265a;
        this.A0 = dVar.f147278n;
        this.I = dVar.f147279o;
        this.J = dVar.f147280p;
        this.F0 = dVar.f147282r;
        this.G0 = dVar.f147281q;
        this.E0 = dVar.f147277m;
        this.K = dVar.f147289y;
        int i17 = dVar.f147290z;
        this.L = i17;
        if (i17 < 1) {
            this.L = 1;
        }
        this.S0 = dVar.F;
        boolean z16 = dVar.G;
        this.T0 = z16;
        this.U0 = dVar.H;
        this.W0 = z16;
        this.P.setAntiAlias(true);
        this.P.setTextSize(this.D);
        this.P.setColor(this.G);
        this.P.setFakeBoldText(this.F);
        this.Q.setAntiAlias(true);
        this.Q.setTextSize(this.D);
        this.Q.setColor(this.E);
        this.Q.setFakeBoldText(this.G0);
        this.N.setAntiAlias(true);
        this.N.setTextSize(this.D);
        this.N.setColor(this.E);
        this.N.setFakeBoldText(this.F0);
        this.M.setAntiAlias(true);
        this.M.setTextSize(this.f147180d);
        this.M.setColor(this.f147183e);
        this.M.setFakeBoldText(this.f147186f);
        this.R.setAntiAlias(true);
        this.R.setTextSize(this.f147180d);
        this.R.setColor(0);
        this.R.setAlpha(255);
        this.S.setAntiAlias(true);
        this.S.setTextSize(this.D);
        this.S.setColor(this.K);
        this.S.setAlpha(255);
        this.Q0.setColor(dVar.f147285u);
        this.Q0.setStyle(Paint.Style.FILL);
        this.R0.setColor(dVar.f147283s);
        this.R0.setTextSize(dVar.f147284t);
        this.Q0.setColor(dVar.f147285u);
        this.H = dVar.f147286v;
        this.Y0 = dVar.f147287w;
        this.Z0 = dVar.f147288x;
        int i18 = dVar.A;
        this.f147175a1 = i18;
        this.f147179c1 = dVar.B;
        this.f147182d1 = dVar.C;
        this.f147185e1 = dVar.D;
        this.f147188f1 = dVar.E;
        if (i18 == com.tencent.lyric.util.d.f147093c) {
            this.f147177b1 = true;
        }
        this.f147190g1 = dVar.I;
        p();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.W0) {
            return;
        }
        Paint paint = new Paint();
        this.V0 = paint;
        paint.setARGB(128, 255, 255, 255);
        this.V0.setStyle(Paint.Style.STROKE);
        this.V0.setPathEffect(new DashPathEffect(new float[]{4.0f, 11.0f}, 0.0f));
        this.V0.setStrokeWidth(2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f147175a1 == com.tencent.lyric.util.d.f147092b) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.f147176b0;
        if (i3 != 40 && i3 != 60) {
            if (i3 != 70) {
                if (this.W != null) {
                    scrollTo(0, 0);
                    this.f147174a0.setFinalX(0);
                    j(canvas, this.M, this.W, 0, this.H);
                    return;
                }
                return;
            }
            i(canvas, 0);
            return;
        }
        if (this.W != null) {
            scrollTo(0, 0);
            this.f147174a0.setFinalX(0);
            j(canvas, this.M, this.W, 0, this.H);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        com.tencent.lyric.data.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f147176b0 == 70) {
            int k3 = measuredWidth - (k() << 1);
            int i18 = this.f147191h + this.f147193i;
            if (this.J) {
                this.U.j(this.N, this.M, k3, false, true, false);
            } else {
                this.U.h(this.N, this.M, k3);
            }
            if (this.V != null && this.U.v() == this.V.v()) {
                if (this.J) {
                    this.V.j(this.N, this.M, k3, false, true, false);
                } else {
                    this.V.h(this.N, this.M, k3);
                }
            }
            if (this.f147195j0) {
                for (int i19 = this.f147199m0; i19 <= this.f147200n0; i19++) {
                    if (this.U.f147056b.get(i19) != null) {
                        i17 += this.U.f147056b.get(i19).e();
                    }
                }
            } else {
                i17 = this.U.q();
            }
            if (this.f147211y0 && (aVar = this.V) != null && aVar.f147056b != null) {
                if (this.f147195j0) {
                    for (int i26 = this.f147199m0; i26 <= this.f147200n0; i26++) {
                        if (i26 < this.V.f147056b.size() && i26 >= 0) {
                            i17 += this.V.f147056b.get(i26).e();
                        }
                    }
                } else {
                    i17 += this.V.q();
                }
            }
            this.f147181d0 = i17 * i18;
            this.D0 = (measuredHeight / (this.f147193i + this.f147191h)) + 1;
            Log.i("ModuleLyricViewInternal", "onMeasure -> Show line count:" + this.D0 + ", parentHeight : " + measuredHeight);
            setMeasuredDimension(measuredWidth, this.f147181d0 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint);
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        int i17 = this.f147191h + this.f147193i;
        int i18 = i16;
        for (int i19 = 0; i19 < f16.size(); i19++) {
            f16.get(i19).j(canvas, i3, i18 + this.f147193i, paint, false, 255 - Math.max((((int) (this.f147202p0 - eVar.f147071b)) / 1000) * 255, 255));
            i18 += i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint);
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        int i17 = this.f147191h + this.f147193i;
        for (int i18 = 0; i18 < f16.size(); i18++) {
            f16.get(i18).i(canvas, i3, i16 + this.f147193i, paint, false);
            i16 += i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Integer.valueOf(i17));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        int i18 = this.f147191h + this.f147193i;
        int i19 = i16;
        for (int i26 = 0; i26 < f16.size(); i26++) {
            f16.get(i26).j(canvas, i3, i19 + this.f147193i, paint, false, i17);
            i19 += i18;
        }
    }

    public void setDataFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f147205s0 = false;
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalBase.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalBase.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalBase.this.requestLayout();
                    }
                }
            });
        }
    }

    public void setDrawAttachInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.B0 = z16;
        }
    }

    @Override // com.tencent.lyric.widget.b
    public void setEffectType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, i3);
        } else if (this.f147175a1 != i3) {
            this.f147175a1 = i3;
            B();
            invalidate();
        }
    }

    public void setFoldLineMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3);
        } else {
            this.f147198m = i3;
        }
    }

    public void setHilightFakeBold(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, z16);
            return;
        }
        this.F0 = z16;
        this.N.setFakeBoldText(this.F0);
        invalidate();
    }

    public void setHilightLineHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, i3);
        } else {
            this.C = i3;
        }
    }

    public void setHilightTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, i3);
        } else {
            this.E = i3;
            this.N.setColor(i3);
        }
    }

    public void setHilightTextSizeNotInvalidate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
            return;
        }
        this.D = i3;
        this.N.setTextSize(i3);
        this.P.setTextSize(this.D);
        this.Q.setTextSize(this.D);
        this.S.setTextSize(this.D);
    }

    public void setHilightThinTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, i3);
        } else {
            this.G = i3;
            this.P.setColor(i3);
        }
    }

    public void setIsHilightLiteratim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
        } else {
            this.A0 = z16;
        }
    }

    public void setLeftAlign(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
        } else {
            this.J = z16;
            y();
        }
    }

    public void setLineHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, i3);
        } else {
            this.f147191h = i3;
        }
    }

    public void setLineMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
        } else {
            this.f147193i = i3;
        }
    }

    public void setLyric(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        Log.i("ModuleLyricViewInternal", "setLyric begin");
        this.f147205s0 = true;
        z();
        this.f147209w0 = false;
        if (aVar != null) {
            h();
            com.tencent.lyric.data.a aVar3 = new com.tencent.lyric.data.a(2, 0, null);
            aVar3.a(aVar);
            this.U = aVar3;
            if (aVar2 != null && aVar.v() == aVar2.v()) {
                com.tencent.lyric.data.a aVar4 = new com.tencent.lyric.data.a(2, 0, null);
                aVar4.a(aVar2);
                this.V = aVar4;
            } else {
                Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
                this.V = new com.tencent.lyric.data.a(2, 0, null);
            }
            this.M0 = o(this.U);
            Log.w("ModuleLyricViewInternal", "setLyric -> is special qrc:" + this.M0);
            setState(70);
        } else {
            Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
            setState(40);
        }
        this.f147205s0 = false;
        Log.i("ModuleLyricViewInternal", "setLyric end");
    }

    public void setLyricFontSize(HashMap<String, Float> hashMap) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) hashMap);
            return;
        }
        if (hashMap == null) {
            Log.i("ModuleLyricViewInternal", "setLyricFontSize fontSizeMap is null");
            return;
        }
        float f27 = -1.0f;
        if (hashMap.containsKey("hilight_font_size")) {
            f16 = hashMap.get("hilight_font_size").floatValue();
        } else {
            f16 = -1.0f;
        }
        if (hashMap.containsKey("ordinary_font_size")) {
            f17 = hashMap.get("ordinary_font_size").floatValue();
        } else {
            f17 = -1.0f;
        }
        if (f17 > 0.0f) {
            setOrdinaryTextSizeNotInvalidate((int) f17);
        }
        if (f16 > 0.0f) {
            setHilightTextSizeNotInvalidate((int) f16);
        }
        if (hashMap.containsKey("ordinary_font_line_height")) {
            f18 = hashMap.get("ordinary_font_line_height").floatValue();
        } else {
            f18 = -1.0f;
        }
        if (f18 > 0.0f) {
            setLineHeight((int) f18);
        }
        if (hashMap.containsKey("hilight_font_line_height")) {
            f19 = hashMap.get("hilight_font_line_height").floatValue();
        } else {
            f19 = -1.0f;
        }
        if (f19 > 0.0f) {
            setHilightLineHeight((int) f19);
        }
        if (hashMap.containsKey("lyric_up_space")) {
            f26 = hashMap.get("lyric_up_space").floatValue();
        } else {
            f26 = -1.0f;
        }
        if (f26 > 0.0f) {
            setUpSpace((int) f26);
        }
        if (hashMap.containsKey("lyric_margin_line")) {
            f27 = hashMap.get("lyric_margin_line").floatValue();
        }
        if (f27 > 0.0f) {
            setLineMargin((int) f27);
        }
    }

    public void setLyricPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, i3);
        } else {
            this.E0 = i3;
            y();
        }
    }

    public void setMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
        } else {
            this.f147212z0 = i3;
        }
    }

    public void setOrdinaryTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, i3);
        } else {
            this.f147183e = i3;
            this.M.setColor(i3);
        }
    }

    public void setOrdinaryTextSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
        } else {
            setOrdinaryTextSizeNotInvalidate(i3);
            invalidate();
        }
    }

    public void setOrdinaryTextSizeNotInvalidate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
            return;
        }
        this.f147180d = i3;
        float f16 = i3;
        this.M.setTextSize(f16);
        this.R.setTextSize(f16);
    }

    @Override // com.tencent.lyric.widget.b
    public void setSegment(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 >= 0 && i16 > i3) {
            com.tencent.lyric.data.a aVar = this.U;
            if (aVar != null && !aVar.t()) {
                if (this.f147196k0 == i3 && this.f147197l0 == i16) {
                    Log.i("ModuleLyricViewInternal", "setSegment -> same start and end");
                    return;
                }
                this.f147196k0 = i3;
                this.f147197l0 = i16;
                this.f147199m0 = this.U.d(i3);
                int b16 = this.U.b(i16);
                this.f147200n0 = b16;
                if (this.f147199m0 >= 0 && b16 >= 0) {
                    this.f147195j0 = true;
                    this.f147209w0 = false;
                    this.N.setTextSize(this.D);
                    this.P.setTextSize(this.D);
                    this.Q.setTextSize(this.D);
                    this.S.setTextSize(this.D);
                    this.M.setTextSize(this.f147180d);
                    y();
                    return;
                }
                Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
                this.f147195j0 = false;
                return;
            }
            Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
            return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
    }

    @Override // com.tencent.lyric.widget.b
    public void setShadowEffectExt(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f147179c1 = i3;
        this.f147182d1 = i16;
        this.f147185e1 = i17;
        this.f147188f1 = i18;
    }

    @Override // com.tencent.lyric.widget.b
    public void setShowLineNumber(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, i3);
            return;
        }
        this.C0 = i3;
        if (i3 < 1) {
            this.C0 = 1;
        }
    }

    public void setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
        } else {
            this.f147176b0 = i3;
            this.X0.sendEmptyMessage(0);
        }
    }

    public void setUpSpace(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, boolean z16) {
        Paint paint;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (z16) {
            paint = this.N;
        } else {
            paint = this.M;
        }
        if (z16) {
            boolean z17 = this.B0;
        }
        if (z16) {
            i17 = this.C;
        } else {
            i17 = this.f147191h;
        }
        int i18 = i17 + this.f147193i;
        for (int i19 = 0; i19 < f16.size(); i19++) {
            f16.get(i19).i(canvas, i3, i16 + this.f147193i, paint, z16);
            i16 += i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void u(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            v(eVar, canvas, i3, i16, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    public synchronized void v(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, boolean z16, Paint paint) {
        ArrayList<com.tencent.lyric.data.f> arrayList;
        boolean z17;
        int i17;
        int i18;
        int i19;
        Paint paint2;
        char c16;
        boolean z18;
        int i26;
        int i27;
        int i28;
        ArrayList<com.tencent.lyric.data.b> arrayList2;
        com.tencent.lyric.data.f fVar;
        float f16;
        float f17;
        int i29;
        ?? r122;
        float measureText;
        int i36;
        float measureText2;
        com.tencent.lyric.data.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 2;
        boolean z19 = true;
        boolean z26 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), paint);
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f18 = eVar.f();
        int size = f18.size();
        int i37 = this.f147202p0;
        Paint paint3 = this.N;
        boolean z27 = this.B0;
        int i38 = i16;
        int i39 = 0;
        while (i39 < size) {
            com.tencent.lyric.data.f fVar2 = f18.get(i39);
            ArrayList<com.tencent.lyric.data.b> arrayList3 = fVar2.f147080d;
            if (arrayList3 != null && arrayList3.size() > 0) {
                ArrayList<com.tencent.lyric.data.b> arrayList4 = fVar2.f147080d;
                int size2 = arrayList4.size();
                int length = fVar2.f147077a.length();
                if (i39 == 0) {
                    i26 = this.f147193i;
                } else {
                    i26 = this.f147198m;
                }
                int i46 = i26;
                if (n()) {
                    i27 = length;
                    i28 = size2;
                    arrayList2 = arrayList4;
                    arrayList = f18;
                    fVar = fVar2;
                    fVar2.b(canvas, i3, i38 + i46, this.S, this.N0, true);
                } else {
                    arrayList = f18;
                    i27 = length;
                    i28 = size2;
                    arrayList2 = arrayList4;
                    fVar = fVar2;
                }
                long j3 = i37;
                if (fVar.f147081e <= j3 && fVar.f147082f >= j3) {
                    int i47 = 0;
                    int i48 = 0;
                    com.tencent.lyric.data.b bVar2 = null;
                    while (i47 < i28) {
                        bVar2 = arrayList2.get(i47);
                        if (i47 < i28 - 1) {
                            bVar = arrayList2.get(i47 + 1);
                            i29 = i47;
                        } else {
                            i29 = i47;
                            bVar = null;
                        }
                        long j16 = bVar2.f147062a;
                        if (j16 <= j3 && bVar != null) {
                            i17 = size;
                            i18 = i37;
                            if (bVar.f147062a > j3) {
                                f16 = ((float) (j3 - j16)) / ((float) bVar2.f147063b);
                                f17 = f16;
                                break;
                            }
                        } else {
                            i17 = size;
                            i18 = i37;
                        }
                        if (j16 <= j3) {
                            long j17 = bVar2.f147063b;
                            if (j16 + j17 >= j3) {
                                f16 = ((float) (j3 - j16)) / ((float) j17);
                                f17 = f16;
                                break;
                            }
                        }
                        i47 = i29 + 1;
                        i48 = i29;
                        size = i17;
                        i37 = i18;
                    }
                    i17 = size;
                    i18 = i37;
                    f16 = 0.0f;
                    f17 = 0.0f;
                    i29 = i48;
                    if (bVar2 != null) {
                        float f19 = i3;
                        if (i29 != 0) {
                            int i49 = i29 - 1;
                            try {
                                if (i27 >= arrayList2.get(i49).f147065d) {
                                    measureText2 = this.N.measureText(fVar.f147077a.substring(0, arrayList2.get(i49).f147065d));
                                } else {
                                    measureText2 = this.N.measureText(fVar.f147077a.substring(0, i27));
                                }
                            } catch (StringIndexOutOfBoundsException unused) {
                                measureText2 = this.N.measureText(fVar.f147077a.substring(0, i27));
                            }
                            f19 += measureText2;
                        }
                        float f26 = f19;
                        if (i29 == i28 - 1) {
                            try {
                                measureText = this.Q.measureText(fVar.f147077a.substring(bVar2.f147064c, i27));
                            } catch (StringIndexOutOfBoundsException unused2) {
                                r122 = 0;
                                measureText = this.Q.measureText(fVar.f147077a.substring(0, i27));
                                i36 = 2;
                            }
                        } else {
                            int length2 = fVar.f147077a.length();
                            int i56 = bVar2.f147065d;
                            if (length2 >= i56) {
                                measureText = this.Q.measureText(fVar.f147077a.substring(bVar2.f147064c, i56));
                            } else {
                                measureText = this.Q.measureText(fVar.f147077a.substring(bVar2.f147064c, i27));
                            }
                        }
                        i36 = 2;
                        r122 = 0;
                        int[] iArr = new int[i36];
                        iArr[r122] = paint3.getColor();
                        z17 = true;
                        iArr[1] = this.P.getColor();
                        c16 = 2;
                        float[] fArr = new float[2];
                        fArr[r122] = f16;
                        fArr[1] = f17;
                        z18 = r122;
                        i19 = i39;
                        paint2 = paint3;
                        fVar.h(canvas, i3, i38 + i46, this.P, paint3, this.Q, i29, measureText, f26, iArr, fArr, paint, z16, this.f147175a1);
                    } else {
                        i19 = i39;
                        paint2 = paint3;
                        c16 = 2;
                        z18 = false;
                        z17 = true;
                    }
                } else {
                    i17 = size;
                    i18 = i37;
                    i19 = i39;
                    paint2 = paint3;
                    c16 = 2;
                    z18 = false;
                    z17 = true;
                    if (fVar.d() < j3) {
                        fVar.k(canvas, i3, i38 + i46, paint2, true, z16, paint);
                    } else {
                        if (i19 == 0) {
                            fVar.a(canvas, i3, i38 + i46, this.P, true);
                        }
                        fVar.k(canvas, i3, i38 + i46, this.P, true, z16, paint);
                    }
                }
                i38 += i46 + this.C;
                i39 = i19 + 1;
                f18 = arrayList;
                c17 = c16;
                z26 = z18;
                paint3 = paint2;
                z19 = z17;
                size = i17;
                i37 = i18;
            }
            arrayList = f18;
            z17 = z19;
            i17 = size;
            i18 = i37;
            i19 = i39;
            paint2 = paint3;
            c16 = c17;
            z18 = z26;
            i39 = i19 + 1;
            f18 = arrayList;
            c17 = c16;
            z26 = z18;
            paint3 = paint2;
            z19 = z17;
            size = i17;
            i37 = i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, boolean z16) {
        Paint paint;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (z16) {
            paint = this.N;
        } else {
            paint = this.M;
        }
        if (z16) {
            boolean z17 = this.B0;
        }
        if (z16) {
            i17 = this.C + this.f147190g1;
        } else {
            i17 = this.f147191h;
        }
        int i18 = i17 + this.f147193i;
        for (int i19 = 0; i19 < f16.size(); i19++) {
            f16.get(i19).i(canvas, i3, i16 + this.f147193i, paint, z16);
            i16 += i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        int i17 = this.f147191h + this.f147193i;
        int i18 = i16;
        for (int i19 = 0; i19 < f16.size(); i19++) {
            f16.get(i19).o(canvas, i3, i18 + this.f147193i, paint, paint2, z16, false, null);
            i18 += i17;
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
        } else {
            this.f147209w0 = false;
            this.X0.sendEmptyMessage(0);
        }
    }

    protected void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.P.setColor(this.G);
        this.N.setColor(this.E);
        this.M.setColor(this.f147183e);
    }

    @SuppressLint({"NewApi"})
    public LyricViewInternalBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.L = 1;
        this.M = new Paint();
        this.N = new Paint();
        this.P = new Paint();
        this.Q = new Paint();
        this.R = new Paint();
        this.S = new Paint();
        this.T = 0;
        this.f147176b0 = 0;
        this.f147178c0 = -1;
        this.f147181d0 = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        this.f147184e0 = -1;
        this.f147187f0 = null;
        this.f147196k0 = -1;
        this.f147197l0 = -1;
        this.f147199m0 = 0;
        this.f147200n0 = 0;
        this.f147201o0 = 0;
        this.f147202p0 = 0;
        this.f147203q0 = 0;
        this.f147204r0 = new Object();
        this.f147205s0 = true;
        this.f147206t0 = 0L;
        this.f147212z0 = 0;
        this.C0 = -1;
        this.E0 = -1;
        this.H0 = 0;
        this.I0 = 0;
        this.N0 = 1;
        this.Q0 = new Paint();
        this.R0 = new Paint();
        this.W0 = false;
        this.X0 = new a(Looper.getMainLooper());
        this.f147175a1 = com.tencent.lyric.util.d.f147092b;
        this.f147177b1 = false;
        this.f147189g0 = context;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        this.f147194i0 = point.x;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f147192h0 = displayMetrics.density;
        this.W = "";
        this.f147174a0 = new Scroller(context, new AccelerateDecelerateInterpolator());
    }
}
