package com.tencent.hippykotlin.demo.pages.goods_center.card.header.category;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterCategoryView$bodyWithCategoryItem$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ GoodsCenterCategory $category;
    public final /* synthetic */ GoodsCenterCategoryView $ctx;
    public final /* synthetic */ int $index;
    public final /* synthetic */ GoodsCenterCategoryViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterCategoryView$bodyWithCategoryItem$1(GoodsCenterCategoryView goodsCenterCategoryView, int i3, GoodsCenterCategoryViewModel goodsCenterCategoryViewModel, GoodsCenterCategory goodsCenterCategory) {
        super(1);
        this.$ctx = goodsCenterCategoryView;
        this.$index = i3;
        this.$viewModel = goodsCenterCategoryViewModel;
        this.$category = goodsCenterCategory;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final GoodsCenterCategoryView goodsCenterCategoryView = this.$ctx;
        final int i3 = this.$index;
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = this.$viewModel;
        final GoodsCenterCategory goodsCenterCategory = this.$category;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$bodyWithCategoryItem$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final GoodsCenterCategoryView goodsCenterCategoryView2 = GoodsCenterCategoryView.this;
                final int i16 = i3;
                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aa<v> aaVar) {
                        GoodsCenterCategoryView.this.categoryRefs.add(i16, aaVar);
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel2 = goodsCenterCategoryViewModel;
                final int i17 = i3;
                final GoodsCenterCategoryView goodsCenterCategoryView3 = GoodsCenterCategoryView.this;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
                    
                        if ((r1 + 1) == r0.size()) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.allCenter();
                        GoodsCenterCategoryViewModel goodsCenterCategoryViewModel3 = GoodsCenterCategoryViewModel.this;
                        int i18 = i17;
                        ArrayList<GoodsCenterCategory> categoryList = goodsCenterCategoryViewModel3.getCategoryList();
                        boolean z16 = categoryList != null;
                        tVar2.marginRight(z16 ? 0.0f : goodsCenterCategoryView3.itemMargin);
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryView goodsCenterCategoryView4 = GoodsCenterCategoryView.this;
                final int i18 = i3;
                final GoodsCenterCategory goodsCenterCategory2 = goodsCenterCategory;
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel3 = goodsCenterCategoryViewModel;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        u uVar2 = uVar;
                        final GoodsCenterCategoryView goodsCenterCategoryView5 = GoodsCenterCategoryView.this;
                        final int i19 = i18;
                        final GoodsCenterCategory goodsCenterCategory3 = goodsCenterCategory2;
                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                GoodsCenterCategoryView.access$clickCategoryItem(GoodsCenterCategoryView.this, i19, goodsCenterCategory3);
                                return Unit.INSTANCE;
                            }
                        });
                        final int i26 = i18;
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = goodsCenterCategoryViewModel3;
                        final GoodsCenterCategoryView goodsCenterCategoryView6 = GoodsCenterCategoryView.this;
                        FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                if (i26 == goodsCenterCategoryViewModel4.getSelectedIndex()) {
                                    GoodsCenterCategoryView.access$updateIndicatorFrameX(goodsCenterCategoryView6);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = goodsCenterCategoryViewModel;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(GoodsCenterCategoryViewModel.this.getSelectedIndex());
                    }
                };
                final GoodsCenterCategory goodsCenterCategory3 = goodsCenterCategory;
                final int i19 = i3;
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel5 = goodsCenterCategoryViewModel;
                BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final GoodsCenterCategory goodsCenterCategory4 = GoodsCenterCategory.this;
                        final int i26 = i19;
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel6 = goodsCenterCategoryViewModel5;
                        cg.a(bindDirectivesView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GoodsCenterCategory goodsCenterCategory5 = GoodsCenterCategory.this;
                                final int i27 = i26;
                                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel7 = goodsCenterCategoryViewModel6;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithCategoryItem.1.1.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(GoodsCenterCategory.this.name);
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null).color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
                                        ceVar2.textAlignCenter();
                                        if (i27 == goodsCenterCategoryViewModel7.getSelectedIndex()) {
                                            ceVar2.fontWeight500();
                                        } else {
                                            ceVar2.fontWeight400();
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
