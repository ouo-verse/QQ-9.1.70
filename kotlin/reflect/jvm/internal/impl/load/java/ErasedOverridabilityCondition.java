package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            try {
                iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor classDescriptor) {
        OverridingUtil.OverrideCompatibilityInfo.Result result;
        Sequence asSequence;
        Sequence map;
        Sequence plus;
        KotlinType kotlinType;
        List listOfNotNull;
        Sequence plus2;
        boolean z16;
        List<TypeParameterDescriptor> emptyList;
        boolean z17;
        Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof JavaMethodDescriptor) {
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) subDescriptor;
            Intrinsics.checkNotNullExpressionValue(javaMethodDescriptor.getTypeParameters(), "subDescriptor.typeParameters");
            if (!(!r0.isEmpty())) {
                OverridingUtil.OverrideCompatibilityInfo basicOverridabilityProblem = OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor);
                if (basicOverridabilityProblem != null) {
                    result = basicOverridabilityProblem.getResult();
                } else {
                    result = null;
                }
                if (result != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
                asSequence = CollectionsKt___CollectionsKt.asSequence(valueParameters);
                map = SequencesKt___SequencesKt.map(asSequence, new Function1<ValueParameterDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition$isOverridable$signatureTypes$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final KotlinType invoke(ValueParameterDescriptor valueParameterDescriptor) {
                        return valueParameterDescriptor.getType();
                    }
                });
                KotlinType returnType = javaMethodDescriptor.getReturnType();
                Intrinsics.checkNotNull(returnType);
                plus = SequencesKt___SequencesKt.plus((Sequence<? extends KotlinType>) ((Sequence<? extends Object>) map), returnType);
                ReceiverParameterDescriptor extensionReceiverParameter = javaMethodDescriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    kotlinType = extensionReceiverParameter.getType();
                } else {
                    kotlinType = null;
                }
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(kotlinType);
                plus2 = SequencesKt___SequencesKt.plus(plus, (Iterable) listOfNotNull);
                Iterator it = plus2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        KotlinType kotlinType2 = (KotlinType) it.next();
                        if ((!kotlinType2.getArguments().isEmpty()) && !(kotlinType2.unwrap() instanceof RawTypeImpl)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                CallableDescriptor substitute = superDescriptor.substitute(new RawSubstitution(null, 1, null).buildSubstitutor());
                if (substitute == null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                if (substitute instanceof SimpleFunctionDescriptor) {
                    SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) substitute;
                    Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor.getTypeParameters(), "erasedSuper.typeParameters");
                    if (!r0.isEmpty()) {
                        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        substitute = newCopyBuilder.setTypeParameters(emptyList).build();
                        Intrinsics.checkNotNull(substitute);
                    }
                }
                OverridingUtil.OverrideCompatibilityInfo.Result result2 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(substitute, subDescriptor, false).getResult();
                Intrinsics.checkNotNullExpressionValue(result2, "DEFAULT.isOverridableByW\u2026Descriptor, false).result");
                if (WhenMappings.$EnumSwitchMapping$0[result2.ordinal()] == 1) {
                    return ExternalOverridabilityCondition.Result.OVERRIDABLE;
                }
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
