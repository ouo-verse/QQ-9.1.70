package com.tencent.ntcompose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00d6\u0001\u0010\u001c\u001a\u00020\u00062B\b\u0002\u0010\t\u001a<\u0012\u0004\u0012\u00020\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007\u00a2\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0019\u00a2\u0006\u0002\b\u001aH\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "", "isRow", "", "top", "left", "bottom", "right", "width", "height", "Lcom/tencent/ntcompose/foundation/layout/MainAxisAlign;", "mainAxisAlign", "Lcom/tencent/ntcompose/foundation/layout/CrossAxisAlign;", "crossAxisAlign", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/tencent/ntcompose/foundation/layout/MainAxisAlign;Lcom/tencent/ntcompose/foundation/layout/CrossAxisAlign;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AbsoluteLayoutKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Function2<? super v, ? super aa<v>, Unit> function2, com.tencent.ntcompose.core.i iVar, boolean z16, Float f16, Float f17, Float f18, Float f19, Float f26, Float f27, MainAxisAlign mainAxisAlign, CrossAxisAlign crossAxisAlign, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16, final int i17) {
        int i18;
        int i19;
        boolean z17;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        final int i47;
        Float f28;
        Float f29;
        Float f36;
        Float f37;
        Float f38;
        Float f39;
        boolean z18;
        Function2<? super v, ? super aa<v>, Unit> function22;
        final Float f46;
        final Float f47;
        final MainAxisAlign mainAxisAlign2;
        final com.tencent.ntcompose.core.i iVar2;
        final Float f48;
        final Float f49;
        final Float f56;
        final boolean z19;
        final CrossAxisAlign crossAxisAlign2;
        final Float f57;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(651477318);
        int i48 = i17 & 1;
        if (i48 != 0) {
            i18 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i18 = (startRestartGroup.changed(function2) ? 4 : 2) | i3;
        } else {
            i18 = i3;
        }
        int i49 = i17 & 2;
        if (i49 != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(iVar) ? 32 : 16;
            i19 = i17 & 4;
            if (i19 == 0) {
                i18 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                z17 = z16;
                i18 |= startRestartGroup.changed(z17) ? 256 : 128;
                i26 = i17 & 8;
                if (i26 != 0) {
                    i18 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    i18 |= startRestartGroup.changed(f16) ? 2048 : 1024;
                    i27 = i17 & 16;
                    if (i27 == 0) {
                        i18 |= 24576;
                    } else if ((i3 & 57344) == 0) {
                        i18 |= startRestartGroup.changed(f17) ? 16384 : 8192;
                    }
                    i28 = i17 & 32;
                    if (i28 == 0) {
                        i18 |= 196608;
                    } else if ((i3 & 458752) == 0) {
                        i18 |= startRestartGroup.changed(f18) ? 131072 : 65536;
                    }
                    i29 = i17 & 64;
                    if (i29 == 0) {
                        i18 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        i18 |= startRestartGroup.changed(f19) ? 1048576 : 524288;
                    }
                    i36 = i17 & 128;
                    if (i36 == 0) {
                        i18 |= 12582912;
                    } else if ((i3 & 29360128) == 0) {
                        i18 |= startRestartGroup.changed(f26) ? 8388608 : 4194304;
                    }
                    i37 = i17 & 256;
                    if (i37 == 0) {
                        i18 |= 100663296;
                    } else if ((i3 & 234881024) == 0) {
                        i18 |= startRestartGroup.changed(f27) ? 67108864 : 33554432;
                    }
                    i38 = i17 & 512;
                    if (i38 == 0) {
                        i18 |= 805306368;
                    } else if ((i3 & 1879048192) == 0) {
                        i18 |= startRestartGroup.changed(mainAxisAlign) ? 536870912 : 268435456;
                    }
                    i39 = i17 & 1024;
                    if (i39 == 0) {
                        i46 = i16 | 6;
                    } else if ((i16 & 14) == 0) {
                        i46 = i16 | (startRestartGroup.changed(crossAxisAlign) ? 4 : 2);
                    } else {
                        i46 = i16;
                    }
                    if ((i17 & 2048) == 0) {
                        i46 |= 48;
                    } else if ((i16 & 112) == 0) {
                        i46 |= startRestartGroup.changed(content) ? 32 : 16;
                    }
                    i47 = i46;
                    if ((i18 & 1533916891) != 306783378 && (i47 & 91) == 18 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        function22 = function2;
                        iVar2 = iVar;
                        f48 = f16;
                        f57 = f17;
                        f49 = f18;
                        f56 = f19;
                        f46 = f26;
                        f47 = f27;
                        mainAxisAlign2 = mainAxisAlign;
                        crossAxisAlign2 = crossAxisAlign;
                        z19 = z17;
                    } else {
                        Function2<? super v, ? super aa<v>, Unit> function23 = i48 == 0 ? null : function2;
                        com.tencent.ntcompose.core.i iVar3 = i49 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                        boolean z26 = i19 == 0 ? false : z17;
                        f28 = i26 == 0 ? null : f16;
                        f29 = i27 == 0 ? null : f17;
                        f36 = i28 == 0 ? null : f18;
                        f37 = i29 == 0 ? null : f19;
                        f38 = i36 == 0 ? null : f26;
                        f39 = i37 == 0 ? null : f27;
                        MainAxisAlign mainAxisAlign3 = i38 == 0 ? MainAxisAlign.START : mainAxisAlign;
                        CrossAxisAlign crossAxisAlign3 = i39 == 0 ? CrossAxisAlign.STRETCH : crossAxisAlign;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(651477318, i18, i47, "com.tencent.ntcompose.foundation.layout.BoxInParent (AbsoluteLayout.kt:31)");
                        }
                        ArrayList arrayList = new ArrayList();
                        Boolean valueOf = Boolean.valueOf(z26);
                        a aVar = a.f339244a;
                        arrayList.add(new com.tencent.ntcompose.core.k("al_isRow", valueOf, null, null, null, null, aVar, 60, null));
                        if (f28 == null) {
                            z18 = z26;
                            arrayList.add(new com.tencent.ntcompose.core.k("al_top", Float.valueOf(f28.floatValue()), null, null, null, null, aVar, 60, null));
                        } else {
                            z18 = z26;
                        }
                        if (f29 != null) {
                            arrayList.add(new com.tencent.ntcompose.core.k("al_left", Float.valueOf(f29.floatValue()), null, null, null, null, aVar, 60, null));
                        }
                        if (f36 != null) {
                            arrayList.add(new com.tencent.ntcompose.core.k("al_bottom", Float.valueOf(f36.floatValue()), null, null, null, null, aVar, 60, null));
                        }
                        if (f37 != null) {
                            arrayList.add(new com.tencent.ntcompose.core.k("al_right", Float.valueOf(f37.floatValue()), null, null, null, null, aVar, 60, null));
                        }
                        if (f38 != null) {
                            arrayList.add(new com.tencent.ntcompose.core.k("al_width", Float.valueOf(f38.floatValue()), null, null, null, null, aVar, 60, null));
                        }
                        if (f39 != null) {
                            arrayList.add(new com.tencent.ntcompose.core.k("al_height", Float.valueOf(f39.floatValue()), null, null, null, null, aVar, 60, null));
                        }
                        arrayList.add(new com.tencent.ntcompose.core.k("al_mainAxisAlign", mainAxisAlign3, null, null, null, null, aVar, 60, null));
                        arrayList.add(new com.tencent.ntcompose.core.k("al_crossAxisAlign", crossAxisAlign3, null, null, null, null, aVar, 60, null));
                        Float f58 = f38;
                        function22 = function23;
                        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, ComposableLambdaKt.composableLambda(startRestartGroup, 137218204, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.AbsoluteLayoutKt$BoxInParent$1
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

                            public final void invoke(Composer composer2, int i56) {
                                if ((i56 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(137218204, i56, -1, "com.tencent.ntcompose.foundation.layout.BoxInParent.<anonymous> (AbsoluteLayout.kt:78)");
                                }
                                content.invoke(composer2, Integer.valueOf((i47 >> 3) & 14));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), startRestartGroup, ((i18 << 6) & 7168) | 229430, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f46 = f58;
                        f47 = f39;
                        mainAxisAlign2 = mainAxisAlign3;
                        iVar2 = iVar3;
                        f48 = f28;
                        f49 = f36;
                        f56 = f37;
                        z19 = z18;
                        crossAxisAlign2 = crossAxisAlign3;
                        f57 = f29;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final Function2<? super v, ? super aa<v>, Unit> function24 = function22;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.AbsoluteLayoutKt$BoxInParent$2
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

                        public final void invoke(Composer composer2, int i56) {
                            AbsoluteLayoutKt.a(function24, iVar2, z19, f48, f57, f49, f56, f46, f47, mainAxisAlign2, crossAxisAlign2, content, composer2, i3 | 1, i16, i17);
                        }
                    });
                    return;
                }
                i27 = i17 & 16;
                if (i27 == 0) {
                }
                i28 = i17 & 32;
                if (i28 == 0) {
                }
                i29 = i17 & 64;
                if (i29 == 0) {
                }
                i36 = i17 & 128;
                if (i36 == 0) {
                }
                i37 = i17 & 256;
                if (i37 == 0) {
                }
                i38 = i17 & 512;
                if (i38 == 0) {
                }
                i39 = i17 & 1024;
                if (i39 == 0) {
                }
                if ((i17 & 2048) == 0) {
                }
                i47 = i46;
                if ((i18 & 1533916891) != 306783378) {
                }
                if (i48 == 0) {
                }
                if (i49 == 0) {
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
                if (i38 == 0) {
                }
                if (i39 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList2 = new ArrayList();
                Boolean valueOf2 = Boolean.valueOf(z26);
                a aVar2 = a.f339244a;
                arrayList2.add(new com.tencent.ntcompose.core.k("al_isRow", valueOf2, null, null, null, null, aVar2, 60, null));
                if (f28 == null) {
                }
                if (f29 != null) {
                }
                if (f36 != null) {
                }
                if (f37 != null) {
                }
                if (f38 != null) {
                }
                if (f39 != null) {
                }
                arrayList2.add(new com.tencent.ntcompose.core.k("al_mainAxisAlign", mainAxisAlign3, null, null, null, null, aVar2, 60, null));
                arrayList2.add(new com.tencent.ntcompose.core.k("al_crossAxisAlign", crossAxisAlign3, null, null, null, null, aVar2, 60, null));
                Float f582 = f38;
                function22 = function23;
                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList2, ComposableLambdaKt.composableLambda(startRestartGroup, 137218204, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.AbsoluteLayoutKt$BoxInParent$1
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

                    public final void invoke(Composer composer2, int i56) {
                        if ((i56 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(137218204, i56, -1, "com.tencent.ntcompose.foundation.layout.BoxInParent.<anonymous> (AbsoluteLayout.kt:78)");
                        }
                        content.invoke(composer2, Integer.valueOf((i47 >> 3) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, ((i18 << 6) & 7168) | 229430, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f46 = f582;
                f47 = f39;
                mainAxisAlign2 = mainAxisAlign3;
                iVar2 = iVar3;
                f48 = f28;
                f49 = f36;
                f56 = f37;
                z19 = z18;
                crossAxisAlign2 = crossAxisAlign3;
                f57 = f29;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z17 = z16;
            i26 = i17 & 8;
            if (i26 != 0) {
            }
            i27 = i17 & 16;
            if (i27 == 0) {
            }
            i28 = i17 & 32;
            if (i28 == 0) {
            }
            i29 = i17 & 64;
            if (i29 == 0) {
            }
            i36 = i17 & 128;
            if (i36 == 0) {
            }
            i37 = i17 & 256;
            if (i37 == 0) {
            }
            i38 = i17 & 512;
            if (i38 == 0) {
            }
            i39 = i17 & 1024;
            if (i39 == 0) {
            }
            if ((i17 & 2048) == 0) {
            }
            i47 = i46;
            if ((i18 & 1533916891) != 306783378) {
            }
            if (i48 == 0) {
            }
            if (i49 == 0) {
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
            if (i38 == 0) {
            }
            if (i39 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList22 = new ArrayList();
            Boolean valueOf22 = Boolean.valueOf(z26);
            a aVar22 = a.f339244a;
            arrayList22.add(new com.tencent.ntcompose.core.k("al_isRow", valueOf22, null, null, null, null, aVar22, 60, null));
            if (f28 == null) {
            }
            if (f29 != null) {
            }
            if (f36 != null) {
            }
            if (f37 != null) {
            }
            if (f38 != null) {
            }
            if (f39 != null) {
            }
            arrayList22.add(new com.tencent.ntcompose.core.k("al_mainAxisAlign", mainAxisAlign3, null, null, null, null, aVar22, 60, null));
            arrayList22.add(new com.tencent.ntcompose.core.k("al_crossAxisAlign", crossAxisAlign3, null, null, null, null, aVar22, 60, null));
            Float f5822 = f38;
            function22 = function23;
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList22, ComposableLambdaKt.composableLambda(startRestartGroup, 137218204, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.AbsoluteLayoutKt$BoxInParent$1
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

                public final void invoke(Composer composer2, int i56) {
                    if ((i56 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(137218204, i56, -1, "com.tencent.ntcompose.foundation.layout.BoxInParent.<anonymous> (AbsoluteLayout.kt:78)");
                    }
                    content.invoke(composer2, Integer.valueOf((i47 >> 3) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, ((i18 << 6) & 7168) | 229430, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f46 = f5822;
            f47 = f39;
            mainAxisAlign2 = mainAxisAlign3;
            iVar2 = iVar3;
            f48 = f28;
            f49 = f36;
            f56 = f37;
            z19 = z18;
            crossAxisAlign2 = crossAxisAlign3;
            f57 = f29;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i19 = i17 & 4;
        if (i19 == 0) {
        }
        z17 = z16;
        i26 = i17 & 8;
        if (i26 != 0) {
        }
        i27 = i17 & 16;
        if (i27 == 0) {
        }
        i28 = i17 & 32;
        if (i28 == 0) {
        }
        i29 = i17 & 64;
        if (i29 == 0) {
        }
        i36 = i17 & 128;
        if (i36 == 0) {
        }
        i37 = i17 & 256;
        if (i37 == 0) {
        }
        i38 = i17 & 512;
        if (i38 == 0) {
        }
        i39 = i17 & 1024;
        if (i39 == 0) {
        }
        if ((i17 & 2048) == 0) {
        }
        i47 = i46;
        if ((i18 & 1533916891) != 306783378) {
        }
        if (i48 == 0) {
        }
        if (i49 == 0) {
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
        if (i38 == 0) {
        }
        if (i39 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList222 = new ArrayList();
        Boolean valueOf222 = Boolean.valueOf(z26);
        a aVar222 = a.f339244a;
        arrayList222.add(new com.tencent.ntcompose.core.k("al_isRow", valueOf222, null, null, null, null, aVar222, 60, null));
        if (f28 == null) {
        }
        if (f29 != null) {
        }
        if (f36 != null) {
        }
        if (f37 != null) {
        }
        if (f38 != null) {
        }
        if (f39 != null) {
        }
        arrayList222.add(new com.tencent.ntcompose.core.k("al_mainAxisAlign", mainAxisAlign3, null, null, null, null, aVar222, 60, null));
        arrayList222.add(new com.tencent.ntcompose.core.k("al_crossAxisAlign", crossAxisAlign3, null, null, null, null, aVar222, 60, null));
        Float f58222 = f38;
        function22 = function23;
        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList222, ComposableLambdaKt.composableLambda(startRestartGroup, 137218204, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.AbsoluteLayoutKt$BoxInParent$1
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

            public final void invoke(Composer composer2, int i56) {
                if ((i56 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(137218204, i56, -1, "com.tencent.ntcompose.foundation.layout.BoxInParent.<anonymous> (AbsoluteLayout.kt:78)");
                }
                content.invoke(composer2, Integer.valueOf((i47 >> 3) & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, ((i18 << 6) & 7168) | 229430, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f46 = f58222;
        f47 = f39;
        mainAxisAlign2 = mainAxisAlign3;
        iVar2 = iVar3;
        f48 = f28;
        f49 = f36;
        f56 = f37;
        z19 = z18;
        crossAxisAlign2 = crossAxisAlign3;
        f57 = f29;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
