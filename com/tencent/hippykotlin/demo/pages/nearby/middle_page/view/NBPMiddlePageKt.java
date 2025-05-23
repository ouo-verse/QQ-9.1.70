package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareContentData;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.ActivatePoi;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.SetPoiTagsInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedListViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$setTagsStatus$5$1;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.TabViewModel;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.EventName;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.FlowRowKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.PagerListKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TabRowKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import j35.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import org.apache.httpcore.message.TokenParser;
import p35.ah;
import to3.b;
import x25.m;
import x25.p;

/* loaded from: classes31.dex */
public final class NBPMiddlePageKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$toggleFeedAreaStateChange(NBPMiddlePageViewModel nBPMiddlePageViewModel) {
        int intValue = ((Number) nBPMiddlePageViewModel.feedAreaHeightState$delegate.getValue()).intValue();
        if (intValue == 1) {
            nBPMiddlePageViewModel.setFeedsAreaState(2);
        } else {
            if (intValue != 2) {
                return;
            }
            nBPMiddlePageViewModel.setFeedsAreaState(1);
        }
    }

    public static final void NBPMiddlePage(final ah ahVar, final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(1569072046);
        if ((i16 & 2) != 0) {
            Function1<b, NBPMiddlePageViewModel> function1 = new Function1<b, NBPMiddlePageViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$NBPMiddlePage$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final NBPMiddlePageViewModel invoke(b bVar2) {
                    return new NBPMiddlePageViewModel(ah.this, c.f117352a.g().getPageData());
                }
            };
            startRestartGroup.startReplaceableGroup(1485077867);
            Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
            if (consume != null) {
                k kVar = (k) consume;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPMiddlePageViewModel.class);
                e eVar = new e();
                eVar.a(Reflection.getOrCreateKotlinClass(NBPMiddlePageViewModel.class), function1);
                i.b b16 = eVar.b();
                if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                    bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                } else {
                    bVar = b.a.f339329b;
                }
                g c16 = a.c(orCreateKotlinClass, kVar, "NBPMIDDLE_PAGE_VIEW_MODEL_KEY", b16, bVar, startRestartGroup, 33160, 0);
                startRestartGroup.endReplaceableGroup();
                nBPMiddlePageViewModel = (NBPMiddlePageViewModel) c16;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569072046, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePage (NBPMiddlePage.kt:92)");
        }
        a.b(nBPMiddlePageViewModel, ((com.tencent.ntcompose.lifecycle.common.c) startRestartGroup.consume(CompositionLocalsKt.e())).getLifecycle(), startRestartGroup, (Lifecycle.f339325a << 3) | 8);
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), Alignment.TopCenter, new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$NBPMiddlePage$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(v vVar, aa<v> aaVar) {
                NBPMiddlePageViewModel.this.containerRef = aaVar;
                return Unit.INSTANCE;
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, 1398849128, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$NBPMiddlePage$3
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1398849128, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePage.<anonymous> (NBPMiddlePage.kt:109)");
                    }
                    NBPMiddlePageKt.access$palaceInfoArea(NBPMiddlePageViewModel.this, composer3, 8);
                    NBPMiddlePageKt.access$feedsArea(NBPMiddlePageViewModel.this, composer3, 8);
                    NBPMiddlePageKt.access$middlePageNavBar(NBPMiddlePageViewModel.this, composer3, 8);
                    NBPMiddlePageKt.access$publishButton(NBPMiddlePageViewModel.this, composer3, 8);
                    composer3.startReplaceableGroup(-120614362);
                    if (NBPMiddlePageViewModel.this.showPopView.getValue().booleanValue()) {
                        NBPLightPlacePopViewKt.NBPLightPlacePopView(NBPMiddlePageViewModel.this, composer3, 8);
                    }
                    composer3.endReplaceableGroup();
                    if (NBPMiddlePageViewModel.this.showLoadingView.getValue().booleanValue()) {
                        LoadingViewKt.LoadingView(false, composer3, 0, 1);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$NBPMiddlePage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPMiddlePageKt.NBPMiddlePage(ah.this, nBPMiddlePageViewModel, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$middlePageNavBar(final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(994150949);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(994150949, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.middlePageNavBar (NBPMiddlePage.kt:133)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i(), 0.0f, 0.0f, 13, null), 44), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 480602183, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$middlePageNavBar$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(480602183, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.middlePageNavBar.<anonymous> (NBPMiddlePage.kt:141)");
                    }
                    BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 36.0f), 18.0f), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("fill_allblack_weak")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$middlePageNavBar$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, 3, null), Alignment.Center, null, ComposableSingletons$NBPMiddlePageKt.f53lambda1, composer3, 3128, 4);
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                    RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1876043031, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$middlePageNavBar$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1876043031, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.middlePageNavBar.<anonymous>.<anonymous> (NBPMiddlePage.kt:158)");
                                }
                                composer5.startReplaceableGroup(363860548);
                                if (NBPMiddlePageViewModel.this.enableTencentMapMiniApp()) {
                                    com.tencent.ntcompose.core.i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 36.0f), 18.0f), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), QUIToken.color$default("fill_allblack_weak"));
                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                                    com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(c16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.middlePageNavBar.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            NBPMiddlePageDTReporter.reportElementClick$default(NBPMiddlePageViewModel.this.getDtReporter(), "em_nearby_go_to_navigate", null, null, 6);
                                            NBPMiddlePageViewModel.this.launchTencentMapNavigation();
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null);
                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                                    BoxKt.a(ViewEventPropUpdaterKt.g(d16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.middlePageNavBar.1.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            NBPMiddlePageDTReporter.reportElementImp$default(NBPMiddlePageViewModel.this.getDtReporter(), "em_nearby_go_to_navigate", null, 6);
                                            return Unit.INSTANCE;
                                        }
                                    }), Alignment.Center, null, ComposableSingletons$NBPMiddlePageKt.f54lambda2, composer5, 3128, 4);
                                }
                                composer5.endReplaceableGroup();
                                com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 36.0f), 18.0f), 0.0f, 0.0f, 16.0f, 0.0f, 11, null), QUIToken.color$default("fill_allblack_weak"));
                                final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = NBPMiddlePageViewModel.this;
                                com.tencent.ntcompose.core.i d17 = ViewEventPropUpdaterKt.d(c17, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.middlePageNavBar.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPMiddlePageDTReporter.reportElementClick$default(NBPMiddlePageViewModel.this.getDtReporter(), "em_nearby_share_btn", null, null, 6);
                                        NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                        if (nBPMiddlePageViewModel6.hasLightThisPlace.getValue().booleanValue()) {
                                            m poiData = nBPMiddlePageViewModel6.getPoiData();
                                            if (poiData != null) {
                                                boolean z16 = nBPMiddlePageViewModel6.hasCanceledToday;
                                                KLog kLog = KLog.INSTANCE;
                                                StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("jumpMiddlePageSharePage: source=", 2, ", displayName=");
                                                ah ahVar = poiData.f447113d;
                                                m3.append(ahVar != null ? ahVar.Q : null);
                                                kLog.i("NBPJumpUtil", m3.toString());
                                                QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{c45.i.d(poiData)});
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=2&share_type=3&poi_key=");
                                                ah ahVar2 = poiData.f447113d;
                                                sb5.append(ahVar2 != null ? ahVar2.R : null);
                                                sb5.append("&poi_canceled=");
                                                sb5.append(z16);
                                                sb5.append("&custom_back_pressed=1&modal_mode=1&nbp_source=");
                                                sb5.append(2);
                                                String sb6 = sb5.toString();
                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.openPage$default(sb6, false, 6);
                                            }
                                        } else {
                                            NBPInteractiveRepo.INSTANCE.getArkMsg(new j35.c(8, (j35.b) null, (j35.k) null, (j35.i) null, (j35.a) null, new j(nBPMiddlePageViewModel6.getPoiData()), 61), new Function3<Integer, String, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$sendQQArkMsg$1
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(Integer num3, String str, String str2) {
                                                    int intValue3 = num3.intValue();
                                                    String str3 = str;
                                                    String str4 = str2;
                                                    if (intValue3 != 0) {
                                                        if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue3)) {
                                                            str3 = "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                        }
                                                        Utils.INSTANCE.currentBridgeModule().qToast(str3, QToastMode.Info);
                                                    } else {
                                                        Utils.INSTANCE.shareModule(BridgeManager.f117344a.u()).doShareAction(2, null, new ShareContentData(0, str4, "\u9644\u8fd1\u7528\u6237", null, null, null, null, 0, 0, 4088), new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$sendQQArkMsg$1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Integer num4) {
                                                                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", num4.intValue(), KLog.INSTANCE, "NBPMiddlePageViewModel");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null);
                                final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                BoxKt.a(ViewEventPropUpdaterKt.g(d17, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.middlePageNavBar.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NBPMiddlePageDTReporter.reportElementImp$default(NBPMiddlePageViewModel.this.getDtReporter(), "em_nearby_share_btn", null, 6);
                                        return Unit.INSTANCE;
                                    }
                                }), Alignment.Center, null, ComposableSingletons$NBPMiddlePageKt.f55lambda3, composer5, 3128, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196608, 31);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196680, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$middlePageNavBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPMiddlePageKt.access$middlePageNavBar(NBPMiddlePageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$palaceInfoArea(final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-241261354);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-241261354, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea (NBPMiddlePage.kt:205)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), nBPMiddlePageViewModel.placeProfileHeight + 16.0f), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1092188764, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x010a  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                String str;
                List<r35.a> list;
                Object firstOrNull;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1092188764, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous> (NBPMiddlePage.kt:211)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    com.tencent.ntcompose.core.i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), NBPMiddlePageViewModel.this.placeProfileHeight + 16.0f), QUIToken.color$default("overlay_dark"));
                    final NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                    com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(c16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NBPMiddlePageKt.access$toggleFeedAreaStateChange(NBPMiddlePageViewModel.this);
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    m poiData = NBPMiddlePageViewModel.this.getPoiData();
                    if (poiData != null && (list = poiData.D) != null) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                        r35.a aVar = (r35.a) firstOrNull;
                        if (aVar != null) {
                            str = aVar.f430681f;
                            float floatValue = NBPMiddlePageViewModel.this.blurDegree.getValue().floatValue();
                            int a16 = h.INSTANCE.a();
                            final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                            ImageKt.a(str, null, null, new Function2<ImageView, aa<ImageView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.2
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(ImageView imageView, aa<ImageView> aaVar) {
                                    NBPMiddlePageViewModel.this.backgroundRef = aaVar;
                                    return Unit.INSTANCE;
                                }
                            }, null, d16, null, a16, null, null, null, null, null, null, Float.valueOf(floatValue), null, null, null, null, null, null, composer3, 12845056, 0, 0, 2080598);
                            com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                            Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                            a.k h17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                            final MutableState<Float> mutableState2 = mutableState;
                            final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                            ColumnKt.a(h16, h17, b16, null, ComposableLambdaKt.composableLambda(composer3, -976009709, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                    int i16;
                                    d dVar2 = dVar;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i16 = (composer5.changed(dVar2) ? 4 : 2) | intValue2;
                                    } else {
                                        i16 = intValue2;
                                    }
                                    if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-976009709, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous> (NBPMiddlePage.kt:226)");
                                        }
                                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                        SpacerKt.a(dVar2.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null)), 1.0f), composer5, 8, 0);
                                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 53.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                                        a.e e16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                                        Alignment.Vertical c17 = Alignment.INSTANCE.c();
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = nBPMiddlePageViewModel4;
                                        RowKt.a(n3, e16, c17, null, null, ComposableLambdaKt.composableLambda(composer5, -123466699, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-123466699, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:236)");
                                                    }
                                                    i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                    ColumnKt.a(ComposeLayoutPropUpdaterKt.s(com.tencent.ntcompose.foundation.layout.h.a(companion3, 1.0f), 0.0f, 0.0f, 12.0f, 0.0f, 11, null), null, null, null, ComposableLambdaKt.composableLambda(composer7, 1752232492, true, new C30961(NBPMiddlePageViewModel.this)), composer7, 24584, 14);
                                                    com.tencent.ntcompose.core.i s16 = ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(companion3), 36), com.tencent.kuikly.core.base.h.INSTANCE.m()), 8), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                                    com.tencent.ntcompose.core.i g16 = ViewEventPropUpdaterKt.g(s16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj) {
                                                            NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                            NBPMiddlePageDTReporter.reportElementImp$default(dtReporter, "em_nearby_lit_btn", new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.2.1
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                    eVar.t("nearby_btn_state", NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue() ? 1 : 0);
                                                                    return eVar;
                                                                }
                                                            }, 2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                    Function2<v, aa<v>, Unit> function2 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.3
                                                        {
                                                            super(2);
                                                        }

                                                        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.kuikly.core.base.aa<?>>, java.util.ArrayList] */
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(v vVar, aa<v> aaVar) {
                                                            NBPMiddlePageViewModel.this.viewRefList.add(aaVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                    Function1<ClickParams, Unit> function1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            ah ahVar;
                                                            NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                            Unit unit = null;
                                                            NBPMiddlePageDTReporter.reportElementClick$default(dtReporter, "em_nearby_lit_btn", null, new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.4.1
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                    eVar.t("nearby_btn_state", NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue() ? 1 : 0);
                                                                    return eVar;
                                                                }
                                                            }, 2);
                                                            if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                                NBPMiddlePageViewModel.this.showPopView.setValue(Boolean.TRUE);
                                                            } else {
                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                if (!nBPMiddlePageViewModel10.canLightPoi(false)) {
                                                                    KLog.INSTANCE.i("NBPMiddlePageViewModel", "doLightPoi: \u4e0d\u5728\u9644\u8fd1, \u6253\u5f00\u5f39\u7a97\u63d0\u9192");
                                                                    nBPMiddlePageViewModel10.showPopView.setValue(Boolean.TRUE);
                                                                } else {
                                                                    final m poiData2 = nBPMiddlePageViewModel10.getPoiData();
                                                                    if (poiData2 != null && (ahVar = poiData2.f447113d) != null) {
                                                                        NBPPOIRepo repo = nBPMiddlePageViewModel10.getRepo();
                                                                        UserDataManager.INSTANCE.getUserSelfInfo();
                                                                        o25.e coord = NearbyProUtilsKt.getCoord();
                                                                        final Function2<Boolean, String, Unit> function22 = new Function2<Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$doLightPoi$1$1$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Unit invoke(Boolean bool, String str2) {
                                                                                boolean booleanValue = bool.booleanValue();
                                                                                KLog kLog = KLog.INSTANCE;
                                                                                kLog.i("NBPMiddlePageViewModel", "activatePoi success: " + booleanValue + ", msg " + str2);
                                                                                if (booleanValue) {
                                                                                    NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                                    nBPMiddlePageViewModel11.setActiveUserCount(nBPMiddlePageViewModel11.getActiveUserCount() + 1);
                                                                                    MutableState<Boolean> mutableState3 = NBPMiddlePageViewModel.this.hasLightThisPlace;
                                                                                    Boolean bool2 = Boolean.TRUE;
                                                                                    mutableState3.setValue(bool2);
                                                                                    NBPMiddlePageViewModel.this.lightedTimestamps = APICallTechReporterKt.NBPCurrentTime();
                                                                                    NBPMiddlePageViewModel.this.showLoadingView.setValue(bool2);
                                                                                    m mVar = poiData2;
                                                                                    boolean z16 = NBPMiddlePageViewModel.this.hasCanceledToday;
                                                                                    StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("jumpMiddlePageSharePage: source=", 2, ", displayName=");
                                                                                    ah ahVar2 = mVar.f447113d;
                                                                                    m3.append(ahVar2 != null ? ahVar2.Q : null);
                                                                                    kLog.i("NBPJumpUtil", m3.toString());
                                                                                    QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{c45.i.d(mVar)});
                                                                                    StringBuilder sb5 = new StringBuilder();
                                                                                    sb5.append("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=2&share_type=3&poi_key=");
                                                                                    ah ahVar3 = mVar.f447113d;
                                                                                    sb5.append(ahVar3 != null ? ahVar3.R : null);
                                                                                    sb5.append("&poi_canceled=");
                                                                                    sb5.append(z16);
                                                                                    sb5.append("&custom_back_pressed=1&modal_mode=1&nbp_source=");
                                                                                    sb5.append(2);
                                                                                    String sb6 = sb5.toString();
                                                                                    QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.openPage$default(sb6, false, 6);
                                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel12 = NBPMiddlePageViewModel.this;
                                                                                    TimerKt.d(1500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$doLightPoi$1$1$1.1
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Unit invoke() {
                                                                                            NBPMiddlePageViewModel.this.showLoadingView.setValue(Boolean.FALSE);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u70b9\u4eae\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        repo.getClass();
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("activatePoi: ");
                                                                        m3.append(ahVar.Q);
                                                                        m3.append('[');
                                                                        m3.append(ahVar.R);
                                                                        m3.append("] op=");
                                                                        m3.append(0);
                                                                        kLog.i("NBPPOIRepo", m3.toString());
                                                                        ActivatePoi activatePoi = new ActivatePoi(ahVar, coord);
                                                                        QQKuiklyPlatformApi.Companion.sendOIDBRequest(activatePoi, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, activatePoi.getCmd()), new Function1<OIDBResponse<x25.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$activatePoi$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(OIDBResponse<x25.b> oIDBResponse) {
                                                                                OIDBResponse<x25.b> oIDBResponse2 = oIDBResponse;
                                                                                if (oIDBResponse2.success) {
                                                                                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("activatePoi success, trace="), oIDBResponse2.code, KLog.INSTANCE, "NBPPOIRepo");
                                                                                } else {
                                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("activatePoi failure, code:");
                                                                                    m16.append(oIDBResponse2.code);
                                                                                    m16.append(", message:");
                                                                                    m16.append(oIDBResponse2.f114186msg);
                                                                                    m16.append('}');
                                                                                    kLog2.e("NBPPOIRepo", m16.toString());
                                                                                }
                                                                                function22.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }));
                                                                        unit = Unit.INSTANCE;
                                                                    }
                                                                    if (unit == null) {
                                                                        KLog.INSTANCE.e("NBPMiddlePageViewModel", "poiInfo is null");
                                                                    }
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                    ButtonKt.a(function2, function1, g16, null, ComposableLambdaKt.composableLambda(composer7, -159466464, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.5
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-159466464, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:362)");
                                                                }
                                                                if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                                    composer9.startReplaceableGroup(-19715561);
                                                                    TextKt.a(TextViewExtKt.fixLineHeightForView(((com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule")).a(NBPMiddlePageViewModel.this.lightedTimestamps, "yyyy\u5e74MM\u6708dd\u65e5")), null, null, com.tencent.kuikly.core.base.h.INSTANCE.b(), Float.valueOf(14.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 48, 0, 134215590);
                                                                    composer9.endReplaceableGroup();
                                                                } else {
                                                                    composer9.startReplaceableGroup(-19715146);
                                                                    com.tencent.ntcompose.core.i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 20.0f), 0.0f, 0.0f, 5.0f, 0.0f, 11, null);
                                                                    h.Companion companion4 = com.tencent.kuikly.core.base.h.INSTANCE;
                                                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_bELCZnosRLK.png", null, null, null, null, n16, null, 0, null, null, null, null, null, null, null, null, null, null, null, companion4.b(), null, composer9, 262150, 1073741824, 0, 1572830);
                                                                    TextKt.a(TextViewExtKt.fixLineHeightForView("\u70b9\u4eae"), null, null, companion4.b(), Float.valueOf(14.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 48, 0, 134215590);
                                                                    composer9.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 25088, 8);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$1$1, reason: invalid class name and collision with other inner class name */
                                            /* loaded from: classes31.dex */
                                            public final class C30961 extends Lambda implements Function3<d, Composer, Integer, Unit> {
                                                public final /* synthetic */ NBPMiddlePageViewModel $vm;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public C30961(NBPMiddlePageViewModel nBPMiddlePageViewModel) {
                                                    super(3);
                                                    this.$vm = nBPMiddlePageViewModel;
                                                }

                                                /* JADX WARN: Multi-variable type inference failed */
                                                public static final float access$invoke$lambda$1(MutableState mutableState) {
                                                    return ((Number) mutableState.getValue()).floatValue();
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer, Integer num) {
                                                    Composer composer2 = composer;
                                                    int intValue = num.intValue();
                                                    if ((intValue & 81) == 16 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1752232492, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:241)");
                                                        }
                                                        composer2.startReplaceableGroup(-492369756);
                                                        Object rememberedValue = composer2.rememberedValue();
                                                        Composer.Companion companion = Composer.INSTANCE;
                                                        if (rememberedValue == companion.getEmpty()) {
                                                            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, composer2);
                                                        }
                                                        composer2.endReplaceableGroup();
                                                        final MutableState mutableState = (MutableState) rememberedValue;
                                                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                                        com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null);
                                                        composer2.startReplaceableGroup(1157296644);
                                                        boolean changed = composer2.changed(mutableState);
                                                        Object rememberedValue2 = composer2.rememberedValue();
                                                        if (changed || rememberedValue2 == companion.getEmpty()) {
                                                            rememberedValue2 = 
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0072: CONSTRUCTOR (r4v1 'rememberedValue2' java.lang.Object) = (r13v1 'mutableState' androidx.compose.runtime.MutableState A[DONT_INLINE]) A[MD:(androidx.compose.runtime.MutableState<java.lang.Float>):void (m)] (LINE:115) call: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$1$1$1$1.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.1.invoke(com.tencent.ntcompose.foundation.layout.d, androidx.compose.runtime.Composer, java.lang.Integer):kotlin.Unit, file: classes31.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$1$1$1$1, state: NOT_LOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                	... 27 more
                                                                */
                                                            /*
                                                                Method dump skipped, instructions count: 268
                                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.AnonymousClass3.AnonymousClass1.C30961.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                                                        }
                                                    }
                                                }), composer5, 196680, 24);
                                                com.tencent.ntcompose.core.i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 110.0f), 16.0f, 16.0f, 16.0f, 30.0f);
                                                final MutableState<Float> mutableState3 = mutableState2;
                                                composer5.startReplaceableGroup(1157296644);
                                                boolean changed = composer5.changed(mutableState3);
                                                Object rememberedValue2 = composer5.rememberedValue();
                                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(com.tencent.kuikly.core.layout.d dVar3) {
                                                            mutableState3.setValue(Float.valueOf(dVar3.getY()));
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue2);
                                                }
                                                composer5.endReplaceableGroup();
                                                com.tencent.ntcompose.core.i j3 = ViewEventPropUpdaterKt.j(m3, (Function1) rememberedValue2);
                                                Alignment alignment = Alignment.Center;
                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = nBPMiddlePageViewModel4;
                                                final MutableState<Float> mutableState4 = mutableState2;
                                                BoxKt.a(j3, alignment, null, ComposableLambdaKt.composableLambda(composer5, -324400615, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-324400615, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:396)");
                                                            }
                                                            i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                            com.tencent.ntcompose.core.i j16 = ModifiersKt.j(ModifiersKt.E(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 110.0f), true), 8.0f);
                                                            final MutableState<Float> mutableState5 = mutableState4;
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                            BoxKt.a(j16, null, null, ComposableLambdaKt.composableLambda(composer7, -752438369, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                /* JADX WARN: Removed duplicated region for block: B:21:0x00ef  */
                                                                @Override // kotlin.jvm.functions.Function3
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer8, Integer num4) {
                                                                    String str2;
                                                                    List<r35.a> list2;
                                                                    Object firstOrNull2;
                                                                    Composer composer9 = composer8;
                                                                    int intValue4 = num4.intValue();
                                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                        composer9.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-752438369, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:402)");
                                                                        }
                                                                        i.Companion companion4 = com.tencent.ntcompose.core.i.INSTANCE;
                                                                        com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion4, -16.0f, -mutableState5.getValue().floatValue(), -16.0f, 0.0f, 8, null), ((com.tencent.ntcompose.ui.platform.a) composer9.consume(CompositionLocalsKt.d())).e()), nBPMiddlePageViewModel7.placeProfileHeight + 16.0f);
                                                                        m poiData2 = nBPMiddlePageViewModel7.getPoiData();
                                                                        if (poiData2 != null && (list2 = poiData2.D) != null) {
                                                                            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                                                                            r35.a aVar2 = (r35.a) firstOrNull2;
                                                                            if (aVar2 != null) {
                                                                                str2 = aVar2.f430681f;
                                                                                ImageKt.a(str2, null, null, null, null, k3, null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, Float.valueOf(50.0f), null, null, null, null, null, null, composer9, 12845056, 24576, 0, 2080606);
                                                                                BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), new com.tencent.kuikly.core.base.h(4294967295L, 0.18f)), null, null, null, composer9, 8, 14);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                        }
                                                                        str2 = null;
                                                                        ImageKt.a(str2, null, null, null, null, k3, null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, Float.valueOf(50.0f), null, null, null, null, null, null, composer9, 12845056, 24576, 0, 2080606);
                                                                        BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), new com.tencent.kuikly.core.base.h(4294967295L, 0.18f)), null, null, null, composer9, 8, 14);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer7, 3080, 6);
                                                            com.tencent.ntcompose.core.i j17 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 110.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 8.0f);
                                                            Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                                                            a.k h18 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                            ColumnKt.a(j17, h18, b17, null, ComposableLambdaKt.composableLambda(composer7, 1551298576, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar3, Composer composer8, Integer num4) {
                                                                    int i17;
                                                                    d dVar4 = dVar3;
                                                                    Composer composer9 = composer8;
                                                                    int intValue4 = num4.intValue();
                                                                    if ((intValue4 & 14) == 0) {
                                                                        i17 = (composer9.changed(dVar4) ? 4 : 2) | intValue4;
                                                                    } else {
                                                                        i17 = intValue4;
                                                                    }
                                                                    if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                                        composer9.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1551298576, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:426)");
                                                                        }
                                                                        i.Companion companion4 = com.tencent.ntcompose.core.i.INSTANCE;
                                                                        com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 38.0f);
                                                                        a.e e17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                                                                        Alignment.Vertical c18 = Alignment.INSTANCE.c();
                                                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                                        RowKt.a(k3, e17, c18, null, null, ComposableLambdaKt.composableLambda(composer9, 1998691762, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.1
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar, Composer composer10, Integer num5) {
                                                                                Composer composer11 = composer10;
                                                                                int intValue5 = num5.intValue();
                                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                                    composer11.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(1998691762, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:431)");
                                                                                    }
                                                                                    TextKt.a(TextViewExtKt.fixLineHeightForView(NearbyProUtilsKt.formatToDisplay((int) NBPMiddlePageViewModel.this.getActiveUserCount()) + "\u4eba\u5df2\u70b9\u4eae"), null, null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601536, 48, 0, 134215590);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer9, 196680, 24);
                                                                        SpacerKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 0.5f), QUIToken.color$default("border_allwhite_weak")), composer9, 8, 0);
                                                                        com.tencent.ntcompose.core.i a17 = dVar4.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null)), 1.0f);
                                                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                        com.tencent.ntcompose.core.i g16 = ViewEventPropUpdaterKt.g(a17, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                                NBPMiddlePageDTReporter.reportElementImp$default(dtReporter, "em_nearby_assess_area", new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.2.1
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<x25.n>, java.util.ArrayList] */
                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                                                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                        eVar.t("nearby_is_assess", !NBPMiddlePageViewModel.this.myTags.isEmpty() ? 1 : 0);
                                                                                        return eVar;
                                                                                    }
                                                                                }, 2);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        Alignment alignment2 = Alignment.Center;
                                                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                        BoxKt.a(g16, alignment2, null, ComposableLambdaKt.composableLambda(composer9, -388365674, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.3
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer10, Integer num5) {
                                                                                Composer composer11 = composer10;
                                                                                int intValue5 = num5.intValue();
                                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                                    composer11.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-388365674, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:456)");
                                                                                    }
                                                                                    com.tencent.ntcompose.core.i E = ModifiersKt.E(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 52.0f), -4.0f, 0.0f, -4.0f, 0.0f, 10, null), true);
                                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel12 = NBPMiddlePageViewModel.this;
                                                                                    FlowRowKt.a(null, E, null, null, null, 0, ComposableLambdaKt.composableLambda(composer11, 1205242619, true, new Function3<com.tencent.ntcompose.foundation.layout.i, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.3.1
                                                                                        {
                                                                                            super(3);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function3
                                                                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.i iVar, Composer composer12, Integer num6) {
                                                                                            Composer composer13 = composer12;
                                                                                            int intValue6 = num6.intValue();
                                                                                            if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                                composer13.skipToGroupEnd();
                                                                                            } else {
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventStart(1205242619, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:463)");
                                                                                                }
                                                                                                m poiData2 = NBPMiddlePageViewModel.this.getPoiData();
                                                                                                List<x25.n> list2 = poiData2 != null ? poiData2.f447114e : null;
                                                                                                if (list2 != null) {
                                                                                                    NBPMiddlePageViewModel nBPMiddlePageViewModel13 = NBPMiddlePageViewModel.this;
                                                                                                    Iterator<T> it = list2.iterator();
                                                                                                    while (it.hasNext()) {
                                                                                                        NBPMiddlePageKt.access$tagView(nBPMiddlePageViewModel13, (x25.n) it.next(), composer13, 72);
                                                                                                    }
                                                                                                }
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventEnd();
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }), composer11, 1572928, 61);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer9, 3128, 4);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer7, 24648, 8);
                                                            if (NBPMiddlePageViewModel.this.isFirstEnter.getValue().booleanValue()) {
                                                                BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion3, 104.0f, 34.0f), 0.0f, -55.0f, 0.0f, 0.0f, 13, null), Alignment.Center, null, ComposableSingletons$NBPMiddlePageKt.f57lambda5, composer7, 3128, 4);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 3128, 4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 24648, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                            str = null;
                            float floatValue2 = NBPMiddlePageViewModel.this.blurDegree.getValue().floatValue();
                            int a162 = com.tencent.ntcompose.material.h.INSTANCE.a();
                            final NBPMiddlePageViewModel nBPMiddlePageViewModel32 = NBPMiddlePageViewModel.this;
                            ImageKt.a(str, null, null, new Function2<ImageView, aa<ImageView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.2
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(ImageView imageView, aa<ImageView> aaVar) {
                                    NBPMiddlePageViewModel.this.backgroundRef = aaVar;
                                    return Unit.INSTANCE;
                                }
                            }, null, d16, null, a162, null, null, null, null, null, null, Float.valueOf(floatValue2), null, null, null, null, null, null, composer3, 12845056, 0, 0, 2080598);
                            com.tencent.ntcompose.core.i h162 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                            Alignment.Horizontal b162 = Alignment.INSTANCE.b();
                            a.k h172 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                            final MutableState<Float> mutableState22 = mutableState;
                            final NBPMiddlePageViewModel nBPMiddlePageViewModel42 = NBPMiddlePageViewModel.this;
                            ColumnKt.a(h162, h172, b162, null, ComposableLambdaKt.composableLambda(composer3, -976009709, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                    int i16;
                                    d dVar2 = dVar;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i16 = (composer5.changed(dVar2) ? 4 : 2) | intValue2;
                                    } else {
                                        i16 = intValue2;
                                    }
                                    if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-976009709, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous> (NBPMiddlePage.kt:226)");
                                        }
                                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                        SpacerKt.a(dVar2.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null)), 1.0f), composer5, 8, 0);
                                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 53.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                                        a.e e16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                                        Alignment.Vertical c17 = Alignment.INSTANCE.c();
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = nBPMiddlePageViewModel42;
                                        RowKt.a(n3, e16, c17, null, null, ComposableLambdaKt.composableLambda(composer5, -123466699, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-123466699, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:236)");
                                                    }
                                                    i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                    ColumnKt.a(ComposeLayoutPropUpdaterKt.s(com.tencent.ntcompose.foundation.layout.h.a(companion3, 1.0f), 0.0f, 0.0f, 12.0f, 0.0f, 11, null), null, null, null, ComposableLambdaKt.composableLambda(composer7, 1752232492, true, new C30961(NBPMiddlePageViewModel.this)), composer7, 24584, 14);
                                                    com.tencent.ntcompose.core.i s16 = ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(companion3), 36), com.tencent.kuikly.core.base.h.INSTANCE.m()), 8), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                                    com.tencent.ntcompose.core.i g16 = ViewEventPropUpdaterKt.g(s16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj) {
                                                            NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                            NBPMiddlePageDTReporter.reportElementImp$default(dtReporter, "em_nearby_lit_btn", new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.2.1
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                    eVar.t("nearby_btn_state", NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue() ? 1 : 0);
                                                                    return eVar;
                                                                }
                                                            }, 2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                    Function2<v, aa<v>, Unit> function2 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.3
                                                        {
                                                            super(2);
                                                        }

                                                        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.kuikly.core.base.aa<?>>, java.util.ArrayList] */
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(v vVar, aa<v> aaVar) {
                                                            NBPMiddlePageViewModel.this.viewRefList.add(aaVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                    Function1<ClickParams, Unit> function1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            ah ahVar;
                                                            NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                            Unit unit = null;
                                                            NBPMiddlePageDTReporter.reportElementClick$default(dtReporter, "em_nearby_lit_btn", null, new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.4.1
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                    eVar.t("nearby_btn_state", NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue() ? 1 : 0);
                                                                    return eVar;
                                                                }
                                                            }, 2);
                                                            if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                                NBPMiddlePageViewModel.this.showPopView.setValue(Boolean.TRUE);
                                                            } else {
                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                if (!nBPMiddlePageViewModel10.canLightPoi(false)) {
                                                                    KLog.INSTANCE.i("NBPMiddlePageViewModel", "doLightPoi: \u4e0d\u5728\u9644\u8fd1, \u6253\u5f00\u5f39\u7a97\u63d0\u9192");
                                                                    nBPMiddlePageViewModel10.showPopView.setValue(Boolean.TRUE);
                                                                } else {
                                                                    final m poiData2 = nBPMiddlePageViewModel10.getPoiData();
                                                                    if (poiData2 != null && (ahVar = poiData2.f447113d) != null) {
                                                                        NBPPOIRepo repo = nBPMiddlePageViewModel10.getRepo();
                                                                        UserDataManager.INSTANCE.getUserSelfInfo();
                                                                        o25.e coord = NearbyProUtilsKt.getCoord();
                                                                        final Function2<? super Boolean, ? super String, Unit> function22 = new Function2<Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$doLightPoi$1$1$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Unit invoke(Boolean bool, String str2) {
                                                                                boolean booleanValue = bool.booleanValue();
                                                                                KLog kLog = KLog.INSTANCE;
                                                                                kLog.i("NBPMiddlePageViewModel", "activatePoi success: " + booleanValue + ", msg " + str2);
                                                                                if (booleanValue) {
                                                                                    NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                                    nBPMiddlePageViewModel11.setActiveUserCount(nBPMiddlePageViewModel11.getActiveUserCount() + 1);
                                                                                    MutableState<Boolean> mutableState3 = NBPMiddlePageViewModel.this.hasLightThisPlace;
                                                                                    Boolean bool2 = Boolean.TRUE;
                                                                                    mutableState3.setValue(bool2);
                                                                                    NBPMiddlePageViewModel.this.lightedTimestamps = APICallTechReporterKt.NBPCurrentTime();
                                                                                    NBPMiddlePageViewModel.this.showLoadingView.setValue(bool2);
                                                                                    m mVar = poiData2;
                                                                                    boolean z16 = NBPMiddlePageViewModel.this.hasCanceledToday;
                                                                                    StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("jumpMiddlePageSharePage: source=", 2, ", displayName=");
                                                                                    ah ahVar2 = mVar.f447113d;
                                                                                    m3.append(ahVar2 != null ? ahVar2.Q : null);
                                                                                    kLog.i("NBPJumpUtil", m3.toString());
                                                                                    QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{c45.i.d(mVar)});
                                                                                    StringBuilder sb5 = new StringBuilder();
                                                                                    sb5.append("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=2&share_type=3&poi_key=");
                                                                                    ah ahVar3 = mVar.f447113d;
                                                                                    sb5.append(ahVar3 != null ? ahVar3.R : null);
                                                                                    sb5.append("&poi_canceled=");
                                                                                    sb5.append(z16);
                                                                                    sb5.append("&custom_back_pressed=1&modal_mode=1&nbp_source=");
                                                                                    sb5.append(2);
                                                                                    String sb6 = sb5.toString();
                                                                                    QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.openPage$default(sb6, false, 6);
                                                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel12 = NBPMiddlePageViewModel.this;
                                                                                    TimerKt.d(1500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$doLightPoi$1$1$1.1
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Unit invoke() {
                                                                                            NBPMiddlePageViewModel.this.showLoadingView.setValue(Boolean.FALSE);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u70b9\u4eae\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        repo.getClass();
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("activatePoi: ");
                                                                        m3.append(ahVar.Q);
                                                                        m3.append('[');
                                                                        m3.append(ahVar.R);
                                                                        m3.append("] op=");
                                                                        m3.append(0);
                                                                        kLog.i("NBPPOIRepo", m3.toString());
                                                                        ActivatePoi activatePoi = new ActivatePoi(ahVar, coord);
                                                                        QQKuiklyPlatformApi.Companion.sendOIDBRequest(activatePoi, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, activatePoi.getCmd()), new Function1<OIDBResponse<x25.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$activatePoi$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(OIDBResponse<x25.b> oIDBResponse) {
                                                                                OIDBResponse<x25.b> oIDBResponse2 = oIDBResponse;
                                                                                if (oIDBResponse2.success) {
                                                                                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("activatePoi success, trace="), oIDBResponse2.code, KLog.INSTANCE, "NBPPOIRepo");
                                                                                } else {
                                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("activatePoi failure, code:");
                                                                                    m16.append(oIDBResponse2.code);
                                                                                    m16.append(", message:");
                                                                                    m16.append(oIDBResponse2.f114186msg);
                                                                                    m16.append('}');
                                                                                    kLog2.e("NBPPOIRepo", m16.toString());
                                                                                }
                                                                                function22.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }));
                                                                        unit = Unit.INSTANCE;
                                                                    }
                                                                    if (unit == null) {
                                                                        KLog.INSTANCE.e("NBPMiddlePageViewModel", "poiInfo is null");
                                                                    }
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                    ButtonKt.a(function2, function1, g16, null, ComposableLambdaKt.composableLambda(composer7, -159466464, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.5
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-159466464, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:362)");
                                                                }
                                                                if (NBPMiddlePageViewModel.this.hasLightThisPlace.getValue().booleanValue()) {
                                                                    composer9.startReplaceableGroup(-19715561);
                                                                    TextKt.a(TextViewExtKt.fixLineHeightForView(((com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule")).a(NBPMiddlePageViewModel.this.lightedTimestamps, "yyyy\u5e74MM\u6708dd\u65e5")), null, null, com.tencent.kuikly.core.base.h.INSTANCE.b(), Float.valueOf(14.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 48, 0, 134215590);
                                                                    composer9.endReplaceableGroup();
                                                                } else {
                                                                    composer9.startReplaceableGroup(-19715146);
                                                                    com.tencent.ntcompose.core.i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 20.0f), 0.0f, 0.0f, 5.0f, 0.0f, 11, null);
                                                                    h.Companion companion4 = com.tencent.kuikly.core.base.h.INSTANCE;
                                                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_bELCZnosRLK.png", null, null, null, null, n16, null, 0, null, null, null, null, null, null, null, null, null, null, null, companion4.b(), null, composer9, 262150, 1073741824, 0, 1572830);
                                                                    TextKt.a(TextViewExtKt.fixLineHeightForView("\u70b9\u4eae"), null, null, companion4.b(), Float.valueOf(14.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 48, 0, 134215590);
                                                                    composer9.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 25088, 8);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$1$1, reason: invalid class name and collision with other inner class name */
                                            /* loaded from: classes31.dex */
                                            public final class C30961 extends Lambda implements Function3<d, Composer, Integer, Unit> {
                                                public final /* synthetic */ NBPMiddlePageViewModel $vm;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public C30961(NBPMiddlePageViewModel nBPMiddlePageViewModel) {
                                                    super(3);
                                                    this.$vm = nBPMiddlePageViewModel;
                                                }

                                                /* JADX WARN: Multi-variable type inference failed */
                                                public static final float access$invoke$lambda$1(MutableState mutableState) {
                                                    return ((Number) mutableState.getValue()).floatValue();
                                                }

                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0072: CONSTRUCTOR (r4v1 'rememberedValue2' java.lang.Object) = (r13v1 'mutableState' androidx.compose.runtime.MutableState A[DONT_INLINE]) A[MD:(androidx.compose.runtime.MutableState<java.lang.Float>):void (m)] (LINE:115) call: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$1$1$1$1.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.1.1.invoke(com.tencent.ntcompose.foundation.layout.d, androidx.compose.runtime.Composer, java.lang.Integer):kotlin.Unit, file: classes31.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$1$1$1$1, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                    	... 22 more
                                                    */
                                                @Override // kotlin.jvm.functions.Function3
                                                public final kotlin.Unit invoke(com.tencent.ntcompose.foundation.layout.d r23, androidx.compose.runtime.Composer r24, java.lang.Integer r25) {
                                                    /*
                                                        Method dump skipped, instructions count: 268
                                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1.AnonymousClass3.AnonymousClass1.C30961.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                                                }
                                            }
                                        }), composer5, 196680, 24);
                                        com.tencent.ntcompose.core.i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 110.0f), 16.0f, 16.0f, 16.0f, 30.0f);
                                        final MutableState<Float> mutableState3 = mutableState22;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed = composer5.changed(mutableState3);
                                        Object rememberedValue2 = composer5.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$1$3$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(com.tencent.kuikly.core.layout.d dVar3) {
                                                    mutableState3.setValue(Float.valueOf(dVar3.getY()));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue2);
                                        }
                                        composer5.endReplaceableGroup();
                                        com.tencent.ntcompose.core.i j3 = ViewEventPropUpdaterKt.j(m3, (Function1) rememberedValue2);
                                        Alignment alignment = Alignment.Center;
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = nBPMiddlePageViewModel42;
                                        final MutableState<Float> mutableState4 = mutableState22;
                                        BoxKt.a(j3, alignment, null, ComposableLambdaKt.composableLambda(composer5, -324400615, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-324400615, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:396)");
                                                    }
                                                    i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                    com.tencent.ntcompose.core.i j16 = ModifiersKt.j(ModifiersKt.E(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 110.0f), true), 8.0f);
                                                    final MutableState<Float> mutableState5 = mutableState4;
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                                    BoxKt.a(j16, null, null, ComposableLambdaKt.composableLambda(composer7, -752438369, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        /* JADX WARN: Removed duplicated region for block: B:21:0x00ef  */
                                                        @Override // kotlin.jvm.functions.Function3
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer8, Integer num4) {
                                                            String str2;
                                                            List<r35.a> list2;
                                                            Object firstOrNull2;
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-752438369, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:402)");
                                                                }
                                                                i.Companion companion4 = com.tencent.ntcompose.core.i.INSTANCE;
                                                                com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion4, -16.0f, -mutableState5.getValue().floatValue(), -16.0f, 0.0f, 8, null), ((com.tencent.ntcompose.ui.platform.a) composer9.consume(CompositionLocalsKt.d())).e()), nBPMiddlePageViewModel7.placeProfileHeight + 16.0f);
                                                                m poiData2 = nBPMiddlePageViewModel7.getPoiData();
                                                                if (poiData2 != null && (list2 = poiData2.D) != null) {
                                                                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                                                                    r35.a aVar2 = (r35.a) firstOrNull2;
                                                                    if (aVar2 != null) {
                                                                        str2 = aVar2.f430681f;
                                                                        ImageKt.a(str2, null, null, null, null, k3, null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, Float.valueOf(50.0f), null, null, null, null, null, null, composer9, 12845056, 24576, 0, 2080606);
                                                                        BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), new com.tencent.kuikly.core.base.h(4294967295L, 0.18f)), null, null, null, composer9, 8, 14);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }
                                                                str2 = null;
                                                                ImageKt.a(str2, null, null, null, null, k3, null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, Float.valueOf(50.0f), null, null, null, null, null, null, composer9, 12845056, 24576, 0, 2080606);
                                                                BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), new com.tencent.kuikly.core.base.h(4294967295L, 0.18f)), null, null, null, composer9, 8, 14);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 3080, 6);
                                                    com.tencent.ntcompose.core.i j17 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 110.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 8.0f);
                                                    Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                                                    a.k h18 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                                    ColumnKt.a(j17, h18, b17, null, ComposableLambdaKt.composableLambda(composer7, 1551298576, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar3, Composer composer8, Integer num4) {
                                                            int i17;
                                                            d dVar4 = dVar3;
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 14) == 0) {
                                                                i17 = (composer9.changed(dVar4) ? 4 : 2) | intValue4;
                                                            } else {
                                                                i17 = intValue4;
                                                            }
                                                            if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1551298576, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:426)");
                                                                }
                                                                i.Companion companion4 = com.tencent.ntcompose.core.i.INSTANCE;
                                                                com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 38.0f);
                                                                a.e e17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                                                                Alignment.Vertical c18 = Alignment.INSTANCE.c();
                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                                RowKt.a(k3, e17, c18, null, null, ComposableLambdaKt.composableLambda(composer9, 1998691762, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.1
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar, Composer composer10, Integer num5) {
                                                                        Composer composer11 = composer10;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                            composer11.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1998691762, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:431)");
                                                                            }
                                                                            TextKt.a(TextViewExtKt.fixLineHeightForView(NearbyProUtilsKt.formatToDisplay((int) NBPMiddlePageViewModel.this.getActiveUserCount()) + "\u4eba\u5df2\u70b9\u4eae"), null, null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 1601536, 48, 0, 134215590);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer9, 196680, 24);
                                                                SpacerKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 0.5f), QUIToken.color$default("border_allwhite_weak")), composer9, 8, 0);
                                                                com.tencent.ntcompose.core.i a17 = dVar4.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null)), 1.0f);
                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel10 = NBPMiddlePageViewModel.this;
                                                                com.tencent.ntcompose.core.i g16 = ViewEventPropUpdaterKt.g(a17, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                                                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                        NBPMiddlePageDTReporter.reportElementImp$default(dtReporter, "em_nearby_assess_area", new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.2.1
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<x25.n>, java.util.ArrayList] */
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                eVar.t("nearby_is_assess", !NBPMiddlePageViewModel.this.myTags.isEmpty() ? 1 : 0);
                                                                                return eVar;
                                                                            }
                                                                        }, 2);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                Alignment alignment2 = Alignment.Center;
                                                                final NBPMiddlePageViewModel nBPMiddlePageViewModel11 = NBPMiddlePageViewModel.this;
                                                                BoxKt.a(g16, alignment2, null, ComposableLambdaKt.composableLambda(composer9, -388365674, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.3
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer10, Integer num5) {
                                                                        Composer composer11 = composer10;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                            composer11.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-388365674, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:456)");
                                                                            }
                                                                            com.tencent.ntcompose.core.i E = ModifiersKt.E(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 52.0f), -4.0f, 0.0f, -4.0f, 0.0f, 10, null), true);
                                                                            final NBPMiddlePageViewModel nBPMiddlePageViewModel12 = NBPMiddlePageViewModel.this;
                                                                            FlowRowKt.a(null, E, null, null, null, 0, ComposableLambdaKt.composableLambda(composer11, 1205242619, true, new Function3<com.tencent.ntcompose.foundation.layout.i, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.palaceInfoArea.1.3.3.2.3.1
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.i iVar, Composer composer12, Integer num6) {
                                                                                    Composer composer13 = composer12;
                                                                                    int intValue6 = num6.intValue();
                                                                                    if ((intValue6 & 81) == 16 && composer13.getSkipping()) {
                                                                                        composer13.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1205242619, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.palaceInfoArea.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:463)");
                                                                                        }
                                                                                        m poiData2 = NBPMiddlePageViewModel.this.getPoiData();
                                                                                        List<x25.n> list2 = poiData2 != null ? poiData2.f447114e : null;
                                                                                        if (list2 != null) {
                                                                                            NBPMiddlePageViewModel nBPMiddlePageViewModel13 = NBPMiddlePageViewModel.this;
                                                                                            Iterator<T> it = list2.iterator();
                                                                                            while (it.hasNext()) {
                                                                                                NBPMiddlePageKt.access$tagView(nBPMiddlePageViewModel13, (x25.n) it.next(), composer13, 72);
                                                                                            }
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer11, 1572928, 61);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer9, 3128, 4);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 24648, 8);
                                                    if (NBPMiddlePageViewModel.this.isFirstEnter.getValue().booleanValue()) {
                                                        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion3, 104.0f, 34.0f), 0.0f, -55.0f, 0.0f, 0.0f, 13, null), Alignment.Center, null, ComposableSingletons$NBPMiddlePageKt.f57lambda5, composer7, 3128, 4);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3128, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 24648, 8);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3128, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$palaceInfoArea$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        NBPMiddlePageKt.access$palaceInfoArea(NBPMiddlePageViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
            }

            public static final void access$publishButton(final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
                Composer startRestartGroup = composer.startRestartGroup(-1270527404);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1270527404, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.publishButton (NBPMiddlePage.kt:710)");
                }
                if (nBPMiddlePageViewModel.tabSelectedIndex.getValue().intValue() != 0) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        return;
                    }
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$publishButton$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer2, Integer num) {
                            num.intValue();
                            NBPMiddlePageKt.access$publishButton(NBPMiddlePageViewModel.this, composer2, i3 | 1);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                RowKt.a(ViewEventPropUpdaterKt.g(ViewEventPropUpdaterKt.d(ModifiersKt.p(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 118.0f, 56.0f), 0.0f, ((((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).d() - ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).f().getBottom()) - nBPMiddlePageViewModel.navBarHeight) - 12.0f, 0.0f, 0.0f, 13, null), 32.0f), QUIToken.color$default("brand_standard")), new com.tencent.kuikly.core.base.g(0.0f, 4.0f, 10.0f, com.tencent.kuikly.core.base.h.INSTANCE.a(0.12f))), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$publishButton$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        NBPMiddlePageDTReporter.reportElementClick$default(NBPMiddlePageViewModel.this.getDtReporter(), "em_neatby_publish_now", null, null, 6);
                        NBPMiddlePageViewModel.this.jumpToPublishPage();
                        return Unit.INSTANCE;
                    }
                }, 3, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$publishButton$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        NBPMiddlePageDTReporter.reportElementImp$default(NBPMiddlePageViewModel.this.getDtReporter(), "em_neatby_publish_now", null, 6);
                        return Unit.INSTANCE;
                    }
                }), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), Alignment.INSTANCE.c(), null, null, ComposableSingletons$NBPMiddlePageKt.f60lambda8, startRestartGroup, 196680, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 == null) {
                    return;
                }
                endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$publishButton$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        NBPMiddlePageKt.access$publishButton(NBPMiddlePageViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
            }

            public static final void access$tabTitle(final String str, final boolean z16, final Function0 function0, Composer composer, final int i3) {
                int i16;
                Composer startRestartGroup = composer.startRestartGroup(1983275915);
                if ((i3 & 14) == 0) {
                    i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
                } else {
                    i16 = i3;
                }
                if ((i3 & 112) == 0) {
                    i16 |= startRestartGroup.changed(z16) ? 32 : 16;
                }
                if ((i3 & 896) == 0) {
                    i16 |= startRestartGroup.changed(function0) ? 256 : 128;
                }
                if ((i16 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1983275915, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.tabTitle (NBPMiddlePage.kt:690)");
                    }
                    com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.B(com.tencent.ntcompose.core.i.INSTANCE), 16.0f, 21.5f, 24.0f, 0.0f, 8, null);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(function0);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tabTitle$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function0.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TabRowKt.b(n3, (Function1) rememberedValue, com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), Alignment.Horizontal.CenterHorizontally, ComposableLambdaKt.composableLambda(startRestartGroup, -582674207, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tabTitle$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer2, Integer num) {
                            bp3.c e16;
                            com.tencent.kuikly.core.base.h color$default;
                            Composer composer3 = composer2;
                            int intValue = num.intValue();
                            if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-582674207, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.tabTitle.<anonymous> (NBPMiddlePage.kt:698)");
                                }
                                String fixLineHeightForView = TextViewExtKt.fixLineHeightForView(str);
                                if (z16) {
                                    e16 = bp3.c.INSTANCE.f();
                                } else {
                                    e16 = bp3.c.INSTANCE.e();
                                }
                                bp3.c cVar = e16;
                                if (z16) {
                                    color$default = QUIToken.color$default("icon_tabbar_primary");
                                } else {
                                    color$default = QUIToken.color$default("icon_nav_secondary");
                                }
                                TextKt.a(fixLineHeightForView, null, null, color$default, Float.valueOf(16.0f), null, cVar, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28672, 48, 0, 134215590);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 28168, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tabTitle$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        NBPMiddlePageKt.access$tabTitle(str, z16, function0, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
            }

            public static final void access$feedsArea(final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
                Composer startRestartGroup = composer.startRestartGroup(212339667);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(212339667, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feedsArea (NBPMiddlePage.kt:546)");
                }
                final com.tencent.ntcompose.foundation.lazy.d a16 = com.tencent.ntcompose.foundation.lazy.e.a(0, 0.0f, startRestartGroup, 0, 3);
                ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).d();
                float f16 = nBPMiddlePageViewModel.navBarHeight;
                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.k(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 16.0f, 16.0f, 0.0f, 0.0f), 0.0f, nBPMiddlePageViewModel.navBarHeight, 0.0f, 0.0f, 13, null);
                com.tencent.ntcompose.foundation.lazy.d dVar = nBPMiddlePageViewModel.feedAreaListViewState;
                Boolean bool = Boolean.FALSE;
                LazyColumnKt.a(n3, null, dVar, null, null, null, bool, bool, null, null, null, 0, null, null, null, null, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollParams scrollParams) {
                        float coerceIn;
                        Object orNull;
                        ScrollParams scrollParams2 = scrollParams;
                        NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                        coerceIn = RangesKt___RangesKt.coerceIn((scrollParams2.getOffsetY() / (nBPMiddlePageViewModel2.placeProfileHeight - nBPMiddlePageViewModel2.navBarHeight)) * 5, 0.0f, 5.0f);
                        if (Math.abs(coerceIn - nBPMiddlePageViewModel2.lastSetBlurDegree) >= 0.2f) {
                            nBPMiddlePageViewModel2.blurDegree.setValue(Float.valueOf(coerceIn));
                            nBPMiddlePageViewModel2.lastSetBlurDegree = coerceIn;
                        }
                        int i16 = 0;
                        if (scrollParams2.getOffsetY() == 0.0f) {
                            nBPMiddlePageViewModel2.blurDegree.setValue(Float.valueOf(0.0f));
                            nBPMiddlePageViewModel2.lastSetBlurDegree = 0.0f;
                        }
                        NBPMiddlePageViewModel.this.mainListContentOffsetY = scrollParams2.getOffsetY();
                        NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                        orNull = CollectionsKt___CollectionsKt.getOrNull(nBPMiddlePageViewModel3.tabList, nBPMiddlePageViewModel3.tabSelectedIndex.getValue().intValue());
                        TabViewModel tabViewModel = (TabViewModel) orNull;
                        if (tabViewModel != null) {
                            tabViewModel.lastListScrollOffsetYForMainList = scrollParams2.getOffsetY();
                        }
                        if (scrollParams2.getOffsetY() < NBPMiddlePageViewModel.this.headerHeight && scrollParams2.getIsDragging()) {
                            NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                            Iterator<TabViewModel<FeedListViewModel>> it = nBPMiddlePageViewModel4.tabList.iterator();
                            while (it.hasNext()) {
                                TabViewModel<FeedListViewModel> next = it.next();
                                int i17 = i16 + 1;
                                if (i16 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                TabViewModel<FeedListViewModel> tabViewModel2 = next;
                                if (i16 != nBPMiddlePageViewModel4.tabSelectedIndex.getValue().intValue()) {
                                    tabViewModel2.lastListScrollOffsetYForMainList = scrollParams2.getOffsetY();
                                }
                                i16 = i17;
                            }
                        }
                        NBPMiddlePageViewModel.this.updateAllTabListOffset();
                        return Unit.INSTANCE;
                    }
                }, null, null, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollParams scrollParams) {
                        ScrollParams scrollParams2 = scrollParams;
                        NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                        if (scrollParams2.getOffsetY() < nBPMiddlePageViewModel2.placeProfileHeight && scrollParams2.getOffsetY() > (nBPMiddlePageViewModel2.placeProfileHeight - nBPMiddlePageViewModel2.navBarHeight) / 2) {
                            nBPMiddlePageViewModel2.setFeedsAreaState(2);
                        } else if (scrollParams2.getOffsetY() < nBPMiddlePageViewModel2.placeProfileHeight / 2) {
                            nBPMiddlePageViewModel2.setFeedsAreaState(1);
                        }
                        return Unit.INSTANCE;
                    }
                }, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1575038648, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                        com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1575038648, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feedsArea.<anonymous> (NBPMiddlePage.kt:577)");
                        }
                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                        com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                        NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                        com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(j3, nBPMiddlePageViewModel2.placeProfileHeight - nBPMiddlePageViewModel2.navBarHeight);
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                        com.tencent.ntcompose.core.i k16 = ViewEventPropUpdaterKt.k(k3, new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap3.a aVar3) {
                                NBPMiddlePageViewModel.this.headerHeight = aVar3.getHeight();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                        com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(k16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r1v5, types: [com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView] */
                            /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.tencent.kuikly.core.base.aa<?>>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                ?? b16;
                                ClickParams clickParams2 = clickParams;
                                NBPMiddlePageViewModel nBPMiddlePageViewModel5 = NBPMiddlePageViewModel.this;
                                if (((Number) nBPMiddlePageViewModel5.feedAreaHeightState$delegate.getValue()).intValue() != 2) {
                                    Iterator it = nBPMiddlePageViewModel5.viewRefList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        DeclarativeBaseView b17 = ((aa) it.next()).b();
                                        if (b17 != null) {
                                            com.tencent.kuikly.core.layout.d frame = b17.getFrame();
                                            aa<v> aaVar = nBPMiddlePageViewModel5.containerRef;
                                            if (NBPMiddlePageViewModel.Companion.containsPoint(b17.convertFrame(frame, aaVar != null ? aaVar.b() : null), clickParams2.getX(), clickParams2.getY() + nBPMiddlePageViewModel5.navBarHeight)) {
                                                b17.onFireEvent(EventName.CLICK.getValue(), null);
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    aa<?> aaVar2 = nBPMiddlePageViewModel5.backgroundRef;
                                    if (aaVar2 != null && (b16 = aaVar2.b()) != 0) {
                                        com.tencent.kuikly.core.layout.d frame2 = b16.getFrame();
                                        aa<v> aaVar3 = nBPMiddlePageViewModel5.containerRef;
                                        if (NBPMiddlePageViewModel.Companion.containsPoint(b16.convertFrame(frame2, aaVar3 != null ? aaVar3.b() : null), clickParams2.getX(), clickParams2.getY())) {
                                            b16.onFireEvent(EventName.CLICK.getValue(), null);
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, 3, null);
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel5 = NBPMiddlePageViewModel.this;
                        BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -621878338, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3.3
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-621878338, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feedsArea.<anonymous>.<anonymous> (NBPMiddlePage.kt:589)");
                                    }
                                    com.tencent.ntcompose.core.i k17 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 10.0f);
                                    NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                                    BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(k17, 0.0f, ((nBPMiddlePageViewModel6.placeProfileHeight - nBPMiddlePageViewModel6.navBarHeight) + 56.0f) - 5, 0.0f, 0.0f, 13, null), QUIToken.color$default("bg_middle_light")), null, null, null, composer5, 8, 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel6 = NBPMiddlePageViewModel.this;
                        final com.tencent.ntcompose.foundation.lazy.d dVar2 = a16;
                        LazyDslKt.d(aVar2, null, null, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 817247807, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(817247807, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feedsArea.<anonymous>.<anonymous> (NBPMiddlePage.kt:599)");
                                    }
                                    if (NBPMiddlePageViewModel.this.getBindChannel()) {
                                        composer5.startReplaceableGroup(-395965497);
                                        int intValue3 = NBPMiddlePageViewModel.this.tabSelectedIndex.getValue().intValue();
                                        com.tencent.ntcompose.core.i k17 = ModifiersKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 56.0f), QUIToken.color$default("bg_middle_light")), 16.0f, 16.0f, 0.0f, 0.0f);
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                                        com.tencent.ntcompose.core.i d17 = ViewEventPropUpdaterKt.d(k17, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.feedsArea.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPMiddlePageKt.access$toggleFeedAreaStateChange(NBPMiddlePageViewModel.this);
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null);
                                        Function2<Composer, Integer, Unit> function2 = ComposableSingletons$NBPMiddlePageKt.f58lambda6;
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                        final com.tencent.ntcompose.foundation.lazy.d dVar3 = dVar2;
                                        TabRowKt.c(intValue3, d17, function2, ComposableLambdaKt.composableLambda(composer5, -947540305, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.feedsArea.3.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue4 = num3.intValue();
                                                if ((intValue4 & 11) == 2 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-947540305, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feedsArea.<anonymous>.<anonymous>.<anonymous> (NBPMiddlePage.kt:616)");
                                                    }
                                                    final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                                    SnapshotStateList<TabViewModel<FeedListViewModel>> snapshotStateList = nBPMiddlePageViewModel9.tabList;
                                                    final com.tencent.ntcompose.foundation.lazy.d dVar4 = dVar3;
                                                    Iterator<TabViewModel<FeedListViewModel>> it = snapshotStateList.iterator();
                                                    final int i16 = 0;
                                                    while (it.hasNext()) {
                                                        TabViewModel<FeedListViewModel> next = it.next();
                                                        int i17 = i16 + 1;
                                                        if (i16 < 0) {
                                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                        }
                                                        NBPMiddlePageKt.access$tabTitle(next.tabTitle, nBPMiddlePageViewModel9.tabSelectedIndex.getValue().intValue() == i16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3$4$2$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                NBPMiddlePageViewModel.this.tabSelectedIndex.setValue(Integer.valueOf(i16));
                                                                com.tencent.ntcompose.foundation.lazy.d.x(dVar4, i16, 0.0f, true, null, 10, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, composer7, 0);
                                                        i16 = i17;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3520, 0);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(-395964237);
                                        com.tencent.ntcompose.core.i k18 = ModifiersKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 56.0f), QUIToken.color$default("bg_middle_light")), 16.0f, 16.0f, 0.0f, 0.0f);
                                        final NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                        BoxKt.a(ViewEventPropUpdaterKt.d(k18, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt.feedsArea.3.4.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPMiddlePageKt.access$toggleFeedAreaStateChange(NBPMiddlePageViewModel.this);
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null), null, null, ComposableSingletons$NBPMiddlePageKt.f59lambda7, composer5, 3080, 6);
                                        composer5.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 15);
                        com.tencent.ntcompose.core.i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), NBPMiddlePageViewModel.this.getPageListHeight()), QUIToken.color$default("bg_middle_light"));
                        int intValue2 = NBPMiddlePageViewModel.this.tabSelectedIndex.getValue().intValue();
                        float e16 = ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e();
                        com.tencent.ntcompose.foundation.lazy.d dVar3 = a16;
                        Float valueOf = Float.valueOf(e16);
                        Boolean bool2 = Boolean.FALSE;
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel7 = NBPMiddlePageViewModel.this;
                        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Integer num2) {
                                Object orNull;
                                int intValue3 = num2.intValue();
                                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("onPageIndexDidChanged to: ", intValue3, KLog.INSTANCE, "NBPMiddlePage");
                                NBPMiddlePageViewModel.this.tabSelectedIndex.setValue(Integer.valueOf(intValue3));
                                NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                                orNull = CollectionsKt___CollectionsKt.getOrNull(nBPMiddlePageViewModel8.tabList, nBPMiddlePageViewModel8.tabSelectedIndex.getValue().intValue());
                                TabViewModel tabViewModel = (TabViewModel) orNull;
                                float f17 = tabViewModel != null ? tabViewModel.lastListScrollOffsetYForMainList : 0.0f;
                                NBPMiddlePageViewModel nBPMiddlePageViewModel9 = NBPMiddlePageViewModel.this;
                                float f18 = nBPMiddlePageViewModel9.headerHeight;
                                if (f17 >= f18 || nBPMiddlePageViewModel9.mainListContentOffsetY >= f18) {
                                    if (nBPMiddlePageViewModel9.mainListContentOffsetY >= f18) {
                                        b.a.b(nBPMiddlePageViewModel9.feedAreaListViewState, f17 < f18 ? f18 : f17, false, null, 4, null);
                                    } else {
                                        b.a.b(nBPMiddlePageViewModel9.feedAreaListViewState, f17, false, null, 4, null);
                                    }
                                }
                                NBPMiddlePageViewModel.this.updateAllTabListOffset();
                                return Unit.INSTANCE;
                            }
                        };
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel8 = NBPMiddlePageViewModel.this;
                        PagerListKt.a(c16, null, dVar3, valueOf, intValue2, null, null, bool2, null, null, null, 0, null, null, null, 0.02f, function1, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 740995301, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$3.6
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue3 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(740995301, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feedsArea.<anonymous>.<anonymous> (NBPMiddlePage.kt:671)");
                                }
                                NearbyFeedListViewKt.NearbyFeedListView(NBPMiddlePageViewModel.this.tabList.get(0), NBPMiddlePageViewModel.this, composer5, 72);
                                if (NBPMiddlePageViewModel.this.getBindChannel()) {
                                    ChannelFeedListViewKt.ChannelFeedListView(NBPMiddlePageViewModel.this.tabList.get(1), NBPMiddlePageViewModel.this, composer5, 72);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 12582920, 196608, 3072, 8290146);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3604282);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$feedsArea$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        NBPMiddlePageKt.access$feedsArea(NBPMiddlePageViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
            }

            public static final void access$tagView(final NBPMiddlePageViewModel nBPMiddlePageViewModel, final x25.n nVar, Composer composer, final int i3) {
                Composer startRestartGroup = composer.startRestartGroup(1434646012);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1434646012, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.tagView (NBPMiddlePage.kt:504)");
                }
                com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(com.tencent.ntcompose.core.i.INSTANCE), 24.0f);
                com.tencent.kuikly.core.base.h hVar = nBPMiddlePageViewModel.tagsColorMap.get(Long.valueOf(nVar.f447119d));
                if (hVar == null) {
                    hVar = QUIToken.color$default("fill_allwhite_weak");
                }
                RowKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.q(ComposeLayoutPropUpdaterKt.n(ModifiersKt.g(ModifiersKt.j(ModifiersKt.c(k3, hVar), 6.0f), new com.tencent.kuikly.core.base.e(Intrinsics.areEqual(nBPMiddlePageViewModel.tagsColorMap.get(Long.valueOf(nVar.f447119d)), QUIToken.color$default("fill_allwhite_strong")) ? 1.0f : 0.0f, BorderStyle.SOLID, QUIToken.color$default("border_allwhite_strong"))), 4.0f, 0.0f, 0.0f, 4.0f, 6, null), 6.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tagView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Type inference failed for: r13v13, types: [java.util.List<x25.n>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r13v15, types: [java.util.List<x25.n>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r13v22, types: [java.util.List<x25.n>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r13v5, types: [java.util.List<x25.n>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.List<x25.n>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        boolean z16;
                        List<x25.n> list;
                        ah ahVar;
                        NBPMiddlePageDTReporter dtReporter = NBPMiddlePageViewModel.this.getDtReporter();
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                        Object obj = null;
                        NBPMiddlePageDTReporter.reportElementClick$default(dtReporter, "em_nearby_assess_area", null, new Function0<com.tencent.kuikly.core.nvi.serialization.json.e>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tagView$1.1
                            {
                                super(0);
                            }

                            /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<x25.n>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.nvi.serialization.json.e invoke() {
                                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                eVar.t("nearby_is_assess", !NBPMiddlePageViewModel.this.myTags.isEmpty() ? 1 : 0);
                                return eVar;
                            }
                        }, 2);
                        ?? r132 = NBPMiddlePageViewModel.this.myTags;
                        x25.n nVar2 = nVar;
                        if (!(r132 instanceof Collection) || !r132.isEmpty()) {
                            Iterator it = r132.iterator();
                            while (it.hasNext()) {
                                if (((x25.n) it.next()).f447119d == nVar2.f447119d) {
                                    z16 = true;
                                    break;
                                }
                            }
                        }
                        z16 = false;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("clicked tag: ");
                        m3.append(nVar.f447120e);
                        m3.append(", hasLighted: ");
                        m3.append(z16);
                        kLog.i("NBPMiddlePage", m3.toString());
                        NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                        boolean z17 = !z16;
                        x25.n nVar3 = nVar;
                        m poiData = nBPMiddlePageViewModel3.getPoiData();
                        if (poiData != null && (list = poiData.f447114e) != null) {
                            kLog.i("NBPMiddlePageViewModel", "setTagsStatus\uff1adoActivate: " + z17 + ", tagId: " + nVar3.f447120e + ", tagCount: " + nVar3.f447121f + ", myTags origin Size: " + nBPMiddlePageViewModel3.myTags.size());
                            if (z17) {
                                nBPMiddlePageViewModel3.tagsColorMap.put(Long.valueOf(nVar3.f447119d), QUIToken.color$default("fill_allwhite_strong"));
                                SnapshotStateMap<Long, Long> snapshotStateMap = nBPMiddlePageViewModel3.tagsCountMap;
                                Long valueOf = Long.valueOf(nVar3.f447119d);
                                Long l3 = nBPMiddlePageViewModel3.tagsCountMap.get(Long.valueOf(nVar3.f447119d));
                                snapshotStateMap.put(valueOf, Long.valueOf((l3 != null ? l3.longValue() : 0L) + 1));
                                Iterator<T> it5 = list.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    Object next = it5.next();
                                    if (((x25.n) next).f447119d == nVar3.f447119d) {
                                        obj = next;
                                        break;
                                    }
                                }
                                x25.n nVar4 = (x25.n) obj;
                                if (nVar4 != null) {
                                    nBPMiddlePageViewModel3.myTags.add(nVar4);
                                }
                            } else {
                                nBPMiddlePageViewModel3.tagsColorMap.put(Long.valueOf(nVar3.f447119d), QUIToken.color$default("fill_allwhite_weak"));
                                SnapshotStateMap<Long, Long> snapshotStateMap2 = nBPMiddlePageViewModel3.tagsCountMap;
                                Long valueOf2 = Long.valueOf(nVar3.f447119d);
                                Long l16 = nBPMiddlePageViewModel3.tagsCountMap.get(Long.valueOf(nVar3.f447119d));
                                snapshotStateMap2.put(valueOf2, Long.valueOf((l16 != null ? l16.longValue() : 1L) - 1));
                                Iterator it6 = nBPMiddlePageViewModel3.myTags.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        break;
                                    }
                                    Object next2 = it6.next();
                                    if (((x25.n) next2).f447119d == nVar3.f447119d) {
                                        obj = next2;
                                        break;
                                    }
                                }
                                x25.n nVar5 = (x25.n) obj;
                                if (nVar5 != null) {
                                    nBPMiddlePageViewModel3.myTags.remove(nVar5);
                                }
                            }
                            m poiData2 = nBPMiddlePageViewModel3.getPoiData();
                            if (poiData2 != null && (ahVar = poiData2.f447113d) != null) {
                                NBPPOIRepo repo = nBPMiddlePageViewModel3.getRepo();
                                List<x25.n> list2 = nBPMiddlePageViewModel3.myTags;
                                final NBPMiddlePageViewModel$setTagsStatus$5$1 nBPMiddlePageViewModel$setTagsStatus$5$1 = new Function2<Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel$setTagsStatus$5$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Boolean bool, String str) {
                                        boolean booleanValue = bool.booleanValue();
                                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("setPoiTags success: ", booleanValue, KLog.INSTANCE, "NBPMiddlePageViewModel");
                                        if (!booleanValue) {
                                            Utils.INSTANCE.currentBridgeModule().qToast("\u8bbe\u7f6e\u6807\u7b7e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                repo.getClass();
                                SetPoiTagsInfo setPoiTagsInfo = new SetPoiTagsInfo(ahVar, list2);
                                QQKuiklyPlatformApi.Companion.sendOIDBRequest(setPoiTagsInfo, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, setPoiTagsInfo.getCmd()), new Function1<OIDBResponse<p>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$setPoiTags$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(OIDBResponse<p> oIDBResponse) {
                                        OIDBResponse<p> oIDBResponse2 = oIDBResponse;
                                        if (oIDBResponse2.success) {
                                            ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("setPoiTagInfo success, trace="), oIDBResponse2.code, KLog.INSTANCE, "NBPPOIRepo");
                                            nBPMiddlePageViewModel$setTagsStatus$5$1.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg);
                                        } else {
                                            KLog kLog2 = KLog.INSTANCE;
                                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("setPoiTagInfo failure, code:");
                                            m16.append(oIDBResponse2.code);
                                            m16.append(", message:");
                                            m16.append(oIDBResponse2.f114186msg);
                                            m16.append('}');
                                            kLog2.e("NBPPOIRepo", m16.toString());
                                            nBPMiddlePageViewModel$setTagsStatus$5$1.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 3, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.INSTANCE.c(), new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tagView$2
                    {
                        super(2);
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.kuikly.core.base.aa<?>>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(v vVar, aa<v> aaVar) {
                        NBPMiddlePageViewModel.this.viewRefList.add(aaVar);
                        return Unit.INSTANCE;
                    }
                }, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2100032670, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tagView$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(n nVar2, Composer composer2, Integer num) {
                        String str;
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2100032670, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.tagView.<anonymous> (NBPMiddlePage.kt:532)");
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(x25.n.this.f447120e);
                            Long l3 = nBPMiddlePageViewModel.tagsCountMap.get(Long.valueOf(x25.n.this.f447119d));
                            if ((l3 != null ? l3.longValue() : 0L) > 0) {
                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP);
                                Long l16 = nBPMiddlePageViewModel.tagsCountMap.get(Long.valueOf(x25.n.this.f447119d));
                                m3.append(l16 != null ? NearbyProUtilsKt.formatToDisplay((int) l16.longValue()) : null);
                                str = m3.toString();
                            } else {
                                str = "";
                            }
                            sb5.append(str);
                            TextKt.a(TextViewExtKt.fixLineHeightForView(sb5.toString()), null, null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(10.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, Float.valueOf(12.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 48, 0, 134215590);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 196680, 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPMiddlePageKt$tagView$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        NBPMiddlePageKt.access$tagView(NBPMiddlePageViewModel.this, nVar, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
            }
        }
