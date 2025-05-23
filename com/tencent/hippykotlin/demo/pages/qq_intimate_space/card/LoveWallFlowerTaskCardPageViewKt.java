package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardViewKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.mobileqq.vas.qid.QidPagView;
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
import e25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class LoveWallFlowerTaskCardPageViewKt {
    public static final void LoveWallFlowerTaskCardPageView(final i iVar, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1308679785);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1308679785, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageView (LoveWallFlowerTaskCardPageView.kt:22)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1081675051, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageViewKt$LoveWallFlowerTaskCardPageView$1
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
                        ComposerKt.traceEventStart(1081675051, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageView.<anonymous> (LoveWallFlowerTaskCardPageView.kt:27)");
                    }
                    com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), h.INSTANCE.a(0.5f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageViewKt$LoveWallFlowerTaskCardPageView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                    a.e b17 = a.f339245a.b();
                    final i iVar2 = i.this;
                    final Function0<Unit> function03 = function0;
                    final int i16 = i3;
                    final Function0<Unit> function04 = function02;
                    ColumnKt.a(d16, b17, b16, null, ComposableLambdaKt.composableLambda(composer3, -1141822686, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageViewKt$LoveWallFlowerTaskCardPageView$1.2
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
                                    ComposerKt.traceEventStart(-1141822686, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageView.<anonymous>.<anonymous> (LoveWallFlowerTaskCardPageView.kt:34)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                LoveFlowerTaskCardViewKt.LoveFlowerTaskCardView(ComposeLayoutPropUpdaterKt.v(companion, 292, QidPagView.DESIGN_PAG_WIDTH), e25.i.this, function03, composer5, ((i16 << 3) & 896) | 72);
                                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 32.0f), 0.0f, 32, 0.0f, 0.0f, 13, null);
                                final Function0<Unit> function05 = function04;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function05);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageViewKt$LoveWallFlowerTaskCardPageView$1$2$1$1
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.card.LoveWallFlowerTaskCardPageViewKt$LoveWallFlowerTaskCardPageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerTaskCardPageViewKt.LoveWallFlowerTaskCardPageView(e25.i.this, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
