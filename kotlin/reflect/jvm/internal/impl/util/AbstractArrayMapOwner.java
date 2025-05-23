package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {

        /* renamed from: id, reason: collision with root package name */
        private final int f412766id;

        @NotNull
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(@NotNull KClass<? extends K> key, int i3) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.f412766id = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Nullable
        public final T extractValue(@NotNull AbstractArrayMapOwner<K, V> thisRef) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return thisRef.getArrayMap().get(this.f412766id);
        }
    }

    @NotNull
    protected abstract ArrayMap<V> getArrayMap();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract TypeRegistry<K, V> getTypeRegistry();

    public final boolean isEmpty() {
        if (getArrayMap().getSize() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    protected abstract void registerComponent(@NotNull KClass<? extends K> kClass, @NotNull V v3);
}
