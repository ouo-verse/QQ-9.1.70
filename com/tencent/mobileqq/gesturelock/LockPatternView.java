package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class LockPatternView extends View {
    static IPatchRedirector $redirector_;
    private boolean[][] C;
    private float D;
    private float E;
    private long F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private float M;
    private final int N;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f213637a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f213638b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f213639c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f213640d;

    /* renamed from: d0, reason: collision with root package name */
    private int f213641d0;

    /* renamed from: e, reason: collision with root package name */
    private Paint f213642e;

    /* renamed from: e0, reason: collision with root package name */
    private float f213643e0;

    /* renamed from: f, reason: collision with root package name */
    private Paint f213644f;

    /* renamed from: f0, reason: collision with root package name */
    private final Path f213645f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Rect f213646g0;

    /* renamed from: h, reason: collision with root package name */
    private Paint f213647h;

    /* renamed from: h0, reason: collision with root package name */
    private int f213648h0;

    /* renamed from: i, reason: collision with root package name */
    private b f213649i;

    /* renamed from: i0, reason: collision with root package name */
    private int f213650i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f213651j0;

    /* renamed from: k0, reason: collision with root package name */
    private final Matrix f213652k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f213653l0;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<a> f213654m;

    /* renamed from: m0, reason: collision with root package name */
    private int f213655m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f213656n0;

    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        static a[][] f213657c;

        /* renamed from: a, reason: collision with root package name */
        int f213658a;

        /* renamed from: b, reason: collision with root package name */
        int f213659b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72485);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
                return;
            }
            f213657c = (a[][]) Array.newInstance((Class<?>) a.class, 3, 3);
            for (int i3 = 0; i3 < 3; i3++) {
                for (int i16 = 0; i16 < 3; i16++) {
                    f213657c[i3][i16] = new a(i3, i16);
                }
            }
        }

        a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            a(i3, i16);
            this.f213658a = i3;
            this.f213659b = i16;
        }

        private static void a(int i3, int i16) {
            if (i3 >= 0 && i3 <= 2) {
                if (i16 >= 0 && i16 <= 2) {
                    return;
                } else {
                    throw new IllegalArgumentException("column must be in range 0-2");
                }
            }
            throw new IllegalArgumentException("row must be in range 0-2");
        }

        public static synchronized a d(int i3, int i16) {
            a aVar;
            synchronized (a.class) {
                a(i3, i16);
                aVar = f213657c[i3][i16];
            }
            return aVar;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f213659b;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f213658a;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "(row=" + this.f213658a + ",clmn=" + this.f213659b + ")";
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void onPatternCellAdded(List<a> list);

        void onPatternCleared();

        void onPatternDetected(List<a> list);

        void onPatternStart();
    }

    public LockPatternView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(a aVar) {
        this.C[aVar.c()][aVar.b()] = true;
        this.f213654m.add(aVar);
        n(aVar);
    }

    private a b(float f16, float f17) {
        int i3;
        int j3 = j(f17);
        if (j3 < 0 || (i3 = i(f16)) < 0 || this.C[j3][i3]) {
            return null;
        }
        return a.d(j3, i3);
    }

    private void d() {
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i16 = 0; i16 < 3; i16++) {
                this.C[i3][i16] = false;
            }
        }
    }

    private a e(float f16, float f17) {
        int i3;
        a b16 = b(f16, f17);
        a aVar = null;
        if (b16 == null) {
            return null;
        }
        ArrayList<a> arrayList = this.f213654m;
        if (!arrayList.isEmpty()) {
            a aVar2 = arrayList.get(arrayList.size() - 1);
            int i16 = b16.f213658a;
            int i17 = aVar2.f213658a;
            int i18 = i16 - i17;
            int i19 = b16.f213659b;
            int i26 = aVar2.f213659b;
            int i27 = i19 - i26;
            int i28 = -1;
            if (Math.abs(i18) == 2 && Math.abs(i27) != 1) {
                int i29 = aVar2.f213658a;
                if (i18 > 0) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                i17 = i29 + i3;
            }
            if (Math.abs(i27) == 2 && Math.abs(i18) != 1) {
                int i36 = aVar2.f213659b;
                if (i27 > 0) {
                    i28 = 1;
                }
                i26 = i36 + i28;
            }
            aVar = a.d(i17, i26);
        }
        if (this.L && aVar != null && !this.C[aVar.f213658a][aVar.f213659b]) {
            a(aVar);
        }
        a(b16);
        if (this.J) {
            performHapticFeedback(1, 3);
        }
        return b16;
    }

    private void f(Canvas canvas, int i3, int i16, boolean z16) {
        int i17;
        int i18;
        int i19;
        if (z16 && (!this.I || this.G == 2)) {
            if (this.K) {
                i17 = this.W;
                i18 = this.T;
                i19 = this.f213639c0;
            } else {
                int i26 = this.G;
                if (i26 == 2) {
                    i17 = this.f213637a0;
                    i18 = this.U;
                    i19 = this.f213641d0;
                } else {
                    if (i26 != 0 && i26 != 1) {
                        throw new IllegalStateException("unknown display mode " + this.G);
                    }
                    i17 = this.W;
                    i18 = this.T;
                    i19 = this.f213639c0;
                }
            }
        } else {
            i17 = this.V;
            i18 = this.S;
            i19 = this.f213638b0;
        }
        float f16 = this.Q;
        float f17 = this.R;
        float min = Math.min(f16 / this.f213648h0, 1.0f);
        float min2 = Math.min(this.R / this.f213650i0, 1.0f);
        this.f213652k0.setTranslate(((int) ((f16 - r11) / 2.0f)) + i3, ((int) ((f17 - ((int) ((3.0f * f17) / 4.0f))) / 2.0f)) + i16);
        this.f213652k0.preTranslate(this.f213648h0 / 2, this.f213650i0 / 2);
        this.f213652k0.preScale(min, min2);
        this.f213652k0.preTranslate((-this.f213648h0) / 2, (-this.f213650i0) / 2);
        float f18 = i3 + (f16 / 2.0f);
        float f19 = i16 + (f17 / 2.0f);
        this.f213647h.setColor(i19);
        this.f213647h.setStyle(Paint.Style.FILL);
        float f26 = ((int) ((f16 * 3.0f) / 4.0f)) / 2;
        canvas.drawCircle(f18, f19, f26, this.f213647h);
        this.f213647h.setColor(i18);
        canvas.drawCircle(f18, f19, (r11 * 18) / 100, this.f213647h);
        this.f213647h.setColor(i17);
        this.f213647h.setStyle(Paint.Style.STROKE);
        this.f213647h.setStrokeWidth(this.f213643e0);
        canvas.drawCircle(f18, f19, f26, this.f213647h);
    }

    private float g(int i3) {
        float paddingLeft = getPaddingLeft();
        float f16 = this.Q;
        return paddingLeft + (i3 * f16) + (f16 / 2.0f);
    }

    private float h(int i3) {
        float paddingTop = getPaddingTop();
        float f16 = this.R;
        return paddingTop + (i3 * f16) + (f16 / 2.0f);
    }

    private int i(float f16) {
        float f17 = this.Q;
        float f18 = this.P * f17;
        float paddingLeft = getPaddingLeft() + ((f17 - f18) / 2.0f);
        for (int i3 = 0; i3 < 3; i3++) {
            float f19 = (i3 * f17) + paddingLeft;
            if (f16 >= f19 && f16 <= f19 + f18) {
                return i3;
            }
        }
        return -1;
    }

    private int j(float f16) {
        float f17 = this.R;
        float f18 = this.P * f17;
        float paddingTop = getPaddingTop() + ((f17 - f18) / 2.0f);
        for (int i3 = 0; i3 < 3; i3++) {
            float f19 = (i3 * f17) + paddingTop;
            if (f16 >= f19 && f16 <= f19 + f18) {
                return i3;
            }
        }
        return -1;
    }

    private void k(MotionEvent motionEvent) {
        r();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        a e16 = e(x16, y16);
        if (e16 != null) {
            this.K = true;
            this.G = 0;
            q();
        } else {
            this.K = false;
            o();
        }
        if (e16 != null) {
            float g16 = g(e16.f213659b);
            float h16 = h(e16.f213658a);
            float f16 = this.Q / 2.0f;
            float f17 = this.R / 2.0f;
            invalidate((int) (g16 - f16), (int) (h16 - f17), (int) (g16 + f16), (int) (h16 + f17));
        }
        this.D = x16;
        this.E = y16;
    }

    private void l(MotionEvent motionEvent) {
        float x16;
        float y16;
        int i3;
        int i16;
        float f16;
        float f17;
        float f18;
        float f19;
        MotionEvent motionEvent2 = motionEvent;
        int historySize = motionEvent.getHistorySize();
        int i17 = 0;
        while (i17 < historySize + 1) {
            if (i17 < historySize) {
                x16 = motionEvent2.getHistoricalX(i17);
            } else {
                x16 = motionEvent.getX();
            }
            if (i17 < historySize) {
                y16 = motionEvent2.getHistoricalY(i17);
            } else {
                y16 = motionEvent.getY();
            }
            int size = this.f213654m.size();
            a e16 = e(x16, y16);
            int size2 = this.f213654m.size();
            if (e16 != null && size2 == 1) {
                this.K = true;
                q();
            }
            if (Math.abs(x16 - this.D) + Math.abs(y16 - this.E) > 0.0f) {
                float f26 = this.D;
                float f27 = this.E;
                this.D = x16;
                this.E = y16;
                if (this.K && size2 > 0) {
                    ArrayList<a> arrayList = this.f213654m;
                    float f28 = this.Q * this.M * 0.5f;
                    int i18 = size2 - 1;
                    a aVar = arrayList.get(i18);
                    float g16 = g(aVar.f213659b);
                    float h16 = h(aVar.f213658a);
                    Rect rect = this.f213646g0;
                    if (g16 < x16) {
                        f16 = x16;
                        x16 = g16;
                    } else {
                        f16 = g16;
                    }
                    if (h16 < y16) {
                        f17 = y16;
                        y16 = h16;
                    } else {
                        f17 = h16;
                    }
                    i3 = historySize;
                    int i19 = (int) (f16 + f28);
                    i16 = i17;
                    rect.set((int) (x16 - f28), (int) (y16 - f28), i19, (int) (f17 + f28));
                    if (g16 < f26) {
                        g16 = f26;
                        f26 = g16;
                    }
                    if (h16 < f27) {
                        h16 = f27;
                        f27 = h16;
                    }
                    rect.union((int) (f26 - f28), (int) (f27 - f28), (int) (g16 + f28), (int) (h16 + f28));
                    if (e16 != null) {
                        float g17 = g(e16.f213659b);
                        float h17 = h(e16.f213658a);
                        if (size2 >= 2) {
                            a aVar2 = arrayList.get(i18 - (size2 - size));
                            f18 = g(aVar2.f213659b);
                            f19 = h(aVar2.f213658a);
                            if (g17 >= f18) {
                                f18 = g17;
                                g17 = f18;
                            }
                            if (h17 >= f19) {
                                f19 = h17;
                                h17 = f19;
                            }
                        } else {
                            f18 = g17;
                            f19 = h17;
                        }
                        float f29 = this.Q / 1.0f;
                        float f36 = this.R / 1.0f;
                        rect.set((int) (g17 - f29), (int) (h17 - f36), (int) (f18 + f29), (int) (f19 + f36));
                    }
                    invalidate(rect);
                } else {
                    i3 = historySize;
                    i16 = i17;
                    invalidate();
                }
            } else {
                i3 = historySize;
                i16 = i17;
            }
            i17 = i16 + 1;
            motionEvent2 = motionEvent;
            historySize = i3;
        }
    }

    private void m(MotionEvent motionEvent) {
        if (!this.f213654m.isEmpty()) {
            this.K = false;
            p();
            invalidate();
        }
    }

    private void n(a aVar) {
        b bVar = this.f213649i;
        if (bVar != null) {
            bVar.onPatternCellAdded(this.f213654m);
        }
        if (aVar != null) {
            u(String.format("%d", Integer.valueOf((aVar.c() * 3) + aVar.b() + 1)));
        } else {
            t(R.string.f171098c63);
        }
    }

    private void o() {
        b bVar = this.f213649i;
        if (bVar != null) {
            bVar.onPatternCleared();
        }
        t(R.string.f171099c64);
    }

    private void p() {
        b bVar = this.f213649i;
        if (bVar != null) {
            bVar.onPatternDetected(this.f213654m);
        }
        t(R.string.c65);
    }

    private void q() {
        b bVar = this.f213649i;
        if (bVar != null) {
            bVar.onPatternStart();
        }
    }

    private void r() {
        this.f213654m.clear();
        d();
        this.G = 0;
        invalidate();
    }

    private int s(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                return size;
            }
            return i16;
        }
        return Math.min(size, i16);
    }

    private void t(int i3) {
        setContentDescription(getContext().getString(i3));
        sendAccessibilityEvent(4);
        setContentDescription(null);
    }

    private void u(String str) {
        setContentDescription(str);
        sendAccessibilityEvent(4);
        setContentDescription(null);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            r();
        }
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f213650i0 * 3;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f213648h0 * 3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        ArrayList<a> arrayList = this.f213654m;
        int size = arrayList.size();
        boolean[][] zArr = this.C;
        if (this.G == 1) {
            int elapsedRealtime = (((int) (SystemClock.elapsedRealtime() - this.F)) % ((size + 1) * 700)) / 700;
            d();
            for (int i3 = 0; i3 < elapsedRealtime; i3++) {
                a aVar = arrayList.get(i3);
                zArr[aVar.c()][aVar.b()] = true;
            }
            if (elapsedRealtime > 0 && elapsedRealtime < size) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                float f16 = (r8 % 700) / 700.0f;
                a aVar2 = arrayList.get(elapsedRealtime - 1);
                float g16 = g(aVar2.f213659b);
                float h16 = h(aVar2.f213658a);
                a aVar3 = arrayList.get(elapsedRealtime);
                float g17 = (g(aVar3.f213659b) - g16) * f16;
                float h17 = f16 * (h(aVar3.f213658a) - h16);
                this.D = g16 + g17;
                this.E = h16 + h17;
            }
            invalidate();
        }
        float f17 = this.Q;
        float f18 = this.R;
        Path path = this.f213645f0;
        path.rewind();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        if (this.I && this.G != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if ((this.f213642e.getFlags() & 2) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f213642e.setFilterBitmap(true);
        int i16 = 0;
        while (true) {
            if (i16 >= 3) {
                break;
            }
            float f19 = paddingTop + (i16 * f18);
            int i17 = 0;
            for (int i18 = 3; i17 < i18; i18 = 3) {
                f(canvas, (int) (paddingLeft + (i17 * f17)), (int) f19, zArr[i16][i17]);
                i17++;
                f18 = f18;
                f17 = f17;
            }
            i16++;
        }
        if (z16) {
            if (this.G != 2) {
                this.f213644f.setColor(this.f213653l0);
            } else {
                this.f213644f.setColor(this.f213655m0);
            }
            int i19 = 0;
            boolean z19 = false;
            while (i19 < size) {
                a aVar4 = arrayList.get(i19);
                boolean[] zArr2 = zArr[aVar4.f213658a];
                int i26 = aVar4.f213659b;
                if (!zArr2[i26]) {
                    break;
                }
                float g18 = g(i26);
                float h18 = h(aVar4.f213658a);
                if (i19 == 0) {
                    path.moveTo(g18, h18);
                } else {
                    path.lineTo(g18, h18);
                }
                i19++;
                z19 = true;
            }
            if ((this.K || this.G == 1) && z19) {
                path.lineTo(this.D, this.E);
            }
            canvas.drawPath(path, this.f213644f);
        }
        this.f213642e.setFilterBitmap(z17);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int s16 = s(i3, suggestedMinimumWidth);
        int s17 = s(i16, suggestedMinimumHeight);
        int i17 = this.f213651j0;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    s16 = Math.min(s16, s17);
                }
            } else {
                s17 = Math.min(s16, s17);
            }
        } else {
            s16 = Math.min(s16, s17);
            s17 = s16;
        }
        setMeasuredDimension(s16, s17);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.Q = ((i3 - getPaddingLeft()) - getPaddingRight()) / 3.0f;
            this.R = ((i16 - getPaddingTop()) - getPaddingBottom()) / 3.0f;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.H || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                    r();
                    this.K = false;
                    o();
                    return true;
                }
                l(motionEvent);
                return true;
            }
            m(motionEvent);
            return true;
        }
        k(motionEvent);
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void setDisplayMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.G = i3;
        if (i3 == 1) {
            if (this.f213654m.size() != 0) {
                this.F = SystemClock.elapsedRealtime();
                a aVar = this.f213654m.get(0);
                this.D = g(aVar.b());
                this.E = h(aVar.c());
                d();
            } else {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
        }
        invalidate();
    }

    public void setFillInGapCell(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.L = z16;
        }
    }

    public void setOnPatternListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.f213649i = bVar;
        }
    }

    public void setTactileFeedbackEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.J = z16;
        }
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f213640d = false;
        this.f213642e = new Paint();
        this.f213644f = new Paint();
        this.f213647h = new Paint();
        this.f213654m = new ArrayList<>(9);
        this.C = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 3, 3);
        this.D = -1.0f;
        this.E = -1.0f;
        this.G = 0;
        this.H = true;
        this.I = false;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = 0.3f;
        this.N = 128;
        this.P = 0.6f;
        this.f213643e0 = 3.0f;
        this.f213645f0 = new Path();
        this.f213646g0 = new Rect();
        this.f213652k0 = new Matrix();
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.LockPatternView);
                String string = typedArray.getString(R.styleable.LockPatternView_aspect);
                if ("square".equals(string)) {
                    this.f213651j0 = 0;
                } else if ("lock_width".equals(string)) {
                    this.f213651j0 = 1;
                } else if ("lock_height".equals(string)) {
                    this.f213651j0 = 2;
                } else {
                    this.f213651j0 = 0;
                }
                setClickable(true);
                this.f213653l0 = getResources().getColor(R.color.qui_common_brand_standard);
                this.f213655m0 = getResources().getColor(R.color.qui_common_feedback_error);
                this.f213656n0 = getResources().getDimensionPixelSize(R.dimen.f158943t2);
                this.f213644f.setAntiAlias(true);
                this.f213644f.setDither(true);
                this.f213644f.setColor(this.f213653l0);
                this.f213644f.setStyle(Paint.Style.STROKE);
                this.f213644f.setStrokeJoin(Paint.Join.ROUND);
                this.f213644f.setStrokeCap(Paint.Cap.ROUND);
                this.f213644f.setStrokeWidth(this.f213656n0);
                this.f213647h.setAntiAlias(true);
                this.f213647h.setStyle(Paint.Style.FILL);
                this.f213647h.setColor(this.S);
                this.S = getResources().getColor(R.color.f157103ju);
                this.T = getResources().getColor(R.color.qui_common_brand_standard);
                this.U = getResources().getColor(R.color.qui_common_brand_standard);
                this.V = getResources().getColor(R.color.qui_common_icon_primary);
                this.W = getResources().getColor(R.color.qui_common_brand_standard);
                this.f213637a0 = getResources().getColor(R.color.qui_common_brand_standard);
                this.f213638b0 = getResources().getColor(R.color.f157100jr);
                this.f213639c0 = getResources().getColor(R.color.f157100jr);
                this.f213641d0 = getResources().getColor(R.color.f157100jr);
                this.f213643e0 = getResources().getDimensionPixelSize(R.dimen.f158944t3);
                this.f213648h0 = getWidth() / 4;
                this.f213650i0 = getHeight() / 4;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("LockPatternView", 2, "LockPatternView()", e16);
                }
                if (typedArray == null) {
                    return;
                }
            }
            typedArray.recycle();
        } catch (Throwable th5) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th5;
        }
    }
}
