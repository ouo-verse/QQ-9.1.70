package com.tencent.gamecenter.wadl.util;

/* loaded from: classes6.dex */
public class WadlProxyServiceUtil {
    public static String TAG = "Wadl_WadlProxyServiceUtil";
    private static WadlProxyServiceWrap mWadlProxyService;

    public static WadlProxyServiceWrap getProxyService() {
        if (mWadlProxyService == null) {
            synchronized (TAG) {
                if (mWadlProxyService == null) {
                    mWadlProxyService = new WadlProxyServiceWrap();
                }
            }
        }
        return mWadlProxyService;
    }

    public static void release() {
        WadlProxyServiceWrap wadlProxyServiceWrap = mWadlProxyService;
        if (wadlProxyServiceWrap != null) {
            wadlProxyServiceWrap.destroy();
            mWadlProxyService = null;
        }
    }
}
