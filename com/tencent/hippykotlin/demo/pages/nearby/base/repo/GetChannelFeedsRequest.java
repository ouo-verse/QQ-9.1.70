package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.ah;
import x25.e;
import x25.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetChannelFeedsRequest extends NearbyBaseOIDBRequest<e, f> {
    public final String cookies;
    public final int count = 10;
    public final long guildId;
    public final ah poiInfo;

    public GetChannelFeedsRequest(ah ahVar, String str, long j3) {
        this.poiInfo = ahVar;
        this.cookies = str;
        this.guildId = j3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e decodeResponse(byte[] bArr) {
        try {
            return (f) i.b(new f(null, false, null, null, 15, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPPOIRepo", "decode GetChannelFeedsRsp error: " + th5);
            return new f(null, false, null, null, 15, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37672;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e getRequest() {
        return new e(UserDataManager.INSTANCE.getCommonExtInfo(), this.poiInfo, this.count, this.cookies, this.guildId);
    }
}
