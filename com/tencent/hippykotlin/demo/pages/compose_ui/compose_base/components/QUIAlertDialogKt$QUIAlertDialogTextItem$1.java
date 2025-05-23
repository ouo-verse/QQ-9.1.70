package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import bp3.k;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIAlertDialogKt$QUIAlertDialogTextItem$1 extends Lambda implements Function3<n, Composer, Integer, Unit> {
    public final /* synthetic */ String $text;
    public final /* synthetic */ k $textStyle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIAlertDialogKt$QUIAlertDialogTextItem$1(String str, k kVar) {
        super(3);
        this.$text = str;
        this.$textStyle = kVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(n nVar, Composer composer, Integer num) {
        Composer composer2 = composer;
        int intValue = num.intValue();
        if ((intValue & 81) == 16 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1407900958, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogTextItem.<anonymous> (QUIAlertDialog.kt:185)");
            }
            TextKt.a(this.$text, i.INSTANCE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.$textStyle, null, null, null, null, null, false, composer2, 64, 0, k.f28903n, 133169148);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
