package com.tencent.hippykotlin.demo.pages.goods_center.card.order;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.layout.ColumnView;
import com.tencent.kuikly.core.views.layout.a;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSkeletonView extends ComposeView<GoodsCenterCardAttr, l> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.justifyContentFlexStart();
                        mVar2.margin(-12.0f, 16.0f, 12.0f, 16.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.mo141height(164.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.m137borderRadius(new f(8.0f, 8.0f, 8.0f, 8.0f));
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                Attr.absolutePosition$default(afVar2, 40.0f, 0.0f, 0.0f, 12.0f, 6, null);
                                afVar2.size(12.0f, 12.0f);
                                b.a.b(afVar2, "qecommerce_icon_general_arrow_right_primary", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                a.b(viewContainer2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ColumnView columnView) {
                        w.a(columnView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentSpaceEvenly();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        for (int i3 = 0; i3 < 3; i3++) {
                                            a.b(vVar4, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ColumnView columnView2) {
                                                    ColumnView columnView3 = columnView2;
                                                    columnView3.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(m mVar) {
                                                            mVar.marginTop(22.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    w.a(columnView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.2.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.2.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    h hVar;
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(61.0f, 24.0f);
                                                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                                    tVar2.mo113backgroundColor(hVar);
                                                                    tVar2.marginBottom(6.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    w.a(columnView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.2.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.2.2.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(61.0f, 10.0f);
                                                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_skeleton", false, 2, null);
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
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(1.0f);
                                                tVar2.marginLeft(12.0f);
                                                tVar2.marginRight(12.0f);
                                                tVar2.marginTop(18.0f);
                                                tVar2.margin(18.0f, 12.0f, 12.0f, 12.0f);
                                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_skeleton", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentSpaceAround();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        for (int i3 = 0; i3 < 3; i3++) {
                                            a.b(vVar4, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ColumnView columnView2) {
                                                    ColumnView columnView3 = columnView2;
                                                    w.a(columnView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4.2.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    h hVar;
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(36.0f, 36.0f);
                                                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_skeleton", false);
                                                                    tVar2.mo113backgroundColor(hVar);
                                                                    tVar2.marginBottom(6.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    w.a(columnView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4.2.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterSkeletonView.body.1.3.1.4.2.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(36.0f, 10.0f);
                                                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_skeleton", false, 2, null);
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
        return new l();
    }
}
