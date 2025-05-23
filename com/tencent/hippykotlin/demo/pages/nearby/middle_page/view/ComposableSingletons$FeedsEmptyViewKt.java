package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$FeedsEmptyViewKt {
    public static final ComposableSingletons$FeedsEmptyViewKt INSTANCE = new ComposableSingletons$FeedsEmptyViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f47lambda1 = ComposableLambdaKt.composableLambdaInstance(-966956830, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.ComposableSingletons$FeedsEmptyViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-966956830, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.ComposableSingletons$FeedsEmptyViewKt.lambda-1.<anonymous> (FeedsEmptyView.kt:45)");
                }
                i.Companion companion = i.INSTANCE;
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_eBbVv6UNVeV.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 80.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, new h(4287664276L), null, composer2, 262150, 1073741824, 0, 1572830);
                i n3 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 6.0f, 0.0f, 0.0f, 13, null);
                TextKt.a(TextViewExtKt.fixLineHeightForView("\u7b2c\u4e00\u4e2a\u53d1\u5e16\u7684\u4eba\u53ef\u4ee5\u5360\u9886\u6b64\u5730\u54e6"), n3, null, new h(4287664276L), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601600, 48, 0, 134215588);
                BoxKt.a(ComposeLayoutPropUpdaterKt.k(companion, 20.0f), null, null, null, composer2, 8, 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
