package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class VerticalAbsSpinner extends AbsSpinner {
    static IPatchRedirector $redirector_;
    Interpolator mInterpolator;
    View mSelectedView;

    public VerticalAbsSpinner(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mSelectedView = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.widget.AbsSpinner, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.tencent.widget.AbsSpinner, com.tencent.widget.AdapterView
    public View getSelectedView() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mItemCount > 0 && (i3 = this.mSelectedPosition) >= 0) {
            if (Math.abs(i3 - this.mFirstPosition) > getChildCount()) {
                int i16 = (this.mSelectedPosition + this.mItemCount) - this.mFirstPosition;
                View childAt = getChildAt(i16);
                if (childAt != null) {
                    childAt.setTag(String.valueOf(i16));
                }
                return childAt;
            }
            int i17 = this.mSelectedPosition - this.mFirstPosition;
            View childAt2 = getChildAt(i17);
            if (childAt2 != null) {
                childAt2.setTag(String.valueOf(i17));
            }
            return childAt2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.widget.AdapterView
    public void handleDataChanged() {
        super.handleDataChanged();
    }

    @Override // com.tencent.widget.AbsSpinner
    public void setSelection(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            super.setSelection(i3, z16);
            checkSelectionChanged();
        }
    }

    public VerticalAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.widget.AbsSpinner, com.tencent.widget.AdapterView
    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            super.setSelection(i3);
            checkSelectionChanged();
        }
    }

    public VerticalAbsSpinner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mSelectedView = null;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
