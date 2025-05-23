package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import n25.l;
import r25.e;
import s25.d;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedRepo$fetchFeedDetailInfo$1 extends Lambda implements Function1<PbResponse<d>, Unit> {
    public final /* synthetic */ Function2<d, Integer, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyFeedRepo$fetchFeedDetailInfo$1(Function2<? super d, ? super Integer, Unit> function2) {
        super(1);
        this.$callback = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<d> pbResponse) {
        l lVar;
        e eVar;
        PbResponse<d> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedDetailInfo, ");
        m3.append(pbResponse2.f114187msg);
        m3.append(", ");
        m3.append(pbResponse2.code);
        m3.append(", ");
        d dVar = pbResponse2.rsp;
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, (dVar == null || (lVar = dVar.f433131d) == null || (eVar = lVar.f418093e) == null) ? null : eVar.J, kLog, "NearbyFeedRepo");
        this.$callback.invoke(pbResponse2.rsp, Integer.valueOf(pbResponse2.code));
        return Unit.INSTANCE;
    }
}
