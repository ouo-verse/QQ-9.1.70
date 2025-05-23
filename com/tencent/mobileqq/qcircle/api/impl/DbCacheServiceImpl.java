package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IDbCacheService;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DbCacheServiceImpl implements IDbCacheService {
    @Override // com.tencent.mobileqq.qcircle.api.IDbCacheService
    public void close() {
        com.tencent.mobileqq.qcircle.api.db.b.g().b();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IDbCacheService
    public IDBManagerWrapper getCacheManager(Class<? extends IDBCacheDataWrapper> cls, long j3, String str) {
        return com.tencent.mobileqq.qcircle.api.db.b.g().e(cls, j3, str);
    }
}
