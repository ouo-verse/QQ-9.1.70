package com.qzone.album.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class o {
    public static int a(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w("QZoneNumberUtil", 2, "parse int error: " + str + ", " + Log.getStackTraceString(new Throwable()));
            }
            return i3;
        }
    }

    public static long b(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w("QZoneNumberUtil", 2, "parse long error: " + str + ", " + Log.getStackTraceString(new Throwable()));
            }
            return j3;
        }
    }
}
