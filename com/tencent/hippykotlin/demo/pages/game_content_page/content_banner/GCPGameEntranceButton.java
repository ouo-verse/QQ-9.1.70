package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.b;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPGameEntranceButton extends ComposeView<GCPGameEntranceViewAttr, GCPGameEntranceViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPGameEntranceViewAttr access$getAttr(GCPGameEntranceButton gCPGameEntranceButton) {
        return (GCPGameEntranceViewAttr) gCPGameEntranceButton.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameEntranceButton gCPGameEntranceButton = GCPGameEntranceButton.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameEntranceButton gCPGameEntranceButton2 = GCPGameEntranceButton.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().enableCloudPlay);
                            }
                        };
                        final GCPGameEntranceButton gCPGameEntranceButton3 = GCPGameEntranceButton.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GCPGameEntranceButton gCPGameEntranceButton4 = GCPGameEntranceButton.this;
                                c.a(conditionView, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ButtonView buttonView) {
                                        ButtonView buttonView2 = buttonView;
                                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(a aVar) {
                                                a aVar2 = aVar;
                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.3.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u4e91\u73a9");
                                                        ceVar2.fontWeightSemisolid();
                                                        ceVar2.color(new h(4278190080L));
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                aVar2.mo153width(64.0f);
                                                aVar2.mo141height(32.0f);
                                                aVar2.mo113backgroundColor(new h(4294309365L));
                                                aVar2.borderRadius(4.0f);
                                                aVar2.marginRight(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GCPGameEntranceButton gCPGameEntranceButton5 = GCPGameEntranceButton.this;
                                        buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(b bVar) {
                                                final b bVar2 = bVar;
                                                final GCPGameEntranceButton gCPGameEntranceButton6 = GCPGameEntranceButton.this;
                                                bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.3.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(b.this.getPagerId()), GCPGameEntranceButton.access$getAttr(gCPGameEntranceButton6).getData().cloudPlayUrl, false, null, null, 30);
                                                        gCPGameEntranceButton6.emit("buttonClick", new e());
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
                        final GCPGameEntranceButton gCPGameEntranceButton4 = GCPGameEntranceButton.this;
                        vVar2.addChild(new GCPGameButton(), new Function1<GCPGameButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPGameButton gCPGameButton) {
                                GCPGameButton gCPGameButton2 = gCPGameButton;
                                final GCPGameEntranceButton gCPGameEntranceButton5 = GCPGameEntranceButton.this;
                                gCPGameButton2.attr(new Function1<GCPGameButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPGameButtonAttr gCPGameButtonAttr) {
                                        GCPGameButtonAttr gCPGameButtonAttr2 = gCPGameButtonAttr;
                                        gCPGameButtonAttr2.gameId = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().f114191id;
                                        gCPGameButtonAttr2.channelId = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().channelId;
                                        gCPGameButtonAttr2.detailUrl = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().detailUrl;
                                        String str = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().appStoreUrl;
                                        ReadWriteProperty readWriteProperty = gCPGameButtonAttr2.appStoreUrl$delegate;
                                        KProperty<?>[] kPropertyArr = GCPGameButtonAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(gCPGameButtonAttr2, kPropertyArr[1], str);
                                        gCPGameButtonAttr2.androidDownloadUrl$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[2], GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().appStoreUrl);
                                        gCPGameButtonAttr2.packName$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[0], GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().pkgName);
                                        gCPGameButtonAttr2.setButtonColor(h.INSTANCE.o(GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().enterButtonColor));
                                        gCPGameButtonAttr2.subscribeSucUrl$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[11], GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().subscribeSucUrl);
                                        gCPGameButtonAttr2.scene = 1;
                                        gCPGameButtonAttr2.gameTab = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).gameTab;
                                        gCPGameButtonAttr2.adTag$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[13], GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().adtag);
                                        gCPGameButtonAttr2.gameName$delegate.setValue(gCPGameButtonAttr2, kPropertyArr[12], GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().title);
                                        gCPGameButtonAttr2.privilege = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().privilege;
                                        gCPGameButtonAttr2.pkgSize = GCPGameEntranceButton.access$getAttr(GCPGameEntranceButton.this).getData().androidPkgSize;
                                        gCPGameButtonAttr2.buttonFixedWidth = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPGameEntranceButton gCPGameEntranceButton6 = GCPGameEntranceButton.this;
                                gCPGameButton2.event(new Function1<GCPGameButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPGameButtonEvent gCPGameButtonEvent) {
                                        GCPGameButtonEvent gCPGameButtonEvent2 = gCPGameButtonEvent;
                                        final GCPGameEntranceButton gCPGameEntranceButton7 = GCPGameEntranceButton.this;
                                        gCPGameButtonEvent2.register("statusChange", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GCPGameEntranceButton.this.emit("statusChange", obj);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GCPGameEntranceButton gCPGameEntranceButton8 = GCPGameEntranceButton.this;
                                        gCPGameButtonEvent2.register("buttonClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameEntranceButton.body.1.2.4.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GCPGameEntranceButton.this.emit("buttonClick", obj);
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
        return new GCPGameEntranceViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPGameEntranceViewEvent();
    }
}
