package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.SharePanelState;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.PagerListKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import e25.i;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFlowerCardListViewKt {
    public static final void LoveWallFlowerCardListView(final LoveWallHomepageViewModel loveWallHomepageViewModel, final List<i> list, final long j3, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1316784255);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1316784255, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView (LoveWallFlowerCardListView.kt:39)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -65856063, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$LoveWallFlowerCardListView$1
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
                        ComposerKt.traceEventStart(-65856063, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous> (LoveWallFlowerCardListView.kt:45)");
                    }
                    com.tencent.ntcompose.core.i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), new h(0, 0, 0, 0.5f));
                    Alignment alignment = Alignment.Center;
                    final Function0<Unit> function02 = function0;
                    final int i16 = i3;
                    final List<i> list2 = list;
                    final long j16 = j3;
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = loveWallHomepageViewModel;
                    BoxKt.a(c16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -2145699129, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$LoveWallFlowerCardListView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2145699129, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous>.<anonymous> (LoveWallFlowerCardListView.kt:49)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                final Function0<Unit> function03 = function02;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function03);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$LoveWallFlowerCardListView$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function03.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                BoxKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), null, null, null, composer5, 8, 14);
                                ColumnKt.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), a.f339245a.b(), Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(composer5, -1722803394, true, new Function3<d, Composer, Integer, Unit>(list2, function02, i16, j16, loveWallHomepageViewModel2) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2
                                    public final /* synthetic */ long $defaultFlowerId;
                                    public final /* synthetic */ List<e25.i> $flowerList;
                                    public final /* synthetic */ LoveWallHomepageViewModel $homepageViewModel;
                                    public final /* synthetic */ Function0<Unit> $removeFun;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                        this.$defaultFlowerId = r4;
                                        this.$homepageViewModel = r6;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1722803394, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardListView.kt:57)");
                                            }
                                            List<e25.i> list3 = this.$flowerList;
                                            long j17 = this.$defaultFlowerId;
                                            composer7.startReplaceableGroup(-492369756);
                                            Object rememberedValue2 = composer7.rememberedValue();
                                            Composer.Companion companion2 = Composer.INSTANCE;
                                            if (rememberedValue2 == companion2.getEmpty()) {
                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallFlowerCardListViewModel(list3, j17), null, 2, null);
                                                composer7.updateRememberedValue(rememberedValue2);
                                            }
                                            composer7.endReplaceableGroup();
                                            MutableState mutableState = (MutableState) rememberedValue2;
                                            composer7.startReplaceableGroup(-492369756);
                                            Object rememberedValue3 = composer7.rememberedValue();
                                            if (rememberedValue3 == companion2.getEmpty()) {
                                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(((LoveWallFlowerCardListViewModel) mutableState.getValue()).getDefaultFlowerIndex()), null, 2, null);
                                                composer7.updateRememberedValue(rememberedValue3);
                                            }
                                            composer7.endReplaceableGroup();
                                            final MutableState mutableState2 = (MutableState) rememberedValue3;
                                            i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                            com.tencent.ntcompose.core.i r16 = ModifiersKt.r(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 480), false);
                                            Float valueOf = Float.valueOf(com.tencent.ntcompose.activity.b.a().getPageData().m());
                                            int defaultFlowerIndex = ((LoveWallFlowerCardListViewModel) mutableState.getValue()).getDefaultFlowerIndex();
                                            Boolean bool = Boolean.FALSE;
                                            composer7.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer7.changed(mutableState2);
                                            Object rememberedValue4 = composer7.rememberedValue();
                                            if (changed2 || rememberedValue4 == companion2.getEmpty()) {
                                                rememberedValue4 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$LoveWallFlowerCardListView$1$1$2$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Integer num4) {
                                                        mutableState2.setValue(Integer.valueOf(num4.intValue()));
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer7.updateRememberedValue(rememberedValue4);
                                            }
                                            composer7.endReplaceableGroup();
                                            Function1 function1 = (Function1) rememberedValue4;
                                            final List<e25.i> list4 = this.$flowerList;
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel3 = this.$homepageViewModel;
                                            final Function0<Unit> function04 = this.$removeFun;
                                            PagerListKt.a(r16, null, null, valueOf, defaultFlowerIndex, null, null, null, bool, null, null, 0, null, null, null, 0.0f, function1, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1905920469, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1905920469, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardListView.kt:70)");
                                                    }
                                                    for (final e25.i iVar : list4) {
                                                        com.tencent.ntcompose.core.i h17 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                                        final LoveWallHomepageViewModel loveWallHomepageViewModel4 = loveWallHomepageViewModel3;
                                                        final Function0<Unit> function05 = function04;
                                                        BoxKt.a(h17, null, null, ComposableLambdaKt.composableLambda(composer9, -2119024621, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(b bVar2, Composer composer10, Integer num5) {
                                                                Composer composer11 = composer10;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-2119024621, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardListView.kt:72)");
                                                                    }
                                                                    if (e25.i.this.f395478d == 1) {
                                                                        composer11.startReplaceableGroup(-758533351);
                                                                        com.tencent.ntcompose.core.i h18 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                                                        final e25.i iVar2 = e25.i.this;
                                                                        final LoveWallHomepageViewModel loveWallHomepageViewModel5 = loveWallHomepageViewModel4;
                                                                        final Function0<Unit> function06 = function05;
                                                                        BoxKt.a(h18, null, null, ComposableLambdaKt.composableLambda(composer11, -157610828, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2.2.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(b bVar3, Composer composer12, Integer num6) {
                                                                                int i17;
                                                                                String str;
                                                                                b bVar4 = bVar3;
                                                                                Composer composer13 = composer12;
                                                                                int intValue6 = num6.intValue();
                                                                                if ((intValue6 & 14) == 0) {
                                                                                    i17 = (composer13.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                } else {
                                                                                    i17 = intValue6;
                                                                                }
                                                                                if ((i17 & 91) == 18 && composer13.getSkipping()) {
                                                                                    composer13.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-157610828, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardListView.kt:75)");
                                                                                    }
                                                                                    com.tencent.ntcompose.core.i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 292, 444), Alignment.Center);
                                                                                    final e25.i iVar3 = e25.i.this;
                                                                                    e25.b bVar5 = iVar3.F;
                                                                                    if (bVar5 == null || (str = bVar5.f395469e) == null) {
                                                                                        str = "\u5206\u4eab\u82b1\u8bed";
                                                                                    }
                                                                                    LoveSproutCardConfig loveSproutCardConfig = new LoveSproutCardConfig(iVar3, str, (String) null, 0.0f, 0.0f, 60);
                                                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel6 = loveWallHomepageViewModel5;
                                                                                    final Function0<Unit> function07 = function06;
                                                                                    LoveSproutCardViewKt.LoveSproutCardView(a16, loveSproutCardConfig, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2.2.1.1.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Unit invoke() {
                                                                                            LoveWallHomepageViewModel.this.shareFlower.setValue(iVar3);
                                                                                            LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.SHARE_FLOWER);
                                                                                            function07.invoke();
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }, composer13, 8, 0);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer11, 3080, 6);
                                                                        composer11.endReplaceableGroup();
                                                                    } else {
                                                                        composer11.startReplaceableGroup(-758532326);
                                                                        com.tencent.ntcompose.core.i h19 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                                                        final e25.i iVar3 = e25.i.this;
                                                                        final LoveWallHomepageViewModel loveWallHomepageViewModel6 = loveWallHomepageViewModel4;
                                                                        final Function0<Unit> function07 = function05;
                                                                        BoxKt.a(h19, null, null, ComposableLambdaKt.composableLambda(composer11, -1997368259, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2.2.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(b bVar3, Composer composer12, Integer num6) {
                                                                                int i17;
                                                                                b bVar4 = bVar3;
                                                                                Composer composer13 = composer12;
                                                                                int intValue6 = num6.intValue();
                                                                                if ((intValue6 & 14) == 0) {
                                                                                    i17 = (composer13.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                } else {
                                                                                    i17 = intValue6;
                                                                                }
                                                                                if ((i17 & 91) == 18 && composer13.getSkipping()) {
                                                                                    composer13.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-1997368259, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerCardListView.kt:92)");
                                                                                    }
                                                                                    com.tencent.ntcompose.core.i a16 = bVar4.a(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 292, u.CTRL_INDEX), Alignment.Center);
                                                                                    final e25.i iVar4 = e25.i.this;
                                                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel7 = loveWallHomepageViewModel6;
                                                                                    final Function0<Unit> function08 = function07;
                                                                                    LoveFlowerCardViewKt.LoveFlowerCardView(a16, iVar4, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView.1.1.2.2.1.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Unit invoke() {
                                                                                            LoveWallHomepageViewModel.this.shareFlower.setValue(iVar4);
                                                                                            LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.SHARE_FLOWER);
                                                                                            function08.invoke();
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }, composer13, 72, 4);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer11, 3080, 6);
                                                                        composer11.endReplaceableGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer9, 3080, 6);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 100663304, 0, 3072, 8322790);
                                            float f16 = 38;
                                            if (com.tencent.ntcompose.activity.b.a().getPageData().l() < 592.0f) {
                                                f16 = 10;
                                            }
                                            float f17 = f16;
                                            LoveWallFlowerCardListViewKt.FlowerCardListIndicatorView(ComposeLayoutPropUpdaterKt.n(companion3, 0.0f, f17, 0.0f, 0.0f, 13, null), ((Number) mutableState2.getValue()).intValue(), this.$flowerList.size(), composer7, 8);
                                            com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion3, 32.0f), 0.0f, f17, 0.0f, 0.0f, 13, null);
                                            final Function0<Unit> function05 = this.$removeFun;
                                            composer7.startReplaceableGroup(1157296644);
                                            boolean changed3 = composer7.changed(function05);
                                            Object rememberedValue5 = composer7.rememberedValue();
                                            if (changed3 || rememberedValue5 == companion2.getEmpty()) {
                                                rememberedValue5 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$LoveWallFlowerCardListView$1$1$2$3$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        function05.invoke();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer7.updateRememberedValue(rememberedValue5);
                                            }
                                            composer7.endReplaceableGroup();
                                            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue5, 3, null), null, 0, null, null, QUIToken.INSTANCE.image("close_circle", QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2096095);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 25032, 8);
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
        }), startRestartGroup, 24624, 13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$LoveWallFlowerCardListView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerCardListViewKt.LoveWallFlowerCardListView(LoveWallHomepageViewModel.this, list, j3, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void FlowerCardListIndicatorView(final com.tencent.ntcompose.core.i iVar, final int i3, final int i16, Composer composer, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(-330981997);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-330981997, i17, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.FlowerCardListIndicatorView (LoveWallFlowerCardListView.kt:139)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i3), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        float f16 = 128.0f / i16;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Animatable(Float.valueOf(i3 * f16));
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final Animatable animatable = (Animatable) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-1303710130);
        if (((Number) mutableState.getValue()).intValue() != i3) {
            Float valueOf = Float.valueOf(i3 * f16);
            m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
            Integer valueOf2 = Integer.valueOf(i3);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(valueOf2) | startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$FlowerCardListIndicatorView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f17) {
                        f17.floatValue();
                        mutableState.setValue(Integer.valueOf(i3));
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Animatable.b(animatable, valueOf, d16, (Function1) rememberedValue3, false, 8, null);
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(iVar, 128, 4), 2), h.INSTANCE.p(0.4f)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1285480013, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$FlowerCardListIndicatorView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1285480013, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.FlowerCardListIndicatorView.<anonymous> (LoveWallFlowerCardListView.kt:155)");
                    }
                    BoxKt.a(ModifiersKt.e(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 128.0f / i16, 4), 2), animatable.f().floatValue(), 0.0f, 0.0f, 0.0f, 12, null), Direction.TO_RIGHT, new j(new h(4293918640L), 0.1756f), new j(new h(4283815978L), 1.2245f)), null, null, null, composer3, 8, 14);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerCardListViewKt$FlowerCardListIndicatorView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerCardListViewKt.FlowerCardListIndicatorView(com.tencent.ntcompose.core.i.this, i3, i16, composer2, i17 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
