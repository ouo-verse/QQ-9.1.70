package kotlin.reflect.jvm.internal;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0016\u00a2\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002\u00a2\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016\u00a2\u0006\u0002\u0010=J3\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<2\f\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010AH\u0000\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020,H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \t*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0012\u0010\u001e\u001a\u00020\u001fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010$R\u0014\u0010%\u001a\u00020#8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010$R\u0012\u0010&\u001a\u00020#X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u0013R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006H"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", ParseCommon.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", h.f248218g, "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {

    @NotNull
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;

    @NotNull
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;

    @NotNull
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;

    @NotNull
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new Function0<List<? extends Annotation>>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_annotations$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                return UtilKt.computeAnnotations(this.this$0.getDescriptor());
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft { descriptor.computeAnnotations() }");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new Function0<ArrayList<KParameter>>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<KParameter> invoke() {
                int i3;
                final CallableMemberDescriptor descriptor = this.this$0.getDescriptor();
                ArrayList<KParameter> arrayList = new ArrayList<>();
                final int i16 = 0;
                if (this.this$0.isBound()) {
                    i3 = 0;
                } else {
                    final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
                    if (instanceReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(this.this$0, 0, KParameter.Kind.INSTANCE, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(this.this$0, i3, KParameter.Kind.EXTENSION_RECEIVER, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i3++;
                    }
                }
                int size = descriptor.getValueParameters().size();
                while (i16 < size) {
                    arrayList.add(new KParameterImpl(this.this$0, i3, KParameter.Kind.VALUE, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final ParameterDescriptor invoke() {
                            ValueParameterDescriptor valueParameterDescriptor = CallableMemberDescriptor.this.getValueParameters().get(i16);
                            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
                            return valueParameterDescriptor;
                        }
                    }));
                    i16++;
                    i3++;
                }
                if (this.this$0.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$invoke$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((KParameter) t16).getName(), ((KParameter) t17).getName());
                            return compareValues;
                        }
                    });
                }
                arrayList.trimToSize();
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft {\n        val d\u2026ze()\n        result\n    }");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new Function0<KTypeImpl>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KTypeImpl invoke() {
                KotlinType returnType = this.this$0.getDescriptor().getReturnType();
                Intrinsics.checkNotNull(returnType);
                final KCallableImpl<R> kCallableImpl = this.this$0;
                return new KTypeImpl(returnType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Type invoke() {
                        Type extractContinuationArgument;
                        extractContinuationArgument = kCallableImpl.extractContinuationArgument();
                        return extractContinuationArgument == null ? kCallableImpl.getCaller().getReturnType() : extractContinuationArgument;
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft {\n        KType\u2026eturnType\n        }\n    }");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new Function0<List<? extends KTypeParameterImpl>>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_typeParameters$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeParameterImpl> invoke() {
                int collectionSizeOrDefault;
                List<TypeParameterDescriptor> typeParameters = this.this$0.getDescriptor().getTypeParameters();
                Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
                List<TypeParameterDescriptor> list = typeParameters;
                KTypeParameterOwnerImpl kTypeParameterOwnerImpl = this.this$0;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (TypeParameterDescriptor descriptor : list) {
                    Intrinsics.checkNotNullExpressionValue(descriptor, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kTypeParameterOwnerImpl, descriptor));
                }
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft {\n        descr\u2026this, descriptor) }\n    }");
        this._typeParameters = lazySoft4;
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> args) {
        int collectionSizeOrDefault;
        Object defaultEmptyArray;
        List<KParameter> parameters = getParameters();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (KParameter kParameter : parameters) {
            if (args.containsKey(kParameter)) {
                defaultEmptyArray = args.get(kParameter);
                if (defaultEmptyArray == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                defaultEmptyArray = null;
            } else if (kParameter.isVararg()) {
                defaultEmptyArray = defaultEmptyArray(kParameter.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            arrayList.add(defaultEmptyArray);
        }
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (R) defaultCaller.call(array);
            } catch (IllegalAccessException e16) {
                throw new IllegalCallableAccessException(e16);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultEmptyArray(KType type) {
        Class javaClass = JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(type));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "type.jvmErasure.java.run\u2026\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        FunctionDescriptor functionDescriptor;
        Object lastOrNull;
        ParameterizedType parameterizedType;
        Type type;
        Object single;
        WildcardType wildcardType;
        Type[] lowerBounds;
        Object first;
        CallableMemberDescriptor descriptor = getDescriptor();
        if (descriptor instanceof FunctionDescriptor) {
            functionDescriptor = (FunctionDescriptor) descriptor;
        } else {
            functionDescriptor = null;
        }
        boolean z16 = false;
        if (functionDescriptor != null && functionDescriptor.isSuspend()) {
            z16 = true;
        }
        if (z16) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) getCaller().getParameterTypes());
            if (lastOrNull instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) lastOrNull;
            } else {
                parameterizedType = null;
            }
            if (parameterizedType != null) {
                type = parameterizedType.getRawType();
            } else {
                type = null;
            }
            if (!Intrinsics.areEqual(type, Continuation.class)) {
                return null;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
            single = ArraysKt___ArraysKt.single(actualTypeArguments);
            if (single instanceof WildcardType) {
                wildcardType = (WildcardType) single;
            } else {
                wildcardType = null;
            }
            if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                first = ArraysKt___ArraysKt.first(lowerBounds);
                return (Type) first;
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.KCallable
    public R call(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return (R) getCaller().call(args);
        } catch (IllegalAccessException e16) {
            throw new IllegalCallableAccessException(e16);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(@NotNull Map<KParameter, ? extends Object> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (isAnnotationConstructor()) {
            return callAnnotationConstructor(args);
        }
        return callDefaultMethod$kotlin_reflection(args, null);
    }

    public final R callDefaultMethod$kotlin_reflection(@NotNull Map<KParameter, ? extends Object> args, @Nullable Continuation<?> continuationArgument) {
        Intrinsics.checkNotNullParameter(args, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i3 = 0;
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            Object obj = null;
            if (it.hasNext()) {
                KParameter next = it.next();
                if (i3 != 0 && i3 % 32 == 0) {
                    arrayList2.add(Integer.valueOf(i16));
                    i16 = 0;
                }
                if (args.containsKey(next)) {
                    arrayList.add(args.get(next));
                } else if (next.isOptional()) {
                    if (!UtilKt.isInlineClassType(next.getType())) {
                        obj = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(next.getType()));
                    }
                    arrayList.add(obj);
                    i16 = (1 << (i3 % 32)) | i16;
                    z16 = true;
                } else if (next.isVararg()) {
                    arrayList.add(defaultEmptyArray(next.getType()));
                } else {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                if (next.getKind() == KParameter.Kind.VALUE) {
                    i3++;
                }
            } else {
                if (continuationArgument != null) {
                    arrayList.add(continuationArgument);
                }
                if (!z16) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i16));
                Caller<?> defaultCaller = getDefaultCaller();
                if (defaultCaller != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        return (R) defaultCaller.call(array2);
                    } catch (IllegalAccessException e16) {
                        throw new IllegalCallableAccessException(e16);
                    }
                }
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
            }
        }
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_annotations()");
        return invoke;
    }

    @NotNull
    public abstract Caller<?> getCaller();

    @NotNull
    public abstract KDeclarationContainerImpl getContainer();

    @Nullable
    public abstract Caller<?> getDefaultCaller();

    @NotNull
    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public KType getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    @Nullable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        if (getDescriptor().getModality() == Modality.ABSTRACT) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isAnnotationConstructor() {
        if (Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation()) {
            return true;
        }
        return false;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        if (getDescriptor().getModality() == Modality.FINAL) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        if (getDescriptor().getModality() == Modality.OPEN) {
            return true;
        }
        return false;
    }
}
