package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RuntimeModuleData {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final DeserializationComponents deserialization;

    @NotNull
    private final PackagePartScopeCache packagePartScopeCache;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RuntimeModuleData create(@NotNull ClassLoader classLoader) {
            Intrinsics.checkNotNullParameter(classLoader, "classLoader");
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializationComponentsForJava.Companion companion = DeserializationComponentsForJava.Companion;
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader2, "Unit::class.java.classLoader");
            DeserializationComponentsForJava.Companion.ModuleData createModuleData = companion.createModuleData(reflectKotlinClassFinder, new ReflectKotlinClassFinder(classLoader2), new ReflectJavaClassFinder(classLoader), "runtime module for " + classLoader, RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(createModuleData.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(createModuleData.getDeserializedDescriptorResolver(), reflectKotlinClassFinder), null);
        }

        Companion() {
        }
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationComponents, packagePartScopeCache);
    }

    @NotNull
    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    @NotNull
    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache;
    }
}
