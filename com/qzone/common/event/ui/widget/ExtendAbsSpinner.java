package com.qzone.common.event.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import com.qzone.common.event.ui.widget.ExtendAdapterView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class ExtendAbsSpinner extends ExtendAdapterView<SpinnerAdapter> {
    SpinnerAdapter T;
    int U;
    int V;
    boolean W;

    /* renamed from: a0, reason: collision with root package name */
    int f45888a0;

    /* renamed from: b0, reason: collision with root package name */
    int f45889b0;

    /* renamed from: c0, reason: collision with root package name */
    int f45890c0;

    /* renamed from: d0, reason: collision with root package name */
    int f45891d0;

    /* renamed from: e0, reason: collision with root package name */
    final Rect f45892e0;

    /* renamed from: f0, reason: collision with root package name */
    final a f45893f0;

    /* renamed from: g0, reason: collision with root package name */
    private DataSetObserver f45894g0;

    /* renamed from: h0, reason: collision with root package name */
    private Rect f45895h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        long f45896d;

        /* renamed from: e, reason: collision with root package name */
        int f45897e;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f45896d + " position=" + this.f45897e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeLong(this.f45896d);
            parcel.writeInt(this.f45897e);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f45896d = parcel.readLong();
            this.f45897e = parcel.readInt();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<View> f45898a = new SparseArray<>();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            SparseArray<View> sparseArray = this.f45898a;
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                View valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    ExtendAbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View b(int i3) {
            View view = this.f45898a.get(i3);
            if (view != null) {
                this.f45898a.delete(i3);
            }
            return view;
        }

        public void c(int i3, View view) {
            this.f45898a.put(i3, view);
        }
    }

    public ExtendAbsSpinner(Context context) {
        super(context);
        this.f45888a0 = 0;
        this.f45889b0 = 0;
        this.f45890c0 = 0;
        this.f45891d0 = 0;
        this.f45892e0 = new Rect();
        this.f45893f0 = new a();
        A();
    }

    abstract void B(int i3, boolean z16);

    public int C(int i3, int i16) {
        Rect rect = this.f45895h0;
        if (rect == null) {
            rect = new Rect();
            this.f45895h0 = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i3, i16)) {
                    return this.f45900d + childCount;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        int childCount = getChildCount();
        a aVar = this.f45893f0;
        int i3 = this.f45900d;
        for (int i16 = 0; i16 < childCount; i16++) {
            aVar.c(i3 + i16, getChildAt(i16));
        }
    }

    void F(int i3, boolean z16) {
        if (i3 != this.P) {
            this.W = true;
            int i16 = i3 - this.J;
            t(i3);
            B(i16, z16);
            this.W = false;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView
    public View l() {
        int i3;
        if (this.M <= 0 || (i3 = this.J) < 0) {
            return null;
        }
        return getChildAt(i3 - this.f45900d);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        SpinnerAdapter spinnerAdapter;
        int mode = View.MeasureSpec.getMode(i3);
        Rect rect = this.f45892e0;
        int paddingLeft = getPaddingLeft();
        int i19 = this.f45888a0;
        if (paddingLeft > i19) {
            i19 = getPaddingLeft();
        }
        rect.left = i19;
        Rect rect2 = this.f45892e0;
        int paddingTop = getPaddingTop();
        int i26 = this.f45889b0;
        if (paddingTop > i26) {
            i26 = getPaddingTop();
        }
        rect2.top = i26;
        Rect rect3 = this.f45892e0;
        int paddingRight = getPaddingRight();
        int i27 = this.f45890c0;
        if (paddingRight > i27) {
            i27 = getPaddingRight();
        }
        rect3.right = i27;
        Rect rect4 = this.f45892e0;
        int paddingBottom = getPaddingBottom();
        int i28 = this.f45891d0;
        if (paddingBottom > i28) {
            i28 = getPaddingBottom();
        }
        rect4.bottom = i28;
        if (this.G) {
            m();
        }
        int k3 = k();
        boolean z16 = true;
        if (k3 >= 0 && (spinnerAdapter = this.T) != null && k3 < spinnerAdapter.getCount()) {
            View b16 = this.f45893f0.b(k3);
            if (b16 == null) {
                b16 = this.T.getView(k3, null, this);
            }
            if (b16 != null) {
                this.f45893f0.c(k3, b16);
            }
            if (b16 != null) {
                if (b16.getLayoutParams() == null) {
                    this.W = true;
                    b16.setLayoutParams(generateDefaultLayoutParams());
                    this.W = false;
                }
                measureChild(b16, i3, i16);
                int y16 = y(b16);
                Rect rect5 = this.f45892e0;
                i17 = y16 + rect5.top + rect5.bottom;
                int z17 = z(b16);
                Rect rect6 = this.f45892e0;
                i18 = z17 + rect6.left + rect6.right;
                z16 = false;
                if (z16) {
                    Rect rect7 = this.f45892e0;
                    int i29 = rect7.top + rect7.bottom;
                    if (mode == 0) {
                        i18 = rect7.left + rect7.right;
                    }
                    i17 = i29;
                }
                setMeasuredDimension(ExtendAdapterView.resolveSizeAndState(Math.max(i18, getSuggestedMinimumWidth()), i3, 0), ExtendAdapterView.resolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), i16, 0));
                this.U = i16;
                this.V = i3;
            }
        }
        i17 = 0;
        i18 = 0;
        if (z16) {
        }
        setMeasuredDimension(ExtendAdapterView.resolveSizeAndState(Math.max(i18, getSuggestedMinimumWidth()), i3, 0), ExtendAdapterView.resolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), i16, 0));
        this.U = i16;
        this.V = i3;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        long j3 = savedState.f45896d;
        if (j3 >= 0) {
            this.G = true;
            this.f45905m = true;
            this.f45903h = j3;
            this.f45902f = savedState.f45897e;
            this.C = 0;
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        long j3 = j();
        savedState.f45896d = j3;
        if (j3 >= 0) {
            savedState.f45897e = k();
        } else {
            savedState.f45897e = -1;
        }
        return savedState;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.W) {
            return;
        }
        super.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (r2 <= ((r3 + getChildCount()) - 1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSelection(int i3, boolean z16) {
        boolean z17 = z16 && (r3 = this.f45900d) <= i3;
        F(i3, z17);
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public SpinnerAdapter f() {
        return this.T;
    }

    int y(View view) {
        return view.getMeasuredHeight();
    }

    int z(View view) {
        return view.getMeasuredWidth();
    }

    private void A() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        this.G = false;
        this.f45905m = false;
        removeAllViewsInLayout();
        this.P = -1;
        this.Q = Long.MIN_VALUE;
        u(-1);
        t(-1);
        invalidate();
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        SpinnerAdapter spinnerAdapter2 = this.T;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.f45894g0);
            E();
        }
        this.T = spinnerAdapter;
        this.P = -1;
        this.Q = Long.MIN_VALUE;
        if (spinnerAdapter != null) {
            this.N = this.M;
            this.M = spinnerAdapter.getCount();
            c();
            ExtendAdapterView.b bVar = new ExtendAdapterView.b();
            this.f45894g0 = bVar;
            this.T.registerDataSetObserver(bVar);
            int i3 = this.M > 0 ? 0 : -1;
            u(i3);
            t(i3);
            if (this.M == 0) {
                d();
            }
        } else {
            c();
            E();
            d();
        }
        requestLayout();
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView
    public void setSelection(int i3) {
        t(i3);
        requestLayout();
        invalidate();
    }

    public ExtendAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendAbsSpinner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f45888a0 = 0;
        this.f45889b0 = 0;
        this.f45890c0 = 0;
        this.f45891d0 = 0;
        this.f45892e0 = new Rect();
        this.f45893f0 = new a();
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendAbsSpinner, i3, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, textArray);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
    }
}
