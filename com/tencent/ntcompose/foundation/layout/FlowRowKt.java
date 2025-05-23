package com.tencent.ntcompose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00a7\u0001\u0010\u0018\u001a\u00020\u00062B\b\u0002\u0010\t\u001a<\u0012\u0004\u0012\u00020\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007\u00a2\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0002\b\bH\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/ntcompose/foundation/layout/base/a$d;", "horizontalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "verticalArrangement", "Lcom/tencent/ntcompose/ui/unit/LayoutDirection;", "layoutDirection", "", "maxItemsInEachRow", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/foundation/layout/i;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/foundation/layout/base/a$d;Lcom/tencent/ntcompose/foundation/layout/base/a$k;Lcom/tencent/ntcompose/ui/unit/LayoutDirection;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FlowRowKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Function2<? super v, ? super aa<v>, Unit> function2, com.tencent.ntcompose.core.i iVar, a.d dVar, a.k kVar, LayoutDirection layoutDirection, int i3, Function3<? super i, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i16, final int i17) {
        Function2<? super v, ? super aa<v>, Unit> function22;
        int i18;
        com.tencent.ntcompose.core.i iVar2;
        a.d dVar2;
        a.k kVar2;
        int i19;
        LayoutDirection layoutDirection2;
        int i26;
        int i27;
        int i28;
        Function3<? super i, ? super Composer, ? super Integer, Unit> function32;
        final com.tencent.ntcompose.core.i iVar3;
        final a.d dVar3;
        final a.k kVar3;
        LayoutDirection layoutDirection3;
        int i29;
        final Function3<? super i, ? super Composer, ? super Integer, Unit> function33;
        ArrayList arrayListOf;
        Function3<? super i, ? super Composer, ? super Integer, Unit> function34;
        final int i36;
        ScopeUpdateScope endRestartGroup;
        int i37;
        int i38;
        Composer startRestartGroup = composer.startRestartGroup(-1382274055);
        int i39 = i17 & 1;
        if (i39 != 0) {
            i18 = i16 | 6;
            function22 = function2;
        } else if ((i16 & 14) == 0) {
            function22 = function2;
            i18 = (startRestartGroup.changed(function22) ? 4 : 2) | i16;
        } else {
            function22 = function2;
            i18 = i16;
        }
        int i46 = i17 & 2;
        if (i46 != 0) {
            i18 |= 48;
        } else if ((i16 & 112) == 0) {
            iVar2 = iVar;
            i18 |= startRestartGroup.changed(iVar2) ? 32 : 16;
            if ((i16 & 896) != 0) {
                if ((i17 & 4) == 0) {
                    dVar2 = dVar;
                    if (startRestartGroup.changed(dVar2)) {
                        i38 = 256;
                        i18 |= i38;
                    }
                } else {
                    dVar2 = dVar;
                }
                i38 = 128;
                i18 |= i38;
            } else {
                dVar2 = dVar;
            }
            if ((i16 & 7168) != 0) {
                if ((i17 & 8) == 0) {
                    kVar2 = kVar;
                    if (startRestartGroup.changed(kVar2)) {
                        i37 = 2048;
                        i18 |= i37;
                    }
                } else {
                    kVar2 = kVar;
                }
                i37 = 1024;
                i18 |= i37;
            } else {
                kVar2 = kVar;
            }
            i19 = i17 & 16;
            if (i19 == 0) {
                i18 |= 24576;
            } else if ((57344 & i16) == 0) {
                layoutDirection2 = layoutDirection;
                i18 |= startRestartGroup.changed(layoutDirection2) ? 16384 : 8192;
                i26 = i17 & 32;
                if (i26 != 0) {
                    i18 |= 196608;
                } else if ((458752 & i16) == 0) {
                    i27 = i3;
                    i18 |= startRestartGroup.changed(i27) ? 131072 : 65536;
                    i28 = i17 & 64;
                    if (i28 == 0) {
                        i18 |= 1572864;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i16 & 3670016) == 0) {
                            i18 |= startRestartGroup.changed(function32) ? 1048576 : 524288;
                        }
                    }
                    if ((i18 & 2995931) != 599186 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        iVar3 = iVar2;
                        kVar3 = kVar2;
                        layoutDirection3 = layoutDirection2;
                        i36 = i27;
                        function34 = function32;
                        dVar3 = dVar2;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i16 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i39 != 0) {
                                function22 = null;
                            }
                            if (i46 != 0) {
                                iVar2 = com.tencent.ntcompose.core.i.INSTANCE;
                            }
                            if ((i17 & 4) != 0) {
                                dVar2 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.g();
                            }
                            if ((i17 & 8) != 0) {
                                kVar2 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                            }
                            if (i19 != 0) {
                                layoutDirection2 = LayoutDirection.Ltr;
                            }
                            if (i26 != 0) {
                                i27 = Integer.MAX_VALUE;
                            }
                            if (i28 != 0) {
                                iVar3 = iVar2;
                                dVar3 = dVar2;
                                kVar3 = kVar2;
                                layoutDirection3 = layoutDirection2;
                                i29 = i27;
                                function33 = null;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1382274055, i16, -1, "com.tencent.ntcompose.foundation.layout.FlowRow (FlowRow.kt:32)");
                                }
                                Integer valueOf = Integer.valueOf(i29);
                                j jVar = j.f339286a;
                                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("maxItemsInEachRow", valueOf, null, null, null, null, jVar, 60, null), new com.tencent.ntcompose.core.k("flexWrapWrap", Boolean.TRUE, null, null, null, null, jVar, 60, null), new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", new Pair(dVar3, kVar3), null, null, null, null, jVar, 60, null), new com.tencent.ntcompose.core.k("layoutDirection", layoutDirection3, null, null, null, null, jVar, 60, null));
                                Function3<? super i, ? super Composer, ? super Integer, Unit> function35 = function33;
                                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? function22 : null, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -1984177073, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.FlowRowKt$FlowRow$1
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

                                    public final void invoke(Composer composer2, int i47) {
                                        if ((i47 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1984177073, i47, -1, "com.tencent.ntcompose.foundation.layout.FlowRow.<anonymous> (FlowRow.kt:54)");
                                        }
                                        Function3<i, Composer, Integer, Unit> function36 = function33;
                                        if (function36 != null) {
                                            function36.invoke(j.f339286a, composer2, 6);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), startRestartGroup, 229430, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function34 = function35;
                                i36 = i29;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                        }
                        iVar3 = iVar2;
                        kVar3 = kVar2;
                        layoutDirection3 = layoutDirection2;
                        i29 = i27;
                        function33 = function32;
                        dVar3 = dVar2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Integer valueOf2 = Integer.valueOf(i29);
                        j jVar2 = j.f339286a;
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("maxItemsInEachRow", valueOf2, null, null, null, null, jVar2, 60, null), new com.tencent.ntcompose.core.k("flexWrapWrap", Boolean.TRUE, null, null, null, null, jVar2, 60, null), new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", new Pair(dVar3, kVar3), null, null, null, null, jVar2, 60, null), new com.tencent.ntcompose.core.k("layoutDirection", layoutDirection3, null, null, null, null, jVar2, 60, null));
                        Function3<? super i, ? super Composer, ? super Integer, Unit> function352 = function33;
                        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? function22 : null, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -1984177073, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.FlowRowKt$FlowRow$1
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

                            public final void invoke(Composer composer2, int i47) {
                                if ((i47 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1984177073, i47, -1, "com.tencent.ntcompose.foundation.layout.FlowRow.<anonymous> (FlowRow.kt:54)");
                                }
                                Function3<i, Composer, Integer, Unit> function36 = function33;
                                if (function36 != null) {
                                    function36.invoke(j.f339286a, composer2, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), startRestartGroup, 229430, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function34 = function352;
                        i36 = i29;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final Function2<? super v, ? super aa<v>, Unit> function23 = function22;
                    final LayoutDirection layoutDirection4 = layoutDirection3;
                    final Function3<? super i, ? super Composer, ? super Integer, Unit> function36 = function34;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.FlowRowKt$FlowRow$2
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

                        public final void invoke(Composer composer2, int i47) {
                            FlowRowKt.a(function23, iVar3, dVar3, kVar3, layoutDirection4, i36, function36, composer2, i16 | 1, i17);
                        }
                    });
                    return;
                }
                i27 = i3;
                i28 = i17 & 64;
                if (i28 == 0) {
                }
                if ((i18 & 2995931) != 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i16 & 1) != 0) {
                }
                if (i39 != 0) {
                }
                if (i46 != 0) {
                }
                if ((i17 & 4) != 0) {
                }
                if ((i17 & 8) != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                iVar3 = iVar2;
                kVar3 = kVar2;
                layoutDirection3 = layoutDirection2;
                i29 = i27;
                function33 = function32;
                dVar3 = dVar2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Integer valueOf22 = Integer.valueOf(i29);
                j jVar22 = j.f339286a;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("maxItemsInEachRow", valueOf22, null, null, null, null, jVar22, 60, null), new com.tencent.ntcompose.core.k("flexWrapWrap", Boolean.TRUE, null, null, null, null, jVar22, 60, null), new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", new Pair(dVar3, kVar3), null, null, null, null, jVar22, 60, null), new com.tencent.ntcompose.core.k("layoutDirection", layoutDirection3, null, null, null, null, jVar22, 60, null));
                Function3<? super i, ? super Composer, ? super Integer, Unit> function3522 = function33;
                ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? function22 : null, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -1984177073, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.FlowRowKt$FlowRow$1
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

                    public final void invoke(Composer composer2, int i47) {
                        if ((i47 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1984177073, i47, -1, "com.tencent.ntcompose.foundation.layout.FlowRow.<anonymous> (FlowRow.kt:54)");
                        }
                        Function3<i, Composer, Integer, Unit> function362 = function33;
                        if (function362 != null) {
                            function362.invoke(j.f339286a, composer2, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 229430, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function34 = function3522;
                i36 = i29;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            layoutDirection2 = layoutDirection;
            i26 = i17 & 32;
            if (i26 != 0) {
            }
            i27 = i3;
            i28 = i17 & 64;
            if (i28 == 0) {
            }
            if ((i18 & 2995931) != 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i16 & 1) != 0) {
            }
            if (i39 != 0) {
            }
            if (i46 != 0) {
            }
            if ((i17 & 4) != 0) {
            }
            if ((i17 & 8) != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            iVar3 = iVar2;
            kVar3 = kVar2;
            layoutDirection3 = layoutDirection2;
            i29 = i27;
            function33 = function32;
            dVar3 = dVar2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Integer valueOf222 = Integer.valueOf(i29);
            j jVar222 = j.f339286a;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("maxItemsInEachRow", valueOf222, null, null, null, null, jVar222, 60, null), new com.tencent.ntcompose.core.k("flexWrapWrap", Boolean.TRUE, null, null, null, null, jVar222, 60, null), new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", new Pair(dVar3, kVar3), null, null, null, null, jVar222, 60, null), new com.tencent.ntcompose.core.k("layoutDirection", layoutDirection3, null, null, null, null, jVar222, 60, null));
            Function3<? super i, ? super Composer, ? super Integer, Unit> function35222 = function33;
            ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? function22 : null, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -1984177073, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.FlowRowKt$FlowRow$1
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

                public final void invoke(Composer composer2, int i47) {
                    if ((i47 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1984177073, i47, -1, "com.tencent.ntcompose.foundation.layout.FlowRow.<anonymous> (FlowRow.kt:54)");
                    }
                    Function3<i, Composer, Integer, Unit> function362 = function33;
                    if (function362 != null) {
                        function362.invoke(j.f339286a, composer2, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 229430, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function34 = function35222;
            i36 = i29;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        iVar2 = iVar;
        if ((i16 & 896) != 0) {
        }
        if ((i16 & 7168) != 0) {
        }
        i19 = i17 & 16;
        if (i19 == 0) {
        }
        layoutDirection2 = layoutDirection;
        i26 = i17 & 32;
        if (i26 != 0) {
        }
        i27 = i3;
        i28 = i17 & 64;
        if (i28 == 0) {
        }
        if ((i18 & 2995931) != 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i16 & 1) != 0) {
        }
        if (i39 != 0) {
        }
        if (i46 != 0) {
        }
        if ((i17 & 4) != 0) {
        }
        if ((i17 & 8) != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        iVar3 = iVar2;
        kVar3 = kVar2;
        layoutDirection3 = layoutDirection2;
        i29 = i27;
        function33 = function32;
        dVar3 = dVar2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Integer valueOf2222 = Integer.valueOf(i29);
        j jVar2222 = j.f339286a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.ntcompose.core.k("maxItemsInEachRow", valueOf2222, null, null, null, null, jVar2222, 60, null), new com.tencent.ntcompose.core.k("flexWrapWrap", Boolean.TRUE, null, null, null, null, jVar2222, 60, null), new com.tencent.ntcompose.core.k("horizontalArrangement_verticalAlignment", new Pair(dVar3, kVar3), null, null, null, null, jVar2222, 60, null), new com.tencent.ntcompose.core.k("layoutDirection", layoutDirection3, null, null, null, null, jVar2222, 60, null));
        Function3<? super i, ? super Composer, ? super Integer, Unit> function352222 = function33;
        ComposeNodeKt.a("view", com.tencent.ntcompose.material.base.a.f339408a, function22 != null ? function22 : null, ComposeLayoutPropUpdaterKt.t(iVar3), arrayListOf, ComposableLambdaKt.composableLambda(startRestartGroup, -1984177073, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.FlowRowKt$FlowRow$1
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

            public final void invoke(Composer composer2, int i47) {
                if ((i47 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1984177073, i47, -1, "com.tencent.ntcompose.foundation.layout.FlowRow.<anonymous> (FlowRow.kt:54)");
                }
                Function3<i, Composer, Integer, Unit> function362 = function33;
                if (function362 != null) {
                    function362.invoke(j.f339286a, composer2, 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 229430, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function34 = function352222;
        i36 = i29;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
