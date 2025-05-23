package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class EmptyArrayMap extends ArrayMap {

    @NotNull
    public static final EmptyArrayMap INSTANCE = new EmptyArrayMap();

    EmptyArrayMap() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    @Nullable
    public Void get(int i3) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    @NotNull
    public Iterator iterator() {
        return new EmptyArrayMap$iterator$1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i3, @NotNull Void value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException();
    }
}
