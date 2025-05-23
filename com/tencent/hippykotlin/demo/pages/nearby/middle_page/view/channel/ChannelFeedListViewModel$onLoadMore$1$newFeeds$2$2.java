package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import l25.a;
import l25.b;
import l25.c;
import l25.j;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class ChannelFeedListViewModel$onLoadMore$1$newFeeds$2$2 extends FunctionReferenceImpl implements Function1<c, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(c cVar) {
        b bVar;
        b bVar2;
        c cVar2 = cVar;
        ChannelFeedListViewModel channelFeedListViewModel = (ChannelFeedListViewModel) this.receiver;
        if (!channelFeedListViewModel.fastClickUtils.isFastDoubleClick()) {
            KLog kLog = KLog.INSTANCE;
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onClickItem: "), cVar2.f413744d, kLog, "ChannelFeedListViewModel");
            NBPMiddlePageDTReporter.reportElementClick$default(channelFeedListViewModel.dtReporter, "em_nearby_channel_dynamic_feed", null, null, 6);
            String str = cVar2.f413744d;
            a aVar = cVar2.f413749m;
            long j3 = 0;
            long j16 = (aVar == null || (bVar2 = aVar.f413740d) == null) ? 0L : bVar2.f413741d;
            if (aVar != null && (bVar = aVar.f413740d) != null) {
                j3 = bVar.f413742e;
            }
            j jVar = cVar2.f413747h;
            String str2 = jVar != null ? jVar.f413768d : null;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mqqguild://guild/openfeeddetail?guild_id=");
            sb5.append(j16);
            sb5.append("&channel_id=");
            sb5.append(j3);
            sb5.append("&feed_id=");
            sb5.append(str);
            String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, "&poster_tinyid=", str2);
            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("open scheme: ", m3, kLog, "ChannelFeedListViewModel");
            QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), m3, false, 6);
        }
        return Unit.INSTANCE;
    }

    public ChannelFeedListViewModel$onLoadMore$1$newFeeds$2$2(Object obj) {
        super(1, obj, ChannelFeedListViewModel.class, "onItemClick", "onItemClick(Lkuikly/com/tencent/trpcprotocol/lplan/common/channel_feed/ChFeed;)V", 0);
    }
}
