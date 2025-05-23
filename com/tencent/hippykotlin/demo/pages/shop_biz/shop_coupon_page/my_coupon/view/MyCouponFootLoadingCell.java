package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponFootLoadingCell extends ComposeView<MyCouponFootLoadingCellAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy loadingPAGToken$delegate;

    public MyCouponFootLoadingCell() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$loadingPAGToken$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (MyCouponFootLoadingCell.this.getPagerData().getIsIOS()) {
                    return "qecommerce_skin_loading_img_sangedian";
                }
                return "ecommerce_skin_loading_img_sangedian";
            }
        });
        this.loadingPAGToken$delegate = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MyCouponFootLoadingCellAttr access$getAttr(MyCouponFootLoadingCell myCouponFootLoadingCell) {
        return (MyCouponFootLoadingCellAttr) myCouponFootLoadingCell.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final MyCouponFootLoadingCell myCouponFootLoadingCell = MyCouponFootLoadingCell.this;
                PAGViewKt.PAG(viewContainer2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PAGView pAGView) {
                        final MyCouponFootLoadingCell myCouponFootLoadingCell2 = MyCouponFootLoadingCell.this;
                        pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGAttr pAGAttr) {
                                PAGAttr pAGAttr2 = pAGAttr;
                                pAGAttr2.size(20.0f, !MyCouponFootLoadingCell.access$getAttr(MyCouponFootLoadingCell.this).isLoadFinishing$qecommerce_biz_release() ? 20.0f : 0.0f);
                                pAGAttr2.repeatCount(Integer.MAX_VALUE);
                                pAGAttr2.autoPlay(!MyCouponFootLoadingCell.access$getAttr(MyCouponFootLoadingCell.this).isLoadFinishing$qecommerce_biz_release());
                                pAGAttr2.src((String) MyCouponFootLoadingCell.this.loadingPAGToken$delegate.getValue());
                                pAGAttr2.m152visibility(!MyCouponFootLoadingCell.access$getAttr(MyCouponFootLoadingCell.this).isLoadFinishing$qecommerce_biz_release());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final MyCouponFootLoadingCell myCouponFootLoadingCell2 = MyCouponFootLoadingCell.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final MyCouponFootLoadingCell myCouponFootLoadingCell3 = MyCouponFootLoadingCell.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(MyCouponFootLoadingCell.access$getAttr(MyCouponFootLoadingCell.this).isLoadFinishing$qecommerce_biz_release() ? 18.0f : 0.0f);
                                tVar2.flexDirectionRow();
                                tVar2.allCenter();
                                tVar2.m152visibility(MyCouponFootLoadingCell.access$getAttr(MyCouponFootLoadingCell.this).isLoadFinishing$qecommerce_biz_release());
                                return Unit.INSTANCE;
                            }
                        });
                        MyCouponFootLoadingCell myCouponFootLoadingCell4 = MyCouponFootLoadingCell.this;
                        int i3 = MyCouponFootLoadingCell.$r8$clinit;
                        myCouponFootLoadingCell4.getClass();
                        final boolean z16 = true;
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$bodyWithLine$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final boolean z17 = z16;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$bodyWithLine$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        final boolean z18 = z17;
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell.bodyWithLine.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                Direction direction;
                                                h hVar;
                                                h hVar2;
                                                t tVar2 = tVar;
                                                tVar2.mo153width(24.0f);
                                                tVar2.mo141height(1.0f);
                                                tVar2.justifyContentCenter();
                                                if (z18) {
                                                    direction = Direction.TO_RIGHT;
                                                } else {
                                                    direction = Direction.TO_LEFT;
                                                }
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_divider", false);
                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.value("\u6ca1\u6709\u66f4\u591a\u5566");
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.marginLeft(8.0f).marginRight(8.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                        ceVar2.color(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        MyCouponFootLoadingCell.this.getClass();
                        final boolean z17 = false;
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$bodyWithLine$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final boolean z172 = z17;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell$bodyWithLine$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        final boolean z18 = z172;
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponFootLoadingCell.bodyWithLine.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                Direction direction;
                                                h hVar;
                                                h hVar2;
                                                t tVar2 = tVar;
                                                tVar2.mo153width(24.0f);
                                                tVar2.mo141height(1.0f);
                                                tVar2.justifyContentCenter();
                                                if (z18) {
                                                    direction = Direction.TO_RIGHT;
                                                } else {
                                                    direction = Direction.TO_LEFT;
                                                }
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_divider", false);
                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_text_light", false);
                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new MyCouponFootLoadingCellAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
