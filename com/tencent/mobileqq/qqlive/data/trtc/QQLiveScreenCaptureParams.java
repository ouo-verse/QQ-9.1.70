package com.tencent.mobileqq.qqlive.data.trtc;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class QQLiveScreenCaptureParams {
    static IPatchRedirector $redirector_;
    private View mFloatingView;

    public QQLiveScreenCaptureParams(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            this.mFloatingView = view;
        }
    }

    public View getFloatingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mFloatingView;
    }
}
