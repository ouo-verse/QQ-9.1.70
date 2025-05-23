package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TypeAttributes Empty;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TypeAttributes create(@NotNull List<? extends TypeAttribute<?>> attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            if (attributes.isEmpty()) {
                return getEmpty();
            }
            return new TypeAttributes(attributes, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public <T extends TypeAttribute<?>> int customComputeIfAbsent(@NotNull ConcurrentHashMap<KClass<? extends TypeAttribute<?>>, Integer> concurrentHashMap, @NotNull KClass<T> kClass, @NotNull Function1<? super KClass<? extends TypeAttribute<?>>, Integer> compute) {
            int intValue;
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(compute, "compute");
            Integer num = concurrentHashMap.get(kClass);
            if (num == null) {
                synchronized (concurrentHashMap) {
                    Integer num2 = concurrentHashMap.get(kClass);
                    if (num2 == null) {
                        Integer invoke = compute.invoke(kClass);
                        concurrentHashMap.putIfAbsent(kClass, Integer.valueOf(invoke.intValue()));
                        num2 = invoke;
                    }
                    Intrinsics.checkNotNullExpressionValue(num2, "this[kClass] ?: compute(\u2026putIfAbsent(kClass, it) }");
                    intValue = num2.intValue();
                }
                return intValue;
            }
            return num.intValue();
        }

        @NotNull
        public final TypeAttributes getEmpty() {
            return TypeAttributes.Empty;
        }

        Companion() {
        }
    }

    static {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Empty = new TypeAttributes((List<? extends TypeAttribute<?>>) emptyList);
    }

    public /* synthetic */ TypeAttributes(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<? extends TypeAttribute<?>>) list);
    }

    @NotNull
    public final TypeAttributes add(@NotNull TypeAttributes other) {
        Object add;
        Intrinsics.checkNotNullParameter(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = Companion.getIndices().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            TypeAttribute<?> typeAttribute = getArrayMap().get(intValue);
            TypeAttribute<?> typeAttribute2 = other.getArrayMap().get(intValue);
            if (typeAttribute == null) {
                if (typeAttribute2 != null) {
                    add = typeAttribute2.add(typeAttribute);
                } else {
                    add = null;
                }
            } else {
                add = typeAttribute.add(typeAttribute2);
            }
            CollectionsKt.addIfNotNull(arrayList, add);
        }
        return Companion.create(arrayList);
    }

    public final boolean contains(@NotNull TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (getArrayMap().get(Companion.getId(attribute.getKey())) != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    @NotNull
    protected TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    @NotNull
    public final TypeAttributes intersect(@NotNull TypeAttributes other) {
        Object intersect;
        Intrinsics.checkNotNullParameter(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = Companion.getIndices().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            TypeAttribute<?> typeAttribute = getArrayMap().get(intValue);
            TypeAttribute<?> typeAttribute2 = other.getArrayMap().get(intValue);
            if (typeAttribute == null) {
                if (typeAttribute2 != null) {
                    intersect = typeAttribute2.intersect(typeAttribute);
                } else {
                    intersect = null;
                }
            } else {
                intersect = typeAttribute.intersect(typeAttribute2);
            }
            CollectionsKt.addIfNotNull(arrayList, intersect);
        }
        return Companion.create(arrayList);
    }

    @NotNull
    public final TypeAttributes plus(@NotNull TypeAttribute<?> attribute) {
        List list;
        List<? extends TypeAttribute<?>> plus;
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (contains(attribute)) {
            return this;
        }
        if (!isEmpty()) {
            list = CollectionsKt___CollectionsKt.toList(this);
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends TypeAttribute<?>>) ((Collection<? extends Object>) list), attribute);
            return Companion.create(plus);
        }
        return new TypeAttributes(attribute);
    }

    @NotNull
    public final TypeAttributes remove(@NotNull TypeAttribute<?> attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (isEmpty()) {
            return this;
        }
        ArrayMap<TypeAttribute<?>> arrayMap = getArrayMap();
        ArrayList arrayList = new ArrayList();
        for (TypeAttribute<?> typeAttribute : arrayMap) {
            if (!Intrinsics.areEqual(typeAttribute, attribute)) {
                arrayList.add(typeAttribute);
            }
        }
        if (arrayList.size() == getArrayMap().getSize()) {
            return this;
        }
        return Companion.create(arrayList);
    }

    TypeAttributes(List<? extends TypeAttribute<?>> list) {
        for (TypeAttribute<?> typeAttribute : list) {
            registerComponent(typeAttribute.getKey(), typeAttribute);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    TypeAttributes(TypeAttribute<?> typeAttribute) {
        this((List<? extends TypeAttribute<?>>) r1);
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(typeAttribute);
    }
}
