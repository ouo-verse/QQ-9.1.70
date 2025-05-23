package com.tencent.ntcompose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0093\u0001\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042B\b\u0002\u0010\u000f\u001a<\u0012\u0004\u0012\u00020\u0007\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r\u00a2\u0006\u0002\b\u000e2 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010\u00a2\u0006\u0002\b\u0012\u00a2\u0006\u0002\b\u000eH\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "verticalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "horizontalAlignment", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/foundation/layout/d;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/foundation/layout/base/a$k;Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ColumnKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, a.k kVar, Alignment.Horizontal horizontal, Function2<? super v, ? super aa<v>, Unit> function2, Function3<? super d, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        a.k kVar2;
        Alignment.Horizontal horizontal2;
        int i18;
        Function2<? super v, ? super aa<v>, Unit> function22;
        int i19;
        Function3<? super d, ? super Composer, ? super Integer, Unit> function32;
        com.tencent.ntcompose.core.i iVar3;
        a.k h16;
        Alignment.Horizontal horizontal3;
        Function2<? super v, ? super aa<v>, Unit> function23;
        final Function3<? super d, ? super Composer, ? super Integer, Unit> function33;
        ArrayList arrayListOf;
        final Function2<? super v, ? super aa<v>, Unit> function24;
        final Function3<? super d, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope endRestartGroup;
        int i26;
        Composer startRestartGroup = composer.startRestartGroup(-551667687);
        int i27 = i16 & 1;
        if (i27 != 0) {
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
                kVar2 = kVar;
                if (startRestartGroup.changed(kVar2)) {
                    i26 = 32;
                    i17 |= i26;
                }
            } else {
                kVar2 = kVar;
            }
            i26 = 16;
            i17 |= i26;
        } else {
            kVar2 = kVar;
        }
        int i28 = i16 & 4;
        if (i28 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            horizontal2 = horizontal;
            i17 |= startRestartGroup.changed(horizontal2) ? 256 : 128;
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
                    function32 = function3;
                    i17 |= startRestartGroup.changed(function32) ? 16384 : 8192;
                    if ((i17 & 46811) != 9362 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        iVar3 = iVar2;
                        h16 = kVar2;
                        function24 = function22;
                        function34 = function32;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar3 = iVar2;
                            h16 = kVar2;
                            horizontal3 = horizontal2;
                            function23 = function22;
                        } else {
                            iVar3 = i27 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                            h16 = (i16 & 2) == 0 ? com.tencent.ntcompose.foundation.layout.base.a.f339245a.h() : kVar2;
                            if (i28 != 0) {
                                horizontal2 = Alignment.Horizontal.Start;
                            }
                            if (i18 != 0) {
                                function22 = null;
                            }
                            horizontal3 = horizontal2;
                            function23 = function22;
                            if (i19 != 0) {
                                function33 = null;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-551667687, i3, -1, "com.tencent.ntcompose.foundation.layout.Column (Column.kt:26)");
                                }
                                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("verticalArrangement_horizontalAlignment", new Pair(h16, horizontal3), null, null, null, null, e.f339283a, 60, null));
                                Function3<? super d, ? super Composer, ? super Integer, Unit> function35 = function33;
                                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -181482257, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ColumnKt$Column$1
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

                                    public final void invoke(Composer composer2, int i29) {
                                        if ((i29 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-181482257, i29, -1, "com.tencent.ntcompose.foundation.layout.Column.<anonymous> (Column.kt:46)");
                                        }
                                        Function3<d, Composer, Integer, Unit> function36 = function33;
                                        if (function36 != null) {
                                            function36.invoke(e.f339283a, composer2, 6);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), startRestartGroup, 229430, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                horizontal2 = horizontal3;
                                function24 = function23;
                                function34 = function35;
                            }
                        }
                        function33 = function32;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("verticalArrangement_horizontalAlignment", new Pair(h16, horizontal3), null, null, null, null, e.f339283a, 60, null));
                        Function3<? super d, ? super Composer, ? super Integer, Unit> function352 = function33;
                        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -181482257, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ColumnKt$Column$1
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

                            public final void invoke(Composer composer2, int i29) {
                                if ((i29 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-181482257, i29, -1, "com.tencent.ntcompose.foundation.layout.Column.<anonymous> (Column.kt:46)");
                                }
                                Function3<d, Composer, Integer, Unit> function36 = function33;
                                if (function36 != null) {
                                    function36.invoke(e.f339283a, composer2, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), startRestartGroup, 229430, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        horizontal2 = horizontal3;
                        function24 = function23;
                        function34 = function352;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final com.tencent.ntcompose.core.i iVar4 = iVar3;
                    final a.k kVar3 = h16;
                    final Alignment.Horizontal horizontal4 = horizontal2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ColumnKt$Column$2
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

                        public final void invoke(Composer composer2, int i29) {
                            ColumnKt.a(com.tencent.ntcompose.core.i.this, kVar3, horizontal4, function24, function34, composer2, i3 | 1, i16);
                        }
                    });
                    return;
                }
                function32 = function3;
                if ((i17 & 46811) != 9362) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i27 == 0) {
                }
                if ((i16 & 2) == 0) {
                }
                if (i28 != 0) {
                }
                if (i18 != 0) {
                }
                horizontal3 = horizontal2;
                function23 = function22;
                if (i19 != 0) {
                }
                function33 = function32;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("verticalArrangement_horizontalAlignment", new Pair(h16, horizontal3), null, null, null, null, e.f339283a, 60, null));
                Function3<? super d, ? super Composer, ? super Integer, Unit> function3522 = function33;
                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -181482257, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ColumnKt$Column$1
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

                    public final void invoke(Composer composer2, int i29) {
                        if ((i29 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-181482257, i29, -1, "com.tencent.ntcompose.foundation.layout.Column.<anonymous> (Column.kt:46)");
                        }
                        Function3<d, Composer, Integer, Unit> function36 = function33;
                        if (function36 != null) {
                            function36.invoke(e.f339283a, composer2, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 229430, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                horizontal2 = horizontal3;
                function24 = function23;
                function34 = function3522;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function22 = function2;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            function32 = function3;
            if ((i17 & 46811) != 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i27 == 0) {
            }
            if ((i16 & 2) == 0) {
            }
            if (i28 != 0) {
            }
            if (i18 != 0) {
            }
            horizontal3 = horizontal2;
            function23 = function22;
            if (i19 != 0) {
            }
            function33 = function32;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("verticalArrangement_horizontalAlignment", new Pair(h16, horizontal3), null, null, null, null, e.f339283a, 60, null));
            Function3<? super d, ? super Composer, ? super Integer, Unit> function35222 = function33;
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -181482257, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ColumnKt$Column$1
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

                public final void invoke(Composer composer2, int i29) {
                    if ((i29 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-181482257, i29, -1, "com.tencent.ntcompose.foundation.layout.Column.<anonymous> (Column.kt:46)");
                    }
                    Function3<d, Composer, Integer, Unit> function36 = function33;
                    if (function36 != null) {
                        function36.invoke(e.f339283a, composer2, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 229430, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            horizontal2 = horizontal3;
            function24 = function23;
            function34 = function35222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        horizontal2 = horizontal;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        function22 = function2;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        function32 = function3;
        if ((i17 & 46811) != 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i27 == 0) {
        }
        if ((i16 & 2) == 0) {
        }
        if (i28 != 0) {
        }
        if (i18 != 0) {
        }
        horizontal3 = horizontal2;
        function23 = function22;
        if (i19 != 0) {
        }
        function33 = function32;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("verticalArrangement_horizontalAlignment", new Pair(h16, horizontal3), null, null, null, null, e.f339283a, 60, null));
        Function3<? super d, ? super Composer, ? super Integer, Unit> function352222 = function33;
        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function23 == null ? null : function23, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -181482257, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ColumnKt$Column$1
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

            public final void invoke(Composer composer2, int i29) {
                if ((i29 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-181482257, i29, -1, "com.tencent.ntcompose.foundation.layout.Column.<anonymous> (Column.kt:46)");
                }
                Function3<d, Composer, Integer, Unit> function36 = function33;
                if (function36 != null) {
                    function36.invoke(e.f339283a, composer2, 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 229430, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        horizontal2 = horizontal3;
        function24 = function23;
        function34 = function352222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
