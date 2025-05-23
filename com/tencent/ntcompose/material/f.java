package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"", "undoEnable", "Lcom/tencent/ntcompose/material/i;", "a", "(ZLandroidx/compose/runtime/Composer;II)Lcom/tencent/ntcompose/material/i;", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {
    public static final i a(boolean z16, Composer composer, int i3, int i16) {
        composer.startReplaceableGroup(1993394304);
        if ((i16 & 1) != 0) {
            z16 = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1993394304, i3, -1, "com.tencent.ntcompose.material.rememberDrawApiState (CanvasV2.kt:26)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new i(z16);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        i iVar = (i) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iVar;
    }
}
