package com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page;

import com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardCompose;
import com.tencent.hippykotlin.demo.pages.hrc_pages.HippyRenderCardPage;
import com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LiveExplainCard;
import com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class LiveRoomPage extends HippyRenderCardPage {
    public LiveRoomPage() {
        registerCard("KTVLivePendantCard", new Function1<e, HippyRenderCardCompose<?>>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.LiveRoomPage.1
            @Override // kotlin.jvm.functions.Function1
            public final HippyRenderCardCompose<?> invoke(e eVar) {
                return new LuckyBagPendantCard();
            }
        });
        registerCard("LiveExplainCard", new Function1<e, HippyRenderCardCompose<?>>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.LiveRoomPage.2
            @Override // kotlin.jvm.functions.Function1
            public final HippyRenderCardCompose<?> invoke(e eVar) {
                return new LiveExplainCard();
            }
        });
    }
}
