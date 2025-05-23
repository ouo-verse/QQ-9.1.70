package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.j;
import bp3.k;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import e25.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveFlowerCardViewKt {
    public static final void LoveWallSingleGeneView(final h hVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1560856698);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1560856698, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallSingleGeneView (LoveFlowerCardView.kt:120)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 84), 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1426094365, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveWallSingleGeneView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                String removeSuffix;
                List listOf;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1426094365, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallSingleGeneView.<anonymous> (LoveFlowerCardView.kt:123)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 70), 45);
                    StringBuilder sb5 = new StringBuilder();
                    removeSuffix = StringsKt__StringsKt.removeSuffix(h.this.f395476d, (CharSequence) "%");
                    sb5.append(removeSuffix);
                    sb5.append('%');
                    String sb6 = sb5.toString();
                    j jVar = new j(null, Float.valueOf(36.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 32765, null);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf("%");
                    RichTextKt.b(LoveSproutCardViewKt.highlightedText(sb6, jVar, listOf, new j(null, Float.valueOf(18.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 32765, null)), k3, null, com.tencent.kuikly.core.base.h.INSTANCE.b(), null, null, new c(700), new n("DINPro-Bold"), null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, (n.f339436b << 21) | 4160, 0, 0, 268434228);
                    i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 14);
                    final h hVar2 = h.this;
                    BoxKt.a(k16, null, null, ComposableLambdaKt.composableLambda(composer3, 1226599453, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveWallSingleGeneView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i16;
                            b bVar2 = bVar;
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
                                    ComposerKt.traceEventStart(1226599453, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallSingleGeneView.<anonymous>.<anonymous> (LoveFlowerCardView.kt:141)");
                                }
                                TextKt.a(h.this.f395477e, bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_secondary"), Float.valueOf(10.0f), null, null, null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28736, 0, 0, 134216676);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveWallSingleGeneView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveFlowerCardViewKt.LoveWallSingleGeneView(h.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoverWallGeneView(final i iVar, final List<h> list, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(56594789);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56594789, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoverWallGeneView (LoveFlowerCardView.kt:108)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.v(iVar, 168, 59), a.f339245a.b(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1316452227, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoverWallGeneView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1316452227, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoverWallGeneView.<anonymous> (LoveFlowerCardView.kt:112)");
                    }
                    Iterator<h> it = list.iterator();
                    while (it.hasNext()) {
                        LoveFlowerCardViewKt.LoveWallSingleGeneView(it.next(), composer3, 8);
                    }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoverWallGeneView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveFlowerCardViewKt.LoverWallGeneView(i.this, list, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveFlowerCardView(final i iVar, final e25.i iVar2, LoveFlowerCardConfig loveFlowerCardConfig, Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        LoveFlowerCardConfig loveFlowerCardConfig2;
        final int i17;
        Composer startRestartGroup = composer.startRestartGroup(1809338152);
        if ((i16 & 4) != 0) {
            i17 = i3 & (-897);
            loveFlowerCardConfig2 = new LoveFlowerCardConfig(true, 32.0f);
        } else {
            loveFlowerCardConfig2 = loveFlowerCardConfig;
            i17 = i3;
        }
        final Function0<Unit> function02 = (i16 & 8) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1809338152, i17, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardView (LoveFlowerCardView.kt:34)");
        }
        LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(iVar, new LoveWallFlowerGeneralCardConfig(iVar2.f395479e, loveFlowerCardConfig2.titleFontSize, loveFlowerCardConfig2.playFlowerAnimation), ComposableLambdaKt.composableLambda(startRestartGroup, -1012891268, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveFlowerCardView$1
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
                        ComposerKt.traceEventStart(-1012891268, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardView.<anonymous> (LoveFlowerCardView.kt:47)");
                    }
                    ColumnKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer3, -1806461979, true, new Function3<d, Composer, Integer, Unit>(function02, i17) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveFlowerCardView$1.1
                        public final /* synthetic */ Function0<Unit> $onShareBtnClick;

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
                                    ComposerKt.traceEventStart(-1806461979, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardView.<anonymous>.<anonymous> (LoveFlowerCardView.kt:50)");
                                }
                                i.Companion companion = i.INSTANCE;
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.0f, 2, 0.0f, 0.0f, 13, null);
                                a.e b16 = a.f339245a.b();
                                final e25.i iVar3 = e25.i.this;
                                RowKt.a(n3, b16, null, null, null, ComposableLambdaKt.composableLambda(composer5, -1529671805, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt.LoveFlowerCardView.1.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer6, Integer num3) {
                                        String replace$default;
                                        String replace$default2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1529671805, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardView.<anonymous>.<anonymous>.<anonymous> (LoveFlowerCardView.kt:54)");
                                            }
                                            i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                            replace$default = StringsKt__StringsJVMKt.replace$default(e25.i.this.D, "[", "", false, 4, (Object) null);
                                            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "]", "", false, 4, (Object) null);
                                            RichTextKt.b(LoveSproutCardViewKt.highlightedText(replace$default2, new j(QUIToken.color$default("text_secondary"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), LoveSproutCardViewKt.extractBracketedContent(e25.i.this.D), new j(new com.tencent.kuikly.core.base.h(255, 128, 0, 1.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null)), j3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_secondary"), Float.valueOf(10), null, null, null, null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, 16124, null), null, null, null, null, null, null, composer7, 64, 0, k.f28903n << 3, 266338300);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196680, 28);
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion, 168), 8.0f), 0.0f, 8, 0.0f, 0.0f, 13, null), null, 0, null, null, e25.i.this.f395481h, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.0f, 4, 0.0f, 0.0f, 13, null), 17);
                                final e25.i iVar4 = e25.i.this;
                                BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, -1820966625, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt.LoveFlowerCardView.1.1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                        int i18;
                                        b bVar2 = bVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i18 = (composer7.changed(bVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i18 = intValue3;
                                        }
                                        if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1820966625, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardView.<anonymous>.<anonymous>.<anonymous> (LoveFlowerCardView.kt:77)");
                                            }
                                            TextKt.a(e25.i.this.C, bVar2.a(i.INSTANCE, Alignment.Center), null, com.tencent.kuikly.core.base.h.INSTANCE.b(), Float.valueOf(14.0f), null, null, new n("MFZhuoYing"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, (n.f339436b << 21) | 28736, 0, 0, 134217572);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                LoveFlowerCardViewKt.LoverWallGeneView(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 5, 0.0f, 0.0f, 13, null), e25.i.this.E, composer5, 72);
                                if (this.$onShareBtnClick != null) {
                                    i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 166.0f, 45.0f), 0.0f, 12, 0.0f, 0.0f, 13, null);
                                    e25.b bVar = e25.i.this.F;
                                    if (bVar == null || (str = bVar.f395469e) == null) {
                                        str = "\u5206\u4eab\u82b1\u8bed";
                                    }
                                    LoveWallButtonConfig loveWallButtonConfig = new LoveWallButtonConfig(str, 17.0f, LoveWallButtonTextColor.YELLOW_BUTTON_COLORS, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_TnkBjfRXl8n.png");
                                    final Function0<Unit> function03 = this.$onShareBtnClick;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function03);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveFlowerCardView$1$1$3$1
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
                                    LoveWallButtonKt.LoveWallButton(n16, loveWallButtonConfig, (Function1) rememberedValue, composer5, 8);
                                }
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
        final LoveFlowerCardConfig loveFlowerCardConfig3 = loveFlowerCardConfig2;
        final Function0<Unit> function03 = function02;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveFlowerCardViewKt$LoveFlowerCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveFlowerCardViewKt.LoveFlowerCardView(i.this, iVar2, loveFlowerCardConfig3, function03, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
