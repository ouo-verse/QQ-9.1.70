package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.log.KLog;
import k25.b;
import k25.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPAttendanceService$getAttendanceStatus$1 extends Lambda implements Function1<OIDBResponse<b>, Unit> {
    public final /* synthetic */ Function3<Boolean, String, b, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPAttendanceService$getAttendanceStatus$1(Function3<? super Boolean, ? super String, ? super b, Unit> function3) {
        super(1);
        this.$callback = function3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(OIDBResponse<b> oIDBResponse) {
        d dVar;
        OIDBResponse<b> oIDBResponse2 = oIDBResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getAttendanceStatus rsp: check = ");
        b bVar = oIDBResponse2.rsp;
        String str = null;
        m3.append(bVar != null ? Boolean.valueOf(bVar.f411442d) : null);
        m3.append("remindSwitch = ");
        b bVar2 = oIDBResponse2.rsp;
        m3.append(bVar2 != null ? Boolean.valueOf(bVar2.f411444f) : null);
        m3.append("accumulateAttendance = ");
        b bVar3 = oIDBResponse2.rsp;
        m3.append(bVar3 != null ? Integer.valueOf(bVar3.f411445h) : null);
        m3.append("luckyCard = ");
        b bVar4 = oIDBResponse2.rsp;
        if (bVar4 != null && (dVar = bVar4.f411443e) != null) {
            str = dVar.f411455m;
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, str, kLog, "NBPAttendanceService");
        this.$callback.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg, oIDBResponse2.rsp);
        return Unit.INSTANCE;
    }
}
