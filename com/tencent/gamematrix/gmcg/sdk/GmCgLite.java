package com.tencent.gamematrix.gmcg.sdk;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gamematrix.gmcg.api.GmCgSdkNetworkChangeListener;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.impl.CGNetworkChangeObserver;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgLite {
    private static final String TAG = "GmCgLite";
    private static GmCgSdkNetworkChangeListener gmCgSdkNetworkChangeListener;

    public static int getNetWorkStatusType() {
        if (CGNetworkChangeObserver.mGmCgActivityNetWorkType == 0 && CGGlbConfig.getAppContext() != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) CGGlbConfig.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type != 0) {
                    if (type != 1) {
                        CGLog.i(TAG + ",switch to unknow net");
                        return 0;
                    }
                    CGLog.i(TAG + ",switch to network wifi");
                    return 1;
                }
                CGLog.i(TAG + ",switch to network mobile");
                return 2;
            }
            return 3;
        }
        return CGNetworkChangeObserver.mGmCgActivityNetWorkType;
    }

    public static void refreshNetworkStatusType() {
        GmCgSdkNetworkChangeListener gmCgSdkNetworkChangeListener2 = gmCgSdkNetworkChangeListener;
        if (gmCgSdkNetworkChangeListener2 != null) {
            gmCgSdkNetworkChangeListener2.onNetworkTypeChange(getNetWorkStatusType());
        }
    }

    public static void setNetWorkStatusChangeListener(GmCgSdkNetworkChangeListener gmCgSdkNetworkChangeListener2) {
        gmCgSdkNetworkChangeListener = gmCgSdkNetworkChangeListener2;
        CGNetworkChangeObserver.get().setNetworkTypeListener(gmCgSdkNetworkChangeListener2);
    }
}
