package com.tencent.hippykotlin.demo.pages.game_content_page.game_goods;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECFastClickUtils;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.Button;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GoodsCard;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameGoodsCardView extends ComposeView<GameGoodsCardViewAttr, l> {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final e generateReportParams(GameTab gameTab, GoodsCard goodsCard) {
            e eVar = new e();
            if (gameTab != null) {
                eVar.v("second_tab_name", gameTab.name);
            }
            if (goodsCard != null) {
                eVar.v("skin_name", goodsCard.title);
                eVar.v("card_tag", goodsCard.tag);
                eVar.v("original_price", goodsCard.crossedPrice);
                eVar.v("current_price", goodsCard.price);
                eVar.v("skin_id", goodsCard.goodsId);
            }
            return eVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameGoodsCardViewAttr access$getAttr(GameGoodsCardView gameGoodsCardView) {
        return (GameGoodsCardViewAttr) gameGoodsCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final GoodsCard goodsCardData = ((GameGoodsCardViewAttr) getAttr()).getGoodsCardData();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(157.0f);
                        mVar2.mo141height(176.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GameGoodsCardView gameGoodsCardView = GameGoodsCardView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GameGoodsCardView gameGoodsCardView2 = GameGoodsCardView.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                e generateReportParams = GameGoodsCardView.Companion.generateReportParams(GameGoodsCardView.access$getAttr(GameGoodsCardView.this).gameTab, GameGoodsCardView.access$getAttr(GameGoodsCardView.this).getGoodsCardData());
                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                Iterator<String> c16 = generateReportParams.c();
                                while (c16.hasNext()) {
                                    String next = c16.next();
                                    m3.v(next, generateReportParams.p(next));
                                }
                                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_skins_card_exp", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCard goodsCard = goodsCardData;
                final GameGoodsCardView gameGoodsCardView2 = GameGoodsCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
                    
                        if ((!r0) == true) goto L10;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(v vVar) {
                        boolean z16;
                        String str;
                        boolean isBlank;
                        v vVar2 = vVar;
                        final GoodsCard goodsCard2 = GoodsCard.this;
                        final GameGoodsCardView gameGoodsCardView3 = gameGoodsCardView2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final GoodsCard goodsCard3 = GoodsCard.this;
                                final GameGoodsCardView gameGoodsCardView4 = gameGoodsCardView3;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
                                    
                                        if ((!r7) == true) goto L13;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(ClickParams clickParams) {
                                        boolean z17;
                                        String str2;
                                        boolean isBlank2;
                                        if (!ECFastClickUtils.isFastDoubleClick$default("game_goods_card_btn")) {
                                            GoodsCard goodsCard4 = GoodsCard.this;
                                            if (goodsCard4 != null && (str2 = goodsCard4.detailUrl) != null) {
                                                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                                z17 = true;
                                            }
                                            z17 = false;
                                            if (z17) {
                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(uVar2);
                                                GoodsCard goodsCard5 = GoodsCard.this;
                                                BridgeModule.openPage$default(bridgeModule, goodsCard5 != null ? goodsCard5.detailUrl : null, false, null, null, 30);
                                            }
                                            e generateReportParams = GameGoodsCardView.Companion.generateReportParams(GameGoodsCardView.access$getAttr(gameGoodsCardView4).gameTab, GameGoodsCardView.access$getAttr(gameGoodsCardView4).getGoodsCardData());
                                            e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                            Iterator<String> c16 = generateReportParams.c();
                                            while (c16.hasNext()) {
                                                String next = c16.next();
                                                m3.v(next, generateReportParams.p(next));
                                            }
                                            Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_skins_card_clk", m3);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCard goodsCard3 = GoodsCard.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final GoodsCard goodsCard4 = GoodsCard.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String str2;
                                        af afVar2 = afVar;
                                        afVar2.mo153width(156.0f);
                                        afVar2.mo141height(176.0f);
                                        afVar2.marginLeft(1.0f);
                                        afVar2.p();
                                        GoodsCard goodsCard5 = GoodsCard.this;
                                        if (goodsCard5 == null || (str2 = goodsCard5.picUrl) == null) {
                                            str2 = "";
                                        }
                                        ImageAttrExtKt.srcUrl(afVar2, str2, null);
                                        afVar2.borderRadius(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        GoodsCard goodsCard4 = GoodsCard.this;
                        if (goodsCard4 != null && (str = goodsCard4.tagIconUrl) != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str);
                            z16 = true;
                        }
                        z16 = false;
                        if (z16) {
                            final GoodsCard goodsCard5 = GoodsCard.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.3
                                {
                                    super(1);
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
                                
                                    if ((!r0) == true) goto L10;
                                 */
                                @Override // kotlin.jvm.functions.Function1
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(v vVar3) {
                                    boolean z17;
                                    String str2;
                                    boolean isBlank2;
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                            tVar2.mo153width(53.0f);
                                            tVar2.mo141height(18.0f);
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final GoodsCard goodsCard6 = GoodsCard.this;
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final GoodsCard goodsCard7 = GoodsCard.this;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                    afVar2.mo153width(53.0f);
                                                    afVar2.mo141height(18.0f);
                                                    afVar2.q();
                                                    GoodsCard goodsCard8 = GoodsCard.this;
                                                    ImageAttrExtKt.srcUrl(afVar2, goodsCard8 != null ? goodsCard8.tagIconUrl : null, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    GoodsCard goodsCard7 = GoodsCard.this;
                                    if (goodsCard7 != null && (str2 = goodsCard7.tag) != null) {
                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                        z17 = true;
                                    }
                                    z17 = false;
                                    if (z17) {
                                        final GoodsCard goodsCard8 = GoodsCard.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final GoodsCard goodsCard9 = GoodsCard.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(3.0f);
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        GoodsCard goodsCard10 = GoodsCard.this;
                                                        ceVar2.text(goodsCard10 != null ? goodsCard10.tag : null);
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_bg_default");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final GoodsCard goodsCard6 = GoodsCard.this;
                        final GameGoodsCardView gameGoodsCardView4 = gameGoodsCardView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.justifyContentFlexEnd();
                                        tVar2.flexDirectionColumn();
                                        tVar2.mo153width(156.0f);
                                        tVar2.mo141height(120.0f);
                                        a.C5863a.a(tVar2, 0.0f, 12.0f, 12.0f, 0.0f, 9, null);
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 3, null);
                                        Direction direction = Direction.TO_BOTTOM;
                                        h.Companion companion = h.INSTANCE;
                                        tVar2.mo135backgroundLinearGradient(direction, new j(companion.j(), 0.0f), new j(companion.b(), 1.0f));
                                        tVar2.borderRadius(0.0f, 0.0f, 8.0f, 8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCard goodsCard7 = GoodsCard.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GoodsCard goodsCard8 = GoodsCard.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str2;
                                                ce ceVar2 = ceVar;
                                                GoodsCard goodsCard9 = GoodsCard.this;
                                                if (goodsCard9 == null || (str2 = goodsCard9.title) == null) {
                                                    str2 = "";
                                                }
                                                ceVar2.text(str2);
                                                ceVar2.color(h.INSTANCE.m());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCard goodsCard8 = GoodsCard.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(3.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsFlexEnd();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCard goodsCard9 = GoodsCard.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final GoodsCard goodsCard10 = GoodsCard.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str2;
                                                        ce ceVar2 = ceVar;
                                                        GoodsCard goodsCard11 = GoodsCard.this;
                                                        if (goodsCard11 == null || (str2 = goodsCard11.price) == null) {
                                                            str2 = "";
                                                        }
                                                        ceVar2.text(str2);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ceVar2.fontWeight700();
                                                        ceVar2.fontWeightBold();
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        ceVar2.fontFamily("Qvideo Digit");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCard goodsCard10 = GoodsCard.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final GoodsCard goodsCard11 = GoodsCard.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str2;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(6.0f);
                                                        GoodsCard goodsCard12 = GoodsCard.this;
                                                        if (goodsCard12 == null || (str2 = goodsCard12.crossedPrice) == null) {
                                                            str2 = "";
                                                        }
                                                        ceVar2.text(str2);
                                                        ceVar2.color(2365587455L);
                                                        ceVar2.fontWeight700();
                                                        ceVar2.fontWeightBold();
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.textDecorationLineThrough();
                                                        ceVar2.fontFamily("Qvideo Digit");
                                                        if (ceVar2.getPagerData().getIsIOS()) {
                                                            ceVar2.marginBottom(2.0f);
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
                                final GoodsCard goodsCard9 = GoodsCard.this;
                                final GameGoodsCardView gameGoodsCardView5 = gameGoodsCardView4;
                                com.tencent.kuikly.core.views.compose.c.a(vVar4, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ButtonView buttonView) {
                                        ButtonView buttonView2 = buttonView;
                                        final GoodsCard goodsCard10 = GoodsCard.this;
                                        buttonView2.attr(new Function1<com.tencent.kuikly.core.views.compose.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.compose.a aVar) {
                                                com.tencent.kuikly.core.views.compose.a aVar2 = aVar;
                                                aVar2.marginTop(5.0f);
                                                aVar2.mo153width(132.0f);
                                                aVar2.mo141height(32.0f);
                                                AttrExtKt.backgroundColorToken(aVar2, "qecommerce_skin_color_btn_primary_blue_normal");
                                                final GoodsCard goodsCard11 = GoodsCard.this;
                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str2;
                                                        Button button;
                                                        ce ceVar2 = ceVar;
                                                        GoodsCard goodsCard12 = GoodsCard.this;
                                                        if (goodsCard12 == null || (button = goodsCard12.buttonPurchase) == null || (str2 = button.title) == null) {
                                                            str2 = "\u8d2d\u4e70";
                                                        }
                                                        ceVar2.text(str2);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeightBold();
                                                        ceVar2.fontWeight600();
                                                        ceVar2.color(h.INSTANCE.m());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                aVar2.borderRadius(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCard goodsCard11 = GoodsCard.this;
                                        final GameGoodsCardView gameGoodsCardView6 = gameGoodsCardView5;
                                        buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(b bVar) {
                                                final b bVar2 = bVar;
                                                final GoodsCard goodsCard12 = GoodsCard.this;
                                                final GameGoodsCardView gameGoodsCardView7 = gameGoodsCardView6;
                                                bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsCardView.body.1.3.4.4.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
                                                    
                                                        if ((!r7) == true) goto L15;
                                                     */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        boolean z17;
                                                        Button button;
                                                        Button button2;
                                                        String str2;
                                                        boolean isBlank2;
                                                        if (!ECFastClickUtils.isFastDoubleClick$default("game_goods_buy_btn")) {
                                                            GoodsCard goodsCard13 = GoodsCard.this;
                                                            if (goodsCard13 != null && (button2 = goodsCard13.buttonPurchase) != null && (str2 = button2.jumpUrl) != null) {
                                                                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                                                z17 = true;
                                                            }
                                                            z17 = false;
                                                            if (z17) {
                                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(bVar2);
                                                                GoodsCard goodsCard14 = GoodsCard.this;
                                                                BridgeModule.openPage$default(bridgeModule, (goodsCard14 == null || (button = goodsCard14.buttonPurchase) == null) ? null : button.jumpUrl, false, null, null, 30);
                                                            }
                                                            e generateReportParams = GameGoodsCardView.Companion.generateReportParams(GameGoodsCardView.access$getAttr(gameGoodsCardView7).gameTab, GameGoodsCardView.access$getAttr(gameGoodsCardView7).getGoodsCardData());
                                                            e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, "source_from"), "bus_id", 2);
                                                            Iterator<String> c16 = generateReportParams.c();
                                                            while (c16.hasNext()) {
                                                                String next = c16.next();
                                                                m3.v(next, generateReportParams.p(next));
                                                            }
                                                            Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_skins_card_buy_button_clk", m3);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GameGoodsCardViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
