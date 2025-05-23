package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.repository;

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
import s35.v;
import u35.b;

/* loaded from: classes31.dex */
public final class NBPNewEditRepository$setUserInfo$1 extends Lambda implements Function1<PbResponse<b>, Unit> {
    public final /* synthetic */ int $appId;
    public final /* synthetic */ Function2<Integer, String, Unit> $errorBlock;
    public final /* synthetic */ int $sourceType = 0;
    public final /* synthetic */ Function1<v, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPNewEditRepository$setUserInfo$1(int i3, Function1 function1, Function2 function2) {
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
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("setUserInfo appId:");
        m3.append(this.$appId);
        m3.append(", source:");
        m3.append(this.$sourceType);
        m3.append(", proxy retcode:");
        m3.append(pbResponse2.code);
        m3.append(", rsp return code:");
        b bVar = pbResponse2.rsp;
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewEditRepository");
        if (pbResponse2.success && pbResponse2.rsp != null) {
            try {
                Function1<v, Unit> function1 = this.$successBlock;
                v vVar = new v(0, null, 3, null);
                b bVar2 = pbResponse2.rsp;
                Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                function1.invoke(i.b(vVar, bVar2.f438203f.f30291a));
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("setUserInfo decode error: ", th5, KLog.INSTANCE, "NBPNewEditRepository");
                this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
            }
        } else {
            this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), "");
        }
        return Unit.INSTANCE;
    }
}
