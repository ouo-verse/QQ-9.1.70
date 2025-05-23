package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdPlayerManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdMidCountDownView;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdTempletItem;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import java.util.ArrayList;
import java.util.Map;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends c implements a {
    private e N;

    public g(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.c cVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.c(context);
        this.f303632h = cVar;
        cVar.v1(this);
        e eVar = new e(this.f303629d, u(), this.H, X(), this.f303631f);
        this.N = eVar;
        eVar.n(this);
        this.N.o(this.f303633i);
    }

    private void a0(boolean z16) {
        QAdPlayerManager qAdPlayerManager = this.f303630e;
        if (qAdPlayerManager != null) {
            qAdPlayerManager.E(z16);
        }
    }

    private void c0(InsideVideoSkipAdInfo insideVideoSkipAdInfo) {
        this.f303632h.C0(insideVideoSkipAdInfo);
    }

    private void e0(vu2.a aVar) {
        this.f303632h.B1(aVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.c
    public void N() {
        super.N();
        e eVar = this.N;
        if (eVar != null) {
            eVar.m();
        }
    }

    public iu2.a W() {
        iu2.a a16 = zu2.c.a(3).a(this.f303629d, this.J);
        if (a16 != null) {
            n.a(c.M, "[CHECK][LOADAD] \u4e0d\u8bf7\u6c42\u5e7f\u544a\u9519\u8bef\u7801\uff1a" + a16.a() + "MSG;" + a16.c());
        }
        return a16;
    }

    protected long X() {
        return yu2.d.d() * 1000;
    }

    public synchronized void Y(ArrayList<AdTempletItem> arrayList) {
        if (this.D != null && this.E != null && arrayList != null) {
            this.C = 1;
            QAdVideoHelper.v(this.D);
            this.f303632h.z1(this.K);
            AdInsideVideoRequest Z = Z();
            ju2.a c16 = QAdVideoHelper.c(Z, this.K, this.E.j(), u());
            this.J = c16;
            this.f303632h.P1(c16);
            iu2.a W = W();
            if (W == null) {
                n.e(c.M, "loadAd, ready to request");
                ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.c) this.f303632h).T1(Z, arrayList);
            } else {
                n.e(c.M, "loadAd, not need to show ad");
                this.f303632h.V0(W);
            }
            return;
        }
        n.e(c.M, "loadAd, params is null, mQAdUserInfo = " + this.D + ", mQAdVideoInfo = " + this.E + ", mDefinition = " + this.F);
        G(0);
    }

    protected AdInsideVideoRequest Z() {
        return QAdVideoHelper.p(this.f303629d, this.E, this.F, this.D, this.K, 4, null);
    }

    public void b0(Map<String, Object> map) {
        this.f303632h.K1(map);
    }

    public void d0(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.a aVar) {
        e0(aVar.a());
        c0(aVar.c());
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a
    public BaseMidCountView e() {
        return new QAdMidCountDownView(this.f303629d);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.a
    public void j() {
        z();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.c
    public int u() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.c
    public synchronized void z() {
        e eVar = this.N;
        if (eVar == null) {
            return;
        }
        if (!eVar.j()) {
            n.e(c.M, "handleAdPlayerPrepared, in subclass 1");
            a0(false);
            this.N.p();
        } else if (this.f303630e.s()) {
            n.e(c.M, "handleAdPlayerPrepared, in subclass 2");
            a0(true);
            super.z();
        }
    }
}
