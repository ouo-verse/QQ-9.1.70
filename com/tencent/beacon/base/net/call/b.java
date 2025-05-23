package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.NetException;

/* compiled from: P */
/* loaded from: classes2.dex */
class b implements Callback<BResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callback f77749a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f77750b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Callback callback) {
        this.f77750b = cVar;
        this.f77749a = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(BResponse bResponse) throws NetException {
        Callback callback = this.f77749a;
        if (callback != null) {
            callback.onResponse(bResponse);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        Callback callback = this.f77749a;
        if (callback != null) {
            callback.onFailure(dVar);
        }
    }
}
