package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};

    @NotNull
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final LazyJavaResolverContext f412753c;

    @NotNull
    private final NotNullLazyValue classNamesLazy$delegate;

    @NotNull
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;

    @NotNull
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;

    @NotNull
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;

    @NotNull
    private final NotNullLazyValue functionNamesLazy$delegate;

    @NotNull
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;

    @Nullable
    private final LazyJavaScope mainScope;

    @NotNull
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;

    @NotNull
    private final NotNullLazyValue propertyNamesLazy$delegate;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    protected static final class MethodSignatureData {

        @NotNull
        private final List<String> errors;
        private final boolean hasStableParameterNames;

        @Nullable
        private final KotlinType receiverType;

        @NotNull
        private final KotlinType returnType;

        @NotNull
        private final List<TypeParameterDescriptor> typeParameters;

        @NotNull
        private final List<ValueParameterDescriptor> valueParameters;

        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(@NotNull KotlinType returnType, @Nullable KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> valueParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters, boolean z16, @NotNull List<String> errors) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
            Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.returnType = returnType;
            this.receiverType = kotlinType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters;
            this.hasStableParameterNames = z16;
            this.errors = errors;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
            if (Intrinsics.areEqual(this.returnType, methodSignatureData.returnType) && Intrinsics.areEqual(this.receiverType, methodSignatureData.receiverType) && Intrinsics.areEqual(this.valueParameters, methodSignatureData.valueParameters) && Intrinsics.areEqual(this.typeParameters, methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && Intrinsics.areEqual(this.errors, methodSignatureData.errors)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<String> getErrors() {
            return this.errors;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        @Nullable
        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        @NotNull
        public final KotlinType getReturnType() {
            return this.returnType;
        }

        @NotNull
        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.returnType.hashCode() * 31;
            KotlinType kotlinType = this.receiverType;
            if (kotlinType == null) {
                hashCode = 0;
            } else {
                hashCode = kotlinType.hashCode();
            }
            int hashCode3 = (((((hashCode2 + hashCode) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31;
            boolean z16 = this.hasStableParameterNames;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode3 + i3) * 31) + this.errors.hashCode();
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ResolvedValueParameters {

        @NotNull
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(@NotNull List<? extends ValueParameterDescriptor> descriptors, boolean z16) {
            Intrinsics.checkNotNullParameter(descriptors, "descriptors");
            this.descriptors = descriptors;
            this.hasSynthesizedNames = z16;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, (i3 & 2) != 0 ? null : lazyJavaScope);
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField javaField) {
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.f412753c, javaField), Modality.FINAL, UtilsKt.toDescriptorVisibility(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.f412753c.getComponents().getSourceElementFactory().source(javaField), isFinalStatic(javaField));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            owne\u2026d.isFinalStatic\n        )");
        return create;
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final KotlinType getPropertyType(JavaField javaField) {
        boolean z16;
        KotlinType transformJavaType = this.f412753c.getTypeResolver().transformJavaType(javaField.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if ((KotlinBuiltIns.isPrimitiveType(transformJavaType) || KotlinBuiltIns.isString(transformJavaType)) && isFinalStatic(javaField) && javaField.getHasConstantNotNullInitializer()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            KotlinType makeNotNullable = TypeUtils.makeNotNullable(transformJavaType);
            Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(propertyType)");
            return makeNotNullable;
        }
        return transformJavaType;
    }

    private final boolean isFinalStatic(JavaField javaField) {
        if (javaField.isFinal() && javaField.isStatic()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final PropertyDescriptor resolveProperty(final JavaField javaField) {
        List emptyList;
        List emptyList2;
        final PropertyDescriptorImpl createPropertyDescriptor = createPropertyDescriptor(javaField);
        createPropertyDescriptor.initialize(null, null, null, null);
        KotlinType propertyType = getPropertyType(javaField);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        createPropertyDescriptor.setType(propertyType, emptyList, dispatchReceiverParameter, null, emptyList2);
        if (DescriptorUtils.shouldRecordInitializerForProperty(createPropertyDescriptor, createPropertyDescriptor.getType())) {
            createPropertyDescriptor.setCompileTimeInitializerFactory(new Function0<NullableLazyValue<? extends ConstantValue<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final NullableLazyValue<? extends ConstantValue<?>> invoke() {
                    StorageManager storageManager = LazyJavaScope.this.getC().getStorageManager();
                    final LazyJavaScope lazyJavaScope = LazyJavaScope.this;
                    final JavaField javaField2 = javaField;
                    final PropertyDescriptorImpl propertyDescriptorImpl = createPropertyDescriptor;
                    return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final ConstantValue<?> invoke() {
                            return LazyJavaScope.this.getC().getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(javaField2, propertyDescriptorImpl);
                        }
                    });
                }
            });
        }
        this.f412753c.getComponents().getJavaResolverCache().recordField(javaField, createPropertyDescriptor);
        return createPropertyDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(computeJvmDescriptor$default);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(computeJvmDescriptor$default, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                List list2 = list;
                Collection<? extends SimpleFunctionDescriptor> selectMostSpecificInEachOverridableGroup = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(list2, new Function1<SimpleFunctionDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CallableDescriptor invoke(@NotNull SimpleFunctionDescriptor selectMostSpecificInEachOverridableGroup2) {
                        Intrinsics.checkNotNullParameter(selectMostSpecificInEachOverridableGroup2, "$this$selectMostSpecificInEachOverridableGroup");
                        return selectMostSpecificInEachOverridableGroup2;
                    }
                });
                set.removeAll(list2);
                set.addAll(selectMostSpecificInEachOverridableGroup);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<Name> computeClassNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        List<DeclarationDescriptor> list;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name : computeClassNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke(name).booleanValue()) {
                    CollectionsKt.addIfNotNull(linkedHashSet, mo1781getContributedClassifier(name, noLookupLocation));
                }
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name2 : computeFunctionNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke(name2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(name2, noLookupLocation));
                }
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name3 : computePropertyNames(kindFilter, nameFilter)) {
                if (nameFilter.invoke(name3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(name3, noLookupLocation));
                }
            }
        }
        list = CollectionsKt___CollectionsKt.toList(linkedHashSet);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    public void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract DeclaredMemberIndex computeMemberIndex();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final KotlinType computeMethodReturnType(@NotNull JavaMethod method, @NotNull LazyJavaResolverContext c16) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(c16, "c");
        return c16.getTypeResolver().transformJavaType(method.getReturnType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, method.getContainingClass().isAnnotationType(), false, null, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> collection);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<Name> computePropertyNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LazyJavaResolverContext getC() {
        return this.f412753c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return this.allDescriptors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        List emptyList;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        if (!getFunctionNames().contains(name)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return this.functions.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        List emptyList;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        if (!getVariableNames().contains(name)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return this.properties.invoke(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    @Nullable
    protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract DeclarationDescriptor getOwnerDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    @NotNull
    protected abstract MethodSignatureData resolveMethodSignature(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(@NotNull JavaMethod method) {
        boolean z16;
        int collectionSizeOrDefault;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        List<ReceiverParameterDescriptor> emptyList;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> emptyMap;
        Object first;
        Intrinsics.checkNotNullParameter(method, "method");
        Annotations resolveAnnotations = LazyJavaAnnotationsKt.resolveAnnotations(this.f412753c, method);
        DeclarationDescriptor ownerDescriptor = getOwnerDescriptor();
        Name name = method.getName();
        JavaSourceElement source = this.f412753c.getComponents().getSourceElementFactory().source(method);
        if (this.declaredMemberIndex.invoke().findRecordComponentByName(method.getName()) != null && method.getValueParameters().isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(ownerDescriptor, resolveAnnotations, name, source, z16);
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n      \u2026eters.isEmpty()\n        )");
        LazyJavaResolverContext childForMethod$default = ContextKt.childForMethod$default(this.f412753c, createJavaMethod, method, 0, 4, null);
        List<JavaTypeParameter> typeParameters = method.getTypeParameters();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10);
        List<? extends TypeParameterDescriptor> arrayList = new ArrayList<>(collectionSizeOrDefault);
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor resolveTypeParameter = childForMethod$default.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) it.next());
            Intrinsics.checkNotNull(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod$default, createJavaMethod, method.getValueParameters());
        MethodSignatureData resolveMethodSignature = resolveMethodSignature(method, arrayList, computeMethodReturnType(method, childForMethod$default), resolveValueParameters.getDescriptors());
        KotlinType receiverType = resolveMethodSignature.getReceiverType();
        if (receiverType != null) {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(createJavaMethod, receiverType, Annotations.Companion.getEMPTY());
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<TypeParameterDescriptor> typeParameters2 = resolveMethodSignature.getTypeParameters();
        List<ValueParameterDescriptor> valueParameters = resolveMethodSignature.getValueParameters();
        KotlinType returnType = resolveMethodSignature.getReturnType();
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, method.isAbstract(), !method.isFinal());
        DescriptorVisibility descriptorVisibility = UtilsKt.toDescriptorVisibility(method.getVisibility());
        if (resolveMethodSignature.getReceiverType() == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        } else {
            CallableDescriptor.UserDataKey<ValueParameterDescriptor> userDataKey = JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) resolveValueParameters.getDescriptors());
            emptyMap = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(userDataKey, first));
        }
        createJavaMethod.initialize(receiverParameterDescriptor2, dispatchReceiverParameter, emptyList, typeParameters2, valueParameters, returnType, convertFromFlags, descriptorVisibility, emptyMap);
        createJavaMethod.setParameterNamesStatus(resolveMethodSignature.getHasStableParameterNames(), resolveValueParameters.getHasSynthesizedNames());
        if (!resolveMethodSignature.getErrors().isEmpty()) {
            childForMethod$default.getComponents().getSignaturePropagator().reportSignatureErrors(createJavaMethod, resolveMethodSignature.getErrors());
        }
        return createJavaMethod;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ResolvedValueParameters resolveValueParameters(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull FunctionDescriptor function, @NotNull List<? extends JavaValueParameter> jValueParameters) {
        Iterable<IndexedValue> withIndex;
        int collectionSizeOrDefault;
        List list;
        Pair pair;
        Name name;
        LazyJavaResolverContext c16 = lazyJavaResolverContext;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(jValueParameters, "jValueParameters");
        withIndex = CollectionsKt___CollectionsKt.withIndex(jValueParameters);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        boolean z16 = false;
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            JavaValueParameter javaValueParameter = (JavaValueParameter) indexedValue.component2();
            Annotations resolveAnnotations = LazyJavaAnnotationsKt.resolveAnnotations(c16, javaValueParameter);
            JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
            JavaArrayType javaArrayType = null;
            if (javaValueParameter.isVararg()) {
                JavaType type = javaValueParameter.getType();
                if (type instanceof JavaArrayType) {
                    javaArrayType = (JavaArrayType) type;
                }
                if (javaArrayType != null) {
                    KotlinType transformArrayType = lazyJavaResolverContext.getTypeResolver().transformArrayType(javaArrayType, attributes$default, true);
                    pair = TuplesKt.to(transformArrayType, lazyJavaResolverContext.getModule().getBuiltIns().getArrayElementType(transformArrayType));
                } else {
                    throw new AssertionError("Vararg parameter should be an array: " + javaValueParameter);
                }
            } else {
                pair = TuplesKt.to(lazyJavaResolverContext.getTypeResolver().transformJavaType(javaValueParameter.getType(), attributes$default), null);
            }
            KotlinType kotlinType = (KotlinType) pair.component1();
            KotlinType kotlinType2 = (KotlinType) pair.component2();
            if (Intrinsics.areEqual(function.getName().asString(), "equals") && jValueParameters.size() == 1 && Intrinsics.areEqual(lazyJavaResolverContext.getModule().getBuiltIns().getNullableAnyType(), kotlinType)) {
                name = Name.identifier("other");
            } else {
                name = javaValueParameter.getName();
                if (name == null) {
                    z16 = true;
                }
                if (name == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append('p');
                    sb5.append(index);
                    name = Name.identifier(sb5.toString());
                    Intrinsics.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            }
            Name name2 = name;
            Intrinsics.checkNotNullExpressionValue(name2, "if (function.name.asStri\u2026(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(function, null, index, resolveAnnotations, name2, kotlinType, false, false, false, kotlinType2, lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaValueParameter)));
            arrayList = arrayList2;
            z16 = z16;
            c16 = lazyJavaResolverContext;
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return new ResolvedValueParameters(list, z16);
    }

    @NotNull
    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }

    public LazyJavaScope(@NotNull LazyJavaResolverContext c16, @Nullable LazyJavaScope lazyJavaScope) {
        List emptyList;
        Intrinsics.checkNotNullParameter(c16, "c");
        this.f412753c = c16;
        this.mainScope = lazyJavaScope;
        StorageManager storageManager = c16.getStorageManager();
        Function0<Collection<? extends DeclarationDescriptor>> function0 = new Function0<Collection<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$allDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends DeclarationDescriptor> invoke() {
                return LazyJavaScope.this.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
            }
        };
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.allDescriptors = storageManager.createRecursionTolerantLazyValue(function0, emptyList);
        this.declaredMemberIndex = c16.getStorageManager().createLazyValue(new Function0<DeclaredMemberIndex>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredMemberIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DeclaredMemberIndex invoke() {
                return LazyJavaScope.this.computeMemberIndex();
            }
        });
        this.declaredFunctions = c16.getStorageManager().createMemoizedFunction(new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredFunctions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                Intrinsics.checkNotNullParameter(name, "name");
                if (LazyJavaScope.this.getMainScope() != null) {
                    memoizedFunctionToNotNull = LazyJavaScope.this.getMainScope().declaredFunctions;
                    return (Collection) memoizedFunctionToNotNull.invoke(name);
                }
                ArrayList arrayList = new ArrayList();
                for (JavaMethod javaMethod : LazyJavaScope.this.getDeclaredMemberIndex().invoke().findMethodsByName(name)) {
                    JavaMethodDescriptor resolveMethodToFunctionDescriptor = LazyJavaScope.this.resolveMethodToFunctionDescriptor(javaMethod);
                    if (LazyJavaScope.this.isVisibleAsFunction(resolveMethodToFunctionDescriptor)) {
                        LazyJavaScope.this.getC().getComponents().getJavaResolverCache().recordMethod(javaMethod, resolveMethodToFunctionDescriptor);
                        arrayList.add(resolveMethodToFunctionDescriptor);
                    }
                }
                LazyJavaScope.this.computeImplicitlyDeclaredFunctions(arrayList, name);
                return arrayList;
            }
        });
        this.declaredField = c16.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Name, PropertyDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final PropertyDescriptor invoke(@NotNull Name name) {
                PropertyDescriptor resolveProperty;
                MemoizedFunctionToNullable memoizedFunctionToNullable;
                Intrinsics.checkNotNullParameter(name, "name");
                if (LazyJavaScope.this.getMainScope() != null) {
                    memoizedFunctionToNullable = LazyJavaScope.this.getMainScope().declaredField;
                    return (PropertyDescriptor) memoizedFunctionToNullable.invoke(name);
                }
                JavaField findFieldByName = LazyJavaScope.this.getDeclaredMemberIndex().invoke().findFieldByName(name);
                if (findFieldByName == null || findFieldByName.isEnumEntry()) {
                    return null;
                }
                resolveProperty = LazyJavaScope.this.resolveProperty(findFieldByName);
                return resolveProperty;
            }
        });
        this.functions = c16.getStorageManager().createMemoizedFunction(new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$functions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                List list;
                Intrinsics.checkNotNullParameter(name, "name");
                memoizedFunctionToNotNull = LazyJavaScope.this.declaredFunctions;
                LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) memoizedFunctionToNotNull.invoke(name));
                LazyJavaScope.this.retainMostSpecificMethods(linkedHashSet);
                LazyJavaScope.this.computeNonDeclaredFunctions(linkedHashSet, name);
                list = CollectionsKt___CollectionsKt.toList(LazyJavaScope.this.getC().getComponents().getSignatureEnhancement().enhanceSignatures(LazyJavaScope.this.getC(), linkedHashSet));
                return list;
            }
        });
        this.functionNamesLazy$delegate = c16.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$functionNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends Name> invoke() {
                return LazyJavaScope.this.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
            }
        });
        this.propertyNamesLazy$delegate = c16.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$propertyNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends Name> invoke() {
                return LazyJavaScope.this.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
            }
        });
        this.classNamesLazy$delegate = c16.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$classNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends Name> invoke() {
                return LazyJavaScope.this.computeClassNames(DescriptorKindFilter.CLASSIFIERS, null);
            }
        });
        this.properties = c16.getStorageManager().createMemoizedFunction(new Function1<Name, List<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$properties$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<PropertyDescriptor> invoke(@NotNull Name name) {
                MemoizedFunctionToNullable memoizedFunctionToNullable;
                List<PropertyDescriptor> list;
                List<PropertyDescriptor> list2;
                Intrinsics.checkNotNullParameter(name, "name");
                ArrayList arrayList = new ArrayList();
                memoizedFunctionToNullable = LazyJavaScope.this.declaredField;
                CollectionsKt.addIfNotNull(arrayList, memoizedFunctionToNullable.invoke(name));
                LazyJavaScope.this.computeNonDeclaredProperties(name, arrayList);
                if (DescriptorUtils.isAnnotationClass(LazyJavaScope.this.getOwnerDescriptor())) {
                    list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                    return list2;
                }
                list = CollectionsKt___CollectionsKt.toList(LazyJavaScope.this.getC().getComponents().getSignatureEnhancement().enhanceSignatures(LazyJavaScope.this.getC(), arrayList));
                return list;
            }
        });
    }
}
