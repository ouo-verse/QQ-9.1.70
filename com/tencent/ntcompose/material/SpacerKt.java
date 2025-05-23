package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.ComposeNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "", "a", "(Lcom/tencent/ntcompose/core/i;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SpacerKt {
    public static final void a(final com.tencent.ntcompose.core.i iVar, Composer composer, final int i3, final int i16) {
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(633629058);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(iVar) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i17 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                iVar = com.tencent.ntcompose.core.i.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(633629058, i17, -1, "com.tencent.ntcompose.material.Spacer (Spacer.kt:42)");
            }
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, null, iVar, null, null, startRestartGroup, ((i17 << 9) & 7168) | 25014, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SpacerKt$Spacer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i19) {
                SpacerKt.a(com.tencent.ntcompose.core.i.this, composer2, i3 | 1, i16);
            }
        });
    }
}
