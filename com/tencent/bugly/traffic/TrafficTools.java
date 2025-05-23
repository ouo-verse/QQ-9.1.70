package com.tencent.bugly.traffic;

import com.heytap.databaseengine.type.DeviceType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrafficTools {
    public static String frontStateToString(int i3) {
        if (i3 == 1) {
            return "front_end";
        }
        if (i3 == 2) {
            return "back_end";
        }
        return "unknown";
    }

    public static String netStateToString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "unknown";
                }
                return "disconnect";
            }
            return DeviceType.DeviceCategory.MOBILE;
        }
        return "wifi";
    }
}
