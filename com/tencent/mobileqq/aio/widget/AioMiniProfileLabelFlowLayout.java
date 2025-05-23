package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes11.dex */
public class AioMiniProfileLabelFlowLayout extends FlowLayout {
    static IPatchRedirector $redirector_;

    public AioMiniProfileLabelFlowLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.aio.widget.TagFlowLayout
    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < this.f194222d.getCount() && i3 < childCount) {
            this.f194222d.getView(i3, getChildAt(i3), this);
            i3++;
        }
        if (childCount > this.f194222d.getCount()) {
            removeViews(i3, childCount - this.f194222d.getCount());
        }
        if (childCount < this.f194222d.getCount()) {
            while (i3 < this.f194222d.getCount()) {
                addView(this.f194222d.getView(i3, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
                i3++;
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.widget.FlowLayout, com.tencent.mobileqq.aio.widget.TagFlowLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int width = getWidth();
        int childCount = getChildCount();
        int i27 = 1;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        while (i28 < childCount) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i27 == i26) {
                    i19 = width - ViewUtils.dip2px(90.0f);
                } else {
                    i19 = width;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i38 = marginLayoutParams.leftMargin;
                if (i29 + i38 + measuredWidth + marginLayoutParams.rightMargin > i19) {
                    i36 += i37;
                    i27++;
                    i29 = 0;
                }
                int i39 = marginLayoutParams.topMargin;
                i37 = i39 + measuredHeight + marginLayoutParams.bottomMargin;
                int i46 = i38 + i29;
                int i47 = i39 + i36;
                childAt.layout(i46, i47, i46 + measuredWidth, measuredHeight + i47);
                i29 += marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
            }
            i28++;
            i26 = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.widget.TagFlowLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i26 = 1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        while (true) {
            if (i19 < childCount) {
                View childAt = getChildAt(i19);
                if (childAt.getVisibility() == 8) {
                    i17 = size;
                    c16 = 2;
                } else {
                    measureChild(childAt, i3, i16);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    int i37 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    int i38 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    if (i26 == 1) {
                        i18 = size - ViewUtils.dip2px(90.0f);
                        i17 = size;
                    } else {
                        i18 = size;
                        i17 = i18;
                    }
                    int i39 = i27 + i37;
                    if (i39 > i18) {
                        i26++;
                        c16 = 2;
                        if (i26 > 2) {
                            i36 = Math.max(i27, i37);
                            i29 += i28;
                            break;
                        } else {
                            i36 = Math.max(i27, i37);
                            i29 += i38;
                        }
                    } else {
                        c16 = 2;
                        i38 = Math.max(i28, i38);
                        i37 = i39;
                    }
                    if (i19 == childCount - 1) {
                        i29 += i38;
                        i36 = Math.max(i37, i36);
                    }
                    i28 = i38;
                    i27 = i37;
                }
                i19++;
                size = i17;
            } else {
                i17 = size;
                break;
            }
        }
        if (mode == 1073741824) {
            i36 = i17;
        }
        if (mode2 != 1073741824) {
            size2 = i29;
        }
        setMeasuredDimension(i36, size2);
    }

    public AioMiniProfileLabelFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AioMiniProfileLabelFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
