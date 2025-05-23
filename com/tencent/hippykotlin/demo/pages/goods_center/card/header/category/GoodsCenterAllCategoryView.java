package com.tencent.hippykotlin.demo.pages.goods_center.card.header.category;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataCategoryPanelState;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterAllCategoryView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithCategoryItem(GoodsCenterAllCategoryView goodsCenterAllCategoryView, int i3, GoodsCenterCategory goodsCenterCategory) {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterAllCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        return new GoodsCenterAllCategoryView$bodyWithCategoryItem$1(i3, (GoodsCenterCategoryViewModel) viewModel, goodsCenterAllCategoryView, goodsCenterCategory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$clickCategoryItem(GoodsCenterAllCategoryView goodsCenterAllCategoryView, int i3, GoodsCenterCategory goodsCenterCategory) {
        goodsCenterAllCategoryView.getClass();
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterAllCategoryView: click category=");
        m3.append(goodsCenterCategory.name);
        m3.append(", index=");
        m3.append(i3);
        utils.logToNative(m3.toString());
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterAllCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        if (((GoodsCenterCategoryViewModel) viewModel).handleUpdateCategoryItem(i3, goodsCenterCategory)) {
            ((GoodsCenterEvent) goodsCenterAllCategoryView.getEvent()).onFireEvent("check_category", new GoodsCenterEventDataCategoryPanelState());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel2 = GoodsCenterCategoryViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(mVar2.getPagerData().l());
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_mask_50", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.m152visibility(GoodsCenterCategoryViewModel.this.getShowAllCategory());
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel3 = GoodsCenterCategoryViewModel.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = GoodsCenterCategoryViewModel.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                GoodsCenterCategoryViewModel.this.setShowAllCategory(false);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = GoodsCenterCategoryViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GoodsCenterCategoryViewModel.this.getCategoryList();
                    }
                };
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel5 = GoodsCenterCategoryViewModel.this;
                final GoodsCenterAllCategoryView goodsCenterAllCategoryView = this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel6 = GoodsCenterCategoryViewModel.this;
                        final GoodsCenterAllCategoryView goodsCenterAllCategoryView2 = goodsCenterAllCategoryView;
                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.padding(12.0f);
                                        tVar2.m143maxHeight(tVar2.getPagerData().l() * 0.7f);
                                        tVar2.borderRadius(0.0f, 0.0f, 8.0f, 8.0f);
                                        tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                        tVar2.flexDirectionRow().justifyContentFlexStart().flexWrapWrap();
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.body.1.4.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView.body.1.4.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ArrayList<GoodsCenterCategory> categoryList = GoodsCenterCategoryViewModel.this.getCategoryList();
                                if (categoryList != null) {
                                    GoodsCenterAllCategoryView goodsCenterAllCategoryView3 = goodsCenterAllCategoryView2;
                                    int i3 = 0;
                                    for (Object obj : categoryList) {
                                        int i16 = i3 + 1;
                                        if (i3 < 0) {
                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                        }
                                        ((GoodsCenterAllCategoryView$bodyWithCategoryItem$1) GoodsCenterAllCategoryView.access$bodyWithCategoryItem(goodsCenterAllCategoryView3, i3, (GoodsCenterCategory) obj)).invoke(vVar2);
                                        i3 = i16;
                                    }
                                }
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
