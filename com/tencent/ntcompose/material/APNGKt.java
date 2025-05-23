package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.views.APNGVView;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008a\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002B\b\u0002\u0010\u000b\u001a<\u0012\u0004\u0012\u00020\u0003\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t\u00a2\u0006\u0002\b\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102-\b\u0002\u0010\u0016\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012j\u0004\u0018\u0001`\u00152-\b\u0002\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012j\u0004\u0018\u0001`\u00152-\b\u0002\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012j\u0004\u0018\u0001`\u0015H\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/APNGVView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "", "srcUrl", "", "repeatCount", "", "autoPlay", "Lkotlin/Function1;", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onLoadFailure", "onAnimationStart", "onAnimationEnd", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class APNGKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Function2<? super APNGVView, ? super com.tencent.kuikly.core.base.aa<APNGVView>, Unit> function2, final String srcUrl, Integer num, Boolean bool, Function1<Object, Unit> function1, Function1<Object, Unit> function12, Function1<Object, Unit> function13, Composer composer, final int i3, final int i16) {
        int i17;
        int i18;
        Integer num2;
        int i19;
        Boolean bool2;
        int i26;
        Function1<Object, Unit> function14;
        int i27;
        int i28;
        Integer num3;
        Boolean bool3;
        Function1<Object, Unit> function15;
        Function1<Object, Unit> function16;
        final Function1<Object, Unit> function17;
        final Function1<Object, Unit> function18;
        final Function1<Object, Unit> function19;
        final com.tencent.ntcompose.core.i iVar2;
        final Function2<? super APNGVView, ? super com.tencent.kuikly.core.base.aa<APNGVView>, Unit> function22;
        final Integer num4;
        final Boolean bool4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        Composer startRestartGroup = composer.startRestartGroup(-193102433);
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
                num2 = num;
                i17 |= startRestartGroup.changed(num2) ? 2048 : 1024;
                i19 = i16 & 16;
                if (i19 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    bool2 = bool;
                    i17 |= startRestartGroup.changed(bool2) ? 16384 : 8192;
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
                            num4 = num2;
                            bool4 = bool2;
                            function18 = function14;
                            function17 = function12;
                        } else {
                            com.tencent.ntcompose.core.i iVar3 = i29 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                            Function2<? super APNGVView, ? super com.tencent.kuikly.core.base.aa<APNGVView>, Unit> function23 = i36 != 0 ? null : function2;
                            num3 = i18 != 0 ? null : num2;
                            bool3 = i19 != 0 ? null : bool2;
                            if (i26 != 0) {
                                function14 = null;
                            }
                            function15 = i27 != 0 ? null : function12;
                            function16 = i28 != 0 ? null : function13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-193102433, i17, -1, "com.tencent.ntcompose.material.APNG (APNG.kt:45)");
                            }
                            ArrayList arrayList = new ArrayList();
                            a aVar = a.f339358a;
                            int i37 = i17;
                            arrayList.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, aVar, 60, null));
                            if (num3 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("repeatCount", Integer.valueOf(num3.intValue()), null, null, null, null, aVar, 60, null));
                            }
                            if (bool3 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(bool3.booleanValue()), null, null, null, null, aVar, 60, null));
                            }
                            if (function14 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("onLoadFailure", function14, null, null, null, null, aVar, 60, null));
                            }
                            if (function15 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("onAnimationStart", function15, null, null, null, null, aVar, 60, null));
                            }
                            if (function16 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("onAnimationEnd", function16, null, null, null, null, aVar, 60, null));
                            }
                            ComposeNodeKt.a("apng", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i37 << 9) & 7168) | 32822, 32);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function17 = function15;
                            function18 = function14;
                            function19 = function16;
                            iVar2 = iVar3;
                            function22 = function23;
                            num4 = num3;
                            bool4 = bool3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.APNGKt$APNG$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num5) {
                                invoke(composer2, num5.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i38) {
                                APNGKt.a(com.tencent.ntcompose.core.i.this, function22, srcUrl, num4, bool4, function18, function17, function19, composer2, i3 | 1, i16);
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
                    a aVar2 = a.f339358a;
                    int i372 = i17;
                    arrayList2.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, aVar2, 60, null));
                    if (num3 != null) {
                    }
                    if (bool3 != null) {
                    }
                    if (function14 != null) {
                    }
                    if (function15 != null) {
                    }
                    if (function16 != null) {
                    }
                    ComposeNodeKt.a("apng", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList2, null, startRestartGroup, ((i372 << 9) & 7168) | 32822, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function17 = function15;
                    function18 = function14;
                    function19 = function16;
                    iVar2 = iVar3;
                    function22 = function23;
                    num4 = num3;
                    bool4 = bool3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                bool2 = bool;
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
                a aVar22 = a.f339358a;
                int i3722 = i17;
                arrayList22.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, aVar22, 60, null));
                if (num3 != null) {
                }
                if (bool3 != null) {
                }
                if (function14 != null) {
                }
                if (function15 != null) {
                }
                if (function16 != null) {
                }
                ComposeNodeKt.a("apng", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList22, null, startRestartGroup, ((i3722 << 9) & 7168) | 32822, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                function17 = function15;
                function18 = function14;
                function19 = function16;
                iVar2 = iVar3;
                function22 = function23;
                num4 = num3;
                bool4 = bool3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            num2 = num;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            bool2 = bool;
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
            a aVar222 = a.f339358a;
            int i37222 = i17;
            arrayList222.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, aVar222, 60, null));
            if (num3 != null) {
            }
            if (bool3 != null) {
            }
            if (function14 != null) {
            }
            if (function15 != null) {
            }
            if (function16 != null) {
            }
            ComposeNodeKt.a("apng", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList222, null, startRestartGroup, ((i37222 << 9) & 7168) | 32822, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            function17 = function15;
            function18 = function14;
            function19 = function16;
            iVar2 = iVar3;
            function22 = function23;
            num4 = num3;
            bool4 = bool3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i16 & 4) == 0) {
        }
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        num2 = num;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        bool2 = bool;
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
        a aVar2222 = a.f339358a;
        int i372222 = i17;
        arrayList2222.add(new com.tencent.ntcompose.core.k("src_url", srcUrl, null, null, null, null, aVar2222, 60, null));
        if (num3 != null) {
        }
        if (bool3 != null) {
        }
        if (function14 != null) {
        }
        if (function15 != null) {
        }
        if (function16 != null) {
        }
        ComposeNodeKt.a("apng", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, iVar3, arrayList2222, null, startRestartGroup, ((i372222 << 9) & 7168) | 32822, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        function17 = function15;
        function18 = function14;
        function19 = function16;
        iVar2 = iVar3;
        function22 = function23;
        num4 = num3;
        bool4 = bool3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
