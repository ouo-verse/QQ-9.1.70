package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import s35.ae;
import u35.b;

/* loaded from: classes31.dex */
public final class NBPNewHomeRepository$updateTagsInfo$1 extends Lambda implements Function1<PbResponse<b>, Unit> {
    public final /* synthetic */ int $appId;
    public final /* synthetic */ Function2<Integer, String, Unit> $errorBlock;
    public final /* synthetic */ Function1<ae, Unit> $successBlock;
    public final /* synthetic */ int $source = 0;
    public final /* synthetic */ int $tagOwner = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPNewHomeRepository$updateTagsInfo$1(int i3, Function1 function1, Function2 function2) {
        super(1);
        this.$appId = i3;
        this.$successBlock = function1;
        this.$errorBlock = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<b> pbResponse) {
        PbResponse<b> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateTagsInfo appId:");
        m3.append(this.$appId);
        m3.append(", source:");
        m3.append(this.$source);
        m3.append(", tags owner:");
        m3.append(this.$tagOwner);
        m3.append(", proxy retcode:");
        m3.append(pbResponse2.code);
        m3.append(", rsp return code:");
        b bVar = pbResponse2.rsp;
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewHomeRepository");
        if (pbResponse2.success && pbResponse2.rsp != null) {
            try {
                Function1<ae, Unit> function1 = this.$successBlock;
                ae aeVar = new ae(0, null, 3, null);
                b bVar2 = pbResponse2.rsp;
                Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                function1.invoke(i.b(aeVar, bVar2.f438203f.f30291a));
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("updateTagsInfo decode error: ", th5, KLog.INSTANCE, "NBPNewHomeRepository");
                this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
            }
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updateTagsInfo error: ");
            m16.append(pbResponse2.code);
            kLog.e("NBPNewHomeRepository", m16.toString());
            this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), "");
        }
        return Unit.INSTANCE;
    }
}
