package com.tencent.hippykotlin.demo.pages.goods_center.card.header.category;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataCategoryPanelState;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterCategoryView extends GoodsCenterCardView {
    public ArrayList<aa<v>> categoryRefs = new ArrayList<>();
    public final float itemMargin = 24.0f;
    public aa<aq<?, ?>> listRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithCategoryItem(GoodsCenterCategoryView goodsCenterCategoryView, int i3, GoodsCenterCategory goodsCenterCategory) {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        return new GoodsCenterCategoryView$bodyWithCategoryItem$1(goodsCenterCategoryView, i3, (GoodsCenterCategoryViewModel) viewModel, goodsCenterCategory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithIndicator(GoodsCenterCategoryView goodsCenterCategoryView) {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        return new GoodsCenterCategoryView$bodyWithIndicator$1((GoodsCenterCategoryViewModel) viewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$clickAllCategoryIcon(GoodsCenterCategoryView goodsCenterCategoryView) {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        if (!goodsCenterCategoryViewModel.getShowAllCategory() && !goodsCenterCategoryViewModel.isHeaderOnTop) {
            ((GoodsCenterEvent) goodsCenterCategoryView.getEvent()).onFireEvent("show_all_category_after_scroll", null);
        } else {
            goodsCenterCategoryViewModel.setShowAllCategory(!goodsCenterCategoryViewModel.getShowAllCategory());
        }
        IGoodsCenterCardViewModel viewModel2 = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        ((GoodsCenterCategoryViewModel) viewModel2).pageModel.scrollToCeiling(true, false, 0.5f);
        ((GoodsCenterEvent) goodsCenterCategoryView.getEvent()).onFireEvent("change_filter_panel_visibility", Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$clickCategoryItem(GoodsCenterCategoryView goodsCenterCategoryView, int i3, GoodsCenterCategory goodsCenterCategory) {
        goodsCenterCategoryView.getClass();
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterCategoryView: click category=");
        m3.append(goodsCenterCategory.name);
        m3.append(", index=");
        m3.append(i3);
        utils.logToNative(m3.toString());
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        if (((GoodsCenterCategoryViewModel) viewModel).handleUpdateCategoryItem(i3, goodsCenterCategory)) {
            ((GoodsCenterEvent) goodsCenterCategoryView.getEvent()).onFireEvent("check_category", new GoodsCenterEventDataCategoryPanelState());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$scrollToTargetOffset(GoodsCenterCategoryView goodsCenterCategoryView) {
        aq<?, ?> b16;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        aa<aq<?, ?>> aaVar = goodsCenterCategoryView.listRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        ScrollerView.setContentOffset$default(b16, ((Number) goodsCenterCategoryViewModel.contentOffsetX$delegate.getValue(goodsCenterCategoryViewModel, GoodsCenterCategoryViewModel.$$delegatedProperties[4])).floatValue(), 0.0f, true, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updateIndicatorFrameX(GoodsCenterCategoryView goodsCenterCategoryView) {
        float f16;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        d catFrameWithIndex = goodsCenterCategoryView.catFrameWithIndex(goodsCenterCategoryViewModel.getSelectedIndex());
        if (catFrameWithIndex != null) {
            f16 = ((catFrameWithIndex.getWidth() / 2) + catFrameWithIndex.getX()) - 10.0f;
        } else {
            f16 = 6.0f;
        }
        goodsCenterCategoryViewModel.indicatorFrameX$delegate.setValue(goodsCenterCategoryViewModel, GoodsCenterCategoryViewModel.$$delegatedProperties[3], Float.valueOf(f16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updateListContentOffsetX(GoodsCenterCategoryView goodsCenterCategoryView) {
        aq<?, ?> b16;
        FlexNode flexNode;
        d layoutFrame;
        FlexNode flexNode2;
        d layoutFrame2;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        d catFrameWithIndex = goodsCenterCategoryView.catFrameWithIndex(goodsCenterCategoryViewModel.getSelectedIndex());
        float f16 = 2;
        float max = Math.max(((((catFrameWithIndex != null ? catFrameWithIndex.getWidth() : 0.0f) / f16) + (catFrameWithIndex != null ? catFrameWithIndex.getX() : 0.0f)) + 16.0f) - (goodsCenterCategoryView.getPagerData().m() / f16), 0.0f);
        float size = (goodsCenterCategoryView.categoryRefs.size() - 1) * goodsCenterCategoryView.itemMargin;
        Iterator<aa<v>> it = goodsCenterCategoryView.categoryRefs.iterator();
        while (it.hasNext()) {
            v b17 = it.next().b();
            size += (b17 == null || (flexNode2 = b17.getFlexNode()) == null || (layoutFrame2 = flexNode2.getLayoutFrame()) == null) ? 0.0f : layoutFrame2.getWidth();
        }
        aa<aq<?, ?>> aaVar = goodsCenterCategoryView.listRef;
        float min = Math.min(max, Math.max(size - ((aaVar == null || (b16 = aaVar.b()) == null || (flexNode = b16.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getWidth()), 0.0f));
        ReadWriteProperty readWriteProperty = goodsCenterCategoryViewModel.contentOffsetX$delegate;
        KProperty<?>[] kPropertyArr = GoodsCenterCategoryViewModel.$$delegatedProperties;
        readWriteProperty.setValue(goodsCenterCategoryViewModel, kPropertyArr[4], Float.valueOf(min));
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterCategoryView: cal content offset = ");
        m3.append(((Number) goodsCenterCategoryViewModel.contentOffsetX$delegate.getValue(goodsCenterCategoryViewModel, kPropertyArr[4])).floatValue());
        utils.logToNative(m3.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.keepAlive(true);
                        mVar2.mo141height(44.0f);
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(mVar2).getForegroundColor());
                        mVar2.flexDirectionRow().justifyContentFlexStart().alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryView goodsCenterCategoryView = GoodsCenterCategoryView.this;
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel2 = goodsCenterCategoryViewModel;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final GoodsCenterCategoryView goodsCenterCategoryView2 = GoodsCenterCategoryView.this;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                GoodsCenterCategoryView.this.listRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.scrollEnable(true);
                                aoVar2.showScrollerIndicator(false);
                                aoVar2.m140flex(1.0f).alignSelfStretch();
                                aoVar2.flexDirectionRow().alignItemsCenter();
                                c.a.a(aoVar2, 0.0f, 16.0f, 0.0f, 0.0f, 5, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel3 = goodsCenterCategoryViewModel2;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.2.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GoodsCenterCategoryViewModel.this.getCategoryList();
                            }
                        };
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = goodsCenterCategoryViewModel2;
                        final GoodsCenterCategoryView goodsCenterCategoryView3 = GoodsCenterCategoryView.this;
                        BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                ArrayList<GoodsCenterCategory> categoryList = GoodsCenterCategoryViewModel.this.getCategoryList();
                                if (categoryList != null) {
                                    GoodsCenterCategoryView goodsCenterCategoryView4 = goodsCenterCategoryView3;
                                    int i3 = 0;
                                    for (Object obj : categoryList) {
                                        int i16 = i3 + 1;
                                        if (i3 < 0) {
                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                        }
                                        ((GoodsCenterCategoryView$bodyWithCategoryItem$1) GoodsCenterCategoryView.access$bodyWithCategoryItem(goodsCenterCategoryView4, i3, (GoodsCenterCategory) obj)).invoke(bindDirectivesView2);
                                        i3 = i16;
                                    }
                                }
                                ((GoodsCenterCategoryView$bodyWithIndicator$1) GoodsCenterCategoryView.access$bodyWithIndicator(goodsCenterCategoryView3)).invoke(bindDirectivesView2);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 52.0f, 6, null);
                                tVar2.size(16.5f, 44.0f);
                                Direction direction = Direction.TO_RIGHT;
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_transparent_gradient", false);
                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(new h("qecommerce_skin_color_bg_default"), 1.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryView goodsCenterCategoryView2 = GoodsCenterCategoryView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow().alignItemsCenter().alignSelfStretch();
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterCategoryView goodsCenterCategoryView3 = GoodsCenterCategoryView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GoodsCenterCategoryView goodsCenterCategoryView4 = GoodsCenterCategoryView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GoodsCenterCategoryView.access$clickAllCategoryIcon(GoodsCenterCategoryView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.mo153width(24.0f).mo141height(24.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_general_more_across_primary", false, 2, null);
                                        c.a.a(afVar2, 0.0f, 12.0f, 0.0f, 16.0f, 5, null);
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

    public final d catFrameWithIndex(int i3) {
        v b16;
        if (i3 >= this.categoryRefs.size() || (b16 = this.categoryRefs.get(i3).b()) == null) {
            return null;
        }
        return b16.getFlexNode().getLayoutFrame();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel");
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = (GoodsCenterCategoryViewModel) viewModel;
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$viewDidLoad$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(GoodsCenterCategoryViewModel.this.getSelectedIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$viewDidLoad$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                GoodsCenterCategoryView.access$updateIndicatorFrameX(GoodsCenterCategoryView.this);
                GoodsCenterCategoryView.access$updateListContentOffsetX(GoodsCenterCategoryView.this);
                GoodsCenterCategoryView.access$scrollToTargetOffset(GoodsCenterCategoryView.this);
                return Unit.INSTANCE;
            }
        });
    }
}
