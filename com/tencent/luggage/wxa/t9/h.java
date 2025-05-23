package com.tencent.luggage.wxa.t9;

import com.tencent.luggage.wxa.tn.w0;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f141059a = -1;

    public static int a() {
        if (f141059a <= 0) {
            synchronized (h.class) {
                if (f141059a <= 0) {
                    return b();
                }
            }
        }
        return f141059a;
    }

    public static int b() {
        int i3;
        if (i.g()) {
            i3 = 7;
        } else if (i.f()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        j jVar = x.f141175a;
        if (jVar.f141061a && jVar.f141063c == 0) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        j jVar2 = x.f141175a;
        if (jVar2.f141061a && jVar2.f141062b == 0) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int d16 = i.d();
        int i16 = 15;
        if (d16 > 16) {
            d16 = 15;
        } else if (d16 < 1) {
            d16 = 1;
        }
        int a16 = w0.a(c(), 0) / 1000;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.CpuChecker", "nCores: " + d16 + ", nFreq: " + a16);
        if (d16 >= 8) {
            a16 *= 5;
        } else if (d16 >= 4) {
            a16 *= 2;
        } else if (d16 > 1) {
            a16 = (a16 * 3) >> 1;
        }
        int i17 = a16 / 100;
        if (i17 > 200) {
            i17 = 200;
        } else if (i17 < 5) {
            i17 = 5;
        }
        if (i17 > 5 || d16 < 4) {
            i16 = i17;
        }
        f141059a = (((d16 << 4) + i3) << 8) + i16;
        return f141059a;
    }

    public static String c() {
        Throwable th5;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
        } catch (Throwable th6) {
            th5 = th6;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                return readLine.trim();
            }
            throw new NullPointerException("null was returned while reading cpuinfo_max_freq.");
        } catch (Throwable th7) {
            th5 = th7;
            try {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.CpuChecker", th5, "unexpected exception occurred.", new Object[0]);
                return "0";
            } finally {
                w0.a((Closeable) bufferedReader);
            }
        }
    }
}
