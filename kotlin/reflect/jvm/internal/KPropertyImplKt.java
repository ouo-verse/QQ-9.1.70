package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class KPropertyImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> accessor, boolean z16) {
        JvmFunctionSignature.KotlinFunction setterSignature;
        Method setterMethod;
        Caller instance;
        JvmProtoBuf.JvmMethodSignature setter;
        Method method;
        Caller caller;
        Method unboxMethod;
        if (KDeclarationContainerImpl.INSTANCE.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(accessor.getProperty().getSignature())) {
            return ThrowingCaller.INSTANCE;
        }
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(accessor.getProperty().getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            JvmProtoBuf.JvmPropertySignature signature = kotlinProperty.getSignature();
            if (z16) {
                if (signature.hasGetter()) {
                    setter = signature.getGetter();
                    if (setter == null) {
                        method = accessor.getProperty().getContainer().findMethodBySignature(kotlinProperty.getNameResolver().getString(setter.getName()), kotlinProperty.getNameResolver().getString(setter.getDesc()));
                    } else {
                        method = null;
                    }
                    if (method != null) {
                        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(accessor.getProperty().getDescriptor()) && Intrinsics.areEqual(accessor.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.INTERNAL)) {
                            Class<?> inlineClass = InlineClassAwareCallerKt.toInlineClass(accessor.getProperty().getDescriptor().getContainingDeclaration());
                            if (inlineClass != null && (unboxMethod = InlineClassAwareCallerKt.getUnboxMethod(inlineClass, accessor.getProperty().getDescriptor())) != null) {
                                if (accessor.isBound()) {
                                    instance = new InternalUnderlyingValOfInlineClass.Bound(unboxMethod, getBoundReceiver(accessor));
                                } else {
                                    instance = new InternalUnderlyingValOfInlineClass.Unbound(unboxMethod);
                                }
                            } else {
                                throw new KotlinReflectionInternalError("Underlying property of inline class " + accessor.getProperty() + " should have a field");
                            }
                        } else {
                            Field javaField = accessor.getProperty().getJavaField();
                            if (javaField != null) {
                                instance = computeCallerForAccessor$computeFieldCaller(accessor, z16, javaField);
                            } else {
                                throw new KotlinReflectionInternalError("No accessors or field is found for property " + accessor.getProperty());
                            }
                        }
                    } else {
                        if (!Modifier.isStatic(method.getModifiers())) {
                            if (accessor.isBound()) {
                                caller = new CallerImpl.Method.BoundInstance(method, getBoundReceiver(accessor));
                            } else {
                                caller = new CallerImpl.Method.Instance(method);
                            }
                        } else if (computeCallerForAccessor$isJvmStaticProperty(accessor)) {
                            if (accessor.isBound()) {
                                caller = new CallerImpl.Method.BoundJvmStaticInObject(method);
                            } else {
                                caller = new CallerImpl.Method.JvmStaticInObject(method);
                            }
                        } else if (accessor.isBound()) {
                            caller = new CallerImpl.Method.BoundStatic(method, getBoundReceiver(accessor));
                        } else {
                            caller = new CallerImpl.Method.Static(method);
                        }
                        instance = caller;
                    }
                }
                setter = null;
                if (setter == null) {
                }
                if (method != null) {
                }
            } else {
                if (signature.hasSetter()) {
                    setter = signature.getSetter();
                    if (setter == null) {
                    }
                    if (method != null) {
                    }
                }
                setter = null;
                if (setter == null) {
                }
                if (method != null) {
                }
            }
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
            instance = computeCallerForAccessor$computeFieldCaller(accessor, z16, ((JvmPropertySignature.JavaField) mapPropertySignature).getField());
        } else if (mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) {
            if (z16) {
                setterMethod = ((JvmPropertySignature.JavaMethodProperty) mapPropertySignature).getGetterMethod();
            } else {
                JvmPropertySignature.JavaMethodProperty javaMethodProperty = (JvmPropertySignature.JavaMethodProperty) mapPropertySignature;
                setterMethod = javaMethodProperty.getSetterMethod();
                if (setterMethod == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + javaMethodProperty.getGetterMethod());
                }
            }
            if (accessor.isBound()) {
                instance = new CallerImpl.Method.BoundInstance(setterMethod, getBoundReceiver(accessor));
            } else {
                instance = new CallerImpl.Method.Instance(setterMethod);
            }
        } else {
            if (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty) {
                if (z16) {
                    setterSignature = ((JvmPropertySignature.MappedKotlinProperty) mapPropertySignature).getGetterSignature();
                } else {
                    setterSignature = ((JvmPropertySignature.MappedKotlinProperty) mapPropertySignature).getSetterSignature();
                    if (setterSignature == null) {
                        throw new KotlinReflectionInternalError("No setter found for property " + accessor.getProperty());
                    }
                }
                Method findMethodBySignature = accessor.getProperty().getContainer().findMethodBySignature(setterSignature.getMethodName(), setterSignature.getMethodDesc());
                if (findMethodBySignature != null) {
                    Modifier.isStatic(findMethodBySignature.getModifiers());
                    if (accessor.isBound()) {
                        return new CallerImpl.Method.BoundInstance(findMethodBySignature, getBoundReceiver(accessor));
                    }
                    return new CallerImpl.Method.Instance(findMethodBySignature);
                }
                throw new KotlinReflectionInternalError("No accessor found for property " + accessor.getProperty());
            }
            throw new NoWhenBranchMatchedException();
        }
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(instance, accessor.getDescriptor(), false, 2, null);
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KPropertyImpl.Accessor<?, ?> accessor, boolean z16, Field field) {
        CallerImpl<Field> instance;
        if (!isJvmFieldPropertyInCompanionObject(accessor.getProperty().getDescriptor()) && Modifier.isStatic(field.getModifiers())) {
            if (computeCallerForAccessor$isJvmStaticProperty(accessor)) {
                if (z16) {
                    if (accessor.isBound()) {
                        return new CallerImpl.FieldGetter.BoundJvmStaticInObject(field);
                    }
                    return new CallerImpl.FieldGetter.JvmStaticInObject(field);
                }
                if (accessor.isBound()) {
                    instance = new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, computeCallerForAccessor$isNotNullProperty(accessor));
                } else {
                    instance = new CallerImpl.FieldSetter.JvmStaticInObject(field, computeCallerForAccessor$isNotNullProperty(accessor));
                }
            } else {
                if (z16) {
                    return new CallerImpl.FieldGetter.Static(field);
                }
                instance = new CallerImpl.FieldSetter.Static(field, computeCallerForAccessor$isNotNullProperty(accessor));
            }
        } else if (z16) {
            if (accessor.isBound()) {
                instance = new CallerImpl.FieldGetter.BoundInstance(field, getBoundReceiver(accessor));
            } else {
                return new CallerImpl.FieldGetter.Instance(field);
            }
        } else if (accessor.isBound()) {
            instance = new CallerImpl.FieldSetter.BoundInstance(field, computeCallerForAccessor$isNotNullProperty(accessor), getBoundReceiver(accessor));
        } else {
            instance = new CallerImpl.FieldSetter.Instance(field, computeCallerForAccessor$isNotNullProperty(accessor));
        }
        return instance;
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KPropertyImpl.Accessor<?, ?> accessor) {
        return accessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KPropertyImpl.Accessor<?, ?> accessor) {
        return !TypeUtils.isNullableType(accessor.getProperty().getDescriptor().getType());
    }

    @Nullable
    public static final Object getBoundReceiver(@NotNull KPropertyImpl.Accessor<?, ?> accessor) {
        Intrinsics.checkNotNullParameter(accessor, "<this>");
        return accessor.getProperty().getBoundReceiver();
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        if (!DescriptorUtils.isCompanionObject(containingDeclaration)) {
            return false;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if ((DescriptorUtils.isInterface(containingDeclaration2) || DescriptorUtils.isAnnotationClass(containingDeclaration2)) && (!(propertyDescriptor instanceof DeserializedPropertyDescriptor) || !JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) propertyDescriptor).getProto()))) {
            return false;
        }
        return true;
    }
}
