package com.tencent.ark.open.internal;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppReport {
    private static final String TAG = "ArkApp.DataReport";

    @Deprecated
    public static void legacyReport(String str, String str2, int i3, int i16, long j3, long j16, long j17, String str3, String str4) {
        boolean z16;
        if (str != null && str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", String.valueOf(i3));
            hashMap.put("entry", String.valueOf(i16));
            hashMap.put("r1", String.valueOf(j16));
            hashMap.put("r2", String.valueOf(j17));
            if (str3 != null) {
                hashMap.put("r3", str3);
            }
            if (str4 != null) {
                hashMap.put("r4", str4);
            }
            ArkEnvironmentManager arkEnvironmentManager = ArkEnvironmentManager.getInstance();
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            arkEnvironmentManager.doDataReport(str, str2, z16, (int) j3, hashMap);
        }
    }

    public static void reportDisplayView(String str, String str2, String str3, boolean z16, int i3, int i16, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put("view", str2);
        hashMap.put(ark.APP_SPECIFIC_BIZSRC, str3);
        hashMap.put("state", String.valueOf(i3));
        hashMap.put("displayTime", String.valueOf(i17));
        ArkEnvironmentManager.getInstance().doDataReport(str, Constants.Event.ArkAppDisplayMonitor, z16, i16, hashMap);
    }
}
