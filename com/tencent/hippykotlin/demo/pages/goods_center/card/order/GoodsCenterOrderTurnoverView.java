package com.tencent.hippykotlin.demo.pages.goods_center.card.order;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterStringKV;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterOrderTurnoverView extends ComposeView<GoodsCenterOrderTurnoverAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final GoodsCenterOrderTurnoverAttr goodsCenterOrderTurnoverAttr = (GoodsCenterOrderTurnoverAttr) getAttr();
        final GoodsCenterOrderViewModel goodsCenterOrderViewModel = goodsCenterOrderTurnoverAttr.viewModel;
        if (goodsCenterOrderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            goodsCenterOrderViewModel = null;
        }
        Intrinsics.checkNotNull(goodsCenterOrderViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderViewModel");
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterOrderTurnoverAttr goodsCenterOrderTurnoverAttr2 = GoodsCenterOrderTurnoverAttr.this;
                final GoodsCenterOrderViewModel goodsCenterOrderViewModel2 = goodsCenterOrderViewModel;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GoodsCenterOrderTurnoverAttr goodsCenterOrderTurnoverAttr3 = GoodsCenterOrderTurnoverAttr.this;
                        final GoodsCenterOrderViewModel goodsCenterOrderViewModel3 = goodsCenterOrderViewModel2;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.body.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                Icon icon = GoodsCenterOrderTurnoverAttr.this.moreBtn;
                                if (icon != null) {
                                    goodsCenterOrderViewModel3.iconClick(icon);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterOrderTurnoverAttr goodsCenterOrderTurnoverAttr3 = GoodsCenterOrderTurnoverAttr.this;
                final GoodsCenterOrderTurnoverView goodsCenterOrderTurnoverView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(12.0f);
                                tVar2.marginLeft(20.0f).marginRight(20.0f);
                                tVar2.flexDirectionRow().justifyContentSpaceAround();
                                return Unit.INSTANCE;
                            }
                        });
                        ArrayList<GoodsCenterStringKV> arrayList = GoodsCenterOrderTurnoverAttr.this.turnovers;
                        if (arrayList != null) {
                            GoodsCenterOrderTurnoverView goodsCenterOrderTurnoverView2 = goodsCenterOrderTurnoverView;
                            for (final GoodsCenterStringKV goodsCenterStringKV : arrayList) {
                                int i3 = GoodsCenterOrderTurnoverView.$r8$clinit;
                                goodsCenterOrderTurnoverView2.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView$bodyWithTurnoverItem$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final GoodsCenterStringKV goodsCenterStringKV2 = GoodsCenterStringKV.this;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView$bodyWithTurnoverItem$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.bodyWithTurnoverItem.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterStringKV goodsCenterStringKV3 = GoodsCenterStringKV.this;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.bodyWithTurnoverItem.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final GoodsCenterStringKV goodsCenterStringKV4 = GoodsCenterStringKV.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.bodyWithTurnoverItem.1.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 22.0f, null, 2, null).fontWeight700().fontFamily("Qvideo Digit").color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
                                                                ceVar2.text(GoodsCenterStringKV.this.value);
                                                                c.a.a(ceVar2, 12.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterStringKV goodsCenterStringKV4 = GoodsCenterStringKV.this;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.bodyWithTurnoverItem.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final GoodsCenterStringKV goodsCenterStringKV5 = GoodsCenterStringKV.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.bodyWithTurnoverItem.1.1.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeight400().color(IPagerIdKtxKt.getSkinColor(ceVar2).getSecondaryTextColor());
                                                                ceVar2.text(GoodsCenterStringKV.this.key);
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
                                }.invoke(vVar2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderTurnoverView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                Attr.absolutePosition$default(afVar2, 40.0f, 0.0f, 0.0f, 12.0f, 6, null);
                                afVar2.size(12.0f, 12.0f);
                                b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_primary", false, 2, null);
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
        return new GoodsCenterOrderTurnoverAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
