package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$NearbyFeedItemViewKt {
    public static final ComposableSingletons$NearbyFeedItemViewKt INSTANCE = new ComposableSingletons$NearbyFeedItemViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f62lambda1 = ComposableLambdaKt.composableLambdaInstance(-835212504, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ComposableSingletons$NearbyFeedItemViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-835212504, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ComposableSingletons$NearbyFeedItemViewKt.lambda-1.<anonymous> (NearbyFeedItemView.kt:160)");
                }
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DdHUF3lfAnx.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("button_text_secondary_default"), null, composer2, 262150, 1073741824, 0, 1572830);
                TextKt.a(TextViewExtKt.fixLineHeightForView("\u6253\u62db\u547c"), null, null, QUIToken.color$default("button_text_secondary_default"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601536, 0, 0, 134217638);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f63lambda2 = ComposableLambdaKt.composableLambdaInstance(-625242667, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ComposableSingletons$NearbyFeedItemViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-625242667, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ComposableSingletons$NearbyFeedItemViewKt.lambda-2.<anonymous> (NearbyFeedItemView.kt:203)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
