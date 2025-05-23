package com.tencent.mars.mmdns;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMDnsLogic {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "mars.MMDnsLogic";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IPStackSelection {
        public static final int kSelectAll = 3;
        public static final int kSelectAuto = 0;
        public static final int kSelectIPv4 = 1;
        public static final int kSelectIPv6 = 2;
    }

    public MMDnsLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native ArrayList<String> getHost(String str);

    public static native ArrayList<String> getHostWithParam(String str, int i3, boolean z16, int i16);

    public static native void setDebugIP(String str, int i3);

    public static native void setForceUserIPv6(boolean z16);
}
