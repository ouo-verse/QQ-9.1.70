package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes19.dex */
public class NetworkCenter {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "NetworkCenter";
    public static NetworkCenter sNC;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sNC = null;
        }
    }

    public NetworkCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static NetworkCenter getInstance() {
        if (sNC == null) {
            synchronized (NetworkCenter.class) {
                if (sNC == null) {
                    sNC = new NetworkCenter();
                }
            }
        }
        return sNC;
    }

    public synchronized String getApnType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return AppNetConnInfo.getCurrentAPN();
    }

    public int getNetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    }
}
