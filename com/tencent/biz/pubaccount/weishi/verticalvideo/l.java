package com.tencent.biz.pubaccount.weishi.verticalvideo;

import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ah;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.s;
import com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.WSOneMoreFeedHelper;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l implements com.tencent.biz.pubaccount.weishi.player.a {

    /* renamed from: a, reason: collision with root package name */
    private ah f82196a;

    /* renamed from: b, reason: collision with root package name */
    private WSVerticalItemVideoProgressController f82197b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.holder.l f82198c;

    /* renamed from: d, reason: collision with root package name */
    private s f82199d;

    /* renamed from: e, reason: collision with root package name */
    private WSVerticalVideoOperationRightItemView f82200e;

    /* renamed from: f, reason: collision with root package name */
    private au f82201f;

    /* renamed from: g, reason: collision with root package name */
    private WSOneMoreFeedHelper f82202g;

    /* renamed from: h, reason: collision with root package name */
    private r10.e f82203h;

    private WSPlayerManager a() {
        WSVerticalPageFragment wSVerticalPageFragment;
        au auVar = this.f82201f;
        if (auVar == null || (wSVerticalPageFragment = auVar.f82128e) == null) {
            return null;
        }
        return wSVerticalPageFragment.U0();
    }

    private void t(long j3, boolean z16) {
        r10.e eVar = this.f82203h;
        if (eVar != null) {
            eVar.b(j3, z16);
        }
    }

    private void v(long j3, float f16) {
        WSVerticalVideoOperationRightItemView wSVerticalVideoOperationRightItemView = this.f82200e;
        if (wSVerticalVideoOperationRightItemView == null || wSVerticalVideoOperationRightItemView.X() || !o10.a.f421718a.j(f16, j3) || com.tencent.biz.pubaccount.weishi.verticalvideo.utils.b.f82304a.e()) {
            return;
        }
        this.f82200e.c0();
        x.f("WSVerticalPlayerUIDelegateLog", "[WSVerticalPlayerUIDelegate.java][playAtGuideAnimation] pos:" + j3 + ", progress:" + f16);
    }

    private void w(long j3, float f16) {
        if (this.f82200e == null || !com.tencent.biz.pubaccount.weishi.verticalvideo.utils.b.f(j3) || !u10.c.b() || com.tencent.biz.pubaccount.weishi.verticalvideo.utils.b.f82304a.e()) {
            return;
        }
        this.f82200e.d0();
        x.f("WSVerticalPlayerUIDelegateLog", "[WSVerticalPlayerUIDelegate.java][playSpeedGuideAnimation] pos:" + j3 + ", progress:" + f16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void b(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.I(8);
            this.f82196a.D();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void c(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, int i16, String str) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.C();
            this.f82196a.K(str);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.I(0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void e(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.w(8, 400);
            this.f82196a.I(8);
            this.f82196a.C();
            this.f82196a.D();
        }
        if (this.f82197b != null) {
            x.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
            this.f82197b.E();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void f(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        x.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.w(8, 200);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void g(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16, boolean z17) {
        ah ahVar = this.f82196a;
        if (ahVar != null && z16 && z17) {
            ahVar.w(8, 400);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void h(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.C();
            this.f82196a.w(0, 100);
            this.f82196a.I(8);
        }
        WSVerticalItemVideoProgressController wSVerticalItemVideoProgressController = this.f82197b;
        if (wSVerticalItemVideoProgressController != null) {
            wSVerticalItemVideoProgressController.E();
            this.f82197b.H(0.0f);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public boolean k(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void l(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        if (this.f82197b != null) {
            x.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
            this.f82197b.I();
            this.f82197b.H(0.0f);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void m(com.tencent.biz.pubaccount.weishi.player.e eVar, long j3, long j16) {
        WSVerticalItemVideoProgressController wSVerticalItemVideoProgressController = this.f82197b;
        boolean z16 = (wSVerticalItemVideoProgressController == null || wSVerticalItemVideoProgressController.G()) ? false : true;
        if (z16) {
            u(j3, j16);
        }
        t(j3, z16);
        s(j3, j16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void o(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.w(0, 100);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void p(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        if (this.f82197b != null) {
            x.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
            this.f82197b.E();
        }
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.C();
            WSPlayerManager a16 = a();
            if (a16 == null || !a16.D0()) {
                return;
            }
            this.f82196a.I(0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void q(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        ah ahVar = this.f82196a;
        if (ahVar != null) {
            ahVar.J();
            WSPlayerManager a16 = a();
            if (a16 == null || !a16.D0()) {
                return;
            }
            this.f82196a.I(8);
        }
    }

    public void x(WSOneMoreFeedHelper wSOneMoreFeedHelper) {
        this.f82202g = wSOneMoreFeedHelper;
    }

    public void y(r10.e eVar) {
        this.f82203h = eVar;
    }

    public void z(au auVar) {
        this.f82201f = auVar;
        if (auVar == null) {
            return;
        }
        Object obj = auVar.f82127d;
        if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b bVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj;
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> i3 = bVar.i();
            if (i3 instanceof ah) {
                this.f82196a = (ah) i3;
            }
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> k3 = bVar.k();
            if (k3 instanceof WSVerticalItemVideoProgressController) {
                this.f82197b = (WSVerticalItemVideoProgressController) k3;
            }
        }
        Object obj2 = auVar.f82127d;
        if (obj2 instanceof WSVerticalVideoOperationRightItemView) {
            WSVerticalVideoOperationRightItemView wSVerticalVideoOperationRightItemView = (WSVerticalVideoOperationRightItemView) obj2;
            this.f82200e = wSVerticalVideoOperationRightItemView;
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> E = wSVerticalVideoOperationRightItemView.E();
            if (E instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.l) {
                this.f82198c = (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.l) E;
            }
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> D = this.f82200e.D();
            if (D instanceof s) {
                this.f82199d = (s) D;
            }
        }
    }

    private void s(long j3, long j16) {
        float r16 = r((float) j3, j16);
        if (this.f82199d != null) {
            if (!c.f81916a.e() || r16 * 100.0f <= r2.a()) {
                return;
            }
            this.f82199d.Y();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(long j3, long j16) {
        float r16 = r((float) j3, j16);
        if (this.f82198c != null && (j3 > r6.A() || 100.0f * r16 > this.f82198c.z())) {
            this.f82198c.H();
        }
        WSOneMoreFeedHelper wSOneMoreFeedHelper = this.f82202g;
        if (wSOneMoreFeedHelper != null) {
            wSOneMoreFeedHelper.f(((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) this.f82201f.f82129f).e(), j3);
        }
        v(j3, r16);
        w(j3, r16);
    }

    private float r(float f16, long j3) {
        if (j3 == 0) {
            this.f82197b.H(0.0f);
            return 0.0f;
        }
        float f17 = f16 / ((float) j3);
        this.f82197b.H(f17);
        return f17;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void j(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void n(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void i(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, boolean z16) {
    }
}
