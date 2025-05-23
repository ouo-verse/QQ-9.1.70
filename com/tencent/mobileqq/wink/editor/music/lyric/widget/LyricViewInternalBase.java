package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import common.config.service.QzoneConfig;
import d73.e;
import d73.f;
import d73.g;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class LyricViewInternalBase extends View implements com.tencent.mobileqq.wink.editor.music.lyric.widget.a {
    protected boolean A0;
    protected Paint B0;
    protected final String C;
    protected Paint C0;
    public int D;
    Bitmap D0;
    public boolean E;
    Context E0;
    protected int F;
    protected int G;
    protected boolean H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    protected int P;
    protected int Q;
    protected d73.b R;
    protected d73.b S;
    protected Scroller T;
    protected int U;
    protected final Handler V;
    protected int W;

    /* renamed from: a0, reason: collision with root package name */
    protected int f321046a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f321047b0;

    /* renamed from: c0, reason: collision with root package name */
    protected volatile boolean f321048c0;

    /* renamed from: d, reason: collision with root package name */
    protected final Paint f321049d;

    /* renamed from: d0, reason: collision with root package name */
    protected int f321050d0;

    /* renamed from: e, reason: collision with root package name */
    protected final Paint f321051e;

    /* renamed from: e0, reason: collision with root package name */
    protected int f321052e0;

    /* renamed from: f, reason: collision with root package name */
    protected final Paint f321053f;

    /* renamed from: f0, reason: collision with root package name */
    protected int f321054f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f321055g0;

    /* renamed from: h, reason: collision with root package name */
    protected final Paint f321056h;

    /* renamed from: h0, reason: collision with root package name */
    protected int f321057h0;

    /* renamed from: i, reason: collision with root package name */
    protected final Paint f321058i;

    /* renamed from: i0, reason: collision with root package name */
    protected int f321059i0;

    /* renamed from: j0, reason: collision with root package name */
    protected volatile int f321060j0;

    /* renamed from: k0, reason: collision with root package name */
    protected volatile boolean f321061k0;

    /* renamed from: l0, reason: collision with root package name */
    protected volatile boolean f321062l0;

    /* renamed from: m, reason: collision with root package name */
    protected final Paint f321063m;

    /* renamed from: m0, reason: collision with root package name */
    protected int f321064m0;

    /* renamed from: n0, reason: collision with root package name */
    protected volatile boolean f321065n0;

    /* renamed from: o0, reason: collision with root package name */
    protected int f321066o0;

    /* renamed from: p0, reason: collision with root package name */
    protected volatile boolean f321067p0;

    /* renamed from: q0, reason: collision with root package name */
    protected volatile int f321068q0;

    /* renamed from: r0, reason: collision with root package name */
    protected volatile boolean f321069r0;

    /* renamed from: s0, reason: collision with root package name */
    protected volatile boolean f321070s0;

    /* renamed from: t0, reason: collision with root package name */
    protected int f321071t0;

    /* renamed from: u0, reason: collision with root package name */
    protected int f321072u0;

    /* renamed from: v0, reason: collision with root package name */
    protected int f321073v0;

    /* renamed from: w0, reason: collision with root package name */
    protected volatile boolean f321074w0;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f321075x0;

    /* renamed from: y0, reason: collision with root package name */
    protected int f321076y0;

    /* renamed from: z0, reason: collision with root package name */
    protected int f321077z0;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("ModuleLyricViewInternal", "mRefreshHandler -> handleMessage begin, mState:" + LyricViewInternalBase.this.U);
            LyricViewInternalBase.this.requestLayout();
            LyricViewInternalBase.this.invalidate();
        }
    }

    public LyricViewInternalBase(Context context) {
        this(context, null);
    }

    protected static boolean k(d73.b bVar) {
        ArrayList<e> arrayList;
        if (bVar == null || bVar.f393161a != 2 || (arrayList = bVar.f393162b) == null) {
            return false;
        }
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<d73.a> arrayList2 = it.next().f393186g;
            if (arrayList2 == null || arrayList2.size() != 1) {
                return false;
            }
        }
        return true;
    }

    private void t(d73.b bVar, d73.b bVar2) {
        if (bVar != null) {
            r();
            d73.b bVar3 = new d73.b(2, 0, null);
            bVar3.a(bVar);
            this.R = bVar3;
            if (bVar2 != null && bVar.l() == bVar2.l()) {
                d73.b bVar4 = new d73.b(2, 0, null);
                bVar4.a(bVar2);
                this.S = bVar4;
            } else {
                this.S = new d73.b(2, 0, null);
            }
            setState(70);
            return;
        }
        setState(40);
        this.R = new d73.b(2, 0, null);
        this.S = new d73.b(2, 0, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int a(int i3) {
        this.f321062l0 = true;
        return this.f321057h0;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int b(int i3) {
        int i16 = this.f321057h0;
        this.f321062l0 = false;
        return i16;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public d73.b c() {
        return this.R;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int d() {
        return this.f321060j0;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public void e(int i3, int i16) {
        this.f321057h0 = i3;
        this.f321059i0 = i16;
        u();
        postInvalidate();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public int f() {
        return 0;
    }

    protected void h(Canvas canvas, Paint paint, String str, int i3, int i16) {
        Log.d("ModuleLyricViewInternal", "drawString -> str:" + str + ", y:" + i16);
        Rect rect = new Rect();
        String[] split = str.split("\n");
        int i17 = this.J;
        for (int i18 = 0; i18 < split.length; i18++) {
            canvas.drawText(split[i18], ((getWidth() - ((int) this.f321049d.measureText(split[i18]))) >> 1) + i3, i16 + i17, paint);
            String str2 = split[i18];
            paint.getTextBounds(str2, 0, str2.length(), rect);
            i17 += rect.height() + 20;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i() {
        if (this.W == -1) {
            this.W = this.f321073v0;
        }
        return this.W;
    }

    public void j(c cVar) {
        this.R = new d73.b(2, 0, null);
        this.S = new d73.b(2, 0, null);
        this.K = cVar.f321109j;
        this.I = cVar.f321103d;
        this.J = cVar.f321108i;
        this.M = cVar.f321104e;
        this.N = cVar.f321105f;
        this.P = cVar.f321106g;
        this.L = cVar.f321107h;
        this.G = cVar.f321101b;
        this.F = cVar.f321100a;
        this.H = cVar.f321102c;
        this.f321069r0 = cVar.f321111l;
        this.D = cVar.f321112m;
        this.E = cVar.f321113n;
        this.f321074w0 = cVar.f321114o;
        this.f321073v0 = cVar.f321110k;
        this.f321053f.setAntiAlias(true);
        this.f321053f.setTextSize(this.M);
        this.f321053f.setColor(this.P);
        this.f321056h.setAntiAlias(true);
        this.f321056h.setTextSize(this.M);
        this.f321056h.setColor(this.N);
        this.f321051e.setAntiAlias(true);
        this.f321051e.setTextSize(this.M);
        this.f321051e.setColor(this.N);
        this.f321051e.setFakeBoldText(this.f321074w0);
        this.f321049d.setAntiAlias(true);
        this.f321049d.setTextSize(this.F);
        this.f321049d.setColor(this.G);
        this.f321049d.setFakeBoldText(this.H);
        this.f321058i.setAntiAlias(true);
        this.f321058i.setTextSize(this.F);
        this.f321058i.setFakeBoldText(this.H);
        this.f321058i.setStrokeWidth(1.0f);
        this.f321058i.setColor(0);
        this.f321058i.setStyle(Paint.Style.STROKE);
        this.f321058i.setAlpha(19);
        this.f321063m.setAntiAlias(true);
        this.f321063m.setTextSize(this.M);
        this.f321063m.setColor(0);
        this.f321063m.setStrokeWidth(2.0f);
        this.f321063m.setStyle(Paint.Style.STROKE);
        this.f321063m.setAlpha(19);
        this.B0.setColor(cVar.f321117r);
        this.B0.setStyle(Paint.Style.FILL);
        this.C0.setColor(cVar.f321115p);
        this.C0.setTextSize(cVar.f321116q);
        this.B0.setColor(cVar.f321117r);
        this.Q = cVar.f321118s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l(e eVar, Canvas canvas, int i3, int i16, boolean z16) {
        Paint paint;
        ArrayList<g> d16 = eVar.d();
        if (z16) {
            paint = this.f321051e;
        } else {
            paint = this.f321049d;
        }
        int i17 = this.I + this.J;
        for (int i18 = 0; i18 < d16.size(); i18++) {
            d16.get(i18).f(canvas, i3, i16 + this.J, paint, z16);
            i16 += i17;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(e eVar, Canvas canvas, int i3, int i16, Paint paint) {
        ArrayList<g> d16 = eVar.d();
        int i17 = this.I + this.J;
        for (int i18 = 0; i18 < d16.size(); i18++) {
            d16.get(i18).f(canvas, i3, i16 + this.J, paint, false);
            i16 += i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0133 A[Catch: StringIndexOutOfBoundsException -> 0x015b, all -> 0x01ef, TryCatch #0 {StringIndexOutOfBoundsException -> 0x015b, blocks: (B:68:0x0124, B:58:0x0133, B:60:0x013d, B:66:0x014c), top: B:67:0x0124, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void n(e eVar, Canvas canvas, int i3, int i16) {
        ArrayList<g> arrayList;
        int i17;
        int i18;
        int i19;
        Paint paint;
        int i26;
        int i27;
        float f16;
        float f17;
        float measureText;
        float measureText2;
        int i28;
        d73.a aVar;
        f fVar;
        ArrayList<g> d16 = eVar.d();
        int size = d16.size();
        int i29 = this.f321059i0;
        Paint paint2 = this.f321051e;
        if (this.f321070s0 && (fVar = eVar.f393184e) != null) {
            paint2.setColor(fVar.f393189c);
        }
        int i36 = i16;
        int i37 = 0;
        while (i37 < size) {
            g gVar = d16.get(i37);
            ArrayList<d73.a> arrayList2 = gVar.f393196f;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList<d73.a> arrayList3 = gVar.f393196f;
                int size2 = arrayList3.size();
                int length = gVar.f393191a.length();
                if (i37 == 0) {
                    i26 = this.J;
                } else {
                    i26 = this.K;
                }
                int i38 = i26;
                if (this.f321075x0) {
                    i27 = length;
                    gVar.b(canvas, i3, i36 + i38, this.f321063m, true);
                } else {
                    i27 = length;
                }
                long j3 = i29;
                if (gVar.d() <= j3 && gVar.c() >= j3) {
                    int i39 = 0;
                    int i46 = 0;
                    d73.a aVar2 = null;
                    while (i39 < size2) {
                        aVar2 = arrayList3.get(i39);
                        if (i39 < size2 - 1) {
                            aVar = arrayList3.get(i39 + 1);
                            i28 = i39;
                        } else {
                            i28 = i39;
                            aVar = null;
                        }
                        long j16 = aVar2.f393157a;
                        if (j16 <= j3 && aVar != null) {
                            i17 = size;
                            i18 = i29;
                            if (aVar.f393157a > j3) {
                                f16 = ((float) (j3 - j16)) / ((float) aVar2.f393158b);
                                f17 = f16;
                                i46 = i28;
                                break;
                            }
                        } else {
                            i17 = size;
                            i18 = i29;
                        }
                        if (j16 <= j3) {
                            long j17 = aVar2.f393158b;
                            if (j16 + j17 >= j3) {
                                f16 = ((float) (j3 - j16)) / ((float) j17);
                                f17 = f16;
                                i46 = i28;
                                break;
                            }
                        }
                        i39 = i28 + 1;
                        i46 = i28;
                        size = i17;
                        i29 = i18;
                    }
                    i17 = size;
                    i18 = i29;
                    f16 = 0.0f;
                    f17 = 0.0f;
                    if (aVar2 != null) {
                        float f18 = i3;
                        if (i46 != 0) {
                            int i47 = i46 - 1;
                            try {
                                if (i27 >= arrayList3.get(i47).f393160d) {
                                    arrayList = d16;
                                    try {
                                        measureText2 = this.f321051e.measureText(gVar.f393191a.substring(0, arrayList3.get(i47).f393160d));
                                    } catch (StringIndexOutOfBoundsException unused) {
                                        measureText2 = this.f321051e.measureText(gVar.f393191a.substring(0, i27));
                                        f18 += measureText2;
                                        float f19 = f18;
                                        if (i46 != size2 - 1) {
                                        }
                                        float[] fArr = {f16, f17};
                                        i19 = i37;
                                        paint = paint2;
                                        gVar.e(canvas, i3, i36 + i38, this.f321053f, paint2, this.f321056h, i46, measureText, f19, new int[]{paint2.getColor(), this.f321053f.getColor()}, fArr);
                                        i36 += i38 + this.L;
                                        i37 = i19 + 1;
                                        d16 = arrayList;
                                        size = i17;
                                        i29 = i18;
                                        paint2 = paint;
                                    }
                                } else {
                                    arrayList = d16;
                                    measureText2 = this.f321051e.measureText(gVar.f393191a.substring(0, i27));
                                }
                            } catch (StringIndexOutOfBoundsException unused2) {
                                arrayList = d16;
                            }
                            f18 += measureText2;
                        } else {
                            arrayList = d16;
                        }
                        float f192 = f18;
                        if (i46 != size2 - 1) {
                            try {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(aVar2.f393159c, i27));
                            } catch (StringIndexOutOfBoundsException unused3) {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(0, i27));
                            }
                        } else {
                            int length2 = gVar.f393191a.length();
                            int i48 = aVar2.f393160d;
                            if (length2 >= i48) {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(aVar2.f393159c, i48));
                            } else {
                                measureText = this.f321056h.measureText(gVar.f393191a.substring(aVar2.f393159c, i27));
                            }
                        }
                        float[] fArr2 = {f16, f17};
                        i19 = i37;
                        paint = paint2;
                        gVar.e(canvas, i3, i36 + i38, this.f321053f, paint2, this.f321056h, i46, measureText, f192, new int[]{paint2.getColor(), this.f321053f.getColor()}, fArr2);
                    } else {
                        arrayList = d16;
                        i19 = i37;
                        paint = paint2;
                    }
                } else {
                    arrayList = d16;
                    i17 = size;
                    i18 = i29;
                    i19 = i37;
                    paint = paint2;
                    if (gVar.c() < j3) {
                        gVar.f(canvas, i3, i36 + i38, paint, true);
                    } else {
                        gVar.f(canvas, i3, i36 + i38, this.f321053f, true);
                    }
                }
                i36 += i38 + this.L;
                i37 = i19 + 1;
                d16 = arrayList;
                size = i17;
                i29 = i18;
                paint2 = paint;
            }
            arrayList = d16;
            i17 = size;
            i18 = i29;
            i19 = i37;
            paint = paint2;
            i37 = i19 + 1;
            d16 = arrayList;
            size = i17;
            i29 = i18;
            paint2 = paint;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(e eVar, Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16) {
        ArrayList<g> d16 = eVar.d();
        int i17 = this.I + this.J;
        int i18 = i16;
        for (int i19 = 0; i19 < d16.size(); i19++) {
            d16.get(i19).g(canvas, i3, i18 + this.J, paint, paint2, z16);
            i18 += i17;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.U != 70) {
            if (this.C != null) {
                scrollTo(0, 0);
                this.T.setFinalX(0);
                h(canvas, this.f321049d, this.C, 0, this.Q);
                return;
            }
            return;
        }
        g(canvas, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int j3;
        d73.b bVar;
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.U == 70) {
            int i17 = measuredWidth - (i() << 1);
            int i18 = this.I + this.J;
            if (this.E) {
                this.R.h(this.f321051e, this.f321049d, i17, false, true);
            } else {
                this.R.f(this.f321051e, this.f321049d, i17);
            }
            if (this.S != null && this.R.l() == this.S.l()) {
                if (this.E) {
                    this.S.h(this.f321051e, this.f321049d, i17, false, true);
                } else {
                    this.S.f(this.f321051e, this.f321049d, i17);
                }
            }
            if (this.f321048c0) {
                j3 = 0;
                for (int i19 = this.f321054f0; i19 <= this.f321055g0; i19++) {
                    if (this.R.f393162b.get(i19) != null) {
                        j3 += this.R.f393162b.get(i19).c();
                    }
                }
            } else {
                j3 = this.R.j();
            }
            if (this.f321067p0 && (bVar = this.S) != null && bVar.f393162b != null) {
                if (this.f321048c0) {
                    for (int i26 = this.f321054f0; i26 <= this.f321055g0; i26++) {
                        if (i26 < this.S.f393162b.size() && i26 >= 0) {
                            j3 += this.S.f393162b.get(i26).c();
                        }
                    }
                } else {
                    j3 += this.S.j();
                }
            }
            this.f321046a0 = j3 * i18;
            this.f321072u0 = (measuredHeight / (this.J + this.I)) + 1;
            Log.d("ModuleLyricViewInternal", "onMeasure -> Show line count:" + this.f321072u0);
            setMeasuredDimension(measuredWidth, this.f321046a0 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void p() {
        this.f321065n0 = false;
        this.V.sendEmptyMessage(0);
    }

    protected void q() {
        this.f321053f.setColor(this.P);
        this.f321051e.setColor(this.N);
        this.f321049d.setColor(this.G);
    }

    public void r() {
        this.f321048c0 = false;
        this.f321050d0 = -1;
        this.f321052e0 = -1;
        this.f321054f0 = 0;
        this.f321055g0 = 0;
        this.f321065n0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void s(d73.b bVar, d73.b bVar2) {
        boolean z16 = this.f321048c0;
        int i3 = this.f321050d0;
        int i16 = this.f321052e0;
        t(bVar, bVar2);
        if (z16) {
            setSegment(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public void setEffectEnable(boolean z16) {
        this.f321075x0 = z16;
        invalidate();
    }

    public void setLeftAlign(boolean z16) {
        this.E = z16;
        p();
    }

    public void setLineHeight(int i3) {
        this.I = i3;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.a
    public void setLyric(d73.b bVar, d73.b bVar2) {
        Log.d("ModuleLyricViewInternal", "setLyric begin");
        this.f321061k0 = true;
        q();
        this.f321065n0 = false;
        if (bVar != null) {
            r();
            d73.b bVar3 = new d73.b(2, 0, null);
            bVar3.a(bVar);
            this.R = bVar3;
            if (bVar2 != null && bVar.l() == bVar2.l()) {
                d73.b bVar4 = new d73.b(2, 0, null);
                bVar4.a(bVar2);
                this.S = bVar4;
            } else {
                Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
                this.S = new d73.b(2, 0, null);
            }
            this.A0 = k(this.R);
            Log.w("ModuleLyricViewInternal", "setLyric -> is special qrc:" + this.A0);
            setState(70);
        } else {
            Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
            setState(40);
        }
        this.f321061k0 = false;
        Log.d("ModuleLyricViewInternal", "setLyric end");
    }

    public void setLyricPadding(int i3) {
        this.f321073v0 = i3;
        p();
    }

    public void setMode(int i3) {
        this.f321068q0 = i3;
    }

    public void setSegment(int i3, int i16) {
        if (i3 >= 0 && i16 > i3) {
            d73.b bVar = this.R;
            if (bVar != null && !bVar.k()) {
                if (this.f321050d0 == i3 && this.f321052e0 == i16) {
                    Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
                    return;
                }
                this.f321050d0 = i3;
                this.f321052e0 = i16;
                this.f321054f0 = this.R.d(i3);
                int b16 = this.R.b(i16);
                this.f321055g0 = b16;
                if (this.f321054f0 >= 0 && b16 >= 0) {
                    this.f321048c0 = true;
                    this.f321065n0 = false;
                    return;
                } else {
                    Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
                    this.f321048c0 = false;
                    return;
                }
            }
            Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
            return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
    }

    public void setState(int i3) {
        this.U = i3;
        this.V.sendEmptyMessage(0);
    }

    public void setTypeface(Typeface typeface) {
        Paint paint = this.f321049d;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        Paint paint2 = this.f321051e;
        if (paint2 != null) {
            paint2.setTypeface(typeface);
        }
        Paint paint3 = this.f321053f;
        if (paint3 != null) {
            paint3.setTypeface(typeface);
        }
        Paint paint4 = this.f321056h;
        if (paint4 != null) {
            paint4.setTypeface(typeface);
        }
        Paint paint5 = this.f321058i;
        if (paint5 != null) {
            paint5.setTypeface(typeface);
        }
        Paint paint6 = this.f321063m;
        if (paint6 != null) {
            paint6.setTypeface(typeface);
        }
    }

    public abstract void u();

    @SuppressLint({"NewApi"})
    public LyricViewInternalBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f321049d = new Paint();
        this.f321051e = new Paint();
        this.f321053f = new Paint();
        this.f321056h = new Paint();
        this.f321058i = new Paint();
        this.f321063m = new Paint();
        this.U = 0;
        this.V = new a(Looper.getMainLooper());
        this.W = -1;
        this.f321046a0 = QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
        this.f321047b0 = -1;
        this.f321050d0 = -1;
        this.f321052e0 = -1;
        this.f321054f0 = 0;
        this.f321055g0 = 0;
        this.f321057h0 = 0;
        this.f321059i0 = 0;
        this.f321060j0 = 0;
        this.f321061k0 = true;
        this.f321068q0 = 0;
        this.f321071t0 = -1;
        this.f321073v0 = -1;
        this.f321075x0 = true;
        this.f321076y0 = 0;
        this.f321077z0 = 0;
        this.B0 = new Paint();
        this.C0 = new Paint();
        this.D0 = null;
        this.E0 = context;
        this.C = "";
        this.T = new Scroller(context, new AccelerateDecelerateInterpolator());
    }

    protected void g(Canvas canvas, int i3) {
    }
}
