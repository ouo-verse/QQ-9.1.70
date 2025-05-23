package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewInternalFeedTriple extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    private volatile boolean f147223h1;

    /* renamed from: i1, reason: collision with root package name */
    private volatile boolean f147224i1;

    /* renamed from: j1, reason: collision with root package name */
    public LyricViewScroll.b f147225j1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements LyricViewScroll.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternalFeedTriple.this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LyricViewInternalFeedTriple.this.f147223h1 = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LyricViewInternalFeedTriple.this.f147223h1 = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public LyricViewInternalFeedTriple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147223h1 = false;
        this.f147224i1 = true;
        this.f147225j1 = new a();
        this.f147210x0 = this.f147191h;
    }

    private int F(int i3) {
        int i16;
        int i17;
        com.tencent.lyric.data.a aVar;
        com.tencent.lyric.data.a aVar2 = this.U;
        int i18 = 0;
        if (aVar2 != null && !aVar2.t()) {
            int v3 = this.U.v() - 1;
            if (this.f147195j0) {
                i17 = this.f147199m0;
                i16 = this.f147200n0;
            } else {
                i16 = v3;
                i17 = 0;
            }
            while (i17 <= i16) {
                int e16 = this.U.f147056b.get(i17).e();
                i18 += (this.f147191h * e16) + (this.f147198m * (e16 - 1)) + this.f147193i;
                if (this.f147211y0 && (aVar = this.V) != null && aVar.v() == this.U.v()) {
                    int e17 = this.V.f147056b.get(i17).e();
                    i18 += (this.f147191h * e17) + (this.f147198m * (e17 - 1)) + this.f147193i;
                }
                if (i3 < i18) {
                    return i17;
                }
                i17++;
            }
            return i16;
        }
        Log.e("LyricViewFeedTriple", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    protected void G(Canvas canvas, int i3, int i16, boolean z16, int i17) {
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i17 < arrayList.size() && i17 >= 0) {
            if (z16 && !this.f147207u0) {
                if (this.A0 && this.V.f147055a == 2 && !this.M0) {
                    u(arrayList.get(i17), canvas, i3, i16);
                    return;
                } else {
                    w(arrayList.get(i17), canvas, i3, i16, true);
                    return;
                }
            }
            if (n()) {
                x(arrayList.get(i17), canvas, i3, i16, this.M, this.R, true);
            } else {
                q(arrayList.get(i17), canvas, i3, i16, this.M);
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        super.a(i3);
        int F = F(i3 + this.f147210x0);
        postInvalidate();
        return F;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        super.b(i3);
        int F = F(i3 + this.f147210x0);
        postInvalidate();
        return F;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        int i3;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f147176b0 != 70) {
            return;
        }
        int i16 = 0;
        this.f147224i1 = false;
        int i17 = this.f147191h + this.f147193i;
        int i18 = this.f147201o0;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        if (arrayList2 == null) {
            return;
        }
        int size = arrayList2.size() - 1;
        if (this.f147195j0) {
            i3 = this.f147199m0;
            size = this.f147200n0;
        } else {
            i3 = 0;
        }
        if (i18 > size) {
            return;
        }
        while (i3 < i18) {
            i16 += arrayList2.get(i3).e();
            if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i3 < arrayList.size() && i3 >= 0) {
                i16 += this.V.f147056b.get(i3).e();
            }
            i3++;
        }
        this.f147203q0 = (i17 * i16) - (this.f147193i / 2);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        Log.i("LyricViewFeedTriple", "showLyricPronounce:" + z16);
        if (this.f147211y0 == z16) {
            return;
        }
        this.f147211y0 = z16;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalFeedTriple.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalFeedTriple.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalFeedTriple.this.requestLayout();
                        LyricViewInternalFeedTriple.this.invalidate();
                    }
                }
            });
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        com.tencent.lyric.data.e eVar;
        int i16;
        com.tencent.lyric.data.e eVar2;
        com.tencent.lyric.data.e eVar3;
        char c16;
        int i17;
        int i18;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas, i3);
            return;
        }
        if (this.f147224i1) {
            Log.i("LyricViewFeedTriple", "drawLyricAll -> isFirstSetLyric, just return");
            return;
        }
        this.H = this.C / 2;
        int i19 = this.f147191h + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        int size = arrayList2.size();
        int i26 = this.f147201o0;
        int i27 = 0;
        if (i26 < 0) {
            i26 = 0;
        }
        if (i26 >= size) {
            i26 = size - 1;
        }
        int i28 = i26;
        SystemClock.uptimeMillis();
        if (!arrayList2.isEmpty()) {
            int k3 = i3 + k();
            int i29 = this.H;
            int i36 = 1;
            int i37 = size - 1;
            if (this.f147195j0) {
                i27 = this.f147199m0;
                i37 = this.f147200n0;
            }
            int i38 = i37;
            com.tencent.lyric.data.e eVar4 = arrayList2.get(i28);
            if (i28 == i38) {
                eVar = eVar4;
            } else {
                eVar = arrayList2.get(i28 + 1);
            }
            int i39 = i29;
            int i46 = i27;
            while (i46 <= i38) {
                com.tencent.lyric.data.e eVar5 = arrayList2.get(i46);
                long j3 = eVar4.f147071b + eVar4.f147072c;
                long j16 = eVar.f147071b;
                eVar5.e();
                int i47 = i19;
                float min = (float) Math.min(1000L, j16 - j3);
                int i48 = i46 - i28;
                if (i48 != 0) {
                    if (i48 != i36 && i48 != 2) {
                        i39 += i47 * eVar5.e();
                        i16 = i46;
                        eVar2 = eVar;
                        eVar3 = eVar4;
                    } else {
                        float f16 = ((float) eVar4.f147071b) + (0.6f * min);
                        if (this.f147202p0 >= f16) {
                            Math.min((int) (((r1 - f16) / (min * 0.4d)) * 128.0d), 128);
                        }
                        i16 = i46;
                        eVar2 = eVar;
                        eVar3 = eVar4;
                        s(eVar5, canvas, k3, i39 + this.f147190g1, this.M, 128);
                        i39 += eVar5.e() * i47;
                        G(canvas, k3, i39, false, i16);
                    }
                    i17 = i38;
                    c16 = 2;
                } else {
                    i16 = i46;
                    eVar2 = eVar;
                    eVar3 = eVar4;
                    Math.min(0.8f, ((float) (this.f147202p0 - j3)) / min);
                    if (this.A0) {
                        c16 = 2;
                        if (this.U.f147055a == 2 && !this.M0) {
                            i17 = i38;
                            G(canvas, k3, i39, true, i16);
                        }
                    } else {
                        c16 = 2;
                    }
                    i17 = i38;
                    if (this.f147202p0 >= eVar3.f147071b) {
                        Math.min((int) (((r0 - r14) / (min * 0.8d)) * 255.0d), 255);
                        Math.min(1.0f, ((float) (this.f147202p0 - eVar3.f147071b)) / (min * 0.8f));
                    }
                    w(eVar5, canvas, k3, i39, true);
                    i39 += eVar5.e() * i47;
                    G(canvas, k3, i39, true, i16);
                }
                if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null) {
                    i18 = i16;
                    if (i18 < arrayList.size() && i18 >= 0) {
                        i39 += this.V.f147056b.get(i18).e() * i47;
                    }
                } else {
                    i18 = i16;
                }
                i46 = i18 + 1;
                eVar = eVar2;
                i38 = i17;
                i36 = 1;
                eVar4 = eVar3;
                i19 = i47;
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        com.tencent.lyric.data.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f147176b0 == 70) {
            int k3 = measuredWidth - (k() << 1);
            int i18 = this.f147191h + this.f147193i;
            if (this.J) {
                this.U.l(this.N, this.M, k3, false, true, false, 0, false);
            } else {
                this.U.h(this.N, this.M, k3);
            }
            com.tencent.lyric.data.a c16 = h.c(this.U);
            this.U = c16;
            if (this.V != null && c16.v() == this.V.v()) {
                if (this.J) {
                    this.V.l(this.N, this.M, k3, false, true, false, 0, false);
                } else {
                    this.V.h(this.N, this.M, k3);
                }
                this.V = h.c(this.V);
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
            Log.i("LyricViewFeedTriple", "onMeasure -> Show line count:" + this.D0 + ", parentHeight : " + measuredHeight);
            setMeasuredDimension(measuredWidth, this.f147181d0 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void setLyric(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) aVar2);
        } else {
            this.f147224i1 = true;
            super.setLyric(aVar, aVar2);
        }
    }
}
