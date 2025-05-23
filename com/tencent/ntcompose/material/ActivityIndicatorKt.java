package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "", "isGrayStyle", "", "a", "(Lcom/tencent/ntcompose/core/i;ZLandroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ActivityIndicatorKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, boolean z16, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        boolean z17;
        final com.tencent.ntcompose.core.i iVar3;
        final boolean z18;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1415261244);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
            iVar2 = iVar;
        } else if ((i3 & 14) == 0) {
            iVar2 = iVar;
            i17 = (startRestartGroup.changed(iVar2) ? 4 : 2) | i3;
        } else {
            iVar2 = iVar;
            i17 = i3;
        }
        int i19 = i16 & 2;
        if (i19 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            z17 = z16;
            i17 |= startRestartGroup.changed(z17) ? 32 : 16;
            if ((i17 & 91) != 18 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                iVar3 = iVar2;
                z18 = z17;
            } else {
                iVar3 = i18 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                z18 = i19 == 0 ? false : z17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1415261244, i3, -1, "com.tencent.ntcompose.material.ActivityIndicator (ActivityIndicator.kt:41)");
                }
                com.tencent.ntcompose.core.i u16 = ComposeLayoutPropUpdaterKt.u(iVar3, 20.0f);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.tencent.ntcompose.core.k("isGrayStyle", Boolean.valueOf(z18), null, null, null, null, b.f339407a, 60, null));
                startRestartGroup.startMovableGroup(-303170834, Boolean.valueOf(z18));
                ComposeNodeKt.a("activity_indicator", com.tencent.ntcompose.material.base.a.f339408a, null, u16, arrayList, null, startRestartGroup, 33206, 32);
                startRestartGroup.endMovableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ActivityIndicatorKt$ActivityIndicator$1
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

                public final void invoke(Composer composer2, int i26) {
                    ActivityIndicatorKt.a(com.tencent.ntcompose.core.i.this, z18, composer2, i3 | 1, i16);
                }
            });
            return;
        }
        z17 = z16;
        if ((i17 & 91) != 18) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        com.tencent.ntcompose.core.i u162 = ComposeLayoutPropUpdaterKt.u(iVar3, 20.0f);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.tencent.ntcompose.core.k("isGrayStyle", Boolean.valueOf(z18), null, null, null, null, b.f339407a, 60, null));
        startRestartGroup.startMovableGroup(-303170834, Boolean.valueOf(z18));
        ComposeNodeKt.a("activity_indicator", com.tencent.ntcompose.material.base.a.f339408a, null, u162, arrayList2, null, startRestartGroup, 33206, 32);
        startRestartGroup.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
