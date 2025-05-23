package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LazyWrappedType extends WrappedType {

    @NotNull
    private final Function0<KotlinType> computation;

    @NotNull
    private final NotNullLazyValue<KotlinType> lazyValue;

    @NotNull
    private final StorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends KotlinType> computation) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(computation, "computation");
        this.storageManager = storageManager;
        this.computation = computation;
        this.lazyValue = storageManager.createLazyValue(computation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    @NotNull
    protected KotlinType getDelegate() {
        return this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public LazyWrappedType refine(@NotNull final KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.types.LazyWrappedType$refine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final KotlinType invoke() {
                Function0 function0;
                KotlinTypeRefiner kotlinTypeRefiner2 = KotlinTypeRefiner.this;
                function0 = this.computation;
                return kotlinTypeRefiner2.refineType((KotlinTypeMarker) function0.invoke());
            }
        });
    }
}
