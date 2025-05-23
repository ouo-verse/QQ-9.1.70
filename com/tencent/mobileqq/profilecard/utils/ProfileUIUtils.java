package com.tencent.mobileqq.profilecard.utils;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileUIUtils {
    static IPatchRedirector $redirector_;
    public static final ViewAlphaOnTouchListener ALPHA_TOUCH_LISTENER;

    /* loaded from: classes16.dex */
    public static class ViewAlphaOnTouchListener implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        public ViewAlphaOnTouchListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41992);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ALPHA_TOUCH_LISTENER = new ViewAlphaOnTouchListener();
        }
    }

    public ProfileUIUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void notifyUser(int i3, int i16) {
        notifyUser(i3, MobileQQ.sMobileQQ.getApplicationContext().getString(i16));
    }

    public static void notifyUser(int i3, String str) {
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), i3, str, 0).show();
    }
}
