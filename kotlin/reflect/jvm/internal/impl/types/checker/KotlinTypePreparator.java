package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {

    /* loaded from: classes28.dex */
    public static final class Default extends KotlinTypePreparator {

        @NotNull
        public static final Default INSTANCE = new Default();

        Default() {
        }
    }

    private final SimpleType transformToNewType(SimpleType simpleType) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List emptyList;
        int collectionSizeOrDefault3;
        KotlinType type;
        TypeConstructor constructor = simpleType.getConstructor();
        boolean z16 = true;
        boolean z17 = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r5 = null;
        UnwrappedType unwrappedType = null;
        KotlinType kotlinType = null;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
            TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (projection.getProjectionKind() != Variance.IN_VARIANCE) {
                z16 = false;
            }
            if (!z16) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                unwrappedType = type.unwrap();
            }
            UnwrappedType unwrappedType2 = unwrappedType;
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                Collection<KotlinType> mo1780getSupertypes = capturedTypeConstructorImpl.mo1780getSupertypes();
                collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mo1780getSupertypes, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault3);
                Iterator<T> it = mo1780getSupertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((KotlinType) it.next()).unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            Intrinsics.checkNotNull(newTypeConstructor);
            return new NewCapturedType(captureStatus, newTypeConstructor, unwrappedType2, simpleType.getAttributes(), simpleType.isMarkedNullable(), false, 32, null);
        }
        if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> mo1780getSupertypes2 = ((IntegerValueTypeConstructor) constructor).mo1780getSupertypes();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mo1780getSupertypes2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = mo1780getSupertypes2.iterator();
            while (it5.hasNext()) {
                KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified((KotlinType) it5.next(), simpleType.isMarkedNullable());
                Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(makeNullableAsSpecified);
            }
            IntersectionTypeConstructor intersectionTypeConstructor2 = new IntersectionTypeConstructor(arrayList2);
            TypeAttributes attributes = simpleType.getAttributes();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, intersectionTypeConstructor2, emptyList, false, simpleType.getMemberScope());
        }
        if ((constructor instanceof IntersectionTypeConstructor) && simpleType.isMarkedNullable()) {
            IntersectionTypeConstructor intersectionTypeConstructor3 = (IntersectionTypeConstructor) constructor;
            Collection<KotlinType> mo1780getSupertypes3 = intersectionTypeConstructor3.mo1780getSupertypes();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mo1780getSupertypes3, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it6 = mo1780getSupertypes3.iterator();
            while (it6.hasNext()) {
                arrayList3.add(TypeUtilsKt.makeNullable((KotlinType) it6.next()));
                z17 = true;
            }
            if (z17) {
                KotlinType alternativeType = intersectionTypeConstructor3.getAlternativeType();
                if (alternativeType != null) {
                    kotlinType = TypeUtilsKt.makeNullable(alternativeType);
                }
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3).setAlternative(kotlinType);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor3 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor3.createType();
        }
        return simpleType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    @NotNull
    public UnwrappedType prepareType(@NotNull KotlinTypeMarker type) {
        UnwrappedType flexibleType;
        Intrinsics.checkNotNullParameter(type, "type");
        if (type instanceof KotlinType) {
            UnwrappedType unwrap = ((KotlinType) type).unwrap();
            if (unwrap instanceof SimpleType) {
                flexibleType = transformToNewType((SimpleType) unwrap);
            } else if (unwrap instanceof FlexibleType) {
                FlexibleType flexibleType2 = (FlexibleType) unwrap;
                SimpleType transformToNewType = transformToNewType(flexibleType2.getLowerBound());
                SimpleType transformToNewType2 = transformToNewType(flexibleType2.getUpperBound());
                flexibleType = (transformToNewType == flexibleType2.getLowerBound() && transformToNewType2 == flexibleType2.getUpperBound()) ? unwrap : KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrap, new KotlinTypePreparator$prepareType$1(this));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
