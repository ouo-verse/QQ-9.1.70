package com.tencent.hippykotlin.demo.pages.adelie.common.compose.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView;
import com.tencent.kuikly.core.base.aa;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieAudioRecordFrequencyViewKt {
    public static final void AdelieAudioRecordFrequencyView(final i iVar, final Function2<? super AdelieAudioRecordFrequencyView, ? super aa<AdelieAudioRecordFrequencyView>, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(66364529);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        int i19 = i16 & 2;
        if (i19 != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if (i17 == 1 && (i18 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i17 != 0) {
                iVar = i.INSTANCE;
            }
            if (i19 != 0) {
                function2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(66364529, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.AdelieAudioRecordFrequencyView (AdelieAudioRecordFrequencyView.kt:13)");
            }
            ComposeNodeKt.a("AudioRecordFrequency", AdelieComposeViewCreator.INSTANCE, function2 == null ? null : function2, iVar, new ArrayList(), null, startRestartGroup, 36918, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.AdelieAudioRecordFrequencyViewKt$AdelieAudioRecordFrequencyView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieAudioRecordFrequencyViewKt.AdelieAudioRecordFrequencyView(i.this, function2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
