package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class LyricViewInternalPractice extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    private float f147230h1;

    /* renamed from: i1, reason: collision with root package name */
    private int f147231i1;

    /* renamed from: j1, reason: collision with root package name */
    private int f147232j1;

    /* renamed from: k1, reason: collision with root package name */
    private Paint f147233k1;

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalPractice$11, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass11 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.invalidate();
            }
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalPractice$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.requestLayout();
                this.this$0.invalidate();
            }
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalPractice$7, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f147238d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f147239e;
        final /* synthetic */ LyricViewInternalPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (int i3 = this.f147238d; i3 <= this.f147239e; i3++) {
                int size = this.this$0.U.f147056b.get(i3).f147074e.size();
                int[] iArr = new int[size];
                for (int i16 = 0; i16 < size; i16++) {
                    iArr[i16] = a.f147243b;
                }
                this.this$0.O0.remove(i3);
                this.this$0.O0.add(i3, iArr);
            }
            this.this$0.requestLayout();
            this.this$0.invalidate();
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalPractice$8, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f147240d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f147241e;
        final /* synthetic */ LyricViewInternalPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (int i3 = this.f147240d; i3 <= this.f147241e; i3++) {
                this.this$0.P0.remove(i3);
                this.this$0.P0.add(i3, null);
            }
            this.this$0.requestLayout();
            this.this$0.invalidate();
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalPractice$9, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass9 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (int i3 = 0; i3 < this.this$0.O0.size(); i3++) {
                int[] iArr = this.this$0.O0.get(i3);
                for (int i16 = 0; i16 < iArr.length; i16++) {
                    iArr[i16] = a.f147243b;
                }
                this.this$0.P0.remove(i3);
                this.this$0.P0.add(i3, null);
            }
            this.this$0.requestLayout();
            this.this$0.invalidate();
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static int f147242a;

        /* renamed from: b, reason: collision with root package name */
        public static int f147243b;

        /* renamed from: c, reason: collision with root package name */
        public static int f147244c;

        /* renamed from: d, reason: collision with root package name */
        public static int f147245d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17130);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f147242a = 1;
            f147243b = 0;
            f147244c = 10;
            f147245d = 12;
        }
    }

    public LyricViewInternalPractice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147230h1 = 0.0f;
        this.f147231i1 = -1;
        this.f147232j1 = -1;
        this.f147233k1 = null;
        Log.i("LVPracticeInternal", "LyricViewPracticeInternal");
        this.H = 0;
        this.f147210x0 = this.f147191h;
        this.f147230h1 = context.getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f147233k1 = paint;
        paint.setARGB(20, 255, 255, 255);
        this.f147233k1.setStyle(Paint.Style.FILL);
    }

    private int E(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        com.tencent.lyric.data.a aVar = this.U;
        int i26 = 0;
        if (aVar != null && !aVar.t()) {
            int i27 = i3 + this.H;
            int v3 = this.U.v() - 1;
            if (this.f147195j0) {
                i17 = this.f147199m0;
                i16 = this.f147200n0;
            } else {
                i16 = v3;
                i17 = 0;
            }
            int i28 = this.H;
            int i29 = 0;
            while (i17 <= i16) {
                int e16 = this.U.f147056b.get(i17).e();
                if (i17 >= this.H0 && i17 <= this.I0) {
                    i18 = (this.C * e16) + (this.f147198m * (e16 - 1));
                    i19 = this.f147193i;
                } else {
                    i18 = (this.f147191h * e16) + (this.f147198m * (e16 - 1));
                    i19 = this.f147193i;
                }
                i28 += i18 + i19;
                int[] iArr = this.J0;
                if (iArr != null && iArr.length >= this.U.v()) {
                    int[] iArr2 = this.J0;
                    if (iArr2 != null) {
                        i29 = iArr2[i17];
                    }
                    if (iArr2 != null && i17 < iArr2.length - 1) {
                        i26 = iArr2[i17 + 1];
                    }
                    if (i29 != i26) {
                        i28 += this.K0;
                    }
                }
                if (i27 < i28) {
                    return i17;
                }
                i17++;
            }
            return i16;
        }
        Log.e("LVPracticeInternal", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    private float F(float f16) {
        return (f16 * this.f147230h1) + 0.5f;
    }

    private void I(List<com.tencent.lyric.data.e> list, int i3, Canvas canvas, int i16, int i17) {
        if (list != null && i3 < list.size() && i3 >= 0) {
            x(list.get(i3), canvas, i16, i17, this.M, this.R, n());
        } else {
            Log.e("LVPracticeInternal", "sentences == null || current >= sentences.size()");
        }
    }

    protected void G(Canvas canvas, int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, canvas, Integer.valueOf(i3), bitmap);
            return;
        }
        Paint.FontMetrics fontMetrics = this.R0.getFontMetrics();
        Rect rect = new Rect();
        int width = getWidth() - ((int) F(23.0f));
        int textSize = i3 + ((int) (((this.R0.getTextSize() - ((int) F(13.0f))) + fontMetrics.bottom) / 2.0f));
        rect.set(width, textSize, getWidth() - ((int) F(15.0f)), ((int) F(13.0f)) + textSize);
        canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
    }

    protected void H(com.tencent.lyric.data.e eVar, int[] iArr, Canvas canvas, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, eVar, iArr, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (f16.isEmpty()) {
            return;
        }
        int[] h16 = eVar.h(iArr);
        int i17 = this.f147191h;
        int i18 = i17 + this.f147193i;
        int i19 = i17 + this.f147198m;
        float F = F(1.0f);
        f16.get(0).n(canvas, h16, 0, i3, i16 + this.f147193i, this.Q0, this.R0, this.N, this.M, z16, F, false, null);
        int i26 = i16 + i18;
        int size = f16.get(0).f147080d.size() + 0;
        for (int i27 = 1; i27 < f16.size(); i27++) {
            f16.get(i27).n(canvas, h16, size, i3, i26 + this.f147198m, this.Q0, this.R0, this.N, this.M, z16, F, false, null);
            i26 += i19;
            size += f16.get(i27).f147080d.size();
        }
    }

    protected void J(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16));
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

    protected void K(com.tencent.lyric.data.e eVar, int[] iArr, Canvas canvas, int i3, int i16, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, eVar, iArr, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        int[] h16 = eVar.h(iArr);
        float F = F(1.0f);
        int i18 = 0;
        int i19 = 0;
        int i26 = i16;
        while (i18 < f16.size()) {
            if (i18 == 0) {
                i17 = this.f147193i;
            } else {
                i17 = this.f147198m;
            }
            int i27 = i17;
            int[] iArr2 = h16;
            int i28 = i18;
            f16.get(i18).n(canvas, h16, i19, i3, i26 + i27, this.Q0, this.R0, this.N, this.M, z16, F, false, null);
            i19 += f16.get(i28).f147080d.size();
            i26 += i27 + this.f147191h;
            i18 = i28 + 1;
            h16 = iArr2;
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        super.a(i3);
        this.f147201o0 = E(i3 + this.f147210x0);
        postInvalidate();
        return this.f147201o0;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        int i3;
        int i16;
        int i17;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f147176b0 != 70) {
            return;
        }
        int i26 = this.f147201o0;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        if (arrayList2 == null) {
            return;
        }
        if (this.H == 0) {
            this.H = ((View) ((View) getParent()).getParent()).getMeasuredHeight() / 2;
        }
        int size = arrayList2.size();
        int i27 = 0;
        if (i26 < 0) {
            i26 = 0;
        }
        if (i26 >= size) {
            i26 = size - 1;
        }
        if (!arrayList2.isEmpty()) {
            int i28 = this.H;
            if (this.U.f147055a == 2) {
                int i29 = size - 1;
                if (this.f147195j0) {
                    i16 = this.f147199m0;
                    i3 = this.f147200n0;
                } else {
                    i3 = i29;
                    i16 = 0;
                }
                int[] iArr = this.J0;
                if (iArr != null) {
                    i17 = iArr[i16];
                } else {
                    i17 = 0;
                }
                while (i16 <= i3 && i16 <= size) {
                    int[] iArr2 = this.J0;
                    if (iArr2 != null && iArr2.length >= arrayList2.size()) {
                        int[] iArr3 = this.J0;
                        if (iArr3 != null) {
                            i27 = iArr3[i16];
                        }
                        if (i27 != i17) {
                            i28 += this.K0;
                        }
                        if (iArr3 != null) {
                            i17 = iArr3[i16];
                        }
                    }
                    com.tencent.lyric.data.e eVar = arrayList2.get(i16);
                    if (i16 - i26 == 0) {
                        this.f147203q0 = i28;
                    } else {
                        int e16 = eVar.e();
                        i28 += (this.f147191h * e16) + (this.f147198m * (e16 - 1)) + this.f147193i;
                    }
                    if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i16 < arrayList.size() && i16 >= 0) {
                        int e17 = this.V.f147056b.get(i16).e();
                        if (i16 == i26 && !this.f147207u0) {
                            i18 = (this.C * e17) + (this.f147198m * (e17 - 1));
                            i19 = this.f147193i;
                        } else {
                            i18 = (this.f147191h * e17) + (this.f147198m * (e17 - 1));
                            i19 = this.f147193i;
                        }
                        i28 += i18 + i19;
                    }
                    i16++;
                }
            }
        }
        this.f147203q0 -= this.H;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        Log.i("LVPracticeInternal", "showLyricPronounce:" + z16);
        if (this.f147211y0 == z16) {
            return;
        }
        this.f147211y0 = z16;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalPractice.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalPractice.this.requestLayout();
                        LyricViewInternalPractice.this.invalidate();
                    }
                }
            });
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    protected void i(Canvas canvas, int i3) {
        boolean z16;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        ArrayList<Bitmap> arrayList;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas, i3);
            return;
        }
        this.H = ((View) ((View) getParent()).getParent()).getMeasuredHeight() / 2;
        int i38 = this.f147201o0;
        int i39 = this.f147191h + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        int size = arrayList2.size();
        if (i38 < 0) {
            i38 = 0;
        }
        if (i38 >= size) {
            i38 = size - 1;
        }
        int i46 = i38;
        if (!arrayList2.isEmpty()) {
            int k3 = i3 + k();
            int i47 = this.H;
            if (this.U.f147055a == 2) {
                int size2 = arrayList2.size() - 1;
                if (this.f147195j0) {
                    i17 = this.f147199m0;
                    i16 = this.f147200n0;
                } else {
                    i16 = size2;
                    i17 = 0;
                }
                int[] iArr = this.J0;
                if (iArr != null) {
                    i18 = iArr[i17];
                } else {
                    i18 = 0;
                }
                int i48 = 0;
                int i49 = -1;
                int i56 = i17;
                int i57 = 0;
                while (i56 <= i16 && i56 <= arrayList2.size()) {
                    int[] iArr2 = this.J0;
                    if (iArr2 != null && iArr2.length >= arrayList2.size()) {
                        int[] iArr3 = this.J0;
                        if (iArr3 != null) {
                            i57 = iArr3[i56];
                        }
                        if (i57 != i18) {
                            i47 += this.K0;
                        }
                        if (iArr3 != null) {
                            i18 = iArr3[i56];
                        }
                    }
                    int i58 = i47;
                    int i59 = i57;
                    int i65 = i18;
                    com.tencent.lyric.data.e eVar = arrayList2.get(i56);
                    if (this.L0 == a.f147245d && (arrayList = this.P0) != null && (bitmap = arrayList.get(i56)) != null) {
                        G(canvas, i58, bitmap);
                    }
                    if (i56 >= this.H0 && i56 <= this.I0) {
                        if (this.L0 == a.f147245d) {
                            i36 = i58;
                            i37 = i49;
                            K(eVar, this.O0.get(i56), canvas, k3, i58, true);
                        } else {
                            i36 = i58;
                            i37 = i49;
                            J(eVar, canvas, k3, i36, this.N, true);
                        }
                        int e16 = eVar.e();
                        int i66 = (this.C * e16) + (this.f147198m * (e16 - 1));
                        int i67 = this.f147193i;
                        int i68 = i66 + i67;
                        i26 = i36 + i68;
                        if (i56 >= this.f147231i1 && i56 <= this.f147232j1) {
                            i48 += i68;
                            i49 = i37;
                            if (i49 == -1) {
                                i28 = i26 - i68;
                                i29 = i67 / 2;
                                i49 = i28 - i29;
                            }
                        } else {
                            i49 = i37;
                        }
                        i47 = i26;
                        i56++;
                        i57 = i59;
                        i18 = i65;
                    } else {
                        if (this.L0 == a.f147245d) {
                            i19 = i49;
                            H(eVar, this.O0.get(i56), canvas, k3, i58, false);
                        } else {
                            i19 = i49;
                            I(arrayList2, i56, canvas, k3, i58);
                        }
                        int e17 = eVar.e();
                        int i69 = (this.f147191h * e17) + (this.f147198m * (e17 - 1));
                        int i75 = this.f147193i;
                        int i76 = i69 + i75;
                        i26 = i58 + i76;
                        if (i56 >= this.f147231i1 && i56 <= this.f147232j1) {
                            i48 += i76;
                            i27 = i19;
                            if (i27 == -1) {
                                i28 = i26 - i76;
                                i29 = i75 / 2;
                                i49 = i28 - i29;
                                i47 = i26;
                                i56++;
                                i57 = i59;
                                i18 = i65;
                            }
                        } else {
                            i27 = i19;
                        }
                        i49 = i27;
                        i47 = i26;
                        i56++;
                        i57 = i59;
                        i18 = i65;
                    }
                }
                int i77 = i49;
                if (i77 != -1 && i48 != 0) {
                    canvas.drawRect(0.0f, i77, getWidth(), i77 + i48, this.f147233k1);
                    return;
                }
                return;
            }
            int i78 = i47;
            for (int i79 = 0; i79 < arrayList2.size(); i79++) {
                if (i79 == i46) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                com.tencent.lyric.data.e eVar2 = arrayList2.get(i79);
                t(eVar2, canvas, k3, i78, z16);
                i78 += eVar2.e() * i39;
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i28 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f147176b0 == 70) {
            this.U.h(this.N, this.M, measuredWidth - (k() << 1));
            List<com.tencent.lyric.data.e> o16 = this.U.o();
            int size = o16.size() - 1;
            if (this.f147195j0) {
                i18 = this.f147199m0;
                i17 = this.f147200n0;
            } else {
                i17 = size;
                i18 = 0;
            }
            int[] iArr = this.J0;
            if (iArr != null) {
                i19 = iArr[i18];
            } else {
                i19 = 0;
            }
            int i29 = i19;
            int i36 = 0;
            for (int i37 = i18; i37 <= i17; i37++) {
                int[] iArr2 = this.J0;
                if (iArr2 != null && iArr2.length >= o16.size()) {
                    int[] iArr3 = this.J0;
                    if (iArr3 != null) {
                        i36 = iArr3[i37];
                    }
                    if (i36 != i29) {
                        i28 += this.K0;
                    }
                    if (iArr3 != null) {
                        i29 = iArr3[i37];
                    }
                }
                if (i37 > o16.size()) {
                    break;
                }
                com.tencent.lyric.data.e eVar = o16.get(i37);
                if (i37 >= this.H0 && i37 <= this.I0) {
                    int e16 = eVar.e();
                    i26 = (this.C * e16) + (this.f147198m * (e16 - 1));
                    i27 = this.f147193i;
                } else {
                    int e17 = eVar.e();
                    i26 = (this.f147191h * e17) + (this.f147198m * (e17 - 1));
                    i27 = this.f147193i;
                }
                i28 += i26 + i27;
            }
            this.f147181d0 = i28;
            setMeasuredDimension(measuredWidth, i28 + measuredHeight);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void setArrowBitmap(int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) bitmap);
            return;
        }
        if (this.O0 == null && this.P0 == null) {
            Log.i("LVPracticeInternal", "setArrowBitmap model = " + this.L0);
            if (i3 >= 0 && i3 < this.P0.size()) {
                this.f147209w0 = false;
                if (getWindowToken() != null) {
                    post(new Runnable(i3, bitmap) { // from class: com.tencent.lyric.widget.LyricViewInternalPractice.6
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f147236d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ Bitmap f147237e;

                        {
                            this.f147236d = i3;
                            this.f147237e = bitmap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, LyricViewInternalPractice.this, Integer.valueOf(i3), bitmap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            LyricViewInternalPractice.this.P0.remove(this.f147236d);
                            LyricViewInternalPractice.this.P0.add(this.f147236d, this.f147237e);
                            LyricViewInternalPractice.this.requestLayout();
                            LyricViewInternalPractice.this.invalidate();
                        }
                    });
                    return;
                }
                return;
            }
            throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.P0.size());
        }
        Log.i("LVPracticeInternal", "not init over");
    }

    public void setHightLightSegment(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.H0 = i3;
            this.I0 = i16;
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void setLyric(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        super.setLyric(aVar, aVar2);
        if (aVar != null) {
            com.tencent.lyric.data.a aVar3 = this.U;
            if (aVar3.f147055a == 2) {
                int size = aVar3.f147056b.size();
                this.O0 = new ArrayList<>(size);
                for (int i3 = 0; i3 < size; i3++) {
                    com.tencent.lyric.data.e eVar = this.U.f147056b.get(i3);
                    if (eVar.f147074e == null) {
                        eVar.f147074e = new ArrayList<>();
                    }
                    int size2 = eVar.f147074e.size();
                    int[] iArr = new int[size2];
                    for (int i16 = 0; i16 < size2; i16++) {
                        iArr[i16] = a.f147243b;
                    }
                    this.O0.add(iArr);
                }
                this.P0 = new ArrayList<>(size);
                for (int i17 = 0; i17 < size; i17++) {
                    this.P0.add(null);
                }
            }
        }
    }

    public void setMarkCharacter(int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) iArr);
            return;
        }
        if (this.O0 != null && this.P0 != null) {
            Log.i("LVPracticeInternal", "setMarkCharacter model = " + this.L0);
            if (i3 >= 0 && i3 < this.O0.size()) {
                if (iArr.length == this.O0.get(i3).length) {
                    this.f147209w0 = false;
                    if (getWindowToken() != null) {
                        post(new Runnable(i3, iArr) { // from class: com.tencent.lyric.widget.LyricViewInternalPractice.5
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f147234d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ int[] f147235e;

                            {
                                this.f147234d = i3;
                                this.f147235e = iArr;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, LyricViewInternalPractice.this, Integer.valueOf(i3), iArr);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                LyricViewInternalPractice.this.O0.remove(this.f147234d);
                                LyricViewInternalPractice.this.O0.add(this.f147234d, this.f147235e);
                                LyricViewInternalPractice.this.requestLayout();
                                LyricViewInternalPractice.this.invalidate();
                            }
                        });
                        return;
                    }
                    return;
                }
                throw new RuntimeException("array leng " + iArr.length + " not equals characters length. characters length = " + this.O0.get(i3).length);
            }
            throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.O0.size());
        }
        Log.i("LVPracticeInternal", "not init over");
    }

    public void setMaskSegment(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f147231i1 = i3;
        this.f147232j1 = i16;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalPractice.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalPractice.this.invalidate();
                    }
                }
            });
        }
    }

    public void setPracticeModel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        this.L0 = i3;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalPractice.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalPractice.this.requestLayout();
                        LyricViewInternalPractice.this.invalidate();
                    }
                }
            });
        }
    }

    public void setSegmentInternal(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        this.K0 = i3;
        this.f147209w0 = false;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalPractice.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalPractice.this.requestLayout();
                        LyricViewInternalPractice.this.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void x(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, paint2, Boolean.valueOf(z16));
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
