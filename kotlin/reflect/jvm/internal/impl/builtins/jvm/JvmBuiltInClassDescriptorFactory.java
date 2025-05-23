package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {

    @NotNull
    private static final ClassId CLONEABLE_CLASS_ID;

    @NotNull
    private static final Name CLONEABLE_NAME;

    @NotNull
    private final NotNullLazyValue cloneable$delegate;

    @NotNull
    private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;

    @NotNull
    private final ModuleDescriptor moduleDescriptor;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final FqName KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.CLONEABLE_CLASS_ID;
        }

        Companion() {
        }
    }

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames.cloneable;
        Name shortName = fqNameUnsafe.shortName();
        Intrinsics.checkNotNullExpressionValue(shortName, "cloneable.shortName()");
        CLONEABLE_NAME = shortName;
        ClassId classId = ClassId.topLevel(fqNameUnsafe.toSafe());
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        CLONEABLE_CLASS_ID = classId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(@NotNull final StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> computeContainingDeclaration) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(computeContainingDeclaration, "computeContainingDeclaration");
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = computeContainingDeclaration;
        this.cloneable$delegate = storageManager.createLazyValue(new Function0<ClassDescriptorImpl>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$cloneable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ClassDescriptorImpl invoke() {
                Function1 function1;
                ModuleDescriptor moduleDescriptor2;
                Name name;
                ModuleDescriptor moduleDescriptor3;
                List listOf;
                Set<ClassConstructorDescriptor> emptySet;
                function1 = JvmBuiltInClassDescriptorFactory.this.computeContainingDeclaration;
                moduleDescriptor2 = JvmBuiltInClassDescriptorFactory.this.moduleDescriptor;
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function1.invoke(moduleDescriptor2);
                name = JvmBuiltInClassDescriptorFactory.CLONEABLE_NAME;
                Modality modality = Modality.ABSTRACT;
                ClassKind classKind = ClassKind.INTERFACE;
                moduleDescriptor3 = JvmBuiltInClassDescriptorFactory.this.moduleDescriptor;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(moduleDescriptor3.getBuiltIns().getAnyType());
                ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(declarationDescriptor, name, modality, classKind, listOf, SourceElement.NO_SOURCE, false, storageManager);
                CloneableClassScope cloneableClassScope = new CloneableClassScope(storageManager, classDescriptorImpl);
                emptySet = SetsKt__SetsKt.emptySet();
                classDescriptorImpl.initialize(cloneableClassScope, emptySet, null);
                return classDescriptorImpl;
            }
        });
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (Intrinsics.areEqual(classId, CLONEABLE_CLASS_ID)) {
            return getCloneable();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName packageFqName) {
        Set emptySet;
        Set of5;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        if (Intrinsics.areEqual(packageFqName, KOTLIN_FQ_NAME)) {
            of5 = SetsKt__SetsJVMKt.setOf(getCloneable());
            return of5;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull FqName packageFqName, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual(name, CLONEABLE_NAME) && Intrinsics.areEqual(packageFqName, KOTLIN_FQ_NAME)) {
            return true;
        }
        return false;
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, (i3 & 4) != 0 ? new Function1<ModuleDescriptor, BuiltInsPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final BuiltInsPackageFragment invoke(@NotNull ModuleDescriptor module) {
                Object first;
                Intrinsics.checkNotNullParameter(module, "module");
                List<PackageFragmentDescriptor> fragments = module.getPackage(JvmBuiltInClassDescriptorFactory.KOTLIN_FQ_NAME).getFragments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fragments) {
                    if (obj instanceof BuiltInsPackageFragment) {
                        arrayList.add(obj);
                    }
                }
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                return (BuiltInsPackageFragment) first;
            }
        } : function1);
    }
}
