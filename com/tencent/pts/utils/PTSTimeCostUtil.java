package com.tencent.pts.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* loaded from: classes22.dex */
public class PTSTimeCostUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSTimeCostUtil";
    private static HashMap<String, Long> sTimeCostMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sTimeCostMap = new HashMap<>();
        }
    }

    PTSTimeCostUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void end(String str) {
        Long l3 = sTimeCostMap.get(str);
        if (l3 != null) {
            System.currentTimeMillis();
            l3.longValue();
        }
    }

    public static void start(String str) {
        sTimeCostMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
