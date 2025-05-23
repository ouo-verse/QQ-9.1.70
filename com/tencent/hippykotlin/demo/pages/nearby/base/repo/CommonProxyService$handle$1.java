package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import u35.b;

/* loaded from: classes31.dex */
public final class CommonProxyService$handle$1 extends Lambda implements Function1<PbResponse<b>, Unit> {
    public final /* synthetic */ Function3<b, Integer, String, Unit> $callback;
    public final /* synthetic */ APICallTechReporter $reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonProxyService$handle$1(APICallTechReporter aPICallTechReporter, Function3<? super b, ? super Integer, ? super String, Unit> function3) {
        super(1);
        this.$reporter = aPICallTechReporter;
        this.$callback = function3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<b> pbResponse) {
        PbResponse<b> pbResponse2 = pbResponse;
        if (pbResponse2.success) {
            this.$reporter.reportSuccess();
        } else {
            this.$reporter.reportError(String.valueOf(pbResponse2.code));
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("rsp: ");
        m3.append(pbResponse2.code);
        m3.append(" - ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "CommonProxyService");
        this.$callback.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
        return Unit.INSTANCE;
    }
}
