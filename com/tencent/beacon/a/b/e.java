package com.tencent.beacon.a.b;

import android.util.Log;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;

/* compiled from: P */
/* loaded from: classes2.dex */
class e implements Callback<BResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f77600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f77600a = fVar;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(BResponse bResponse) {
        Log.e("AttaReport", "report success attaCode: " + this.f77600a.f77602b);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        Log.e("AttaReport", "report failure attaCode: " + this.f77600a.f77602b + " errorMsg: " + dVar.f77780d);
    }
}
