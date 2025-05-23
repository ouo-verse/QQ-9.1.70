package com.tencent.biz.pubaccount.weishi.verticalvideo;

import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.report.GdtAdWsVideoReport;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b implements com.tencent.biz.pubaccount.weishi.player.f {

    /* renamed from: a, reason: collision with root package name */
    private WSPlayerManager f81913a;

    /* renamed from: b, reason: collision with root package name */
    private WSVerticalPageFragment f81914b;

    /* renamed from: c, reason: collision with root package name */
    private f f81915c;

    public b(WSPlayerManager wSPlayerManager) {
        this.f81913a = wSPlayerManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        au z16;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar;
        f fVar = this.f81915c;
        if (fVar == null || (z16 = fVar.z()) == null || (jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f) == null || !jVar.i()) {
            return;
        }
        x.j("WS_VIDEO_REPORT", "[gdtVideoPauseReport]");
        stSimpleMetaGdtAdInfo a16 = jVar.a();
        if (a16 == null) {
            x.j("WS_VIDEO_REPORT", "[gdtVideoPauseReport] gdtAdInfo == null");
            return;
        }
        if (a16.isGdtAdclicked) {
            GdtAdWsVideoReport.g(jVar, eVar, false, 2);
            a16.isGdtAdclicked = false;
        } else {
            GdtAdWsVideoReport.g((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f, eVar, false, 3);
        }
        WSPlayerWrapper wSPlayerWrapper = eVar.f81129e;
        if (wSPlayerWrapper != null) {
            eVar.f81132h = wSPlayerWrapper.z();
        }
    }

    private void k() {
        Object obj;
        au A = this.f81915c.A();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:");
        sb5.append(A);
        sb5.append(", mPlayerParam:");
        if (A != null) {
            obj = A.f82114h;
        } else {
            obj = "null";
        }
        sb5.append(obj);
        x.j("WS_VIDEO_LISTENER", sb5.toString());
        if (A == null || A.f82114h == null) {
            return;
        }
        x.j("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
        this.f81913a.M0(A.f82114h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        stSimpleMetaGdtAdInfo a16;
        f fVar = this.f81915c;
        if (fVar == null || fVar.z() == null) {
            return;
        }
        au z17 = this.f81915c.z();
        com.tencent.biz.pubaccount.weishi.report.dc898.d.m(eVar, z16);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.j0(this.f81914b.getFrom(), this.f81914b.getPlayScene(), eVar, z16, z17.getAdapterPosition() - 1, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.k(this.f81914b.getPresenter().h0(), z17));
        T t16 = z17.f82129f;
        if (t16 == 0 || ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) t16).e() == null || eVar == null || (a16 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z17.f82129f).a()) == null || a16.isGdtAdVidoReport) {
            return;
        }
        if (a16.isGdtAdclicked) {
            GdtAdWsVideoReport.g((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z17.f82129f, eVar, false, 2);
            a16.isGdtAdclicked = false;
        } else {
            GdtAdWsVideoReport.g((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z17.f82129f, eVar, false, 3);
            a16.numbersOfGdtAdPlayed = 0;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        this.f81914b.a(eVar, z16);
        m(eVar, z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void c(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, int i16, String str) {
        this.f81914b.ri(eVar, i3, i16, str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        j(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void e(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.f81914b.d(eVar);
        if (this.f81915c != null) {
            k();
            au z16 = this.f81915c.z();
            this.f81913a.T0(z16 != null ? ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f).g() : 1.0f);
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.i0(this.f81914b.getFrom(), this.f81914b.getPlayScene(), eVar, z16 != null ? z16.getAdapterPosition() - 1 : 0, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.k(this.f81914b.getPresenter().h0(), z16));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void f(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void g(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3) {
        f fVar;
        au z16;
        T t16;
        boolean B0 = this.f81913a.B0();
        x.j("WS_VIDEO_LISTENER", "onVideoReplayOnLoop loopPlayMode:" + B0);
        if (!B0) {
            this.f81914b.vi();
            return;
        }
        if (eVar == null || eVar.f81127c == null || (fVar = this.f81915c) == null || fVar.z() == null || (z16 = this.f81915c.z()) == null || (t16 = z16.f82129f) == 0 || ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) t16).e() == null || ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f).a() == null) {
            return;
        }
        GdtAdWsVideoReport.g((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f, eVar, true, 3);
        ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) z16.f82129f).a().numbersOfGdtAdPlayed++;
        eVar.f81132h = 0L;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void h(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        if (this.f81913a.B0()) {
            return;
        }
        this.f81914b.vi();
    }

    public void l(WSVerticalPageFragment wSVerticalPageFragment) {
        this.f81914b = wSVerticalPageFragment;
        if (wSVerticalPageFragment != null) {
            this.f81915c = wSVerticalPageFragment.getAdapter();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void b(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void i(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }
}
