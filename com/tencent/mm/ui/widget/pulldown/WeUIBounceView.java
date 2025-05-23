package com.tencent.mm.ui.widget.pulldown;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mm.ui.widget.pulldown.IBounceView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeUIBounceView extends FrameLayout implements IBounceView {
    public static final int FLAG_BOTTOM_2_TOP = 2;
    public static final int FLAG_TOP_2_BOTTOM = 1;
    public static final String TAG = "WeUIPullDownView";
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public String G;
    public boolean H;
    public DragDirection I;
    public int J;
    public int K;
    public int L;
    public ObjectAnimator M;

    /* renamed from: a, reason: collision with root package name */
    public View f153780a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f153781b;

    /* renamed from: c, reason: collision with root package name */
    public View f153782c;

    /* renamed from: d, reason: collision with root package name */
    public FrameLayout f153783d;

    /* renamed from: e, reason: collision with root package name */
    public IsAtBottomCallBack f153784e;

    /* renamed from: f, reason: collision with root package name */
    public IsAtTopCallBack f153785f;

    /* renamed from: g, reason: collision with root package name */
    public int f153786g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153787h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153788i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f153789j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f153790k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f153791l;

    /* renamed from: m, reason: collision with root package name */
    public int f153792m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum DragDirection {
        NONE,
        TOP2BOTTOM,
        BOTTOM2TOP
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IsAtBottomCallBack {
        boolean isAtBottom();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IsAtTopCallBack {
        boolean isAtTop();
    }

    public WeUIBounceView(@NonNull Context context) {
        super(context);
        this.f153787h = false;
        this.f153788i = false;
        this.f153789j = false;
        this.f153790k = false;
        this.f153791l = false;
        this.E = false;
        this.F = false;
        this.G = "WeUIPullDownView@" + hashCode();
        this.H = false;
        this.I = DragDirection.NONE;
        this.J = 3;
        this.K = 0;
        this.L = 0;
        this.M = null;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f153786g = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private int getMaxOverScrollDistance() {
        return getHeight();
    }

    public void a() {
        b(0);
        if (this.f153789j) {
            b();
        }
        this.f153790k = false;
        this.f153789j = false;
        this.f153791l = false;
    }

    public void b() {
    }

    public void c() {
    }

    public final void d() {
        b(getStayHeight());
        if (!this.f153789j) {
            c();
        }
        this.f153790k = true;
        this.f153789j = true;
        this.f153791l = true;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void enableEnd2Start(boolean z16) {
        if (z16) {
            this.J |= 2;
        } else {
            this.J &= -3;
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void enableStart2End(boolean z16) {
        if (z16) {
            this.J |= 1;
        } else {
            this.J &= -2;
        }
    }

    public View getContentView() {
        return this.f153782c;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public int getOffset() {
        return (int) this.f153783d.getTranslationY();
    }

    public int getOpenHeight() {
        return this.f153780a.getHeight();
    }

    @ColorInt
    public int getPullDownBackgroundColor() {
        Drawable background = this.f153781b.getBackground();
        if (background instanceof ColorDrawable) {
            return ((ColorDrawable) background).getColor();
        }
        return 0;
    }

    public int getStayHeight() {
        return this.f153780a.getHeight();
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void initBounce() {
        MMPullDownHelper.INSTANCE.detectAndSolvePullDown(this);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public boolean isBounceEnabled() {
        return !this.f153787h;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x015d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        if (this.f153787h) {
            return this.f153791l;
        }
        IsAtTopCallBack isAtTopCallBack = this.f153785f;
        if (isAtTopCallBack != null) {
            this.E = isAtTopCallBack.isAtTop();
        }
        IsAtBottomCallBack isAtBottomCallBack = this.f153784e;
        if (isAtBottomCallBack != null) {
            this.F = isAtBottomCallBack.isAtBottom();
        }
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            n.a(this.G, "onInterceptTouchEvent %s, mDownEventCaptured %b, mOverScrolling %b, mOpened %b isAtTop:%s, isAtBottom:%s", MotionEvent.actionToString(motionEvent.getAction()), Boolean.valueOf(this.H), Boolean.valueOf(this.f153790k), Boolean.valueOf(this.f153791l), Boolean.valueOf(this.E), Boolean.valueOf(this.F));
        }
        int action = motionEvent.getAction();
        if (action != 3 && action != 1) {
            if (action == 2 && this.f153790k) {
                return true;
            }
            if (action != 0) {
                if (action == 2 && (this.E || this.F)) {
                    if (!this.H) {
                        this.f153792m = (int) motionEvent.getX();
                        this.C = (int) motionEvent.getY();
                        this.D = (int) motionEvent.getY();
                        this.f153790k = false;
                        this.H = true;
                        return false;
                    }
                    int x16 = (int) motionEvent.getX();
                    int y16 = (int) motionEvent.getY();
                    int i3 = x16 - this.f153792m;
                    int i16 = y16 - this.C;
                    if (Math.abs(i16) > Math.abs(i3)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (this.E && Math.abs(i16) > this.f153786g && z16 && i16 > 0) {
                        this.I = DragDirection.TOP2BOTTOM;
                    } else if (this.F && Math.abs(i16) > this.f153786g && z16 && i16 < 0) {
                        this.I = DragDirection.BOTTOM2TOP;
                    } else {
                        this.I = DragDirection.NONE;
                    }
                    if (nestedBounceParam.isPullDownDebugOpen()) {
                        n.a(this.G, "intercept isAtTop:%s isAtBottom:%s isYDistanceMore:%s dy:%s mTouchSlop:%s direction:%s mFlag:%s", Boolean.valueOf(this.E), Boolean.valueOf(this.F), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(this.f153786g), this.I, Integer.valueOf(this.J));
                    }
                    DragDirection dragDirection = this.I;
                    if (dragDirection != DragDirection.NONE) {
                        if (dragDirection == DragDirection.TOP2BOTTOM && (this.J & 1) != 0) {
                            this.f153780a.setBackgroundColor(this.K);
                        } else if (dragDirection == DragDirection.BOTTOM2TOP && (this.J & 2) != 0) {
                            this.f153780a.setBackgroundColor(this.L);
                        } else {
                            z17 = false;
                            if (z17) {
                                this.f153792m = x16;
                                this.C = y16;
                                this.f153790k = true;
                                this.H = false;
                                return true;
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    }
                }
            } else if (this.E || this.F) {
                this.f153792m = (int) motionEvent.getX();
                this.C = (int) motionEvent.getY();
                this.D = (int) motionEvent.getY();
                this.f153790k = false;
                this.H = true;
            }
            if (this.f153790k || this.f153791l) {
                return true;
            }
            return false;
        }
        this.f153790k = false;
        this.H = false;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (r1 != 3) goto L71;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f153787h) {
            if (this.f153791l) {
                a();
            }
            return this.f153791l;
        }
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        int i3 = 0;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            n.a(this.G, "onTouchEvent %s, edgeFlags %s,mDownEventCaptured %b, mOverScrolling %b, mOpened %b isAtTop:%s, isAtBottom:%s", MotionEvent.actionToString(motionEvent.getAction()), Integer.valueOf(motionEvent.getEdgeFlags()), Boolean.valueOf(this.H), Boolean.valueOf(this.f153790k), Boolean.valueOf(this.f153791l), Boolean.valueOf(this.E), Boolean.valueOf(this.F));
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f153790k || this.f153791l) {
                        if (!this.H) {
                            this.C = (int) motionEvent.getY();
                            this.f153792m = (int) motionEvent.getX();
                            this.D = (int) motionEvent.getY();
                            this.H = true;
                            return true;
                        }
                        int y16 = ((int) motionEvent.getY()) - this.D;
                        int a16 = a(y16);
                        if (this.f153789j) {
                            a16 += getStayHeight();
                        }
                        if (nestedBounceParam.isPullDownDebugOpen()) {
                            n.a(this.G, "real diff: %d, calc diff: %d, isAtTop:%s, isAtBottom:%s", Integer.valueOf(y16), Integer.valueOf(a16), Boolean.valueOf(this.E), Boolean.valueOf(this.F));
                        }
                        if ((!this.E || this.I != DragDirection.TOP2BOTTOM || a16 >= 0) && (!this.F || this.I != DragDirection.BOTTOM2TOP || a16 <= 0)) {
                            i3 = a16;
                        }
                        d(i3);
                        c(i3);
                        return true;
                    }
                }
            }
            this.H = false;
            if (this.f153783d.getTranslationY() > getOpenHeight() && this.f153788i) {
                d();
                return true;
            }
            if (this.f153790k || this.f153791l) {
                a();
                return true;
            }
        } else if (this.E || this.F || this.f153791l) {
            this.C = (int) motionEvent.getY();
            this.f153792m = (int) motionEvent.getX();
            this.D = (int) motionEvent.getY();
            this.H = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        super.requestDisallowInterceptTouchEvent(z16);
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            n.a(this.G, "[requestDisallowInterceptTouchEvent] disallowIntercept:%s. disable:%s", Boolean.valueOf(z16), Boolean.valueOf(this.f153787h));
        }
    }

    public void setAtBottomCallBack(IsAtBottomCallBack isAtBottomCallBack) {
        this.f153784e = isAtBottomCallBack;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setAtEndCallback(final AtEndCallback atEndCallback, @Nullable View view) {
        setAtBottomCallBack(new IsAtBottomCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.WeUIBounceView.2
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtBottomCallBack
            public boolean isAtBottom() {
                AtEndCallback atEndCallback2 = atEndCallback;
                if (atEndCallback2 != null && atEndCallback2.isAtEnd()) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setAtStartCallback(final AtStartCallback atStartCallback, @Nullable View view) {
        setAtTopCallBack(new IsAtTopCallBack() { // from class: com.tencent.mm.ui.widget.pulldown.WeUIBounceView.1
            @Override // com.tencent.mm.ui.widget.pulldown.WeUIBounceView.IsAtTopCallBack
            public boolean isAtTop() {
                AtStartCallback atStartCallback2 = atStartCallback;
                if (atStartCallback2 != null && atStartCallback2.isAtStart()) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setAtTopCallBack(IsAtTopCallBack isAtTopCallBack) {
        this.f153785f = isAtTopCallBack;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setBgColor(int i3) {
        this.K = i3;
        this.L = i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setBounceEnabled(boolean z16) {
        this.f153787h = !z16;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setEnd2StartBgColor(int i3) {
        this.L = i3;
    }

    public void setNeedStay(boolean z16) {
        this.f153788i = z16;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setStart2EndBgColor(int i3) {
        this.K = i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setView(View view) {
        this.f153780a = new LinearLayout(view.getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f153781b = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f153781b.addView(this.f153780a);
        this.f153782c = view;
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.f153783d = frameLayout2;
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f153783d.addView(view);
        addView(this.f153781b);
        addView(this.f153783d);
    }

    public final void b(int i3) {
        int translationY = (int) this.f153783d.getTranslationY();
        if (translationY == i3) {
            return;
        }
        ObjectAnimator objectAnimator = this.M;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        Math.abs(translationY - i3);
        getStayHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f153783d, "translationY", translationY, i3);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.pulldown.WeUIBounceView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WeUIBounceView.this.c((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.M = ofFloat;
    }

    public void c(int i3) {
    }

    public final int a(int i3) {
        int i16;
        int i17 = i3 >> 1;
        int maxOverScrollDistance = getMaxOverScrollDistance();
        int sqrt = (int) Math.sqrt(Math.abs(i17) * o.a(getContext(), 150));
        if (i17 >= 0 ? sqrt > (i16 = i17 * 2) : (sqrt = -sqrt) < (i16 = i17 * 2)) {
            sqrt = i16;
        }
        return sqrt > maxOverScrollDistance ? maxOverScrollDistance : sqrt;
    }

    public final void d(int i3) {
        this.f153783d.setTranslationY(Math.min(getMaxOverScrollDistance(), i3));
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void addBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void removeBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setBg(@NotNull Drawable drawable) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setEnd2StartBg(@NotNull Drawable drawable) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setEnd2StartBgColorByNavigationBar(int i3) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setStart2EndBg(@NotNull Drawable drawable) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setStart2EndBgColorByActionBar(int i3) {
    }
}
