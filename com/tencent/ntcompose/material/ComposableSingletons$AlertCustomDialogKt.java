package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ComposableSingletons$AlertCustomDialogKt {

    /* renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AlertCustomDialogKt f339341a = new ComposableSingletons$AlertCustomDialogKt();

    /* renamed from: b, reason: collision with root package name */
    public static Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit> f339342b = ComposableLambdaKt.composableLambdaInstance(-1278500478, false, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ComposableSingletons$AlertCustomDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer, Integer num) {
            invoke(bVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(com.tencent.ntcompose.foundation.layout.b AnimatedTransitionBox, Composer composer, int i3) {
            Intrinsics.checkNotNullParameter(AnimatedTransitionBox, "$this$AnimatedTransitionBox");
            if ((i3 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1278500478, i3, -1, "com.tencent.ntcompose.material.ComposableSingletons$AlertCustomDialogKt.lambda-1.<anonymous> (AlertCustomDialog.kt:83)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    public final Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit> a() {
        return f339342b;
    }
}
