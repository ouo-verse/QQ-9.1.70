package com.tencent.mobileqq.matchfriend.reborn.content.msg.settop;

import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\tJ\u0014\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0014\u0010\u000f\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0006\u0010\u0010\u001a\u00020\u0004R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/a;", "T", "", "value", "", "d", "(Ljava/lang/Object;)Z", "", "a", "(Ljava/lang/Object;)V", "g", "", "values", "b", "c", "e", "f", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "setsCache", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashSet<T> setsCache = new HashSet<>();

    public final void a(T value) {
        synchronized (this.setsCache) {
            if (!this.setsCache.contains(value)) {
                this.setsCache.add(value);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(Set<? extends T> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        synchronized (this.setsCache) {
            this.setsCache.addAll(values);
        }
    }

    public final Set<T> c() {
        HashSet hashSet;
        synchronized (this.setsCache) {
            hashSet = new HashSet();
            hashSet.addAll(this.setsCache);
        }
        return hashSet;
    }

    public final boolean d(T value) {
        boolean contains;
        synchronized (this.setsCache) {
            contains = this.setsCache.contains(value);
        }
        return contains;
    }

    public final void e(Set<? extends T> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        synchronized (this.setsCache) {
            this.setsCache.clear();
            b(values);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean f() {
        boolean isEmpty;
        synchronized (this.setsCache) {
            isEmpty = this.setsCache.isEmpty();
        }
        return isEmpty;
    }

    public final void g(T value) {
        synchronized (this.setsCache) {
            if (this.setsCache.contains(value)) {
                this.setsCache.remove(value);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
