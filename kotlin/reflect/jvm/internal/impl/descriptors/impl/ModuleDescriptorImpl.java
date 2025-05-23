package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {

    @NotNull
    private final KotlinBuiltIns builtIns;

    @NotNull
    private final Map<ModuleCapability<?>, Object> capabilities;

    @Nullable
    private ModuleDependencies dependencies;
    private boolean isValid;

    @Nullable
    private PackageFragmentProvider packageFragmentProviderForModuleContent;

    @NotNull
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;

    @NotNull
    private final PackageViewDescriptorFactory packageViewDescriptorFactory;

    @NotNull
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;

    @Nullable
    private final TargetPlatform platform;

    @Nullable
    private final Name stableName;

    @NotNull
    private final StorageManager storageManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable TargetPlatform targetPlatform) {
        this(moduleName, storageManager, builtIns, targetPlatform, null, null, 48, null);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getId() {
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return name;
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInitialized() {
        if (this.packageFragmentProviderForModuleContent != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d16) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d16);
    }

    public void assertValid() {
        if (!isValid()) {
            InvalidModuleExceptionKt.moduleInvalidated(this);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @Nullable
    public <T> T getCapability(@NotNull ModuleCapability<T> capability) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        T t16 = (T) this.capabilities.get(capability);
        if (t16 == null) {
            return null;
        }
        return t16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.packages.invoke(fqName);
    }

    @NotNull
    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, nameFilter);
    }

    public final void initialize(@NotNull PackageFragmentProvider providerForModuleContent) {
        Intrinsics.checkNotNullParameter(providerForModuleContent, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = providerForModuleContent;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public final void setDependencies(@NotNull ModuleDependencies dependencies) {
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        this.dependencies = dependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor targetModule) {
        boolean contains;
        Intrinsics.checkNotNullParameter(targetModule, "targetModule");
        if (Intrinsics.areEqual(this, targetModule)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        Intrinsics.checkNotNull(moduleDependencies);
        contains = CollectionsKt___CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), targetModule);
        if (contains || getExpectedByModules().contains(targetModule) || targetModule.getExpectedByModules().contains(this)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, storageManager, kotlinBuiltIns, r6, r7, (i3 & 32) != 0 ? null : name2);
        Map map2;
        Map emptyMap;
        TargetPlatform targetPlatform2 = (i3 & 8) != 0 ? null : targetPlatform;
        if ((i3 & 16) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
    }

    public final void setDependencies(@NotNull ModuleDescriptorImpl... descriptors) {
        List<ModuleDescriptorImpl> list;
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        list = ArraysKt___ArraysKt.toList(descriptors);
        setDependencies(list);
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> descriptors) {
        Set<ModuleDescriptorImpl> emptySet;
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        emptySet = SetsKt__SetsKt.emptySet();
        setDependencies(descriptors, emptySet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable TargetPlatform targetPlatform, @NotNull Map<ModuleCapability<?>, ? extends Object> capabilities, @Nullable Name name) {
        super(Annotations.Companion.getEMPTY(), moduleName);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        this.storageManager = storageManager;
        this.builtIns = builtIns;
        this.platform = targetPlatform;
        this.stableName = name;
        if (moduleName.isSpecial()) {
            this.capabilities = capabilities;
            PackageViewDescriptorFactory packageViewDescriptorFactory = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
            this.packageViewDescriptorFactory = packageViewDescriptorFactory == null ? PackageViewDescriptorFactory.Default.INSTANCE : packageViewDescriptorFactory;
            this.isValid = true;
            this.packages = storageManager.createMemoizedFunction(new Function1<FqName, PackageViewDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final PackageViewDescriptor invoke(@NotNull FqName fqName) {
                    PackageViewDescriptorFactory packageViewDescriptorFactory2;
                    StorageManager storageManager2;
                    Intrinsics.checkNotNullParameter(fqName, "fqName");
                    packageViewDescriptorFactory2 = ModuleDescriptorImpl.this.packageViewDescriptorFactory;
                    ModuleDescriptorImpl moduleDescriptorImpl = ModuleDescriptorImpl.this;
                    storageManager2 = moduleDescriptorImpl.storageManager;
                    return packageViewDescriptorFactory2.compute(moduleDescriptorImpl, fqName, storageManager2);
                }
            });
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<CompositePackageFragmentProvider>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final CompositePackageFragmentProvider invoke() {
                    ModuleDependencies moduleDependencies;
                    String id5;
                    int collectionSizeOrDefault;
                    PackageFragmentProvider packageFragmentProvider;
                    moduleDependencies = ModuleDescriptorImpl.this.dependencies;
                    ModuleDescriptorImpl moduleDescriptorImpl = ModuleDescriptorImpl.this;
                    if (moduleDependencies != null) {
                        List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
                        ModuleDescriptorImpl.this.assertValid();
                        allDependencies.contains(ModuleDescriptorImpl.this);
                        List<ModuleDescriptorImpl> list = allDependencies;
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            ((ModuleDescriptorImpl) it.next()).isInitialized();
                        }
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it5 = list.iterator();
                        while (it5.hasNext()) {
                            packageFragmentProvider = ((ModuleDescriptorImpl) it5.next()).packageFragmentProviderForModuleContent;
                            Intrinsics.checkNotNull(packageFragmentProvider);
                            arrayList.add(packageFragmentProvider);
                        }
                        return new CompositePackageFragmentProvider(arrayList, "CompositeProvider@ModuleDescriptor for " + ModuleDescriptorImpl.this.getName());
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Dependencies of module ");
                    id5 = moduleDescriptorImpl.getId();
                    sb5.append(id5);
                    sb5.append(" were not set before querying module content");
                    throw new AssertionError(sb5.toString());
                }
            });
            this.packageFragmentProviderForWholeModuleWithDependencies$delegate = lazy;
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + moduleName);
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> descriptors, @NotNull Set<ModuleDescriptorImpl> friends) {
        List emptyList;
        Set emptySet;
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        Intrinsics.checkNotNullParameter(friends, "friends");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptySet = SetsKt__SetsKt.emptySet();
        setDependencies(new ModuleDependenciesImpl(descriptors, friends, emptyList, emptySet));
    }
}
