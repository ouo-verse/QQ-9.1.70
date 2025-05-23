package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.views.bc;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0096\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002B\b\u0002\u0010\u000b\u001a<\u0012\u0004\u0012\u00020\u0003\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t\u00a2\u0006\u0002\b\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122-\b\u0002\u0010\u0018\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00172-\b\u0002\u0010\u0019\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00172-\b\u0002\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u0017H\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/bc;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "", "srcUrl", "Lcom/tencent/kuikly/core/base/attr/e;", "srcUri", "", "repeatCount", "", "autoPlay", "Lkotlin/Function1;", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onLoadFailure", "onAnimationStart", "onAnimationEnd", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lcom/tencent/kuikly/core/base/attr/e;IZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PAGKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Function2<? super bc, ? super com.tencent.kuikly.core.base.aa<bc>, Unit> function2, String str, com.tencent.kuikly.core.base.attr.e eVar, int i3, boolean z16, Function1<Object, Unit> function1, Function1<Object, Unit> function12, Function1<Object, Unit> function13, Composer composer, final int i16, final int i17) {
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z17;
        int i36;
        int i37;
        int i38;
        com.tencent.ntcompose.core.i iVar2;
        Function2<? super bc, ? super com.tencent.kuikly.core.base.aa<bc>, Unit> function22;
        String str2;
        com.tencent.kuikly.core.base.attr.e eVar2;
        Function1<Object, Unit> function14;
        Function1<Object, Unit> function15;
        Function1<Object, Unit> function16;
        final com.tencent.kuikly.core.base.attr.e eVar3;
        final boolean z18;
        final Function1<Object, Unit> function17;
        final Function1<Object, Unit> function18;
        final String str3;
        final Function1<Object, Unit> function19;
        ScopeUpdateScope endRestartGroup;
        int i39;
        Composer startRestartGroup = composer.startRestartGroup(179871568);
        int i46 = i17 & 1;
        if (i46 != 0) {
            i18 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i18 = (startRestartGroup.changed(iVar) ? 4 : 2) | i16;
        } else {
            i18 = i16;
        }
        int i47 = i17 & 2;
        if (i47 != 0) {
            i18 |= 48;
        } else if ((i16 & 112) == 0) {
            i18 |= startRestartGroup.changed(function2) ? 32 : 16;
            i19 = i17 & 4;
            if (i19 == 0) {
                i18 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                i18 |= startRestartGroup.changed(str) ? 256 : 128;
                i26 = i17 & 8;
                if (i26 != 0) {
                    i18 |= 1024;
                }
                i27 = i17 & 16;
                if (i27 != 0) {
                    i18 |= 24576;
                } else if ((57344 & i16) == 0) {
                    i28 = i3;
                    i18 |= startRestartGroup.changed(i28) ? 16384 : 8192;
                    i29 = i17 & 32;
                    if (i29 == 0) {
                        i18 |= 196608;
                    } else if ((458752 & i16) == 0) {
                        z17 = z16;
                        i18 |= startRestartGroup.changed(z17) ? 131072 : 65536;
                        i36 = i17 & 64;
                        if (i36 != 0) {
                            i18 |= 1572864;
                        } else if ((i16 & 3670016) == 0) {
                            i18 |= startRestartGroup.changed(function1) ? 1048576 : 524288;
                        }
                        i37 = i17 & 128;
                        if (i37 != 0) {
                            i18 |= 12582912;
                        } else if ((i16 & 29360128) == 0) {
                            i18 |= startRestartGroup.changed(function12) ? 8388608 : 4194304;
                        }
                        i38 = i17 & 256;
                        if (i38 == 0) {
                            i39 = (i16 & 234881024) == 0 ? startRestartGroup.changed(function13) ? 67108864 : 33554432 : 100663296;
                            if (i26 != 8 && (191739611 & i18) == 38347922 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                iVar2 = iVar;
                                function22 = function2;
                                str3 = str;
                                eVar3 = eVar;
                                function19 = function1;
                                function17 = function12;
                                function18 = function13;
                                z18 = z17;
                            } else {
                                iVar2 = i46 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                function22 = i47 == 0 ? null : function2;
                                str2 = i19 == 0 ? null : str;
                                eVar2 = i26 == 0 ? null : eVar;
                                if (i27 != 0) {
                                    i28 = 1;
                                }
                                boolean z19 = i29 == 0 ? z17 : true;
                                function14 = i36 == 0 ? null : function1;
                                function15 = i37 == 0 ? null : function12;
                                function16 = i38 == 0 ? null : function13;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(179871568, i18, -1, "com.tencent.ntcompose.material.PAG (PAG.kt:54)");
                                }
                                ArrayList arrayList = new ArrayList();
                                if (str2 != null) {
                                    arrayList.add(new com.tencent.ntcompose.core.k("src_url", str2, null, null, null, null, aa.f339359a, 60, null));
                                }
                                if (eVar2 != null) {
                                    arrayList.add(new com.tencent.ntcompose.core.k("src_uri", eVar2, null, null, null, null, aa.f339359a, 60, null));
                                }
                                Integer valueOf = Integer.valueOf(i28);
                                aa aaVar = aa.f339359a;
                                arrayList.add(new com.tencent.ntcompose.core.k("repeatCount", valueOf, null, null, null, null, aaVar, 60, null));
                                arrayList.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z19), null, null, null, null, aaVar, 60, null));
                                if (function14 != null) {
                                    arrayList.add(new com.tencent.ntcompose.core.k("onLoadFailure", function14, null, null, null, null, aaVar, 60, null));
                                }
                                if (function15 != null) {
                                    arrayList.add(new com.tencent.ntcompose.core.k("onAnimationStart", function15, null, null, null, null, aaVar, 60, null));
                                }
                                if (function16 != null) {
                                    arrayList.add(new com.tencent.ntcompose.core.k("onAnimationEnd", function16, null, null, null, null, aaVar, 60, null));
                                }
                                ComposeNodeKt.a("pag", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? null : function22, iVar2, arrayList, null, startRestartGroup, ((i18 << 9) & 7168) | 32822, 32);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                eVar3 = eVar2;
                                z18 = z19;
                                function17 = function15;
                                function18 = function16;
                                str3 = str2;
                                function19 = function14;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                return;
                            }
                            final com.tencent.ntcompose.core.i iVar3 = iVar2;
                            final Function2<? super bc, ? super com.tencent.kuikly.core.base.aa<bc>, Unit> function23 = function22;
                            final int i48 = i28;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.PAGKt$PAG$1
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

                                public final void invoke(Composer composer2, int i49) {
                                    PAGKt.a(com.tencent.ntcompose.core.i.this, function23, str3, eVar3, i48, z18, function19, function17, function18, composer2, i16 | 1, i17);
                                }
                            });
                            return;
                        }
                        i18 |= i39;
                        if (i26 != 8) {
                        }
                        if (i46 == 0) {
                        }
                        if (i47 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 != 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i36 == 0) {
                        }
                        if (i37 == 0) {
                        }
                        if (i38 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ArrayList arrayList2 = new ArrayList();
                        if (str2 != null) {
                        }
                        if (eVar2 != null) {
                        }
                        Integer valueOf2 = Integer.valueOf(i28);
                        aa aaVar2 = aa.f339359a;
                        arrayList2.add(new com.tencent.ntcompose.core.k("repeatCount", valueOf2, null, null, null, null, aaVar2, 60, null));
                        arrayList2.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z19), null, null, null, null, aaVar2, 60, null));
                        if (function14 != null) {
                        }
                        if (function15 != null) {
                        }
                        if (function16 != null) {
                        }
                        ComposeNodeKt.a("pag", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? null : function22, iVar2, arrayList2, null, startRestartGroup, ((i18 << 9) & 7168) | 32822, 32);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        eVar3 = eVar2;
                        z18 = z19;
                        function17 = function15;
                        function18 = function16;
                        str3 = str2;
                        function19 = function14;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    z17 = z16;
                    i36 = i17 & 64;
                    if (i36 != 0) {
                    }
                    i37 = i17 & 128;
                    if (i37 != 0) {
                    }
                    i38 = i17 & 256;
                    if (i38 == 0) {
                    }
                    i18 |= i39;
                    if (i26 != 8) {
                    }
                    if (i46 == 0) {
                    }
                    if (i47 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i36 == 0) {
                    }
                    if (i37 == 0) {
                    }
                    if (i38 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList22 = new ArrayList();
                    if (str2 != null) {
                    }
                    if (eVar2 != null) {
                    }
                    Integer valueOf22 = Integer.valueOf(i28);
                    aa aaVar22 = aa.f339359a;
                    arrayList22.add(new com.tencent.ntcompose.core.k("repeatCount", valueOf22, null, null, null, null, aaVar22, 60, null));
                    arrayList22.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z19), null, null, null, null, aaVar22, 60, null));
                    if (function14 != null) {
                    }
                    if (function15 != null) {
                    }
                    if (function16 != null) {
                    }
                    ComposeNodeKt.a("pag", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? null : function22, iVar2, arrayList22, null, startRestartGroup, ((i18 << 9) & 7168) | 32822, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    eVar3 = eVar2;
                    z18 = z19;
                    function17 = function15;
                    function18 = function16;
                    str3 = str2;
                    function19 = function14;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i28 = i3;
                i29 = i17 & 32;
                if (i29 == 0) {
                }
                z17 = z16;
                i36 = i17 & 64;
                if (i36 != 0) {
                }
                i37 = i17 & 128;
                if (i37 != 0) {
                }
                i38 = i17 & 256;
                if (i38 == 0) {
                }
                i18 |= i39;
                if (i26 != 8) {
                }
                if (i46 == 0) {
                }
                if (i47 == 0) {
                }
                if (i19 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 != 0) {
                }
                if (i29 == 0) {
                }
                if (i36 == 0) {
                }
                if (i37 == 0) {
                }
                if (i38 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList222 = new ArrayList();
                if (str2 != null) {
                }
                if (eVar2 != null) {
                }
                Integer valueOf222 = Integer.valueOf(i28);
                aa aaVar222 = aa.f339359a;
                arrayList222.add(new com.tencent.ntcompose.core.k("repeatCount", valueOf222, null, null, null, null, aaVar222, 60, null));
                arrayList222.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z19), null, null, null, null, aaVar222, 60, null));
                if (function14 != null) {
                }
                if (function15 != null) {
                }
                if (function16 != null) {
                }
                ComposeNodeKt.a("pag", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? null : function22, iVar2, arrayList222, null, startRestartGroup, ((i18 << 9) & 7168) | 32822, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                eVar3 = eVar2;
                z18 = z19;
                function17 = function15;
                function18 = function16;
                str3 = str2;
                function19 = function14;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i26 = i17 & 8;
            if (i26 != 0) {
            }
            i27 = i17 & 16;
            if (i27 != 0) {
            }
            i28 = i3;
            i29 = i17 & 32;
            if (i29 == 0) {
            }
            z17 = z16;
            i36 = i17 & 64;
            if (i36 != 0) {
            }
            i37 = i17 & 128;
            if (i37 != 0) {
            }
            i38 = i17 & 256;
            if (i38 == 0) {
            }
            i18 |= i39;
            if (i26 != 8) {
            }
            if (i46 == 0) {
            }
            if (i47 == 0) {
            }
            if (i19 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 != 0) {
            }
            if (i29 == 0) {
            }
            if (i36 == 0) {
            }
            if (i37 == 0) {
            }
            if (i38 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList2222 = new ArrayList();
            if (str2 != null) {
            }
            if (eVar2 != null) {
            }
            Integer valueOf2222 = Integer.valueOf(i28);
            aa aaVar2222 = aa.f339359a;
            arrayList2222.add(new com.tencent.ntcompose.core.k("repeatCount", valueOf2222, null, null, null, null, aaVar2222, 60, null));
            arrayList2222.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z19), null, null, null, null, aaVar2222, 60, null));
            if (function14 != null) {
            }
            if (function15 != null) {
            }
            if (function16 != null) {
            }
            ComposeNodeKt.a("pag", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? null : function22, iVar2, arrayList2222, null, startRestartGroup, ((i18 << 9) & 7168) | 32822, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            eVar3 = eVar2;
            z18 = z19;
            function17 = function15;
            function18 = function16;
            str3 = str2;
            function19 = function14;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i19 = i17 & 4;
        if (i19 == 0) {
        }
        i26 = i17 & 8;
        if (i26 != 0) {
        }
        i27 = i17 & 16;
        if (i27 != 0) {
        }
        i28 = i3;
        i29 = i17 & 32;
        if (i29 == 0) {
        }
        z17 = z16;
        i36 = i17 & 64;
        if (i36 != 0) {
        }
        i37 = i17 & 128;
        if (i37 != 0) {
        }
        i38 = i17 & 256;
        if (i38 == 0) {
        }
        i18 |= i39;
        if (i26 != 8) {
        }
        if (i46 == 0) {
        }
        if (i47 == 0) {
        }
        if (i19 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 != 0) {
        }
        if (i29 == 0) {
        }
        if (i36 == 0) {
        }
        if (i37 == 0) {
        }
        if (i38 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList22222 = new ArrayList();
        if (str2 != null) {
        }
        if (eVar2 != null) {
        }
        Integer valueOf22222 = Integer.valueOf(i28);
        aa aaVar22222 = aa.f339359a;
        arrayList22222.add(new com.tencent.ntcompose.core.k("repeatCount", valueOf22222, null, null, null, null, aaVar22222, 60, null));
        arrayList22222.add(new com.tencent.ntcompose.core.k("autoPlay", Boolean.valueOf(z19), null, null, null, null, aaVar22222, 60, null));
        if (function14 != null) {
        }
        if (function15 != null) {
        }
        if (function16 != null) {
        }
        ComposeNodeKt.a("pag", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? null : function22, iVar2, arrayList22222, null, startRestartGroup, ((i18 << 9) & 7168) | 32822, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        eVar3 = eVar2;
        z18 = z19;
        function17 = function15;
        function18 = function16;
        str3 = str2;
        function19 = function14;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
