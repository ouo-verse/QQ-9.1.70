package com.qqnt.widget.smartrefreshlayout.header;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent2;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.qqnt.widget.smartrefreshlayout.layout.constant.b;
import com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent;
import q3.d;
import q3.e;
import q3.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwoLevelHeader extends SimpleComponent implements d, NestedScrollingParent2 {
    protected float C;
    protected float D;
    protected float E;
    protected int F;
    protected int G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected e K;
    protected q3.a L;
    protected o3.a M;
    private int N;

    /* renamed from: h, reason: collision with root package name */
    protected int f41141h;

    /* renamed from: i, reason: collision with root package name */
    protected float f41142i;

    /* renamed from: m, reason: collision with root package name */
    protected float f41143m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f41144a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f41144a = iArr;
            try {
                iArr[RefreshState.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41144a[RefreshState.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41144a[RefreshState.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41144a[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, q3.a
    public void a(@NonNull e eVar, int i3, int i16) {
        q3.a aVar = this.L;
        if (aVar == null) {
            return;
        }
        if (((i16 + i3) * 1.0f) / i3 != this.f41143m && this.F == 0) {
            this.F = i3;
            this.L = null;
            eVar.getRefreshLayout().j(this.f41143m);
            this.L = aVar;
        }
        if (this.K == null && aVar.getSpinnerStyle() == b.f41251d && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) aVar.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i3;
            aVar.getView().setLayoutParams(marginLayoutParams);
        }
        this.F = i3;
        this.K = eVar;
        eVar.c(this.G);
        eVar.g(this.E);
        eVar.e(this, !this.J);
        aVar.a(eVar, i3, i16);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        q3.a aVar = this.L;
        if (aVar != null) {
            if (refreshState2 == RefreshState.ReleaseToRefresh && !this.H) {
                refreshState2 = RefreshState.PullDownToRefresh;
            }
            aVar.d(fVar, refreshState, refreshState2);
            int i3 = a.f41144a[refreshState2.ordinal()];
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4 && aVar.getView().getAlpha() == 0.0f && aVar.getView() != this) {
                        aVar.getView().setAlpha(1.0f);
                        return;
                    }
                    return;
                }
                if (aVar.getView() != this) {
                    aVar.getView().animate().alpha(1.0f).setDuration(this.G / 2);
                    return;
                }
                return;
            }
            if (aVar.getView() != this) {
                aVar.getView().animate().alpha(0.0f).setDuration(this.G / 2);
            }
            e eVar = this.K;
            if (eVar != null) {
                o3.a aVar2 = this.M;
                if (aVar2 != null && !aVar2.a(fVar)) {
                    z16 = false;
                }
                eVar.d(z16);
            }
        }
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent
    public boolean equals(Object obj) {
        q3.a aVar = this.L;
        if ((aVar != null && aVar.equals(obj)) || super.equals(obj)) {
            return true;
        }
        return false;
    }

    public TwoLevelHeader g() {
        e eVar = this.K;
        if (eVar != null) {
            eVar.finishTwoLevel();
        }
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.N;
    }

    public q3.a h() {
        return this.L;
    }

    protected void i(int i3) {
        q3.a aVar = this.L;
        if (this.f41141h != i3 && aVar != null) {
            this.f41141h = i3;
            b spinnerStyle = aVar.getSpinnerStyle();
            if (spinnerStyle == b.f41251d) {
                aVar.getView().setTranslationY(i3);
            } else if (spinnerStyle.f41259c) {
                View view = aVar.getView();
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i3));
            }
        }
    }

    public TwoLevelHeader j(boolean z16, Animator.AnimatorListener animatorListener) {
        boolean z17;
        e eVar = this.K;
        if (eVar != null) {
            o3.a aVar = this.M;
            if (z16 && aVar != null && !aVar.a(eVar.getRefreshLayout())) {
                z17 = false;
            } else {
                z17 = true;
            }
            eVar.f(z17, animatorListener);
        }
        return this;
    }

    public TwoLevelHeader k(int i3) {
        this.G = i3;
        return this;
    }

    public TwoLevelHeader l(float f16) {
        this.C = f16;
        return this;
    }

    public TwoLevelHeader m(float f16) {
        if (this.f41143m != f16) {
            this.f41143m = f16;
            e eVar = this.K;
            if (eVar != null) {
                this.F = 0;
                eVar.getRefreshLayout().j(this.f41143m);
            }
        }
        return this;
    }

    public TwoLevelHeader n(o3.a aVar) {
        this.M = aVar;
        return this;
    }

    public TwoLevelHeader o(d dVar) {
        return p(dVar, 0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f41261e = b.f41255h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f41261e = b.f41253f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof d) {
                this.L = (d) childAt;
                this.f41262f = (q3.a) childAt;
                bringChildToFront(childAt);
                return;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        q3.a aVar = this.L;
        if (aVar != null) {
            if (View.MeasureSpec.getMode(i16) == Integer.MIN_VALUE) {
                aVar.getView().measure(i3, i16);
                super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i3), aVar.getView().getMeasuredHeight());
                return;
            }
            super.onMeasure(i3, i16);
            return;
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, q3.a
    public void onMoving(boolean z16, float f16, int i3, int i16, int i17) {
        i(i3);
        q3.a aVar = this.L;
        e eVar = this.K;
        if (aVar != null) {
            aVar.onMoving(z16, f16, i3, i16, i17);
        }
        if (z16) {
            if (eVar != null) {
                float f17 = this.f41142i;
                float f18 = this.C;
                if (f17 < f18 && f16 >= f18 && this.I) {
                    eVar.b(RefreshState.ReleaseToTwoLevel);
                } else if (f17 >= f18 && f16 < this.D) {
                    eVar.b(RefreshState.PullDownToRefresh);
                } else if (f17 >= f18 && f16 < f18 && this.H) {
                    eVar.b(RefreshState.ReleaseToRefresh);
                } else if (!this.H && eVar.getRefreshLayout().getState() != RefreshState.ReleaseToTwoLevel) {
                    eVar.b(RefreshState.PullDownToRefresh);
                }
            }
            this.f41142i = f16;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f16, float f17) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3) {
        this.N = i3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
    }

    public TwoLevelHeader p(d dVar, int i3, int i16) {
        if (dVar != null) {
            if (i3 == 0) {
                i3 = -1;
            }
            if (i16 == 0) {
                i16 = -2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
            ViewGroup.LayoutParams layoutParams2 = dVar.getView().getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            }
            q3.a aVar = this.L;
            if (aVar != null) {
                removeView(aVar.getView());
            }
            if (dVar.getSpinnerStyle() == b.f41253f) {
                addView(dVar.getView(), 0, layoutParams);
            } else {
                addView(dVar.getView(), getChildCount(), layoutParams);
            }
            this.L = dVar;
            this.f41262f = dVar;
        }
        return this;
    }

    public TwoLevelHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f41142i = 0.0f;
        this.f41143m = 2.5f;
        this.C = 1.9f;
        this.D = 1.0f;
        this.E = 0.16666667f;
        this.G = 1000;
        this.H = true;
        this.I = true;
        this.J = true;
        this.N = 0;
        this.f41261e = b.f41253f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        this.N = i3;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
    }
}
