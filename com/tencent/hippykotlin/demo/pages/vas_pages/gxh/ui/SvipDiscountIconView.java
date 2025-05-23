package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui;

import com.tencent.hippykotlin.demo.pages.vas_base.extensions.p002float.ImplKt;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.DressItem;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.User;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SvipDiscountIconView extends ComposeView<SvipDiscountIconViewAttr, SvipDiscountIconViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SvipDiscountIconViewAttr access$getAttr(SvipDiscountIconView svipDiscountIconView) {
        return (SvipDiscountIconViewAttr) svipDiscountIconView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final SvipDiscountIconView svipDiscountIconView = SvipDiscountIconView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final SvipDiscountIconView svipDiscountIconView2 = SvipDiscountIconView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                SvipDiscountIconViewAttr access$getAttr = SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this);
                                User user = (User) access$getAttr.user$delegate.getValue(access$getAttr, SvipDiscountIconViewAttr.$$delegatedProperties[1]);
                                return Boolean.valueOf(((Boolean) user.isSvip$delegate.getValue(user, User.$$delegatedProperties[1])).booleanValue());
                            }
                        };
                        final SvipDiscountIconView svipDiscountIconView3 = SvipDiscountIconView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final SvipDiscountIconView svipDiscountIconView4 = SvipDiscountIconView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.borderRadius(ImplKt.getW(4.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SvipDiscountIconView svipDiscountIconView5 = SvipDiscountIconView.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.marginRight(ImplKt.getW(4.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SvipDiscountIconView svipDiscountIconView6 = SvipDiscountIconView.this;
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final SvipDiscountIconView svipDiscountIconView7 = SvipDiscountIconView.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(ImplKt.getW(SvipDiscountIconView.this.getIconWidth()), ImplKt.getW(SvipDiscountIconView.this.getIconHeight()));
                                                                b.a.b(afVar2, "https://tianquan.gtimg.cn/shoal/qqgxh/svip-discount.png", false, 2, null);
                                                                afVar2.o();
                                                                afVar2.borderRadius(ImplKt.getW(4.0f), 0.0f, ImplKt.getW(4.0f), 0.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SvipDiscountIconView svipDiscountIconView7 = SvipDiscountIconView.this;
                                                PriceKt.Price(vVar6, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PriceView priceView) {
                                                        final SvipDiscountIconView svipDiscountIconView8 = SvipDiscountIconView.this;
                                                        priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                                PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                                priceViewAttr2.setPrice$qecommerce_biz_release(SvipDiscountIconView.this.getDiscountPrice());
                                                                priceViewAttr2.isDiscount$delegate.setValue(priceViewAttr2, PriceViewAttr.$$delegatedProperties[2], Boolean.TRUE);
                                                                priceViewAttr2.setViewScale$qecommerce_biz_release(SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this).getViewScale$qecommerce_biz_release());
                                                                priceViewAttr2.borderRadius(0.0f, ImplKt.getW(4.0f), 0.0f, ImplKt.getW(4.0f));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SvipDiscountIconView svipDiscountIconView6 = SvipDiscountIconView.this;
                                        PriceKt.Price(vVar4, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PriceView priceView) {
                                                final SvipDiscountIconView svipDiscountIconView7 = SvipDiscountIconView.this;
                                                priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.2.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                        PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                        priceViewAttr2.setPrice$qecommerce_biz_release(SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this).getItem$qecommerce_biz_release().getPrice());
                                                        priceViewAttr2.isInvalid$delegate.setValue(priceViewAttr2, PriceViewAttr.$$delegatedProperties[1], Boolean.TRUE);
                                                        priceViewAttr2.setViewScale$qecommerce_biz_release(SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this).getViewScale$qecommerce_biz_release());
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
                        final SvipDiscountIconView svipDiscountIconView4 = SvipDiscountIconView.this;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final SvipDiscountIconView svipDiscountIconView5 = SvipDiscountIconView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.borderRadius(ImplKt.getW(4.0f));
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SvipDiscountIconView svipDiscountIconView6 = SvipDiscountIconView.this;
                                        PriceKt.Price(vVar4, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PriceView priceView) {
                                                final SvipDiscountIconView svipDiscountIconView7 = SvipDiscountIconView.this;
                                                priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                        PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                        priceViewAttr2.setPrice$qecommerce_biz_release(SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this).getItem$qecommerce_biz_release().getPrice());
                                                        priceViewAttr2.setViewScale$qecommerce_biz_release(SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this).getViewScale$qecommerce_biz_release());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SvipDiscountIconView svipDiscountIconView7 = SvipDiscountIconView.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.marginLeft(ImplKt.getW(4.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SvipDiscountIconView svipDiscountIconView8 = SvipDiscountIconView.this;
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final SvipDiscountIconView svipDiscountIconView9 = SvipDiscountIconView.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(ImplKt.getW(SvipDiscountIconView.this.getIconWidth()), ImplKt.getW(SvipDiscountIconView.this.getIconHeight()));
                                                                b.a.b(afVar2, "https://tianquan.gtimg.cn/shoal/qqgxh/svip-discount.png", false, 2, null);
                                                                afVar2.o();
                                                                afVar2.borderRadius(ImplKt.getW(4.0f), 0.0f, ImplKt.getW(4.0f), 0.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SvipDiscountIconView svipDiscountIconView9 = SvipDiscountIconView.this;
                                                PriceKt.Price(vVar6, new Function1<PriceView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PriceView priceView) {
                                                        final SvipDiscountIconView svipDiscountIconView10 = SvipDiscountIconView.this;
                                                        priceView.attr(new Function1<PriceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.SvipDiscountIconView.body.1.1.3.1.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(PriceViewAttr priceViewAttr) {
                                                                PriceViewAttr priceViewAttr2 = priceViewAttr;
                                                                priceViewAttr2.setPrice$qecommerce_biz_release(SvipDiscountIconView.this.getDiscountPrice());
                                                                priceViewAttr2.isDiscount$delegate.setValue(priceViewAttr2, PriceViewAttr.$$delegatedProperties[2], Boolean.TRUE);
                                                                priceViewAttr2.setViewScale$qecommerce_biz_release(SvipDiscountIconView.access$getAttr(SvipDiscountIconView.this).getViewScale$qecommerce_biz_release());
                                                                priceViewAttr2.borderRadius(0.0f, ImplKt.getW(4.0f), 0.0f, ImplKt.getW(4.0f));
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new SvipDiscountIconViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SvipDiscountIconViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getDiscountPrice() {
        DressItem item$qecommerce_biz_release = ((SvipDiscountIconViewAttr) getAttr()).getItem$qecommerce_biz_release();
        DressItem.Discount discount = (DressItem.Discount) item$qecommerce_biz_release.discount$delegate.getValue(item$qecommerce_biz_release, DressItem.$$delegatedProperties[13]);
        return ((Number) discount.discountPrice$delegate.getValue(discount, DressItem.Discount.$$delegatedProperties[2])).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getIconHeight() {
        if (((SvipDiscountIconViewAttr) getAttr()).getViewScale$qecommerce_biz_release() <= 0.0f) {
            return 18.0f;
        }
        return ((SvipDiscountIconViewAttr) getAttr()).getViewScale$qecommerce_biz_release() * ImplKt.getW(18.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getIconWidth() {
        if (((SvipDiscountIconViewAttr) getAttr()).getViewScale$qecommerce_biz_release() <= 0.0f) {
            return 41.0f;
        }
        return ((SvipDiscountIconViewAttr) getAttr()).getViewScale$qecommerce_biz_release() * ImplKt.getW(41.0f);
    }
}
