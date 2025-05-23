package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.FlipLoadingLayout;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.RotateLoadingLayout;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private float C;
    private float D;
    private float E;
    private float F;
    private boolean G;
    private State H;
    private Mode I;
    private Mode J;
    private FrameLayout K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private Interpolator T;
    private AnimationStyle U;
    private d<T> V;
    private c<T> W;

    /* renamed from: a0, reason: collision with root package name */
    private PullToRefreshBase<T>.SmoothScrollRunnable f264227a0;

    /* renamed from: d, reason: collision with root package name */
    public int f264228d;

    /* renamed from: e, reason: collision with root package name */
    public int f264229e;

    /* renamed from: f, reason: collision with root package name */
    protected T f264230f;

    /* renamed from: h, reason: collision with root package name */
    protected LoadingLayoutBase f264231h;

    /* renamed from: i, reason: collision with root package name */
    protected LoadingLayoutBase f264232i;

    /* renamed from: m, reason: collision with root package name */
    private int f264233m;

    /* loaded from: classes16.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP;

        static AnimationStyle getDefault() {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i3) {
            if (i3 != 1) {
                return ROTATE;
            }
            return FLIP;
        }

        LoadingLayoutBase createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            if (b.f264244d[ordinal()] != 2) {
                return new RotateLoadingLayout(context, mode, orientation, typedArray);
            }
            return new FlipLoadingLayout(context, mode, orientation, typedArray);
        }
    }

    /* loaded from: classes16.dex */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);

        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        private final int mIntValue;

        static {
            Mode mode = PULL_FROM_START;
            Mode mode2 = PULL_FROM_END;
            PULL_DOWN_TO_REFRESH = mode;
            PULL_UP_TO_REFRESH = mode2;
        }

        Mode(int i3) {
            this.mIntValue = i3;
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        static Mode mapIntToValue(int i3) {
            for (Mode mode : values()) {
                if (i3 == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        int getIntValue() {
            return this.mIntValue;
        }

        boolean permitsPullToRefresh() {
            if (this != DISABLED && this != MANUAL_REFRESH_ONLY) {
                return true;
            }
            return false;
        }

        public boolean showFooterLoadingLayout() {
            if (this != PULL_FROM_END && this != BOTH) {
                return false;
            }
            return true;
        }

        public boolean showHeaderLoadingLayout() {
            if (this != PULL_FROM_START && this != BOTH && this != MANUAL_REFRESH_ONLY) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes16.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public final class SmoothScrollRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Interpolator f264234d;

        /* renamed from: e, reason: collision with root package name */
        private final int f264235e;

        /* renamed from: f, reason: collision with root package name */
        private final int f264236f;

        /* renamed from: h, reason: collision with root package name */
        private final long f264237h;

        /* renamed from: i, reason: collision with root package name */
        private final f f264238i;

        /* renamed from: m, reason: collision with root package name */
        private boolean f264239m = true;
        private long C = -1;
        private int D = -1;

        public SmoothScrollRunnable(int i3, int i16, long j3, f fVar) {
            this.f264236f = i3;
            this.f264235e = i16;
            this.f264234d = PullToRefreshBase.this.T;
            this.f264237h = j3;
            this.f264238i = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.C == -1) {
                this.C = System.currentTimeMillis();
            } else {
                int round = this.f264236f - Math.round((this.f264236f - this.f264235e) * this.f264234d.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.C) * 1000) / this.f264237h, 1000L), 0L)) / 1000.0f));
                this.D = round;
                PullToRefreshBase.this.M(round);
            }
            if (this.f264239m && this.f264235e != this.D) {
                eh2.a.a(PullToRefreshBase.this, this);
                return;
            }
            f fVar = this.f264238i;
            if (fVar != null) {
                fVar.a();
            }
        }

        public void stop() {
            this.f264239m = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    /* loaded from: classes16.dex */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);

        private final int mIntValue;

        State(int i3) {
            this.mIntValue = i3;
        }

        static State mapIntToValue(int i3) {
            for (State state : values()) {
                if (i3 == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements f {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.f
        public void a() {
            PullToRefreshBase.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f264241a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f264242b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f264243c;

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f264244d;

        static {
            int[] iArr = new int[AnimationStyle.values().length];
            f264244d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f264244d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f264243c = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f264243c[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f264243c[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f264243c[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[State.values().length];
            f264242b = iArr3;
            try {
                iArr3[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f264242b[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f264242b[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f264242b[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f264242b[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f264242b[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[Orientation.values().length];
            f264241a = iArr4;
            try {
                iArr4[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f264241a[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface c<V extends View> {
        void N9(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes16.dex */
    public interface d<V extends View> {
        void F4(PullToRefreshBase<V> pullToRefreshBase);

        void s5(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes16.dex */
    public interface e<V extends View> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public interface f {
        void a();
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.f264228d = 0;
        this.f264229e = 0;
        this.G = false;
        this.H = State.RESET;
        this.I = Mode.getDefault();
        this.L = true;
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.U = AnimationStyle.getDefault();
        v(context, null);
    }

    private void J() {
        float f16;
        float f17;
        int round;
        int j3;
        if (b.f264241a[q().ordinal()] != 1) {
            f16 = this.F;
            f17 = this.D;
        } else {
            f16 = this.E;
            f17 = this.C;
        }
        int[] iArr = b.f264243c;
        if (iArr[this.J.ordinal()] != 1) {
            if (this.R) {
                round = Math.round(Math.min(f16 - f17, 0.0f) / 2.0f);
            } else {
                round = Math.round(Math.min(f16 - f17, 0.0f));
            }
            j3 = l();
        } else {
            if (this.S) {
                round = Math.round(Math.max(f16 - f17, 0.0f) / 2.0f);
            } else {
                round = Math.round(Math.max(f16 - f17, 0.0f));
            }
            j3 = j();
        }
        M(round);
        if (round != 0 && !A()) {
            float abs = Math.abs(round) / j3;
            if (iArr[this.J.ordinal()] != 1) {
                this.f264231h.f(abs);
            } else {
                this.f264232i.f(abs);
            }
            State state = this.H;
            State state2 = State.PULL_TO_REFRESH;
            if (state != state2 && j3 >= Math.abs(round)) {
                N(state2, new boolean[0]);
            } else if (this.H == state2 && j3 < Math.abs(round)) {
                N(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private final void P(int i3, long j3) {
        Q(i3, j3, 0L, null);
    }

    private final void Q(int i3, long j3, long j16, f fVar) {
        int scrollX;
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.f264227a0;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (b.f264241a[q().ordinal()] != 1) {
            scrollX = getScrollY();
        } else {
            scrollX = getScrollX();
        }
        int i16 = scrollX;
        if (QLog.isColorLevel()) {
            QLog.i("PullToRefreshBase", 2, String.format("oldScroll:%d newScroll:%d", Integer.valueOf(i16), Integer.valueOf(i3)));
        }
        if (i16 != i3) {
            if (this.T == null) {
                this.T = new DecelerateInterpolator();
            }
            PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(i16, i3, j3, fVar);
            this.f264227a0 = smoothScrollRunnable2;
            if (j16 > 0) {
                postDelayed(smoothScrollRunnable2, j16);
            } else {
                post(smoothScrollRunnable2);
            }
        }
    }

    private void c(Context context, T t16) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.K = frameLayout;
        frameLayout.addView(t16, -1, -1);
        e(this.K, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        d<T> dVar = this.V;
        if (dVar != null) {
            Mode mode = this.J;
            if (mode != Mode.PULL_FROM_START && mode != Mode.MANUAL_REFRESH_ONLY) {
                if (mode == Mode.PULL_FROM_END) {
                    dVar.s5(this);
                    return;
                }
                return;
            }
            dVar.F4(this);
        }
    }

    private LinearLayout.LayoutParams m() {
        if (b.f264241a[q().ordinal()] != 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return new LinearLayout.LayoutParams(-2, -1);
    }

    private int p() {
        if (b.f264241a[q().ordinal()] != 1) {
            return Math.round(getHeight() / 2.0f);
        }
        return Math.round(getWidth() / 2.0f);
    }

    private void v(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        if (b.f264241a[q().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.f264233m = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, tg2.a.K3);
        int i3 = tg2.a.Y3;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.I = Mode.mapIntToValue(obtainStyledAttributes.getInteger(i3, 0));
        }
        int i16 = tg2.a.M3;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.U = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(i16, 0));
        }
        int i17 = tg2.a.U3;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.f264228d = (int) obtainStyledAttributes.getDimension(i17, 0.0f);
        }
        int i18 = tg2.a.T3;
        if (obtainStyledAttributes.hasValue(i18)) {
            this.f264229e = (int) obtainStyledAttributes.getDimension(i18, 0.0f);
        }
        T i19 = i(context, attributeSet);
        this.f264230f = i19;
        c(context, i19);
        this.f264231h = g(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.f264232i = g(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        int i26 = tg2.a.f436120a4;
        if (obtainStyledAttributes.hasValue(i26)) {
            Drawable drawable2 = obtainStyledAttributes.getDrawable(i26);
            if (drawable2 != null) {
                this.f264230f.setBackgroundDrawable(drawable2);
            }
        } else {
            int i27 = tg2.a.L3;
            if (obtainStyledAttributes.hasValue(i27) && (drawable = obtainStyledAttributes.getDrawable(i27)) != null) {
                this.f264230f.setBackgroundDrawable(drawable);
            }
        }
        int i28 = tg2.a.Z3;
        if (obtainStyledAttributes.hasValue(i28)) {
            this.P = obtainStyledAttributes.getBoolean(i28, true);
        }
        int i29 = tg2.a.f436138c4;
        if (obtainStyledAttributes.hasValue(i29)) {
            this.M = obtainStyledAttributes.getBoolean(i29, false);
        }
        u(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        S();
    }

    private boolean x() {
        int i3 = b.f264243c[this.I.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return false;
                }
                if (y() || z()) {
                    return true;
                }
                return false;
            }
            return z();
        }
        return y();
    }

    public final boolean A() {
        State state = this.H;
        if (state != State.REFRESHING && state != State.MANUAL_REFRESHING) {
            return false;
        }
        return true;
    }

    protected void D() {
        int i3 = b.f264243c[this.J.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this.f264231h.a();
                return;
            }
            return;
        }
        this.f264232i.a();
    }

    public final void E() {
        if (A()) {
            N(State.RESET, new boolean[0]);
        }
    }

    public final void F() {
        this.f264231h.g();
        this.f264232i.g();
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.1
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.E();
            }
        }, 1000L);
    }

    protected void G(boolean z16) {
        if (this.I.showHeaderLoadingLayout()) {
            this.f264231h.b();
        }
        if (this.I.showFooterLoadingLayout()) {
            this.f264232i.b();
        }
        if (z16) {
            if (this.L) {
                a aVar = new a();
                if (b.f264243c[this.J.ordinal()] != 1) {
                    R(-l(), aVar);
                    return;
                } else {
                    R(j(), aVar);
                    return;
                }
            }
            O(0);
            return;
        }
        f();
    }

    protected void H() {
        int i3 = b.f264243c[this.J.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this.f264231h.d();
                return;
            }
            return;
        }
        this.f264232i.d();
    }

    protected void I() {
        this.G = false;
        this.Q = true;
        O(0);
    }

    protected final void K() {
        int p16 = (int) (p() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i3 = b.f264241a[q().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.I.showHeaderLoadingLayout()) {
                    this.f264231h.setHeight(p16);
                    paddingTop = -p16;
                } else {
                    paddingTop = 0;
                }
                if (this.I.showFooterLoadingLayout()) {
                    this.f264232i.setHeight(p16);
                    paddingBottom = -p16;
                } else {
                    paddingBottom = 0;
                }
            }
        } else {
            if (this.I.showHeaderLoadingLayout()) {
                this.f264231h.setWidth(p16);
                paddingLeft = -p16;
            } else {
                paddingLeft = 0;
            }
            if (this.I.showFooterLoadingLayout()) {
                this.f264232i.setWidth(p16);
                paddingRight = -p16;
            } else {
                paddingRight = 0;
            }
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    protected final void L(int i3, int i16) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
        int i17 = b.f264241a[q().ordinal()];
        if (i17 != 1) {
            if (i17 == 2 && layoutParams.height != i16) {
                layoutParams.height = i16;
                this.K.requestLayout();
                return;
            }
            return;
        }
        if (layoutParams.width != i3) {
            layoutParams.width = i3;
            this.K.requestLayout();
        }
    }

    protected final void M(int i3) {
        int p16 = p();
        int min = Math.min(p16, Math.max(-p16, i3));
        if (this.Q) {
            if (min < 0) {
                this.f264231h.setVisibility(0);
            } else if (min > 0) {
                this.f264232i.setVisibility(0);
            } else {
                this.f264231h.setVisibility(4);
                this.f264232i.setVisibility(4);
            }
        }
        int i16 = b.f264241a[q().ordinal()];
        if (i16 != 1) {
            if (i16 == 2) {
                scrollTo(0, min);
                return;
            }
            return;
        }
        scrollTo(min, 0);
    }

    final void N(State state, boolean... zArr) {
        this.H = state;
        int i3 = b.f264242b[state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 || i3 == 5) {
                        G(zArr[0]);
                    }
                } else {
                    H();
                }
            } else {
                D();
            }
        } else {
            I();
        }
        c<T> cVar = this.W;
        if (cVar != null) {
            cVar.N9(this, this.H, this.J);
        }
    }

    protected final void O(int i3) {
        P(i3, r());
    }

    protected final void R(int i3, f fVar) {
        Q(i3, r(), 0L, fVar);
    }

    protected void S() {
        LinearLayout.LayoutParams m3 = m();
        if (this == this.f264231h.getParent()) {
            removeView(this.f264231h);
        }
        if (this.I.showHeaderLoadingLayout()) {
            m3.topMargin += this.f264228d;
            m3.bottomMargin += this.f264229e;
            d(this.f264231h, 0, m3);
        }
        if (this == this.f264232i.getParent()) {
            removeView(this.f264232i);
        }
        if (this.I.showFooterLoadingLayout()) {
            e(this.f264232i, m3);
        }
        K();
        Mode mode = this.I;
        if (mode == Mode.BOTH) {
            mode = Mode.PULL_FROM_START;
        }
        this.J = mode;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        T s16 = s();
        if (s16 instanceof ViewGroup) {
            ((ViewGroup) s16).addView(view, i3, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    protected final void d(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
    }

    protected final void e(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayoutBase g(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayoutBase createLoadingLayout = this.U.createLoadingLayout(context, mode, q(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected com.tencent.mobileqq.qqexpand.widget.pulltorefresh.b h(boolean z16, boolean z17) {
        com.tencent.mobileqq.qqexpand.widget.pulltorefresh.b bVar = new com.tencent.mobileqq.qqexpand.widget.pulltorefresh.b();
        if (z16 && this.I.showHeaderLoadingLayout()) {
            bVar.a(this.f264231h);
        }
        if (z17 && this.I.showFooterLoadingLayout()) {
            bVar.a(this.f264232i);
        }
        return bVar;
    }

    protected abstract T i(Context context, AttributeSet attributeSet);

    protected final int j() {
        return this.f264232i.e();
    }

    public final LoadingLayoutBase k() {
        return this.f264231h;
    }

    protected final int l() {
        return this.f264231h.e();
    }

    public final com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a n() {
        return o(true, true);
    }

    public final com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a o(boolean z16, boolean z17) {
        return h(z16, z17);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        if (!w()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3 && action != 1) {
            if (action != 0 && this.G) {
                return true;
            }
            if (action != 0) {
                if (action == 2) {
                    if (!this.M && A()) {
                        return true;
                    }
                    if (x()) {
                        float y16 = motionEvent.getY();
                        float x16 = motionEvent.getX();
                        if (b.f264241a[q().ordinal()] != 1) {
                            f16 = y16 - this.D;
                            f17 = x16 - this.C;
                        } else {
                            f16 = x16 - this.C;
                            f17 = y16 - this.D;
                        }
                        float abs = Math.abs(f16);
                        if (abs > this.f264233m && (!this.N || abs > Math.abs(f17))) {
                            if (this.I.showHeaderLoadingLayout() && f16 >= 1.0f && z()) {
                                this.D = y16;
                                this.C = x16;
                                this.G = true;
                                if (this.I == Mode.BOTH) {
                                    this.J = Mode.PULL_FROM_START;
                                }
                            } else if (this.I.showFooterLoadingLayout() && f16 <= -1.0f && y()) {
                                this.D = y16;
                                this.C = x16;
                                this.G = true;
                                if (this.I == Mode.BOTH) {
                                    this.J = Mode.PULL_FROM_END;
                                }
                            }
                        }
                    }
                }
            } else if (x()) {
                float y17 = motionEvent.getY();
                this.F = y17;
                this.D = y17;
                float x17 = motionEvent.getX();
                this.E = x17;
                this.C = x17;
                this.G = false;
            }
            return this.G;
        }
        this.G = false;
        return false;
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.J = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.M = bundle.getBoolean("ptr_disable_scrolling", false);
            this.L = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                N(mapIntToValue, true);
            }
            B(bundle);
            return;
        }
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e16) {
            QLog.e("PullToRefresh", 1, "onRestoreInstanceState fail.", e16);
        }
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        C(bundle);
        bundle.putInt("ptr_state", this.H.getIntValue());
        bundle.putInt("ptr_mode", this.I.getIntValue());
        bundle.putInt("ptr_current_mode", this.J.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.M);
        bundle.putBoolean("ptr_show_refreshing_view", this.L);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        K();
        L(i3, i16);
        post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.3
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
    
        if (r0 != 3) goto L45;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!w()) {
            return false;
        }
        if (!this.M && A()) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.G) {
                        this.D = motionEvent.getY();
                        this.C = motionEvent.getX();
                        J();
                        return true;
                    }
                }
            }
            if (this.G) {
                this.G = false;
                if (this.H == State.RELEASE_TO_REFRESH && this.V != null) {
                    N(State.REFRESHING, true);
                    return true;
                }
                if (A()) {
                    O(0);
                    return true;
                }
                N(State.RESET, new boolean[0]);
                return true;
            }
        } else if (x()) {
            float y16 = motionEvent.getY();
            this.F = y16;
            this.D = y16;
            float x16 = motionEvent.getX();
            this.E = x16;
            this.C = x16;
            return true;
        }
        return false;
    }

    public abstract Orientation q();

    protected int r() {
        return 200;
    }

    public final T s() {
        return this.f264230f;
    }

    public void setDisableScrollingWhileRefreshing(boolean z16) {
        setScrollingWhileRefreshingEnabled(!z16);
    }

    public final void setFilterTouchEvents(boolean z16) {
        this.N = z16;
    }

    public void setFooterLayout(LoadingLayoutBase loadingLayoutBase) {
        this.f264232i = loadingLayoutBase;
        S();
    }

    public void setHasPullDownFriction(boolean z16) {
        this.R = z16;
    }

    public void setHasPullUpFriction(boolean z16) {
        this.S = z16;
    }

    public void setHeaderLayout(LoadingLayoutBase loadingLayoutBase) {
        this.f264231h = loadingLayoutBase;
        S();
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        n().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        n().setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z16) {
        s().setLongClickable(z16);
    }

    public final void setMode(Mode mode) {
        if (mode != this.I) {
            this.I = mode;
            S();
        }
    }

    public void setOnPullEventListener(c<T> cVar) {
        this.W = cVar;
    }

    public final void setOnRefreshListener(e<T> eVar) {
        this.V = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        n().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z16) {
        Mode mode;
        if (z16) {
            mode = Mode.getDefault();
        } else {
            mode = Mode.DISABLED;
        }
        setMode(mode);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z16) {
        this.P = z16;
    }

    public final void setRefreshing(boolean z16) {
        if (A()) {
            return;
        }
        N(State.MANUAL_REFRESHING, z16);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        n().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.T = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z16) {
        this.M = z16;
    }

    public final void setShowViewWhileRefreshing(boolean z16) {
        this.L = z16;
    }

    public final State t() {
        return this.H;
    }

    public final boolean w() {
        return this.I.permitsPullToRefresh();
    }

    protected abstract boolean y();

    protected abstract boolean z();

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        o(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public final void setOnRefreshListener(d<T> dVar) {
        this.V = dVar;
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        o(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        o(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        o(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264228d = 0;
        this.f264229e = 0;
        this.G = false;
        this.H = State.RESET;
        this.I = Mode.getDefault();
        this.L = true;
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.U = AnimationStyle.getDefault();
        v(context, attributeSet);
    }

    protected void B(Bundle bundle) {
    }

    protected void C(Bundle bundle) {
    }

    public void setSecondFooterLayout(View view) {
    }

    protected void u(TypedArray typedArray) {
    }
}
