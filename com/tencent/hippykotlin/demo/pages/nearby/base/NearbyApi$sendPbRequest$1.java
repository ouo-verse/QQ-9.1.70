package com.tencent.hippykotlin.demo.pages.nearby.base;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NearbyApi$sendPbRequest$1 extends Lambda implements Function1<PbResponse<e>, Unit> {
    public final /* synthetic */ Function1<PbResponse<e>, Unit> $pbRspCallback;
    public final /* synthetic */ APICallTechReporter $reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyApi$sendPbRequest$1(APICallTechReporter aPICallTechReporter, Function1<? super PbResponse<e>, Unit> function1) {
        super(1);
        this.$reporter = aPICallTechReporter;
        this.$pbRspCallback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<e> pbResponse) {
        PbResponse<e> pbResponse2 = pbResponse;
        if (pbResponse2.success) {
            this.$reporter.reportSuccess();
        } else {
            this.$reporter.reportError(String.valueOf(pbResponse2.code));
        }
        this.$pbRspCallback.invoke(pbResponse2);
        return Unit.INSTANCE;
    }
}
