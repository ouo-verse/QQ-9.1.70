package com.tencent.mobileqq.highway.openup;

import android.content.Context;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class OpenUpConfig {
    static IPatchRedirector $redirector_;
    public static boolean isOpenUpEnable;
    public static int preSendDots_2g;
    public static int preSendDots_3g;
    public static int preSendDots_4g;
    public static int preSendDots_wifi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        isOpenUpEnable = false;
        preSendDots_2g = 2;
        preSendDots_3g = 2;
        preSendDots_4g = 2;
        preSendDots_wifi = 2;
    }

    public OpenUpConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized int getPreSendDots(Context context) {
        synchronized (OpenUpConfig.class) {
            int i3 = preSendDots_2g;
            if (context == null) {
                return i3;
            }
            int systemNetwork = HwNetworkUtil.getSystemNetwork(context);
            if (3 == systemNetwork) {
                i3 = preSendDots_3g;
            } else if (4 == systemNetwork) {
                i3 = preSendDots_4g;
            } else if (1 == systemNetwork) {
                i3 = preSendDots_wifi;
            }
            return i3;
        }
    }

    public static synchronized void updateFromSrv(subcmd0x501.SubCmd0x501Rspbody.OpenUpConf openUpConf) {
        synchronized (OpenUpConfig.class) {
            if (openUpConf == null) {
                return;
            }
            if (openUpConf.bool_enable_openup.has()) {
                isOpenUpEnable = openUpConf.bool_enable_openup.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "OpenUpConfig.updateFromSrv: isOpenUpEnable = " + isOpenUpEnable);
            }
            if (openUpConf.uint32_pre_send_segnum.has() && openUpConf.uint32_pre_send_segnum.get() >= 0) {
                preSendDots_2g = openUpConf.uint32_pre_send_segnum.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "OpenUpConfig.updateFromSrv: preSendDots_2g = " + preSendDots_2g);
            }
            if (openUpConf.uint32_pre_send_segnum_3g.has() && openUpConf.uint32_pre_send_segnum_3g.get() >= 0) {
                preSendDots_3g = openUpConf.uint32_pre_send_segnum_3g.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "OpenUpConfig.updateFromSrv: preSendDots_3g = " + preSendDots_3g);
            }
            if (openUpConf.uint32_pre_send_segnum_4g.has() && openUpConf.uint32_pre_send_segnum_4g.get() >= 0) {
                preSendDots_4g = openUpConf.uint32_pre_send_segnum_4g.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "OpenUpConfig.updateFromSrv: preSendDots_4g = " + preSendDots_4g);
            }
            if (openUpConf.uint32_pre_send_segnum_wifi.has() && openUpConf.uint32_pre_send_segnum_wifi.get() >= 0) {
                preSendDots_wifi = openUpConf.uint32_pre_send_segnum_wifi.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "OpenUpConfig.updateFromSrv: preSendDots_wifi = " + preSendDots_wifi);
            }
        }
    }
}
