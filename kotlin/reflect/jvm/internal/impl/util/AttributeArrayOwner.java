package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {

    @NotNull
    private ArrayMap<T> arrayMap;

    protected AttributeArrayOwner(@NotNull ArrayMap<T> arrayMap) {
        Intrinsics.checkNotNullParameter(arrayMap, "arrayMap");
        this.arrayMap = arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    @NotNull
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final void registerComponent(@NotNull KClass<? extends K> tClass, @NotNull T value) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        Intrinsics.checkNotNullParameter(value, "value");
        int id5 = getTypeRegistry().getId(tClass);
        int size = this.arrayMap.getSize();
        if (size != 0) {
            if (size == 1) {
                ArrayMap<T> arrayMap = this.arrayMap;
                Intrinsics.checkNotNull(arrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                OneElementArrayMap oneElementArrayMap = (OneElementArrayMap) arrayMap;
                if (oneElementArrayMap.getIndex() == id5) {
                    this.arrayMap = new OneElementArrayMap(value, id5);
                    return;
                } else {
                    ArrayMapImpl arrayMapImpl = new ArrayMapImpl();
                    this.arrayMap = arrayMapImpl;
                    arrayMapImpl.set(oneElementArrayMap.getIndex(), oneElementArrayMap.getValue());
                }
            }
            this.arrayMap.set(id5, value);
            return;
        }
        this.arrayMap = new OneElementArrayMap(value, id5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AttributeArrayOwner() {
        this(r0);
        EmptyArrayMap emptyArrayMap = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(emptyArrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
    }
}
