package com.tencent.mobileqq.soso.location;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class LbsManagerServiceOnLocationChangeListener {
    static IPatchRedirector $redirector_;
    public String businessId;
    public boolean observerOnUiThread;

    public LbsManagerServiceOnLocationChangeListener(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.businessId = str;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public void onConsecutiveFailure(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
    }

    public abstract void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo);

    public void onStatusUpdate(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
        }
    }

    public LbsManagerServiceOnLocationChangeListener(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            this.businessId = str;
            this.observerOnUiThread = z16;
        }
    }
}
