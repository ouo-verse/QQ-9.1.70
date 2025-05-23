package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {

    @NotNull
    private final ModuleDescriptor module;

    @NotNull
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        boolean contains$default;
        Object firstOrNull;
        Object first;
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.relativeClassName.asString()");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) asString, (CharSequence) "Function", false, 2, (Object) null);
        if (!contains$default) {
            return null;
        }
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        FunctionClassKind.Companion.KindWithArity parseClassName = FunctionClassKind.Companion.parseClassName(asString, packageFqName);
        if (parseClassName == null) {
            return null;
        }
        FunctionClassKind component1 = parseClassName.component1();
        int component2 = parseClassName.component2();
        List<PackageFragmentDescriptor> fragments = this.module.getPackage(packageFqName).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof BuiltInsPackageFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof FunctionInterfacePackageFragment) {
                arrayList2.add(obj2);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) firstOrNull;
        if (packageFragmentDescriptor == null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            packageFragmentDescriptor = (BuiltInsPackageFragment) first;
        }
        return new FunctionClassDescriptor(this.storageManager, packageFragmentDescriptor, component1, component2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName packageFqName) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull FqName packageFqName, @NotNull Name name) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(asString, "Function", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(asString, "KFunction", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(asString, "SuspendFunction", false, 2, null);
                if (!startsWith$default3) {
                    startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(asString, "KSuspendFunction", false, 2, null);
                    if (!startsWith$default4) {
                        return false;
                    }
                }
            }
        }
        if (FunctionClassKind.Companion.parseClassName(asString, packageFqName) == null) {
            return false;
        }
        return true;
    }
}
