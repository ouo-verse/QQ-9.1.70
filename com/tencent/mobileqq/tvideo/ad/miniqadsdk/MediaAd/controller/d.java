package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller;

import android.content.Context;
import kt3.j;
import pw2.n;
import yu2.g;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends a {
    public d(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.a
    protected long b(j jVar) {
        return jVar.k();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.a
    protected void f(int i3, sv2.a aVar) {
        n.a("QAdMidrollReportController", "vrPlayReport,uvEventId:" + i3 + ",adPlayerData:" + aVar);
        g.e(aVar, i3, this.f303572a);
    }
}
