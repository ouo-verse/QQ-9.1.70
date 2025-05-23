package com.tencent.relation.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FlowLayoutContainer extends ViewGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f364773d;

    /* renamed from: e, reason: collision with root package name */
    private int f364774e;

    /* renamed from: f, reason: collision with root package name */
    private int f364775f;

    /* renamed from: h, reason: collision with root package name */
    private View f364776h;

    /* renamed from: i, reason: collision with root package name */
    private int f364777i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f364778m;

    public FlowLayoutContainer(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 <= this.f364777i; i27++) {
            View childAt = getChildAt(i27);
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth - i19 < this.f364774e + measuredWidth2) {
                i26 = i26 + measuredHeight + this.f364773d;
                i19 = 0;
            }
            int i28 = measuredWidth2 + i19;
            childAt.layout(i19, i26, i28, measuredHeight + i26);
            i19 = this.f364774e + i28;
        }
        if (this.f364778m && (view = this.f364776h) != null) {
            this.f364776h.layout(i19, i26, view.getMeasuredWidth() + i19, this.f364776h.getMeasuredHeight() + i26);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        if (getChildCount() <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        if (this.f364776h == null) {
            i17 = 0;
        } else {
            i17 = 1;
        }
        int i19 = childCount - i17;
        this.f364777i = i19 - 1;
        this.f364778m = false;
        int i26 = 0;
        int i27 = 0;
        int i28 = 1;
        while (true) {
            if (i18 >= i19) {
                break;
            }
            View childAt = getChildAt(i18);
            measureChild(childAt, i3, i16);
            i26 = Math.max(i26, childAt.getMeasuredHeight());
            int measuredWidth = childAt.getMeasuredWidth();
            int i29 = size - i27;
            int i36 = this.f364774e;
            if (i29 < i36 + measuredWidth) {
                i28++;
                int i37 = this.f364775f;
                if (i28 > i37 && (view = this.f364776h) != null) {
                    measureChild(view, i3, i16);
                    int measuredWidth2 = this.f364776h.getMeasuredWidth();
                    if (measuredWidth2 <= size) {
                        this.f364778m = true;
                        this.f364777i = i18 - 1;
                        while (true) {
                            int i38 = this.f364777i;
                            if (i38 < 0) {
                                break;
                            }
                            int measuredWidth3 = getChildAt(i38).getMeasuredWidth();
                            int i39 = size - i27;
                            int i46 = this.f364774e;
                            if (i39 >= measuredWidth2 + i46) {
                                break;
                            }
                            i27 = (i27 - measuredWidth3) - i46;
                            this.f364777i--;
                        }
                    }
                    i28 = i37;
                } else {
                    i27 = measuredWidth;
                }
            } else {
                i27 = i27 + measuredWidth + i36;
            }
            i18++;
        }
        setMeasuredDimension(size, (i26 * i28) + ((i28 - 1) * this.f364773d));
    }

    public void setAndAddEndView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        this.f364776h = view;
        if (view == null) {
            return;
        }
        addView(view);
    }

    public void setMargin(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 < 0) {
            i16 = this.f364774e;
        }
        this.f364774e = i16;
        this.f364773d = i3;
    }

    public void setMaxLine(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f364775f = i3;
        }
    }

    public FlowLayoutContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FlowLayoutContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f364775f = Integer.MAX_VALUE;
            this.f364778m = false;
        }
    }
}
