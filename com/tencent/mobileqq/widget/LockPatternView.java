package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes20.dex */
public class LockPatternView extends View {
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
    private int f315775a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f315776b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f315777c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f315778d;

    /* renamed from: d0, reason: collision with root package name */
    private int f315779d0;

    /* renamed from: e, reason: collision with root package name */
    private Paint f315780e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f315781e0;

    /* renamed from: f, reason: collision with root package name */
    private Paint f315782f;

    /* renamed from: f0, reason: collision with root package name */
    private float f315783f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Path f315784g0;

    /* renamed from: h, reason: collision with root package name */
    private Paint f315785h;

    /* renamed from: h0, reason: collision with root package name */
    private final Rect f315786h0;

    /* renamed from: i, reason: collision with root package name */
    private b f315787i;

    /* renamed from: i0, reason: collision with root package name */
    private int f315788i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f315789j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f315790k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Matrix f315791l0;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<a> f315792m;

    /* renamed from: m0, reason: collision with root package name */
    private final Matrix f315793m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f315794n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f315795o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f315796p0;

    /* loaded from: classes20.dex */
    private static class SavedState extends View.BaseSavedState {

        /* renamed from: d, reason: collision with root package name */
        private final String f315797d;

        /* renamed from: e, reason: collision with root package name */
        private final int f315798e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f315799f;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f315800h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f315801i;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f315797d);
            parcel.writeInt(this.f315798e);
            parcel.writeValue(Boolean.valueOf(this.f315799f));
            parcel.writeValue(Boolean.valueOf(this.f315800h));
            parcel.writeValue(Boolean.valueOf(this.f315801i));
        }
    }

    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        static a[][] f315802c = (a[][]) Array.newInstance((Class<?>) a.class, 3, 3);

        /* renamed from: a, reason: collision with root package name */
        int f315803a;

        /* renamed from: b, reason: collision with root package name */
        int f315804b;

        static {
            for (int i3 = 0; i3 < 3; i3++) {
                for (int i16 = 0; i16 < 3; i16++) {
                    f315802c[i3][i16] = new a(i3, i16);
                }
            }
        }

        a(int i3, int i16) {
            a(i3, i16);
            this.f315803a = i3;
            this.f315804b = i16;
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
                aVar = f315802c[i3][i16];
            }
            return aVar;
        }

        public int b() {
            return this.f315804b;
        }

        public int c() {
            return this.f315803a;
        }

        public String toString() {
            return "(row=" + this.f315803a + ",clmn=" + this.f315804b + ")";
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
        void onPatternCellAdded(List<a> list);

        void onPatternCleared();

        void onPatternDetected(List<a> list);

        void onPatternStart();
    }

    public LockPatternView(Context context) {
        this(context, null);
    }

    private void a(a aVar) {
        this.C[aVar.c()][aVar.b()] = true;
        this.f315792m.add(aVar);
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
        ArrayList<a> arrayList = this.f315792m;
        if (!arrayList.isEmpty()) {
            a aVar2 = arrayList.get(arrayList.size() - 1);
            int i16 = b16.f315803a;
            int i17 = aVar2.f315803a;
            int i18 = i16 - i17;
            int i19 = b16.f315804b;
            int i26 = aVar2.f315804b;
            int i27 = i19 - i26;
            int i28 = -1;
            if (Math.abs(i18) == 2 && Math.abs(i27) != 1) {
                int i29 = aVar2.f315803a;
                if (i18 > 0) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                i17 = i29 + i3;
            }
            if (Math.abs(i27) == 2 && Math.abs(i18) != 1) {
                int i36 = aVar2.f315804b;
                if (i27 > 0) {
                    i28 = 1;
                }
                i26 = i36 + i28;
            }
            aVar = a.d(i17, i26);
        }
        if (this.L && aVar != null && !this.C[aVar.f315803a][aVar.f315804b]) {
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
                i19 = this.f315777c0;
            } else {
                int i26 = this.G;
                if (i26 == 2) {
                    i17 = this.f315775a0;
                    i18 = this.U;
                    i19 = this.f315779d0;
                } else {
                    if (i26 != 0 && i26 != 1) {
                        throw new IllegalStateException("unknown display mode " + this.G);
                    }
                    i17 = this.V;
                    i18 = this.T;
                    i19 = this.f315777c0;
                }
            }
        } else {
            i17 = this.V;
            i18 = this.S;
            i19 = this.f315776b0;
        }
        float f16 = this.Q;
        float f17 = this.R;
        float min = Math.min(f16 / this.f315788i0, 1.0f);
        float min2 = Math.min(this.R / this.f315789j0, 1.0f);
        this.f315793m0.setTranslate(((int) ((f16 - r11) / 2.0f)) + i3, ((int) ((f17 - ((int) ((3.0f * f17) / 4.0f))) / 2.0f)) + i16);
        this.f315793m0.preTranslate(this.f315788i0 / 2, this.f315789j0 / 2);
        this.f315793m0.preScale(min, min2);
        this.f315793m0.preTranslate((-this.f315788i0) / 2, (-this.f315789j0) / 2);
        float f18 = i3 + (f16 / 2.0f);
        float f19 = i16 + (f17 / 2.0f);
        this.f315785h.setColor(i19);
        this.f315785h.setStyle(Paint.Style.FILL);
        float f26 = ((int) ((f16 * 3.0f) / 4.0f)) / 2;
        canvas.drawCircle(f18, f19, f26, this.f315785h);
        this.f315785h.setColor(i18);
        canvas.drawCircle(f18, f19, (r11 * 18) / 100, this.f315785h);
        this.f315785h.setColor(i17);
        this.f315785h.setStyle(Paint.Style.STROKE);
        this.f315785h.setStrokeWidth(this.f315783f0);
        canvas.drawCircle(f18, f19, f26, this.f315785h);
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
            float g16 = g(e16.f315804b);
            float h16 = h(e16.f315803a);
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
            int size = this.f315792m.size();
            a e16 = e(x16, y16);
            int size2 = this.f315792m.size();
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
                    ArrayList<a> arrayList = this.f315792m;
                    float f28 = this.Q * this.M * 0.5f;
                    int i18 = size2 - 1;
                    a aVar = arrayList.get(i18);
                    float g16 = g(aVar.f315804b);
                    float h16 = h(aVar.f315803a);
                    i3 = historySize;
                    Rect rect = this.f315786h0;
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
                    i16 = i17;
                    rect.set((int) (x16 - f28), (int) (y16 - f28), (int) (f16 + f28), (int) (f17 + f28));
                    if (g16 < f26) {
                        f26 = g16;
                        g16 = f26;
                    }
                    if (h16 < f27) {
                        h16 = f27;
                        f27 = h16;
                    }
                    rect.union((int) (f26 - f28), (int) (f27 - f28), (int) (g16 + f28), (int) (h16 + f28));
                    if (e16 != null) {
                        float g17 = g(e16.f315804b);
                        float h17 = h(e16.f315803a);
                        if (size2 >= 2) {
                            a aVar2 = arrayList.get(i18 - (size2 - size));
                            f18 = g(aVar2.f315804b);
                            f19 = h(aVar2.f315803a);
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
                    QLog.d("LockPatternView", 4, "move invalidate.rect=" + rect);
                    invalidate(rect);
                } else {
                    i3 = historySize;
                    i16 = i17;
                    QLog.d("LockPatternView", 4, "move invalidate.all");
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
        if (!this.f315792m.isEmpty()) {
            this.K = false;
            p();
            invalidate();
        }
    }

    private void n(a aVar) {
        b bVar = this.f315787i;
        if (bVar != null) {
            bVar.onPatternCellAdded(this.f315792m);
        }
        if (aVar != null) {
            u(String.format("%d", Integer.valueOf((aVar.c() * 3) + aVar.b() + 1)));
        } else {
            t(R.string.f171098c63);
        }
    }

    private void o() {
        b bVar = this.f315787i;
        if (bVar != null) {
            bVar.onPatternCleared();
        }
        t(R.string.f171099c64);
    }

    private void p() {
        b bVar = this.f315787i;
        if (bVar != null) {
            bVar.onPatternDetected(this.f315792m);
        }
        t(R.string.c65);
    }

    private void q() {
        b bVar = this.f315787i;
        if (bVar != null) {
            bVar.onPatternStart();
        }
    }

    private void r() {
        this.f315792m.clear();
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
        r();
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return this.f315789j0 * 3;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return this.f315788i0 * 3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        boolean z17;
        boolean z18;
        ArrayList<a> arrayList = this.f315792m;
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
                float g16 = g(aVar2.f315804b);
                float h16 = h(aVar2.f315803a);
                a aVar3 = arrayList.get(elapsedRealtime);
                float g17 = (g(aVar3.f315804b) - g16) * f16;
                float h17 = f16 * (h(aVar3.f315803a) - h16);
                this.D = g16 + g17;
                this.E = h16 + h17;
            }
            invalidate();
        }
        float f17 = this.Q;
        float f18 = this.R;
        Path path = this.f315784g0;
        path.rewind();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        if (this.I && this.G != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if ((this.f315780e.getFlags() & 2) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f315780e.setFilterBitmap(true);
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
                this.f315782f.setColor(this.f315794n0);
            } else {
                this.f315782f.setColor(this.f315795o0);
            }
            int i19 = 0;
            boolean z19 = false;
            while (i19 < size) {
                a aVar4 = arrayList.get(i19);
                boolean[] zArr2 = zArr[aVar4.f315803a];
                int i26 = aVar4.f315804b;
                if (!zArr2[i26]) {
                    break;
                }
                float g18 = g(i26);
                float h18 = h(aVar4.f315803a);
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
            canvas.drawPath(path, this.f315782f);
        }
        this.f315780e.setFilterBitmap(z17);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int s16 = s(i3, suggestedMinimumWidth);
        int s17 = s(i16, suggestedMinimumHeight);
        int i17 = this.f315790k0;
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
        this.Q = ((i3 - getPaddingLeft()) - getPaddingRight()) / 3.0f;
        this.R = ((i16 - getPaddingTop()) - getPaddingBottom()) / 3.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
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
        this.G = i3;
        if (i3 == 1) {
            if (this.f315792m.size() != 0) {
                this.F = SystemClock.elapsedRealtime();
                a aVar = this.f315792m.get(0);
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
        this.L = z16;
    }

    public void setInStealthMode(boolean z16) {
        this.I = z16;
    }

    public void setOnPatternListener(b bVar) {
        this.f315787i = bVar;
    }

    public void setPattern(int i3, List<a> list) {
        this.f315792m.clear();
        this.f315792m.addAll(list);
        d();
        for (a aVar : list) {
            this.C[aVar.c()][aVar.b()] = true;
        }
        setDisplayMode(i3);
    }

    public void setTactileFeedbackEnabled(boolean z16) {
        this.J = z16;
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315778d = false;
        this.f315780e = new Paint();
        this.f315782f = new Paint();
        this.f315785h = new Paint();
        this.f315792m = new ArrayList<>(9);
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
        this.f315781e0 = false;
        this.f315783f0 = 3.0f;
        this.f315784g0 = new Path();
        this.f315786h0 = new Rect();
        this.f315791l0 = new Matrix();
        this.f315793m0 = new Matrix();
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, jj2.b.N3);
                String string = typedArray.getString(jj2.b.O3);
                if ("square".equals(string)) {
                    this.f315790k0 = 0;
                } else if ("lock_width".equals(string)) {
                    this.f315790k0 = 1;
                } else if ("lock_height".equals(string)) {
                    this.f315790k0 = 2;
                } else {
                    this.f315790k0 = 0;
                }
                setClickable(true);
                this.f315794n0 = getResources().getColor(R.color.f157109k0);
                this.f315795o0 = getResources().getColor(R.color.f157110k1);
                this.f315796p0 = getResources().getDimensionPixelSize(R.dimen.f158943t2);
                this.f315782f.setAntiAlias(true);
                this.f315782f.setDither(true);
                this.f315782f.setColor(this.f315794n0);
                this.f315782f.setStyle(Paint.Style.STROKE);
                this.f315782f.setStrokeJoin(Paint.Join.ROUND);
                this.f315782f.setStrokeCap(Paint.Cap.ROUND);
                this.f315782f.setStrokeWidth(this.f315796p0);
                this.f315785h.setAntiAlias(true);
                this.f315785h.setStyle(Paint.Style.FILL);
                this.f315785h.setColor(this.S);
                this.S = getResources().getColor(R.color.f157103ju);
                this.T = getResources().getColor(R.color.f157104jv);
                this.U = getResources().getColor(R.color.f157105jw);
                this.V = getResources().getColor(R.color.f157106jx);
                this.W = getResources().getColor(R.color.f157107jy);
                this.f315775a0 = getResources().getColor(R.color.f157108jz);
                this.f315776b0 = getResources().getColor(R.color.f157100jr);
                this.f315777c0 = getResources().getColor(R.color.f157101js);
                this.f315779d0 = getResources().getColor(R.color.f157102jt);
                this.f315783f0 = getResources().getDimensionPixelSize(R.dimen.f158944t3);
                this.f315788i0 = getWidth() / 4;
                this.f315789j0 = getHeight() / 4;
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
