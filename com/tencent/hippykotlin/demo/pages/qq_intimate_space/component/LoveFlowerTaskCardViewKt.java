package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import e25.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveFlowerTaskCardViewKt {
    public static final void LoveFlowerTaskCardView(final i iVar, final e25.i iVar2, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(604109793);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(604109793, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardView (LoveFlowerTaskCardView.kt:19)");
        }
        LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(iVar, new LoveWallFlowerGeneralCardConfig(iVar2.f395479e, 0.0f, 6), ComposableLambdaKt.composableLambda(startRestartGroup, 313692429, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardViewKt$LoveFlowerTaskCardView$1
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
                        ComposerKt.traceEventStart(313692429, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardView.<anonymous> (LoveFlowerTaskCardView.kt:29)");
                    }
                    ColumnKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardViewKt$LoveFlowerTaskCardView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer3, 1690617860, true, new Function3<d, Composer, Integer, Unit>(function0, i3) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardViewKt$LoveFlowerTaskCardView$1.2
                        public final /* synthetic */ Function0<Unit> $onCompleteBtnClick;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            String str;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1690617860, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardView.<anonymous>.<anonymous> (LoveFlowerTaskCardView.kt:35)");
                                }
                                i.Companion companion = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion, 168), 8.0f), 0.0f, 10, 0.0f, 0.0f, 13, null), null, 0, null, null, e25.i.this.f395481h, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                TextKt.a(e25.i.this.D, ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 8, 0.0f, 0.0f, 13, null), null, h.INSTANCE.b(), Float.valueOf(12.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28736, 0, 0, 134217700);
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 166.0f, 45.0f), 0.0f, 12, 0.0f, 0.0f, 13, null);
                                b bVar = e25.i.this.F;
                                if (bVar == null || (str = bVar.f395469e) == null) {
                                    str = "";
                                }
                                LoveWallButtonConfig loveWallButtonConfig = new LoveWallButtonConfig(str, 17.0f, LoveWallButtonTextColor.YELLOW_BUTTON_COLORS, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_TnkBjfRXl8n.png");
                                final Function0<Unit> function02 = this.$onCompleteBtnClick;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function02);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardViewKt$LoveFlowerTaskCardView$1$2$1$1
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
                                LoveWallButtonKt.LoveWallButton(n3, loveWallButtonConfig, (Function1) rememberedValue, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerTaskCardViewKt$LoveFlowerTaskCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveFlowerTaskCardViewKt.LoveFlowerTaskCardView(i.this, iVar2, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
