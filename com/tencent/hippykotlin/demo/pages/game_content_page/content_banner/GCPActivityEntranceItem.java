package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
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
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class GCPActivityEntranceItem extends ComposeView<GCPActivityEntranceItemAttr, l> {
    public static final Companion Companion = new Companion();
    public final GCPActivityEntranceItemAttr viewAttr = new GCPActivityEntranceItemAttr();

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final e generateReportParams(IconButton iconButton, int i3, GameTab gameTab) {
            e eVar = new e();
            eVar.v("entrance_name", iconButton.title);
            eVar.t("entrance_position", i3);
            if (gameTab != null) {
                eVar.v("second_tab_name", gameTab.name);
            }
            return eVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPActivityEntranceItemAttr access$getAttr(GCPActivityEntranceItem gCPActivityEntranceItem) {
        return (GCPActivityEntranceItemAttr) gCPActivityEntranceItem.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.justifyContentCenter();
                        mVar2.alignItemsCenter();
                        mVar2.mo141height(77.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GCPActivityEntranceItem gCPActivityEntranceItem = GCPActivityEntranceItem.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final Event event2 = event;
                        final GCPActivityEntranceItem gCPActivityEntranceItem2 = GCPActivityEntranceItem.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str = GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).getActivityData().jumpUrl;
                                Utils utils = Utils.INSTANCE;
                                String pagerId = event2.getPagerId();
                                utils.bridgeModule(pagerId).log(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("GCPActivityBannerEntranceView jump with schema ", str));
                                BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(event2), str, false, null, null, 30);
                                e generateReportParams = GCPActivityEntranceItem.Companion.generateReportParams(GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).getActivityData(), GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).index + 1, GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).gameTab);
                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                Iterator<String> c16 = generateReportParams.c();
                                while (c16.hasNext()) {
                                    String next = c16.next();
                                    m3.v(next, generateReportParams.p(next));
                                }
                                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_functional_entrance_clk", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPActivityEntranceItem gCPActivityEntranceItem2 = GCPActivityEntranceItem.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final GCPActivityEntranceItem gCPActivityEntranceItem3 = GCPActivityEntranceItem.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                if (SkinColor.INSTANCE.isNightMode(afVar2.getPagerId())) {
                                    b.a.b(afVar2, GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).getActivityData().iconNight, false, 2, null);
                                } else {
                                    b.a.b(afVar2, GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).getActivityData().iconDefault, false, 2, null);
                                }
                                afVar2.size(24.0f, 24.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPActivityEntranceItem gCPActivityEntranceItem3 = GCPActivityEntranceItem.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GCPActivityEntranceItem gCPActivityEntranceItem4 = GCPActivityEntranceItem.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h blackTextColor;
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(4.0f);
                                blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                ceVar2.color(blackTextColor);
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.fontFamily("PingFang SC");
                                ceVar2.text(GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).getActivityData().title);
                                ceVar2.lines(1);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPActivityEntranceItem gCPActivityEntranceItem4 = GCPActivityEntranceItem.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GCPActivityEntranceItemAttr access$getAttr = GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this);
                        return Integer.valueOf(((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPActivityEntranceItemAttr.$$delegatedProperties[0])).intValue());
                    }
                };
                final GCPActivityEntranceItem gCPActivityEntranceItem5 = GCPActivityEntranceItem.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPActivityEntranceItem$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        GCPActivityEntranceItemAttr access$getAttr = GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this);
                        if (((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPActivityEntranceItemAttr.$$delegatedProperties[0])).intValue() == 1) {
                            Utils.INSTANCE.logToNative("GCPActivityBannerView pageDidAppear");
                            e generateReportParams = GCPActivityEntranceItem.Companion.generateReportParams(GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).getActivityData(), GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).index + 1, GCPActivityEntranceItem.access$getAttr(GCPActivityEntranceItem.this).gameTab);
                            e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                            Iterator<String> c16 = generateReportParams.c();
                            while (c16.hasNext()) {
                                String next = c16.next();
                                m3.v(next, generateReportParams.p(next));
                            }
                            Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_functional_entrance_exp", m3);
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
