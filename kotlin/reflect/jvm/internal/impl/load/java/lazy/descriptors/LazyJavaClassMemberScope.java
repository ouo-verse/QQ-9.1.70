package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LazyJavaClassMemberScope extends LazyJavaScope {

    @NotNull
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;

    @NotNull
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;

    @NotNull
    private final JavaClass jClass;

    @NotNull
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;

    @NotNull
    private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;

    @NotNull
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z16, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z16, (i3 & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i3, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType kotlinType3;
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = javaMethod.getName();
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(returnType)");
        boolean hasAnnotationParameterDefaultValue = javaMethod.getHasAnnotationParameterDefaultValue();
        if (kotlinType2 != null) {
            kotlinType3 = TypeUtils.makeNotNullable(kotlinType2);
        } else {
            kotlinType3 = null;
        }
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i3, empty, name, makeNotNullable, hasAnnotationParameterDefaultValue, false, false, kotlinType3, getC().getComponents().getSourceElementFactory().source(javaMethod)));
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z16) {
        List plus;
        int collectionSizeOrDefault;
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonSt\u2026.overridingUtil\n        )");
        if (!z16) {
            collection.addAll(resolveOverridesForNonStaticMembers);
            return;
        }
        Collection<? extends SimpleFunctionDescriptor> collection3 = resolveOverridesForNonStaticMembers;
        plus = CollectionsKt___CollectionsKt.plus((Collection) collection, (Iterable) collection3);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SimpleFunctionDescriptor resolvedOverride : collection3) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(resolvedOverride);
            if (simpleFunctionDescriptor == null) {
                Intrinsics.checkNotNullExpressionValue(resolvedOverride, "resolvedOverride");
            } else {
                Intrinsics.checkNotNullExpressionValue(resolvedOverride, "resolvedOverride");
                resolvedOverride = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(resolvedOverride, simpleFunctionDescriptor, plus);
            }
            arrayList.add(resolvedOverride);
        }
        collection.addAll(arrayList);
    }

    private final void addOverriddenSpecialMethods(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltinWithDifferentJvmName(simpleFunctionDescriptor, function1, name, collection));
            CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltInWithErasedValueParametersInJava(simpleFunctionDescriptor, function1, collection));
            CollectionsKt.addIfNotNull(collection3, obtainOverrideForSuspend(simpleFunctionDescriptor, function1));
        }
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor propertyDescriptor : set) {
            JavaPropertyDescriptor createPropertyDescriptorByMethods = createPropertyDescriptorByMethods(propertyDescriptor, function1);
            if (createPropertyDescriptorByMethods != null) {
                collection.add(createPropertyDescriptorByMethods);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    private final void computeAnnotationProperties(Name name, Collection<PropertyDescriptor> collection) {
        Object singleOrNull;
        singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(name));
        JavaMethod javaMethod = (JavaMethod) singleOrNull;
        if (javaMethod == null) {
            return;
        }
        collection.add(createPropertyDescriptorWithDefaultGetter$default(this, javaMethod, null, Modality.FINAL, 2, null));
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement) {
            Collection<KotlinType> mo1780getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1780getSupertypes();
            Intrinsics.checkNotNullExpressionValue(mo1780getSupertypes, "ownerDescriptor.typeConstructor.supertypes");
            return mo1780getSupertypes;
        }
        return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        Object firstOrNull;
        Pair pair;
        Collection<JavaMethod> methods = this.jClass.getMethods();
        ArrayList arrayList = new ArrayList(methods.size());
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : methods) {
            if (Intrinsics.areEqual(((JavaMethod) obj).getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<JavaMethod> list2 = (List) pair2.component2();
        list.size();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        JavaMethod javaMethod = (JavaMethod) firstOrNull;
        int i3 = 1;
        if (javaMethod != null) {
            JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof JavaArrayType) {
                JavaArrayType javaArrayType = (JavaArrayType) returnType;
                pair = new Pair(getC().getTypeResolver().transformArrayType(javaArrayType, attributes$default, true), getC().getTypeResolver().transformJavaType(javaArrayType.getComponentType(), attributes$default));
            } else {
                pair = new Pair(getC().getTypeResolver().transformJavaType(returnType, attributes$default), null);
            }
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, 0, javaMethod, (KotlinType) pair.component1(), (KotlinType) pair.component2());
        }
        int i16 = 0;
        if (javaMethod == null) {
            i3 = 0;
        }
        for (JavaMethod javaMethod2 : list2) {
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, i16 + i3, javaMethod2, getC().getTypeResolver().transformJavaType(javaMethod2.getReturnType(), attributes$default), null);
            i16++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassConstructorDescriptor createDefaultConstructor() {
        List<ValueParameterDescriptor> emptyList;
        boolean isAnnotationType = this.jClass.isAnnotationType();
        if ((this.jClass.isInterface() || !this.jClass.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n \u2026.source(jClass)\n        )");
        if (isAnnotationType) {
            emptyList = createAnnotationConstructorParameters(createJavaConstructor);
        } else {
            emptyList = Collections.emptyList();
        }
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(emptyList, getConstructorVisibility(ownerDescriptor));
        createJavaConstructor.setHasStableParameterNames(true);
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, createJavaConstructor);
        return createJavaConstructor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n \u2026.source(jClass)\n        )");
        List<ValueParameterDescriptor> createRecordConstructorParameters = createRecordConstructorParameters(createJavaConstructor);
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(createRecordConstructorParameters, getConstructorVisibility(ownerDescriptor));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        return createJavaConstructor;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z16;
        Collection<? extends SimpleFunctionDescriptor> collection2 = collection;
        boolean z17 = true;
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
                if (!Intrinsics.areEqual(simpleFunctionDescriptor, simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && doesOverride(simpleFunctionDescriptor2, callableDescriptor)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = false;
                    break;
                }
            }
        }
        if (!z17) {
            SimpleFunctionDescriptor build = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
            Intrinsics.checkNotNull(build);
            return build;
        }
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor functionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object obj;
        int collectionSizeOrDefault;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "overridden.name");
        Iterator<T> it = function1.invoke(name).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) obj, functionDescriptor)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "overridden.valueParameters");
        List<ValueParameterDescriptor> list = valueParameters;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList.add(((ValueParameterDescriptor) it5.next()).getType());
        }
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "override.valueParameters");
        newCopyBuilder.setValueParameters(UtilKt.copyValueParameters(arrayList, valueParameters2, functionDescriptor));
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        newCopyBuilder.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, Boolean.TRUE);
        return newCopyBuilder.build();
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        List<? extends TypeParameterDescriptor> emptyList;
        List<ReceiverParameterDescriptor> emptyList2;
        Object firstOrNull;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
        if (!doesClassOverridesProperty(propertyDescriptor, function1)) {
            return null;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        Intrinsics.checkNotNull(findGetterOverride);
        if (propertyDescriptor.isVar()) {
            simpleFunctionDescriptor = findSetterOverride(propertyDescriptor, function1);
            Intrinsics.checkNotNull(simpleFunctionDescriptor);
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor != null) {
            simpleFunctionDescriptor.getModality();
            findGetterOverride.getModality();
        }
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), findGetterOverride, simpleFunctionDescriptor, propertyDescriptor);
        KotlinType returnType = findGetterOverride.getReturnType();
        Intrinsics.checkNotNull(returnType);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        javaForKotlinOverridePropertyDescriptor.setType(returnType, emptyList, dispatchReceiverParameter, null, emptyList2);
        PropertyGetterDescriptorImpl createGetter = DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor, findGetterOverride.getAnnotations(), false, false, false, findGetterOverride.getSource());
        createGetter.setInitialSignatureDescriptor(findGetterOverride);
        createGetter.initialize(javaForKotlinOverridePropertyDescriptor.getType());
        Intrinsics.checkNotNullExpressionValue(createGetter, "createGetter(\n          \u2026escriptor.type)\n        }");
        if (simpleFunctionDescriptor != null) {
            List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) valueParameters);
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) firstOrNull;
            if (valueParameterDescriptor != null) {
                propertySetterDescriptorImpl = DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(simpleFunctionDescriptor);
            } else {
                throw new AssertionError("No parameter found for " + simpleFunctionDescriptor);
            }
        }
        javaForKotlinOverridePropertyDescriptor.initialize(createGetter, propertySetterDescriptorImpl);
        return javaForKotlinOverridePropertyDescriptor;
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod javaMethod, KotlinType kotlinType, Modality modality) {
        KotlinType kotlinType2;
        List<? extends TypeParameterDescriptor> emptyList;
        List<ReceiverParameterDescriptor> emptyList2;
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaMethod), modality, UtilsKt.toDescriptorVisibility(javaMethod.getVisibility()), false, javaMethod.getName(), getC().getComponents().getSourceElementFactory().source(javaMethod), false);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            owne\u2026inal = */ false\n        )");
        PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(create, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "createDefaultGetter(prop\u2026iptor, Annotations.EMPTY)");
        create.initialize(createDefaultGetter, null);
        if (kotlinType == null) {
            kotlinType2 = computeMethodReturnType(javaMethod, ContextKt.childForMethod$default(getC(), create, javaMethod, 0, 4, null));
        } else {
            kotlinType2 = kotlinType;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        create.setType(kotlinType2, emptyList, dispatchReceiverParameter, null, emptyList2);
        createDefaultGetter.initialize(kotlinType2);
        return create;
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        KotlinType kotlinType;
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator<JavaRecordComponent> it = recordComponents.iterator();
        int i3 = 0;
        while (true) {
            int i16 = i3;
            if (it.hasNext()) {
                i3 = i16 + 1;
                JavaRecordComponent next = it.next();
                KotlinType transformJavaType = getC().getTypeResolver().transformJavaType(next.getType(), attributes$default);
                if (next.isVararg()) {
                    kotlinType = getC().getComponents().getModule().getBuiltIns().getArrayElementType(transformJavaType);
                } else {
                    kotlinType = null;
                }
                arrayList.add(new ValueParameterDescriptorImpl(classConstructorDescriptorImpl, null, i16, Annotations.Companion.getEMPTY(), next.getName(), transformJavaType, false, false, false, kotlinType, getC().getComponents().getSourceElementFactory().source(next)));
            } else {
                return arrayList;
            }
        }
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor simpleFunctionDescriptor, Name name) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setName(name);
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Object lastOrNull;
        FqName fqName;
        List<ValueParameterDescriptor> dropLast;
        FqNameUnsafe fqNameUnsafe;
        List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) valueParameters);
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) lastOrNull;
        if (valueParameterDescriptor != null) {
            ClassifierDescriptor mo1779getDeclarationDescriptor = valueParameterDescriptor.getType().getConstructor().mo1779getDeclarationDescriptor();
            if (mo1779getDeclarationDescriptor != null && (fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(mo1779getDeclarationDescriptor)) != null) {
                if (!fqNameUnsafe.isSafe()) {
                    fqNameUnsafe = null;
                }
                if (fqNameUnsafe != null) {
                    fqName = fqNameUnsafe.toSafe();
                    if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
                        valueParameterDescriptor = null;
                    }
                    if (valueParameterDescriptor != null) {
                        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
                        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters2, "valueParameters");
                        dropLast = CollectionsKt___CollectionsKt.dropLast(valueParameters2, 1);
                        SimpleFunctionDescriptor build = newCopyBuilder.setValueParameters(dropLast).setReturnType(valueParameterDescriptor.getType().getArguments().get(0).getType()).build();
                        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = (SimpleFunctionDescriptorImpl) build;
                        if (simpleFunctionDescriptorImpl != null) {
                            simpleFunctionDescriptorImpl.setSuspend(true);
                        }
                        return build;
                    }
                }
            }
            fqName = null;
            if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
            }
            if (valueParameterDescriptor != null) {
            }
        }
        return null;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        SimpleFunctionDescriptor findSetterOverride = findSetterOverride(propertyDescriptor, function1);
        if (findGetterOverride == null) {
            return false;
        }
        if (!propertyDescriptor.isVar()) {
            return true;
        }
        if (findSetterOverride == null || findSetterOverride.getModality() != findGetterOverride.getModality()) {
            return false;
        }
        return true;
    }

    private final boolean doesOverride(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByW\u2026iptor, this, true).result");
        if (result == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor)) {
            return true;
        }
        return false;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        Name builtinFunctionNamesByJvmName = companion.getBuiltinFunctionNamesByJvmName(name);
        if (builtinFunctionNamesByJvmName == null) {
            return false;
        }
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(builtinFunctionNamesByJvmName);
        ArrayList arrayList = new ArrayList();
        for (Object obj : functionsFromSupertypes) {
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        SimpleFunctionDescriptor createRenamedCopy = createRenamedCopy(simpleFunctionDescriptor, builtinFunctionNamesByJvmName);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (doesOverrideRenamedDescriptor((SimpleFunctionDescriptor) it.next(), createRenamedCopy)) {
                return true;
            }
        }
        return false;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics.checkNotNullExpressionValue(functionDescriptor, "if (superDescriptor.isRe\u2026iginal else subDescriptor");
        return doesOverride(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z16;
        SimpleFunctionDescriptor createSuspendView = createSuspendView(simpleFunctionDescriptor);
        if (createSuspendView == null) {
            return false;
        }
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if ((functionsFromSupertypes instanceof Collection) && functionsFromSupertypes.isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : functionsFromSupertypes) {
            if (simpleFunctionDescriptor2.isSuspend() && doesOverride(createSuspendView, simpleFunctionDescriptor2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        boolean isSubtypeOf;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(getterName)");
        Iterator<T> it = function1.invoke(identifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null) {
                    isSubtypeOf = false;
                } else {
                    isSubtypeOf = kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType());
                }
                if (isSubtypeOf) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor propertyGetterDescriptor;
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String str = null;
        if (getter != null) {
            propertyGetterDescriptor = (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter);
        } else {
            propertyGetterDescriptor = null;
        }
        if (propertyGetterDescriptor != null) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor);
        }
        if (str != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), propertyGetterDescriptor)) {
            return findGetterByName(propertyDescriptor, str, function1);
        }
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return findGetterByName(propertyDescriptor, JvmAbi.getterName(asString), function1);
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        Object single;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(identifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                single = CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) single).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (Intrinsics.areEqual(visibility, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            DescriptorVisibility PROTECTED_AND_PACKAGE = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
            Intrinsics.checkNotNullExpressionValue(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
            return PROTECTED_AND_PACKAGE;
        }
        return visibility;
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name) {
        Collection<KotlinType> computeSupertypes = computeSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = computeSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name) {
        Set<PropertyDescriptor> set;
        int collectionSizeOrDefault;
        Collection<KotlinType> computeSupertypes = computeSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = computeSupertypes.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = ((KotlinType) it.next()).getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(contributedVariables, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = contributedVariables.iterator();
            while (it5.hasNext()) {
                arrayList2.add((PropertyDescriptor) it5.next());
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        return set;
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        if (!Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null)) || doesOverride(simpleFunctionDescriptor, functionDescriptor)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
    
        if (kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.isSetterName(r4) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[LOOP:1: B:32:0x0045->B:46:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isVisibleAsFunctionInCurrentClass(final SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z16;
        boolean z17;
        boolean z18;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "function.name");
        List<Name> propertyNamesCandidatesByAccessorName = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name);
        if (!(propertyNamesCandidatesByAccessorName instanceof Collection) || !propertyNamesCandidatesByAccessorName.isEmpty()) {
            Iterator<T> it = propertyNamesCandidatesByAccessorName.iterator();
            while (it.hasNext()) {
                Set<PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes((Name) it.next());
                if (!(propertiesFromSupertypes instanceof Collection) || !propertiesFromSupertypes.isEmpty()) {
                    for (PropertyDescriptor propertyDescriptor : propertiesFromSupertypes) {
                        if (doesClassOverridesProperty(propertyDescriptor, new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name accessorName) {
                                Collection searchMethodsByNameWithoutBuiltinMagic;
                                Collection searchMethodsInSupertypesWithoutBuiltinMagic;
                                List plus;
                                List listOf;
                                Intrinsics.checkNotNullParameter(accessorName, "accessorName");
                                if (Intrinsics.areEqual(SimpleFunctionDescriptor.this.getName(), accessorName)) {
                                    listOf = CollectionsKt__CollectionsJVMKt.listOf(SimpleFunctionDescriptor.this);
                                    return listOf;
                                }
                                searchMethodsByNameWithoutBuiltinMagic = this.searchMethodsByNameWithoutBuiltinMagic(accessorName);
                                searchMethodsInSupertypesWithoutBuiltinMagic = this.searchMethodsInSupertypesWithoutBuiltinMagic(accessorName);
                                plus = CollectionsKt___CollectionsKt.plus(searchMethodsByNameWithoutBuiltinMagic, (Iterable) searchMethodsInSupertypesWithoutBuiltinMagic);
                                return plus;
                            }
                        })) {
                            if (!propertyDescriptor.isVar()) {
                                String asString = simpleFunctionDescriptor.getName().asString();
                                Intrinsics.checkNotNullExpressionValue(asString, "function.name.asString()");
                            }
                            z16 = true;
                            if (!z16) {
                                z17 = true;
                                break;
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                }
                z17 = false;
                if (z17) {
                    z18 = true;
                    break;
                }
            }
        }
        z18 = false;
        if (z18) {
            return false;
        }
        if (!doesOverrideRenamedBuiltins(simpleFunctionDescriptor) && !shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(simpleFunctionDescriptor) && !doesOverrideSuspendFunction(simpleFunctionDescriptor)) {
            return true;
        }
        return false;
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null || (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltinFunctionWithErasedValueParametersInJava, function1)) == null) {
            return null;
        }
        if (!isVisibleAsFunctionInCurrentClass(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded)) {
            createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = null;
        }
        if (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded == null) {
            return null;
        }
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Name name, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor2);
        Intrinsics.checkNotNull(jvmMethodNameIfSpecial);
        Name identifier = Name.identifier(jvmMethodNameIfSpecial);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(nameInJava)");
        Iterator<? extends SimpleFunctionDescriptor> it = function1.invoke(identifier).iterator();
        while (it.hasNext()) {
            SimpleFunctionDescriptor createRenamedCopy = createRenamedCopy(it.next(), name);
            if (doesOverrideRenamedDescriptor(simpleFunctionDescriptor2, createRenamedCopy)) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createRenamedCopy, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (!simpleFunctionDescriptor.isSuspend()) {
            return null;
        }
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        Iterator<T> it = function1.invoke(name).iterator();
        while (it.hasNext()) {
            SimpleFunctionDescriptor createSuspendView = createSuspendView((SimpleFunctionDescriptor) it.next());
            if (createSuspendView == null || !doesOverride(createSuspendView, simpleFunctionDescriptor)) {
                createSuspendView = null;
            }
            if (createSuspendView != null) {
                return createSuspendView;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor javaConstructor) {
        int collectionSizeOrDefault;
        List<TypeParameterDescriptor> plus;
        ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaConstructor), false, getC().getComponents().getSourceElementFactory().source(javaConstructor));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n \u2026ce(constructor)\n        )");
        LazyJavaResolverContext childForMethod = ContextKt.childForMethod(getC(), createJavaConstructor, javaConstructor, ownerDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod, createJavaConstructor, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = ownerDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<TypeParameterDescriptor> list = declaredTypeParameters;
        List<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor resolveTypeParameter = childForMethod.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) it.next());
            Intrinsics.checkNotNull(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
        createJavaConstructor.initialize(resolveValueParameters.getDescriptors(), UtilsKt.toDescriptorVisibility(javaConstructor.getVisibility()), plus);
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setHasSynthesizedParameterNames(resolveValueParameters.getHasSynthesizedNames());
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        childForMethod.getComponents().getJavaResolverCache().recordConstructor(javaConstructor, createJavaConstructor);
        return createJavaConstructor;
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent javaRecordComponent) {
        List<ReceiverParameterDescriptor> emptyList;
        List<? extends TypeParameterDescriptor> emptyList2;
        List<ValueParameterDescriptor> emptyList3;
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaRecordComponent), javaRecordComponent.getName(), getC().getComponents().getSourceElementFactory().source(javaRecordComponent), true);
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n      \u2026omponent), true\n        )");
        KotlinType transformJavaType = getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null));
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        createJavaMethod.initialize(null, dispatchReceiverParameter, emptyList, emptyList2, emptyList3, transformJavaType, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        createJavaMethod.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(javaRecordComponent, createJavaMethod);
        return createJavaMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name) {
        int collectionSizeOrDefault;
        Collection<JavaMethod> findMethodsByName = getDeclaredMemberIndex().invoke().findMethodsByName(name);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(findMethodsByName, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = findMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(resolveMethodToFunctionDescriptor((JavaMethod) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name) {
        boolean z16;
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        ArrayList arrayList = new ArrayList();
        for (Object obj : functionsFromSupertypes) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            if (!SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return false;
        }
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = functionsFromSupertypes.iterator();
        while (it.hasNext()) {
            FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((SimpleFunctionDescriptor) it.next());
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                arrayList.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            if (hasSameJvmDescriptorButDoesNotOverride(simpleFunctionDescriptor, (FunctionDescriptor) it5.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Set<Name> plus;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        plus = SetsKt___SetsKt.plus((Set) this.nestedClassIndex.invoke(), (Iterable) this.enumEntryIndex.invoke().keySet());
        return plus;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ Set computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        return computeFunctionNames(descriptorKindFilter, (Function1<? super Name, Boolean>) function1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.jClass.isRecord() && getDeclaredMemberIndex().invoke().findRecordComponentByName(name) != null) {
            Collection<SimpleFunctionDescriptor> collection = result;
            boolean z16 = true;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                        z16 = false;
                        break;
                    }
                }
            }
            if (z16) {
                JavaRecordComponent findRecordComponentByName = getDeclaredMemberIndex().invoke().findRecordComponentByName(name);
                Intrinsics.checkNotNull(findRecordComponentByName);
                result.add(resolveRecordComponentToFunctionDescriptor(findRecordComponentByName));
            }
        }
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), name, result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        List emptyList;
        List plus;
        boolean z16;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if (!SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            if (!(functionsFromSupertypes instanceof Collection) || !functionsFromSupertypes.isEmpty()) {
                Iterator<T> it = functionsFromSupertypes.iterator();
                while (it.hasNext()) {
                    if (((FunctionDescriptor) it.next()).isSuspend()) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (z16) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : functionsFromSupertypes) {
                    if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                addFunctionFromSupertypes(result, name, arrayList, false);
                return;
            }
        }
        SmartSet create = SmartSet.Companion.create();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, functionsFromSupertypes, emptyList, getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonSt\u2026.overridingUtil\n        )");
        addOverriddenSpecialMethods(name, result, resolveOverridesForNonStaticMembers, result, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        addOverriddenSpecialMethods(name, result, resolveOverridesForNonStaticMembers, create, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : functionsFromSupertypes) {
            if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) obj2)) {
                arrayList2.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) create);
        addFunctionFromSupertypes(result, name, plus, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> result) {
        Set<? extends PropertyDescriptor> minus;
        Set plus;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.jClass.isAnnotationType()) {
            computeAnnotationProperties(name, result);
        }
        Set<PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes(name);
        if (propertiesFromSupertypes.isEmpty()) {
            return;
        }
        SmartSet.Companion companion = SmartSet.Companion;
        SmartSet create = companion.create();
        SmartSet create2 = companion.create();
        addPropertyOverrideByMethod(propertiesFromSupertypes, result, create, new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name it) {
                Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic;
                Intrinsics.checkNotNullParameter(it, "it");
                searchMethodsByNameWithoutBuiltinMagic = LazyJavaClassMemberScope.this.searchMethodsByNameWithoutBuiltinMagic(it);
                return searchMethodsByNameWithoutBuiltinMagic;
            }
        });
        minus = SetsKt___SetsKt.minus((Set) propertiesFromSupertypes, (Iterable) create);
        addPropertyOverrideByMethod(minus, create2, null, new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name it) {
                Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic;
                Intrinsics.checkNotNullParameter(it, "it");
                searchMethodsInSupertypesWithoutBuiltinMagic = LazyJavaClassMemberScope.this.searchMethodsInSupertypesWithoutBuiltinMagic(it);
                return searchMethodsInSupertypesWithoutBuiltinMagic;
            }
        });
        plus = SetsKt___SetsKt.plus((Set) propertiesFromSupertypes, (Iterable) create2);
        Collection<? extends PropertyDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, plus, result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonSt\u2026rridingUtil\n            )");
        result.addAll(resolveOverridesForNonStaticMembers);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        Collection<KotlinType> mo1780getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1780getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1780getSupertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = mo1780getSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1781getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        MemoizedFunctionToNullable<Name, ClassDescriptorBase> memoizedFunctionToNullable;
        ClassDescriptorBase invoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        mo1785recordLookup(name, location);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) getMainScope();
        if (lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.nestedClasses) == null || (invoke = memoizedFunctionToNullable.invoke(name)) == null) {
            return this.nestedClasses.invoke(name);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        mo1785recordLookup(name, location);
        return super.getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        mo1785recordLookup(name, location);
        return super.getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @Nullable
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass(javaMethodDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public void mo1785recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), location, getOwnerDescriptor(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod method, @NotNull List<? extends TypeParameterDescriptor> methodTypeParameters, @NotNull KotlinType returnType, @NotNull List<? extends ValueParameterDescriptor> valueParameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(methodTypeParameters, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
        SignaturePropagator.PropagatedSignature resolvePropagatedSignature = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(method, getOwnerDescriptor(), returnType, null, valueParameters, methodTypeParameters);
        Intrinsics.checkNotNullExpressionValue(resolvePropagatedSignature, "c.components.signaturePr\u2026dTypeParameters\n        )");
        KotlinType returnType2 = resolvePropagatedSignature.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType2, "propagated.returnType");
        KotlinType receiverType = resolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters2 = resolvePropagatedSignature.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "propagated.valueParameters");
        List<TypeParameterDescriptor> typeParameters = resolvePropagatedSignature.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "propagated.typeParameters");
        boolean hasStableParameterNames = resolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = resolvePropagatedSignature.getErrors();
        Intrinsics.checkNotNullExpressionValue(errors, "propagated.errors");
        return new LazyJavaScope.MethodSignatureData(returnType2, receiverType, valueParameters2, typeParameters, hasStableParameterNames, errors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(@NotNull final LazyJavaResolverContext c16, @NotNull ClassDescriptor ownerDescriptor, @NotNull JavaClass jClass, boolean z16, @Nullable LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(c16, lazyJavaClassMemberScope);
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.ownerDescriptor = ownerDescriptor;
        this.jClass = jClass;
        this.skipRefinement = z16;
        this.constructors = c16.getStorageManager().createLazyValue(new Function0<List<? extends ClassConstructorDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$constructors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v4, types: [java.util.Collection] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends ClassConstructorDescriptor> invoke() {
                JavaClass javaClass;
                JavaClass javaClass2;
                List<? extends ClassConstructorDescriptor> list;
                ClassConstructorDescriptor createDefaultConstructor;
                List listOfNotNull;
                ClassConstructorDescriptor createDefaultRecordConstructor;
                JavaClass javaClass3;
                JavaClassConstructorDescriptor resolveConstructor;
                javaClass = LazyJavaClassMemberScope.this.jClass;
                Collection<JavaConstructor> constructors = javaClass.getConstructors();
                ArrayList arrayList = new ArrayList(constructors.size());
                Iterator<JavaConstructor> it = constructors.iterator();
                while (it.hasNext()) {
                    resolveConstructor = LazyJavaClassMemberScope.this.resolveConstructor(it.next());
                    arrayList.add(resolveConstructor);
                }
                javaClass2 = LazyJavaClassMemberScope.this.jClass;
                if (javaClass2.isRecord()) {
                    createDefaultRecordConstructor = LazyJavaClassMemberScope.this.createDefaultRecordConstructor();
                    boolean z17 = false;
                    String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(createDefaultRecordConstructor, false, false, 2, null);
                    if (!arrayList.isEmpty()) {
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((ClassConstructorDescriptor) it5.next(), false, false, 2, null), computeJvmDescriptor$default)) {
                                break;
                            }
                        }
                    }
                    z17 = true;
                    if (z17) {
                        arrayList.add(createDefaultRecordConstructor);
                        JavaResolverCache javaResolverCache = c16.getComponents().getJavaResolverCache();
                        javaClass3 = LazyJavaClassMemberScope.this.jClass;
                        javaResolverCache.recordConstructor(javaClass3, createDefaultRecordConstructor);
                    }
                }
                c16.getComponents().getSyntheticPartsProvider().generateConstructors(LazyJavaClassMemberScope.this.getOwnerDescriptor(), arrayList);
                SignatureEnhancement signatureEnhancement = c16.getComponents().getSignatureEnhancement();
                LazyJavaResolverContext lazyJavaResolverContext = c16;
                LazyJavaClassMemberScope lazyJavaClassMemberScope2 = LazyJavaClassMemberScope.this;
                boolean isEmpty = arrayList.isEmpty();
                ArrayList arrayList2 = arrayList;
                if (isEmpty) {
                    createDefaultConstructor = lazyJavaClassMemberScope2.createDefaultConstructor();
                    listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(createDefaultConstructor);
                    arrayList2 = listOfNotNull;
                }
                list = CollectionsKt___CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, arrayList2));
                return list;
            }
        });
        this.nestedClassIndex = c16.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClassIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends Name> invoke() {
                JavaClass javaClass;
                Set<? extends Name> set;
                javaClass = LazyJavaClassMemberScope.this.jClass;
                set = CollectionsKt___CollectionsKt.toSet(javaClass.getInnerClassNames());
                return set;
            }
        });
        this.enumEntryIndex = c16.getStorageManager().createLazyValue(new Function0<Map<Name, ? extends JavaField>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$enumEntryIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Name, ? extends JavaField> invoke() {
                JavaClass javaClass;
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                javaClass = LazyJavaClassMemberScope.this.jClass;
                Collection<JavaField> fields = javaClass.getFields();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fields) {
                    if (((JavaField) obj).isEnumEntry()) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(((JavaField) obj2).getName(), obj2);
                }
                return linkedHashMap;
            }
        });
        this.nestedClasses = c16.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Name, ClassDescriptorBase>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final ClassDescriptorBase invoke(@NotNull Name name) {
                NotNullLazyValue notNullLazyValue;
                JavaClass javaClass;
                NotNullLazyValue notNullLazyValue2;
                Intrinsics.checkNotNullParameter(name, "name");
                notNullLazyValue = LazyJavaClassMemberScope.this.nestedClassIndex;
                if (!((Set) notNullLazyValue.invoke()).contains(name)) {
                    notNullLazyValue2 = LazyJavaClassMemberScope.this.enumEntryIndex;
                    JavaField javaField = (JavaField) ((Map) notNullLazyValue2.invoke()).get(name);
                    if (javaField == null) {
                        return null;
                    }
                    StorageManager storageManager = c16.getStorageManager();
                    final LazyJavaClassMemberScope lazyJavaClassMemberScope2 = LazyJavaClassMemberScope.this;
                    return EnumEntrySyntheticClassDescriptor.create(c16.getStorageManager(), LazyJavaClassMemberScope.this.getOwnerDescriptor(), name, storageManager.createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Set<? extends Name> invoke() {
                            Set<? extends Name> plus;
                            plus = SetsKt___SetsKt.plus((Set) LazyJavaClassMemberScope.this.getFunctionNames(), (Iterable) LazyJavaClassMemberScope.this.getVariableNames());
                            return plus;
                        }
                    }), LazyJavaAnnotationsKt.resolveAnnotations(c16, javaField), c16.getComponents().getSourceElementFactory().source(javaField));
                }
                JavaClassFinder finder = c16.getComponents().getFinder();
                ClassId classId = DescriptorUtilsKt.getClassId(LazyJavaClassMemberScope.this.getOwnerDescriptor());
                Intrinsics.checkNotNull(classId);
                ClassId createNestedClassId = classId.createNestedClassId(name);
                Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!\u2026createNestedClassId(name)");
                javaClass = LazyJavaClassMemberScope.this.jClass;
                JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, null, javaClass, 2, null));
                if (findClass == null) {
                    return null;
                }
                LazyJavaResolverContext lazyJavaResolverContext = c16;
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, LazyJavaClassMemberScope.this.getOwnerDescriptor(), findClass, null, 8, null);
                lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LinkedHashSet<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Collection<KotlinType> mo1780getSupertypes = getOwnerDescriptor().getTypeConstructor().mo1780getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1780getSupertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<Name> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = mo1780getSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        linkedHashSet.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        linkedHashSet.addAll(computeClassNames(kindFilter, function1));
        linkedHashSet.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor()));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, new Function1<JavaMember, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeMemberIndex$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull JavaMember it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!it.isStatic());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
