package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final LazyJavaResolverContext f412749c;

    @NotNull
    private final LazyJavaPackageScope javaScope;

    @NotNull
    private final NotNullLazyValue kotlinScopes$delegate;

    @NotNull
    private final LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(@NotNull LazyJavaResolverContext c16, @NotNull JavaPackage jPackage, @NotNull LazyJavaPackageFragment packageFragment) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        Intrinsics.checkNotNullParameter(packageFragment, "packageFragment");
        this.f412749c = c16;
        this.packageFragment = packageFragment;
        this.javaScope = new LazyJavaPackageScope(c16, jPackage, packageFragment);
        this.kotlinScopes$delegate = c16.getStorageManager().createLazyValue(new Function0<MemberScope[]>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope$kotlinScopes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope[] invoke() {
                LazyJavaPackageFragment lazyJavaPackageFragment;
                LazyJavaResolverContext lazyJavaResolverContext;
                LazyJavaPackageFragment lazyJavaPackageFragment2;
                lazyJavaPackageFragment = JvmPackageScope.this.packageFragment;
                Collection<KotlinJvmBinaryClass> values = lazyJavaPackageFragment.getBinaryClasses$descriptors_jvm().values();
                JvmPackageScope jvmPackageScope = JvmPackageScope.this;
                ArrayList arrayList = new ArrayList();
                for (KotlinJvmBinaryClass kotlinJvmBinaryClass : values) {
                    lazyJavaResolverContext = jvmPackageScope.f412749c;
                    DeserializedDescriptorResolver deserializedDescriptorResolver = lazyJavaResolverContext.getComponents().getDeserializedDescriptorResolver();
                    lazyJavaPackageFragment2 = jvmPackageScope.packageFragment;
                    MemberScope createKotlinPackagePartScope = deserializedDescriptorResolver.createKotlinPackagePartScope(lazyJavaPackageFragment2, kotlinJvmBinaryClass);
                    if (createKotlinPackagePartScope != null) {
                        arrayList.add(createKotlinPackagePartScope);
                    }
                }
                Object[] array = ScopeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (MemberScope[]) array;
            }
        });
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<Name> getClassifierNames() {
        Iterable asIterable;
        asIterable = ArraysKt___ArraysKt.asIterable(getKotlinScopes());
        Set<Name> flatMapClassifierNamesOrNull = MemberScopeKt.flatMapClassifierNamesOrNull(asIterable);
        if (flatMapClassifierNamesOrNull != null) {
            flatMapClassifierNamesOrNull.addAll(this.javaScope.getClassifierNames());
            return flatMapClassifierNamesOrNull;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1781getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        mo1785recordLookup(name, location);
        ClassDescriptor mo1781getContributedClassifier = this.javaScope.mo1781getContributedClassifier(name, location);
        if (mo1781getContributedClassifier != null) {
            return mo1781getContributedClassifier;
        }
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope memberScope : getKotlinScopes()) {
            ClassifierDescriptor mo1781getContributedClassifier2 = memberScope.mo1781getContributedClassifier(name, location);
            if (mo1781getContributedClassifier2 != null) {
                if ((mo1781getContributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) && ((ClassifierDescriptorWithTypeParameters) mo1781getContributedClassifier2).isExpect()) {
                    if (classifierDescriptor == null) {
                        classifierDescriptor = mo1781getContributedClassifier2;
                    }
                } else {
                    return mo1781getContributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(kindFilter, nameFilter);
        for (MemberScope memberScope : kotlinScopes) {
            contributedDescriptors = ScopeUtilsKt.concat(contributedDescriptors, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        if (contributedDescriptors == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        return contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        mo1785recordLookup(name, location);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, location);
        int length = kotlinScopes.length;
        int i3 = 0;
        Collection collection = contributedFunctions;
        while (i3 < length) {
            Collection concat = ScopeUtilsKt.concat(collection, kotlinScopes[i3].getContributedFunctions(name, location));
            i3++;
            collection = concat;
        }
        if (collection == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        mo1785recordLookup(name, location);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(name, location);
        int length = kotlinScopes.length;
        int i3 = 0;
        Collection collection = contributedVariables;
        while (i3 < length) {
            Collection concat = ScopeUtilsKt.concat(collection, kotlinScopes[i3].getContributedVariables(name, location));
            i3++;
            collection = concat;
        }
        if (collection == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : kotlinScopes) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        linkedHashSet.addAll(this.javaScope.getFunctionNames());
        return linkedHashSet;
    }

    @NotNull
    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : kotlinScopes) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        linkedHashSet.addAll(this.javaScope.getVariableNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public void mo1785recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        UtilsKt.record(this.f412749c.getComponents().getLookupTracker(), location, this.packageFragment, name);
    }

    @NotNull
    public String toString() {
        return "scope for " + this.packageFragment;
    }
}
