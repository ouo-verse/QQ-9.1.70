package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import bp3.k;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.views.CanvasLinearGradient;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.CanvasViewPropUpdater;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.Stroke;
import com.tencent.ntcompose.material.ab;
import com.tencent.ntcompose.material.ae;
import com.tencent.ntcompose.material.ao;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.m;
import com.tencent.ntcompose.material.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yo3.Size;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFlowerGeneralCardKt {
    public static final void LoveWallFlowerGeneralCard(final i iVar, final LoveWallFlowerGeneralCardConfig loveWallFlowerGeneralCardConfig, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-806288396);
        if ((i16 & 4) != 0) {
            function2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-806288396, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCard (LoveWallFlowerGeneralCard.kt:41)");
        }
        BoxKt.a(ViewEventPropUpdaterKt.d(iVar, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$LoveWallFlowerGeneralCard$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -191238226, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$LoveWallFlowerGeneralCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Type inference failed for: r11v2 */
            /* JADX WARN: Type inference failed for: r11v3, types: [int, boolean] */
            /* JADX WARN: Type inference failed for: r11v5 */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i17;
                List listOf;
                List listOf2;
                Composer composer3;
                i.Companion companion;
                float f16;
                Object obj;
                ?? r112;
                b bVar2 = bVar;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer4.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-191238226, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCard.<anonymous> (LoveWallFlowerGeneralCard.kt:48)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    BoxKt.a(ModifiersKt.e(ModifiersKt.G(ModifiersKt.j(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), 13.0f, 50.0f, 9.0f, 4.0f), 16), -2.74f, null, 2, null), Direction.TO_RIGHT, new j(new h(4293918640L), 0.1756f), new j(new h(4283815978L), 1.0f)), null, null, null, composer4, 8, 14);
                    i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), 4.0f, 34.0f, 18.0f, 4.0f);
                    Float valueOf = Float.valueOf(0.0f);
                    h.Companion companion3 = h.INSTANCE;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(valueOf, companion3.a(0.1f)), TuplesKt.to(Float.valueOf(1.0f), companion3.a(0.1f))});
                    LoveWallFlowerGeneralCardKt.FlowerCardPolygon(m3, listOf, false, composer4, QFSNumberConstants.Int.NUM_456, 0);
                    composer4.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer4.rememberedValue();
                    Composer.Companion companion4 = Composer.INSTANCE;
                    if (rememberedValue == companion4.getEmpty()) {
                        rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, composer4);
                    }
                    composer4.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), 0.0f, 30.0f, 22.0f, 8.0f, 1, null);
                    composer4.startReplaceableGroup(1157296644);
                    boolean changed = composer4.changed(mutableState);
                    Object rememberedValue2 = composer4.rememberedValue();
                    if (changed || rememberedValue2 == companion4.getEmpty()) {
                        rememberedValue2 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$LoveWallFlowerGeneralCard$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                mutableState.setValue(Float.valueOf(aVar.getSize().getWidth()));
                                return Unit.INSTANCE;
                            }
                        };
                        composer4.updateRememberedValue(rememberedValue2);
                    }
                    composer4.endReplaceableGroup();
                    i k3 = ViewEventPropUpdaterKt.k(n3, (Function1) rememberedValue2);
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Float.valueOf(0.0f), new h(4291424595L)), TuplesKt.to(Float.valueOf(0.1175f), new h(4294967295L))});
                    LoveWallFlowerGeneralCardKt.FlowerCardPolygon(k3, listOf2, true, composer4, QFSNumberConstants.Int.NUM_456, 0);
                    if (LoveWallFlowerGeneralCardConfig.this.playFlowerAnimation) {
                        composer4.startReplaceableGroup(-234217680);
                        APNGKt.a(ComposeLayoutPropUpdaterKt.o(bVar2.a(ComposeLayoutPropUpdaterKt.v(companion2, 52, 75.81f), Alignment.BottomEnd), (float) 13.5d, -98), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/card_flower.png", 0, null, null, null, null, composer4, 3464, 242);
                        composer4.endReplaceableGroup();
                        r112 = 1;
                        f16 = 0.0f;
                        companion = companion2;
                        composer3 = composer4;
                        obj = null;
                    } else {
                        composer4.startReplaceableGroup(-234217349);
                        composer3 = composer4;
                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.o(bVar2.a(ComposeLayoutPropUpdaterKt.v(companion2, 52, 75.81f), Alignment.BottomEnd), (float) 13.5d, -98), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_lAxT6MZYovk.png", null, null, null, null, null, null, null, null, null, null, composer3, 262144, 6, 0, 2096095);
                        composer3.endReplaceableGroup();
                        companion = companion2;
                        f16 = 0.0f;
                        obj = null;
                        r112 = 1;
                    }
                    Composer composer5 = composer3;
                    BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion, f16, r112, obj), 0.0f, 30.0f, 0.0f, 0.0f, 13, null), null, null, ComposableSingletons$LoveWallFlowerGeneralCardKt.f97lambda1, composer5, 3080, 6);
                    i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion, f16, r112, obj), 0.0f, 30.0f, 22.0f, 8.0f, 1, null);
                    final LoveWallFlowerGeneralCardConfig loveWallFlowerGeneralCardConfig2 = LoveWallFlowerGeneralCardConfig.this;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    final int i18 = i3;
                    BoxKt.a(n16, null, null, ComposableLambdaKt.composableLambda(composer5, -1533671696, r112, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$LoveWallFlowerGeneralCard$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer6, Integer num2) {
                            Composer composer7 = composer6;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1533671696, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCard.<anonymous>.<anonymous> (LoveWallFlowerGeneralCard.kt:117)");
                                }
                                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                final LoveWallFlowerGeneralCardConfig loveWallFlowerGeneralCardConfig3 = LoveWallFlowerGeneralCardConfig.this;
                                final Function2<Composer, Integer, Unit> function23 = function22;
                                final int i19 = i18;
                                ColumnKt.a(h16, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1618132135, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer8, Integer num3) {
                                        Composer composer9 = composer8;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                            composer9.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1618132135, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCard.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerGeneralCard.kt:118)");
                                            }
                                            i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, LoveWallFlowerGeneralCardConfig.this.titleFontSize >= 32.0f ? 40.12f : 35.12f), 0.0f, 20.2f, 0.0f, 0.0f, 13, null);
                                            final LoveWallFlowerGeneralCardConfig loveWallFlowerGeneralCardConfig4 = LoveWallFlowerGeneralCardConfig.this;
                                            BoxKt.a(n17, null, null, ComposableLambdaKt.composableLambda(composer9, -185674605, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard.2.2.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar4, Composer composer10, Integer num4) {
                                                    Composer composer11 = composer10;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer11.getSkipping()) {
                                                        composer11.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-185674605, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallFlowerGeneralCard.kt:120)");
                                                        }
                                                        composer11.startReplaceableGroup(-492369756);
                                                        Object rememberedValue3 = composer11.rememberedValue();
                                                        Composer.Companion companion5 = Composer.INSTANCE;
                                                        if (rememberedValue3 == companion5.getEmpty()) {
                                                            rememberedValue3 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, composer11);
                                                        }
                                                        composer11.endReplaceableGroup();
                                                        final MutableState mutableState2 = (MutableState) rememberedValue3;
                                                        i.Companion companion6 = i.INSTANCE;
                                                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion6, ((Number) mutableState2.getValue()).floatValue() + 49), (float) 29.73d), -10, LoveWallFlowerGeneralCardConfig.this.titleFontSize >= 32.0f ? 25.0f : 20.0f, 0.0f, 0.0f, 12, null), null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_NBjQeWirt3R.png", null, null, null, null, null, null, null, null, null, null, composer11, 12845056, 6, 0, 2095967);
                                                        i n18 = ComposeLayoutPropUpdaterKt.n(companion6, 19, 0.0f, 0.0f, 0.0f, 14, null);
                                                        Alignment alignment = Alignment.Center;
                                                        String str = LoveWallFlowerGeneralCardConfig.this.title;
                                                        composer11.startReplaceableGroup(1157296644);
                                                        boolean changed2 = composer11.changed(mutableState2);
                                                        Object rememberedValue4 = composer11.rememberedValue();
                                                        if (changed2 || rememberedValue4 == companion5.getEmpty()) {
                                                            rememberedValue4 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$LoveWallFlowerGeneralCard$2$2$1$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(a aVar) {
                                                                    mutableState2.setValue(Float.valueOf(aVar.getSize().getWidth()));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer11.updateRememberedValue(rememberedValue4);
                                                        }
                                                        composer11.endReplaceableGroup();
                                                        LoveWallGradientOutLineTextKt.LoveWallGradientOutLineText(n18, alignment, str, ViewEventPropUpdaterKt.k(companion6, (Function1) rememberedValue4), new k(new h(23, 23, 23, 1.0f), Float.valueOf(LoveWallFlowerGeneralCardConfig.this.titleFontSize), null, null, new n("MFYuanHei"), null, null, null, null, null, null, null, null, null, 16364, null), new ao(h.INSTANCE.m(), 6.26f), composer11, (k.f28903n << 12) | 4152, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer9, 3080, 6);
                                            Function2<Composer, Integer, Unit> function24 = function23;
                                            if (function24 != null) {
                                                function24.invoke(composer9, Integer.valueOf((i19 >> 6) & 14));
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer7, 24584, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer5, 3080, 6);
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
        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$LoveWallFlowerGeneralCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(i.this, loveWallFlowerGeneralCardConfig, function22, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void FlowerCardPolygon(final i iVar, final List<Pair<Float, h>> list, boolean z16, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(943196461);
        boolean z17 = (i16 & 4) != 0 ? false : z16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(943196461, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.FlowerCardPolygon (LoveWallFlowerGeneralCard.kt:154)");
        }
        startRestartGroup.startReplaceableGroup(-537167339);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new com.tencent.ntcompose.material.k();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final com.tencent.ntcompose.material.k kVar = (com.tencent.ntcompose.material.k) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue2;
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            kVar.e();
            ab abVar = new ab();
            float width = (kVar.getSize().getWidth() * 2.0f) / 3.0f;
            float f16 = width - 5.0f;
            float f17 = width - 2.5f;
            float f18 = width + 5.0f;
            float width2 = (kVar.getSize().getWidth() / 8.0f) + ((kVar.getSize().getWidth() * 2.0f) / 3.0f);
            float width3 = kVar.getSize().getWidth() / 8.0f;
            float f19 = width2 - 5.0f;
            float f26 = width3 - 5.0f;
            abVar.g(16.0f, 0.0f);
            abVar.f(f16, 0.0f);
            abVar.c(f16, 0.0f, f17, 0.0f, f18, 5.0f);
            abVar.f(f19, f26);
            abVar.c(f19, f26, width2 + 2.5f, width3, width2 + 5.0f, width3);
            abVar.f(kVar.getSize().getWidth() - 16.0f, width3);
            abVar.a(kVar.getSize().getWidth() - 16.0f, width3 + 16.0f, 16.0f, -90.0f, 0.0f, false);
            abVar.f(kVar.getSize().getWidth(), kVar.getSize().getHeight() - 16.0f);
            abVar.a(kVar.getSize().getWidth() - 16.0f, kVar.getSize().getHeight() - 16.0f, 16.0f, 0.0f, 90.0f, false);
            abVar.f(16.0f, kVar.getSize().getHeight());
            abVar.a(16.0f, kVar.getSize().getHeight() - 16.0f, 16.0f, 90.0f, 180.0f, false);
            abVar.f(0.0f, 16.0f);
            abVar.a(16.0f, 16.0f, 16.0f, 180.0f, 270.0f, false);
            abVar.d();
            CanvasLinearGradient canvasLinearGradient = new CanvasLinearGradient(0.0f, 0.0f, 0.0f, kVar.getSize().getHeight());
            for (Pair<Float, h> pair : list) {
                canvasLinearGradient.a(pair.getFirst().floatValue(), pair.getSecond());
            }
            Unit unit = Unit.INSTANCE;
            kVar.a(abVar, canvasLinearGradient, m.f339435a);
            if (z17) {
                CanvasLinearGradient canvasLinearGradient2 = new CanvasLinearGradient(0.0f, 0.0f, 0.0f, 0.0f);
                h.Companion companion2 = h.INSTANCE;
                canvasLinearGradient2.a(0.0f, companion2.p(0.1f));
                canvasLinearGradient2.a(1.0f, companion2.p(0.1f));
                kVar.a(abVar, canvasLinearGradient2, new Stroke(2.0f, 0.0f, ae.INSTANCE.b(), 2, null));
            }
            if (!kVar.m()) {
                kVar.w();
                MutableState<Integer> q16 = kVar.q();
                q16.setValue(Integer.valueOf(q16.getValue().intValue() + 1));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.ntcompose.core.k("drawCallback", kVar, kVar.q().getValue(), null, null, null, CanvasViewPropUpdater.f339340a, 56, null));
        ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, ViewEventPropUpdaterKt.m(iVar, new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$FlowerCardPolygon$$inlined$Canvas$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(w wVar) {
                w it = wVar;
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.ntcompose.material.k.this.z(new Size(it.getWidth(), it.getHeight()));
                mutableState.setValue(Boolean.TRUE);
                MutableState<Integer> q17 = com.tencent.ntcompose.material.k.this.q();
                q17.setValue(Integer.valueOf(q17.getValue().intValue() + 1));
                return Unit.INSTANCE;
            }
        }), arrayList, null, startRestartGroup, 33206, 32);
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final boolean z18 = z17;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt$FlowerCardPolygon$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFlowerGeneralCardKt.FlowerCardPolygon(i.this, list, z18, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
