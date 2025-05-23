package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.foundation.layout.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTPlaceHolderCardVMKt {
    public static final ComposableSingletons$QQFTPlaceHolderCardVMKt INSTANCE = new ComposableSingletons$QQFTPlaceHolderCardVMKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f157lambda1 = ComposableLambdaKt.composableLambdaInstance(1106754209, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.ComposableSingletons$QQFTPlaceHolderCardVMKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1106754209, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.ComposableSingletons$QQFTPlaceHolderCardVMKt.lambda-1.<anonymous> (QQFTPlaceHolderCardVM.kt:37)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
