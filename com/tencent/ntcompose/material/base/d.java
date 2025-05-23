package com.tencent.ntcompose.material.base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\t\u001a\u00020\u0000*\u00020\u00002&\u0010\b\u001a\"\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u00a2\u0006\u0002\b\u0007H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/material/base/b;", "Lkotlin/ParameterName;", "name", "modifierRef", "", "Landroidx/compose/runtime/Composable;", "ref", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Lcom/tencent/ntcompose/core/i;", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {
    public static final i a(i iVar, Function3<? super b, ? super Composer, ? super Integer, Unit> ref, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(ref, "ref");
        composer.startReplaceableGroup(-1286769527);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1286769527, i3, -1, "com.tencent.ntcompose.material.base.modifierRef (ModifierRef.kt:14)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new c();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        c cVar = (c) rememberedValue;
        ref.invoke(cVar, composer, Integer.valueOf((i3 & 112) | 8));
        i c16 = com.tencent.ntcompose.core.ModifiersKt.c(iVar, "modifierRef", cVar, null, null, null, null, e.f339411a, 60, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return c16;
    }
}
