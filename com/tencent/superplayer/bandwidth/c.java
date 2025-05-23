package com.tencent.superplayer.bandwidth;

import android.os.SystemClock;
import com.tencent.superplayer.report.SPReportHelper;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements IBandwidthObtainer {

    /* renamed from: a, reason: collision with root package name */
    private long f373906a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f373907b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f373908c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f373909d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f373910e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f373911f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f373912g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f373909d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if (this.f373912g > 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.superplayer.bandwidth.IBandwidthObtainer
    public long getCurrentBandwidth() {
        int i3;
        long j3 = SPReportHelper.GLOBAL_HTTP_BANDWIDTH.get();
        long j16 = SPReportHelper.GLOBAL_PCDN_BANDWIDTH.get();
        long j17 = j3 + j16 + SPReportHelper.GLOBAL_P2P_BANDWIDTH.get();
        long j18 = com.tencent.superplayer.report.b.Q.get() + com.tencent.superplayer.report.b.R.get() + com.tencent.superplayer.report.b.S.get() + j17;
        long j19 = j18 - this.f373906a;
        long j26 = j17 - this.f373907b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j27 = this.f373908c;
        if (j27 > 0) {
            i3 = (int) Math.max((elapsedRealtime - j27) / 1000, 1L);
        } else {
            i3 = 1;
        }
        long j28 = i3;
        long max = Math.max(0L, j19 / 1024) / j28;
        long max2 = Math.max(0L, j26 / 1024) / j28;
        long j29 = SPReportHelper.GLOBAL_HTTP_ERROR_COUNT.get();
        if (max > 0) {
            this.f373912g = 0L;
            this.f373911f = j29;
        } else {
            this.f373912g = j29 - this.f373911f;
        }
        this.f373906a = j18;
        this.f373907b = j17;
        this.f373908c = elapsedRealtime;
        this.f373909d = max;
        this.f373910e = max2;
        return max;
    }
}
