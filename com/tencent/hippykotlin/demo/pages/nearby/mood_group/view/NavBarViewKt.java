package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupPageState;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import w25.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NavBarViewKt {
    public static final void NavBarView(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        final NBPMoodGroupConfig.IndicatorConfig indicatorConfig;
        Composer startRestartGroup = composer.startRestartGroup(345241055);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(345241055, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarView (NavBarView.kt:54)");
        }
        NBPMoodGroupConfig nBPMoodGroupConfig = nBPMoodGroupViewModel.config;
        if (nBPMoodGroupConfig != null && (indicatorConfig = nBPMoodGroupConfig.indicatorConfig) != null) {
            RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), 0.0f, ((a) startRestartGroup.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1554880765, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(1554880765, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarView.<anonymous> (NavBarView.kt:65)");
                        }
                        i.Companion companion = i.INSTANCE;
                        i j3 = ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 36.0f), 36.0f), new h(3439329279L)), 18.0f);
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                        i L = ModifiersKt.L(ViewEventPropUpdaterKt.d(j3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.closePage$default();
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_close", null);
                                return Unit.INSTANCE;
                            }
                        }, 3, null), 0.0f, 2.0f, 16.0f, new h(335544320L));
                        Alignment alignment = Alignment.Center;
                        BoxKt.a(L, alignment, null, ComposableSingletons$NavBarViewKt.f68lambda1, composer3, 3128, 4);
                        i L2 = ModifiersKt.L(ModifiersKt.D(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(companion, 44.0f)), 24.0f), 8.0f, 0.0f, 8.0f, 0.0f, 10, null), new h(3439329279L)), AnimateAsStateKt.c(!NBPMoodGroupViewModel.this.getResultVM().getEnterAnimPlayed() ? 1.0f : 0.0f, b.d(320, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4).getValue().floatValue()), 0.0f, 2.0f, 16.0f, new h(335544320L));
                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                        final NBPMoodGroupConfig.IndicatorConfig indicatorConfig2 = indicatorConfig;
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                        RowKt.a(L2, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -340625509, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(-340625509, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarView.<anonymous>.<anonymous> (NavBarView.kt:107)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    ImageKt.a(NBPMoodGroupConfig.IndicatorConfig.this.moodIcon.src, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, NBPMoodGroupConfig.IndicatorConfig.this.moodIcon.width), NBPMoodGroupConfig.IndicatorConfig.this.moodIcon.height), 0.0f, 0.0f, 2.67f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                    i A = ComposeLayoutPropUpdaterKt.A(companion2);
                                    final NBPMoodGroupConfig.IndicatorConfig indicatorConfig3 = NBPMoodGroupConfig.IndicatorConfig.this;
                                    final NBPMoodGroupViewModel nBPMoodGroupViewModel4 = nBPMoodGroupViewModel3;
                                    ColumnKt.a(A, null, null, null, ComposableLambdaKt.composableLambda(composer5, 718897732, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt.NavBarView.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(718897732, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarView.<anonymous>.<anonymous>.<anonymous> (NavBarView.kt:115)");
                                                }
                                                TextKt.a(NBPMoodGroupConfig.IndicatorConfig.this.moodTitle, ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 0.0f, 2.0f, 7, null), null, new h(4279901214L), Float.valueOf(14.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601600, 0, 0, 134217636);
                                                TextKt.a((((Number) nBPMoodGroupViewModel4.groupDistance$delegate.getValue()).intValue() / 1000) + "km\u8303\u56f4\u5185\uff5c" + ((Number) nBPMoodGroupViewModel4.groupUserNum$delegate.getValue()).intValue() + '\u4eba', null, null, new h(4287664276L), Float.valueOf(10.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 28672, 0, 0, 134217702);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 24584, 14);
                                    if (nBPMoodGroupViewModel3.getHostMood() == null && nBPMoodGroupViewModel3.getPageState() == NBPMoodGroupPageState.SUCCESS) {
                                        composer5.startReplaceableGroup(-221134484);
                                        i s16 = ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(companion2, 27.0f)), NBPMoodGroupConfig.IndicatorConfig.this.joinButtonBgColor), 13.5f), 8.0f, 0.0f, 8.0f, 0.0f, 10, null);
                                        final NBPMoodGroupViewModel nBPMoodGroupViewModel5 = nBPMoodGroupViewModel3;
                                        i l3 = ViewEventPropUpdaterKt.l(s16, new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt.NavBarView.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap3.a aVar) {
                                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementImp("em_nearby_join", null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMoodGroupViewModel nBPMoodGroupViewModel6 = nBPMoodGroupViewModel3;
                                        i d16 = ViewEventPropUpdaterKt.d(l3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt.NavBarView.1.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_join", null);
                                                NBPMoodGroupViewModel.this.onJoinMoodGroup();
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null);
                                        Alignment alignment2 = Alignment.Center;
                                        final NBPMoodGroupConfig.IndicatorConfig indicatorConfig4 = NBPMoodGroupConfig.IndicatorConfig.this;
                                        BoxKt.a(d16, alignment2, null, ComposableLambdaKt.composableLambda(composer5, 837695194, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt.NavBarView.1.2.4
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(837695194, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarView.<anonymous>.<anonymous>.<anonymous> (NavBarView.kt:145)");
                                                    }
                                                    NBPMoodGroupConfig.IndicatorConfig indicatorConfig5 = NBPMoodGroupConfig.IndicatorConfig.this;
                                                    TextKt.a(indicatorConfig5.joinButtonText, null, null, indicatorConfig5.joinButtonTextColor, Float.valueOf(12.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 28672, 0, 0, 134217702);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3128, 4);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(-221133596);
                                        BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 8.0f), 1.0f), null, null, null, composer5, 8, 14);
                                        composer5.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 26);
                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 36.0f), 36.0f);
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel4 = NBPMoodGroupViewModel.this;
                        i d16 = ViewEventPropUpdaterKt.d(k3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                byte[] encodeToByteArray;
                                NBPMoodGroupViewModel nBPMoodGroupViewModel5 = NBPMoodGroupViewModel.this;
                                nBPMoodGroupViewModel5.getClass();
                                QQNearbyModule.Companion companion2 = QQNearbyModule.Companion;
                                QQNearbyModule companion3 = companion2.getInstance();
                                g hostMood = nBPMoodGroupViewModel5.getHostMood();
                                if (hostMood == null) {
                                    hostMood = new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null);
                                }
                                String str = nBPMoodGroupViewModel5.configStrData;
                                companion3.getClass();
                                KLog kLog = KLog.INSTANCE;
                                NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("openMoodMapShare moodName:");
                                p25.a aVar = hostMood.f444489e;
                                final Function1 function1 = null;
                                m3.append(aVar != null ? aVar.C : null);
                                m3.append("  from:");
                                final boolean z16 = false;
                                m3.append(0);
                                kLog.i("feed_detail_page", m3.toString());
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("jumpMoodMapSharePage: mapTheme=");
                                p25.a aVar2 = hostMood.f444489e;
                                m16.append(aVar2 != null ? aVar2.C : null);
                                kLog.i("NBPJumpUtil", m16.toString());
                                Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil$jumpMoodMapSharePage$1
                                    public final /* synthetic */ int $source = 0;

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        boolean booleanValue = bool.booleanValue();
                                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("jumpMoodMapSharePage: success=", booleanValue, KLog.INSTANCE, "NBPJumpUtil");
                                        if (booleanValue) {
                                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=2&share_type=2&custom_back_pressed=1&modal_mode=1&nbp_source=");
                                            m17.append(this.$source);
                                            String sb5 = m17.toString();
                                            QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default(sb5, z16, 4);
                                            Function1<Boolean, Unit> function13 = function1;
                                            if (function13 != null) {
                                                function13.invoke(Boolean.TRUE);
                                            }
                                        } else {
                                            Function1<Boolean, Unit> function14 = function1;
                                            if (function14 != null) {
                                                function14.invoke(Boolean.FALSE);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }
                                };
                                byte[] d17 = c45.i.d(hostMood);
                                encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(String.valueOf(str));
                                companion2.getInstance().setSharePenetratePageData(new byte[][]{d17, encodeToByteArray});
                                function12.invoke(Boolean.TRUE);
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_share_btn", null);
                                return Unit.INSTANCE;
                            }
                        }, 3, null);
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel5 = NBPMoodGroupViewModel.this;
                        BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 986741536, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$1.4
                            {
                                super(3);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                                int i16;
                                com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i16 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i16 = intValue2;
                                }
                                if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(986741536, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarView.<anonymous>.<anonymous> (NavBarView.kt:165)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    BoxKt.a(ModifiersKt.L(ModifiersKt.j(ModifiersKt.c(bVar2.b(companion2), new h(3439329279L)), 18.0f), 0.0f, 2.0f, 16.0f, new h(335544320L)), null, null, null, composer5, 8, 14);
                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_r6bxzvu1-f-.png", null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 20.0f), 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, new h(4281282611L), null, composer5, 262150, 1073741824, 0, 1572830);
                                    if (((Boolean) NBPMoodGroupViewModel.this.isFirstTime$delegate.getValue()).booleanValue()) {
                                        CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("first_time_enter_mood_map_");
                                        m3.append(UserDataManager.INSTANCE.getUserSelfInfo().tid);
                                        cacheModule.setInt(m3.toString(), 1);
                                        final NBPMoodGroupViewModel nBPMoodGroupViewModel6 = NBPMoodGroupViewModel.this;
                                        TimerKt.d(5000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt.NavBarView.1.4.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPMoodGroupViewModel.this.isFirstTime$delegate.setValue(Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        BoxKt.a(ModifiersKt.E(ComposeLayoutPropUpdaterKt.o(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 11.0f), 11.0f), 0.0f, 27.0f), true), null, null, ComposableSingletons$NavBarViewKt.f69lambda2, composer5, 3080, 6);
                                        i j16 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.o(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 126.0f), 36.0f), QUIToken.color$default("bg_top_dark")), -40.0f, 50.0f), 4.0f);
                                        final NBPMoodGroupViewModel nBPMoodGroupViewModel7 = NBPMoodGroupViewModel.this;
                                        BoxKt.a(ViewEventPropUpdaterKt.g(j16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt.NavBarView.1.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementImp("em_nearby_share_guide_pop", null);
                                                return Unit.INSTANCE;
                                            }
                                        }), null, null, ComposableSingletons$NavBarViewKt.f70lambda3, composer5, 3080, 6);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    NavBarViewKt.NavBarView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.NavBarViewKt$NavBarView$cfg$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NavBarViewKt.NavBarView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
