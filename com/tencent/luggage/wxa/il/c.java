package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends g {

    /* renamed from: g, reason: collision with root package name */
    public Integer f130647g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f130648h;

    /* renamed from: i, reason: collision with root package name */
    public Float f130649i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f130650j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.wj.h f130651k;

    public c(Context context) {
        super(context);
        this.f130651k = new com.tencent.luggage.wxa.wj.h(-1, -1);
        w.d("Luggage.WXA.AppBrandCenterInsideRuntimeFrameLayout", "AppBrandCenterInsideRuntimeFrameLayout: create");
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        b(view);
    }

    public final void b(View view) {
        if (this.f130649i != null && Math.abs(view.getScaleX() - this.f130649i.floatValue()) >= 0.01f) {
            view.setScaleX(this.f130649i.floatValue());
            view.setScaleY(this.f130649i.floatValue());
        }
    }

    public ViewGroup.LayoutParams getWxaLayoutParams() {
        return this.f130651k;
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        Integer num;
        if (this.f130648h != null && (num = this.f130647g) != null) {
            if (num.intValue() > 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(this.f130647g.intValue(), 1073741824);
            }
            if (this.f130648h.intValue() > 0) {
                i17 = View.MeasureSpec.makeMeasureSpec(this.f130648h.intValue(), 1073741824);
            }
        }
        super.measureChildWithMargins(view, i3, i16, i17, i18);
    }

    @Override // com.tencent.luggage.wxa.il.g, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int intValue;
        int i27;
        int i28;
        int i29;
        int i36;
        Integer num = this.f130647g;
        if (num == null && this.f130648h == null) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        if (num != null && this.f130648h != null) {
            i26 = ((i17 - i3) / 2) - (num.intValue() / 2);
            i19 = ((i18 - i16) / 2) - (this.f130648h.intValue() / 2);
        } else {
            i19 = 0;
            i26 = 0;
        }
        Integer num2 = this.f130650j;
        if (num2 == null) {
            intValue = 17;
        } else {
            intValue = num2.intValue();
        }
        int childCount = getChildCount();
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (intValue != 17) {
                    if (intValue != 80) {
                        i27 = i3 + measuredWidth;
                        w.h("Luggage.WXA.AppBrandCenterInsideRuntimeFrameLayout", "onLayout: unhandled gravity[%d], good luck~", Integer.valueOf(intValue));
                        i36 = i3;
                        i28 = i16 + measuredHeight;
                        i29 = i16;
                    } else {
                        i27 = i3 + measuredWidth;
                        i29 = i18 - measuredHeight;
                        i36 = i3;
                        i28 = i18;
                    }
                } else {
                    int i38 = i3 + i26;
                    int i39 = i16 + i19;
                    i27 = measuredWidth + i38;
                    i28 = measuredHeight + i39;
                    i29 = i39;
                    i36 = i38;
                }
                childAt.layout(i36, i29, i27, i28);
            }
        }
    }

    public void setWxaLayoutParams(com.tencent.luggage.wxa.wj.h hVar) {
        this.f130651k = hVar;
        this.f130647g = Integer.valueOf(((FrameLayout.LayoutParams) hVar).width);
        this.f130648h = Integer.valueOf(((FrameLayout.LayoutParams) hVar).height);
        this.f130649i = Float.valueOf(hVar.a());
        this.f130650j = Integer.valueOf(((FrameLayout.LayoutParams) hVar).gravity);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            b(getChildAt(i3));
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        super.addView(view, i3);
        b(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i16) {
        super.addView(view, i3, i16);
        b(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        b(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        b(view);
    }
}
