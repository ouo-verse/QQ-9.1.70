package com.tencent.hippykotlin.demo.pages.goods_center.card.order;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
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
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterOrderNavigationView$bodyWithNavItem$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ Icon $icon;
    public final /* synthetic */ GoodsCenterOrderViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterOrderNavigationView$bodyWithNavItem$1(GoodsCenterOrderViewModel goodsCenterOrderViewModel, Icon icon) {
        super(1);
        this.$viewModel = goodsCenterOrderViewModel;
        this.$icon = icon;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final GoodsCenterOrderViewModel goodsCenterOrderViewModel = this.$viewModel;
        final Icon icon = this.$icon;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView$bodyWithNavItem$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionColumn();
                        tVar2.alignItemsCenter();
                        tVar2.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterOrderViewModel goodsCenterOrderViewModel2 = GoodsCenterOrderViewModel.this;
                final Icon icon2 = icon;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final GoodsCenterOrderViewModel goodsCenterOrderViewModel3 = GoodsCenterOrderViewModel.this;
                        final Icon icon3 = icon2;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                GoodsCenterOrderViewModel.this.iconClick(icon3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final Icon icon3 = icon;
                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final Icon icon4 = Icon.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.mo153width(36.0f).mo141height(36.0f);
                                b.a.b(afVar2, Icon.this.img, false, 2, null);
                                c.a.a(afVar2, 12.0f, 0.0f, 6.0f, 0.0f, 10, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final Icon icon4 = icon;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final Icon icon5 = Icon.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.bodyWithNavItem.1.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeight400().color(IPagerIdKtxKt.getSkinColor(ceVar2).getSecondaryTextColor());
                                ceVar2.text(Icon.this.f114183msg);
                                ceVar2.marginBottom(12.0f);
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
}
