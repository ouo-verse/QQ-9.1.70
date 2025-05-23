package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

/* loaded from: classes26.dex */
public class TPDownloadProxyHelper {
    private static final String FILE_NAME = "TPDownloadProxyHelper";
    private static Context applicationContext;
    private static ITPOfflineVinfoAdapter offlineVinfoAdapter;

    public static String checkVideoStatus(String str, String str2) {
        ITPOfflineVinfoAdapter iTPOfflineVinfoAdapter;
        if (!TPDownloadProxyFactory.canUseService() || (iTPOfflineVinfoAdapter = offlineVinfoAdapter) == null) {
            return "";
        }
        return iTPOfflineVinfoAdapter.checkVideoStatus(str, str2);
    }

    public static boolean downloadProxyUploadEnable(boolean z16) {
        int i3;
        if (z16) {
            i3 = 26;
        } else {
            i3 = 27;
        }
        return TPDownloadProxyFactory.pushEvent(i3);
    }

    public static Context getContext() {
        return applicationContext;
    }

    public static String getHLSOfflineExttag(String str, String str2, int i3, long j3) {
        try {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(str, str2, i3, j3));
            }
            return "";
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get exttag failed, error:" + th5);
            return "";
        }
    }

    public static String getNativeInfo(int i3) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getNativeInfo(i3));
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th5);
                return null;
            }
        }
        return null;
    }

    public static String getNativeLibVersion() {
        return TPDownloadProxyFactory.getNativeVersion();
    }

    public static int getRecordDuration(String str, String str2) {
        ITPOfflineVinfoAdapter iTPOfflineVinfoAdapter = offlineVinfoAdapter;
        if (iTPOfflineVinfoAdapter != null) {
            return iTPOfflineVinfoAdapter.getRecordDuration(str, str2);
        }
        return -1;
    }

    public static boolean isReadyForPlay() {
        return TPDownloadProxyFactory.isReadyForPlay();
    }

    public static void setContext(Context context) {
        applicationContext = context;
        TPDownloadProxyNative.getInstance().setAppContext(context);
    }

    public static void setNativeLibLoader(ITPDLProxyNativeLibLoader iTPDLProxyNativeLibLoader) {
        TPDownloadProxyNative.getInstance().setLibLoader(iTPDLProxyNativeLibLoader);
    }

    public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter iTPOfflineVinfoAdapter) {
        offlineVinfoAdapter = iTPOfflineVinfoAdapter;
    }

    public static void setUseService(boolean z16) {
        TPDownloadProxyFactory.setUseService(z16);
    }

    public static void setUserData(String str, Object obj) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setUserData(str, obj.toString());
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th5);
            }
        }
    }

    public static long verifyOfflineCacheSync(String str, int i3, String str2, String str3) {
        try {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                return TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(str, i3, str2, str3);
            }
            return -1L;
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "verify offline cache failed, error:" + th5);
            return -1L;
        }
    }

    public static void setTPProxyAdapter(ITPProxyAdapter iTPProxyAdapter) {
    }
}
