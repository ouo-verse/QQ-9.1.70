package kotlin.reflect.jvm.internal;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 @*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004?@ABB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0011J\n\u00104\u001a\u0004\u0018\u000105H\u0004J\u0013\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\nH\u0096\u0002J(\u00108\u001a\u0004\u0018\u00010\n2\b\u00109\u001a\u0004\u0018\u0001052\b\u0010:\u001a\u0004\u0018\u00010\n2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0004J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\r0\r0\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010*R\u0013\u0010.\u001a\u0004\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00102\u00a8\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", ParseCommon.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateSource", "Ljava/lang/reflect/Member;", "equals", "other", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Object EXTENSION_PROPERTY_DELEGATE = new Object();

    @NotNull
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;

    @NotNull
    private final ReflectProperties.LazyVal<Field> _javaField;

    @NotNull
    private final KDeclarationContainerImpl container;

    @NotNull
    private final String name;

    @Nullable
    private final Object rawBoundReceiver;

    @NotNull
    private final String signature;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", ParseCommon.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @Nullable
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public abstract PropertyAccessorDescriptor getDescriptor();

        @NotNull
        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return KPropertyImpl.EXTENSION_PROPERTY_DELEGATE;
        }

        Companion() {
        }
    }

    KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.name = str;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        ReflectProperties.LazyVal<Field> lazy = ReflectProperties.lazy(new Function0<Field>(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$_javaField$1
            final /* synthetic */ KPropertyImpl<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Field invoke() {
                Class<?> enclosingClass;
                JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.this$0.getDescriptor());
                if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
                    JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
                    PropertyDescriptor descriptor = kotlinProperty.getDescriptor();
                    JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, kotlinProperty.getProto(), kotlinProperty.getNameResolver(), kotlinProperty.getTypeTable(), false, 8, null);
                    if (jvmFieldSignature$default == null) {
                        return null;
                    }
                    KCallableImpl kCallableImpl = this.this$0;
                    if (!DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) && !JvmProtoBufUtil.isMovedFromInterfaceCompanion(kotlinProperty.getProto())) {
                        DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                        enclosingClass = containingDeclaration instanceof ClassDescriptor ? UtilKt.toJavaClass((ClassDescriptor) containingDeclaration) : kCallableImpl.getContainer().getJClass();
                    } else {
                        enclosingClass = kCallableImpl.getContainer().getJClass().getEnclosingClass();
                    }
                    if (enclosingClass == null) {
                        return null;
                    }
                    try {
                        return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
                    } catch (NoSuchFieldException unused) {
                        return null;
                    }
                }
                if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
                    return ((JvmPropertySignature.JavaField) mapPropertySignature).getField();
                }
                if ((mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) || (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazy, "lazy {\n        when (val\u2026y -> null\n        }\n    }");
        this._javaField = lazy;
        ReflectProperties.LazySoftVal<PropertyDescriptor> lazySoft = ReflectProperties.lazySoft(propertyDescriptor, new Function0<PropertyDescriptor>(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$_descriptor$1
            final /* synthetic */ KPropertyImpl<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final PropertyDescriptor invoke() {
                return this.this$0.getContainer().findPropertyDescriptor(this.this$0.getName(), this.this$0.getSignature());
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft(descriptorIniti\u2026or(name, signature)\n    }");
        this._descriptor = lazySoft;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Member computeDelegateSource() {
        if (!getDescriptor().isDelegated()) {
            return null;
        }
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            if (kotlinProperty.getSignature().hasDelegateMethod()) {
                JvmProtoBuf.JvmMethodSignature delegateMethod = kotlinProperty.getSignature().getDelegateMethod();
                if (!delegateMethod.hasName() || !delegateMethod.hasDesc()) {
                    return null;
                }
                return getContainer().findMethodBySignature(kotlinProperty.getNameResolver().getString(delegateMethod.getName()), kotlinProperty.getNameResolver().getString(delegateMethod.getDesc()));
            }
        }
        return getJavaField();
    }

    public boolean equals(@Nullable Object other) {
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(other);
        if (asKPropertyImpl == null || !Intrinsics.areEqual(getContainer(), asKPropertyImpl.getContainer()) || !Intrinsics.areEqual(getName(), asKPropertyImpl.getName()) || !Intrinsics.areEqual(this.signature, asKPropertyImpl.signature) || !Intrinsics.areEqual(this.rawBoundReceiver, asKPropertyImpl.rawBoundReceiver)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object getDelegateImpl(@Nullable Member fieldOrMethod, @Nullable Object receiver1, @Nullable Object receiver2) {
        Object obj;
        boolean z16;
        boolean z17;
        AccessibleObject accessibleObject;
        try {
            Object obj2 = EXTENSION_PROPERTY_DELEGATE;
            if ((receiver1 != obj2 && receiver2 != obj2) || getDescriptor().getExtensionReceiverParameter() != null) {
                if (isBound()) {
                    obj = getBoundReceiver();
                } else {
                    obj = receiver1;
                }
                if (obj != obj2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    obj = null;
                }
                if (!isBound()) {
                    receiver1 = receiver2;
                }
                if (receiver1 != obj2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    receiver1 = null;
                }
                if (fieldOrMethod instanceof AccessibleObject) {
                    accessibleObject = (AccessibleObject) fieldOrMethod;
                } else {
                    accessibleObject = null;
                }
                if (accessibleObject != null) {
                    accessibleObject.setAccessible(KCallablesJvm.isAccessible(this));
                }
                if (fieldOrMethod == 0) {
                    return null;
                }
                if (fieldOrMethod instanceof Field) {
                    return ((Field) fieldOrMethod).get(obj);
                }
                if (fieldOrMethod instanceof Method) {
                    int length = ((Method) fieldOrMethod).getParameterTypes().length;
                    if (length != 0) {
                        if (length != 1) {
                            if (length == 2) {
                                Method method = (Method) fieldOrMethod;
                                Object[] objArr = new Object[2];
                                objArr[0] = obj;
                                if (receiver1 == null) {
                                    Class<?> cls = ((Method) fieldOrMethod).getParameterTypes()[1];
                                    Intrinsics.checkNotNullExpressionValue(cls, "fieldOrMethod.parameterTypes[1]");
                                    receiver1 = UtilKt.defaultPrimitiveValue(cls);
                                }
                                objArr[1] = receiver1;
                                return method.invoke(null, objArr);
                            }
                            throw new AssertionError("delegate method " + fieldOrMethod + " should take 0, 1, or 2 parameters");
                        }
                        Method method2 = (Method) fieldOrMethod;
                        Object[] objArr2 = new Object[1];
                        if (obj == null) {
                            Class<?> cls2 = ((Method) fieldOrMethod).getParameterTypes()[0];
                            Intrinsics.checkNotNullExpressionValue(cls2, "fieldOrMethod.parameterTypes[0]");
                            obj = UtilKt.defaultPrimitiveValue(cls2);
                        }
                        objArr2[0] = obj;
                        return method2.invoke(null, objArr2);
                    }
                    return ((Method) fieldOrMethod).invoke(null, new Object[0]);
                }
                throw new AssertionError("delegate field/method " + fieldOrMethod + " neither field nor method");
            }
            throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
        } catch (IllegalAccessException e16) {
            throw new IllegalPropertyDelegateAccessException(e16);
        }
    }

    @NotNull
    public abstract Getter<V> getGetter();

    @Nullable
    public final Field getJavaField() {
        return this._javaField.invoke();
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class Getter<V> extends Accessor<V, V> implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* renamed from: descriptor$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor = ReflectProperties.lazySoft(new Function0<PropertyGetterDescriptor>(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$descriptor$2
            final /* synthetic */ KPropertyImpl.Getter<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final PropertyGetterDescriptor invoke() {
                PropertyGetterDescriptor getter = this.this$0.getProperty().getDescriptor().getGetter();
                return getter == null ? DescriptorFactory.createDefaultGetter(this.this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY()) : getter;
            }
        });

        /* renamed from: caller$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReflectProperties.LazyVal caller = ReflectProperties.lazy(new Function0<Caller<?>>(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$caller$2
            final /* synthetic */ KPropertyImpl.Getter<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Caller<?> invoke() {
                Caller<?> computeCallerForAccessor;
                computeCallerForAccessor = KPropertyImplKt.computeCallerForAccessor(this.this$0, true);
                return computeCallerForAccessor;
            }
        });

        public boolean equals(@Nullable Object other) {
            if ((other instanceof Getter) && Intrinsics.areEqual(getProperty(), ((Getter) other).getProperty())) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> getCaller() {
            T value = this.caller.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-caller>(...)");
            return (Caller) value;
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            return "<get-" + getProperty().getName() + Typography.greater;
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        @NotNull
        public String toString() {
            return "getter of " + getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public PropertyGetterDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-descriptor>(...)");
            return (PropertyGetterDescriptor) value;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class Setter<V> extends Accessor<V, Unit> implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* renamed from: descriptor$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor = ReflectProperties.lazySoft(new Function0<PropertySetterDescriptor>(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$descriptor$2
            final /* synthetic */ KPropertyImpl.Setter<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final PropertySetterDescriptor invoke() {
                PropertySetterDescriptor setter = this.this$0.getProperty().getDescriptor().getSetter();
                if (setter != null) {
                    return setter;
                }
                PropertyDescriptor descriptor = this.this$0.getProperty().getDescriptor();
                Annotations.Companion companion = Annotations.Companion;
                return DescriptorFactory.createDefaultSetter(descriptor, companion.getEMPTY(), companion.getEMPTY());
            }
        });

        /* renamed from: caller$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReflectProperties.LazyVal caller = ReflectProperties.lazy(new Function0<Caller<?>>(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$caller$2
            final /* synthetic */ KPropertyImpl.Setter<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Caller<?> invoke() {
                Caller<?> computeCallerForAccessor;
                computeCallerForAccessor = KPropertyImplKt.computeCallerForAccessor(this.this$0, false);
                return computeCallerForAccessor;
            }
        });

        public boolean equals(@Nullable Object other) {
            if ((other instanceof Setter) && Intrinsics.areEqual(getProperty(), ((Setter) other).getProperty())) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> getCaller() {
            T value = this.caller.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-caller>(...)");
            return (Caller) value;
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            return "<set-" + getProperty().getName() + Typography.greater;
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        @NotNull
        public String toString() {
            return "setter of " + getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public PropertySetterDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-descriptor>(...)");
            return (PropertySetterDescriptor) value;
        }
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor invoke = this._descriptor.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_descriptor()");
        return invoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        this(container, name, signature, null, obj);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KPropertyImpl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor) {
        this(container, r3, RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).getString(), descriptor, CallableReference.NO_RECEIVER);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String asString = descriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "descriptor.name.asString()");
    }
}
