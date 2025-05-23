package com.tencent.mobileqq.mini.util;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HttpUtil {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    interface NetType {
        public static final int CABLE = 5;
        public static final int G2 = 2;
        public static final int G3 = 3;
        public static final int G4 = 4;
        public static final int NONE = 0;
        public static final int WIFI = 1;
    }

    public static int getNetWorkType() {
        int mobileInfo;
        int i3 = 0;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn() && (mobileInfo = AppNetConnInfo.getMobileInfo()) != -1) {
            i3 = 2;
            if (mobileInfo != 0 && mobileInfo != 1) {
                if (mobileInfo != 2) {
                    return mobileInfo != 3 ? -1 : 4;
                }
                return 3;
            }
        }
        return i3;
    }
}
