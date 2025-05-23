package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SignatureEnhancement {

    @NotNull
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(@NotNull JavaTypeEnhancement typeEnhancement) {
        Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$containsFunctionN$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(UnwrappedType unwrappedType) {
                ClassifierDescriptor mo1779getDeclarationDescriptor = unwrappedType.getConstructor().mo1779getDeclarationDescriptor();
                if (mo1779getDeclarationDescriptor == null) {
                    return Boolean.FALSE;
                }
                Name name = mo1779getDeclarationDescriptor.getName();
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                return Boolean.valueOf(Intrinsics.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(mo1779getDeclarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
            }
        });
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z16, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z17, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        int collectionSizeOrDefault;
        SignatureParts signatureParts = new SignatureParts(annotated, z16, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, null);
        KotlinType invoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
        Collection<? extends CallableMemberDescriptor> collection = overriddenDescriptors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (CallableMemberDescriptor it : collection) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(function1.invoke(it));
        }
        return enhance(signatureParts, invoke, arrayList, typeEnhancementInfo, z17);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z16, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z17, Function1 function1, int i3, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z16, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i3 & 32) != 0 ? false : z17, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D d16, LazyJavaResolverContext lazyJavaResolverContext) {
        D d17;
        KotlinType kotlinType;
        JavaMethodDescriptor javaMethodDescriptor;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        boolean z16;
        int collectionSizeOrDefault;
        D d18;
        PropertyDescriptor propertyDescriptor;
        boolean z17;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        TypeEnhancementInfo typeEnhancementInfo;
        KotlinType enhance$default;
        KotlinType returnType;
        boolean z18;
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair;
        KotlinType kotlinType2;
        int collectionSizeOrDefault2;
        boolean z19;
        boolean z26;
        boolean z27;
        KotlinType type;
        TypeEnhancementInfo typeEnhancementInfo2;
        List<TypeEnhancementInfo> parametersInfo;
        Object orNull;
        D d19;
        ValueParameterDescriptor valueParameterDescriptor;
        boolean z28;
        if (!(d16 instanceof JavaCallableMemberDescriptor)) {
            return d16;
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d16;
        boolean z29 = true;
        if (javaCallableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && javaCallableMemberDescriptor.getOriginal().getOverriddenDescriptors().size() == 1) {
            return d16;
        }
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, getDefaultAnnotations(d16, lazyJavaResolverContext));
        if (d16 instanceof JavaPropertyDescriptor) {
            JavaPropertyDescriptor javaPropertyDescriptor = (JavaPropertyDescriptor) d16;
            PropertyGetterDescriptorImpl getter = javaPropertyDescriptor.getGetter();
            if (getter != null && !getter.isDefault()) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (z28) {
                PropertyGetterDescriptorImpl getter2 = javaPropertyDescriptor.getGetter();
                Intrinsics.checkNotNull(getter2);
                d17 = getter2;
                if (javaCallableMemberDescriptor.getExtensionReceiverParameter() == null) {
                    if (!(d17 instanceof FunctionDescriptor)) {
                        d19 = null;
                    } else {
                        d19 = d17;
                    }
                    FunctionDescriptor functionDescriptor = (FunctionDescriptor) d19;
                    if (functionDescriptor != null) {
                        valueParameterDescriptor = (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
                    } else {
                        valueParameterDescriptor = null;
                    }
                    kotlinType = enhanceValueParameter(d16, valueParameterDescriptor, copyWithNewDefaultTypeQualifiers, null, false, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final KotlinType invoke(@NotNull CallableMemberDescriptor it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
                            Intrinsics.checkNotNull(extensionReceiverParameter);
                            KotlinType type2 = extensionReceiverParameter.getType();
                            Intrinsics.checkNotNullExpressionValue(type2, "it.extensionReceiverParameter!!.type");
                            return type2;
                        }
                    });
                } else {
                    kotlinType = null;
                }
                if (!(d16 instanceof JavaMethodDescriptor)) {
                    javaMethodDescriptor = (JavaMethodDescriptor) d16;
                } else {
                    javaMethodDescriptor = null;
                }
                if (javaMethodDescriptor != null) {
                    SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                    DeclarationDescriptor containingDeclaration = javaMethodDescriptor.getContainingDeclaration();
                    Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    String signature = MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, (ClassDescriptor) containingDeclaration, MethodSignatureMappingKt.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null));
                    if (signature != null) {
                        predefinedFunctionEnhancementInfo = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(signature);
                        if (predefinedFunctionEnhancementInfo != null) {
                            predefinedFunctionEnhancementInfo.getParametersInfo().size();
                            javaCallableMemberDescriptor.getValueParameters().size();
                        }
                        if ((!UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState()) || copyWithNewDefaultTypeQualifiers.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters()) && UtilsKt.hasErasedValueParameters(d16)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        List<ValueParameterDescriptor> valueParameters = d17.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters, "annotationOwnerForMember.valueParameters");
                        List<ValueParameterDescriptor> list = valueParameters;
                        char c16 = '\n';
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (final ValueParameterDescriptor valueParameterDescriptor2 : list) {
                            if (predefinedFunctionEnhancementInfo != null && (parametersInfo = predefinedFunctionEnhancementInfo.getParametersInfo()) != null) {
                                orNull = CollectionsKt___CollectionsKt.getOrNull(parametersInfo, valueParameterDescriptor2.getIndex());
                                typeEnhancementInfo2 = (TypeEnhancementInfo) orNull;
                            } else {
                                typeEnhancementInfo2 = null;
                            }
                            ArrayList arrayList2 = arrayList;
                            arrayList2.add(enhanceValueParameter(d16, valueParameterDescriptor2, copyWithNewDefaultTypeQualifiers, typeEnhancementInfo2, z16, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final KotlinType invoke(@NotNull CallableMemberDescriptor it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    KotlinType type2 = it.getValueParameters().get(ValueParameterDescriptor.this.getIndex()).getType();
                                    Intrinsics.checkNotNullExpressionValue(type2, "it.valueParameters[p.index].type");
                                    return type2;
                                }
                            }));
                            arrayList = arrayList2;
                            c16 = '\n';
                        }
                        ArrayList arrayList3 = arrayList;
                        if (!(d16 instanceof PropertyDescriptor)) {
                            d18 = null;
                        } else {
                            d18 = d16;
                        }
                        propertyDescriptor = (PropertyDescriptor) d18;
                        if (propertyDescriptor == null && JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.FIELD;
                        } else {
                            annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
                        }
                        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = annotationQualifierApplicabilityType;
                        if (predefinedFunctionEnhancementInfo != null) {
                            typeEnhancementInfo = predefinedFunctionEnhancementInfo.getReturnTypeInfo();
                        } else {
                            typeEnhancementInfo = null;
                        }
                        enhance$default = enhance$default(this, d16, d17, true, copyWithNewDefaultTypeQualifiers, annotationQualifierApplicabilityType2, typeEnhancementInfo, false, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1
                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final KotlinType invoke(@NotNull CallableMemberDescriptor it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                KotlinType returnType2 = it.getReturnType();
                                Intrinsics.checkNotNull(returnType2);
                                return returnType2;
                            }
                        }, 32, null);
                        returnType = javaCallableMemberDescriptor.getReturnType();
                        Intrinsics.checkNotNull(returnType);
                        if (!containsFunctionN(returnType)) {
                            ReceiverParameterDescriptor extensionReceiverParameter = javaCallableMemberDescriptor.getExtensionReceiverParameter();
                            if (extensionReceiverParameter != null && (type = extensionReceiverParameter.getType()) != null) {
                                z26 = containsFunctionN(type);
                            } else {
                                z26 = false;
                            }
                            if (!z26) {
                                List<ValueParameterDescriptor> valueParameters2 = javaCallableMemberDescriptor.getValueParameters();
                                Intrinsics.checkNotNullExpressionValue(valueParameters2, "valueParameters");
                                List<ValueParameterDescriptor> list2 = valueParameters2;
                                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                    Iterator<T> it = list2.iterator();
                                    while (it.hasNext()) {
                                        KotlinType type2 = ((ValueParameterDescriptor) it.next()).getType();
                                        Intrinsics.checkNotNullExpressionValue(type2, "it.type");
                                        if (containsFunctionN(type2)) {
                                            z27 = true;
                                            break;
                                        }
                                    }
                                }
                                z27 = false;
                                if (!z27) {
                                    z18 = false;
                                    if (!z18) {
                                        pair = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d16));
                                    } else {
                                        pair = null;
                                    }
                                    if (kotlinType == null && enhance$default == null) {
                                        if (!arrayList3.isEmpty()) {
                                            Iterator it5 = arrayList3.iterator();
                                            while (it5.hasNext()) {
                                                if (((KotlinType) it5.next()) != null) {
                                                    z19 = true;
                                                } else {
                                                    z19 = false;
                                                }
                                                if (z19) {
                                                    break;
                                                }
                                            }
                                        }
                                        z29 = false;
                                        if (!z29 && pair == null) {
                                            return d16;
                                        }
                                    }
                                    if (kotlinType != null) {
                                        ReceiverParameterDescriptor extensionReceiverParameter2 = javaCallableMemberDescriptor.getExtensionReceiverParameter();
                                        if (extensionReceiverParameter2 != null) {
                                            kotlinType2 = extensionReceiverParameter2.getType();
                                        } else {
                                            kotlinType2 = null;
                                        }
                                    } else {
                                        kotlinType2 = kotlinType;
                                    }
                                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                                    ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
                                    int i3 = 0;
                                    for (Object obj : arrayList3) {
                                        int i16 = i3 + 1;
                                        if (i3 < 0) {
                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                        }
                                        KotlinType kotlinType3 = (KotlinType) obj;
                                        if (kotlinType3 == null) {
                                            kotlinType3 = javaCallableMemberDescriptor.getValueParameters().get(i3).getType();
                                            Intrinsics.checkNotNullExpressionValue(kotlinType3, "valueParameters[index].type");
                                        }
                                        arrayList4.add(kotlinType3);
                                        i3 = i16;
                                    }
                                    if (enhance$default == null) {
                                        enhance$default = javaCallableMemberDescriptor.getReturnType();
                                        Intrinsics.checkNotNull(enhance$default);
                                    }
                                    JavaCallableMemberDescriptor enhance = javaCallableMemberDescriptor.enhance(kotlinType2, arrayList4, enhance$default, pair);
                                    Intrinsics.checkNotNull(enhance, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                                    return enhance;
                                }
                            }
                        }
                        z18 = true;
                        if (!z18) {
                        }
                        if (kotlinType == null) {
                            if (!arrayList3.isEmpty()) {
                            }
                            z29 = false;
                            if (!z29) {
                                return d16;
                            }
                        }
                        if (kotlinType != null) {
                        }
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                        ArrayList arrayList42 = new ArrayList(collectionSizeOrDefault2);
                        int i36 = 0;
                        while (r3.hasNext()) {
                        }
                        if (enhance$default == null) {
                        }
                        JavaCallableMemberDescriptor enhance2 = javaCallableMemberDescriptor.enhance(kotlinType2, arrayList42, enhance$default, pair);
                        Intrinsics.checkNotNull(enhance2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                        return enhance2;
                    }
                }
                predefinedFunctionEnhancementInfo = null;
                if (predefinedFunctionEnhancementInfo != null) {
                }
                if (!UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState())) {
                }
                z16 = true;
                List<ValueParameterDescriptor> valueParameters3 = d17.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters3, "annotationOwnerForMember.valueParameters");
                List<ValueParameterDescriptor> list3 = valueParameters3;
                char c162 = '\n';
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
                while (r18.hasNext()) {
                }
                ArrayList arrayList32 = arrayList5;
                if (!(d16 instanceof PropertyDescriptor)) {
                }
                propertyDescriptor = (PropertyDescriptor) d18;
                if (propertyDescriptor == null) {
                }
                z17 = false;
                if (z17) {
                }
                AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType22 = annotationQualifierApplicabilityType;
                if (predefinedFunctionEnhancementInfo != null) {
                }
                enhance$default = enhance$default(this, d16, d17, true, copyWithNewDefaultTypeQualifiers, annotationQualifierApplicabilityType22, typeEnhancementInfo, false, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final KotlinType invoke(@NotNull CallableMemberDescriptor it6) {
                        Intrinsics.checkNotNullParameter(it6, "it");
                        KotlinType returnType2 = it6.getReturnType();
                        Intrinsics.checkNotNull(returnType2);
                        return returnType2;
                    }
                }, 32, null);
                returnType = javaCallableMemberDescriptor.getReturnType();
                Intrinsics.checkNotNull(returnType);
                if (!containsFunctionN(returnType)) {
                }
                z18 = true;
                if (!z18) {
                }
                if (kotlinType == null) {
                }
                if (kotlinType != null) {
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList32, 10);
                ArrayList arrayList422 = new ArrayList(collectionSizeOrDefault2);
                int i362 = 0;
                while (r3.hasNext()) {
                }
                if (enhance$default == null) {
                }
                JavaCallableMemberDescriptor enhance22 = javaCallableMemberDescriptor.enhance(kotlinType2, arrayList422, enhance$default, pair);
                Intrinsics.checkNotNull(enhance22, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                return enhance22;
            }
        }
        d17 = d16;
        if (javaCallableMemberDescriptor.getExtensionReceiverParameter() == null) {
        }
        if (!(d16 instanceof JavaMethodDescriptor)) {
        }
        if (javaMethodDescriptor != null) {
        }
        predefinedFunctionEnhancementInfo = null;
        if (predefinedFunctionEnhancementInfo != null) {
        }
        if (!UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState())) {
        }
        z16 = true;
        List<ValueParameterDescriptor> valueParameters32 = d17.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters32, "annotationOwnerForMember.valueParameters");
        List<ValueParameterDescriptor> list32 = valueParameters32;
        char c1622 = '\n';
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list32, 10);
        ArrayList arrayList52 = new ArrayList(collectionSizeOrDefault);
        while (r18.hasNext()) {
        }
        ArrayList arrayList322 = arrayList52;
        if (!(d16 instanceof PropertyDescriptor)) {
        }
        propertyDescriptor = (PropertyDescriptor) d18;
        if (propertyDescriptor == null) {
        }
        z17 = false;
        if (z17) {
        }
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType222 = annotationQualifierApplicabilityType;
        if (predefinedFunctionEnhancementInfo != null) {
        }
        enhance$default = enhance$default(this, d16, d17, true, copyWithNewDefaultTypeQualifiers, annotationQualifierApplicabilityType222, typeEnhancementInfo, false, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final KotlinType invoke(@NotNull CallableMemberDescriptor it6) {
                Intrinsics.checkNotNullParameter(it6, "it");
                KotlinType returnType2 = it6.getReturnType();
                Intrinsics.checkNotNull(returnType2);
                return returnType2;
            }
        }, 32, null);
        returnType = javaCallableMemberDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (!containsFunctionN(returnType)) {
        }
        z18 = true;
        if (!z18) {
        }
        if (kotlinType == null) {
        }
        if (kotlinType != null) {
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList322, 10);
        ArrayList arrayList4222 = new ArrayList(collectionSizeOrDefault2);
        int i3622 = 0;
        while (r3.hasNext()) {
        }
        if (enhance$default == null) {
        }
        JavaCallableMemberDescriptor enhance222 = javaCallableMemberDescriptor.enhance(kotlinType2, arrayList4222, enhance$default, pair);
        Intrinsics.checkNotNull(enhance222, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return enhance222;
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, TypeEnhancementInfo typeEnhancementInfo, boolean z16, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext lazyJavaResolverContext2;
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        if (valueParameterDescriptor != null && (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) != null) {
            lazyJavaResolverContext2 = copyWithNewDefaultTypeQualifiers;
        } else {
            lazyJavaResolverContext2 = lazyJavaResolverContext;
        }
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, lazyJavaResolverContext2, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z16, function1);
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d16, LazyJavaResolverContext lazyJavaResolverContext) {
        LazyJavaClassDescriptor lazyJavaClassDescriptor;
        boolean z16;
        int collectionSizeOrDefault;
        List<? extends AnnotationDescriptor> plus;
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier(d16);
        if (topLevelContainingClassifier == null) {
            return d16.getAnnotations();
        }
        List<JavaAnnotation> list = null;
        if (topLevelContainingClassifier instanceof LazyJavaClassDescriptor) {
            lazyJavaClassDescriptor = (LazyJavaClassDescriptor) topLevelContainingClassifier;
        } else {
            lazyJavaClassDescriptor = null;
        }
        if (lazyJavaClassDescriptor != null) {
            list = lazyJavaClassDescriptor.getModuleAnnotations();
        }
        List<JavaAnnotation> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return d16.getAnnotations();
        }
        List<JavaAnnotation> list3 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, (JavaAnnotation) it.next(), true));
        }
        Annotations.Companion companion = Annotations.Companion;
        plus = CollectionsKt___CollectionsKt.plus((Iterable) d16.getAnnotations(), (Iterable) arrayList);
        return companion.create(plus);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull LazyJavaResolverContext c16, @NotNull Collection<? extends D> platformSignatures) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), c16));
        }
        return arrayList;
    }

    @NotNull
    public final KotlinType enhanceSuperType(@NotNull KotlinType type, @NotNull LazyJavaResolverContext context) {
        List emptyList;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        SignatureParts signatureParts = new SignatureParts(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        KotlinType enhance$default = enhance$default(this, signatureParts, type, emptyList, null, false, 12, null);
        if (enhance$default != null) {
            return enhance$default;
        }
        return type;
    }

    @NotNull
    public final List<KotlinType> enhanceTypeParameterBounds(@NotNull TypeParameterDescriptor typeParameter, @NotNull List<? extends KotlinType> bounds, @NotNull LazyJavaResolverContext context) {
        int collectionSizeOrDefault;
        List emptyList;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(context, "context");
        List<? extends KotlinType> list = bounds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (KotlinType kotlinType : list) {
            if (!TypeUtilsKt.contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceTypeParameterBounds$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull UnwrappedType it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it instanceof RawType);
                }
            })) {
                SignatureParts signatureParts = new SignatureParts(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                KotlinType enhance$default = enhance$default(this, signatureParts, kotlinType, emptyList, null, false, 12, null);
                if (enhance$default != null) {
                    kotlinType = enhance$default;
                }
            }
            arrayList.add(kotlinType);
        }
        return arrayList;
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            typeEnhancementInfo = null;
        }
        TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo2, z16);
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z16) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z16), signatureParts.getSkipRawTypeArguments());
    }
}
