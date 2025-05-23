package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.SwitchKt;
import com.tencent.ntcompose.material.ag;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUISwitchKt {
    public static final void QUISwitch(final boolean z16, final Function1<? super Boolean, Unit> function1, i iVar, Composer composer, final int i3, final int i16) {
        int i17;
        final i iVar2;
        Composer startRestartGroup = composer.startRestartGroup(881998773);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = i3 | (startRestartGroup.changed(z16) ? 4 : 2);
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(function1) ? 32 : 16;
        }
        int i18 = i16 & 4;
        if (i18 != 0) {
            i17 |= 128;
        }
        int i19 = i17;
        if (i18 == 4 && (i19 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            iVar2 = iVar;
        } else {
            i iVar3 = i18 != 0 ? i.INSTANCE : iVar;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(881998773, i19, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUISwitch (QUISwitch.kt:27)");
            }
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function1);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUISwitchKt$QUISwitch$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Boolean bool) {
                        boolean booleanValue = bool.booleanValue();
                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).callNativeMethod("shakeLight", null, null);
                        function1.invoke(Boolean.valueOf(booleanValue));
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            i iVar4 = iVar3;
            SwitchKt.a(z16, (Function1) rememberedValue, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar3, 47.0f), 26.0f), null, 5.0f, false, ag.f339378a.a(QUIToken.color$default("on_brand_primary"), QUIToken.color$default("on_brand_primary"), QUIToken.color$default("brand_standard"), QUIToken.color$default("fill_standard_secondary"), null, null, null, null, startRestartGroup, 134222408, 240), startRestartGroup, (i19 & 14) | 25088, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            iVar2 = iVar4;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUISwitchKt$QUISwitch$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUISwitchKt.QUISwitch(z16, function1, iVar2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
