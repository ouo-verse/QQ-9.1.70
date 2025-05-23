package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ResizeURLImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    public ResizeURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        int screenHeight;
        int paddingBottom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (getContext().getResources().getConfiguration().orientation == 1) {
            screenHeight = ViewUtils.getScreenWidth() - getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            screenHeight = ViewUtils.getScreenHeight() - getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(screenHeight - paddingBottom, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
