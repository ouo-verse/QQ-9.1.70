package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(@NonNull Context context) {
        this(context, null);
    }

    private void addCustomViewsWithGravity(List<View> list, int i3) {
        boolean z16;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (z16) {
            for (int i16 = childCount - 1; i16 >= 0; i16--) {
                View childAt = getChildAt(i16);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view, boolean z16) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.mViewType = 1;
        if (z16 && this.mExpandedActionView != null) {
            view.setLayoutParams(layoutParams);
            this.mHiddenViews.add(view);
        } else {
            addView(view, layoutParams);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.bj8);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i3) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i3, layoutDirection) & 7;
        if (absoluteGravity != 1 && absoluteGravity != 3 && absoluteGravity != 5) {
            if (layoutDirection != 1) {
                return 3;
            }
            return 5;
        }
        return absoluteGravity;
    }

    private int getChildTop(View view, int i3) {
        int i16;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 > 0) {
            i16 = (measuredHeight - i3) / 2;
        } else {
            i16 = 0;
        }
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity != 48) {
            if (childVerticalGravity != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i17 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i17 < i18) {
                    i17 = i18;
                } else {
                    int i19 = (((height - paddingBottom) - measuredHeight) - i17) - paddingTop;
                    int i26 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (i19 < i26) {
                        i17 = Math.max(0, i17 - (i26 - i19));
                    }
                }
                return paddingTop + i17;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i16;
        }
        return getPaddingTop() - i16;
    }

    private int getChildVerticalGravity(int i3) {
        int i16 = i3 & 112;
        if (i16 != 16 && i16 != 48 && i16 != 80) {
            return this.mGravity & 112;
        }
        return i16;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i3 = iArr[0];
        int i16 = iArr[1];
        int size = list.size();
        int i17 = 0;
        int i18 = 0;
        while (i17 < size) {
            View view = list.get(i17);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i19 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i3;
            int i26 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i16;
            int max = Math.max(0, i19);
            int max2 = Math.max(0, i26);
            int max3 = Math.max(0, -i19);
            int max4 = Math.max(0, -i26);
            i18 += max + view.getMeasuredWidth() + max2;
            i17++;
            i16 = max4;
            i3 = max3;
        }
        return i18;
    }

    private boolean isChildOrHidden(View view) {
        if (view.getParent() != this && !this.mHiddenViews.contains(view)) {
            return false;
        }
        return true;
    }

    private int layoutChildLeft(View view, int i3, int[] iArr, int i16) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i3 + Math.max(0, i17);
        iArr[0] = Math.max(0, -i17);
        int childTop = getChildTop(view, i16);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int layoutChildRight(View view, int i3, int[] iArr, int i16) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i3 - Math.max(0, i17);
        iArr[1] = Math.max(0, -i17);
        int childTop = getChildTop(view, i16);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i3, int i16, int i17, int i18, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i19 = marginLayoutParams.leftMargin - iArr[0];
        int i26 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i19) + Math.max(0, i26);
        iArr[0] = Math.max(0, -i19);
        iArr[1] = Math.max(0, -i26);
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + max + i16, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i17, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i18, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i3, int i16, int i17, int i18, int i19) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i16, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i17, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i18, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i19 >= 0) {
            if (mode != 0) {
                i19 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i19);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        if (getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.isOverflowReserved()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
            return true;
        }
        return false;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.bj8);
            this.mCollapseButtonView = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    Toolbar.this.collapseActionView();
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getEnd();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i3 = this.mContentInsetEndWithActions;
        if (i3 == Integer.MIN_VALUE) {
            return getContentInsetEnd();
        }
        return i3;
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getLeft();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getRight();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.getStart();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i3 = this.mContentInsetStartWithNavigation;
        if (i3 == Integer.MIN_VALUE) {
            return getContentInsetStart();
        }
        return i3;
    }

    public int getCurrentContentInsetEnd() {
        boolean z16;
        MenuBuilder peekMenu;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && (peekMenu = actionMenuView.peekMenu()) != null && peekMenu.hasVisibleItems()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.mCurrentExpandedItem != null) {
            return true;
        }
        return false;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && actionMenuView.hideOverflowMenu()) {
            return true;
        }
        return false;
    }

    public void inflateMenu(@MenuRes int i3) {
        getMenuInflater().inflate(i3, getMenu());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && actionMenuView.isOverflowMenuShowPending()) {
            return true;
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && actionMenuView.isOverflowMenuShowing()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i3 = 0; i3 < lineCount; i3++) {
            if (layout.getEllipsisCount(i3) > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x029f A[LOOP:0: B:41:0x029d->B:42:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c1 A[LOOP:1: B:45:0x02bf->B:46:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02fa A[LOOP:2: B:54:0x02f8->B:55:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int paddingTop;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int size;
        int i58;
        int size2;
        int i59;
        int i65;
        int size3;
        boolean z17 = ViewCompat.getLayoutDirection(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i66 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        int min = minimumHeight >= 0 ? Math.min(minimumHeight, i18 - i16) : 0;
        if (!shouldLayout(this.mNavButtonView)) {
            i19 = paddingLeft;
        } else {
            if (z17) {
                i26 = layoutChildRight(this.mNavButtonView, i66, iArr, min);
                i19 = paddingLeft;
                if (shouldLayout(this.mCollapseButtonView)) {
                    if (z17) {
                        i26 = layoutChildRight(this.mCollapseButtonView, i26, iArr, min);
                    } else {
                        i19 = layoutChildLeft(this.mCollapseButtonView, i19, iArr, min);
                    }
                }
                if (shouldLayout(this.mMenuView)) {
                    if (z17) {
                        i19 = layoutChildLeft(this.mMenuView, i19, iArr, min);
                    } else {
                        i26 = layoutChildRight(this.mMenuView, i26, iArr, min);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - i19);
                iArr[1] = Math.max(0, currentContentInsetRight - (i66 - i26));
                int max = Math.max(i19, currentContentInsetLeft);
                int min2 = Math.min(i26, i66 - currentContentInsetRight);
                if (shouldLayout(this.mExpandedActionView)) {
                    if (z17) {
                        min2 = layoutChildRight(this.mExpandedActionView, min2, iArr, min);
                    } else {
                        max = layoutChildLeft(this.mExpandedActionView, max, iArr, min);
                    }
                }
                if (shouldLayout(this.mLogoView)) {
                    if (z17) {
                        min2 = layoutChildRight(this.mLogoView, min2, iArr, min);
                    } else {
                        max = layoutChildLeft(this.mLogoView, max, iArr, min);
                    }
                }
                shouldLayout = shouldLayout(this.mTitleTextView);
                shouldLayout2 = shouldLayout(this.mSubtitleTextView);
                if (shouldLayout) {
                    i27 = paddingRight;
                    i28 = 0;
                } else {
                    LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    i27 = paddingRight;
                    i28 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + 0;
                }
                if (shouldLayout2) {
                    i29 = width;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    i29 = width;
                    i28 += ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                }
                if (!shouldLayout || shouldLayout2) {
                    TextView textView = !shouldLayout ? this.mTitleTextView : this.mSubtitleTextView;
                    TextView textView2 = !shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView;
                    LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
                    LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
                    boolean z18 = (!shouldLayout && this.mTitleTextView.getMeasuredWidth() > 0) || (shouldLayout2 && this.mSubtitleTextView.getMeasuredWidth() > 0);
                    i36 = this.mGravity & 112;
                    i37 = paddingLeft;
                    if (i36 != 48) {
                        i38 = max;
                        i39 = min;
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.mTitleMarginTop;
                    } else if (i36 != 80) {
                        int i67 = (((height - paddingTop2) - paddingBottom) - i28) / 2;
                        int i68 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
                        i39 = min;
                        int i69 = this.mTitleMarginTop;
                        i38 = max;
                        if (i67 < i68 + i69) {
                            i67 = i68 + i69;
                        } else {
                            int i75 = (((height - paddingBottom) - i28) - i67) - paddingTop2;
                            int i76 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                            int i77 = this.mTitleMarginBottom;
                            if (i75 < i76 + i77) {
                                i67 = Math.max(0, i67 - ((((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + i77) - i75));
                            }
                        }
                        paddingTop = paddingTop2 + i67;
                    } else {
                        i38 = max;
                        i39 = min;
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - this.mTitleMarginBottom) - i28;
                    }
                    if (!z17) {
                        int i78 = (z18 ? this.mTitleMarginStart : 0) - iArr[1];
                        min2 -= Math.max(0, i78);
                        iArr[1] = Math.max(0, -i78);
                        if (shouldLayout) {
                            LayoutParams layoutParams5 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                            int measuredWidth = min2 - this.mTitleTextView.getMeasuredWidth();
                            int measuredHeight = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                            this.mTitleTextView.layout(measuredWidth, paddingTop, min2, measuredHeight);
                            i56 = measuredWidth - this.mTitleMarginEnd;
                            paddingTop = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                        } else {
                            i56 = min2;
                        }
                        if (shouldLayout2) {
                            int i79 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                            this.mSubtitleTextView.layout(min2 - this.mSubtitleTextView.getMeasuredWidth(), i79, min2, this.mSubtitleTextView.getMeasuredHeight() + i79);
                            i57 = min2 - this.mTitleMarginEnd;
                        } else {
                            i57 = min2;
                        }
                        if (z18) {
                            min2 = Math.min(i56, i57);
                        }
                        max = i38;
                    } else {
                        if (z18) {
                            i47 = this.mTitleMarginStart;
                            i46 = 0;
                        } else {
                            i46 = 0;
                            i47 = 0;
                        }
                        int i85 = i47 - iArr[i46];
                        max = i38 + Math.max(i46, i85);
                        iArr[i46] = Math.max(i46, -i85);
                        if (shouldLayout) {
                            LayoutParams layoutParams6 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                            int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                            int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                            this.mTitleTextView.layout(max, paddingTop, measuredWidth2, measuredHeight2);
                            i48 = measuredWidth2 + this.mTitleMarginEnd;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                        } else {
                            i48 = max;
                        }
                        if (shouldLayout2) {
                            int i86 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                            this.mSubtitleTextView.layout(max, i86, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i86);
                            i49 = measuredWidth3 + this.mTitleMarginEnd;
                        } else {
                            i49 = max;
                        }
                        if (z18) {
                            max = Math.max(i48, i49);
                        }
                        addCustomViewsWithGravity(this.mTempViews, 3);
                        size = this.mTempViews.size();
                        for (i58 = i46; i58 < size; i58++) {
                            max = layoutChildLeft(this.mTempViews.get(i58), max, iArr, i39);
                        }
                        int i87 = i39;
                        addCustomViewsWithGravity(this.mTempViews, 5);
                        size2 = this.mTempViews.size();
                        for (i59 = i46; i59 < size2; i59++) {
                            min2 = layoutChildRight(this.mTempViews.get(i59), min2, iArr, i87);
                        }
                        addCustomViewsWithGravity(this.mTempViews, 1);
                        int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
                        i65 = (i37 + (((i29 - i37) - i27) / 2)) - (viewListMeasuredWidth / 2);
                        int i88 = viewListMeasuredWidth + i65;
                        if (i65 >= max) {
                            max = i88 > min2 ? i65 - (i88 - min2) : i65;
                        }
                        size3 = this.mTempViews.size();
                        while (i46 < size3) {
                            max = layoutChildLeft(this.mTempViews.get(i46), max, iArr, i87);
                            i46++;
                        }
                        this.mTempViews.clear();
                        return;
                    }
                } else {
                    i37 = paddingLeft;
                    i39 = min;
                }
                i46 = 0;
                addCustomViewsWithGravity(this.mTempViews, 3);
                size = this.mTempViews.size();
                while (i58 < size) {
                }
                int i872 = i39;
                addCustomViewsWithGravity(this.mTempViews, 5);
                size2 = this.mTempViews.size();
                while (i59 < size2) {
                }
                addCustomViewsWithGravity(this.mTempViews, 1);
                int viewListMeasuredWidth2 = getViewListMeasuredWidth(this.mTempViews, iArr);
                i65 = (i37 + (((i29 - i37) - i27) / 2)) - (viewListMeasuredWidth2 / 2);
                int i882 = viewListMeasuredWidth2 + i65;
                if (i65 >= max) {
                }
                size3 = this.mTempViews.size();
                while (i46 < size3) {
                }
                this.mTempViews.clear();
                return;
            }
            i19 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, min);
        }
        i26 = i66;
        if (shouldLayout(this.mCollapseButtonView)) {
        }
        if (shouldLayout(this.mMenuView)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i19);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i66 - i26));
        int max2 = Math.max(i19, currentContentInsetLeft2);
        int min22 = Math.min(i26, i66 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
        }
        if (shouldLayout(this.mLogoView)) {
        }
        shouldLayout = shouldLayout(this.mTitleTextView);
        shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (shouldLayout) {
        }
        if (shouldLayout2) {
        }
        if (shouldLayout) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        LayoutParams layoutParams32 = (LayoutParams) textView.getLayoutParams();
        LayoutParams layoutParams42 = (LayoutParams) textView2.getLayoutParams();
        if (shouldLayout) {
        }
        i36 = this.mGravity & 112;
        i37 = paddingLeft;
        if (i36 != 48) {
        }
        if (!z17) {
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int[] iArr = this.mTempMargins;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i36 = 0;
        int i37 = !isLayoutRtl ? 1 : 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i3, 0, i16, 0, this.mMaxButtonHeight);
            i17 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i18 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i19 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i17 = 0;
            i18 = 0;
            i19 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i3, 0, i16, 0, this.mMaxButtonHeight);
            i17 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i18 = Math.max(i18, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i19 = View.combineMeasuredStates(i19, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i17);
        iArr[isLayoutRtl ? 1 : 0] = Math.max(0, currentContentInsetStart - i17);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i3, max, i16, 0, this.mMaxButtonHeight);
            i26 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i18 = Math.max(i18, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i19 = View.combineMeasuredStates(i19, this.mMenuView.getMeasuredState());
        } else {
            i26 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i26);
        iArr[i37] = Math.max(0, currentContentInsetEnd - i26);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i3, max2, i16, 0, iArr);
            i18 = Math.max(i18, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i19 = View.combineMeasuredStates(i19, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i3, max2, i16, 0, iArr);
            i18 = Math.max(i18, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i19 = View.combineMeasuredStates(i19, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i38 = 0; i38 < childCount; i38++) {
            View childAt = getChildAt(i38);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                max2 += measureChildCollapseMargins(childAt, i3, max2, i16, 0, iArr);
                i18 = Math.max(i18, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i19 = View.combineMeasuredStates(i19, childAt.getMeasuredState());
            }
        }
        int i39 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i46 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i3, max2 + i46, i16, i39, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i27 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i28 = View.combineMeasuredStates(i19, this.mTitleTextView.getMeasuredState());
            i29 = measuredWidth;
        } else {
            i27 = 0;
            i28 = i19;
            i29 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i29 = Math.max(i29, measureChildCollapseMargins(this.mSubtitleTextView, i3, max2 + i46, i16, i27 + i39, iArr));
            i27 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i28 = View.combineMeasuredStates(i28, this.mSubtitleTextView.getMeasuredState());
        }
        int max3 = Math.max(i18, i27);
        int paddingLeft = max2 + i29 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, (-16777216) & i28);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i16, i28 << 16);
        if (!shouldCollapse()) {
            i36 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i36);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.peekMenu();
        } else {
            menuBuilder = null;
        }
        int i3 = savedState.expandedMenuItemId;
        if (i3 != 0 && this.mExpandedMenuPresenter != null && menuBuilder != null && (findItem = menuBuilder.findItem(i3)) != null) {
            findItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        rtlSpacingHelper.setDirection(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter != null && (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) != null) {
            savedState.expandedMenuItemId = menuItemImpl.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType != 2 && childAt != this.mMenuView) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    public void setCollapseContentDescription(@StringRes int i3) {
        setCollapseContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setCollapseIcon(@DrawableRes int i3) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), i3));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z16) {
        this.mCollapsible = z16;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i3, int i16) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(i3, i16);
    }

    public void setContentInsetsRelative(int i3, int i16) {
        ensureContentInsets();
        this.mContentInsets.setRelative(i3, i16);
    }

    public void setLogo(@DrawableRes int i3) {
        setLogo(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setLogoDescription(@StringRes int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.mMenuView == null) {
            return;
        }
        ensureMenuView();
        MenuBuilder peekMenu = this.mMenuView.peekMenu();
        if (peekMenu == menuBuilder) {
            return;
        }
        if (peekMenu != null) {
            peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
            peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
        }
        actionMenuPresenter.setExpandedActionViewsExclusive(true);
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
            actionMenuPresenter.initForMenu(this.mPopupContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            actionMenuPresenter.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    public void setNavigationContentDescription(@StringRes int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setNavigationIcon(@DrawableRes int i3) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
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

    public void setSubtitle(@StringRes int i3) {
        setSubtitle(getContext().getText(i3));
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i3) {
        this.mSubtitleTextAppearance = i3;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i3) {
        setSubtitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitle(@StringRes int i3) {
        setTitle(getContext().getText(i3));
    }

    public void setTitleMargin(int i3, int i16, int i17, int i18) {
        this.mTitleMarginStart = i3;
        this.mTitleMarginTop = i16;
        this.mTitleMarginEnd = i17;
        this.mTitleMarginBottom = i18;
        requestLayout();
    }

    public void setTitleMarginBottom(int i3) {
        this.mTitleMarginBottom = i3;
        requestLayout();
    }

    public void setTitleMarginEnd(int i3) {
        this.mTitleMarginEnd = i3;
        requestLayout();
    }

    public void setTitleMarginStart(int i3) {
        this.mTitleMarginStart = i3;
        requestLayout();
    }

    public void setTitleMarginTop(int i3) {
        this.mTitleMarginTop = i3;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i3) {
        this.mTitleTextAppearance = i3;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public void setTitleTextColor(@ColorInt int i3) {
        setTitleTextColor(ColorStateList.valueOf(i3));
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && actionMenuView.showOverflowMenu()) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i3, int i16, int i17) {
            super(i3, i16);
            this.mViewType = 0;
            this.gravity = i17;
        }

        public LayoutParams(int i3) {
            this(-2, -1, i3);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bj9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.mCollapseIcon);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.mSubtitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.mSubtitleTextAppearance;
                if (i3 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.mTitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.mTitleTextAppearance;
                if (i3 != 0) {
                    this.mTitleTextView.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.mOnMenuItemClickListener;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        Context context2 = getContext();
        int[] iArr = androidx.appcompat.R.styleable.Toolbar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i3, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i3, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = obtainStyledAttributes.getInteger(androidx.appcompat.R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = obtainStyledAttributes.getInteger(androidx.appcompat.R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMargin, 0);
        int i16 = androidx.appcompat.R.styleable.Toolbar_titleMargins;
        dimensionPixelOffset = obtainStyledAttributes.hasValue(i16) ? obtainStyledAttributes.getDimensionPixelOffset(i16, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            this.mContentInsets.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        int i17 = androidx.appcompat.R.styleable.Toolbar_titleTextColor;
        if (obtainStyledAttributes.hasValue(i17)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(i17));
        }
        int i18 = androidx.appcompat.R.styleable.Toolbar_subtitleTextColor;
        if (obtainStyledAttributes.hasValue(i18)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(i18));
        }
        int i19 = androidx.appcompat.R.styleable.Toolbar_menu;
        if (obtainStyledAttributes.hasValue(i19)) {
            inflateMenu(obtainStyledAttributes.getResourceId(i19, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            KeyEvent.Callback callback = Toolbar.this.mExpandedActionView;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.gravity = (toolbar4.mButtonGravity & 112) | 8388611;
                generateDefaultLayoutParams.mViewType = 2;
                toolbar4.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            KeyEvent.Callback callback = Toolbar.this.mExpandedActionView;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).onActionViewExpanded();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (menuBuilder2 != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean z16) {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                boolean z17 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        if (this.mMenu.getItem(i3) == this.mCurrentExpandedItem) {
                            z17 = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (!z17) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback callback) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z16) {
        }
    }
}
