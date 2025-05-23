package com.tencent.mobileqq.ar;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f197684a;

    public static a a() {
        if (f197684a == null) {
            f197684a = new a();
        }
        return f197684a;
    }

    public void b(long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("ARDebugReport", 2, String.format("AR_\u9009\u56fe_\u542f\u52a8\u7d2f\u8ba1\u8017\u65f6 timeCost=%sms", Long.valueOf(j16 - j3)));
        }
    }

    public void c(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARDebugReport", 2, String.format("AR_\u9009\u56fe_\u5355\u5e27\u8017\u65f6 timeCost=%sms", Long.valueOf(j3)));
        }
    }

    public void d(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARDebugReport", 2, String.format("AR_\u8bc6\u522b_\u5355\u5e27\u8017\u65f6 timeCost=%sms", Long.valueOf(j3)));
        }
    }

    public void e(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARDebugReport", 2, String.format("AR_\u8ffd\u8e2a_\u5355\u5e27\u8017\u65f6 timeCost=%sms", Long.valueOf(j3)));
        }
    }

    public void f(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARDebugReport", 2, String.format("\u4eba\u8138_\u7279\u5f81\u63d0\u53d6_\u5355\u5e27\u8017\u65f6 time cost=%sms", Long.valueOf(j3)));
        }
    }

    public void g(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ARDebugReport", 2, String.format("\u4eba\u8138_\u8ffd\u8e2a_\u5355\u5e27\u8017\u65f6 time cost=%sms", Long.valueOf(j3)));
        }
    }
}
