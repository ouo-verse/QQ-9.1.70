package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.luggage.wxa.ig.w;
import kotlin.random.Random;
import n35.ah;
import n35.ai;
import n35.ak;
import n35.am;
import n35.d;
import n35.f;
import n35.n;
import n35.v;

/* loaded from: classes31.dex */
public final class DownloadPicReq extends BaseOIDBRequest<ah, ak> {
    public final ah reqBody;

    public DownloadPicReq(v vVar) {
        this.reqBody = new ah(new ai(new f(Random.INSTANCE.nextLong(), 200), new am(2, 1, 11, 5, w.CTRL_INDEX), new d(2)), new n(vVar, 2), 1018);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final ak decodeResponse(byte[] bArr) {
        try {
            return (ak) i.b(new ak(null, null, null, null, null, null, null, null, null, null, 1023, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("DownloadPicReq", "DownloadPicReq error: " + th5);
            return new ak(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 4777;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 200;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final ah getRequest() {
        return this.reqBody;
    }
}
