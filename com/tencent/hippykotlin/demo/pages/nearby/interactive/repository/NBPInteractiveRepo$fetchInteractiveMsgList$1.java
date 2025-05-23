package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.kuikly.core.log.KLog;
import j35.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPInteractiveRepo$fetchInteractiveMsgList$1 extends Lambda implements Function1<PbResponse<f>, Unit> {
    public final /* synthetic */ Function1<f, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPInteractiveRepo$fetchInteractiveMsgList$1(Function1<? super f, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<f> pbResponse) {
        PbResponse<f> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchInteractiveGroupMsgList code:");
        m3.append(pbResponse2.code);
        m3.append(", msg:");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPInteractiveRepo");
        if (pbResponse2.success) {
            this.$callback.invoke(pbResponse2.rsp);
        } else {
            this.$callback.invoke(null);
        }
        return Unit.INSTANCE;
    }
}
