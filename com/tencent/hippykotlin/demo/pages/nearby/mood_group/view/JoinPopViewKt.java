package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.ImageConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BackgroundInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.random.Random;

/* loaded from: classes31.dex */
public final class JoinPopViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void JoinPopView(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        final NBPMoodGroupConfig.JoinPropConfig joinPropConfig;
        h hVar;
        Composer startRestartGroup = composer.startRestartGroup(-2012107085);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012107085, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView (JoinPopView.kt:54)");
        }
        startRestartGroup.startReplaceableGroup(-717653607);
        if (((Boolean) nBPMoodGroupViewModel.getResultVM().showThemeMapGuide$delegate.getValue()).booleanValue()) {
            final BackgroundInfo bgInfo = nBPMoodGroupViewModel.getBgInfo();
            if (bgInfo == null) {
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$renderInfo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        JoinPopViewKt.JoinPopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            final ImageConfig imageConfig = bgInfo.config.mainBuilding;
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1442711886, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    int i16;
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i16 = intValue;
                    }
                    if ((i16 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1442711886, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous> (JoinPopView.kt:63)");
                        }
                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 48.0f);
                        Alignment alignment = Alignment.TopEnd;
                        i n3 = ComposeLayoutPropUpdaterKt.n(bVar2.a(k3, alignment), 0.0f, 150.0f, 0.0f, 0.0f, 13, null);
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                        i g16 = ViewEventPropUpdaterKt.g(n3, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementImp("em_nearby_guide_bubble", null);
                                final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                                TimerKt.d(10000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.1.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPMoodGroupViewModel.this.getResultVM().setShowThemeMapGuide(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ImageConfig imageConfig2 = imageConfig;
                        final BackgroundInfo backgroundInfo = bgInfo;
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                        BoxKt.a(g16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 197965292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(197965292, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous>.<anonymous> (JoinPopView.kt:75)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Mg_nWo80qOl.png", null, null, null, null, ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.v(companion, 144.0f, 68.0f), ((-ImageConfig.this.width) * backgroundInfo.scale) + 70.0f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("bg_top_light"), null, composer5, 262150, 1073741824, 0, 1572830);
                                    i p16 = ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.v(companion, 144.0f, 48.0f), ((-ImageConfig.this.width) * backgroundInfo.scale) + 70.0f, 0.0f, 2, null);
                                    final NBPMoodGroupViewModel nBPMoodGroupViewModel4 = nBPMoodGroupViewModel3;
                                    i s16 = ComposeLayoutPropUpdaterKt.s(ViewEventPropUpdaterKt.d(p16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            NBPMoodGroupViewModel.this.getResultVM().setShowThemeMapGuide(false);
                                            NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_guide_bubble", null);
                                            NBPJumpUtil.jumpSquareFeedList$default(null, null, null, "6", false, NBPMoodGroupViewModel.this.getResultVM().themeId, null, null, 208);
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), 0.0f, 3.0f, 0.0f, 0.0f, 13, null);
                                    a.e b16 = a.f339245a.b();
                                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                    final NBPMoodGroupViewModel nBPMoodGroupViewModel5 = nBPMoodGroupViewModel3;
                                    RowKt.a(s16, b16, c16, null, null, ComposableLambdaKt.composableLambda(composer5, 93614858, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.1.2.2
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
                                                    ComposerKt.traceEventStart(93614858, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous>.<anonymous>.<anonymous> (JoinPopView.kt:96)");
                                                }
                                                int nextInt = Random.INSTANCE.nextInt(NBPMoodGroupViewModel.this.getResultVM().guidePicture.size());
                                                i.Companion companion2 = i.INSTANCE;
                                                ImageKt.a(NBPMoodGroupViewModel.this.getResultVM().guidePicture.get(nextInt), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion2, 32.0f, 32.0f), 0.0f, 0.0f, 6.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 76.0f), 32.0f);
                                                String str = NBPMoodGroupViewModel.this.getResultVM().guideText;
                                                int a16 = ai.INSTANCE.a();
                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                TextKt.a(str, k16, null, QUIToken.color$default("text_primary"), Float.valueOf(12.0f), null, c.INSTANCE.f(), null, null, null, ai.f(a16), null, null, null, null, null, null, null, 2, null, null, null, null, null, null, null, false, composer7, 1601600, 100663296, 0, 133954468);
                                                ImageKt.a(qUIToken.image("arrow_right", QUIToken.color$default("icon_primary")), null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion2, 12.0f, 12.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 196680, 24);
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
            }), startRestartGroup, 3080, 6);
        }
        startRestartGroup.endReplaceableGroup();
        if (!((Boolean) nBPMoodGroupViewModel.showJoinPop$delegate.getValue()).booleanValue()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    JoinPopViewKt.JoinPopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        NBPMoodGroupConfig nBPMoodGroupConfig = nBPMoodGroupViewModel.config;
        if (nBPMoodGroupConfig != null && (joinPropConfig = nBPMoodGroupConfig.joinPropConfig) != null) {
            final float e16 = ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e();
            final float f16 = e16 - (joinPropConfig.imagePadding * 2);
            ImageConfig imageConfig2 = joinPropConfig.image;
            float f17 = imageConfig2 != null ? (imageConfig2.height / imageConfig2.width) * f16 : 0.54473686f * f16;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            float f18 = f17 + 210.0f;
            if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                hVar = new h(39423L, 1.0f);
            } else {
                hVar = new h(26282L, 0.3f);
            }
            final State<h> a16 = AnimateAsStateKt.a(hVar, com.tencent.ntcompose.animation.b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), null, startRestartGroup, 8, 4);
            i g16 = ViewEventPropUpdaterKt.g(ModifiersKt.T(i.INSTANCE, 3), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    NBPMoodGroupReportViewModel reportVM = NBPMoodGroupViewModel.this.getReportVM();
                    e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_click_area", 0);
                    Unit unit = Unit.INSTANCE;
                    reportVM.dtReportElementImp("em_nearby_join_float", m3);
                    return Unit.INSTANCE;
                }
            });
            Boolean valueOf = Boolean.valueOf(((Boolean) mutableState.getValue()).booleanValue());
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Boolean bool) {
                        mutableState.setValue(Boolean.valueOf(bool.booleanValue()));
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            final float f19 = f17;
            NBPHalfScreenModalKt.NBPHalfScreenModal(g16, f18, valueOf, (Function1) rememberedValue3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPMoodGroupViewModel.this.showJoinPop$delegate.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            }, ComposableLambdaKt.composableLambda(startRestartGroup, 1263328527, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1263328527, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous> (JoinPopView.kt:162)");
                        }
                        i M = ModifiersKt.M(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), true);
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                        i d16 = ViewEventPropUpdaterKt.d(M, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPMoodGroupReportViewModel reportVM = NBPMoodGroupViewModel.this.getReportVM();
                                e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_click_area", 0);
                                Unit unit = Unit.INSTANCE;
                                reportVM.dtReportElementClick("em_nearby_join_float", m3);
                                return Unit.INSTANCE;
                            }
                        }, 3, null);
                        Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                        a.e b17 = a.f339245a.b();
                        final NBPMoodGroupConfig.JoinPropConfig joinPropConfig2 = joinPropConfig;
                        final float f26 = e16;
                        final float f27 = f16;
                        final float f28 = f19;
                        final State<h> state = a16;
                        final MutableState<Boolean> mutableState3 = mutableState2;
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                        final MutableState<Boolean> mutableState4 = mutableState;
                        ColumnKt.a(d16, b17, b16, null, ComposableLambdaKt.composableLambda(composer3, 2027896440, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$6.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                int i16;
                                String str;
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
                                        ComposerKt.traceEventStart(2027896440, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous>.<anonymous> (JoinPopView.kt:180)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    BoxKt.a(ModifiersKt.a(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion2, 40.0f, 4.0f), 0.0f, 14.0f, 0.0f, 14.0f, 5, null), new h(4291611852L)), 2.0f), "\u4e0b\u62c9\u5173\u95ed"), null, null, null, composer5, 8, 14);
                                    String str2 = NBPMoodGroupConfig.JoinPropConfig.this.title;
                                    h hVar2 = new h(4279901214L);
                                    int b18 = an.INSTANCE.b();
                                    int a17 = ai.INSTANCE.a();
                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f26 - 20.0f), 40.0f), 0.0f, 12.0f, 0.0f, 0.0f, 13, null);
                                    Alignment.Companion companion3 = Alignment.INSTANCE;
                                    TextKt.a(str2, dVar2.b(n3, companion3.b()), null, hVar2, Float.valueOf(17.0f), null, null, null, null, null, ai.f(a17), Float.valueOf(40.0f), null, null, null, null, an.d(b18), null, 1, null, null, null, null, null, null, null, false, composer5, 28736, 102236208, 0, 133886948);
                                    ImageConfig imageConfig3 = NBPMoodGroupConfig.JoinPropConfig.this.image;
                                    if (imageConfig3 == null || (str = imageConfig3.src) == null) {
                                        str = "";
                                    }
                                    ImageKt.a(null, null, null, null, null, dVar2.b(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f27), f28), 0.0f, 12.0f, 0.0f, 0.0f, 13, null), companion3.b()), null, 0, null, null, str, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                    AnonymousClass1 anonymousClass1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    i c16 = ModifiersKt.c(dVar2.b(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.n(companion2, 0.0f, 34.0f, 0.0f, 0.0f, 13, null), 168.0f), 45.0f), 4.0f), companion3.b()), new h(39423L, 1.0f));
                                    final State<h> state2 = state;
                                    final NBPMoodGroupConfig.JoinPropConfig joinPropConfig3 = NBPMoodGroupConfig.JoinPropConfig.this;
                                    final MutableState<Boolean> mutableState5 = mutableState3;
                                    final NBPMoodGroupViewModel nBPMoodGroupViewModel4 = nBPMoodGroupViewModel3;
                                    final MutableState<Boolean> mutableState6 = mutableState4;
                                    ButtonKt.a(null, anonymousClass1, c16, null, ComposableLambdaKt.composableLambda(composer5, -770102803, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                    ComposerKt.traceEventStart(-770102803, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous>.<anonymous>.<anonymous> (JoinPopView.kt:224)");
                                                }
                                                i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), state2.getValue());
                                                Alignment alignment = Alignment.Center;
                                                final NBPMoodGroupConfig.JoinPropConfig joinPropConfig4 = joinPropConfig3;
                                                final MutableState<Boolean> mutableState7 = mutableState5;
                                                final NBPMoodGroupViewModel nBPMoodGroupViewModel5 = nBPMoodGroupViewModel4;
                                                final MutableState<Boolean> mutableState8 = mutableState6;
                                                BoxKt.a(c17, alignment, null, ComposableLambdaKt.composableLambda(composer7, 202476019, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(202476019, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (JoinPopView.kt:229)");
                                                            }
                                                            TextKt.a(NBPMoodGroupConfig.JoinPropConfig.this.btnText, null, null, h.INSTANCE.n(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 4096, 0, 0, 134217718);
                                                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                            final MutableState<Boolean> mutableState9 = mutableState7;
                                                            final NBPMoodGroupViewModel nBPMoodGroupViewModel6 = nBPMoodGroupViewModel5;
                                                            final MutableState<Boolean> mutableState10 = mutableState8;
                                                            KuiklyKt.a(null, h16, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                                                    final MutableState<Boolean> mutableState11 = mutableState9;
                                                                    final NBPMoodGroupViewModel nBPMoodGroupViewModel7 = nBPMoodGroupViewModel6;
                                                                    final MutableState<Boolean> mutableState12 = mutableState10;
                                                                    w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1.1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar) {
                                                                            v vVar2 = vVar;
                                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1.1.1.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    tVar.m140flex(1.0f);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final MutableState<Boolean> mutableState13 = mutableState11;
                                                                            final NBPMoodGroupViewModel nBPMoodGroupViewModel8 = nBPMoodGroupViewModel7;
                                                                            final MutableState<Boolean> mutableState14 = mutableState12;
                                                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1.1.1.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(u uVar) {
                                                                                    u uVar2 = uVar;
                                                                                    final MutableState<Boolean> mutableState15 = mutableState13;
                                                                                    uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1.1.1.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(TouchParams touchParams) {
                                                                                            mutableState15.setValue(Boolean.TRUE);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    final NBPMoodGroupViewModel nBPMoodGroupViewModel9 = nBPMoodGroupViewModel8;
                                                                                    final MutableState<Boolean> mutableState16 = mutableState13;
                                                                                    final MutableState<Boolean> mutableState17 = mutableState14;
                                                                                    uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt.JoinPopView.6.2.2.1.1.1.2.2
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(TouchParams touchParams) {
                                                                                            NBPMoodGroupViewModel.this.onJoinMoodGroup();
                                                                                            MutableState<Boolean> mutableState18 = mutableState16;
                                                                                            Boolean bool = Boolean.FALSE;
                                                                                            mutableState18.setValue(bool);
                                                                                            mutableState17.setValue(bool);
                                                                                            NBPMoodGroupReportViewModel reportVM = NBPMoodGroupViewModel.this.getReportVM();
                                                                                            e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_click_area", 1);
                                                                                            Unit unit = Unit.INSTANCE;
                                                                                            reportVM.dtReportElementClick("em_nearby_join_float", m3);
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
                                                            }, composer9, 64, 1);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3128, 4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 25136, 9);
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
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196616, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
            if (endRestartGroup3 == null) {
                return;
            }
            endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    JoinPopViewKt.JoinPopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup4 = startRestartGroup.endRestartGroup();
        if (endRestartGroup4 == null) {
            return;
        }
        endRestartGroup4.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.JoinPopViewKt$JoinPopView$config$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                JoinPopViewKt.JoinPopView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
