package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import defpackage.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDOrderCardView extends ComposeView<ASDOrderCardViewAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ASDOrderCardViewAttr viewAttr = new ASDOrderCardViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ASDOrderCardView aSDOrderCardView = ASDOrderCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(tVar2.getPagerId()));
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDOrderCardView aSDOrderCardView2 = ASDOrderCardView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final ASDOrderCardView aSDOrderCardView3 = ASDOrderCardView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        ((Attr) c.a.a(afVar2, 16.0f, 16.0f, 16.0f, 0.0f, 8, null)).size(92.0f, 92.0f);
                                        afVar2.borderRadius(4.0f);
                                        b.a.b(afVar2, ASDOrderCardView.this.viewAttr.getOrderCard().cover, false, 2, null);
                                        afVar2.backgroundColor(4291809231L);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDOrderCardView aSDOrderCardView3 = ASDOrderCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        c.a.a(tVar.m140flex(1.0f), 16.0f, 12.0f, 0.0f, 0.0f, 12, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDOrderCardView aSDOrderCardView4 = ASDOrderCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDOrderCardView aSDOrderCardView5 = ASDOrderCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2.text(ASDOrderCardView.this.viewAttr.getOrderCard().goodTitle), 14.0f, null, 2, null).fontWeightMedium().color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                ceVar2.lines(2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDOrderCardView aSDOrderCardView5 = ASDOrderCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDOrderCardView aSDOrderCardView6 = ASDOrderCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2.text(ASDOrderCardView.this.viewAttr.getOrderCard().specification), 12.0f, null, 2, null).color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                                ceVar2.marginTop(6.0f);
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
                        final ASDOrderCardView aSDOrderCardView4 = ASDOrderCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.margin(16.0f);
                                        tVar2.alignItemsFlexEnd();
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDOrderCardView aSDOrderCardView5 = ASDOrderCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDOrderCardView aSDOrderCardView6 = ASDOrderCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u00a5');
                                                m3.append(ASDOrderCardView.this.viewAttr.getOrderCard().price);
                                                ceVar2.text(m3.toString());
                                                ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDOrderCardView aSDOrderCardView6 = ASDOrderCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDOrderCardView aSDOrderCardView7 = ASDOrderCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.1.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                Attr.absolutePosition$default(ceVar2, 26.0f, 0.0f, 0.0f, 0.0f, 6, null);
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u00d7 ");
                                                m3.append(ASDOrderCardView.this.viewAttr.getOrderCard().goodNum);
                                                ceVar2.text(m3.toString());
                                                ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
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
                final ASDOrderCardView aSDOrderCardView2 = ASDOrderCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(8.0f).marginBottom(8.0f);
                                tVar2.mo141height(56.0f);
                                tVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(tVar2.getPagerId()));
                                tVar2.flexDirectionRow();
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        ((af) b.a.b(afVar, "qecommerce_skin_icon_general_contact_primary", false, 2, null)).size(20.0f, 20.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).fontWeightMedium().color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId())).marginLeft(7.0f);
                                        ceVar2.text("\u8054\u7cfb\u5546\u5bb6");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDOrderCardView aSDOrderCardView3 = ASDOrderCardView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final ASDOrderCardView aSDOrderCardView4 = ASDOrderCardView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDOrderCardView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ASDOrderCardView aSDOrderCardView5 = ASDOrderCardView.this;
                                        int i3 = ASDOrderCardView.$r8$clinit;
                                        String p16 = aSDOrderCardView5.getPager().getPageData().n().p("order_id");
                                        String p17 = aSDOrderCardView5.getPager().getPageData().n().p(WadlProxyConsts.CHANNEL);
                                        AfterSalesDetailRspModel afterSalesDetailRspModel = aSDOrderCardView5.viewAttr.rspModel;
                                        AfterSalesDetailRspModel afterSalesDetailRspModel2 = null;
                                        if (afterSalesDetailRspModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("rspModel");
                                            afterSalesDetailRspModel = null;
                                        }
                                        AfterSalesDetailPageData afterSalesDetailPageData = afterSalesDetailRspModel.detailPage;
                                        Intrinsics.checkNotNull(afterSalesDetailPageData);
                                        afterSalesDetailPageData.getClass();
                                        AfterSalesDetailRspModel afterSalesDetailRspModel3 = aSDOrderCardView5.viewAttr.rspModel;
                                        if (afterSalesDetailRspModel3 != null) {
                                            afterSalesDetailRspModel2 = afterSalesDetailRspModel3;
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("rspModel");
                                        }
                                        AfterSalesDetailPageData afterSalesDetailPageData2 = afterSalesDetailRspModel2.detailPage;
                                        Intrinsics.checkNotNull(afterSalesDetailPageData2);
                                        afterSalesDetailPageData2.getClass();
                                        ShopInfo shopInfo = aSDOrderCardView5.viewAttr.getOrderCard().shopInfo;
                                        Intrinsics.checkNotNull(shopInfo);
                                        BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(aSDOrderCardView5.getPagerId()), OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(j.a("mqqapi://ecommerce/open?target=43&channel=", p17, "&scene=4&&order_id=", p16, "&shop_id="), shopInfo.shopId, "&src_type=internal&version=1"), false, null, null, 30);
                                        ASDReportModel aSDReportModel = aSDOrderCardView5.viewAttr.reportModel;
                                        if (aSDReportModel != null) {
                                            aSDReportModel.reportDT("qstore_after_sales_detail_contact_seller_clk", new e());
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
