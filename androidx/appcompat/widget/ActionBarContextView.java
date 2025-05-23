package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    private void initTitle() {
        int i3;
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.f167508dp1, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleLayout = linearLayout;
            this.mTitleView = (TextView) linearLayout.findViewById(R.id.s97);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.s96);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean z16 = !TextUtils.isEmpty(this.mTitle);
        boolean z17 = !TextUtils.isEmpty(this.mSubtitle);
        TextView textView = this.mSubtitleView;
        int i16 = 0;
        if (z17) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        LinearLayout linearLayout2 = this.mTitleLayout;
        if (!z16 && !z17) {
            i16 = 8;
        }
        linearLayout2.setVisibility(i16);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int i3) {
        super.animateToVisibility(i3);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose == null) {
            killMode();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public void initForMode(final ActionMode actionMode) {
        View view = this.mClose;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, (ViewGroup) this, false);
            this.mClose = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.mClose);
        }
        this.mClose.findViewById(R.id.s9k).setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                actionMode.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = actionMenuPresenter2;
        actionMenuPresenter2.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = actionMenuView;
        ViewCompat.setBackground(actionMenuView, null);
        addView(this.mMenuView, layoutParams);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int paddingLeft;
        int paddingRight;
        int i19;
        int i26;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            paddingLeft = (i17 - i3) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i18 - i16) - getPaddingTop()) - getPaddingBottom();
        View view = this.mClose;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            if (isLayoutRtl) {
                i19 = marginLayoutParams.rightMargin;
            } else {
                i19 = marginLayoutParams.leftMargin;
            }
            if (isLayoutRtl) {
                i26 = marginLayoutParams.leftMargin;
            } else {
                i26 = marginLayoutParams.rightMargin;
            }
            int next = AbsActionBarView.next(paddingLeft, i19, isLayoutRtl);
            paddingLeft = AbsActionBarView.next(next + positionChild(this.mClose, next, paddingTop, paddingTop2, isLayoutRtl), i26, isLayoutRtl);
        }
        int i27 = paddingLeft;
        LinearLayout linearLayout = this.mTitleLayout;
        if (linearLayout != null && this.mCustomView == null && linearLayout.getVisibility() != 8) {
            i27 += positionChild(this.mTitleLayout, i27, paddingTop, paddingTop2, isLayoutRtl);
        }
        int i28 = i27;
        View view2 = this.mCustomView;
        if (view2 != null) {
            positionChild(view2, i28, paddingTop, paddingTop2, isLayoutRtl);
        }
        if (isLayoutRtl) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i17 - i3) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            positionChild(actionMenuView, paddingRight, paddingTop, paddingTop2, !isLayoutRtl);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        boolean z16;
        int i18;
        int i19 = 1073741824;
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            if (View.MeasureSpec.getMode(i16) != 0) {
                int size = View.MeasureSpec.getSize(i3);
                int i26 = this.mContentHeight;
                if (i26 <= 0) {
                    i26 = View.MeasureSpec.getSize(i16);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i27 = i26 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i27, Integer.MIN_VALUE);
                View view = this.mClose;
                if (view != null) {
                    int measureChildView = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                    paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.mMenuView;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.mTitleLayout;
                if (linearLayout != null && this.mCustomView == null) {
                    if (this.mTitleOptional) {
                        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.mTitleLayout;
                        if (z16) {
                            i18 = 0;
                        } else {
                            i18 = 8;
                        }
                        linearLayout2.setVisibility(i18);
                    } else {
                        paddingLeft = measureChildView(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.mCustomView;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i28 = layoutParams.width;
                    if (i28 != -2) {
                        i17 = 1073741824;
                    } else {
                        i17 = Integer.MIN_VALUE;
                    }
                    if (i28 >= 0) {
                        paddingLeft = Math.min(i28, paddingLeft);
                    }
                    int i29 = layoutParams.height;
                    if (i29 == -2) {
                        i19 = Integer.MIN_VALUE;
                    }
                    if (i29 >= 0) {
                        i27 = Math.min(i29, i27);
                    }
                    this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i17), View.MeasureSpec.makeMeasureSpec(i27, i19));
                }
                if (this.mContentHeight <= 0) {
                    int childCount = getChildCount();
                    int i36 = 0;
                    for (int i37 = 0; i37 < childCount; i37++) {
                        int measuredHeight = getChildAt(i37).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i36) {
                            i36 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i36);
                    return;
                }
                setMeasuredDimension(size, i26);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i3) {
        this.mContentHeight = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.mCustomView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (linearLayout = this.mTitleLayout) != null) {
            removeView(linearLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
    }

    public void setTitleOptional(boolean z16) {
        if (z16 != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = z16;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i3, long j3) {
        return super.setupAnimatorToVisibility(i3, j3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f4416f);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.ActionMode, i3, 0);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionMode_background));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(androidx.appcompat.R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionMode_closeItemLayout, R.layout.dp6);
        obtainStyledAttributes.recycle();
    }
}
