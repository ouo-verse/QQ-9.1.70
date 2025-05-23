package com.tencent.luggage.wxa.ic;

import com.tencent.luggage.wxa.kc.a;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/luggage/wxa/ic/v0;", "Lcom/tencent/luggage/wxa/kc/a;", "", "onSuccess", "", "errCode", "", "errMsg", "a", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class v0 implements com.tencent.luggage.wxa.kc.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f130010a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f130011b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.tencent.luggage.wxa.kc.a f130012c;

    @Override // com.tencent.luggage.wxa.kc.a
    public void a(int errCode, String errMsg) {
        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService", "onError, requestId:" + this.f130010a + ", errCode:" + a.C6375a.a(errCode) + ", cost:" + w0.e(this.f130011b));
        com.tencent.luggage.wxa.kc.a aVar = this.f130012c;
        if (aVar != null) {
            aVar.a(errCode, errMsg);
        }
    }

    @Override // com.tencent.luggage.wxa.kc.a
    public void onSuccess() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPreRenderColdStartService", "onSuccess, requestId:" + this.f130010a + ", cost:" + w0.e(this.f130011b));
        com.tencent.luggage.wxa.kc.a aVar = this.f130012c;
        if (aVar != null) {
            aVar.onSuccess();
        }
    }
}
