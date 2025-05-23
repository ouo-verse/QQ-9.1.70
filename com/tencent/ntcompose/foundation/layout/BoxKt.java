package com.tencent.ntcompose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0089\u0001\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022B\b\u0002\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f2 \b\u0002\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e\u00a2\u0006\u0002\b\u0010\u00a2\u0006\u0002\b\fH\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "contentAlignment", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/foundation/layout/b;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/foundation/layout/base/Alignment;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class BoxKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Alignment alignment, Function2<? super v, ? super aa<v>, Unit> function2, Function3<? super b, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        Alignment alignment2;
        int i18;
        Function2<? super v, ? super aa<v>, Unit> function22;
        int i19;
        Function3<? super b, ? super Composer, ? super Integer, Unit> function32;
        com.tencent.ntcompose.core.i iVar3;
        Alignment alignment3;
        ArrayList arrayListOf;
        final Function3<? super b, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(35169636);
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
            alignment2 = alignment;
            i17 |= startRestartGroup.changed(alignment2) ? 32 : 16;
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
                    function32 = function3;
                    i17 |= startRestartGroup.changed(function32) ? 2048 : 1024;
                    if ((i17 & 5851) != 1170 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        iVar3 = iVar2;
                        alignment3 = alignment2;
                        function33 = function32;
                    } else {
                        iVar3 = i26 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                        alignment3 = i27 == 0 ? Alignment.TopStart : alignment2;
                        Function2<? super v, ? super aa<v>, Unit> function23 = i18 == 0 ? null : function22;
                        final Function3<? super b, ? super Composer, ? super Integer, Unit> function34 = i19 == 0 ? null : function32;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(35169636, i3, -1, "com.tencent.ntcompose.foundation.layout.Box (Box.kt:26)");
                        }
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("contentAlignment", alignment3, null, null, null, null, c.f339282a, 60, null));
                        function33 = function34;
                        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -332814790, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.BoxKt$Box$1
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
                                if ((i28 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-332814790, i28, -1, "com.tencent.ntcompose.foundation.layout.Box.<anonymous> (Box.kt:42)");
                                }
                                Function3<b, Composer, Integer, Unit> function35 = function34;
                                if (function35 != null) {
                                    function35.invoke(c.f339282a, composer2, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), startRestartGroup, 229430, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function22 = function23;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final com.tencent.ntcompose.core.i iVar4 = iVar3;
                    final Alignment alignment4 = alignment3;
                    final Function2<? super v, ? super aa<v>, Unit> function24 = function22;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.BoxKt$Box$2
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
                            BoxKt.a(com.tencent.ntcompose.core.i.this, alignment4, function24, function33, composer2, i3 | 1, i16);
                        }
                    });
                    return;
                }
                function32 = function3;
                if ((i17 & 5851) != 1170) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("contentAlignment", alignment3, null, null, null, null, c.f339282a, 60, null));
                function33 = function34;
                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -332814790, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.BoxKt$Box$1
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
                        if ((i28 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-332814790, i28, -1, "com.tencent.ntcompose.foundation.layout.Box.<anonymous> (Box.kt:42)");
                        }
                        Function3<b, Composer, Integer, Unit> function35 = function34;
                        if (function35 != null) {
                            function35.invoke(c.f339282a, composer2, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 229430, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function22 = function23;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function22 = function2;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            function32 = function3;
            if ((i17 & 5851) != 1170) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("contentAlignment", alignment3, null, null, null, null, c.f339282a, 60, null));
            function33 = function34;
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -332814790, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.BoxKt$Box$1
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
                    if ((i28 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-332814790, i28, -1, "com.tencent.ntcompose.foundation.layout.Box.<anonymous> (Box.kt:42)");
                    }
                    Function3<b, Composer, Integer, Unit> function35 = function34;
                    if (function35 != null) {
                        function35.invoke(c.f339282a, composer2, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 229430, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function22 = function23;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        alignment2 = alignment;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        function22 = function2;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        function32 = function3;
        if ((i17 & 5851) != 1170) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("contentAlignment", alignment3, null, null, null, null, c.f339282a, 60, null));
        function33 = function34;
        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -332814790, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.BoxKt$Box$1
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
                if ((i28 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-332814790, i28, -1, "com.tencent.ntcompose.foundation.layout.Box.<anonymous> (Box.kt:42)");
                }
                Function3<b, Composer, Integer, Unit> function35 = function34;
                if (function35 != null) {
                    function35.invoke(c.f339282a, composer2, 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 229430, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function22 = function23;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
