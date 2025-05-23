package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements Callback<BResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.e f77717a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Callback f77718b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f77719c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, com.tencent.beacon.base.net.call.e eVar, Callback callback) {
        this.f77719c = cVar;
        this.f77717a = eVar;
        this.f77718b = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(BResponse bResponse) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("httpRequest: ");
            sb5.append(this.f77717a.h());
            sb5.append(" request success!");
            com.tencent.beacon.base.util.c.a("[BeaconNet]", sb5.toString(), new Object[0]);
            this.f77718b.onResponse(bResponse);
            this.f77719c.f();
        } catch (Exception e16) {
            onFailure(new d(this.f77717a.h(), "453", 200, e16.getMessage(), e16));
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(d dVar) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "httpRequest: " + dVar.toString(), new Object[0]);
        this.f77719c.a(dVar);
        this.f77718b.onFailure(dVar);
        this.f77719c.f();
    }
}
