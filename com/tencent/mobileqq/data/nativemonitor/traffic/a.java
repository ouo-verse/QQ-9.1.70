package com.tencent.mobileqq.data.nativemonitor.traffic;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.jsonconverter.Alias;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    @Alias("isInitNativeTrafficMonitor")
    private boolean f203175d = false;

    /* renamed from: e, reason: collision with root package name */
    @Alias("isEnableMonitor")
    private boolean f203176e = false;

    /* renamed from: f, reason: collision with root package name */
    @Alias("isEnableGlobalMonitor")
    private boolean f203177f = false;

    /* renamed from: h, reason: collision with root package name */
    @Alias("mobileReportThreshold")
    private long f203178h = Long.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    @Alias("nextMobileLogTimes")
    private long f203179i = 1;

    /* renamed from: m, reason: collision with root package name */
    @Alias("wifiReportThreshold")
    private long f203180m = Long.MAX_VALUE;

    @Alias("nextWifiLogTimes")
    private long C = 1;

    @Alias("mobileLogThreshold")
    private long D = Long.MAX_VALUE;

    @Alias("wifiLogThreshold")
    private long E = Long.MAX_VALUE;

    @Alias("globalThreadInfoThreshold")
    private long F = Long.MAX_VALUE;

    @Alias("globalMonitorTime")
    private long G = 600;

    @Alias("globalMobileReportThreshold")
    private long H = Long.MAX_VALUE;

    @Alias("nextGlobalMobileLogTimes")
    private long I = 1;

    @Alias("globalWifiReportThreshold")
    private long J = Long.MAX_VALUE;

    @Alias("nextGlobalWifiLogTimes")
    private long K = 1;

    @Alias("globalMobileLogThreshold")
    private long L = Long.MAX_VALUE;

    @Alias("globalWifiLogThreshold")
    private long M = Long.MAX_VALUE;

    @Alias("blackList")
    public List<String> N = null;

    public long a() {
        return this.L;
    }

    public long b() {
        return this.H;
    }

    public long c() {
        return this.G;
    }

    public long d() {
        return this.F;
    }

    public long e() {
        return this.M;
    }

    public long f() {
        return this.J;
    }

    public long g() {
        return this.D;
    }

    public long h() {
        return this.f203178h;
    }

    public long i() {
        return this.I;
    }

    public long j() {
        return this.K;
    }

    public long k() {
        return this.f203179i;
    }

    public long l() {
        return this.C;
    }

    public long m() {
        return this.E;
    }

    public long n() {
        return this.f203180m;
    }

    public boolean o() {
        return this.f203177f;
    }

    public boolean p() {
        return this.f203176e;
    }

    public boolean q() {
        return this.f203175d;
    }

    public String toString() {
        return "NativeTrafficMonitorConfig{isInitNativeTrafficMonitor=" + this.f203175d + ", isEnableMonitor=" + this.f203176e + ", isEnableGlobalMonitor=" + this.f203177f + ", mobileReportThreshold=" + this.f203178h + ", nextMobileLogTimes=" + this.f203179i + ", wifiReportThreshold=" + this.f203180m + ", nextWifiLogTimes=" + this.C + ", mobileLogThreshold=" + this.D + ", wifiLogThreshold=" + this.E + ", globalThreadInfoThreshold=" + this.F + ", globalMonitorTime=" + this.G + ", globalMobileReportThreshold=" + this.H + ", nextGlobalMobileLogTimes=" + this.I + ", globalWifiReportThreshold=" + this.J + ", nextGlobalWifiLogTimes=" + this.K + ", globalMobileLogThreshold=" + this.L + ", globalWifiLogThreshold=" + this.M + ", blackList=" + this.N + '}';
    }
}
