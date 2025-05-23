package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;

    @NotNull
    private final T value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneElementArrayMap(@NotNull T value, int i3) {
        super(null);
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.index = i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    @Nullable
    public T get(int i3) {
        if (i3 == this.index) {
            return this.value;
        }
        return null;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 1;
    }

    @NotNull
    public final T getValue() {
        return this.value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new OneElementArrayMap$iterator$1(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i3, @NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException();
    }
}
