package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ConstantValueFactory {

    @NotNull
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    ConstantValueFactory() {
    }

    @NotNull
    public final ArrayValue createArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull final KotlinType type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ArrayValue(value, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final KotlinType invoke(@NotNull ModuleDescriptor it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KotlinType.this;
            }
        });
    }

    @Nullable
    public final ConstantValue<?> createConstantValue(@Nullable Object obj) {
        List<?> list;
        List<?> list2;
        List<?> list3;
        List<?> list4;
        List<?> list5;
        List<?> list6;
        List<?> list7;
        List<?> list8;
        if (obj instanceof Byte) {
            return new ByteValue(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new ShortValue(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new IntValue(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new LongValue(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new CharValue(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new FloatValue(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new DoubleValue(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new BooleanValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new StringValue((String) obj);
        }
        if (obj instanceof byte[]) {
            list8 = ArraysKt___ArraysKt.toList((byte[]) obj);
            return createArrayValue(list8, PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            list7 = ArraysKt___ArraysKt.toList((short[]) obj);
            return createArrayValue(list7, PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            list6 = ArraysKt___ArraysKt.toList((int[]) obj);
            return createArrayValue(list6, PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            list5 = ArraysKt___ArraysKt.toList((long[]) obj);
            return createArrayValue(list5, PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            list4 = ArraysKt___ArraysKt.toList((char[]) obj);
            return createArrayValue(list4, PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            list3 = ArraysKt___ArraysKt.toList((float[]) obj);
            return createArrayValue(list3, PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            list2 = ArraysKt___ArraysKt.toList((double[]) obj);
            return createArrayValue(list2, PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            list = ArraysKt___ArraysKt.toList((boolean[]) obj);
            return createArrayValue(list, PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new NullValue();
        }
        return null;
    }

    private final ArrayValue createArrayValue(List<?> list, final PrimitiveType primitiveType) {
        List list2;
        list2 = CollectionsKt___CollectionsKt.toList(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ConstantValue<?> createConstantValue = createConstantValue(it.next());
            if (createConstantValue != null) {
                arrayList.add(createConstantValue);
            }
        }
        return new ArrayValue(arrayList, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final KotlinType invoke(@NotNull ModuleDescriptor module) {
                Intrinsics.checkNotNullParameter(module, "module");
                SimpleType primitiveArrayKotlinType = module.getBuiltIns().getPrimitiveArrayKotlinType(PrimitiveType.this);
                Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimi\u2026KotlinType(componentType)");
                return primitiveArrayKotlinType;
            }
        });
    }
}
