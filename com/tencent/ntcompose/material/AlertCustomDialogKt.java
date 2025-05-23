package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00a8\u0001\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000e2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0011H\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\u0017"}, d2 = {"", "showDialog", "dialogInWindow", "Lcom/tencent/kuikly/core/base/h;", "dialogBackgroundColor", "Lkotlin/Function0;", "", "dialogBackgroundClick", "Lcom/tencent/ntcompose/material/AlertDialogTransitionType;", "alertTransitionType", "onDismiss", "onDidShow", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "contentAlignInDialog", "Lcom/tencent/ntcompose/animation/a;", "showWithAnimationSpec", "hideWithAnimationSpec", "Landroidx/compose/runtime/Composable;", "customContent", "a", "(ZZLcom/tencent/kuikly/core/base/h;Lkotlin/jvm/functions/Function0;Lcom/tencent/ntcompose/material/AlertDialogTransitionType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/tencent/ntcompose/foundation/layout/base/Alignment;Lcom/tencent/ntcompose/animation/a;Lcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Lcom/tencent/ntcompose/material/AnimatedTransitionType;", "c", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AlertCustomDialogKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339338a;

        static {
            int[] iArr = new int[AlertDialogTransitionType.values().length];
            try {
                iArr[AlertDialogTransitionType.DIRECTION_FROM_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlertDialogTransitionType.DIRECTION_FROM_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AlertDialogTransitionType.DIRECTION_FROM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AlertDialogTransitionType.DIRECTION_FROM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AlertDialogTransitionType.DIRECTION_FROM_BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AlertDialogTransitionType.FADE_IN_OUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f339338a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final boolean z16, boolean z17, com.tencent.kuikly.core.base.h hVar, Function0<Unit> function0, AlertDialogTransitionType alertDialogTransitionType, final Function0<Unit> onDismiss, Function0<Unit> function02, Alignment alignment, com.tencent.ntcompose.animation.a<Boolean> aVar, com.tencent.ntcompose.animation.a<Boolean> aVar2, final Function2<? super Composer, ? super Integer, Unit> customContent, Composer composer, final int i3, final int i16, final int i17) {
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        com.tencent.kuikly.core.base.h hVar2;
        com.tencent.ntcompose.animation.a<Boolean> aVar3;
        com.tencent.ntcompose.animation.a<Boolean> aVar4;
        int i39;
        Alignment alignment2;
        boolean z18;
        com.tencent.kuikly.core.base.h hVar3;
        Function0<Unit> function03;
        AlertDialogTransitionType alertDialogTransitionType2;
        Function0<Unit> function04;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        Composer composer2;
        final boolean z19;
        final com.tencent.kuikly.core.base.h hVar4;
        final Function0<Unit> function05;
        final AlertDialogTransitionType alertDialogTransitionType3;
        final Function0<Unit> function06;
        final Alignment alignment3;
        final com.tencent.ntcompose.animation.a<Boolean> aVar5;
        final com.tencent.ntcompose.animation.a<Boolean> aVar6;
        ScopeUpdateScope endRestartGroup;
        int i46;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(customContent, "customContent");
        Composer startRestartGroup = composer.startRestartGroup(794970132);
        if ((i17 & 1) != 0) {
            i18 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i18 = (startRestartGroup.changed(z16) ? 4 : 2) | i3;
        } else {
            i18 = i3;
        }
        int i47 = i17 & 2;
        if (i47 != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(z17) ? 32 : 16;
            i19 = i17 & 4;
            if (i19 != 0) {
                i18 |= 128;
            }
            i26 = i17 & 8;
            if (i26 == 0) {
                i18 |= 3072;
            } else if ((i3 & 7168) == 0) {
                i18 |= startRestartGroup.changed(function0) ? 2048 : 1024;
                i27 = i17 & 16;
                if (i27 != 0) {
                    i18 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i18 |= startRestartGroup.changed(alertDialogTransitionType) ? 16384 : 8192;
                }
                if ((i17 & 32) == 0) {
                    i46 = (i3 & 458752) == 0 ? startRestartGroup.changed(onDismiss) ? 131072 : 65536 : 196608;
                    i28 = i17 & 64;
                    if (i28 == 0) {
                        i18 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        i18 |= startRestartGroup.changed(function02) ? 1048576 : 524288;
                    }
                    i29 = i17 & 128;
                    if (i29 == 0) {
                        i18 |= 12582912;
                    } else if ((i3 & 29360128) == 0) {
                        i18 |= startRestartGroup.changed(alignment) ? 8388608 : 4194304;
                    }
                    i36 = i17 & 256;
                    if (i36 == 0) {
                        i18 |= 100663296;
                    } else if ((i3 & 234881024) == 0) {
                        i18 |= startRestartGroup.changed(aVar) ? 67108864 : 33554432;
                    }
                    i37 = i17 & 512;
                    if (i37 == 0) {
                        i18 |= 805306368;
                    } else if ((i3 & 1879048192) == 0) {
                        i18 |= startRestartGroup.changed(aVar2) ? 536870912 : 268435456;
                    }
                    if ((i17 & 1024) == 0) {
                        i38 = i16 | 6;
                    } else if ((i16 & 14) == 0) {
                        i38 = i16 | (startRestartGroup.changed(customContent) ? 4 : 2);
                    } else {
                        i38 = i16;
                    }
                    if (i19 != 4 && (1533916891 & i18) == 306783378 && (i38 & 11) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        z19 = z17;
                        hVar4 = hVar;
                        function05 = function0;
                        alertDialogTransitionType3 = alertDialogTransitionType;
                        function06 = function02;
                        alignment3 = alignment;
                        aVar5 = aVar;
                        aVar6 = aVar2;
                        composer2 = startRestartGroup;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if (i19 != 0) {
                                i18 &= -897;
                            }
                            z18 = z17;
                            hVar3 = hVar;
                            function03 = function0;
                            alertDialogTransitionType2 = alertDialogTransitionType;
                            function04 = function02;
                            alignment2 = alignment;
                            aVar4 = aVar;
                            aVar3 = aVar2;
                            i39 = i18;
                        } else {
                            boolean z26 = i47 == 0 ? true : z17;
                            if (i19 == 0) {
                                hVar2 = com.tencent.kuikly.core.base.h.INSTANCE.a(0.4f);
                                i18 &= -897;
                            } else {
                                hVar2 = hVar;
                            }
                            Function0<Unit> function07 = i26 == 0 ? null : function0;
                            AlertDialogTransitionType alertDialogTransitionType4 = i27 == 0 ? AlertDialogTransitionType.DIRECTION_FROM_CENTER : alertDialogTransitionType;
                            Function0<Unit> function08 = i28 == 0 ? null : function02;
                            Alignment alignment4 = i29 == 0 ? Alignment.Center : alignment;
                            com.tencent.ntcompose.animation.a<Boolean> d16 = i36 == 0 ? com.tencent.ntcompose.animation.b.d(250, 0, com.tencent.ntcompose.animation.i.b(), null, 10, null) : aVar;
                            if (i37 == 0) {
                                aVar4 = d16;
                                i39 = i18;
                                alignment2 = alignment4;
                                aVar3 = com.tencent.ntcompose.animation.b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
                            } else {
                                aVar3 = aVar2;
                                aVar4 = d16;
                                i39 = i18;
                                alignment2 = alignment4;
                            }
                            z18 = z26;
                            hVar3 = hVar2;
                            function03 = function07;
                            alertDialogTransitionType2 = alertDialogTransitionType4;
                            function04 = function08;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(794970132, i39, i38, "com.tencent.ntcompose.material.AlertCustomDialog (AlertCustomDialog.kt:45)");
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) rememberedValue;
                        if (z16 && !((Boolean) mutableState.getValue()).booleanValue()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                            if (endRestartGroup2 == null) {
                                return;
                            }
                            final boolean z27 = z18;
                            final com.tencent.kuikly.core.base.h hVar5 = hVar3;
                            final Function0<Unit> function09 = function03;
                            final AlertDialogTransitionType alertDialogTransitionType5 = alertDialogTransitionType2;
                            final Function0<Unit> function010 = function04;
                            final Alignment alignment5 = alignment2;
                            final com.tencent.ntcompose.animation.a<Boolean> aVar7 = aVar4;
                            final com.tencent.ntcompose.animation.a<Boolean> aVar8 = aVar3;
                            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i48) {
                                    AlertCustomDialogKt.a(z16, z27, hVar5, function09, alertDialogTransitionType5, onDismiss, function010, alignment5, aVar7, aVar8, customContent, composer3, i3 | 1, i16, i17);
                                }
                            });
                            return;
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState mutableState2 = (MutableState) rememberedValue2;
                        Boolean valueOf = Boolean.valueOf(z16);
                        Boolean valueOf2 = Boolean.valueOf(z16);
                        startRestartGroup.startReplaceableGroup(511388516);
                        changed = startRestartGroup.changed(valueOf2) | startRestartGroup.changed(mutableState2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                    mutableState2.setValue(Boolean.valueOf(z16));
                                    return new a();
                                }

                                /* compiled from: P */
                                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                                /* loaded from: classes34.dex */
                                public static final class a implements DisposableEffectResult {
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, i39 & 14);
                        final com.tencent.kuikly.core.base.h hVar6 = hVar3;
                        final Function0<Unit> function011 = function03;
                        final int i48 = i38;
                        final int i49 = i39;
                        final com.tencent.ntcompose.animation.a<Boolean> aVar9 = aVar4;
                        final com.tencent.ntcompose.animation.a<Boolean> aVar10 = aVar3;
                        final Alignment alignment6 = alignment2;
                        int i56 = i39;
                        composer2 = startRestartGroup;
                        final AlertDialogTransitionType alertDialogTransitionType6 = alertDialogTransitionType2;
                        final Function0<Unit> function012 = function04;
                        ModalKt.a(null, z18, null, null, ComposableLambdaKt.composableLambda(composer2, 774380434, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i57) {
                                if ((i57 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(774380434, i57, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous> (AlertCustomDialog.kt:67)");
                                }
                                com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                final com.tencent.kuikly.core.base.h hVar7 = com.tencent.kuikly.core.base.h.this;
                                final Function0<Unit> function013 = function011;
                                final MutableState<Boolean> mutableState3 = mutableState2;
                                final int i58 = i49;
                                final com.tencent.ntcompose.animation.a<Boolean> aVar11 = aVar9;
                                final com.tencent.ntcompose.animation.a<Boolean> aVar12 = aVar10;
                                final Alignment alignment7 = alignment6;
                                final MutableState<Boolean> mutableState4 = mutableState;
                                final AlertDialogTransitionType alertDialogTransitionType7 = alertDialogTransitionType6;
                                final Function0<Unit> function014 = onDismiss;
                                final Function0<Unit> function015 = function012;
                                final Function2<Composer, Integer, Unit> function2 = customContent;
                                final int i59 = i48;
                                BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, -805424948, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num) {
                                        invoke(bVar, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer4, int i65) {
                                        int i66;
                                        AnimatedTransitionType c16;
                                        com.tencent.ntcompose.core.i iVar;
                                        int i67;
                                        float f16;
                                        Intrinsics.checkNotNullParameter(Box, "$this$Box");
                                        if ((i65 & 14) == 0) {
                                            i66 = (composer4.changed(Box) ? 4 : 2) | i65;
                                        } else {
                                            i66 = i65;
                                        }
                                        if ((i66 & 91) == 18 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-805424948, i65, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous> (AlertCustomDialog.kt:68)");
                                        }
                                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                        com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), com.tencent.kuikly.core.base.h.this);
                                        final Function0<Unit> function016 = function013;
                                        final MutableState<Boolean> mutableState5 = mutableState3;
                                        composer4.startReplaceableGroup(511388516);
                                        boolean changed2 = composer4.changed(function016) | composer4.changed(mutableState5);
                                        Object rememberedValue4 = composer4.rememberedValue();
                                        if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                    invoke2(clickParams);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(ClickParams it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    Function0<Unit> function017 = function016;
                                                    if (function017 != null) {
                                                        function017.invoke();
                                                    } else {
                                                        mutableState5.setValue(Boolean.FALSE);
                                                    }
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue4);
                                        }
                                        composer4.endReplaceableGroup();
                                        com.tencent.ntcompose.core.i d17 = ViewEventPropUpdaterKt.d(c17, false, null, (Function1) rememberedValue4, 3, null);
                                        boolean booleanValue = mutableState3.getValue().booleanValue();
                                        AnimatedTransitionType animatedTransitionType = AnimatedTransitionType.FADE_IN_OUT;
                                        com.tencent.ntcompose.animation.a<Boolean> aVar13 = aVar11;
                                        com.tencent.ntcompose.animation.a<Boolean> aVar14 = aVar12;
                                        Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit> a16 = ComposableSingletons$AlertCustomDialogKt.f339341a.a();
                                        int i68 = i58;
                                        AnimatedTransitionBoxKt.a(d17, null, animatedTransitionType, booleanValue, null, aVar13, aVar14, a16, composer4, ((i68 >> 9) & 458752) | 12583296 | ((i68 >> 9) & 3670016), 18);
                                        com.tencent.ntcompose.core.i b16 = ModifiersKt.b(ModifiersKt.M(ComposeLayoutPropUpdaterKt.j(Box.a(companion2, alignment7), 0.0f, 1, null), mutableState4.getValue().booleanValue()), 1.0f);
                                        c16 = AlertCustomDialogKt.c(alertDialogTransitionType7);
                                        boolean booleanValue2 = mutableState3.getValue().booleanValue();
                                        if (alertDialogTransitionType7 == AlertDialogTransitionType.DIRECTION_FROM_CENTER) {
                                            if (mutableState3.getValue().booleanValue()) {
                                                f16 = 0.7f;
                                                i67 = 2;
                                            } else {
                                                i67 = 2;
                                                f16 = 0.8f;
                                            }
                                            iVar = ModifiersKt.b(ModifiersKt.J(companion2, f16, null, i67, null), 0.0f);
                                        } else {
                                            iVar = null;
                                        }
                                        final MutableState<Boolean> mutableState6 = mutableState4;
                                        final Function0<Unit> function017 = function014;
                                        final Function0<Unit> function018 = function015;
                                        composer4.startReplaceableGroup(1618982084);
                                        boolean changed3 = composer4.changed(mutableState6) | composer4.changed(function017) | composer4.changed(function018);
                                        Object rememberedValue5 = composer4.rememberedValue();
                                        if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                    invoke(bool.booleanValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(boolean z28) {
                                                    if (!z28) {
                                                        mutableState6.setValue(Boolean.FALSE);
                                                        function017.invoke();
                                                        return;
                                                    }
                                                    mutableState6.setValue(Boolean.TRUE);
                                                    Function0<Unit> function019 = function018;
                                                    if (function019 != null) {
                                                        function019.invoke();
                                                    }
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue5);
                                        }
                                        composer4.endReplaceableGroup();
                                        Function1 function1 = (Function1) rememberedValue5;
                                        com.tencent.ntcompose.animation.a<Boolean> aVar15 = aVar11;
                                        com.tencent.ntcompose.animation.a<Boolean> aVar16 = aVar12;
                                        final Alignment alignment8 = alignment7;
                                        final Function2<Composer, Integer, Unit> function22 = function2;
                                        final int i69 = i59;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 168233003, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer5, Integer num) {
                                                invoke(bVar, composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(com.tencent.ntcompose.foundation.layout.b AnimatedTransitionBox, Composer composer5, int i75) {
                                                Intrinsics.checkNotNullParameter(AnimatedTransitionBox, "$this$AnimatedTransitionBox");
                                                if ((i75 & 81) == 16 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(168233003, i75, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:105)");
                                                }
                                                Alignment.Horizontal horizontal = Alignment.Horizontal.Start;
                                                Alignment alignment9 = Alignment.this;
                                                if (alignment9 != Alignment.TopCenter && alignment9 != Alignment.Center && alignment9 != Alignment.BottomCenter) {
                                                    if (alignment9 == Alignment.TopEnd || alignment9 == Alignment.CenterEnd || alignment9 == Alignment.BottomEnd) {
                                                        horizontal = Alignment.Horizontal.End;
                                                    }
                                                } else {
                                                    horizontal = Alignment.Horizontal.CenterHorizontally;
                                                }
                                                com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                                final Function2<Composer, Integer, Unit> function23 = function22;
                                                final int i76 = i69;
                                                ColumnKt.a(j3, null, horizontal, null, ComposableLambdaKt.composableLambda(composer5, -2061423084, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer6, Integer num) {
                                                        invoke(dVar, composer6, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(com.tencent.ntcompose.foundation.layout.d Column, Composer composer6, int i77) {
                                                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                                        if ((i77 & 81) == 16 && composer6.getSkipping()) {
                                                            composer6.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2061423084, i77, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:112)");
                                                        }
                                                        function23.invoke(composer6, Integer.valueOf(i76 & 14));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer5, 24576, 10);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        int i75 = i58;
                                        AnimatedTransitionBoxKt.a(b16, iVar, c16, booleanValue2, function1, aVar15, aVar16, composableLambda, composer4, ((i75 >> 9) & 458752) | 12582912 | ((i75 >> 9) & 3670016), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 3072, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i56 & 112) | 24576, 13);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z19 = z18;
                        hVar4 = hVar3;
                        function05 = function03;
                        alertDialogTransitionType3 = alertDialogTransitionType2;
                        function06 = function04;
                        alignment3 = alignment2;
                        aVar5 = aVar4;
                        aVar6 = aVar3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i57) {
                            AlertCustomDialogKt.a(z16, z19, hVar4, function05, alertDialogTransitionType3, onDismiss, function06, alignment3, aVar5, aVar6, customContent, composer3, i3 | 1, i16, i17);
                        }
                    });
                    return;
                }
                i18 |= i46;
                i28 = i17 & 64;
                if (i28 == 0) {
                }
                i29 = i17 & 128;
                if (i29 == 0) {
                }
                i36 = i17 & 256;
                if (i36 == 0) {
                }
                i37 = i17 & 512;
                if (i37 == 0) {
                }
                if ((i17 & 1024) == 0) {
                }
                if (i19 != 4) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i47 == 0) {
                }
                if (i19 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                if (i29 == 0) {
                }
                if (i36 == 0) {
                }
                if (i37 == 0) {
                }
                z18 = z26;
                hVar3 = hVar2;
                function03 = function07;
                alertDialogTransitionType2 = alertDialogTransitionType4;
                function04 = function08;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) rememberedValue;
                if (z16) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState22 = (MutableState) rememberedValue2;
                Boolean valueOf3 = Boolean.valueOf(z16);
                Boolean valueOf22 = Boolean.valueOf(z16);
                startRestartGroup.startReplaceableGroup(511388516);
                changed = startRestartGroup.changed(valueOf22) | startRestartGroup.changed(mutableState22);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        mutableState22.setValue(Boolean.valueOf(z16));
                        return new a();
                    }

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes34.dex */
                    public static final class a implements DisposableEffectResult {
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(valueOf3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, i39 & 14);
                final com.tencent.kuikly.core.base.h hVar62 = hVar3;
                final Function0<Unit> function0112 = function03;
                final int i482 = i38;
                final int i492 = i39;
                final com.tencent.ntcompose.animation.a<Boolean> aVar92 = aVar4;
                final com.tencent.ntcompose.animation.a<Boolean> aVar102 = aVar3;
                final Alignment alignment62 = alignment2;
                int i562 = i39;
                composer2 = startRestartGroup;
                final AlertDialogTransitionType alertDialogTransitionType62 = alertDialogTransitionType2;
                final Function0<Unit> function0122 = function04;
                ModalKt.a(null, z18, null, null, ComposableLambdaKt.composableLambda(composer2, 774380434, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i57) {
                        if ((i57 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(774380434, i57, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous> (AlertCustomDialog.kt:67)");
                        }
                        com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                        final com.tencent.kuikly.core.base.h hVar7 = com.tencent.kuikly.core.base.h.this;
                        final Function0<Unit> function013 = function0112;
                        final MutableState<Boolean> mutableState3 = mutableState22;
                        final int i58 = i492;
                        final com.tencent.ntcompose.animation.a<Boolean> aVar11 = aVar92;
                        final com.tencent.ntcompose.animation.a<Boolean> aVar12 = aVar102;
                        final Alignment alignment7 = alignment62;
                        final MutableState<Boolean> mutableState4 = mutableState;
                        final AlertDialogTransitionType alertDialogTransitionType7 = alertDialogTransitionType62;
                        final Function0<Unit> function014 = onDismiss;
                        final Function0<Unit> function015 = function0122;
                        final Function2<? super Composer, ? super Integer, Unit> function2 = customContent;
                        final int i59 = i482;
                        BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, -805424948, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num) {
                                invoke(bVar, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer4, int i65) {
                                int i66;
                                AnimatedTransitionType c16;
                                com.tencent.ntcompose.core.i iVar;
                                int i67;
                                float f16;
                                Intrinsics.checkNotNullParameter(Box, "$this$Box");
                                if ((i65 & 14) == 0) {
                                    i66 = (composer4.changed(Box) ? 4 : 2) | i65;
                                } else {
                                    i66 = i65;
                                }
                                if ((i66 & 91) == 18 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-805424948, i65, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous> (AlertCustomDialog.kt:68)");
                                }
                                i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), com.tencent.kuikly.core.base.h.this);
                                final Function0<Unit> function016 = function013;
                                final MutableState<Boolean> mutableState5 = mutableState3;
                                composer4.startReplaceableGroup(511388516);
                                boolean changed2 = composer4.changed(function016) | composer4.changed(mutableState5);
                                Object rememberedValue4 = composer4.rememberedValue();
                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                            invoke2(clickParams);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ClickParams it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            Function0<Unit> function017 = function016;
                                            if (function017 != null) {
                                                function017.invoke();
                                            } else {
                                                mutableState5.setValue(Boolean.FALSE);
                                            }
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue4);
                                }
                                composer4.endReplaceableGroup();
                                com.tencent.ntcompose.core.i d17 = ViewEventPropUpdaterKt.d(c17, false, null, (Function1) rememberedValue4, 3, null);
                                boolean booleanValue = mutableState3.getValue().booleanValue();
                                AnimatedTransitionType animatedTransitionType = AnimatedTransitionType.FADE_IN_OUT;
                                com.tencent.ntcompose.animation.a<Boolean> aVar13 = aVar11;
                                com.tencent.ntcompose.animation.a<Boolean> aVar14 = aVar12;
                                Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit> a16 = ComposableSingletons$AlertCustomDialogKt.f339341a.a();
                                int i68 = i58;
                                AnimatedTransitionBoxKt.a(d17, null, animatedTransitionType, booleanValue, null, aVar13, aVar14, a16, composer4, ((i68 >> 9) & 458752) | 12583296 | ((i68 >> 9) & 3670016), 18);
                                com.tencent.ntcompose.core.i b16 = ModifiersKt.b(ModifiersKt.M(ComposeLayoutPropUpdaterKt.j(Box.a(companion2, alignment7), 0.0f, 1, null), mutableState4.getValue().booleanValue()), 1.0f);
                                c16 = AlertCustomDialogKt.c(alertDialogTransitionType7);
                                boolean booleanValue2 = mutableState3.getValue().booleanValue();
                                if (alertDialogTransitionType7 == AlertDialogTransitionType.DIRECTION_FROM_CENTER) {
                                    if (mutableState3.getValue().booleanValue()) {
                                        f16 = 0.7f;
                                        i67 = 2;
                                    } else {
                                        i67 = 2;
                                        f16 = 0.8f;
                                    }
                                    iVar = ModifiersKt.b(ModifiersKt.J(companion2, f16, null, i67, null), 0.0f);
                                } else {
                                    iVar = null;
                                }
                                final MutableState<Boolean> mutableState6 = mutableState4;
                                final Function0<Unit> function017 = function014;
                                final Function0<Unit> function018 = function015;
                                composer4.startReplaceableGroup(1618982084);
                                boolean changed3 = composer4.changed(mutableState6) | composer4.changed(function017) | composer4.changed(function018);
                                Object rememberedValue5 = composer4.rememberedValue();
                                if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z28) {
                                            if (!z28) {
                                                mutableState6.setValue(Boolean.FALSE);
                                                function017.invoke();
                                                return;
                                            }
                                            mutableState6.setValue(Boolean.TRUE);
                                            Function0<Unit> function019 = function018;
                                            if (function019 != null) {
                                                function019.invoke();
                                            }
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue5);
                                }
                                composer4.endReplaceableGroup();
                                Function1 function1 = (Function1) rememberedValue5;
                                com.tencent.ntcompose.animation.a<Boolean> aVar15 = aVar11;
                                com.tencent.ntcompose.animation.a<Boolean> aVar16 = aVar12;
                                final Alignment alignment8 = alignment7;
                                final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                final int i69 = i59;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 168233003, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer5, Integer num) {
                                        invoke(bVar, composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(com.tencent.ntcompose.foundation.layout.b AnimatedTransitionBox, Composer composer5, int i75) {
                                        Intrinsics.checkNotNullParameter(AnimatedTransitionBox, "$this$AnimatedTransitionBox");
                                        if ((i75 & 81) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(168233003, i75, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:105)");
                                        }
                                        Alignment.Horizontal horizontal = Alignment.Horizontal.Start;
                                        Alignment alignment9 = Alignment.this;
                                        if (alignment9 != Alignment.TopCenter && alignment9 != Alignment.Center && alignment9 != Alignment.BottomCenter) {
                                            if (alignment9 == Alignment.TopEnd || alignment9 == Alignment.CenterEnd || alignment9 == Alignment.BottomEnd) {
                                                horizontal = Alignment.Horizontal.End;
                                            }
                                        } else {
                                            horizontal = Alignment.Horizontal.CenterHorizontally;
                                        }
                                        com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                        final int i76 = i69;
                                        ColumnKt.a(j3, null, horizontal, null, ComposableLambdaKt.composableLambda(composer5, -2061423084, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer6, Integer num) {
                                                invoke(dVar, composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(com.tencent.ntcompose.foundation.layout.d Column, Composer composer6, int i77) {
                                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                                if ((i77 & 81) == 16 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2061423084, i77, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:112)");
                                                }
                                                function23.invoke(composer6, Integer.valueOf(i76 & 14));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer5, 24576, 10);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i75 = i58;
                                AnimatedTransitionBoxKt.a(b16, iVar, c16, booleanValue2, function1, aVar15, aVar16, composableLambda, composer4, ((i75 >> 9) & 458752) | 12582912 | ((i75 >> 9) & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i562 & 112) | 24576, 13);
                if (ComposerKt.isTraceInProgress()) {
                }
                z19 = z18;
                hVar4 = hVar3;
                function05 = function03;
                alertDialogTransitionType3 = alertDialogTransitionType2;
                function06 = function04;
                alignment3 = alignment2;
                aVar5 = aVar4;
                aVar6 = aVar3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i27 = i17 & 16;
            if (i27 != 0) {
            }
            if ((i17 & 32) == 0) {
            }
            i18 |= i46;
            i28 = i17 & 64;
            if (i28 == 0) {
            }
            i29 = i17 & 128;
            if (i29 == 0) {
            }
            i36 = i17 & 256;
            if (i36 == 0) {
            }
            i37 = i17 & 512;
            if (i37 == 0) {
            }
            if ((i17 & 1024) == 0) {
            }
            if (i19 != 4) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i47 == 0) {
            }
            if (i19 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            if (i29 == 0) {
            }
            if (i36 == 0) {
            }
            if (i37 == 0) {
            }
            z18 = z26;
            hVar3 = hVar2;
            function03 = function07;
            alertDialogTransitionType2 = alertDialogTransitionType4;
            function04 = function08;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) rememberedValue;
            if (z16) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Boolean> mutableState222 = (MutableState) rememberedValue2;
            Boolean valueOf32 = Boolean.valueOf(z16);
            Boolean valueOf222 = Boolean.valueOf(z16);
            startRestartGroup.startReplaceableGroup(511388516);
            changed = startRestartGroup.changed(valueOf222) | startRestartGroup.changed(mutableState222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    mutableState222.setValue(Boolean.valueOf(z16));
                    return new a();
                }

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes34.dex */
                public static final class a implements DisposableEffectResult {
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(valueOf32, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, i39 & 14);
            final com.tencent.kuikly.core.base.h hVar622 = hVar3;
            final Function0<Unit> function01122 = function03;
            final int i4822 = i38;
            final int i4922 = i39;
            final com.tencent.ntcompose.animation.a<Boolean> aVar922 = aVar4;
            final com.tencent.ntcompose.animation.a<Boolean> aVar1022 = aVar3;
            final Alignment alignment622 = alignment2;
            int i5622 = i39;
            composer2 = startRestartGroup;
            final AlertDialogTransitionType alertDialogTransitionType622 = alertDialogTransitionType2;
            final Function0<Unit> function01222 = function04;
            ModalKt.a(null, z18, null, null, ComposableLambdaKt.composableLambda(composer2, 774380434, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i57) {
                    if ((i57 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(774380434, i57, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous> (AlertCustomDialog.kt:67)");
                    }
                    com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                    final com.tencent.kuikly.core.base.h hVar7 = com.tencent.kuikly.core.base.h.this;
                    final Function0<Unit> function013 = function01122;
                    final MutableState<Boolean> mutableState3 = mutableState222;
                    final int i58 = i4922;
                    final com.tencent.ntcompose.animation.a<Boolean> aVar11 = aVar922;
                    final com.tencent.ntcompose.animation.a<Boolean> aVar12 = aVar1022;
                    final Alignment alignment7 = alignment622;
                    final MutableState<Boolean> mutableState4 = mutableState;
                    final AlertDialogTransitionType alertDialogTransitionType7 = alertDialogTransitionType622;
                    final Function0<Unit> function014 = onDismiss;
                    final Function0<Unit> function015 = function01222;
                    final Function2<? super Composer, ? super Integer, Unit> function2 = customContent;
                    final int i59 = i4822;
                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, -805424948, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num) {
                            invoke(bVar, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer4, int i65) {
                            int i66;
                            AnimatedTransitionType c16;
                            com.tencent.ntcompose.core.i iVar;
                            int i67;
                            float f16;
                            Intrinsics.checkNotNullParameter(Box, "$this$Box");
                            if ((i65 & 14) == 0) {
                                i66 = (composer4.changed(Box) ? 4 : 2) | i65;
                            } else {
                                i66 = i65;
                            }
                            if ((i66 & 91) == 18 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-805424948, i65, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous> (AlertCustomDialog.kt:68)");
                            }
                            i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                            com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), com.tencent.kuikly.core.base.h.this);
                            final Function0<Unit> function016 = function013;
                            final MutableState<Boolean> mutableState5 = mutableState3;
                            composer4.startReplaceableGroup(511388516);
                            boolean changed2 = composer4.changed(function016) | composer4.changed(mutableState5);
                            Object rememberedValue4 = composer4.rememberedValue();
                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        invoke2(clickParams);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ClickParams it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        Function0<Unit> function017 = function016;
                                        if (function017 != null) {
                                            function017.invoke();
                                        } else {
                                            mutableState5.setValue(Boolean.FALSE);
                                        }
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue4);
                            }
                            composer4.endReplaceableGroup();
                            com.tencent.ntcompose.core.i d17 = ViewEventPropUpdaterKt.d(c17, false, null, (Function1) rememberedValue4, 3, null);
                            boolean booleanValue = mutableState3.getValue().booleanValue();
                            AnimatedTransitionType animatedTransitionType = AnimatedTransitionType.FADE_IN_OUT;
                            com.tencent.ntcompose.animation.a<Boolean> aVar13 = aVar11;
                            com.tencent.ntcompose.animation.a<Boolean> aVar14 = aVar12;
                            Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit> a16 = ComposableSingletons$AlertCustomDialogKt.f339341a.a();
                            int i68 = i58;
                            AnimatedTransitionBoxKt.a(d17, null, animatedTransitionType, booleanValue, null, aVar13, aVar14, a16, composer4, ((i68 >> 9) & 458752) | 12583296 | ((i68 >> 9) & 3670016), 18);
                            com.tencent.ntcompose.core.i b16 = ModifiersKt.b(ModifiersKt.M(ComposeLayoutPropUpdaterKt.j(Box.a(companion2, alignment7), 0.0f, 1, null), mutableState4.getValue().booleanValue()), 1.0f);
                            c16 = AlertCustomDialogKt.c(alertDialogTransitionType7);
                            boolean booleanValue2 = mutableState3.getValue().booleanValue();
                            if (alertDialogTransitionType7 == AlertDialogTransitionType.DIRECTION_FROM_CENTER) {
                                if (mutableState3.getValue().booleanValue()) {
                                    f16 = 0.7f;
                                    i67 = 2;
                                } else {
                                    i67 = 2;
                                    f16 = 0.8f;
                                }
                                iVar = ModifiersKt.b(ModifiersKt.J(companion2, f16, null, i67, null), 0.0f);
                            } else {
                                iVar = null;
                            }
                            final MutableState<Boolean> mutableState6 = mutableState4;
                            final Function0<Unit> function017 = function014;
                            final Function0<Unit> function018 = function015;
                            composer4.startReplaceableGroup(1618982084);
                            boolean changed3 = composer4.changed(mutableState6) | composer4.changed(function017) | composer4.changed(function018);
                            Object rememberedValue5 = composer4.rememberedValue();
                            if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z28) {
                                        if (!z28) {
                                            mutableState6.setValue(Boolean.FALSE);
                                            function017.invoke();
                                            return;
                                        }
                                        mutableState6.setValue(Boolean.TRUE);
                                        Function0<Unit> function019 = function018;
                                        if (function019 != null) {
                                            function019.invoke();
                                        }
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue5);
                            }
                            composer4.endReplaceableGroup();
                            Function1 function1 = (Function1) rememberedValue5;
                            com.tencent.ntcompose.animation.a<Boolean> aVar15 = aVar11;
                            com.tencent.ntcompose.animation.a<Boolean> aVar16 = aVar12;
                            final Alignment alignment8 = alignment7;
                            final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                            final int i69 = i59;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 168233003, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer5, Integer num) {
                                    invoke(bVar, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.foundation.layout.b AnimatedTransitionBox, Composer composer5, int i75) {
                                    Intrinsics.checkNotNullParameter(AnimatedTransitionBox, "$this$AnimatedTransitionBox");
                                    if ((i75 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(168233003, i75, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:105)");
                                    }
                                    Alignment.Horizontal horizontal = Alignment.Horizontal.Start;
                                    Alignment alignment9 = Alignment.this;
                                    if (alignment9 != Alignment.TopCenter && alignment9 != Alignment.Center && alignment9 != Alignment.BottomCenter) {
                                        if (alignment9 == Alignment.TopEnd || alignment9 == Alignment.CenterEnd || alignment9 == Alignment.BottomEnd) {
                                            horizontal = Alignment.Horizontal.End;
                                        }
                                    } else {
                                        horizontal = Alignment.Horizontal.CenterHorizontally;
                                    }
                                    com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                    final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                    final int i76 = i69;
                                    ColumnKt.a(j3, null, horizontal, null, ComposableLambdaKt.composableLambda(composer5, -2061423084, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer6, Integer num) {
                                            invoke(dVar, composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(com.tencent.ntcompose.foundation.layout.d Column, Composer composer6, int i77) {
                                            Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                            if ((i77 & 81) == 16 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2061423084, i77, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:112)");
                                            }
                                            function23.invoke(composer6, Integer.valueOf(i76 & 14));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer5, 24576, 10);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i75 = i58;
                            AnimatedTransitionBoxKt.a(b16, iVar, c16, booleanValue2, function1, aVar15, aVar16, composableLambda, composer4, ((i75 >> 9) & 458752) | 12582912 | ((i75 >> 9) & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, (i5622 & 112) | 24576, 13);
            if (ComposerKt.isTraceInProgress()) {
            }
            z19 = z18;
            hVar4 = hVar3;
            function05 = function03;
            alertDialogTransitionType3 = alertDialogTransitionType2;
            function06 = function04;
            alignment3 = alignment2;
            aVar5 = aVar4;
            aVar6 = aVar3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i19 = i17 & 4;
        if (i19 != 0) {
        }
        i26 = i17 & 8;
        if (i26 == 0) {
        }
        i27 = i17 & 16;
        if (i27 != 0) {
        }
        if ((i17 & 32) == 0) {
        }
        i18 |= i46;
        i28 = i17 & 64;
        if (i28 == 0) {
        }
        i29 = i17 & 128;
        if (i29 == 0) {
        }
        i36 = i17 & 256;
        if (i36 == 0) {
        }
        i37 = i17 & 512;
        if (i37 == 0) {
        }
        if ((i17 & 1024) == 0) {
        }
        if (i19 != 4) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i47 == 0) {
        }
        if (i19 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        if (i29 == 0) {
        }
        if (i36 == 0) {
        }
        if (i37 == 0) {
        }
        z18 = z26;
        hVar3 = hVar2;
        function03 = function07;
        alertDialogTransitionType2 = alertDialogTransitionType4;
        function04 = function08;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState = (MutableState) rememberedValue;
        if (z16) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Boolean> mutableState2222 = (MutableState) rememberedValue2;
        Boolean valueOf322 = Boolean.valueOf(z16);
        Boolean valueOf2222 = Boolean.valueOf(z16);
        startRestartGroup.startReplaceableGroup(511388516);
        changed = startRestartGroup.changed(valueOf2222) | startRestartGroup.changed(mutableState2222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                mutableState2222.setValue(Boolean.valueOf(z16));
                return new a();
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements DisposableEffectResult {
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(valueOf322, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, i39 & 14);
        final com.tencent.kuikly.core.base.h hVar6222 = hVar3;
        final Function0<Unit> function011222 = function03;
        final int i48222 = i38;
        final int i49222 = i39;
        final com.tencent.ntcompose.animation.a<Boolean> aVar9222 = aVar4;
        final com.tencent.ntcompose.animation.a<Boolean> aVar10222 = aVar3;
        final Alignment alignment6222 = alignment2;
        int i56222 = i39;
        composer2 = startRestartGroup;
        final AlertDialogTransitionType alertDialogTransitionType6222 = alertDialogTransitionType2;
        final Function0<Unit> function012222 = function04;
        ModalKt.a(null, z18, null, null, ComposableLambdaKt.composableLambda(composer2, 774380434, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i57) {
                if ((i57 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(774380434, i57, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous> (AlertCustomDialog.kt:67)");
                }
                com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                final com.tencent.kuikly.core.base.h hVar7 = com.tencent.kuikly.core.base.h.this;
                final Function0<Unit> function013 = function011222;
                final MutableState<Boolean> mutableState3 = mutableState2222;
                final int i58 = i49222;
                final com.tencent.ntcompose.animation.a<Boolean> aVar11 = aVar9222;
                final com.tencent.ntcompose.animation.a<Boolean> aVar12 = aVar10222;
                final Alignment alignment7 = alignment6222;
                final MutableState<Boolean> mutableState4 = mutableState;
                final AlertDialogTransitionType alertDialogTransitionType7 = alertDialogTransitionType6222;
                final Function0<Unit> function014 = onDismiss;
                final Function0<Unit> function015 = function012222;
                final Function2<? super Composer, ? super Integer, Unit> function2 = customContent;
                final int i59 = i48222;
                BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, -805424948, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num) {
                        invoke(bVar, composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer4, int i65) {
                        int i66;
                        AnimatedTransitionType c16;
                        com.tencent.ntcompose.core.i iVar;
                        int i67;
                        float f16;
                        Intrinsics.checkNotNullParameter(Box, "$this$Box");
                        if ((i65 & 14) == 0) {
                            i66 = (composer4.changed(Box) ? 4 : 2) | i65;
                        } else {
                            i66 = i65;
                        }
                        if ((i66 & 91) == 18 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-805424948, i65, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous> (AlertCustomDialog.kt:68)");
                        }
                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                        com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), com.tencent.kuikly.core.base.h.this);
                        final Function0<Unit> function016 = function013;
                        final MutableState<Boolean> mutableState5 = mutableState3;
                        composer4.startReplaceableGroup(511388516);
                        boolean changed2 = composer4.changed(function016) | composer4.changed(mutableState5);
                        Object rememberedValue4 = composer4.rememberedValue();
                        if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                    invoke2(clickParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ClickParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    Function0<Unit> function017 = function016;
                                    if (function017 != null) {
                                        function017.invoke();
                                    } else {
                                        mutableState5.setValue(Boolean.FALSE);
                                    }
                                }
                            };
                            composer4.updateRememberedValue(rememberedValue4);
                        }
                        composer4.endReplaceableGroup();
                        com.tencent.ntcompose.core.i d17 = ViewEventPropUpdaterKt.d(c17, false, null, (Function1) rememberedValue4, 3, null);
                        boolean booleanValue = mutableState3.getValue().booleanValue();
                        AnimatedTransitionType animatedTransitionType = AnimatedTransitionType.FADE_IN_OUT;
                        com.tencent.ntcompose.animation.a<Boolean> aVar13 = aVar11;
                        com.tencent.ntcompose.animation.a<Boolean> aVar14 = aVar12;
                        Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit> a16 = ComposableSingletons$AlertCustomDialogKt.f339341a.a();
                        int i68 = i58;
                        AnimatedTransitionBoxKt.a(d17, null, animatedTransitionType, booleanValue, null, aVar13, aVar14, a16, composer4, ((i68 >> 9) & 458752) | 12583296 | ((i68 >> 9) & 3670016), 18);
                        com.tencent.ntcompose.core.i b16 = ModifiersKt.b(ModifiersKt.M(ComposeLayoutPropUpdaterKt.j(Box.a(companion2, alignment7), 0.0f, 1, null), mutableState4.getValue().booleanValue()), 1.0f);
                        c16 = AlertCustomDialogKt.c(alertDialogTransitionType7);
                        boolean booleanValue2 = mutableState3.getValue().booleanValue();
                        if (alertDialogTransitionType7 == AlertDialogTransitionType.DIRECTION_FROM_CENTER) {
                            if (mutableState3.getValue().booleanValue()) {
                                f16 = 0.7f;
                                i67 = 2;
                            } else {
                                i67 = 2;
                                f16 = 0.8f;
                            }
                            iVar = ModifiersKt.b(ModifiersKt.J(companion2, f16, null, i67, null), 0.0f);
                        } else {
                            iVar = null;
                        }
                        final MutableState<Boolean> mutableState6 = mutableState4;
                        final Function0<Unit> function017 = function014;
                        final Function0<Unit> function018 = function015;
                        composer4.startReplaceableGroup(1618982084);
                        boolean changed3 = composer4.changed(mutableState6) | composer4.changed(function017) | composer4.changed(function018);
                        Object rememberedValue5 = composer4.rememberedValue();
                        if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt$AlertCustomDialog$3$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z28) {
                                    if (!z28) {
                                        mutableState6.setValue(Boolean.FALSE);
                                        function017.invoke();
                                        return;
                                    }
                                    mutableState6.setValue(Boolean.TRUE);
                                    Function0<Unit> function019 = function018;
                                    if (function019 != null) {
                                        function019.invoke();
                                    }
                                }
                            };
                            composer4.updateRememberedValue(rememberedValue5);
                        }
                        composer4.endReplaceableGroup();
                        Function1 function1 = (Function1) rememberedValue5;
                        com.tencent.ntcompose.animation.a<Boolean> aVar15 = aVar11;
                        com.tencent.ntcompose.animation.a<Boolean> aVar16 = aVar12;
                        final Alignment alignment8 = alignment7;
                        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                        final int i69 = i59;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer4, 168233003, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer5, Integer num) {
                                invoke(bVar, composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(com.tencent.ntcompose.foundation.layout.b AnimatedTransitionBox, Composer composer5, int i75) {
                                Intrinsics.checkNotNullParameter(AnimatedTransitionBox, "$this$AnimatedTransitionBox");
                                if ((i75 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(168233003, i75, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:105)");
                                }
                                Alignment.Horizontal horizontal = Alignment.Horizontal.Start;
                                Alignment alignment9 = Alignment.this;
                                if (alignment9 != Alignment.TopCenter && alignment9 != Alignment.Center && alignment9 != Alignment.BottomCenter) {
                                    if (alignment9 == Alignment.TopEnd || alignment9 == Alignment.CenterEnd || alignment9 == Alignment.BottomEnd) {
                                        horizontal = Alignment.Horizontal.End;
                                    }
                                } else {
                                    horizontal = Alignment.Horizontal.CenterHorizontally;
                                }
                                com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                final int i76 = i69;
                                ColumnKt.a(j3, null, horizontal, null, ComposableLambdaKt.composableLambda(composer5, -2061423084, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AlertCustomDialogKt.AlertCustomDialog.3.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer6, Integer num) {
                                        invoke(dVar, composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(com.tencent.ntcompose.foundation.layout.d Column, Composer composer6, int i77) {
                                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                        if ((i77 & 81) == 16 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2061423084, i77, -1, "com.tencent.ntcompose.material.AlertCustomDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertCustomDialog.kt:112)");
                                        }
                                        function23.invoke(composer6, Integer.valueOf(i76 & 14));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer5, 24576, 10);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i75 = i58;
                        AnimatedTransitionBoxKt.a(b16, iVar, c16, booleanValue2, function1, aVar15, aVar16, composableLambda, composer4, ((i75 >> 9) & 458752) | 12582912 | ((i75 >> 9) & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer3, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, (i56222 & 112) | 24576, 13);
        if (ComposerKt.isTraceInProgress()) {
        }
        z19 = z18;
        hVar4 = hVar3;
        function05 = function03;
        alertDialogTransitionType3 = alertDialogTransitionType2;
        function06 = function04;
        alignment3 = alignment2;
        aVar5 = aVar4;
        aVar6 = aVar3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimatedTransitionType c(AlertDialogTransitionType alertDialogTransitionType) {
        switch (a.f339338a[alertDialogTransitionType.ordinal()]) {
            case 1:
                return AnimatedTransitionType.DIRECTION_FROM_CENTER;
            case 2:
                return AnimatedTransitionType.DIRECTION_FROM_TOP;
            case 3:
                return AnimatedTransitionType.DIRECTION_FROM_LEFT;
            case 4:
                return AnimatedTransitionType.DIRECTION_FROM_RIGHT;
            case 5:
                return AnimatedTransitionType.DIRECTION_FROM_BOTTOM;
            case 6:
                return AnimatedTransitionType.FADE_IN_OUT;
            default:
                return AnimatedTransitionType.DIRECTION_FROM_CENTER;
        }
    }
}
