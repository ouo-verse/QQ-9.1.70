package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdelieComposeUiCreator;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIScanningLightKt {
    public static final void QUIScanningLight(i iVar, final String str, Composer composer, final int i3, final int i16) {
        final i iVar2;
        Composer startRestartGroup = composer.startRestartGroup(1269102753);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if ((i16 & 2) != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if (i17 == 1 && (i18 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            iVar2 = iVar;
        } else {
            iVar2 = i17 != 0 ? i.INSTANCE : iVar;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1269102753, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIScanningLight (QUIScanningLight.kt:13)");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new k("scene", str, null, null, null, null, ScanningLightViewPropUpdater.INSTANCE, 60, null));
            ComposeNodeKt.a("ScanningLight", AdelieComposeUiCreator.INSTANCE, null, iVar2, arrayList, null, startRestartGroup, 37302, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIScanningLightKt$QUIScanningLight$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIScanningLightKt.QUIScanningLight(i.this, str, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
