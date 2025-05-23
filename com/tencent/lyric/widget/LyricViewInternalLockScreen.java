package com.tencent.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
@SuppressLint({"LongLogTag"})
/* loaded from: classes9.dex */
public class LyricViewInternalLockScreen extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    private volatile boolean f147227h1;

    /* renamed from: i1, reason: collision with root package name */
    public LyricViewScroll.b f147228i1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements LyricViewScroll.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewInternalLockScreen.this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LyricViewInternalLockScreen.this.f147227h1 = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LyricViewInternalLockScreen.this.f147227h1 = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public LyricViewInternalLockScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147227h1 = false;
        this.f147228i1 = new a();
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
        Log.e("LyricViewInternalLockScreen", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        super.a(i3);
        int F = F(i3 + this.f147210x0);
        postInvalidate();
        return F;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
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
            if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i3 < arrayList.size()) {
                i18 += this.V.f147056b.get(i3).e();
            }
            i3++;
        }
        this.f147203q0 = (i16 * i18) - (this.f147193i / 2);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        int e16;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas, i3);
            return;
        }
        int i16 = this.f147191h + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        int size = arrayList2.size();
        int i17 = this.f147201o0;
        int i18 = 0;
        if (i17 < 0) {
            i17 = 0;
        }
        if (i17 >= size) {
            i17 = size - 1;
        }
        int i19 = i17;
        if (!arrayList2.isEmpty()) {
            int k3 = i3 + k();
            int i26 = this.H;
            int i27 = size - 1;
            if (this.f147195j0) {
                i18 = this.f147199m0;
                i27 = this.f147200n0;
            }
            int i28 = i27;
            int i29 = i26;
            for (int i36 = i18; i36 <= i28; i36++) {
                com.tencent.lyric.data.e eVar = arrayList2.get(i36);
                int i37 = i36 - i19;
                int abs = Math.abs(i37);
                if (abs != 0) {
                    if (abs != 1 && abs != 2) {
                        int i38 = this.D0;
                        int i39 = this.C0;
                        if (i39 > 0 && i39 < i38) {
                            i38 = i39;
                        }
                        if (Math.abs(i37) <= i38 / 2) {
                            r(eVar, canvas, k3, i29, this.M);
                            e16 = eVar.e();
                        } else {
                            if (this.f147207u0 || this.f147227h1) {
                                r(eVar, canvas, k3, i29, this.M);
                            }
                            e16 = eVar.e();
                        }
                    } else {
                        r(eVar, canvas, k3, i29, this.M);
                        e16 = eVar.e();
                    }
                } else if (this.A0 && this.U.f147055a == 2 && !this.M0) {
                    u(eVar, canvas, k3, i29);
                    e16 = eVar.e();
                } else {
                    t(eVar, canvas, k3, i29, true);
                    e16 = eVar.e();
                }
                i29 += e16 * i16;
                if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i36 < arrayList.size()) {
                    i29 += this.V.f147056b.get(i36).e() * i16;
                }
            }
        }
    }
}
