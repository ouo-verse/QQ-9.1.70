package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.flexbox.a f33153a;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f33154b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    int[] f33155c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    long[] f33156d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private long[] f33157e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        List<com.google.android.flexbox.b> f33158a;

        /* renamed from: b, reason: collision with root package name */
        int f33159b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f33158a = null;
            this.f33159b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.google.android.flexbox.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0227c implements Comparable<C0227c> {

        /* renamed from: d, reason: collision with root package name */
        int f33160d;

        /* renamed from: e, reason: collision with root package name */
        int f33161e;

        C0227c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull C0227c c0227c) {
            int i3 = this.f33161e;
            int i16 = c0227c.f33161e;
            if (i3 != i16) {
                return i3 - i16;
            }
            return this.f33160d - c0227c.f33160d;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f33161e + ", index=" + this.f33160d + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.f33153a = aVar;
    }

    private int A(int i3, FlexItem flexItem, int i16) {
        com.google.android.flexbox.a aVar = this.f33153a;
        int o16 = aVar.o(i3, aVar.getPaddingLeft() + this.f33153a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i16, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(o16);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(o16));
        }
        if (size < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(o16));
        }
        return o16;
    }

    private int B(FlexItem flexItem, boolean z16) {
        if (z16) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private int C(FlexItem flexItem, boolean z16) {
        if (z16) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int D(FlexItem flexItem, boolean z16) {
        if (z16) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int E(FlexItem flexItem, boolean z16) {
        if (z16) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int F(FlexItem flexItem, boolean z16) {
        if (z16) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int G(FlexItem flexItem, boolean z16) {
        if (z16) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int H(boolean z16) {
        if (z16) {
            return this.f33153a.getPaddingBottom();
        }
        return this.f33153a.getPaddingEnd();
    }

    private int I(boolean z16) {
        if (z16) {
            return this.f33153a.getPaddingEnd();
        }
        return this.f33153a.getPaddingBottom();
    }

    private int J(boolean z16) {
        if (z16) {
            return this.f33153a.getPaddingTop();
        }
        return this.f33153a.getPaddingStart();
    }

    private int K(boolean z16) {
        if (z16) {
            return this.f33153a.getPaddingStart();
        }
        return this.f33153a.getPaddingTop();
    }

    private int L(View view, boolean z16) {
        if (z16) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int M(View view, boolean z16) {
        if (z16) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean N(int i3, int i16, com.google.android.flexbox.b bVar) {
        if (i3 == i16 - 1 && bVar.c() != 0) {
            return true;
        }
        return false;
    }

    private boolean P(View view, int i3, int i16, int i17, int i18, FlexItem flexItem, int i19, int i26, int i27) {
        if (this.f33153a.g() == 0) {
            return false;
        }
        if (flexItem.Y()) {
            return true;
        }
        if (i3 == 0) {
            return false;
        }
        int d16 = this.f33153a.d();
        if (d16 != -1 && d16 <= i27 + 1) {
            return false;
        }
        int k3 = this.f33153a.k(view, i19, i26);
        if (k3 > 0) {
            i18 += k3;
        }
        if (i16 >= i17 + i18) {
            return false;
        }
        return true;
    }

    private void T(int i3, int i16, com.google.android.flexbox.b bVar, int i17, int i18, boolean z16) {
        int i19;
        int i26;
        int i27;
        int i28 = bVar.f33139e;
        float f16 = bVar.f33145k;
        float f17 = 0.0f;
        if (f16 > 0.0f && i17 <= i28) {
            float f18 = (i28 - i17) / f16;
            bVar.f33139e = i18 + bVar.f33140f;
            if (!z16) {
                bVar.f33141g = Integer.MIN_VALUE;
            }
            int i29 = 0;
            boolean z17 = false;
            int i36 = 0;
            float f19 = 0.0f;
            while (i29 < bVar.f33142h) {
                int i37 = bVar.f33149o + i29;
                View n3 = this.f33153a.n(i37);
                if (n3 != null && n3.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) n3.getLayoutParams();
                    int flexDirection = this.f33153a.getFlexDirection();
                    if (flexDirection != 0 && flexDirection != 1) {
                        int measuredHeight = n3.getMeasuredHeight();
                        long[] jArr = this.f33157e;
                        if (jArr != null) {
                            measuredHeight = x(jArr[i37]);
                        }
                        int measuredWidth = n3.getMeasuredWidth();
                        long[] jArr2 = this.f33157e;
                        if (jArr2 != null) {
                            measuredWidth = y(jArr2[i37]);
                        }
                        if (!this.f33154b[i37] && flexItem.getFlexShrink() > f17) {
                            float flexShrink = measuredHeight - (flexItem.getFlexShrink() * f18);
                            if (i29 == bVar.f33142h - 1) {
                                flexShrink += f19;
                                f19 = f17;
                            }
                            int round = Math.round(flexShrink);
                            if (round < flexItem.getMinHeight()) {
                                round = flexItem.getMinHeight();
                                this.f33154b[i37] = true;
                                bVar.f33145k -= flexItem.getFlexShrink();
                                i19 = i28;
                                i26 = i29;
                                z17 = true;
                            } else {
                                f19 += flexShrink - round;
                                i19 = i28;
                                i26 = i29;
                                double d16 = f19;
                                if (d16 > 1.0d) {
                                    round++;
                                    f19 -= 1.0f;
                                } else if (d16 < -1.0d) {
                                    round--;
                                    f19 += 1.0f;
                                }
                            }
                            int A = A(i3, flexItem, bVar.f33147m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            n3.measure(A, makeMeasureSpec);
                            measuredWidth = n3.getMeasuredWidth();
                            int measuredHeight2 = n3.getMeasuredHeight();
                            Z(i37, A, makeMeasureSpec, n3);
                            this.f33153a.p(i37, n3);
                            measuredHeight = measuredHeight2;
                        } else {
                            i19 = i28;
                            i26 = i29;
                        }
                        i27 = Math.max(i36, measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f33153a.j(n3));
                        bVar.f33139e += measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    } else {
                        i19 = i28;
                        int i38 = i29;
                        int measuredWidth2 = n3.getMeasuredWidth();
                        long[] jArr3 = this.f33157e;
                        if (jArr3 != null) {
                            measuredWidth2 = y(jArr3[i37]);
                        }
                        int measuredHeight3 = n3.getMeasuredHeight();
                        long[] jArr4 = this.f33157e;
                        if (jArr4 != null) {
                            measuredHeight3 = x(jArr4[i37]);
                        }
                        if (!this.f33154b[i37] && flexItem.getFlexShrink() > 0.0f) {
                            float flexShrink2 = measuredWidth2 - (flexItem.getFlexShrink() * f18);
                            i26 = i38;
                            if (i26 == bVar.f33142h - 1) {
                                flexShrink2 += f19;
                                f19 = 0.0f;
                            }
                            int round2 = Math.round(flexShrink2);
                            if (round2 < flexItem.getMinWidth()) {
                                round2 = flexItem.getMinWidth();
                                this.f33154b[i37] = true;
                                bVar.f33145k -= flexItem.getFlexShrink();
                                z17 = true;
                            } else {
                                f19 += flexShrink2 - round2;
                                double d17 = f19;
                                if (d17 > 1.0d) {
                                    round2++;
                                    f19 -= 1.0f;
                                } else if (d17 < -1.0d) {
                                    round2--;
                                    f19 += 1.0f;
                                }
                            }
                            int z18 = z(i16, flexItem, bVar.f33147m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            n3.measure(makeMeasureSpec2, z18);
                            int measuredWidth3 = n3.getMeasuredWidth();
                            int measuredHeight4 = n3.getMeasuredHeight();
                            Z(i37, makeMeasureSpec2, z18, n3);
                            this.f33153a.p(i37, n3);
                            measuredWidth2 = measuredWidth3;
                            measuredHeight3 = measuredHeight4;
                        } else {
                            i26 = i38;
                        }
                        int max = Math.max(i36, measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f33153a.j(n3));
                        bVar.f33139e += measuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i27 = max;
                    }
                    bVar.f33141g = Math.max(bVar.f33141g, i27);
                    i36 = i27;
                } else {
                    i19 = i28;
                    i26 = i29;
                }
                i29 = i26 + 1;
                i28 = i19;
                f17 = 0.0f;
            }
            int i39 = i28;
            if (z17 && i39 != bVar.f33139e) {
                T(i3, i16, bVar, i17, i18, true);
            }
        }
    }

    private int[] U(int i3, List<C0227c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i3];
        int i16 = 0;
        for (C0227c c0227c : list) {
            int i17 = c0227c.f33160d;
            iArr[i16] = i17;
            sparseIntArray.append(i17, c0227c.f33161e);
            i16++;
        }
        return iArr;
    }

    private void V(View view, int i3, int i16) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i3 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f33153a.j(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.f33157e;
        if (jArr != null) {
            measuredHeight = x(jArr[i16]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(i16, makeMeasureSpec2, makeMeasureSpec, view);
        this.f33153a.p(i16, view);
    }

    private void W(View view, int i3, int i16) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i3 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f33153a.j(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.f33157e;
        if (jArr != null) {
            measuredWidth = y(jArr[i16]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(i16, makeMeasureSpec, makeMeasureSpec2, view);
        this.f33153a.p(i16, view);
    }

    private void Z(int i3, int i16, int i17, View view) {
        long[] jArr = this.f33156d;
        if (jArr != null) {
            jArr[i3] = S(i16, i17);
        }
        long[] jArr2 = this.f33157e;
        if (jArr2 != null) {
            jArr2[i3] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i3, int i16) {
        bVar.f33147m = i16;
        this.f33153a.e(bVar);
        bVar.f33150p = i3;
        list.add(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(View view, int i3) {
        boolean z16;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z17 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else if (measuredWidth > flexItem.getMaxWidth()) {
            measuredWidth = flexItem.getMaxWidth();
        } else {
            z16 = false;
            if (measuredHeight >= flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z17 = z16;
            }
            if (!z17) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                Z(i3, makeMeasureSpec, makeMeasureSpec2, view);
                this.f33153a.p(i3, view);
                return;
            }
            return;
        }
        z16 = true;
        if (measuredHeight >= flexItem.getMinHeight()) {
        }
        if (!z17) {
        }
    }

    private List<com.google.android.flexbox.b> k(List<com.google.android.flexbox.b> list, int i3, int i16) {
        int i17 = (i3 - i16) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.f33141g = i17;
        int size = list.size();
        for (int i18 = 0; i18 < size; i18++) {
            if (i18 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i18));
            if (i18 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<C0227c> l(int i3) {
        ArrayList arrayList = new ArrayList(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            FlexItem flexItem = (FlexItem) this.f33153a.f(i16).getLayoutParams();
            C0227c c0227c = new C0227c();
            c0227c.f33161e = flexItem.getOrder();
            c0227c.f33160d = i16;
            arrayList.add(c0227c);
        }
        return arrayList;
    }

    private void r(int i3) {
        boolean[] zArr = this.f33154b;
        if (zArr == null) {
            this.f33154b = new boolean[Math.max(i3, 10)];
        } else if (zArr.length < i3) {
            this.f33154b = new boolean[Math.max(zArr.length * 2, i3)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(CompoundButton compoundButton) {
        int minimumWidth;
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int i3 = 0;
        if (buttonDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = buttonDrawable.getMinimumWidth();
        }
        if (buttonDrawable != null) {
            i3 = buttonDrawable.getMinimumHeight();
        }
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.W(minWidth);
        if (minHeight == -1) {
            minHeight = i3;
        }
        flexItem.U(minHeight);
    }

    private void w(int i3, int i16, com.google.android.flexbox.b bVar, int i17, int i18, boolean z16) {
        int i19;
        int i26;
        int i27;
        double d16;
        int i28;
        double d17;
        float f16 = bVar.f33144j;
        float f17 = 0.0f;
        if (f16 > 0.0f && i17 >= (i19 = bVar.f33139e)) {
            float f18 = (i17 - i19) / f16;
            bVar.f33139e = i18 + bVar.f33140f;
            if (!z16) {
                bVar.f33141g = Integer.MIN_VALUE;
            }
            int i29 = 0;
            boolean z17 = false;
            int i36 = 0;
            float f19 = 0.0f;
            while (i29 < bVar.f33142h) {
                int i37 = bVar.f33149o + i29;
                View n3 = this.f33153a.n(i37);
                if (n3 != null && n3.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) n3.getLayoutParams();
                    int flexDirection = this.f33153a.getFlexDirection();
                    if (flexDirection != 0 && flexDirection != 1) {
                        int measuredHeight = n3.getMeasuredHeight();
                        long[] jArr = this.f33157e;
                        if (jArr != null) {
                            measuredHeight = x(jArr[i37]);
                        }
                        int measuredWidth = n3.getMeasuredWidth();
                        long[] jArr2 = this.f33157e;
                        if (jArr2 != null) {
                            measuredWidth = y(jArr2[i37]);
                        }
                        if (!this.f33154b[i37] && flexItem.getFlexGrow() > f17) {
                            float flexGrow = measuredHeight + (flexItem.getFlexGrow() * f18);
                            if (i29 == bVar.f33142h - 1) {
                                flexGrow += f19;
                                f19 = f17;
                            }
                            int round = Math.round(flexGrow);
                            if (round > flexItem.getMaxHeight()) {
                                round = flexItem.getMaxHeight();
                                this.f33154b[i37] = true;
                                bVar.f33144j -= flexItem.getFlexGrow();
                                i28 = i19;
                                z17 = true;
                            } else {
                                f19 += flexGrow - round;
                                i28 = i19;
                                double d18 = f19;
                                if (d18 > 1.0d) {
                                    round++;
                                    d17 = d18 - 1.0d;
                                } else if (d18 < -1.0d) {
                                    round--;
                                    d17 = d18 + 1.0d;
                                }
                                f19 = (float) d17;
                            }
                            int A = A(i3, flexItem, bVar.f33147m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            n3.measure(A, makeMeasureSpec);
                            measuredWidth = n3.getMeasuredWidth();
                            int measuredHeight2 = n3.getMeasuredHeight();
                            Z(i37, A, makeMeasureSpec, n3);
                            this.f33153a.p(i37, n3);
                            measuredHeight = measuredHeight2;
                        } else {
                            i28 = i19;
                        }
                        i27 = Math.max(i36, measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f33153a.j(n3));
                        bVar.f33139e += measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom();
                        i26 = i28;
                    } else {
                        int i38 = i19;
                        int measuredWidth2 = n3.getMeasuredWidth();
                        long[] jArr3 = this.f33157e;
                        if (jArr3 != null) {
                            measuredWidth2 = y(jArr3[i37]);
                        }
                        int measuredHeight3 = n3.getMeasuredHeight();
                        long[] jArr4 = this.f33157e;
                        i26 = i38;
                        if (jArr4 != null) {
                            measuredHeight3 = x(jArr4[i37]);
                        }
                        if (!this.f33154b[i37] && flexItem.getFlexGrow() > 0.0f) {
                            float flexGrow2 = measuredWidth2 + (flexItem.getFlexGrow() * f18);
                            if (i29 == bVar.f33142h - 1) {
                                flexGrow2 += f19;
                                f19 = 0.0f;
                            }
                            int round2 = Math.round(flexGrow2);
                            if (round2 > flexItem.getMaxWidth()) {
                                round2 = flexItem.getMaxWidth();
                                this.f33154b[i37] = true;
                                bVar.f33144j -= flexItem.getFlexGrow();
                                z17 = true;
                            } else {
                                f19 += flexGrow2 - round2;
                                double d19 = f19;
                                if (d19 > 1.0d) {
                                    round2++;
                                    d16 = d19 - 1.0d;
                                } else if (d19 < -1.0d) {
                                    round2--;
                                    d16 = d19 + 1.0d;
                                }
                                f19 = (float) d16;
                            }
                            int z18 = z(i16, flexItem, bVar.f33147m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            n3.measure(makeMeasureSpec2, z18);
                            int measuredWidth3 = n3.getMeasuredWidth();
                            int measuredHeight4 = n3.getMeasuredHeight();
                            Z(i37, makeMeasureSpec2, z18, n3);
                            this.f33153a.p(i37, n3);
                            measuredWidth2 = measuredWidth3;
                            measuredHeight3 = measuredHeight4;
                        }
                        int max = Math.max(i36, measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f33153a.j(n3));
                        bVar.f33139e += measuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i27 = max;
                    }
                    bVar.f33141g = Math.max(bVar.f33141g, i27);
                    i36 = i27;
                } else {
                    i26 = i19;
                }
                i29++;
                i19 = i26;
                f17 = 0.0f;
            }
            int i39 = i19;
            if (z17 && i39 != bVar.f33139e) {
                w(i3, i16, bVar, i17, i18, true);
            }
        }
    }

    private int z(int i3, FlexItem flexItem, int i16) {
        com.google.android.flexbox.a aVar = this.f33153a;
        int m3 = aVar.m(i3, aVar.getPaddingTop() + this.f33153a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i16, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(m3);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(m3));
        }
        if (size < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(m3));
        }
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(SparseIntArray sparseIntArray) {
        int c16 = this.f33153a.c();
        if (sparseIntArray.size() != c16) {
            return true;
        }
        for (int i3 = 0; i3 < c16; i3++) {
            View f16 = this.f33153a.f(i3);
            if (f16 != null && ((FlexItem) f16.getLayoutParams()).getOrder() != sparseIntArray.get(i3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(View view, com.google.android.flexbox.b bVar, int i3, int i16, int i17, int i18) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f33153a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i19 = bVar.f33141g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3) {
                        if (alignItems != 4) {
                            return;
                        }
                    } else if (this.f33153a.g() != 2) {
                        int max = Math.max(bVar.f33146l - view.getBaseline(), flexItem.getMarginTop());
                        view.layout(i3, i16 + max, i17, i18 + max);
                        return;
                    } else {
                        int max2 = Math.max((bVar.f33146l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                        view.layout(i3, i16 - max2, i17, i18 - max2);
                        return;
                    }
                } else {
                    int measuredHeight = (((i19 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                    if (this.f33153a.g() != 2) {
                        int i26 = i16 + measuredHeight;
                        view.layout(i3, i26, i17, view.getMeasuredHeight() + i26);
                        return;
                    } else {
                        int i27 = i16 - measuredHeight;
                        view.layout(i3, i27, i17, view.getMeasuredHeight() + i27);
                        return;
                    }
                }
            } else if (this.f33153a.g() != 2) {
                int i28 = i16 + i19;
                view.layout(i3, (i28 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i17, i28 - flexItem.getMarginBottom());
                return;
            } else {
                view.layout(i3, (i16 - i19) + view.getMeasuredHeight() + flexItem.getMarginTop(), i17, (i18 - i19) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            }
        }
        if (this.f33153a.g() != 2) {
            view.layout(i3, i16 + flexItem.getMarginTop(), i17, i18 + flexItem.getMarginTop());
        } else {
            view.layout(i3, i16 - flexItem.getMarginBottom(), i17, i18 - flexItem.getMarginBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(View view, com.google.android.flexbox.b bVar, boolean z16, int i3, int i16, int i17, int i18) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f33153a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i19 = bVar.f33141g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3 && alignItems != 4) {
                        return;
                    }
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i19 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                    if (!z16) {
                        view.layout(i3 + measuredWidth, i16, i17 + measuredWidth, i18);
                        return;
                    } else {
                        view.layout(i3 - measuredWidth, i16, i17 - measuredWidth, i18);
                        return;
                    }
                }
            } else if (!z16) {
                view.layout(((i3 + i19) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i16, ((i17 + i19) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i18);
                return;
            } else {
                view.layout((i3 - i19) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i16, (i17 - i19) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i18);
                return;
            }
        }
        if (!z16) {
            view.layout(i3 + flexItem.getMarginLeft(), i16, i17 + flexItem.getMarginLeft(), i18);
        } else {
            view.layout(i3 - flexItem.getMarginRight(), i16, i17 - flexItem.getMarginRight(), i18);
        }
    }

    @VisibleForTesting
    long S(int i3, int i16) {
        return (i3 & 4294967295L) | (i16 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        Y(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(int i3) {
        int i16;
        View n3;
        if (i3 >= this.f33153a.c()) {
            return;
        }
        int flexDirection = this.f33153a.getFlexDirection();
        if (this.f33153a.getAlignItems() == 4) {
            int[] iArr = this.f33155c;
            if (iArr != null) {
                i16 = iArr[i3];
            } else {
                i16 = 0;
            }
            List<com.google.android.flexbox.b> i17 = this.f33153a.i();
            int size = i17.size();
            while (i16 < size) {
                com.google.android.flexbox.b bVar = i17.get(i16);
                int i18 = bVar.f33142h;
                for (int i19 = 0; i19 < i18; i19++) {
                    int i26 = bVar.f33149o + i19;
                    if (i19 < this.f33153a.c() && (n3 = this.f33153a.n(i26)) != null && n3.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) n3.getLayoutParams();
                        if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                V(n3, bVar.f33141g, i26);
                            } else {
                                W(n3, bVar.f33141g, i26);
                            }
                        }
                    }
                }
                i16++;
            }
            return;
        }
        for (com.google.android.flexbox.b bVar2 : this.f33153a.i()) {
            for (Integer num : bVar2.f33148n) {
                View n16 = this.f33153a.n(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                    V(n16, bVar2.f33141g, num.intValue());
                } else {
                    W(n16, bVar2.f33141g, num.intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(b bVar, int i3, int i16, int i17, int i18, int i19, @Nullable List<com.google.android.flexbox.b> list) {
        List<com.google.android.flexbox.b> list2;
        int i26;
        int i27;
        b bVar2;
        int i28;
        int i29;
        int i36;
        List<com.google.android.flexbox.b> list3;
        int i37;
        View view;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65 = i3;
        int i66 = i16;
        int i67 = i19;
        boolean q16 = this.f33153a.q();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (list == null) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        bVar.f33158a = list2;
        if (i67 == -1) {
            i26 = 1;
        } else {
            i26 = 0;
        }
        int K = K(q16);
        int I = I(q16);
        int J = J(q16);
        int H = H(q16);
        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
        int i68 = i18;
        bVar3.f33149o = i68;
        int i69 = I + K;
        bVar3.f33139e = i69;
        int c16 = this.f33153a.c();
        int i75 = i26;
        int i76 = Integer.MIN_VALUE;
        int i77 = 0;
        int i78 = 0;
        int i79 = 0;
        while (true) {
            if (i68 < c16) {
                View n3 = this.f33153a.n(i68);
                if (n3 == null) {
                    if (N(i68, c16, bVar3)) {
                        a(list2, bVar3, i68, i77);
                    }
                } else if (n3.getVisibility() == 8) {
                    bVar3.f33143i++;
                    bVar3.f33142h++;
                    if (N(i68, c16, bVar3)) {
                        a(list2, bVar3, i68, i77);
                    }
                } else {
                    if (n3 instanceof CompoundButton) {
                        v((CompoundButton) n3);
                    }
                    FlexItem flexItem = (FlexItem) n3.getLayoutParams();
                    int i85 = c16;
                    if (flexItem.getAlignSelf() == 4) {
                        bVar3.f33148n.add(Integer.valueOf(i68));
                    }
                    int G = G(flexItem, q16);
                    if (flexItem.O() != -1.0f && mode == 1073741824) {
                        G = Math.round(size * flexItem.O());
                    }
                    if (q16) {
                        int o16 = this.f33153a.o(i65, i69 + E(flexItem, true) + C(flexItem, true), G);
                        i28 = size;
                        i29 = mode;
                        int m3 = this.f33153a.m(i66, J + H + D(flexItem, true) + B(flexItem, true) + i77, F(flexItem, true));
                        n3.measure(o16, m3);
                        Z(i68, o16, m3, n3);
                        i36 = o16;
                    } else {
                        i28 = size;
                        i29 = mode;
                        int o17 = this.f33153a.o(i66, J + H + D(flexItem, false) + B(flexItem, false) + i77, F(flexItem, false));
                        int m16 = this.f33153a.m(i65, E(flexItem, false) + i69 + C(flexItem, false), G);
                        n3.measure(o17, m16);
                        Z(i68, o17, m16, n3);
                        i36 = m16;
                    }
                    this.f33153a.p(i68, n3);
                    i(n3, i68);
                    i78 = View.combineMeasuredStates(i78, n3.getMeasuredState());
                    int i86 = i77;
                    int i87 = i69;
                    com.google.android.flexbox.b bVar4 = bVar3;
                    int i88 = i68;
                    list3 = list2;
                    int i89 = i36;
                    if (P(n3, i29, i28, bVar3.f33139e, C(flexItem, q16) + M(n3, q16) + E(flexItem, q16), flexItem, i88, i79, list2.size())) {
                        if (bVar4.c() > 0) {
                            if (i88 > 0) {
                                i59 = i88 - 1;
                            } else {
                                i59 = 0;
                            }
                            a(list3, bVar4, i59, i86);
                            i77 = bVar4.f33141g + i86;
                        } else {
                            i77 = i86;
                        }
                        if (q16) {
                            if (flexItem.getHeight() == -1) {
                                com.google.android.flexbox.a aVar = this.f33153a;
                                i37 = i16;
                                i68 = i88;
                                view = n3;
                                view.measure(i89, aVar.m(i37, aVar.getPaddingTop() + this.f33153a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i77, flexItem.getHeight()));
                                i(view, i68);
                            } else {
                                i37 = i16;
                                view = n3;
                                i68 = i88;
                            }
                        } else {
                            i37 = i16;
                            view = n3;
                            i68 = i88;
                            if (flexItem.getWidth() == -1) {
                                com.google.android.flexbox.a aVar2 = this.f33153a;
                                view.measure(aVar2.o(i37, aVar2.getPaddingLeft() + this.f33153a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i77, flexItem.getWidth()), i89);
                                i(view, i68);
                            }
                        }
                        bVar3 = new com.google.android.flexbox.b();
                        i39 = 1;
                        bVar3.f33142h = 1;
                        i38 = i87;
                        bVar3.f33139e = i38;
                        bVar3.f33149o = i68;
                        i47 = Integer.MIN_VALUE;
                        i46 = 0;
                    } else {
                        i37 = i16;
                        view = n3;
                        i68 = i88;
                        bVar3 = bVar4;
                        i38 = i87;
                        i39 = 1;
                        bVar3.f33142h++;
                        i46 = i79 + 1;
                        i77 = i86;
                        i47 = i76;
                    }
                    boolean z16 = bVar3.f33151q;
                    if (flexItem.getFlexGrow() != 0.0f) {
                        i48 = i39;
                    } else {
                        i48 = 0;
                    }
                    bVar3.f33151q = (z16 ? 1 : 0) | i48;
                    boolean z17 = bVar3.f33152r;
                    if (flexItem.getFlexShrink() != 0.0f) {
                        i49 = i39;
                    } else {
                        i49 = 0;
                    }
                    bVar3.f33152r = (z17 ? 1 : 0) | i49;
                    int[] iArr = this.f33155c;
                    if (iArr != null) {
                        iArr[i68] = list3.size();
                    }
                    bVar3.f33139e += M(view, q16) + E(flexItem, q16) + C(flexItem, q16);
                    bVar3.f33144j += flexItem.getFlexGrow();
                    bVar3.f33145k += flexItem.getFlexShrink();
                    this.f33153a.l(view, i68, i46, bVar3);
                    int max = Math.max(i47, L(view, q16) + D(flexItem, q16) + B(flexItem, q16) + this.f33153a.j(view));
                    bVar3.f33141g = Math.max(bVar3.f33141g, max);
                    if (q16) {
                        if (this.f33153a.g() != 2) {
                            bVar3.f33146l = Math.max(bVar3.f33146l, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            bVar3.f33146l = Math.max(bVar3.f33146l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i56 = i85;
                    if (N(i68, i56, bVar3)) {
                        a(list3, bVar3, i68, i77);
                        i77 += bVar3.f33141g;
                    }
                    i57 = i19;
                    if (i57 != -1 && list3.size() > 0 && list3.get(list3.size() - i39).f33150p >= i57 && i68 >= i57 && i75 == 0) {
                        i77 = -bVar3.a();
                        i58 = i17;
                        i75 = i39;
                    } else {
                        i58 = i17;
                    }
                    if (i77 > i58 && i75 != 0) {
                        bVar2 = bVar;
                        i27 = i78;
                        break;
                    }
                    i79 = i46;
                    i76 = max;
                    i68++;
                    i65 = i3;
                    c16 = i56;
                    i66 = i37;
                    i69 = i38;
                    list2 = list3;
                    size = i28;
                    i67 = i57;
                    mode = i29;
                }
                i28 = size;
                i29 = mode;
                i37 = i66;
                i57 = i67;
                list3 = list2;
                i38 = i69;
                i56 = c16;
                i68++;
                i65 = i3;
                c16 = i56;
                i66 = i37;
                i69 = i38;
                list2 = list3;
                size = i28;
                i67 = i57;
                mode = i29;
            } else {
                i27 = i78;
                bVar2 = bVar;
                break;
            }
        }
        bVar2.f33159b = i27;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(b bVar, int i3, int i16) {
        b(bVar, i3, i16, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(b bVar, int i3, int i16, int i17, int i18, @Nullable List<com.google.android.flexbox.b> list) {
        b(bVar, i3, i16, i17, i18, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(b bVar, int i3, int i16, int i17, int i18, List<com.google.android.flexbox.b> list) {
        b(bVar, i3, i16, i17, 0, i18, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(b bVar, int i3, int i16) {
        b(bVar, i16, i3, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(b bVar, int i3, int i16, int i17, int i18, @Nullable List<com.google.android.flexbox.b> list) {
        b(bVar, i16, i3, i17, i18, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(b bVar, int i3, int i16, int i17, int i18, List<com.google.android.flexbox.b> list) {
        b(bVar, i16, i3, i17, 0, i18, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(List<com.google.android.flexbox.b> list, int i3) {
        int i16 = this.f33155c[i3];
        if (i16 == -1) {
            i16 = 0;
        }
        if (list.size() > i16) {
            list.subList(i16, list.size()).clear();
        }
        int[] iArr = this.f33155c;
        int length = iArr.length - 1;
        if (i3 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i3, length, -1);
        }
        long[] jArr = this.f33156d;
        int length2 = jArr.length - 1;
        if (i3 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i3, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m(SparseIntArray sparseIntArray) {
        int c16 = this.f33153a.c();
        return U(c16, l(c16), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i3, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int c16 = this.f33153a.c();
        List<C0227c> l3 = l(c16);
        C0227c c0227c = new C0227c();
        if (view != null && (layoutParams instanceof FlexItem)) {
            c0227c.f33161e = ((FlexItem) layoutParams).getOrder();
        } else {
            c0227c.f33161e = 1;
        }
        if (i3 != -1 && i3 != c16) {
            if (i3 < this.f33153a.c()) {
                c0227c.f33160d = i3;
                while (i3 < c16) {
                    l3.get(i3).f33160d++;
                    i3++;
                }
            } else {
                c0227c.f33160d = c16;
            }
        } else {
            c0227c.f33160d = c16;
        }
        l3.add(c0227c);
        return U(c16 + 1, l3, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i3, int i16, int i17) {
        int i18;
        int i19;
        int flexDirection = this.f33153a.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i18 = View.MeasureSpec.getMode(i3);
            i19 = View.MeasureSpec.getSize(i3);
        } else {
            int mode = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i16);
            i18 = mode;
            i19 = size;
        }
        List<com.google.android.flexbox.b> i26 = this.f33153a.i();
        if (i18 == 1073741824) {
            int h16 = this.f33153a.h() + i17;
            int i27 = 0;
            if (i26.size() == 1) {
                i26.get(0).f33141g = i19 - i17;
                return;
            }
            if (i26.size() >= 2) {
                int alignContent = this.f33153a.getAlignContent();
                if (alignContent != 1) {
                    if (alignContent != 2) {
                        if (alignContent != 3) {
                            if (alignContent != 4) {
                                if (alignContent == 5 && h16 < i19) {
                                    float size2 = (i19 - h16) / i26.size();
                                    int size3 = i26.size();
                                    float f16 = 0.0f;
                                    while (i27 < size3) {
                                        com.google.android.flexbox.b bVar = i26.get(i27);
                                        float f17 = bVar.f33141g + size2;
                                        if (i27 == i26.size() - 1) {
                                            f17 += f16;
                                            f16 = 0.0f;
                                        }
                                        int round = Math.round(f17);
                                        f16 += f17 - round;
                                        if (f16 > 1.0f) {
                                            round++;
                                            f16 -= 1.0f;
                                        } else if (f16 < -1.0f) {
                                            round--;
                                            f16 += 1.0f;
                                        }
                                        bVar.f33141g = round;
                                        i27++;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (h16 >= i19) {
                                this.f33153a.setFlexLines(k(i26, i19, h16));
                                return;
                            }
                            int size4 = (i19 - h16) / (i26.size() * 2);
                            ArrayList arrayList = new ArrayList();
                            com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
                            bVar2.f33141g = size4;
                            for (com.google.android.flexbox.b bVar3 : i26) {
                                arrayList.add(bVar2);
                                arrayList.add(bVar3);
                                arrayList.add(bVar2);
                            }
                            this.f33153a.setFlexLines(arrayList);
                            return;
                        }
                        if (h16 < i19) {
                            float size5 = (i19 - h16) / (i26.size() - 1);
                            ArrayList arrayList2 = new ArrayList();
                            int size6 = i26.size();
                            float f18 = 0.0f;
                            while (i27 < size6) {
                                arrayList2.add(i26.get(i27));
                                if (i27 != i26.size() - 1) {
                                    com.google.android.flexbox.b bVar4 = new com.google.android.flexbox.b();
                                    if (i27 == i26.size() - 2) {
                                        bVar4.f33141g = Math.round(f18 + size5);
                                        f18 = 0.0f;
                                    } else {
                                        bVar4.f33141g = Math.round(size5);
                                    }
                                    int i28 = bVar4.f33141g;
                                    f18 += size5 - i28;
                                    if (f18 > 1.0f) {
                                        bVar4.f33141g = i28 + 1;
                                        f18 -= 1.0f;
                                    } else if (f18 < -1.0f) {
                                        bVar4.f33141g = i28 - 1;
                                        f18 += 1.0f;
                                    }
                                    arrayList2.add(bVar4);
                                }
                                i27++;
                            }
                            this.f33153a.setFlexLines(arrayList2);
                            return;
                        }
                        return;
                    }
                    this.f33153a.setFlexLines(k(i26, i19, h16));
                    return;
                }
                int i29 = i19 - h16;
                com.google.android.flexbox.b bVar5 = new com.google.android.flexbox.b();
                bVar5.f33141g = i29;
                i26.add(0, bVar5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i3, int i16) {
        q(i3, i16, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i3, int i16, int i17) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i18;
        r(this.f33153a.c());
        if (i17 >= this.f33153a.c()) {
            return;
        }
        int flexDirection = this.f33153a.getFlexDirection();
        int flexDirection2 = this.f33153a.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode = View.MeasureSpec.getMode(i16);
            size = View.MeasureSpec.getSize(i16);
            if (mode != 1073741824) {
                size = this.f33153a.b();
            }
            paddingLeft = this.f33153a.getPaddingTop();
            paddingRight = this.f33153a.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            int b16 = this.f33153a.b();
            if (mode2 != 1073741824) {
                size = Math.min(b16, size);
            }
            paddingLeft = this.f33153a.getPaddingLeft();
            paddingRight = this.f33153a.getPaddingRight();
        }
        int i19 = paddingLeft + paddingRight;
        int[] iArr = this.f33155c;
        if (iArr != null) {
            i18 = iArr[i17];
        } else {
            i18 = 0;
        }
        List<com.google.android.flexbox.b> i26 = this.f33153a.i();
        int size2 = i26.size();
        while (i18 < size2) {
            com.google.android.flexbox.b bVar = i26.get(i18);
            int i27 = bVar.f33139e;
            if (i27 < size && bVar.f33151q) {
                w(i3, i16, bVar, size, i19, false);
            } else if (i27 > size && bVar.f33152r) {
                T(i3, i16, bVar, size, i19, false);
            }
            i18++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i3) {
        int[] iArr = this.f33155c;
        if (iArr == null) {
            this.f33155c = new int[Math.max(i3, 10)];
        } else if (iArr.length < i3) {
            this.f33155c = Arrays.copyOf(this.f33155c, Math.max(iArr.length * 2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i3) {
        long[] jArr = this.f33156d;
        if (jArr == null) {
            this.f33156d = new long[Math.max(i3, 10)];
        } else if (jArr.length < i3) {
            this.f33156d = Arrays.copyOf(this.f33156d, Math.max(jArr.length * 2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i3) {
        long[] jArr = this.f33157e;
        if (jArr == null) {
            this.f33157e = new long[Math.max(i3, 10)];
        } else if (jArr.length < i3) {
            this.f33157e = Arrays.copyOf(this.f33157e, Math.max(jArr.length * 2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(long j3) {
        return (int) (j3 >> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y(long j3) {
        return (int) j3;
    }
}
