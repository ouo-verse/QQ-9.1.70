package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean isForRecordComponent;
    private ParameterNamesStatus parameterNamesStatus;
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new CallableDescriptor.UserDataKey<ValueParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.1
    };
    public static final CallableDescriptor.UserDataKey<Boolean> HAS_ERASED_VALUE_PARAMETERS = new CallableDescriptor.UserDataKey<Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.2
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        ParameterNamesStatus(boolean z16, boolean z17) {
            this.isStable = z16;
            this.isSynthesized = z17;
        }

        @NotNull
        public static ParameterNamesStatus get(boolean z16, boolean z17) {
            ParameterNamesStatus parameterNamesStatus;
            if (z16) {
                if (z17) {
                    parameterNamesStatus = STABLE_SYNTHESIZED;
                } else {
                    parameterNamesStatus = STABLE_DECLARED;
                }
            } else if (z17) {
                parameterNamesStatus = NON_STABLE_SYNTHESIZED;
            } else {
                parameterNamesStatus = NON_STABLE_DECLARED;
            }
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 13 && i3 != 18 && i3 != 21) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 13 && i3 != 18 && i3 != 21) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i3 != 13) {
            if (i3 != 18) {
                if (i3 != 21) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                } else {
                    objArr[1] = QQWinkConstants.TAB_ENHANCE;
                }
            } else {
                objArr[1] = "createSubstitutedCopy";
            }
        } else {
            objArr[1] = "initialize";
        }
        switch (i3) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = QQWinkConstants.TAB_ENHANCE;
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i3 == 13 || i3 == 18 || i3 == 21) {
            throw new IllegalStateException(format);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected JavaMethodDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z16) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (kind == null) {
            $$$reportNull$$$0(3);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(4);
        }
        this.parameterNamesStatus = null;
        this.isForRecordComponent = z16;
    }

    @NotNull
    public static JavaMethodDescriptor createJavaMethod(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Name name, @NotNull SourceElement sourceElement, boolean z16) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        if (annotations == null) {
            $$$reportNull$$$0(6);
        }
        if (name == null) {
            $$$reportNull$$$0(7);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(8);
        }
        return new JavaMethodDescriptor(declarationDescriptor, null, annotations, name, CallableMemberDescriptor.Kind.DECLARATION, sourceElement, z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Pair pair) {
        return enhance(kotlinType, (List<KotlinType>) list, kotlinType2, (Pair<CallableDescriptor.UserDataKey<?>, ?>) pair);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.parameterNamesStatus.isStable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.parameterNamesStatus.isSynthesized;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl
    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<ReceiverParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, @NotNull List<ValueParameterDescriptor> list3, @Nullable KotlinType kotlinType, @Nullable Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @Nullable Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        if (list == null) {
            $$$reportNull$$$0(9);
        }
        if (list2 == null) {
            $$$reportNull$$$0(10);
        }
        if (list3 == null) {
            $$$reportNull$$$0(11);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(12);
        }
        SimpleFunctionDescriptorImpl initialize = super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
        setOperator(OperatorChecks.INSTANCE.check(initialize).isSuccess());
        if (initialize == null) {
            $$$reportNull$$$0(13);
        }
        return initialize;
    }

    public void setParameterNamesStatus(boolean z16, boolean z17) {
        this.parameterNamesStatus = ParameterNamesStatus.get(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    @NotNull
    public JavaMethodDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(14);
        }
        if (kind == null) {
            $$$reportNull$$$0(15);
        }
        if (annotations == null) {
            $$$reportNull$$$0(16);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(17);
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            name = getName();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement, this.isForRecordComponent);
        javaMethodDescriptor.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return javaMethodDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    @NotNull
    public JavaMethodDescriptor enhance(@Nullable KotlinType kotlinType, @NotNull List<KotlinType> list, @NotNull KotlinType kotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(20);
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(UtilKt.copyValueParameters(list, getValueParameters(), this)).setReturnType(kotlinType2).setExtensionReceiverParameter(kotlinType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, Annotations.Companion.getEMPTY())).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (pair != null) {
            javaMethodDescriptor.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        if (javaMethodDescriptor == null) {
            $$$reportNull$$$0(21);
        }
        return javaMethodDescriptor;
    }
}
