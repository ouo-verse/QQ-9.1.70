package m10;

import UserGrowth.stSimpleMetaFeed;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f415964a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f415965b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f415966c;

    /* renamed from: d, reason: collision with root package name */
    private a f415967d;

    private String a(j jVar) {
        stSimpleMetaFeed e16 = jVar.e();
        if (e16 != null) {
            return e16.feed_desc;
        }
        return "";
    }

    public void c(j jVar, int i3, String str, String str2) {
        x.j("WSVerticalDeltaTimeCalculatorManager", "[onBindFeedHolder] position:" + i3 + ", mHasBindFirstHolder:" + this.f415964a + ", title:" + a(jVar));
        a aVar = this.f415967d;
        if (aVar == null || i3 != 0 || this.f415964a) {
            return;
        }
        this.f415964a = true;
        aVar.e(SystemClock.uptimeMillis());
    }

    public void e(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        if (this.f415967d == null || this.f415966c) {
            return;
        }
        x.f("WSVerticalDeltaTimeCalculatorManager", "[onExitVerticalPage] firstVideoNotStarted! title:" + b(eVar));
        this.f415966c = true;
        this.f415967d.j(SystemClock.uptimeMillis());
    }

    public void f(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        if (this.f415967d == null || this.f415966c) {
            return;
        }
        x.f("WSVerticalDeltaTimeCalculatorManager", "[onPagerUnselected] firstVideoNotStarted! title:" + b(eVar));
        this.f415966c = true;
        this.f415967d.f(SystemClock.uptimeMillis());
    }

    public void g(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        if (this.f415967d == null || this.f415966c) {
            return;
        }
        x.f("WSVerticalDeltaTimeCalculatorManager", "[onPause] firstVideoNotStarted! title:" + b(eVar));
        this.f415966c = true;
        this.f415967d.h(SystemClock.uptimeMillis());
    }

    public void h(int i3, com.tencent.biz.pubaccount.weishi.player.e eVar) {
        x.j("WSVerticalDeltaTimeCalculatorManager", "[onPlayVideo] position:" + i3 + ", mHasPlayFirstVideo:" + this.f415965b + ", mHasFirstVideoStarted:" + this.f415966c + ", title:" + b(eVar));
        a aVar = this.f415967d;
        if (aVar != null && i3 == 0 && !this.f415965b) {
            this.f415965b = true;
            aVar.g(SystemClock.uptimeMillis());
        } else {
            if (aVar == null || i3 != 1 || this.f415966c) {
                return;
            }
            this.f415966c = true;
            x.f("WSVerticalDeltaTimeCalculatorManager", "[onPlayVideo] firstVideoNotStarted! secondVideoTitle:" + b(eVar));
            this.f415967d.b(SystemClock.uptimeMillis());
        }
    }

    public void i(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, int i16, String str) {
        if (this.f415967d == null || this.f415966c) {
            return;
        }
        x.f("WSVerticalDeltaTimeCalculatorManager", "[onVideoError] firstVideoNotStarted! model:" + i3 + ", what:" + i16 + ", errorMsg:" + str + ", title:" + b(eVar));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append(":");
        sb5.append(i16);
        String sb6 = sb5.toString();
        this.f415966c = true;
        this.f415967d.d(SystemClock.uptimeMillis(), sb6, str);
    }

    public void j(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        x.j("WSVerticalDeltaTimeCalculatorManager", "[onVideoStarted] mHasFirstVideoStarted:" + this.f415966c + ", title:" + b(eVar));
        a aVar = this.f415967d;
        if (aVar == null || this.f415966c) {
            return;
        }
        this.f415966c = true;
        aVar.a(SystemClock.uptimeMillis(), eVar);
    }

    public void k(j jVar) {
        x.j("WSVerticalDeltaTimeCalculatorManager", "[onViewCreated]");
        a aVar = this.f415967d;
        if (aVar != null) {
            aVar.i(SystemClock.uptimeMillis(), jVar);
        }
    }

    private String b(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        l lVar;
        if (eVar != null && (lVar = eVar.f81127c) != null) {
            return lVar.f81175j;
        }
        return "";
    }

    public void d(String str, String str2, long j3, long j16, boolean z16) {
        x.j("WSVerticalDeltaTimeCalculatorManager", "[onCreate] from:" + str + ", isNeedCalcDeltaTime:" + z16 + ", startPageUptime:" + j16 + ", mDeltaTimeCalculator:" + this.f415967d);
        if (z16) {
            a a16 = c.a(str);
            this.f415967d = a16;
            if (a16 != null) {
                a16.c(str, str2, j3, j16, SystemClock.uptimeMillis());
            }
        }
    }
}
