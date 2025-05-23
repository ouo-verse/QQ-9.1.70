package com.etrump.mixlayout;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.mobileqq.vas.font.api.IETextView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private IETextView f32747a;

    /* renamed from: b, reason: collision with root package name */
    private e f32748b;

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<Rect> f32749c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private int[] f32750d = new int[2];

    public j(IETextView iETextView, e eVar) {
        this.f32747a = iETextView;
        this.f32748b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        SparseArray<Rect> sparseArray = this.f32749c;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        this.f32747a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<Rect> b() {
        return this.f32749c;
    }

    public void c(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            i w3 = this.f32748b.w(i3);
            i w16 = this.f32748b.w(i16);
            if (w3 != null && w16 != null) {
                this.f32749c.clear();
                int i17 = w3.f32745b;
                int i18 = w16.f32745b;
                if (i17 == i18) {
                    Rect rect = new Rect();
                    Rect rect2 = w16.f32746c;
                    int i19 = rect2.left;
                    Rect rect3 = w3.f32746c;
                    int i26 = rect3.left;
                    if (i19 >= i26) {
                        rect.set(i26, rect3.top, rect2.right, rect2.bottom);
                    } else {
                        rect.set(i19, rect2.top, i26, rect3.bottom);
                    }
                    rect.offset(this.f32747a.getPaddingLeft(), this.f32747a.getPaddingTop());
                    this.f32749c.append(w16.f32745b, rect);
                } else {
                    if (i17 > i18) {
                        i18 = i17;
                        i17 = i18;
                    }
                    for (int i27 = i17; i27 <= i18; i27++) {
                        Rect rect4 = new Rect();
                        Rect t16 = this.f32748b.t(i27);
                        if (t16 == null) {
                            QLog.e("ETTextSelection", 1, "no lineBound: " + i27 + " " + this.f32748b.r() + " " + i17 + " " + i18);
                            return;
                        }
                        if (w16.f32745b > w3.f32745b) {
                            if (i27 == i17) {
                                Rect rect5 = w3.f32746c;
                                rect4.set(rect5.left, rect5.top, t16.right, t16.bottom);
                            } else if (i27 == i18) {
                                int i28 = t16.left;
                                int i29 = t16.top;
                                Rect rect6 = w16.f32746c;
                                rect4.set(i28, i29, rect6.right, rect6.bottom);
                            } else {
                                rect4.set(t16.left, t16.top, t16.right, t16.bottom);
                            }
                        } else if (i27 == i17) {
                            Rect rect7 = w16.f32746c;
                            rect4.set(rect7.left, rect7.top, t16.right, t16.bottom);
                        } else if (i27 == i18) {
                            int i36 = t16.left;
                            int i37 = t16.top;
                            Rect rect8 = w3.f32746c;
                            rect4.set(i36, i37, rect8.left, rect8.bottom);
                        } else {
                            rect4.set(t16.left, t16.top, t16.right, t16.bottom);
                        }
                        rect4.offset(this.f32747a.getPaddingLeft(), this.f32747a.getPaddingTop());
                        this.f32749c.append(i27, rect4);
                    }
                }
                this.f32747a.invalidate();
            }
        }
    }

    public void d(int i3, int[] iArr, boolean z16) {
        if (!z16) {
            i3--;
        }
        i w3 = this.f32748b.w(i3);
        if (w3 != null && iArr != null && iArr.length >= 2) {
            this.f32747a.getLocationInWindow(iArr);
            if (z16) {
                iArr[0] = iArr[0] + this.f32747a.getPaddingLeft() + w3.f32746c.left;
                iArr[1] = iArr[1] + this.f32747a.getPaddingTop() + w3.f32746c.bottom;
            } else {
                iArr[0] = iArr[0] + this.f32747a.getPaddingLeft() + w3.f32746c.right;
                iArr[1] = iArr[1] + this.f32747a.getPaddingTop() + w3.f32746c.bottom;
            }
        }
    }

    public int e(int i3, int i16) {
        this.f32747a.getLocationInWindow(this.f32750d);
        return this.f32748b.x((i3 - this.f32750d[0]) - this.f32747a.getPaddingLeft(), (i16 - this.f32750d[1]) - this.f32747a.getPaddingTop());
    }
}
