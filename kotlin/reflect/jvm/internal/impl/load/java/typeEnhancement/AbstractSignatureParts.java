package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public abstract class AbstractSignatureParts<TAnnotation> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static final class TypeAndDefaultQualifiers {

        @Nullable
        private final JavaTypeQualifiersByElementType defaultQualifiers;

        @Nullable
        private final KotlinTypeMarker type;

        @Nullable
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(@Nullable KotlinTypeMarker kotlinTypeMarker, @Nullable JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, @Nullable TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }

        @Nullable
        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        @Nullable
        public final KotlinTypeMarker getType() {
            return this.type;
        }

        @Nullable
        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker kotlinTypeMarker) {
        NullabilityQualifier nullabilityQualifier;
        boolean z16;
        NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            if (enhancedForWarnings != null) {
                nullabilityQualifier = getNullabilityQualifier(enhancedForWarnings);
            } else {
                nullabilityQualifier = null;
            }
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        TypeSystemContext typeSystem = getTypeSystem();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (javaToKotlinClassMap.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (javaToKotlinClassMap.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        boolean z17 = false;
        if (!getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) && !isNotNullTypeParameterCompat(kotlinTypeMarker)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (nullabilityQualifier != nullabilityQualifier2) {
            z17 = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z16, z17);
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0130, code lost:
    
        if (r0 != false) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JavaTypeQualifiers extractQualifiersFromAnnotations(TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        boolean z16;
        List emptyList;
        List list;
        TypeParameterMarker typeParameterMarker;
        boolean z17;
        AnnotationQualifierApplicabilityType containerApplicabilityType;
        JavaDefaultQualifiers javaDefaultQualifiers;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
        NullabilityQualifier nullabilityQualifier;
        boolean z18;
        TypeParameterMarker typeParameterForArgument;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus3;
        NullabilityQualifierWithMigrationStatus mostSpecific;
        boolean z19;
        List plus;
        boolean z26;
        List plus2;
        TypeConstructorMarker typeConstructor;
        TypeVariance typeVariance;
        NullabilityQualifier nullabilityQualifier2 = null;
        if (typeAndDefaultQualifiers.getType() == null) {
            TypeSystemContext typeSystem = getTypeSystem();
            TypeParameterMarker typeParameterForArgument2 = typeAndDefaultQualifiers.getTypeParameterForArgument();
            if (typeParameterForArgument2 != null) {
                typeVariance = typeSystem.getVariance(typeParameterForArgument2);
            } else {
                typeVariance = null;
            }
            if (typeVariance == TypeVariance.IN) {
                return JavaTypeQualifiers.Companion.getNONE();
            }
        }
        boolean z27 = true;
        if (typeAndDefaultQualifiers.getTypeParameterForArgument() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        KotlinTypeMarker type = typeAndDefaultQualifiers.getType();
        if (type == null || (list = getAnnotations(type)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        }
        TypeSystemContext typeSystem2 = getTypeSystem();
        KotlinTypeMarker type2 = typeAndDefaultQualifiers.getType();
        if (type2 != null && (typeConstructor = typeSystem2.typeConstructor(type2)) != null) {
            typeParameterMarker = typeSystem2.getTypeParameterClassifier(typeConstructor);
        } else {
            typeParameterMarker = null;
        }
        if (getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            if (!z17 && getEnableImprovementsInStrictMode()) {
                KotlinTypeMarker type3 = typeAndDefaultQualifiers.getType();
                if (type3 != null && isArrayOrPrimitiveArray(type3)) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    Iterable<TAnnotation> containerAnnotations = getContainerAnnotations();
                    ArrayList arrayList = new ArrayList();
                    for (TAnnotation tannotation : containerAnnotations) {
                        if (!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(tannotation)) {
                            arrayList.add(tannotation);
                        }
                    }
                    plus2 = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) list);
                    list = plus2;
                }
            }
            plus = CollectionsKt___CollectionsKt.plus((Iterable) getContainerAnnotations(), (Iterable) list);
            list = plus;
        }
        MutabilityQualifier extractMutability = getAnnotationTypeQualifierResolver().extractMutability(list);
        NullabilityQualifierWithMigrationStatus extractNullability = getAnnotationTypeQualifierResolver().extractNullability((Iterable) list, (Function1) new Function1<TAnnotation, Boolean>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1
            final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull TAnnotation extractNullability2) {
                Intrinsics.checkNotNullParameter(extractNullability2, "$this$extractNullability");
                return Boolean.valueOf(this.this$0.getForceWarning(extractNullability2));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1<TAnnotation>) obj);
            }
        });
        if (extractNullability != null) {
            NullabilityQualifier qualifier = extractNullability.getQualifier();
            if (extractNullability.getQualifier() != NullabilityQualifier.NOT_NULL || typeParameterMarker == null) {
                z27 = false;
            }
            return new JavaTypeQualifiers(qualifier, extractMutability, z27, extractNullability.isForWarningOnly());
        }
        if (!z16 && !z17) {
            containerApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
        } else {
            containerApplicabilityType = getContainerApplicabilityType();
        }
        JavaTypeQualifiersByElementType defaultQualifiers = typeAndDefaultQualifiers.getDefaultQualifiers();
        if (defaultQualifiers != null) {
            javaDefaultQualifiers = defaultQualifiers.get(containerApplicabilityType);
        } else {
            javaDefaultQualifiers = null;
        }
        if (typeParameterMarker != null) {
            nullabilityQualifierWithMigrationStatus = getBoundsNullability(typeParameterMarker);
        } else {
            nullabilityQualifierWithMigrationStatus = null;
        }
        if (nullabilityQualifierWithMigrationStatus == null || (nullabilityQualifierWithMigrationStatus2 = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, NullabilityQualifier.NOT_NULL, false, 2, null)) == null) {
            if (javaDefaultQualifiers != null) {
                nullabilityQualifierWithMigrationStatus2 = javaDefaultQualifiers.getNullabilityQualifier();
            } else {
                nullabilityQualifierWithMigrationStatus2 = null;
            }
        }
        if (nullabilityQualifierWithMigrationStatus != null) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.getQualifier();
        } else {
            nullabilityQualifier = null;
        }
        if (nullabilityQualifier != NullabilityQualifier.NOT_NULL) {
            if (typeParameterMarker != null) {
                if (javaDefaultQualifiers != null && javaDefaultQualifiers.getDefinitelyNotNull()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
            }
            z18 = false;
            typeParameterForArgument = typeAndDefaultQualifiers.getTypeParameterForArgument();
            if (typeParameterForArgument == null && (nullabilityQualifierWithMigrationStatus3 = getBoundsNullability(typeParameterForArgument)) != null) {
                if (nullabilityQualifierWithMigrationStatus3.getQualifier() == NullabilityQualifier.NULLABLE) {
                    nullabilityQualifierWithMigrationStatus3 = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus3, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
                }
            } else {
                nullabilityQualifierWithMigrationStatus3 = null;
            }
            mostSpecific = mostSpecific(nullabilityQualifierWithMigrationStatus3, nullabilityQualifierWithMigrationStatus2);
            if (mostSpecific != null) {
                nullabilityQualifier2 = mostSpecific.getQualifier();
            }
            if (mostSpecific != null || !mostSpecific.isForWarningOnly()) {
                z27 = false;
            }
            return new JavaTypeQualifiers(nullabilityQualifier2, extractMutability, z18, z27);
        }
        z18 = true;
        typeParameterForArgument = typeAndDefaultQualifiers.getTypeParameterForArgument();
        if (typeParameterForArgument == null) {
        }
        nullabilityQualifierWithMigrationStatus3 = null;
        mostSpecific = mostSpecific(nullabilityQualifierWithMigrationStatus3, nullabilityQualifierWithMigrationStatus2);
        if (mostSpecific != null) {
        }
        if (mostSpecific != null) {
        }
        z27 = false;
        return new JavaTypeQualifiers(nullabilityQualifier2, extractMutability, z18, z27);
    }

    private final <T> void flattenTree(T t16, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t16);
        Iterable<? extends T> invoke = function1.invoke(t16);
        if (invoke != null) {
            Iterator<? extends T> it = invoke.iterator();
            while (it.hasNext()) {
                flattenTree(it.next(), list, function1);
            }
        }
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker typeParameterMarker) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        List<KotlinTypeMarker> arrayList;
        boolean z27;
        NullabilityQualifier nullabilityQualifier;
        TypeSystemContext typeSystem = getTypeSystem();
        if (!isFromJava(typeParameterMarker)) {
            return null;
        }
        List<KotlinTypeMarker> upperBounds = typeSystem.getUpperBounds(typeParameterMarker);
        List<KotlinTypeMarker> list = upperBounds;
        boolean z28 = list instanceof Collection;
        boolean z29 = false;
        if (!z28 || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!typeSystem.isError((KotlinTypeMarker) it.next())) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        if (z16) {
            return null;
        }
        if (!z28 || !list.isEmpty()) {
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                if (getNullabilityQualifier((KotlinTypeMarker) it5.next()) != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z18 = true;
                    break;
                }
            }
        }
        z18 = false;
        if (z18) {
            arrayList = upperBounds;
        } else {
            if (!z28 || !list.isEmpty()) {
                Iterator<T> it6 = list.iterator();
                while (it6.hasNext()) {
                    if (getEnhancedForWarnings((KotlinTypeMarker) it6.next()) != null) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        z26 = true;
                        break;
                    }
                }
            }
            z26 = false;
            if (!z26) {
                return null;
            }
            arrayList = new ArrayList<>();
            Iterator<T> it7 = list.iterator();
            while (it7.hasNext()) {
                KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings((KotlinTypeMarker) it7.next());
                if (enhancedForWarnings != null) {
                    arrayList.add(enhancedForWarnings);
                }
            }
        }
        List<KotlinTypeMarker> list2 = arrayList;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it8 = list2.iterator();
            while (it8.hasNext()) {
                if (!typeSystem.isNullableType((KotlinTypeMarker) it8.next())) {
                    z27 = false;
                    break;
                }
            }
        }
        z27 = true;
        if (z27) {
            nullabilityQualifier = NullabilityQualifier.NULLABLE;
        } else {
            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        }
        if (arrayList != upperBounds) {
            z29 = true;
        }
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z29);
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker kotlinTypeMarker) {
        TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (!typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NOT_NULL;
        }
        return null;
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        if (nullabilityQualifierWithMigrationStatus == null) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus2 == null) {
            return nullabilityQualifierWithMigrationStatus;
        }
        if (nullabilityQualifierWithMigrationStatus.isForWarningOnly() && !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() && nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return nullabilityQualifierWithMigrationStatus;
        }
        if (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) < 0) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0) {
            return nullabilityQualifierWithMigrationStatus;
        }
        return nullabilityQualifierWithMigrationStatus2;
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker kotlinTypeMarker) {
        final TypeSystemContext typeSystem = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), null), new Function1<TypeAndDefaultQualifiers, Iterable<? extends TypeAndDefaultQualifiers>>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$toIndexed$1$1
            final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Iterable<AbstractSignatureParts.TypeAndDefaultQualifiers> invoke(@NotNull AbstractSignatureParts.TypeAndDefaultQualifiers it) {
                TypeConstructorMarker typeConstructor;
                List<TypeParameterMarker> parameters;
                int collectionSizeOrDefault;
                int collectionSizeOrDefault2;
                JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers;
                AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers;
                FlexibleTypeMarker asFlexibleType;
                Intrinsics.checkNotNullParameter(it, "it");
                ArrayList arrayList = null;
                if (this.this$0.getSkipRawTypeArguments()) {
                    KotlinTypeMarker type = it.getType();
                    if (((type == null || (asFlexibleType = typeSystem.asFlexibleType(type)) == null) ? null : typeSystem.asRawType(asFlexibleType)) != null) {
                        return null;
                    }
                }
                KotlinTypeMarker type2 = it.getType();
                if (type2 != null && (typeConstructor = typeSystem.typeConstructor(type2)) != null && (parameters = typeSystem.getParameters(typeConstructor)) != null) {
                    List<TypeParameterMarker> list = parameters;
                    List<TypeArgumentMarker> arguments = typeSystem.getArguments(it.getType());
                    TypeSystemContext typeSystemContext = typeSystem;
                    AbstractSignatureParts<TAnnotation> abstractSignatureParts = this.this$0;
                    Iterator<T> it5 = list.iterator();
                    Iterator<T> it6 = arguments.iterator();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10);
                    ArrayList arrayList2 = new ArrayList(Math.min(collectionSizeOrDefault, collectionSizeOrDefault2));
                    while (it5.hasNext() && it6.hasNext()) {
                        Object next = it5.next();
                        TypeArgumentMarker typeArgumentMarker = (TypeArgumentMarker) it6.next();
                        TypeParameterMarker typeParameterMarker = (TypeParameterMarker) next;
                        if (typeSystemContext.isStarProjection(typeArgumentMarker)) {
                            typeAndDefaultQualifiers = new AbstractSignatureParts.TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), typeParameterMarker);
                        } else {
                            KotlinTypeMarker type3 = typeSystemContext.getType(typeArgumentMarker);
                            extractAndMergeDefaultQualifiers = abstractSignatureParts.extractAndMergeDefaultQualifiers(type3, it.getDefaultQualifiers());
                            typeAndDefaultQualifiers = new AbstractSignatureParts.TypeAndDefaultQualifiers(type3, extractAndMergeDefaultQualifiers, typeParameterMarker);
                        }
                        arrayList2.add(typeAndDefaultQualifiers);
                    }
                    arrayList = arrayList2;
                }
                return arrayList;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        if (r10 != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0072  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull Iterable<? extends KotlinTypeMarker> overrides, @Nullable final TypeEnhancementInfo typeEnhancementInfo, boolean z16) {
        int collectionSizeOrDefault;
        boolean z17;
        int size;
        int i3;
        boolean z18;
        boolean z19;
        Object orNull;
        JavaTypeQualifiers javaTypeQualifiers;
        KotlinTypeMarker type;
        boolean z26;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List<TypeAndDefaultQualifiers> indexed = toIndexed(kotlinTypeMarker);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(overrides, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<? extends KotlinTypeMarker> it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(toIndexed(it.next()));
        }
        if (!getForceOnlyHeadTypeConstructor()) {
            if (isCovariant()) {
                if (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty()) {
                    Iterator<? extends KotlinTypeMarker> it5 = overrides.iterator();
                    while (it5.hasNext()) {
                        if (!isEqual(kotlinTypeMarker, it5.next())) {
                            z26 = true;
                            break;
                        }
                    }
                }
                z26 = false;
            }
            z17 = false;
            if (!z17) {
                size = 1;
            } else {
                size = indexed.size();
            }
            final JavaTypeQualifiers[] javaTypeQualifiersArr = new JavaTypeQualifiers[size];
            for (i3 = 0; i3 < size; i3++) {
                JavaTypeQualifiers extractQualifiersFromAnnotations = extractQualifiersFromAnnotations(indexed.get(i3));
                ArrayList arrayList2 = new ArrayList();
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull((List) it6.next(), i3);
                    TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) orNull;
                    if (typeAndDefaultQualifiers != null && (type = typeAndDefaultQualifiers.getType()) != null) {
                        javaTypeQualifiers = extractQualifiers(type);
                    } else {
                        javaTypeQualifiers = null;
                    }
                    if (javaTypeQualifiers != null) {
                        arrayList2.add(javaTypeQualifiers);
                    }
                }
                if (i3 == 0 && isCovariant()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (i3 == 0 && getContainerIsVarargParameter()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                javaTypeQualifiersArr[i3] = TypeEnhancementUtilsKt.computeQualifiersForOverride(extractQualifiersFromAnnotations, arrayList2, z18, z19, z16);
            }
            return new Function1<Integer, JavaTypeQualifiers>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @NotNull
                public final JavaTypeQualifiers invoke(int i16) {
                    int lastIndex;
                    Map<Integer, JavaTypeQualifiers> map;
                    JavaTypeQualifiers javaTypeQualifiers2;
                    TypeEnhancementInfo typeEnhancementInfo2 = TypeEnhancementInfo.this;
                    if (typeEnhancementInfo2 != null && (map = typeEnhancementInfo2.getMap()) != null && (javaTypeQualifiers2 = map.get(Integer.valueOf(i16))) != null) {
                        return javaTypeQualifiers2;
                    }
                    JavaTypeQualifiers[] javaTypeQualifiersArr2 = javaTypeQualifiersArr;
                    if (i16 >= 0) {
                        lastIndex = ArraysKt___ArraysKt.getLastIndex(javaTypeQualifiersArr2);
                        if (i16 <= lastIndex) {
                            return javaTypeQualifiersArr2[i16];
                        }
                    }
                    return JavaTypeQualifiers.Companion.getNONE();
                }
            };
        }
        z17 = true;
        if (!z17) {
        }
        final JavaTypeQualifiers[] javaTypeQualifiersArr2 = new JavaTypeQualifiers[size];
        while (i3 < size) {
        }
        return new Function1<Integer, JavaTypeQualifiers>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final JavaTypeQualifiers invoke(int i16) {
                int lastIndex;
                Map<Integer, JavaTypeQualifiers> map;
                JavaTypeQualifiers javaTypeQualifiers2;
                TypeEnhancementInfo typeEnhancementInfo2 = TypeEnhancementInfo.this;
                if (typeEnhancementInfo2 != null && (map = typeEnhancementInfo2.getMap()) != null && (javaTypeQualifiers2 = map.get(Integer.valueOf(i16))) != null) {
                    return javaTypeQualifiers2;
                }
                JavaTypeQualifiers[] javaTypeQualifiersArr22 = javaTypeQualifiersArr2;
                if (i16 >= 0) {
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(javaTypeQualifiersArr22);
                    if (i16 <= lastIndex) {
                        return javaTypeQualifiersArr22[i16];
                    }
                }
                return JavaTypeQualifiers.Companion.getNONE();
            }
        };
    }

    @NotNull
    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    @NotNull
    public abstract Iterable<TAnnotation> getAnnotations(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    public abstract Iterable<TAnnotation> getContainerAnnotations();

    @NotNull
    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    @Nullable
    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    @Nullable
    public abstract KotlinTypeMarker getEnhancedForWarnings(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract boolean getForceWarning(@NotNull TAnnotation tannotation);

    @Nullable
    public abstract FqNameUnsafe getFqNameUnsafe(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    @NotNull
    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(@NotNull TypeParameterMarker typeParameterMarker);

    public boolean isNotNullTypeParameterCompat(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return false;
    }

    private final <T> List<T> flattenTree(T t16, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList arrayList = new ArrayList(1);
        flattenTree(t16, arrayList, function1);
        return arrayList;
    }
}
