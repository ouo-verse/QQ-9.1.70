package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.d;
import com.google.android.material.shape.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.navigation.a f33919d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final NavigationBarMenuView f33920e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final NavigationBarPresenter f33921f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private ColorStateList f33922h;

    /* renamed from: i, reason: collision with root package name */
    private MenuInflater f33923i;

    /* renamed from: m, reason: collision with root package name */
    private c f33924m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface LabelVisibility {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        Bundle f33925d;

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

        private void a(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.f33925d = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.f33925d);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(k1.a.c(context, attributeSet, i3, i16), attributeSet, i3);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f33921f = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = w0.a.Q5;
        int i17 = w0.a.f443827b6;
        int i18 = w0.a.f443815a6;
        TintTypedArray i19 = o.i(context2, attributeSet, iArr, i3, i16, i17, i18);
        com.google.android.material.navigation.a aVar = new com.google.android.material.navigation.a(context2, getClass(), e());
        this.f33919d = aVar;
        NavigationBarMenuView d16 = d(context2);
        this.f33920e = d16;
        navigationBarPresenter.b(d16);
        navigationBarPresenter.a(1);
        d16.setPresenter(navigationBarPresenter);
        aVar.addMenuPresenter(navigationBarPresenter);
        navigationBarPresenter.initForMenu(getContext(), aVar);
        int i26 = w0.a.W5;
        if (i19.hasValue(i26)) {
            d16.setIconTintList(i19.getColorStateList(i26));
        } else {
            d16.setIconTintList(d16.d(R.attr.textColorSecondary));
        }
        setItemIconSize(i19.getDimensionPixelSize(w0.a.V5, getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.cuk)));
        if (i19.hasValue(i17)) {
            setItemTextAppearanceInactive(i19.getResourceId(i17, 0));
        }
        if (i19.hasValue(i18)) {
            setItemTextAppearanceActive(i19.getResourceId(i18, 0));
        }
        int i27 = w0.a.f443839c6;
        if (i19.hasValue(i27)) {
            setItemTextColor(i19.getColorStateList(i27));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, c(context2));
        }
        int i28 = w0.a.Y5;
        if (i19.hasValue(i28)) {
            setItemPaddingTop(i19.getDimensionPixelSize(i28, 0));
        }
        int i29 = w0.a.X5;
        if (i19.hasValue(i29)) {
            setItemPaddingBottom(i19.getDimensionPixelSize(i29, 0));
        }
        if (i19.hasValue(w0.a.S5)) {
            setElevation(i19.getDimensionPixelSize(r12, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), g1.c.b(context2, i19, w0.a.R5));
        setLabelVisibilityMode(i19.getInteger(w0.a.f443851d6, -1));
        int resourceId = i19.getResourceId(w0.a.U5, 0);
        if (resourceId != 0) {
            d16.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(g1.c.b(context2, i19, w0.a.Z5));
        }
        int resourceId2 = i19.getResourceId(w0.a.T5, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, w0.a.K5);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(w0.a.M5, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(w0.a.L5, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(w0.a.O5, 0));
            setItemActiveIndicatorColor(g1.c.a(context2, obtainStyledAttributes, w0.a.N5));
            setItemActiveIndicatorShapeAppearance(g.b(context2, obtainStyledAttributes.getResourceId(w0.a.P5, 0), 0).m());
            obtainStyledAttributes.recycle();
        }
        int i36 = w0.a.f443863e6;
        if (i19.hasValue(i36)) {
            j(i19.getResourceId(i36, 0));
        }
        i19.recycle();
        addView(d16);
        aVar.setCallback(new a());
    }

    static /* synthetic */ b a(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    @NonNull
    private MaterialShapeDrawable c(Context context) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            materialShapeDrawable.Y(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        materialShapeDrawable.N(context);
        return materialShapeDrawable;
    }

    private MenuInflater g() {
        if (this.f33923i == null) {
            this.f33923i = new SupportMenuInflater(getContext());
        }
        return this.f33923i;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract NavigationBarMenuView d(@NonNull Context context);

    public abstract int e();

    @NonNull
    public Menu f() {
        return this.f33919d;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView h() {
        return this.f33920e;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter i() {
        return this.f33921f;
    }

    public void j(int i3) {
        this.f33921f.c(true);
        g().inflate(i3, this.f33919d);
        this.f33921f.c(false);
        this.f33921f.updateMenuView(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f33919d.restorePresenterStates(savedState.f33925d);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f33925d = bundle;
        this.f33919d.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f16) {
        super.setElevation(f16);
        d.d(this, f16);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f33920e.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z16) {
        this.f33920e.setItemActiveIndicatorEnabled(z16);
    }

    public void setItemActiveIndicatorHeight(@Px int i3) {
        this.f33920e.setItemActiveIndicatorHeight(i3);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i3) {
        this.f33920e.setItemActiveIndicatorMarginHorizontal(i3);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable g gVar) {
        this.f33920e.setItemActiveIndicatorShapeAppearance(gVar);
    }

    public void setItemActiveIndicatorWidth(@Px int i3) {
        this.f33920e.setItemActiveIndicatorWidth(i3);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f33920e.setItemBackground(drawable);
        this.f33922h = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i3) {
        this.f33920e.setItemBackgroundRes(i3);
        this.f33922h = null;
    }

    public void setItemIconSize(@Dimension int i3) {
        this.f33920e.setItemIconSize(i3);
    }

    public void setItemIconSizeRes(@DimenRes int i3) {
        setItemIconSize(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f33920e.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i3, @Nullable View.OnTouchListener onTouchListener) {
        this.f33920e.setItemOnTouchListener(i3, onTouchListener);
    }

    public void setItemPaddingBottom(@Px int i3) {
        this.f33920e.setItemPaddingBottom(i3);
    }

    public void setItemPaddingTop(@Px int i3) {
        this.f33920e.setItemPaddingTop(i3);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f33922h == colorStateList) {
            if (colorStateList == null && this.f33920e.h() != null) {
                this.f33920e.setItemBackground(null);
                return;
            }
            return;
        }
        this.f33922h = colorStateList;
        if (colorStateList == null) {
            this.f33920e.setItemBackground(null);
        } else {
            this.f33920e.setItemBackground(new RippleDrawable(h1.b.a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i3) {
        this.f33920e.setItemTextAppearanceActive(i3);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i3) {
        this.f33920e.setItemTextAppearanceInactive(i3);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f33920e.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i3) {
        if (this.f33920e.i() != i3) {
            this.f33920e.setLabelVisibilityMode(i3);
            this.f33921f.updateMenuView(false);
        }
    }

    public void setOnItemSelectedListener(@Nullable c cVar) {
        this.f33924m = cVar;
    }

    public void setSelectedItemId(@IdRes int i3) {
        MenuItem findItem = this.f33919d.findItem(i3);
        if (findItem != null && !this.f33919d.performItemAction(findItem, this.f33921f, 0)) {
            findItem.setChecked(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            NavigationBarView.a(NavigationBarView.this);
            if (NavigationBarView.this.f33924m != null && !NavigationBarView.this.f33924m.onNavigationItemSelected(menuItem)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public void setOnItemReselectedListener(@Nullable b bVar) {
    }
}
