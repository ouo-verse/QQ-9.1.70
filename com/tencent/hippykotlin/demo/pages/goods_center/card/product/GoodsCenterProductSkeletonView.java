package com.tencent.hippykotlin.demo.pages.goods_center.card.product;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.layout.ColumnView;
import com.tencent.kuikly.core.views.layout.RowView;
import com.tencent.kuikly.core.views.layout.a;
import com.tencent.kuikly.core.views.layout.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class GoodsCenterProductSkeletonView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 148.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        c.b(vVar2, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RowView rowView) {
                                RowView rowView2 = rowView;
                                rowView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(m mVar) {
                                        m mVar2 = mVar;
                                        mVar2.mo141height(148.0f);
                                        mVar2.justifyContentFlexStart();
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(rowView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                t tVar2 = tVar;
                                                tVar2.size(132.0f, 132.0f);
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                tVar2.mo113backgroundColor(hVar);
                                                tVar2.margin(8.0f, 16.0f, 8.0f, 8.0f);
                                                tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                a.b(rowView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ColumnView columnView) {
                                        ColumnView columnView2 = columnView;
                                        columnView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                m mVar2 = mVar;
                                                mVar2.justifyContentFlexStart();
                                                mVar2.mo153width(((mVar2.getPagerData().m() - 132) - 8) - 16);
                                                mVar2.paddingTop(8.0f);
                                                mVar2.paddingBottom(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(40.0f);
                                                        tVar2.marginLeft(0.0f);
                                                        tVar2.marginRight(16.0f);
                                                        tVar2.marginBottom(4.0f);
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(160.0f);
                                                        tVar2.mo141height(16.0f);
                                                        tVar2.marginBottom(4.0f);
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(16.0f);
                                                        tVar2.marginRight(16.0f);
                                                        tVar2.marginBottom(4.0f);
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.5
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.5.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.size(90.0f, 16.0f);
                                                        tVar2.marginRight(16.0f);
                                                        tVar2.marginBottom(4.0f);
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        c.b(columnView2, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.6
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RowView rowView3) {
                                                RowView rowView4 = rowView3;
                                                rowView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.6.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        m mVar2 = mVar;
                                                        mVar2.flexDirectionRow();
                                                        mVar2.mo141height(28.0f);
                                                        mVar2.marginLeft(0.0f);
                                                        mVar2.marginRight(16.0f);
                                                        mVar2.marginBottom(4.0f);
                                                        mVar2.marginRight(16.0f);
                                                        mVar2.justifyContentSpaceBetween();
                                                        mVar2.alignItemsFlexEnd();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(rowView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.6.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.6.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                h hVar;
                                                                t tVar2 = tVar;
                                                                tVar2.size(70.0f, 19.0f);
                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                                tVar2.mo113backgroundColor(hVar);
                                                                tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(rowView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.6.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonView.body.1.1.2.3.6.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                h hVar;
                                                                t tVar2 = tVar;
                                                                tVar2.size(58.0f, 28.0f);
                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                                tVar2.mo113backgroundColor(hVar);
                                                                tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
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
        return new GoodsCenterCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
