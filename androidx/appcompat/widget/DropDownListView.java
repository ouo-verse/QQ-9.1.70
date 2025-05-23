package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import com.tencent.mobileqq.R;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private Field mIsChildViewEnabled;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        void setEnabled(boolean z16) {
            this.mEnabled = z16;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float f16, float f17) {
            if (this.mEnabled) {
                super.setHotspot(f16, f17);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i3, int i16, int i17, int i18) {
            if (this.mEnabled) {
                super.setHotspotBounds(i3, i16, i17, i18);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.mEnabled) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z16, boolean z17) {
            if (this.mEnabled) {
                return super.setVisible(z16, z17);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void cancel() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.removeCallbacks(this);
        }

        public void post() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropDownListView(@NonNull Context context, boolean z16) {
        super(context, null, R.attr.f155566ad0);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = z16;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e16) {
            e16.printStackTrace();
        }
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mClickAnimation;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int i3) {
        performItemClick(view, i3, getItemIdAtPosition(i3));
    }

    private void drawSelectorCompat(Canvas canvas) {
        Drawable selector;
        if (!this.mSelectorRect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.mSelectorRect);
            selector.draw(canvas);
        }
    }

    private void positionSelectorCompat(int i3, View view) {
        boolean z16;
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        try {
            boolean z17 = this.mIsChildViewEnabled.getBoolean(this);
            if (view.isEnabled() != z17) {
                Field field = this.mIsChildViewEnabled;
                if (!z17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                field.set(this, Boolean.valueOf(z16));
                if (i3 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        }
    }

    private void positionSelectorLikeFocusCompat(int i3, View view) {
        boolean z16;
        Drawable selector = getSelector();
        boolean z17 = true;
        if (selector != null && i3 != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(i3, view);
        if (z16) {
            Rect rect = this.mSelectorRect;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z17 = false;
            }
            selector.setVisible(z17, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    private void positionSelectorLikeTouchCompat(int i3, View view, float f16, float f17) {
        positionSelectorLikeFocusCompat(i3, view);
        Drawable selector = getSelector();
        if (selector != null && i3 != -1) {
            DrawableCompat.setHotspot(selector, f16, f17);
        }
    }

    private void setPressedItem(View view, int i3, float f16, float f17) {
        View childAt;
        this.mDrawsInPressedState = true;
        drawableHotspotChanged(f16, f17);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i16 = this.mMotionPosition;
        if (i16 != -1 && (childAt = getChildAt(i16 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.mMotionPosition = i3;
        view.drawableHotspotChanged(f16 - view.getLeft(), f17 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i3, view, f16, f17);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean z16) {
        GateKeeperDrawable gateKeeperDrawable = this.mSelector;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.setEnabled(z16);
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && touchModeDrawsInPressedStateCompat() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.mResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (!this.mHijackFocus && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (!this.mHijackFocus && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (!this.mHijackFocus && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if ((this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    public int lookForSelectablePosition(int i3, boolean z16) {
        int min;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z16) {
                    min = Math.max(0, i3);
                    while (min < count && !adapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i3, count - 1);
                    while (min >= 0 && !adapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            }
            if (i3 >= 0 && i3 < count) {
                return i3;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i3, int i16, int i17, int i18, int i19) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i26 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i27 = 0;
        int i28 = 0;
        View view = null;
        for (int i29 = 0; i29 < count; i29++) {
            int itemViewType = adapter.getItemViewType(i29);
            if (itemViewType != i27) {
                view = null;
                i27 = itemViewType;
            }
            view = adapter.getView(i29, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i36 = layoutParams.height;
            if (i36 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i36, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i3, makeMeasureSpec);
            view.forceLayout();
            if (i29 > 0) {
                i26 += dividerHeight;
            }
            i26 += view.getMeasuredHeight();
            if (i26 >= i18) {
                if (i19 >= 0 && i29 > i19 && i28 > 0 && i26 != i18) {
                    return i28;
                }
                return i18;
            }
            if (i19 >= 0 && i29 >= i19) {
                i28 = i26;
            }
        }
        return i26;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i3) {
        boolean z16;
        boolean z17;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                z16 = true;
            }
        } else {
            z16 = false;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        if (findPointerIndex >= 0) {
            int x16 = (int) motionEvent.getX(findPointerIndex);
            int y16 = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x16, y16);
            if (pointToPosition == -1) {
                z17 = true;
                if (z16 || z17) {
                    clearPressedItem();
                }
                if (z16) {
                    if (this.mScrollHelper == null) {
                        this.mScrollHelper = new ListViewAutoScrollHelper(this);
                    }
                    this.mScrollHelper.setEnabled(true);
                    this.mScrollHelper.onTouch(this, motionEvent);
                } else {
                    ListViewAutoScrollHelper listViewAutoScrollHelper = this.mScrollHelper;
                    if (listViewAutoScrollHelper != null) {
                        listViewAutoScrollHelper.setEnabled(false);
                    }
                }
                return z16;
            }
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            setPressedItem(childAt, pointToPosition, x16, y16);
            if (actionMasked == 1) {
                clickPressedItem(childAt, pointToPosition);
            }
            z16 = true;
            z17 = false;
            if (z16) {
            }
            clearPressedItem();
            if (z16) {
            }
            return z16;
        }
        z17 = false;
        z16 = false;
        if (z16) {
        }
        clearPressedItem();
        if (z16) {
        }
        return z16;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.mResolveHoverRunnable = resolveHoverRunnable;
            resolveHoverRunnable.post();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                updateSelectorStateCompat();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z16) {
        this.mListSelectionHidden = z16;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable;
        if (drawable != null) {
            gateKeeperDrawable = new GateKeeperDrawable(drawable);
        } else {
            gateKeeperDrawable = null;
        }
        this.mSelector = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
}
