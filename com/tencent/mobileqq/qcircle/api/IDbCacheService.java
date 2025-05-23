package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IDbCacheService extends QRouteApi {
    void close();

    IDBManagerWrapper getCacheManager(Class<? extends IDBCacheDataWrapper> cls, long j3, String str);
}
