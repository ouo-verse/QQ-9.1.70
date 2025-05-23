package com.tencent.timi.game.utils;

import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private long f380313a;

    /* renamed from: b, reason: collision with root package name */
    private long f380314b;

    /* renamed from: c, reason: collision with root package name */
    private long f380315c;

    x() {
    }

    public static x b() {
        return new x();
    }

    public x a() {
        long nanoTime = System.nanoTime();
        this.f380313a = nanoTime;
        this.f380314b = nanoTime;
        return this;
    }

    public void c(String str) {
        long nanoTime = System.nanoTime();
        long j3 = nanoTime - this.f380314b;
        this.f380315c += j3;
        this.f380314b = nanoTime;
        if (this.f380313a == 0) {
            l.e("TimeDetector_", "you need call begin() first!!");
        } else {
            l.i("TimeDetector_", String.format(Locale.CHINA, "%s Consume(%dms),TotalConsume(%dms)", str, Long.valueOf(j3 / 1000000), Long.valueOf(this.f380315c / 1000000)));
        }
    }

    public void d(String str, String str2) {
        c(str + "_" + str2);
    }
}
