package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FindClassInModuleKt {
    @Nullable
    public static final ClassDescriptor findClassAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0151  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Object first;
        Object first2;
        ClassifierDescriptor mo1781getContributedClassifier;
        Object first3;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(packageFqName);
            List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope = packageViewDescriptor.getMemberScope();
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) pathSegments);
            Intrinsics.checkNotNullExpressionValue(first3, "segments.first()");
            mo1781getContributedClassifier = memberScope.mo1781getContributedClassifier((Name) first3, NoLookupLocation.FROM_DESERIALIZATION);
            if (mo1781getContributedClassifier == null) {
                return null;
            }
            for (Name name : pathSegments.subList(1, pathSegments.size())) {
                if (!(mo1781getContributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) mo1781getContributedClassifier).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(name, "name");
                ClassifierDescriptor mo1781getContributedClassifier2 = unsubstitutedInnerClassesScope.mo1781getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                if (mo1781getContributedClassifier2 instanceof ClassDescriptor) {
                    mo1781getContributedClassifier = (ClassDescriptor) mo1781getContributedClassifier2;
                } else {
                    mo1781getContributedClassifier = null;
                }
                if (mo1781getContributedClassifier == null) {
                    return null;
                }
            }
        } else {
            FqName packageFqName2 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<Name> pathSegments2 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments2, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope2 = packageViewDescriptor2.getMemberScope();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) pathSegments2);
            Intrinsics.checkNotNullExpressionValue(first, "segments.first()");
            ClassifierDescriptor mo1781getContributedClassifier3 = memberScope2.mo1781getContributedClassifier((Name) first, NoLookupLocation.FROM_DESERIALIZATION);
            if (mo1781getContributedClassifier3 != null) {
                for (Name name2 : pathSegments2.subList(1, pathSegments2.size())) {
                    if (mo1781getContributedClassifier3 instanceof ClassDescriptor) {
                        MemberScope unsubstitutedInnerClassesScope2 = ((ClassDescriptor) mo1781getContributedClassifier3).getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(name2, "name");
                        ClassifierDescriptor mo1781getContributedClassifier4 = unsubstitutedInnerClassesScope2.mo1781getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                        if (mo1781getContributedClassifier4 instanceof ClassDescriptor) {
                            mo1781getContributedClassifier3 = (ClassDescriptor) mo1781getContributedClassifier4;
                        } else {
                            mo1781getContributedClassifier3 = null;
                        }
                        if (mo1781getContributedClassifier3 != null) {
                        }
                    }
                }
                if (mo1781getContributedClassifier3 != null) {
                    FqName packageFqName3 = classId.getPackageFqName();
                    Intrinsics.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
                    PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(packageFqName3);
                    List<Name> pathSegments3 = classId.getRelativeClassName().pathSegments();
                    Intrinsics.checkNotNullExpressionValue(pathSegments3, "classId.relativeClassName.pathSegments()");
                    MemberScope memberScope3 = packageViewDescriptor3.getMemberScope();
                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) pathSegments3);
                    Intrinsics.checkNotNullExpressionValue(first2, "segments.first()");
                    mo1781getContributedClassifier = memberScope3.mo1781getContributedClassifier((Name) first2, NoLookupLocation.FROM_DESERIALIZATION);
                    if (mo1781getContributedClassifier == null) {
                        return null;
                    }
                    for (Name name3 : pathSegments3.subList(1, pathSegments3.size())) {
                        if (!(mo1781getContributedClassifier instanceof ClassDescriptor)) {
                            return null;
                        }
                        MemberScope unsubstitutedInnerClassesScope3 = ((ClassDescriptor) mo1781getContributedClassifier).getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(name3, "name");
                        ClassifierDescriptor mo1781getContributedClassifier5 = unsubstitutedInnerClassesScope3.mo1781getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
                        if (mo1781getContributedClassifier5 instanceof ClassDescriptor) {
                            mo1781getContributedClassifier = (ClassDescriptor) mo1781getContributedClassifier5;
                        } else {
                            mo1781getContributedClassifier = null;
                        }
                        if (mo1781getContributedClassifier == null) {
                            return null;
                        }
                    }
                } else {
                    return mo1781getContributedClassifier3;
                }
            }
            mo1781getContributedClassifier3 = null;
            if (mo1781getContributedClassifier3 != null) {
            }
        }
        return mo1781getContributedClassifier;
    }

    @NotNull
    public static final ClassDescriptor findNonGenericClassAcrossDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId, @NotNull NotFoundClasses notFoundClasses) {
        Sequence generateSequence;
        Sequence map;
        List<Integer> list;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies == null) {
            generateSequence = SequencesKt__SequencesKt.generateSequence(classId, (Function1<? super ClassId, ? extends ClassId>) ((Function1<? super Object, ? extends Object>) FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE));
            map = SequencesKt___SequencesKt.map(generateSequence, new Function1<ClassId, Integer>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Integer invoke(@NotNull ClassId it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return 0;
                }
            });
            list = SequencesKt___SequencesKt.toList(map);
            return notFoundClasses.getClass(classId, list);
        }
        return findClassAcrossModuleDependencies;
    }

    @Nullable
    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
