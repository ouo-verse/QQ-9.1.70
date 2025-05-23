package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ Function0<Type> $computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl, Function0<? extends Type> function0) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$computeJavaType = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Type> invoke$lambda$0(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeProjection> invoke() {
        final Lazy lazy;
        int collectionSizeOrDefault;
        KTypeProjection invariant;
        List<? extends KTypeProjection> emptyList;
        List<TypeProjection> arguments = this.this$0.getType().getArguments();
        if (arguments.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        final KTypeImpl kTypeImpl = this.this$0;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$parameterizedTypeArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Type> invoke() {
                Type javaType = KTypeImpl.this.getJavaType();
                Intrinsics.checkNotNull(javaType);
                return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
            }
        });
        List<TypeProjection> list = arguments;
        Function0<Type> function0 = this.$computeJavaType;
        final KTypeImpl kTypeImpl2 = this.this$0;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        final int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                invariant = KTypeProjection.INSTANCE.getSTAR();
            } else {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                KTypeImpl kTypeImpl3 = new KTypeImpl(type, function0 == null ? null : new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$1$type$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Type invoke() {
                        List invoke$lambda$0;
                        Object firstOrNull;
                        Object first;
                        Type javaType = KTypeImpl.this.getJavaType();
                        if (javaType instanceof Class) {
                            Class cls = (Class) javaType;
                            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                            Intrinsics.checkNotNullExpressionValue(componentType, "{\n                      \u2026                        }");
                            return componentType;
                        }
                        if (javaType instanceof GenericArrayType) {
                            if (i3 == 0) {
                                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                                Intrinsics.checkNotNullExpressionValue(genericComponentType, "{\n                      \u2026                        }");
                                return genericComponentType;
                            }
                            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + KTypeImpl.this);
                        }
                        if (javaType instanceof ParameterizedType) {
                            invoke$lambda$0 = KTypeImpl$arguments$2.invoke$lambda$0(lazy);
                            Type type2 = (Type) invoke$lambda$0.get(i3);
                            if (type2 instanceof WildcardType) {
                                WildcardType wildcardType = (WildcardType) type2;
                                Type[] lowerBounds = wildcardType.getLowerBounds();
                                Intrinsics.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                                firstOrNull = ArraysKt___ArraysKt.firstOrNull(lowerBounds);
                                Type type3 = (Type) firstOrNull;
                                if (type3 == null) {
                                    Type[] upperBounds = wildcardType.getUpperBounds();
                                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                                    first = ArraysKt___ArraysKt.first(upperBounds);
                                    type2 = (Type) first;
                                } else {
                                    type2 = type3;
                                }
                            }
                            Intrinsics.checkNotNullExpressionValue(type2, "{\n                      \u2026                        }");
                            return type2;
                        }
                        throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + KTypeImpl.this);
                    }
                });
                int i17 = WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i17 == 1) {
                    invariant = KTypeProjection.INSTANCE.invariant(kTypeImpl3);
                } else if (i17 != 2) {
                    if (i17 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    invariant = KTypeProjection.INSTANCE.covariant(kTypeImpl3);
                } else {
                    invariant = KTypeProjection.INSTANCE.contravariant(kTypeImpl3);
                }
            }
            arrayList.add(invariant);
            i3 = i16;
        }
        return arrayList;
    }
}
