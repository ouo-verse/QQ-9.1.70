package kotlin.reflect.jvm.internal.impl.types;

import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);

    @NotNull
    private final TypeSubstitution substitution;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType;

        static {
            int[] iArr = new int[VarianceConflictType.values().length];
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = iArr;
            try {
                iArr[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x0122. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0125. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x0128. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0134 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x003d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0022 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 1 && i3 != 2 && i3 != 8 && i3 != 34 && i3 != 37) {
            switch (i3) {
                default:
                    switch (i3) {
                        default:
                            switch (i3) {
                                default:
                                    switch (i3) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    break;
            }
            if (i3 != 1 && i3 != 2 && i3 != 8 && i3 != 34 && i3 != 37) {
                switch (i3) {
                    default:
                        switch (i3) {
                            default:
                                switch (i3) {
                                    default:
                                        switch (i3) {
                                            case 40:
                                            case 41:
                                            case 42:
                                                break;
                                            default:
                                                i16 = 3;
                                                break;
                                        }
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                        i16 = 2;
                                        break;
                                }
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                                break;
                        }
                    case 11:
                    case 12:
                    case 13:
                        break;
                }
                Object[] objArr = new Object[i16];
                switch (i3) {
                    case 1:
                    case 2:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                    case 37:
                    case 40:
                    case 41:
                    case 42:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                        break;
                    case 3:
                        objArr[0] = MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST;
                        break;
                    case 4:
                        objArr[0] = MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND;
                        break;
                    case 5:
                        objArr[0] = "substitutionContext";
                        break;
                    case 6:
                        objArr[0] = "context";
                        break;
                    case 7:
                    default:
                        objArr[0] = "substitution";
                        break;
                    case 9:
                    case 14:
                        objArr[0] = "type";
                        break;
                    case 10:
                    case 15:
                        objArr[0] = "howThisTypeIsUsed";
                        break;
                    case 16:
                    case 17:
                    case 36:
                        objArr[0] = "typeProjection";
                        break;
                    case 18:
                    case 28:
                        objArr[0] = "originalProjection";
                        break;
                    case 26:
                        objArr[0] = QzoneCoverConst.KEY_VIDEO_COVER_ORIGINAL_TYPE;
                        break;
                    case 27:
                        objArr[0] = "substituted";
                        break;
                    case 33:
                        objArr[0] = "annotations";
                        break;
                    case 35:
                    case 38:
                        objArr[0] = "typeParameterVariance";
                        break;
                    case 39:
                        objArr[0] = "projectionKind";
                        break;
                }
                if (i3 == 1) {
                    if (i3 != 2) {
                        if (i3 != 8) {
                            if (i3 != 34) {
                                if (i3 != 37) {
                                    switch (i3) {
                                        case 11:
                                        case 12:
                                        case 13:
                                            objArr[1] = "safeSubstitute";
                                            break;
                                        default:
                                            switch (i3) {
                                                case 19:
                                                case 20:
                                                case 21:
                                                case 22:
                                                case 23:
                                                case 24:
                                                case 25:
                                                    objArr[1] = "unsafeSubstitute";
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 29:
                                                        case 30:
                                                        case 31:
                                                        case 32:
                                                            objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                                            break;
                                                        default:
                                                            switch (i3) {
                                                                case 40:
                                                                case 41:
                                                                case 42:
                                                                    break;
                                                                default:
                                                                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                                }
                                objArr[1] = "combine";
                            } else {
                                objArr[1] = "filterOutUnsafeVariance";
                            }
                        } else {
                            objArr[1] = "getSubstitution";
                        }
                    } else {
                        objArr[1] = "replaceWithContravariantApproximatingSubstitution";
                    }
                } else {
                    objArr[1] = "replaceWithNonApproximatingSubstitution";
                }
                switch (i3) {
                    case 1:
                    case 2:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                    case 37:
                    case 40:
                    case 41:
                    case 42:
                        break;
                    case 3:
                    case 4:
                        objArr[2] = "createChainedSubstitutor";
                        break;
                    case 5:
                    case 6:
                    default:
                        objArr[2] = OperateCustomButton.OPERATE_CREATE;
                        break;
                    case 7:
                        objArr[2] = "<init>";
                        break;
                    case 9:
                    case 10:
                        objArr[2] = "safeSubstitute";
                        break;
                    case 14:
                    case 15:
                    case 16:
                        objArr[2] = "substitute";
                        break;
                    case 17:
                        objArr[2] = "substituteWithoutApproximation";
                        break;
                    case 18:
                        objArr[2] = "unsafeSubstitute";
                        break;
                    case 26:
                    case 27:
                    case 28:
                        objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                        break;
                    case 33:
                        objArr[2] = "filterOutUnsafeVariance";
                        break;
                    case 35:
                    case 36:
                    case 38:
                    case 39:
                        objArr[2] = "combine";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 1 && i3 != 2 && i3 != 8 && i3 != 34 && i3 != 37) {
                    switch (i3) {
                        default:
                            switch (i3) {
                                default:
                                    switch (i3) {
                                        default:
                                            switch (i3) {
                                                case 40:
                                                case 41:
                                                case 42:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                            throw new IllegalStateException(format);
                                    }
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    break;
                            }
                        case 11:
                        case 12:
                        case 13:
                            break;
                    }
                }
                throw new IllegalStateException(format);
            }
            i16 = 2;
            Object[] objArr2 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 1) {
            }
            switch (i3) {
            }
            String format2 = String.format(str, objArr2);
            if (i3 != 1) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 1) {
            switch (i3) {
            }
            Object[] objArr22 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 1) {
            }
            switch (i3) {
            }
            String format22 = String.format(str, objArr22);
            if (i3 != 1) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        Object[] objArr222 = new Object[i16];
        switch (i3) {
        }
        if (i3 == 1) {
        }
        switch (i3) {
        }
        String format222 = String.format(str, objArr222);
        if (i3 != 1) {
        }
        throw new IllegalStateException(format222);
    }

    protected TypeSubstitutor(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(7);
        }
        this.substitution = typeSubstitution;
    }

    private static void assertRecursionDepth(int i3, TypeProjection typeProjection, TypeSubstitution typeSubstitution) {
        if (i3 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(typeProjection) + "; substitution: " + safeToString(typeSubstitution));
    }

    @NotNull
    public static Variance combine(@NotNull Variance variance, @NotNull TypeProjection typeProjection) {
        if (variance == null) {
            $$$reportNull$$$0(35);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(36);
        }
        if (!typeProjection.isStarProjection()) {
            return combine(variance, typeProjection.getProjectionKind());
        }
        Variance variance2 = Variance.OUT_VARIANCE;
        if (variance2 == null) {
            $$$reportNull$$$0(37);
        }
        return variance2;
    }

    private static VarianceConflictType conflictType(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(0);
        }
        return new TypeSubstitutor(typeSubstitution);
    }

    @NotNull
    public static TypeSubstitutor createChainedSubstitutor(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(3);
        }
        if (typeSubstitution2 == null) {
            $$$reportNull$$$0(4);
        }
        return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution, typeSubstitution2));
    }

    @NotNull
    private static Annotations filterOutUnsafeVariance(@NotNull Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$0(33);
        }
        if (!annotations.hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            return annotations;
        }
        return new FilteredAnnotations(annotations, new Function1<FqName, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.1
            private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
            }

            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(@NotNull FqName fqName) {
                if (fqName == null) {
                    $$$reportNull$$$0(0);
                }
                return Boolean.valueOf(!fqName.equals(StandardNames.FqNames.unsafeVariance));
            }
        });
    }

    @NotNull
    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(@NotNull KotlinType kotlinType, @NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(26);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(27);
        }
        if (typeProjection2 == null) {
            $$$reportNull$$$0(28);
        }
        if (!kotlinType.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            if (typeProjection == null) {
                $$$reportNull$$$0(29);
            }
            return typeProjection;
        }
        TypeConstructor constructor = typeProjection.getType().getConstructor();
        if (!(constructor instanceof NewCapturedTypeConstructor)) {
            return typeProjection;
        }
        TypeProjection projection = ((NewCapturedTypeConstructor) constructor).getProjection();
        Variance projectionKind = projection.getProjectionKind();
        VarianceConflictType conflictType = conflictType(typeProjection2.getProjectionKind(), projectionKind);
        VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
        if (conflictType == varianceConflictType) {
            return new TypeProjectionImpl(projection.getType());
        }
        if (typeParameterDescriptor == null) {
            return typeProjection;
        }
        if (conflictType(typeParameterDescriptor.getVariance(), projectionKind) == varianceConflictType) {
            return new TypeProjectionImpl(projection.getType());
        }
        return typeProjection;
    }

    private static String safeToString(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th5) {
            if (!ExceptionUtilsKt.isProcessCanceledException(th5)) {
                return "[Exception while computing toString(): " + th5 + "]";
            }
            throw th5;
        }
    }

    private TypeProjection substituteCompoundType(TypeProjection typeProjection, int i3) throws SubstitutionException {
        KotlinType kotlinType;
        KotlinType type = typeProjection.getType();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (type.getConstructor().mo1779getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type);
        if (abbreviation != null) {
            kotlinType = replaceWithNonApproximatingSubstitution().substitute(abbreviation, Variance.INVARIANT);
        } else {
            kotlinType = null;
        }
        KotlinType replace = TypeSubstitutionKt.replace(type, substituteTypeArguments(type.getConstructor().getParameters(), type.getArguments(), i3), this.substitution.filterAnnotations(type.getAnnotations()));
        if ((replace instanceof SimpleType) && (kotlinType instanceof SimpleType)) {
            replace = SpecialTypesKt.withAbbreviation((SimpleType) replace, (SimpleType) kotlinType);
        }
        return new TypeProjectionImpl(projectionKind, replace);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i3) throws SubstitutionException {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z16 = false;
        for (int i16 = 0; i16 < list.size(); i16++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i16);
            TypeProjection typeProjection = list2.get(i16);
            TypeProjection unsafeSubstitute = unsafeSubstitute(typeProjection, typeParameterDescriptor, i3 + 1);
            int i17 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(typeParameterDescriptor.getVariance(), unsafeSubstitute.getProjectionKind()).ordinal()];
            if (i17 != 1 && i17 != 2) {
                if (i17 == 3) {
                    Variance variance = typeParameterDescriptor.getVariance();
                    Variance variance2 = Variance.INVARIANT;
                    if (variance != variance2 && !unsafeSubstitute.isStarProjection()) {
                        unsafeSubstitute = new TypeProjectionImpl(variance2, unsafeSubstitute.getType());
                    }
                }
            } else {
                unsafeSubstitute = TypeUtils.makeStarProjection(typeParameterDescriptor);
            }
            if (unsafeSubstitute != typeProjection) {
                z16 = true;
            }
            arrayList.add(unsafeSubstitute);
        }
        if (!z16) {
            return list2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    private TypeProjection unsafeSubstitute(@NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, int i3) throws SubstitutionException {
        TypeProjection typeProjection2;
        KotlinType makeNullableIfNeeded;
        if (typeProjection == null) {
            $$$reportNull$$$0(18);
        }
        assertRecursionDepth(i3, typeProjection, this.substitution);
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            UnwrappedType origin = typeWithEnhancement.getOrigin();
            KotlinType enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection unsafeSubstitute = unsafeSubstitute(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i3 + 1);
            if (unsafeSubstitute.isStarProjection()) {
                return unsafeSubstitute;
            }
            return new TypeProjectionImpl(unsafeSubstitute.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(unsafeSubstitute.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
        }
        if (!DynamicTypesKt.isDynamic(type) && !(type.unwrap() instanceof RawType)) {
            TypeProjection mo1784get = this.substitution.mo1784get(type);
            if (mo1784get != null) {
                typeProjection2 = projectedTypeForConflictedTypeWithUnsafeVariance(type, mo1784get, typeParameterDescriptor, typeProjection);
            } else {
                typeProjection2 = null;
            }
            Variance projectionKind = typeProjection.getProjectionKind();
            if (typeProjection2 == null && FlexibleTypesKt.isFlexible(type) && !TypeCapabilitiesKt.isCustomTypeParameter(type)) {
                FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(type);
                int i16 = i3 + 1;
                TypeProjection unsafeSubstitute2 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getLowerBound()), typeParameterDescriptor, i16);
                TypeProjection unsafeSubstitute3 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getUpperBound()), typeParameterDescriptor, i16);
                Variance projectionKind2 = unsafeSubstitute2.getProjectionKind();
                if (unsafeSubstitute2.getType() == asFlexibleType.getLowerBound() && unsafeSubstitute3.getType() == asFlexibleType.getUpperBound()) {
                    return typeProjection;
                }
                return new TypeProjectionImpl(projectionKind2, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(unsafeSubstitute2.getType()), TypeSubstitutionKt.asSimpleType(unsafeSubstitute3.getType())));
            }
            if (!KotlinBuiltIns.isNothing(type) && !KotlinTypeKt.isError(type)) {
                if (typeProjection2 != null) {
                    VarianceConflictType conflictType = conflictType(projectionKind, typeProjection2.getProjectionKind());
                    if (!CapturedTypeConstructorKt.isCaptured(type)) {
                        int i17 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType.ordinal()];
                        if (i17 != 1) {
                            if (i17 == 2) {
                                return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                            }
                        } else {
                            throw new SubstitutionException("Out-projection in in-position");
                        }
                    }
                    CustomTypeParameter customTypeParameter = TypeCapabilitiesKt.getCustomTypeParameter(type);
                    if (typeProjection2.isStarProjection()) {
                        return typeProjection2;
                    }
                    if (customTypeParameter != null) {
                        makeNullableIfNeeded = customTypeParameter.substitutionResult(typeProjection2.getType());
                    } else {
                        makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(typeProjection2.getType(), type.isMarkedNullable());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        makeNullableIfNeeded = TypeUtilsKt.replaceAnnotations(makeNullableIfNeeded, new CompositeAnnotations(makeNullableIfNeeded.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(type.getAnnotations()))));
                    }
                    if (conflictType == VarianceConflictType.NO_CONFLICT) {
                        projectionKind = combine(projectionKind, typeProjection2.getProjectionKind());
                    }
                    return new TypeProjectionImpl(projectionKind, makeNullableIfNeeded);
                }
                typeProjection = substituteCompoundType(typeProjection, i3);
                if (typeProjection == null) {
                    $$$reportNull$$$0(25);
                }
            }
        }
        return typeProjection;
    }

    @NotNull
    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution == null) {
            $$$reportNull$$$0(8);
        }
        return typeSubstitution;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    @NotNull
    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if ((typeSubstitution instanceof IndexedParametersSubstitution) && typeSubstitution.approximateContravariantCapturedTypes()) {
            return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
        }
        return this;
    }

    @NotNull
    public KotlinType safeSubstitute(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        if (variance == null) {
            $$$reportNull$$$0(10);
        }
        if (isEmpty()) {
            if (kotlinType == null) {
                $$$reportNull$$$0(11);
            }
            return kotlinType;
        }
        try {
            KotlinType type = unsafeSubstitute(new TypeProjectionImpl(variance, kotlinType), null, 0).getType();
            if (type == null) {
                $$$reportNull$$$0(12);
            }
            return type;
        } catch (SubstitutionException e16) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, e16.getMessage());
            if (createErrorType == null) {
                $$$reportNull$$$0(13);
            }
            return createErrorType;
        }
    }

    @Nullable
    public KotlinType substitute(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(14);
        }
        if (variance == null) {
            $$$reportNull$$$0(15);
        }
        TypeProjection substitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
        if (substitute == null) {
            return null;
        }
        return substitute.getType();
    }

    @Nullable
    public TypeProjection substituteWithoutApproximation(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(17);
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return unsafeSubstitute(typeProjection, null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(6);
        }
        return create(TypeConstructorSubstitution.create(kotlinType.getConstructor(), kotlinType.getArguments()));
    }

    @NotNull
    public static Variance combine(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            $$$reportNull$$$0(38);
        }
        if (variance2 == null) {
            $$$reportNull$$$0(39);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                $$$reportNull$$$0(40);
            }
            return variance2;
        }
        if (variance2 == variance3) {
            if (variance == null) {
                $$$reportNull$$$0(41);
            }
            return variance;
        }
        if (variance == variance2) {
            if (variance2 == null) {
                $$$reportNull$$$0(42);
            }
            return variance2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
    }

    @Nullable
    public TypeProjection substitute(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(16);
        }
        TypeProjection substituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
        return (this.substitution.approximateCapturedTypes() || this.substitution.approximateContravariantCapturedTypes()) ? CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substituteWithoutApproximation, this.substitution.approximateContravariantCapturedTypes()) : substituteWithoutApproximation;
    }
}
