package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.views.ax;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qq.effect.engine.QEffectType;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0086\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002B\b\u0002\u0010\u000b\u001a<\u0012\u0004\u0012\u00020\u0003\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t\u00a2\u0006\u0002\b\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2-\b\u0002\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011j\u0004\u0018\u0001`\u00142-\b\u0002\u0010\u0016\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011j\u0004\u0018\u0001`\u00142-\b\u0002\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011j\u0004\u0018\u0001`\u0014H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/ax;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "", "srcUrl", "", "loopAnimation", "autoPlay", "Lkotlin/Function1;", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onLoadFailure", "onAnimationStart", "onAnimationEnd", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Ljava/lang/String;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LottieKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Function2<? super ax, ? super com.tencent.kuikly.core.base.aa<ax>, Unit> function2, final String srcUrl, boolean z16, boolean z17, Function1<Object, Unit> function1, Function1<Object, Unit> function12, Function1<Object, Unit> function13, Composer composer, final int i3, final int i16) {
        int i17;
        int i18;
        boolean z18;
        int i19;
        boolean z19;
        int i26;
        Function1<Object, Unit> function14;
        int i27;
        int i28;
        Function1<Object, Unit> function15;
        Function1<Object, Unit> function16;
        final Function1<Object, Unit> function17;
        final Function1<Object, Unit> function18;
        final Function1<Object, Unit> function19;
        final com.tencent.ntcompose.core.i iVar2;
        final Function2<? super ax, ? super com.tencent.kuikly.core.base.aa<ax>, Unit> function22;
        final boolean z26;
        final boolean z27;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        Composer startRestartGroup = composer.startRestartGroup(1405474584);
        int i29 = i16 & 1;
        if (i29 != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(iVar) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i36 = i16 & 2;
        if (i36 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(function2) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i17 |= startRestartGroup.changed(srcUrl) ? 256 : 128;
            }
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                z18 = z16;
                i17 |= startRestartGroup.changed(z18) ? 2048 : 1024;
                i19 = i16 & 16;
                if (i19 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    z19 = z17;
                    i17 |= startRestartGroup.changed(z19) ? 16384 : 8192;
                    i26 = i16 & 32;
                    if (i26 == 0) {
                        i17 |= 196608;
                    } else if ((458752 & i3) == 0) {
                        function14 = function1;
                        i17 |= startRestartGroup.changed(function14) ? 131072 : 65536;
                        i27 = i16 & 64;
                        if (i27 != 0) {
                            i17 |= 1572864;
                        } else if ((i3 & 3670016) == 0) {
                            i17 |= startRestartGroup.changed(function12) ? 1048576 : 524288;
                        }
                        i28 = i16 & 128;
                        if (i28 != 0) {
                            i17 |= 12582912;
                        } else if ((i3 & 29360128) == 0) {
                            i17 |= startRestartGroup.changed(function13) ? 8388608 : 4194304;
                        }
                        if ((i17 & 23967451) != 4793490 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar2 = iVar;
                            function22 = function2;
                            function19 = function13;
                            z26 = z18;
                            z27 = z19;
                            function18 = function14;
                            function17 = function12;
                        } else {
                            com.tencent.ntcompose.core.i iVar3 = i29 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                            Function2<? super ax, ? super com.tencent.kuikly.core.base.aa<ax>, Unit> function23 = i36 != 0 ? null : function2;
                            boolean z28 = i18 != 0 ? true : z18;
                            boolean z29 = i19 != 0 ? true : z19;
                            if (i26 != 0) {
                                function14 = null;
                            }
                            function15 = i27 != 0 ? null : function12;
                            function16 = i28 != 0 ? null : function13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1405474584, i17, -1, "com.tencent.ntcompose.material.Lottie (Lottie.kt:48)");
                            }
                            ArrayList arrayList = new ArrayList();
                            Boolean valueOf = Boolean.valueOf(z28);
                            x xVar = x.f339450a;
                            arrayList.add(new com.tencent.ntcompose.core.k("loopAnimation", valueOf, null, null, null, null, xVar, 60, null));
                            arrayList.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z29), null, null, null, null, xVar, 60, null));
                            if (function14 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("onLoadFailure", function14, null, null, null, null, xVar, 60, null));
                            }
                            if (function15 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("onAnimationStart", function15, null, null, null, null, xVar, 60, null));
                            }
                            if (function16 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("onAnimationEnd", function16, null, null, null, null, xVar, 60, null));
                            }
                            int i37 = i17;
                            arrayList.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, xVar, 60, null));
                            ComposeNodeKt.a(QEffectType.LOTTIE_TAG, com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i37 << 9) & 7168) | 32822, 32);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function17 = function15;
                            function18 = function14;
                            function19 = function16;
                            iVar2 = iVar3;
                            function22 = function23;
                            z26 = z28;
                            z27 = z29;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LottieKt$Lottie$1
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
                                LottieKt.a(com.tencent.ntcompose.core.i.this, function22, srcUrl, z26, z27, function18, function17, function19, composer2, i3 | 1, i16);
                            }
                        });
                        return;
                    }
                    function14 = function1;
                    i27 = i16 & 64;
                    if (i27 != 0) {
                    }
                    i28 = i16 & 128;
                    if (i28 != 0) {
                    }
                    if ((i17 & 23967451) != 4793490) {
                    }
                    if (i29 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Boolean valueOf2 = Boolean.valueOf(z28);
                    x xVar2 = x.f339450a;
                    arrayList2.add(new com.tencent.ntcompose.core.k("loopAnimation", valueOf2, null, null, null, null, xVar2, 60, null));
                    arrayList2.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z29), null, null, null, null, xVar2, 60, null));
                    if (function14 != null) {
                    }
                    if (function15 != null) {
                    }
                    if (function16 != null) {
                    }
                    int i372 = i17;
                    arrayList2.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, xVar2, 60, null));
                    ComposeNodeKt.a(QEffectType.LOTTIE_TAG, com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList2, null, startRestartGroup, ((i372 << 9) & 7168) | 32822, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function17 = function15;
                    function18 = function14;
                    function19 = function16;
                    iVar2 = iVar3;
                    function22 = function23;
                    z26 = z28;
                    z27 = z29;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z19 = z17;
                i26 = i16 & 32;
                if (i26 == 0) {
                }
                function14 = function1;
                i27 = i16 & 64;
                if (i27 != 0) {
                }
                i28 = i16 & 128;
                if (i28 != 0) {
                }
                if ((i17 & 23967451) != 4793490) {
                }
                if (i29 != 0) {
                }
                if (i36 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
                if (i28 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList22 = new ArrayList();
                Boolean valueOf22 = Boolean.valueOf(z28);
                x xVar22 = x.f339450a;
                arrayList22.add(new com.tencent.ntcompose.core.k("loopAnimation", valueOf22, null, null, null, null, xVar22, 60, null));
                arrayList22.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z29), null, null, null, null, xVar22, 60, null));
                if (function14 != null) {
                }
                if (function15 != null) {
                }
                if (function16 != null) {
                }
                int i3722 = i17;
                arrayList22.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, xVar22, 60, null));
                ComposeNodeKt.a(QEffectType.LOTTIE_TAG, com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList22, null, startRestartGroup, ((i3722 << 9) & 7168) | 32822, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                function17 = function15;
                function18 = function14;
                function19 = function16;
                iVar2 = iVar3;
                function22 = function23;
                z26 = z28;
                z27 = z29;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z18 = z16;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            z19 = z17;
            i26 = i16 & 32;
            if (i26 == 0) {
            }
            function14 = function1;
            i27 = i16 & 64;
            if (i27 != 0) {
            }
            i28 = i16 & 128;
            if (i28 != 0) {
            }
            if ((i17 & 23967451) != 4793490) {
            }
            if (i29 != 0) {
            }
            if (i36 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            if (i28 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList222 = new ArrayList();
            Boolean valueOf222 = Boolean.valueOf(z28);
            x xVar222 = x.f339450a;
            arrayList222.add(new com.tencent.ntcompose.core.k("loopAnimation", valueOf222, null, null, null, null, xVar222, 60, null));
            arrayList222.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z29), null, null, null, null, xVar222, 60, null));
            if (function14 != null) {
            }
            if (function15 != null) {
            }
            if (function16 != null) {
            }
            int i37222 = i17;
            arrayList222.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, xVar222, 60, null));
            ComposeNodeKt.a(QEffectType.LOTTIE_TAG, com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList222, null, startRestartGroup, ((i37222 << 9) & 7168) | 32822, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            function17 = function15;
            function18 = function14;
            function19 = function16;
            iVar2 = iVar3;
            function22 = function23;
            z26 = z28;
            z27 = z29;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i16 & 4) == 0) {
        }
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        z18 = z16;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        z19 = z17;
        i26 = i16 & 32;
        if (i26 == 0) {
        }
        function14 = function1;
        i27 = i16 & 64;
        if (i27 != 0) {
        }
        i28 = i16 & 128;
        if (i28 != 0) {
        }
        if ((i17 & 23967451) != 4793490) {
        }
        if (i29 != 0) {
        }
        if (i36 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        if (i28 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList2222 = new ArrayList();
        Boolean valueOf2222 = Boolean.valueOf(z28);
        x xVar2222 = x.f339450a;
        arrayList2222.add(new com.tencent.ntcompose.core.k("loopAnimation", valueOf2222, null, null, null, null, xVar2222, 60, null));
        arrayList2222.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z29), null, null, null, null, xVar2222, 60, null));
        if (function14 != null) {
        }
        if (function15 != null) {
        }
        if (function16 != null) {
        }
        int i372222 = i17;
        arrayList2222.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, xVar2222, 60, null));
        ComposeNodeKt.a(QEffectType.LOTTIE_TAG, com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList2222, null, startRestartGroup, ((i372222 << 9) & 7168) | 32822, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        function17 = function15;
        function18 = function14;
        function19 = function16;
        iVar2 = iVar3;
        function22 = function23;
        z26 = z28;
        z27 = z29;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
