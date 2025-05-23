package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import v25.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyMapThemeRepo$fetchFeedShareInfo$1 extends Lambda implements Function1<PbResponse<e>, Unit> {
    public final /* synthetic */ Function1<PbResponse<e>, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyMapThemeRepo$fetchFeedShareInfo$1(Function1<? super PbResponse<e>, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<e> pbResponse) {
        PbResponse<e> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch feed share info result: ");
        m3.append(pbResponse2.code);
        m3.append(", ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NearbyMapThemeRepo");
        this.$callback.invoke(pbResponse2);
        return Unit.INSTANCE;
    }
}
