package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class LoveWallContributionCardPageViewKt {
    public static final void LoveWallContributionCardPageView(final Function0<Unit> function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(462963507);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(462963507, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageView (LoveWallContributionCardPageView.kt:26)");
            }
            ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 628883061, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt$LoveWallContributionCardPageView$1
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
                            ComposerKt.traceEventStart(628883061, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageView.<anonymous> (LoveWallContributionCardPageView.kt:27)");
                        }
                        ColumnKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.a(0.5f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt$LoveWallContributionCardPageView$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        }, 3, null), a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer3, 1957526572, true, new Function3<d, Composer, Integer, Unit>(function0, i16) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt$LoveWallContributionCardPageView$1.2
                            public final /* synthetic */ Function0<Unit> $onCloseBtnClick;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1957526572, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageView.<anonymous>.<anonymous> (LoveWallContributionCardPageView.kt:34)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    LoveWallContributionCardPageViewKt.LoveWallContributionCardView(ComposeLayoutPropUpdaterKt.v(companion, 292, 427), composer5, 8);
                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 32.0f), 0.0f, 32, 0.0f, 0.0f, 13, null);
                                    final Function0<Unit> function02 = this.$onCloseBtnClick;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function02);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt$LoveWallContributionCardPageView$1$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function02.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue, 3, null), null, 0, null, null, QUIToken.INSTANCE.image("close_circle", QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
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
            }), startRestartGroup, 24624, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt$LoveWallContributionCardPageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallContributionCardPageViewKt.LoveWallContributionCardPageView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallContributionCardView(final i iVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1072533269);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1072533269, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardView (LoveWallContributionCardPageView.kt:52)");
        }
        LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(iVar, new LoveWallFlowerGeneralCardConfig("\u6211\u4eec\u7684\u8d21\u732e\u503c", 26.0f, 4), ComposableSingletons$LoveWallContributionCardPageViewKt.f94lambda3, startRestartGroup, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallContributionCardPageViewKt$LoveWallContributionCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallContributionCardPageViewKt.LoveWallContributionCardView(i.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
