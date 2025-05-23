package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final boolean isPrimary;

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 21 && i3 != 27) {
            switch (i3) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i3 != 21 && i3 != 27) {
                switch (i3) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        i16 = 3;
                        break;
                }
                Object[] objArr = new Object[i16];
                switch (i3) {
                    case 1:
                    case 5:
                    case 8:
                    case 25:
                        objArr[0] = "annotations";
                        break;
                    case 2:
                    case 24:
                        objArr[0] = "kind";
                        break;
                    case 3:
                    case 6:
                    case 9:
                    case 26:
                        objArr[0] = "source";
                        break;
                    case 4:
                    case 7:
                    default:
                        objArr[0] = "containingDeclaration";
                        break;
                    case 10:
                    case 13:
                        objArr[0] = "unsubstitutedValueParameters";
                        break;
                    case 11:
                    case 14:
                        objArr[0] = "visibility";
                        break;
                    case 12:
                        objArr[0] = "typeParameterDescriptors";
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                    case 27:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                        break;
                    case 20:
                        objArr[0] = "originalSubstitutor";
                        break;
                    case 22:
                        objArr[0] = "overriddenDescriptors";
                        break;
                    case 23:
                        objArr[0] = "newOwner";
                        break;
                }
                if (i3 == 21) {
                    if (i3 != 27) {
                        switch (i3) {
                            case 15:
                            case 16:
                                objArr[1] = "calculateContextReceiverParameters";
                                break;
                            case 17:
                                objArr[1] = "getContainingDeclaration";
                                break;
                            case 18:
                                objArr[1] = "getConstructedClass";
                                break;
                            case 19:
                                objArr[1] = "getOriginal";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                                break;
                        }
                    } else {
                        objArr[1] = "copy";
                    }
                } else {
                    objArr[1] = "getOverriddenDescriptors";
                }
                switch (i3) {
                    case 4:
                    case 5:
                    case 6:
                        objArr[2] = OperateCustomButton.OPERATE_CREATE;
                        break;
                    case 7:
                    case 8:
                    case 9:
                        objArr[2] = "createSynthesized";
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        objArr[2] = "initialize";
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                    case 27:
                        break;
                    case 20:
                        objArr[2] = "substitute";
                        break;
                    case 22:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        objArr[2] = "createSubstitutedCopy";
                        break;
                    default:
                        objArr[2] = "<init>";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 21 && i3 != 27) {
                    switch (i3) {
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
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
            if (i3 == 21) {
            }
            switch (i3) {
            }
            String format2 = String.format(str, objArr2);
            if (i3 != 21) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 21) {
            switch (i3) {
            }
            Object[] objArr22 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 21) {
            }
            switch (i3) {
            }
            String format22 = String.format(str, objArr22);
            if (i3 != 21) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        Object[] objArr222 = new Object[i16];
        switch (i3) {
        }
        if (i3 == 21) {
        }
        switch (i3) {
        }
        String format222 = String.format(str, objArr222);
        if (i3 != 21) {
        }
        throw new IllegalStateException(format222);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassConstructorDescriptorImpl(@NotNull ClassDescriptor classDescriptor, @Nullable ConstructorDescriptor constructorDescriptor, @NotNull Annotations annotations, boolean z16, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations, SpecialNames.INIT, kind, sourceElement);
        if (classDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (kind == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.isPrimary = z16;
    }

    @NotNull
    private List<ReceiverParameterDescriptor> calculateContextReceiverParameters() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (!containingDeclaration.getContextReceivers().isEmpty()) {
            List<ReceiverParameterDescriptor> contextReceivers = containingDeclaration.getContextReceivers();
            if (contextReceivers == null) {
                $$$reportNull$$$0(15);
            }
            return contextReceivers;
        }
        List<ReceiverParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(16);
        }
        return emptyList;
    }

    @NotNull
    public static ClassConstructorDescriptorImpl create(@NotNull ClassDescriptor classDescriptor, @NotNull Annotations annotations, boolean z16, @NotNull SourceElement sourceElement) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        if (annotations == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        return new ClassConstructorDescriptorImpl(classDescriptor, null, annotations, z16, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d16) {
        return declarationDescriptorVisitor.visitConstructorDescriptor(this, d16);
    }

    @Nullable
    public ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (containingDeclaration.isInner()) {
            DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
            if (containingDeclaration2 instanceof ClassDescriptor) {
                return ((ClassDescriptor) containingDeclaration2).getThisAsReceiverParameter();
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (containingDeclaration == null) {
            $$$reportNull$$$0(18);
        }
        return containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            $$$reportNull$$$0(21);
        }
        return emptySet;
    }

    public ClassConstructorDescriptorImpl initialize(@NotNull List<ValueParameterDescriptor> list, @NotNull DescriptorVisibility descriptorVisibility, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(10);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(11);
        }
        if (list2 == null) {
            $$$reportNull$$$0(12);
        }
        super.initialize(null, calculateDispatchReceiverParameter(), calculateContextReceiverParameters(), list2, list, null, Modality.FINAL, descriptorVisibility);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return this.isPrimary;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(22);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    @NotNull
    public ClassConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(23);
        }
        if (kind == null) {
            $$$reportNull$$$0(24);
        }
        if (annotations == null) {
            $$$reportNull$$$0(25);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(26);
        }
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2 && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + kind);
        }
        return new ClassConstructorDescriptorImpl((ClassDescriptor) declarationDescriptor, this, annotations, this.isPrimary, kind2, sourceElement);
    }

    public ClassConstructorDescriptorImpl initialize(@NotNull List<ValueParameterDescriptor> list, @NotNull DescriptorVisibility descriptorVisibility) {
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(14);
        }
        initialize(list, descriptorVisibility, getContainingDeclaration().getDeclaredTypeParameters());
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public ClassConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z16) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.copy(declarationDescriptor, modality, descriptorVisibility, kind, z16);
        if (classConstructorDescriptor == null) {
            $$$reportNull$$$0(27);
        }
        return classConstructorDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.getContainingDeclaration();
        if (classDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        return classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @Nullable
    public ClassConstructorDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(20);
        }
        return (ClassConstructorDescriptor) super.substitute(typeSubstitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.getOriginal();
        if (classConstructorDescriptor == null) {
            $$$reportNull$$$0(19);
        }
        return classConstructorDescriptor;
    }
}
