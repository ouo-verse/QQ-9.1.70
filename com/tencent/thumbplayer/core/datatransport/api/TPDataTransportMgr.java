package com.tencent.thumbplayer.core.datatransport.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportFactory;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;

/* loaded from: classes26.dex */
public class TPDataTransportMgr {
    private static ITPDataTransportOfflineVinfoAdapter sOfflineVinfoAdapter;

    public static int checkFileCacheStatus(int i3, String str, int i16) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().checkFileCacheStatus(i3, str, i16);
    }

    public static String checkVideoStatus(String str, String str2) {
        ITPDataTransportOfflineVinfoAdapter iTPDataTransportOfflineVinfoAdapter = sOfflineVinfoAdapter;
        if (iTPDataTransportOfflineVinfoAdapter != null) {
            return iTPDataTransportOfflineVinfoAdapter.checkVideoStatus(str, str2);
        }
        return "";
    }

    public static boolean clearCache(int i3, String str, int i16) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().clearCache(i3, str, i16);
    }

    public static boolean clearRangeCache(int i3, String str, int i16, int i17) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().clearRangeCache(i3, str, i16, i17);
    }

    public static String getBizAccessibleNativeInfo(int i3, int i16) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getBizAccessibleNativeInfo(i3, i16);
    }

    public static long getFileCacheSize(int i3, String str) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getFileCacheSize(i3, str);
    }

    public static String getGlobalAccessibleNativeInfo(int i3) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getGlobalAccessibleNativeInfo(i3);
    }

    public static String getNativeLibVersion() {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getNativeLibVersion();
    }

    public static ITPDataTransportOfflineTaskMgr getOfflineTaskMgr() {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getOfflineTaskMgr();
    }

    public static ITPDataTransportPreloadTaskMgr getPreloadTaskMgr() {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getPreloadTaskMgr();
    }

    public static int getRecordDuration(String str, String str2) {
        ITPDataTransportOfflineVinfoAdapter iTPDataTransportOfflineVinfoAdapter = sOfflineVinfoAdapter;
        if (iTPDataTransportOfflineVinfoAdapter != null) {
            return iTPDataTransportOfflineVinfoAdapter.getRecordDuration(str, str2);
        }
        return -1;
    }

    public static ITPDataTransportTaskMgr getTaskMgr() {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().getTaskMgr();
    }

    public static boolean init(Context context) {
        TPDataTransportFactory.getInstance().init(context);
        return TPDataTransportFactory.getInstance().getDataTransportMgr().init(context);
    }

    public static boolean isNativeInit() {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().isNativeInit();
    }

    public static int registerBizId(@NonNull String str) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().registerBizId(str);
    }

    public static void registerCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener) {
        TPDataTransportFactory.getInstance().getDataTransportMgr().registerCommonInfoListener(iTPDataTransportCommonInfoListener);
    }

    public static void registerServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener) {
        TPDataTransportFactory.getInstance().getDataTransportMgr().registerServiceListener(iTPDataTransportServiceListener);
    }

    public static boolean setBizOptionalConfigParam(int i3, String str, String str2) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().setBizOptionalConfigParam(i3, str, str2);
    }

    public static boolean setGlobalOptionalConfigParam(String str, String str2) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().setGlobalOptionalConfigParam(str, str2);
    }

    public static void setLogListener(ITPDataTransportLogListener iTPDataTransportLogListener) {
        TPDataTransportLogFactory.getInstance().setLogListener(iTPDataTransportLogListener);
    }

    public static void setOfflineVinfoAdapter(ITPDataTransportOfflineVinfoAdapter iTPDataTransportOfflineVinfoAdapter) {
        sOfflineVinfoAdapter = iTPDataTransportOfflineVinfoAdapter;
    }

    public static void setThirdNativeLibLoader(ITPDataTransportNativeLibLoader iTPDataTransportNativeLibLoader) {
        TPDataTransportFactory.getInstance().getDataTransportMgr().setThirdNativeLibLoader(iTPDataTransportNativeLibLoader);
    }

    public static void setUseService(boolean z16) {
        TPDataTransportFactory.getInstance().setUseService(z16);
    }

    public static void startBindingService() {
        TPDataTransportFactory.getInstance().getDataTransportMgr().startBindingService();
    }

    public static void unregisterBizId(int i3) {
        TPDataTransportFactory.getInstance().getDataTransportMgr().unregisterBizId(i3);
    }

    public static void unregisterCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener) {
        TPDataTransportFactory.getInstance().getDataTransportMgr().unregisterCommonInfoListener(iTPDataTransportCommonInfoListener);
    }

    public static void unregisterServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener) {
        TPDataTransportFactory.getInstance().getDataTransportMgr().unregisterServiceListener(iTPDataTransportServiceListener);
    }

    public static int registerBizId(int i3, String str) {
        return TPDataTransportFactory.getInstance().getDataTransportMgr().registerBizId(i3, str);
    }
}
