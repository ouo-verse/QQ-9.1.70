package com.tencent.ntcompose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.v;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.ui.unit.LayoutDirection;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009f\u0001\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042B\b\u0002\u0010\u000f\u001a<\u0012\u0004\u0012\u00020\u0007\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r\u00a2\u0006\u0002\b\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012\u00a2\u0006\u0002\b\u0014\u00a2\u0006\u0002\b\u000eH\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/ntcompose/foundation/layout/base/a$d;", "horizontalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", ImageNode.PROP_VERTICAL_ALIGNMENT, "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/ui/unit/LayoutDirection;", "layoutDirection", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/foundation/layout/n;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/foundation/layout/base/a$d;Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RowKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, a.d dVar, Alignment.Vertical vertical, Function2<? super v, ? super aa<v>, Unit> function2, LayoutDirection layoutDirection, Function3<? super n, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        a.d dVar2;
        Alignment.Vertical vertical2;
        int i18;
        Function2<? super v, ? super aa<v>, Unit> function22;
        int i19;
        LayoutDirection layoutDirection2;
        int i26;
        final Function3<? super n, ? super Composer, ? super Integer, Unit> function32;
        com.tencent.ntcompose.core.i iVar3;
        a.d g16;
        Alignment.Vertical vertical3;
        Function2<? super v, ? super aa<v>, Unit> function23;
        LayoutDirection layoutDirection3;
        ArrayList arrayListOf;
        final Function2<? super v, ? super aa<v>, Unit> function24;
        final LayoutDirection layoutDirection4;
        final Function3<? super n, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        int i27;
        Composer startRestartGroup = composer.startRestartGroup(-440196192);
        int i28 = i16 & 1;
        if (i28 != 0) {
            i17 = i3 | 6;
            iVar2 = iVar;
        } else if ((i3 & 14) == 0) {
            iVar2 = iVar;
            i17 = (startRestartGroup.changed(iVar2) ? 4 : 2) | i3;
        } else {
            iVar2 = iVar;
            i17 = i3;
        }
        if ((i3 & 112) == 0) {
            if ((i16 & 2) == 0) {
                dVar2 = dVar;
                if (startRestartGroup.changed(dVar2)) {
                    i27 = 32;
                    i17 |= i27;
                }
            } else {
                dVar2 = dVar;
            }
            i27 = 16;
            i17 |= i27;
        } else {
            dVar2 = dVar;
        }
        int i29 = i16 & 4;
        if (i29 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            vertical2 = vertical;
            i17 |= startRestartGroup.changed(vertical2) ? 256 : 128;
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
                    layoutDirection2 = layoutDirection;
                    i17 |= startRestartGroup.changed(layoutDirection2) ? 16384 : 8192;
                    i26 = i16 & 32;
                    if (i26 == 0) {
                        i17 |= 196608;
                    } else if ((458752 & i3) == 0) {
                        function32 = function3;
                        i17 |= startRestartGroup.changed(function32) ? 131072 : 65536;
                        if ((i17 & 374491) != 74898 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar3 = iVar2;
                            g16 = dVar2;
                            function24 = function22;
                            layoutDirection4 = layoutDirection2;
                            function33 = function32;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                iVar3 = iVar2;
                                g16 = dVar2;
                                vertical3 = vertical2;
                                function23 = function22;
                                layoutDirection3 = layoutDirection2;
                            } else {
                                iVar3 = i28 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                                g16 = (i16 & 2) != 0 ? com.tencent.ntcompose.foundation.layout.base.a.f339245a.g() : dVar2;
                                if (i29 != 0) {
                                    vertical2 = Alignment.Vertical.Top;
                                }
                                if (i18 != 0) {
                                    function22 = null;
                                }
                                if (i19 != 0) {
                                    layoutDirection2 = null;
                                }
                                vertical3 = vertical2;
                                function23 = function22;
                                layoutDirection3 = layoutDirection2;
                                if (i26 != 0) {
                                    function32 = null;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-440196192, i3, -1, "com.tencent.ntcompose.foundation.layout.Row (Row.kt:30)");
                            }
                            Pair pair = new Pair(g16, vertical3);
                            o oVar = o.f339291a;
                            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", pair, null, null, null, null, oVar, 60, null));
                            if (layoutDirection3 != null) {
                                arrayListOf.add(new com.tencent.ntcompose.core.k("layoutDirection", layoutDirection3, null, null, null, null, oVar, 60, null));
                            }
                            Function3<? super n, ? super Composer, ? super Integer, Unit> function34 = function32;
                            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, 1448617206, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.RowKt$Row$1
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
                                    if ((i36 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1448617206, i36, -1, "com.tencent.ntcompose.foundation.layout.Row.<anonymous> (Row.kt:54)");
                                    }
                                    Function3<n, Composer, Integer, Unit> function35 = function32;
                                    if (function35 != null) {
                                        function35.invoke(o.f339291a, composer2, 6);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), startRestartGroup, 229430, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            vertical2 = vertical3;
                            function24 = function23;
                            layoutDirection4 = layoutDirection3;
                            function33 = function34;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final com.tencent.ntcompose.core.i iVar4 = iVar3;
                        final a.d dVar3 = g16;
                        final Alignment.Vertical vertical4 = vertical2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.RowKt$Row$2
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
                                RowKt.a(com.tencent.ntcompose.core.i.this, dVar3, vertical4, function24, layoutDirection4, function33, composer2, i3 | 1, i16);
                            }
                        });
                        return;
                    }
                    function32 = function3;
                    if ((i17 & 374491) != 74898) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) == 0) {
                    }
                    if (i28 != 0) {
                    }
                    if ((i16 & 2) != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    vertical3 = vertical2;
                    function23 = function22;
                    layoutDirection3 = layoutDirection2;
                    if (i26 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Pair pair2 = new Pair(g16, vertical3);
                    o oVar2 = o.f339291a;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", pair2, null, null, null, null, oVar2, 60, null));
                    if (layoutDirection3 != null) {
                    }
                    Function3<? super n, ? super Composer, ? super Integer, Unit> function342 = function32;
                    ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, 1448617206, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.RowKt$Row$1
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
                            if ((i36 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1448617206, i36, -1, "com.tencent.ntcompose.foundation.layout.Row.<anonymous> (Row.kt:54)");
                            }
                            Function3<n, Composer, Integer, Unit> function35 = function32;
                            if (function35 != null) {
                                function35.invoke(o.f339291a, composer2, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, 229430, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    vertical2 = vertical3;
                    function24 = function23;
                    layoutDirection4 = layoutDirection3;
                    function33 = function342;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                layoutDirection2 = layoutDirection;
                i26 = i16 & 32;
                if (i26 == 0) {
                }
                function32 = function3;
                if ((i17 & 374491) != 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i28 != 0) {
                }
                if ((i16 & 2) != 0) {
                }
                if (i29 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                vertical3 = vertical2;
                function23 = function22;
                layoutDirection3 = layoutDirection2;
                if (i26 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Pair pair22 = new Pair(g16, vertical3);
                o oVar22 = o.f339291a;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", pair22, null, null, null, null, oVar22, 60, null));
                if (layoutDirection3 != null) {
                }
                Function3<? super n, ? super Composer, ? super Integer, Unit> function3422 = function32;
                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, 1448617206, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.RowKt$Row$1
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
                        if ((i36 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1448617206, i36, -1, "com.tencent.ntcompose.foundation.layout.Row.<anonymous> (Row.kt:54)");
                        }
                        Function3<n, Composer, Integer, Unit> function35 = function32;
                        if (function35 != null) {
                            function35.invoke(o.f339291a, composer2, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 229430, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                vertical2 = vertical3;
                function24 = function23;
                layoutDirection4 = layoutDirection3;
                function33 = function3422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function22 = function2;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            layoutDirection2 = layoutDirection;
            i26 = i16 & 32;
            if (i26 == 0) {
            }
            function32 = function3;
            if ((i17 & 374491) != 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i28 != 0) {
            }
            if ((i16 & 2) != 0) {
            }
            if (i29 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            vertical3 = vertical2;
            function23 = function22;
            layoutDirection3 = layoutDirection2;
            if (i26 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Pair pair222 = new Pair(g16, vertical3);
            o oVar222 = o.f339291a;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", pair222, null, null, null, null, oVar222, 60, null));
            if (layoutDirection3 != null) {
            }
            Function3<? super n, ? super Composer, ? super Integer, Unit> function34222 = function32;
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, 1448617206, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.RowKt$Row$1
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
                    if ((i36 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1448617206, i36, -1, "com.tencent.ntcompose.foundation.layout.Row.<anonymous> (Row.kt:54)");
                    }
                    Function3<n, Composer, Integer, Unit> function35 = function32;
                    if (function35 != null) {
                        function35.invoke(o.f339291a, composer2, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 229430, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            vertical2 = vertical3;
            function24 = function23;
            layoutDirection4 = layoutDirection3;
            function33 = function34222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        vertical2 = vertical;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        function22 = function2;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        layoutDirection2 = layoutDirection;
        i26 = i16 & 32;
        if (i26 == 0) {
        }
        function32 = function3;
        if ((i17 & 374491) != 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i28 != 0) {
        }
        if ((i16 & 2) != 0) {
        }
        if (i29 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        vertical3 = vertical2;
        function23 = function22;
        layoutDirection3 = layoutDirection2;
        if (i26 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Pair pair2222 = new Pair(g16, vertical3);
        o oVar2222 = o.f339291a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", pair2222, null, null, null, null, oVar2222, 60, null));
        if (layoutDirection3 != null) {
        }
        Function3<? super n, ? super Composer, ? super Integer, Unit> function342222 = function32;
        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, 1448617206, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.RowKt$Row$1
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
                if ((i36 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1448617206, i36, -1, "com.tencent.ntcompose.foundation.layout.Row.<anonymous> (Row.kt:54)");
                }
                Function3<n, Composer, Integer, Unit> function35 = function32;
                if (function35 != null) {
                    function35.invoke(o.f339291a, composer2, 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 229430, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        vertical2 = vertical3;
        function24 = function23;
        layoutDirection4 = layoutDirection3;
        function33 = function342222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
