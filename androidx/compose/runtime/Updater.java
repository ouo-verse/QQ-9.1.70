package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0019\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0018JI\u0010\u001b\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0004\b!\u0010\"JK\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e\u00a2\u0006\u0002\b\u0016H\u0086\b\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010#J\u0010\u0010$\u001a\u00020%H\u00d6\u0001\u00a2\u0006\u0004\b&\u0010'JI\u0010(\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0004\b)\u0010\"JK\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e\u00a2\u0006\u0002\b\u0016H\u0086\b\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010#R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004\u00f8\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006*"}, d2 = {"Landroidx/compose/runtime/Updater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "init", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "set", "V", "value", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "update-impl", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes39.dex */
public final class Updater<T> {
    private final Composer composer;

    private /* synthetic */ Updater(Composer composer) {
        this.composer = composer;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m19boximpl(Composer composer) {
        return new Updater(composer);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m20constructorimpl(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        return composer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m21equalsimpl(Composer composer, Object obj) {
        return (obj instanceof Updater) && Intrinsics.areEqual(composer, ((Updater) obj).getComposer());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m22equalsimpl0(Composer composer, Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m23hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: init-impl, reason: not valid java name */
    public static final void m24initimpl(Composer composer, final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (composer.getInserting()) {
            composer.apply(Unit.INSTANCE, new Function2<T, Unit, Unit>() { // from class: androidx.compose.runtime.Updater$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Unit unit) {
                    invoke2((Updater$init$1<T>) obj, unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(T t16, Unit it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    block.invoke(t16);
                }
            });
        }
    }

    /* renamed from: reconcile-impl, reason: not valid java name */
    public static final void m25reconcileimpl(Composer composer, final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.apply(Unit.INSTANCE, new Function2<T, Unit, Unit>() { // from class: androidx.compose.runtime.Updater$reconcile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Unit unit) {
                invoke2((Updater$reconcile$1<T>) obj, unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t16, Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                block.invoke(t16);
            }
        });
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m26setimpl(Composer composer, int i3, Function2<? super T, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i3))) {
            composer.updateRememberedValue(Integer.valueOf(i3));
            composer.apply(Integer.valueOf(i3), block);
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m28toStringimpl(Composer composer) {
        return "Updater(composer=" + composer + ')';
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final void m29updateimpl(Composer composer, int i3, Function2<? super T, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean inserting = composer.getInserting();
        if (inserting || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i3))) {
            composer.updateRememberedValue(Integer.valueOf(i3));
            if (inserting) {
                return;
            }
            composer.apply(Integer.valueOf(i3), block);
        }
    }

    public boolean equals(Object obj) {
        return m21equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m23hashCodeimpl(this.composer);
    }

    public String toString() {
        return m28toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Composer getComposer() {
        return this.composer;
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final <V> void m27setimpl(Composer composer, V v3, Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), v3)) {
            composer.updateRememberedValue(v3);
            composer.apply(v3, block);
        }
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final <V> void m30updateimpl(Composer composer, V v3, Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean inserting = composer.getInserting();
        if (inserting || !Intrinsics.areEqual(composer.rememberedValue(), v3)) {
            composer.updateRememberedValue(v3);
            if (inserting) {
                return;
            }
            composer.apply(v3, block);
        }
    }

    public static /* synthetic */ void getComposer$annotations() {
    }
}
