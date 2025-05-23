package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class NtrtcCommonParam {
    static IPatchRedirector $redirector_;
    public String avDebugConfig;
    public String configFromQqmc;
    public String dataDir;
    public String flowCtrlConfigDir;
    public boolean isPadForMultiDeviceLogin;
    public String libDir;
    public String logDir;
    public String logFilePrefix;

    public NtrtcCommonParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
