package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class CPBigCouponView extends ComposeView<CPBigCouponViewAttr, l> {
    public final CPBigCouponViewAttr viewAttr = new CPBigCouponViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(72.0f, 92.0f).marginTop(86.0f).marginLeft(16.0f);
                        mVar2.alignItemsCenter();
                        mVar2.justifyContentSpaceBetween();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                b.a.b(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8925/youhuiquan/qecommerce_zhibo_coupon_bg.png", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final CPBigCouponView cPBigCouponView = CPBigCouponView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2.fontWeight500(), 11.0f, null, 2, null);
                                        ceVar2.color(new h("qecommerce_color_tag_light_100"));
                                        ceVar2.text("\u4e3b\u64ad\u53d1\u5238\u4e2d");
                                        ceVar2.marginTop(10.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final CPBigCouponView cPBigCouponView2 = CPBigCouponView.this;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                RichTextView richTextView2 = richTextView;
                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.lines(1);
                                        richTextAttr2.marginTop(6.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 18.0f, null, 2, null).fontFamily("Qvideo Digit").fontWeight700().color(new h("qecommerce_color_tag_light_100"));
                                        cfVar2.text("\u00a5");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final CPBigCouponView cPBigCouponView3 = CPBigCouponView.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        String str;
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 26.0f, null, 2, null).fontFamily("Qvideo Digit").fontWeight700().color(new h("qecommerce_color_tag_light_100"));
                                        CPBigCouponViewAttr cPBigCouponViewAttr = CPBigCouponView.this.viewAttr;
                                        LiveCouponRspModel liveCouponRspModel = (LiveCouponRspModel) cPBigCouponViewAttr.couponInfo$delegate.getValue(cPBigCouponViewAttr, CPBigCouponViewAttr.$$delegatedProperties[0]);
                                        if (liveCouponRspModel == null || (str = liveCouponRspModel.discountPrice) == null) {
                                            str = "0";
                                        }
                                        cfVar2.text(str);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.CPBigCouponView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginBottom(8.0f);
                                ce.fontSize$default(ceVar2.fontWeight500(), 13.0f, null, 2, null);
                                ceVar2.color(new h("qecommerce_color_tag_light_100"));
                                ceVar2.text("\u9886\u5238");
                                ceVar2.marginBottom(8.0f);
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
