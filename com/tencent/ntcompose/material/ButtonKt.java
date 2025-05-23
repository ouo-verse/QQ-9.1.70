package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00ae\u0001\u0010\u0015\u001a\u00020\u00062B\b\u0002\u0010\t\u001a<\u0012\u0004\u0012\u00020\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007\u00a2\u0006\u0002\b\b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u00a2\u0006\u0002\b\u0013\u00a2\u0006\u0002\b\bH\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "e", NodeProps.ON_CLICK, "Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/ntcompose/material/d;", NodeProps.COLORS, "Lcom/tencent/ntcompose/foundation/layout/n;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/material/d;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function2, final Function1<? super ClickParams, Unit> onClick, com.tencent.ntcompose.core.i iVar, d dVar, Function3<? super com.tencent.ntcompose.foundation.layout.n, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i16) {
        Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function22;
        final int i17;
        com.tencent.ntcompose.core.i iVar2;
        int i18;
        Function3<? super com.tencent.ntcompose.foundation.layout.n, ? super Composer, ? super Integer, Unit> function32;
        final com.tencent.ntcompose.core.i iVar3;
        d dVar2;
        boolean changed;
        Object rememberedValue;
        final Function3<? super com.tencent.ntcompose.foundation.layout.n, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1178504982);
        int i19 = i16 & 1;
        if (i19 != 0) {
            i17 = i3 | 6;
            function22 = function2;
        } else if ((i3 & 14) == 0) {
            function22 = function2;
            i17 = (startRestartGroup.changed(function22) ? 4 : 2) | i3;
        } else {
            function22 = function2;
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i26 = i16 & 4;
        if (i26 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            iVar2 = iVar;
            i17 |= startRestartGroup.changed(iVar2) ? 256 : 128;
            i18 = i16 & 16;
            if (i18 == 0) {
                i17 |= 24576;
            } else if ((57344 & i3) == 0) {
                function32 = function3;
                i17 |= startRestartGroup.changed(function32) ? 16384 : 8192;
                if ((41691 & i17) != 8338 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    dVar2 = dVar;
                    iVar3 = iVar2;
                    function33 = function32;
                } else {
                    if (i19 != 0) {
                        function22 = null;
                    }
                    iVar3 = i26 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                    dVar2 = (i16 & 8) != 0 ? null : dVar;
                    final Function3<? super com.tencent.ntcompose.foundation.layout.n, ? super Composer, ? super Integer, Unit> function34 = i18 != 0 ? null : function32;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1178504982, i17, -1, "com.tencent.ntcompose.material.Button (Button.kt:41)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed = startRestartGroup.changed(onClick);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                invoke2(clickParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ClickParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                onClick.invoke(it);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    com.tencent.ntcompose.core.i b16 = ViewEventPropUpdaterKt.d(companion, false, null, (Function1) rememberedValue, 3, null).b(iVar3);
                    a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1919298804, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer2, Integer num) {
                            invoke(nVar, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.n Row, Composer composer2, int i27) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if ((i27 & 14) == 0) {
                                i27 |= composer2.changed(Row) ? 4 : 2;
                            }
                            if ((i27 & 91) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1919298804, i27, -1, "com.tencent.ntcompose.material.Button.<anonymous> (Button.kt:53)");
                            }
                            Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit> function35 = function34;
                            if (function35 != null) {
                                function35.invoke(Row, composer2, Integer.valueOf((i27 & 14) | ((i17 >> 9) & 112)));
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i27 = ((i17 << 9) & 7168) | 196992;
                    function33 = function34;
                    RowKt.a(b16, b17, vertical, function22, null, composableLambda, startRestartGroup, i27, 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                final Function2<? super com.tencent.kuikly.core.views.v, ? super com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit> function23 = function22;
                final d dVar3 = dVar2;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$3
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
                        ButtonKt.a(function23, onClick, iVar3, dVar3, function33, composer2, i3 | 1, i16);
                    }
                });
                return;
            }
            function32 = function3;
            if ((41691 & i17) != 8338) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if ((i16 & 8) != 0) {
            }
            if (i18 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
            startRestartGroup.startReplaceableGroup(1157296644);
            changed = startRestartGroup.changed(onClick);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                    invoke2(clickParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClickParams it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    onClick.invoke(it);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            com.tencent.ntcompose.core.i b162 = ViewEventPropUpdaterKt.d(companion2, false, null, (Function1) rememberedValue, 3, null).b(iVar3);
            a.e b172 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
            Alignment.Vertical vertical2 = Alignment.Vertical.CenterVertically;
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, -1919298804, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer2, Integer num) {
                    invoke(nVar, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.ntcompose.foundation.layout.n Row, Composer composer2, int i272) {
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    if ((i272 & 14) == 0) {
                        i272 |= composer2.changed(Row) ? 4 : 2;
                    }
                    if ((i272 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1919298804, i272, -1, "com.tencent.ntcompose.material.Button.<anonymous> (Button.kt:53)");
                    }
                    Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit> function35 = function34;
                    if (function35 != null) {
                        function35.invoke(Row, composer2, Integer.valueOf((i272 & 14) | ((i17 >> 9) & 112)));
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            int i272 = ((i17 << 9) & 7168) | 196992;
            function33 = function34;
            RowKt.a(b162, b172, vertical2, function22, null, composableLambda2, startRestartGroup, i272, 16);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        iVar2 = iVar;
        i18 = i16 & 16;
        if (i18 == 0) {
        }
        function32 = function3;
        if ((41691 & i17) != 8338) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if ((i16 & 8) != 0) {
        }
        if (i18 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        i.Companion companion22 = com.tencent.ntcompose.core.i.INSTANCE;
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(onClick);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                invoke2(clickParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClickParams it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onClick.invoke(it);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        com.tencent.ntcompose.core.i b1622 = ViewEventPropUpdaterKt.d(companion22, false, null, (Function1) rememberedValue, 3, null).b(iVar3);
        a.e b1722 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
        Alignment.Vertical vertical22 = Alignment.Vertical.CenterVertically;
        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, -1919298804, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ButtonKt$Button$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer2, Integer num) {
                invoke(nVar, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.ntcompose.foundation.layout.n Row, Composer composer2, int i2722) {
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if ((i2722 & 14) == 0) {
                    i2722 |= composer2.changed(Row) ? 4 : 2;
                }
                if ((i2722 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1919298804, i2722, -1, "com.tencent.ntcompose.material.Button.<anonymous> (Button.kt:53)");
                }
                Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit> function35 = function34;
                if (function35 != null) {
                    function35.invoke(Row, composer2, Integer.valueOf((i2722 & 14) | ((i17 >> 9) & 112)));
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        int i2722 = ((i17 << 9) & 7168) | 196992;
        function33 = function34;
        RowKt.a(b1622, b1722, vertical22, function22, null, composableLambda22, startRestartGroup, i2722, 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
