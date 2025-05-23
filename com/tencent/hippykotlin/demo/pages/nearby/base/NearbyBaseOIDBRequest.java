package com.tencent.hippykotlin.demo.pages.nearby.base;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class NearbyBaseOIDBRequest<Req extends e, Rsp extends e> extends BaseOIDBRequest<Req, Rsp> {
    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 1;
    }
}
