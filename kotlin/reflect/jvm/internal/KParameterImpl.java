package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* renamed from: annotations$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReflectProperties.LazySoftVal annotations;

    @NotNull
    private final KCallableImpl<?> callable;

    /* renamed from: descriptor$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReflectProperties.LazySoftVal descriptor;
    private final int index;

    @NotNull
    private final KParameter.Kind kind;

    public KParameterImpl(@NotNull KCallableImpl<?> callable, int i3, @NotNull KParameter.Kind kind, @NotNull Function0<? extends ParameterDescriptor> computeDescriptor) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i3;
        this.kind = kind;
        this.descriptor = ReflectProperties.lazySoft(computeDescriptor);
        this.annotations = ReflectProperties.lazySoft(new Function0<List<? extends Annotation>>() { // from class: kotlin.reflect.jvm.internal.KParameterImpl$annotations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                ParameterDescriptor descriptor;
                descriptor = KParameterImpl.this.getDescriptor();
                return UtilKt.computeAnnotations(descriptor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParameterDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "<get-descriptor>(...)");
        return (ParameterDescriptor) value;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) other;
            if (Intrinsics.areEqual(this.callable, kParameterImpl.callable) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        T value = this.annotations.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "<get-annotations>(...)");
        return (List) value;
    }

    @NotNull
    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KParameter.Kind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.KParameter
    @Nullable
    public String getName() {
        ValueParameterDescriptor valueParameterDescriptor;
        ParameterDescriptor descriptor = getDescriptor();
        if (descriptor instanceof ValueParameterDescriptor) {
            valueParameterDescriptor = (ValueParameterDescriptor) descriptor;
        } else {
            valueParameterDescriptor = null;
        }
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KType getType() {
        KotlinType type = getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(type, "descriptor.type");
        return new KTypeImpl(type, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KParameterImpl$type$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Type invoke() {
                ParameterDescriptor descriptor;
                descriptor = KParameterImpl.this.getDescriptor();
                if ((descriptor instanceof ReceiverParameterDescriptor) && Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter(KParameterImpl.this.getCallable().getDescriptor()), descriptor) && KParameterImpl.this.getCallable().getDescriptor().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    DeclarationDescriptor containingDeclaration = KParameterImpl.this.getCallable().getDescriptor().getContainingDeclaration();
                    Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
                    if (javaClass != null) {
                        return javaClass;
                    }
                    throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + descriptor);
                }
                return KParameterImpl.this.getCallable().getCaller().getParameterTypes().get(KParameterImpl.this.getIndex());
            }
        });
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ValueParameterDescriptor valueParameterDescriptor;
        ParameterDescriptor descriptor = getDescriptor();
        if (descriptor instanceof ValueParameterDescriptor) {
            valueParameterDescriptor = (ValueParameterDescriptor) descriptor;
        } else {
            valueParameterDescriptor = null;
        }
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor descriptor = getDescriptor();
        if ((descriptor instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) descriptor).getVarargElementType() != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
