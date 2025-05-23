package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/r;", "Ld01/n;", "Lkotlin/Function0;", "", "task", "b", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class r implements d01.n {

    /* renamed from: a, reason: collision with root package name */
    public static final r f262806a = new r();

    r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // d01.n
    public void a(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.q
            @Override // java.lang.Runnable
            public final void run() {
                r.f(Function0.this);
            }
        }, 192, null, true);
    }

    @Override // d01.n
    public void b(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.p
            @Override // java.lang.Runnable
            public final void run() {
                r.e(Function0.this);
            }
        });
    }
}
