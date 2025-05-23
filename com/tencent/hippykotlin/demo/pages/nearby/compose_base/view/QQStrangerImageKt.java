package com.tencent.hippykotlin.demo.pages.nearby.compose_base.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import n35.v;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQStrangerImageKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x006d  */
    /* renamed from: QQStrangerImage-CvonfEE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m114QQStrangerImageCvonfEE(final Function0<? extends Object> function0, int i3, i iVar, Composer composer, final int i16, final int i17) {
        int i18;
        int i19;
        int i26;
        i iVar2;
        Object rememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        String str;
        Composer composer2;
        final int i27;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1976881292);
        if ((i17 & 1) != 0) {
            i18 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i18 = i16 | (startRestartGroup.changed(function0) ? 4 : 2);
        } else {
            i18 = i16;
        }
        int i28 = i17 & 2;
        if (i28 != 0) {
            i18 |= 48;
        } else if ((i16 & 112) == 0) {
            i19 = i3;
            i18 |= startRestartGroup.changed(i19) ? 32 : 16;
            i26 = i17 & 4;
            if (i26 != 0) {
                i18 |= 128;
            }
            if (i26 != 4 && (i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                iVar2 = iVar;
                i27 = i19;
                composer2 = startRestartGroup;
            } else {
                int a16 = i28 == 0 ? h.INSTANCE.a() : i19;
                iVar2 = i26 == 0 ? i.INSTANCE : iVar;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1976881292, i18, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.QQStrangerImage (QQStrangerImage.kt:17)");
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0.invoke(), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) rememberedValue;
                if (!(mutableState.getValue() instanceof String)) {
                    Object value = mutableState.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                    str = (String) value;
                } else {
                    str = "";
                }
                ImageKt.a(str, null, null, null, null, iVar2, null, a16, null, null, null, null, null, null, null, null, null, null, null, null, null, startRestartGroup, ((i18 << 18) & 29360128) | 262144, 0, 0, 2096990);
                if (mutableState.getValue() instanceof v) {
                    composer2 = startRestartGroup;
                } else {
                    Unit unit = Unit.INSTANCE;
                    composer2 = startRestartGroup;
                    composer2.startReplaceableGroup(1157296644);
                    boolean changed = composer2.changed(mutableState);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new QQStrangerImageKt$QQStrangerImage$1$1(mutableState, null);
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer2, 64);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i27 = a16;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final i iVar3 = iVar2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.QQStrangerImageKt$QQStrangerImage$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer3, Integer num) {
                    num.intValue();
                    QQStrangerImageKt.m114QQStrangerImageCvonfEE(function0, i27, iVar3, composer3, i16 | 1, i17);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        i19 = i3;
        i26 = i17 & 4;
        if (i26 != 0) {
        }
        if (i26 != 4) {
        }
        if (i28 == 0) {
        }
        if (i26 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState = (MutableState) rememberedValue;
        if (!(mutableState.getValue() instanceof String)) {
        }
        ImageKt.a(str, null, null, null, null, iVar2, null, a16, null, null, null, null, null, null, null, null, null, null, null, null, null, startRestartGroup, ((i18 << 18) & 29360128) | 262144, 0, 0, 2096990);
        if (mutableState.getValue() instanceof v) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        i27 = a16;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
