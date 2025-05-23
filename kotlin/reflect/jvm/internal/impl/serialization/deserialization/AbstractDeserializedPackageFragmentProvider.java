package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    protected DeserializationComponents components;

    @NotNull
    private final KotlinMetadataFinder finder;

    @NotNull
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;

    @NotNull
    private final ModuleDescriptor moduleDescriptor;

    @NotNull
    private final StorageManager storageManager;

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull KotlinMetadataFinder finder, @NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        this.storageManager = storageManager;
        this.finder = finder;
        this.moduleDescriptor = moduleDescriptor;
        this.fragments = storageManager.createMemoizedFunctionWithNullableValues(new Function1<FqName, PackageFragmentDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider$fragments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final PackageFragmentDescriptor invoke(@NotNull FqName fqName) {
                Intrinsics.checkNotNullParameter(fqName, "fqName");
                DeserializedPackageFragment findPackage = AbstractDeserializedPackageFragmentProvider.this.findPackage(fqName);
                if (findPackage == null) {
                    return null;
                }
                findPackage.initialize(AbstractDeserializedPackageFragmentProvider.this.getComponents());
                return findPackage;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> packageFragments) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        CollectionsKt.addIfNotNull(packageFragments, this.fragments.invoke(fqName));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract DeserializedPackageFragment findPackage(@NotNull FqName fqName);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        List<PackageFragmentDescriptor> listOfNotNull;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(this.fragments.invoke(fqName));
        return listOfNotNull;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(@NotNull FqName fqName) {
        DeclarationDescriptorWithSource findPackage;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fragments.isComputed(fqName)) {
            findPackage = (PackageFragmentDescriptor) this.fragments.invoke(fqName);
        } else {
            findPackage = findPackage(fqName);
        }
        if (findPackage == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }
}
