package com.tencent.thumbplayer.common;

import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;

/* loaded from: classes26.dex */
public class TPVersion {
    private static final boolean IS_OTT = false;
    private static final String VERSION = "3.0.0.1206";

    public static String getDataTransportVersion() {
        return TPDataTransportMgr.getNativeLibVersion();
    }

    public static String getSelfDevPlayerVersion() {
        try {
            return native_getLibVersion();
        } catch (UnsatisfiedLinkError unused) {
            TPLogUtil.e("", "failed to get native lib version");
            return "";
        }
    }

    public static String getVersion() {
        return VERSION;
    }

    public static boolean isOTT() {
        return false;
    }

    private static native String native_getLibVersion();
}
