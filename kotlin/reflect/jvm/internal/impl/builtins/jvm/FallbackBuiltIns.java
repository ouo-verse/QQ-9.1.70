package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
final class FallbackBuiltIns extends KotlinBuiltIns {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final KotlinBuiltIns Instance = new FallbackBuiltIns();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KotlinBuiltIns getInstance() {
            return FallbackBuiltIns.Instance;
        }

        Companion() {
        }
    }

    FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        createBuiltInsModule(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    @NotNull
    public PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }
}
