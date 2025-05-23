package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t\u00a8\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TypesJVMKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalStdlibApi
    public static final Type computeJavaType(KType kType, boolean z16) {
        Class javaClass;
        Object singleOrNull;
        int i3;
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            if (z16) {
                javaClass = JvmClassMappingKt.getJavaObjectType(kClass);
            } else {
                javaClass = JvmClassMappingKt.getJavaClass(kClass);
            }
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return javaClass;
            }
            if (javaClass.isArray()) {
                if (!javaClass.getComponentType().isPrimitive()) {
                    singleOrNull = CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) arguments);
                    KTypeProjection kTypeProjection = (KTypeProjection) singleOrNull;
                    if (kTypeProjection != null) {
                        KVariance variance = kTypeProjection.getVariance();
                        KType type = kTypeProjection.getType();
                        if (variance == null) {
                            i3 = -1;
                        } else {
                            i3 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
                        }
                        if (i3 != -1 && i3 != 1) {
                            if (i3 != 2 && i3 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Intrinsics.checkNotNull(type);
                            Type computeJavaType$default = computeJavaType$default(type, false, 1, null);
                            if (!(computeJavaType$default instanceof Class)) {
                                return new GenericArrayTypeImpl(computeJavaType$default);
                            }
                            return javaClass;
                        }
                        return javaClass;
                    }
                    throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
                }
                return javaClass;
            }
            return createPossiblyInnerType(javaClass, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return computeJavaType(kType, z16);
    }

    @ExperimentalStdlibApi
    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> list2 = list;
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<KTypeProjection> list3 = list;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = list3.iterator();
            while (it5.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it5.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> subList = list.subList(0, length);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it6 = subList.iterator();
        while (it6.hasNext()) {
            arrayList3.add(getJavaType((KTypeProjection) it6.next()));
        }
        return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList3);
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType kType) {
        Type javaType;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? computeJavaType$default(kType, false, 1, null) : javaType;
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        String name;
        Sequence generateSequence;
        Object last;
        int count;
        String repeat;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                generateSequence = SequencesKt__SequencesKt.generateSequence(type, (Function1<? super Type, ? extends Type>) ((Function1<? super Object, ? extends Object>) TypesJVMKt$typeToString$unwrap$1.INSTANCE));
                StringBuilder sb5 = new StringBuilder();
                last = SequencesKt___SequencesKt.last(generateSequence);
                sb5.append(((Class) last).getName());
                count = SequencesKt___SequencesKt.count(generateSequence);
                repeat = StringsKt__StringsJVMKt.repeat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, count);
                sb5.append(repeat);
                name = sb5.toString();
            } else {
                name = cls.getName();
            }
            Intrinsics.checkNotNullExpressionValue(name, "{\n        if (type.isArr\u2026   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    private static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        KType type = kTypeProjection.getType();
        Intrinsics.checkNotNull(type);
        int i3 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i3 == 1) {
            return new WildcardTypeImpl(null, computeJavaType(type, true));
        }
        if (i3 == 2) {
            return computeJavaType(type, true);
        }
        if (i3 == 3) {
            return new WildcardTypeImpl(computeJavaType(type, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
