package com.tencent.mobileqq.vasgift.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {
    @NonNull
    public static String a(long j3) {
        StringBuilder sb5;
        StringBuilder sb6;
        long j16 = j3 / 3600000;
        long j17 = j3 - (3600000 * j16);
        long j18 = j17 / 60000;
        long j19 = (j17 - (60000 * j18)) / 1000;
        if (j18 > 9) {
            sb5 = new StringBuilder();
            sb5.append("");
        } else {
            sb5 = new StringBuilder();
            sb5.append("0");
        }
        sb5.append(j18);
        String sb7 = sb5.toString();
        if (j19 > 9) {
            sb6 = new StringBuilder();
            sb6.append("");
        } else {
            sb6 = new StringBuilder();
            sb6.append("0");
        }
        sb6.append(j19);
        String sb8 = sb6.toString();
        if (j16 == 0) {
            return String.format("%s:%s", sb7, sb8);
        }
        return String.format("%s:%s:%s", Long.valueOf(j16), sb7, sb8);
    }

    public static long b() {
        ToggleProxy toggleProxy = VasToggle.VAS_LIVE_GIFT_TIME_CONFIG;
        if (toggleProxy.isEnable(false)) {
            try {
                return Long.parseLong(toggleProxy.getStringDataSet("request_delay", String.valueOf(1000)));
            } catch (Exception unused) {
                return 1000L;
            }
        }
        return 1000L;
    }
}
