package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.utils.b;
import com.tencent.kuikly.core.views.aq;
import com.tencent.ntcompose.core.ComposeOnKuiklyKt;
import com.tencent.ntcompose.core.g;
import com.tencent.ntcompose.material.KuiklyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HalfFloatingLayerKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void HalfFloatingLayer(final float f16, float f17, h hVar, float f18, Function1<Object, Unit> function1, HalfFloatingLayerState halfFloatingLayerState, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i3, final int i16) {
        int i17;
        float f19;
        int i18;
        int i19;
        float f26;
        int i26;
        Function1<Object, Unit> function12;
        HalfFloatingLayerState halfFloatingLayerState2;
        float f27;
        h hVar2;
        h hVar3;
        HalfFloatingLayerState rememberHalfFloatingLayerState;
        float f28;
        Function1<Object, Unit> function13;
        final float f29;
        final h hVar4;
        final float f36;
        final Function1<Object, Unit> function14;
        final HalfFloatingLayerState halfFloatingLayerState3;
        int i27;
        Composer startRestartGroup = composer.startRestartGroup(1304574726);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(f16) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i28 = i16 & 2;
        if (i28 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            f19 = f17;
            i17 |= startRestartGroup.changed(f19) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 != 0) {
                i17 |= 128;
            }
            i19 = i16 & 8;
            if (i19 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                f26 = f18;
                i17 |= startRestartGroup.changed(f26) ? 2048 : 1024;
                i26 = i16 & 16;
                if (i26 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    function12 = function1;
                    i17 |= startRestartGroup.changed(function12) ? 16384 : 8192;
                    if ((458752 & i3) != 0) {
                        if ((i16 & 32) == 0) {
                            halfFloatingLayerState2 = halfFloatingLayerState;
                            if (startRestartGroup.changed(halfFloatingLayerState2)) {
                                i27 = 131072;
                                i17 |= i27;
                            }
                        } else {
                            halfFloatingLayerState2 = halfFloatingLayerState;
                        }
                        i27 = 65536;
                        i17 |= i27;
                    } else {
                        halfFloatingLayerState2 = halfFloatingLayerState;
                    }
                    if ((i16 & 64) == 0) {
                        i17 |= 1572864;
                    } else if ((3670016 & i3) == 0) {
                        i17 |= startRestartGroup.changed(function2) ? 1048576 : 524288;
                        if ((i16 & 128) != 0) {
                            i17 |= 12582912;
                        } else if ((29360128 & i3) == 0) {
                            i17 |= startRestartGroup.changed(function22) ? 8388608 : 4194304;
                            if (i18 != 4 && (23967451 & i17) == 4793490 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                hVar4 = hVar;
                                f29 = f19;
                                f36 = f26;
                                function14 = function12;
                                halfFloatingLayerState3 = halfFloatingLayerState2;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    f27 = i28 == 0 ? 0.3f : f19;
                                    if (i18 == 0) {
                                        hVar2 = h.INSTANCE.m();
                                        i17 &= -897;
                                    } else {
                                        hVar2 = hVar;
                                    }
                                    if (i19 != 0) {
                                        f26 = 8.0f;
                                    }
                                    if (i26 != 0) {
                                        function12 = null;
                                    }
                                    if ((i16 & 32) == 0) {
                                        i17 &= -458753;
                                        hVar3 = hVar2;
                                        rememberHalfFloatingLayerState = rememberHalfFloatingLayerState(startRestartGroup);
                                        f28 = f26;
                                        function13 = function12;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1304574726, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayer (HalfFloatingLayer.kt:49)");
                                        }
                                        final float f37 = f27;
                                        final h hVar5 = hVar3;
                                        final float f38 = f28;
                                        final Function1<Object, Unit> function15 = function13;
                                        final HalfFloatingLayerState halfFloatingLayerState4 = rememberHalfFloatingLayerState;
                                        final int i29 = i17;
                                        KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                                ViewContainer<?, ?> viewContainer2 = viewContainer;
                                                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        mVar.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final float f39 = f16;
                                                final float f46 = f37;
                                                final h hVar6 = hVar5;
                                                final float f47 = f38;
                                                final Function1<Object, Unit> function16 = function15;
                                                final HalfFloatingLayerState halfFloatingLayerState5 = halfFloatingLayerState4;
                                                final Function1<aa<HalfFloatingLayerView>, Unit> function17 = new Function1<aa<HalfFloatingLayerView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<HalfFloatingLayerView> aaVar) {
                                                        HalfFloatingLayerState.this.getClass();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final Function2<Composer, Integer, Unit> function23 = function2;
                                                final int i36 = i29;
                                                final Function1<ViewContainer<?, ?>, Unit> function18 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        final Function2<Composer, Integer, Unit> function24 = function23;
                                                        final int i37 = i36;
                                                        ComposeOnKuiklyKt.a(viewContainer3, new Function1<g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(g gVar) {
                                                                final Function2<Composer, Integer, Unit> function25 = function24;
                                                                final int i38 = i37;
                                                                gVar.i(ComposableLambdaKt.composableLambdaInstance(-1220398386, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.3.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Unit invoke(Composer composer2, Integer num) {
                                                                        Composer composer3 = composer2;
                                                                        int intValue = num.intValue();
                                                                        if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                                                            composer3.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-1220398386, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HalfFloatingLayer.kt:72)");
                                                                            }
                                                                            function25.invoke(composer3, Integer.valueOf((i38 >> 18) & 14));
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final Function2<Composer, Integer, Unit> function24 = function22;
                                                final int i37 = i29;
                                                final Function1<aq<?, ?>, Unit> function19 = new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aq<?, ?> aqVar) {
                                                        final Function2<Composer, Integer, Unit> function25 = function24;
                                                        final int i38 = i37;
                                                        ComposeOnKuiklyKt.a(aqVar, new Function1<g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(g gVar) {
                                                                final Function2<Composer, Integer, Unit> function26 = function25;
                                                                final int i39 = i38;
                                                                gVar.i(ComposableLambdaKt.composableLambdaInstance(1336489176, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.4.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Unit invoke(Composer composer2, Integer num) {
                                                                        Composer composer3 = composer2;
                                                                        int intValue = num.intValue();
                                                                        if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                                                            composer3.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1336489176, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HalfFloatingLayer.kt:77)");
                                                                            }
                                                                            function26.invoke(composer3, Integer.valueOf((i39 >> 21) & 14));
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                viewContainer2.addChild(new HalfFloatingLayerView(), new Function1<HalfFloatingLayerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(HalfFloatingLayerView halfFloatingLayerView) {
                                                        HalfFloatingLayerView halfFloatingLayerView2 = halfFloatingLayerView;
                                                        final Function1<aa<HalfFloatingLayerView>, Unit> function110 = function17;
                                                        halfFloatingLayerView2.ref(halfFloatingLayerView2, new Function1<aa<HalfFloatingLayerView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aa<HalfFloatingLayerView> aaVar) {
                                                                aa<HalfFloatingLayerView> aaVar2 = aaVar;
                                                                Function1<aa<HalfFloatingLayerView>, Unit> function111 = function110;
                                                                if (function111 != null) {
                                                                    function111.invoke(aaVar2);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final float f48 = f46;
                                                        final h hVar7 = hVar6;
                                                        final float f49 = f47;
                                                        final Function1<ViewContainer<?, ?>, Unit> function111 = function18;
                                                        final Function1<aq<?, ?>, Unit> function112 = function19;
                                                        final float f56 = f39;
                                                        halfFloatingLayerView2.attr(new Function1<HalfFloatingLayerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(HalfFloatingLayerAttr halfFloatingLayerAttr) {
                                                                HalfFloatingLayerAttr halfFloatingLayerAttr2 = halfFloatingLayerAttr;
                                                                halfFloatingLayerAttr2.m140flex(1.0f);
                                                                halfFloatingLayerAttr2.bgMaskColorAlpha = f48;
                                                                halfFloatingLayerAttr2.boardBgColor = hVar7;
                                                                halfFloatingLayerAttr2.boardBorderRadius = f49;
                                                                halfFloatingLayerAttr2.boardIndicatorBarBuilder = function111;
                                                                Function1<aq<?, ?>, Unit> function113 = function112;
                                                                halfFloatingLayerAttr2.floatingLayerHeight$delegate.setValue(halfFloatingLayerAttr2, HalfFloatingLayerAttr.$$delegatedProperties[0], Float.valueOf(b.a(f56)));
                                                                halfFloatingLayerAttr2.boardBuilder = function113;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final Function1<Object, Unit> function113 = function16;
                                                        halfFloatingLayerView2.event(new Function1<HalfFloatingLayerEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(HalfFloatingLayerEvent halfFloatingLayerEvent) {
                                                                HalfFloatingLayerEvent halfFloatingLayerEvent2 = halfFloatingLayerEvent;
                                                                Function1<Object, Unit> function114 = function113;
                                                                if (function114 != null) {
                                                                    halfFloatingLayerEvent2.closeHandlerFn = function114;
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        }, startRestartGroup, 0, 3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        f29 = f27;
                                        hVar4 = hVar3;
                                        f36 = f28;
                                        function14 = function13;
                                        halfFloatingLayerState3 = rememberHalfFloatingLayerState;
                                    } else {
                                        hVar3 = hVar2;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if (i18 != 0) {
                                        i17 &= -897;
                                    }
                                    if ((i16 & 32) != 0) {
                                        hVar3 = hVar;
                                        i17 &= -458753;
                                    } else {
                                        hVar3 = hVar;
                                    }
                                    f27 = f19;
                                }
                                f28 = f26;
                                function13 = function12;
                                rememberHalfFloatingLayerState = halfFloatingLayerState2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final float f372 = f27;
                                final h hVar52 = hVar3;
                                final float f382 = f28;
                                final Function1<Object, Unit> function152 = function13;
                                final HalfFloatingLayerState halfFloatingLayerState42 = rememberHalfFloatingLayerState;
                                final int i292 = i17;
                                KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                        ViewContainer<?, ?> viewContainer2 = viewContainer;
                                        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                mVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final float f39 = f16;
                                        final float f46 = f372;
                                        final h hVar6 = hVar52;
                                        final float f47 = f382;
                                        final Function1<Object, Unit> function16 = function152;
                                        final HalfFloatingLayerState halfFloatingLayerState5 = halfFloatingLayerState42;
                                        final Function1<? super aa<HalfFloatingLayerView>, Unit> function17 = new Function1<aa<HalfFloatingLayerView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<HalfFloatingLayerView> aaVar) {
                                                HalfFloatingLayerState.this.getClass();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final Function2<? super Composer, ? super Integer, Unit> function23 = function2;
                                        final int i36 = i292;
                                        final Function1<? super ViewContainer<?, ?>, Unit> function18 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                                                final int i37 = i36;
                                                ComposeOnKuiklyKt.a(viewContainer3, new Function1<g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(g gVar) {
                                                        final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                                        final int i38 = i37;
                                                        gVar.i(ComposableLambdaKt.composableLambdaInstance(-1220398386, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.3.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(Composer composer2, Integer num) {
                                                                Composer composer3 = composer2;
                                                                int intValue = num.intValue();
                                                                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                                                    composer3.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1220398386, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HalfFloatingLayer.kt:72)");
                                                                    }
                                                                    function25.invoke(composer3, Integer.valueOf((i38 >> 18) & 14));
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                                        final int i37 = i292;
                                        final Function1<? super aq<?, ?>, Unit> function19 = new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                                final int i38 = i37;
                                                ComposeOnKuiklyKt.a(aqVar, new Function1<g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(g gVar) {
                                                        final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                                        final int i39 = i38;
                                                        gVar.i(ComposableLambdaKt.composableLambdaInstance(1336489176, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt.HalfFloatingLayer.1.4.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(Composer composer2, Integer num) {
                                                                Composer composer3 = composer2;
                                                                int intValue = num.intValue();
                                                                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                                                    composer3.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1336489176, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HalfFloatingLayer.kt:77)");
                                                                    }
                                                                    function26.invoke(composer3, Integer.valueOf((i39 >> 21) & 14));
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        viewContainer2.addChild(new HalfFloatingLayerView(), new Function1<HalfFloatingLayerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(HalfFloatingLayerView halfFloatingLayerView) {
                                                HalfFloatingLayerView halfFloatingLayerView2 = halfFloatingLayerView;
                                                final Function1<? super aa<HalfFloatingLayerView>, Unit> function110 = function17;
                                                halfFloatingLayerView2.ref(halfFloatingLayerView2, new Function1<aa<HalfFloatingLayerView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<HalfFloatingLayerView> aaVar) {
                                                        aa<HalfFloatingLayerView> aaVar2 = aaVar;
                                                        Function1<aa<HalfFloatingLayerView>, Unit> function111 = function110;
                                                        if (function111 != null) {
                                                            function111.invoke(aaVar2);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final float f48 = f46;
                                                final h hVar7 = hVar6;
                                                final float f49 = f47;
                                                final Function1<? super ViewContainer<?, ?>, Unit> function111 = function18;
                                                final Function1<? super aq<?, ?>, Unit> function112 = function19;
                                                final float f56 = f39;
                                                halfFloatingLayerView2.attr(new Function1<HalfFloatingLayerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(HalfFloatingLayerAttr halfFloatingLayerAttr) {
                                                        HalfFloatingLayerAttr halfFloatingLayerAttr2 = halfFloatingLayerAttr;
                                                        halfFloatingLayerAttr2.m140flex(1.0f);
                                                        halfFloatingLayerAttr2.bgMaskColorAlpha = f48;
                                                        halfFloatingLayerAttr2.boardBgColor = hVar7;
                                                        halfFloatingLayerAttr2.boardBorderRadius = f49;
                                                        halfFloatingLayerAttr2.boardIndicatorBarBuilder = function111;
                                                        Function1<aq<?, ?>, Unit> function113 = function112;
                                                        halfFloatingLayerAttr2.floatingLayerHeight$delegate.setValue(halfFloatingLayerAttr2, HalfFloatingLayerAttr.$$delegatedProperties[0], Float.valueOf(b.a(f56)));
                                                        halfFloatingLayerAttr2.boardBuilder = function113;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Function1<Object, Unit> function113 = function16;
                                                halfFloatingLayerView2.event(new Function1<HalfFloatingLayerEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerViewKt$HalfFloatingLayer$1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(HalfFloatingLayerEvent halfFloatingLayerEvent) {
                                                        HalfFloatingLayerEvent halfFloatingLayerEvent2 = halfFloatingLayerEvent;
                                                        Function1<Object, Unit> function114 = function113;
                                                        if (function114 != null) {
                                                            halfFloatingLayerEvent2.closeHandlerFn = function114;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }, startRestartGroup, 0, 3);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f29 = f27;
                                hVar4 = hVar3;
                                f36 = f28;
                                function14 = function13;
                                halfFloatingLayerState3 = rememberHalfFloatingLayerState;
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                return;
                            }
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt$HalfFloatingLayer$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Composer composer2, Integer num) {
                                    num.intValue();
                                    HalfFloatingLayerKt.HalfFloatingLayer(f16, f29, hVar4, f36, function14, halfFloatingLayerState3, function2, function22, composer2, i3 | 1, i16);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        if (i18 != 4) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i28 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if ((i16 & 32) == 0) {
                        }
                    }
                    if ((i16 & 128) != 0) {
                    }
                    if (i18 != 4) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i28 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if ((i16 & 32) == 0) {
                    }
                }
                function12 = function1;
                if ((458752 & i3) != 0) {
                }
                if ((i16 & 64) == 0) {
                }
                if ((i16 & 128) != 0) {
                }
                if (i18 != 4) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i28 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if ((i16 & 32) == 0) {
                }
            }
            f26 = f18;
            i26 = i16 & 16;
            if (i26 != 0) {
            }
            function12 = function1;
            if ((458752 & i3) != 0) {
            }
            if ((i16 & 64) == 0) {
            }
            if ((i16 & 128) != 0) {
            }
            if (i18 != 4) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i28 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if ((i16 & 32) == 0) {
            }
        }
        f19 = f17;
        i18 = i16 & 4;
        if (i18 != 0) {
        }
        i19 = i16 & 8;
        if (i19 == 0) {
        }
        f26 = f18;
        i26 = i16 & 16;
        if (i26 != 0) {
        }
        function12 = function1;
        if ((458752 & i3) != 0) {
        }
        if ((i16 & 64) == 0) {
        }
        if ((i16 & 128) != 0) {
        }
        if (i18 != 4) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i28 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if ((i16 & 32) == 0) {
        }
    }

    public static final HalfFloatingLayerState rememberHalfFloatingLayerState(Composer composer) {
        composer.startReplaceableGroup(439089250);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(439089250, 0, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.rememberHalfFloatingLayerState (HalfFloatingLayer.kt:15)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new HalfFloatingLayerState();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        HalfFloatingLayerState halfFloatingLayerState = (HalfFloatingLayerState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return halfFloatingLayerState;
    }
}
