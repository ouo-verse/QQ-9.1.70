package androidx.compose.runtime;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0002\u0010\u000b\u001a0\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0002\u0010\u000e\u001a:\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0002\u0010\u0010\u001aD\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0002\u0010\u0012\u001a>\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0002\u0010\u0015\u001aW\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018\u00a2\u0006\u0002\b\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001b\u001aM\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018\u00a2\u0006\u0002\b\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001aC\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018\u00a2\u0006\u0002\b\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001aQ\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018\u00a2\u0006\u0002\b\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001a9\u0010\u0016\u001a\u00020\u00062'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018\u00a2\u0006\u0002\b\nH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0007\u00a2\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001\u001a&\u0010(\u001a\u00020\u00192\u0013\b\u0002\u0010)\u001a\r\u0012\u0004\u0012\u00020%0!\u00a2\u0006\u0002\b*H\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010+\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006,"}, d2 = {"DisposableEffectNoParamError", "", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "LaunchedEffectNoParamError", "DisposableEffect", "", QQWinkConstants.TAB_EFFECT, "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SideEffect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "composer", "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class EffectsKt {
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    private static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    @Deprecated(level = DeprecationLevel.ERROR, message = DisposableEffectNoParamError)
    public static final void DisposableEffect(Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-904483903);
        throw new IllegalStateException(DisposableEffectNoParamError.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LaunchedEffectNoParamError)
    public static final void LaunchedEffect(final Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer startRestartGroup = composer.startRestartGroup(-805415771);
        if ((i3 & 1) != 0 || !startRestartGroup.getSkipping()) {
            throw new IllegalStateException(LaunchedEffectNoParamError.toString());
        }
        startRestartGroup.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.EffectsKt$LaunchedEffect$1
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

            public final void invoke(Composer composer2, int i16) {
                EffectsKt.LaunchedEffect(block, composer2, i3 | 1);
            }
        });
    }

    public static final void SideEffect(Function0<Unit> effect, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-1288466761);
        composer.recordSideEffect(effect);
        composer.endReplaceableGroup();
    }

    public static final CoroutineScope createCompositionCoroutineScope(CoroutineContext coroutineContext, Composer composer) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Job.Companion companion = Job.INSTANCE;
        if (coroutineContext.get(companion) != null) {
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            Job$default.completeExceptionally(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
            return CoroutineScopeKt.CoroutineScope(Job$default);
        }
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        return CoroutineScopeKt.CoroutineScope(applyCoroutineContext.plus(JobKt.Job((Job) applyCoroutineContext.get(companion))).plus(coroutineContext));
    }

    public static final void DisposableEffect(Object obj, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-1371986847);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void LaunchedEffect(Object obj, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(1179185413);
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final CoroutineScope rememberCoroutineScope(Function0<? extends CoroutineContext> function0, Composer composer, int i3, int i16) {
        composer.startReplaceableGroup(773894976);
        if ((i16 & 1) != 0) {
            function0 = new Function0<EmptyCoroutineContext>() { // from class: androidx.compose.runtime.EffectsKt$rememberCoroutineScope$1
                @Override // kotlin.jvm.functions.Function0
                public final EmptyCoroutineContext invoke() {
                    return EmptyCoroutineContext.INSTANCE;
                }
            };
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new CompositionScopedCoroutineScopeCanceller(createCompositionCoroutineScope(function0.invoke(), composer));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        return coroutineScope;
    }

    public static final void DisposableEffect(Object obj, Object obj2, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(1429097729);
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void LaunchedEffect(Object obj, Object obj2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(590241125);
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void DisposableEffect(Object obj, Object obj2, Object obj3, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-1239538271);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void LaunchedEffect(Object obj, Object obj2, Object obj3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(-54093371);
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void DisposableEffect(Object[] keys, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(effect, "effect");
        composer.startReplaceableGroup(-1307627122);
        Object[] copyOf = Arrays.copyOf(keys, keys.length);
        composer.startReplaceableGroup(-568225417);
        boolean z16 = false;
        for (Object obj : copyOf) {
            z16 |= composer.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z16 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void LaunchedEffect(Object[] keys, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(-139560008);
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        Object[] copyOf = Arrays.copyOf(keys, keys.length);
        composer.startReplaceableGroup(-568225417);
        boolean z16 = false;
        for (Object obj : copyOf) {
            z16 |= composer.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z16 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
