package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.d;
import com.google.android.material.shape.g;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] P = {R.attr.state_checked};
    private static final int[] Q = {-16842910};
    private static final int R = 2131953246;
    private final i C;
    c D;
    private final int E;
    private final int[] F;
    private MenuInflater G;
    private ViewTreeObserver.OnGlobalLayoutListener H;
    private boolean I;
    private boolean J;
    private int K;

    @Px
    private int L;

    @Nullable
    private Path M;
    private final RectF N;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    private final h f33927m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.F);
            boolean z26 = true;
            if (NavigationView.this.F[1] == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            NavigationView.this.C.e(z16);
            NavigationView navigationView2 = NavigationView.this;
            if (z16 && navigationView2.m()) {
                z17 = true;
            } else {
                z17 = false;
            }
            navigationView2.setDrawTopInsetForeground(z17);
            Activity a16 = com.google.android.material.internal.c.a(NavigationView.this.getContext());
            if (a16 != null) {
                if (a16.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (Color.alpha(a16.getWindow().getNavigationBarColor()) != 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                NavigationView navigationView3 = NavigationView.this;
                if (!z18 || !z19 || !navigationView3.l()) {
                    z26 = false;
                }
                navigationView3.setDrawBottomInsetForeground(z26);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private ColorStateList d(int i3) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i3, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(com.tencent.mobileqq.R.attr.a88, typedValue, true)) {
            return null;
        }
        int i16 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = Q;
        return new ColorStateList(new int[][]{iArr, P, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i16, defaultColor});
    }

    @NonNull
    private Drawable e(@NonNull TintTypedArray tintTypedArray) {
        return f(tintTypedArray, g1.c.b(getContext(), tintTypedArray, w0.a.F6));
    }

    @NonNull
    private Drawable f(@NonNull TintTypedArray tintTypedArray, @Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(g.b(getContext(), tintTypedArray.getResourceId(w0.a.D6, 0), tintTypedArray.getResourceId(w0.a.E6, 0)).m());
        materialShapeDrawable.Y(colorStateList);
        return new InsetDrawable((Drawable) materialShapeDrawable, tintTypedArray.getDimensionPixelSize(w0.a.I6, 0), tintTypedArray.getDimensionPixelSize(w0.a.J6, 0), tintTypedArray.getDimensionPixelSize(w0.a.H6, 0), tintTypedArray.getDimensionPixelSize(w0.a.G6, 0));
    }

    private MenuInflater h() {
        if (this.G == null) {
            this.G = new SupportMenuInflater(getContext());
        }
        return this.G;
    }

    private boolean i(@NonNull TintTypedArray tintTypedArray) {
        if (!tintTypedArray.hasValue(w0.a.D6) && !tintTypedArray.hasValue(w0.a.E6)) {
            return false;
        }
        return true;
    }

    private void n(@Px int i3, @Px int i16) {
        if ((getParent() instanceof DrawerLayout) && this.L > 0 && (getBackground() instanceof MaterialShapeDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
            g.b v3 = materialShapeDrawable.E().v();
            if (GravityCompat.getAbsoluteGravity(this.K, ViewCompat.getLayoutDirection(this)) == 3) {
                v3.I(this.L);
                v3.z(this.L);
            } else {
                v3.E(this.L);
                v3.v(this.L);
            }
            materialShapeDrawable.setShapeAppearanceModel(v3.m());
            if (this.M == null) {
                this.M = new Path();
            }
            this.M.reset();
            this.N.set(0.0f, 0.0f, i3, i16);
            com.google.android.material.shape.h.k().d(materialShapeDrawable.E(), materialShapeDrawable.y(), this.N, this.M);
            invalidate();
            return;
        }
        this.M = null;
        this.N.setEmpty();
    }

    private void o() {
        this.H = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.H);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.C.c(windowInsetsCompat);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        if (this.M == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.M);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @NonNull
    public Menu g() {
        return this.f33927m;
    }

    public View j(@LayoutRes int i3) {
        return this.C.d(i3);
    }

    public void k(int i3) {
        this.C.x(true);
        h().inflate(i3, this.f33927m);
        this.C.x(false);
        this.C.updateMenuView(false);
    }

    public boolean l() {
        return this.J;
    }

    public boolean m() {
        return this.I;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.H);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(this.E, 1073741824);
            }
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.E), 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f33927m.restorePresenterStates(savedState.f33928d);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f33928d = bundle;
        this.f33927m.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        n(i3, i16);
    }

    public void setBottomInsetScrimEnabled(boolean z16) {
        this.J = z16;
    }

    public void setCheckedItem(@IdRes int i3) {
        MenuItem findItem = this.f33927m.findItem(i3);
        if (findItem != null) {
            this.C.f((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i3) {
        this.C.g(i3);
    }

    public void setDividerInsetStart(@Px int i3) {
        this.C.h(i3);
    }

    @Override // android.view.View
    public void setElevation(float f16) {
        super.setElevation(f16);
        d.d(this, f16);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.C.j(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i3) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setItemHorizontalPadding(@Dimension int i3) {
        this.C.l(i3);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i3) {
        this.C.l(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconPadding(@Dimension int i3) {
        this.C.m(i3);
    }

    public void setItemIconPaddingResource(int i3) {
        this.C.m(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconSize(@Dimension int i3) {
        this.C.n(i3);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.C.o(colorStateList);
    }

    public void setItemMaxLines(int i3) {
        this.C.p(i3);
    }

    public void setItemTextAppearance(@StyleRes int i3) {
        this.C.q(i3);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.C.r(colorStateList);
    }

    public void setItemVerticalPadding(@Px int i3) {
        this.C.s(i3);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i3) {
        this.C.s(getResources().getDimensionPixelSize(i3));
    }

    public void setNavigationItemSelectedListener(@Nullable c cVar) {
        this.D = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(i3);
        i iVar = this.C;
        if (iVar != null) {
            iVar.t(i3);
        }
    }

    public void setSubheaderInsetEnd(@Px int i3) {
        this.C.v(i3);
    }

    public void setSubheaderInsetStart(@Px int i3) {
        this.C.v(i3);
    }

    public void setTopInsetScrimEnabled(boolean z16) {
        this.I = z16;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public Bundle f33928d;

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

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f33928d = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.f33928d);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.aya);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r9), attributeSet, i3);
        ColorStateList d16;
        int i16 = R;
        i iVar = new i();
        this.C = iVar;
        this.F = new int[2];
        this.I = true;
        this.J = true;
        this.K = 0;
        this.L = 0;
        this.N = new RectF();
        Context context2 = getContext();
        h hVar = new h(context2);
        this.f33927m = hVar;
        TintTypedArray i17 = o.i(context2, attributeSet, w0.a.f443943l6, i3, i16, new int[0]);
        int i18 = w0.a.f443965n6;
        if (i17.hasValue(i18)) {
            ViewCompat.setBackground(this, i17.getDrawable(i18));
        }
        this.L = i17.getDimensionPixelSize(w0.a.f444037t6, 0);
        this.K = i17.getInt(w0.a.f443954m6, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            g m3 = g.e(context2, attributeSet, i3, i16).m();
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(m3);
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.Y(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.N(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (i17.hasValue(w0.a.f444049u6)) {
            setElevation(i17.getDimensionPixelSize(r2, 0));
        }
        setFitsSystemWindows(i17.getBoolean(w0.a.f443977o6, false));
        this.E = i17.getDimensionPixelSize(w0.a.f443989p6, 0);
        int i19 = w0.a.O6;
        ColorStateList colorStateList = i17.hasValue(i19) ? i17.getColorStateList(i19) : null;
        int i26 = w0.a.R6;
        int resourceId = i17.hasValue(i26) ? i17.getResourceId(i26, 0) : 0;
        if (resourceId == 0 && colorStateList == null) {
            colorStateList = d(R.attr.textColorSecondary);
        }
        int i27 = w0.a.A6;
        if (i17.hasValue(i27)) {
            d16 = i17.getColorStateList(i27);
        } else {
            d16 = d(R.attr.textColorSecondary);
        }
        int i28 = w0.a.K6;
        int resourceId2 = i17.hasValue(i28) ? i17.getResourceId(i28, 0) : 0;
        int i29 = w0.a.f444107z6;
        if (i17.hasValue(i29)) {
            setItemIconSize(i17.getDimensionPixelSize(i29, 0));
        }
        int i36 = w0.a.L6;
        ColorStateList colorStateList2 = i17.hasValue(i36) ? i17.getColorStateList(i36) : null;
        if (resourceId2 == 0 && colorStateList2 == null) {
            colorStateList2 = d(R.attr.textColorPrimary);
        }
        Drawable drawable = i17.getDrawable(w0.a.f444071w6);
        if (drawable == null && i(i17)) {
            drawable = e(i17);
            ColorStateList b16 = g1.c.b(context2, i17, w0.a.C6);
            if (b16 != null) {
                iVar.k(new RippleDrawable(h1.b.d(b16), null, f(i17, null)));
            }
        }
        int i37 = w0.a.f444083x6;
        if (i17.hasValue(i37)) {
            setItemHorizontalPadding(i17.getDimensionPixelSize(i37, 0));
        }
        int i38 = w0.a.M6;
        if (i17.hasValue(i38)) {
            setItemVerticalPadding(i17.getDimensionPixelSize(i38, 0));
        }
        setDividerInsetStart(i17.getDimensionPixelSize(w0.a.f444025s6, 0));
        setDividerInsetEnd(i17.getDimensionPixelSize(w0.a.f444013r6, 0));
        setSubheaderInsetStart(i17.getDimensionPixelSize(w0.a.Q6, 0));
        setSubheaderInsetEnd(i17.getDimensionPixelSize(w0.a.P6, 0));
        setTopInsetScrimEnabled(i17.getBoolean(w0.a.S6, this.I));
        setBottomInsetScrimEnabled(i17.getBoolean(w0.a.f444001q6, this.J));
        int dimensionPixelSize = i17.getDimensionPixelSize(w0.a.f444095y6, 0);
        setItemMaxLines(i17.getInt(w0.a.B6, 1));
        hVar.setCallback(new a());
        iVar.i(1);
        iVar.initForMenu(context2, hVar);
        if (resourceId != 0) {
            iVar.w(resourceId);
        }
        iVar.u(colorStateList);
        iVar.o(d16);
        iVar.t(getOverScrollMode());
        if (resourceId2 != 0) {
            iVar.q(resourceId2);
        }
        iVar.r(colorStateList2);
        iVar.j(drawable);
        iVar.m(dimensionPixelSize);
        hVar.addMenuPresenter(iVar);
        addView((View) iVar.getMenuView(this));
        int i39 = w0.a.N6;
        if (i17.hasValue(i39)) {
            k(i17.getResourceId(i39, 0));
        }
        int i46 = w0.a.f444060v6;
        if (i17.hasValue(i46)) {
            j(i17.getResourceId(i46, 0));
        }
        i17.recycle();
        o();
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f33927m.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.C.f((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            c cVar = NavigationView.this.D;
            if (cVar != null && cVar.onNavigationItemSelected(menuItem)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }
}
