package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class LbsPackHorizontalListView extends HorizontalListView {
    static IPatchRedirector $redirector_;

    public LbsPackHorizontalListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.widget.HorizontalListView
    protected boolean checkScrollToChild() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.mStayDisplayOffsetZero || getChildAt(0) == null || (i3 = this.mNextX) == 0) {
            return false;
        }
        int measuredWidth = getChildAt(1).getMeasuredWidth();
        int i17 = i3 % measuredWidth;
        if (i17 <= measuredWidth * 0.5d) {
            i16 = i3 - i17;
        } else {
            i16 = (i3 - i17) + measuredWidth;
        }
        int i18 = i16;
        if (!this.mScroller.springBack(getScrollX() + this.mNextX, 0, i18, i18, 0, 0, 1000)) {
            return false;
        }
        invalidate();
        return true;
    }

    public LbsPackHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
