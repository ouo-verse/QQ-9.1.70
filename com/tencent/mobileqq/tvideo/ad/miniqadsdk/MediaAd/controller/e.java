package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import pw2.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private a f303577a;

    /* renamed from: b, reason: collision with root package name */
    private AdInsideVideoItem f303578b;

    /* renamed from: c, reason: collision with root package name */
    private int f303579c;

    /* renamed from: d, reason: collision with root package name */
    private lu2.a f303580d = new lu2.a();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a();

        void b();
    }

    public e(a aVar, AdInsideVideoItem adInsideVideoItem, int i3) {
        this.f303579c = i3;
        this.f303577a = aVar;
        this.f303578b = adInsideVideoItem;
        d();
    }

    public static ew2.e b(AdOrderItem adOrderItem, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar) {
        return cw2.a.a(adOrderItem, aVar);
    }

    private void c(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar) {
        ew2.e b16;
        int i3;
        AdInsideVideoItem adInsideVideoItem = this.f303578b;
        if (adInsideVideoItem != null && (b16 = b(adInsideVideoItem.orderItem, aVar)) != null && aVar != null && (aVar.b() instanceof ew2.c) && (i3 = ((ew2.c) aVar.b()).f397282d) != -1) {
            k.a().c(b16, i3);
        }
    }

    private void d() {
        this.f303580d.b(20, new mu2.b(this.f303577a));
        this.f303580d.b(2, new mu2.b(this.f303577a));
        this.f303580d.b(6, new mu2.b(this.f303577a));
        this.f303580d.b(7, new mu2.b(this.f303577a));
        this.f303580d.b(4, new mu2.c(this.f303577a));
        this.f303580d.b(9, new mu2.c(this.f303577a));
        this.f303580d.b(37, new mu2.b(this.f303577a));
        this.f303580d.b(38, new mu2.b(this.f303577a));
        this.f303580d.b(39, new mu2.c(this.f303577a));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b.a
    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar) {
        this.f303580d.a(aVar);
        c(aVar);
    }
}
