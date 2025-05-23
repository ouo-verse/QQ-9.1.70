package com.tencent.hippykotlin.demo.pages.game_content_page.game_goods;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECFastClickUtils;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.Button;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GoodsCard;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameGoodsListBarView extends ComposeView<GameGoodsListBarAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameGoodsListBarAttr access$getAttr(GameGoodsListBarView gameGoodsListBarView) {
        return (GameGoodsListBarAttr) gameGoodsListBarView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(252.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GameGoodsListBarView gameGoodsListBarView = GameGoodsListBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexStart();
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(244.0f);
                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                return Unit.INSTANCE;
                            }
                        });
                        final GameGoodsListBarView gameGoodsListBarView2 = GameGoodsListBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.paddingLeft(16.0f);
                                        tVar2.paddingRight(16.0f);
                                        tVar2.mo141height(52.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameGoodsListBarView gameGoodsListBarView3 = GameGoodsListBarView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GameGoodsListBarView gameGoodsListBarView4 = GameGoodsListBarView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h blackTextColor;
                                                ce ceVar2 = ceVar;
                                                GameGoodsListBarAttr access$getAttr = GameGoodsListBarView.access$getAttr(GameGoodsListBarView.this);
                                                ceVar2.text((String) access$getAttr.leftTitle$delegate.getValue(access$getAttr, GameGoodsListBarAttr.$$delegatedProperties[0]));
                                                blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                                ceVar2.color(blackTextColor);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeightBold();
                                                ceVar2.fontWeight500();
                                                ceVar2.marginTop(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameGoodsListBarView gameGoodsListBarView4 = GameGoodsListBarView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 16.0f, 7, null);
                                                tVar2.flexDirectionRow();
                                                tVar2.mo141height(52.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameGoodsListBarView gameGoodsListBarView5 = GameGoodsListBarView.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final GameGoodsListBarView gameGoodsListBarView6 = GameGoodsListBarView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        h subTextColor;
                                                        ce ceVar2 = ceVar;
                                                        GameGoodsListBarAttr access$getAttr = GameGoodsListBarView.access$getAttr(GameGoodsListBarView.this);
                                                        ceVar2.text((String) access$getAttr.rightTitle$delegate.getValue(access$getAttr, GameGoodsListBarAttr.$$delegatedProperties[1]));
                                                        subTextColor = SkinColor.INSTANCE.subTextColor(BridgeManager.f117344a.u());
                                                        ceVar2.color(subTextColor);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.marginTop(19.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.marginLeft(3.0f);
                                                        afVar2.mo153width(16.0f);
                                                        afVar2.mo141height(16.0f);
                                                        afVar2.o();
                                                        afVar2.marginTop(19.0f);
                                                        b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameGoodsListBarView gameGoodsListBarView6 = GameGoodsListBarView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final u uVar2 = uVar;
                                                final GameGoodsListBarView gameGoodsListBarView7 = GameGoodsListBarView.this;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.2.3.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        String str;
                                                        Map mapOf;
                                                        if (!ECFastClickUtils.isFastDoubleClick$default("game_goods_more_btn")) {
                                                            BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(u.this);
                                                            GameGoodsListBarAttr access$getAttr = GameGoodsListBarView.access$getAttr(gameGoodsListBarView7);
                                                            Button button = (Button) access$getAttr.buttonMore$delegate.getValue(access$getAttr, GameGoodsListBarAttr.$$delegatedProperties[3]);
                                                            if (button == null || (str = button.jumpUrl) == null) {
                                                                str = "";
                                                            }
                                                            BridgeModule.openPage$default(bridgeModule, str, false, null, null, 30);
                                                            GameTab gameTab = GameGoodsListBarView.access$getAttr(gameGoodsListBarView7).gameTab;
                                                            if (gameTab != null) {
                                                                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("second_tab_name", gameTab.name));
                                                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                                                if (mapOf != null) {
                                                                    for (Map.Entry entry : mapOf.entrySet()) {
                                                                        m3.v((String) entry.getKey(), entry.getValue());
                                                                    }
                                                                }
                                                                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_skins_card_more_clk", m3);
                                                            }
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
                        final GameGoodsListBarView gameGoodsListBarView3 = GameGoodsListBarView.this;
                        ar.a(vVar2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.mo141height(176.0f);
                                        aoVar2.flexDirectionRow();
                                        aoVar2.showScrollerIndicator(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameGoodsListBarView gameGoodsListBarView4 = GameGoodsListBarView.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<GoodsCard>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<GoodsCard>>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<GoodsCard> invoke() {
                                        return GameGoodsListBarView.access$getAttr(GameGoodsListBarView.this).getGameGoodsItems();
                                    }
                                };
                                final GameGoodsListBarView gameGoodsListBarView5 = GameGoodsListBarView.this;
                                LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<GoodsCard>, GoodsCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.3.3
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<GoodsCard> loopDirectivesView, GoodsCard goodsCard) {
                                        final GoodsCard goodsCard2 = goodsCard;
                                        final int indexOf = GameGoodsListBarView.access$getAttr(GameGoodsListBarView.this).getGameGoodsItems().indexOf(goodsCard2);
                                        final GameGoodsListBarView gameGoodsListBarView6 = GameGoodsListBarView.this;
                                        loopDirectivesView.addChild(new GameGoodsCardView(), new Function1<GameGoodsCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GameGoodsCardView gameGoodsCardView) {
                                                final int i3 = indexOf;
                                                final GoodsCard goodsCard3 = goodsCard2;
                                                final GameGoodsListBarView gameGoodsListBarView7 = gameGoodsListBarView6;
                                                gameGoodsCardView.attr(new Function1<GameGoodsCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.2.3.3.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(GameGoodsCardViewAttr gameGoodsCardViewAttr) {
                                                        GameGoodsCardViewAttr gameGoodsCardViewAttr2 = gameGoodsCardViewAttr;
                                                        if (i3 != 0) {
                                                            gameGoodsCardViewAttr2.marginLeft(7.0f);
                                                        } else {
                                                            gameGoodsCardViewAttr2.marginLeft(15.0f);
                                                        }
                                                        gameGoodsCardViewAttr2.goodsCardData$delegate.setValue(gameGoodsCardViewAttr2, GameGoodsCardViewAttr.$$delegatedProperties[0], goodsCard3);
                                                        gameGoodsCardViewAttr2.gameTab = GameGoodsListBarView.access$getAttr(gameGoodsListBarView7).gameTab;
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
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(8.0f);
                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_backplate");
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
        return new GameGoodsListBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
