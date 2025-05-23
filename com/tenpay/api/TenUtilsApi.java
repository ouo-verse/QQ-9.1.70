package com.tenpay.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenUtilsApi {
    private static final String PROTOCAL_HTTP = "http";
    private static final String PROTOCAL_HTTPS = "https";
    private static final String TAG = "TenUtilsApi";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x003d. Please report as an issue. */
    public static String getNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            if (NetworkMonitor.getType(networkInfo) == 1) {
                return Global.TRACKING_WIFI;
            }
            if (NetworkMonitor.getType(networkInfo) == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                switch (NetworkMonitor.getSubtype(networkInfo)) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return subtypeName;
                        }
                        return "3G";
                }
            }
        }
        return "";
    }
}
