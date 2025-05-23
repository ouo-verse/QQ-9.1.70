package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewEvent$onFeedDeleteResult$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsEmptyViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.TabViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.k;
import com.tencent.ntcompose.foundation.layout.l;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.c;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.base.d;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p35.n;
import s35.af;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedListViewKt {
    public static final void NearbyFeedListView(final TabViewModel<? extends FeedListViewModel> tabViewModel, final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1898923653);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1898923653, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListView (NearbyFeedListView.kt:28)");
        }
        a.b(nBPMiddlePageViewModel.getNearbyFeedsVm(), ((c) startRestartGroup.consume(CompositionLocalsKt.e())).getLifecycle(), startRestartGroup, (Lifecycle.f339325a << 3) | 8);
        final float a16 = ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).a();
        BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), nBPMiddlePageViewModel.getPageListHeight()), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1050294027, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1050294027, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListView.<anonymous> (NearbyFeedListView.kt:37)");
                    }
                    com.tencent.ntcompose.ui.platform.a aVar = (com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d());
                    composer3.startReplaceableGroup(-1938494733);
                    if (NBPMiddlePageViewModel.this.getNearbyFeedsVm().isEnd() && NBPMiddlePageViewModel.this.getNearbyFeedsVm().listVm.feedCardViewModelList.size() == 0) {
                        FeedsEmptyViewKt.FeedsEmptyView(composer3, 0);
                    }
                    composer3.endReplaceableGroup();
                    ComposeFeedListViewModel composeFeedListViewModel = NBPMiddlePageViewModel.this.getNearbyFeedsVm().listVm;
                    com.tencent.ntcompose.foundation.lazy.a aVar2 = NBPMiddlePageViewModel.this.getNearbyFeedsVm().listState;
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                    final TabViewModel<? extends FeedListViewModel> tabViewModel2 = tabViewModel;
                    i a17 = d.a(h16, ComposableLambdaKt.composableLambda(composer3, -1601222110, true, new Function3<com.tencent.ntcompose.material.base.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.material.base.b bVar2, Composer composer4, Integer num2) {
                            com.tencent.ntcompose.material.base.b bVar3 = bVar2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1601222110, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListView.<anonymous>.<anonymous> (NearbyFeedListView.kt:47)");
                            }
                            NBPMiddlePageViewModel.this.bindTabListOffset(tabViewModel2, bVar3, composer5, 584);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 56);
                    r.a aVar3 = new r.a(1);
                    float e16 = aVar.e();
                    float d16 = aVar.d();
                    l c16 = k.c(16.0f, 16.0f, 16.0f, 0.0f, 8, null);
                    Boolean bool = Boolean.FALSE;
                    Float valueOf = Float.valueOf(d16);
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                    final float f16 = a16;
                    Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Float f17, Float f18) {
                            f17.floatValue();
                            NBPMiddlePageViewModel.this.tabList.get(0).listContentHeight.setValue(Float.valueOf(Math.max(f18.floatValue(), f16)));
                            return Unit.INSTANCE;
                        }
                    };
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                    composeFeedListViewModel.buildLazyVerticalGrid(aVar3, a17, e16, aVar2, c16, 0.0f, 24.0f, bool, null, null, null, null, null, 3, valueOf, null, null, null, null, function2, ComposableLambdaKt.composableLambda(composer3, -1108348521, true, new Function3<FooterRefreshState, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1.3

                        /* compiled from: P */
                        /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1$3$1, reason: invalid class name */
                        /* loaded from: classes31.dex */
                        public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                ((NearbyFeedListViewModel) this.receiver).getClass();
                                NBPJumpUtil.jumpSquareFeedList$default(null, null, null, "7", false, null, null, null, 247);
                                return Unit.INSTANCE;
                            }

                            public AnonymousClass1(Object obj) {
                                super(0, obj, NearbyFeedListViewModel.class, "gotoNearbyFeedSquarePage", "gotoNearbyFeedSquarePage()V", 0);
                            }
                        }

                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(FooterRefreshState footerRefreshState, Composer composer4, Integer num2) {
                            FooterRefreshState footerRefreshState2 = footerRefreshState;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                intValue2 |= composer5.changed(footerRefreshState2) ? 4 : 2;
                            }
                            if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1108348521, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListView.<anonymous>.<anonymous> (NearbyFeedListView.kt:58)");
                                }
                                FeedsFooterRefreshViewKt.FeedsFooterRefreshView(footerRefreshState2, "\u53bb\u9644\u8fd1\u5e7f\u573a\u770b\u66f4\u591a\u5e16\u5b50", new AnonymousClass1(NBPMiddlePageViewModel.this.getNearbyFeedsVm()), composer5, (intValue2 & 14) | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 14352448, 3072, 70, 499456);
                    final n nVar = (n) NBPMiddlePageViewModel.this.getNearbyFeedsVm().actionMenuFeed$delegate.getValue();
                    if (nVar != null) {
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = NBPMiddlePageViewModel.this;
                        KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                final n nVar2 = n.this;
                                final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = nBPMiddlePageViewModel5;
                                NBPFeedActionSheetViewKt.NBPFeedActionSheet(viewContainer, new Function1<NBPFeedActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$1$4$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedActionSheetView nBPFeedActionSheetView) {
                                        NBPFeedActionSheetView nBPFeedActionSheetView2 = nBPFeedActionSheetView;
                                        final n nVar3 = n.this;
                                        nBPFeedActionSheetView2.attr(new Function1<NBPFeedActionSheetViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt.NearbyFeedListView.1.4.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPFeedActionSheetViewAttr nBPFeedActionSheetViewAttr) {
                                                String str;
                                                boolean z16;
                                                String l3;
                                                NBPFeedActionSheetViewAttr nBPFeedActionSheetViewAttr2 = nBPFeedActionSheetViewAttr;
                                                String str2 = n.this.f425193d;
                                                UserDataManager userDataManager = UserDataManager.INSTANCE;
                                                String valueOf2 = String.valueOf(userDataManager.getUserSelfInfo().tid);
                                                af afVar = n.this.f425194e;
                                                String str3 = "";
                                                if (afVar == null || (str = Long.valueOf(afVar.f433207e).toString()) == null) {
                                                    str = "";
                                                }
                                                af afVar2 = n.this.f425194e;
                                                if (afVar2 != null && (l3 = Long.valueOf(afVar2.f433207e).toString()) != null) {
                                                    str3 = l3;
                                                }
                                                if (!n.this.I.isEmpty()) {
                                                    af afVar3 = n.this.f425194e;
                                                    if (!(afVar3 != null && afVar3.f433207e == userDataManager.getUserSelfInfo().tid)) {
                                                        z16 = true;
                                                        nBPFeedActionSheetViewAttr2.params(2, str2, valueOf2, str, str3, z16);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                z16 = false;
                                                nBPFeedActionSheetViewAttr2.params(2, str2, valueOf2, str, str3, z16);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = nBPMiddlePageViewModel6;
                                        nBPFeedActionSheetView2.event(new Function1<NBPFeedActionSheetViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt.NearbyFeedListView.1.4.1.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPFeedActionSheetViewEvent nBPFeedActionSheetViewEvent) {
                                                NBPFeedActionSheetViewEvent nBPFeedActionSheetViewEvent2 = nBPFeedActionSheetViewEvent;
                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                nBPFeedActionSheetViewEvent2.closedActionSheet(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt.NearbyFeedListView.1.4.1.1.2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPMiddlePageViewModel.this.getNearbyFeedsVm().actionMenuFeed$delegate.setValue(null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                nBPFeedActionSheetViewEvent2.register("EVENT_DELETE_STATUS_FEED", new NBPFeedActionSheetViewEvent$onFeedDeleteResult$1(new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt.NearbyFeedListView.1.4.1.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(String str) {
                                                        final String str2 = str;
                                                        CollectionsKt__MutableCollectionsKt.removeAll((List) NBPMiddlePageViewModel.this.getNearbyFeedsVm().listVm.feedCardViewModelList, (Function1) new Function1<BaseComposeCardViewModel, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewModel$removeFeed$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Boolean invoke(BaseComposeCardViewModel baseComposeCardViewModel) {
                                                                n nVar4;
                                                                BaseComposeCardViewModel baseComposeCardViewModel2 = baseComposeCardViewModel;
                                                                String str3 = null;
                                                                NearbyFeedItemViewModel nearbyFeedItemViewModel = baseComposeCardViewModel2 instanceof NearbyFeedItemViewModel ? (NearbyFeedItemViewModel) baseComposeCardViewModel2 : null;
                                                                if (nearbyFeedItemViewModel != null && (nVar4 = nearbyFeedItemViewModel.feed) != null) {
                                                                    str3 = nVar4.f425193d;
                                                                }
                                                                return Boolean.valueOf(Intrinsics.areEqual(str3, str2));
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                }));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }, composer3, 0, 3);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt$NearbyFeedListView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedListViewKt.NearbyFeedListView(tabViewModel, nBPMiddlePageViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
