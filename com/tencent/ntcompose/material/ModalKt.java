package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00a9\u0001\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022B\b\u0002\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f2-\b\u0002\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00112\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\n0\u0013\u00a2\u0006\u0002\b\u0014H\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "", "inWindow", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/ModalView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lkotlin/Function1;", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onWillDismiss", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModalKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, boolean z16, Function2<? super ModalView, ? super com.tencent.kuikly.core.base.aa<ModalView>, Unit> function2, Function1<Object, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        boolean z17;
        int i18;
        Function2<? super ModalView, ? super com.tencent.kuikly.core.base.aa<ModalView>, Unit> function22;
        int i19;
        Function1<Object, Unit> function12;
        boolean z18;
        String str;
        final Function1<Object, Unit> function13;
        final com.tencent.ntcompose.core.i iVar3;
        final boolean z19;
        final Function2<? super ModalView, ? super com.tencent.kuikly.core.base.aa<ModalView>, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-679791407);
        int i26 = i16 & 1;
        if (i26 != 0) {
            i17 = i3 | 6;
            iVar2 = iVar;
        } else if ((i3 & 14) == 0) {
            iVar2 = iVar;
            i17 = (startRestartGroup.changed(iVar2) ? 4 : 2) | i3;
        } else {
            iVar2 = iVar;
            i17 = i3;
        }
        int i27 = i16 & 2;
        if (i27 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            z17 = z16;
            i17 |= startRestartGroup.changed(z17) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                function22 = function2;
                i17 |= startRestartGroup.changed(function22) ? 256 : 128;
                i19 = i16 & 8;
                if (i19 != 0) {
                    i17 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    function12 = function1;
                    i17 |= startRestartGroup.changed(function12) ? 2048 : 1024;
                    if ((i16 & 16) == 0) {
                        i17 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        i17 |= startRestartGroup.changed(content) ? 16384 : 8192;
                    }
                    if ((46811 & i17) != 9362 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        iVar3 = iVar2;
                        z19 = z17;
                        function23 = function22;
                        function13 = function12;
                    } else {
                        com.tencent.ntcompose.core.i iVar4 = i26 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                        z18 = i27 == 0 ? true : z17;
                        Function2<? super ModalView, ? super com.tencent.kuikly.core.base.aa<ModalView>, Unit> function24 = i18 == 0 ? null : function22;
                        if (i19 != 0) {
                            function12 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-679791407, i17, -1, "com.tencent.ntcompose.material.Modal (Modal.kt:27)");
                        }
                        ArrayList arrayList = new ArrayList();
                        if (function12 != null) {
                            arrayList.add(new com.tencent.ntcompose.core.k("onWillDismiss", function12, null, null, null, null, z.f339453a, 60, null));
                        }
                        startRestartGroup.startReplaceableGroup(-418101196);
                        com.tencent.ntcompose.core.i v3 = !z18 ? iVar4 : ComposeLayoutPropUpdaterKt.v(iVar4, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e(), ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).d());
                        startRestartGroup.endReplaceableGroup();
                        if (!z18) {
                            str = "modal";
                        } else {
                            str = "root_modal";
                        }
                        ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function24 != null ? null : function24, v3, arrayList, content, startRestartGroup, ((i17 << 3) & 458752) | 32816, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function13 = function12;
                        iVar3 = iVar4;
                        z19 = z18;
                        function23 = function24;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ModalKt$Modal$1
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

                        public final void invoke(Composer composer2, int i28) {
                            ModalKt.a(com.tencent.ntcompose.core.i.this, z19, function23, function13, content, composer2, i3 | 1, i16);
                        }
                    });
                    return;
                }
                function12 = function1;
                if ((i16 & 16) == 0) {
                }
                if ((46811 & i17) != 9362) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList2 = new ArrayList();
                if (function12 != null) {
                }
                startRestartGroup.startReplaceableGroup(-418101196);
                if (!z18) {
                }
                startRestartGroup.endReplaceableGroup();
                if (!z18) {
                }
                ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function24 != null ? null : function24, v3, arrayList2, content, startRestartGroup, ((i17 << 3) & 458752) | 32816, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function13 = function12;
                iVar3 = iVar4;
                z19 = z18;
                function23 = function24;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function22 = function2;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            function12 = function1;
            if ((i16 & 16) == 0) {
            }
            if ((46811 & i17) != 9362) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList22 = new ArrayList();
            if (function12 != null) {
            }
            startRestartGroup.startReplaceableGroup(-418101196);
            if (!z18) {
            }
            startRestartGroup.endReplaceableGroup();
            if (!z18) {
            }
            ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function24 != null ? null : function24, v3, arrayList22, content, startRestartGroup, ((i17 << 3) & 458752) | 32816, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function13 = function12;
            iVar3 = iVar4;
            z19 = z18;
            function23 = function24;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z17 = z16;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        function22 = function2;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        function12 = function1;
        if ((i16 & 16) == 0) {
        }
        if ((46811 & i17) != 9362) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList222 = new ArrayList();
        if (function12 != null) {
        }
        startRestartGroup.startReplaceableGroup(-418101196);
        if (!z18) {
        }
        startRestartGroup.endReplaceableGroup();
        if (!z18) {
        }
        ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function24 != null ? null : function24, v3, arrayList222, content, startRestartGroup, ((i17 << 3) & 458752) | 32816, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function13 = function12;
        iVar3 = iVar4;
        z19 = z18;
        function23 = function24;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
