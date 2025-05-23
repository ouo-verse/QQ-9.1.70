package com.tencent.hippykotlin.demo.pages.nearby.public_account.repo;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy;
import com.tencent.kuikly.core.log.KLog;
import n25.k;
import o25.e;
import o35.c;
import o35.d;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetCardListRequest implements IBizRequestByProxy<c, d> {
    public final int appId;
    public final String cookies;
    public final e coordinate;
    public final m25.c ext;
    public final k poiInfo;
    public final byte[] redExt;

    public GetCardListRequest(int i3, e eVar, k kVar, byte[] bArr, String str, m25.c cVar) {
        this.appId = i3;
        this.coordinate = eVar;
        this.poiInfo = kVar;
        this.redExt = bArr;
        this.cookies = str;
        this.ext = cVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final d decodeResponse(byte[] bArr) {
        try {
            return (d) i.b(new d(null, false, null, null, false, 31, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("GetCardListRequest", "GetCardListRequest decode error: " + th5);
            return new d(null, false, null, null, false, 31, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetCardList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final c getRequest() {
        return new c(this.cookies, this.coordinate, this.poiInfo, new a(this.redExt), this.ext);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.CardSvr";
    }
}
