package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public interface SyntheticJavaPartsProvider {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final CompositeSyntheticJavaPartsProvider EMPTY;

        static {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            EMPTY = new CompositeSyntheticJavaPartsProvider(emptyList);
        }

        Companion() {
        }

        @NotNull
        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }

    void generateConstructors(@NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list);

    void generateMethods(@NotNull ClassDescriptor classDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> collection);

    void generateStaticFunctions(@NotNull ClassDescriptor classDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> collection);

    @NotNull
    List<Name> getMethodNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    List<Name> getStaticFunctionNames(@NotNull ClassDescriptor classDescriptor);
}
