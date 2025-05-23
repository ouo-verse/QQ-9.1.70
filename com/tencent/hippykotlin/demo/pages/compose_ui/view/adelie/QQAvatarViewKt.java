package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQAvatarView;
import com.tencent.kuikly.core.base.aa;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQAvatarViewKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QQAvatarView(i iVar, Function2<? super QQAvatarView, ? super aa<QQAvatarView>, Unit> function2, final String str, Composer composer, final int i3, final int i16) {
        Function2<? super QQAvatarView, ? super aa<QQAvatarView>, Unit> function22;
        i iVar2;
        Function2<? super QQAvatarView, ? super aa<QQAvatarView>, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(761619850);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        int i19 = i16 & 2;
        if (i19 != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            function22 = function2;
            i18 |= startRestartGroup.changed(function22) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i18 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i18 |= startRestartGroup.changed(str) ? 256 : 128;
                if (i17 != 1 && (i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    iVar2 = iVar;
                    function23 = function22;
                } else {
                    iVar2 = i17 != 0 ? i.INSTANCE : iVar;
                    function23 = i19 != 0 ? null : function22;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(761619850, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarView (QQAvatarView.kt:14)");
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k("load", str, null, null, null, null, QQAvatarViewPropUpdater.INSTANCE, 60, null));
                    ComposeNodeKt.a("QQAvatar", AdelieComposeUiCreator.INSTANCE, function23 != null ? function23 : null, iVar2, arrayList, null, startRestartGroup, 36918, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                final i iVar3 = iVar2;
                final Function2<? super QQAvatarView, ? super aa<QQAvatarView>, Unit> function24 = function23;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt$QQAvatarView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        QQAvatarViewKt.QQAvatarView(i.this, function24, str, composer2, i3 | 1, i16);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            if (i17 != 1) {
            }
            if (i17 != 0) {
            }
            if (i19 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new k("load", str, null, null, null, null, QQAvatarViewPropUpdater.INSTANCE, 60, null));
            ComposeNodeKt.a("QQAvatar", AdelieComposeUiCreator.INSTANCE, function23 != null ? function23 : null, iVar2, arrayList2, null, startRestartGroup, 36918, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function22 = function2;
        if ((i16 & 4) == 0) {
        }
        if (i17 != 1) {
        }
        if (i17 != 0) {
        }
        if (i19 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList22 = new ArrayList();
        arrayList22.add(new k("load", str, null, null, null, null, QQAvatarViewPropUpdater.INSTANCE, 60, null));
        ComposeNodeKt.a("QQAvatar", AdelieComposeUiCreator.INSTANCE, function23 != null ? function23 : null, iVar2, arrayList22, null, startRestartGroup, 36918, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
