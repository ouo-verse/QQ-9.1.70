package kotlin.reflect.jvm.internal.impl.types;

import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorType(ErrorTypeKind.DONT_CARE, new String[0]);
    public static final SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);

    @NotNull
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            String format;
            if (i3 != 1 && i3 != 4) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 1 && i3 != 4) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            objArr[0] = "newAttributes";
                        }
                    } else {
                        objArr[0] = "kotlinTypeRefiner";
                    }
                } else {
                    objArr[0] = "delegate";
                }
                if (i3 == 1) {
                    if (i3 != 4) {
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                    } else {
                        objArr[1] = "refine";
                    }
                } else {
                    objArr[1] = "toString";
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                objArr[2] = "replaceAttributes";
                            }
                        } else {
                            objArr[2] = "refine";
                        }
                    } else {
                        objArr[2] = "replaceDelegate";
                    }
                }
                format = String.format(str, objArr);
                if (i3 != 1 || i3 == 4) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            if (i3 == 1) {
            }
            if (i3 != 1) {
            }
            format = String.format(str, objArr);
            if (i3 != 1) {
            }
            throw new IllegalStateException(format);
        }

        public SpecialType(String str) {
            this.name = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        @NotNull
        protected SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        @NotNull
        public SpecialType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        @NotNull
        public DelegatingSimpleType replaceDelegate(@NotNull SimpleType simpleType) {
            if (simpleType == null) {
                $$$reportNull$$$0(2);
            }
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        @NotNull
        public String toString() {
            String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        @NotNull
        public SimpleType makeNullableAsSpecified(boolean z16) {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        @NotNull
        public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
            if (typeAttributes == null) {
                $$$reportNull$$$0(0);
            }
            throw new IllegalStateException(this.name);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 4 && i3 != 9 && i3 != 11 && i3 != 15 && i3 != 17 && i3 != 19 && i3 != 26 && i3 != 35 && i3 != 48 && i3 != 53 && i3 != 6 && i3 != 7) {
            switch (i3) {
                case 56:
                case 57:
                case 58:
                case 59:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i3 != 4 && i3 != 9 && i3 != 11 && i3 != 15 && i3 != 17 && i3 != 19 && i3 != 26 && i3 != 35 && i3 != 48 && i3 != 53 && i3 != 6 && i3 != 7) {
                switch (i3) {
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        break;
                    default:
                        i16 = 3;
                        break;
                }
                Object[] objArr = new Object[i16];
                switch (i3) {
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 48:
                    case 53:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                    case 5:
                    case 8:
                    case 10:
                    case 18:
                    case 23:
                    case 25:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 38:
                    case 40:
                    default:
                        objArr[0] = "type";
                        break;
                    case 12:
                        objArr[0] = "typeConstructor";
                        break;
                    case 13:
                        objArr[0] = "unsubstitutedMemberScope";
                        break;
                    case 14:
                        objArr[0] = "refinedTypeFactory";
                        break;
                    case 16:
                        objArr[0] = "parameters";
                        break;
                    case 20:
                        objArr[0] = QCircleLpReportDc010001.KEY_SUBTYPE;
                        break;
                    case 21:
                        objArr[0] = "superType";
                        break;
                    case 22:
                        objArr[0] = "substitutor";
                        break;
                    case 24:
                        objArr[0] = "result";
                        break;
                    case 31:
                    case 33:
                        objArr[0] = "clazz";
                        break;
                    case 32:
                        objArr[0] = "typeArguments";
                        break;
                    case 34:
                        objArr[0] = "projections";
                        break;
                    case 36:
                        objArr[0] = "a";
                        break;
                    case 37:
                        objArr[0] = "b";
                        break;
                    case 39:
                        objArr[0] = "typeParameters";
                        break;
                    case 41:
                        objArr[0] = "typeParameterConstructors";
                        break;
                    case 42:
                        objArr[0] = "specialType";
                        break;
                    case 43:
                    case 44:
                        objArr[0] = "isSpecialType";
                        break;
                    case 45:
                    case 46:
                        objArr[0] = "parameterDescriptor";
                        break;
                    case 47:
                    case 51:
                        objArr[0] = "numberValueTypeConstructor";
                        break;
                    case 49:
                    case 50:
                        objArr[0] = "supertypes";
                        break;
                    case 52:
                    case 55:
                        objArr[0] = "expectedType";
                        break;
                    case 54:
                        objArr[0] = "literalTypeConstructor";
                        break;
                }
                if (i3 == 4) {
                    if (i3 != 9) {
                        if (i3 != 11 && i3 != 15) {
                            if (i3 != 17) {
                                if (i3 != 19) {
                                    if (i3 != 26) {
                                        if (i3 != 35) {
                                            if (i3 != 48) {
                                                if (i3 != 53) {
                                                    if (i3 != 6 && i3 != 7) {
                                                        switch (i3) {
                                                            case 56:
                                                            case 57:
                                                            case 58:
                                                            case 59:
                                                                break;
                                                            default:
                                                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                                                                break;
                                                        }
                                                    }
                                                }
                                                objArr[1] = "getPrimitiveNumberType";
                                            } else {
                                                objArr[1] = "getDefaultPrimitiveNumberType";
                                            }
                                        } else {
                                            objArr[1] = "substituteProjectionsForParameters";
                                        }
                                    } else {
                                        objArr[1] = "getAllSupertypes";
                                    }
                                } else {
                                    objArr[1] = "getImmediateSupertypes";
                                }
                            } else {
                                objArr[1] = "getDefaultTypeProjections";
                            }
                        } else {
                            objArr[1] = "makeUnsubstitutedType";
                        }
                    }
                    objArr[1] = "makeNullableIfNeeded";
                } else {
                    objArr[1] = "makeNullableAsSpecified";
                }
                switch (i3) {
                    case 1:
                        objArr[2] = "makeNullable";
                        break;
                    case 2:
                        objArr[2] = "makeNotNullable";
                        break;
                    case 3:
                        objArr[2] = "makeNullableAsSpecified";
                        break;
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 48:
                    case 53:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        break;
                    case 5:
                    case 8:
                        objArr[2] = "makeNullableIfNeeded";
                        break;
                    case 10:
                        objArr[2] = "canHaveSubtypes";
                        break;
                    case 12:
                    case 13:
                    case 14:
                        objArr[2] = "makeUnsubstitutedType";
                        break;
                    case 16:
                        objArr[2] = "getDefaultTypeProjections";
                        break;
                    case 18:
                        objArr[2] = "getImmediateSupertypes";
                        break;
                    case 20:
                    case 21:
                    case 22:
                        objArr[2] = "createSubstitutedSupertype";
                        break;
                    case 23:
                    case 24:
                        objArr[2] = "collectAllSupertypes";
                        break;
                    case 25:
                        objArr[2] = "getAllSupertypes";
                        break;
                    case 27:
                        objArr[2] = "isNullableType";
                        break;
                    case 28:
                        objArr[2] = "acceptsNullable";
                        break;
                    case 29:
                        objArr[2] = "hasNullableSuperType";
                        break;
                    case 30:
                        objArr[2] = "getClassDescriptor";
                        break;
                    case 31:
                    case 32:
                        objArr[2] = "substituteParameters";
                        break;
                    case 33:
                    case 34:
                        objArr[2] = "substituteProjectionsForParameters";
                        break;
                    case 36:
                    case 37:
                        objArr[2] = "equalTypes";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "dependsOnTypeParameters";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "dependsOnTypeConstructors";
                        break;
                    case 42:
                    case 43:
                    case 44:
                        objArr[2] = "contains";
                        break;
                    case 45:
                    case 46:
                        objArr[2] = "makeStarProjection";
                        break;
                    case 47:
                    case 49:
                        objArr[2] = "getDefaultPrimitiveNumberType";
                        break;
                    case 50:
                        objArr[2] = "findByFqName";
                        break;
                    case 51:
                    case 52:
                    case 54:
                    case 55:
                        objArr[2] = "getPrimitiveNumberType";
                        break;
                    case 60:
                        objArr[2] = "isTypeParameter";
                        break;
                    case 61:
                        objArr[2] = "isReifiedTypeParameter";
                        break;
                    case 62:
                        objArr[2] = "isNonReifiedTypeParameter";
                        break;
                    case 63:
                        objArr[2] = "getTypeParameterDescriptorOrNull";
                        break;
                    default:
                        objArr[2] = "noExpectedType";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 4 && i3 != 9 && i3 != 11 && i3 != 15 && i3 != 17 && i3 != 19 && i3 != 26 && i3 != 35 && i3 != 48 && i3 != 53 && i3 != 6 && i3 != 7) {
                    switch (i3) {
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i16 = 2;
            Object[] objArr2 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 4) {
            }
            switch (i3) {
            }
            String format2 = String.format(str, objArr2);
            if (i3 != 4) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 4) {
            switch (i3) {
            }
            Object[] objArr22 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 4) {
            }
            switch (i3) {
            }
            String format22 = String.format(str, objArr22);
            if (i3 != 4) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        Object[] objArr222 = new Object[i16];
        switch (i3) {
        }
        if (i3 == 4) {
        }
        switch (i3) {
        }
        String format222 = String.format(str, objArr222);
        if (i3 != 4) {
        }
        throw new IllegalStateException(format222);
    }

    public static boolean acceptsNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType) && acceptsNullable(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        return false;
    }

    public static boolean contains(@Nullable KotlinType kotlinType, @NotNull Function1<UnwrappedType, Boolean> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(43);
        }
        return contains(kotlinType, function1, null);
    }

    @Nullable
    public static KotlinType createSubstitutedSupertype(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(20);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(21);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        KotlinType substitute = typeSubstitutor.substitute(kotlinType2, Variance.INVARIANT);
        if (substitute != null) {
            return makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    @Nullable
    public static ClassDescriptor getClassDescriptor(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(30);
        }
        ClassifierDescriptor mo1779getDeclarationDescriptor = kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo1779getDeclarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static List<TypeProjection> getDefaultTypeProjections(@NotNull List<TypeParameterDescriptor> list) {
        List<TypeProjection> list2;
        if (list == null) {
            $$$reportNull$$$0(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TypeProjectionImpl(it.next().getDefaultType()));
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        if (list2 == null) {
            $$$reportNull$$$0(17);
        }
        return list2;
    }

    @NotNull
    public static List<KotlinType> getImmediateSupertypes(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(18);
        }
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
        Collection<KotlinType> mo1780getSupertypes = kotlinType.getConstructor().mo1780getSupertypes();
        ArrayList arrayList = new ArrayList(mo1780getSupertypes.size());
        Iterator<KotlinType> it = mo1780getSupertypes.iterator();
        while (it.hasNext()) {
            KotlinType createSubstitutedSupertype = createSubstitutedSupertype(kotlinType, it.next(), create);
            if (createSubstitutedSupertype != null) {
                arrayList.add(createSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    @Nullable
    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(63);
        }
        if (kotlinType.getConstructor().mo1779getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().mo1779getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean hasNullableSuperType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(29);
        }
        if (kotlinType.getConstructor().mo1779getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        Iterator<KotlinType> it = getImmediateSupertypes(kotlinType).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDontCarePlaceholder(@Nullable KotlinType kotlinType) {
        if (kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor()) {
            return true;
        }
        return false;
    }

    public static boolean isNullableType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(27);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            return false;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        if (kotlinType instanceof AbstractStubType) {
            TypeParameterDescriptor originalTypeParameter = ((AbstractStubType) kotlinType).getOriginalTypeVariable().getOriginalTypeParameter();
            if (originalTypeParameter == null || hasNullableSuperType(originalTypeParameter.getDefaultType())) {
                return true;
            }
            return false;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = constructor.mo1780getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTypeParameter(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(60);
        }
        if (getTypeParameterDescriptorOrNull(kotlinType) == null && !(kotlinType.getConstructor() instanceof NewTypeVariableConstructor)) {
            return false;
        }
        return true;
    }

    @NotNull
    public static KotlinType makeNotNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(kotlinType, false);
    }

    @NotNull
    public static KotlinType makeNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(kotlinType, true);
    }

    @NotNull
    public static KotlinType makeNullableAsSpecified(@NotNull KotlinType kotlinType, boolean z16) {
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z16);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return makeNullableAsSpecified;
    }

    @NotNull
    public static SimpleType makeNullableIfNeeded(@NotNull SimpleType simpleType, boolean z16) {
        if (simpleType == null) {
            $$$reportNull$$$0(5);
        }
        if (!z16) {
            if (simpleType == null) {
                $$$reportNull$$$0(7);
            }
            return simpleType;
        }
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(6);
        }
        return makeNullableAsSpecified;
    }

    @NotNull
    public static TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    @NotNull
    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, classifierDescriptor.toString());
            if (createErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return createErrorType;
        }
        return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
    }

    public static boolean noExpectedType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType != NO_EXPECTED_TYPE && kotlinType != UNIT_EXPECTED_TYPE) {
            return false;
        }
        return true;
    }

    private static boolean contains(@Nullable KotlinType kotlinType, @NotNull Function1<UnwrappedType, Boolean> function1, SmartSet<KotlinType> smartSet) {
        if (function1 == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType == null) {
            return false;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (noExpectedType(kotlinType)) {
            return function1.invoke(unwrap).booleanValue();
        }
        if (smartSet != null && smartSet.contains(kotlinType)) {
            return false;
        }
        if (function1.invoke(unwrap).booleanValue()) {
            return true;
        }
        if (smartSet == null) {
            smartSet = SmartSet.create();
        }
        smartSet.add(kotlinType);
        FlexibleType flexibleType = unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
        if (flexibleType != null && (contains(flexibleType.getLowerBound(), function1, smartSet) || contains(flexibleType.getUpperBound(), function1, smartSet))) {
            return true;
        }
        if ((unwrap instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrap).getOriginal(), function1, smartSet)) {
            return true;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = ((IntersectionTypeConstructor) constructor).mo1780getSupertypes().iterator();
            while (it.hasNext()) {
                if (contains(it.next(), function1, smartSet)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection typeProjection : kotlinType.getArguments()) {
            if (!typeProjection.isStarProjection()) {
                if (contains(typeProjection.getType(), function1, smartSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public static TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(46);
        }
        if (erasureTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    @NotNull
    public static KotlinType makeNullableIfNeeded(@NotNull KotlinType kotlinType, boolean z16) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (z16) {
            return makeNullable(kotlinType);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        return kotlinType;
    }

    @NotNull
    public static SimpleType makeUnsubstitutedType(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
        }
        if (memberScope == null) {
            $$$reportNull$$$0(13);
        }
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope, function1);
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(15);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }
}
