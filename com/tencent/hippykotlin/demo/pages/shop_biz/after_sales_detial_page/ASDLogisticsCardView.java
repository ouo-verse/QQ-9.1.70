package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDLogisticsCardView extends ComposeView<ASDLogisticsCardViewAttr, l> {
    public ASDLogisticsCardViewAttr viewAttr = new ASDLogisticsCardViewAttr();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ASDLogisticsCardViewAttr access$getAttr(ASDLogisticsCardView aSDLogisticsCardView) {
        return (ASDLogisticsCardViewAttr) aSDLogisticsCardView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        return Unit.INSTANCE;
                    }
                });
                final ASDLogisticsCardView aSDLogisticsCardView = ASDLogisticsCardView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final Event event2 = event;
                        final ASDLogisticsCardView aSDLogisticsCardView2 = ASDLogisticsCardView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                if (ASDLogisticsCardView.access$getAttr(ASDLogisticsCardView.this).getJumpUrl().length() > 0) {
                                    BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(event2.getPagerId()), ASDLogisticsCardView.access$getAttr(ASDLogisticsCardView.this).getJumpUrl(), false, null, null, 30);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.5f);
                                tVar2.marginRight(16.0f);
                                tVar2.marginRight(16.0f);
                                tVar2.mo113backgroundColor(SkinColor.INSTANCE.sepColor(tVar2.getPagerId()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDLogisticsCardView aSDLogisticsCardView2 = ASDLogisticsCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m145minHeight(72.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDLogisticsCardView aSDLogisticsCardView3 = ASDLogisticsCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(48.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDLogisticsCardView aSDLogisticsCardView4 = ASDLogisticsCardView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final ASDLogisticsCardView aSDLogisticsCardView5 = ASDLogisticsCardView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.o();
                                                ASDLogisticsCardViewAttr aSDLogisticsCardViewAttr = ASDLogisticsCardView.this.viewAttr;
                                                b.a.b(afVar2, (String) aSDLogisticsCardViewAttr.iconUrl$delegate.getValue(aSDLogisticsCardViewAttr, ASDLogisticsCardViewAttr.$$delegatedProperties[2]), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDLogisticsCardView aSDLogisticsCardView4 = ASDLogisticsCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDLogisticsCardView aSDLogisticsCardView5 = ASDLogisticsCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDLogisticsCardView aSDLogisticsCardView6 = ASDLogisticsCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(13.5f);
                                                ceVar2.lines(1);
                                                ce color = ce.fontSize$default(ceVar2.fontWeightMedium(), 15.0f, null, 2, null).color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                ASDLogisticsCardViewAttr aSDLogisticsCardViewAttr = ASDLogisticsCardView.this.viewAttr;
                                                color.text((String) aSDLogisticsCardViewAttr.title$delegate.getValue(aSDLogisticsCardViewAttr, ASDLogisticsCardViewAttr.$$delegatedProperties[0]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDLogisticsCardView aSDLogisticsCardView6 = ASDLogisticsCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDLogisticsCardView aSDLogisticsCardView7 = ASDLogisticsCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginBottom(13.5f);
                                                ceVar2.marginRight(15.0f);
                                                ce color = ce.fontSize$default(ceVar2, 13.0f, null, 2, null).color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                                ASDLogisticsCardViewAttr aSDLogisticsCardViewAttr = ASDLogisticsCardView.this.viewAttr;
                                                color.text((String) aSDLogisticsCardViewAttr.content$delegate.getValue(aSDLogisticsCardViewAttr, ASDLogisticsCardViewAttr.$$delegatedProperties[1]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (ASDLogisticsCardView.access$getAttr(ASDLogisticsCardView.this).getJumpUrl().length() > 0) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.4
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.allCenter();
                                            tVar2.margin(16.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.4.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.4.4.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.size(16.0f, 16.0f);
                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADEAAAAxBAMAAACBslwvAAAAG1BMVEUAAACZmZmZmZmVlZWXl5eXl5eXl5efn5+ZmZmlM1WdAAAACHRSTlMAgO8wQGEgECPwZG4AAABBSURBVDjLYxjiwAGXBGMjLhmJDgHsEmwaHbg0GXXg0sQ8qokCTawdHS0E9WDaM6qFFC3sCC2E8wIi/+DJc8MBAAAlYCfZ1SCbIAAAAABJRU5ErkJggg==", false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
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
                final ASDLogisticsCardView aSDLogisticsCardView3 = ASDLogisticsCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ASDLogisticsCardViewAttr aSDLogisticsCardViewAttr = ASDLogisticsCardView.this.viewAttr;
                        return Boolean.valueOf(((Boolean) aSDLogisticsCardViewAttr.showBtn$delegate.getValue(aSDLogisticsCardViewAttr, ASDLogisticsCardViewAttr.$$delegatedProperties[4])).booleanValue());
                    }
                };
                final ASDLogisticsCardView aSDLogisticsCardView4 = ASDLogisticsCardView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final ASDLogisticsCardView aSDLogisticsCardView5 = ASDLogisticsCardView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.marginBottom(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDLogisticsCardView aSDLogisticsCardView6 = ASDLogisticsCardView.this;
                                c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ButtonView buttonView) {
                                        ButtonView buttonView2 = buttonView;
                                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(a aVar) {
                                                aVar.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u586b\u5199\u9000\u8d27\u7269\u6d41");
                                                        ceVar2.fontWeightSemisolid();
                                                        ceVar2.color(SkinColor.whiteTextColor);
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(a aVar) {
                                                a aVar2 = aVar;
                                                aVar2.mo141height(40.0f);
                                                aVar2.marginLeft(16.0f);
                                                aVar2.marginRight(16.0f);
                                                aVar2.borderRadius(4.0f);
                                                aVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ASDLogisticsCardView aSDLogisticsCardView7 = ASDLogisticsCardView.this;
                                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                final com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                                final ASDLogisticsCardView aSDLogisticsCardView8 = ASDLogisticsCardView.this;
                                                bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLogisticsCardView.body.1.6.1.2.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        String p16 = com.tencent.kuikly.core.views.compose.b.this.getPager().getPageData().n().p(WadlProxyConsts.CHANNEL);
                                                        AfterSalesDetailPageData afterSalesDetailPageData = aSDLogisticsCardView8.viewAttr.getRspModel().detailPage;
                                                        Intrinsics.checkNotNull(afterSalesDetailPageData);
                                                        String str = afterSalesDetailPageData.afterSalesId;
                                                        AfterSalesDetailPageData afterSalesDetailPageData2 = aSDLogisticsCardView8.viewAttr.getRspModel().detailPage;
                                                        Intrinsics.checkNotNull(afterSalesDetailPageData2);
                                                        LogisticsCard logisticsCard = afterSalesDetailPageData2.logisticsCard;
                                                        Intrinsics.checkNotNull(logisticsCard);
                                                        String str2 = logisticsCard.phoneNum;
                                                        AfterSalesDetailPageData afterSalesDetailPageData3 = aSDLogisticsCardView8.viewAttr.getRspModel().detailPage;
                                                        Intrinsics.checkNotNull(afterSalesDetailPageData3);
                                                        String str3 = afterSalesDetailPageData3.processId;
                                                        StringBuilder a16 = defpackage.j.a("mqqapi://ecommerce/open?target=41&src_type=internal&version=1&channel=", p16, "&&after_sales_id=", str, "&phone_num=");
                                                        a16.append(str2);
                                                        a16.append("&process_id=");
                                                        a16.append(str3);
                                                        BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(com.tencent.kuikly.core.views.compose.b.this.getPagerId()), a16.toString(), false, null, null, 30);
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
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
