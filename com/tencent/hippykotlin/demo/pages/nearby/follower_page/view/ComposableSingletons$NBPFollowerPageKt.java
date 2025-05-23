package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* loaded from: classes31.dex */
public final class ComposableSingletons$NBPFollowerPageKt {
    public static final ComposableSingletons$NBPFollowerPageKt INSTANCE = new ComposableSingletons$NBPFollowerPageKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function4<Integer, String, Composer, Integer, Unit> f44lambda1 = ComposableLambdaKt.composableLambdaInstance(-1940578372, false, new Function4<Integer, String, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(Integer num, String str, Composer composer, Integer num2) {
            int i3;
            int intValue = num.intValue();
            Composer composer2 = composer;
            int intValue2 = num2.intValue();
            if ((intValue2 & 14) == 0) {
                i3 = (composer2.changed(intValue) ? 4 : 2) | intValue2;
            } else {
                i3 = intValue2;
            }
            if ((i3 & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1940578372, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerPageKt.lambda-1.<anonymous> (NBPFollowerPage.kt:93)");
                }
                if (intValue == 0) {
                    composer2.startReplaceableGroup(-494512203);
                    NBPFollowerListKt.NBPFansList(null, composer2, 0, 1);
                    composer2.endReplaceableGroup();
                } else if (intValue != 1) {
                    composer2.startReplaceableGroup(-494512021);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-494512116);
                    NBPFollowerListKt.NBPFollowingList(null, composer2, 0, 1);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f45lambda2 = ComposableLambdaKt.composableLambdaInstance(1495818651, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1495818651, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerPageKt.lambda-2.<anonymous> (NBPFollowerPage.kt:135)");
                }
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gprg2tiIEyx.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_nav_secondary"), null, composer2, 262150, 1073741824, 0, 1572830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f46lambda3 = ComposableLambdaKt.composableLambdaInstance(2030978089, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2030978089, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.ComposableSingletons$NBPFollowerPageKt.lambda-3.<anonymous> (NBPFollowerPage.kt:147)");
                }
                ColumnKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.d(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 51, 2), QUIToken.color$default("brand_standard")), 0.0f, 5, 0.0f, 15, 5, null), null, null, null, null, composer2, 8, 30);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
