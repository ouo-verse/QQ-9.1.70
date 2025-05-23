package kotlin.reflect.jvm.internal;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.cache.Entry;
import com.vivo.push.PushClientConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001al\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f\u00a2\u0006\u0002\b!H\u0000\u00a2\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0004\u0018\u00010\u000e*\u0002032\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0014\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00106\u001a\u0004\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;*\u00020=H\u0000\u001a\u0014\u0010>\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010?\u001a\u0004\u0018\u00010<*\u00020@H\u0002\u001a\u0012\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020BH\u0000\u001a\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020EH\u0000\u001a\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030G2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020<0;H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006I"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", "", "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", PushClientConstants.TAG_CLASS_NAME, "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", BdhLogUtil.LogTag.Tag_Req, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "unwrapRepeatableAnnotations", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class UtilKt {

    @NotNull
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v12, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v14, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=short[], for r7v13, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Object arrayToRuntimeValue(ArrayValue arrayValue, ClassLoader classLoader) {
        DeserializedArrayValue deserializedArrayValue;
        KotlinType type;
        int collectionSizeOrDefault;
        int i3;
        Object single;
        ClassDescriptor classDescriptor;
        Class loadClass$default;
        short[] sArr;
        if (arrayValue instanceof DeserializedArrayValue) {
            deserializedArrayValue = (DeserializedArrayValue) arrayValue;
        } else {
            deserializedArrayValue = null;
        }
        if (deserializedArrayValue == null || (type = deserializedArrayValue.getType()) == null) {
            return null;
        }
        List<? extends ConstantValue<?>> value = arrayValue.getValue();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(value, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            arrayList.add(toRuntimeValue((ConstantValue) it.next(), classLoader));
        }
        PrimitiveType primitiveArrayElementType = KotlinBuiltIns.getPrimitiveArrayElementType(type);
        if (primitiveArrayElementType == null) {
            i3 = -1;
        } else {
            i3 = WhenMappings.$EnumSwitchMapping$0[primitiveArrayElementType.ordinal()];
        }
        int i16 = 0;
        switch (i3) {
            case -1:
                if (KotlinBuiltIns.isArray(type)) {
                    single = CollectionsKt___CollectionsKt.single((List<? extends Object>) type.getArguments());
                    KotlinType type2 = ((TypeProjection) single).getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "type.arguments.single().type");
                    ClassifierDescriptor mo1779getDeclarationDescriptor = type2.getConstructor().mo1779getDeclarationDescriptor();
                    if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
                        classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
                    } else {
                        classDescriptor = null;
                    }
                    if (classDescriptor != null) {
                        if (KotlinBuiltIns.isString(type2)) {
                            int size = arrayValue.getValue().size();
                            sArr = new String[size];
                            while (i16 < size) {
                                Object obj = arrayList.get(i16);
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                sArr[i16] = (String) obj;
                                i16++;
                            }
                        } else if (KotlinBuiltIns.isKClass(classDescriptor)) {
                            int size2 = arrayValue.getValue().size();
                            sArr = new Class[size2];
                            while (i16 < size2) {
                                Object obj2 = arrayList.get(i16);
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                sArr[i16] = (Class) obj2;
                                i16++;
                            }
                        } else {
                            ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
                            if (classId == null || (loadClass$default = loadClass$default(classLoader, classId, 0, 4, null)) == null) {
                                return null;
                            }
                            Object newInstance = Array.newInstance((Class<?>) loadClass$default, arrayValue.getValue().size());
                            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                            sArr = (Object[]) newInstance;
                            int size3 = arrayList.size();
                            while (i16 < size3) {
                                sArr[i16] = arrayList.get(i16);
                                i16++;
                            }
                        }
                        return sArr;
                    }
                    throw new IllegalStateException(("Not a class type: " + type2).toString());
                }
                throw new IllegalStateException(("Not an array type: " + type).toString());
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                int size4 = arrayValue.getValue().size();
                sArr = new boolean[size4];
                while (i16 < size4) {
                    Object obj3 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    sArr[i16] = ((Boolean) obj3).booleanValue();
                    i16++;
                }
                return sArr;
            case 2:
                int size5 = arrayValue.getValue().size();
                sArr = new char[size5];
                while (i16 < size5) {
                    Object obj4 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Char");
                    sArr[i16] = ((Character) obj4).charValue();
                    i16++;
                }
                return sArr;
            case 3:
                int size6 = arrayValue.getValue().size();
                sArr = new byte[size6];
                while (i16 < size6) {
                    Object obj5 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    sArr[i16] = ((Byte) obj5).byteValue();
                    i16++;
                }
                return sArr;
            case 4:
                int size7 = arrayValue.getValue().size();
                sArr = new short[size7];
                while (i16 < size7) {
                    Object obj6 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i16] = ((Short) obj6).shortValue();
                    i16++;
                }
                return sArr;
            case 5:
                int size8 = arrayValue.getValue().size();
                sArr = new int[size8];
                while (i16 < size8) {
                    Object obj7 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                    sArr[i16] = ((Integer) obj7).intValue();
                    i16++;
                }
                return sArr;
            case 6:
                int size9 = arrayValue.getValue().size();
                sArr = new float[size9];
                while (i16 < size9) {
                    Object obj8 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Float");
                    sArr[i16] = ((Float) obj8).floatValue();
                    i16++;
                }
                return sArr;
            case 7:
                int size10 = arrayValue.getValue().size();
                sArr = new long[size10];
                while (i16 < size10) {
                    Object obj9 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Long");
                    sArr[i16] = ((Long) obj9).longValue();
                    i16++;
                }
                return sArr;
            case 8:
                int size11 = arrayValue.getValue().size();
                sArr = new double[size11];
                while (i16 < size11) {
                    Object obj10 = arrayList.get(i16);
                    Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Double");
                    sArr[i16] = ((Double) obj10).doubleValue();
                    i16++;
                }
                return sArr;
        }
    }

    @Nullable
    public static final KCallableImpl<?> asKCallableImpl(@Nullable Object obj) {
        KCallableImpl<?> kCallableImpl;
        if (obj instanceof KCallableImpl) {
            kCallableImpl = (KCallableImpl) obj;
        } else {
            kCallableImpl = null;
        }
        if (kCallableImpl == null) {
            KFunctionImpl asKFunctionImpl = asKFunctionImpl(obj);
            if (asKFunctionImpl == null) {
                return asKPropertyImpl(obj);
            }
            return asKFunctionImpl;
        }
        return kCallableImpl;
    }

    @Nullable
    public static final KFunctionImpl asKFunctionImpl(@Nullable Object obj) {
        KFunctionImpl kFunctionImpl;
        FunctionReference functionReference;
        KCallable kCallable;
        if (obj instanceof KFunctionImpl) {
            kFunctionImpl = (KFunctionImpl) obj;
        } else {
            kFunctionImpl = null;
        }
        if (kFunctionImpl == null) {
            if (obj instanceof FunctionReference) {
                functionReference = (FunctionReference) obj;
            } else {
                functionReference = null;
            }
            if (functionReference != null) {
                kCallable = functionReference.compute();
            } else {
                kCallable = null;
            }
            if (!(kCallable instanceof KFunctionImpl)) {
                return null;
            }
            return (KFunctionImpl) kCallable;
        }
        return kFunctionImpl;
    }

    @Nullable
    public static final KPropertyImpl<?> asKPropertyImpl(@Nullable Object obj) {
        KPropertyImpl<?> kPropertyImpl;
        PropertyReference propertyReference;
        KCallable kCallable;
        if (obj instanceof KPropertyImpl) {
            kPropertyImpl = (KPropertyImpl) obj;
        } else {
            kPropertyImpl = null;
        }
        if (kPropertyImpl == null) {
            if (obj instanceof PropertyReference) {
                propertyReference = (PropertyReference) obj;
            } else {
                propertyReference = null;
            }
            if (propertyReference != null) {
                kCallable = propertyReference.compute();
            } else {
                kCallable = null;
            }
            if (!(kCallable instanceof KPropertyImpl)) {
                return null;
            }
            return (KPropertyImpl) kCallable;
        }
        return kPropertyImpl;
    }

    @NotNull
    public static final List<Annotation> computeAnnotations(@NotNull Annotated annotated) {
        Annotation annotationInstance;
        ReflectJavaAnnotation reflectJavaAnnotation;
        Intrinsics.checkNotNullParameter(annotated, "<this>");
        Annotations annotations = annotated.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            if (source instanceof ReflectAnnotationSource) {
                annotationInstance = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                if (javaElement instanceof ReflectJavaAnnotation) {
                    reflectJavaAnnotation = (ReflectJavaAnnotation) javaElement;
                } else {
                    reflectJavaAnnotation = null;
                }
                if (reflectJavaAnnotation != null) {
                    annotationInstance = reflectJavaAnnotation.getAnnotation();
                } else {
                    annotationInstance = null;
                }
            } else {
                annotationInstance = toAnnotationInstance(annotationDescriptor);
            }
            if (annotationInstance != null) {
                arrayList.add(annotationInstance);
            }
        }
        return unwrapRepeatableAnnotations(arrayList);
    }

    @NotNull
    public static final Class<?> createArrayType(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    @Nullable
    public static final Object defaultPrimitiveValue(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (Intrinsics.areEqual(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (Intrinsics.areEqual(type, Character.TYPE)) {
                return (char) 0;
            }
            if (Intrinsics.areEqual(type, Byte.TYPE)) {
                return (byte) 0;
            }
            if (Intrinsics.areEqual(type, Short.TYPE)) {
                return (short) 0;
            }
            if (Intrinsics.areEqual(type, Integer.TYPE)) {
                return 0;
            }
            if (Intrinsics.areEqual(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (Intrinsics.areEqual(type, Long.TYPE)) {
                return 0L;
            }
            if (Intrinsics.areEqual(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (Intrinsics.areEqual(type, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException("Unknown primitive: " + type);
        }
        return null;
    }

    @NotNull
    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(@NotNull Class<?> moduleAnchor, @NotNull M proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull BinaryVersion metadataVersion, @NotNull Function2<? super MemberDeserializer, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        Intrinsics.checkNotNullParameter(moduleAnchor, "moduleAnchor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(createDescriptor, "createDescriptor");
        RuntimeModuleData orCreateModule = ModuleByClassLoaderKt.getOrCreateModule(moduleAnchor);
        if (proto instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) proto).getTypeParameterList();
        } else if (proto instanceof ProtoBuf.Property) {
            typeParameterList = ((ProtoBuf.Property) proto).getTypeParameterList();
        } else {
            throw new IllegalStateException(("Unsupported message: " + proto).toString());
        }
        List<ProtoBuf.TypeParameter> typeParameters = typeParameterList;
        DeserializationComponents deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor module = orCreateModule.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "typeParameters");
        return createDescriptor.invoke(new MemberDeserializer(new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, metadataVersion, null, null, typeParameters)), proto);
    }

    @Nullable
    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(@NotNull CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        if (callableDescriptor.getDispatchReceiverParameter() != null) {
            DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
        }
        return null;
    }

    @NotNull
    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final boolean isInlineClassType(@NotNull KType kType) {
        KTypeImpl kTypeImpl;
        KotlinType type;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        if (kType instanceof KTypeImpl) {
            kTypeImpl = (KTypeImpl) kType;
        } else {
            kTypeImpl = null;
        }
        if (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !InlineClassesUtilsKt.isInlineClassType(type)) {
            return false;
        }
        return true;
    }

    private static final Class<?> loadClass(ClassLoader classLoader, ClassId classId, int i3) {
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava != null) {
            classId = mapKotlinToJava;
        }
        String asString = classId.getPackageFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "javaClassId.packageFqName.asString()");
        String asString2 = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "javaClassId.relativeClassName.asString()");
        return loadClass(classLoader, asString, asString2, i3);
    }

    static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return loadClass(classLoader, classId, i3);
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor annotationDescriptor) {
        Class<?> cls;
        Map map;
        Pair pair;
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass != null) {
            cls = toJavaClass(annotationClass);
        } else {
            cls = null;
        }
        if (!(cls instanceof Class)) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        Set<Map.Entry<Name, ConstantValue<?>>> entrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Name name = (Name) entry.getKey();
            ConstantValue constantValue = (ConstantValue) entry.getValue();
            ClassLoader classLoader = cls.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "annotationClass.classLoader");
            Object runtimeValue = toRuntimeValue(constantValue, classLoader);
            if (runtimeValue != null) {
                pair = TuplesKt.to(name.asString(), runtimeValue);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(cls, map, null, 4, null);
    }

    @Nullable
    public static final Class<?> toJavaClass(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        SourceElement source = classDescriptor.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "source");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            Intrinsics.checkNotNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ReflectKotlinClass) binaryClass).getKlass();
        }
        if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            Intrinsics.checkNotNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        }
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null) {
            return null;
        }
        return loadClass(ReflectClassUtilKt.getSafeClassLoader(classDescriptor.getClass()), classId, 0);
    }

    @Nullable
    public static final KVisibility toKVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        boolean areEqual;
        Intrinsics.checkNotNullParameter(descriptorVisibility, "<this>");
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PRIVATE)) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PRIVATE_TO_THIS);
        }
        if (areEqual) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        boolean z16;
        ClassDescriptor classDescriptor;
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance(((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            return arrayToRuntimeValue((ArrayValue) constantValue, classLoader);
        }
        if (constantValue instanceof EnumValue) {
            Pair<? extends ClassId, ? extends Name> value = ((EnumValue) constantValue).getValue();
            ClassId component1 = value.component1();
            Name component2 = value.component2();
            Class loadClass$default = loadClass$default(classLoader, component1, 0, 4, null);
            if (loadClass$default != null) {
                return Util.getEnumConstantByName(loadClass$default, component2.asString());
            }
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value value2 = ((KClassValue) constantValue).getValue();
            if (value2 instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value2;
                return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
            }
            if (value2 instanceof KClassValue.Value.LocalClass) {
                ClassifierDescriptor mo1779getDeclarationDescriptor = ((KClassValue.Value.LocalClass) value2).getType().getConstructor().mo1779getDeclarationDescriptor();
                if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
                    classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
                } else {
                    classDescriptor = null;
                }
                if (classDescriptor != null) {
                    return toJavaClass(classDescriptor);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (constantValue instanceof ErrorValue) {
                z16 = true;
            } else {
                z16 = constantValue instanceof NullValue;
            }
            if (!z16) {
                return constantValue.getValue();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List<? extends java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.Collection, java.util.ArrayList] */
    private static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> list) {
        boolean z16;
        List listOf;
        Iterable<Annotation> iterable = (Iterable) list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) it.next())).getSimpleName(), "Container")) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            list = new ArrayList<>();
            for (Annotation annotation : iterable) {
                Class javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
                if (!Intrinsics.areEqual(javaClass.getSimpleName(), "Container") || javaClass.getAnnotation(RepeatableContainer.class) == null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(annotation);
                } else {
                    Object invoke = javaClass.getDeclaredMethod("value", new Class[0]).invoke(annotation, new Object[0]);
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                    listOf = ArraysKt___ArraysJvmKt.asList((Annotation[]) invoke);
                }
                CollectionsKt__MutableCollectionsKt.addAll((Collection) list, listOf);
            }
        }
        return list;
    }

    private static final Class<?> loadClass(ClassLoader classLoader, String str, String str2, int i3) {
        String replace$default;
        String repeat;
        if (Intrinsics.areEqual(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals(Entry.DATA_TYPE_Array)) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append('.');
        replace$default = StringsKt__StringsJVMKt.replace$default(str2, '.', '$', false, 4, (Object) null);
        sb5.append(replace$default);
        String sb6 = sb5.toString();
        if (i3 > 0) {
            StringBuilder sb7 = new StringBuilder();
            repeat = StringsKt__StringsJVMKt.repeat("[", i3);
            sb7.append(repeat);
            sb7.append('L');
            sb7.append(sb6);
            sb7.append(';');
            sb6 = sb7.toString();
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, sb6);
    }
}
