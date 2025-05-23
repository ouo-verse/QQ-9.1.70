package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u35.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFollowRepo$setFollowState$1 extends Lambda implements Function1<PbResponse<b>, Unit> {
    public final /* synthetic */ int $appId;
    public final /* synthetic */ Function2<Integer, String, Unit> $errorBlock;
    public final /* synthetic */ int $operationType;
    public final /* synthetic */ Function1<q35.b, Unit> $successBlock;
    public final /* synthetic */ String $toUserTid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyFollowRepo$setFollowState$1(int i3, Function1<? super q35.b, Unit> function1, Function2<? super Integer, ? super String, Unit> function2, String str, int i16) {
        super(1);
        this.$appId = i3;
        this.$successBlock = function1;
        this.$errorBlock = function2;
        this.$toUserTid = str;
        this.$operationType = i16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<b> pbResponse) {
        PbResponse<b> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doFollow: appId:");
        m3.append(this.$appId);
        m3.append(", proxy retcode:");
        m3.append(pbResponse2.code);
        m3.append(" rsp return code:");
        b bVar = pbResponse2.rsp;
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NearbyFollowRepo");
        if (pbResponse2.success && pbResponse2.rsp != null) {
            try {
                Function1<q35.b, Unit> function1 = this.$successBlock;
                q35.b bVar2 = new q35.b(null, 1, null);
                b bVar3 = pbResponse2.rsp;
                Intrinsics.checkNotNull(bVar3, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                function1.invoke(i.b(bVar2, bVar3.f438203f.f30291a));
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("doFollow decode error: ", th5, KLog.INSTANCE, "NearbyFollowRepo");
                this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
            }
            k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
            e eVar = new e();
            String str = this.$toUserTid;
            int i3 = this.$operationType;
            eVar.v("accountId", str);
            eVar.w("doFollow", i3 == 1);
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", eVar, false, 4, null);
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doFollow error: ");
            m16.append(pbResponse2.code);
            kLog.e("NearbyFollowRepo", m16.toString());
            this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
        }
        return Unit.INSTANCE;
    }
}
