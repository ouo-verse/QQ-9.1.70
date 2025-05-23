package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.core.ModifierAttribute;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aj\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u00a2\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"", "checked", "Lkotlin/Function1;", "", "onCheckedChange", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "thumbContent", "", "thumbMargin", NodeProps.ENABLED, "Lcom/tencent/ntcompose/material/af;", NodeProps.COLORS, "a", "(ZLkotlin/jvm/functions/Function1;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;FZLcom/tencent/ntcompose/material/af;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SwitchKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final boolean z16, final Function1<? super Boolean, Unit> onCheckedChange, com.tencent.ntcompose.core.i iVar, Function2<? super Composer, ? super Integer, Unit> function2, float f16, boolean z17, af afVar, Composer composer, final int i3, final int i16) {
        int i17;
        com.tencent.ntcompose.core.i iVar2;
        int i18;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i19;
        float f17;
        int i26;
        boolean z18;
        af afVar2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        float f18;
        af afVar3;
        int i27;
        boolean z19;
        boolean changed;
        Object rememberedValue;
        final float f19;
        final boolean z26;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        int i28;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer startRestartGroup = composer.startRestartGroup(-1828820933);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(z16) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i29 = i16 & 4;
        if (i29 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            iVar2 = iVar;
            i17 |= startRestartGroup.changed(iVar2) ? 256 : 128;
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                function22 = function2;
                i17 |= startRestartGroup.changed(function22) ? 2048 : 1024;
                i19 = i16 & 16;
                if (i19 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    f17 = f16;
                    i17 |= startRestartGroup.changed(f17) ? 16384 : 8192;
                    i26 = i16 & 32;
                    if (i26 == 0) {
                        i17 |= 196608;
                    } else if ((458752 & i3) == 0) {
                        z18 = z17;
                        i17 |= startRestartGroup.changed(z18) ? 131072 : 65536;
                        if ((3670016 & i3) == 0) {
                            if ((i16 & 64) == 0) {
                                afVar2 = afVar;
                                if (startRestartGroup.changed(afVar2)) {
                                    i28 = 1048576;
                                    i17 |= i28;
                                }
                            } else {
                                afVar2 = afVar;
                            }
                            i28 = 524288;
                            i17 |= i28;
                        } else {
                            afVar2 = afVar;
                        }
                        if ((i17 & 2995931) != 599186 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function22;
                            f19 = f17;
                            z26 = z18;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i29 != 0) {
                                    iVar2 = com.tencent.ntcompose.core.i.INSTANCE;
                                }
                                function23 = i18 != 0 ? null : function22;
                                f18 = i19 != 0 ? 2.0f : f17;
                                boolean z27 = i26 != 0 ? true : z18;
                                if ((i16 & 64) != 0) {
                                    i27 = i17 & (-3670017);
                                    afVar3 = ag.f339378a.a(null, null, null, null, null, null, null, null, startRestartGroup, 100663296, 255);
                                } else {
                                    afVar3 = afVar;
                                    i27 = i17;
                                }
                                z19 = z27;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i16 & 64) != 0) {
                                    i17 &= -3670017;
                                }
                                afVar3 = afVar;
                                i27 = i17;
                                function23 = function22;
                                f18 = f17;
                                z19 = z18;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1828820933, i27, -1, "com.tencent.ntcompose.material.Switch (Switch.kt:39)");
                            }
                            int i36 = ((i27 >> 15) & 14) | ((i27 << 3) & 112) | ((i27 >> 12) & 896);
                            final State<com.tencent.kuikly.core.base.h> a16 = afVar3.a(z19, z16, startRestartGroup, i36);
                            final State<com.tencent.kuikly.core.base.h> b16 = afVar3.b(z19, z16, startRestartGroup, i36);
                            ModifierAttribute modifierAttribute = new ModifierAttribute(iVar2);
                            Float c16 = modifierAttribute.c();
                            final float floatValue = c16 != null ? c16.floatValue() : ag.f339378a.c();
                            Float b17 = modifierAttribute.b();
                            final float floatValue2 = b17 != null ? b17.floatValue() : ag.f339378a.b();
                            float f26 = 2;
                            final float f27 = (floatValue2 / f26) - f18;
                            final State<Float> c17 = AnimateAsStateKt.c(z16 ? ((floatValue / f26) - f27) - f18 : ((-floatValue) / f26) + f27 + f18, null, null, startRestartGroup, 0, 6);
                            af afVar4 = afVar3;
                            float f28 = (-f18) * f26;
                            float f29 = f18;
                            com.tencent.ntcompose.core.i v3 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, floatValue + Math.max(0.0f, f28), Math.max(0.0f, f28) + floatValue2);
                            Boolean valueOf = Boolean.valueOf(z16);
                            startRestartGroup.startReplaceableGroup(511388516);
                            changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(onCheckedChange);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        onCheckedChange.invoke(Boolean.valueOf(!z16));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final boolean z28 = z19;
                            final int i37 = i27;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                            BoxKt.a(ModifiersKt.M(ViewEventPropUpdaterKt.d(v3, false, null, (Function1) rememberedValue, 3, null), z19).b(iVar2), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1340283071, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2
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

                                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i38) {
                                    com.tencent.kuikly.core.base.h c18;
                                    com.tencent.kuikly.core.base.h b18;
                                    float d16;
                                    Intrinsics.checkNotNullParameter(Box, "$this$Box");
                                    if ((i38 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1340283071, i38, -1, "com.tencent.ntcompose.material.Switch.<anonymous> (Switch.kt:78)");
                                    }
                                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                    c18 = SwitchKt.c(b16);
                                    BoxKt.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.v(ModifiersKt.M(ModifiersKt.d(companion, c18), z28), floatValue, floatValue2), uo3.c.b()), null, null, null, composer2, 0, 14);
                                    com.tencent.ntcompose.core.i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion, f27 * 2), uo3.c.b());
                                    b18 = SwitchKt.b(a16);
                                    com.tencent.ntcompose.core.i d17 = ModifiersKt.d(q16, b18);
                                    d16 = SwitchKt.d(c17);
                                    com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(d17, d16, 0.0f, 2, null);
                                    Alignment alignment = Alignment.Center;
                                    final Function2<Composer, Integer, Unit> function26 = function25;
                                    final int i39 = i37;
                                    BoxKt.a(p16, alignment, null, ComposableLambdaKt.composableLambda(composer2, 86042558, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                                            invoke(bVar, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i46) {
                                            Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                            if ((i46 & 81) == 16 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(86042558, i46, -1, "com.tencent.ntcompose.material.Switch.<anonymous>.<anonymous> (Switch.kt:98)");
                                            }
                                            Function2<Composer, Integer, Unit> function27 = function26;
                                            if (function27 != null) {
                                                function27.invoke(composer3, Integer.valueOf((i39 >> 9) & 14));
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 3120, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), startRestartGroup, 3120, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f19 = f29;
                            z26 = z19;
                            afVar2 = afVar4;
                            function24 = function23;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final com.tencent.ntcompose.core.i iVar3 = iVar2;
                        final af afVar5 = afVar2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$3
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

                            public final void invoke(Composer composer2, int i38) {
                                SwitchKt.a(z16, onCheckedChange, iVar3, function24, f19, z26, afVar5, composer2, i3 | 1, i16);
                            }
                        });
                        return;
                    }
                    z18 = z17;
                    if ((3670016 & i3) == 0) {
                    }
                    if ((i17 & 2995931) != 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if ((i16 & 64) != 0) {
                    }
                    z19 = z27;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i362 = ((i27 >> 15) & 14) | ((i27 << 3) & 112) | ((i27 >> 12) & 896);
                    final State<com.tencent.kuikly.core.base.h> a162 = afVar3.a(z19, z16, startRestartGroup, i362);
                    final State<com.tencent.kuikly.core.base.h> b162 = afVar3.b(z19, z16, startRestartGroup, i362);
                    ModifierAttribute modifierAttribute2 = new ModifierAttribute(iVar2);
                    Float c162 = modifierAttribute2.c();
                    final float floatValue3 = c162 != null ? c162.floatValue() : ag.f339378a.c();
                    Float b172 = modifierAttribute2.b();
                    final float floatValue22 = b172 != null ? b172.floatValue() : ag.f339378a.b();
                    float f262 = 2;
                    final float f272 = (floatValue22 / f262) - f18;
                    final State<Float> c172 = AnimateAsStateKt.c(z16 ? ((floatValue3 / f262) - f272) - f18 : ((-floatValue3) / f262) + f272 + f18, null, null, startRestartGroup, 0, 6);
                    af afVar42 = afVar3;
                    float f282 = (-f18) * f262;
                    float f292 = f18;
                    com.tencent.ntcompose.core.i v36 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, floatValue3 + Math.max(0.0f, f282), Math.max(0.0f, f282) + floatValue22);
                    Boolean valueOf2 = Boolean.valueOf(z16);
                    startRestartGroup.startReplaceableGroup(511388516);
                    changed = startRestartGroup.changed(valueOf2) | startRestartGroup.changed(onCheckedChange);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            onCheckedChange.invoke(Boolean.valueOf(!z16));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    final boolean z282 = z19;
                    final int i372 = i27;
                    final Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                    BoxKt.a(ModifiersKt.M(ViewEventPropUpdaterKt.d(v36, false, null, (Function1) rememberedValue, 3, null), z19).b(iVar2), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1340283071, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2
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

                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i38) {
                            com.tencent.kuikly.core.base.h c18;
                            com.tencent.kuikly.core.base.h b18;
                            float d16;
                            Intrinsics.checkNotNullParameter(Box, "$this$Box");
                            if ((i38 & 81) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1340283071, i38, -1, "com.tencent.ntcompose.material.Switch.<anonymous> (Switch.kt:78)");
                            }
                            i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                            c18 = SwitchKt.c(b162);
                            BoxKt.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.v(ModifiersKt.M(ModifiersKt.d(companion, c18), z282), floatValue3, floatValue22), uo3.c.b()), null, null, null, composer2, 0, 14);
                            com.tencent.ntcompose.core.i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion, f272 * 2), uo3.c.b());
                            b18 = SwitchKt.b(a162);
                            com.tencent.ntcompose.core.i d17 = ModifiersKt.d(q16, b18);
                            d16 = SwitchKt.d(c172);
                            com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(d17, d16, 0.0f, 2, null);
                            Alignment alignment = Alignment.Center;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function252;
                            final int i39 = i372;
                            BoxKt.a(p16, alignment, null, ComposableLambdaKt.composableLambda(composer2, 86042558, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                                    invoke(bVar, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i46) {
                                    Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                    if ((i46 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(86042558, i46, -1, "com.tencent.ntcompose.material.Switch.<anonymous>.<anonymous> (Switch.kt:98)");
                                    }
                                    Function2<Composer, Integer, Unit> function27 = function26;
                                    if (function27 != null) {
                                        function27.invoke(composer3, Integer.valueOf((i39 >> 9) & 14));
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 3120, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, 3120, 4);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f19 = f292;
                    z26 = z19;
                    afVar2 = afVar42;
                    function24 = function23;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f17 = f16;
                i26 = i16 & 32;
                if (i26 == 0) {
                }
                z18 = z17;
                if ((3670016 & i3) == 0) {
                }
                if ((i17 & 2995931) != 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i29 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if ((i16 & 64) != 0) {
                }
                z19 = z27;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i3622 = ((i27 >> 15) & 14) | ((i27 << 3) & 112) | ((i27 >> 12) & 896);
                final State<com.tencent.kuikly.core.base.h> a1622 = afVar3.a(z19, z16, startRestartGroup, i3622);
                final State<com.tencent.kuikly.core.base.h> b1622 = afVar3.b(z19, z16, startRestartGroup, i3622);
                ModifierAttribute modifierAttribute22 = new ModifierAttribute(iVar2);
                Float c1622 = modifierAttribute22.c();
                final float floatValue32 = c1622 != null ? c1622.floatValue() : ag.f339378a.c();
                Float b1722 = modifierAttribute22.b();
                final float floatValue222 = b1722 != null ? b1722.floatValue() : ag.f339378a.b();
                float f2622 = 2;
                final float f2722 = (floatValue222 / f2622) - f18;
                final State<Float> c1722 = AnimateAsStateKt.c(z16 ? ((floatValue32 / f2622) - f2722) - f18 : ((-floatValue32) / f2622) + f2722 + f18, null, null, startRestartGroup, 0, 6);
                af afVar422 = afVar3;
                float f2822 = (-f18) * f2622;
                float f2922 = f18;
                com.tencent.ntcompose.core.i v362 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, floatValue32 + Math.max(0.0f, f2822), Math.max(0.0f, f2822) + floatValue222);
                Boolean valueOf22 = Boolean.valueOf(z16);
                startRestartGroup.startReplaceableGroup(511388516);
                changed = startRestartGroup.changed(valueOf22) | startRestartGroup.changed(onCheckedChange);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        onCheckedChange.invoke(Boolean.valueOf(!z16));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                final boolean z2822 = z19;
                final int i3722 = i27;
                final Function2<? super Composer, ? super Integer, Unit> function2522 = function23;
                BoxKt.a(ModifiersKt.M(ViewEventPropUpdaterKt.d(v362, false, null, (Function1) rememberedValue, 3, null), z19).b(iVar2), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1340283071, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2
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

                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i38) {
                        com.tencent.kuikly.core.base.h c18;
                        com.tencent.kuikly.core.base.h b18;
                        float d16;
                        Intrinsics.checkNotNullParameter(Box, "$this$Box");
                        if ((i38 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1340283071, i38, -1, "com.tencent.ntcompose.material.Switch.<anonymous> (Switch.kt:78)");
                        }
                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                        c18 = SwitchKt.c(b1622);
                        BoxKt.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.v(ModifiersKt.M(ModifiersKt.d(companion, c18), z2822), floatValue32, floatValue222), uo3.c.b()), null, null, null, composer2, 0, 14);
                        com.tencent.ntcompose.core.i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion, f2722 * 2), uo3.c.b());
                        b18 = SwitchKt.b(a1622);
                        com.tencent.ntcompose.core.i d17 = ModifiersKt.d(q16, b18);
                        d16 = SwitchKt.d(c1722);
                        com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(d17, d16, 0.0f, 2, null);
                        Alignment alignment = Alignment.Center;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function2522;
                        final int i39 = i3722;
                        BoxKt.a(p16, alignment, null, ComposableLambdaKt.composableLambda(composer2, 86042558, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                                invoke(bVar, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i46) {
                                Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                if ((i46 & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(86042558, i46, -1, "com.tencent.ntcompose.material.Switch.<anonymous>.<anonymous> (Switch.kt:98)");
                                }
                                Function2<Composer, Integer, Unit> function27 = function26;
                                if (function27 != null) {
                                    function27.invoke(composer3, Integer.valueOf((i39 >> 9) & 14));
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3120, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 3120, 4);
                if (ComposerKt.isTraceInProgress()) {
                }
                f19 = f2922;
                z26 = z19;
                afVar2 = afVar422;
                function24 = function23;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function22 = function2;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            f17 = f16;
            i26 = i16 & 32;
            if (i26 == 0) {
            }
            z18 = z17;
            if ((3670016 & i3) == 0) {
            }
            if ((i17 & 2995931) != 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i29 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if ((i16 & 64) != 0) {
            }
            z19 = z27;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i36222 = ((i27 >> 15) & 14) | ((i27 << 3) & 112) | ((i27 >> 12) & 896);
            final State<com.tencent.kuikly.core.base.h> a16222 = afVar3.a(z19, z16, startRestartGroup, i36222);
            final State<com.tencent.kuikly.core.base.h> b16222 = afVar3.b(z19, z16, startRestartGroup, i36222);
            ModifierAttribute modifierAttribute222 = new ModifierAttribute(iVar2);
            Float c16222 = modifierAttribute222.c();
            final float floatValue322 = c16222 != null ? c16222.floatValue() : ag.f339378a.c();
            Float b17222 = modifierAttribute222.b();
            final float floatValue2222 = b17222 != null ? b17222.floatValue() : ag.f339378a.b();
            float f26222 = 2;
            final float f27222 = (floatValue2222 / f26222) - f18;
            final State<Float> c17222 = AnimateAsStateKt.c(z16 ? ((floatValue322 / f26222) - f27222) - f18 : ((-floatValue322) / f26222) + f27222 + f18, null, null, startRestartGroup, 0, 6);
            af afVar4222 = afVar3;
            float f28222 = (-f18) * f26222;
            float f29222 = f18;
            com.tencent.ntcompose.core.i v3622 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, floatValue322 + Math.max(0.0f, f28222), Math.max(0.0f, f28222) + floatValue2222);
            Boolean valueOf222 = Boolean.valueOf(z16);
            startRestartGroup.startReplaceableGroup(511388516);
            changed = startRestartGroup.changed(valueOf222) | startRestartGroup.changed(onCheckedChange);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    onCheckedChange.invoke(Boolean.valueOf(!z16));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            final boolean z28222 = z19;
            final int i37222 = i27;
            final Function2<? super Composer, ? super Integer, Unit> function25222 = function23;
            BoxKt.a(ModifiersKt.M(ViewEventPropUpdaterKt.d(v3622, false, null, (Function1) rememberedValue, 3, null), z19).b(iVar2), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1340283071, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2
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

                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i38) {
                    com.tencent.kuikly.core.base.h c18;
                    com.tencent.kuikly.core.base.h b18;
                    float d16;
                    Intrinsics.checkNotNullParameter(Box, "$this$Box");
                    if ((i38 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1340283071, i38, -1, "com.tencent.ntcompose.material.Switch.<anonymous> (Switch.kt:78)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    c18 = SwitchKt.c(b16222);
                    BoxKt.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.v(ModifiersKt.M(ModifiersKt.d(companion, c18), z28222), floatValue322, floatValue2222), uo3.c.b()), null, null, null, composer2, 0, 14);
                    com.tencent.ntcompose.core.i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion, f27222 * 2), uo3.c.b());
                    b18 = SwitchKt.b(a16222);
                    com.tencent.ntcompose.core.i d17 = ModifiersKt.d(q16, b18);
                    d16 = SwitchKt.d(c17222);
                    com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(d17, d16, 0.0f, 2, null);
                    Alignment alignment = Alignment.Center;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function25222;
                    final int i39 = i37222;
                    BoxKt.a(p16, alignment, null, ComposableLambdaKt.composableLambda(composer2, 86042558, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                            invoke(bVar, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i46) {
                            Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                            if ((i46 & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(86042558, i46, -1, "com.tencent.ntcompose.material.Switch.<anonymous>.<anonymous> (Switch.kt:98)");
                            }
                            Function2<Composer, Integer, Unit> function27 = function26;
                            if (function27 != null) {
                                function27.invoke(composer3, Integer.valueOf((i39 >> 9) & 14));
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3120, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
            }
            f19 = f29222;
            z26 = z19;
            afVar2 = afVar4222;
            function24 = function23;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        iVar2 = iVar;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        function22 = function2;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        f17 = f16;
        i26 = i16 & 32;
        if (i26 == 0) {
        }
        z18 = z17;
        if ((3670016 & i3) == 0) {
        }
        if ((i17 & 2995931) != 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i29 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if ((i16 & 64) != 0) {
        }
        z19 = z27;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i362222 = ((i27 >> 15) & 14) | ((i27 << 3) & 112) | ((i27 >> 12) & 896);
        final State<com.tencent.kuikly.core.base.h> a162222 = afVar3.a(z19, z16, startRestartGroup, i362222);
        final State<com.tencent.kuikly.core.base.h> b162222 = afVar3.b(z19, z16, startRestartGroup, i362222);
        ModifierAttribute modifierAttribute2222 = new ModifierAttribute(iVar2);
        Float c162222 = modifierAttribute2222.c();
        final float floatValue3222 = c162222 != null ? c162222.floatValue() : ag.f339378a.c();
        Float b172222 = modifierAttribute2222.b();
        final float floatValue22222 = b172222 != null ? b172222.floatValue() : ag.f339378a.b();
        float f262222 = 2;
        final float f272222 = (floatValue22222 / f262222) - f18;
        final State<Float> c172222 = AnimateAsStateKt.c(z16 ? ((floatValue3222 / f262222) - f272222) - f18 : ((-floatValue3222) / f262222) + f272222 + f18, null, null, startRestartGroup, 0, 6);
        af afVar42222 = afVar3;
        float f282222 = (-f18) * f262222;
        float f292222 = f18;
        com.tencent.ntcompose.core.i v36222 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, floatValue3222 + Math.max(0.0f, f282222), Math.max(0.0f, f282222) + floatValue22222);
        Boolean valueOf2222 = Boolean.valueOf(z16);
        startRestartGroup.startReplaceableGroup(511388516);
        changed = startRestartGroup.changed(valueOf2222) | startRestartGroup.changed(onCheckedChange);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                onCheckedChange.invoke(Boolean.valueOf(!z16));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        final boolean z282222 = z19;
        final int i372222 = i27;
        final Function2<? super Composer, ? super Integer, Unit> function252222 = function23;
        BoxKt.a(ModifiersKt.M(ViewEventPropUpdaterKt.d(v36222, false, null, (Function1) rememberedValue, 3, null), z19).b(iVar2), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1340283071, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2
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

            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i38) {
                com.tencent.kuikly.core.base.h c18;
                com.tencent.kuikly.core.base.h b18;
                float d16;
                Intrinsics.checkNotNullParameter(Box, "$this$Box");
                if ((i38 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1340283071, i38, -1, "com.tencent.ntcompose.material.Switch.<anonymous> (Switch.kt:78)");
                }
                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                c18 = SwitchKt.c(b162222);
                BoxKt.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.v(ModifiersKt.M(ModifiersKt.d(companion, c18), z282222), floatValue3222, floatValue22222), uo3.c.b()), null, null, null, composer2, 0, 14);
                com.tencent.ntcompose.core.i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion, f272222 * 2), uo3.c.b());
                b18 = SwitchKt.b(a162222);
                com.tencent.ntcompose.core.i d17 = ModifiersKt.d(q16, b18);
                d16 = SwitchKt.d(c172222);
                com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(d17, d16, 0.0f, 2, null);
                Alignment alignment = Alignment.Center;
                final Function2<? super Composer, ? super Integer, Unit> function26 = function252222;
                final int i39 = i372222;
                BoxKt.a(p16, alignment, null, ComposableLambdaKt.composableLambda(composer2, 86042558, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SwitchKt$Switch$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                        invoke(bVar, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i46) {
                        Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                        if ((i46 & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(86042558, i46, -1, "com.tencent.ntcompose.material.Switch.<anonymous>.<anonymous> (Switch.kt:98)");
                        }
                        Function2<Composer, Integer, Unit> function27 = function26;
                        if (function27 != null) {
                            function27.invoke(composer3, Integer.valueOf((i39 >> 9) & 14));
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3120, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 3120, 4);
        if (ComposerKt.isTraceInProgress()) {
        }
        f19 = f292222;
        z26 = z19;
        afVar2 = afVar42222;
        function24 = function23;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.kuikly.core.base.h b(State<com.tencent.kuikly.core.base.h> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.kuikly.core.base.h c(State<com.tencent.kuikly.core.base.h> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(State<Float> state) {
        return state.getValue().floatValue();
    }
}
