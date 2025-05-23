package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.scheduler.Choreographer;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aG\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"", "progress", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/kuikly/core/base/h;", "color", "backgroundColor", "strokeWidth", "rpm", "", "a", "(FLcom/tencent/ntcompose/core/i;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;FFLandroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ProgressIndicatorKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final float f16, final com.tencent.ntcompose.core.i modifier, com.tencent.kuikly.core.base.h hVar, com.tencent.kuikly.core.base.h hVar2, float f17, float f18, Composer composer, final int i3, final int i16) {
        int i17;
        float f19;
        int i18;
        float f26;
        com.tencent.kuikly.core.base.h hVar3;
        com.tencent.kuikly.core.base.h hVar4;
        com.tencent.kuikly.core.base.h hVar5;
        com.tencent.kuikly.core.base.h hVar6;
        float f27;
        float f28;
        float rint;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        boolean changed;
        Object rememberedValue5;
        final com.tencent.kuikly.core.base.h hVar7;
        final com.tencent.kuikly.core.base.h hVar8;
        final float f29;
        final float f36;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-769764447);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = i3 | (startRestartGroup.changed(f16) ? 4 : 2);
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i19 = i16 & 4;
        if (i19 != 0) {
            i17 |= 128;
        }
        int i26 = i16 & 8;
        if (i26 != 0) {
            i17 |= 1024;
        }
        int i27 = i16 & 16;
        if (i27 != 0) {
            i17 |= 24576;
        } else if ((i3 & 57344) == 0) {
            f19 = f17;
            i17 |= startRestartGroup.changed(f19) ? 16384 : 8192;
            i18 = i16 & 32;
            if (i18 == 0) {
                i17 |= 196608;
            } else if ((i3 & 458752) == 0) {
                f26 = f18;
                i17 |= startRestartGroup.changed(f26) ? 131072 : 65536;
                if ((i16 & 12) != 12 && (374491 & i17) == 74898 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    hVar7 = hVar;
                    hVar8 = hVar2;
                    f29 = f19;
                    f36 = f26;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            hVar3 = new com.tencent.kuikly.core.base.h(4278229503L);
                            i17 &= -897;
                        } else {
                            hVar3 = hVar;
                        }
                        if (i26 != 0) {
                            hVar4 = new com.tencent.kuikly.core.base.h(4290624957L);
                            i17 &= -7169;
                        } else {
                            hVar4 = hVar2;
                        }
                        hVar5 = hVar4;
                        hVar6 = hVar3;
                        f27 = i27 != 0 ? 4.0f : f19;
                        if (i18 != 0) {
                            f28 = 0.0f;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-769764447, i17, -1, "com.tencent.ntcompose.material.CircularProgressIndicator (ProgressIndicator.kt:158)");
                            }
                            if (f16 != 0.0f) {
                                double d16 = (f16 - ((int) f16)) * 100;
                                rint = ((((float) Math.rint(d16)) / 100.0f) > 0.0f ? 1 : ((((float) Math.rint(d16)) / 100.0f) == 0.0f ? 0 : -1)) == 0 ? 360.0f : ((float) Math.rint(d16)) * 3.6f;
                            } else {
                                rint = 0.0f;
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = new ah();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final ah ahVar = (ah) rememberedValue;
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue2;
                            final Choreographer a16 = Choreographer.INSTANCE.a();
                            final float f37 = f28;
                            final float f38 = rint;
                            EffectsKt.DisposableEffect(Float.valueOf(f28), Float.valueOf(rint), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$1

                                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                                /* loaded from: classes34.dex */
                                public static final class a implements Choreographer.b {

                                    /* renamed from: a, reason: collision with root package name */
                                    final /* synthetic */ ah f339346a;

                                    /* renamed from: b, reason: collision with root package name */
                                    final /* synthetic */ float f339347b;

                                    /* renamed from: c, reason: collision with root package name */
                                    final /* synthetic */ MutableState<Float> f339348c;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ float f339349d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ Choreographer f339350e;

                                    a(ah ahVar, float f16, MutableState<Float> mutableState, float f17, Choreographer choreographer) {
                                        this.f339346a = ahVar;
                                        this.f339347b = f16;
                                        this.f339348c = mutableState;
                                        this.f339349d = f17;
                                        this.f339350e = choreographer;
                                    }

                                    @Override // com.tencent.ntcompose.foundation.scheduler.Choreographer.b
                                    public void doFrame(long j3) {
                                        this.f339346a.c();
                                        float deltaTimeMs = ((this.f339347b / 60.0f) / 1000.0f) * 360.0f * this.f339346a.getDeltaTimeMs();
                                        MutableState<Float> mutableState = this.f339348c;
                                        mutableState.setValue(Float.valueOf((mutableState.getValue().floatValue() + deltaTimeMs) % 360.0f));
                                        float f16 = this.f339349d;
                                        if (f16 < 360.0f) {
                                            this.f339350e.d(this);
                                        } else if (f16 >= 360.0f) {
                                            this.f339350e.e(this);
                                        }
                                    }
                                }

                                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                                /* loaded from: classes34.dex */
                                public static final class b implements DisposableEffectResult {

                                    /* renamed from: a, reason: collision with root package name */
                                    final /* synthetic */ Choreographer f339351a;

                                    /* renamed from: b, reason: collision with root package name */
                                    final /* synthetic */ a f339352b;

                                    public b(Choreographer choreographer, a aVar) {
                                        this.f339351a = choreographer;
                                        this.f339352b = aVar;
                                    }

                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        this.f339351a.e(this.f339352b);
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
                                    ah.this.b();
                                    a aVar = new a(ah.this, f37, mutableState, f38, a16);
                                    if (f37 > 0.0f) {
                                        a16.d(aVar);
                                    }
                                    return new b(a16, aVar);
                                }
                            }, startRestartGroup, (i17 >> 15) & 14);
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new com.tencent.kuikly.core.base.w(0.0f, 0.0f), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState2 = (MutableState) rememberedValue3;
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = new i(false, 1, null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceableGroup();
                            i iVar = (i) rememberedValue4;
                            EffectsKt.LaunchedEffect(new Object[]{mutableState2.getValue(), hVar5, hVar6, Float.valueOf(rint)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new ProgressIndicatorKt$CircularProgressIndicator$2(mutableState2, f27, iVar, hVar5, hVar6, rint, null), startRestartGroup, 72);
                            com.tencent.ntcompose.core.i G = ModifiersKt.G(modifier, ((Number) mutableState.getValue()).floatValue(), null, 2, null);
                            startRestartGroup.startReplaceableGroup(1157296644);
                            changed = startRestartGroup.changed(mutableState2);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue5 == companion.getEmpty()) {
                                rememberedValue5 = new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                                        invoke2(wVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(com.tencent.kuikly.core.base.w it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        mutableState2.setValue(it);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            com.tencent.ntcompose.core.i m3 = ViewEventPropUpdaterKt.m(G, (Function1) rememberedValue5);
                            startRestartGroup.startReplaceableGroup(-522895883);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new com.tencent.ntcompose.core.k("drawCallbackEmpty", iVar, null, null, null, null, CanvasViewPropUpdater.f339340a, 60, null));
                            ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, m3, arrayList, null, startRestartGroup, 33206, 32);
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            hVar7 = hVar6;
                            hVar8 = hVar5;
                            f29 = f27;
                            f36 = f28;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if (i19 != 0) {
                            i17 &= -897;
                        }
                        if (i26 != 0) {
                            i17 &= -7169;
                        }
                        hVar6 = hVar;
                        hVar5 = hVar2;
                        f27 = f19;
                    }
                    f28 = f26;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (f16 != 0.0f) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final ah ahVar2 = (ah) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<Float> mutableState3 = (MutableState) rememberedValue2;
                    final Choreographer a162 = Choreographer.INSTANCE.a();
                    final float f372 = f28;
                    final float f382 = rint;
                    EffectsKt.DisposableEffect(Float.valueOf(f28), Float.valueOf(rint), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$1

                        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                        /* loaded from: classes34.dex */
                        public static final class a implements Choreographer.b {

                            /* renamed from: a, reason: collision with root package name */
                            final /* synthetic */ ah f339346a;

                            /* renamed from: b, reason: collision with root package name */
                            final /* synthetic */ float f339347b;

                            /* renamed from: c, reason: collision with root package name */
                            final /* synthetic */ MutableState<Float> f339348c;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ float f339349d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ Choreographer f339350e;

                            a(ah ahVar, float f16, MutableState<Float> mutableState, float f17, Choreographer choreographer) {
                                this.f339346a = ahVar;
                                this.f339347b = f16;
                                this.f339348c = mutableState;
                                this.f339349d = f17;
                                this.f339350e = choreographer;
                            }

                            @Override // com.tencent.ntcompose.foundation.scheduler.Choreographer.b
                            public void doFrame(long j3) {
                                this.f339346a.c();
                                float deltaTimeMs = ((this.f339347b / 60.0f) / 1000.0f) * 360.0f * this.f339346a.getDeltaTimeMs();
                                MutableState<Float> mutableState = this.f339348c;
                                mutableState.setValue(Float.valueOf((mutableState.getValue().floatValue() + deltaTimeMs) % 360.0f));
                                float f16 = this.f339349d;
                                if (f16 < 360.0f) {
                                    this.f339350e.d(this);
                                } else if (f16 >= 360.0f) {
                                    this.f339350e.e(this);
                                }
                            }
                        }

                        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                        /* loaded from: classes34.dex */
                        public static final class b implements DisposableEffectResult {

                            /* renamed from: a, reason: collision with root package name */
                            final /* synthetic */ Choreographer f339351a;

                            /* renamed from: b, reason: collision with root package name */
                            final /* synthetic */ a f339352b;

                            public b(Choreographer choreographer, a aVar) {
                                this.f339351a = choreographer;
                                this.f339352b = aVar;
                            }

                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                this.f339351a.e(this.f339352b);
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
                            ah.this.b();
                            a aVar = new a(ah.this, f372, mutableState3, f382, a162);
                            if (f372 > 0.0f) {
                                a162.d(aVar);
                            }
                            return new b(a162, aVar);
                        }
                    }, startRestartGroup, (i17 >> 15) & 14);
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<com.tencent.kuikly.core.base.w> mutableState22 = (MutableState) rememberedValue3;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    i iVar2 = (i) rememberedValue4;
                    EffectsKt.LaunchedEffect(new Object[]{mutableState22.getValue(), hVar5, hVar6, Float.valueOf(rint)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new ProgressIndicatorKt$CircularProgressIndicator$2(mutableState22, f27, iVar2, hVar5, hVar6, rint, null), startRestartGroup, 72);
                    com.tencent.ntcompose.core.i G2 = ModifiersKt.G(modifier, ((Number) mutableState3.getValue()).floatValue(), null, 2, null);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed = startRestartGroup.changed(mutableState22);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue5 = new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                            invoke2(wVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.base.w it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState22.setValue(it);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    com.tencent.ntcompose.core.i m36 = ViewEventPropUpdaterKt.m(G2, (Function1) rememberedValue5);
                    startRestartGroup.startReplaceableGroup(-522895883);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new com.tencent.ntcompose.core.k("drawCallbackEmpty", iVar2, null, null, null, null, CanvasViewPropUpdater.f339340a, 60, null));
                    ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, m36, arrayList2, null, startRestartGroup, 33206, 32);
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    hVar7 = hVar6;
                    hVar8 = hVar5;
                    f29 = f27;
                    f36 = f28;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i28) {
                        ProgressIndicatorKt.a(f16, modifier, hVar7, hVar8, f29, f36, composer2, i3 | 1, i16);
                    }
                });
                return;
            }
            f26 = f18;
            if ((i16 & 12) != 12) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            hVar5 = hVar4;
            hVar6 = hVar3;
            f27 = i27 != 0 ? 4.0f : f19;
            if (i18 != 0) {
            }
            f28 = f26;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (f16 != 0.0f) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final ah ahVar22 = (ah) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Float> mutableState32 = (MutableState) rememberedValue2;
            final Choreographer a1622 = Choreographer.INSTANCE.a();
            final float f3722 = f28;
            final float f3822 = rint;
            EffectsKt.DisposableEffect(Float.valueOf(f28), Float.valueOf(rint), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$1

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes34.dex */
                public static final class a implements Choreographer.b {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ ah f339346a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ float f339347b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ MutableState<Float> f339348c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ float f339349d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Choreographer f339350e;

                    a(ah ahVar, float f16, MutableState<Float> mutableState, float f17, Choreographer choreographer) {
                        this.f339346a = ahVar;
                        this.f339347b = f16;
                        this.f339348c = mutableState;
                        this.f339349d = f17;
                        this.f339350e = choreographer;
                    }

                    @Override // com.tencent.ntcompose.foundation.scheduler.Choreographer.b
                    public void doFrame(long j3) {
                        this.f339346a.c();
                        float deltaTimeMs = ((this.f339347b / 60.0f) / 1000.0f) * 360.0f * this.f339346a.getDeltaTimeMs();
                        MutableState<Float> mutableState = this.f339348c;
                        mutableState.setValue(Float.valueOf((mutableState.getValue().floatValue() + deltaTimeMs) % 360.0f));
                        float f16 = this.f339349d;
                        if (f16 < 360.0f) {
                            this.f339350e.d(this);
                        } else if (f16 >= 360.0f) {
                            this.f339350e.e(this);
                        }
                    }
                }

                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes34.dex */
                public static final class b implements DisposableEffectResult {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Choreographer f339351a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ a f339352b;

                    public b(Choreographer choreographer, a aVar) {
                        this.f339351a = choreographer;
                        this.f339352b = aVar;
                    }

                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        this.f339351a.e(this.f339352b);
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
                    ah.this.b();
                    a aVar = new a(ah.this, f3722, mutableState32, f3822, a1622);
                    if (f3722 > 0.0f) {
                        a1622.d(aVar);
                    }
                    return new b(a1622, aVar);
                }
            }, startRestartGroup, (i17 >> 15) & 14);
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<com.tencent.kuikly.core.base.w> mutableState222 = (MutableState) rememberedValue3;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            i iVar22 = (i) rememberedValue4;
            EffectsKt.LaunchedEffect(new Object[]{mutableState222.getValue(), hVar5, hVar6, Float.valueOf(rint)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new ProgressIndicatorKt$CircularProgressIndicator$2(mutableState222, f27, iVar22, hVar5, hVar6, rint, null), startRestartGroup, 72);
            com.tencent.ntcompose.core.i G22 = ModifiersKt.G(modifier, ((Number) mutableState32.getValue()).floatValue(), null, 2, null);
            startRestartGroup.startReplaceableGroup(1157296644);
            changed = startRestartGroup.changed(mutableState222);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue5 = new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                    invoke2(wVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.kuikly.core.base.w it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState222.setValue(it);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            com.tencent.ntcompose.core.i m362 = ViewEventPropUpdaterKt.m(G22, (Function1) rememberedValue5);
            startRestartGroup.startReplaceableGroup(-522895883);
            ArrayList arrayList22 = new ArrayList();
            arrayList22.add(new com.tencent.ntcompose.core.k("drawCallbackEmpty", iVar22, null, null, null, null, CanvasViewPropUpdater.f339340a, 60, null));
            ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, m362, arrayList22, null, startRestartGroup, 33206, 32);
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            hVar7 = hVar6;
            hVar8 = hVar5;
            f29 = f27;
            f36 = f28;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f19 = f17;
        i18 = i16 & 32;
        if (i18 == 0) {
        }
        f26 = f18;
        if ((i16 & 12) != 12) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        hVar5 = hVar4;
        hVar6 = hVar3;
        f27 = i27 != 0 ? 4.0f : f19;
        if (i18 != 0) {
        }
        f28 = f26;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (f16 != 0.0f) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final ah ahVar222 = (ah) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Float> mutableState322 = (MutableState) rememberedValue2;
        final Choreographer a16222 = Choreographer.INSTANCE.a();
        final float f37222 = f28;
        final float f38222 = rint;
        EffectsKt.DisposableEffect(Float.valueOf(f28), Float.valueOf(rint), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$1

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes34.dex */
            public static final class a implements Choreographer.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ah f339346a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ float f339347b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ MutableState<Float> f339348c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f339349d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Choreographer f339350e;

                a(ah ahVar, float f16, MutableState<Float> mutableState, float f17, Choreographer choreographer) {
                    this.f339346a = ahVar;
                    this.f339347b = f16;
                    this.f339348c = mutableState;
                    this.f339349d = f17;
                    this.f339350e = choreographer;
                }

                @Override // com.tencent.ntcompose.foundation.scheduler.Choreographer.b
                public void doFrame(long j3) {
                    this.f339346a.c();
                    float deltaTimeMs = ((this.f339347b / 60.0f) / 1000.0f) * 360.0f * this.f339346a.getDeltaTimeMs();
                    MutableState<Float> mutableState = this.f339348c;
                    mutableState.setValue(Float.valueOf((mutableState.getValue().floatValue() + deltaTimeMs) % 360.0f));
                    float f16 = this.f339349d;
                    if (f16 < 360.0f) {
                        this.f339350e.d(this);
                    } else if (f16 >= 360.0f) {
                        this.f339350e.e(this);
                    }
                }
            }

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class b implements DisposableEffectResult {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Choreographer f339351a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ a f339352b;

                public b(Choreographer choreographer, a aVar) {
                    this.f339351a = choreographer;
                    this.f339352b = aVar;
                }

                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    this.f339351a.e(this.f339352b);
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
                ah.this.b();
                a aVar = new a(ah.this, f37222, mutableState322, f38222, a16222);
                if (f37222 > 0.0f) {
                    a16222.d(aVar);
                }
                return new b(a16222, aVar);
            }
        }, startRestartGroup, (i17 >> 15) & 14);
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<com.tencent.kuikly.core.base.w> mutableState2222 = (MutableState) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        i iVar222 = (i) rememberedValue4;
        EffectsKt.LaunchedEffect(new Object[]{mutableState2222.getValue(), hVar5, hVar6, Float.valueOf(rint)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new ProgressIndicatorKt$CircularProgressIndicator$2(mutableState2222, f27, iVar222, hVar5, hVar6, rint, null), startRestartGroup, 72);
        com.tencent.ntcompose.core.i G222 = ModifiersKt.G(modifier, ((Number) mutableState322.getValue()).floatValue(), null, 2, null);
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(mutableState2222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue5 = new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                invoke2(wVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.base.w it) {
                Intrinsics.checkNotNullParameter(it, "it");
                mutableState2222.setValue(it);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        com.tencent.ntcompose.core.i m3622 = ViewEventPropUpdaterKt.m(G222, (Function1) rememberedValue5);
        startRestartGroup.startReplaceableGroup(-522895883);
        ArrayList arrayList222 = new ArrayList();
        arrayList222.add(new com.tencent.ntcompose.core.k("drawCallbackEmpty", iVar222, null, null, null, null, CanvasViewPropUpdater.f339340a, 60, null));
        ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, m3622, arrayList222, null, startRestartGroup, 33206, 32);
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        hVar7 = hVar6;
        hVar8 = hVar5;
        f29 = f27;
        f36 = f28;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
