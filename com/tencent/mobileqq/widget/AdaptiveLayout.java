package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AdaptiveLayout extends ViewGroup {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private int f315374d;

    /* renamed from: e, reason: collision with root package name */
    private int f315375e;

    /* renamed from: f, reason: collision with root package name */
    private int f315376f;

    /* renamed from: h, reason: collision with root package name */
    private Map<Integer, a> f315377h;

    /* renamed from: i, reason: collision with root package name */
    private int f315378i;

    /* renamed from: m, reason: collision with root package name */
    private int f315379m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f315380a;

        /* renamed from: b, reason: collision with root package name */
        public int f315381b;

        public a(int i3, int i16) {
            this.f315380a = i3;
            this.f315381b = i16;
        }
    }

    public AdaptiveLayout(Context context) {
        super(context);
        this.f315377h = new HashMap();
    }

    private void a(int i3, int i16, int i17, int i18) {
        int paddingLeft;
        int paddingTop;
        int i19;
        AdaptiveLayout adaptiveLayout = this;
        Object[] array = adaptiveLayout.f315377h.keySet().toArray();
        Arrays.sort(array);
        int childCount = getChildCount();
        int paddingTop2 = getPaddingTop();
        int length = array.length;
        int length2 = array.length;
        int i26 = 0;
        int i27 = 0;
        while (i26 < length2) {
            Object obj = array[i26];
            int intValue = ((Integer) obj).intValue();
            if (intValue > childCount) {
                intValue = childCount;
            }
            a aVar = adaptiveLayout.f315377h.get(obj);
            int i28 = adaptiveLayout.f315375e;
            int i29 = adaptiveLayout.f315376f;
            int i36 = adaptiveLayout.f315378i & 7;
            if (i36 != 1) {
                if (i36 != 5) {
                    if (i36 == 7) {
                        int i37 = intValue - i27;
                        i28 = ((i17 - i3) - (aVar.f315380a - (i28 * (i37 - 1)))) / i37;
                    }
                    paddingLeft = getPaddingLeft();
                } else {
                    paddingLeft = ((getPaddingLeft() + i17) - i3) - aVar.f315380a;
                }
            } else {
                paddingLeft = getPaddingLeft() + (((i17 - i3) - aVar.f315380a) / 2);
            }
            int i38 = adaptiveLayout.f315378i & 112;
            if (i38 != 16) {
                if (i38 != 80) {
                    if (i38 == 112) {
                        i29 = ((i18 - i16) - (adaptiveLayout.C - (adaptiveLayout.f315376f * (length - 1)))) / length;
                    }
                    paddingTop = getPaddingTop();
                } else {
                    paddingTop = ((getPaddingTop() + i18) - i16) - adaptiveLayout.C;
                }
            } else {
                paddingTop = getPaddingTop() + (((i18 - i16) - adaptiveLayout.C) / 2);
            }
            int i39 = paddingTop + paddingTop2;
            int i46 = paddingLeft;
            while (i27 < intValue) {
                View childAt = adaptiveLayout.getChildAt(i27);
                Object[] objArr = array;
                if (childAt.getVisibility() != 8) {
                    int measuredHeight = ((aVar.f315381b - childAt.getMeasuredHeight()) / 2) + i39;
                    i19 = childCount;
                    childAt.layout(i46, measuredHeight, childAt.getMeasuredWidth() + i46, measuredHeight + childAt.getMeasuredHeight());
                    i46 += childAt.getMeasuredWidth() + i28;
                } else {
                    i19 = childCount;
                }
                i27++;
                adaptiveLayout = this;
                array = objArr;
                childCount = i19;
            }
            Object[] objArr2 = array;
            int i47 = childCount;
            if (paddingLeft != i46) {
                paddingTop2 += aVar.f315381b + i29;
            }
            i26++;
            adaptiveLayout = this;
            array = objArr2;
            childCount = i47;
        }
    }

    private void c(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        this.f315377h.clear();
        measureChildren(i3, i16);
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                if (mode != 0) {
                    if (i17 > 0 && childAt.getMeasuredWidth() + paddingLeft > size) {
                        int i27 = paddingLeft - this.f315375e;
                        i18 = Math.max(i18, i27);
                        i19 += this.f315376f + i26;
                        this.f315377h.put(Integer.valueOf(i17), new a(i27, i26));
                        paddingLeft = getPaddingLeft() + getPaddingRight();
                        i26 = 0;
                    }
                    paddingLeft += childAt.getMeasuredWidth() + this.f315375e;
                    i26 = Math.max(i26, childAt.getMeasuredHeight());
                } else {
                    paddingLeft += childAt.getMeasuredWidth() + this.f315375e;
                    i26 = Math.max(i26, childAt.getMeasuredHeight());
                }
            }
            i17++;
        }
        if (paddingLeft != 0) {
            int i28 = paddingLeft - this.f315375e;
            i18 = Math.max(i18, i28);
            i19 += i26;
            this.f315377h.put(Integer.valueOf(i17), new a(i28, i26));
        }
        this.f315379m = i18;
        this.C = i19;
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                size = i18;
            }
        } else {
            size = Math.min(i18 + getPaddingLeft() + getPaddingTop(), size);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                size2 = i19;
            }
        } else {
            size2 = Math.min(i19 + getPaddingTop() + getPaddingBottom(), size2);
        }
        setMeasuredDimension(View.resolveSize(Math.max(size, getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(size2, getSuggestedMinimumHeight()), i16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.f315374d == 1) {
            b(i3, i16, i17, i18);
        } else {
            a(i3, i16, i17, i18);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f315374d == 1) {
            d(i3, i16);
        } else {
            c(i3, i16);
        }
    }

    public void setGap(int i3, int i16) {
        this.f315375e = i3;
        this.f315376f = i16;
    }

    public void setGravity(int i3) {
        this.f315378i = i3;
    }

    public void setOrientation(int i3) {
        if (this.f315374d != i3) {
            this.f315374d = i3;
            requestLayout();
        }
    }

    public AdaptiveLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315377h = new HashMap();
    }

    public AdaptiveLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315377h = new HashMap();
    }

    private void d(int i3, int i16) {
    }

    private void b(int i3, int i16, int i17, int i18) {
    }
}
