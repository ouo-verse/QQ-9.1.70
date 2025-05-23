package com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.base.aa;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class IntimateSpaceFilamentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IntimateSpaceComposeFilamentView(i iVar, Function2<? super IntimateSpaceFilamentView, ? super aa<IntimateSpaceFilamentView>, Unit> function2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        Function2<? super IntimateSpaceFilamentView, ? super aa<IntimateSpaceFilamentView>, Unit> function22;
        i iVar2;
        Function2<? super IntimateSpaceFilamentView, ? super aa<IntimateSpaceFilamentView>, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1255966695);
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
                i18 |= startRestartGroup.changed(function0) ? 256 : 128;
                if ((i16 & 8) != 0) {
                    i18 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    i18 |= startRestartGroup.changed(function02) ? 2048 : 1024;
                }
                if (i17 != 1 && (i18 & 5851) == 1170 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    iVar2 = iVar;
                    function23 = function22;
                } else {
                    iVar2 = i17 != 0 ? i.INSTANCE : iVar;
                    function23 = i19 != 0 ? null : function22;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1255966695, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceComposeFilamentView (IntimateSpaceFilamentView.kt:18)");
                    }
                    ArrayList arrayList = new ArrayList();
                    IntimateSpaceFilamentViewPropUpdater intimateSpaceFilamentViewPropUpdater = IntimateSpaceFilamentViewPropUpdater.INSTANCE;
                    arrayList.add(new k("onMessageChannelReady", function0, null, null, null, null, intimateSpaceFilamentViewPropUpdater, 60, null));
                    arrayList.add(new k("onSceneReady", function02, null, null, null, null, intimateSpaceFilamentViewPropUpdater, 60, null));
                    ComposeNodeKt.a("FilamentView", IntimateSpaceComposeViewCreator.INSTANCE, function23 != null ? function23 : null, iVar2, arrayList, null, startRestartGroup, 36918, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                final i iVar3 = iVar2;
                final Function2<? super IntimateSpaceFilamentView, ? super aa<IntimateSpaceFilamentView>, Unit> function24 = function23;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceFilamentViewKt$IntimateSpaceComposeFilamentView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        IntimateSpaceFilamentViewKt.IntimateSpaceComposeFilamentView(i.this, function24, function0, function02, composer2, i3 | 1, i16);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            if ((i16 & 8) != 0) {
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
            IntimateSpaceFilamentViewPropUpdater intimateSpaceFilamentViewPropUpdater2 = IntimateSpaceFilamentViewPropUpdater.INSTANCE;
            arrayList2.add(new k("onMessageChannelReady", function0, null, null, null, null, intimateSpaceFilamentViewPropUpdater2, 60, null));
            arrayList2.add(new k("onSceneReady", function02, null, null, null, null, intimateSpaceFilamentViewPropUpdater2, 60, null));
            ComposeNodeKt.a("FilamentView", IntimateSpaceComposeViewCreator.INSTANCE, function23 != null ? function23 : null, iVar2, arrayList2, null, startRestartGroup, 36918, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function22 = function2;
        if ((i16 & 4) == 0) {
        }
        if ((i16 & 8) != 0) {
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
        IntimateSpaceFilamentViewPropUpdater intimateSpaceFilamentViewPropUpdater22 = IntimateSpaceFilamentViewPropUpdater.INSTANCE;
        arrayList22.add(new k("onMessageChannelReady", function0, null, null, null, null, intimateSpaceFilamentViewPropUpdater22, 60, null));
        arrayList22.add(new k("onSceneReady", function02, null, null, null, null, intimateSpaceFilamentViewPropUpdater22, 60, null));
        ComposeNodeKt.a("FilamentView", IntimateSpaceComposeViewCreator.INSTANCE, function23 != null ? function23 : null, iVar2, arrayList22, null, startRestartGroup, 36918, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
