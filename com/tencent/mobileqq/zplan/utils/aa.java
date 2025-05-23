package com.tencent.mobileqq.zplan.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes34.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private long f335751a;

    /* renamed from: b, reason: collision with root package name */
    private long f335752b;

    /* renamed from: c, reason: collision with root package name */
    private long f335753c;

    aa() {
    }

    public static aa b() {
        return new aa();
    }

    public aa a() {
        long nanoTime = System.nanoTime();
        this.f335751a = nanoTime;
        this.f335752b = nanoTime;
        return this;
    }

    public long c() {
        return System.nanoTime() - this.f335751a;
    }

    public void d(String str) {
        long nanoTime = System.nanoTime();
        long j3 = nanoTime - this.f335752b;
        this.f335753c += j3;
        this.f335752b = nanoTime;
        if (this.f335751a == 0) {
            QLog.i("TimeDetector_", 1, "you need call begin() first!!");
        } else {
            QLog.i("TimeDetector_", 1, String.format(Locale.CHINA, "%s Consume(%dms),TotalConsume(%dms)", str, Long.valueOf(j3 / 1000000), Long.valueOf(this.f335753c / 1000000)));
        }
    }
}
