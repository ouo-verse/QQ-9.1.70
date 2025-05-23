package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AbstractTypeChecker {

    @NotNull
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();

    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            try {
                iArr[TypeVariance.INV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeVariance.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!typeSystemContext.isIntegerLiteralType(simpleTypeMarker) && !typeSystemContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return null;
        }
        if (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, simpleTypeMarker) && checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, simpleTypeMarker2)) {
            return Boolean.TRUE;
        }
        if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker)) {
            if (checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, simpleTypeMarker, simpleTypeMarker2, false)) {
                return Boolean.TRUE;
            }
        } else if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker2) && (checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(typeSystemContext, simpleTypeMarker) || checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, simpleTypeMarker2, simpleTypeMarker, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        if (!(simpleTypeMarker instanceof CapturedTypeMarker)) {
            return false;
        }
        TypeArgumentMarker projection = typeSystemContext.projection(typeSystemContext.typeConstructor((CapturedTypeMarker) simpleTypeMarker));
        if (typeSystemContext.isStarProjection(projection) || !typeSystemContext.isIntegerLiteralType(typeSystemContext.upperBoundIfFlexible(typeSystemContext.getType(projection)))) {
            return false;
        }
        return true;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeInIntersectionComponents(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        boolean z16;
        boolean z17;
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker);
        if (!(typeConstructor instanceof IntersectionTypeConstructorMarker)) {
            return false;
        }
        Collection<KotlinTypeMarker> supertypes = typeSystemContext.supertypes(typeConstructor);
        if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType((KotlinTypeMarker) it.next());
                if (asSimpleType != null && typeSystemContext.isIntegerLiteralType(asSimpleType)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (!z17) {
            return false;
        }
        return true;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        if (!typeSystemContext.isIntegerLiteralType(simpleTypeMarker) && !checkSubtypeForIntegerLiteralType$lambda$7$isCapturedIntegerLiteralType(typeSystemContext, simpleTypeMarker)) {
            return false;
        }
        return true;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$lambda$7$isTypeInIntegerLiteralType(TypeSystemContext typeSystemContext, TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z16) {
        boolean z17;
        Collection<KotlinTypeMarker> possibleIntegerTypes = typeSystemContext.possibleIntegerTypes(simpleTypeMarker);
        if ((possibleIntegerTypes instanceof Collection) && possibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
            if (!Intrinsics.areEqual(typeSystemContext.typeConstructor(kotlinTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2)) && (!z16 || !isSubtypeOf$default(INSTANCE, typeCheckerState, simpleTypeMarker2, kotlinTypeMarker, false, 8, null))) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0131, code lost:
    
        if (r10 != false) goto L191;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Boolean checkSubtypeForSpecialCases(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        SimpleTypeMarker simpleTypeMarker3;
        KotlinTypeMarker kotlinTypeMarker;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        boolean z16 = false;
        if (!typeSystemContext.isError(simpleTypeMarker) && !typeSystemContext.isError(simpleTypeMarker2)) {
            if (typeSystemContext.isStubTypeForBuilderInference(simpleTypeMarker) && typeSystemContext.isStubTypeForBuilderInference(simpleTypeMarker2)) {
                if (INSTANCE.isStubTypeSubtypeOfAnother(typeSystemContext, simpleTypeMarker, simpleTypeMarker2) || typeCheckerState.isStubTypeEqualsToAnything()) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }
            if (!typeSystemContext.isStubType(simpleTypeMarker) && !typeSystemContext.isStubType(simpleTypeMarker2)) {
                DefinitelyNotNullTypeMarker asDefinitelyNotNullType = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2);
                if (asDefinitelyNotNullType == null || (simpleTypeMarker3 = typeSystemContext.original(asDefinitelyNotNullType)) == null) {
                    simpleTypeMarker3 = simpleTypeMarker2;
                }
                CapturedTypeMarker asCapturedType = typeSystemContext.asCapturedType(simpleTypeMarker3);
                if (asCapturedType != null) {
                    kotlinTypeMarker = typeSystemContext.lowerType(asCapturedType);
                } else {
                    kotlinTypeMarker = null;
                }
                if (asCapturedType != null && kotlinTypeMarker != null) {
                    if (typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
                        kotlinTypeMarker = typeSystemContext.withNullability(kotlinTypeMarker, true);
                    } else if (typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
                        kotlinTypeMarker = typeSystemContext.makeDefinitelyNotNullOrNotNull(kotlinTypeMarker);
                    }
                    KotlinTypeMarker kotlinTypeMarker2 = kotlinTypeMarker;
                    int i3 = WhenMappings.$EnumSwitchMapping$1[typeCheckerState.getLowerCapturedTypePolicy(simpleTypeMarker, asCapturedType).ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2 && isSubtypeOf$default(INSTANCE, typeCheckerState, simpleTypeMarker, kotlinTypeMarker2, false, 8, null)) {
                            return Boolean.TRUE;
                        }
                    } else {
                        return Boolean.valueOf(isSubtypeOf$default(INSTANCE, typeCheckerState, simpleTypeMarker, kotlinTypeMarker2, false, 8, null));
                    }
                }
                TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker2);
                if (typeSystemContext.isIntersection(typeConstructor)) {
                    typeSystemContext.isMarkedNullable(simpleTypeMarker2);
                    Collection<KotlinTypeMarker> supertypes = typeSystemContext.supertypes(typeConstructor);
                    if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                        Iterator<T> it = supertypes.iterator();
                        while (it.hasNext()) {
                            if (!isSubtypeOf$default(INSTANCE, typeCheckerState, simpleTypeMarker, (KotlinTypeMarker) it.next(), false, 8, null)) {
                                break;
                            }
                        }
                    }
                    z16 = true;
                    return Boolean.valueOf(z16);
                }
                TypeConstructorMarker typeConstructor2 = typeSystemContext.typeConstructor(simpleTypeMarker);
                if (!(simpleTypeMarker instanceof CapturedTypeMarker)) {
                    if (typeSystemContext.isIntersection(typeConstructor2)) {
                        Collection<KotlinTypeMarker> supertypes2 = typeSystemContext.supertypes(typeConstructor2);
                        if (!(supertypes2 instanceof Collection) || !supertypes2.isEmpty()) {
                            Iterator<T> it5 = supertypes2.iterator();
                            while (it5.hasNext()) {
                                if (!(((KotlinTypeMarker) it5.next()) instanceof CapturedTypeMarker)) {
                                    break;
                                }
                            }
                        }
                        z16 = true;
                    }
                    return null;
                }
                TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = INSTANCE.getTypeParameterForArgumentInBaseIfItEqualToTarget(typeCheckerState.getTypeSystemContext(), simpleTypeMarker2, simpleTypeMarker);
                if (typeParameterForArgumentInBaseIfItEqualToTarget != null && typeSystemContext.hasRecursiveBounds(typeParameterForArgumentInBaseIfItEqualToTarget, typeSystemContext.typeConstructor(simpleTypeMarker2))) {
                    return Boolean.TRUE;
                }
                return null;
            }
            return Boolean.valueOf(typeCheckerState.isStubTypeEqualsToAnything());
        }
        if (typeCheckerState.isErrorTypeEqualsToAnything()) {
            return Boolean.TRUE;
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker) && !typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(typeSystemContext, typeSystemContext.withNullability(simpleTypeMarker, false), typeSystemContext.withNullability(simpleTypeMarker2, false)));
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        String joinToString$default;
        TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy;
        List<SimpleTypeMarker> emptyList;
        List<SimpleTypeMarker> listOf;
        List<SimpleTypeMarker> emptyList2;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        List<SimpleTypeMarker> fastCorrespondingSupertypes = typeSystemContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes != null) {
            return fastCorrespondingSupertypes;
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker) && typeSystemContext.isClassType(simpleTypeMarker)) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        if (typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            SimpleTypeMarker captureFromArguments = typeSystemContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
            if (captureFromArguments != null) {
                simpleTypeMarker = captureFromArguments;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(simpleTypeMarker);
            return listOf;
        }
        SmartList smartList = new SmartList();
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(current, "current");
                if (supertypesSet.add(current)) {
                    SimpleTypeMarker captureFromArguments2 = typeSystemContext.captureFromArguments(current, CaptureStatus.FOR_SUBTYPING);
                    if (captureFromArguments2 == null) {
                        captureFromArguments2 = current;
                    }
                    if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(captureFromArguments2), typeConstructorMarker)) {
                        smartList.add(captureFromArguments2);
                        substitutionSupertypePolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else if (typeSystemContext.argumentsCount(captureFromArguments2) == 0) {
                        substitutionSupertypePolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    } else {
                        substitutionSupertypePolicy = typeCheckerState.getTypeSystemContext().substitutionSupertypePolicy(captureFromArguments2);
                    }
                    if (!(!Intrinsics.areEqual(substitutionSupertypePolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        substitutionSupertypePolicy = null;
                    }
                    if (substitutionSupertypePolicy != null) {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(current)).iterator();
                        while (it.hasNext()) {
                            supertypesDeque.add(substitutionSupertypePolicy.mo1783transformType(typeCheckerState, it.next()));
                        }
                    }
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Too many supertypes for type: ");
                sb5.append(simpleTypeMarker);
                sb5.append(". Supertypes = ");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null);
                sb5.append(joinToString$default);
                throw new IllegalStateException(sb5.toString().toString());
            }
        }
        typeCheckerState.clear();
        return smartList;
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(typeCheckerState, collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, simpleTypeMarker, typeConstructorMarker));
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z16) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        KotlinTypeMarker prepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
        KotlinTypeMarker prepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForSpecialCases = abstractTypeChecker.checkSubtypeForSpecialCases(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
        if (checkSubtypeForSpecialCases != null) {
            boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
            typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z16);
            return booleanValue;
        }
        Boolean addSubtypeConstraint = typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z16);
        if (addSubtypeConstraint != null) {
            return addSubtypeConstraint.booleanValue();
        }
        return abstractTypeChecker.isSubtypeOfForSingleClassifierType(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        KotlinTypeMarker type;
        int argumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker);
        int i3 = 0;
        while (true) {
            TypeArgumentMarker typeArgumentMarker = null;
            if (i3 >= argumentsCount) {
                return null;
            }
            TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i3);
            boolean z16 = true;
            if (!typeSystemContext.isStarProjection(argument)) {
                typeArgumentMarker = argument;
            }
            if (typeArgumentMarker != null && (type = typeSystemContext.getType(typeArgumentMarker)) != null) {
                if (!typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(type)) || !typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker2))) {
                    z16 = false;
                }
                if (Intrinsics.areEqual(type, kotlinTypeMarker2) || (z16 && Intrinsics.areEqual(typeSystemContext.typeConstructor(type), typeSystemContext.typeConstructor(kotlinTypeMarker2)))) {
                    break;
                }
                TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, type, kotlinTypeMarker2);
                if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                    return typeParameterForArgumentInBaseIfItEqualToTarget;
                }
            }
            i3++;
        }
        return typeSystemContext.getParameter(typeSystemContext.typeConstructor(kotlinTypeMarker), i3);
    }

    private final boolean hasNothingSupertype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker) {
        String joinToString$default;
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker);
        if (typeSystemContext.isClassTypeConstructor(typeConstructor)) {
            return typeSystemContext.isNothingConstructor(typeConstructor);
        }
        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(simpleTypeMarker))) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(current, "current");
                if (supertypesSet.add(current)) {
                    if (typeSystemContext.isClassType(current)) {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(current)).iterator();
                        while (it.hasNext()) {
                            SimpleTypeMarker mo1783transformType = supertypesPolicy.mo1783transformType(typeCheckerState, it.next());
                            if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(mo1783transformType))) {
                                typeCheckerState.clear();
                                return true;
                            }
                            supertypesDeque.add(mo1783transformType);
                        }
                    }
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Too many supertypes for type: ");
                sb5.append(simpleTypeMarker);
                sb5.append(". Supertypes = ");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null);
                sb5.append(joinToString$default);
                throw new IllegalStateException(sb5.toString().toString());
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isCommonDenotableType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        if (typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) && !typeSystemContext.isDynamic(kotlinTypeMarker) && !typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) && !typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker) && Intrinsics.areEqual(typeSystemContext.typeConstructor(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)), typeSystemContext.typeConstructor(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker)))) {
            return true;
        }
        return false;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        SimpleTypeMarker simpleTypeMarker3;
        SimpleTypeMarker simpleTypeMarker4;
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker);
        if (asDefinitelyNotNullType == null || (simpleTypeMarker3 = typeSystemContext.original(asDefinitelyNotNullType)) == null) {
            simpleTypeMarker3 = simpleTypeMarker;
        }
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType2 = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2);
        if (asDefinitelyNotNullType2 == null || (simpleTypeMarker4 = typeSystemContext.original(asDefinitelyNotNullType2)) == null) {
            simpleTypeMarker4 = simpleTypeMarker2;
        }
        if (typeSystemContext.typeConstructor(simpleTypeMarker3) != typeSystemContext.typeConstructor(simpleTypeMarker4)) {
            return false;
        }
        if (!typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker) && typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
            return false;
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker) && !typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z16);
    }

    private final boolean isSubtypeOfForSingleClassifierType(final TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, final SimpleTypeMarker simpleTypeMarker2) {
        int collectionSizeOrDefault;
        Object first;
        int collectionSizeOrDefault2;
        boolean z16;
        KotlinTypeMarker type;
        final TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        boolean z17 = false;
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(typeCheckerState, simpleTypeMarker, simpleTypeMarker2)) {
            return false;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForIntegerLiteralType = abstractTypeChecker.checkSubtypeForIntegerLiteralType(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(simpleTypeMarker), typeSystemContext.upperBoundIfFlexible(simpleTypeMarker2));
        if (checkSubtypeForIntegerLiteralType != null) {
            boolean booleanValue = checkSubtypeForIntegerLiteralType.booleanValue();
            TypeCheckerState.addSubtypeConstraint$default(typeCheckerState, simpleTypeMarker, simpleTypeMarker2, false, 4, null);
            return booleanValue;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker2);
        boolean z18 = true;
        if ((typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeConstructor) && typeSystemContext.parametersCount(typeConstructor) == 0) || typeSystemContext.isAnyConstructor(typeSystemContext.typeConstructor(simpleTypeMarker2))) {
            return true;
        }
        List<SimpleTypeMarker> findCorrespondingSupertypes = abstractTypeChecker.findCorrespondingSupertypes(typeCheckerState, simpleTypeMarker, typeConstructor);
        int i3 = 10;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(findCorrespondingSupertypes, 10);
        final ArrayList<SimpleTypeMarker> arrayList = new ArrayList(collectionSizeOrDefault);
        for (SimpleTypeMarker simpleTypeMarker3 : findCorrespondingSupertypes) {
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(typeCheckerState.prepareType(simpleTypeMarker3));
            if (asSimpleType != null) {
                simpleTypeMarker3 = asSimpleType;
            }
            arrayList.add(simpleTypeMarker3);
        }
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                ArgumentList argumentList = new ArgumentList(typeSystemContext.parametersCount(typeConstructor));
                int parametersCount = typeSystemContext.parametersCount(typeConstructor);
                int i16 = 0;
                boolean z19 = false;
                while (i16 < parametersCount) {
                    if (!z19 && typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i16)) == TypeVariance.OUT) {
                        z19 = z17;
                    } else {
                        z19 = z18;
                    }
                    if (!z19) {
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, i3);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                        for (SimpleTypeMarker simpleTypeMarker4 : arrayList) {
                            TypeArgumentMarker argumentOrNull = typeSystemContext.getArgumentOrNull(simpleTypeMarker4, i16);
                            if (argumentOrNull != null) {
                                if (typeSystemContext.getVariance(argumentOrNull) == TypeVariance.INV) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (!z16) {
                                    argumentOrNull = null;
                                }
                                if (argumentOrNull != null && (type = typeSystemContext.getType(argumentOrNull)) != null) {
                                    arrayList2.add(type);
                                }
                            }
                            throw new IllegalStateException(("Incorrect type: " + simpleTypeMarker4 + ", subType: " + simpleTypeMarker + ", superType: " + simpleTypeMarker2).toString());
                        }
                        argumentList.add(typeSystemContext.asTypeArgument(typeSystemContext.intersectTypes(arrayList2)));
                    }
                    i16++;
                    z17 = false;
                    z18 = true;
                    i3 = 10;
                }
                if (!z19 && INSTANCE.isSubtypeForSameConstructor(typeCheckerState, argumentList, simpleTypeMarker2)) {
                    return true;
                }
                return typeCheckerState.runForkingPoint(new Function1<TypeCheckerState.ForkPointContext, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypeCheckerState.ForkPointContext forkPointContext) {
                        invoke2(forkPointContext);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TypeCheckerState.ForkPointContext runForkingPoint) {
                        Intrinsics.checkNotNullParameter(runForkingPoint, "$this$runForkingPoint");
                        for (final SimpleTypeMarker simpleTypeMarker5 : arrayList) {
                            final TypeCheckerState typeCheckerState2 = typeCheckerState;
                            final TypeSystemContext typeSystemContext2 = typeSystemContext;
                            final SimpleTypeMarker simpleTypeMarker6 = simpleTypeMarker2;
                            runForkingPoint.fork(new Function0<Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                @NotNull
                                public final Boolean invoke() {
                                    return Boolean.valueOf(AbstractTypeChecker.INSTANCE.isSubtypeForSameConstructor(TypeCheckerState.this, typeSystemContext2.asArgumentList(simpleTypeMarker5), simpleTypeMarker6));
                                }
                            });
                        }
                    }
                });
            }
            AbstractTypeChecker abstractTypeChecker2 = INSTANCE;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            return abstractTypeChecker2.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList((SimpleTypeMarker) first), simpleTypeMarker2);
        }
        return INSTANCE.hasNothingSupertype(typeCheckerState, simpleTypeMarker);
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker;
        TypeParameterMarker typeParameter;
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        if (!(asSimpleType instanceof CapturedTypeMarker)) {
            return false;
        }
        CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) asSimpleType;
        if (typeSystemContext.isOldCapturedType(capturedTypeMarker) || !typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) || typeSystemContext.captureStatus(capturedTypeMarker) != CaptureStatus.FOR_SUBTYPING) {
            return false;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(kotlinTypeMarker2);
        if (typeConstructor instanceof TypeVariableTypeConstructorMarker) {
            typeVariableTypeConstructorMarker = (TypeVariableTypeConstructorMarker) typeConstructor;
        } else {
            typeVariableTypeConstructorMarker = null;
        }
        if (typeVariableTypeConstructorMarker == null || (typeParameter = typeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) == null || !typeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState typeCheckerState, List<? extends SimpleTypeMarker> list) {
        boolean z16;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = typeSystemContext.asArgumentList((SimpleTypeMarker) next);
            int size = typeSystemContext.size(asArgumentList);
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (typeSystemContext.asFlexibleType(typeSystemContext.getType(typeSystemContext.get(asArgumentList, i3))) == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                    break;
                }
                i3++;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return list;
    }

    @Nullable
    public final TypeVariance effectiveVariance(@NotNull TypeVariance declared, @NotNull TypeVariance useSite) {
        Intrinsics.checkNotNullParameter(declared, "declared");
        Intrinsics.checkNotNullParameter(useSite, "useSite");
        TypeVariance typeVariance = TypeVariance.INV;
        if (declared == typeVariance) {
            return useSite;
        }
        if (useSite == typeVariance) {
            return declared;
        }
        if (declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean equalTypes(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker a16, @NotNull KotlinTypeMarker b16) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (a16 == b16) {
            return true;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        if (abstractTypeChecker.isCommonDenotableType(typeSystemContext, a16) && abstractTypeChecker.isCommonDenotableType(typeSystemContext, b16)) {
            KotlinTypeMarker prepareType = state.prepareType(state.refineType(a16));
            KotlinTypeMarker prepareType2 = state.prepareType(state.refineType(b16));
            SimpleTypeMarker lowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(prepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(prepareType), typeSystemContext.typeConstructor(prepareType2))) {
                return false;
            }
            if (typeSystemContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (typeSystemContext.hasFlexibleNullability(prepareType) || typeSystemContext.hasFlexibleNullability(prepareType2) || typeSystemContext.isMarkedNullable(lowerBoundIfFlexible) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(prepareType2))) {
                    return true;
                }
                return false;
            }
        }
        if (isSubtypeOf$default(abstractTypeChecker, state, a16, b16, false, 8, null) && isSubtypeOf$default(abstractTypeChecker, state, b16, a16, false, 8, null)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<SimpleTypeMarker> findCorrespondingSupertypes(@NotNull TypeCheckerState state, @NotNull SimpleTypeMarker subType, @NotNull TypeConstructorMarker superConstructor) {
        String joinToString$default;
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superConstructor, "superConstructor");
        TypeSystemContext typeSystemContext = state.getTypeSystemContext();
        if (typeSystemContext.isClassType(subType)) {
            return INSTANCE.collectAndFilter(state, subType, superConstructor);
        }
        if (!typeSystemContext.isClassTypeConstructor(superConstructor) && !typeSystemContext.isIntegerLiteralTypeConstructor(superConstructor)) {
            return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(state, subType, superConstructor);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList();
        state.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = state.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = state.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(subType);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(current, "current");
                if (supertypesSet.add(current)) {
                    if (typeSystemContext.isClassType(current)) {
                        smartList.add(current);
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        TypeSystemContext typeSystemContext2 = state.getTypeSystemContext();
                        Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(current)).iterator();
                        while (it.hasNext()) {
                            supertypesDeque.add(supertypesPolicy.mo1783transformType(state, it.next()));
                        }
                    }
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Too many supertypes for type: ");
                sb5.append(subType);
                sb5.append(". Supertypes = ");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null);
                sb5.append(joinToString$default);
                throw new IllegalStateException(sb5.toString().toString());
            }
        }
        state.clear();
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker it5 : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(state, it5, superConstructor));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(@NotNull TypeCheckerState typeCheckerState, @NotNull TypeArgumentListMarker capturedSubArguments, @NotNull SimpleTypeMarker superType) {
        boolean z16;
        int i3;
        int i16;
        boolean equalTypes;
        int i17;
        Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        Intrinsics.checkNotNullParameter(capturedSubArguments, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(superType, "superType");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(superType);
        int size = typeSystemContext.size(capturedSubArguments);
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        if (size != parametersCount || size != typeSystemContext.argumentsCount(superType)) {
            return false;
        }
        for (int i18 = 0; i18 < parametersCount; i18++) {
            TypeArgumentMarker argument = typeSystemContext.getArgument(superType, i18);
            if (!typeSystemContext.isStarProjection(argument)) {
                KotlinTypeMarker type = typeSystemContext.getType(argument);
                TypeArgumentMarker typeArgumentMarker = typeSystemContext.get(capturedSubArguments, i18);
                typeSystemContext.getVariance(typeArgumentMarker);
                TypeVariance typeVariance = TypeVariance.INV;
                KotlinTypeMarker type2 = typeSystemContext.getType(typeArgumentMarker);
                AbstractTypeChecker abstractTypeChecker = INSTANCE;
                TypeVariance effectiveVariance = abstractTypeChecker.effectiveVariance(typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i18)), typeSystemContext.getVariance(argument));
                if (effectiveVariance == null) {
                    return typeCheckerState.isErrorTypeEqualsToAnything();
                }
                if (effectiveVariance == typeVariance && (abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type2, type, typeConstructor) || abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type, type2, typeConstructor))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    continue;
                } else {
                    i3 = typeCheckerState.argumentsDepth;
                    if (i3 <= 100) {
                        i16 = typeCheckerState.argumentsDepth;
                        typeCheckerState.argumentsDepth = i16 + 1;
                        int i19 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                        if (i19 != 1) {
                            if (i19 != 2) {
                                if (i19 == 3) {
                                    equalTypes = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type, type2, false, 8, null);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                equalTypes = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type2, type, false, 8, null);
                            }
                        } else {
                            equalTypes = abstractTypeChecker.equalTypes(typeCheckerState, type2, type);
                        }
                        i17 = typeCheckerState.argumentsDepth;
                        typeCheckerState.argumentsDepth = i17 - 1;
                        if (!equalTypes) {
                            return false;
                        }
                    } else {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                    }
                }
            }
        }
        return true;
    }

    @JvmOverloads
    public final boolean isSubtypeOf(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker subType, @NotNull KotlinTypeMarker superType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return isSubtypeOf$default(this, state, subType, superType, false, 8, null);
    }

    @JvmOverloads
    public final boolean isSubtypeOf(@NotNull TypeCheckerState state, @NotNull KotlinTypeMarker subType, @NotNull KotlinTypeMarker superType, boolean z16) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.customIsSubtypeOf(subType, superType)) {
            return completeIsSubTypeOf(state, subType, superType, z16);
        }
        return false;
    }
}
