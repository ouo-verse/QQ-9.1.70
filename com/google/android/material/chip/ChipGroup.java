package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.a;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int G = 2131953427;

    @Nullable
    private d C;
    private final com.google.android.material.internal.a<Chip> D;
    private final int E;

    @NonNull
    private final e F;

    /* renamed from: i, reason: collision with root package name */
    @Dimension
    private int f33448i;

    /* renamed from: m, reason: collision with root package name */
    @Dimension
    private int f33449m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements a.b {
        a() {
        }

        @Override // com.google.android.material.internal.a.b
        public void a(Set<Integer> set) {
            if (ChipGroup.this.C != null) {
                d dVar = ChipGroup.this.C;
                ChipGroup chipGroup = ChipGroup.this;
                dVar.a(chipGroup, chipGroup.D.j(ChipGroup.this));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements d {
        b(c cVar) {
        }

        @Override // com.google.android.material.chip.ChipGroup.d
        public void a(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list) {
            if (!ChipGroup.this.D.l()) {
                return;
            }
            ChipGroup.this.j();
            throw null;
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        void a(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f33452d;

        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            EventCollector.getInstance().onChildViewAdded(view, view2);
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                ChipGroup.this.D.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f33452d;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            EventCollector.getInstance().onChildViewRemoved(view, view2);
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.D.n((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f33452d;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        /* synthetic */ e(ChipGroup chipGroup, a aVar) {
            this();
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int k() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            if (getChildAt(i16) instanceof Chip) {
                i3++;
            }
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean d() {
        return super.d();
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int j() {
        return this.D.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            if (getChildAt(i16) instanceof Chip) {
                if (((Chip) getChildAt(i16)) == view) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    public boolean m() {
        return this.D.l();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.E;
        if (i3 != -1) {
            this.D.f(i3);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3;
        int i16;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        if (d()) {
            i3 = k();
        } else {
            i3 = -1;
        }
        int b16 = b();
        if (m()) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(b16, i3, false, i16));
    }

    public void setChipSpacing(@Dimension int i3) {
        setChipSpacingHorizontal(i3);
        setChipSpacingVertical(i3);
    }

    public void setChipSpacingHorizontal(@Dimension int i3) {
        if (this.f33448i != i3) {
            this.f33448i = i3;
            f(i3);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i3) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingResource(@DimenRes int i3) {
        setChipSpacing(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingVertical(@Dimension int i3) {
        if (this.f33449m != i3) {
            this.f33449m = i3;
            g(i3);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i3) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i3));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i3) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable c cVar) {
        if (cVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new b(cVar));
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable d dVar) {
        this.C = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.F.f33452d = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z16) {
        this.D.p(z16);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z16) {
        super.setSingleLine(z16);
    }

    public void setSingleSelection(boolean z16) {
        this.D.q(z16);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a5s);
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@BoolRes int i3) {
        setSingleLine(getResources().getBoolean(i3));
    }

    public void setSingleSelection(@BoolRes int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChipGroup(Context context, AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = G;
        com.google.android.material.internal.a<Chip> aVar = new com.google.android.material.internal.a<>();
        this.D = aVar;
        e eVar = new e(this, null);
        this.F = eVar;
        TypedArray h16 = o.h(getContext(), attributeSet, w0.a.D1, i3, i16, new int[0]);
        int dimensionPixelOffset = h16.getDimensionPixelOffset(w0.a.F1, 0);
        setChipSpacingHorizontal(h16.getDimensionPixelOffset(w0.a.G1, dimensionPixelOffset));
        setChipSpacingVertical(h16.getDimensionPixelOffset(w0.a.H1, dimensionPixelOffset));
        setSingleLine(h16.getBoolean(w0.a.J1, false));
        setSingleSelection(h16.getBoolean(w0.a.K1, false));
        setSelectionRequired(h16.getBoolean(w0.a.I1, false));
        this.E = h16.getResourceId(w0.a.E1, -1);
        h16.recycle();
        aVar.o(new a());
        super.setOnHierarchyChangeListener(eVar);
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
