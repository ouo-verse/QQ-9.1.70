package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class GCPGameActivityCardEntranceItem extends ComposeView<GCPGameActivityCardEntranceItemAttr, l> {
    public final GCPGameActivityCardEntranceItemAttr viewAttr = new GCPGameActivityCardEntranceItemAttr();

    public static final e access$generateReportParams(GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem, GameCard gameCard, GameTab gameTab, boolean z16, IconButton iconButton, int i3) {
        gCPGameActivityCardEntranceItem.getClass();
        e eVar = new e();
        eVar.v(CrashRtInfoHolder.BeaconKey.GAME_NAME, gameCard.title);
        eVar.v("game_id", gameCard.f114191id);
        eVar.t("is_cloud_gaming", z16 ? 1 : 2);
        eVar.v("entrance_name", iconButton.title);
        eVar.t("entrance_position", i3);
        if (gameTab != null) {
            eVar.v("second_tab_name", gameTab.name);
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameActivityCardEntranceItemAttr access$getAttr(GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem) {
        return (GCPGameActivityCardEntranceItemAttr) gCPGameActivityCardEntranceItem.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.justifyContentCenter();
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem = GCPGameActivityCardEntranceItem.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final Event event2 = event;
                        final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem2 = GCPGameActivityCardEntranceItem.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(Event.this.getPagerId()), GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem2).getButtonData().jumpUrl, false, null, null, 30);
                                GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem3 = gCPGameActivityCardEntranceItem2;
                                e access$generateReportParams = GCPGameActivityCardEntranceItem.access$generateReportParams(gCPGameActivityCardEntranceItem3, GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem3).getGameData(), GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem2).gameTab, GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem2).getGameData().enableCloudPlay, GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem2).getButtonData(), GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem2).index + 1);
                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                Iterator<String> c16 = access$generateReportParams.c();
                                while (c16.hasNext()) {
                                    String next = c16.next();
                                    m3.v(next, access$generateReportParams.p(next));
                                }
                                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_entrance_clk", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem2 = GCPGameActivityCardEntranceItem.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem3 = GCPGameActivityCardEntranceItem.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                b.a.b(afVar2, GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this).getButtonData().iconNight, false, 2, null);
                                afVar2.size(20.0f, 20.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem3 = GCPGameActivityCardEntranceItem.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem4 = GCPGameActivityCardEntranceItem.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(4.0f);
                                ceVar2.color(SkinColor.whiteTextColor);
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.fontWeightMedium();
                                ceVar2.fontFamily("PingFang SC");
                                ceVar2.text(GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this).getButtonData().title);
                                ceVar2.lines(1);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem4 = GCPGameActivityCardEntranceItem.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GCPGameActivityCardEntranceItemAttr access$getAttr = GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this);
                        return Integer.valueOf(((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPGameActivityCardEntranceItemAttr.$$delegatedProperties[0])).intValue());
                    }
                };
                final GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem5 = GCPGameActivityCardEntranceItem.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceItem$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        GCPGameActivityCardEntranceItemAttr access$getAttr = GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this);
                        if (((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPGameActivityCardEntranceItemAttr.$$delegatedProperties[0])).intValue() == 1) {
                            Utils.INSTANCE.logToNative("GCPGameActivityEntrance pageDidAppear");
                            GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem6 = GCPGameActivityCardEntranceItem.this;
                            e access$generateReportParams = GCPGameActivityCardEntranceItem.access$generateReportParams(gCPGameActivityCardEntranceItem6, GCPGameActivityCardEntranceItem.access$getAttr(gCPGameActivityCardEntranceItem6).getGameData(), GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this).gameTab, GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this).getGameData().enableCloudPlay, GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this).getButtonData(), GCPGameActivityCardEntranceItem.access$getAttr(GCPGameActivityCardEntranceItem.this).index + 1);
                            e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                            Iterator<String> c16 = access$generateReportParams.c();
                            while (c16.hasNext()) {
                                String next = c16.next();
                                m3.v(next, access$generateReportParams.p(next));
                            }
                            Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_game_card_entrance_exp", m3);
                        }
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
