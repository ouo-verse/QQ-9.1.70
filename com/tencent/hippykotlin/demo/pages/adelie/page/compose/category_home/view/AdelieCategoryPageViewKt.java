package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AbsDelegateData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomePageBannerConfig;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.BannerDelegateData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.HotDelegateData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.PageDataType;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RecommondPageData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RegularDelegateData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RoleDelegateData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.ToolDelegateData;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIScanningLightKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import g25.h;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdelieCategoryPageViewKt {
    public static final void AdelieCategoryPageView(final StateHolder<RecommondPageData> stateHolder, final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, final h hVar, final e eVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-921292857);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-921292857, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageView (AdelieCategoryPageView.kt:34)");
        }
        LazyColumnKt.a(ViewEventPropUpdaterKt.g(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.B(i.INSTANCE, true), 0.0f, 1, null), ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d()), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageViewKt$AdelieCategoryPageView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                if (!Intrinsics.areEqual(h.this.f401163d, "0")) {
                    RecommondPageData value = stateHolder._state.getValue();
                    if ((value != null ? value.type : null) == PageDataType.NONE) {
                        adelieHomeCategoryViewModel.requestLocalCachePageData(h.this);
                    }
                }
                return Unit.INSTANCE;
            }
        }), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageViewKt$AdelieCategoryPageView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                if (!Intrinsics.areEqual(h.this.f401163d, "0")) {
                    k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                    e eVar2 = new e();
                    eVar2.w("show_next_time", false);
                    Unit unit = Unit.INSTANCE;
                    k.d(kVar, "adelie_interrupt_guide_animation", eVar2, false, 4, null);
                }
                return Unit.INSTANCE;
            }
        }), null, null, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1148645268, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageViewKt$AdelieCategoryPageView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                final com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1148645268, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageView.<anonymous> (AdelieCategoryPageView.kt:61)");
                }
                RecommondPageData value = stateHolder._state.getValue();
                Intrinsics.checkNotNull(value);
                int ordinal = value.type.ordinal();
                if (ordinal == 0) {
                    composer3.startReplaceableGroup(872877394);
                    composer3.endReplaceableGroup();
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("empty view type:");
                    RecommondPageData value2 = stateHolder._state.getValue();
                    Intrinsics.checkNotNull(value2);
                    m3.append(value2.type);
                    kLog.i("AdelieCategoryPageView", m3.toString());
                } else if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            composer3.startReplaceableGroup(872877128);
                            final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel2 = adelieHomeCategoryViewModel;
                            final h hVar2 = hVar;
                            CategoryHomeErrorViewKt.CategoryHomeErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageViewKt$AdelieCategoryPageView$3.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    KLog.INSTANCE.i("AdelieCategoryPageView", "error view reload");
                                    AdelieHomeCategoryViewModel.this.getPageDataWrapper(hVar2).refreshPageData();
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (ordinal != 4) {
                            composer3.startReplaceableGroup(872877571);
                            composer3.endReplaceableGroup();
                        }
                    }
                    composer3.startReplaceableGroup(872875654);
                    RecommondPageData value3 = adelieHomeCategoryViewModel.getPageDataWrapper(hVar).recommondPageData._state.getValue();
                    Intrinsics.checkNotNull(value3);
                    List<AbsDelegateData> list = value3.data;
                    final h hVar3 = hVar;
                    final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel3 = adelieHomeCategoryViewModel;
                    final e eVar2 = eVar;
                    LazyDslKt.b(aVar2, list, null, ComposableLambdaKt.composableLambda(composer3, 1002509675, true, new Function3<AbsDelegateData, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageViewKt$AdelieCategoryPageView$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(AbsDelegateData absDelegateData, Composer composer4, Integer num2) {
                            int i16;
                            AbsDelegateData absDelegateData2 = absDelegateData;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(absDelegateData2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1002509675, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageView.<anonymous>.<anonymous> (AdelieCategoryPageView.kt:79)");
                                }
                                int ordinal2 = BoxType$EnumUnboxingSharedUtility.ordinal(absDelegateData2.type);
                                if (ordinal2 == 0) {
                                    composer5.startReplaceableGroup(205463774);
                                    if (Intrinsics.areEqual(h.this.f401163d, "0")) {
                                        StateHolder<AdelieHomePageBannerConfig> stateHolder2 = adelieHomeCategoryViewModel3.bannerInfo;
                                        Intrinsics.checkNotNull(absDelegateData2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.BannerDelegateData");
                                        BannerCardKt.BannerCard(stateHolder2, (BannerDelegateData) absDelegateData2, eVar2, composer5, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
                                    }
                                    composer5.endReplaceableGroup();
                                } else if (ordinal2 == 1) {
                                    composer5.startReplaceableGroup(205464053);
                                    Intrinsics.checkNotNull(absDelegateData2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.HotDelegateData");
                                    HotAndFriendCardKt.HotAndFriendCard((HotDelegateData) absDelegateData2, eVar2, composer5, 72);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 12.0f), composer5, 8, 0);
                                    composer5.endReplaceableGroup();
                                } else if (ordinal2 == 2) {
                                    composer5.startReplaceableGroup(205464286);
                                    Intrinsics.checkNotNull(absDelegateData2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RoleDelegateData");
                                    RoleCardKt.RoleCard((RoleDelegateData) absDelegateData2, eVar2, adelieHomeCategoryViewModel3, composer5, 584);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 12.0f), composer5, 8, 0);
                                    composer5.endReplaceableGroup();
                                } else if (ordinal2 == 3) {
                                    composer5.startReplaceableGroup(205464523);
                                    com.tencent.ntcompose.foundation.lazy.layout.a aVar3 = aVar2;
                                    Intrinsics.checkNotNull(absDelegateData2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.ToolDelegateData");
                                    ToolCardKt.ToolCard(aVar3, (ToolDelegateData) absDelegateData2, eVar2, composer5, 584);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 12.0f), composer5, 8, 0);
                                    composer5.endReplaceableGroup();
                                } else if (ordinal2 != 4) {
                                    composer5.startReplaceableGroup(205464898);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(205464752);
                                    com.tencent.ntcompose.foundation.lazy.layout.a aVar4 = aVar2;
                                    Intrinsics.checkNotNull(absDelegateData2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RegularDelegateData");
                                    RegularCardKt.RegularCard(aVar4, (RegularDelegateData) absDelegateData2, eVar2, adelieHomeCategoryViewModel3, composer5, 4680);
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3144, 2);
                    CategoryListFooterKt.CategoryListFooter(adelieHomeCategoryViewModel.getPageDataWrapper(hVar).hasNextPage, hVar, adelieHomeCategoryViewModel, composer3, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
                    composer3.endReplaceableGroup();
                } else {
                    composer3.startReplaceableGroup(872874974);
                    c cVar = c.f117352a;
                    if (defpackage.k.a(cVar)) {
                        composer3.startReplaceableGroup(872875040);
                        QUIScanningLightKt.QUIScanningLight(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 719.0f), "category_other_tab", composer3, 56, 0);
                        composer3.endReplaceableGroup();
                    } else if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                        composer3.startReplaceableGroup(872875270);
                        QUIScanningLightKt.QUIScanningLight(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), ((a) composer3.consume(CompositionLocalsKt.d())).e() / 0.4858357f), "category_other_tab", composer3, 56, 0);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(872875583);
                        composer3.endReplaceableGroup();
                    }
                    composer3.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194174);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryPageViewKt$AdelieCategoryPageView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieCategoryPageViewKt.AdelieCategoryPageView(stateHolder, adelieHomeCategoryViewModel, hVar, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
