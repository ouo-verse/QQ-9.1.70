package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class TypeParameterUtilsKt {
    @Nullable
    public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        return buildPossiblyInnerType(kotlinType, mo1779getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo1779getDeclarationDescriptor : null, 0);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i3) {
        return new CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i3);
    }

    @NotNull
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        Sequence takeWhile;
        Sequence filter;
        Sequence flatMap;
        List list;
        List<TypeParameterDescriptor> list2;
        DeclarationDescriptor declarationDescriptor;
        List plus;
        int collectionSizeOrDefault;
        List<TypeParameterDescriptor> plus2;
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (classifierDescriptorWithTypeParameters.isInner() || (classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            takeWhile = SequencesKt___SequencesKt.takeWhile(DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters), new Function1<DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DeclarationDescriptor it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it instanceof CallableDescriptor);
                }
            });
            filter = SequencesKt___SequencesKt.filter(takeWhile, new Function1<DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DeclarationDescriptor it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(!(it instanceof ConstructorDescriptor));
                }
            });
            flatMap = SequencesKt___SequencesKt.flatMap(filter, new Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Sequence<TypeParameterDescriptor> invoke(@NotNull DeclarationDescriptor it) {
                    Sequence<TypeParameterDescriptor> asSequence;
                    Intrinsics.checkNotNullParameter(it, "it");
                    List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) it).getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters, "it as CallableDescriptor).typeParameters");
                    asSequence = CollectionsKt___CollectionsKt.asSequence(typeParameters);
                    return asSequence;
                }
            });
            list = SequencesKt___SequencesKt.toList(flatMap);
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters).iterator();
            while (true) {
                list2 = null;
                if (it.hasNext()) {
                    declarationDescriptor = it.next();
                    if (declarationDescriptor instanceof ClassDescriptor) {
                        break;
                    }
                } else {
                    declarationDescriptor = null;
                    break;
                }
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
                list2 = typeConstructor.getParameters();
            }
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            if (!list.isEmpty() || !list2.isEmpty()) {
                plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2);
                List<TypeParameterDescriptor> list3 = plus;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (TypeParameterDescriptor it5 : list3) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    arrayList.add(capturedCopyForInnerDeclaration(it5, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
                }
                plus2 = CollectionsKt___CollectionsKt.plus((Collection) declaredTypeParameters, (Iterable) arrayList);
                return plus2;
            }
            List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
            return declaredTypeParameters2;
        }
        return declaredTypeParameters;
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i3) {
        if (classifierDescriptorWithTypeParameters == null || ErrorUtils.isError(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i3;
        if (!classifierDescriptorWithTypeParameters.isInner()) {
            if (size != kotlinType.getArguments().size()) {
                DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters);
            }
            return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i3, kotlinType.getArguments().size()), null);
        }
        List<TypeProjection> subList = kotlinType.getArguments().subList(i3, size);
        DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
        return new PossiblyInnerType(classifierDescriptorWithTypeParameters, subList, buildPossiblyInnerType(kotlinType, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
    }
}
