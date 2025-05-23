package com.tencent.ecommerce.repo.commission.subsidy;

import com.tencent.ecommerce.base.network.api.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tj0.b;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\tJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/repo/commission/subsidy/a;", "", "Ltj0/b;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cookie", "Lsj0/a;", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltj0/a;", "d", "token", "Lcom/tencent/ecommerce/base/network/api/d;", "Lsj0/d;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface a {
    Object a(String str, Continuation<? super d<sj0.d>> continuation);

    Object b(Continuation<? super b> continuation);

    Object c(String str, Continuation<? super sj0.a> continuation);

    Object d(String str, Continuation<? super tj0.a> continuation);
}
