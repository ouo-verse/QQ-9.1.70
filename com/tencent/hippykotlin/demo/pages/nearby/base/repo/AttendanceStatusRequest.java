package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import k25.a;
import k25.b;
import k25.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AttendanceStatusRequest extends NearbyBaseOIDBRequest<a, b> {
    public final c date;

    public AttendanceStatusRequest(c cVar) {
        this.date = cVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e decodeResponse(byte[] bArr) {
        b bVar = new b(false, null, false, 0, 15, null);
        try {
            return (b) i.b(new b(false, null, false, 0, 15, null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("AttendanceStatusRequest error: ", th5, KLog.INSTANCE, "AttendanceStatusRequest");
            return bVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37599;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e getRequest() {
        return new a(UserDataManager.INSTANCE.getCommonExtInfo(), this.date);
    }
}
