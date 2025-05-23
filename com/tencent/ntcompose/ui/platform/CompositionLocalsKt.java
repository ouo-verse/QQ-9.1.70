package com.tencent.ntcompose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.activity.ComponentActivity;
import com.tencent.ntcompose.foundation.event.ActivityEventHandlerKt;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0004\u001a\u00020\u00012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000\u00a2\u0006\u0002\b\u0002H\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\"\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\n8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\n8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\u001f\u0010\u000e\u00a8\u0006#"}, d2 = {"Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "", "name", "", "g", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/tencent/ntcompose/ui/platform/a;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "d", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalConfiguration", "Lcom/tencent/ntcompose/activity/ComponentActivity;", "b", "c", "LocalActivity", "Lcom/tencent/ntcompose/ui/platform/b;", "getLocalContext", "LocalContext", "Lcom/tencent/ntcompose/ui/platform/d;", "getLocalModule", "LocalModule", "Lcom/tencent/ntcompose/foundation/event/d;", "e", "getLocalOnBackPressedDispatcherOwner", "LocalOnBackPressedDispatcherOwner", "Lcom/tencent/ntcompose/lifecycle/common/c;", "f", "LocalLifecycleOwner", "Lcom/tencent/ntcompose/lifecycle/viewmodel/k;", "LocalViewModelStoreOwner", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CompositionLocalsKt {

    /* renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal<a> f339456a = CompositionLocalKt.staticCompositionLocalOf(new Function0<a>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalConfiguration$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            CompositionLocalsKt.g("Configuration");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal<ComponentActivity> f339457b = CompositionLocalKt.staticCompositionLocalOf(new Function0<ComponentActivity>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalActivity$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ComponentActivity invoke() {
            CompositionLocalsKt.g("ComponentActivity");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final ProvidableCompositionLocal<b> f339458c = CompositionLocalKt.staticCompositionLocalOf(new Function0<b>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalContext$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            CompositionLocalsKt.g("Context");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final ProvidableCompositionLocal<d> f339459d = CompositionLocalKt.staticCompositionLocalOf(new Function0<d>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalModule$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d invoke() {
            CompositionLocalsKt.g("ModuleOwner");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final ProvidableCompositionLocal<com.tencent.ntcompose.foundation.event.d> f339460e = CompositionLocalKt.staticCompositionLocalOf(new Function0<com.tencent.ntcompose.foundation.event.d>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalOnBackPressedDispatcherOwner$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.tencent.ntcompose.foundation.event.d invoke() {
            CompositionLocalsKt.g("OnBackPressedDispatcherOwner");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final ProvidableCompositionLocal<com.tencent.ntcompose.lifecycle.common.c> f339461f = CompositionLocalKt.staticCompositionLocalOf(new Function0<com.tencent.ntcompose.lifecycle.common.c>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalLifecycleOwner$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.tencent.ntcompose.lifecycle.common.c invoke() {
            CompositionLocalsKt.g("LifecycleOwner");
            throw new KotlinNothingValueException();
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private static final ProvidableCompositionLocal<k> f339462g = CompositionLocalKt.staticCompositionLocalOf(new Function0<k>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$LocalViewModelStoreOwner$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final k invoke() {
            CompositionLocalsKt.g("LocalViewModelStoreOwner");
            throw new KotlinNothingValueException();
        }
    });

    public static final void a(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3) {
        final int i16;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(495476565);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(content) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(495476565, i16, -1, "com.tencent.ntcompose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:45)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new a();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final a aVar = (a) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new b();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            b bVar = (b) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                com.tencent.kuikly.core.pager.b hostPager = com.tencent.kuikly.core.manager.c.f117352a.g().hostPager();
                Intrinsics.checkNotNull(hostPager, "null cannot be cast to non-null type com.tencent.ntcompose.activity.ComponentActivity");
                rememberedValue3 = (ComponentActivity) hostPager;
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            ComponentActivity componentActivity = (ComponentActivity) rememberedValue3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{f339456a.provides(aVar), f339458c.provides(bVar), f339459d.provides(d.f339473a), f339457b.provides(componentActivity), f339460e.provides(componentActivity), f339461f.provides(componentActivity), f339462g.provides(componentActivity)}, ComposableLambdaKt.composableLambda(startRestartGroup, 1247417365, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$ProvideCommonCompositionLocals$1
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
                    if ((i17 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1247417365, i17, -1, "com.tencent.ntcompose.ui.platform.ProvideCommonCompositionLocals.<anonymous> (CompositionLocals.kt:63)");
                    }
                    final a aVar2 = aVar;
                    ActivityEventHandlerKt.a(new Function2<Double, Double, Unit>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$ProvideCommonCompositionLocals$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Double d16, Double d17) {
                            invoke(d16.doubleValue(), d17.doubleValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(double d16, double d17) {
                            a.this.m(d16, d17);
                        }
                    }, composer2, 0);
                    content.invoke(composer2, Integer.valueOf(i16 & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.ui.platform.CompositionLocalsKt$ProvideCommonCompositionLocals$2
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
                CompositionLocalsKt.a(content, composer2, i3 | 1);
            }
        });
    }

    public static final ProvidableCompositionLocal<ComponentActivity> c() {
        return f339457b;
    }

    public static final ProvidableCompositionLocal<a> d() {
        return f339456a;
    }

    public static final ProvidableCompositionLocal<com.tencent.ntcompose.lifecycle.common.c> e() {
        return f339461f;
    }

    public static final ProvidableCompositionLocal<k> f() {
        return f339462g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void g(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
