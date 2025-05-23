package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdelieComposeUiCreator;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QRCodeViewKt {
    public static final void QRCodeView(final i iVar, Function2<? super QRCodeView, ? super aa<QRCodeView>, Unit> function2, String str, float f16, h hVar, h hVar2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(286576497);
        Function2<? super QRCodeView, ? super aa<QRCodeView>, Unit> function22 = (i16 & 2) != 0 ? null : function2;
        String str2 = (i16 & 4) != 0 ? null : str;
        float f17 = (i16 & 8) != 0 ? 200.0f : f16;
        h b16 = (i16 & 16) != 0 ? h.INSTANCE.b() : hVar;
        h m3 = (i16 & 32) != 0 ? h.INSTANCE.m() : hVar2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286576497, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QRCodeView (QRCodeView.kt:17)");
        }
        ArrayList arrayList = new ArrayList();
        Float valueOf = Float.valueOf(f17);
        QRCodeViewPropUpdater qRCodeViewPropUpdater = QRCodeViewPropUpdater.INSTANCE;
        arrayList.add(new k("qrCodeUrl", str2, valueOf, null, null, null, qRCodeViewPropUpdater, 56, null));
        arrayList.add(new k("qrCodeSize", b16, m3, null, null, null, qRCodeViewPropUpdater, 56, null));
        ComposeNodeKt.a("QRCode", AdelieComposeUiCreator.INSTANCE, function22 == null ? null : function22, iVar, arrayList, null, startRestartGroup, 36918, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function2<? super QRCodeView, ? super aa<QRCodeView>, Unit> function23 = function22;
        final String str3 = str2;
        final float f18 = f17;
        final h hVar3 = b16;
        final h hVar4 = m3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QRCodeViewKt$QRCodeView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QRCodeViewKt.QRCodeView(i.this, function23, str3, f18, hVar3, hVar4, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
