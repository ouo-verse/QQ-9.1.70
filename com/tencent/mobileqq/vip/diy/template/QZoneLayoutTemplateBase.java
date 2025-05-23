package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QZoneLayoutTemplateBase extends ViewGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected int f312992d;

    /* renamed from: e, reason: collision with root package name */
    protected int f312993e;

    /* renamed from: f, reason: collision with root package name */
    protected int f312994f;

    /* renamed from: h, reason: collision with root package name */
    protected int f312995h;

    /* renamed from: i, reason: collision with root package name */
    protected int f312996i;

    /* renamed from: m, reason: collision with root package name */
    protected Drawable f312997m;

    public QZoneLayoutTemplateBase(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        super.addView(view);
        int i3 = this.f312995h;
        view.setPadding(i3, i3, i3, i3);
        Drawable drawable = this.f312997m;
        if (drawable != null) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackgroundColor(this.f312996i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            View childAt = getChildAt(0);
            int i19 = this.f312993e;
            childAt.layout(0, 0, i19, i19);
        }
        if (childCount > 1) {
            View childAt2 = getChildAt(1);
            int i26 = this.f312993e;
            int i27 = this.f312994f;
            childAt2.layout(i26 + i27, 0, (i26 * 2) + i27, i26);
        }
        if (childCount > 2) {
            View childAt3 = getChildAt(2);
            int i28 = this.f312993e;
            int i29 = this.f312994f;
            childAt3.layout((i28 * 2) + (i29 * 2), 0, (i28 * 3) + (i29 * 2), i28);
        }
        if (childCount > 3) {
            View childAt4 = getChildAt(3);
            int i36 = this.f312993e;
            childAt4.layout((i36 * 3) + (this.f312994f * 3), 0, this.f312992d, i36);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        this.f312992d = size;
        this.f312993e = (size - (this.f312994f * 3)) / 4;
        int childCount = getChildCount();
        if (childCount > 0) {
            getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824));
        }
        if (childCount > 1) {
            getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824));
        }
        if (childCount > 2) {
            getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824));
        }
        if (childCount > 3) {
            getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f312993e, 1073741824));
        }
        setMeasuredDimension(this.f312992d, this.f312993e);
    }

    public void setBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f312996i = i3;
        }
    }

    public void setBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f312995h = i3;
        }
    }

    public void setItemBg(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
        } else {
            this.f312997m = drawable;
        }
    }

    public QZoneLayoutTemplateBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QZoneLayoutTemplateBase(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f312996i = -16777216;
            this.f312994f = UIUtils.b(context, 5.0f);
        }
    }
}
