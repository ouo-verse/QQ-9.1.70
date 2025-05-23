package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTBorderImageKt {
    /* renamed from: QQFTBorderImage-aj-Xzr8, reason: not valid java name */
    public static final void m123QQFTBorderImageajXzr8(final String str, final int i3, final float f16, final float f17, final h hVar, BorderStyle borderStyle, i iVar, String str2, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(1697231192);
        BorderStyle borderStyle2 = (i17 & 32) != 0 ? BorderStyle.SOLID : borderStyle;
        i iVar2 = (i17 & 64) != 0 ? i.INSTANCE : iVar;
        String str3 = (i17 & 128) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1697231192, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBorderImage (QQFTBorderImage.kt:21)");
        }
        final String str4 = str3;
        final BorderStyle borderStyle3 = borderStyle2;
        BoxKt.a(iVar2, Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2124866158, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBorderImageKt$QQFTBorderImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2124866158, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBorderImage.<anonymous> (QQFTBorderImage.kt:34)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), c.a(f16 + 1.0f));
                    String str5 = str;
                    String str6 = str4;
                    int i18 = i3;
                    int i19 = i16;
                    ImageKt.a(str5, null, str6, null, null, q16, null, i18, null, null, null, null, null, "data:image/png;base64,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", null, null, null, null, null, null, null, composer3, (i19 & 14) | 262144 | ((i19 >> 15) & 896) | ((i19 << 18) & 29360128), 3072, 0, 2088794);
                    BoxKt.a(ModifiersKt.f(ModifiersKt.q(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), c.a(f16)), f17, hVar, borderStyle3), null, null, null, composer3, 8, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final BorderStyle borderStyle4 = borderStyle2;
        final i iVar3 = iVar2;
        final String str5 = str3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBorderImageKt$QQFTBorderImage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTBorderImageKt.m123QQFTBorderImageajXzr8(str, i3, f16, f17, hVar, borderStyle4, iVar3, str5, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }
}
