package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {

    @NotNull
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;

    @NotNull
    private final JavaPackage jPackage;

    @NotNull
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;

    @NotNull
    private final LazyJavaPackageFragment ownerDescriptor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static final class FindClassRequest {

        @Nullable
        private final JavaClass javaClass;

        @NotNull
        private final Name name;

        public FindClassRequest(@NotNull Name name, @Nullable JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.javaClass = javaClass;
        }

        public boolean equals(@Nullable Object obj) {
            if ((obj instanceof FindClassRequest) && Intrinsics.areEqual(this.name, ((FindClassRequest) obj).name)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        @NotNull
        public final Name getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static abstract class KotlinClassLookupResult {

        /* loaded from: classes28.dex */
        public static final class Found extends KotlinClassLookupResult {

            @NotNull
            private final ClassDescriptor descriptor;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Found(@NotNull ClassDescriptor descriptor) {
                super(null);
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                this.descriptor = descriptor;
            }

            @NotNull
            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        /* loaded from: classes28.dex */
        public static final class NotFound extends KotlinClassLookupResult {

            @NotNull
            public static final NotFound INSTANCE = new NotFound();

            NotFound() {
                super(null);
            }
        }

        /* loaded from: classes28.dex */
        public static final class SyntheticClass extends KotlinClassLookupResult {

            @NotNull
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            SyntheticClass() {
                super(null);
            }
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        KotlinClassLookupResult() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(@NotNull final LazyJavaResolverContext c16, @NotNull JavaPackage jPackage, @NotNull LazyJavaPackageFragment ownerDescriptor) {
        super(c16);
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        this.jPackage = jPackage;
        this.ownerDescriptor = ownerDescriptor;
        this.knownClassNamesInPackage = c16.getStorageManager().createNullableLazyValue(new Function0<Set<? extends String>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$knownClassNamesInPackage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Set<? extends String> invoke() {
                return LazyJavaResolverContext.this.getComponents().getFinder().knownClassNamesInPackage(this.getOwnerDescriptor().getFqName());
            }
        });
        this.classes = c16.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<FindClassRequest, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ClassDescriptor invoke(@NotNull LazyJavaPackageScope.FindClassRequest request) {
                KotlinClassFinder.Result findKotlinClassOrContent;
                LazyJavaPackageScope.KotlinClassLookupResult resolveKotlinBinaryClass;
                byte[] bArr;
                Intrinsics.checkNotNullParameter(request, "request");
                ClassId classId = new ClassId(LazyJavaPackageScope.this.getOwnerDescriptor().getFqName(), request.getName());
                if (request.getJavaClass() != null) {
                    findKotlinClassOrContent = c16.getComponents().getKotlinClassFinder().findKotlinClassOrContent(request.getJavaClass());
                } else {
                    findKotlinClassOrContent = c16.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
                }
                KotlinJvmBinaryClass kotlinJvmBinaryClass = findKotlinClassOrContent != null ? findKotlinClassOrContent.toKotlinJvmBinaryClass() : null;
                ClassId classId2 = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
                if (classId2 != null && (classId2.isNestedClass() || classId2.isLocal())) {
                    return null;
                }
                resolveKotlinBinaryClass = LazyJavaPackageScope.this.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
                if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
                    return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) resolveKotlinBinaryClass).getDescriptor();
                }
                if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
                    return null;
                }
                if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
                    JavaClass javaClass = request.getJavaClass();
                    if (javaClass == null) {
                        JavaClassFinder finder = c16.getComponents().getFinder();
                        if (findKotlinClassOrContent != null) {
                            if (!(findKotlinClassOrContent instanceof KotlinClassFinder.Result.ClassFileContent)) {
                                findKotlinClassOrContent = null;
                            }
                            KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) findKotlinClassOrContent;
                            if (classFileContent != null) {
                                bArr = classFileContent.getContent();
                                javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                            }
                        }
                        bArr = null;
                        javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                    }
                    JavaClass javaClass2 = javaClass;
                    if ((javaClass2 != null ? javaClass2.getLightClassOriginKind() : null) != LightClassOriginKind.BINARY) {
                        FqName fqName = javaClass2 != null ? javaClass2.getFqName() : null;
                        if (fqName == null || fqName.isRoot() || !Intrinsics.areEqual(fqName.parent(), LazyJavaPackageScope.this.getOwnerDescriptor().getFqName())) {
                            return null;
                        }
                        LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(c16, LazyJavaPackageScope.this.getOwnerDescriptor(), javaClass2, null, 8, null);
                        c16.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                        return lazyJavaClassDescriptor;
                    }
                    throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass2 + "\nClassId: " + classId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(c16.getComponents().getKotlinClassFinder(), javaClass2) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(c16.getComponents().getKotlinClassFinder(), classId) + '\n');
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final ClassDescriptor findClassifier(Name name, JavaClass javaClass) {
        if (!SpecialNames.INSTANCE.isSafeIdentifier(name)) {
            return null;
        }
        Set<String> invoke = this.knownClassNamesInPackage.invoke();
        if (javaClass == null && invoke != null && !invoke.contains(name.asString())) {
            return null;
        }
        return this.classes.invoke(new FindClassRequest(name, javaClass));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() == KotlinClassHeader.Kind.CLASS) {
            ClassDescriptor resolveClass = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
            if (resolveClass != null) {
                return new KotlinClassLookupResult.Found(resolveClass);
            }
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Name name;
        Set<Name> emptySet;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        Set<String> invoke = this.knownClassNamesInPackage.invoke();
        if (invoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = invoke.iterator();
            while (it.hasNext()) {
                hashSet.add(Name.identifier((String) it.next()));
            }
            return hashSet;
        }
        JavaPackage javaPackage = this.jPackage;
        if (function1 == null) {
            function1 = FunctionsKt.alwaysTrue();
        }
        Collection<JavaClass> classes = javaPackage.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaClass javaClass : classes) {
            if (javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
                name = null;
            } else {
                name = javaClass.getName();
            }
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Set<Name> emptySet;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Set<Name> emptySet;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return findClassifier(javaClass.getName(), javaClass);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        boolean z16;
        List emptyList;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        DescriptorKindFilter.Companion companion = DescriptorKindFilter.Companion;
        if (!kindFilter.acceptsKinds(companion.getNON_SINGLETON_CLASSIFIERS_MASK() | companion.getCLASSIFIERS_MASK())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Collection<DeclarationDescriptor> invoke = getAllDescriptors().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : invoke) {
            DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof ClassDescriptor) {
                Name name = ((ClassDescriptor) declarationDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                if (nameFilter.invoke(name).booleanValue()) {
                    z16 = true;
                    if (!z16) {
                        arrayList.add(obj);
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        List emptyList;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    /* renamed from: getContributedClassifier */
    public ClassDescriptor mo1781getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return findClassifier(name, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
