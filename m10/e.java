package m10;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private long f415983a;

    /* renamed from: b, reason: collision with root package name */
    private long f415984b;

    /* renamed from: c, reason: collision with root package name */
    private long f415985c;

    /* renamed from: d, reason: collision with root package name */
    private long f415986d;

    /* renamed from: e, reason: collision with root package name */
    private long f415987e;

    /* renamed from: f, reason: collision with root package name */
    private long f415988f;

    /* renamed from: g, reason: collision with root package name */
    private final d f415989g = new d();

    private long k(long j3) {
        long j16 = this.f415983a;
        if (j16 > 0) {
            return j3 - j16;
        }
        long j17 = this.f415984b;
        if (j17 > 0) {
            return j3 - j17;
        }
        return -1L;
    }

    @Override // m10.a
    public void a(long j3, com.tencent.biz.pubaccount.weishi.player.e eVar) {
        long j16 = this.f415988f;
        long j17 = j16 > 0 ? j3 - j16 : -1L;
        d dVar = this.f415989g;
        dVar.f415979l = j17;
        dVar.f415980m = k(j3);
        this.f415989g.f415968a = "1001";
        x.j("WSVerticalForCommonDeltaTimeCalculator", "[onFirstVideoStartedUptime] deltaTime:" + j17);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.d0(this.f415989g);
        x.c("WSVerticalForCommonDeltaTimeCalculator", "<<<< [totalDeltaTime] deltaTime:" + k(j3));
    }

    @Override // m10.a
    public void b(long j3) {
        this.f415989g.f415980m = k(j3);
        d dVar = this.f415989g;
        dVar.f415968a = "2001";
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.d0(dVar);
        x.f("WSVerticalForCommonDeltaTimeCalculator", "[onFirstVideoNotPlayScrollSecond] deltaTime:" + k(j3));
    }

    @Override // m10.a
    public void c(String str, String str2, long j3, long j16, long j17) {
        this.f415983a = j3;
        this.f415984b = j16;
        this.f415985c = j17;
        d dVar = this.f415989g;
        dVar.f415969b = str;
        dVar.f415970c = str2;
        long j18 = j3 > 0 ? j16 - j3 : -1L;
        dVar.f415974g = j18;
        long j19 = j16 > 0 ? j17 - j16 : -1L;
        dVar.f415975h = j19;
        x.c("WSVerticalForCommonDeltaTimeCalculator", ">>>> [onCreateUptime] onStartOpenDeltaTime:" + j18 + ", onCreateDeltaTime:" + j19);
    }

    @Override // m10.a
    public void d(long j3, String str, String str2) {
        this.f415989g.f415980m = k(j3);
        d dVar = this.f415989g;
        dVar.f415968a = "3001";
        dVar.f415981n = str;
        dVar.f415982o = str2;
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.d0(dVar);
        x.f("WSVerticalForCommonDeltaTimeCalculator", "[onFirstVideoPlayError] deltaTime:" + k(j3));
    }

    @Override // m10.a
    public void e(long j3) {
        this.f415987e = j3;
        long j16 = this.f415986d;
        long j17 = j16 > 0 ? j3 - j16 : -1L;
        this.f415989g.f415977j = j17;
        x.j("WSVerticalForCommonDeltaTimeCalculator", "[onBindFirstHolderUptime] deltaTime:" + j17);
    }

    @Override // m10.a
    public void f(long j3) {
        this.f415989g.f415980m = k(j3);
        d dVar = this.f415989g;
        dVar.f415968a = "2004";
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.d0(dVar);
        x.f("WSVerticalForCommonDeltaTimeCalculator", "[onFirstVideoNotPlayOnPagerUnselected] deltaTime:" + k(j3));
    }

    @Override // m10.a
    public void g(long j3) {
        this.f415988f = j3;
        long j16 = this.f415987e;
        long j17 = j16 > 0 ? j3 - j16 : -1L;
        this.f415989g.f415978k = j17;
        x.j("WSVerticalForCommonDeltaTimeCalculator", "[onPlayFirstVideoUptime] deltaTime:" + j17);
    }

    @Override // m10.a
    public void h(long j3) {
        this.f415989g.f415980m = k(j3);
        d dVar = this.f415989g;
        dVar.f415968a = "2002";
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.d0(dVar);
        x.f("WSVerticalForCommonDeltaTimeCalculator", "[onFirstVideoNotPlayOnPause] deltaTime:" + k(j3));
    }

    @Override // m10.a
    public void i(long j3, j jVar) {
        String str;
        stMetaUgcVideoSeg stmetaugcvideoseg;
        stSimpleMetaPerson stsimplemetaperson;
        this.f415986d = j3;
        long j16 = this.f415985c;
        long j17 = -1;
        long j18 = j16 > 0 ? j3 - j16 : -1L;
        this.f415989g.f415976i = j18;
        stSimpleMetaFeed e16 = jVar != null ? jVar.e() : null;
        d dVar = this.f415989g;
        String str2 = "";
        if (e16 == null) {
            str = "";
        } else {
            str = e16.f25129id;
        }
        dVar.f415971d = str;
        if (e16 != null && (stsimplemetaperson = e16.poster) != null) {
            str2 = stsimplemetaperson.f25130id;
        }
        dVar.f415972e = str2;
        if (e16 != null && (stmetaugcvideoseg = e16.video) != null) {
            j17 = stmetaugcvideoseg.duration;
        }
        dVar.f415973f = j17;
        x.j("WSVerticalForCommonDeltaTimeCalculator", "[onViewCreatedUptime] deltaTime:" + j18);
    }

    @Override // m10.a
    public void j(long j3) {
        this.f415989g.f415980m = k(j3);
        d dVar = this.f415989g;
        dVar.f415968a = "2003";
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.d0(dVar);
        x.f("WSVerticalForCommonDeltaTimeCalculator", "[onFirstVideoNotPlayExitVertical] deltaTime:" + k(j3));
    }
}
