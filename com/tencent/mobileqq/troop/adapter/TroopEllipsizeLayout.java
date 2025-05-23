package com.tencent.mobileqq.troop.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.SingleLineTextView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopEllipsizeLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    public TroopEllipsizeLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        SingleLineTextView singleLineTextView;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (getOrientation() == 0 && View.MeasureSpec.getMode(i3) == 1073741824) {
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i3);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
            SingleLineTextView singleLineTextView2 = null;
            boolean z19 = false;
            int i18 = 0;
            for (int i19 = 0; i19 < childCount && !z19; i19++) {
                View childAt = getChildAt(i19);
                if (childAt != null && childAt.getVisibility() != 8) {
                    if (childAt instanceof SingleLineTextView) {
                        SingleLineTextView singleLineTextView3 = (SingleLineTextView) childAt;
                        if (singleLineTextView2 == null) {
                            singleLineTextView3.setMaxWidth(Integer.MAX_VALUE);
                            z16 = z19;
                            singleLineTextView = singleLineTextView3;
                        } else {
                            singleLineTextView = singleLineTextView2;
                            z16 = true;
                        }
                    } else {
                        singleLineTextView = singleLineTextView2;
                        z16 = z19;
                    }
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i16, 0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    if (layoutParams != null) {
                        if (layoutParams.weight > 0.0f) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z19 = z16 | z17;
                        i18 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        z19 = true;
                    }
                    singleLineTextView2 = singleLineTextView;
                }
            }
            if (singleLineTextView2 != null && i18 != 0) {
                z18 = false;
            }
            if (!(z19 | z18) && i18 > size) {
                int measuredWidth = singleLineTextView2.getMeasuredWidth() - (i18 - size);
                if (measuredWidth >= 0) {
                    i17 = measuredWidth;
                }
                singleLineTextView2.setMaxWidth(i17);
            }
        }
        super.onMeasure(i3, i16);
    }

    public TroopEllipsizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
