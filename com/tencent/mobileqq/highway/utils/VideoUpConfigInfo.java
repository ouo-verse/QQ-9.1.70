package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VideoUpConfigInfo {
    static IPatchRedirector $redirector_;
    public static volatile boolean sIsHardCodeEnable;
    public static volatile boolean sIsPreSendSignal;
    private static volatile boolean sIsUpdated;
    public static int sSwitch;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sSwitch = 1;
        sIsUpdated = false;
        sIsHardCodeEnable = true;
        sIsPreSendSignal = false;
    }

    public VideoUpConfigInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized boolean getIsUpdated() {
        boolean z16;
        synchronized (VideoUpConfigInfo.class) {
            z16 = sIsUpdated;
        }
        return z16;
    }

    public static synchronized boolean isPreUpload() {
        boolean z16;
        synchronized (VideoUpConfigInfo.class) {
            if (sSwitch == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public static synchronized void setIsUpdated() {
        synchronized (VideoUpConfigInfo.class) {
            sIsUpdated = true;
        }
    }

    public static synchronized void updateFromSrc(subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf shortVideoConf) {
        synchronized (VideoUpConfigInfo.class) {
            sIsUpdated = true;
            if (shortVideoConf == null) {
                return;
            }
            if (shortVideoConf.uint32_channel_type.has()) {
                sSwitch = shortVideoConf.uint32_channel_type.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "VideoUpConfigInfo.updateFromSrv: sSwitch = " + sSwitch);
            }
            if (shortVideoConf.bool_open_hardware_codec.has()) {
                sIsHardCodeEnable = shortVideoConf.bool_open_hardware_codec.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "VideoUpConfigInfo.updateFromSrv: sIsHardCodeEnable = " + sIsHardCodeEnable);
            }
            if (shortVideoConf.bool_send_ahead_signal.has()) {
                sIsPreSendSignal = shortVideoConf.bool_send_ahead_signal.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "VideoUpConfigInfo.updateFromSrv: sIsPreSendSignal = " + sIsPreSendSignal);
            }
        }
    }
}
