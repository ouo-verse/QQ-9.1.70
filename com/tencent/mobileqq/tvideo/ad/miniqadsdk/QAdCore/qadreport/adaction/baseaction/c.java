package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import ew2.e;
import pw2.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private AdOrderItem f303969a;

    public c(AdOrderItem adOrderItem) {
        this.f303969a = adOrderItem;
    }

    private void b(a aVar) {
        e b16;
        int i3;
        AdOrderItem adOrderItem = this.f303969a;
        if (adOrderItem != null && (b16 = cw2.a.b(adOrderItem, aVar)) != null && aVar != null && (aVar.b() instanceof ew2.c) && (i3 = ((ew2.c) aVar.b()).f397282d) != -1) {
            k.a().c(b16, i3);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b.a
    public void a(a aVar) {
        b(aVar);
    }
}
