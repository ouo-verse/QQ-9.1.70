package com.tencent.mobileqq.leba.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaTableLayout extends ViewGroup {
    static IPatchRedirector $redirector_;
    public int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    public int f240824d;

    /* renamed from: e, reason: collision with root package name */
    public int f240825e;

    /* renamed from: f, reason: collision with root package name */
    public int f240826f;

    /* renamed from: h, reason: collision with root package name */
    public int f240827h;

    /* renamed from: i, reason: collision with root package name */
    public int f240828i;

    /* renamed from: m, reason: collision with root package name */
    public int f240829m;

    public LebaTableLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.C = 3;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0 && this.C != 0) {
            int i26 = this.f240828i;
            int i27 = this.f240826f;
            while (i19 < childCount) {
                View childAt = getChildAt(i19);
                int i28 = this.D;
                childAt.layout(i26, i27, i26 + i28, i27 + i28);
                i26 += this.f240824d + i28;
                i19++;
                if (i19 % this.C == 0) {
                    i26 = this.f240828i;
                    i27 += i28 + this.f240825e;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int childCount = getChildCount();
        if (childCount > 0 && this.C != 0) {
            int size = View.MeasureSpec.getSize(i3);
            int i18 = (size - this.f240828i) - this.f240829m;
            int i19 = this.f240824d;
            int i26 = this.C;
            int i27 = (i18 - (i19 * (i26 - 1))) / i26;
            this.D = i27;
            for (int i28 = 0; i28 < childCount; i28++) {
                measureChild(getChildAt(i28), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(i27, 1073741824));
            }
            int i29 = this.C;
            if (childCount % i29 == 0) {
                i17 = childCount / i29;
            } else {
                i17 = (childCount / i29) + 1;
            }
            setMeasuredDimension(size, (i27 * i17) + (this.f240825e * ((childCount - 1) / i29)) + this.f240826f + this.f240827h);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public LebaTableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.C = 3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public LebaTableLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.C = 3;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
