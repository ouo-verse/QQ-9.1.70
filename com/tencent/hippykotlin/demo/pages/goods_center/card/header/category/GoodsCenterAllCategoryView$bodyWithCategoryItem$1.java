package com.tencent.hippykotlin.demo.pages.goods_center.card.header.category;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.views.TextView;
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
public final class GoodsCenterAllCategoryView$bodyWithCategoryItem$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ GoodsCenterCategory $category;
    public final /* synthetic */ GoodsCenterAllCategoryView $ctx;
    public final /* synthetic */ int $index;
    public final /* synthetic */ GoodsCenterCategoryViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterAllCategoryView$bodyWithCategoryItem$1(int i3, GoodsCenterCategoryViewModel goodsCenterCategoryViewModel, GoodsCenterAllCategoryView goodsCenterAllCategoryView, GoodsCenterCategory goodsCenterCategory) {
        super(1);
        this.$index = i3;
        this.$viewModel = goodsCenterCategoryViewModel;
        this.$ctx = goodsCenterAllCategoryView;
        this.$category = goodsCenterCategory;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final int i3 = this.$index;
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = this.$viewModel;
        final GoodsCenterAllCategoryView goodsCenterAllCategoryView = this.$ctx;
        final GoodsCenterCategory goodsCenterCategory = this.$category;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView$bodyWithCategoryItem$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        tVar.mo153width((float) Math.floor((r3.getPagerData().m() - 24.0f) / 3.0f));
                        return Unit.INSTANCE;
                    }
                });
                final int i16 = i3;
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel2 = goodsCenterCategoryViewModel;
                final GoodsCenterAllCategoryView goodsCenterAllCategoryView2 = goodsCenterAllCategoryView;
                final GoodsCenterCategory goodsCenterCategory2 = goodsCenterCategory;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final int i17 = i16;
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel3 = goodsCenterCategoryViewModel2;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.allCenter();
                                tVar2.margin(4.0f);
                                tVar2.borderRadius(14.0f);
                                if (i17 == goodsCenterCategoryViewModel3.getSelectedIndex()) {
                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_tag_light", false, 2, null);
                                } else {
                                    tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getBackgroundColor());
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterAllCategoryView goodsCenterAllCategoryView3 = goodsCenterAllCategoryView2;
                        final int i18 = i16;
                        final GoodsCenterCategory goodsCenterCategory3 = goodsCenterCategory2;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GoodsCenterAllCategoryView goodsCenterAllCategoryView4 = GoodsCenterAllCategoryView.this;
                                final int i19 = i18;
                                final GoodsCenterCategory goodsCenterCategory4 = goodsCenterCategory3;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GoodsCenterAllCategoryView.access$clickCategoryItem(GoodsCenterAllCategoryView.this, i19, goodsCenterCategory4);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterCategory goodsCenterCategory4 = goodsCenterCategory2;
                        final int i19 = i16;
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = goodsCenterCategoryViewModel2;
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GoodsCenterCategory goodsCenterCategory5 = GoodsCenterCategory.this;
                                final int i26 = i19;
                                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel5 = goodsCenterCategoryViewModel4;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.bodyWithCategoryItem.1.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(GoodsCenterCategory.this.name);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.textAlignCenter();
                                        c.a.a(ceVar2, 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                        if (i26 == goodsCenterCategoryViewModel5.getSelectedIndex()) {
                                            ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getRedTextColor()).fontWeight500();
                                        } else {
                                            ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getSecondaryTextColor()).fontWeight400();
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
        });
        return Unit.INSTANCE;
    }
}
