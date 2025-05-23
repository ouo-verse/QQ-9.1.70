package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QZoneLayoutTemplate1 extends ViewGroup {
    static IPatchRedirector $redirector_;
    private ImageView C;

    /* renamed from: d, reason: collision with root package name */
    protected int f312986d;

    /* renamed from: e, reason: collision with root package name */
    protected int f312987e;

    /* renamed from: f, reason: collision with root package name */
    protected int f312988f;

    /* renamed from: h, reason: collision with root package name */
    protected int f312989h;

    /* renamed from: i, reason: collision with root package name */
    protected List<View> f312990i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f312991m;

    public QZoneLayoutTemplate1(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int a(float f16) {
        return (int) ((f16 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        super.addView(view);
        this.f312990i.add(view);
        int i3 = this.f312989h;
        view.setPadding(i3, i3, i3, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int i19 = this.f312986d / 3;
        if (this.f312990i.size() > 0) {
            this.f312990i.get(0).layout(0, 0, i19, i19);
        }
        if (this.f312990i.size() > 1) {
            View view = this.f312990i.get(1);
            int i26 = this.f312988f;
            int i27 = i19 * 2;
            view.layout(i19 + i26, 0, i26 + i27, i19);
            this.C.layout(i27 + (this.f312988f * 2), 0, this.f312986d, i19);
        }
        if (this.f312990i.size() > 2) {
            View view2 = this.f312990i.get(2);
            int i28 = this.f312986d;
            int i29 = this.f312988f;
            view2.layout((i28 - (i19 * 2)) - i29, i19 + i29, (i28 - i19) - i29, this.f312987e);
            ImageView imageView = this.f312991m;
            int i36 = this.f312988f;
            imageView.layout(0, i19 + i36, i19 - (i36 * 2), this.f312987e);
        }
        if (this.f312990i.size() > 3) {
            View view3 = this.f312990i.get(3);
            int i37 = this.f312986d;
            view3.layout(i37 - i19, i19 + this.f312988f, i37, this.f312987e);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        this.f312986d = size;
        int i17 = this.f312988f;
        this.f312987e = ((size * 2) / 3) + i17;
        int i18 = size / 3;
        int i19 = i18 * 2;
        this.C.measure(View.MeasureSpec.makeMeasureSpec((size - i19) - (i17 * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        this.f312991m.measure(View.MeasureSpec.makeMeasureSpec((this.f312986d - i19) - (this.f312988f * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        if (this.f312990i.size() > 0) {
            this.f312990i.get(0).measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        if (this.f312990i.size() > 1) {
            this.f312990i.get(1).measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        if (this.f312990i.size() > 2) {
            this.f312990i.get(2).measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        if (this.f312990i.size() > 3) {
            this.f312990i.get(3).measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        if (this.f312990i.size() > 2) {
            setMeasuredDimension(this.f312986d, this.f312987e);
        } else {
            setMeasuredDimension(this.f312986d, i18);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.removeAllViewsInLayout();
        super.addView(this.f312991m);
        super.addView(this.C);
        this.f312990i.clear();
    }

    public void setBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        Iterator<View> it = this.f312990i.iterator();
        while (it.hasNext()) {
            it.next().setBackgroundColor(i3);
        }
    }

    public void setBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f312989h = i3;
        }
    }

    public void setItemBg(Drawable drawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, i3);
            return;
        }
        for (View view : this.f312990i) {
            if (drawable != null) {
                view.setBackgroundDrawable(drawable);
            } else {
                view.setBackgroundColor(i3);
            }
        }
    }

    public void setLeftView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f312991m.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
        }
    }

    public void setRightView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.C.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
        }
    }

    public QZoneLayoutTemplate1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QZoneLayoutTemplate1(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        this.f312990i = new ArrayList();
        this.f312991m = new ImageView(context);
        this.C = new ImageView(context);
        this.f312991m.setImageDrawable(colorDrawable);
        this.C.setImageDrawable(colorDrawable);
        super.addView(this.f312991m);
        super.addView(this.C);
        this.f312988f = a(8.0f);
    }
}
