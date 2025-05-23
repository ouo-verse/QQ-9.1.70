package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0096\u0001\u0010\u0015\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012B\b\u0002\u0010\f\u001a<\u0012\u0004\u0012\u00020\u0004\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\n\u00a2\u0006\u0002\b\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\u0002\b\u0013H\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/ab;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "", "bringIndex", "", "hoverMarginTop", "hoverMaxMarginTop", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/foundation/lazy/layout/a;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Ljava/lang/Integer;FLjava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class HoverKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final com.tencent.ntcompose.foundation.lazy.layout.a aVar, com.tencent.ntcompose.core.i iVar, Function2<? super com.tencent.kuikly.core.views.ab, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.ab>, Unit> function2, Integer num, float f16, Float f17, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16) {
        int i17;
        Function2<? super com.tencent.kuikly.core.views.ab, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.ab>, Unit> function22;
        int i18;
        Integer num2;
        int i19;
        float f18;
        int i26;
        Float f19;
        Integer num3;
        final float f26;
        final Float f27;
        final com.tencent.ntcompose.core.i iVar2;
        final Function2<? super com.tencent.kuikly.core.views.ab, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.ab>, Unit> function23;
        final Integer num4;
        ScopeUpdateScope endRestartGroup;
        int i27;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1112573159);
        int i28 = i16 & 1;
        if (i28 != 0) {
            i17 = i3 | 48;
        } else if ((i3 & 112) == 0) {
            i17 = (startRestartGroup.changed(iVar) ? 32 : 16) | i3;
        } else {
            i17 = i3;
        }
        int i29 = i16 & 2;
        if (i29 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            function22 = function2;
            i17 |= startRestartGroup.changed(function22) ? 256 : 128;
            i18 = i16 & 4;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                num2 = num;
                i17 |= startRestartGroup.changed(num2) ? 2048 : 1024;
                i19 = i16 & 8;
                if (i19 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    f18 = f16;
                    i17 |= startRestartGroup.changed(f18) ? 16384 : 8192;
                    i26 = i16 & 16;
                    if (i26 == 0) {
                        i17 |= 196608;
                        f19 = f17;
                    } else {
                        f19 = f17;
                        if ((i3 & 458752) == 0) {
                            i17 |= startRestartGroup.changed(f19) ? 131072 : 65536;
                        }
                    }
                    if ((i16 & 32) != 0) {
                        i27 = (i3 & 3670016) == 0 ? startRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                        if ((i17 & 2995921) != 599184 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar2 = iVar;
                            function23 = function22;
                            num4 = num2;
                            f26 = f18;
                            f27 = f19;
                        } else {
                            com.tencent.ntcompose.core.i iVar3 = i28 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                            Function2<? super com.tencent.kuikly.core.views.ab, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.ab>, Unit> function24 = i29 != 0 ? null : function22;
                            num3 = i18 != 0 ? null : num2;
                            if (i19 != 0) {
                                f18 = 0.0f;
                            }
                            if (i26 != 0) {
                                f19 = null;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1112573159, i17, -1, "com.tencent.ntcompose.material.Hover (Hover.kt:47)");
                            }
                            ArrayList arrayList = new ArrayList();
                            if (num3 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("bringIndex", Integer.valueOf(num3.intValue()), null, null, null, null, s.f339445a, 60, null));
                            }
                            Float valueOf = Float.valueOf(f18);
                            s sVar = s.f339445a;
                            arrayList.add(new com.tencent.ntcompose.core.k("hoverMarginTop", valueOf, null, null, null, null, sVar, 60, null));
                            if (f19 != null) {
                                arrayList.add(new com.tencent.ntcompose.core.k("hoverMaxMarginTop", Float.valueOf(f19.floatValue()), null, null, null, null, sVar, 60, null));
                            }
                            ComposeNodeKt.a("hover", com.tencent.ntcompose.material.base.a.f339408a, function24 == null ? null : function24, iVar3, arrayList, content, startRestartGroup, ((i17 << 6) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f26 = f18;
                            f27 = f19;
                            iVar2 = iVar3;
                            function23 = function24;
                            num4 = num3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.HoverKt$Hover$1
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

                            public final void invoke(Composer composer2, int i36) {
                                HoverKt.a(com.tencent.ntcompose.foundation.lazy.layout.a.this, iVar2, function23, num4, f26, f27, content, composer2, i3 | 1, i16);
                            }
                        });
                        return;
                    }
                    i17 |= i27;
                    if ((i17 & 2995921) != 599184) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (num3 != null) {
                    }
                    Float valueOf2 = Float.valueOf(f18);
                    s sVar2 = s.f339445a;
                    arrayList2.add(new com.tencent.ntcompose.core.k("hoverMarginTop", valueOf2, null, null, null, null, sVar2, 60, null));
                    if (f19 != null) {
                    }
                    ComposeNodeKt.a("hover", com.tencent.ntcompose.material.base.a.f339408a, function24 == null ? null : function24, iVar3, arrayList2, content, startRestartGroup, ((i17 << 6) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f26 = f18;
                    f27 = f19;
                    iVar2 = iVar3;
                    function23 = function24;
                    num4 = num3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f18 = f16;
                i26 = i16 & 16;
                if (i26 == 0) {
                }
                if ((i16 & 32) != 0) {
                }
                i17 |= i27;
                if ((i17 & 2995921) != 599184) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList22 = new ArrayList();
                if (num3 != null) {
                }
                Float valueOf22 = Float.valueOf(f18);
                s sVar22 = s.f339445a;
                arrayList22.add(new com.tencent.ntcompose.core.k("hoverMarginTop", valueOf22, null, null, null, null, sVar22, 60, null));
                if (f19 != null) {
                }
                ComposeNodeKt.a("hover", com.tencent.ntcompose.material.base.a.f339408a, function24 == null ? null : function24, iVar3, arrayList22, content, startRestartGroup, ((i17 << 6) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f26 = f18;
                f27 = f19;
                iVar2 = iVar3;
                function23 = function24;
                num4 = num3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            num2 = num;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            f18 = f16;
            i26 = i16 & 16;
            if (i26 == 0) {
            }
            if ((i16 & 32) != 0) {
            }
            i17 |= i27;
            if ((i17 & 2995921) != 599184) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList222 = new ArrayList();
            if (num3 != null) {
            }
            Float valueOf222 = Float.valueOf(f18);
            s sVar222 = s.f339445a;
            arrayList222.add(new com.tencent.ntcompose.core.k("hoverMarginTop", valueOf222, null, null, null, null, sVar222, 60, null));
            if (f19 != null) {
            }
            ComposeNodeKt.a("hover", com.tencent.ntcompose.material.base.a.f339408a, function24 == null ? null : function24, iVar3, arrayList222, content, startRestartGroup, ((i17 << 6) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f26 = f18;
            f27 = f19;
            iVar2 = iVar3;
            function23 = function24;
            num4 = num3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function22 = function2;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        num2 = num;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        f18 = f16;
        i26 = i16 & 16;
        if (i26 == 0) {
        }
        if ((i16 & 32) != 0) {
        }
        i17 |= i27;
        if ((i17 & 2995921) != 599184) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList2222 = new ArrayList();
        if (num3 != null) {
        }
        Float valueOf2222 = Float.valueOf(f18);
        s sVar2222 = s.f339445a;
        arrayList2222.add(new com.tencent.ntcompose.core.k("hoverMarginTop", valueOf2222, null, null, null, null, sVar2222, 60, null));
        if (f19 != null) {
        }
        ComposeNodeKt.a("hover", com.tencent.ntcompose.material.base.a.f339408a, function24 == null ? null : function24, iVar3, arrayList2222, content, startRestartGroup, ((i17 << 6) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f26 = f18;
        f27 = f19;
        iVar2 = iVar3;
        function23 = function24;
        num4 = num3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
