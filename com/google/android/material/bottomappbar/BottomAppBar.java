package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x0.k;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int T = 2131953401;
    private int C;
    private boolean D;
    private final boolean E;
    private final boolean F;
    private final boolean G;
    private int H;
    private ArrayList<i> I;

    @MenuRes
    private int J;
    private boolean K;
    private boolean L;
    private Behavior M;
    private int N;
    private int P;
    private int Q;

    @NonNull
    AnimatorListenerAdapter R;

    @NonNull
    k<FloatingActionButton> S;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Integer f33298d;

    /* renamed from: e, reason: collision with root package name */
    private final int f33299e;

    /* renamed from: f, reason: collision with root package name */
    private final MaterialShapeDrawable f33300f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Animator f33301h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private Animator f33302i;

    /* renamed from: m, reason: collision with root package name */
    private int f33303m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FabAlignmentMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FabAnimationMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f33312d;

        /* renamed from: e, reason: collision with root package name */
        boolean f33313e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f33312d);
            parcel.writeInt(this.f33313e ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f33312d = parcel.readInt();
            this.f33313e = parcel.readInt() != 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!BottomAppBar.this.K) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.f0(bottomAppBar.f33303m, BottomAppBar.this.L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements k<FloatingActionButton> {
        b() {
        }

        @Override // x0.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            float f16;
            MaterialShapeDrawable materialShapeDrawable = BottomAppBar.this.f33300f;
            if (floatingActionButton.getVisibility() == 0) {
                f16 = floatingActionButton.getScaleY();
            } else {
                f16 = 0.0f;
            }
            materialShapeDrawable.Z(f16);
        }

        @Override // x0.k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(@NonNull FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.d0().i() != translationX) {
                BottomAppBar.this.d0().o(translationX);
                BottomAppBar.this.f33300f.invalidateSelf();
            }
            float f16 = 0.0f;
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.d0().c() != max) {
                BottomAppBar.this.d0().j(max);
                BottomAppBar.this.f33300f.invalidateSelf();
            }
            MaterialShapeDrawable materialShapeDrawable = BottomAppBar.this.f33300f;
            if (floatingActionButton.getVisibility() == 0) {
                f16 = floatingActionButton.getScaleY();
            }
            materialShapeDrawable.Z(f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements ViewUtils.d {
        c() {
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.e eVar) {
            boolean z16;
            if (BottomAppBar.this.E) {
                BottomAppBar.this.N = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z17 = true;
            boolean z18 = false;
            if (BottomAppBar.this.F) {
                if (BottomAppBar.this.Q != windowInsetsCompat.getSystemWindowInsetLeft()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                BottomAppBar.this.Q = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z16 = false;
            }
            if (BottomAppBar.this.G) {
                if (BottomAppBar.this.P == windowInsetsCompat.getSystemWindowInsetRight()) {
                    z17 = false;
                }
                BottomAppBar.this.P = windowInsetsCompat.getSystemWindowInsetRight();
                z18 = z17;
            }
            if (z16 || z18) {
                BottomAppBar.this.I();
                BottomAppBar.this.k0();
                BottomAppBar.this.j0();
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.M();
            BottomAppBar.this.f33301h = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33318a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.M();
            }
        }

        e(int i3) {
            this.f33318a = i3;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.Y(this.f33318a));
            floatingActionButton.y(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.M();
            BottomAppBar.this.K = false;
            BottomAppBar.this.f33302i = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        public boolean f33322d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f33323e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f33324f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f33325h;

        g(ActionMenuView actionMenuView, int i3, boolean z16) {
            this.f33323e = actionMenuView;
            this.f33324f = i3;
            this.f33325h = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f33322d = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z16;
            if (!this.f33322d) {
                if (BottomAppBar.this.J != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.i0(bottomAppBar.J);
                BottomAppBar.this.o0(this.f33323e, this.f33324f, this.f33325h, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.R.onAnimationStart(animator);
            FloatingActionButton O = BottomAppBar.this.O();
            if (O != null) {
                O.setTranslationX(BottomAppBar.this.X());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface i {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.R);
        floatingActionButton.f(new h());
        floatingActionButton.g(this.S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Animator animator = this.f33302i;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f33301h;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void K(int i3, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(O(), "translationX", Y(i3));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void L(int i3, boolean z16, @NonNull List<Animator> list) {
        ActionMenuView Q = Q();
        if (Q == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(Q, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f);
        if (Math.abs(Q.getTranslationX() - R(Q, i3, z16)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(Q, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
            ofFloat2.addListener(new g(Q, i3, z16));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
            return;
        }
        if (Q.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        ArrayList<i> arrayList;
        int i3 = this.H - 1;
        this.H = i3;
        if (i3 == 0 && (arrayList = this.I) != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ArrayList<i> arrayList;
        int i3 = this.H;
        this.H = i3 + 1;
        if (i3 == 0 && (arrayList = this.I) != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton O() {
        View P = P();
        if (P instanceof FloatingActionButton) {
            return (FloatingActionButton) P;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public View P() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    @Nullable
    private ActionMenuView Q() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int T() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float X() {
        return Y(this.f33303m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Y(int i3) {
        int i16;
        boolean i17 = ViewUtils.i(this);
        int i18 = 1;
        if (i3 == 1) {
            if (i17) {
                i16 = this.Q;
            } else {
                i16 = this.P;
            }
            int measuredWidth = (getMeasuredWidth() / 2) - (this.f33299e + i16);
            if (i17) {
                i18 = -1;
            }
            return measuredWidth * i18;
        }
        return 0.0f;
    }

    private float Z() {
        return -d0().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b0() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c0() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.google.android.material.bottomappbar.a d0() {
        return (com.google.android.material.bottomappbar.a) this.f33300f.E().p();
    }

    private boolean e0() {
        FloatingActionButton O = O();
        if (O != null && O.u()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i3, boolean z16) {
        if (!ViewCompat.isLaidOut(this)) {
            this.K = false;
            i0(this.J);
            return;
        }
        Animator animator = this.f33302i;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!e0()) {
            i3 = 0;
            z16 = false;
        }
        L(i3, z16, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f33302i = animatorSet;
        animatorSet.addListener(new f());
        this.f33302i.start();
    }

    private void g0(int i3) {
        if (this.f33303m != i3 && ViewCompat.isLaidOut(this)) {
            Animator animator = this.f33301h;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.C == 1) {
                K(i3, arrayList);
            } else {
                J(i3, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f33301h = animatorSet;
            animatorSet.addListener(new d());
            this.f33301h.start();
        }
    }

    @Nullable
    private Drawable h0(@Nullable Drawable drawable) {
        if (drawable != null && this.f33298d != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTint(wrap, this.f33298d.intValue());
            return wrap;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        ActionMenuView Q = Q();
        if (Q != null && this.f33302i == null) {
            Q.setAlpha(1.0f);
            if (!e0()) {
                n0(Q, 0, false);
            } else {
                n0(Q, this.f33303m, this.L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        float f16;
        d0().o(X());
        View P = P();
        MaterialShapeDrawable materialShapeDrawable = this.f33300f;
        if (this.L && e0()) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        materialShapeDrawable.Z(f16);
        if (P != null) {
            P.setTranslationY(Z());
            P.setTranslationX(X());
        }
    }

    private void n0(@NonNull ActionMenuView actionMenuView, int i3, boolean z16) {
        o0(actionMenuView, i3, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(@NonNull final ActionMenuView actionMenuView, final int i3, final boolean z16, boolean z17) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public void run() {
                actionMenuView.setTranslationX(BottomAppBar.this.R(r0, i3, z16));
            }
        };
        if (z17) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    protected void J(int i3, List<Animator> list) {
        FloatingActionButton O = O();
        if (O != null && !O.t()) {
            N();
            O.r(new e(i3));
        }
    }

    protected int R(@NonNull ActionMenuView actionMenuView, int i3, boolean z16) {
        int i16;
        int left;
        int i17;
        boolean z17;
        if (i3 != 1 || !z16) {
            return 0;
        }
        boolean i18 = ViewUtils.i(this);
        if (i18) {
            i16 = getMeasuredWidth();
        } else {
            i16 = 0;
        }
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt = getChildAt(i19);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (i18) {
                    i16 = Math.min(i16, childAt.getLeft());
                } else {
                    i16 = Math.max(i16, childAt.getRight());
                }
            }
        }
        if (i18) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        if (i18) {
            i17 = this.P;
        } else {
            i17 = -this.Q;
        }
        return i16 - (left + i17);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public Behavior getBehavior() {
        if (this.M == null) {
            this.M = new Behavior();
        }
        return this.M;
    }

    @Dimension
    public float U() {
        return d0().c();
    }

    public float V() {
        return d0().e();
    }

    @Dimension
    public float W() {
        return d0().f();
    }

    public boolean a0() {
        return this.D;
    }

    public void i0(@MenuRes int i3) {
        if (i3 != 0) {
            this.J = 0;
            getMenu().clear();
            inflateMenu(i3);
        }
    }

    void l0(@Dimension float f16) {
        if (f16 != d0().d()) {
            d0().k(f16);
            this.f33300f.invalidateSelf();
        }
    }

    boolean m0(@Px int i3) {
        float f16 = i3;
        if (f16 != d0().h()) {
            d0().n(f16);
            this.f33300f.invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.d.f(this, this.f33300f);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            I();
            k0();
        }
        j0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f33303m = savedState.f33312d;
        this.L = savedState.f33313e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f33312d = this.f33303m;
        savedState.f33313e = this.L;
        return savedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f33300f, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f16) {
        if (f16 != U()) {
            d0().j(f16);
            this.f33300f.invalidateSelf();
            k0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f16) {
        this.f33300f.X(f16);
        getBehavior().f(this, this.f33300f.D() - this.f33300f.C());
    }

    public void setFabAlignmentMode(int i3) {
        setFabAlignmentModeAndReplaceMenu(i3, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i3, @MenuRes int i16) {
        this.J = i16;
        this.K = true;
        f0(i3, this.L);
        g0(i3);
        this.f33303m = i3;
    }

    public void setFabAnimationMode(int i3) {
        this.C = i3;
    }

    public void setFabCradleMargin(@Dimension float f16) {
        if (f16 != V()) {
            d0().l(f16);
            this.f33300f.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f16) {
        if (f16 != W()) {
            d0().m(f16);
            this.f33300f.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z16) {
        this.D = z16;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(h0(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i3) {
        this.f33298d = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a2o);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: k, reason: collision with root package name */
        @NonNull
        private final Rect f33307k;

        /* renamed from: l, reason: collision with root package name */
        private WeakReference<BottomAppBar> f33308l;

        /* renamed from: m, reason: collision with root package name */
        private int f33309m;

        /* renamed from: n, reason: collision with root package name */
        private final View.OnLayoutChangeListener f33310n;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f33308l.get();
                if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.m(Behavior.this.f33307k);
                    int height = Behavior.this.f33307k.height();
                    bottomAppBar.m0(height);
                    bottomAppBar.l0(floatingActionButton.n().r().a(new RectF(Behavior.this.f33307k)));
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (Behavior.this.f33309m == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.T() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.cri) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.b0();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.c0();
                        if (ViewUtils.i(floatingActionButton)) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f33299e;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f33299e;
                            return;
                        }
                    }
                    return;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f33310n = new a();
            this.f33307k = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i3) {
            this.f33308l = new WeakReference<>(bottomAppBar);
            View P = bottomAppBar.P();
            if (P != null && !ViewCompat.isLaidOut(P)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) P.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.f33309m = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (P instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) P;
                    if (floatingActionButton.o() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.f1829);
                    }
                    if (floatingActionButton.k() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.f1818);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.f33310n);
                    bottomAppBar.H(floatingActionButton);
                }
                bottomAppBar.k0();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i3);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i3, int i16) {
            if (bottomAppBar.a0() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i3, i16)) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33310n = new a();
            this.f33307k = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r6), attributeSet, i3);
        int i16 = T;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f33300f = materialShapeDrawable;
        this.H = 0;
        this.J = 0;
        this.K = false;
        this.L = true;
        this.R = new a();
        this.S = new b();
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.Z, i3, i16, new int[0]);
        ColorStateList a16 = g1.c.a(context2, h16, w0.a.f443809a0);
        int i17 = w0.a.f443905i0;
        if (h16.hasValue(i17)) {
            setNavigationIconTint(h16.getColor(i17, -1));
        }
        int dimensionPixelSize = h16.getDimensionPixelSize(w0.a.f443821b0, 0);
        float dimensionPixelOffset = h16.getDimensionPixelOffset(w0.a.f443857e0, 0);
        float dimensionPixelOffset2 = h16.getDimensionPixelOffset(w0.a.f443869f0, 0);
        float dimensionPixelOffset3 = h16.getDimensionPixelOffset(w0.a.f443881g0, 0);
        this.f33303m = h16.getInt(w0.a.f443833c0, 0);
        this.C = h16.getInt(w0.a.f443845d0, 0);
        this.D = h16.getBoolean(w0.a.f443893h0, false);
        this.E = h16.getBoolean(w0.a.f443916j0, false);
        this.F = h16.getBoolean(w0.a.f443927k0, false);
        this.G = h16.getBoolean(w0.a.f443938l0, false);
        h16.recycle();
        this.f33299e = getResources().getDimensionPixelOffset(R.dimen.crh);
        materialShapeDrawable.setShapeAppearanceModel(com.google.android.material.shape.g.a().B(new com.google.android.material.bottomappbar.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        materialShapeDrawable.f0(2);
        materialShapeDrawable.b0(Paint.Style.FILL);
        materialShapeDrawable.N(context2);
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(materialShapeDrawable, a16);
        ViewCompat.setBackground(this, materialShapeDrawable);
        ViewUtils.a(this, attributeSet, i3, i16, new c());
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
