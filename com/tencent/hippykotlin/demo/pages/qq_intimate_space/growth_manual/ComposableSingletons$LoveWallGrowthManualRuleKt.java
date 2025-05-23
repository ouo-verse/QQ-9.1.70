package com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyVerticalGridKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallGrowthManualRuleKt {
    public static final ComposableSingletons$LoveWallGrowthManualRuleKt INSTANCE = new ComposableSingletons$LoveWallGrowthManualRuleKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f98lambda1 = ComposableLambdaKt.composableLambdaInstance(630528563, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ComposableSingletons$LoveWallGrowthManualRuleKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(630528563, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ComposableSingletons$LoveWallGrowthManualRuleKt.lambda-1.<anonymous> (LoveWallGrowthManualRule.kt:82)");
                }
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ManualRuleViewModel(), null, 2, null);
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceableGroup();
                final MutableState mutableState = (MutableState) rememberedValue;
                LazyVerticalGridKt.a(new r.a(1), ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 12, 0.0f, 0.0f, 0.0f, 14, null), ((a) composer2.consume(CompositionLocalsKt.d())).e() - 64, null, null, null, 0.0f, 0, null, null, null, Boolean.FALSE, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer2, -865247922, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ComposableSingletons$LoveWallGrowthManualRuleKt$lambda-1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ManualRule>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer3, Integer num2) {
                        String str;
                        Object last;
                        Composer composer4 = composer3;
                        int intValue2 = num2.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-865247922, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ComposableSingletons$LoveWallGrowthManualRuleKt.lambda-1.<anonymous>.<anonymous> (LoveWallGrowthManualRule.kt:90)");
                        }
                        Iterator it = mutableState.getValue().rules.iterator();
                        while (it.hasNext()) {
                            ManualRule manualRule = (ManualRule) it.next();
                            String str2 = manualRule.title;
                            if (str2.length() > 4) {
                                str = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_AHy1T80hEIq.png";
                            } else {
                                str = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_BXVkCiP1i8n.png";
                            }
                            i.Companion companion = i.INSTANCE;
                            LoveWallGrowthManualRuleKt.LoveWallRuleTitle(str2, str, ModifiersKt.e(companion, Direction.TO_RIGHT, new j(new h(4278366577L), 0.0f), new j(new h(4280621584L), 0.0f)), composer4, 512);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, (float) 12.16d), composer4, 8, 0);
                            LoveWallGrowthManualRuleKt.LoveWallRuleContent(manualRule.desc, composer4, 0);
                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableState.getValue().rules);
                            if (!Intrinsics.areEqual(manualRule, last)) {
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 20), composer4, 8, 0);
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), composer2, 12582976, 48, 1572864, 67106680);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f99lambda2 = ComposableLambdaKt.composableLambdaInstance(1893235101, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ComposableSingletons$LoveWallGrowthManualRuleKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1893235101, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.ComposableSingletons$LoveWallGrowthManualRuleKt.lambda-2.<anonymous> (LoveWallGrowthManualRule.kt:147)");
                }
                float f16 = 12;
                int c16 = ai.INSTANCE.c();
                QUIToken qUIToken = QUIToken.INSTANCE;
                TextKt.a("\u53cd\u9988\u5165\u53e3", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, null, null, null, null, null, ai.f(c16), Float.valueOf(17), null, null, null, null, 15612, null), null, null, null, null, null, false, composer2, 6, 0, k.f28903n, 133169150);
                i.Companion companion = i.INSTANCE;
                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 4), composer2, 8, 0);
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, f16), null, 0, null, null, qUIToken.image("chevron_right", QUIToken.color$default("icon_secondary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
