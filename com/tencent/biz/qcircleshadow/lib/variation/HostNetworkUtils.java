package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostNetworkUtils {
    public static int getConnRetryTimes(int i3) {
        return NetworkUtil.getConnRetryTimes(i3);
    }

    public static boolean is4G() {
        if (AppNetConnInfo.getMobileInfo() == 3) {
            return true;
        }
        return false;
    }

    public static boolean is5G() {
        if (AppNetConnInfo.getMobileInfo() == 4) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkAvailable() {
        return NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ);
    }

    public static boolean isWifi() {
        return NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ);
    }
}
