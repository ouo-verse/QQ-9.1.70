package com.tencent.hippykotlin.demo.pages.goods_center;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageCallback;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GoodsCenterPage extends BasePager implements c {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterPage.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0)};
    public final ArrayList<IGoodsCenterEvent> eventViewModel;
    public aa<FooterRefreshView> footerRefreshRef;
    public final ReadWriteProperty footerRefreshText$delegate = c01.c.a("\u52a0\u8f7d\u66f4\u591a");
    public aa<aq<?, ?>> mainViewRef;
    public final Lazy pageModel$delegate;
    public final ArrayList<aa<?>> scrollEnableView;
    public final ArrayList<aa<?>> topCardViewRef;

    public GoodsCenterPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GoodsCenterPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$pageModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final GoodsCenterPageModel invoke() {
                g pageData = GoodsCenterPage.this.getPageData();
                final GoodsCenterPage goodsCenterPage = GoodsCenterPage.this;
                return new GoodsCenterPageModel(pageData, new IGoodsCenterPageCallback() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$pageModel$2.1
                    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageCallback
                    public final void scrollToSpecifiedPosition(float f16, boolean z16) {
                        aq<?, ?> b16;
                        aa<aq<?, ?>> aaVar = GoodsCenterPage.this.mainViewRef;
                        if (aaVar == null || (b16 = aaVar.b()) == null) {
                            return;
                        }
                        ScrollerView.setContentOffset$default(b16, 0.0f, f16, z16, null, 8, null);
                    }
                });
            }
        });
        this.pageModel$delegate = lazy;
        this.eventViewModel = new ArrayList<>();
        this.scrollEnableView = new ArrayList<>();
        this.topCardViewRef = new ArrayList<>();
    }

    public static final Function1 access$bodyWithMainSubView(GoodsCenterPage goodsCenterPage, GoodsCenterPage goodsCenterPage2, IGoodsCenterCardViewModel iGoodsCenterCardViewModel) {
        goodsCenterPage.getClass();
        return new GoodsCenterPage$bodyWithMainSubView$1(goodsCenterPage2, iGoodsCenterCardViewModel);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        GoodsCenterPageModel pageModel = getPageModel();
        if (!(pageModel instanceof IGoodsCenterEvent)) {
            pageModel = null;
        }
        if (pageModel != null) {
            this.eventViewModel.add(pageModel);
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterPage goodsCenterPage = GoodsCenterPage.this;
                goodsCenterPage.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithBackPendantView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                        GoodsCenterPageModel pageModel2 = GoodsCenterPage.this.getPageModel();
                        com.tencent.kuikly.core.reactive.collection.c cVar = (com.tencent.kuikly.core.reactive.collection.c) pageModel2.backPendantsViewModel$delegate.getValue(pageModel2, GoodsCenterPageModel.$$delegatedProperties[4]);
                        GoodsCenterPage goodsCenterPage2 = GoodsCenterPage.this;
                        Iterator it = cVar.iterator();
                        while (it.hasNext()) {
                            IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel = (IGoodsCenterPendantViewModel) it.next();
                            goodsCenterPage2.getClass();
                            new GoodsCenterPage$bodyWithPendantView$1(iGoodsCenterPendantViewModel, goodsCenterPage2).invoke(viewContainer4);
                        }
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                final GoodsCenterPage goodsCenterPage2 = GoodsCenterPage.this;
                goodsCenterPage2.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithMainView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final GoodsCenterPage goodsCenterPage3 = GoodsCenterPage.this;
                        ar.a(viewContainer3, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithMainView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final GoodsCenterPage goodsCenterPage4 = GoodsCenterPage.this;
                                aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                        GoodsCenterPage.this.mainViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterPage goodsCenterPage5 = GoodsCenterPage.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        ScrollerAttr.bouncesEnable$default(aoVar2, false, false, 2, null);
                                        GoodsCenterPage goodsCenterPage6 = GoodsCenterPage.this;
                                        KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                        goodsCenterPage6.getPageModel().getClass();
                                        aoVar2.absolutePosition((com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().getNavigationBarHeight() + 52.0f) - 45.0f, 0.0f, 0.0f, 0.0f);
                                        aoVar2.showScrollerIndicator(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterPage goodsCenterPage6 = GoodsCenterPage.this;
                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ap apVar) {
                                        ap apVar2 = apVar;
                                        final GoodsCenterPage goodsCenterPage7 = GoodsCenterPage.this;
                                        apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                ScrollParams scrollParams2 = scrollParams;
                                                Iterator<aa<?>> it = GoodsCenterPage.this.scrollEnableView.iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        break;
                                                    }
                                                    Object b16 = it.next().b();
                                                    IGoodsCenterPageSubView iGoodsCenterPageSubView = b16 instanceof IGoodsCenterPageSubView ? (IGoodsCenterPageSubView) b16 : null;
                                                    if (iGoodsCenterPageSubView != null) {
                                                        iGoodsCenterPageSubView.mainViewScrollEvent(scrollParams2);
                                                    }
                                                }
                                                Iterator<aa<?>> it5 = GoodsCenterPage.this.topCardViewRef.iterator();
                                                while (it5.hasNext()) {
                                                    Object b17 = it5.next().b();
                                                    GoodsCenterCardView goodsCenterCardView = b17 instanceof GoodsCenterCardView ? (GoodsCenterCardView) b17 : null;
                                                    if (goodsCenterCardView != null) {
                                                        goodsCenterCardView.bringToFront();
                                                    }
                                                }
                                                GoodsCenterPage.this.getPageModel().currentPageOffsetY = scrollParams2.getOffsetY();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterPage goodsCenterPage8 = GoodsCenterPage.this;
                                        apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                Iterator<aa<?>> it = GoodsCenterPage.this.scrollEnableView.iterator();
                                                while (it.hasNext()) {
                                                    Object b16 = it.next().b();
                                                    IGoodsCenterPageSubView iGoodsCenterPageSubView = b16 instanceof IGoodsCenterPageSubView ? (IGoodsCenterPageSubView) b16 : null;
                                                    if (iGoodsCenterPageSubView != null) {
                                                        iGoodsCenterPageSubView.mainViewScrollEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterPage goodsCenterPage9 = GoodsCenterPage.this;
                                        apVar2.contentSizeChanged(new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.3.3
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(Float f16, Float f17) {
                                                f16.floatValue();
                                                float floatValue = f17.floatValue();
                                                Iterator<aa<?>> it = GoodsCenterPage.this.scrollEnableView.iterator();
                                                while (it.hasNext()) {
                                                    Object b16 = it.next().b();
                                                    IGoodsCenterPageSubView iGoodsCenterPageSubView = b16 instanceof IGoodsCenterPageSubView ? (IGoodsCenterPageSubView) b16 : null;
                                                    if (iGoodsCenterPageSubView != null) {
                                                        iGoodsCenterPageSubView.mainViewContentSizeChanged(floatValue);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterPage goodsCenterPage7 = GoodsCenterPage.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel> invoke() {
                                        GoodsCenterPage goodsCenterPage8 = GoodsCenterPage.this;
                                        KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                        return goodsCenterPage8.getPageModel().getHeadersViewModel();
                                    }
                                };
                                final GoodsCenterPage goodsCenterPage8 = GoodsCenterPage.this;
                                LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<IGoodsCenterCardViewModel>, IGoodsCenterCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.5
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<IGoodsCenterCardViewModel> loopDirectivesView, IGoodsCenterCardViewModel iGoodsCenterCardViewModel) {
                                        GoodsCenterPage goodsCenterPage9 = GoodsCenterPage.this;
                                        ((GoodsCenterPage$bodyWithMainSubView$1) GoodsCenterPage.access$bodyWithMainSubView(goodsCenterPage9, goodsCenterPage9, iGoodsCenterCardViewModel)).invoke(loopDirectivesView);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterPage goodsCenterPage9 = GoodsCenterPage.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.6
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel> invoke() {
                                        GoodsCenterPage goodsCenterPage10 = GoodsCenterPage.this;
                                        KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                        return goodsCenterPage10.getPageModel().getCardsViewModel();
                                    }
                                };
                                final GoodsCenterPage goodsCenterPage10 = GoodsCenterPage.this;
                                LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<IGoodsCenterCardViewModel>, IGoodsCenterCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.7
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<IGoodsCenterCardViewModel> loopDirectivesView, IGoodsCenterCardViewModel iGoodsCenterCardViewModel) {
                                        GoodsCenterPage goodsCenterPage11 = GoodsCenterPage.this;
                                        ((GoodsCenterPage$bodyWithMainSubView$1) GoodsCenterPage.access$bodyWithMainSubView(goodsCenterPage11, goodsCenterPage11, iGoodsCenterCardViewModel)).invoke(loopDirectivesView);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterPage goodsCenterPage11 = GoodsCenterPage.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.8
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        GoodsCenterPage goodsCenterPage12 = GoodsCenterPage.this;
                                        KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                        return Boolean.valueOf(goodsCenterPage12.getPageModel().hasProductCard());
                                    }
                                };
                                final GoodsCenterPage goodsCenterPage12 = GoodsCenterPage.this;
                                ConditionViewKt.c(aqVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final GoodsCenterPage goodsCenterPage13 = GoodsCenterPage.this;
                                        z.a(conditionView, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                final GoodsCenterPage goodsCenterPage14 = GoodsCenterPage.this;
                                                footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                        GoodsCenterPage.this.footerRefreshRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(x xVar) {
                                                        x xVar2 = xVar;
                                                        AttrExtKt.backgroundColorToken(xVar2, "qecommerce_skin_color_bg_default");
                                                        xVar2.k(500.0f);
                                                        xVar2.allCenter();
                                                        xVar2.flexDirectionColumn();
                                                        xVar2.mo141height((xVar2.getPager().getPageData().getIsIphoneX() ? 34.0f : 0.0f) + 30.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                                                GoodsCenterPage goodsCenterPage15 = GoodsCenterPage.this;
                                                KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                                GoodsCenterPageModel pageModel2 = goodsCenterPage15.getPageModel();
                                                FooterRefreshState footerRefreshState = (FooterRefreshState) pageModel2.footerRefreshState$delegate.getValue(pageModel2, GoodsCenterPageModel.$$delegatedProperties[7]);
                                                final GoodsCenterPage goodsCenterPage16 = GoodsCenterPage.this;
                                                companion.b(footerRefreshState, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.3

                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithMainView$1$1$9$1$3$WhenMappings */
                                                    /* loaded from: classes31.dex */
                                                    public /* synthetic */ class WhenMappings {
                                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                        static {
                                                            int[] iArr = new int[FooterRefreshState.values().length];
                                                            try {
                                                                iArr[FooterRefreshState.REFRESHING.ordinal()] = 1;
                                                            } catch (NoSuchFieldError unused) {
                                                            }
                                                            try {
                                                                iArr[FooterRefreshState.IDLE.ordinal()] = 2;
                                                            } catch (NoSuchFieldError unused2) {
                                                            }
                                                            try {
                                                                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
                                                            } catch (NoSuchFieldError unused3) {
                                                            }
                                                            try {
                                                                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
                                                            } catch (NoSuchFieldError unused4) {
                                                            }
                                                            $EnumSwitchMapping$0 = iArr;
                                                        }
                                                    }

                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        bool.booleanValue();
                                                        GoodsCenterPage goodsCenterPage17 = GoodsCenterPage.this;
                                                        KProperty<Object>[] kPropertyArr2 = GoodsCenterPage.$$delegatedProperties;
                                                        GoodsCenterPageModel pageModel3 = goodsCenterPage17.getPageModel();
                                                        int i3 = WhenMappings.$EnumSwitchMapping$0[((FooterRefreshState) pageModel3.footerRefreshState$delegate.getValue(pageModel3, GoodsCenterPageModel.$$delegatedProperties[7])).ordinal()];
                                                        if (i3 == 1) {
                                                            GoodsCenterPage.this.setFooterRefreshText("\u52a0\u8f7d\u66f4\u591a\u4e2d..");
                                                            GoodsCenterPage.this.getPageModel().loadMoreData();
                                                        } else if (i3 == 2) {
                                                            GoodsCenterPage.this.setFooterRefreshText("\u52a0\u8f7d\u66f4\u591a");
                                                            FooterRefreshView b16 = GoodsCenterPage.this.getFooterRefreshRef().b();
                                                            if (b16 != null) {
                                                                b16.t(FooterRefreshEndState.SUCCESS);
                                                            }
                                                        } else if (i3 == 3) {
                                                            GoodsCenterPage.this.setFooterRefreshText("\u6ca1\u6709\u66f4\u591a\u5546\u54c1\u4e86");
                                                            FooterRefreshView b17 = GoodsCenterPage.this.getFooterRefreshRef().b();
                                                            if (b17 != null) {
                                                                b17.t(FooterRefreshEndState.NONE_MORE_DATA);
                                                            }
                                                        } else if (i3 == 4) {
                                                            GoodsCenterPage.this.setFooterRefreshText("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5");
                                                            FooterRefreshView b18 = GoodsCenterPage.this.getFooterRefreshRef().b();
                                                            if (b18 != null) {
                                                                b18.t(FooterRefreshEndState.FAILURE);
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterPage goodsCenterPage17 = GoodsCenterPage.this;
                                                footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(y yVar) {
                                                        y yVar2 = yVar;
                                                        final GoodsCenterPage goodsCenterPage18 = GoodsCenterPage.this;
                                                        VisibilityEventKt.e(yVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                FooterRefreshView b16;
                                                                FooterRefreshView b17 = GoodsCenterPage.this.getFooterRefreshRef().b();
                                                                if ((b17 != null ? b17.getRefreshState() : null) == FooterRefreshState.IDLE && GoodsCenterPage.this.getPageModel().hasProductCard() && (b16 = GoodsCenterPage.this.getFooterRefreshRef().b()) != null) {
                                                                    b16.p();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterPage goodsCenterPage19 = GoodsCenterPage.this;
                                                        yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.4.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(FooterRefreshState footerRefreshState2) {
                                                                GoodsCenterPage goodsCenterPage20 = GoodsCenterPage.this;
                                                                KProperty<Object>[] kPropertyArr2 = GoodsCenterPage.$$delegatedProperties;
                                                                goodsCenterPage20.getPageModel().setFooterRefreshState(footerRefreshState2);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterPage goodsCenterPage20 = GoodsCenterPage.this;
                                                        yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.4.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                FooterRefreshView b16 = GoodsCenterPage.this.getFooterRefreshRef().b();
                                                                FooterRefreshState refreshState = b16 != null ? b16.getRefreshState() : null;
                                                                if (refreshState == FooterRefreshState.IDLE || refreshState == FooterRefreshState.FAILURE) {
                                                                    GoodsCenterPage.this.getPageModel().loadMoreData();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterPage goodsCenterPage18 = GoodsCenterPage.this;
                                                cg.a(footerRefreshView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final GoodsCenterPage goodsCenterPage19 = GoodsCenterPage.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.5.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.color(new h(4291611852L));
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                GoodsCenterPage goodsCenterPage20 = GoodsCenterPage.this;
                                                                ceVar2.text((String) goodsCenterPage20.footerRefreshText$delegate.getValue(goodsCenterPage20, GoodsCenterPage.$$delegatedProperties[0]));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                if (footerRefreshView2.getPager().getPageData().getIsIphoneX()) {
                                                    w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.6
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.9.1.6.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                                                    tVar2.mo141height(34.0f);
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
                                final GoodsCenterPage goodsCenterPage13 = GoodsCenterPage.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel>> function04 = new Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.10
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterCardViewModel> invoke() {
                                        GoodsCenterPage goodsCenterPage14 = GoodsCenterPage.this;
                                        KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                        return goodsCenterPage14.getPageModel().getFootersViewModel();
                                    }
                                };
                                final GoodsCenterPage goodsCenterPage14 = GoodsCenterPage.this;
                                LoopDirectivesViewKt.a(aqVar2, function04, new Function2<LoopDirectivesView<IGoodsCenterCardViewModel>, IGoodsCenterCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainView.1.1.11
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<IGoodsCenterCardViewModel> loopDirectivesView, IGoodsCenterCardViewModel iGoodsCenterCardViewModel) {
                                        GoodsCenterPage goodsCenterPage15 = GoodsCenterPage.this;
                                        ((GoodsCenterPage$bodyWithMainSubView$1) GoodsCenterPage.access$bodyWithMainSubView(goodsCenterPage15, goodsCenterPage15, iGoodsCenterCardViewModel)).invoke(loopDirectivesView);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                final GoodsCenterPage goodsCenterPage3 = GoodsCenterPage.this;
                goodsCenterPage3.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithFrontPendantView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final GoodsCenterPage goodsCenterPage4 = GoodsCenterPage.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterPendantViewModel>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterPendantViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithFrontPendantView$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<IGoodsCenterPendantViewModel> invoke() {
                                GoodsCenterPage goodsCenterPage5 = GoodsCenterPage.this;
                                KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                return goodsCenterPage5.getPageModel().getFrontPendantsViewModel();
                            }
                        };
                        final GoodsCenterPage goodsCenterPage5 = GoodsCenterPage.this;
                        LoopDirectivesViewKt.a(viewContainer3, function0, new Function2<LoopDirectivesView<IGoodsCenterPendantViewModel>, IGoodsCenterPendantViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithFrontPendantView$1.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<IGoodsCenterPendantViewModel> loopDirectivesView, IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel) {
                                GoodsCenterPage goodsCenterPage6 = GoodsCenterPage.this;
                                KProperty<Object>[] kPropertyArr = GoodsCenterPage.$$delegatedProperties;
                                goodsCenterPage6.getClass();
                                new GoodsCenterPage$bodyWithPendantView$1(iGoodsCenterPendantViewModel, goodsCenterPage6).invoke(loopDirectivesView);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    public final aa<FooterRefreshView> getFooterRefreshRef() {
        aa<FooterRefreshView> aaVar = this.footerRefreshRef;
        if (aaVar != null) {
            return aaVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("footerRefreshRef");
        return null;
    }

    public final GoodsCenterPageModel getPageModel() {
        return (GoodsCenterPageModel) this.pageModel$delegate.getValue();
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            GoodsCenterNavBarViewModel goodsCenterNavBarViewModel = getPageModel().navBarViewModel;
            goodsCenterNavBarViewModel.sysBackCalledAutoIncreaseId$delegate.setValue(goodsCenterNavBarViewModel, GoodsCenterNavBarViewModel.$$delegatedProperties[3], Integer.valueOf(goodsCenterNavBarViewModel.getSysBackCalledAutoIncreaseId() + 1));
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        e eVar = new e();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("daihuo_exp", m3);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        e eVar = new e();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("daihuo_exit", m3);
    }

    public final void setFooterRefreshText(String str) {
        this.footerRefreshText$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        addPagerEventObserver(this);
    }
}
