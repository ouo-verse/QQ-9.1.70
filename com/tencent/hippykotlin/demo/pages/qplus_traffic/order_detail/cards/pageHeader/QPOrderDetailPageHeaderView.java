package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPlanDetail;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailPageHeaderView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderViewModel");
        final QPOrderDetailPageHeaderViewModel qPOrderDetailPageHeaderViewModel = (QPOrderDetailPageHeaderViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        h hVar2;
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), 54.0f);
                        Direction direction = Direction.TO_RIGHT;
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_color_btn_gradient01_normal", false);
                        hVar2 = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_color_btn_gradient02_normal", false);
                        mVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(afVar2.getPagerData().m(), 54.0f);
                                Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                b.a.b(afVar2, "qecommerce_skin_order_bg", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailPageHeaderViewModel qPOrderDetailPageHeaderViewModel2 = QPOrderDetailPageHeaderViewModel.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final QPOrderDetailPageHeaderViewModel qPOrderDetailPageHeaderViewModel3 = QPOrderDetailPageHeaderViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                String str;
                                QPlusPlanDetail qPlusPlanDetail;
                                ce ceVar2 = ceVar;
                                QPlusPromotionDetail qPlusPromotionDetail = QPOrderDetailPageHeaderViewModel.this.info.promotionDetail;
                                if (qPlusPromotionDetail == null || (qPlusPlanDetail = qPlusPromotionDetail.planDetail) == null || (str = qPlusPlanDetail.statusText) == null) {
                                    str = "";
                                }
                                ceVar2.text(str);
                                ceVar2.marginLeft(16.0f);
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.color(h.INSTANCE.m());
                                ceVar2.fontWeightBold();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginRight(16.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://kuikly/open?target=52&page_name=qplus_promotion_setting&single_mode=1&src_type=internal&version=1&bundle_name=new_qecommerce", false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u518d\u6765\u4e00\u5355");
                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, ceVar2, "qecommerce_white_color_text_secondary", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderView.body.1.4.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(16.0f, 16.0f);
                                        b.a.b(afVar2, "qecommerce_white_icon_general_arrow_right_secondary", false, 2, null);
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
}
