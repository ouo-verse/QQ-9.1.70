package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessFadeIconImageView extends ImageView {
    static IPatchRedirector $redirector_;

    public ConfessFadeIconImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.drawableStateChanged();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (StateSet.stateSetMatches(ImageView.PRESSED_WINDOW_FOCUSED_STATE_SET, getDrawableState())) {
                drawable.setAlpha(125);
            } else {
                drawable.setAlpha(255);
            }
        }
    }

    public ConfessFadeIconImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }
}
