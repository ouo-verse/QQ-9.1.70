package com.tencent.kuikly.core.reactive;

import com.tencent.kuikly.core.reactive.collection.b;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\"\u001a\u00028\u0000\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ&\u0010\r\u001a\u00028\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0010\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/kuikly/core/reactive/ObservableCollectionProperty;", "Lcom/tencent/kuikly/core/reactive/collection/b;", "T", "Lcom/tencent/kuikly/core/reactive/a;", "Lc01/a;", "oldValue", "", "i", "(Lcom/tencent/kuikly/core/reactive/collection/b;)V", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "k", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lcom/tencent/kuikly/core/reactive/collection/b;", "value", "l", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Lcom/tencent/kuikly/core/reactive/collection/b;)V", "a", "otherHandler", "d", "b", "c", "", "f", "Ljava/lang/String;", "propertyName", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "g", "Lkotlin/Lazy;", "j", "()Ljava/util/HashSet;", "otherCollectionElementChangeHandlerSet", "initValue", "Lc01/b;", "handler", "<init>", "(Lcom/tencent/kuikly/core/reactive/collection/b;Lc01/b;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ObservableCollectionProperty<T extends b> extends a<T> implements c01.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String propertyName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy otherCollectionElementChangeHandlerSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableCollectionProperty(T initValue, c01.b handler) {
        super(initValue, handler);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initValue, "initValue");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.propertyName = "";
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HashSet<c01.a>>() { // from class: com.tencent.kuikly.core.reactive.ObservableCollectionProperty$otherCollectionElementChangeHandlerSet$2
            @Override // kotlin.jvm.functions.Function0
            public final HashSet<c01.a> invoke() {
                return new HashSet<>();
            }
        });
        this.otherCollectionElementChangeHandlerSet = lazy;
        ((b) e()).a(this);
    }

    private final void i(T oldValue) {
        c01.a c16;
        c01.a handler = oldValue.getHandler();
        if (handler != null) {
            handler.b(this);
        }
        if (Intrinsics.areEqual(oldValue.getHandler(), this)) {
            c01.a handler2 = oldValue.getHandler();
            if (handler2 != null && (c16 = handler2.c()) != null) {
                c01.a handler3 = oldValue.getHandler();
                if (handler3 != null) {
                    handler3.b(c16);
                }
                oldValue.a(c16);
            }
            oldValue.a(null);
        }
    }

    private final HashSet<c01.a> j() {
        return (HashSet) this.otherCollectionElementChangeHandlerSet.getValue();
    }

    @Override // c01.a
    public void a() {
        Set set;
        Set<c01.a> set2;
        set = CollectionsKt___CollectionsKt.toSet(j());
        g(this.propertyName);
        if (!j().isEmpty()) {
            set2 = CollectionsKt___CollectionsKt.toSet(j());
            for (c01.a aVar : set2) {
                if (set.contains(aVar)) {
                    aVar.a();
                }
            }
        }
    }

    @Override // c01.a
    public void b(c01.a otherHandler) {
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        j().remove(otherHandler);
    }

    @Override // c01.a
    public c01.a c() {
        Object first;
        if (!(!j().isEmpty())) {
            return null;
        }
        first = CollectionsKt___CollectionsKt.first(j());
        return (c01.a) first;
    }

    @Override // c01.a
    public void d(c01.a otherHandler) {
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        if (Intrinsics.areEqual(otherHandler, this)) {
            return;
        }
        j().add(otherHandler);
    }

    @Override // com.tencent.kuikly.core.reactive.a, kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public T getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.propertyName = property.getName();
        return (T) super.getValue(thisRef, property);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.reactive.a, kotlin.properties.ReadWriteProperty
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void setValue(Object thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(e(), value)) {
            return;
        }
        i((b) e());
        h(value);
        if (((b) e()).getHandler() == null) {
            ((b) e()).a(this);
        } else {
            c01.a handler = ((b) e()).getHandler();
            if (handler != null) {
                handler.d(this);
            }
        }
        g(this.propertyName);
    }
}
