package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.shape.g;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    private static final String G = "MaterialButtonToggleGroup";
    private static final int H = 2131953441;
    private boolean C;
    private boolean D;

    @IdRes
    private final int E;
    private Set<Integer> F;

    /* renamed from: d, reason: collision with root package name */
    private final List<c> f33370d;

    /* renamed from: e, reason: collision with root package name */
    private final e f33371e;

    /* renamed from: f, reason: collision with root package name */
    private final LinkedHashSet<d> f33372f;

    /* renamed from: h, reason: collision with root package name */
    private final Comparator<MaterialButton> f33373h;

    /* renamed from: i, reason: collision with root package name */
    private Integer[] f33374i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f33375m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.j(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e, reason: collision with root package name */
        private static final j1.c f33378e = new j1.a(0.0f);

        /* renamed from: a, reason: collision with root package name */
        j1.c f33379a;

        /* renamed from: b, reason: collision with root package name */
        j1.c f33380b;

        /* renamed from: c, reason: collision with root package name */
        j1.c f33381c;

        /* renamed from: d, reason: collision with root package name */
        j1.c f33382d;

        c(j1.c cVar, j1.c cVar2, j1.c cVar3, j1.c cVar4) {
            this.f33379a = cVar;
            this.f33380b = cVar3;
            this.f33381c = cVar4;
            this.f33382d = cVar2;
        }

        public static c a(c cVar) {
            j1.c cVar2 = f33378e;
            return new c(cVar2, cVar.f33382d, cVar2, cVar.f33381c);
        }

        public static c b(c cVar, View view) {
            if (ViewUtils.i(view)) {
                return c(cVar);
            }
            return d(cVar);
        }

        public static c c(c cVar) {
            j1.c cVar2 = cVar.f33379a;
            j1.c cVar3 = cVar.f33382d;
            j1.c cVar4 = f33378e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            j1.c cVar2 = f33378e;
            return new c(cVar2, cVar2, cVar.f33380b, cVar.f33381c);
        }

        public static c e(c cVar, View view) {
            if (ViewUtils.i(view)) {
                return d(cVar);
            }
            return c(cVar);
        }

        public static c f(c cVar) {
            j1.c cVar2 = cVar.f33379a;
            j1.c cVar3 = f33378e;
            return new c(cVar2, cVar3, cVar.f33380b, cVar3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i3, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements MaterialButton.b {
        e() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z16) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void c() {
        int i3 = i();
        if (i3 == -1) {
            return;
        }
        for (int i16 = i3 + 1; i16 < getChildCount(); i16++) {
            MaterialButton h16 = h(i16);
            int min = Math.min(h16.h(), h(i16 - 1).h());
            LinearLayout.LayoutParams d16 = d(h16);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(d16, 0);
                MarginLayoutParamsCompat.setMarginStart(d16, -min);
                d16.topMargin = 0;
            } else {
                d16.bottomMargin = 0;
                d16.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(d16, 0);
            }
            h16.setLayoutParams(d16);
        }
        q(i3);
    }

    @NonNull
    private LinearLayout.LayoutParams d(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(@IdRes int i3, boolean z16) {
        if (i3 == -1) {
            Log.e(G, "Button ID is not valid: " + i3);
            return;
        }
        HashSet hashSet = new HashSet(this.F);
        if (z16 && !hashSet.contains(Integer.valueOf(i3))) {
            if (this.C && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i3));
        } else if (!z16 && hashSet.contains(Integer.valueOf(i3))) {
            if (!this.D || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i3));
            }
        } else {
            return;
        }
        v(hashSet);
    }

    private void g(@IdRes int i3, boolean z16) {
        Iterator<d> it = this.f33372f.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3, z16);
        }
    }

    private MaterialButton h(int i3) {
        return (MaterialButton) getChildAt(i3);
    }

    private int i() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (n(i3)) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            if (getChildAt(i16) == view) {
                return i3;
            }
            if ((getChildAt(i16) instanceof MaterialButton) && n(i16)) {
                i3++;
            }
        }
        return -1;
    }

    private int k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (n(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @Nullable
    private c l(int i3, int i16, int i17) {
        boolean z16;
        c cVar = this.f33370d.get(i3);
        if (i16 == i17) {
            return cVar;
        }
        if (getOrientation() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == i16) {
            if (z16) {
                return c.e(cVar, this);
            }
            return c.f(cVar);
        }
        if (i3 == i17) {
            if (z16) {
                return c.b(cVar, this);
            }
            return c.a(cVar);
        }
        return null;
    }

    private int m() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            if ((getChildAt(i16) instanceof MaterialButton) && n(i16)) {
                i3++;
            }
        }
        return i3;
    }

    private boolean n(int i3) {
        if (getChildAt(i3).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void q(int i3) {
        if (getChildCount() != 0 && i3 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i3).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
            } else {
                MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
                MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
        }
    }

    private void r(@IdRes int i3, boolean z16) {
        View findViewById = findViewById(i3);
        if (findViewById instanceof MaterialButton) {
            this.f33375m = true;
            ((MaterialButton) findViewById).setChecked(z16);
            this.f33375m = false;
        }
    }

    private void s(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void t(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.s(this.f33371e);
        materialButton.t(true);
    }

    private static void u(g.b bVar, @Nullable c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.F(cVar.f33379a).w(cVar.f33382d).J(cVar.f33380b).A(cVar.f33381c);
        }
    }

    private void v(Set<Integer> set) {
        Set<Integer> set2 = this.F;
        this.F = new HashSet(set);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id5 = h(i3).getId();
            r(id5, set.contains(Integer.valueOf(id5)));
            if (set2.contains(Integer.valueOf(id5)) != set.contains(Integer.valueOf(id5))) {
                g(id5, set.contains(Integer.valueOf(id5)));
            }
        }
        invalidate();
    }

    private void w() {
        TreeMap treeMap = new TreeMap(this.f33373h);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put(h(i3), Integer.valueOf(i3));
        }
        this.f33374i = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(G, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        s(materialButton);
        t(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        g g16 = materialButton.g();
        this.f33370d.add(new c(g16.r(), g16.j(), g16.t(), g16.l()));
        ViewCompat.setAccessibilityDelegate(materialButton, new b());
    }

    public void b(@NonNull d dVar) {
        this.f33372f.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        w();
        super.dispatchDraw(canvas);
    }

    public void f() {
        v(new HashSet());
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        Integer[] numArr = this.f33374i;
        if (numArr != null && i16 < numArr.length) {
            return numArr[i16].intValue();
        }
        Log.w(G, "Child order wasn't updated");
        return i16;
    }

    public boolean o() {
        return this.C;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.E;
        if (i3 != -1) {
            v(Collections.singleton(Integer.valueOf(i3)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        int m3 = m();
        if (o()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, m3, false, i3));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        x();
        c();
        super.onMeasure(i3, i16);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).s(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f33370d.remove(indexOfChild);
        }
        x();
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@NonNull MaterialButton materialButton, boolean z16) {
        if (this.f33375m) {
            return;
        }
        e(materialButton.getId(), z16);
    }

    public void setSelectionRequired(boolean z16) {
        this.D = z16;
    }

    public void setSingleSelection(boolean z16) {
        if (this.C != z16) {
            this.C = z16;
            f();
        }
    }

    @VisibleForTesting
    void x() {
        int childCount = getChildCount();
        int i3 = i();
        int k3 = k();
        for (int i16 = 0; i16 < childCount; i16++) {
            MaterialButton h16 = h(i16);
            if (h16.getVisibility() != 8) {
                g.b v3 = h16.g().v();
                u(v3, l(i16, i3, k3));
                h16.setShapeAppearanceModel(v3.m());
            }
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.auj);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = H;
        this.f33370d = new ArrayList();
        this.f33371e = new e(this, null);
        this.f33372f = new LinkedHashSet<>();
        this.f33373h = new a();
        this.f33375m = false;
        this.F = new HashSet();
        TypedArray h16 = o.h(getContext(), attributeSet, w0.a.f443963n4, i3, i16, new int[0]);
        setSingleSelection(h16.getBoolean(w0.a.f443999q4, false));
        this.E = h16.getResourceId(w0.a.f443975o4, -1);
        this.D = h16.getBoolean(w0.a.f443987p4, false);
        setChildrenDrawingOrderEnabled(true);
        h16.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
