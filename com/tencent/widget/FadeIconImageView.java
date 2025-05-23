package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FadeIconImageView extends ImageView {
    static IPatchRedirector $redirector_;
    private ISetVisibilityHandler setVisibilityHandler;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ISetVisibilityHandler {
        boolean onSetVisibility(int i3);
    }

    public FadeIconImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.setVisibilityHandler = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
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
                drawable.setAlpha(66);
            } else {
                drawable.setAlpha(255);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        ISetVisibilityHandler iSetVisibilityHandler = this.setVisibilityHandler;
        if (iSetVisibilityHandler == null || !iSetVisibilityHandler.onSetVisibility(i3)) {
            super.setVisibility(i3);
        }
    }

    public void setVisibilityHandler(ISetVisibilityHandler iSetVisibilityHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iSetVisibilityHandler);
        } else {
            this.setVisibilityHandler = iSetVisibilityHandler;
        }
    }

    public FadeIconImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.setVisibilityHandler = null;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }
}
