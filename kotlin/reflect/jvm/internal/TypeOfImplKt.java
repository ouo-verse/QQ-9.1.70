package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002\u00a8\u0006\t"}, d2 = {"createMutableCollectionKType", "Lkotlin/reflect/KType;", "type", "createNothingType", "createPlatformKType", "lowerBound", "upperBound", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TypeOfImplKt {
    @NotNull
    public static final KType createMutableCollectionKType(@NotNull KType type) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType type2 = ((KTypeImpl) type).getType();
        if (type2 instanceof SimpleType) {
            ClassifierDescriptor mo1779getDeclarationDescriptor = type2.getConstructor().mo1779getDeclarationDescriptor();
            if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
            } else {
                classDescriptor = null;
            }
            if (classDescriptor != null) {
                SimpleType simpleType = (SimpleType) type2;
                TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor, "classifier.readOnlyToMutable().typeConstructor");
                return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
            }
            throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
        }
        throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + type).toString());
    }

    @NotNull
    public static final KType createNothingType(@NotNull KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KotlinType type2 = ((KTypeImpl) type).getType();
        if (type2 instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) type2;
            TypeConstructor typeConstructor = TypeUtilsKt.getBuiltIns(type2).getNothing().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "kotlinType.builtIns.nothing.typeConstructor");
            return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
        }
        throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + type).toString());
    }

    @NotNull
    public static final KType createPlatformKType(@NotNull KType lowerBound, @NotNull KType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        KotlinType type = ((KTypeImpl) lowerBound).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType type2 = ((KTypeImpl) upperBound).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) type, (SimpleType) type2), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor classDescriptor) {
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(classDescriptor));
        if (readOnlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(readOnlyToMutable);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(fqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Not a readonly collection: " + classDescriptor);
    }
}
