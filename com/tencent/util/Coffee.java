package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.SoInfo;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Coffee {
    static IPatchRedirector $redirector_;

    public Coffee() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @SoInfo(libName = "image_filter_common")
    private static native String getDESSignKey();

    public static String getSignkey() {
        try {
            return getDESSignKey();
        } catch (UnsatisfiedLinkError e16) {
            LogUtils.e(e16);
            return BaseQmcfProcessor.LINK_ERROR;
        }
    }
}
