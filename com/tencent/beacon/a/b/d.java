package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class d implements Callback<BResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f77599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(g gVar) {
        this.f77599a = gVar;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(BResponse bResponse) {
        if (bResponse != null) {
            com.tencent.beacon.base.util.c.a("AttaReport", "oversea net ret: " + bResponse.toString(), new Object[0]);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
    }
}
