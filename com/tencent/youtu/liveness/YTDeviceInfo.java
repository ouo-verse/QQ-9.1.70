package com.tencent.youtu.liveness;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTDeviceInfo {
    static IPatchRedirector $redirector_;
    public String device_id;
    public String device_info_encrypted;
    public String platform;

    public YTDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
