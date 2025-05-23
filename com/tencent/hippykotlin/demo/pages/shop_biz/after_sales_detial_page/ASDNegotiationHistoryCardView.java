package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDNegotiationHistoryCardView extends ComposeView<ASDNegotiationHistoryCardViewAttr, l> {
    public final ASDNegotiationHistoryCardViewAttr viewAttr = new ASDNegotiationHistoryCardViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        mVar2.padding(16.0f);
                        mVar2.marginTop(8.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ASDNegotiationHistoryCardView aSDNegotiationHistoryCardView = ASDNegotiationHistoryCardView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final Event event2 = event;
                        final ASDNegotiationHistoryCardView aSDNegotiationHistoryCardView2 = ASDNegotiationHistoryCardView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String p16 = Event.this.getPager().getPageData().n().p(WadlProxyConsts.CHANNEL);
                                AfterSalesDetailRspModel afterSalesDetailRspModel = aSDNegotiationHistoryCardView2.viewAttr.rspModel;
                                if (afterSalesDetailRspModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("rspModel");
                                    afterSalesDetailRspModel = null;
                                }
                                AfterSalesDetailPageData afterSalesDetailPageData = afterSalesDetailRspModel.detailPage;
                                Intrinsics.checkNotNull(afterSalesDetailPageData);
                                BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(Event.this.getPagerId()), QUISkinImage$$ExternalSyntheticOutline0.m("mqqapi://ecommerce/open?target=40&src_type=internal&version=1&channel=", p16, "&after_sales_id=", afterSalesDetailPageData.afterSalesId), false, null, null, 30);
                                ASDReportModel aSDReportModel = aSDNegotiationHistoryCardView2.viewAttr.reportModel;
                                if (aSDReportModel != null) {
                                    aSDReportModel.reportDT("qstore_after_sales_detail_neg_history_clk", new e());
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow().justifyContentSpaceBetween().alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightMedium().text("\u534f\u5546\u5386\u53f2").color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNegotiationHistoryCardView.body.1.3.3.1
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
