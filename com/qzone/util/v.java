package com.qzone.util;

import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class v {
    public static float a(String str) {
        try {
            return Float.valueOf(str).floatValue();
        } catch (NumberFormatException unused) {
            QZLog.e("NumberUtil", "float string is ill-format, return 0.0f");
            return 0.0f;
        }
    }
}
