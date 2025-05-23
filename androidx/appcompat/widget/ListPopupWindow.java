package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* loaded from: classes.dex */
    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.mPopup) != null && popupWindow.isShowing() && x16 >= 0 && x16 < ListPopupWindow.this.mPopup.getWidth() && y16 >= 0 && y16 < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
                return false;
            }
            if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
            if (dropDownListView != null && ViewCompat.isAttachedToWindow(dropDownListView) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) {
                int childCount = ListPopupWindow.this.mDropDownList.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.mListItemExpandMaximum) {
                    listPopupWindow.mPopup.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R.attr.arl);
    }

    private int buildDropDown() {
        int i3;
        int i16;
        int makeMeasureSpec;
        int i17;
        boolean z16 = true;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView != null && anchorView.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            DropDownListView createDropDownListView = createDropDownListView(context, !this.mModal);
            this.mDropDownList = createDropDownListView;
            Drawable drawable = this.mDropDownListHighlight;
            if (drawable != null) {
                createDropDownListView.setSelector(drawable);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i18, long j3) {
                    DropDownListView dropDownListView;
                    if (i18 != -1 && (dropDownListView = ListPopupWindow.this.mDropDownList) != null) {
                        dropDownListView.setListSelectionHidden(false);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mItemSelectedListener;
            if (onItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.mDropDownList;
            View view2 = this.mPromptView;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i18 = this.mPromptPosition;
                if (i18 != 0) {
                    if (i18 != 1) {
                        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
                    } else {
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                    }
                } else {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                }
                int i19 = this.mDropDownWidth;
                if (i19 >= 0) {
                    i17 = Integer.MIN_VALUE;
                } else {
                    i19 = 0;
                    i17 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i19, i17), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i3 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i3 = 0;
            }
            this.mPopup.setContentView(view);
        } else {
            View view3 = this.mPromptView;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i3 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            int i26 = rect.top;
            i16 = rect.bottom + i26;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -i26;
            }
        } else {
            this.mTempRect.setEmpty();
            i16 = 0;
        }
        if (this.mPopup.getInputMethodMode() != 2) {
            z16 = false;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, z16);
        if (!this.mDropDownAlwaysVisible && this.mDropDownHeight != -1) {
            int i27 = this.mDropDownWidth;
            if (i27 != -2) {
                if (i27 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i27, 1073741824);
                } else {
                    int i28 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.mTempRect;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i28 - (rect2.left + rect2.right), 1073741824);
                }
            } else {
                int i29 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.mTempRect;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i29 - (rect3.left + rect3.right), Integer.MIN_VALUE);
            }
            int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i3, -1);
            if (measureHeightOfChildrenCompat > 0) {
                i3 += i16 + this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom();
            }
            return measureHeightOfChildrenCompat + i3;
        }
        return maxAvailableHeight + i16;
    }

    private int getMaxAvailableHeight(View view, int i3, boolean z16) {
        int maxAvailableHeight;
        if (Build.VERSION.SDK_INT > 23) {
            maxAvailableHeight = this.mPopup.getMaxAvailableHeight(view, i3, z16);
            return maxAvailableHeight;
        }
        Method method = sGetMaxAvailableHeightMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.mPopup, view, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
            } catch (Exception unused) {
                Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.mPopup.getMaxAvailableHeight(view, i3);
    }

    private static boolean isConfirmKey(int i3) {
        if (i3 != 66 && i3 != 23) {
            return false;
        }
        return true;
    }

    private void removePromptView() {
        View view = this.mPromptView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    private void setPopupClipToScreenEnabled(boolean z16) {
        if (Build.VERSION.SDK_INT > 28) {
            this.mPopup.setIsClippedToScreen(z16);
            return;
        }
        Method method = sSetClipToWindowEnabledMethod;
        if (method != null) {
            try {
                method.invoke(this.mPopup, Boolean.valueOf(z16));
            } catch (Exception unused) {
                Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) { // from class: androidx.appcompat.widget.ListPopupWindow.1
            @Override // androidx.appcompat.widget.ForwardingListener
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    @NonNull
    DropDownListView createDropDownListView(Context context, boolean z16) {
        return new DropDownListView(context, z16);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    @Nullable
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) {
            return new Rect(this.mEpicenterBounds);
        }
        return null;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    @Nullable
    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.mPopup.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean isModal() {
        return this.mModal;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int i3, @NonNull KeyEvent keyEvent) {
        int i16;
        int i17;
        if (isShowing() && i3 != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i3))) {
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            boolean z16 = !this.mPopup.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i16 = 0;
                } else {
                    i16 = this.mDropDownList.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    i17 = listAdapter.getCount() - 1;
                } else {
                    i17 = this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
            } else {
                i16 = Integer.MAX_VALUE;
                i17 = Integer.MIN_VALUE;
            }
            if ((z16 && i3 == 19 && selectedItemPosition <= i16) || (!z16 && i3 == 20 && selectedItemPosition >= i17)) {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
            this.mDropDownList.setListSelectionHidden(false);
            if (this.mDropDownList.onKeyDown(i3, keyEvent)) {
                this.mPopup.setInputMethodMode(2);
                this.mDropDownList.requestFocusFromTouch();
                show();
                if (i3 == 19 || i3 == 20 || i3 == 23 || i3 == 66) {
                    return true;
                }
            } else if (z16 && i3 == 20) {
                if (selectedItemPosition == i17) {
                    return true;
                }
            } else if (!z16 && i3 == 19 && selectedItemPosition == i16) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i3, @NonNull KeyEvent keyEvent) {
        if (i3 == 4 && isShowing()) {
            View view = this.mDropDownAnchorView;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean onKeyUp(int i3, @NonNull KeyEvent keyEvent) {
        if (isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
            boolean onKeyUp = this.mDropDownList.onKeyUp(i3, keyEvent);
            if (onKeyUp && isConfirmKey(i3)) {
                dismiss();
            }
            return onKeyUp;
        }
        return false;
    }

    public boolean performItemClick(int i3) {
        if (isShowing()) {
            if (this.mItemClickListener != null) {
                DropDownListView dropDownListView = this.mDropDownList;
                this.mItemClickListener.onItemClick(dropDownListView, dropDownListView.getChildAt(i3 - dropDownListView.getFirstVisiblePosition()), i3, dropDownListView.getAdapter().getItemId(i3));
                return true;
            }
            return true;
        }
        return false;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(@StyleRes int i3) {
        this.mPopup.setAnimationStyle(i3);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i3) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            this.mDropDownWidth = rect.left + rect.right + i3;
            return;
        }
        setWidth(i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z16) {
        this.mDropDownAlwaysVisible = z16;
    }

    public void setDropDownGravity(int i3) {
        this.mDropDownGravity = i3;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.mEpicenterBounds = rect2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z16) {
        this.mForceIgnoreOutsideTouch = z16;
    }

    public void setHeight(int i3) {
        if (i3 < 0 && -2 != i3 && -1 != i3) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.mDropDownHeight = i3;
    }

    public void setHorizontalOffset(int i3) {
        this.mDropDownHorizontalOffset = i3;
    }

    public void setInputMethodMode(int i3) {
        this.mPopup.setInputMethodMode(i3);
    }

    void setListItemExpandMax(int i3) {
        this.mListItemExpandMaximum = i3;
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean z16) {
        this.mModal = z16;
        this.mPopup.setFocusable(z16);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z16) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z16;
    }

    public void setPromptPosition(int i3) {
        this.mPromptPosition = i3;
    }

    public void setPromptView(@Nullable View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i3) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i3);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i3, true);
            }
        }
    }

    public void setSoftInputMode(int i3) {
        this.mPopup.setSoftInputMode(i3);
    }

    public void setVerticalOffset(int i3) {
        this.mDropDownVerticalOffset = i3;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i3) {
        this.mDropDownWidth = i3;
    }

    public void setWindowLayoutType(int i3) {
        this.mDropDownWindowLayoutType = i3;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean z17 = true;
        if (this.mPopup.isShowing()) {
            if (!ViewCompat.isAttachedToWindow(getAnchorView())) {
                return;
            }
            int i19 = this.mDropDownWidth;
            if (i19 == -1) {
                i19 = -1;
            } else if (i19 == -2) {
                i19 = getAnchorView().getWidth();
            }
            int i26 = this.mDropDownHeight;
            if (i26 == -1) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i18 = -1;
                    } else {
                        i18 = 0;
                    }
                    popupWindow.setWidth(i18);
                    this.mPopup.setHeight(0);
                } else {
                    PopupWindow popupWindow2 = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i17 = -1;
                    } else {
                        i17 = 0;
                    }
                    popupWindow2.setWidth(i17);
                    this.mPopup.setHeight(-1);
                }
            } else if (i26 != -2) {
                buildDropDown = i26;
            }
            PopupWindow popupWindow3 = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z17 = false;
            }
            popupWindow3.setOutsideTouchable(z17);
            PopupWindow popupWindow4 = this.mPopup;
            View anchorView = getAnchorView();
            int i27 = this.mDropDownHorizontalOffset;
            int i28 = this.mDropDownVerticalOffset;
            if (i19 < 0) {
                i3 = -1;
            } else {
                i3 = i19;
            }
            if (buildDropDown < 0) {
                i16 = -1;
            } else {
                i16 = buildDropDown;
            }
            popupWindow4.update(anchorView, i27, i28, i3, i16);
            return;
        }
        int i29 = this.mDropDownWidth;
        if (i29 == -1) {
            i29 = -1;
        } else if (i29 == -2) {
            i29 = getAnchorView().getWidth();
        }
        int i36 = this.mDropDownHeight;
        if (i36 == -1) {
            buildDropDown = -1;
        } else if (i36 != -2) {
            buildDropDown = i36;
        }
        this.mPopup.setWidth(i29);
        this.mPopup.setHeight(buildDropDown);
        setPopupClipToScreenEnabled(true);
        PopupWindow popupWindow5 = this.mPopup;
        if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
            z16 = true;
        } else {
            z16 = false;
        }
        popupWindow5.setOutsideTouchable(z16);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet) {
            PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
        }
        if (Build.VERSION.SDK_INT > 28) {
            this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
        } else {
            Method method = sSetEpicenterBoundsMethod;
            if (method != null) {
                try {
                    method.invoke(this.mPopup, this.mEpicenterBounds);
                } catch (Exception e16) {
                    Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e16);
                }
            }
        }
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.arl);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ListPopupWindow, i3, i16);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i3, i16);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
            if (i3 == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
