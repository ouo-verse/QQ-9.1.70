package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: P */
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.isOverflowButton = false;
        }

        LayoutParams(int i3, int i16, boolean z16) {
            super(i3, i16);
            this.isOverflowButton = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.mOnMenuItemClickListener;
            if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.mMenuBuilderCallback;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int measureChildForCells(View view, int i3, int i16, int i17, int i18) {
        ActionMenuItemView actionMenuItemView;
        boolean z16;
        int i19;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i17) - i18, View.MeasureSpec.getMode(i17));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z17 = true;
        if (actionMenuItemView != null && actionMenuItemView.hasText()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 > 0) {
            i19 = 2;
            if (!z16 || i16 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i16 * i3, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i26 = measuredWidth / i3;
                if (measuredWidth % i3 != 0) {
                    i26++;
                }
                if (!z16 || i26 >= 2) {
                    i19 = i26;
                }
                if (!layoutParams.isOverflowButton || !z16) {
                    z17 = false;
                }
                layoutParams.expandable = z17;
                layoutParams.cellsUsed = i19;
                view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i19, 1073741824), makeMeasureSpec);
                return i19;
            }
        }
        i19 = 0;
        if (!layoutParams.isOverflowButton) {
        }
        z17 = false;
        layoutParams.expandable = z17;
        layoutParams.cellsUsed = i19;
        view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i19, 1073741824), makeMeasureSpec);
        return i19;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void onMeasureExactFormat(int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        boolean z17;
        int i19;
        boolean z18;
        int i26;
        boolean z19;
        int i27;
        int i28;
        boolean z26;
        int i29;
        ?? r142;
        boolean z27;
        int i36;
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, paddingTop, -2);
        int i37 = size - paddingLeft;
        int i38 = this.mMinCellSize;
        int i39 = i37 / i38;
        int i46 = i37 % i38;
        if (i39 == 0) {
            setMeasuredDimension(i37, 0);
            return;
        }
        int i47 = i38 + (i46 / i39);
        int childCount = getChildCount();
        int i48 = 0;
        int i49 = 0;
        boolean z28 = false;
        int i56 = 0;
        int i57 = 0;
        int i58 = 0;
        long j3 = 0;
        while (i49 < childCount) {
            View childAt = getChildAt(i49);
            int i59 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z29 = childAt instanceof ActionMenuItemView;
                int i65 = i56 + 1;
                if (z29) {
                    int i66 = this.mGeneratedItemPadding;
                    i29 = i65;
                    r142 = 0;
                    childAt.setPadding(i66, 0, i66, 0);
                } else {
                    i29 = i65;
                    r142 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = r142;
                layoutParams.extraPixels = r142;
                layoutParams.cellsUsed = r142;
                layoutParams.expandable = r142;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = r142;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = r142;
                if (z29 && ((ActionMenuItemView) childAt).hasText()) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                layoutParams.preventEdgeOffset = z27;
                if (layoutParams.isOverflowButton) {
                    i36 = 1;
                } else {
                    i36 = i39;
                }
                int measureChildForCells = measureChildForCells(childAt, i47, i36, childMeasureSpec, paddingTop);
                i57 = Math.max(i57, measureChildForCells);
                if (layoutParams.expandable) {
                    i58++;
                }
                if (layoutParams.isOverflowButton) {
                    z28 = true;
                }
                i39 -= measureChildForCells;
                i48 = Math.max(i48, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j3 |= 1 << i49;
                    i48 = i48;
                }
                i56 = i29;
            }
            i49++;
            size2 = i59;
        }
        int i67 = size2;
        if (z28 && i56 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z36 = false;
        while (i58 > 0 && i39 > 0) {
            int i68 = Integer.MAX_VALUE;
            int i69 = 0;
            int i75 = 0;
            long j16 = 0;
            while (i75 < childCount) {
                boolean z37 = z36;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i75).getLayoutParams();
                int i76 = i48;
                if (layoutParams2.expandable) {
                    int i77 = layoutParams2.cellsUsed;
                    if (i77 < i68) {
                        j16 = 1 << i75;
                        i68 = i77;
                        i69 = 1;
                    } else if (i77 == i68) {
                        i69++;
                        j16 |= 1 << i75;
                    }
                }
                i75++;
                i48 = i76;
                z36 = z37;
            }
            z17 = z36;
            i19 = i48;
            j3 |= j16;
            if (i69 > i39) {
                i17 = mode;
                i18 = i37;
                break;
            }
            int i78 = i68 + 1;
            int i79 = 0;
            while (i79 < childCount) {
                View childAt2 = getChildAt(i79);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                int i85 = i37;
                int i86 = mode;
                long j17 = 1 << i79;
                if ((j16 & j17) == 0) {
                    if (layoutParams3.cellsUsed == i78) {
                        j3 |= j17;
                    }
                    z26 = z16;
                } else {
                    if (z16 && layoutParams3.preventEdgeOffset && i39 == 1) {
                        int i87 = this.mGeneratedItemPadding;
                        z26 = z16;
                        childAt2.setPadding(i87 + i47, 0, i87, 0);
                    } else {
                        z26 = z16;
                    }
                    layoutParams3.cellsUsed++;
                    layoutParams3.expanded = true;
                    i39--;
                }
                i79++;
                mode = i86;
                i37 = i85;
                z16 = z26;
            }
            i48 = i19;
            z36 = true;
        }
        i17 = mode;
        i18 = i37;
        z17 = z36;
        i19 = i48;
        if (!z28 && i56 == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (i39 > 0 && j3 != 0 && (i39 < i56 - 1 || z18 || i57 > 1)) {
            float bitCount = Long.bitCount(j3);
            if (!z18) {
                i26 = 0;
                if ((j3 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
                int i88 = childCount - 1;
                if ((j3 & (1 << i88)) != 0 && !((LayoutParams) getChildAt(i88).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            } else {
                i26 = 0;
            }
            if (bitCount > 0.0f) {
                i28 = (int) ((i39 * i47) / bitCount);
            } else {
                i28 = i26;
            }
            z19 = z17;
            for (int i89 = i26; i89 < childCount; i89++) {
                if ((j3 & (1 << i89)) != 0) {
                    View childAt3 = getChildAt(i89);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i28;
                        layoutParams4.expanded = true;
                        if (i89 == 0 && !layoutParams4.preventEdgeOffset) {
                            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (-i28) / 2;
                        }
                        z19 = true;
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i28;
                        layoutParams4.expanded = true;
                        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (-i28) / 2;
                        z19 = true;
                    } else {
                        if (i89 != 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = i28 / 2;
                        }
                        if (i89 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = i28 / 2;
                        }
                    }
                }
            }
        } else {
            i26 = 0;
            z19 = z17;
        }
        if (z19) {
            for (int i95 = i26; i95 < childCount; i95++) {
                View childAt4 = getChildAt(i95);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.expanded) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i47) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i17 != 1073741824) {
            i27 = i19;
        } else {
            i27 = i67;
        }
        setMeasuredDimension(i18, i27);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected boolean hasSupportDividerBeforeChildAt(int i3) {
        boolean z16 = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z16 = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (i3 > 0 && (childAt2 instanceof ActionMenuChildView)) {
            return z16 | ((ActionMenuChildView) childAt2).needsDividerBefore();
        }
        return z16;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending()) {
            return true;
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int width;
        int i26;
        if (!this.mFormatItems) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        int childCount = getChildCount();
        int i27 = (i18 - i16) / 2;
        int dividerWidth = getDividerWidth();
        int i28 = i17 - i3;
        int paddingRight = (i28 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i29 = 0;
        int i36 = 0;
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i37)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i26 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        width = i26 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        i26 = width - measuredWidth;
                    }
                    int i38 = i27 - (measuredHeight / 2);
                    childAt.layout(i26, i38, width, measuredHeight + i38);
                    paddingRight -= measuredWidth;
                    i29 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    hasSupportDividerBeforeChildAt(i37);
                    i36++;
                }
            }
        }
        if (childCount == 1 && i29 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i39 = (i28 / 2) - (measuredWidth2 / 2);
            int i46 = i27 - (measuredHeight2 / 2);
            childAt2.layout(i39, i46, measuredWidth2 + i39, measuredHeight2 + i46);
            return;
        }
        int i47 = i36 - (i29 ^ 1);
        if (i47 > 0) {
            i19 = paddingRight / i47;
        } else {
            i19 = 0;
        }
        int max = Math.max(0, i19);
        if (isLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            for (int i48 = 0; i48 < childCount; i48++) {
                View childAt3 = getChildAt(i48);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i49 = width2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i56 = i27 - (measuredHeight3 / 2);
                    childAt3.layout(i49 - measuredWidth3, i56, i49, measuredHeight3 + i56);
                    width2 = i49 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i57 = 0; i57 < childCount; i57++) {
            View childAt4 = getChildAt(i57);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i58 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i59 = i27 - (measuredHeight4 / 2);
                childAt4.layout(i58, i59, i58 + measuredWidth4, measuredHeight4 + i59);
                paddingLeft = i58 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i3, int i16) {
        boolean z16;
        MenuBuilder menuBuilder;
        boolean z17 = this.mFormatItems;
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mFormatItems = z16;
        if (z17 != z16) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.mFormatItems && childCount > 0) {
            onMeasureExactFormat(i3, i16);
            return;
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i17).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i3, i16);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z16) {
        this.mPresenter.setExpandedActionViewsExclusive(z16);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z16) {
        this.mReserveOverflow = z16;
    }

    public void setPopupTheme(@StyleRes int i3) {
        if (this.mPopupTheme != i3) {
            this.mPopupTheme = i3;
            if (i3 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu()) {
            return true;
        }
        return false;
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f16);
        this.mGeneratedItemPadding = (int) (f16 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (layoutParams2.gravity <= 0) {
                layoutParams2.gravity = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z16) {
        }
    }
}
