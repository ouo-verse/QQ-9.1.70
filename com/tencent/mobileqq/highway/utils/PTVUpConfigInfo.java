package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes9.dex */
public class PTVUpConfigInfo {
    static IPatchRedirector $redirector_;
    public static volatile boolean sIsHardCodeEnable;
    private static volatile boolean sIsUpdated;
    public static int sSwitch;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16681);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sSwitch = 1;
        sIsUpdated = false;
        sIsHardCodeEnable = true;
    }

    public PTVUpConfigInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized boolean getIsUpdated() {
        boolean z16;
        synchronized (PTVUpConfigInfo.class) {
            z16 = sIsUpdated;
        }
        return z16;
    }

    public static synchronized boolean isPreUpload() {
        boolean z16;
        synchronized (PTVUpConfigInfo.class) {
            if (sSwitch == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public static synchronized void setIsUpdated() {
        synchronized (PTVUpConfigInfo.class) {
            sIsUpdated = true;
        }
    }

    public static synchronized void updateFromSrc(subcmd0x501.SubCmd0x501Rspbody.PTVConf pTVConf) {
        synchronized (PTVUpConfigInfo.class) {
            sIsUpdated = true;
            if (pTVConf == null) {
                return;
            }
            if (pTVConf.uint32_channel_type.has()) {
                sSwitch = pTVConf.uint32_channel_type.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "PTVUpConfigInfo.updateFromSrv: sSwitch = " + sSwitch);
            }
            if (pTVConf.bool_open_hardware_codec.has()) {
                sIsHardCodeEnable = pTVConf.bool_open_hardware_codec.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "PTVUpConfigInfo.updateFromSrv: sIsHardCodeEnable = " + sIsHardCodeEnable);
            }
        }
    }
}
