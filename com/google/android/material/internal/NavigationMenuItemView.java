package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] M = {R.attr.state_checked};
    private int C;
    private boolean D;
    boolean E;
    private final CheckedTextView F;
    private FrameLayout G;
    private MenuItemImpl H;
    private ColorStateList I;
    private boolean J;
    private Drawable K;
    private final AccessibilityDelegateCompat L;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.E);
        }
    }

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void b() {
        if (g()) {
            this.F.setVisibility(8);
            FrameLayout frameLayout = this.G;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                this.G.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.F.setVisibility(0);
        FrameLayout frameLayout2 = this.G;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            this.G.setLayoutParams(layoutParams2);
        }
    }

    @Nullable
    private StateListDrawable c() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(com.tencent.mobileqq.R.attr.a7p, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(M, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private void e(@Nullable View view) {
        if (view != null) {
            if (this.G == null) {
                this.G = (FrameLayout) ((ViewStub) findViewById(com.tencent.mobileqq.R.id.ugm)).inflate();
            }
            this.G.removeAllViews();
            this.G.addView(view);
        }
    }

    private boolean g() {
        if (this.H.getTitle() == null && this.H.getIcon() == null && this.H.getActionView() != null) {
            return true;
        }
        return false;
    }

    public void d() {
        FrameLayout frameLayout = this.G;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.F.setCompoundDrawables(null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        boolean z16;
        this.I = colorStateList;
        if (colorStateList != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.J = z16;
        MenuItemImpl menuItemImpl = this.H;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.H;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i3) {
        int i16;
        this.H = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        if (menuItemImpl.isVisible()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        setVisibility(i16);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, c());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        e(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        MenuItemImpl menuItemImpl = this.H;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.H.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, M);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z16) {
        refreshDrawableState();
        if (this.E != z16) {
            this.E = z16;
            this.L.sendAccessibilityEvent(this.F, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z16) {
        refreshDrawableState();
        this.F.setChecked(z16);
    }

    public void setHorizontalPadding(int i3) {
        setPadding(i3, getPaddingTop(), i3, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.J) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.I);
            }
            int i3 = this.C;
            drawable.setBounds(0, 0, i3, i3);
        } else if (this.D) {
            if (this.K == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.tencent.mobileqq.R.drawable.f161101k21, getContext().getTheme());
                this.K = drawable2;
                if (drawable2 != null) {
                    int i16 = this.C;
                    drawable2.setBounds(0, 0, i16, i16);
                }
            }
            drawable = this.K;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.F, drawable, null, null, null);
    }

    public void setIconPadding(int i3) {
        this.F.setCompoundDrawablePadding(i3);
    }

    public void setIconSize(@Dimension int i3) {
        this.C = i3;
    }

    public void setMaxLines(int i3) {
        this.F.setMaxLines(i3);
    }

    public void setNeedsEmptyIcon(boolean z16) {
        this.D = z16;
    }

    public void setTextAppearance(int i3) {
        TextViewCompat.setTextAppearance(this.F, i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.F.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.F.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a aVar = new a();
        this.L = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.e5u, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.c8s));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.tencent.mobileqq.R.id.ugn);
        this.F = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z16, char c16) {
    }
}
