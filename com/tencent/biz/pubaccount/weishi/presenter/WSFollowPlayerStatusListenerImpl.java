package com.tencent.biz.pubaccount.weishi.presenter;

import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.player.f;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.x;

/* loaded from: classes32.dex */
public class WSFollowPlayerStatusListenerImpl implements f {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.f f81234a;

    public WSFollowPlayerStatusListenerImpl(com.tencent.biz.pubaccount.weishi.f fVar) {
        this.f81234a = fVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void a(final e eVar, final boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onVideoStop] video: ");
        if (eVar != null && eVar.f81126b != null) {
            str = eVar.f81127c.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.b("WSFollowPlayerStatusListenerImpl", sb5.toString());
        new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.presenter.WSFollowPlayerStatusListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                WSFollowBeaconReport.D(eVar, z16);
                WSReportDc00898.r(eVar, z16);
            }
        }.run();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void b(e eVar) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onVideoRestart] video: ");
        if (eVar != null && eVar.f81126b != null) {
            str = eVar.f81127c.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.b("WSFollowPlayerStatusListenerImpl", sb5.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void c(e eVar, int i3, int i16, String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onVideoError] video: ");
        if (eVar != null && eVar.f81126b != null) {
            str2 = eVar.f81127c.f81175j;
        } else {
            str2 = "";
        }
        sb5.append(str2);
        x.b("WSFollowPlayerStatusListenerImpl", sb5.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void d(e eVar) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onVideoPause] video: ");
        if (eVar != null && eVar.f81126b != null) {
            str = eVar.f81127c.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.b("WSFollowPlayerStatusListenerImpl", sb5.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void e(e eVar) {
        String str;
        l lVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onVideoStart] video: ");
        if (eVar != null && (lVar = eVar.f81127c) != null) {
            str = lVar.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.b("WSFollowPlayerStatusListenerImpl", sb5.toString());
        WSFollowBeaconReport.C(eVar);
        com.tencent.biz.pubaccount.weishi.f fVar = this.f81234a;
        if (fVar != null) {
            fVar.F();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void f(e eVar) {
        com.tencent.biz.pubaccount.weishi.f fVar = this.f81234a;
        if (fVar != null) {
            fVar.F();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void h(e eVar) {
        String str;
        if (eVar == null || this.f81234a == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onCompletion] videoTitle: ");
        l lVar = eVar.f81127c;
        if (lVar != null) {
            str = lVar.f81175j;
        } else {
            str = "videoInfo is null!";
        }
        sb5.append(str);
        x.j("WSFollowPlayerStatusListenerImpl", sb5.toString());
        WSPlayerManager t16 = this.f81234a.t();
        if (t16 == null || !t16.B0()) {
            return;
        }
        x.j("WSFollowPlayerStatusListenerImpl", "[onCompletion] loopPlayMode: true");
        t16.L0(eVar, false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void i(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void g(e eVar, int i3) {
    }
}
