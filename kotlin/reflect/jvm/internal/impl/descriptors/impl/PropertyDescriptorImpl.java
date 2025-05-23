package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    private FieldDescriptor backingField;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private FieldDescriptor delegateField;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private PropertyGetterDescriptorImpl getter;
    private final boolean isActual;
    private final boolean isConst;
    private final boolean isDelegated;
    private final boolean isExpect;
    private final boolean isExternal;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final Modality modality;
    private final PropertyDescriptor original;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private List<TypeParameterDescriptor> typeParameters;
    private DescriptorVisibility visibility;

    /* loaded from: classes28.dex */
    public class CopyConfiguration {
        private ReceiverParameterDescriptor dispatchReceiverParameter;
        private CallableMemberDescriptor.Kind kind;
        private Modality modality;
        private Name name;
        private DeclarationDescriptor owner;
        private KotlinType returnType;
        private DescriptorVisibility visibility;
        private PropertyDescriptor original = null;
        private boolean preserveSourceElement = false;
        private TypeSubstitution substitution = TypeSubstitution.EMPTY;
        private boolean copyOverrides = true;
        private List<TypeParameterDescriptor> newTypeParameters = null;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 5 && i3 != 7 && i3 != 9 && i3 != 11 && i3 != 19 && i3 != 13 && i3 != 14 && i3 != 16 && i3 != 17) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 5 && i3 != 7 && i3 != 9 && i3 != 11 && i3 != 19 && i3 != 13 && i3 != 14 && i3 != 16 && i3 != 17) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 7) {
                                if (i3 != 9) {
                                    if (i3 != 11) {
                                        if (i3 != 19) {
                                            if (i3 != 13) {
                                                if (i3 != 14) {
                                                    if (i3 != 16) {
                                                        if (i3 != 17) {
                                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                                                        } else {
                                                            objArr[1] = "setCopyOverrides";
                                                        }
                                                    } else {
                                                        objArr[1] = "setSubstitution";
                                                    }
                                                } else {
                                                    objArr[1] = "setDispatchReceiverParameter";
                                                }
                                            } else {
                                                objArr[1] = "setTypeParameters";
                                            }
                                        } else {
                                            objArr[1] = "setName";
                                        }
                                    } else {
                                        objArr[1] = "setKind";
                                    }
                                } else {
                                    objArr[1] = "setVisibility";
                                }
                            } else {
                                objArr[1] = "setModality";
                            }
                        } else {
                            objArr[1] = "setReturnType";
                        }
                    } else {
                        objArr[1] = "setPreserveSourceElement";
                    }
                } else {
                    objArr[1] = "setOriginal";
                }
            } else {
                objArr[1] = "setOwner";
            }
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 5 || i3 == 7 || i3 == 9 || i3 == 11 || i3 == 19 || i3 == 13 || i3 == 14 || i3 == 16 || i3 == 17) {
                throw new IllegalStateException(format);
            }
        }

        public CopyConfiguration() {
            this.owner = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.modality = PropertyDescriptorImpl.this.getModality();
            this.visibility = PropertyDescriptorImpl.this.getVisibility();
            this.kind = PropertyDescriptorImpl.this.getKind();
            this.dispatchReceiverParameter = PropertyDescriptorImpl.this.dispatchReceiverParameter;
            this.name = PropertyDescriptorImpl.this.getName();
            this.returnType = PropertyDescriptorImpl.this.getType();
        }

        @Nullable
        public PropertyDescriptor build() {
            return PropertyDescriptorImpl.this.doSubstitute(this);
        }

        PropertyGetterDescriptor getOriginalGetter() {
            PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getGetter();
        }

        PropertySetterDescriptor getOriginalSetter() {
            PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getSetter();
        }

        @NotNull
        public CopyConfiguration setCopyOverrides(boolean z16) {
            this.copyOverrides = z16;
            return this;
        }

        @NotNull
        public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(10);
            }
            this.kind = kind;
            return this;
        }

        @NotNull
        public CopyConfiguration setModality(@NotNull Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(6);
            }
            this.modality = modality;
            return this;
        }

        @NotNull
        public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(0);
            }
            this.owner = declarationDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setSubstitution(@NotNull TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(15);
            }
            this.substitution = typeSubstitution;
            return this;
        }

        @NotNull
        public CopyConfiguration setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(8);
            }
            this.visibility = descriptorVisibility;
            return this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 28 && i3 != 38 && i3 != 39 && i3 != 41 && i3 != 42) {
            switch (i3) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i3 != 28 && i3 != 38 && i3 != 39 && i3 != 41 && i3 != 42) {
                switch (i3) {
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        break;
                    default:
                        i16 = 3;
                        break;
                }
                Object[] objArr = new Object[i16];
                switch (i3) {
                    case 1:
                    case 8:
                        objArr[0] = "annotations";
                        break;
                    case 2:
                    case 9:
                        objArr[0] = "modality";
                        break;
                    case 3:
                    case 10:
                    case 20:
                        objArr[0] = "visibility";
                        break;
                    case 4:
                    case 11:
                        objArr[0] = "name";
                        break;
                    case 5:
                    case 12:
                    case 35:
                        objArr[0] = "kind";
                        break;
                    case 6:
                    case 13:
                    case 37:
                        objArr[0] = "source";
                        break;
                    case 7:
                    default:
                        objArr[0] = "containingDeclaration";
                        break;
                    case 14:
                        objArr[0] = "inType";
                        break;
                    case 15:
                    case 17:
                        objArr[0] = "outType";
                        break;
                    case 16:
                    case 18:
                        objArr[0] = "typeParameters";
                        break;
                    case 19:
                        objArr[0] = "contextReceiverParameters";
                        break;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 28:
                    case 38:
                    case 39:
                    case 41:
                    case 42:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                        break;
                    case 27:
                        objArr[0] = "originalSubstitutor";
                        break;
                    case 29:
                        objArr[0] = "copyConfiguration";
                        break;
                    case 30:
                        objArr[0] = "substitutor";
                        break;
                    case 31:
                        objArr[0] = "accessorDescriptor";
                        break;
                    case 32:
                        objArr[0] = "newOwner";
                        break;
                    case 33:
                        objArr[0] = "newModality";
                        break;
                    case 34:
                        objArr[0] = "newVisibility";
                        break;
                    case 36:
                        objArr[0] = "newName";
                        break;
                    case 40:
                        objArr[0] = "overriddenDescriptors";
                        break;
                }
                if (i3 == 28) {
                    if (i3 != 38) {
                        if (i3 != 39) {
                            if (i3 != 41) {
                                if (i3 != 42) {
                                    switch (i3) {
                                        case 21:
                                            objArr[1] = "getTypeParameters";
                                            break;
                                        case 22:
                                            objArr[1] = "getContextReceiverParameters";
                                            break;
                                        case 23:
                                            objArr[1] = "getReturnType";
                                            break;
                                        case 24:
                                            objArr[1] = "getModality";
                                            break;
                                        case 25:
                                            objArr[1] = "getVisibility";
                                            break;
                                        case 26:
                                            objArr[1] = "getAccessors";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                                            break;
                                    }
                                } else {
                                    objArr[1] = "copy";
                                }
                            } else {
                                objArr[1] = "getOverriddenDescriptors";
                            }
                        } else {
                            objArr[1] = "getKind";
                        }
                    } else {
                        objArr[1] = "getOriginal";
                    }
                } else {
                    objArr[1] = "getSourceToUseForCopy";
                }
                switch (i3) {
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        objArr[2] = OperateCustomButton.OPERATE_CREATE;
                        break;
                    case 14:
                        objArr[2] = "setInType";
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        objArr[2] = "setType";
                        break;
                    case 20:
                        objArr[2] = "setVisibility";
                        break;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 28:
                    case 38:
                    case 39:
                    case 41:
                    case 42:
                        break;
                    case 27:
                        objArr[2] = "substitute";
                        break;
                    case 29:
                        objArr[2] = "doSubstitute";
                        break;
                    case 30:
                    case 31:
                        objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                        break;
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                        objArr[2] = "createSubstitutedCopy";
                        break;
                    case 40:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    default:
                        objArr[2] = "<init>";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 28 && i3 != 38 && i3 != 39 && i3 != 41 && i3 != 42) {
                    switch (i3) {
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
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
            if (i3 == 28) {
            }
            switch (i3) {
            }
            String format2 = String.format(str, objArr2);
            if (i3 != 28) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 28) {
            switch (i3) {
            }
            Object[] objArr22 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 28) {
            }
            switch (i3) {
            }
            String format22 = String.format(str, objArr22);
            if (i3 != 28) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        Object[] objArr222 = new Object[i16];
        switch (i3) {
        }
        if (i3 == 28) {
        }
        switch (i3) {
        }
        String format222 = String.format(str, objArr222);
        if (i3 != 28) {
        }
        throw new IllegalStateException(format222);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z16, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        super(declarationDescriptor, annotations, name, null, z16, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (modality == null) {
            $$$reportNull$$$0(2);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
        if (kind == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        this.overriddenProperties = null;
        this.contextReceiverParameters = Collections.emptyList();
        this.modality = modality;
        this.visibility = descriptorVisibility;
        this.original = propertyDescriptor == null ? this : propertyDescriptor;
        this.kind = kind;
        this.lateInit = z17;
        this.isConst = z18;
        this.isExpect = z19;
        this.isActual = z26;
        this.isExternal = z27;
        this.isDelegated = z28;
    }

    @NotNull
    public static PropertyDescriptorImpl create(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z16, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (modality == null) {
            $$$reportNull$$$0(9);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(10);
        }
        if (name == null) {
            $$$reportNull$$$0(11);
        }
        if (kind == null) {
            $$$reportNull$$$0(12);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(13);
        }
        return new PropertyDescriptorImpl(declarationDescriptor, null, annotations, modality, descriptorVisibility, z16, name, kind, sourceElement, z17, z18, z19, z26, z27, z28);
    }

    @NotNull
    private SourceElement getSourceToUseForCopy(boolean z16, @Nullable PropertyDescriptor propertyDescriptor) {
        SourceElement sourceElement;
        if (z16) {
            if (propertyDescriptor == null) {
                propertyDescriptor = getOriginal();
            }
            sourceElement = propertyDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(28);
        }
        return sourceElement;
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(@NotNull TypeSubstitutor typeSubstitutor, @NotNull PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(30);
        }
        if (propertyAccessorDescriptor == null) {
            $$$reportNull$$$0(31);
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        }
        return null;
    }

    private static DescriptorVisibility normalizeVisibility(DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind) {
        if (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(descriptorVisibility.normalize())) {
            return DescriptorVisibilities.INVISIBLE_FAKE;
        }
        return descriptorVisibility;
    }

    private static ReceiverParameterDescriptor substituteContextParameterDescriptor(TypeSubstitutor typeSubstitutor, PropertyDescriptor propertyDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        KotlinType substitute = typeSubstitutor.substitute(receiverParameterDescriptor.getType(), Variance.IN_VARIANCE);
        if (substitute == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(propertyDescriptor, new ContextReceiver(propertyDescriptor, substitute, receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static ReceiverParameterDescriptor substituteParameterDescriptor(TypeSubstitutor typeSubstitutor, PropertyDescriptor propertyDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        KotlinType substitute = typeSubstitutor.substitute(receiverParameterDescriptor.getType(), Variance.IN_VARIANCE);
        if (substitute == null) {
            return null;
        }
        return new ReceiverParameterDescriptorImpl(propertyDescriptor, new ExtensionReceiver(propertyDescriptor, substitute, receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d16) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d16);
    }

    @NotNull
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull Name name, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(32);
        }
        if (modality == null) {
            $$$reportNull$$$0(33);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(34);
        }
        if (kind == null) {
            $$$reportNull$$$0(35);
        }
        if (name == null) {
            $$$reportNull$$$0(36);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(37);
        }
        return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name, kind, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    @Nullable
    protected PropertyDescriptor doSubstitute(@NotNull CopyConfiguration copyConfiguration) {
        List<TypeParameterDescriptor> list;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        FieldDescriptorImpl fieldDescriptorImpl;
        Function0<NullableLazyValue<ConstantValue<?>>> function0;
        KotlinType kotlinType;
        if (copyConfiguration == null) {
            $$$reportNull$$$0(29);
        }
        PropertyDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(copyConfiguration.owner, copyConfiguration.modality, copyConfiguration.visibility, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, getSourceToUseForCopy(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        if (copyConfiguration.newTypeParameters != null) {
            list = copyConfiguration.newTypeParameters;
        } else {
            list = getTypeParameters();
        }
        ArrayList arrayList = new ArrayList(list.size());
        TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(list, copyConfiguration.substitution, createSubstitutedCopy, arrayList);
        KotlinType kotlinType2 = copyConfiguration.returnType;
        KotlinType substitute = substituteTypeParameters.substitute(kotlinType2, Variance.OUT_VARIANCE);
        FieldDescriptorImpl fieldDescriptorImpl2 = null;
        if (substitute == null) {
            return null;
        }
        KotlinType substitute2 = substituteTypeParameters.substitute(kotlinType2, Variance.IN_VARIANCE);
        if (substitute2 != null) {
            createSubstitutedCopy.setInType(substitute2);
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = copyConfiguration.dispatchReceiverParameter;
        if (receiverParameterDescriptor3 != null) {
            ReceiverParameterDescriptor substitute3 = receiverParameterDescriptor3.substitute(substituteTypeParameters);
            if (substitute3 == null) {
                return null;
            }
            receiverParameterDescriptor = substitute3;
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor4 = this.extensionReceiverParameter;
        if (receiverParameterDescriptor4 != null) {
            receiverParameterDescriptor2 = substituteParameterDescriptor(substituteTypeParameters, createSubstitutedCopy, receiverParameterDescriptor4);
        } else {
            receiverParameterDescriptor2 = null;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<ReceiverParameterDescriptor> it = this.contextReceiverParameters.iterator();
        while (it.hasNext()) {
            ReceiverParameterDescriptor substituteContextParameterDescriptor = substituteContextParameterDescriptor(substituteTypeParameters, createSubstitutedCopy, it.next());
            if (substituteContextParameterDescriptor != null) {
                arrayList2.add(substituteContextParameterDescriptor);
            }
        }
        createSubstitutedCopy.setType(substitute, arrayList, receiverParameterDescriptor, receiverParameterDescriptor2, arrayList2);
        if (this.getter == null) {
            propertyGetterDescriptorImpl = null;
        } else {
            propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(createSubstitutedCopy, this.getter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.getter.getVisibility(), copyConfiguration.kind), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalGetter(), SourceElement.NO_SOURCE);
        }
        if (propertyGetterDescriptorImpl != null) {
            KotlinType returnType = this.getter.getReturnType();
            propertyGetterDescriptorImpl.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(substituteTypeParameters, this.getter));
            if (returnType != null) {
                kotlinType = substituteTypeParameters.substitute(returnType, Variance.OUT_VARIANCE);
            } else {
                kotlinType = null;
            }
            propertyGetterDescriptorImpl.initialize(kotlinType);
        }
        if (this.setter == null) {
            propertySetterDescriptorImpl = null;
        } else {
            propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(createSubstitutedCopy, this.setter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.setter.getVisibility(), copyConfiguration.kind), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalSetter(), SourceElement.NO_SOURCE);
        }
        if (propertySetterDescriptorImpl != null) {
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, this.setter.getValueParameters(), substituteTypeParameters, false, false, null);
            if (substitutedValueParameters == null) {
                createSubstitutedCopy.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtilsKt.getBuiltIns(copyConfiguration.owner).getNothingType(), this.setter.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() == 1) {
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(substituteTypeParameters, this.setter));
                propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        FieldDescriptor fieldDescriptor = this.backingField;
        if (fieldDescriptor == null) {
            fieldDescriptorImpl = null;
        } else {
            fieldDescriptorImpl = new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), createSubstitutedCopy);
        }
        FieldDescriptor fieldDescriptor2 = this.delegateField;
        if (fieldDescriptor2 != null) {
            fieldDescriptorImpl2 = new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), createSubstitutedCopy);
        }
        createSubstitutedCopy.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, fieldDescriptorImpl, fieldDescriptorImpl2);
        if (copyConfiguration.copyOverrides) {
            SmartSet create = SmartSet.create();
            Iterator<? extends PropertyDescriptor> it5 = getOverriddenDescriptors().iterator();
            while (it5.hasNext()) {
                create.add(it5.next().substitute(substituteTypeParameters));
            }
            createSubstitutedCopy.setOverriddenDescriptors(create);
        }
        if (isConst() && (function0 = this.compileTimeInitializerFactory) != null) {
            createSubstitutedCopy.setCompileTimeInitializer(this.compileTimeInitializer, function0);
        }
        return createSubstitutedCopy;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.setter;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(22);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            $$$reportNull$$$0(39);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(24);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.overriddenProperties;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            $$$reportNull$$$0(41);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type == null) {
            $$$reportNull$$$0(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(25);
        }
        return descriptorVisibility;
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, null, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.isConst;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.lateInit;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @NotNull
    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration();
    }

    public void setInType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(14);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            $$$reportNull$$$0(40);
        }
        this.overriddenProperties = collection;
    }

    public void setSetterProjectedOut(boolean z16) {
        this.setterProjectedOut = z16;
    }

    public void setType(@NotNull KotlinType kotlinType, @NotNull List<? extends TypeParameterDescriptor> list, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<ReceiverParameterDescriptor> list2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(17);
        }
        if (list == null) {
            $$$reportNull$$$0(18);
        }
        if (list2 == null) {
            $$$reportNull$$$0(19);
        }
        setOutType(kotlinType);
        this.typeParameters = new ArrayList(list);
        this.extensionReceiverParameter = receiverParameterDescriptor2;
        this.dispatchReceiverParameter = receiverParameterDescriptor;
        this.contextReceiverParameters = list2;
    }

    public void setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(20);
        }
        this.visibility = descriptorVisibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z16) {
        PropertyDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setOriginal(null).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z16).build();
        if (build == null) {
            $$$reportNull$$$0(42);
        }
        return build;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor propertySetterDescriptor, @Nullable FieldDescriptor fieldDescriptor, @Nullable FieldDescriptor fieldDescriptor2) {
        this.getter = propertyGetterDescriptorImpl;
        this.setter = propertySetterDescriptor;
        this.backingField = fieldDescriptor;
        this.delegateField = fieldDescriptor2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public PropertyDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(27);
        }
        return typeSubstitutor.isEmpty() ? this : newCopyBuilder().setSubstitution(typeSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.original;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(38);
        }
        return original;
    }
}
