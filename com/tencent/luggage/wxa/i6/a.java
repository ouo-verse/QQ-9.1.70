package com.tencent.luggage.wxa.i6;

import com.tencent.luggage.wxa.cp.y;
import com.tencent.luggage.wxa.t9.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.BufferedReader;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f129492a;

    public static int a() {
        int i3;
        if (i.g()) {
            i3 = 7;
        } else if (i.f()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        int d16 = i.d();
        int i16 = 15;
        if (d16 > 16) {
            d16 = 15;
        } else if (d16 < 1) {
            d16 = 1;
        }
        int a16 = w0.a(b(), 0) / 1000;
        if (d16 >= 8) {
            a16 *= 4;
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
        int i18 = (((d16 << 4) + i3) << 8) + i16;
        f129492a = i18;
        return i18;
    }

    public static String b() {
        Throwable th5;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new y("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
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
                w.a("WMPF.CpuChecker", th5, "unexpected exception occurred.", new Object[0]);
                return "0";
            } finally {
                w0.a((Closeable) bufferedReader);
            }
        }
    }
}
