package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewInternalDetail extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    private volatile boolean f147214h1;

    /* renamed from: i1, reason: collision with root package name */
    public LyricViewScroll.b f147215i1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements LyricViewScroll.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternalDetail.this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LyricViewInternalDetail.this.f147214h1 = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LyricViewInternalDetail.this.f147214h1 = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public LyricViewInternalDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147214h1 = false;
        this.f147215i1 = new a();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17));
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
                r(arrayList.get(i17), canvas, i3, i16, this.M);
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        super.a(i3);
        int F = F(i3 + this.f147210x0);
        postInvalidate();
        return F;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        Log.i("LyricViewInternalDetail", "showLyricPronounce:" + z16);
        if (this.f147211y0 == z16) {
            return;
        }
        this.f147211y0 = z16;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalDetail.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalDetail.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalDetail.this.requestLayout();
                        LyricViewInternalDetail.this.invalidate();
                    }
                }
            });
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        int i16;
        int e16;
        int i17;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas, i3);
            return;
        }
        int measuredHeight = ((View) ((View) getParent()).getParent()).getMeasuredHeight() / 2;
        int i18 = this.f147191h;
        this.H = measuredHeight - (i18 / 2);
        int i19 = i18 + this.f147193i;
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
        if (!arrayList2.isEmpty()) {
            int k3 = i3 + k();
            int i29 = this.H;
            int i36 = size - 1;
            if (this.f147195j0) {
                i27 = this.f147199m0;
                i36 = this.f147200n0;
            }
            int i37 = i36;
            int i38 = i29;
            int i39 = i27;
            while (i39 <= i37) {
                com.tencent.lyric.data.e eVar = arrayList2.get(i39);
                int i46 = i39 - i28;
                int abs = Math.abs(i46);
                if (abs != 0) {
                    if (abs != 1 && abs != 2) {
                        int i47 = this.D0;
                        int i48 = this.C0;
                        if (i48 > 0 && i48 < i47) {
                            i47 = i48;
                        }
                        if (Math.abs(i46) <= i47 / 2) {
                            i16 = i39;
                            r(eVar, canvas, k3, i38, this.M);
                            i38 += eVar.e() * i19;
                            G(canvas, k3, i38, false, i16);
                        } else {
                            i16 = i39;
                            if (this.f147207u0 || this.f147214h1) {
                                r(eVar, canvas, k3, i38, this.M);
                            }
                            i38 += eVar.e() * i19;
                            if (this.f147207u0 || this.f147214h1) {
                                G(canvas, k3, i38, false, i16);
                            }
                        }
                    } else {
                        i16 = i39;
                        r(eVar, canvas, k3, i38, this.M);
                        i38 += eVar.e() * i19;
                        G(canvas, k3, i38, false, i16);
                    }
                } else {
                    i16 = i39;
                    if (this.A0 && this.U.f147055a == 2 && !this.M0) {
                        u(eVar, canvas, k3, i38);
                        e16 = eVar.e();
                    } else {
                        t(eVar, canvas, k3, i38, true);
                        e16 = eVar.e();
                    }
                    i38 += e16 * i19;
                    G(canvas, k3, i38, true, i16);
                }
                if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null) {
                    i17 = i16;
                    if (i17 < arrayList.size() && i17 >= 0) {
                        i38 += this.V.f147056b.get(i17).e() * i19;
                    }
                } else {
                    i17 = i16;
                }
                i39 = i17 + 1;
            }
        }
    }
}
