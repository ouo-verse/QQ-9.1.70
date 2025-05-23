package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
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
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class GCPIconButtonItem extends ComposeView<GCPIconButtonItemAttr, l> {
    public static final Companion Companion = new Companion();
    public final GCPIconButtonItemAttr viewAttr = new GCPIconButtonItemAttr();

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
    public static final /* synthetic */ GCPIconButtonItemAttr access$getAttr(GCPIconButtonItem gCPIconButtonItem) {
        return (GCPIconButtonItemAttr) gCPIconButtonItem.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.alignItemsCenter();
                        mVar2.mo141height(40.0f);
                        mVar2.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                final GCPIconButtonItem gCPIconButtonItem = GCPIconButtonItem.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final Event event2 = event;
                        final GCPIconButtonItem gCPIconButtonItem2 = GCPIconButtonItem.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str = GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData().jumpUrl;
                                Utils utils = Utils.INSTANCE;
                                String pagerId = event2.getPagerId();
                                utils.bridgeModule(pagerId).log(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("GCPActivityBannerEntranceView jump with schema ", str));
                                BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(event2), str, false, null, null, 30);
                                e generateReportParams = GCPIconButtonItem.Companion.generateReportParams(GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData(), GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).index + 1, GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).gameTab);
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
                final GCPIconButtonItem gCPIconButtonItem2 = GCPIconButtonItem.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(40.0f, 40.0f);
                                tVar2.borderRadius(4.0f);
                                tVar2.allCenter();
                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_backplate");
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPIconButtonItem gCPIconButtonItem3 = GCPIconButtonItem.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final GCPIconButtonItem gCPIconButtonItem4 = GCPIconButtonItem.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        if (SkinColor.INSTANCE.isNightMode(afVar2.getPagerId())) {
                                            b.a.b(afVar2, GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData().iconNight, false, 2, null);
                                        } else {
                                            b.a.b(afVar2, GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData().iconDefault, false, 2, null);
                                        }
                                        afVar2.o();
                                        afVar2.size(24.0f, 24.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPIconButtonItem gCPIconButtonItem3 = GCPIconButtonItem.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.alignItemsFlexStart();
                                tVar2.justifyContentCenter();
                                tVar2.marginLeft(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPIconButtonItem gCPIconButtonItem4 = GCPIconButtonItem.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GCPIconButtonItem gCPIconButtonItem5 = GCPIconButtonItem.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h blackTextColor;
                                        ce ceVar2 = ceVar;
                                        blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                        ceVar2.color(blackTextColor);
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.text(GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData().title);
                                        ceVar2.lines(1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPIconButtonItem gCPIconButtonItem5 = GCPIconButtonItem.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GCPIconButtonItem gCPIconButtonItem6 = GCPIconButtonItem.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h subTextColor;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(2.0f);
                                        subTextColor = SkinColor.INSTANCE.subTextColor(BridgeManager.f117344a.u());
                                        ceVar2.color(subTextColor);
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.text(GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData().subTitle);
                                        ceVar2.lines(1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPIconButtonItem gCPIconButtonItem4 = GCPIconButtonItem.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GCPIconButtonItemAttr access$getAttr = GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this);
                        return Integer.valueOf(((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPIconButtonItemAttr.$$delegatedProperties[0])).intValue());
                    }
                };
                final GCPIconButtonItem gCPIconButtonItem5 = GCPIconButtonItem.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPIconButtonItem$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        GCPIconButtonItemAttr access$getAttr = GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this);
                        if (((Number) access$getAttr.pageDidAppearTimes$delegate.getValue(access$getAttr, GCPIconButtonItemAttr.$$delegatedProperties[0])).intValue() == 1) {
                            Utils.INSTANCE.logToNative("GCPIconButtonItem pageDidAppear");
                            e generateReportParams = GCPIconButtonItem.Companion.generateReportParams(GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).getActivityData(), GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).index + 1, GCPIconButtonItem.access$getAttr(GCPIconButtonItem.this).gameTab);
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
