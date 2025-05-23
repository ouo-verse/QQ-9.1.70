package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class GCPGameActivityCard extends ComposeView<GCPGameActivityCardAttr, l> {
    public static final Companion Companion = new Companion();
    public boolean hasReportedExp;
    public int buttonStatusForReport = 3;
    public final GCPGameActivityCardAttr viewAttr = new GCPGameActivityCardAttr();

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final e generateReportParams(GameCard gameCard, GameTab gameTab, boolean z16, int i3) {
            e eVar = new e();
            eVar.v(CrashRtInfoHolder.BeaconKey.GAME_NAME, gameCard.title);
            eVar.v("game_id", gameCard.f114191id);
            eVar.t("is_cloud_gaming", z16 ? 1 : 2);
            eVar.t("button_type", i3);
            if (gameTab != null) {
                eVar.v("second_tab_name", gameTab.name);
            }
            return eVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameActivityCardAttr access$getAttr(GCPGameActivityCard gCPGameActivityCard) {
        return (GCPGameActivityCardAttr) gCPGameActivityCard.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float f16 = ((GCPGameActivityCardAttr) getAttr()).cardHeight;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f17 = f16;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo141height(f17);
                        return Unit.INSTANCE;
                    }
                });
                final float f18 = f16;
                final GCPGameActivityCard gCPGameActivityCard = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f19 = f18;
                        final GCPGameActivityCard gCPGameActivityCard2 = gCPGameActivityCard;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.borderRadius(8.0f);
                                tVar2.mo141height(f19);
                                GCPGameActivityCard gCPGameActivityCard3 = gCPGameActivityCard2;
                                if (GCPGameActivityCard.access$getAttr(gCPGameActivityCard3).index != 0) {
                                    tVar2.marginLeft(14.0f);
                                } else {
                                    tVar2.marginLeft(16.0f);
                                }
                                if (GCPGameActivityCard.access$getAttr(gCPGameActivityCard3).listSize > 1 && GCPGameActivityCard.access$getAttr(gCPGameActivityCard3).index == GCPGameActivityCard.access$getAttr(gCPGameActivityCard3).listSize - 1) {
                                    tVar2.marginRight(16.0f);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameActivityCard gCPGameActivityCard3 = gCPGameActivityCard;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final GCPGameActivityCard gCPGameActivityCard4 = GCPGameActivityCard.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(u.this.getPagerId()), GCPGameActivityCard.access$getAttr(gCPGameActivityCard4).getActivityData().detailUrl, false, null, null, 30);
                                        e generateReportParams = GCPGameActivityCard.Companion.generateReportParams(GCPGameActivityCard.access$getAttr(gCPGameActivityCard4).getActivityData(), GCPGameActivityCard.access$getAttr(gCPGameActivityCard4).gameTab, GCPGameActivityCard.access$getAttr(gCPGameActivityCard4).getActivityData().enableCloudPlay, gCPGameActivityCard4.buttonStatusForReport);
                                        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                        Iterator<String> c16 = generateReportParams.c();
                                        while (c16.hasNext()) {
                                            String next = c16.next();
                                            m3.v(next, generateReportParams.p(next));
                                        }
                                        Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_clk", m3);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPGameActivityCard gCPGameActivityCard5 = GCPGameActivityCard.this;
                                VisibilityEventKt.a(uVar2, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f26) {
                                        float floatValue = f26.floatValue();
                                        if (floatValue >= 0.5d) {
                                            GCPGameActivityCardAttr access$getAttr = GCPGameActivityCard.access$getAttr(GCPGameActivityCard.this);
                                            if (((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPGameActivityCardAttr.$$delegatedProperties[0])).intValue() == 1 && !GCPGameActivityCard.this.hasReportedExp) {
                                                Utils.INSTANCE.logToNative("GCPGameActivityCard reportGameContentGameCardExp percent:" + floatValue + TokenParser.SP + GCPGameActivityCard.access$getAttr(GCPGameActivityCard.this).getActivityData().title);
                                                GCPGameActivityCard gCPGameActivityCard6 = GCPGameActivityCard.this;
                                                gCPGameActivityCard6.hasReportedExp = true;
                                                e generateReportParams = GCPGameActivityCard.Companion.generateReportParams(GCPGameActivityCard.access$getAttr(gCPGameActivityCard6).getActivityData(), GCPGameActivityCard.access$getAttr(GCPGameActivityCard.this).gameTab, GCPGameActivityCard.access$getAttr(GCPGameActivityCard.this).getActivityData().enableCloudPlay, GCPGameActivityCard.this.buttonStatusForReport);
                                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                                Iterator<String> c16 = generateReportParams.c();
                                                while (c16.hasNext()) {
                                                    String next = c16.next();
                                                    m3.v(next, generateReportParams.p(next));
                                                }
                                                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_exp", m3);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameActivityCard gCPGameActivityCard4 = gCPGameActivityCard;
                        final float f26 = f18;
                        vVar2.addChild(new GCPGameInfoCardView(), new Function1<GCPGameInfoCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPGameInfoCardView gCPGameInfoCardView) {
                                GCPGameInfoCardView gCPGameInfoCardView2 = gCPGameInfoCardView;
                                final GCPGameActivityCard gCPGameActivityCard5 = GCPGameActivityCard.this;
                                final float f27 = f26;
                                gCPGameInfoCardView2.attr(new Function1<GCPActivityInfoViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPActivityInfoViewAttr gCPActivityInfoViewAttr) {
                                        GCPActivityInfoViewAttr gCPActivityInfoViewAttr2 = gCPActivityInfoViewAttr;
                                        gCPActivityInfoViewAttr2.data = GCPGameActivityCard.access$getAttr(GCPGameActivityCard.this).getActivityData();
                                        gCPActivityInfoViewAttr2.gameTab = GCPGameActivityCard.access$getAttr(GCPGameActivityCard.this).gameTab;
                                        gCPActivityInfoViewAttr2.mo141height(f27);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPGameActivityCard gCPGameActivityCard6 = GCPGameActivityCard.this;
                                gCPGameInfoCardView2.event(new Function1<GCPActivityInfoViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPActivityInfoViewEvent gCPActivityInfoViewEvent) {
                                        GCPActivityInfoViewEvent gCPActivityInfoViewEvent2 = gCPActivityInfoViewEvent;
                                        final GCPGameActivityCard gCPGameActivityCard7 = GCPGameActivityCard.this;
                                        gCPActivityInfoViewEvent2.register("statusChange", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GCPGameActivityCard gCPGameActivityCard8 = GCPGameActivityCard.this;
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                                gCPGameActivityCard8.buttonStatusForReport = ((e) obj).k("status", 3);
                                                e generateReportParams = GCPGameActivityCard.Companion.generateReportParams(GCPGameActivityCard.access$getAttr(gCPGameActivityCard8).getActivityData(), GCPGameActivityCard.access$getAttr(gCPGameActivityCard8).gameTab, GCPGameActivityCard.access$getAttr(gCPGameActivityCard8).getActivityData().enableCloudPlay, gCPGameActivityCard8.buttonStatusForReport);
                                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                                Iterator<String> c16 = generateReportParams.c();
                                                while (c16.hasNext()) {
                                                    String next = c16.next();
                                                    m3.v(next, generateReportParams.p(next));
                                                }
                                                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_button_change", m3);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GCPGameActivityCard gCPGameActivityCard8 = GCPGameActivityCard.this;
                                        gCPActivityInfoViewEvent2.register("buttonClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCard.body.1.2.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GCPGameActivityCard gCPGameActivityCard9 = GCPGameActivityCard.this;
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                                if (Intrinsics.areEqual(((e) obj).q("buttonClickFrom", ""), "PARAMS_IS_FROM_NORMAL_BUTTON")) {
                                                    e generateReportParams = GCPGameActivityCard.Companion.generateReportParams(GCPGameActivityCard.access$getAttr(gCPGameActivityCard9).getActivityData(), GCPGameActivityCard.access$getAttr(gCPGameActivityCard9).gameTab, GCPGameActivityCard.access$getAttr(gCPGameActivityCard9).getActivityData().enableCloudPlay, gCPGameActivityCard9.buttonStatusForReport);
                                                    e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                                    Iterator<String> c16 = generateReportParams.c();
                                                    while (c16.hasNext()) {
                                                        String next = c16.next();
                                                        m3.v(next, generateReportParams.p(next));
                                                    }
                                                    Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_download_clk", m3);
                                                } else {
                                                    e generateReportParams2 = GCPGameActivityCard.Companion.generateReportParams(GCPGameActivityCard.access$getAttr(gCPGameActivityCard9).getActivityData(), GCPGameActivityCard.access$getAttr(gCPGameActivityCard9).gameTab, GCPGameActivityCard.access$getAttr(gCPGameActivityCard9).getActivityData().enableCloudPlay, gCPGameActivityCard9.buttonStatusForReport);
                                                    e m16 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                                    Iterator<String> c17 = generateReportParams2.c();
                                                    while (c17.hasNext()) {
                                                        String next2 = c17.next();
                                                        m16.v(next2, generateReportParams2.p(next2));
                                                    }
                                                    Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_cloud_clk", m16);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
