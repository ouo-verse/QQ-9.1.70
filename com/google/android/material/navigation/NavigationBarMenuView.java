package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.m;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {

    /* renamed from: c0, reason: collision with root package name */
    private static final int[] f33902c0 = {R.attr.state_checked};

    /* renamed from: d0, reason: collision with root package name */
    private static final int[] f33903d0 = {-16842910};
    private int C;
    private int D;

    @Nullable
    private ColorStateList E;

    @Dimension
    private int F;
    private ColorStateList G;

    @Nullable
    private final ColorStateList H;

    @StyleRes
    private int I;

    @StyleRes
    private int J;
    private Drawable K;
    private int L;

    @NonNull
    private final SparseArray<BadgeDrawable> M;
    private int N;
    private int P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private g U;
    private boolean V;
    private ColorStateList W;

    /* renamed from: a0, reason: collision with root package name */
    private NavigationBarPresenter f33904a0;

    /* renamed from: b0, reason: collision with root package name */
    private MenuBuilder f33905b0;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final TransitionSet f33906d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final View.OnClickListener f33907e;

    /* renamed from: f, reason: collision with root package name */
    private final Pools.Pool<NavigationBarItemView> f33908f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final SparseArray<View.OnTouchListener> f33909h;

    /* renamed from: i, reason: collision with root package name */
    private int f33910i;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private NavigationBarItemView[] f33911m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
            if (!NavigationBarMenuView.this.f33905b0.performItemAction(itemData, NavigationBarMenuView.this.f33904a0, 0)) {
                itemData.setChecked(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.f33908f = new Pools.SynchronizedPool(5);
        this.f33909h = new SparseArray<>(5);
        this.C = 0;
        this.D = 0;
        this.M = new SparseArray<>(5);
        this.N = -1;
        this.P = -1;
        this.V = false;
        this.H = d(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f33906d = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.f33906d = autoTransition;
            autoTransition.setOrdering(0);
            autoTransition.setDuration(f1.a.d(getContext(), com.tencent.mobileqq.R.attr.axa, getResources().getInteger(com.tencent.mobileqq.R.integer.f167190bi)));
            autoTransition.setInterpolator(f1.a.e(getContext(), com.tencent.mobileqq.R.attr.axk, x0.a.f446811b));
            autoTransition.addTransition(new m());
        }
        this.f33907e = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    @Nullable
    private Drawable e() {
        if (this.U != null && this.W != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.U);
            materialShapeDrawable.Y(this.W);
            return materialShapeDrawable;
        }
        return null;
    }

    private NavigationBarItemView k() {
        NavigationBarItemView acquire = this.f33908f.acquire();
        if (acquire == null) {
            return f(getContext());
        }
        return acquire;
    }

    private boolean o(int i3) {
        if (i3 != -1) {
            return true;
        }
        return false;
    }

    private void p() {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < this.f33905b0.size(); i3++) {
            hashSet.add(Integer.valueOf(this.f33905b0.getItem(i3).getItemId()));
        }
        for (int i16 = 0; i16 < this.M.size(); i16++) {
            int keyAt = this.M.keyAt(i16);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.M.delete(keyAt);
            }
        }
    }

    private void r(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id5 = navigationBarItemView.getId();
        if (o(id5) && (badgeDrawable = this.M.get(id5)) != null) {
            navigationBarItemView.u(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f33908f.release(navigationBarItemView);
                    navigationBarItemView.f();
                }
            }
        }
        if (this.f33905b0.size() == 0) {
            this.C = 0;
            this.D = 0;
            this.f33911m = null;
            return;
        }
        p();
        this.f33911m = new NavigationBarItemView[this.f33905b0.size()];
        boolean n3 = n(this.f33910i, this.f33905b0.getVisibleItems().size());
        for (int i3 = 0; i3 < this.f33905b0.size(); i3++) {
            this.f33904a0.c(true);
            this.f33905b0.getItem(i3).setCheckable(true);
            this.f33904a0.c(false);
            NavigationBarItemView k3 = k();
            this.f33911m[i3] = k3;
            k3.setIconTintList(this.E);
            k3.setIconSize(this.F);
            k3.setTextColor(this.H);
            k3.setTextAppearanceInactive(this.I);
            k3.setTextAppearanceActive(this.J);
            k3.setTextColor(this.G);
            int i16 = this.N;
            if (i16 != -1) {
                k3.setItemPaddingTop(i16);
            }
            int i17 = this.P;
            if (i17 != -1) {
                k3.setItemPaddingBottom(i17);
            }
            k3.setActiveIndicatorWidth(this.R);
            k3.setActiveIndicatorHeight(this.S);
            k3.setActiveIndicatorMarginHorizontal(this.T);
            k3.setActiveIndicatorDrawable(e());
            k3.setActiveIndicatorResizeable(this.V);
            k3.setActiveIndicatorEnabled(this.Q);
            Drawable drawable = this.K;
            if (drawable != null) {
                k3.setItemBackground(drawable);
            } else {
                k3.setItemBackground(this.L);
            }
            k3.setShifting(n3);
            k3.setLabelVisibilityMode(this.f33910i);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f33905b0.getItem(i3);
            k3.initialize(menuItemImpl, 0);
            k3.setItemPosition(i3);
            int itemId = menuItemImpl.getItemId();
            k3.setOnTouchListener(this.f33909h.get(itemId));
            k3.setOnClickListener(this.f33907e);
            int i18 = this.C;
            if (i18 != 0 && itemId == i18) {
                this.D = i3;
            }
            r(k3);
            addView(k3);
        }
        int min = Math.min(this.f33905b0.size() - 1, this.D);
        this.D = min;
        this.f33905b0.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList d(int i3) {
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
        int[] iArr = f33903d0;
        return new ColorStateList(new int[][]{iArr, f33902c0, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i16, defaultColor});
    }

    @NonNull
    protected abstract NavigationBarItemView f(@NonNull Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> g() {
        return this.M;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Nullable
    public Drawable h() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null && navigationBarItemViewArr.length > 0) {
            return navigationBarItemViewArr[0].getBackground();
        }
        return this.K;
    }

    public int i() {
        return this.f33910i;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.f33905b0 = menuBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public MenuBuilder j() {
        return this.f33905b0;
    }

    public int l() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int m() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(int i3, int i16) {
        if (i3 == -1) {
            if (i16 > 3) {
                return true;
            }
        } else if (i3 == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f33905b0.getVisibleItems().size(), false, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(SparseArray<BadgeDrawable> sparseArray) {
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            int keyAt = sparseArray.keyAt(i3);
            if (this.M.indexOfKey(keyAt) < 0) {
                this.M.append(keyAt, sparseArray.get(keyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.u(this.M.get(navigationBarItemView.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(boolean z16) {
        this.V = z16;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z16);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.E = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.W = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(e());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z16) {
        this.Q = z16;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z16);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i3) {
        this.S = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i3);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i3) {
        this.T = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i3);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable g gVar) {
        this.U = gVar;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(e());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i3) {
        this.R = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i3);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.K = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i3) {
        this.L = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i3);
            }
        }
    }

    public void setItemIconSize(@Dimension int i3) {
        this.F = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i3);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i3, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f33909h.remove(i3);
        } else {
            this.f33909h.put(i3, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i3) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i3) {
        this.P = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i3);
            }
        }
    }

    public void setItemPaddingTop(@Px int i3) {
        this.N = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i3);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i3) {
        this.J = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i3);
                ColorStateList colorStateList = this.G;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i3) {
        this.I = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i3);
                ColorStateList colorStateList = this.G;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.G = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f33911m;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i3) {
        this.f33910i = i3;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.f33904a0 = navigationBarPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i3) {
        int size = this.f33905b0.size();
        for (int i16 = 0; i16 < size; i16++) {
            MenuItem item = this.f33905b0.getItem(i16);
            if (i3 == item.getItemId()) {
                this.C = i3;
                this.D = i16;
                item.setChecked(true);
                return;
            }
        }
    }

    public void u() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.f33905b0;
        if (menuBuilder != null && this.f33911m != null) {
            int size = menuBuilder.size();
            if (size != this.f33911m.length) {
                c();
                return;
            }
            int i3 = this.C;
            for (int i16 = 0; i16 < size; i16++) {
                MenuItem item = this.f33905b0.getItem(i16);
                if (item.isChecked()) {
                    this.C = item.getItemId();
                    this.D = i16;
                }
            }
            if (i3 != this.C && (transitionSet = this.f33906d) != null) {
                TransitionManager.beginDelayedTransition(this, transitionSet);
            }
            boolean n3 = n(this.f33910i, this.f33905b0.getVisibleItems().size());
            for (int i17 = 0; i17 < size; i17++) {
                this.f33904a0.c(true);
                this.f33911m[i17].setLabelVisibilityMode(this.f33910i);
                this.f33911m[i17].setShifting(n3);
                this.f33911m[i17].initialize((MenuItemImpl) this.f33905b0.getItem(i17), 0);
                this.f33904a0.c(false);
            }
        }
    }
}
