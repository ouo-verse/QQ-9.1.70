package com.tencent.hippykotlin.demo.pages.qqkmp.base.cache;

import com.tencent.kuikly.core.kmp.g;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\u0006J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/base/cache/LruCache;", "", "K", "V", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "", "size", QCircleLpReportDc05507.KEY_CLEAR, "maxSize", "I", "Lkotlin/Function1;", "sizeCalculator", "Lkotlin/jvm/functions/Function1;", "Lcom/tencent/kuikly/core/kmp/g;", "cache", "Lcom/tencent/kuikly/core/kmp/g;", "getCache", "()Lcom/tencent/kuikly/core/kmp/g;", "currentSize", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class LruCache<K, V> {
    public static final int $stable = 8;
    private final g<K, V> cache;
    private int currentSize;
    private final int maxSize;
    private final Function1<V, Integer> sizeCalculator;

    /* JADX WARN: Multi-variable type inference failed */
    public LruCache(int i3, Function1<? super V, Integer> function1) {
        this.maxSize = i3;
        this.sizeCalculator = function1;
        this.cache = new g<>();
    }

    public final void clear() {
        this.cache.clear();
        this.currentSize = 0;
    }

    public final V get(K key) {
        return this.cache.get(key);
    }

    public final g<K, V> getCache() {
        return this.cache;
    }

    public final void put(K key, V value) {
        Object firstOrNull;
        Unit unit;
        V put = this.cache.put(key, value);
        int intValue = this.sizeCalculator.invoke(value).intValue() + this.currentSize;
        this.currentSize = intValue;
        if (put != null) {
            this.currentSize = intValue - this.sizeCalculator.invoke(put).intValue();
        }
        while (this.currentSize > this.maxSize) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(this.cache.entrySet());
            Map.Entry entry = (Map.Entry) firstOrNull;
            if (entry != null) {
                this.cache.remove(entry.getKey());
                this.currentSize -= ((Number) this.sizeCalculator.invoke(entry.getValue())).intValue();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return;
            }
        }
    }

    public final V remove(K key) {
        V remove = this.cache.remove(key);
        if (remove == null) {
            return null;
        }
        this.currentSize -= this.sizeCalculator.invoke(remove).intValue();
        return remove;
    }

    public final int size() {
        return this.cache.size();
    }

    public /* synthetic */ LruCache(int i3, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? new Function1<V, Integer>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.base.cache.LruCache.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(V v3) {
                return 1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
                return invoke((AnonymousClass1) obj);
            }
        } : function1);
    }
}
