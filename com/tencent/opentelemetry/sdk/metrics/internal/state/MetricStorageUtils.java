package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MetricStorageUtils {
    static IPatchRedirector $redirector_ = null;
    static final int MAX_ACCUMULATIONS = 2000;

    MetricStorageUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static <T> void blend(final Map<Attributes, T> map, Map<Attributes, T> map2, boolean z16, final BiFunction<T, T, T> biFunction) {
        if (!z16) {
            removeUnseen(map, map2);
        }
        map2.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.n
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricStorageUtils.lambda$blend$1(map, biFunction, (Attributes) obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void diffInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, final Aggregator<T> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, false, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.q
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Aggregator.this.diff(obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$blend$0(BiFunction biFunction, Object obj, Attributes attributes, Object obj2) {
        Object apply;
        if (obj2 != null) {
            apply = biFunction.apply(obj2, obj);
            return apply;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$blend$1(Map map, final BiFunction biFunction, Attributes attributes, final Object obj) {
        map.compute(attributes, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.p
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                Object lambda$blend$0;
                lambda$blend$0 = MetricStorageUtils.lambda$blend$0(biFunction, obj, (Attributes) obj2, obj3);
                return lambda$blend$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeUnseen$2(Map map, Map.Entry entry) {
        return !map.containsKey(entry.getKey());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void mergeAndPreserveInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, Aggregator<T> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, true, new o(aggregator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void mergeInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, Aggregator<T> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, false, new o(aggregator));
    }

    public static <T> void removeUnseen(Map<Attributes, T> map, final Map<Attributes, T> map2) {
        map.entrySet().removeIf(new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.r
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$removeUnseen$2;
                lambda$removeUnseen$2 = MetricStorageUtils.lambda$removeUnseen$2(map2, (Map.Entry) obj);
                return lambda$removeUnseen$2;
            }
        });
    }
}
