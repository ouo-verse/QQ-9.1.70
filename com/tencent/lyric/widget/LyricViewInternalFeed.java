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
public class LyricViewInternalFeed extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    private volatile boolean f147217h1;

    /* renamed from: i1, reason: collision with root package name */
    public LyricViewScroll.b f147218i1;

    /* renamed from: j1, reason: collision with root package name */
    private long f147219j1;

    /* renamed from: k1, reason: collision with root package name */
    private long f147220k1;

    /* renamed from: l1, reason: collision with root package name */
    private long f147221l1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements LyricViewScroll.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternalFeed.this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LyricViewInternalFeed.this.f147217h1 = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LyricViewInternalFeed.this.f147217h1 = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public LyricViewInternalFeed(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147217h1 = false;
        this.f147218i1 = new a();
        this.f147219j1 = -1L;
        this.f147220k1 = 1000L;
        this.f147221l1 = 1000L;
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
        Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    protected void G(Canvas canvas, int i3, int i16, boolean z16, int i17) {
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i17 < arrayList.size() && i17 >= 0) {
            if (z16 && !this.f147207u0) {
                if (this.A0 && this.V.f147055a == 2 && !this.M0) {
                    u(arrayList.get(i17), canvas, i3, i16);
                    return;
                } else {
                    t(arrayList.get(i17), canvas, i3, i16, true);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        super.a(i3);
        int F = F(i3 + this.f147210x0);
        postInvalidate();
        return F;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
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
        int i16 = this.f147191h + this.f147193i;
        int i17 = this.f147201o0;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        if (arrayList2 == null) {
            return;
        }
        int size = arrayList2.size() - 1;
        int i18 = 0;
        if (this.f147195j0) {
            i3 = this.f147199m0;
            size = this.f147200n0;
        } else {
            i3 = 0;
        }
        if (i17 > size) {
            return;
        }
        while (i3 < i17) {
            i18 += arrayList2.get(i3).e();
            if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i3 < arrayList.size() && i3 >= 0) {
                i18 += this.V.f147056b.get(i3).e();
            }
            i3++;
        }
        this.f147203q0 = (i16 * i18) - (this.f147193i / 2);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        Log.i("LyricViewInternalDetail", "showLyricPronounce:" + z16);
        if (this.f147211y0 == z16) {
            return;
        }
        this.f147211y0 = z16;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalFeed.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalFeed.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalFeed.this.requestLayout();
                        LyricViewInternalFeed.this.invalidate();
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0113, code lost:
    
        if (r20.M0 == false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void i(Canvas canvas, int i3) {
        com.tencent.lyric.data.e eVar;
        int i16;
        int i17;
        com.tencent.lyric.data.e eVar2;
        int i18;
        char c16;
        int i19;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas, i3);
            return;
        }
        int measuredHeight = ((View) ((View) getParent()).getParent()).getMeasuredHeight() / 2;
        int i26 = this.f147191h;
        this.H = measuredHeight - (i26 / 2);
        int i27 = i26 + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        int size = arrayList2.size();
        int i28 = this.f147201o0;
        int i29 = 0;
        if (i28 < 0) {
            i28 = 0;
        }
        if (i28 >= size) {
            i28 = size - 1;
        }
        int i36 = i28;
        SystemClock.uptimeMillis();
        if (!arrayList2.isEmpty()) {
            int k3 = i3 + k();
            int i37 = this.H;
            int i38 = size - 1;
            if (this.f147195j0) {
                i29 = this.f147199m0;
                i38 = this.f147200n0;
            }
            int i39 = i38;
            com.tencent.lyric.data.e eVar3 = arrayList2.get(i36);
            if (i36 < i39) {
                try {
                    eVar = arrayList2.get(i36 + 1);
                } catch (IndexOutOfBoundsException e17) {
                    e17.printStackTrace();
                }
                int i46 = i37;
                i16 = i29;
                while (i16 <= i39) {
                    com.tencent.lyric.data.e eVar4 = arrayList2.get(i16);
                    long j3 = eVar3.f147071b + eVar3.f147072c;
                    int i47 = i27;
                    float min = (float) Math.min(1000L, eVar.f147071b - j3);
                    int i48 = i16 - i36;
                    if (i48 != -1) {
                        if (i48 != 0) {
                            if (i48 != 1) {
                                int i49 = this.D0;
                                int i56 = this.C0;
                                if (i56 > 0 && i56 < i49) {
                                    i49 = i56;
                                }
                                if (Math.abs(i48) <= i49 / 2) {
                                    e16 = eVar4.e();
                                } else {
                                    e16 = eVar4.e();
                                }
                                i46 += i47 * e16;
                                i17 = i16;
                                eVar2 = eVar3;
                                i18 = i39;
                            } else {
                                i17 = i16;
                                eVar2 = eVar3;
                                i18 = i39;
                                s(eVar4, canvas, k3, i46, this.M, 128);
                                i46 += i47 * eVar4.e();
                                G(canvas, k3, i46, false, i17);
                            }
                            c16 = 2;
                        } else {
                            i17 = i16;
                            eVar2 = eVar3;
                            i18 = i39;
                            Math.min(0.8f, ((float) (this.f147202p0 - j3)) / min);
                            if (this.A0) {
                                c16 = 2;
                                if (this.U.f147055a == 2) {
                                }
                            } else {
                                c16 = 2;
                            }
                            t(eVar4, canvas, k3, i46, true);
                            i46 += eVar4.e() * i47;
                            G(canvas, k3, i46, true, i17);
                        }
                    } else {
                        i17 = i16;
                        eVar2 = eVar3;
                        i18 = i39;
                        c16 = 2;
                        s(eVar4, canvas, k3, i46, this.M, 128);
                        i46 += eVar4.e() * i47;
                        G(canvas, k3, i46, false, i17);
                    }
                    if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null) {
                        i19 = i17;
                        if (i19 < arrayList.size() && i19 >= 0) {
                            i46 += this.V.f147056b.get(i19).e() * i47;
                        }
                    } else {
                        i19 = i17;
                    }
                    i16 = i19 + 1;
                    i39 = i18;
                    i27 = i47;
                    eVar3 = eVar2;
                }
            }
            eVar = eVar3;
            int i462 = i37;
            i16 = i29;
            while (i16 <= i39) {
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
                this.U.l(this.N, this.M, k3, false, true, false, 0, true);
            } else {
                this.U.h(this.N, this.M, k3);
            }
            if (this.V != null && this.U.v() == this.V.v()) {
                if (this.J) {
                    this.V.l(this.N, this.M, k3, false, true, false, 0, true);
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
            Log.i("LyricViewInternalDetail", "onMeasure -> Show line count:" + this.D0 + ", parentHeight : " + measuredHeight);
            setMeasuredDimension(measuredWidth, this.f147181d0 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
