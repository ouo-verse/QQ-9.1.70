package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.ActionButtonParams;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.LoadingViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.FooterRefreshKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.p;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFollowerListKt {
    public static final void NBPFansList(final NBPFollowerViewModel nBPFollowerViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(-171064334);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if (i17 == 1 && (i18 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else if (i17 != 0) {
                NBPFollowerListKt$NBPFansList$1 nBPFollowerListKt$NBPFansList$1 = new Function1<b, NBPFollowerViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPFollowerViewModel invoke(b bVar2) {
                        return new NBPFollowerViewModel(c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class), nBPFollowerListKt$NBPFansList$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    nBPFollowerViewModel = (NBPFollowerViewModel) c16;
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-171064334, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFansList (NBPFollowerList.kt:48)");
            }
            BoxKt.a(ViewEventPropUpdaterKt.h(ViewEventPropUpdaterKt.g(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_middle_light")), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                    int i19 = NBPFollowerViewModel.$r8$clinit;
                    nBPFollowerViewModel2.dtReportPageExposure(true, false);
                    return Unit.INSTANCE;
                }
            }), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                    int i19 = NBPFollowerViewModel.$r8$clinit;
                    nBPFollowerViewModel2.dtReportPageExposure(false, false);
                    return Unit.INSTANCE;
                }
            }), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2088707500, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$4
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2088707500, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFansList.<anonymous> (NBPFollowerList.kt:60)");
                        }
                        if (NBPFollowerViewModel.this.isEnterLoading.getValue().booleanValue()) {
                            composer3.startReplaceableGroup(-1360357141);
                            LoadingViewKt.LoadingView(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (NBPFollowerViewModel.this.getTotalFansCount() != 0 && !NBPFollowerViewModel.this.fansList.isEmpty()) {
                            composer3.startReplaceableGroup(-1360356829);
                            com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                            final NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                            LazyColumnKt.a(h16, null, null, null, null, null, null, null, null, null, null, 10, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -699153107, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$4.1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num2) {
                                    com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-699153107, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFansList.<anonymous>.<anonymous> (NBPFollowerList.kt:75)");
                                    }
                                    final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                                    LazyDslKt.c(aVar2, nBPFollowerViewModel3.fansList, null, ComposableLambdaKt.composableLambda(composer5, 220472823, true, new Function4<Integer, af, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.1.1
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public final Unit invoke(Integer num3, af afVar, Composer composer6, Integer num4) {
                                            int intValue3 = num3.intValue();
                                            af afVar2 = afVar;
                                            Composer composer7 = composer6;
                                            int intValue4 = num4.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(220472823, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFansList.<anonymous>.<anonymous>.<anonymous> (NBPFollowerList.kt:76)");
                                            }
                                            NBPFollowerListKt.NBPFollowUserView(NBPFollowerViewModel.this, true, intValue3, afVar2, composer7, ((intValue4 << 6) & 896) | 4152);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 2);
                                    final p b17 = FooterRefreshKt.b(composer5, 0);
                                    final NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                    FooterRefreshKt.a(b17, null, null, 300.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                            final p pVar = b17;
                                            TimerKt.d(10, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                    if (!nBPFollowerViewModel6.isFansListEnd && !nBPFollowerViewModel6.isRequesting) {
                                                        nBPFollowerViewModel6.isRequesting = true;
                                                        NBPFollowerViewModel.fetchFollowerPageData$default(nBPFollowerViewModel6, nBPFollowerViewModel6.appId, 1, false, false, false, nBPFollowerViewModel6.isSelf.getValue().booleanValue(), nBPFollowerViewModel6.accountId, nBPFollowerViewModel6.roundParamList, 260);
                                                    }
                                                    pVar.b(false);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }, ComposableSingletons$NBPFollowerListKt.f42lambda1, composer5, 1575936, 22);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 8, 48, MsgConstant.KRMFILETHUMBSIZE384, 4192254);
                            if (((Boolean) NBPFollowerViewModel.this.showFansUnfollowActionSheet$delegate.getValue()).booleanValue()) {
                                final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                                KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                        final NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                        QActionSheetKt.QActionSheet(viewContainer, new Function1<QActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QActionSheetView qActionSheetView) {
                                                final QActionSheetView qActionSheetView2 = qActionSheetView;
                                                final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                                qActionSheetView2.event(new Function1<QActionSheetEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QActionSheetEvent qActionSheetEvent) {
                                                        QActionSheetEvent qActionSheetEvent2 = qActionSheetEvent;
                                                        final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                        final QActionSheetView qActionSheetView3 = qActionSheetView2;
                                                        qActionSheetEvent2.onClickWithText(new Function1<ActionButtonParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.2.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ActionButtonParams actionButtonParams) {
                                                                if (actionButtonParams.index == 0) {
                                                                    NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                                                    nBPFollowerViewModel7.setFollowState(0, nBPFollowerViewModel7.unFollowAccount);
                                                                    qActionSheetView3.dismiss();
                                                                    NBPFollowerViewModel.this.setShowFansUnfollowActionSheet(false);
                                                                    final NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                                    CollectionsKt__MutableCollectionsKt.removeAll((List) nBPFollowerViewModel8.followingList, (Function1) new Function1<af, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.2.1.1.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Boolean invoke(af afVar) {
                                                                            return Boolean.valueOf(Intrinsics.areEqual(String.valueOf(afVar.f433207e), NBPFollowerViewModel.this.unFollowAccount));
                                                                        }
                                                                    });
                                                                    NBPFollowerViewModel nBPFollowerViewModel9 = NBPFollowerViewModel.this;
                                                                    nBPFollowerViewModel9.setTotalFollowingCount(nBPFollowerViewModel9.getTotalFollowingCount() - 1);
                                                                    NBPFollowerViewModel nBPFollowerViewModel10 = NBPFollowerViewModel.this;
                                                                    Iterator<af> it = nBPFollowerViewModel10.fansList.iterator();
                                                                    int i19 = 0;
                                                                    while (true) {
                                                                        if (!it.hasNext()) {
                                                                            i19 = -1;
                                                                            break;
                                                                        }
                                                                        if (Intrinsics.areEqual(String.valueOf(it.next().f433207e), nBPFollowerViewModel10.unFollowAccount)) {
                                                                            break;
                                                                        }
                                                                        i19++;
                                                                    }
                                                                    NBPFollowerViewModel.this.fansFollowStatusList.set(i19, 2);
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(false);
                                                                    NBPFollowerViewModel nBPFollowerViewModel11 = NBPFollowerViewModel.this;
                                                                    dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                                    dTPageParam.t("nearby_btn_type", 1);
                                                                    dTPageParam.v("cur_pg", nBPFollowerViewModel11.getDTPageParam(false));
                                                                    dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                                        qActionSheetEvent2.register("onBottomCancelClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.2.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPFollowerViewModel.this.setShowFansUnfollowActionSheet(false);
                                                                com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(false);
                                                                NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                                dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                                dTPageParam.t("nearby_btn_type", 0);
                                                                dTPageParam.v("cur_pg", nBPFollowerViewModel8.getDTPageParam(false));
                                                                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                        qActionSheetEvent2.register("onDismiss", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFansList.4.2.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPFollowerViewModel.this.setShowFansUnfollowActionSheet(false);
                                                                com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(false);
                                                                NBPFollowerViewModel nBPFollowerViewModel9 = NBPFollowerViewModel.this;
                                                                dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                                dTPageParam.t("nearby_btn_type", 0);
                                                                dTPageParam.v("cur_pg", nBPFollowerViewModel9.getDTPageParam(false));
                                                                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                qActionSheetView2.addButton("\u53d6\u6d88\u5173\u6ce8");
                                                qActionSheetView2.addCancelButton();
                                                qActionSheetView2.show();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }, composer3, 0, 3);
                            }
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1360357030);
                            if (NBPFollowerViewModel.this.isSelf.getValue().booleanValue()) {
                                composer3.startReplaceableGroup(-1360356969);
                                NBPFollowerEmptyStateViewKt.NBPSubjectiveFansEmptyState(composer3, 0);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(-1360356902);
                                NBPFollowerEmptyStateViewKt.NBPGuestFansEmptyState(composer3, 0);
                                composer3.endReplaceableGroup();
                            }
                            composer3.endReplaceableGroup();
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFansList$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerListKt.NBPFansList(NBPFollowerViewModel.this, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPFollowUserView(final NBPFollowerViewModel nBPFollowerViewModel, final boolean z16, final int i3, final af afVar, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-695354161);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-695354161, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowUserView (NBPFollowerList.kt:266)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 72), QUIToken.color$default("bg_middle_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowUserView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                String valueOf = String.valueOf(afVar.f433207e);
                nBPFollowerViewModel2.getClass();
                NBPJumpUtil.jumpPersonaPage$default(2, valueOf, false, false, null, null, 56);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -266218255, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowUserView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i17;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266218255, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowUserView.<anonymous> (NBPFollowerList.kt:276)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    float f16 = 16;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, f16), composer3, 8, 0);
                    com.tencent.ntcompose.core.i a16 = nVar2.a(ComposeLayoutPropUpdaterKt.B(companion), 1.0f);
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final af afVar2 = afVar;
                    final NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                    final boolean z17 = z16;
                    final int i18 = i3;
                    RowKt.a(a16, null, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, 1954873747, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowUserView$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1954873747, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowUserView.<anonymous>.<anonymous> (NBPFollowerList.kt:282)");
                                }
                                String str = af.this.E;
                                i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                com.tencent.ntcompose.core.i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion2, 52), uo3.c.b());
                                final NBPFollowerViewModel nBPFollowerViewModel3 = nBPFollowerViewModel2;
                                final boolean z18 = z17;
                                com.tencent.ntcompose.core.i g16 = ViewEventPropUpdaterKt.g(q16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowUserView.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NBPFollowerViewModel.this.dtReportElementImp("em_nearby_user_avatar", !z18);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFollowerViewModel nBPFollowerViewModel4 = nBPFollowerViewModel2;
                                final af afVar3 = af.this;
                                final boolean z19 = z17;
                                ImageKt.a(str, null, null, null, null, ViewEventPropUpdaterKt.d(g16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowUserView.2.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                        String valueOf = String.valueOf(afVar3.f433207e);
                                        nBPFollowerViewModel5.getClass();
                                        NBPJumpUtil.jumpPersonaPage$default(2, valueOf, false, false, null, null, 56);
                                        NBPFollowerViewModel.this.dtReportElementClick("em_nearby_user_avatar", !z19);
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12), composer5, 8, 0);
                                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 44.0f), 0.0f, 0.0f, 10.0f, 0.0f, 11, null);
                                Alignment alignment = Alignment.CenterStart;
                                final NBPFollowerViewModel nBPFollowerViewModel5 = nBPFollowerViewModel2;
                                final boolean z26 = z17;
                                final int i19 = i18;
                                final af afVar4 = af.this;
                                BoxKt.a(n3, alignment, null, ComposableLambdaKt.composableLambda(composer5, 1005029017, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowUserView.2.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer6, Integer num3) {
                                        int totalFollowingCount;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1005029017, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowUserView.<anonymous>.<anonymous>.<anonymous> (NBPFollowerList.kt:302)");
                                            }
                                            i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                            com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null);
                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                            final af afVar5 = afVar4;
                                            final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                            ColumnKt.a(j3, b16, null, null, ComposableLambdaKt.composableLambda(composer7, -924529904, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowUserView.2.1.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-924529904, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowUserView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPFollowerList.kt:306)");
                                                        }
                                                        i.Companion companion4 = com.tencent.ntcompose.core.i.INSTANCE;
                                                        com.tencent.ntcompose.core.i j16 = ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.s(companion4, 0.0f, 0.0f, 0.0f, 5, 7, null), 0.0f, 1, null);
                                                        String str2 = af.this.f433209f;
                                                        h color$default = QUIToken.color$default("text_primary");
                                                        c.Companion companion5 = bp3.c.INSTANCE;
                                                        TextKt.a(str2, j16, null, color$default, Float.valueOf(17.0f), null, companion5.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer9, 1601600, 100663296, 0, 133955492);
                                                        if (nBPFollowerViewModel6.formatUserTags(af.this).length() > 0) {
                                                            TextKt.a(nBPFollowerViewModel6.formatUserTags(af.this), ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion5.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer9, 1601600, 100663296, 0, 133955492);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 24648, 12);
                                            NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                            boolean z27 = z26;
                                            int i26 = i19;
                                            if (z27) {
                                                totalFollowingCount = nBPFollowerViewModel7.getTotalFansCount();
                                            } else {
                                                totalFollowingCount = nBPFollowerViewModel7.getTotalFollowingCount();
                                            }
                                            if (!(i26 == totalFollowingCount - 1)) {
                                                BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, ((com.tencent.ntcompose.ui.platform.a) composer7.consume(CompositionLocalsKt.d())).e() - 80), 0.5f), 0.0f, 70.0f, 0.0f, 0.0f, 13, null), QUIToken.color$default("border_standard")), null, null, null, composer7, 8, 14);
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
                    }), composer3, 197000, 26);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 8), composer3, 8, 0);
                    if (NBPFollowerViewModel.this.isSelf.getValue().booleanValue() && z16) {
                        composer3.startReplaceableGroup(1061274930);
                        NBPFollowerButtonViewKt.NBPFollowerButtonView(NBPFollowerViewModel.this, NBPFollowerViewModel.this.fansFollowStatusList.get(i3).intValue(), afVar, z16, composer3, ((i16 << 6) & 7168) | TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                        composer3.endReplaceableGroup();
                    } else if (NBPFollowerViewModel.this.isSelf.getValue().booleanValue() && !z16) {
                        composer3.startReplaceableGroup(1061275147);
                        NBPFollowerButtonViewKt.NBPFollowerButtonView(NBPFollowerViewModel.this, NBPFollowerViewModel.this.followingStatusList.get(i3).intValue(), afVar, z16, composer3, ((i16 << 6) & 7168) | TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1061275313);
                        composer3.endReplaceableGroup();
                    }
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, f16), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 197000, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowUserView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerListKt.NBPFollowUserView(NBPFollowerViewModel.this, z16, i3, afVar, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPFollowingList(final NBPFollowerViewModel nBPFollowerViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(-450539875);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if (i17 == 1 && (i18 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else if (i17 != 0) {
                NBPFollowerListKt$NBPFollowingList$1 nBPFollowerListKt$NBPFollowingList$1 = new Function1<b, NBPFollowerViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPFollowerViewModel invoke(b bVar2) {
                        return new NBPFollowerViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class), nBPFollowerListKt$NBPFollowingList$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    nBPFollowerViewModel = (NBPFollowerViewModel) c16;
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450539875, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowingList (NBPFollowerList.kt:157)");
            }
            BoxKt.a(ViewEventPropUpdaterKt.h(ViewEventPropUpdaterKt.g(ComposeLayoutPropUpdaterKt.n(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_middle_light")), 0.0f, 0.0f, 0.0f, 86.0f, 7, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    NBPFollowerViewModel.this.dtReportPageExposure(true, true);
                    return Unit.INSTANCE;
                }
            }), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    NBPFollowerViewModel.this.dtReportPageExposure(false, true);
                    return Unit.INSTANCE;
                }
            }), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1467092701, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$4
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1467092701, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowingList.<anonymous> (NBPFollowerList.kt:170)");
                        }
                        if (NBPFollowerViewModel.this.isEnterLoading.getValue().booleanValue()) {
                            composer3.startReplaceableGroup(-1540393012);
                            LoadingViewKt.LoadingView(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (NBPFollowerViewModel.this.getTotalFollowingCount() != 0 && !NBPFollowerViewModel.this.followingList.isEmpty()) {
                            composer3.startReplaceableGroup(-1540392679);
                            com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                            final NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                            LazyColumnKt.a(h16, null, null, null, null, null, null, null, null, null, null, 10, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -2115642814, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$4.1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num2) {
                                    com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2115642814, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowingList.<anonymous>.<anonymous> (NBPFollowerList.kt:185)");
                                    }
                                    final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                                    LazyDslKt.c(aVar2, nBPFollowerViewModel3.followingList, null, ComposableLambdaKt.composableLambda(composer5, 923035576, true, new Function4<Integer, af, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.1.1
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public final Unit invoke(Integer num3, af afVar, Composer composer6, Integer num4) {
                                            int intValue3 = num3.intValue();
                                            af afVar2 = afVar;
                                            Composer composer7 = composer6;
                                            int intValue4 = num4.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(923035576, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowingList.<anonymous>.<anonymous>.<anonymous> (NBPFollowerList.kt:186)");
                                            }
                                            NBPFollowerListKt.NBPFollowUserView(NBPFollowerViewModel.this, false, intValue3, afVar2, composer7, ((intValue4 << 6) & 896) | 4152);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 2);
                                    final p b17 = FooterRefreshKt.b(composer5, 0);
                                    final NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                    FooterRefreshKt.a(b17, null, null, 100.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                            final p pVar = b17;
                                            TimerKt.d(10, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                    if (!nBPFollowerViewModel6.isFollowingListEnd && !nBPFollowerViewModel6.isRequesting) {
                                                        nBPFollowerViewModel6.isRequesting = true;
                                                        NBPFollowerViewModel.fetchFollowerPageData$default(nBPFollowerViewModel6, nBPFollowerViewModel6.appId, 2, false, false, false, nBPFollowerViewModel6.isSelf.getValue().booleanValue(), nBPFollowerViewModel6.accountId, nBPFollowerViewModel6.roundParamList, 260);
                                                    }
                                                    pVar.b(false);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }, ComposableSingletons$NBPFollowerListKt.f43lambda2, composer5, 1575936, 22);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 8, 48, MsgConstant.KRMFILETHUMBSIZE384, 4192254);
                            if (((Boolean) NBPFollowerViewModel.this.showFollowingUnfollowActionSheet$delegate.getValue()).booleanValue()) {
                                final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                                KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                        final NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                        QActionSheetKt.QActionSheet(viewContainer, new Function1<QActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QActionSheetView qActionSheetView) {
                                                final QActionSheetView qActionSheetView2 = qActionSheetView;
                                                final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                                qActionSheetView2.event(new Function1<QActionSheetEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QActionSheetEvent qActionSheetEvent) {
                                                        QActionSheetEvent qActionSheetEvent2 = qActionSheetEvent;
                                                        final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                        final QActionSheetView qActionSheetView3 = qActionSheetView2;
                                                        qActionSheetEvent2.onClickWithText(new Function1<ActionButtonParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.2.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ActionButtonParams actionButtonParams) {
                                                                if (actionButtonParams.index == 0) {
                                                                    NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                                                    int i19 = 0;
                                                                    nBPFollowerViewModel7.setFollowState(0, nBPFollowerViewModel7.unFollowAccount);
                                                                    qActionSheetView3.dismiss();
                                                                    NBPFollowerViewModel.this.setShowFollowingUnfollowActionSheet(false);
                                                                    final NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                                    CollectionsKt__MutableCollectionsKt.removeAll((List) nBPFollowerViewModel8.followingList, (Function1) new Function1<af, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.2.1.1.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Boolean invoke(af afVar) {
                                                                            return Boolean.valueOf(Intrinsics.areEqual(String.valueOf(afVar.f433207e), NBPFollowerViewModel.this.unFollowAccount));
                                                                        }
                                                                    });
                                                                    NBPFollowerViewModel nBPFollowerViewModel9 = NBPFollowerViewModel.this;
                                                                    Iterator<af> it = nBPFollowerViewModel9.fansList.iterator();
                                                                    while (it.hasNext()) {
                                                                        af next = it.next();
                                                                        int i26 = i19 + 1;
                                                                        if (i19 < 0) {
                                                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                                        }
                                                                        if (Intrinsics.areEqual(String.valueOf(next.f433207e), nBPFollowerViewModel9.unFollowAccount)) {
                                                                            nBPFollowerViewModel9.fansFollowStatusList.set(i19, 2);
                                                                        }
                                                                        i19 = i26;
                                                                    }
                                                                    NBPFollowerViewModel nBPFollowerViewModel10 = NBPFollowerViewModel.this;
                                                                    nBPFollowerViewModel10.setTotalFollowingCount(nBPFollowerViewModel10.getTotalFollowingCount() - 1);
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(true);
                                                                    NBPFollowerViewModel nBPFollowerViewModel11 = NBPFollowerViewModel.this;
                                                                    dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                                    dTPageParam.t("nearby_btn_type", 1);
                                                                    dTPageParam.v("cur_pg", nBPFollowerViewModel11.getDTPageParam(true));
                                                                    dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                                        qActionSheetEvent2.register("onBottomCancelClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.2.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPFollowerViewModel.this.setShowFollowingUnfollowActionSheet(false);
                                                                com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(true);
                                                                NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                                dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                                dTPageParam.t("nearby_btn_type", 0);
                                                                dTPageParam.v("cur_pg", nBPFollowerViewModel8.getDTPageParam(true));
                                                                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                        qActionSheetEvent2.register("onDismiss", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt.NBPFollowingList.4.2.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPFollowerViewModel.this.setShowFollowingUnfollowActionSheet(false);
                                                                com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(true);
                                                                NBPFollowerViewModel nBPFollowerViewModel9 = NBPFollowerViewModel.this;
                                                                dTPageParam.v("dt_eid", "em_nearbby_focus_cancel_float");
                                                                dTPageParam.t("nearby_btn_type", 0);
                                                                dTPageParam.v("cur_pg", nBPFollowerViewModel9.getDTPageParam(true));
                                                                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                qActionSheetView2.addButton("\u53d6\u6d88\u5173\u6ce8");
                                                qActionSheetView2.addCancelButton();
                                                qActionSheetView2.show();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }, composer3, 0, 3);
                            }
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1540392890);
                            if (NBPFollowerViewModel.this.isSelf.getValue().booleanValue()) {
                                composer3.startReplaceableGroup(-1540392829);
                                NBPFollowerEmptyStateViewKt.NBPSubjectiveFollowersEmptyState(composer3, 0);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(-1540392757);
                                NBPFollowerEmptyStateViewKt.NBPGuestFollowersEmptyState(composer3, 0);
                                composer3.endReplaceableGroup();
                            }
                            composer3.endReplaceableGroup();
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerListKt$NBPFollowingList$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerListKt.NBPFollowingList(NBPFollowerViewModel.this, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
