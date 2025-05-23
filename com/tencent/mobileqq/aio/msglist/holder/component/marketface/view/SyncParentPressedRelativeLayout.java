package com.tencent.mobileqq.aio.msglist.holder.component.marketface.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class SyncParentPressedRelativeLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    public SyncParentPressedRelativeLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (isPressed() == z16) {
            return;
        }
        View view = (View) getParent();
        if (view != null && (view instanceof BreathAnimationLayout) && view.isPressed() != z16) {
            view.setPressed(z16);
        }
        super.setPressed(z16);
    }
}
