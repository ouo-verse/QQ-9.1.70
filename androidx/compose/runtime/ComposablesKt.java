package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0002\b\u001eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u001f\u001aq\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\"\u001a\u0097\u0001\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0002\b\u001e2$\b\b\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b!\u00a2\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010%\u001ab\u0010&\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0002\b\u001eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u001f\u001aq\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\"\u001a\u0097\u0001\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0002\b\u001e2$\b\b\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\u0002\b!\u00a2\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010%\u001a.\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010)\u001a.\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0013\b\u0004\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010-\u001a\b\u0010.\u001a\u00020\u0013H\u0001\u001aB\u0010(\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0016\u0010/\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001500\"\u0004\u0018\u00010\u00152\u0011\u00101\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019\u00a2\u0006\u0002\b!H\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u00102\u001a*\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0011\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u00105\u001a4\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u00107\u001a>\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00108\u001a\u0004\u0018\u00010\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u00109\u001aH\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00108\u001a\u0004\u0018\u00010\u00152\b\u0010:\u001a\u0004\u0018\u00010\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010;\u001aB\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0016\u0010/\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001500\"\u0004\u0018\u00010\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019\u00a2\u0006\u0002\b\u001dH\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010<\u001a\r\u0010=\u001a\u00020>H\u0007\u00a2\u0006\u0002\u0010?\"\u0011\u0010\u0000\u001a\u00020\u00018G\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058G\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u00020\t8G\u00a2\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f8G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006@"}, d2 = {"currentComposer", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentCompositeKeyHash", "", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "currentCompositionLocalContext", "Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext$annotations", "()V", "getCurrentCompositionLocalContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionLocalContext;", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "ComposeNode", "", "T", "", "E", "Landroidx/compose/runtime/Applier;", "factory", "Lkotlin/Function0;", "update", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Landroidx/compose/runtime/DisallowComposableCalls;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "skippableUpdate", "Landroidx/compose/runtime/SkippableUpdater;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "ReusableContent", "key", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableContentHost", "active", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "remember", "calculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key1", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "rememberCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ComposablesKt {
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(final Function0<? extends T> factory, Function1<? super Updater<T>, Unit> update, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        composer.startReplaceableGroup(1886828752);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(new Function0<T>() { // from class: androidx.compose.runtime.ComposablesKt$ComposeNode$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    return factory.invoke();
                }
            });
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m19boximpl(Updater.m20constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(final Function0<? extends T> factory, Function1<? super Updater<T>, Unit> update, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        composer.startReplaceableGroup(1405779621);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new Function0<T>() { // from class: androidx.compose.runtime.ComposablesKt$ReusableComposeNode$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    return factory.invoke();
                }
            });
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        update.invoke(Updater.m19boximpl(Updater.m20constructorimpl(composer)));
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final void ReusableContent(Object obj, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(444418301);
        composer.startReusableGroup(207, obj);
        content.invoke(composer, Integer.valueOf((i3 >> 3) & 14));
        composer.endReusableGroup();
        composer.endReplaceableGroup();
    }

    public static final void ReusableContentHost(boolean z16, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReusableGroup(207, Boolean.valueOf(z16));
        boolean changed = composer.changed(z16);
        if (z16) {
            content.invoke(composer, Integer.valueOf((i3 >> 3) & 14));
        } else {
            composer.deactivateToEndGroup(changed);
        }
        composer.endReusableGroup();
    }

    public static final Composer getCurrentComposer(Composer composer, int i3) {
        throw new NotImplementedError("Implemented as an intrinsic");
    }

    public static final int getCurrentCompositeKeyHash(Composer composer, int i3) {
        return composer.getCompoundKeyHash();
    }

    public static final RecomposeScope getCurrentRecomposeScope(Composer composer, int i3) {
        RecomposeScope recomposeScope = composer.getRecomposeScope();
        if (recomposeScope != null) {
            composer.recordUsed(recomposeScope);
            return recomposeScope;
        }
        throw new IllegalStateException("no recompose scope found".toString());
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    public static final <T> T key(Object[] keys, Function2<? super Composer, ? super Integer, ? extends T> block, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(-11941951);
        T invoke = block.invoke(composer, Integer.valueOf((i3 >> 3) & 14));
        composer.endReplaceableGroup();
        return invoke;
    }

    public static final <T> T remember(Object obj, Function0<? extends T> calculation, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        T t16 = (T) composer.rememberedValue();
        if (changed || t16 == Composer.INSTANCE.getEmpty()) {
            t16 = calculation.invoke();
            composer.updateRememberedValue(t16);
        }
        composer.endReplaceableGroup();
        return t16;
    }

    public static final CompositionLocalContext getCurrentCompositionLocalContext(Composer composer, int i3) {
        composer.startReplaceableGroup(-43352356);
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext(composer.buildContext().getCompositionLocalScope$runtime_release());
        composer.endReplaceableGroup();
        return compositionLocalContext;
    }

    public static final CompositionContext rememberCompositionContext(Composer composer, int i3) {
        composer.startReplaceableGroup(-1165786124);
        CompositionContext buildContext = composer.buildContext();
        composer.endReplaceableGroup();
        return buildContext;
    }

    public static final <T> T remember(Object obj, Object obj2, Function0<? extends T> calculation, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        T t16 = (T) composer.rememberedValue();
        if (changed || t16 == Composer.INSTANCE.getEmpty()) {
            t16 = calculation.invoke();
            composer.updateRememberedValue(t16);
        }
        composer.endReplaceableGroup();
        return t16;
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> factory, Function1<? super Updater<T>, Unit> update, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-548224868);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m19boximpl(Updater.m20constructorimpl(composer)));
        content.invoke(composer, Integer.valueOf((i3 >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> factory, Function1<? super Updater<T>, Unit> update, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-692256719);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        update.invoke(Updater.m19boximpl(Updater.m20constructorimpl(composer)));
        composer.enableReusing();
        content.invoke(composer, Integer.valueOf((i3 >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final <T> T remember(Object obj, Object obj2, Object obj3, Function0<? extends T> calculation, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        T t16 = (T) composer.rememberedValue();
        if (changed || t16 == Composer.INSTANCE.getEmpty()) {
            t16 = calculation.invoke();
            composer.updateRememberedValue(t16);
        }
        composer.endReplaceableGroup();
        return t16;
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> factory, Function1<? super Updater<T>, Unit> update, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> skippableUpdate, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(skippableUpdate, "skippableUpdate");
        Intrinsics.checkNotNullParameter(content, "content");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m19boximpl(Updater.m20constructorimpl(composer)));
        skippableUpdate.invoke(SkippableUpdater.m9boximpl(SkippableUpdater.m10constructorimpl(composer)), composer, Integer.valueOf((i3 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.invoke(composer, Integer.valueOf((i3 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> factory, Function1<? super Updater<T>, Unit> update, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> skippableUpdate, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(skippableUpdate, "skippableUpdate");
        Intrinsics.checkNotNullParameter(content, "content");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        update.invoke(Updater.m19boximpl(Updater.m20constructorimpl(composer)));
        composer.enableReusing();
        skippableUpdate.invoke(SkippableUpdater.m9boximpl(SkippableUpdater.m10constructorimpl(composer)), composer, Integer.valueOf((i3 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.invoke(composer, Integer.valueOf((i3 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    public static final <T> T remember(Object[] keys, Function0<? extends T> calculation, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        composer.startReplaceableGroup(-568225417);
        boolean z16 = false;
        for (Object obj : keys) {
            z16 |= composer.changed(obj);
        }
        T t16 = (T) composer.rememberedValue();
        if (z16 || t16 == Composer.INSTANCE.getEmpty()) {
            t16 = calculation.invoke();
            composer.updateRememberedValue(t16);
        }
        composer.endReplaceableGroup();
        return t16;
    }

    public static final <T> T remember(Function0<? extends T> calculation, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        composer.startReplaceableGroup(-492369756);
        T t16 = (T) composer.rememberedValue();
        if (t16 == Composer.INSTANCE.getEmpty()) {
            t16 = calculation.invoke();
            composer.updateRememberedValue(t16);
        }
        composer.endReplaceableGroup();
        return t16;
    }
}
