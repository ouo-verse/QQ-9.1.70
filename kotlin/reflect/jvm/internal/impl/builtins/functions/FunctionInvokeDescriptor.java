package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {

    @NotNull
    public static final Factory Factory = new Factory(null);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i3, TypeParameterDescriptor typeParameterDescriptor) {
            String lowerCase;
            String asString = typeParameterDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "typeParameter.name.asString()");
            if (Intrinsics.areEqual(asString, "T")) {
                lowerCase = WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE;
            } else if (Intrinsics.areEqual(asString, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = asString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name identifier = Name.identifier(lowerCase);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i3, empty, identifier, defaultType, false, false, false, null, NO_SOURCE);
        }

        @NotNull
        public final FunctionInvokeDescriptor create(@NotNull FunctionClassDescriptor functionClass, boolean z16) {
            List<ReceiverParameterDescriptor> emptyList;
            List<? extends TypeParameterDescriptor> emptyList2;
            Iterable<IndexedValue> withIndex;
            int collectionSizeOrDefault;
            Object last;
            boolean z17;
            Intrinsics.checkNotNullParameter(functionClass, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClass.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, z16, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClass.getThisAsReceiverParameter();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (((TypeParameterDescriptor) obj).getVariance() == Variance.IN_VARIANCE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    break;
                }
                arrayList.add(obj);
            }
            withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (IndexedValue indexedValue : withIndex) {
                arrayList2.add(FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (TypeParameterDescriptor) indexedValue.getValue()));
            }
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) declaredTypeParameters);
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, emptyList2, (List<ValueParameterDescriptor>) arrayList2, (KotlinType) ((TypeParameterDescriptor) last).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }

        Factory() {
        }
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        int collectionSizeOrDefault;
        boolean z16;
        Name name;
        List zip;
        boolean z17;
        int size = getValueParameters().size() - list.size();
        boolean z18 = true;
        if (size == 0) {
            List<ValueParameterDescriptor> valueParameters = getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
            zip = CollectionsKt___CollectionsKt.zip(list, valueParameters);
            List<Pair> list2 = zip;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (Pair pair : list2) {
                    if (!Intrinsics.areEqual((Name) pair.component1(), ((ValueParameterDescriptor) pair.component2()).getName())) {
                        z17 = false;
                        break;
                    }
                }
            }
            z17 = true;
            if (z17) {
                return this;
            }
        }
        List<ValueParameterDescriptor> valueParameters2 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "valueParameters");
        List<ValueParameterDescriptor> list3 = valueParameters2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ValueParameterDescriptor valueParameterDescriptor : list3) {
            Name name2 = valueParameterDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            int index = valueParameterDescriptor.getIndex();
            int i3 = index - size;
            if (i3 >= 0 && (name = list.get(i3)) != null) {
                name2 = name;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name2, index));
        }
        FunctionDescriptorImpl.CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        List<Name> list4 = list;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it = list4.iterator();
            while (it.hasNext()) {
                if (((Name) it.next()) == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            }
        }
        z18 = false;
        ?? original = newCopyBuilder.setHasSynthesizedParameterNames(z18).setValueParameters2((List<ValueParameterDescriptor>) arrayList).setOriginal((CallableMemberDescriptor) getOriginal());
        Intrinsics.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubst\u2026   .setOriginal(original)");
        FunctionDescriptor doSubstitute = super.doSubstitute(original);
        Intrinsics.checkNotNull(doSubstitute);
        return doSubstitute;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement source) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(source, "source");
        return new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    @Nullable
    public FunctionDescriptor doSubstitute(@NotNull FunctionDescriptorImpl.CopyConfiguration configuration) {
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.doSubstitute(configuration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        List<ValueParameterDescriptor> list = valueParameters;
        boolean z17 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
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
        if (z17) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        List<ValueParameterDescriptor> list2 = valueParameters2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            KotlinType type2 = ((ValueParameterDescriptor) it5.next()).getType();
            Intrinsics.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2));
        }
        return functionInvokeDescriptor.replaceParameterNames(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z16) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z16);
        setHasStableParameterNames(false);
    }
}
