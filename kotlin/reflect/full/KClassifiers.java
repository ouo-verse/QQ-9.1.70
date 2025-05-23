package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/TypeAttributes;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "KClassifiers")
/* loaded from: classes28.dex */
public final class KClassifiers {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final SimpleType createKotlinType(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<KTypeProjection> list, boolean z16) {
        int collectionSizeOrDefault;
        KotlinType kotlinType;
        int i3;
        TypeProjectionBase starProjectionImpl;
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        List<KTypeProjection> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i16 = 0;
        for (Object obj : list2) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            KTypeProjection kTypeProjection = (KTypeProjection) obj;
            KTypeImpl kTypeImpl = (KTypeImpl) kTypeProjection.getType();
            if (kTypeImpl != null) {
                kotlinType = kTypeImpl.getType();
            } else {
                kotlinType = null;
            }
            KVariance variance = kTypeProjection.getVariance();
            if (variance == null) {
                i3 = -1;
            } else {
                i3 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
            }
            if (i3 != -1) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            Variance variance2 = Variance.OUT_VARIANCE;
                            Intrinsics.checkNotNull(kotlinType);
                            starProjectionImpl = new TypeProjectionImpl(variance2, kotlinType);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        Variance variance3 = Variance.IN_VARIANCE;
                        Intrinsics.checkNotNull(kotlinType);
                        starProjectionImpl = new TypeProjectionImpl(variance3, kotlinType);
                    }
                } else {
                    Variance variance4 = Variance.INVARIANT;
                    Intrinsics.checkNotNull(kotlinType);
                    starProjectionImpl = new TypeProjectionImpl(variance4, kotlinType);
                }
            } else {
                TypeParameterDescriptor typeParameterDescriptor = parameters.get(i16);
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameters[index]");
                starProjectionImpl = new StarProjectionImpl(typeParameterDescriptor);
            }
            arrayList.add(starProjectionImpl);
            i16 = i17;
        }
        return KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, arrayList, z16, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final KType createType(@NotNull KClassifier kClassifier, @NotNull List<KTypeProjection> arguments, boolean z16, @NotNull List<? extends Annotation> annotations) {
        KClassifierImpl kClassifierImpl;
        ClassifierDescriptor descriptor;
        TypeAttributes empty;
        Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (kClassifier instanceof KClassifierImpl) {
            kClassifierImpl = (KClassifierImpl) kClassifier;
        } else {
            kClassifierImpl = null;
        }
        if (kClassifierImpl != null && (descriptor = kClassifierImpl.getDescriptor()) != null) {
            TypeConstructor typeConstructor = descriptor.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            if (parameters.size() == arguments.size()) {
                if (annotations.isEmpty()) {
                    empty = TypeAttributes.Companion.getEmpty();
                } else {
                    empty = TypeAttributes.Companion.getEmpty();
                }
                return new KTypeImpl(createKotlinType(empty, typeConstructor, arguments, z16), null, 2, null);
            }
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
        }
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + kClassifier + " (" + kClassifier.getClass() + ')');
    }

    public static /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean z16, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return createType(kClassifier, list, z16, list2);
    }

    @NotNull
    public static final KType getStarProjectedType(@NotNull KClassifier kClassifier) {
        KClassifierImpl kClassifierImpl;
        ClassifierDescriptor descriptor;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        if (kClassifier instanceof KClassifierImpl) {
            kClassifierImpl = (KClassifierImpl) kClassifier;
        } else {
            kClassifierImpl = null;
        }
        if (kClassifierImpl != null && (descriptor = kClassifierImpl.getDescriptor()) != null) {
            List<TypeParameterDescriptor> parameters = descriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "descriptor.typeConstructor.parameters");
            if (parameters.isEmpty()) {
                return createType$default(kClassifier, null, false, null, 7, null);
            }
            List<TypeParameterDescriptor> list = parameters;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                arrayList.add(KTypeProjection.INSTANCE.getSTAR());
            }
            return createType$default(kClassifier, arrayList, false, null, 6, null);
        }
        return createType$default(kClassifier, null, false, null, 7, null);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier kClassifier) {
    }
}
