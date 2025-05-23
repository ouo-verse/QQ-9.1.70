package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.AbsoluteLayoutKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.CrossAxisAlign;
import com.tencent.ntcompose.foundation.layout.MainAxisAlign;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import to3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0002\b\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\b\u0006H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a_\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0002\b\u00062\b\b\u0002\u0010\r\u001a\u00020\u00002\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\b\u0006H\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001an\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0002\b\u001bH\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"", "selectedTabIndex", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "indicator", "tabs", "c", "(ILcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Lcom/tencent/ntcompose/foundation/lazy/d;", "state", "firstLoadMaxIndex", "a", "(ILcom/tencent/ntcompose/foundation/lazy/d;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "Lkotlin/ParameterName;", "name", "e", NodeProps.ON_CLICK, "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "verticalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "horizontalAlignment", "Lcom/tencent/ntcompose/foundation/layout/d;", "Lkotlin/ExtensionFunctionType;", "text", "b", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function1;Lcom/tencent/ntcompose/foundation/layout/base/a$k;Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TabRowKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final int i3, com.tencent.ntcompose.foundation.lazy.d dVar, com.tencent.ntcompose.core.i iVar, Function2<? super Composer, ? super Integer, Unit> function2, int i16, final Function2<? super Composer, ? super Integer, Unit> tabs, Composer composer, final int i17, final int i18) {
        int i19;
        com.tencent.ntcompose.foundation.lazy.d dVar2;
        com.tencent.ntcompose.core.i iVar2;
        int i26;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i27;
        int i28;
        int i29;
        com.tencent.ntcompose.foundation.lazy.d dVar3;
        com.tencent.ntcompose.core.i iVar3;
        int i36;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        Composer composer2;
        final com.tencent.ntcompose.foundation.lazy.d dVar4;
        final com.tencent.ntcompose.core.i iVar4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final int i37;
        int i38;
        int i39;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer startRestartGroup = composer.startRestartGroup(773726244);
        if ((i18 & 1) != 0) {
            i19 = i17 | 6;
        } else if ((i17 & 14) == 0) {
            i19 = (startRestartGroup.changed(i3) ? 4 : 2) | i17;
        } else {
            i19 = i17;
        }
        if ((i17 & 112) == 0) {
            if ((i18 & 2) == 0) {
                dVar2 = dVar;
                if (startRestartGroup.changed(dVar2)) {
                    i39 = 32;
                    i19 |= i39;
                }
            } else {
                dVar2 = dVar;
            }
            i39 = 16;
            i19 |= i39;
        } else {
            dVar2 = dVar;
        }
        int i46 = i18 & 4;
        if (i46 != 0) {
            i19 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i17 & 896) == 0) {
            iVar2 = iVar;
            i19 |= startRestartGroup.changed(iVar2) ? 256 : 128;
            i26 = i18 & 8;
            if (i26 == 0) {
                i19 |= 3072;
            } else if ((i17 & 7168) == 0) {
                function22 = function2;
                i19 |= startRestartGroup.changed(function22) ? 2048 : 1024;
                i27 = i18 & 16;
                if (i27 != 0) {
                    i19 |= 24576;
                } else if ((57344 & i17) == 0) {
                    i28 = i16;
                    i19 |= startRestartGroup.changed(i28) ? 16384 : 8192;
                    if ((i18 & 32) != 0) {
                        i38 = (458752 & i17) == 0 ? startRestartGroup.changed(tabs) ? 131072 : 65536 : 196608;
                        if ((374491 & i19) != 74898 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            dVar4 = dVar2;
                            iVar4 = iVar2;
                            function24 = function22;
                            i37 = i28;
                            composer2 = startRestartGroup;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i17 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i18 & 2) != 0) {
                                    i19 &= -113;
                                }
                                i29 = i19;
                                dVar3 = dVar2;
                                iVar3 = iVar2;
                            } else {
                                if ((i18 & 2) != 0) {
                                    dVar2 = com.tencent.ntcompose.foundation.lazy.e.a(0, 0.0f, startRestartGroup, 0, 3);
                                    i19 &= -113;
                                }
                                com.tencent.ntcompose.core.i iVar5 = i46 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                                if (i26 != 0) {
                                    function22 = null;
                                }
                                if (i27 != 0) {
                                    i29 = i19;
                                    dVar3 = dVar2;
                                    iVar3 = iVar5;
                                    i36 = 5;
                                    function23 = function22;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(773726244, i29, -1, "com.tencent.ntcompose.material.ScrollableTabRow (TabRow.kt:120)");
                                    }
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                        rememberedValue = new Animatable(new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f)));
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final Animatable animatable = (Animatable) rememberedValue;
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = Integer.valueOf(i3);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    int intValue = ((Number) rememberedValue2).intValue();
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i3), null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue3;
                                    final Ref.IntRef intRef = new Ref.IntRef();
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (rememberedValue4 == companion.getEmpty()) {
                                        rememberedValue4 = 0;
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    intRef.element = ((Number) rememberedValue4).intValue();
                                    int i47 = intValue + i36;
                                    final int i48 = i29;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                    final com.tencent.ntcompose.foundation.lazy.d dVar5 = dVar3;
                                    int i49 = i29;
                                    composer2 = startRestartGroup;
                                    LazyRowKt.a(iVar3, null, dVar3, null, null, null, null, Boolean.FALSE, null, null, null, i47, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -550165139, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer3, Integer num) {
                                            invoke(aVar, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(com.tencent.ntcompose.foundation.lazy.layout.a LazyRow, Composer composer3, int i56) {
                                            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                            if ((i56 & 81) == 16 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-550165139, i56, -1, "com.tencent.ntcompose.material.ScrollableTabRow.<anonymous> (TabRow.kt:137)");
                                            }
                                            tabs.invoke(composer3, Integer.valueOf((i48 >> 15) & 14));
                                            final Function2<Composer, Integer, Unit> function26 = function25;
                                            if (function26 != null) {
                                                final Animatable<Pair<Float, Float>> animatable2 = animatable;
                                                final int i57 = i3;
                                                final com.tencent.ntcompose.foundation.lazy.d dVar6 = dVar5;
                                                int i58 = i48;
                                                final MutableState<Integer> mutableState2 = mutableState;
                                                final Ref.IntRef intRef2 = intRef;
                                                AbsoluteLayoutKt.a(null, ModifiersKt.M(ModifiersKt.T(ModifiersKt.C(ModifiersKt.R(com.tencent.ntcompose.core.i.INSTANCE, animatable2.f().getFirst().floatValue() > 0.0f), true), -1), false), false, Float.valueOf(0.0f), Float.valueOf(animatable2.f().getSecond().floatValue()), Float.valueOf(0.0f), null, Float.valueOf(animatable2.f().getFirst().floatValue()), null, MainAxisAlign.END, CrossAxisAlign.CENTER, ComposableLambdaKt.composableLambda(composer3, -763479855, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                        invoke(composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i59) {
                                                        if ((i59 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-763479855, i59, -1, "com.tencent.ntcompose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:149)");
                                                        }
                                                        function26.invoke(composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), composer3, 805506048, 54, 325);
                                                EffectsKt.DisposableEffect(Integer.valueOf(i57), Float.valueOf(dVar6.d()), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$2

                                                    /* compiled from: P */
                                                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                                                    /* loaded from: classes34.dex */
                                                    public static final class a implements DisposableEffectResult {

                                                        /* renamed from: a, reason: collision with root package name */
                                                        final /* synthetic */ Ref.IntRef f339355a;

                                                        public a(Ref.IntRef intRef) {
                                                            this.f339355a = intRef;
                                                        }

                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                        public void dispose() {
                                                            this.f339355a.element++;
                                                        }
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                                        if (com.tencent.ntcompose.foundation.lazy.d.this.d() > 0.0f) {
                                                            final MutableState<Integer> mutableState3 = mutableState2;
                                                            final int i59 = i57;
                                                            final com.tencent.ntcompose.foundation.lazy.d dVar7 = com.tencent.ntcompose.foundation.lazy.d.this;
                                                            final Animatable<Pair<Float, Float>> animatable3 = animatable2;
                                                            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$2$task$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                                    invoke2();
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2() {
                                                                    boolean z16;
                                                                    int intValue2 = mutableState3.getValue().intValue();
                                                                    int i65 = i59;
                                                                    if (intValue2 != i65) {
                                                                        mutableState3.setValue(Integer.valueOf(i65));
                                                                        z16 = true;
                                                                    } else {
                                                                        z16 = false;
                                                                    }
                                                                    com.tencent.kuikly.core.layout.d p16 = dVar7.p(i59);
                                                                    if (p16 != null) {
                                                                        Animatable<Pair<Float, Float>> animatable4 = animatable3;
                                                                        com.tencent.ntcompose.foundation.lazy.d dVar8 = dVar7;
                                                                        float width = p16.getWidth() - 0.01f;
                                                                        if (z16) {
                                                                            Animatable.b(animatable4, new Pair(Float.valueOf(width), Float.valueOf(p16.getX())), null, null, false, 14, null);
                                                                        } else {
                                                                            animatable4.h(new Pair<>(Float.valueOf(width), Float.valueOf(p16.getX())));
                                                                        }
                                                                        b.a.b(dVar8, Math.max(0.0f, Math.min(p16.getX() + ((-(dVar8.h().getWidth() - width)) / 2.0f), dVar8.f())), z16, null, 4, null);
                                                                    }
                                                                    if (dVar7.z().isEmpty()) {
                                                                        if (animatable3.f().getFirst().floatValue() == 0.0f) {
                                                                            return;
                                                                        }
                                                                        animatable3.h(new Pair<>(Float.valueOf(0.0f), Float.valueOf(0.0f)));
                                                                    }
                                                                }
                                                            };
                                                            if (mutableState2.getValue().intValue() != i57) {
                                                                final Ref.IntRef intRef3 = intRef2;
                                                                final int i65 = intRef3.element + 1;
                                                                intRef3.element = i65;
                                                                SchedulerKt.a(new Function0<Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                                        invoke2();
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2() {
                                                                        if (i65 == intRef3.element) {
                                                                            function0.invoke();
                                                                        }
                                                                    }
                                                                });
                                                            } else {
                                                                intRef2.element++;
                                                                function0.invoke();
                                                            }
                                                        }
                                                        return new a(intRef2);
                                                    }
                                                }, composer3, i58 & 14);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, ((i49 >> 6) & 14) | 12582912 | ((i49 << 3) & 896), 0, MsgConstant.KRMFILETHUMBSIZE384, 4192122);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    dVar4 = dVar3;
                                    iVar4 = iVar3;
                                    function24 = function23;
                                    i37 = i36;
                                } else {
                                    i29 = i19;
                                    dVar3 = dVar2;
                                    iVar3 = iVar5;
                                }
                            }
                            function23 = function22;
                            i36 = i28;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final Animatable<Pair<Float, Float>> animatable2 = (Animatable) rememberedValue;
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            int intValue2 = ((Number) rememberedValue2).intValue();
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState<Integer> mutableState2 = (MutableState) rememberedValue3;
                            final Ref.IntRef intRef2 = new Ref.IntRef();
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            intRef2.element = ((Number) rememberedValue4).intValue();
                            int i472 = intValue2 + i36;
                            final int i482 = i29;
                            final Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                            final com.tencent.ntcompose.foundation.lazy.d dVar52 = dVar3;
                            int i492 = i29;
                            composer2 = startRestartGroup;
                            LazyRowKt.a(iVar3, null, dVar3, null, null, null, null, Boolean.FALSE, null, null, null, i472, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -550165139, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer3, Integer num) {
                                    invoke(aVar, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.foundation.lazy.layout.a LazyRow, Composer composer3, int i56) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    if ((i56 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-550165139, i56, -1, "com.tencent.ntcompose.material.ScrollableTabRow.<anonymous> (TabRow.kt:137)");
                                    }
                                    tabs.invoke(composer3, Integer.valueOf((i482 >> 15) & 14));
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function252;
                                    if (function26 != null) {
                                        final Animatable<Pair<Float, Float>> animatable22 = animatable2;
                                        final int i57 = i3;
                                        final com.tencent.ntcompose.foundation.lazy.d dVar6 = dVar52;
                                        int i58 = i482;
                                        final MutableState<Integer> mutableState22 = mutableState2;
                                        final Ref.IntRef intRef22 = intRef2;
                                        AbsoluteLayoutKt.a(null, ModifiersKt.M(ModifiersKt.T(ModifiersKt.C(ModifiersKt.R(com.tencent.ntcompose.core.i.INSTANCE, animatable22.f().getFirst().floatValue() > 0.0f), true), -1), false), false, Float.valueOf(0.0f), Float.valueOf(animatable22.f().getSecond().floatValue()), Float.valueOf(0.0f), null, Float.valueOf(animatable22.f().getFirst().floatValue()), null, MainAxisAlign.END, CrossAxisAlign.CENTER, ComposableLambdaKt.composableLambda(composer3, -763479855, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i59) {
                                                if ((i59 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-763479855, i59, -1, "com.tencent.ntcompose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:149)");
                                                }
                                                function26.invoke(composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer3, 805506048, 54, 325);
                                        EffectsKt.DisposableEffect(Integer.valueOf(i57), Float.valueOf(dVar6.d()), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$2

                                            /* compiled from: P */
                                            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                                            /* loaded from: classes34.dex */
                                            public static final class a implements DisposableEffectResult {

                                                /* renamed from: a, reason: collision with root package name */
                                                final /* synthetic */ Ref.IntRef f339355a;

                                                public a(Ref.IntRef intRef) {
                                                    this.f339355a = intRef;
                                                }

                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                    this.f339355a.element++;
                                                }
                                            }

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                                if (com.tencent.ntcompose.foundation.lazy.d.this.d() > 0.0f) {
                                                    final MutableState<Integer> mutableState3 = mutableState22;
                                                    final int i59 = i57;
                                                    final com.tencent.ntcompose.foundation.lazy.d dVar7 = com.tencent.ntcompose.foundation.lazy.d.this;
                                                    final Animatable<Pair<Float, Float>> animatable3 = animatable22;
                                                    final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$2$task$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                                            invoke2();
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2() {
                                                            boolean z16;
                                                            int intValue22 = mutableState3.getValue().intValue();
                                                            int i65 = i59;
                                                            if (intValue22 != i65) {
                                                                mutableState3.setValue(Integer.valueOf(i65));
                                                                z16 = true;
                                                            } else {
                                                                z16 = false;
                                                            }
                                                            com.tencent.kuikly.core.layout.d p16 = dVar7.p(i59);
                                                            if (p16 != null) {
                                                                Animatable<Pair<Float, Float>> animatable4 = animatable3;
                                                                com.tencent.ntcompose.foundation.lazy.d dVar8 = dVar7;
                                                                float width = p16.getWidth() - 0.01f;
                                                                if (z16) {
                                                                    Animatable.b(animatable4, new Pair(Float.valueOf(width), Float.valueOf(p16.getX())), null, null, false, 14, null);
                                                                } else {
                                                                    animatable4.h(new Pair<>(Float.valueOf(width), Float.valueOf(p16.getX())));
                                                                }
                                                                b.a.b(dVar8, Math.max(0.0f, Math.min(p16.getX() + ((-(dVar8.h().getWidth() - width)) / 2.0f), dVar8.f())), z16, null, 4, null);
                                                            }
                                                            if (dVar7.z().isEmpty()) {
                                                                if (animatable3.f().getFirst().floatValue() == 0.0f) {
                                                                    return;
                                                                }
                                                                animatable3.h(new Pair<>(Float.valueOf(0.0f), Float.valueOf(0.0f)));
                                                            }
                                                        }
                                                    };
                                                    if (mutableState22.getValue().intValue() != i57) {
                                                        final Ref.IntRef intRef3 = intRef22;
                                                        final int i65 = intRef3.element + 1;
                                                        intRef3.element = i65;
                                                        SchedulerKt.a(new Function0<Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$1$1$2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                                invoke2();
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2() {
                                                                if (i65 == intRef3.element) {
                                                                    function0.invoke();
                                                                }
                                                            }
                                                        });
                                                    } else {
                                                        intRef22.element++;
                                                        function0.invoke();
                                                    }
                                                }
                                                return new a(intRef22);
                                            }
                                        }, composer3, i58 & 14);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, ((i492 >> 6) & 14) | 12582912 | ((i492 << 3) & 896), 0, MsgConstant.KRMFILETHUMBSIZE384, 4192122);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            dVar4 = dVar3;
                            iVar4 = iVar3;
                            function24 = function23;
                            i37 = i36;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$ScrollableTabRow$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i56) {
                                TabRowKt.a(i3, dVar4, iVar4, function24, i37, tabs, composer3, i17 | 1, i18);
                            }
                        });
                        return;
                    }
                    i19 |= i38;
                    if ((374491 & i19) != 74898) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i17 & 1) == 0) {
                    }
                    if ((i18 & 2) != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                }
                i28 = i16;
                if ((i18 & 32) != 0) {
                }
                i19 |= i38;
                if ((374491 & i19) != 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i17 & 1) == 0) {
                }
                if ((i18 & 2) != 0) {
                }
                if (i46 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
            }
            function22 = function2;
            i27 = i18 & 16;
            if (i27 != 0) {
            }
            i28 = i16;
            if ((i18 & 32) != 0) {
            }
            i19 |= i38;
            if ((374491 & i19) != 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i17 & 1) == 0) {
            }
            if ((i18 & 2) != 0) {
            }
            if (i46 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
        }
        iVar2 = iVar;
        i26 = i18 & 8;
        if (i26 == 0) {
        }
        function22 = function2;
        i27 = i18 & 16;
        if (i27 != 0) {
        }
        i28 = i16;
        if ((i18 & 32) != 0) {
        }
        i19 |= i38;
        if ((374491 & i19) != 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i17 & 1) == 0) {
        }
        if ((i18 & 2) != 0) {
        }
        if (i46 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(final int i3, com.tencent.ntcompose.core.i iVar, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> tabs, Composer composer, final int i16, final int i17) {
        int i18;
        com.tencent.ntcompose.core.i iVar2;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final int i26;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        boolean changed;
        Object rememberedValue5;
        Object rememberedValue6;
        boolean changed2;
        Object rememberedValue7;
        Composer composer2;
        final com.tencent.ntcompose.core.i iVar3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer startRestartGroup = composer.startRestartGroup(1719516397);
        if ((i17 & 1) != 0) {
            i18 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i18 = (startRestartGroup.changed(i3) ? 4 : 2) | i16;
        } else {
            i18 = i16;
        }
        int i27 = i17 & 2;
        if (i27 != 0) {
            i18 |= 48;
        } else if ((i16 & 112) == 0) {
            iVar2 = iVar;
            i18 |= startRestartGroup.changed(iVar2) ? 32 : 16;
            i19 = i17 & 4;
            if (i19 == 0) {
                i18 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                function22 = function2;
                i18 |= startRestartGroup.changed(function22) ? 256 : 128;
                if ((i17 & 8) != 0) {
                    i18 |= 3072;
                } else if ((i16 & 7168) == 0) {
                    i18 |= startRestartGroup.changed(tabs) ? 2048 : 1024;
                }
                i26 = i18;
                if ((i26 & 5851) != 1170 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    iVar3 = iVar2;
                    function23 = function22;
                    composer2 = startRestartGroup;
                } else {
                    com.tencent.ntcompose.core.i iVar4 = i27 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                    function23 = i19 != 0 ? null : function22;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1719516397, i26, -1, "com.tencent.ntcompose.material.TabRow (TabRow.kt:39)");
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = new Animatable(new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f)));
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    final Animatable animatable = (Animatable) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = Integer.valueOf(i3);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    ((Number) rememberedValue2).intValue();
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i3), null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue3;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.tencent.kuikly.core.layout.d.INSTANCE.a(), null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState mutableState2 = (MutableState) rememberedValue4;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed = startRestartGroup.changed(mutableState2);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$tModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                                invoke2(dVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState2.setValue(it);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceableGroup();
                    com.tencent.ntcompose.core.i a16 = ViewEventPropUpdaterKt.a(iVar4, (Function1) rememberedValue5);
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new com.tencent.kuikly.core.base.aa(BridgeManager.f117344a.u(), -1), null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState mutableState3 = (MutableState) rememberedValue6;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed2 = startRestartGroup.changed(mutableState3);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (!changed2 || rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function2<com.tencent.kuikly.core.views.v, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.v vVar, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v> aaVar) {
                                invoke2(vVar, aaVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.views.v Row, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v> it) {
                                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState3.setValue(it);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceableGroup();
                    final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 112548363, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer3, Integer num) {
                            invoke(nVar, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.n Row, Composer composer3, int i28) {
                            Intrinsics.checkNotNullParameter(Row, "$this$Row");
                            if ((i28 & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(112548363, i28, -1, "com.tencent.ntcompose.material.TabRow.<anonymous> (TabRow.kt:59)");
                            }
                            tabs.invoke(composer3, Integer.valueOf((i26 >> 9) & 14));
                            final Function2<Composer, Integer, Unit> function25 = function24;
                            if (function25 != null) {
                                final Animatable<Pair<Float, Float>> animatable2 = animatable;
                                final int i29 = i3;
                                final MutableState<com.tencent.kuikly.core.layout.d> mutableState4 = mutableState2;
                                int i36 = i26;
                                final MutableState<Integer> mutableState5 = mutableState;
                                final MutableState<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>> mutableState6 = mutableState3;
                                AbsoluteLayoutKt.a(null, ModifiersKt.M(ModifiersKt.T(ModifiersKt.C(ModifiersKt.R(com.tencent.ntcompose.core.i.INSTANCE, animatable2.f().getFirst().floatValue() > 0.0f), true), -1), false), false, Float.valueOf(0.0f), Float.valueOf(animatable2.f().getSecond().floatValue()), Float.valueOf(0.0f), null, Float.valueOf(animatable2.f().getFirst().floatValue()), null, MainAxisAlign.END, CrossAxisAlign.CENTER, ComposableLambdaKt.composableLambda(composer3, -1060349841, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i37) {
                                        if ((i37 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1060349841, i37, -1, "com.tencent.ntcompose.material.TabRow.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:71)");
                                        }
                                        function25.invoke(composer4, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 805506048, 54, 325);
                                EffectsKt.DisposableEffect(Integer.valueOf(i29), mutableState4.getValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2$1$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                        boolean z16;
                                        List<DeclarativeBaseView<?, ?>> a17;
                                        List<DeclarativeBaseView<?, ?>> a18;
                                        Object orNull;
                                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                        float width = mutableState4.getValue().getWidth();
                                        Float valueOf = Float.valueOf(0.0f);
                                        if (width > 0.0f) {
                                            int intValue = mutableState5.getValue().intValue();
                                            int i37 = i29;
                                            if (intValue != i37) {
                                                mutableState5.setValue(Integer.valueOf(i37));
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            com.tencent.kuikly.core.views.v b16 = mutableState6.getValue().b();
                                            if (b16 != null && (a18 = VirtualViewKt.a(b16)) != null) {
                                                orNull = CollectionsKt___CollectionsKt.getOrNull(a18, i29);
                                                DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) orNull;
                                                if (declarativeBaseView != null) {
                                                    Animatable<Pair<Float, Float>> animatable3 = animatable2;
                                                    com.tencent.kuikly.core.layout.d layoutFrame = declarativeBaseView.getFlexNode().getLayoutFrame();
                                                    if (!layoutFrame.f()) {
                                                        if (z16) {
                                                            Animatable.b(animatable3, new Pair(Float.valueOf(layoutFrame.getWidth()), Float.valueOf(layoutFrame.getX())), null, null, false, 14, null);
                                                        } else {
                                                            animatable3.h(new Pair<>(Float.valueOf(layoutFrame.getWidth()), Float.valueOf(layoutFrame.getX())));
                                                        }
                                                    }
                                                }
                                            }
                                            com.tencent.kuikly.core.views.v b17 = mutableState6.getValue().b();
                                            if ((b17 == null || (a17 = VirtualViewKt.a(b17)) == null || a17.size() != 1) ? false : true) {
                                                if (!(animatable2.f().getFirst().floatValue() == 0.0f)) {
                                                    animatable2.h(new Pair<>(valueOf, valueOf));
                                                }
                                            }
                                        }
                                        return new a();
                                    }

                                    /* compiled from: P */
                                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                                    /* loaded from: classes34.dex */
                                    public static final class a implements DisposableEffectResult {
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                        }
                                    }
                                }, composer3, (i36 & 14) | 64);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    com.tencent.ntcompose.core.i iVar5 = iVar4;
                    composer2 = startRestartGroup;
                    RowKt.a(a16, null, null, (Function2) rememberedValue7, null, composableLambda, composer2, 196608, 22);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    iVar3 = iVar5;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i28) {
                        TabRowKt.c(i3, iVar3, function25, tabs, composer3, i16 | 1, i17);
                    }
                });
                return;
            }
            function22 = function2;
            if ((i17 & 8) != 0) {
            }
            i26 = i18;
            if ((i26 & 5851) != 1170) {
            }
            if (i27 != 0) {
            }
            if (i19 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final Animatable<Pair<Float, Float>> animatable2 = (Animatable) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            ((Number) rememberedValue2).intValue();
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Integer> mutableState4 = (MutableState) rememberedValue3;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<com.tencent.kuikly.core.layout.d> mutableState22 = (MutableState) rememberedValue4;
            startRestartGroup.startReplaceableGroup(1157296644);
            changed = startRestartGroup.changed(mutableState22);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue5 = new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$tModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                    invoke2(dVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState22.setValue(it);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            com.tencent.ntcompose.core.i a162 = ViewEventPropUpdaterKt.a(iVar4, (Function1) rememberedValue5);
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>> mutableState32 = (MutableState) rememberedValue6;
            startRestartGroup.startReplaceableGroup(1157296644);
            changed2 = startRestartGroup.changed(mutableState32);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue7 = new Function2<com.tencent.kuikly.core.views.v, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.v vVar, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v> aaVar) {
                    invoke2(vVar, aaVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.kuikly.core.views.v Row, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v> it) {
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState32.setValue(it);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue7);
            startRestartGroup.endReplaceableGroup();
            final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 112548363, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer3, Integer num) {
                    invoke(nVar, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.ntcompose.foundation.layout.n Row, Composer composer3, int i28) {
                    Intrinsics.checkNotNullParameter(Row, "$this$Row");
                    if ((i28 & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(112548363, i28, -1, "com.tencent.ntcompose.material.TabRow.<anonymous> (TabRow.kt:59)");
                    }
                    tabs.invoke(composer3, Integer.valueOf((i26 >> 9) & 14));
                    final Function2<? super Composer, ? super Integer, Unit> function252 = function242;
                    if (function252 != null) {
                        final Animatable<Pair<Float, Float>> animatable22 = animatable2;
                        final int i29 = i3;
                        final MutableState<com.tencent.kuikly.core.layout.d> mutableState42 = mutableState22;
                        int i36 = i26;
                        final MutableState<Integer> mutableState5 = mutableState4;
                        final MutableState<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>> mutableState6 = mutableState32;
                        AbsoluteLayoutKt.a(null, ModifiersKt.M(ModifiersKt.T(ModifiersKt.C(ModifiersKt.R(com.tencent.ntcompose.core.i.INSTANCE, animatable22.f().getFirst().floatValue() > 0.0f), true), -1), false), false, Float.valueOf(0.0f), Float.valueOf(animatable22.f().getSecond().floatValue()), Float.valueOf(0.0f), null, Float.valueOf(animatable22.f().getFirst().floatValue()), null, MainAxisAlign.END, CrossAxisAlign.CENTER, ComposableLambdaKt.composableLambda(composer3, -1060349841, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i37) {
                                if ((i37 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1060349841, i37, -1, "com.tencent.ntcompose.material.TabRow.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:71)");
                                }
                                function252.invoke(composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 805506048, 54, 325);
                        EffectsKt.DisposableEffect(Integer.valueOf(i29), mutableState42.getValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                boolean z16;
                                List<DeclarativeBaseView<?, ?>> a17;
                                List<DeclarativeBaseView<?, ?>> a18;
                                Object orNull;
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                float width = mutableState42.getValue().getWidth();
                                Float valueOf = Float.valueOf(0.0f);
                                if (width > 0.0f) {
                                    int intValue = mutableState5.getValue().intValue();
                                    int i37 = i29;
                                    if (intValue != i37) {
                                        mutableState5.setValue(Integer.valueOf(i37));
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    com.tencent.kuikly.core.views.v b16 = mutableState6.getValue().b();
                                    if (b16 != null && (a18 = VirtualViewKt.a(b16)) != null) {
                                        orNull = CollectionsKt___CollectionsKt.getOrNull(a18, i29);
                                        DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) orNull;
                                        if (declarativeBaseView != null) {
                                            Animatable<Pair<Float, Float>> animatable3 = animatable22;
                                            com.tencent.kuikly.core.layout.d layoutFrame = declarativeBaseView.getFlexNode().getLayoutFrame();
                                            if (!layoutFrame.f()) {
                                                if (z16) {
                                                    Animatable.b(animatable3, new Pair(Float.valueOf(layoutFrame.getWidth()), Float.valueOf(layoutFrame.getX())), null, null, false, 14, null);
                                                } else {
                                                    animatable3.h(new Pair<>(Float.valueOf(layoutFrame.getWidth()), Float.valueOf(layoutFrame.getX())));
                                                }
                                            }
                                        }
                                    }
                                    com.tencent.kuikly.core.views.v b17 = mutableState6.getValue().b();
                                    if ((b17 == null || (a17 = VirtualViewKt.a(b17)) == null || a17.size() != 1) ? false : true) {
                                        if (!(animatable22.f().getFirst().floatValue() == 0.0f)) {
                                            animatable22.h(new Pair<>(valueOf, valueOf));
                                        }
                                    }
                                }
                                return new a();
                            }

                            /* compiled from: P */
                            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                            /* loaded from: classes34.dex */
                            public static final class a implements DisposableEffectResult {
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            }
                        }, composer3, (i36 & 14) | 64);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            com.tencent.ntcompose.core.i iVar52 = iVar4;
            composer2 = startRestartGroup;
            RowKt.a(a162, null, null, (Function2) rememberedValue7, null, composableLambda2, composer2, 196608, 22);
            if (ComposerKt.isTraceInProgress()) {
            }
            iVar3 = iVar52;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        iVar2 = iVar;
        i19 = i17 & 4;
        if (i19 == 0) {
        }
        function22 = function2;
        if ((i17 & 8) != 0) {
        }
        i26 = i18;
        if ((i26 & 5851) != 1170) {
        }
        if (i27 != 0) {
        }
        if (i19 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final Animatable<Pair<Float, Float>> animatable22 = (Animatable) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        ((Number) rememberedValue2).intValue();
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Integer> mutableState42 = (MutableState) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<com.tencent.kuikly.core.layout.d> mutableState222 = (MutableState) rememberedValue4;
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(mutableState222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue5 = new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$tModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                mutableState222.setValue(it);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        com.tencent.ntcompose.core.i a1622 = ViewEventPropUpdaterKt.a(iVar4, (Function1) rememberedValue5);
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>> mutableState322 = (MutableState) rememberedValue6;
        startRestartGroup.startReplaceableGroup(1157296644);
        changed2 = startRestartGroup.changed(mutableState322);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue7 = new Function2<com.tencent.kuikly.core.views.v, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.v vVar, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v> aaVar) {
                invoke2(vVar, aaVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.views.v Row, com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v> it) {
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                Intrinsics.checkNotNullParameter(it, "it");
                mutableState322.setValue(it);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue7);
        startRestartGroup.endReplaceableGroup();
        final Function2<? super Composer, ? super Integer, Unit> function2422 = function23;
        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 112548363, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer3, Integer num) {
                invoke(nVar, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.ntcompose.foundation.layout.n Row, Composer composer3, int i28) {
                Intrinsics.checkNotNullParameter(Row, "$this$Row");
                if ((i28 & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(112548363, i28, -1, "com.tencent.ntcompose.material.TabRow.<anonymous> (TabRow.kt:59)");
                }
                tabs.invoke(composer3, Integer.valueOf((i26 >> 9) & 14));
                final Function2<? super Composer, ? super Integer, Unit> function252 = function2422;
                if (function252 != null) {
                    final Animatable<Pair<Float, Float>> animatable222 = animatable22;
                    final int i29 = i3;
                    final MutableState<com.tencent.kuikly.core.layout.d> mutableState422 = mutableState222;
                    int i36 = i26;
                    final MutableState<Integer> mutableState5 = mutableState42;
                    final MutableState<com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.v>> mutableState6 = mutableState322;
                    AbsoluteLayoutKt.a(null, ModifiersKt.M(ModifiersKt.T(ModifiersKt.C(ModifiersKt.R(com.tencent.ntcompose.core.i.INSTANCE, animatable222.f().getFirst().floatValue() > 0.0f), true), -1), false), false, Float.valueOf(0.0f), Float.valueOf(animatable222.f().getSecond().floatValue()), Float.valueOf(0.0f), null, Float.valueOf(animatable222.f().getFirst().floatValue()), null, MainAxisAlign.END, CrossAxisAlign.CENTER, ComposableLambdaKt.composableLambda(composer3, -1060349841, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i37) {
                            if ((i37 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1060349841, i37, -1, "com.tencent.ntcompose.material.TabRow.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:71)");
                            }
                            function252.invoke(composer4, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 805506048, 54, 325);
                    EffectsKt.DisposableEffect(Integer.valueOf(i29), mutableState422.getValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.TabRowKt$TabRow$2$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            boolean z16;
                            List<DeclarativeBaseView<?, ?>> a17;
                            List<DeclarativeBaseView<?, ?>> a18;
                            Object orNull;
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            float width = mutableState422.getValue().getWidth();
                            Float valueOf = Float.valueOf(0.0f);
                            if (width > 0.0f) {
                                int intValue = mutableState5.getValue().intValue();
                                int i37 = i29;
                                if (intValue != i37) {
                                    mutableState5.setValue(Integer.valueOf(i37));
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                com.tencent.kuikly.core.views.v b16 = mutableState6.getValue().b();
                                if (b16 != null && (a18 = VirtualViewKt.a(b16)) != null) {
                                    orNull = CollectionsKt___CollectionsKt.getOrNull(a18, i29);
                                    DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) orNull;
                                    if (declarativeBaseView != null) {
                                        Animatable<Pair<Float, Float>> animatable3 = animatable222;
                                        com.tencent.kuikly.core.layout.d layoutFrame = declarativeBaseView.getFlexNode().getLayoutFrame();
                                        if (!layoutFrame.f()) {
                                            if (z16) {
                                                Animatable.b(animatable3, new Pair(Float.valueOf(layoutFrame.getWidth()), Float.valueOf(layoutFrame.getX())), null, null, false, 14, null);
                                            } else {
                                                animatable3.h(new Pair<>(Float.valueOf(layoutFrame.getWidth()), Float.valueOf(layoutFrame.getX())));
                                            }
                                        }
                                    }
                                }
                                com.tencent.kuikly.core.views.v b17 = mutableState6.getValue().b();
                                if ((b17 == null || (a17 = VirtualViewKt.a(b17)) == null || a17.size() != 1) ? false : true) {
                                    if (!(animatable222.f().getFirst().floatValue() == 0.0f)) {
                                        animatable222.h(new Pair<>(valueOf, valueOf));
                                    }
                                }
                            }
                            return new a();
                        }

                        /* compiled from: P */
                        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                        /* loaded from: classes34.dex */
                        public static final class a implements DisposableEffectResult {
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        }
                    }, composer3, (i36 & 14) | 64);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        com.tencent.ntcompose.core.i iVar522 = iVar4;
        composer2 = startRestartGroup;
        RowKt.a(a1622, null, null, (Function2) rememberedValue7, null, composableLambda22, composer2, 196608, 22);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar3 = iVar522;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(com.tencent.ntcompose.core.i iVar, final Function1<? super ClickParams, Unit> onClick, a.k kVar, Alignment.Horizontal horizontal, final Function3<? super com.tencent.ntcompose.foundation.layout.d, ? super Composer, ? super Integer, Unit> text, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        a.k kVar2;
        Alignment.Horizontal horizontal2;
        a.k kVar3;
        com.tencent.ntcompose.core.i iVar3;
        a.k kVar4;
        final int i18;
        Alignment.Horizontal horizontal3;
        Composer composer2;
        final com.tencent.ntcompose.core.i iVar4;
        final a.k kVar5;
        final Alignment.Horizontal horizontal4;
        int i19;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-1925589362);
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
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            if ((i16 & 4) == 0) {
                kVar2 = kVar;
                if (startRestartGroup.changed(kVar2)) {
                    i19 = 256;
                    i17 |= i19;
                }
            } else {
                kVar2 = kVar;
            }
            i19 = 128;
            i17 |= i19;
        } else {
            kVar2 = kVar;
        }
        int i27 = i16 & 8;
        if (i27 != 0) {
            i17 |= 3072;
        } else if ((i3 & 7168) == 0) {
            horizontal2 = horizontal;
            i17 |= startRestartGroup.changed(horizontal2) ? 2048 : 1024;
            if ((i16 & 16) == 0) {
                i17 |= 24576;
            } else if ((57344 & i3) == 0) {
                i17 |= startRestartGroup.changed(text) ? 16384 : 8192;
            }
            if ((46811 & i17) != 9362 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                iVar4 = iVar2;
                kVar5 = kVar2;
                horizontal4 = horizontal2;
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i16 & 4) != 0) {
                        i17 &= -897;
                    }
                    iVar3 = iVar2;
                    kVar4 = kVar2;
                } else {
                    com.tencent.ntcompose.core.i iVar5 = i26 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                    if ((i16 & 4) == 0) {
                        kVar3 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                        i17 &= -897;
                    } else {
                        kVar3 = kVar2;
                    }
                    if (i27 == 0) {
                        iVar3 = iVar5;
                        kVar4 = kVar3;
                        i18 = i17;
                        horizontal3 = Alignment.Horizontal.Start;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1925589362, i18, -1, "com.tencent.ntcompose.material.Tab (TabRow.kt:198)");
                        }
                        int i28 = i18 >> 3;
                        composer2 = startRestartGroup;
                        ColumnKt.a(ViewEventPropUpdaterKt.d(iVar3, false, null, onClick, 3, null), kVar4, horizontal3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1563974661, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$Tab$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer3, Integer num) {
                                invoke(dVar, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(com.tencent.ntcompose.foundation.layout.d Column, Composer composer3, int i29) {
                                Intrinsics.checkNotNullParameter(Column, "$this$Column");
                                if ((i29 & 14) == 0) {
                                    i29 |= composer3.changed(Column) ? 4 : 2;
                                }
                                if ((i29 & 91) == 18 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1563974661, i29, -1, "com.tencent.ntcompose.material.Tab.<anonymous> (TabRow.kt:206)");
                                }
                                text.invoke(Column, composer3, Integer.valueOf((i29 & 14) | ((i18 >> 9) & 112)));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), startRestartGroup, (i28 & 896) | (i28 & 112) | 24576, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        iVar4 = iVar3;
                        kVar5 = kVar4;
                        horizontal4 = horizontal3;
                    } else {
                        iVar3 = iVar5;
                        kVar4 = kVar3;
                    }
                }
                horizontal3 = horizontal2;
                i18 = i17;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i282 = i18 >> 3;
                composer2 = startRestartGroup;
                ColumnKt.a(ViewEventPropUpdaterKt.d(iVar3, false, null, onClick, 3, null), kVar4, horizontal3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1563974661, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$Tab$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer3, Integer num) {
                        invoke(dVar, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(com.tencent.ntcompose.foundation.layout.d Column, Composer composer3, int i29) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if ((i29 & 14) == 0) {
                            i29 |= composer3.changed(Column) ? 4 : 2;
                        }
                        if ((i29 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1563974661, i29, -1, "com.tencent.ntcompose.material.Tab.<anonymous> (TabRow.kt:206)");
                        }
                        text.invoke(Column, composer3, Integer.valueOf((i29 & 14) | ((i18 >> 9) & 112)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, (i282 & 896) | (i282 & 112) | 24576, 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                iVar4 = iVar3;
                kVar5 = kVar4;
                horizontal4 = horizontal3;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TabRowKt$Tab$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i29) {
                    TabRowKt.b(com.tencent.ntcompose.core.i.this, onClick, kVar5, horizontal4, text, composer3, i3 | 1, i16);
                }
            });
            return;
        }
        horizontal2 = horizontal;
        if ((i16 & 16) == 0) {
        }
        if ((46811 & i17) != 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i26 == 0) {
        }
        if ((i16 & 4) == 0) {
        }
        if (i27 == 0) {
        }
    }
}
