package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import m25.c;
import o25.f;
import v25.i;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyMapThemeRepo$fetchMapThemeList$1 extends Lambda implements Function1<PbResponse<i>, Unit> {
    public final /* synthetic */ Function2<Boolean, i, Unit> $callback;
    public final /* synthetic */ Ref.BooleanRef $isThemeInCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyMapThemeRepo$fetchMapThemeList$1(Ref.BooleanRef booleanRef, Function2<? super Boolean, ? super i, Unit> function2) {
        super(1);
        this.$isThemeInCache = booleanRef;
        this.$callback = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<i> pbResponse) {
        List<f> list;
        PbResponse<i> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetched from online, detail: code:");
        m3.append(pbResponse2.code);
        m3.append(", msg:");
        m3.append(pbResponse2.f114187msg);
        m3.append(", size:");
        i iVar = pbResponse2.rsp;
        c cVar = null;
        byte b16 = 0;
        byte b17 = 0;
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, (iVar == null || (list = iVar.f440858e) == null) ? null : Integer.valueOf(list.size()), kLog, "NearbyMapThemeRepo");
        if (pbResponse2.success) {
            i iVar2 = pbResponse2.rsp;
            if (iVar2 != null) {
                NearbyProUtilsKt.setCachedMapThemeList(iVar2);
            }
            if (!this.$isThemeInCache.element) {
                Function2<Boolean, i, Unit> function2 = this.$callback;
                Boolean bool = Boolean.TRUE;
                i iVar3 = pbResponse2.rsp;
                if (iVar3 == null) {
                    iVar3 = new i(cVar, b17 == true ? 1 : 0, 3, b16 == true ? 1 : 0);
                }
                function2.invoke(bool, iVar3);
                kLog.i("NearbyMapThemeRepo", "Callback from online data");
            }
        }
        return Unit.INSTANCE;
    }
}
