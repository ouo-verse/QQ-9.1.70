package com.dataline.util;

import android.net.wifi.WifiManager;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {
    public static long a() {
        if (!((WifiManager) BaseApplication.getContext().getSystemService("wifi")).isWifiEnabled()) {
            return 0L;
        }
        try {
            return NetworkMonitor.getIpAddress(LocationMonitor.getConnectionInfo(r0));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static String b(long j3) {
        if (j3 <= 4294967295L) {
            if (j3 < 0) {
                j3 += 4294967296L;
                if (j3 < 0) {
                    throw new IllegalArgumentException("invalid ip");
                }
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 <= 3; i3++) {
                sb5.append(((255 << r3) & j3) >> (i3 * 8));
                if (i3 < 3) {
                    sb5.append(".");
                }
            }
            return sb5.toString();
        }
        throw new IllegalArgumentException("invalid ip");
    }
}
