package com.tencent.ntcompose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "Lcom/tencent/ntcompose/foundation/lazy/d;", "a", "(IFLandroidx/compose/runtime/Composer;II)Lcom/tencent/ntcompose/foundation/lazy/d;", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {
    public static final d a(int i3, float f16, Composer composer, int i16, int i17) {
        composer.startReplaceableGroup(-1000478990);
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            f16 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1000478990, i16, -1, "com.tencent.ntcompose.foundation.lazy.rememberLazyListState (LazyListState.kt:29)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new d(i3, f16);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        d dVar = (d) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dVar;
    }
}
