package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import defpackage.k;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTUIConfigKt {
    public static final float getAndroidBottomNavBarHeight(Composer composer) {
        composer.startReplaceableGroup(-1486056533);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1486056533, 0, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.getAndroidBottomNavBarHeight (QQFTUIConfig.kt:94)");
        }
        if (k.a(c.f117352a)) {
            float bottom = ((a) composer.consume(CompositionLocalsKt.d())).f().getBottom();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return bottom;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return 10.0f;
    }
}
