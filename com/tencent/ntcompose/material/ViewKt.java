package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001at\u0010\u000f\u001a\u00020\u00062B\b\u0002\u0010\t\u001a<\u0012\u0004\u0012\u00020\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007\u00a2\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u00a2\u0006\u0002\b\rH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ViewKt {
    public static final void a(Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function2, com.tencent.ntcompose.core.i iVar, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i3, final int i16) {
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1459994076);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(function2) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i19 = i16 & 2;
        if (i19 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(iVar) ? 32 : 16;
        }
        int i26 = i16 & 4;
        if (i26 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            i17 |= startRestartGroup.changed(function22) ? 256 : 128;
        }
        if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                function2 = null;
            }
            if (i19 != 0) {
                iVar = com.tencent.ntcompose.core.i.INSTANCE;
            }
            if (i26 != 0) {
                function22 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459994076, i17, -1, "com.tencent.ntcompose.material.View (View.kt:31)");
            }
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function2 == null ? null : function2, iVar, null, function22, startRestartGroup, ((i17 << 6) & 7168) | 24630 | ((i17 << 9) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function23 = function2;
        final com.tencent.ntcompose.core.i iVar2 = iVar;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ViewKt$View$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i27) {
                ViewKt.a(function23, iVar2, function24, composer2, i3 | 1, i16);
            }
        });
    }
}
