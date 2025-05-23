package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewInternalRecord extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    public LyricViewInternalRecord(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            Log.i("LyricViewInternalRecord", "LyricViewInternalRecord");
            this.f147210x0 = this.f147191h;
        }
    }

    private int E(int i3) {
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
        Log.e("LyricViewInternalRecord", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    protected void F(Canvas canvas, int i3, int i16, boolean z16, int i17, Paint paint) {
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        com.tencent.lyric.data.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), paint);
            return;
        }
        if (!this.f147211y0 || (aVar = this.V) == null || (arrayList = aVar.f147056b) == null || i17 >= arrayList.size() || i17 < 0 || (eVar = arrayList.get(i17)) == null) {
            return;
        }
        if (z16) {
            if (this.f147207u0) {
                x(eVar, canvas, i3, i16, this.M, this.R, n());
                return;
            } else if (this.A0 && this.V.f147055a == 2 && !this.M0) {
                u(eVar, canvas, i3, i16);
                return;
            } else {
                t(eVar, canvas, i3, i16, true);
                return;
            }
        }
        x(eVar, canvas, i3, i16, this.M, this.R, n());
    }

    protected void G(List<com.tencent.lyric.data.e> list, int i3, Canvas canvas, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, Integer.valueOf(i3), canvas, Integer.valueOf(i16), Integer.valueOf(i17));
        } else if (list != null && i3 < list.size() && i3 >= 0) {
            x(list.get(i3), canvas, i16, i17, this.M, this.R, n());
        } else {
            Log.e("LyricViewInternalRecord", "sentences == null || current >= sentences.size()");
        }
    }

    protected void H(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        for (int i18 = 0; i18 < f16.size(); i18++) {
            if (i18 == 0) {
                i17 = this.f147193i;
            } else {
                i17 = this.f147198m;
            }
            f16.get(i18).i(canvas, i3, i16 + i17, paint, z16);
            i16 += i17 + this.f147191h;
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        super.a(i3);
        this.f147201o0 = E(i3 + this.f147210x0 + this.H);
        postInvalidate();
        return this.f147201o0;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        int i3;
        int i16;
        int i17;
        int i18;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f147176b0 != 70) {
            return;
        }
        int i27 = this.f147201o0;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        if (arrayList2 == null) {
            return;
        }
        int size = arrayList2.size();
        int i28 = 0;
        if (i27 < 0) {
            i27 = 0;
        }
        if (i27 >= size) {
            i27 = size - 1;
        }
        if (!arrayList2.isEmpty() && this.U.f147055a == 2) {
            int i29 = size - 1;
            if (this.f147195j0) {
                i16 = this.f147199m0;
                i3 = this.f147200n0;
            } else {
                i3 = i29;
                i16 = 0;
            }
            while (i16 <= i3 && i16 <= size) {
                com.tencent.lyric.data.e eVar = arrayList2.get(i16);
                if (i16 - i27 != 0) {
                    int e16 = eVar.e();
                    i17 = (this.f147191h * e16) + (this.f147198m * (e16 - 1));
                    i18 = this.f147193i;
                } else {
                    this.f147203q0 = i28;
                    if (this.f147207u0) {
                        int e17 = eVar.e();
                        i17 = (this.f147191h * e17) + (this.f147198m * (e17 - 1));
                        i18 = this.f147193i;
                    } else {
                        int e18 = eVar.e();
                        i17 = (this.C * e18) + (this.f147198m * (e18 - 1));
                        i18 = this.f147193i;
                    }
                }
                i28 += i17 + i18;
                if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i16 < arrayList.size() && i16 >= 0) {
                    int e19 = this.V.f147056b.get(i16).e();
                    if (i16 == i27 && !this.f147207u0) {
                        i19 = (this.C * e19) + (this.f147198m * (e19 - 1));
                        i26 = this.f147193i;
                    } else {
                        i19 = (this.f147191h * e19) + (this.f147198m * (e19 - 1));
                        i26 = this.f147193i;
                    }
                    i28 += i19 + i26;
                }
                i16++;
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        Log.i("LyricViewInternalRecord", "showLyricPronounce:" + z16);
        if (this.f147211y0 == z16) {
            return;
        }
        this.f147211y0 = z16;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalRecord.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalRecord.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalRecord.this.invalidate();
                    }
                }
            });
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        boolean z16;
        int i16;
        com.tencent.lyric.data.e eVar;
        char c16;
        int i17;
        int i18;
        char c17;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int i19;
        int i26;
        int i27;
        com.tencent.lyric.data.a aVar2;
        ArrayList<com.tencent.lyric.data.e> arrayList2;
        int i28;
        int i29;
        int i36;
        com.tencent.lyric.data.e eVar2;
        int i37;
        int i38;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas, i3);
            return;
        }
        int i39 = this.f147201o0;
        int i46 = this.f147191h + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList3 = this.U.f147056b;
        int size = arrayList3.size();
        int i47 = 0;
        if (i39 < 0) {
            i39 = 0;
        }
        if (i39 >= size) {
            i39 = size - 1;
        }
        int i48 = i39;
        if (!arrayList3.isEmpty()) {
            int k3 = i3 + k();
            int i49 = this.H;
            if (this.U.f147055a == 2) {
                int size2 = arrayList3.size() - 1;
                if (this.f147195j0) {
                    i47 = this.f147199m0;
                    size2 = this.f147200n0;
                }
                int i56 = i47;
                int i57 = size2;
                int i58 = i49;
                for (int i59 = i56; i59 <= i57; i59 = i16 + 1) {
                    if ((this.f147207u0 || i59 <= i48 || i59 - i48 <= this.D0) && i59 <= arrayList3.size()) {
                        com.tencent.lyric.data.e eVar3 = arrayList3.get(i59);
                        int i65 = i59 - i48;
                        if (i65 != 0) {
                            if (i65 != 1) {
                                if (this.f147212z0 != 1 && i59 > i48 && ((i38 = this.C0) <= 0 || i65 < i38)) {
                                    i36 = i65;
                                    eVar2 = eVar3;
                                    G(arrayList3, i59, canvas, k3, i58);
                                } else {
                                    i36 = i65;
                                    eVar2 = eVar3;
                                }
                                int e16 = eVar2.e();
                                i58 += (this.f147191h * e16) + (this.f147198m * (e16 - 1)) + this.f147193i;
                                if (this.f147212z0 != 1 && i59 > i48 && ((i37 = this.C0) <= 0 || i36 < i37)) {
                                    i27 = i59;
                                    F(canvas, k3, i58, false, i59, this.M);
                                } else {
                                    i27 = i59;
                                }
                            } else {
                                i27 = i59;
                                if (this.f147212z0 == 1 && this.f147211y0) {
                                    int e17 = eVar3.e();
                                    i58 += (this.f147191h * e17) + (this.f147198m * (e17 - 1)) + this.f147193i;
                                    if (this.f147211y0 && (aVar2 = this.V) != null && (arrayList2 = aVar2.f147056b) != null) {
                                        i16 = i27;
                                        if (i16 < arrayList2.size() && i16 >= 0) {
                                            int e18 = this.V.f147056b.get(i16).e();
                                            if (i16 == i48 && !this.f147207u0) {
                                                i28 = (this.C * e18) + (this.f147198m * (e18 - 1));
                                                i29 = this.f147193i;
                                            } else {
                                                i28 = (this.f147191h * e18) + (this.f147198m * (e18 - 1));
                                                i29 = this.f147193i;
                                            }
                                            i58 += i28 + i29;
                                        }
                                    }
                                } else {
                                    i16 = i27;
                                    G(arrayList3, i16, canvas, k3, i58);
                                    int e19 = eVar3.e();
                                    i58 += (this.f147191h * e19) + (this.f147198m * (e19 - 1)) + this.f147193i;
                                    F(canvas, k3, i58, false, i16, this.M);
                                }
                                c17 = 2;
                            }
                            i16 = i27;
                            c17 = 2;
                        } else {
                            i16 = i59;
                            if (this.f147207u0) {
                                H(eVar3, canvas, k3, i58, this.P, true);
                                int e26 = eVar3.e();
                                i58 += (this.f147191h * e26) + (this.f147198m * (e26 - 1)) + this.f147193i;
                                c16 = 2;
                            } else {
                                if (this.A0) {
                                    c16 = 2;
                                    if (this.U.f147055a == 2 && !this.M0) {
                                        u(eVar3, canvas, k3, i58);
                                        int e27 = eVar3.e();
                                        i17 = (this.C * e27) + (this.f147198m * (e27 - 1));
                                        i18 = this.f147193i;
                                        i58 += i17 + i18;
                                    } else {
                                        eVar = eVar3;
                                    }
                                } else {
                                    eVar = eVar3;
                                    c16 = 2;
                                }
                                t(eVar, canvas, k3, i58, true);
                                int e28 = eVar.e();
                                i17 = (this.C * e28) + (this.f147198m * (e28 - 1));
                                i18 = this.f147193i;
                                i58 += i17 + i18;
                            }
                            c17 = c16;
                            F(canvas, k3, i58, true, i16, null);
                        }
                        if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i16 < arrayList.size() && i16 >= 0) {
                            int e29 = this.V.f147056b.get(i16).e();
                            if (i16 == i48 && !this.f147207u0) {
                                i19 = (this.C * e29) + (this.f147198m * (e29 - 1));
                                i26 = this.f147193i;
                            } else {
                                i19 = (this.f147191h * e29) + (this.f147198m * (e29 - 1));
                                i26 = this.f147193i;
                            }
                            i58 += i19 + i26;
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            int i66 = i49;
            for (int i67 = 0; i67 < arrayList3.size(); i67++) {
                if (i67 == i48) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                com.tencent.lyric.data.e eVar4 = arrayList3.get(i67);
                t(eVar4, canvas, k3, i66, z16);
                i66 += eVar4.e() * i46;
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f147208v0 == measuredWidth && this.f147209w0) {
            if (this.f147176b0 == 70) {
                setMeasuredDimension(measuredWidth, (this.f147181d0 + measuredHeight) - (this.L * (this.f147193i + this.f147191h)));
            } else {
                setMeasuredDimension(measuredWidth, measuredHeight);
            }
        } else {
            this.f147208v0 = measuredWidth;
            if (this.f147176b0 == 70) {
                int k3 = measuredWidth - (k() << 1);
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
                List<com.tencent.lyric.data.e> o16 = this.U.o();
                int i28 = this.f147201o0;
                int size = o16.size() - 1;
                if (this.f147195j0) {
                    i27 = this.f147199m0;
                    size = this.f147200n0;
                }
                int i29 = this.H;
                while (i27 <= size && i27 <= o16.size()) {
                    com.tencent.lyric.data.e eVar = o16.get(i27);
                    if (i27 - i28 != 0) {
                        int e16 = eVar.e();
                        i17 = (this.f147191h * e16) + (this.f147198m * (e16 - 1));
                        i18 = this.f147193i;
                    } else if (this.f147207u0) {
                        int e17 = eVar.e();
                        i17 = (this.f147191h * e17) + (this.f147198m * (e17 - 1));
                        i18 = this.f147193i;
                    } else {
                        int e18 = eVar.e();
                        i17 = (this.C * e18) + (this.f147198m * (e18 - 1));
                        i18 = this.f147193i;
                    }
                    i29 += i17 + i18;
                    com.tencent.lyric.data.a aVar = this.V;
                    if (aVar != null && (arrayList = aVar.f147056b) != null && i27 < arrayList.size() && i27 >= 0) {
                        int e19 = this.V.f147056b.get(i27).e();
                        if (i27 == i28 && !this.f147207u0) {
                            i19 = (this.C * e19) + (this.f147198m * (e19 - 1));
                            i26 = this.f147193i;
                        } else {
                            i19 = (this.f147191h * e19) + (this.f147198m * (e19 - 1));
                            i26 = this.f147193i;
                        }
                        i29 += i19 + i26;
                    }
                    i27++;
                }
                this.f147181d0 = i29;
                this.D0 = (measuredHeight / (this.f147193i + this.f147191h)) + 1;
                Log.i("LyricViewInternalRecord", "onMeasure -> Show line count:" + this.D0);
                setMeasuredDimension(measuredWidth, (this.f147181d0 + measuredHeight) - (this.L * (this.f147193i + this.f147191h)));
            } else {
                setMeasuredDimension(measuredWidth, measuredHeight);
            }
        }
        this.f147209w0 = true;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void setLyricFontSize(HashMap<String, Float> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hashMap);
            return;
        }
        super.setLyricFontSize(hashMap);
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalRecord.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalRecord.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalRecord.this.requestLayout();
                        LyricViewInternalRecord.this.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void x(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (f16.isEmpty()) {
            return;
        }
        int i17 = this.f147191h;
        int i18 = this.f147193i + i17;
        int i19 = i17 + this.f147198m;
        f16.get(0).o(canvas, i3, i16 + this.f147193i, paint, paint2, z16, false, null);
        int i26 = i16 + i18;
        for (int i27 = 1; i27 < f16.size(); i27++) {
            f16.get(i27).o(canvas, i3, i26 + this.f147198m, paint, paint2, z16, false, null);
            i26 += i19;
        }
    }
}
