package com.tencent.mobileqq.addfriend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlowLabelLayout extends ViewGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final int f187611e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f187612f;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f187613d;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f187614a;

        /* renamed from: b, reason: collision with root package name */
        int f187615b;

        /* renamed from: c, reason: collision with root package name */
        List<View> f187616c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlowLabelLayout.this);
            } else {
                this.f187616c = new ArrayList();
            }
        }

        public void a(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            this.f187616c.add(view);
            this.f187614a += view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = this.f187615b;
            if (i3 >= measuredHeight) {
                measuredHeight = i3;
            }
            this.f187615b = measuredHeight;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f187616c.size();
        }

        public void c(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            int b16 = b();
            if ((((FlowLabelLayout.this.getMeasuredWidth() - FlowLabelLayout.this.getPaddingLeft()) - FlowLabelLayout.this.getPaddingRight()) - this.f187614a) - (FlowLabelLayout.f187612f * (b16 - 1)) >= 0) {
                for (int i17 = 0; i17 < b16; i17++) {
                    View view = this.f187616c.get(i17);
                    int measuredWidth = view.getMeasuredWidth();
                    view.layout(i3, i16, i3 + measuredWidth, this.f187615b + i16);
                    i3 += measuredWidth + FlowLabelLayout.f187611e;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f187611e = ViewUtils.dpToPx(6.0f);
            f187612f = ViewUtils.dpToPx(6.0f);
        }
    }

    public FlowLabelLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (z16) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size = this.f187613d.size();
            for (int i19 = 0; i19 < size; i19++) {
                a aVar = this.f187613d.get(i19);
                aVar.c(paddingLeft, paddingTop);
                paddingTop += aVar.f187615b + f187611e;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int size;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size2 = View.MeasureSpec.getSize(i3);
        int size3 = (View.MeasureSpec.getSize(i3) - getPaddingRight()) - getPaddingLeft();
        int size4 = (View.MeasureSpec.getSize(i16) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        this.f187613d = new ArrayList();
        a aVar = new a();
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            int i27 = Integer.MIN_VALUE;
            if (mode == 1073741824) {
                i18 = Integer.MIN_VALUE;
            } else {
                i18 = mode;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, i18);
            if (mode2 != 1073741824) {
                i27 = mode2;
            }
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size4, i27);
            if (childAt != null) {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                i19 += childAt.getMeasuredWidth();
                if (i19 < size3) {
                    aVar.a(childAt);
                    i19 += f187612f;
                }
                if (i19 > size3) {
                    if (this.f187613d.size() >= 2) {
                        break;
                    }
                    this.f187613d.add(aVar);
                    aVar = new a();
                    i19 = 0;
                } else {
                    continue;
                }
            }
        }
        this.f187613d.add(aVar);
        List<a> list = this.f187613d;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        int i28 = 0;
        for (int i29 = 0; i29 < size; i29++) {
            if (this.f187613d.get(i29) == null) {
                i17 = 0;
            } else {
                i17 = this.f187613d.get(i29).f187615b;
            }
            i28 += i17;
        }
        setMeasuredDimension(size2, View.resolveSize(i28 + (f187611e * (size - 1)), i16));
    }

    public FlowLabelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FlowLabelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
