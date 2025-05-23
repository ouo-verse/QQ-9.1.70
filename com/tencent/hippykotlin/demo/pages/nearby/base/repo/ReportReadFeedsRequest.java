package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.kuikly.core.log.KLog;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import m25.c;
import s25.g;
import s25.h;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ReportReadFeedsRequest extends NearbyBasePbRequest<g, h> {
    public g req;

    public ReportReadFeedsRequest(int i3, List<String> list) {
        List mutableList;
        c commonExtInfo = getCommonExtInfo();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        this.req = new g(commonExtInfo, i3, mutableList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        h hVar = new h(null);
        try {
            return (h) i.b(new h(null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("ReportReadFeedsRequest error: ", th5, KLog.INSTANCE, "ReportReadFeedsRequest");
            return hVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.feed_svr.StatusWrite.SsoReportReadFeeds";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return this.req;
    }
}
