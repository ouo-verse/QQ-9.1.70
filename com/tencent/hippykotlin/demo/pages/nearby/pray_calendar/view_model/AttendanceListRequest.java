package com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import g35.b;
import g35.c;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AttendanceListRequest extends NearbyBaseOIDBRequest<b, c> {
    public final List<k25.c> dates;

    public AttendanceListRequest(List<k25.c> list) {
        this.dates = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e decodeResponse(byte[] bArr) {
        c cVar = new c(null, null, 3, null);
        try {
            return (c) i.b(new c(null, null, 3, null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("AttendanceListRequest error: ", th5, KLog.INSTANCE, "AttendanceListRequest");
            return cVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37597;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e getRequest() {
        List mutableList;
        m25.c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.dates);
        return new b(commonExtInfo, mutableList);
    }
}
