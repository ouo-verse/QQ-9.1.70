package com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page;

import com.tencent.hippykotlin.demo.pages.base.ECButton;
import com.tencent.hippykotlin.demo.pages.base.ECButtonAttr;
import com.tencent.hippykotlin.demo.pages.base.ECButtonKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponShowDiscount;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundViewKt;
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
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ReceiveResultDlg extends ComposeView<ReceiveResultAttr, ReceiveResultEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        ReceiveResultAttr receiveResultAttr = (ReceiveResultAttr) getAttr();
        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = (ShopCouponCouponShowStyleInfo) receiveResultAttr.couponInfo$delegate.getValue(receiveResultAttr, ReceiveResultAttr.$$delegatedProperties[0]);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.allCenter();
                        mVar2.mo153width(297.0f);
                        mVar2.mo141height(324.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo2 = ShopCouponCouponShowStyleInfo.this;
                final ReceiveResultDlg receiveResultDlg = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.allCenter();
                                tVar2.mo153width(297.0f);
                                tVar2.mo141height(240.0f);
                                tVar2.borderRadius(10.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        h hVar;
                                        h hVar2;
                                        t tVar2 = tVar;
                                        tVar2.absolutePosition(0.0f, 0.0f, 120.0f, 0.0f);
                                        tVar2.mo153width(297.0f);
                                        tVar2.mo141height(120.0f);
                                        Direction direction = Direction.TO_BOTTOM;
                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_color_tag_secondary", false);
                                        hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_color_bg_default", false);
                                        tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.absolutePosition(0.0f, 0.0f, 117.0f, 0.0f);
                                        afVar2.mo153width(297.0f);
                                        afVar2.mo141height(123.0f);
                                        afVar2.q();
                                        b.a.b(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8925/youhuiquan/qecommerce_zhibolingquan_bg.png", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo3 = ShopCouponCouponShowStyleInfo.this;
                        final ReceiveResultDlg receiveResultDlg2 = receiveResultDlg;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.allCenter();
                                        tVar2.padding(20.0f, 24.0f, 24.0f, 24.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u606d\u559c\u4f60 \u9886\u5238\u6210\u529f");
                                                ceVar2.color(4294914928L);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeightBold();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo4 = ShopCouponCouponShowStyleInfo.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.mo153width(249.0f);
                                                tVar2.mo141height(92.0f);
                                                tVar2.marginTop(16.0f);
                                                tVar2.marginBottom(24.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        CouponBackgroundViewKt.CouponBackground(vVar6, new Function1<CouponBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(CouponBackgroundView couponBackgroundView) {
                                                couponBackgroundView.attr(new Function1<CouponBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(CouponBackgroundAttr couponBackgroundAttr) {
                                                        CouponBackgroundAttr couponBackgroundAttr2 = couponBackgroundAttr;
                                                        couponBackgroundAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                        couponBackgroundAttr2.rightAreaWidth = 155.0f;
                                                        couponBackgroundAttr2.couponBgOpacity = 1.0f;
                                                        ReadWriteProperty readWriteProperty = couponBackgroundAttr2.backgroundColor$delegate;
                                                        KProperty<?>[] kPropertyArr = CouponBackgroundAttr.$$delegatedProperties;
                                                        readWriteProperty.setValue(couponBackgroundAttr2, kPropertyArr[4], 4294965498L);
                                                        couponBackgroundAttr2.borderColor$delegate.setValue(couponBackgroundAttr2, kPropertyArr[3], 4294962161L);
                                                        couponBackgroundAttr2.setDashLineColorToken("qecommerce_color_tag_secondary");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo5 = ShopCouponCouponShowStyleInfo.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.allCenter();
                                                        tVar2.mo153width(94.0f);
                                                        tVar2.marginTop(-4.0f);
                                                        tVar2.mo141height(92.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo6 = ShopCouponCouponShowStyleInfo.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        v vVar10 = vVar9;
                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo7 = ShopCouponCouponShowStyleInfo.this;
                                                        ConditionViewKt.c(vVar10, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                ShopCouponShowDiscount shopCouponShowDiscount;
                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo8 = ShopCouponCouponShowStyleInfo.this;
                                                                return Boolean.valueOf(!((shopCouponCouponShowStyleInfo8 == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo8.couponShowDiscount) == null || shopCouponShowDiscount.type != 3) ? false : true));
                                                            }
                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.3.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                                ceVar2.text("\u00a5");
                                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getRedTextColor());
                                                                                ceVar2.fontWeightBold();
                                                                                ceVar2.marginTop(7.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo8 = ShopCouponCouponShowStyleInfo.this;
                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        ShopCouponShowDiscount shopCouponShowDiscount;
                                                                        ce ceVar2 = ceVar;
                                                                        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo10 = ShopCouponCouponShowStyleInfo.this;
                                                                        if (shopCouponCouponShowStyleInfo10 == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo10.couponShowDiscount) == null || (str = shopCouponShowDiscount.discountAmount) == null) {
                                                                            str = "";
                                                                        }
                                                                        ceVar2.text(str);
                                                                        ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getRedTextColor());
                                                                        ce.fontSize$default(ceVar2, 32.0f, null, 2, null);
                                                                        ceVar2.fontWeightBold();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                        ConditionViewKt.c(vVar10, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.5
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                ShopCouponShowDiscount shopCouponShowDiscount;
                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo10 = ShopCouponCouponShowStyleInfo.this;
                                                                return Boolean.valueOf((shopCouponCouponShowStyleInfo10 == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo10.couponShowDiscount) == null || shopCouponShowDiscount.type != 3) ? false : true);
                                                            }
                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.6
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.6.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.2.6.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                                ceVar2.text("\u6298");
                                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getRedTextColor());
                                                                                ceVar2.fontWeightBold();
                                                                                ceVar2.marginTop(7.0f);
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
                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo7 = ShopCouponCouponShowStyleInfo.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo8 = ShopCouponCouponShowStyleInfo.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ShopCouponShowDiscount shopCouponShowDiscount;
                                                                ce ceVar2 = ceVar;
                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                                if (shopCouponCouponShowStyleInfo9 == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo9.couponShowDiscount) == null || (str = shopCouponShowDiscount.discountThreshold) == null) {
                                                                    str = "";
                                                                }
                                                                ceVar2.text(str);
                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getRedTextColor());
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.fontWeightBold();
                                                                ceVar2.marginTop(6.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo6 = ShopCouponCouponShowStyleInfo.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.mo153width(155.0f);
                                                        tVar2.mo141height(92.0f);
                                                        tVar2.alignItemsFlexStart();
                                                        tVar2.paddingLeft(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo7 = ShopCouponCouponShowStyleInfo.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        v vVar10 = vVar9;
                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.marginTop(17.0f);
                                                                tVar2.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo8 = ShopCouponCouponShowStyleInfo.this;
                                                        w.a(vVar10, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar11) {
                                                                v vVar12 = vVar11;
                                                                vVar12.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.mo113backgroundColor(new h(4294962161L));
                                                                        tVar2.padding(1.5f, 4.0f, 1.5f, 4.0f);
                                                                        tVar2.borderRadius(2.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                                cg.a(vVar12, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo10 = ShopCouponCouponShowStyleInfo.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.2.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                String str;
                                                                                ce ceVar2 = ceVar;
                                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo11 = ShopCouponCouponShowStyleInfo.this;
                                                                                if (shopCouponCouponShowStyleInfo11 == null || (str = shopCouponCouponShowStyleInfo11.couponTypeName) == null) {
                                                                                    str = "";
                                                                                }
                                                                                ceVar2.text(str);
                                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getRedTextColor());
                                                                                ceVar2.fontWeightBold();
                                                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo10 = ShopCouponCouponShowStyleInfo.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo11 = ShopCouponCouponShowStyleInfo.this;
                                                                        if (shopCouponCouponShowStyleInfo11 == null || (str = shopCouponCouponShowStyleInfo11.couponIssuerName) == null) {
                                                                            str = "";
                                                                        }
                                                                        ceVar2.text(str);
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_text_secondary", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                        ceVar2.marginLeft(4.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo8 = ShopCouponCouponShowStyleInfo.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo10 = ShopCouponCouponShowStyleInfo.this;
                                                                if (shopCouponCouponShowStyleInfo10 == null || (str = shopCouponCouponShowStyleInfo10.couponUsableRange) == null) {
                                                                    str = "";
                                                                }
                                                                ceVar2.text(str);
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_text_secondary", false);
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.marginTop(10.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo9 = ShopCouponCouponShowStyleInfo.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo10 = ShopCouponCouponShowStyleInfo.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.3.4.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo11 = ShopCouponCouponShowStyleInfo.this;
                                                                if (shopCouponCouponShowStyleInfo11 == null || (str = shopCouponCouponShowStyleInfo11.couponTimeScope) == null) {
                                                                    str = "";
                                                                }
                                                                ceVar2.text(str);
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_text_secondary", false);
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.marginTop(3.0f);
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
                                final ReceiveResultDlg receiveResultDlg3 = receiveResultDlg2;
                                ECButtonKt.ECButton(vVar4, new Function1<ECButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECButton eCButton) {
                                        ECButton eCButton2 = eCButton;
                                        eCButton2.attr(new Function1<ECButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECButtonAttr eCButtonAttr) {
                                                ECButtonAttr eCButtonAttr2 = eCButtonAttr;
                                                eCButtonAttr2.titleAttrInit = new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.fontWeightBold();
                                                        ceVar2.text("\u7acb\u5373\u7528\u5238");
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                eCButtonAttr2.justifyContentCenter();
                                                eCButtonAttr2.mo153width(249.0f);
                                                eCButtonAttr2.mo141height(40.0f);
                                                eCButtonAttr2.marginBottom(0.0f);
                                                EcommerceExtKt.vr(eCButtonAttr2, "em_qqlive_coupon_layer_to_use", new e());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ReceiveResultDlg receiveResultDlg4 = ReceiveResultDlg.this;
                                        eCButton2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(l lVar) {
                                                final ReceiveResultDlg receiveResultDlg5 = ReceiveResultDlg.this;
                                                lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.2.4.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        ReceiveResultDlg receiveResultDlg6 = ReceiveResultDlg.this;
                                                        int i3 = ReceiveResultDlg.$r8$clinit;
                                                        receiveResultDlg6.emit("OnClickUseCouponBtn", null);
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
                final ReceiveResultDlg receiveResultDlg2 = this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.mo153width(40.0f);
                                afVar2.mo141height(40.0f);
                                afVar2.marginTop(32.0f);
                                afVar2.q();
                                b.a.b(afVar2, "qecommerce_icon_popup_close", false, 2, null);
                                EcommerceExtKt.vr(afVar2, "em_qqlive_coupon_layer_close", new e());
                                return Unit.INSTANCE;
                            }
                        });
                        final ReceiveResultDlg receiveResultDlg3 = ReceiveResultDlg.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final ReceiveResultDlg receiveResultDlg4 = ReceiveResultDlg.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.ReceiveResultDlg.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ReceiveResultDlg receiveResultDlg5 = ReceiveResultDlg.this;
                                        int i3 = ReceiveResultDlg.$r8$clinit;
                                        receiveResultDlg5.emit("onClickCloseBtn", null);
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
        return new ReceiveResultAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ReceiveResultEvent();
    }
}
