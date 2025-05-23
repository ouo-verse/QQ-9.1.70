package com.tencent.lyric.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
public class LyricViewInternalAIPractice extends LyricViewInternalBase {
    static IPatchRedirector $redirector_;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f147148h1;

    /* renamed from: i1, reason: collision with root package name */
    private int f147149i1;

    /* renamed from: j1, reason: collision with root package name */
    private int f147150j1;

    /* renamed from: k1, reason: collision with root package name */
    private float f147151k1;

    /* renamed from: l1, reason: collision with root package name */
    private Paint f147152l1;

    /* renamed from: m1, reason: collision with root package name */
    private Paint f147153m1;

    /* renamed from: n1, reason: collision with root package name */
    private Paint f147154n1;

    /* renamed from: o1, reason: collision with root package name */
    private Bitmap f147155o1;

    /* renamed from: p1, reason: collision with root package name */
    private Bitmap f147156p1;

    /* renamed from: q1, reason: collision with root package name */
    private ArrayList<Bitmap> f147157q1;

    /* renamed from: r1, reason: collision with root package name */
    private boolean f147158r1;

    /* renamed from: s1, reason: collision with root package name */
    private ArrayList<Boolean> f147159s1;

    /* renamed from: t1, reason: collision with root package name */
    private int f147160t1;

    /* renamed from: u1, reason: collision with root package name */
    private boolean f147161u1;

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$10, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass10 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

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
                    iArr[i16] = a.f147171b;
                }
                this.this$0.P0.remove(i3);
                this.this$0.P0.add(i3, null);
            }
            this.this$0.requestLayout();
            this.this$0.invalidate();
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$12, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass12 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

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

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$13, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass13 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.this$0.f147159s1 == null) {
                return;
            }
            int size = this.this$0.f147159s1.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.this$0.f147159s1.set(i3, Boolean.FALSE);
            }
            this.this$0.invalidate();
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

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

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$6, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

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

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$8, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f147166d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f147167e;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (int i3 = this.f147166d; i3 <= this.f147167e; i3++) {
                int size = this.this$0.U.f147056b.get(i3).f147074e.size();
                int[] iArr = new int[size];
                for (int i16 = 0; i16 < size; i16++) {
                    iArr[i16] = a.f147171b;
                }
                this.this$0.O0.remove(i3);
                this.this$0.O0.add(i3, iArr);
            }
            this.this$0.requestLayout();
            this.this$0.invalidate();
        }
    }

    /* renamed from: com.tencent.lyric.widget.LyricViewInternalAIPractice$9, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass9 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f147168d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f147169e;
        final /* synthetic */ LyricViewInternalAIPractice this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (int i3 = this.f147168d; i3 <= this.f147169e; i3++) {
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
        public static int f147170a;

        /* renamed from: b, reason: collision with root package name */
        public static int f147171b;

        /* renamed from: c, reason: collision with root package name */
        public static int f147172c;

        /* renamed from: d, reason: collision with root package name */
        public static int f147173d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15072);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f147170a = 1;
            f147171b = 0;
            f147172c = 10;
            f147173d = 11;
        }
    }

    public LyricViewInternalAIPractice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147148h1 = false;
        this.f147149i1 = -1;
        this.f147150j1 = -1;
        this.f147151k1 = 0.0f;
        this.f147152l1 = null;
        this.f147153m1 = new Paint();
        this.f147154n1 = new Paint();
        this.f147158r1 = true;
        this.f147160t1 = 0;
        this.f147161u1 = false;
        this.H = 0;
        this.f147210x0 = this.f147191h;
        this.f147151k1 = context.getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f147152l1 = paint;
        paint.setARGB(20, 255, 255, 255);
        this.f147152l1.setStyle(Paint.Style.FILL);
    }

    private int F(int i3) {
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
        Log.e("LyricViewInternalAIPractice", "computeHilightWhileScrolling -> mLineLyric == null");
        return 0;
    }

    private float G(float f16) {
        return (f16 * this.f147151k1) + 0.5f;
    }

    private void H(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, boolean z16, boolean z17, Bitmap bitmap, int i17) {
        int i18;
        boolean z18;
        if (bitmap != null && !bitmap.isRecycled() && z17) {
            ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextSize(this.P.getTextSize());
            paint.setColor(this.G);
            paint.setFakeBoldText(this.F);
            int i19 = i16;
            for (int i26 = 0; i26 < f16.size(); i26++) {
                if (i26 == 0) {
                    i18 = this.f147193i;
                } else {
                    i18 = this.f147198m;
                }
                int i27 = i18;
                if (i26 == f16.size() - 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                f16.get(i26).l(canvas, i3, i19 + i27, true, bitmap, this.P, this.M, i17, this.U, z18);
                i19 += i27 + this.f147191h;
            }
        }
    }

    private void K(List<com.tencent.lyric.data.e> list, int i3, Canvas canvas, int i16, int i17, boolean z16, boolean z17, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, boolean z18) {
        if (list != null && i3 < list.size() && i3 >= 0) {
            com.tencent.lyric.data.e eVar = list.get(i3);
            if (z17) {
                v(eVar, canvas, i16, i17, z16, this.V0);
            } else if (z18) {
                N(eVar, canvas, i16, i17, this.P, true);
            } else {
                Q(eVar, canvas, i16, i17, this.M, this.R, n(), bitmap, bitmap2, bitmap3, i3);
            }
            H(eVar, canvas, i16, i17, true, z17, bitmap, i3);
            return;
        }
        Log.e("LyricViewInternalAIPractice", "sentences == null || current >= sentences.size()");
    }

    private void M() {
        this.f147153m1.setAntiAlias(true);
        this.f147153m1.setTextSize(3.0f);
        this.f147153m1.setColor(this.G);
        this.f147153m1.setFakeBoldText(this.F);
        this.f147154n1.setAntiAlias(true);
        this.f147154n1.setTextSize(2.0f);
        this.f147154n1.setColor(this.f147183e);
        this.f147154n1.setFakeBoldText(this.f147186f);
    }

    private void Q(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, Paint paint2, boolean z16, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i17) {
        boolean z17;
        boolean z18;
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (f16.isEmpty()) {
            return;
        }
        int i18 = this.f147191h;
        int i19 = this.f147193i + i18;
        int i26 = i18 + this.f147198m;
        com.tencent.lyric.data.f fVar = f16.get(0);
        int i27 = i16 + this.f147193i;
        if (this.f147158r1 && this.W0 && com.tencent.lyric.util.a.a().c(i17) >= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        fVar.p(canvas, i3, i27, paint, paint2, z16, z17, this.V0, bitmap2, bitmap3, this.M);
        int i28 = i16 + i19;
        for (int i29 = 1; i29 < f16.size(); i29++) {
            com.tencent.lyric.data.f fVar2 = f16.get(i29);
            int i36 = i28 + this.f147198m;
            if (this.f147158r1 && this.W0 && com.tencent.lyric.util.a.a().c(i17) >= 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            fVar2.o(canvas, i3, i36, paint, paint2, z16, z18, this.V0);
            i28 += i26;
        }
    }

    protected void I(Canvas canvas, int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, canvas, Integer.valueOf(i3), bitmap);
            return;
        }
        Paint.FontMetrics fontMetrics = this.R0.getFontMetrics();
        Rect rect = new Rect();
        int width = getWidth() - ((int) G(23.0f));
        int textSize = i3 + ((int) (((this.R0.getTextSize() - ((int) G(13.0f))) + fontMetrics.bottom) / 2.0f));
        rect.set(width, textSize, getWidth() - ((int) G(15.0f)), ((int) G(13.0f)) + textSize);
        canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
    }

    protected void J(com.tencent.lyric.data.e eVar, int[] iArr, Canvas canvas, int i3, int i16, boolean z16, boolean z17, boolean z18, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i17, boolean z19) {
        boolean z26;
        Paint paint;
        Paint paint2;
        Paint paint3;
        ArrayList<Boolean> arrayList;
        ArrayList<com.tencent.lyric.data.f> arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, eVar, iArr, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), bitmap, bitmap2, bitmap3, Integer.valueOf(i17), Boolean.valueOf(z19));
            return;
        }
        if (z18) {
            v(eVar, canvas, i3, i16, this.f147158r1 && this.W0 && com.tencent.lyric.util.a.a().c(i17) >= 0, this.V0);
            if (!this.f147148h1) {
                H(eVar, canvas, i3, i16, z16, true, bitmap, i17);
                return;
            }
            Paint paint4 = new Paint();
            paint4.setColor(this.Q0.getColor());
            paint4.setStyle(Paint.Style.FILL);
            Paint paint5 = new Paint();
            paint5.setColor(this.P.getColor());
            paint5.setTextSize(this.N.getTextSize());
            Paint paint6 = new Paint();
            paint6.setAntiAlias(true);
            paint6.setTextSize(this.N.getTextSize());
            paint6.setColor(Color.alpha(0));
            paint6.setFakeBoldText(this.f147186f);
            paint = paint4;
            paint2 = paint5;
            paint3 = paint6;
            z26 = true;
        } else {
            if (z19 && ((arrayList = this.f147159s1) == null || i17 < 0 || i17 >= arrayList.size() || !this.f147159s1.get(i17).booleanValue())) {
                N(eVar, canvas, i3, i16, this.P, true);
                return;
            }
            z26 = z16;
            paint = null;
            paint2 = null;
            paint3 = null;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (f16.isEmpty()) {
            return;
        }
        int[] h16 = eVar.h(iArr);
        int i18 = this.f147191h;
        int i19 = i18 + this.f147193i;
        int i26 = i18 + this.f147198m;
        float G = G(1.0f);
        if (bitmap3 != null && !bitmap3.isRecycled() && !z18) {
            f16.get(0).m(canvas, i3, i16 + this.f147193i, z26, bitmap3, this.M);
        }
        if (z18) {
            arrayList2 = f16;
            f16.get(0).n(canvas, h16, 0, i3, i16 + this.f147193i, paint, paint2, paint3, paint3, z26, G, z17, this.V0);
        } else {
            arrayList2 = f16;
            com.tencent.lyric.data.f fVar = arrayList2.get(0);
            int i27 = i16 + this.f147193i;
            Paint paint7 = this.Q0;
            Paint paint8 = this.R0;
            Paint paint9 = this.M;
            fVar.n(canvas, h16, 0, i3, i27, paint7, paint8, paint9, paint9, z26, G, z17, this.V0);
        }
        int i28 = i16 + i19;
        int size = 0 + arrayList2.get(0).f147080d.size();
        for (int i29 = 1; i29 < arrayList2.size(); i29++) {
            if (z18) {
                arrayList2.get(i29).n(canvas, h16, size, i3, i28 + this.f147198m, paint, paint2, paint3, paint3, z26, G, z17, this.V0);
            } else {
                com.tencent.lyric.data.f fVar2 = arrayList2.get(i29);
                int i36 = i28 + this.f147198m;
                Paint paint10 = this.Q0;
                Paint paint11 = this.R0;
                Paint paint12 = this.M;
                fVar2.n(canvas, h16, size, i3, i36, paint10, paint11, paint12, paint12, z26, G, z17, this.V0);
            }
            i28 += i26;
            size += arrayList2.get(i29).f147080d.size();
        }
        H(eVar, canvas, i3, i16, z26, z18, bitmap, i17);
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.S0 && this.T0) {
            A(true);
        } else {
            A(false);
        }
        m();
        M();
    }

    protected void N(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16));
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

    protected void O(com.tencent.lyric.data.e eVar, Canvas canvas, int i3, int i16, Paint paint, boolean z16, boolean z17, boolean z18, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i17, boolean z19) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, eVar, canvas, Integer.valueOf(i3), Integer.valueOf(i16), paint, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), bitmap, bitmap2, bitmap3, Integer.valueOf(i17), Boolean.valueOf(z19));
            return;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        if (z18) {
            v(eVar, canvas, i3, i16, z17, this.V0);
        } else if (z19) {
            N(eVar, canvas, i3, i16, this.P, true);
        } else {
            int i19 = i16;
            for (int i26 = 0; i26 < f16.size(); i26++) {
                if (i26 == 0) {
                    i18 = this.f147193i;
                } else {
                    i18 = this.f147198m;
                }
                int i27 = i18;
                if (i26 == 0 && bitmap3 != null && !bitmap3.isRecycled()) {
                    f16.get(0).m(canvas, i3, i19 + i27, z16, bitmap3, this.M);
                }
                f16.get(i26).k(canvas, i3, i19 + i27, paint, z16, z17, this.V0);
                i19 += i27 + this.f147191h;
            }
        }
        H(eVar, canvas, i3, i16, z16, z18, bitmap, i17);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void P(com.tencent.lyric.data.e eVar, int[] iArr, Canvas canvas, int i3, int i16, boolean z16, boolean z17, boolean z18, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i17, boolean z19) {
        boolean z26;
        Paint paint;
        Paint paint2;
        Paint paint3;
        int i18;
        int i19;
        ArrayList<com.tencent.lyric.data.f> arrayList;
        boolean z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, eVar, iArr, canvas, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), bitmap, bitmap2, bitmap3, Integer.valueOf(i17), Boolean.valueOf(z19));
            return;
        }
        if (z18) {
            if (this.f147158r1 && this.W0) {
                if (com.tencent.lyric.util.a.a().c(i17) >= 0) {
                    z27 = true;
                    v(eVar, canvas, i3, i16, z27, this.V0);
                    if (this.f147148h1) {
                        H(eVar, canvas, i3, i16, z16, true, bitmap, i17);
                        return;
                    }
                    Paint paint4 = new Paint();
                    paint4.setColor(this.Q0.getColor());
                    paint4.setStyle(Paint.Style.FILL);
                    Paint paint5 = new Paint();
                    paint5.setColor(this.P.getColor());
                    paint5.setTextSize(this.N.getTextSize());
                    Paint paint6 = new Paint();
                    paint6.setAntiAlias(true);
                    paint6.setTextSize(this.N.getTextSize());
                    paint6.setColor(Color.alpha(0));
                    paint6.setFakeBoldText(this.f147186f);
                    paint2 = paint5;
                    paint3 = paint6;
                    z26 = true;
                    paint = paint4;
                }
            }
            z27 = false;
            v(eVar, canvas, i3, i16, z27, this.V0);
            if (this.f147148h1) {
            }
        } else {
            z26 = z16;
            paint = null;
            paint2 = null;
            paint3 = null;
        }
        ArrayList<com.tencent.lyric.data.f> f16 = eVar.f();
        int[] h16 = eVar.h(iArr);
        float G = G(1.0f);
        int i26 = i16;
        int i27 = 0;
        int i28 = 0;
        while (i27 < f16.size()) {
            if (i27 == 0) {
                i18 = this.f147193i;
            } else {
                i18 = this.f147198m;
            }
            int i29 = i18;
            if (i27 == 0 && bitmap3 != null && !bitmap3.isRecycled() && !z18) {
                f16.get(0).m(canvas, i3, i26 + i29, z26, bitmap3, this.M);
            }
            if (z18) {
                i19 = i27;
                arrayList = f16;
                f16.get(i27).n(canvas, h16, i28, i3, i26 + i29, paint, paint2, paint3, paint3, z26, G, z17, this.V0);
            } else {
                i19 = i27;
                arrayList = f16;
                Paint paint7 = this.Q0;
                Paint paint8 = this.R0;
                Paint paint9 = this.M;
                arrayList.get(i19).n(canvas, h16, i28, i3, i26 + i29, paint7, paint8, paint9, paint9, z26, G, z17, this.V0);
            }
            i28 += arrayList.get(i19).f147080d.size();
            i26 += i29 + this.f147191h;
            i27 = i19 + 1;
            f16 = arrayList;
        }
        H(eVar, canvas, i3, i16, z26, z18, bitmap, i17);
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        super.a(i3);
        int F = F(i3 + this.f147210x0);
        this.f147201o0 = F;
        if (F != 0) {
            postInvalidate();
        }
        return this.f147201o0;
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void f() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        com.tencent.lyric.data.a aVar;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int i26;
        int i27;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.f147176b0 != 70) {
            return;
        }
        int i28 = this.f147201o0;
        ArrayList<com.tencent.lyric.data.e> arrayList2 = this.U.f147056b;
        if (arrayList2 == null) {
            return;
        }
        if (this.H == 0 && (bitmap = this.f147155o1) != null && !bitmap.isRecycled()) {
            this.H = this.f147155o1.getHeight();
        }
        int size = arrayList2.size();
        int i29 = 0;
        if (i28 < 0) {
            i28 = 0;
        }
        if (i28 >= size) {
            i28 = size - 1;
        }
        if (!arrayList2.isEmpty() && this.U.f147055a == 2) {
            int i36 = size - 1;
            if (this.f147195j0) {
                i16 = this.f147199m0;
                i3 = this.f147200n0;
            } else {
                i3 = i36;
                i16 = 0;
            }
            int[] iArr = this.J0;
            if (iArr != null) {
                i17 = iArr[i16];
            } else {
                i17 = 0;
            }
            int i37 = i17;
            int i38 = 0;
            for (int i39 = i16; i39 <= i3 && i39 <= size; i39++) {
                int[] iArr2 = this.J0;
                if (iArr2 != null && iArr2.length >= arrayList2.size()) {
                    int[] iArr3 = this.J0;
                    if (iArr3 != null) {
                        i29 = iArr3[i39];
                    }
                    if (i29 != i37) {
                        i38 += this.K0;
                    }
                    if (iArr3 != null) {
                        i37 = iArr3[i39];
                    }
                }
                com.tencent.lyric.data.e eVar = arrayList2.get(i39);
                if (i39 - i28 == 0) {
                    this.f147203q0 = i38;
                    if (this.f147207u0) {
                        int e16 = eVar.e();
                        i18 = (this.f147191h * e16) + (this.f147198m * (e16 - 1));
                        i19 = this.f147193i;
                    } else {
                        int e17 = eVar.e();
                        i18 = (this.C * e17) + (this.f147198m * (e17 - 1));
                        i19 = this.f147193i;
                    }
                } else {
                    int e18 = eVar.e();
                    i18 = (this.f147191h * e18) + (this.f147198m * (e18 - 1));
                    i19 = this.f147193i;
                }
                i38 += i18 + i19;
                if (this.f147211y0 && (aVar = this.V) != null && (arrayList = aVar.f147056b) != null && i39 < arrayList.size() && i39 >= 0) {
                    int e19 = this.V.f147056b.get(i39).e();
                    if (i39 == i28 && !this.f147207u0) {
                        i26 = (this.C * e19) + (this.f147198m * (e19 - 1));
                        i27 = this.f147193i;
                    } else {
                        i26 = (this.f147191h * e19) + (this.f147198m * (e19 - 1));
                        i27 = this.f147193i;
                    }
                    i38 += i26 + i27;
                }
            }
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        Log.i("LyricViewInternalAIPractice", "showLyricPronounce:" + z16);
        if (this.f147211y0 == z16) {
            return;
        }
        this.f147211y0 = z16;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalAIPractice.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalAIPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalAIPractice.this.requestLayout();
                        LyricViewInternalAIPractice.this.invalidate();
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f1  */
    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void i(Canvas canvas, int i3) {
        boolean z16;
        int i16;
        int i17;
        int i18;
        boolean z17;
        boolean z18;
        Bitmap bitmap;
        int i19;
        int i26;
        boolean z19;
        Bitmap bitmap2;
        int i27;
        int i28;
        int i29;
        int i36;
        boolean z26;
        boolean z27;
        ArrayList<com.tencent.lyric.data.e> arrayList;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        ArrayList<Bitmap> arrayList2;
        ArrayList<Bitmap> arrayList3;
        Bitmap bitmap3;
        Canvas canvas2 = canvas;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas2, i3);
            return;
        }
        Bitmap bitmap4 = this.f147155o1;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.H = this.f147155o1.getHeight();
        }
        int i49 = this.f147201o0;
        int i56 = this.f147191h + this.f147193i;
        ArrayList<com.tencent.lyric.data.e> arrayList4 = this.U.f147056b;
        int size = arrayList4.size();
        int i57 = 0;
        boolean z28 = false;
        if (i49 < 0) {
            i49 = 0;
        }
        boolean z29 = true;
        if (i49 >= size) {
            i49 = size - 1;
        }
        int i58 = i49;
        if (!arrayList4.isEmpty()) {
            int k3 = i3 + k();
            int i59 = this.H;
            int i65 = 2;
            if (this.U.f147055a == 2) {
                int size2 = arrayList4.size() - 1;
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
                int i66 = -1;
                int i67 = i17;
                int i68 = -1;
                int i69 = 0;
                int i75 = 0;
                while (i67 <= i16 && i67 <= arrayList4.size()) {
                    int[] iArr2 = this.J0;
                    if (iArr2 != null && iArr2.length >= arrayList4.size()) {
                        int[] iArr3 = this.J0;
                        if (iArr3 != null) {
                            i69 = iArr3[i67];
                        }
                        if (i69 != i18) {
                            i59 += this.K0;
                        }
                        if (iArr3 != null) {
                            i18 = iArr3[i67];
                        }
                    }
                    int i76 = i59;
                    int i77 = i69;
                    int i78 = i18;
                    com.tencent.lyric.data.e eVar = arrayList4.get(i67);
                    if (this.L0 == a.f147173d && (arrayList3 = this.P0) != null && (bitmap3 = arrayList3.get(i67)) != null) {
                        I(canvas2, i76, bitmap3);
                    }
                    if (i67 == i58) {
                        if (this.f147207u0) {
                            z18 = z29;
                            z17 = z28;
                        } else if (this.A0 && this.U.f147055a == i65 && !this.M0) {
                            z17 = z29;
                            z18 = z28;
                        }
                        if (!this.f147158r1) {
                            i19 = this.U.n(i67);
                            i26 = this.U.p(i67);
                            bitmap = this.f147155o1;
                        } else {
                            bitmap = null;
                            i19 = i66;
                            i26 = i19;
                        }
                        if (!this.W0 && i26 >= 0) {
                            z19 = z29;
                        } else {
                            z19 = z28;
                        }
                        if (i19 < 0 && (arrayList2 = this.f147157q1) != null) {
                            bitmap2 = arrayList2.get(i19);
                        } else {
                            bitmap2 = null;
                        }
                        if (i67 == i58) {
                            if (i26 == 0) {
                                R(z29);
                            } else {
                                R(z28);
                            }
                        }
                        if (i67 < this.H0 && i67 <= this.I0) {
                            if (this.L0 == a.f147173d) {
                                i46 = i76;
                                i27 = i68;
                                i47 = i67;
                                i28 = i16;
                                i29 = i65;
                                i36 = i58;
                                z26 = z29;
                                z27 = z28;
                                arrayList = arrayList4;
                                P(eVar, this.O0.get(i67), canvas, k3, i46, false, z19, z17, bitmap, this.f147156p1, bitmap2, i47, z18);
                            } else {
                                i46 = i76;
                                i27 = i68;
                                i47 = i67;
                                i28 = i16;
                                i29 = i65;
                                i36 = i58;
                                z26 = z29;
                                z27 = z28;
                                arrayList = arrayList4;
                                O(eVar, canvas, k3, i76, this.M, false, z19, z17, bitmap, this.f147156p1, bitmap2, i47, z18);
                            }
                            int e16 = eVar.e();
                            int i79 = (this.C * e16) + (this.f147198m * (e16 - 1));
                            int i85 = this.f147193i;
                            int i86 = i79 + i85;
                            int i87 = i46 + i86;
                            int i88 = (i85 * 2) / 3;
                            int i89 = i47;
                            if (i89 >= this.f147149i1 && i89 <= this.f147150j1) {
                                i75 += i86;
                                i48 = -1;
                                if (i27 == -1) {
                                    i68 = (i87 - i86) - (i85 / 2);
                                    i59 = i87;
                                    i39 = -1;
                                    i38 = i89;
                                }
                            } else {
                                i48 = -1;
                            }
                            i59 = i87;
                            i39 = i48;
                            i38 = i89;
                            i68 = i27;
                        } else {
                            i27 = i68;
                            i28 = i16;
                            i29 = i65;
                            i36 = i58;
                            z26 = z29;
                            z27 = z28;
                            arrayList = arrayList4;
                            int i95 = i67;
                            if (this.L0 != a.f147173d) {
                                i37 = i95;
                                J(eVar, this.O0.get(i95), canvas, k3, i76, false, z19, z17, bitmap, this.f147156p1, bitmap2, i95, z18);
                            } else {
                                i37 = i95;
                                K(arrayList, i37, canvas, k3, i76, z19, z17, bitmap, this.f147156p1, bitmap2, z18);
                            }
                            int e17 = eVar.e();
                            int i96 = (this.f147191h * e17) + (this.f147198m * (e17 - 1));
                            int i97 = this.f147193i;
                            int i98 = i96 + i97;
                            int i99 = i76 + i98;
                            int i100 = (i97 * 2) / 3;
                            i38 = i37;
                            if (i38 < this.f147149i1 && i38 <= this.f147150j1) {
                                i75 += i98;
                                i39 = -1;
                                if (i27 == -1) {
                                    i68 = (i99 - i98) - (i97 / 2);
                                    i59 = i99;
                                }
                            } else {
                                i39 = -1;
                            }
                            i59 = i99;
                            i68 = i27;
                        }
                        i67 = i38 + 1;
                        canvas2 = canvas;
                        i66 = i39;
                        i69 = i77;
                        i18 = i78;
                        i16 = i28;
                        z29 = z26;
                        i65 = i29;
                        i58 = i36;
                        z28 = z27;
                        arrayList4 = arrayList;
                    }
                    z17 = z28;
                    z18 = z17;
                    if (!this.f147158r1) {
                    }
                    if (!this.W0) {
                    }
                    z19 = z28;
                    if (i19 < 0) {
                    }
                    bitmap2 = null;
                    if (i67 == i58) {
                    }
                    if (i67 < this.H0) {
                    }
                    i27 = i68;
                    i28 = i16;
                    i29 = i65;
                    i36 = i58;
                    z26 = z29;
                    z27 = z28;
                    arrayList = arrayList4;
                    int i952 = i67;
                    if (this.L0 != a.f147173d) {
                    }
                    int e172 = eVar.e();
                    int i962 = (this.f147191h * e172) + (this.f147198m * (e172 - 1));
                    int i972 = this.f147193i;
                    int i982 = i962 + i972;
                    int i992 = i76 + i982;
                    int i1002 = (i972 * 2) / 3;
                    i38 = i37;
                    if (i38 < this.f147149i1) {
                    }
                    i39 = -1;
                    i59 = i992;
                    i68 = i27;
                    i67 = i38 + 1;
                    canvas2 = canvas;
                    i66 = i39;
                    i69 = i77;
                    i18 = i78;
                    i16 = i28;
                    z29 = z26;
                    i65 = i29;
                    i58 = i36;
                    z28 = z27;
                    arrayList4 = arrayList;
                }
                int i101 = i68;
                if (i101 != i66 && i75 != 0) {
                    canvas.drawRect(0.0f, i101, getWidth(), i101 + i75, this.f147152l1);
                    return;
                }
                return;
            }
            int i102 = i58;
            ArrayList<com.tencent.lyric.data.e> arrayList5 = arrayList4;
            int i103 = i59;
            while (i57 < arrayList5.size()) {
                int i104 = i102;
                if (i57 == i104) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ArrayList<com.tencent.lyric.data.e> arrayList6 = arrayList5;
                com.tencent.lyric.data.e eVar2 = arrayList6.get(i57);
                t(eVar2, canvas, k3, i103, z16);
                i103 += eVar2.e() * i56;
                i57++;
                i102 = i104;
                arrayList5 = arrayList6;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Log.i("LyricViewInternalAIPractice", "onMeasure");
        View view = (View) ((View) getParent()).getParent();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (this.f147176b0 == 70) {
            if (this.L0 == a.f147172c) {
                if (measuredHeight > 0) {
                    this.f147160t1 = measuredHeight;
                } else {
                    int i29 = this.f147160t1;
                    if (i29 > 0) {
                        measuredHeight = i29;
                    }
                }
            }
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
            int i36 = i19;
            int i37 = 0;
            for (int i38 = i18; i38 <= i17; i38++) {
                int[] iArr2 = this.J0;
                if (iArr2 != null && iArr2.length >= o16.size()) {
                    int[] iArr3 = this.J0;
                    if (iArr3 != null) {
                        i37 = iArr3[i38];
                    }
                    if (i37 != i36) {
                        i28 += this.K0;
                    }
                    if (iArr3 != null) {
                        i36 = iArr3[i38];
                    }
                }
                if (i38 > o16.size()) {
                    break;
                }
                com.tencent.lyric.data.e eVar = o16.get(i38);
                if (i38 >= this.H0 && i38 <= this.I0) {
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
            setMeasuredDimension(measuredWidth, (i28 + measuredHeight) - this.f147191h);
            return;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void setArrowBitmap(int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) bitmap);
            return;
        }
        if (this.O0 != null && this.P0 != null) {
            Log.i("LyricViewInternalAIPractice", "setArrowBitmap model = " + this.L0);
            if (i3 >= 0 && i3 < this.P0.size()) {
                this.f147209w0 = false;
                if (getWindowToken() != null) {
                    post(new Runnable(i3, bitmap) { // from class: com.tencent.lyric.widget.LyricViewInternalAIPractice.7
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f147164d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ Bitmap f147165e;

                        {
                            this.f147164d = i3;
                            this.f147165e = bitmap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, LyricViewInternalAIPractice.this, Integer.valueOf(i3), bitmap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            LyricViewInternalAIPractice.this.P0.remove(this.f147164d);
                            LyricViewInternalAIPractice.this.P0.add(this.f147164d, this.f147165e);
                            LyricViewInternalAIPractice.this.requestLayout();
                            LyricViewInternalAIPractice.this.invalidate();
                        }
                    });
                    return;
                }
                return;
            }
            throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.P0.size());
        }
        Log.i("LyricViewInternalAIPractice", "not init over");
    }

    public void setHightLightSegment(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.H0 = i3;
            this.I0 = i16;
        }
    }

    public void setHuanqiBitmaps(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) bitmap);
        } else {
            this.f147155o1 = bitmap;
        }
    }

    public void setLeftTipsBitmaps(ArrayList<Bitmap> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) arrayList);
        } else {
            this.f147157q1 = arrayList;
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase, com.tencent.lyric.widget.b
    public void setLyric(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar, (Object) aVar2);
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
                        iArr[i16] = a.f147171b;
                    }
                    this.O0.add(iArr);
                }
                this.f147159s1 = new ArrayList<>(size);
                this.P0 = new ArrayList<>(size);
                for (int i17 = 0; i17 < size; i17++) {
                    this.P0.add(null);
                    this.f147159s1.add(Boolean.FALSE);
                }
            }
        }
    }

    public void setLyricPracticeExternalListener(com.tencent.lyric.widget.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        }
    }

    public void setMarkCharacter(int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3, (Object) iArr);
            return;
        }
        if (this.O0 == null) {
            Log.i("LyricViewInternalAIPractice", "not init over");
            return;
        }
        Log.i("LyricViewInternalAIPractice", "setMarkCharacter model = " + this.L0);
        if (i3 >= 0 && i3 < this.O0.size()) {
            if (iArr.length == this.O0.get(i3).length) {
                this.f147209w0 = false;
                this.f147148h1 = true;
                if (getWindowToken() != null) {
                    post(new Runnable(i3, iArr) { // from class: com.tencent.lyric.widget.LyricViewInternalAIPractice.5
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f147162d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int[] f147163e;

                        {
                            this.f147162d = i3;
                            this.f147163e = iArr;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, LyricViewInternalAIPractice.this, Integer.valueOf(i3), iArr);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            LyricViewInternalAIPractice.this.O0.remove(this.f147162d);
                            LyricViewInternalAIPractice.this.O0.add(this.f147162d, this.f147163e);
                            LyricViewInternalAIPractice.this.requestLayout();
                            LyricViewInternalAIPractice.this.invalidate();
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

    public void setMaskSegment(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f147149i1 = i3;
        this.f147150j1 = i16;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalAIPractice.11
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalAIPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalAIPractice.this.invalidate();
                    }
                }
            });
        }
    }

    @Override // com.tencent.lyric.widget.LyricViewInternalBase
    public void setOrdinaryTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        super.setOrdinaryTextColor(i3);
        this.f147154n1.setColor(this.f147183e);
        invalidate();
    }

    public void setPracticeModel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        this.L0 = i3;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalAIPractice.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalAIPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalAIPractice.this.requestLayout();
                        LyricViewInternalAIPractice.this.invalidate();
                    }
                }
            });
        }
    }

    public void setSegmentInternal(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        this.K0 = i3;
        this.f147209w0 = false;
        this.f147209w0 = false;
        if (getWindowToken() != null) {
            post(new Runnable() { // from class: com.tencent.lyric.widget.LyricViewInternalAIPractice.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewInternalAIPractice.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewInternalAIPractice.this.requestLayout();
                        LyricViewInternalAIPractice.this.invalidate();
                    }
                }
            });
        }
    }

    public void setUpTipsBitmaps(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bitmap);
        } else {
            this.f147156p1 = bitmap;
        }
    }

    private void R(boolean z16) {
    }
}
