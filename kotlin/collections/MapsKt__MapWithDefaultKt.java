package kotlin.collections;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\t\u001aX\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0007\u00a2\u0006\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes28.dex */
public class MapsKt__MapWithDefaultKt {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static <K, V> V getOrImplicitDefaultNullable(@NotNull Map<K, ? extends V> map, K k3) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k3);
        }
        V v3 = map.get(k3);
        if (v3 == null && !map.containsKey(k3)) {
            throw new NoSuchElementException("Key " + k3 + " is missing in the map.");
        }
        return v3;
    }

    @NotNull
    public static <K, V> Map<K, V> withDefault(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> defaultValue) {
        Map<K, V> withDefault;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (map instanceof MapWithDefault) {
            withDefault = withDefault(((MapWithDefault) map).getMap(), defaultValue);
            return withDefault;
        }
        return new MapWithDefaultImpl(map, defaultValue);
    }

    @JvmName(name = "withDefaultMutable")
    @NotNull
    public static <K, V> Map<K, V> withDefaultMutable(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> defaultValue) {
        Map<K, V> withDefaultMutable;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (map instanceof MutableMapWithDefault) {
            withDefaultMutable = withDefaultMutable(((MutableMapWithDefault) map).getMap(), defaultValue);
            return withDefaultMutable;
        }
        return new MutableMapWithDefaultImpl(map, defaultValue);
    }
}
