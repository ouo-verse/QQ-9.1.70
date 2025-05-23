package f10;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f397572a;

    /* renamed from: b, reason: collision with root package name */
    private long f397573b;

    /* renamed from: c, reason: collision with root package name */
    private long f397574c;

    /* renamed from: d, reason: collision with root package name */
    private long f397575d;

    /* renamed from: e, reason: collision with root package name */
    private long f397576e;

    /* renamed from: f, reason: collision with root package name */
    private long f397577f;

    /* renamed from: g, reason: collision with root package name */
    private long f397578g;

    /* renamed from: h, reason: collision with root package name */
    private long f397579h;

    /* renamed from: i, reason: collision with root package name */
    private long f397580i;

    /* renamed from: j, reason: collision with root package name */
    private final String f397581j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.f397581j = str;
    }

    public long a() {
        long j3 = this.f397573b;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f397572a;
    }

    public long b() {
        long j3 = this.f397577f;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f397576e;
    }

    public long c() {
        long j3 = this.f397578g;
        if (j3 == 0) {
            return -1L;
        }
        return j3;
    }

    public long d() {
        long j3 = this.f397579h;
        if (j3 == 0) {
            return -1L;
        }
        return j3;
    }

    public long e() {
        long j3 = this.f397576e;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f397575d;
    }

    public long f() {
        long j3 = this.f397575d;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f397574c;
    }

    public String g() {
        return this.f397581j;
    }

    public long h() {
        long j3 = this.f397574c;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f397573b;
    }

    public long i() {
        long j3 = this.f397577f;
        if (j3 == 0) {
            return -1L;
        }
        return j3 - this.f397572a;
    }

    public void j() {
        x.j("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onEntranceClick]");
        this.f397572a = SystemClock.uptimeMillis();
    }

    public void k() {
        x.j("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onFirstPageCoverLoadStart]");
        this.f397576e = SystemClock.uptimeMillis();
    }

    public void l(long j3) {
        this.f397578g = j3;
    }

    public void m(long j3) {
        this.f397579h = j3;
    }

    public void n() {
        x.j("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onInterruptWhenFetchData]");
        this.f397580i = SystemClock.uptimeMillis();
    }

    public void o() {
        x.j("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onRecommendFeedsHandleFinish]");
        this.f397575d = SystemClock.uptimeMillis();
    }

    public void p() {
        x.j("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onRecommendFeedsReqSend]");
        this.f397573b = SystemClock.uptimeMillis();
    }

    public void q() {
        x.j("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onRecommendFeedsRspReceive]");
        this.f397574c = SystemClock.uptimeMillis();
    }
}
