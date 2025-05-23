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
import s35.k;
import u35.b;

/* loaded from: classes31.dex */
public final class NBPNewHomeRepository$fetchTacitList$1 extends Lambda implements Function1<PbResponse<b>, Unit> {
    public final /* synthetic */ String $accountId;
    public final /* synthetic */ int $accountType;
    public final /* synthetic */ int $appId;
    public final /* synthetic */ Function2<Integer, String, Unit> $errorBlock;
    public final /* synthetic */ Function1<k, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPNewHomeRepository$fetchTacitList$1(int i3, int i16, String str, Function1<? super k, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
        super(1);
        this.$appId = i3;
        this.$accountType = i16;
        this.$accountId = str;
        this.$successBlock = function1;
        this.$errorBlock = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PbResponse<b> pbResponse) {
        PbResponse<b> pbResponse2 = pbResponse;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchTacitList: appId:");
        m3.append(this.$appId);
        m3.append(", accountType:");
        m3.append(this.$accountType);
        m3.append(", accountId:");
        m3.append(this.$accountId);
        m3.append(", proxy retcode:");
        m3.append(pbResponse2.code);
        m3.append(" rsp return code:");
        b bVar = pbResponse2.rsp;
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewHomeRepository");
        if (pbResponse2.success && pbResponse2.rsp != null) {
            try {
                k kVar = new k(0, null, null, 7, null);
                b bVar2 = pbResponse2.rsp;
                Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                k kVar2 = (k) i.b(kVar, bVar2.f438203f.f30291a);
                int i3 = kVar2.f433246d;
                if (i3 == 0) {
                    this.$successBlock.invoke(kVar2);
                } else {
                    this.$errorBlock.invoke(Integer.valueOf(i3), "retCode != 0");
                }
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchTacitList decode error: ", th5, KLog.INSTANCE, "NBPNewHomeRepository");
                this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
            }
        } else {
            this.$errorBlock.invoke(Integer.valueOf(pbResponse2.code), "");
        }
        return Unit.INSTANCE;
    }
}
