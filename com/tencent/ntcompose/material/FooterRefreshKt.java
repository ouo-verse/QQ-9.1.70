package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u009a\u0001\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00002B\b\u0002\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\n0\u0013\u00a2\u0006\u0002\b\u0015H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ntcompose/material/p;", "b", "(Landroidx/compose/runtime/Composer;I)Lcom/tencent/ntcompose/material/p;", "state", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/FooterRefreshView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "", "preloadDistance", "minListContentSize", "Lkotlin/Function0;", "onLoadMoreRefresh", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/material/p;Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;FFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FooterRefreshKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final p state, Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function2, com.tencent.ntcompose.core.i iVar, float f16, float f17, final Function0<Unit> onLoadMoreRefresh, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16) {
        int i17;
        final Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function22;
        int i18;
        com.tencent.ntcompose.core.i iVar2;
        int i19;
        float f18;
        int i26;
        float f19;
        boolean changed;
        Object rememberedValue;
        Object rememberedValue2;
        Composer.Companion companion;
        boolean changed2;
        Object rememberedValue3;
        boolean changed3;
        Object rememberedValue4;
        final com.tencent.ntcompose.core.i iVar3;
        final float f26;
        ScopeUpdateScope endRestartGroup;
        int i27;
        int i28;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onLoadMoreRefresh, "onLoadMoreRefresh");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(268593894);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(state) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i29 = i16 & 2;
        if (i29 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            function22 = function2;
            i17 |= startRestartGroup.changed(function22) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                iVar2 = iVar;
                i17 |= startRestartGroup.changed(iVar2) ? 256 : 128;
                i19 = i16 & 8;
                if (i19 != 0) {
                    i17 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    f18 = f16;
                    i17 |= startRestartGroup.changed(f18) ? 2048 : 1024;
                    i26 = i16 & 16;
                    if (i26 == 0) {
                        i17 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        f19 = f17;
                        i17 |= startRestartGroup.changed(f19) ? 16384 : 8192;
                        if ((i16 & 32) == 0) {
                            i28 = (i3 & 458752) == 0 ? startRestartGroup.changed(onLoadMoreRefresh) ? 131072 : 65536 : 196608;
                            if ((i16 & 64) != 0) {
                                i27 = (i3 & 3670016) == 0 ? startRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                                if ((i17 & 2995931) != 599186 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    iVar3 = iVar2;
                                    f26 = f18;
                                } else {
                                    if (i29 != 0) {
                                        function22 = null;
                                    }
                                    com.tencent.ntcompose.core.i iVar4 = i18 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                                    float f27 = i19 != 0 ? 500.0f : f18;
                                    float f28 = i26 != 0 ? 0.0f : f19;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(268593894, i17, -1, "com.tencent.ntcompose.material.FooterRefresh (FooterRefresh.kt:51)");
                                    }
                                    startRestartGroup.startReplaceableGroup(511388516);
                                    changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                                                invoke2(footerRefreshState);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(FooterRefreshState it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                if (it == FooterRefreshState.REFRESHING) {
                                                    p.this.b(true);
                                                    onLoadMoreRefresh.invoke();
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    Function1 function1 = (Function1) rememberedValue;
                                    ArrayList arrayList = new ArrayList();
                                    Float valueOf = Float.valueOf(f27);
                                    q qVar = q.f339443a;
                                    arrayList.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf, null, null, null, null, qVar, 60, null));
                                    arrayList.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar, 60, null));
                                    arrayList.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function1, null, null, null, null, qVar, 60, null));
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new com.tencent.kuikly.core.base.aa(BridgeManager.f117344a.u(), 0), null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue2;
                                    com.tencent.ntcompose.material.base.a aVar = com.tencent.ntcompose.material.base.a.f339408a;
                                    startRestartGroup.startReplaceableGroup(511388516);
                                    changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(function22);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (!changed2 || rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                                                invoke2(obj, aaVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                mutableState.setValue(it);
                                                Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function23 = function22;
                                                if (function23 != null) {
                                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                                                    function23.invoke((FooterRefreshView) obj, it);
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function23 = function22;
                                    ComposeNodeKt.a("footer_refresh", aVar, (Function2) rememberedValue3, iVar4, arrayList, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                                    Object value = mutableState.getValue();
                                    Boolean valueOf2 = Boolean.valueOf(state.a());
                                    startRestartGroup.startReplaceableGroup(511388516);
                                    changed3 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(state);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (!changed3 || rememberedValue4 == companion.getEmpty()) {
                                        rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                                FooterRefreshView b16 = mutableState.getValue().b();
                                                if (b16 != null) {
                                                    if (state.a()) {
                                                        b16.p();
                                                    } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                                                        b16.t(FooterRefreshEndState.SUCCESS);
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
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    EffectsKt.DisposableEffect(value, valueOf2, (Function1) rememberedValue4, startRestartGroup, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function22 = function23;
                                    iVar3 = iVar4;
                                    f26 = f27;
                                    f19 = f28;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    return;
                                }
                                final Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function24 = function22;
                                final float f29 = f19;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$3
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
                                        FooterRefreshKt.a(p.this, function24, iVar3, f26, f29, onLoadMoreRefresh, content, composer2, i3 | 1, i16);
                                    }
                                });
                                return;
                            }
                            i17 |= i27;
                            if ((i17 & 2995931) != 599186) {
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
                            startRestartGroup.startReplaceableGroup(511388516);
                            changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                                    invoke2(footerRefreshState);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(FooterRefreshState it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (it == FooterRefreshState.REFRESHING) {
                                        p.this.b(true);
                                        onLoadMoreRefresh.invoke();
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            startRestartGroup.endReplaceableGroup();
                            Function1 function12 = (Function1) rememberedValue;
                            ArrayList arrayList2 = new ArrayList();
                            Float valueOf3 = Float.valueOf(f27);
                            q qVar2 = q.f339443a;
                            arrayList2.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf3, null, null, null, null, qVar2, 60, null));
                            arrayList2.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar2, 60, null));
                            arrayList2.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function12, null, null, null, null, qVar2, 60, null));
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue2 == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState<com.tencent.kuikly.core.base.aa<FooterRefreshView>> mutableState2 = (MutableState) rememberedValue2;
                            com.tencent.ntcompose.material.base.a aVar2 = com.tencent.ntcompose.material.base.a.f339408a;
                            startRestartGroup.startReplaceableGroup(511388516);
                            changed2 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(function22);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changed2) {
                            }
                            rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                                    invoke2(obj, aaVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState2.setValue(it);
                                    Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function232 = function22;
                                    if (function232 != null) {
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                                        function232.invoke((FooterRefreshView) obj, it);
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                            startRestartGroup.endReplaceableGroup();
                            Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function232 = function22;
                            ComposeNodeKt.a("footer_refresh", aVar2, (Function2) rememberedValue3, iVar4, arrayList2, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                            Object value2 = mutableState2.getValue();
                            Boolean valueOf22 = Boolean.valueOf(state.a());
                            startRestartGroup.startReplaceableGroup(511388516);
                            changed3 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(state);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changed3) {
                            }
                            rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                    FooterRefreshView b16 = mutableState2.getValue().b();
                                    if (b16 != null) {
                                        if (state.a()) {
                                            b16.p();
                                        } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                                            b16.t(FooterRefreshEndState.SUCCESS);
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
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(value2, valueOf22, (Function1) rememberedValue4, startRestartGroup, 8);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function22 = function232;
                            iVar3 = iVar4;
                            f26 = f27;
                            f19 = f28;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i17 |= i28;
                        if ((i16 & 64) != 0) {
                        }
                        i17 |= i27;
                        if ((i17 & 2995931) != 599186) {
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
                        startRestartGroup.startReplaceableGroup(511388516);
                        changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                                invoke2(footerRefreshState);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FooterRefreshState it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (it == FooterRefreshState.REFRESHING) {
                                    p.this.b(true);
                                    onLoadMoreRefresh.invoke();
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        Function1 function122 = (Function1) rememberedValue;
                        ArrayList arrayList22 = new ArrayList();
                        Float valueOf32 = Float.valueOf(f27);
                        q qVar22 = q.f339443a;
                        arrayList22.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf32, null, null, null, null, qVar22, 60, null));
                        arrayList22.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar22, 60, null));
                        arrayList22.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function122, null, null, null, null, qVar22, 60, null));
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<com.tencent.kuikly.core.base.aa<FooterRefreshView>> mutableState22 = (MutableState) rememberedValue2;
                        com.tencent.ntcompose.material.base.a aVar22 = com.tencent.ntcompose.material.base.a.f339408a;
                        startRestartGroup.startReplaceableGroup(511388516);
                        changed2 = startRestartGroup.changed(mutableState22) | startRestartGroup.changed(function22);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                                invoke2(obj, aaVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState22.setValue(it);
                                Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function2322 = function22;
                                if (function2322 != null) {
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                                    function2322.invoke((FooterRefreshView) obj, it);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function2322 = function22;
                        ComposeNodeKt.a("footer_refresh", aVar22, (Function2) rememberedValue3, iVar4, arrayList22, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                        Object value22 = mutableState22.getValue();
                        Boolean valueOf222 = Boolean.valueOf(state.a());
                        startRestartGroup.startReplaceableGroup(511388516);
                        changed3 = startRestartGroup.changed(mutableState22) | startRestartGroup.changed(state);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                FooterRefreshView b16 = mutableState22.getValue().b();
                                if (b16 != null) {
                                    if (state.a()) {
                                        b16.p();
                                    } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                                        b16.t(FooterRefreshEndState.SUCCESS);
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
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.DisposableEffect(value22, valueOf222, (Function1) rememberedValue4, startRestartGroup, 8);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function22 = function2322;
                        iVar3 = iVar4;
                        f26 = f27;
                        f19 = f28;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    f19 = f17;
                    if ((i16 & 32) == 0) {
                    }
                    i17 |= i28;
                    if ((i16 & 64) != 0) {
                    }
                    i17 |= i27;
                    if ((i17 & 2995931) != 599186) {
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
                    startRestartGroup.startReplaceableGroup(511388516);
                    changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                            invoke2(footerRefreshState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FooterRefreshState it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (it == FooterRefreshState.REFRESHING) {
                                p.this.b(true);
                                onLoadMoreRefresh.invoke();
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    Function1 function1222 = (Function1) rememberedValue;
                    ArrayList arrayList222 = new ArrayList();
                    Float valueOf322 = Float.valueOf(f27);
                    q qVar222 = q.f339443a;
                    arrayList222.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf322, null, null, null, null, qVar222, 60, null));
                    arrayList222.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar222, 60, null));
                    arrayList222.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function1222, null, null, null, null, qVar222, 60, null));
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<com.tencent.kuikly.core.base.aa<FooterRefreshView>> mutableState222 = (MutableState) rememberedValue2;
                    com.tencent.ntcompose.material.base.a aVar222 = com.tencent.ntcompose.material.base.a.f339408a;
                    startRestartGroup.startReplaceableGroup(511388516);
                    changed2 = startRestartGroup.changed(mutableState222) | startRestartGroup.changed(function22);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                            invoke2(obj, aaVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState222.setValue(it);
                            Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function23222 = function22;
                            if (function23222 != null) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                                function23222.invoke((FooterRefreshView) obj, it);
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function23222 = function22;
                    ComposeNodeKt.a("footer_refresh", aVar222, (Function2) rememberedValue3, iVar4, arrayList222, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                    Object value222 = mutableState222.getValue();
                    Boolean valueOf2222 = Boolean.valueOf(state.a());
                    startRestartGroup.startReplaceableGroup(511388516);
                    changed3 = startRestartGroup.changed(mutableState222) | startRestartGroup.changed(state);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed3) {
                    }
                    rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            FooterRefreshView b16 = mutableState222.getValue().b();
                            if (b16 != null) {
                                if (state.a()) {
                                    b16.p();
                                } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                                    b16.t(FooterRefreshEndState.SUCCESS);
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
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(value222, valueOf2222, (Function1) rememberedValue4, startRestartGroup, 8);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function22 = function23222;
                    iVar3 = iVar4;
                    f26 = f27;
                    f19 = f28;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f18 = f16;
                i26 = i16 & 16;
                if (i26 == 0) {
                }
                f19 = f17;
                if ((i16 & 32) == 0) {
                }
                i17 |= i28;
                if ((i16 & 64) != 0) {
                }
                i17 |= i27;
                if ((i17 & 2995931) != 599186) {
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
                startRestartGroup.startReplaceableGroup(511388516);
                changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                        invoke2(footerRefreshState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FooterRefreshState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it == FooterRefreshState.REFRESHING) {
                            p.this.b(true);
                            onLoadMoreRefresh.invoke();
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                Function1 function12222 = (Function1) rememberedValue;
                ArrayList arrayList2222 = new ArrayList();
                Float valueOf3222 = Float.valueOf(f27);
                q qVar2222 = q.f339443a;
                arrayList2222.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf3222, null, null, null, null, qVar2222, 60, null));
                arrayList2222.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar2222, 60, null));
                arrayList2222.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function12222, null, null, null, null, qVar2222, 60, null));
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue2 = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue2 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<com.tencent.kuikly.core.base.aa<FooterRefreshView>> mutableState2222 = (MutableState) rememberedValue2;
                com.tencent.ntcompose.material.base.a aVar2222 = com.tencent.ntcompose.material.base.a.f339408a;
                startRestartGroup.startReplaceableGroup(511388516);
                changed2 = startRestartGroup.changed(mutableState2222) | startRestartGroup.changed(function22);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                        invoke2(obj, aaVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        mutableState2222.setValue(it);
                        Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function232222 = function22;
                        if (function232222 != null) {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                            function232222.invoke((FooterRefreshView) obj, it);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function232222 = function22;
                ComposeNodeKt.a("footer_refresh", aVar2222, (Function2) rememberedValue3, iVar4, arrayList2222, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
                Object value2222 = mutableState2222.getValue();
                Boolean valueOf22222 = Boolean.valueOf(state.a());
                startRestartGroup.startReplaceableGroup(511388516);
                changed3 = startRestartGroup.changed(mutableState2222) | startRestartGroup.changed(state);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        FooterRefreshView b16 = mutableState2222.getValue().b();
                        if (b16 != null) {
                            if (state.a()) {
                                b16.p();
                            } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                                b16.t(FooterRefreshEndState.SUCCESS);
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
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(value2222, valueOf22222, (Function1) rememberedValue4, startRestartGroup, 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                function22 = function232222;
                iVar3 = iVar4;
                f26 = f27;
                f19 = f28;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            iVar2 = iVar;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            f18 = f16;
            i26 = i16 & 16;
            if (i26 == 0) {
            }
            f19 = f17;
            if ((i16 & 32) == 0) {
            }
            i17 |= i28;
            if ((i16 & 64) != 0) {
            }
            i17 |= i27;
            if ((i17 & 2995931) != 599186) {
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
            startRestartGroup.startReplaceableGroup(511388516);
            changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                    invoke2(footerRefreshState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FooterRefreshState it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it == FooterRefreshState.REFRESHING) {
                        p.this.b(true);
                        onLoadMoreRefresh.invoke();
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            Function1 function122222 = (Function1) rememberedValue;
            ArrayList arrayList22222 = new ArrayList();
            Float valueOf32222 = Float.valueOf(f27);
            q qVar22222 = q.f339443a;
            arrayList22222.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf32222, null, null, null, null, qVar22222, 60, null));
            arrayList22222.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar22222, 60, null));
            arrayList22222.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function122222, null, null, null, null, qVar22222, 60, null));
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<com.tencent.kuikly.core.base.aa<FooterRefreshView>> mutableState22222 = (MutableState) rememberedValue2;
            com.tencent.ntcompose.material.base.a aVar22222 = com.tencent.ntcompose.material.base.a.f339408a;
            startRestartGroup.startReplaceableGroup(511388516);
            changed2 = startRestartGroup.changed(mutableState22222) | startRestartGroup.changed(function22);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                    invoke2(obj, aaVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState22222.setValue(it);
                    Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function2322222 = function22;
                    if (function2322222 != null) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                        function2322222.invoke((FooterRefreshView) obj, it);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function2322222 = function22;
            ComposeNodeKt.a("footer_refresh", aVar22222, (Function2) rememberedValue3, iVar4, arrayList22222, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
            Object value22222 = mutableState22222.getValue();
            Boolean valueOf222222 = Boolean.valueOf(state.a());
            startRestartGroup.startReplaceableGroup(511388516);
            changed3 = startRestartGroup.changed(mutableState22222) | startRestartGroup.changed(state);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    FooterRefreshView b16 = mutableState22222.getValue().b();
                    if (b16 != null) {
                        if (state.a()) {
                            b16.p();
                        } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                            b16.t(FooterRefreshEndState.SUCCESS);
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
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(value22222, valueOf222222, (Function1) rememberedValue4, startRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
            }
            function22 = function2322222;
            iVar3 = iVar4;
            f26 = f27;
            f19 = f28;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function22 = function2;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        iVar2 = iVar;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        f18 = f16;
        i26 = i16 & 16;
        if (i26 == 0) {
        }
        f19 = f17;
        if ((i16 & 32) == 0) {
        }
        i17 |= i28;
        if ((i16 & 64) != 0) {
        }
        i17 |= i27;
        if ((i17 & 2995931) != 599186) {
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
        startRestartGroup.startReplaceableGroup(511388516);
        changed = startRestartGroup.changed(state) | startRestartGroup.changed(onLoadMoreRefresh);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$onRefreshStateChanged$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FooterRefreshState footerRefreshState) {
                invoke2(footerRefreshState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FooterRefreshState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it == FooterRefreshState.REFRESHING) {
                    p.this.b(true);
                    onLoadMoreRefresh.invoke();
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        Function1 function1222222 = (Function1) rememberedValue;
        ArrayList arrayList222222 = new ArrayList();
        Float valueOf322222 = Float.valueOf(f27);
        q qVar222222 = q.f339443a;
        arrayList222222.add(new com.tencent.ntcompose.core.k("preloadDistance", valueOf322222, null, null, null, null, qVar222222, 60, null));
        arrayList222222.add(new com.tencent.ntcompose.core.k("minListContentSize", Float.valueOf(f28), null, null, null, null, qVar222222, 60, null));
        arrayList222222.add(new com.tencent.ntcompose.core.k("onRefreshStateDidChange", function1222222, null, null, null, null, qVar222222, 60, null));
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<com.tencent.kuikly.core.base.aa<FooterRefreshView>> mutableState222222 = (MutableState) rememberedValue2;
        com.tencent.ntcompose.material.base.a aVar222222 = com.tencent.ntcompose.material.base.a.f339408a;
        startRestartGroup.startReplaceableGroup(511388516);
        changed2 = startRestartGroup.changed(mutableState222222) | startRestartGroup.changed(function22);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = new Function2<Object, com.tencent.kuikly.core.base.aa<?>, Unit>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, com.tencent.kuikly.core.base.aa<?> aaVar) {
                invoke2(obj, aaVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj, com.tencent.kuikly.core.base.aa<?> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                mutableState222222.setValue(it);
                Function2<FooterRefreshView, com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function23222222 = function22;
                if (function23222222 != null) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.FooterRefreshView");
                    function23222222.invoke((FooterRefreshView) obj, it);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        Function2<? super FooterRefreshView, ? super com.tencent.kuikly.core.base.aa<FooterRefreshView>, Unit> function23222222 = function22;
        ComposeNodeKt.a("footer_refresh", aVar222222, (Function2) rememberedValue3, iVar4, arrayList222222, content, startRestartGroup, ((i17 << 3) & 7168) | 32822 | ((i17 >> 3) & 458752), 0);
        Object value222222 = mutableState222222.getValue();
        Boolean valueOf2222222 = Boolean.valueOf(state.a());
        startRestartGroup.startReplaceableGroup(511388516);
        changed3 = startRestartGroup.changed(mutableState222222) | startRestartGroup.changed(state);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.FooterRefreshKt$FooterRefresh$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                FooterRefreshView b16 = mutableState222222.getValue().b();
                if (b16 != null) {
                    if (state.a()) {
                        b16.p();
                    } else if (b16.getRefreshState() == FooterRefreshState.REFRESHING) {
                        b16.t(FooterRefreshEndState.SUCCESS);
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
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(value222222, valueOf2222222, (Function1) rememberedValue4, startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        function22 = function23222222;
        iVar3 = iVar4;
        f26 = f27;
        f19 = f28;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final p b(Composer composer, int i3) {
        composer.startReplaceableGroup(274714068);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(274714068, i3, -1, "com.tencent.ntcompose.material.rememberFooterRefreshViewState (FooterRefresh.kt:24)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new p(false);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        p pVar = (p) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pVar;
    }
}
