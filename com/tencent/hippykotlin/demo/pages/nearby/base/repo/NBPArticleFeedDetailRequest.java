package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import s25.c;
import s25.d;

/* loaded from: classes31.dex */
public final class NBPArticleFeedDetailRequest extends NearbyBasePbRequest<c, d> {
    public final String feedId;

    public NBPArticleFeedDetailRequest(String str) {
        this.feedId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.feed_svr.StatusRead.SsoGetStatusDetail";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new c(this.feedId, UserDataManager.INSTANCE.getCommonExtInfo());
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (d) i.b(new d(null, null, 3, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPArticleFeedDetailRequest", "NBPArticleFeedDetailRequest decode error: " + th5);
            return new d(null, null, 3, null);
        }
    }
}
