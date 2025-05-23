package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import org.light.utils.ILightLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements ILightLogger {
    @Override // org.light.utils.ILightLogger
    public void d(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1");
        }
    }

    @Override // org.light.utils.ILightLogger
    public void e(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterLogger", 2, "s: " + str + ", s1");
        }
    }

    @Override // org.light.utils.ILightLogger
    public void i(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1");
        }
    }

    @Override // org.light.utils.ILightLogger
    public void log(int i3, String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "i: " + i3 + ", s:" + str + ", s1: " + str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void v(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1");
        }
    }

    @Override // org.light.utils.ILightLogger
    public void w(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1");
        }
    }

    @Override // org.light.utils.ILightLogger
    public void d(String str, String str2, Throwable th5) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1", th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void e(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterLogger", 2, "s: " + str + ", s1", th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void i(String str, String str2, Throwable th5) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1", th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void log(int i3, String str, String str2, Throwable th5) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "i: " + i3 + ", s:" + str + ", s1: " + str2, th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void v(String str, String str2, Throwable th5) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1", th5);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void w(String str, String str2, Throwable th5) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AEFilterLogger", 4, "s: " + str + ", s1", th5);
        }
    }
}
