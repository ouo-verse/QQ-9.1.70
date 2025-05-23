package com.tencent.ntcompose.foundation.event;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import com.tencent.ntcompose.activity.ComponentActivity;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aG\u0010\b\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0000H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "onRootViewSizeChanged", "a", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ActivityEventHandlerKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.kuikly.core.pager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ State<Function2<Double, Double, Unit>> f339228a;

        /* JADX WARN: Multi-variable type inference failed */
        a(State<? extends Function2<? super Double, ? super Double, Unit>> state) {
            this.f339228a = state;
        }

        @Override // com.tencent.kuikly.core.pager.c
        public void onPagerEvent(String pagerEvent, e eventData) {
            Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
        }

        @Override // com.tencent.kuikly.core.pager.c
        public void onRootViewSizeChanged(double d16, double d17) {
            c.a.a(this, d16, d17);
            this.f339228a.getValue().invoke(Double.valueOf(d16), Double.valueOf(d17));
        }
    }

    public static final void a(final Function2<? super Double, ? super Double, Unit> onRootViewSizeChanged, Composer composer, final int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(onRootViewSizeChanged, "onRootViewSizeChanged");
        Composer startRestartGroup = composer.startRestartGroup(1971231197);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(onRootViewSizeChanged) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1971231197, i16, -1, "com.tencent.ntcompose.foundation.event.ActivityEventHandler (ActivityEventHandler.kt:14)");
            }
            final ComponentActivity componentActivity = (ComponentActivity) startRestartGroup.consume(CompositionLocalsKt.c());
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onRootViewSizeChanged, startRestartGroup, i16 & 14);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new a(rememberUpdatedState);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final com.tencent.kuikly.core.pager.c cVar = (com.tencent.kuikly.core.pager.c) rememberedValue;
            EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.foundation.event.ActivityEventHandlerKt$ActivityEventHandler$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes34.dex */
                public static final class a implements DisposableEffectResult {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ ComponentActivity f339226a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ com.tencent.kuikly.core.pager.c f339227b;

                    public a(ComponentActivity componentActivity, com.tencent.kuikly.core.pager.c cVar) {
                        this.f339226a = componentActivity;
                        this.f339227b = cVar;
                    }

                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        this.f339226a.removePagerEventObserver(this.f339227b);
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
                    ComponentActivity.this.addPagerEventObserver(cVar);
                    return new a(ComponentActivity.this, cVar);
                }
            }, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ActivityEventHandlerKt$ActivityEventHandler$2
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

            public final void invoke(Composer composer2, int i17) {
                ActivityEventHandlerKt.a(onRootViewSizeChanged, composer2, i3 | 1);
            }
        });
    }
}
