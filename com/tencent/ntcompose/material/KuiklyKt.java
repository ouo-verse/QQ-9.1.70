package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a~\u0010\u000f\u001a\u00020\u00062B\b\u0002\u0010\t\u001a<\u0012\u0004\u0012\u00020\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007\u00a2\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u001f\u0010\u000e\u001a\u001b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00060\f\u00a2\u0006\u0002\b\bH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "content", "a", "(Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class KuiklyKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function2, com.tencent.ntcompose.core.i iVar, final Function1<? super ViewContainer<?, ?>, Unit> content, Composer composer, final int i3, final int i16) {
        Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function22;
        int i17;
        com.tencent.ntcompose.core.i iVar2;
        int i18;
        final Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function23;
        final com.tencent.ntcompose.core.i iVar3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-146039165);
        int i19 = i16 & 1;
        if (i19 != 0) {
            i17 = i3 | 6;
            function22 = function2;
        } else if ((i3 & 14) == 0) {
            function22 = function2;
            i17 = (startRestartGroup.changed(function22) ? 4 : 2) | i3;
        } else {
            function22 = function2;
            i17 = i3;
        }
        int i26 = i16 & 2;
        if (i26 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            iVar2 = iVar;
            i17 |= startRestartGroup.changed(iVar2) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i17 |= startRestartGroup.changed(content) ? 256 : 128;
            }
            i18 = i17;
            if ((i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) != 146 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                function23 = function22;
                iVar3 = iVar2;
            } else {
                Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function24 = i19 == 0 ? null : function22;
                com.tencent.ntcompose.core.i iVar4 = i26 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-146039165, i18, -1, "com.tencent.ntcompose.material.Kuikly (Kuikly.kt:57)");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.tencent.ntcompose.core.k("kuikly", content, null, null, null, null, u.f339447a, 60, null));
                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function24 != null ? null : function24, iVar4, arrayList, null, startRestartGroup, ((i18 << 6) & 7168) | 229430, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function23 = function24;
                iVar3 = iVar4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.KuiklyKt$Kuikly$1
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
                    KuiklyKt.a(function23, iVar3, content, composer2, i3 | 1, i16);
                }
            });
            return;
        }
        iVar2 = iVar;
        if ((i16 & 4) == 0) {
        }
        i18 = i17;
        if ((i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) != 146) {
        }
        if (i19 == 0) {
        }
        if (i26 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.tencent.ntcompose.core.k("kuikly", content, null, null, null, null, u.f339447a, 60, null));
        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function24 != null ? null : function24, iVar4, arrayList2, null, startRestartGroup, ((i18 << 6) & 7168) | 229430, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = function24;
        iVar3 = iVar4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
