package com.tencent.mobileqq.zplan.cc;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0017\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\b\u001a\u00020\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/a;", "T", "", "d", "()Ljava/lang/Object;", "", "e", "", "c", "", "b", "a", "(Ljava/lang/Object;)V", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "cache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LinkedList<T> cache = new LinkedList<>();

    public final void b(Collection<? extends T> c16) {
        Intrinsics.checkNotNullParameter(c16, "c");
        this.cache.addAll(c16);
    }

    public final void c() {
        if (e() == 0) {
            return;
        }
        this.cache.clear();
    }

    public final T d() {
        return this.cache.pollFirst();
    }

    public final int e() {
        return this.cache.size();
    }

    public final void a(T c16) {
        if (c16 != null) {
            this.cache.add(c16);
        }
    }
}
