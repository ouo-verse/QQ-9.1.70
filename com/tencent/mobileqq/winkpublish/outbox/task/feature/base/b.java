package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\t\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "d", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "b", "()Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "c", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "next", "<init>", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class b implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b next;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: b, reason: from getter */
    public final b getNext() {
        return this.next;
    }

    public final void c(b bVar) {
        this.next = bVar;
    }

    public b(b bVar) {
        this.next = bVar;
    }

    public /* synthetic */ b(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
