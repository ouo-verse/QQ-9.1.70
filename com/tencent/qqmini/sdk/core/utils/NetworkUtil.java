package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NetworkUtil {
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final int NETWORK_TYPE_NR = 20;
    public static final String TAG = "NetworkUtil";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class NetType {
        public static final int CABLE = 5;
        public static final int G2 = 2;
        public static final int G3 = 3;
        public static final int G4 = 4;
        public static final int G5 = 6;
        public static final int NONE = 0;
        public static final int WIFI = 1;
    }

    public static int getActiveNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 0;
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th5) {
            QMLog.e(TAG, "fail to get active network info", th5);
            return 0;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        int type = NetworkMonitor.getType(activeNetworkInfo);
        if (type != 9) {
            switch (type) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    return getMobileNetworkType(NetworkMonitor.getSubtype(activeNetworkInfo));
                case 1:
                case 6:
                    return 1;
                default:
                    return 0;
            }
            QMLog.e(TAG, "fail to get active network info", th5);
            return 0;
        }
        return 5;
    }

    private static int getMobileNetworkType(int i3) {
        switch (i3) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 4:
            case 7:
            case 11:
            case 16:
            default:
                return 2;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 6;
        }
    }

    public static String getNetWorkTypeByStr(Context context) {
        switch (getActiveNetworkType(context)) {
            case -1:
            default:
                return "UNKNOWN";
            case 0:
                return "NONE";
            case 1:
                return Global.TRACKING_WIFI;
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "CABLE";
            case 6:
                return "5G";
        }
    }
}
