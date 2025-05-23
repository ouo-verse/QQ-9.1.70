package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    private KotlinType inType;
    private final boolean isStaticFinal;

    @Nullable
    private final Pair<CallableDescriptor.UserDataKey<?>, ?> singleUserData;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 21) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 21) {
            i16 = 3;
        } else {
            i16 = 2;
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
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i3 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = QQWinkConstants.TAB_ENHANCE;
        }
        switch (i3) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = OperateCustomButton.OPERATE_CREATE;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = QQWinkConstants.TAB_ENHANCE;
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i3 != 21) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaPropertyDescriptor(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z16, @NotNull Name name, @NotNull SourceElement sourceElement, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, boolean z17, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, descriptorVisibility, z16, name, kind, sourceElement, false, false, false, false, false, false);
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
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        if (kind == null) {
            $$$reportNull$$$0(6);
        }
        this.inType = null;
        this.isStaticFinal = z17;
        this.singleUserData = pair;
    }

    @NotNull
    public static JavaPropertyDescriptor create(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z16, @NotNull Name name, @NotNull SourceElement sourceElement, boolean z17) {
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
        if (sourceElement == null) {
            $$$reportNull$$$0(12);
        }
        return new JavaPropertyDescriptor(declarationDescriptor, annotations, modality, descriptorVisibility, z16, name, sourceElement, null, CallableMemberDescriptor.Kind.DECLARATION, z17, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    @NotNull
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull Name name, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (modality == null) {
            $$$reportNull$$$0(14);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(15);
        }
        if (kind == null) {
            $$$reportNull$$$0(16);
        }
        if (name == null) {
            $$$reportNull$$$0(17);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(18);
        }
        return new JavaPropertyDescriptor(declarationDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name, sourceElement, propertyDescriptor, kind, this.isStaticFinal, this.singleUserData);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    @NotNull
    public JavaCallableMemberDescriptor enhance(@Nullable KotlinType kotlinType, @NotNull List<KotlinType> list, @NotNull KotlinType kotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        PropertyDescriptor original;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable;
        List<ReceiverParameterDescriptor> emptyList;
        PropertySetterDescriptor setter;
        PropertyGetterDescriptor getter;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(20);
        }
        if (getOriginal() == this) {
            original = null;
        } else {
            original = getOriginal();
        }
        JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.isStaticFinal, pair);
        PropertyGetterDescriptorImpl getter2 = getGetter();
        if (getter2 != null) {
            Annotations annotations = getter2.getAnnotations();
            Modality modality = getter2.getModality();
            DescriptorVisibility visibility = getter2.getVisibility();
            boolean isDefault = getter2.isDefault();
            boolean isExternal = getter2.isExternal();
            boolean isInline = getter2.isInline();
            CallableMemberDescriptor.Kind kind = getKind();
            if (original == null) {
                getter = null;
            } else {
                getter = original.getGetter();
            }
            propertyGetterDescriptorImpl = r15;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = new PropertyGetterDescriptorImpl(javaPropertyDescriptor, annotations, modality, visibility, isDefault, isExternal, isInline, kind, getter, getter2.getSource());
            propertyGetterDescriptorImpl.setInitialSignatureDescriptor(getter2.getInitialSignatureDescriptor());
            propertyGetterDescriptorImpl.initialize(kotlinType2);
        } else {
            propertyGetterDescriptorImpl = null;
        }
        PropertySetterDescriptor setter2 = getSetter();
        if (setter2 != null) {
            Annotations annotations2 = setter2.getAnnotations();
            Modality modality2 = setter2.getModality();
            DescriptorVisibility visibility2 = setter2.getVisibility();
            boolean isDefault2 = setter2.isDefault();
            boolean isExternal2 = setter2.isExternal();
            boolean isInline2 = setter2.isInline();
            CallableMemberDescriptor.Kind kind2 = getKind();
            if (original == null) {
                setter = null;
            } else {
                setter = original.getSetter();
            }
            PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(javaPropertyDescriptor, annotations2, modality2, visibility2, isDefault2, isExternal2, isInline2, kind2, setter, setter2.getSource());
            propertySetterDescriptorImpl2.setInitialSignatureDescriptor(propertySetterDescriptorImpl2.getInitialSignatureDescriptor());
            propertySetterDescriptorImpl2.initialize(setter2.getValueParameters().get(0));
            propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
        } else {
            propertySetterDescriptorImpl = null;
        }
        javaPropertyDescriptor.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, getBackingField(), getDelegateField());
        javaPropertyDescriptor.setSetterProjectedOut(isSetterProjectedOut());
        Function0<NullableLazyValue<ConstantValue<?>>> function0 = this.compileTimeInitializerFactory;
        if (function0 != null) {
            javaPropertyDescriptor.setCompileTimeInitializer(this.compileTimeInitializer, function0);
        }
        javaPropertyDescriptor.setOverriddenDescriptors(getOverriddenDescriptors());
        if (kotlinType == null) {
            createExtensionReceiverParameterForCallable = null;
        } else {
            createExtensionReceiverParameterForCallable = DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, Annotations.Companion.getEMPTY());
        }
        List<TypeParameterDescriptor> typeParameters = getTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        javaPropertyDescriptor.setType(kotlinType2, typeParameters, dispatchReceiverParameter, createExtensionReceiverParameterForCallable, emptyList);
        return javaPropertyDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair = this.singleUserData;
        if (pair != null && pair.getFirst().equals(userDataKey)) {
            return (V) this.singleUserData.getSecond();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        KotlinType type = getType();
        if (this.isStaticFinal && ConstUtil.canBeUsedForConstVal(type) && (!TypeEnhancementKt.hasEnhancedNullability(type) || KotlinBuiltIns.isString(type))) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    public void setInType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(22);
        }
        this.inType = kotlinType;
    }
}
