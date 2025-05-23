package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallGradientOutLineTextKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ao;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallNavigationBarKt {
    public static final void LoveWallNavigationBar(final i iVar, boolean z16, boolean z17, boolean z18, final Function1<? super ClickParams, Unit> function1, Function1<? super ClickParams, Unit> function12, Function1<? super ClickParams, Unit> function13, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-2045368646);
        boolean z19 = (i16 & 2) != 0 ? true : z16;
        boolean z26 = (i16 & 4) != 0 ? true : z17;
        boolean z27 = (i16 & 8) != 0 ? true : z18;
        Function1<? super ClickParams, Unit> function14 = (i16 & 32) != 0 ? null : function12;
        Function1<? super ClickParams, Unit> function15 = (i16 & 64) != 0 ? null : function13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045368646, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBar (LoveWallNavigationBar.kt:31)");
        }
        final boolean z28 = z19;
        final boolean z29 = z27;
        final Function1<? super ClickParams, Unit> function16 = function15;
        final boolean z36 = z26;
        final Function1<? super ClickParams, Unit> function17 = function14;
        BoxKt.a(ComposeLayoutPropUpdaterKt.j(iVar, 0.0f, 1, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 277783924, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBarKt$LoveWallNavigationBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i17;
                i.Companion companion;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(277783924, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBar.<anonymous> (LoveWallNavigationBar.kt:43)");
                    }
                    Function1<ClickParams, Unit> function18 = function1;
                    i.Companion companion2 = i.INSTANCE;
                    ButtonKt.a(null, function18, ComposeLayoutPropUpdaterKt.p(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion2, 44), Alignment.CenterStart), 10, 0.0f, 2, null), null, ComposableSingletons$LoveWallNavigationBarKt.f105lambda2, composer3, ((i3 >> 9) & 112) | 25088, 9);
                    composer3.startReplaceableGroup(-722900724);
                    if (z28) {
                        companion = companion2;
                        LoveWallGradientOutLineTextKt.LoveWallGradientOutLineText(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(companion2, 100), 0.0f, 1, null), Alignment.Center, "\u7231\u60c5\u85e4\u8513", ModifiersKt.e(companion, Direction.TO_BOTTOM, new j(new h(4278190080L), 0.0f), new j(new h(4279254060L), 0.5f), new j(new h(4279979570L), 1.0f)), new k(null, Float.valueOf(20), null, null, new n("MFYuanHei"), null, null, null, null, Float.valueOf(30), null, null, null, null, 15853, null), new ao(h.INSTANCE.m(), 3), composer3, (k.f28903n << 12) | 4536, 0);
                    } else {
                        companion = companion2;
                    }
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-722899875);
                    if (z29) {
                        final Function1<ClickParams, Unit> function19 = function16;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function19);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBarKt$LoveWallNavigationBar$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    ClickParams clickParams2 = clickParams;
                                    Function1<ClickParams, Unit> function110 = function19;
                                    if (function110 != null) {
                                        function110.invoke(clickParams2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.a(null, (Function1) rememberedValue, ModifierExtKt.elementVR(ComposeLayoutPropUpdaterKt.p(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, 36), Alignment.CenterEnd), -54, 0.0f, 2, null), "em_qz_planting_handbook_entry", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams()), null, ComposableSingletons$LoveWallNavigationBarKt.f107lambda4, composer3, 25088, 9);
                    }
                    composer3.endReplaceableGroup();
                    if (z36) {
                        final Function1<ClickParams, Unit> function110 = function17;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed2 = composer3.changed(function110);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBarKt$LoveWallNavigationBar$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    ClickParams clickParams2 = clickParams;
                                    Function1<ClickParams, Unit> function111 = function110;
                                    if (function111 != null) {
                                        function111.invoke(clickParams2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        ButtonKt.a(null, (Function1) rememberedValue2, ModifierExtKt.elementVR(ComposeLayoutPropUpdaterKt.p(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, 36), Alignment.CenterEnd), -18, 0.0f, 2, null), WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams()), null, ComposableSingletons$LoveWallNavigationBarKt.f109lambda6, composer3, 25088, 9);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
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
        final boolean z37 = z19;
        final boolean z38 = z26;
        final boolean z39 = z27;
        final Function1<? super ClickParams, Unit> function18 = function14;
        final Function1<? super ClickParams, Unit> function19 = function15;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBarKt$LoveWallNavigationBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallNavigationBarKt.LoveWallNavigationBar(i.this, z37, z38, z39, function1, function18, function19, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
