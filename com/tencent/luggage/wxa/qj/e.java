package com.tencent.luggage.wxa.qj;

import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final int f138914a;

    /* renamed from: b, reason: collision with root package name */
    public volatile RandomAccessFile f138915b;

    /* renamed from: c, reason: collision with root package name */
    public volatile RandomAccessFile f138916c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f138917d;

    /* renamed from: e, reason: collision with root package name */
    public long f138918e;

    /* renamed from: f, reason: collision with root package name */
    public long f138919f;

    /* renamed from: g, reason: collision with root package name */
    public long f138920g;

    public e(int i3) {
        this.f138914a = i3;
    }

    public final long a() {
        if (this.f138915b == null) {
            this.f138915b = x.c("/proc/stat", false);
        }
        this.f138915b.seek(0L);
        String readLine = this.f138915b.readLine();
        if (w0.c(readLine)) {
            return 0L;
        }
        String[] split = readLine.split(" ");
        if (split.length < 9) {
            return 0L;
        }
        long g16 = w0.g(split[2]);
        long g17 = w0.g(split[3]);
        long g18 = w0.g(split[4]);
        long g19 = w0.g(split[5]);
        long g26 = w0.g(split[6]);
        long g27 = w0.g(split[7]);
        return g16 + g17 + g18 + g19 + g26 + g27 + w0.g(split[8]) + w0.g(split[9]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f138916c != null) {
                this.f138916c.close();
            }
        } catch (IOException unused) {
        }
        try {
            if (this.f138915b != null) {
                this.f138915b.close();
            }
        } catch (IOException unused2) {
        }
    }

    public double d() {
        String readLine;
        double d16;
        double d17 = 0.0d;
        if (this.f138917d) {
            return 0.0d;
        }
        try {
            if (this.f138916c == null) {
                try {
                    this.f138916c = x.c("/proc/" + this.f138914a + "/stat", false);
                } catch (Exception e16) {
                    e = e16;
                    w.b(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
                    this.f138917d = true;
                    return d17;
                }
            }
            this.f138916c.seek(0L);
            readLine = this.f138916c.readLine();
        } catch (Exception e17) {
            e = e17;
        }
        if (w0.c(readLine)) {
            return 0.0d;
        }
        String[] split = readLine.split(" ");
        if (split.length < 17) {
            return 0.0d;
        }
        long a16 = a();
        long g16 = w0.g(split[13]);
        long g17 = w0.g(split[14]);
        long j3 = this.f138918e;
        if (j3 != 0) {
            double d18 = a16 - j3;
            double d19 = ((g16 - this.f138919f) * 100) / d18;
            try {
                double d26 = ((g17 - this.f138920g) * 100) / d18;
                d16 = 0.0d;
                try {
                    d17 = Math.max(0.0d, d19) + Math.max(0.0d, d26);
                } catch (Exception e18) {
                    e = e18;
                    d17 = d16;
                    w.b(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
                    this.f138917d = true;
                    return d17;
                }
            } catch (Exception e19) {
                e = e19;
                d16 = 0.0d;
            }
        }
        this.f138918e = a16;
        this.f138919f = g16;
        this.f138920g = g17;
        return d17;
    }
}
