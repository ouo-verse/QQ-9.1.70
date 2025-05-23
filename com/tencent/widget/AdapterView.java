package com.tencent.widget;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.VersionUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEBUG = false;
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_LAST_POSITION = 2;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    static final int SYNC_SELECTED_POSITION = 0;
    public static final String TAG = "XListView";
    private boolean canGetBooleanFlag;
    boolean mBlockLayoutRequests;
    boolean mDataChanged;
    private boolean mDesiredFocusableInTouchModeState;
    private boolean mDesiredFocusableState;
    private View mEmptyView;

    @ViewDebug.ExportedProperty(category = "scrolling")
    public int mFirstPosition;
    boolean mInLayout;

    @ViewDebug.ExportedProperty(category = "list")
    protected int mItemCount;
    int mLayoutHeight;
    boolean mNeedSync;

    @ViewDebug.ExportedProperty(category = "list")
    int mNextSelectedPosition;
    long mNextSelectedRowId;
    int mOldItemCount;
    protected int mOldSelectedPosition;
    long mOldSelectedRowId;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    OnItemSelectedListener mOnItemSelectedListener;

    @ViewDebug.ExportedProperty(category = "list")
    protected int mSelectedPosition;
    long mSelectedRowId;
    private AdapterView<T>.SelectionNotifier mSelectionNotifier;
    int mSpecificBottom;
    int mSpecificTop;
    long mSyncHeight;
    int mSyncMode;
    int mSyncPosition;
    long mSyncRowId;
    private float mVerticalScrollFactor;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public long f384530id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            this.targetView = view;
            this.position = i3;
            this.f384530id = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class AdapterDataSetObserver extends DataSetObserver {
        static IPatchRedirector $redirector_;
        private Parcelable mInstanceState;

        public AdapterDataSetObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdapterView.this);
            } else {
                this.mInstanceState = null;
            }
        }

        public void clearSavedState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.mInstanceState = null;
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AdapterView adapterView = AdapterView.this;
            adapterView.mDataChanged = true;
            adapterView.mOldItemCount = adapterView.mItemCount;
            adapterView.mItemCount = adapterView.getAdapter().getCount();
            if (AdapterView.this.getAdapter().hasStableIds() && (parcelable = this.mInstanceState) != null) {
                AdapterView adapterView2 = AdapterView.this;
                if (adapterView2.mOldItemCount == 0 && adapterView2.mItemCount > 0) {
                    adapterView2.onRestoreInstanceState(parcelable);
                    this.mInstanceState = null;
                    AdapterView.this.checkFocus();
                    AdapterView.this.requestLayout();
                }
            }
            AdapterView.this.rememberSyncState();
            AdapterView.this.checkFocus();
            AdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AdapterView adapterView = AdapterView.this;
            adapterView.mDataChanged = true;
            if (adapterView.getAdapter().hasStableIds()) {
                this.mInstanceState = AdapterView.this.onSaveInstanceState();
            }
            AdapterView adapterView2 = AdapterView.this;
            adapterView2.mOldItemCount = adapterView2.mItemCount;
            adapterView2.mItemCount = 0;
            adapterView2.mSelectedPosition = -1;
            adapterView2.mSelectedRowId = Long.MIN_VALUE;
            adapterView2.mNextSelectedPosition = -1;
            adapterView2.mNextSelectedRowId = Long.MIN_VALUE;
            adapterView2.mNeedSync = false;
            adapterView2.checkFocus();
            AdapterView.this.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemClickListener {
        void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemSelectedListener {
        void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3);

        void onNothingSelected(AdapterView<?> adapterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SelectionNotifier implements Runnable {
        static IPatchRedirector $redirector_;

        SelectionNotifier() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdapterView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AdapterView adapterView = AdapterView.this;
            if (!adapterView.mDataChanged) {
                adapterView.fireOnSelected();
            } else if (adapterView.getAdapter() != null) {
                AdapterView.this.post(this);
            }
        }
    }

    public AdapterView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        this.canGetBooleanFlag = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
        } else {
            this.mOnItemSelectedListener.onNothingSelected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getStyleableValue(String str) {
        try {
            return Class.forName("com.android.internal.R$styleable").getField(str).getInt(null);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int[] getStyleableValues(String str) {
        try {
            return (int[]) Class.forName("com.android.internal.R$styleable").getField(str).get(null);
        } catch (Exception unused) {
            return new int[0];
        }
    }

    private boolean isScrollableForAccessibility() {
        int count;
        T adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        if (getFirstVisiblePosition() <= 0 && getLastVisiblePosition() >= count - 1) {
            return false;
        }
        return true;
    }

    public static void traceBegin(String str) {
        TraceUtils.traceBegin(str);
    }

    public static void traceEnd() {
        TraceUtils.traceEnd();
    }

    private void updateEmptyStatus(boolean z16) {
        if (isInFilterMode()) {
            z16 = false;
        }
        if (z16) {
            View view = this.mEmptyView;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.mEmptyView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        if (super.canAnimate() && this.mItemCount > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkFocus() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        T adapter = getAdapter();
        boolean z26 = false;
        if (adapter != null && adapter.getCount() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && !isInFilterMode()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17 && this.mDesiredFocusableInTouchModeState) {
            z18 = true;
        } else {
            z18 = false;
        }
        super.setFocusableInTouchMode(z18);
        if (z17 && this.mDesiredFocusableState) {
            z19 = true;
        } else {
            z19 = false;
        }
        super.setFocusable(z19);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z26 = true;
            }
            updateEmptyStatus(z26);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkSelectionChanged() {
        if (this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedRowId != this.mOldSelectedRowId) {
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.mOldSelectedRowId = this.mSelectedRowId;
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) sparseArray);
        } else {
            dispatchThawSelfOnly(sparseArray);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) sparseArray);
        } else {
            dispatchFreezeSelfOnly(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findSyncPosition() {
        boolean z16;
        boolean z17;
        int i3 = this.mItemCount;
        if (i3 == 0) {
            return -1;
        }
        long j3 = this.mSyncRowId;
        int i16 = this.mSyncPosition;
        if (j3 == Long.MIN_VALUE) {
            return -1;
        }
        int i17 = i3 - 1;
        int min = Math.min(i17, Math.max(0, i16));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i18 = min;
        int i19 = i18;
        boolean z18 = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(min) == j3) {
                return min;
            }
            if (i18 == i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i19 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 && z17) {
                break;
            }
            if (!z17 && (!z18 || z16)) {
                if (z16 || (!z18 && !z17)) {
                    i19--;
                    z18 = true;
                    min = i19;
                }
            } else {
                i18++;
                z18 = false;
                min = i18;
            }
        }
        return -1;
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mItemCount;
    }

    public View getEmptyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (View) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mFirstPosition;
    }

    public Object getItemAtPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return iPatchRedirector.redirect((short) 30, (Object) this, i3);
        }
        T adapter = getAdapter();
        if (adapter != null && i3 >= 0) {
            return adapter.getItem(i3);
        }
        return null;
    }

    public long getItemIdAtPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Long) iPatchRedirector.redirect((short) 31, (Object) this, i3)).longValue();
        }
        T adapter = getAdapter();
        if (adapter != null && i3 >= 0) {
            return adapter.getItemId(i3);
        }
        return Long.MIN_VALUE;
    }

    public int getLastVisiblePosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public final OnItemClickListener getOnItemClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OnItemClickListener) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (OnItemLongClickListener) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mOnItemLongClickListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (OnItemSelectedListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mOnItemSelectedListener;
    }

    public int getPositionForView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) view)).intValue();
        }
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3).equals(view)) {
                return this.mFirstPosition + i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getQQPersistentDrawingCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        return ((Integer) ReflectionUtil.getField(this, "android.view.ViewGroup", "mPersistentDrawingCache", 0)).intValue();
    }

    public Object getSelectedItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return iPatchRedirector.redirect((short) 21, (Object) this);
        }
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter != null && adapter.getCount() > 0 && selectedItemPosition >= 0) {
            return adapter.getItem(selectedItemPosition);
        }
        return null;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        return this.mNextSelectedRowId;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mNextSelectedPosition;
    }

    public abstract View getSelectedView();

    /* JADX INFO: Access modifiers changed from: protected */
    public float getVerticalScrollFactor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Float) iPatchRedirector.redirect((short) 43, (Object) this)).floatValue();
        }
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDataChanged() {
        boolean z16;
        boolean z17;
        int i3 = this.mItemCount;
        if (i3 > 0) {
            z16 = true;
            if (this.mNeedSync) {
                this.mNeedSync = false;
                int findSyncPosition = findSyncPosition();
                if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                    setNextSelectedPositionInt(findSyncPosition);
                    z17 = true;
                    if (!z17) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i3) {
                            selectedItemPosition = i3 - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                        if (lookForSelectablePosition < 0) {
                            lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, false);
                        }
                        if (lookForSelectablePosition >= 0) {
                            setNextSelectedPositionInt(lookForSelectablePosition);
                            checkSelectionChanged();
                        }
                    }
                    z16 = z17;
                }
            }
            z17 = false;
            if (!z17) {
            }
            z16 = z17;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.mSelectedPosition = -1;
            this.mSelectedRowId = Long.MIN_VALUE;
            this.mNextSelectedPosition = -1;
            this.mNextSelectedRowId = Long.MIN_VALUE;
            this.mNeedSync = false;
            checkSelectionChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasBooleanFlag(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, i3)).booleanValue();
        }
        if (this.canGetBooleanFlag) {
            Object invokeMethodWithArgs = ReflectionUtil.invokeMethodWithArgs(this, "android.view.ViewGroup", "hasBooleanFlag", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
            if (invokeMethodWithArgs != null && (invokeMethodWithArgs instanceof Boolean)) {
                return ((Boolean) invokeMethodWithArgs).booleanValue();
            }
            this.canGetBooleanFlag = false;
        }
        if (i3 != 34) {
            return false;
        }
        boolean clipToPadding = getClipToPadding();
        if (getPaddingLeft() == 0 && getPaddingLeft() == 0 && getPaddingLeft() == 0 && getPaddingLeft() == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (clipToPadding && z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(11)
    public void invalidateParentIfNeeded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else if (VersionUtils.isHoneycomb() && isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    boolean isInFilterMode() {
        return false;
    }

    @TargetApi(14)
    public boolean isInScrollingContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        if (VersionUtils.isIceScreamSandwich()) {
            for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
                if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void offsetChildrenTopAndBottomWrap(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            ReflectionUtil.invokeMethodWithArgs(this, "android.view.ViewGroup", "offsetChildrenTopAndBottom", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            super.onDetachedFromWindow();
            removeCallbacks(this.mSelectionNotifier);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) accessibilityEvent);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        try {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        accessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mLayoutHeight = getHeight();
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"NewApi"})
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) view, (Object) accessibilityEvent)).booleanValue();
        }
        try {
            if (super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(obtain);
                view.dispatchPopulateAccessibilityEvent(obtain);
                accessibilityEvent.appendRecord(obtain);
                return true;
            }
        } catch (Exception e16) {
            QLog.e("AdapterView", 1, e16, new Object[0]);
        }
        return false;
    }

    public boolean performItemClick(View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        if (this.mOnItemClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnItemClickListener.onItemClick(this, view, i3, j3);
        return true;
    }

    void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = this.mLayoutHeight;
            int i3 = this.mSelectedPosition;
            if (i3 >= 0) {
                View childAt = getChildAt(i3 - this.mFirstPosition);
                this.mSyncRowId = this.mNextSelectedRowId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (childAt != null) {
                    this.mSpecificTop = childAt.getTop();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            int i16 = this.mFirstPosition;
            if (i16 >= 0 && i16 < adapter.getCount()) {
                this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
            } else {
                this.mSyncRowId = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.mSpecificTop = childAt2.getTop();
            }
            this.mSyncMode = 1;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
            return;
        }
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void selectionChanged() {
        if (this.mOnItemSelectedListener != null) {
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                fireOnSelected();
            } else {
                if (this.mSelectionNotifier == null) {
                    this.mSelectionNotifier = new SelectionNotifier();
                }
                post(this.mSelectionNotifier);
            }
        }
        if (this.mSelectedPosition != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    public abstract void setAdapter(T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBooleanFlag(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            ReflectionUtil.invokeMethodWithArgs(this, "android.view.ViewGroup", "setBooleanFlag", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    public void setEmptyView(View view) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
            return;
        }
        this.mEmptyView = view;
        T adapter = getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        updateEmptyStatus(z16);
    }

    @Override // android.view.View
    public void setFocusable(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        T adapter = getAdapter();
        boolean z18 = true;
        if (adapter != null && adapter.getCount() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.mDesiredFocusableState = z16;
        if (!z16) {
            this.mDesiredFocusableInTouchModeState = false;
        }
        if (!z16 || (z17 && !isInFilterMode())) {
            z18 = false;
        }
        super.setFocusable(z18);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        T adapter = getAdapter();
        boolean z18 = false;
        if (adapter != null && adapter.getCount() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.mDesiredFocusableInTouchModeState = z16;
        if (z16) {
            this.mDesiredFocusableState = true;
        }
        if (z16 && (!z17 || isInFilterMode())) {
            z18 = true;
        }
        super.setFocusableInTouchMode(z18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int i3) {
        this.mNextSelectedPosition = i3;
        long itemIdAtPosition = getItemIdAtPosition(i3);
        this.mNextSelectedRowId = itemIdAtPosition;
        if (this.mNeedSync && this.mSyncMode == 0 && i3 >= 0) {
            this.mSyncPosition = i3;
            this.mSyncRowId = itemIdAtPosition;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) onClickListener);
            return;
        }
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onItemClickListener);
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onItemLongClickListener);
            return;
        }
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onItemSelectedListener);
        } else {
            this.mOnItemSelectedListener = onItemSelectedListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i3) {
        this.mSelectedPosition = i3;
        this.mSelectedRowId = getItemIdAtPosition(i3);
    }

    public abstract void setSelection(int i3);

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
        }
        iPatchRedirector.redirect((short) 14, this, view, Integer.valueOf(i3), layoutParams);
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        this.canGetBooleanFlag = true;
    }

    public AdapterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        this.canGetBooleanFlag = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int lookForSelectablePosition(int i3, boolean z16) {
        return i3;
    }
}
