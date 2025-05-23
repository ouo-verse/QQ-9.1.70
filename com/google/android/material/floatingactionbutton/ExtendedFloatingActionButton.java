package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: k0, reason: collision with root package name */
    private static final int f33628k0 = 2131953437;

    /* renamed from: l0, reason: collision with root package name */
    static final Property<View, Float> f33629l0 = new d(Float.class, "width");

    /* renamed from: m0, reason: collision with root package name */
    static final Property<View, Float> f33630m0 = new e(Float.class, "height");

    /* renamed from: n0, reason: collision with root package name */
    static final Property<View, Float> f33631n0 = new f(Float.class, "paddingStart");

    /* renamed from: o0, reason: collision with root package name */
    static final Property<View, Float> f33632o0 = new g(Float.class, "paddingEnd");
    private int T;
    private final com.google.android.material.floatingactionbutton.a U;

    @NonNull
    private final com.google.android.material.floatingactionbutton.f V;

    @NonNull
    private final com.google.android.material.floatingactionbutton.f W;

    /* renamed from: a0, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.f f33633a0;

    /* renamed from: b0, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.f f33634b0;

    /* renamed from: c0, reason: collision with root package name */
    private final int f33635c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f33636d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f33637e0;

    /* renamed from: f0, reason: collision with root package name */
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f33638f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f33639g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f33640h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f33641i0;

    /* renamed from: j0, reason: collision with root package name */
    @NonNull
    protected ColorStateList f33642j0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements l {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.f33637e0;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f33636d0;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.J() * 2)) + ExtendedFloatingActionButton.this.f33636d0 + ExtendedFloatingActionButton.this.f33637e0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements l {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.K();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.J();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.J();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private boolean f33648d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.f f33649e;

        c(com.google.android.material.floatingactionbutton.f fVar, j jVar) {
            this.f33649e = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f33648d = true;
            this.f33649e.onAnimationCancel();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f33649e.onAnimationEnd();
            if (!this.f33648d) {
                this.f33649e.c(null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f33649e.onAnimationStart(animator);
            this.f33648d = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f16) {
            view.getLayoutParams().width = f16.intValue();
            view.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f16) {
            view.getLayoutParams().height = f16.intValue();
            view.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class f extends Property<View, Float> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f16) {
            ViewCompat.setPaddingRelative(view, f16.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class g extends Property<View, Float> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f16) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f16.intValue(), view.getPaddingBottom());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class j {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    interface l {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        if (getVisibility() == 0) {
            if (this.T != 1) {
                return false;
            }
            return true;
        }
        if (this.T == 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        if (getVisibility() != 0) {
            if (this.T != 2) {
                return false;
            }
            return true;
        }
        if (this.T == 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(@NonNull com.google.android.material.floatingactionbutton.f fVar, @Nullable j jVar) {
        if (fVar.a()) {
            return;
        }
        if (!P()) {
            fVar.e();
            fVar.c(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet d16 = fVar.d();
        d16.addListener(new c(fVar, jVar));
        Iterator<Animator.AnimatorListener> it = fVar.getListeners().iterator();
        while (it.hasNext()) {
            d16.addListener(it.next());
        }
        d16.start();
    }

    private void O() {
        this.f33642j0 = getTextColors();
    }

    private boolean P() {
        if ((ViewCompat.isLaidOut(this) || (!M() && this.f33641i0)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    int J() {
        return (K() - f()) / 2;
    }

    @VisibleForTesting
    int K() {
        int i3 = this.f33635c0;
        if (i3 < 0) {
            return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + f();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f33638f0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f33639g0 && TextUtils.isEmpty(getText()) && e() != null) {
            this.f33639g0 = false;
            this.V.e();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z16) {
        this.f33641i0 = z16;
    }

    public void setExtendMotionSpec(@Nullable x0.h hVar) {
        this.W.f(hVar);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i3) {
        setExtendMotionSpec(x0.h.d(getContext(), i3));
    }

    public void setExtended(boolean z16) {
        com.google.android.material.floatingactionbutton.f fVar;
        if (this.f33639g0 == z16) {
            return;
        }
        if (z16) {
            fVar = this.W;
        } else {
            fVar = this.V;
        }
        if (fVar.a()) {
            return;
        }
        fVar.e();
    }

    public void setHideMotionSpec(@Nullable x0.h hVar) {
        this.f33634b0.f(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i3) {
        setHideMotionSpec(x0.h.d(getContext(), i3));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        if (this.f33639g0 && !this.f33640h0) {
            this.f33636d0 = ViewCompat.getPaddingStart(this);
            this.f33637e0 = ViewCompat.getPaddingEnd(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i3, int i16, int i17, int i18) {
        super.setPaddingRelative(i3, i16, i17, i18);
        if (this.f33639g0 && !this.f33640h0) {
            this.f33636d0 = i3;
            this.f33637e0 = i17;
        }
    }

    public void setShowMotionSpec(@Nullable x0.h hVar) {
        this.f33633a0.f(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i3) {
        setShowMotionSpec(x0.h.d(getContext(), i3));
    }

    public void setShrinkMotionSpec(@Nullable x0.h hVar) {
        this.V.f(hVar);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i3) {
        setShrinkMotionSpec(x0.h.d(getContext(), i3));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        O();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.af5);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: g, reason: collision with root package name */
        private Rect f33643g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f33644h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f33645i;

        public ExtendedFloatingActionButtonBehavior() {
            this.f33644h = false;
            this.f33645i = true;
        }

        private static boolean d(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean g(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f33644h && !this.f33645i) || layoutParams.getAnchorId() != view.getId()) {
                return false;
            }
            return true;
        }

        private boolean i(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!g(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f33643g == null) {
                this.f33643g = new Rect();
            }
            Rect rect = this.f33643g;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.m()) {
                h(extendedFloatingActionButton);
                return true;
            }
            b(extendedFloatingActionButton);
            return true;
        }

        private boolean j(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!g(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                h(extendedFloatingActionButton);
                return true;
            }
            b(extendedFloatingActionButton);
            return true;
        }

        protected void b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.N(this.f33645i ? extendedFloatingActionButton.W : extendedFloatingActionButton.f33633a0, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                i(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (d(view)) {
                j(view, extendedFloatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i3) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i16 = 0; i16 < size; i16++) {
                View view = dependencies.get(i16);
                if (view instanceof AppBarLayout) {
                    if (i(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (d(view) && j(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i3);
            return true;
        }

        protected void h(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.N(this.f33645i ? extendedFloatingActionButton.V : extendedFloatingActionButton.f33634b0, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.O2);
            this.f33644h = obtainStyledAttributes.getBoolean(w0.a.P2, false);
            this.f33645i = obtainStyledAttributes.getBoolean(w0.a.Q2, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r9), attributeSet, i3);
        int i16 = f33628k0;
        this.T = 0;
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.U = aVar;
        k kVar = new k(aVar);
        this.f33633a0 = kVar;
        i iVar = new i(aVar);
        this.f33634b0 = iVar;
        this.f33639g0 = true;
        this.f33640h0 = false;
        this.f33641i0 = false;
        Context context2 = getContext();
        this.f33638f0 = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray h16 = o.h(context2, attributeSet, w0.a.I2, i3, i16, new int[0]);
        x0.h c16 = x0.h.c(context2, h16, w0.a.M2);
        x0.h c17 = x0.h.c(context2, h16, w0.a.L2);
        x0.h c18 = x0.h.c(context2, h16, w0.a.K2);
        x0.h c19 = x0.h.c(context2, h16, w0.a.N2);
        this.f33635c0 = h16.getDimensionPixelSize(w0.a.J2, -1);
        this.f33636d0 = ViewCompat.getPaddingStart(this);
        this.f33637e0 = ViewCompat.getPaddingEnd(this);
        com.google.android.material.floatingactionbutton.a aVar2 = new com.google.android.material.floatingactionbutton.a();
        h hVar = new h(aVar2, new a(), true);
        this.W = hVar;
        h hVar2 = new h(aVar2, new b(), false);
        this.V = hVar2;
        kVar.f(c16);
        iVar.f(c17);
        hVar.f(c18);
        hVar2.f(c19);
        h16.recycle();
        setShapeAppearanceModel(com.google.android.material.shape.g.g(context2, attributeSet, i3, i16, com.google.android.material.shape.g.f34052m).m());
        O();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        O();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class h extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g, reason: collision with root package name */
        private final l f33651g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f33652h;

        h(com.google.android.material.floatingactionbutton.a aVar, l lVar, boolean z16) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f33651g = lVar;
            this.f33652h = z16;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean a() {
            if (this.f33652h != ExtendedFloatingActionButton.this.f33639g0 && ExtendedFloatingActionButton.this.e() != null && !TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int b() {
            if (this.f33652h) {
                return R.animator.f1774;
            }
            return R.animator.f1763;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        @NonNull
        public AnimatorSet d() {
            float f16;
            x0.h i3 = i();
            if (i3.j("width")) {
                PropertyValuesHolder[] g16 = i3.g("width");
                g16[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f33651g.getWidth());
                i3.l("width", g16);
            }
            if (i3.j("height")) {
                PropertyValuesHolder[] g17 = i3.g("height");
                g17[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f33651g.getHeight());
                i3.l("height", g17);
            }
            if (i3.j("paddingStart")) {
                PropertyValuesHolder[] g18 = i3.g("paddingStart");
                g18[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f33651g.getPaddingStart());
                i3.l("paddingStart", g18);
            }
            if (i3.j("paddingEnd")) {
                PropertyValuesHolder[] g19 = i3.g("paddingEnd");
                g19[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f33651g.getPaddingEnd());
                i3.l("paddingEnd", g19);
            }
            if (i3.j("labelOpacity")) {
                PropertyValuesHolder[] g26 = i3.g("labelOpacity");
                boolean z16 = this.f33652h;
                float f17 = 0.0f;
                if (z16) {
                    f16 = 0.0f;
                } else {
                    f16 = 1.0f;
                }
                if (z16) {
                    f17 = 1.0f;
                }
                g26[0].setFloatValues(f16, f17);
                i3.l("labelOpacity", g26);
            }
            return super.h(i3);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void e() {
            ExtendedFloatingActionButton.this.f33639g0 = this.f33652h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f33651g.getLayoutParams().width;
            layoutParams.height = this.f33651g.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f33651g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f33651g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.f33640h0 = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f33651g.getLayoutParams().width;
            layoutParams.height = this.f33651g.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.f33639g0 = this.f33652h;
            ExtendedFloatingActionButton.this.f33640h0 = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c(@Nullable j jVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class i extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g, reason: collision with root package name */
        private boolean f33654g;

        public i(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean a() {
            return ExtendedFloatingActionButton.this.L();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int b() {
            return R.animator.f1785;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void e() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.f33654g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.T = 0;
            if (!this.f33654g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f33654g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.T = 1;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c(@Nullable j jVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class k extends com.google.android.material.floatingactionbutton.b {
        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean a() {
            return ExtendedFloatingActionButton.this.M();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int b() {
            return R.animator.f1796;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void e() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.T = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.T = 2;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c(@Nullable j jVar) {
        }
    }
}
