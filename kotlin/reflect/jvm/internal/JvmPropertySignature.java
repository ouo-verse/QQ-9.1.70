package kotlin.reflect.jvm.internal;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0004\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class JvmPropertySignature {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class JavaField extends JvmPropertySignature {

        @NotNull
        private final Field field;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JavaField(@NotNull Field field) {
            super(null);
            Intrinsics.checkNotNullParameter(field, "field");
            this.field = field;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        /* renamed from: asString */
        public String getString() {
            StringBuilder sb5 = new StringBuilder();
            String name = this.field.getName();
            Intrinsics.checkNotNullExpressionValue(name, "field.name");
            sb5.append(JvmAbi.getterName(name));
            sb5.append("()");
            Class<?> type = this.field.getType();
            Intrinsics.checkNotNullExpressionValue(type, "field.type");
            sb5.append(ReflectClassUtilKt.getDesc(type));
            return sb5.toString();
        }

        @NotNull
        public final Field getField() {
            return this.field;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class JavaMethodProperty extends JvmPropertySignature {

        @NotNull
        private final Method getterMethod;

        @Nullable
        private final Method setterMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JavaMethodProperty(@NotNull Method getterMethod, @Nullable Method method) {
            super(null);
            Intrinsics.checkNotNullParameter(getterMethod, "getterMethod");
            this.getterMethod = getterMethod;
            this.setterMethod = method;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        /* renamed from: asString */
        public String getString() {
            String signature;
            signature = RuntimeTypeMapperKt.getSignature(this.getterMethod);
            return signature;
        }

        @NotNull
        public final Method getGetterMethod() {
            return this.getterMethod;
        }

        @Nullable
        public final Method getSetterMethod() {
            return this.setterMethod;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", HippyControllerProps.STRING, "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class KotlinProperty extends JvmPropertySignature {

        @NotNull
        private final PropertyDescriptor descriptor;

        @NotNull
        private final NameResolver nameResolver;

        @NotNull
        private final ProtoBuf.Property proto;

        @NotNull
        private final JvmProtoBuf.JvmPropertySignature signature;

        @NotNull
        private final String string;

        @NotNull
        private final TypeTable typeTable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KotlinProperty(@NotNull PropertyDescriptor descriptor, @NotNull ProtoBuf.Property proto, @NotNull JvmProtoBuf.JvmPropertySignature signature, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
            super(null);
            String str;
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(proto, "proto");
            Intrinsics.checkNotNullParameter(signature, "signature");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            this.descriptor = descriptor;
            this.proto = proto;
            this.signature = signature;
            this.nameResolver = nameResolver;
            this.typeTable = typeTable;
            if (signature.hasGetter()) {
                str = nameResolver.getString(signature.getGetter().getName()) + nameResolver.getString(signature.getGetter().getDesc());
            } else {
                JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, proto, nameResolver, typeTable, false, 8, null);
                if (jvmFieldSignature$default != null) {
                    String component1 = jvmFieldSignature$default.component1();
                    str = JvmAbi.getterName(component1) + getManglingSuffix() + "()" + jvmFieldSignature$default.component2();
                } else {
                    throw new KotlinReflectionInternalError("No field signature for property: " + descriptor);
                }
            }
            this.string = str;
        }

        private final String getManglingSuffix() {
            String str;
            DeclarationDescriptor containingDeclaration = this.descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), DescriptorVisibilities.INTERNAL) && (containingDeclaration instanceof DeserializedClassDescriptor)) {
                ProtoBuf.Class classProto = ((DeserializedClassDescriptor) containingDeclaration).getClassProto();
                GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = JvmProtoBuf.classModuleName;
                Intrinsics.checkNotNullExpressionValue(classModuleName, "classModuleName");
                Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(classProto, classModuleName);
                if (num == null || (str = this.nameResolver.getString(num.intValue())) == null) {
                    str = "main";
                }
                return '$' + NameUtils.sanitizeAsJavaIdentifier(str);
            }
            if (Intrinsics.areEqual(this.descriptor.getVisibility(), DescriptorVisibilities.PRIVATE) && (containingDeclaration instanceof PackageFragmentDescriptor)) {
                PropertyDescriptor propertyDescriptor = this.descriptor;
                Intrinsics.checkNotNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                DeserializedContainerSource containerSource = ((DeserializedPropertyDescriptor) propertyDescriptor).getContainerSource();
                if (containerSource instanceof JvmPackagePartSource) {
                    JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
                    if (jvmPackagePartSource.getFacadeClassName() != null) {
                        return '$' + jvmPackagePartSource.getSimpleName().asString();
                    }
                    return "";
                }
                return "";
            }
            return "";
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        /* renamed from: asString, reason: from getter */
        public String getString() {
            return this.string;
        }

        @NotNull
        public final PropertyDescriptor getDescriptor() {
            return this.descriptor;
        }

        @NotNull
        public final NameResolver getNameResolver() {
            return this.nameResolver;
        }

        @NotNull
        public final ProtoBuf.Property getProto() {
            return this.proto;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.signature;
        }

        @NotNull
        public final TypeTable getTypeTable() {
            return this.typeTable;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class MappedKotlinProperty extends JvmPropertySignature {

        @NotNull
        private final JvmFunctionSignature.KotlinFunction getterSignature;

        @Nullable
        private final JvmFunctionSignature.KotlinFunction setterSignature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MappedKotlinProperty(@NotNull JvmFunctionSignature.KotlinFunction getterSignature, @Nullable JvmFunctionSignature.KotlinFunction kotlinFunction) {
            super(null);
            Intrinsics.checkNotNullParameter(getterSignature, "getterSignature");
            this.getterSignature = getterSignature;
            this.setterSignature = kotlinFunction;
        }

        @Override // kotlin.reflect.jvm.internal.JvmPropertySignature
        @NotNull
        /* renamed from: asString */
        public String getString() {
            return this.getterSignature.get_signature();
        }

        @NotNull
        public final JvmFunctionSignature.KotlinFunction getGetterSignature() {
            return this.getterSignature;
        }

        @Nullable
        public final JvmFunctionSignature.KotlinFunction getSetterSignature() {
            return this.setterSignature;
        }
    }

    public /* synthetic */ JvmPropertySignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    /* renamed from: asString */
    public abstract String getString();

    JvmPropertySignature() {
    }
}
