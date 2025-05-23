package com.tencent.superplayer.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

/* compiled from: P */
/* loaded from: classes26.dex */
public class NetworkUtil {
    private static final String TAG = "NetworkUtil";

    public static int getMobileSubType(int i3) {
        if (i3 != 20) {
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 0;
            }
        }
        return 5;
    }

    @SuppressLint({"MissingPermission"})
    public static int getNetWorkType() {
        NetworkInfo activeNetworkInfo;
        int mobileSubType;
        Context context = SuperPlayerSDKMgr.getContext();
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                mobileSubType = 1;
                if (type != 1) {
                    if (type != 9) {
                        return 0;
                    }
                    mobileSubType = 10;
                }
            } else {
                mobileSubType = getMobileSubType(NetworkMonitor.getSubtype(activeNetworkInfo));
            }
            return mobileSubType;
        } catch (Exception e16) {
            LogUtil.e("NetworkUtil", e16);
            return 0;
        }
    }

    public static boolean isWifiConnected() {
        if (getNetWorkType() == 1) {
            return true;
        }
        return false;
    }
}
