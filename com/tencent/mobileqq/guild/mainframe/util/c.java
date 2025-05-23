package com.tencent.mobileqq.guild.mainframe.util;

import android.os.Debug;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {
    private static boolean a() {
        QLog.isDevelopLevel();
        return false;
    }

    public static void b(String str) {
        if (a()) {
            Debug.startMethodTracing(str);
        }
    }

    public static void c() {
        if (a()) {
            Debug.stopMethodTracing();
        }
    }
}
