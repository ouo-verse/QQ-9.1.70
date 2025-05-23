package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import c45.d;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class SearchNetApi$sendOidbPbRequest$1 extends Lambda implements Function1<OIDBResponse<d>, Unit> {
    public final /* synthetic */ Function1<OIDBResponse<d>, Unit> $pbRspCallback;
    public final /* synthetic */ BaseOIDBRequest<Object, Object> $request;
    public final /* synthetic */ long $startTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchNetApi$sendOidbPbRequest$1(long j3, BaseOIDBRequest<Object, Object> baseOIDBRequest, Function1<? super OIDBResponse<d>, Unit> function1) {
        super(1);
        this.$startTime = j3;
        this.$request = baseOIDBRequest;
        this.$pbRspCallback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(OIDBResponse<d> oIDBResponse) {
        OIDBResponse<d> oIDBResponse2 = oIDBResponse;
        QSearchReportKt.reportNetQuality(this.$request.getCmd(), (int) (QSearchUtilKt.getTimeStamp() - this.$startTime), oIDBResponse2.code, "");
        this.$pbRspCallback.invoke(oIDBResponse2);
        return Unit.INSTANCE;
    }
}
