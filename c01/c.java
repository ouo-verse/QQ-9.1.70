package c01;

import com.tencent.kuikly.core.reactive.ReactiveObserver;
import kotlin.Metadata;
import kotlin.properties.ReadWriteProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0002\"\u0004\b\u0000\u0010\u0000\u00a8\u0006\b"}, d2 = {"T", "init", "Lkotlin/properties/ReadWriteProperty;", "", "a", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "Lcom/tencent/kuikly/core/reactive/collection/c;", "b", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {
    public static final <T> ReadWriteProperty<Object, T> a(T t16) {
        return ReactiveObserver.INSTANCE.c(t16);
    }

    public static final <T> ReadWriteProperty<Object, com.tencent.kuikly.core.reactive.collection.c<T>> b() {
        return ReactiveObserver.INSTANCE.d();
    }
}
