package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u008f\u0001\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\u000e\u00a2\u0006\u0002\b\u000fH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a3\u0010\u0015\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "enterToModifier", "customExitToModifier", "Lcom/tencent/ntcompose/material/AnimatedTransitionType;", "transitionType", "", "enterOrExit", "Lkotlin/Function1;", "", "transitionAnimationFinish", "Lcom/tencent/ntcompose/animation/a;", "enterWithAnimationSpec", "exitWithAnimationSpec", "Lcom/tencent/ntcompose/foundation/layout/b;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/material/AnimatedTransitionType;ZLkotlin/jvm/functions/Function1;Lcom/tencent/ntcompose/animation/a;Lcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "appear", "customTransitionInitModifier", "f", "(Ljava/lang/Boolean;Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/material/AnimatedTransitionType;Lcom/tencent/ntcompose/core/i;)Lcom/tencent/ntcompose/core/i;", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AnimatedTransitionBoxKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339339a;

        static {
            int[] iArr = new int[AnimatedTransitionType.values().length];
            try {
                iArr[AnimatedTransitionType.DIRECTION_FROM_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimatedTransitionType.DIRECTION_FROM_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnimatedTransitionType.DIRECTION_FROM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnimatedTransitionType.DIRECTION_FROM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnimatedTransitionType.DIRECTION_FROM_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnimatedTransitionType.FADE_IN_OUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f339339a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final com.tencent.ntcompose.core.i enterToModifier, com.tencent.ntcompose.core.i iVar, final AnimatedTransitionType transitionType, boolean z16, Function1<? super Boolean, Unit> function1, com.tencent.ntcompose.animation.a<Boolean> aVar, com.tencent.ntcompose.animation.a<Boolean> aVar2, final Function3<? super com.tencent.ntcompose.foundation.layout.b, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16) {
        final int i17;
        com.tencent.ntcompose.core.i iVar2;
        int i18;
        boolean z17;
        int i19;
        final Function1<? super Boolean, Unit> function12;
        int i26;
        int i27;
        final boolean z18;
        com.tencent.ntcompose.animation.a<Boolean> d16;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        boolean changed;
        Object rememberedValue2;
        boolean changed2;
        Object rememberedValue3;
        final boolean z19;
        final com.tencent.ntcompose.animation.a<Boolean> aVar3;
        final Function1<? super Boolean, Unit> function13;
        ScopeUpdateScope endRestartGroup;
        int i28;
        Intrinsics.checkNotNullParameter(enterToModifier, "enterToModifier");
        Intrinsics.checkNotNullParameter(transitionType, "transitionType");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(2056637145);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(enterToModifier) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i29 = i16 & 2;
        if (i29 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            iVar2 = iVar;
            i17 |= startRestartGroup.changed(iVar2) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i17 |= startRestartGroup.changed(transitionType) ? 256 : 128;
            }
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                z17 = z16;
                i17 |= startRestartGroup.changed(z17) ? 2048 : 1024;
                i19 = i16 & 16;
                if (i19 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    function12 = function1;
                    i17 |= startRestartGroup.changed(function12) ? 16384 : 8192;
                    i26 = i16 & 32;
                    if (i26 == 0) {
                        i17 |= 196608;
                    } else if ((i3 & 458752) == 0) {
                        i17 |= startRestartGroup.changed(aVar) ? 131072 : 65536;
                    }
                    i27 = i16 & 64;
                    if (i27 == 0) {
                        i17 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        i17 |= startRestartGroup.changed(aVar2) ? 1048576 : 524288;
                    }
                    if ((i16 & 128) != 0) {
                        i28 = (29360128 & i3) == 0 ? startRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i17) != 4793490 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            aVar3 = aVar;
                            d16 = aVar2;
                            z19 = z17;
                            function13 = function12;
                        } else {
                            if (i29 != 0) {
                                iVar2 = null;
                            }
                            z18 = i18 != 0 ? true : z17;
                            if (i19 != 0) {
                                function12 = null;
                            }
                            com.tencent.ntcompose.animation.a<Boolean> d17 = i26 != 0 ? com.tencent.ntcompose.animation.b.d(250, 0, com.tencent.ntcompose.animation.i.b(), null, 10, null) : aVar;
                            d16 = i27 != 0 ? com.tencent.ntcompose.animation.b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null) : aVar2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2056637145, i17, -1, "com.tencent.ntcompose.material.AnimatedTransitionBox (AnimatedTransitionBox.kt:40)");
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(z18 ? null : Boolean.FALSE, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            mutableState = (MutableState) rememberedValue;
                            com.tencent.ntcompose.animation.a<Boolean> aVar4 = Intrinsics.areEqual(b(mutableState), Boolean.FALSE) ? d16 : d17;
                            Boolean b16 = b(mutableState);
                            startRestartGroup.startReplaceableGroup(1157296644);
                            changed = startRestartGroup.changed(function12);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$animated$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke2(bool);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Boolean bool) {
                                        Function1<Boolean, Unit> function14 = function12;
                                        if (function14 != null) {
                                            function14.invoke(Boolean.valueOf(bool != null ? bool.booleanValue() : true));
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Function1<? super Boolean, Unit> function14 = function12;
                            State d18 = AnimateAsStateKt.d(b16, aVar4, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                            Boolean valueOf = Boolean.valueOf(z18);
                            Boolean valueOf2 = Boolean.valueOf(z18);
                            startRestartGroup.startReplaceableGroup(511388516);
                            changed2 = startRestartGroup.changed(valueOf2) | startRestartGroup.changed(mutableState);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                        AnimatedTransitionBoxKt.c(mutableState, Boolean.valueOf(z18));
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
                            EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, (i17 >> 9) & 14);
                            BoxKt.a(com.tencent.ntcompose.core.i.INSTANCE.b(f(d(d18), enterToModifier, transitionType, iVar2)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1223262995, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                                    invoke(bVar, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i36) {
                                    Intrinsics.checkNotNullParameter(Box, "$this$Box");
                                    if ((i36 & 14) == 0) {
                                        i36 |= composer2.changed(Box) ? 4 : 2;
                                    }
                                    if ((i36 & 91) == 18 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1223262995, i36, -1, "com.tencent.ntcompose.material.AnimatedTransitionBox.<anonymous> (AnimatedTransitionBox.kt:61)");
                                    }
                                    content.invoke(Box, composer2, Integer.valueOf((i36 & 14) | ((i17 >> 18) & 112)));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), startRestartGroup, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z19 = z18;
                            aVar3 = d17;
                            function13 = function14;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final com.tencent.ntcompose.core.i iVar3 = iVar2;
                        final com.tencent.ntcompose.animation.a<Boolean> aVar5 = d16;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$3
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

                            public final void invoke(Composer composer2, int i36) {
                                AnimatedTransitionBoxKt.a(com.tencent.ntcompose.core.i.this, iVar3, transitionType, z19, function13, aVar3, aVar5, content, composer2, i3 | 1, i16);
                            }
                        });
                        return;
                    }
                    i17 |= i28;
                    if ((23967451 & i17) != 4793490) {
                    }
                    if (i29 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
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
                    if (Intrinsics.areEqual(b(mutableState), Boolean.FALSE)) {
                    }
                    Boolean b162 = b(mutableState);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed = startRestartGroup.changed(function12);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$animated$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke2(bool);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Boolean bool) {
                            Function1<Boolean, Unit> function142 = function12;
                            if (function142 != null) {
                                function142.invoke(Boolean.valueOf(bool != null ? bool.booleanValue() : true));
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    Function1<? super Boolean, Unit> function142 = function12;
                    State d182 = AnimateAsStateKt.d(b162, aVar4, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                    Boolean valueOf3 = Boolean.valueOf(z18);
                    Boolean valueOf22 = Boolean.valueOf(z18);
                    startRestartGroup.startReplaceableGroup(511388516);
                    changed2 = startRestartGroup.changed(valueOf22) | startRestartGroup.changed(mutableState);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            AnimatedTransitionBoxKt.c(mutableState, Boolean.valueOf(z18));
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
                    EffectsKt.DisposableEffect(valueOf3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, (i17 >> 9) & 14);
                    BoxKt.a(com.tencent.ntcompose.core.i.INSTANCE.b(f(d(d182), enterToModifier, transitionType, iVar2)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1223262995, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                            invoke(bVar, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i36) {
                            Intrinsics.checkNotNullParameter(Box, "$this$Box");
                            if ((i36 & 14) == 0) {
                                i36 |= composer2.changed(Box) ? 4 : 2;
                            }
                            if ((i36 & 91) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1223262995, i36, -1, "com.tencent.ntcompose.material.AnimatedTransitionBox.<anonymous> (AnimatedTransitionBox.kt:61)");
                            }
                            content.invoke(Box, composer2, Integer.valueOf((i36 & 14) | ((i17 >> 18) & 112)));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z19 = z18;
                    aVar3 = d17;
                    function13 = function142;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i26 = i16 & 32;
                if (i26 == 0) {
                }
                i27 = i16 & 64;
                if (i27 == 0) {
                }
                if ((i16 & 128) != 0) {
                }
                i17 |= i28;
                if ((23967451 & i17) != 4793490) {
                }
                if (i29 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
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
                if (Intrinsics.areEqual(b(mutableState), Boolean.FALSE)) {
                }
                Boolean b1622 = b(mutableState);
                startRestartGroup.startReplaceableGroup(1157296644);
                changed = startRestartGroup.changed(function12);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$animated$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean bool) {
                        Function1<Boolean, Unit> function1422 = function12;
                        if (function1422 != null) {
                            function1422.invoke(Boolean.valueOf(bool != null ? bool.booleanValue() : true));
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                Function1<? super Boolean, Unit> function1422 = function12;
                State d1822 = AnimateAsStateKt.d(b1622, aVar4, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                Boolean valueOf32 = Boolean.valueOf(z18);
                Boolean valueOf222 = Boolean.valueOf(z18);
                startRestartGroup.startReplaceableGroup(511388516);
                changed2 = startRestartGroup.changed(valueOf222) | startRestartGroup.changed(mutableState);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        AnimatedTransitionBoxKt.c(mutableState, Boolean.valueOf(z18));
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
                EffectsKt.DisposableEffect(valueOf32, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, (i17 >> 9) & 14);
                BoxKt.a(com.tencent.ntcompose.core.i.INSTANCE.b(f(d(d1822), enterToModifier, transitionType, iVar2)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1223262995, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                        invoke(bVar, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i36) {
                        Intrinsics.checkNotNullParameter(Box, "$this$Box");
                        if ((i36 & 14) == 0) {
                            i36 |= composer2.changed(Box) ? 4 : 2;
                        }
                        if ((i36 & 91) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1223262995, i36, -1, "com.tencent.ntcompose.material.AnimatedTransitionBox.<anonymous> (AnimatedTransitionBox.kt:61)");
                        }
                        content.invoke(Box, composer2, Integer.valueOf((i36 & 14) | ((i17 >> 18) & 112)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                z19 = z18;
                aVar3 = d17;
                function13 = function1422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z17 = z16;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            function12 = function1;
            i26 = i16 & 32;
            if (i26 == 0) {
            }
            i27 = i16 & 64;
            if (i27 == 0) {
            }
            if ((i16 & 128) != 0) {
            }
            i17 |= i28;
            if ((23967451 & i17) != 4793490) {
            }
            if (i29 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
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
            if (Intrinsics.areEqual(b(mutableState), Boolean.FALSE)) {
            }
            Boolean b16222 = b(mutableState);
            startRestartGroup.startReplaceableGroup(1157296644);
            changed = startRestartGroup.changed(function12);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$animated$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    Function1<Boolean, Unit> function14222 = function12;
                    if (function14222 != null) {
                        function14222.invoke(Boolean.valueOf(bool != null ? bool.booleanValue() : true));
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            Function1<? super Boolean, Unit> function14222 = function12;
            State d18222 = AnimateAsStateKt.d(b16222, aVar4, (Function1) rememberedValue2, startRestartGroup, 0, 0);
            Boolean valueOf322 = Boolean.valueOf(z18);
            Boolean valueOf2222 = Boolean.valueOf(z18);
            startRestartGroup.startReplaceableGroup(511388516);
            changed2 = startRestartGroup.changed(valueOf2222) | startRestartGroup.changed(mutableState);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    AnimatedTransitionBoxKt.c(mutableState, Boolean.valueOf(z18));
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
            EffectsKt.DisposableEffect(valueOf322, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, (i17 >> 9) & 14);
            BoxKt.a(com.tencent.ntcompose.core.i.INSTANCE.b(f(d(d18222), enterToModifier, transitionType, iVar2)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1223262995, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                    invoke(bVar, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i36) {
                    Intrinsics.checkNotNullParameter(Box, "$this$Box");
                    if ((i36 & 14) == 0) {
                        i36 |= composer2.changed(Box) ? 4 : 2;
                    }
                    if ((i36 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1223262995, i36, -1, "com.tencent.ntcompose.material.AnimatedTransitionBox.<anonymous> (AnimatedTransitionBox.kt:61)");
                    }
                    content.invoke(Box, composer2, Integer.valueOf((i36 & 14) | ((i17 >> 18) & 112)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            z19 = z18;
            aVar3 = d17;
            function13 = function14222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        iVar2 = iVar;
        if ((i16 & 4) == 0) {
        }
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        z17 = z16;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        function12 = function1;
        i26 = i16 & 32;
        if (i26 == 0) {
        }
        i27 = i16 & 64;
        if (i27 == 0) {
        }
        if ((i16 & 128) != 0) {
        }
        i17 |= i28;
        if ((23967451 & i17) != 4793490) {
        }
        if (i29 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
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
        if (Intrinsics.areEqual(b(mutableState), Boolean.FALSE)) {
        }
        Boolean b162222 = b(mutableState);
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(function12);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$animated$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Function1<Boolean, Unit> function142222 = function12;
                if (function142222 != null) {
                    function142222.invoke(Boolean.valueOf(bool != null ? bool.booleanValue() : true));
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        Function1<? super Boolean, Unit> function142222 = function12;
        State d182222 = AnimateAsStateKt.d(b162222, aVar4, (Function1) rememberedValue2, startRestartGroup, 0, 0);
        Boolean valueOf3222 = Boolean.valueOf(z18);
        Boolean valueOf22222 = Boolean.valueOf(z18);
        startRestartGroup.startReplaceableGroup(511388516);
        changed2 = startRestartGroup.changed(valueOf22222) | startRestartGroup.changed(mutableState);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                AnimatedTransitionBoxKt.c(mutableState, Boolean.valueOf(z18));
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
        EffectsKt.DisposableEffect(valueOf3222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, (i17 >> 9) & 14);
        BoxKt.a(com.tencent.ntcompose.core.i.INSTANCE.b(f(d(d182222), enterToModifier, transitionType, iVar2)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1223262995, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.AnimatedTransitionBoxKt$AnimatedTransitionBox$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                invoke(bVar, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i36) {
                Intrinsics.checkNotNullParameter(Box, "$this$Box");
                if ((i36 & 14) == 0) {
                    i36 |= composer2.changed(Box) ? 4 : 2;
                }
                if ((i36 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1223262995, i36, -1, "com.tencent.ntcompose.material.AnimatedTransitionBox.<anonymous> (AnimatedTransitionBox.kt:61)");
                }
                content.invoke(Box, composer2, Integer.valueOf((i36 & 14) | ((i17 >> 18) & 112)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        z19 = z18;
        aVar3 = d17;
        function13 = function142222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Boolean b(MutableState<Boolean> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState<Boolean> mutableState, Boolean bool) {
        mutableState.setValue(bool);
    }

    private static final Boolean d(State<Boolean> state) {
        return state.getValue();
    }

    private static final com.tencent.ntcompose.core.i f(Boolean bool, com.tencent.ntcompose.core.i iVar, AnimatedTransitionType animatedTransitionType, com.tencent.ntcompose.core.i iVar2) {
        com.tencent.ntcompose.core.i Q;
        com.tencent.ntcompose.core.i O;
        if (bool != null && !Intrinsics.areEqual(bool, Boolean.FALSE)) {
            if (animatedTransitionType == AnimatedTransitionType.FADE_IN_OUT) {
                O = ModifiersKt.b(com.tencent.ntcompose.core.i.INSTANCE, 1.0f);
            } else {
                O = ModifiersKt.O(com.tencent.ntcompose.core.i.INSTANCE, null, null, null, null, null, 31, null);
            }
            return iVar.b(O);
        }
        if (iVar2 != null) {
            return iVar2.b(iVar);
        }
        switch (a.f339339a[animatedTransitionType.ordinal()]) {
            case 1:
                Q = ModifiersKt.Q(com.tencent.ntcompose.core.i.INSTANCE, new com.tencent.kuikly.core.base.y(0.0f, 1.0f, 0.0f, 0.0f, 12, null), null, 2, null);
                break;
            case 2:
                Q = ModifiersKt.Q(com.tencent.ntcompose.core.i.INSTANCE, new com.tencent.kuikly.core.base.y(0.0f, -1.0f, 0.0f, 0.0f, 12, null), null, 2, null);
                break;
            case 3:
                Q = ModifiersKt.Q(com.tencent.ntcompose.core.i.INSTANCE, new com.tencent.kuikly.core.base.y(-1.0f, 0.0f, 0.0f, 0.0f, 12, null), null, 2, null);
                break;
            case 4:
                Q = ModifiersKt.Q(com.tencent.ntcompose.core.i.INSTANCE, new com.tencent.kuikly.core.base.y(1.0f, 0.0f, 0.0f, 0.0f, 12, null), null, 2, null);
                break;
            case 5:
                Q = ModifiersKt.J(com.tencent.ntcompose.core.i.INSTANCE, 0.001f, null, 2, null);
                break;
            case 6:
                Q = ModifiersKt.b(com.tencent.ntcompose.core.i.INSTANCE, 0.0f);
                break;
            default:
                Q = com.tencent.ntcompose.core.i.INSTANCE;
                break;
        }
        return Q.b(iVar);
    }
}
