package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import l25.c;
import l25.g;
import l25.h;
import l25.i;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class ChannelFeedListViewModel$onLoadMore$1$newFeeds$2$1 extends FunctionReferenceImpl implements Function2<c, Float, Unit> {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit invoke(c cVar, Float f16) {
        final String str;
        List<h> list;
        Object firstOrNull;
        i iVar;
        c cVar2 = cVar;
        final float floatValue = f16.floatValue();
        final ChannelFeedListViewModel channelFeedListViewModel = (ChannelFeedListViewModel) this.receiver;
        int i3 = ChannelFeedListViewModel.$r8$clinit;
        channelFeedListViewModel.getClass();
        String str2 = cVar2.f413744d;
        if (!channelFeedListViewModel.exposedFeeds.contains(str2)) {
            channelFeedListViewModel.exposedFeeds.add(str2);
            g gVar = cVar2.f413745e;
            if (gVar != null && (list = gVar.f413762d) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                h hVar = (h) firstOrNull;
                if (hVar != null && (iVar = hVar.f413766f) != null) {
                    str = iVar.f413767d;
                    if (floatValue >= channelFeedListViewModel.collapsedHeight) {
                        KLog.INSTANCE.d("ChannelFeedListViewModel", "\u66dd\u5149 " + str + TokenParser.SP + floatValue + '/' + channelFeedListViewModel.collapsedHeight);
                        NBPMiddlePageDTReporter.reportElementImp$default(channelFeedListViewModel.dtReporter, "em_nearby_channel_dynamic_feed", null, 6);
                    } else {
                        channelFeedListViewModel.listExpandedWaitingTask.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewModel$onItemExpose$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Unit unit) {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u5ef6\u8fdf\u66dd\u5149 ");
                                m3.append(str);
                                m3.append(TokenParser.SP);
                                m3.append(floatValue);
                                m3.append('/');
                                m3.append(channelFeedListViewModel.collapsedHeight);
                                kLog.d("ChannelFeedListViewModel", m3.toString());
                                NBPMiddlePageDTReporter.reportElementImp$default(channelFeedListViewModel.dtReporter, "em_nearby_channel_dynamic_feed", null, 6);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
            }
            str = null;
            if (floatValue >= channelFeedListViewModel.collapsedHeight) {
            }
        }
        return Unit.INSTANCE;
    }

    public ChannelFeedListViewModel$onLoadMore$1$newFeeds$2$1(Object obj) {
        super(2, obj, ChannelFeedListViewModel.class, "onItemExpose", "onItemExpose(Lkuikly/com/tencent/trpcprotocol/lplan/common/channel_feed/ChFeed;F)V", 0);
    }
}
