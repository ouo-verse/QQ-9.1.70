package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.mobileqq.lyric.data.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LyricViewInternalDetail extends LyricViewInternal {
    static IPatchRedirector $redirector_;

    public LyricViewInternalDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f243237u0 = this.f243216e;
        }
    }

    private int u(int i3) {
        int i16;
        int i17;
        com.tencent.mobileqq.lyric.data.b bVar;
        com.tencent.mobileqq.lyric.data.b bVar2 = this.Q;
        int i18 = 0;
        if (bVar2 != null && !bVar2.j()) {
            int l3 = this.Q.l() - 1;
            if (this.f243222h0) {
                i17 = this.f243226k0;
                i16 = this.f243227l0;
            } else {
                i16 = l3;
                i17 = 0;
            }
            while (i17 <= i16) {
                int c16 = this.Q.f243142b.get(i17).c();
                i18 += (this.f243216e * c16) + (this.f243221h * (c16 - 1)) + this.f243218f;
                if (this.f243238v0 && (bVar = this.R) != null && bVar.l() == this.Q.l()) {
                    int c17 = this.R.f243142b.get(i17).c();
                    i18 += (this.f243216e * c17) + (this.f243221h * (c17 - 1)) + this.f243218f;
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

    @Override // com.tencent.mobileqq.lyric.widget.LyricViewInternal
    protected void a(Canvas canvas, int i3) {
        int c16;
        com.tencent.mobileqq.lyric.data.b bVar;
        ArrayList<d> arrayList;
        int c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas, i3);
            return;
        }
        int i16 = this.f243216e + this.f243218f;
        ArrayList<d> arrayList2 = this.Q.f243142b;
        int size = arrayList2.size();
        int i17 = this.f243229m0;
        int i18 = 0;
        if (i17 < 0) {
            i17 = 0;
        }
        if (i17 >= size) {
            i17 = size - 1;
        }
        int i19 = i17;
        if (!arrayList2.isEmpty()) {
            int c18 = i3 + c();
            int i26 = this.f243228m;
            int i27 = size - 1;
            if (this.f243222h0) {
                i18 = this.f243226k0;
                i27 = this.f243227l0;
            }
            int i28 = i27;
            int i29 = i26;
            for (int i36 = i18; i36 <= i28; i36++) {
                d dVar = arrayList2.get(i36);
                int abs = Math.abs(i36 - i19);
                if (abs == 0) {
                    if (this.f243239w0 && this.Q.f243141a == 2 && this.f243241y0) {
                        n(dVar, canvas, c18, i29);
                        c17 = dVar.c();
                    } else {
                        m(dVar, canvas, c18, i29, this.f243241y0);
                        c17 = dVar.c();
                    }
                    c16 = i29 + (c17 * i16);
                    v(canvas, c18, c16, true, i36, null);
                    setContentDescription(dVar.f243148a);
                } else if (abs > 0 && abs <= this.f243242z0) {
                    l(dVar, canvas, c18, i29, this.E);
                    c16 = i29 + (dVar.c() * i16);
                    v(canvas, c18, c16, false, i36, this.E);
                } else {
                    c16 = i29 + (dVar.c() * i16);
                }
                if (this.f243238v0 && (bVar = this.R) != null && (arrayList = bVar.f243142b) != null && i36 < arrayList.size() && i36 >= 0) {
                    c16 += this.R.f243142b.get(i36).c() * i16;
                }
                i29 = c16;
            }
        }
    }

    @Override // com.tencent.mobileqq.lyric.widget.LyricViewInternal
    public int j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        super.j(i3);
        this.f243229m0 = u(i3 + this.f243237u0);
        postInvalidate();
        return this.f243229m0;
    }

    @Override // com.tencent.mobileqq.lyric.widget.LyricViewInternal
    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        Log.d("LyricViewInternalDetail", "showLyricPronounce:" + z16);
        if (this.f243238v0 == z16) {
            return;
        }
        this.f243238v0 = z16;
        this.f243236t0 = false;
        com.tencent.mobileqq.lyric.util.a.a().post(new Runnable() { // from class: com.tencent.mobileqq.lyric.widget.LyricViewInternalDetail.1
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

    @Override // com.tencent.mobileqq.lyric.widget.LyricViewInternal
    public void t() {
        int i3;
        com.tencent.mobileqq.lyric.data.b bVar;
        ArrayList<d> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int i16 = this.f243216e + this.f243218f;
        int i17 = this.f243229m0;
        if (this.f243222h0) {
            i17 -= this.f243226k0;
        }
        ArrayList<d> arrayList2 = this.Q.f243142b;
        int size = arrayList2.size() - 1;
        int i18 = 0;
        if (this.f243222h0) {
            i3 = this.f243226k0;
            size = this.f243227l0;
        } else {
            i3 = 0;
        }
        if (i17 > size) {
            return;
        }
        while (i3 < i17) {
            i18 += arrayList2.get(i3).c();
            if (this.f243238v0 && (bVar = this.R) != null && (arrayList = bVar.f243142b) != null && i3 < arrayList.size() && i3 >= 0) {
                i18 += this.R.f243142b.get(i3).c();
            }
            i3++;
        }
        int i19 = this.A0;
        if (i19 >= 0) {
            this.f243231o0 = (this.f243228m + (i16 * ((i18 + 1) - i19))) - this.f243218f;
        } else {
            this.f243231o0 = (this.f243228m + (i16 * ((i18 - this.f243242z0) - i19))) - this.f243218f;
        }
    }

    protected void v(Canvas canvas, int i3, int i16, boolean z16, int i17, Paint paint) {
        com.tencent.mobileqq.lyric.data.b bVar;
        ArrayList<d> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), paint);
            return;
        }
        if (this.f243238v0 && (bVar = this.R) != null && (arrayList = bVar.f243142b) != null && i17 < arrayList.size() && i17 >= 0) {
            if (z16 && !this.f243235s0) {
                n(arrayList.get(i17), canvas, i3, i16);
            } else {
                o(arrayList.get(i17), canvas, i3, i16, this.E, this.M);
            }
        }
    }
}
