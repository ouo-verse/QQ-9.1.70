package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {

    @NotNull
    private final BuiltInsResourceLoader resourceLoader = new BuiltInsResourceLoader();

    public static /* synthetic */ PackageFragmentProvider createBuiltInPackageFragmentProvider$default(BuiltInsLoaderImpl builtInsLoaderImpl, StorageManager storageManager, ModuleDescriptor moduleDescriptor, Set set, Iterable iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z16, Function1 function1, int i3, Object obj) {
        AdditionalClassPartsProvider additionalClassPartsProvider2;
        if ((i3 & 32) != 0) {
            additionalClassPartsProvider2 = AdditionalClassPartsProvider.None.INSTANCE;
        } else {
            additionalClassPartsProvider2 = additionalClassPartsProvider;
        }
        return builtInsLoaderImpl.createBuiltInPackageFragmentProvider(storageManager, moduleDescriptor, set, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider2, z16, function1);
    }

    @NotNull
    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module, @NotNull Set<FqName> packageFqNames, @NotNull Iterable<? extends ClassDescriptorFactory> classDescriptorFactories, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z16, @NotNull Function1<? super String, ? extends InputStream> loadResource) {
        int collectionSizeOrDefault;
        List emptyList;
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(packageFqNames, "packageFqNames");
        Intrinsics.checkNotNullParameter(classDescriptorFactories, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(loadResource, "loadResource");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(packageFqNames, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (FqName fqName : packageFqNames) {
            String builtInsFilePath = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName);
            InputStream invoke = loadResource.invoke(builtInsFilePath);
            if (invoke != null) {
                arrayList.add(BuiltInsPackageFragmentImpl.Companion.create(fqName, storageManager, module, invoke, z16));
            } else {
                throw new IllegalStateException("Resource not found in classpath: " + builtInsFilePath);
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, module);
        DeserializationConfiguration.Default r36 = DeserializationConfiguration.Default.INSTANCE;
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(packageFragmentProviderImpl);
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.INSTANCE;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(module, notFoundClasses, builtInSerializerProtocol);
        LocalClassifierTypeSettings.Default r75 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter DO_NOTHING = ErrorReporter.DO_NOTHING;
        Intrinsics.checkNotNullExpressionValue(DO_NOTHING, "DO_NOTHING");
        LookupTracker.DO_NOTHING do_nothing = LookupTracker.DO_NOTHING.INSTANCE;
        FlexibleTypeDeserializer.ThrowException throwException = FlexibleTypeDeserializer.ThrowException.INSTANCE;
        ContractDeserializer contractDeserializer = ContractDeserializer.Companion.getDEFAULT();
        ExtensionRegistryLite extensionRegistry = builtInSerializerProtocol.getExtensionRegistry();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        DeserializationComponents deserializationComponents = new DeserializationComponents(storageManager, module, r36, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl, r75, DO_NOTHING, do_nothing, throwException, classDescriptorFactories, notFoundClasses, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter, extensionRegistry, null, new SamConversionResolverImpl(storageManager, emptyList), null, null, 851968, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BuiltInsPackageFragmentImpl) it.next()).initialize(deserializationComponents);
        }
        return packageFragmentProviderImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    @NotNull
    public PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor builtInsModule, @NotNull Iterable<? extends ClassDescriptorFactory> classDescriptorFactories, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z16) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtInsModule, "builtInsModule");
        Intrinsics.checkNotNullParameter(classDescriptorFactories, "classDescriptorFactories");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(storageManager, builtInsModule, StandardNames.BUILT_INS_PACKAGE_FQ_NAMES, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z16, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.resourceLoader));
    }
}
