package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import m25.c;
import p35.ah;
import x25.n;
import x25.o;
import x25.p;

/* loaded from: classes31.dex */
public final class SetPoiTagsInfo extends NearbyBaseOIDBRequest<o, p> {
    public final ah poiInfo;
    public final List<n> tags;

    public SetPoiTagsInfo(ah ahVar, List<n> list) {
        this.poiInfo = ahVar;
        this.tags = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (p) i.b(new p(), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPPOIRepo", "decode SetPoiTagRsp error: " + th5);
            return new p();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37674;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e getRequest() {
        List mutableList;
        c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        ah ahVar = this.poiInfo;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.tags);
        return new o(commonExtInfo, ahVar, mutableList);
    }
}
