package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.widget.AdapterView;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {
    static IPatchRedirector $redirector_;
    private static int ABSSPINNER_ENTRIES;
    SpinnerAdapter mAdapter;
    boolean mBlockLayoutRequests;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class RecycleBin {
        static IPatchRedirector $redirector_;
        private final SparseArray<View> mScrapHeap;

        RecycleBin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsSpinner.this);
            } else {
                this.mScrapHeap = new SparseArray<>();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            SparseArray<View> sparseArray = this.mScrapHeap;
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                View valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    AbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clearByTag() {
            boolean z16;
            SparseArray<View> sparseArray = this.mScrapHeap;
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                View valueAt = sparseArray.valueAt(i3);
                if (valueAt != null && (valueAt.getTag(R.id.cql) instanceof Boolean)) {
                    z16 = ((Boolean) valueAt.getTag(R.id.cql)).booleanValue();
                } else {
                    z16 = true;
                }
                if (valueAt != null && z16) {
                    AbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View get(int i3) {
            View view = this.mScrapHeap.get(i3);
            if (view != null) {
                this.mScrapHeap.delete(i3);
            }
            return view;
        }

        public void put(int i3, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
            } else {
                this.mScrapHeap.put(i3, view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;
        int position;
        long selectedId;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements Parcelable.Creator<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53828);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcelable);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            } else {
                this.selectedId = parcel.readLong();
                this.position = parcel.readInt();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53831);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            ABSSPINNER_ENTRIES = -2;
        }
    }

    public AbsSpinner(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    public static int doResolveSizeAndState(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i3 = size;
            }
        } else if (size < i3) {
            i3 = 16777216 | size;
        }
        return i3 | ((-16777216) & i17);
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    protected AdapterView.AdapterDataSetObserver createObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AdapterView.AdapterDataSetObserver) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AdapterView.AdapterDataSetObserver();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    int getChildWidth(View view) {
        return view.getMeasuredWidth();
    }

    @Override // com.tencent.widget.AdapterView
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mItemCount;
    }

    @Override // com.tencent.widget.AdapterView
    public View getSelectedView() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.mItemCount > 0 && (i3 = this.mSelectedPosition) >= 0) {
            return getChildAt(i3 - this.mFirstPosition);
        }
        return null;
    }

    abstract void layout(int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        SpinnerAdapter spinnerAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        Rect rect = this.mSpinnerPadding;
        int paddingLeft = getPaddingLeft();
        int i19 = this.mSelectionLeftPadding;
        if (paddingLeft > i19) {
            i19 = getPaddingLeft();
        }
        rect.left = i19;
        Rect rect2 = this.mSpinnerPadding;
        int paddingTop = getPaddingTop();
        int i26 = this.mSelectionTopPadding;
        if (paddingTop > i26) {
            i26 = getPaddingTop();
        }
        rect2.top = i26;
        Rect rect3 = this.mSpinnerPadding;
        int paddingRight = getPaddingRight();
        int i27 = this.mSelectionRightPadding;
        if (paddingRight > i27) {
            i27 = getPaddingRight();
        }
        rect3.right = i27;
        Rect rect4 = this.mSpinnerPadding;
        int paddingBottom = getPaddingBottom();
        int i28 = this.mSelectionBottomPadding;
        if (paddingBottom > i28) {
            i28 = getPaddingBottom();
        }
        rect4.bottom = i28;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0 && (spinnerAdapter = this.mAdapter) != null && selectedItemPosition < spinnerAdapter.getCount()) {
            View view = this.mRecycler.get(selectedItemPosition);
            if (view == null) {
                view = this.mAdapter.getView(selectedItemPosition, null, this);
            }
            if (view != null) {
                this.mRecycler.put(selectedItemPosition, view);
            }
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    this.mBlockLayoutRequests = true;
                    view.setLayoutParams(generateDefaultLayoutParams());
                    this.mBlockLayoutRequests = false;
                }
                measureChild(view, i3, i16);
                int childHeight = getChildHeight(view);
                Rect rect5 = this.mSpinnerPadding;
                int i29 = childHeight + rect5.top + rect5.bottom;
                int childWidth = getChildWidth(view);
                Rect rect6 = this.mSpinnerPadding;
                i18 = childWidth + rect6.left + rect6.right;
                i17 = i29;
                z16 = false;
                if (z16) {
                    Rect rect7 = this.mSpinnerPadding;
                    i17 = rect7.top + rect7.bottom;
                    if (mode == 0) {
                        i18 = rect7.left + rect7.right;
                    }
                }
                setMeasuredDimension(doResolveSizeAndState(Math.max(i18, getSuggestedMinimumWidth()), i3, 0), doResolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), i16, 0));
                this.mHeightMeasureSpec = i16;
                this.mWidthMeasureSpec = i3;
            }
        }
        i17 = 0;
        i18 = 0;
        if (z16) {
        }
        setMeasuredDimension(doResolveSizeAndState(Math.max(i18, getSuggestedMinimumWidth()), i3, 0), doResolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), i16, 0));
        this.mHeightMeasureSpec = i16;
        this.mWidthMeasureSpec = i3;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        long j3 = savedState.selectedId;
        if (j3 >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = j3;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Parcelable) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        if (selectedItemId >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    public int pointToPosition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i3, i16)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycleAllViews() {
        int childCount = getChildCount();
        RecycleBin recycleBin = this.mRecycler;
        int i3 = this.mFirstPosition;
        for (int i16 = 0; i16 < childCount; i16++) {
            recycleBin.put(i3 + i16, getChildAt(i16));
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    public void setSelection(int i3, boolean z16) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (z16 && (i16 = this.mFirstPosition) <= i3 && i3 <= (i16 + getChildCount()) - 1) {
            z17 = true;
        }
        setSelectionInt(i3, z17);
    }

    void setSelectionInt(int i3, boolean z16) {
        if (i3 != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            int i16 = i3 - this.mSelectedPosition;
            setNextSelectedPositionInt(i3);
            layout(i16, z16);
            this.mBlockLayoutRequests = false;
        }
    }

    @Override // com.tencent.widget.AdapterView
    public SpinnerAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.mAdapter : (SpinnerAdapter) iPatchRedirector.redirect((short) 13, (Object) this);
    }

    @Override // com.tencent.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) spinnerAdapter);
            return;
        }
        SpinnerAdapter spinnerAdapter2 = this.mAdapter;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (spinnerAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = spinnerAdapter.getCount();
            checkFocus();
            AdapterView.AdapterDataSetObserver createObserver = createObserver();
            this.mDataSetObserver = createObserver;
            this.mAdapter.registerDataSetObserver(createObserver);
            int i3 = this.mItemCount > 0 ? 0 : -1;
            setSelectedPositionInt(i3);
            setNextSelectedPositionInt(i3);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    @Override // com.tencent.widget.AdapterView
    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        setNextSelectedPositionInt(i3);
        requestLayout();
        invalidate();
    }

    public AbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AbsSpinner(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public AbsSpinner(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
        if (z16) {
            if (ABSSPINNER_ENTRIES == -2) {
                ABSSPINNER_ENTRIES = AdapterView.getStyleableValue("AbsSpinner_entries");
            }
            TypedArrayWarpper typedArrayWarpper = new TypedArrayWarpper(context.obtainStyledAttributes(attributeSet, AdapterView.getStyleableValues("AbsSpinner"), i3, 0));
            CharSequence[] textArray = typedArrayWarpper.getTextArray(ABSSPINNER_ENTRIES);
            if (textArray != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, textArray);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                setAdapter((SpinnerAdapter) arrayAdapter);
            }
            typedArrayWarpper.recycle();
        }
    }
}
