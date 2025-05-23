package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class u {

    /* renamed from: b, reason: collision with root package name */
    private static u f307815b;

    /* renamed from: a, reason: collision with root package name */
    private long f307816a = 0;

    public static u a() {
        if (f307815b == null) {
            synchronized (u.class) {
                if (f307815b == null) {
                    f307815b = new u();
                }
            }
        }
        return f307815b;
    }

    public boolean b() {
        return c(500L);
    }

    public boolean c(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f307816a >= j3) {
            this.f307816a = currentTimeMillis;
            return false;
        }
        QLog.i("CheckFastClickUtils", 1, "isFastClick");
        this.f307816a = currentTimeMillis;
        return true;
    }
}
