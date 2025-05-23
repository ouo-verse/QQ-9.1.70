package com.tencent.hippykotlin.demo.pages.nearby.main.control.login;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.kuikly.core.log.KLog;
import f35.g;
import f35.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import zz0.a;

/* loaded from: classes31.dex */
public final class NBPMainLoginRepo$login$1 extends Lambda implements Function1<PbResponse<g>, Unit> {
    public final /* synthetic */ long $beginTime;
    public final /* synthetic */ Function3<Integer, String, g, Unit> $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPMainLoginRepo$login$1(long j3, Function3<? super Integer, ? super String, ? super g, Unit> function3) {
        super(1);
        this.$beginTime = j3;
        this.$callback = function3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<g> pbResponse) {
        l lVar;
        PbResponse<g> pbResponse2 = pbResponse;
        long a16 = a.f453719a.a();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("login, code: ");
        m3.append(pbResponse2.code);
        m3.append(", msg: ");
        m3.append(pbResponse2.f114187msg);
        m3.append(" costTime:");
        m3.append(a16 - this.$beginTime);
        m3.append(", verifiedStatus:");
        g gVar = pbResponse2.rsp;
        m3.append((gVar == null || (lVar = gVar.f397804i) == null) ? null : Integer.valueOf(lVar.f397820d));
        m3.append(", isNewUser:");
        g gVar2 = pbResponse2.rsp;
        m3.append(gVar2 != null ? Boolean.valueOf(gVar2.C) : null);
        kLog.i("NBPMainLoginRepo", m3.toString());
        this.$callback.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg, pbResponse2.rsp);
        return Unit.INSTANCE;
    }
}
