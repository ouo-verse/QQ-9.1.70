package com.tencent.hippykotlin.demo.pages.nearby.base;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyApi$sendOIDBRequest$1 extends Lambda implements Function1<OIDBResponse<e>, Unit> {
    public final /* synthetic */ Function1<OIDBResponse<e>, Unit> $pbRspCallback;
    public final /* synthetic */ APICallTechReporter $reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyApi$sendOIDBRequest$1(APICallTechReporter aPICallTechReporter, Function1<? super OIDBResponse<e>, Unit> function1) {
        super(1);
        this.$reporter = aPICallTechReporter;
        this.$pbRspCallback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(OIDBResponse<e> oIDBResponse) {
        OIDBResponse<e> oIDBResponse2 = oIDBResponse;
        if (oIDBResponse2.success) {
            this.$reporter.reportSuccess();
        } else {
            this.$reporter.reportError(String.valueOf(oIDBResponse2.code));
        }
        this.$pbRspCallback.invoke(oIDBResponse2);
        return Unit.INSTANCE;
    }
}
