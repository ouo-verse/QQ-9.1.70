package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface BuiltInsLoader {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final Lazy<BuiltInsLoader> Instance$delegate;

        static {
            Lazy<BuiltInsLoader> lazy;
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<BuiltInsLoader>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader$Companion$Instance$2
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final BuiltInsLoader invoke() {
                    Object firstOrNull;
                    ServiceLoader implementations = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
                    Intrinsics.checkNotNullExpressionValue(implementations, "implementations");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(implementations);
                    BuiltInsLoader builtInsLoader = (BuiltInsLoader) firstOrNull;
                    if (builtInsLoader != null) {
                        return builtInsLoader;
                    }
                    throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
                }
            });
            Instance$delegate = lazy;
        }

        Companion() {
        }

        @NotNull
        public final BuiltInsLoader getInstance() {
            return Instance$delegate.getValue();
        }
    }

    @NotNull
    PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z16);
}
