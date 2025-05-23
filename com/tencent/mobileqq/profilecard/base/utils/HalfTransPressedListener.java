package com.tencent.mobileqq.profilecard.base.utils;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class HalfTransPressedListener implements View.OnTouchListener {
    static IPatchRedirector $redirector_ = null;
    private static final float ALPHA_NORMAL = 1.0f;
    private static final float ALPHA_PRESSED = 0.5f;

    public HalfTransPressedListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }
}
