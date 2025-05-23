package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.ecommerce.base.list.BaseListDataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameListRepo;", "", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "", "predicate", "", "deleteAccount", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bean", "addAccount", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAccount", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/list/b;", "getListOperator", "()Lcom/tencent/ecommerce/base/list/b;", "listOperator", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/biz/orders/realname/b;", "", "getRealNameListDataSource", "()Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "realNameListDataSource", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECRealNameListRepo {
    Object addAccount(RealNameAccount realNameAccount, Continuation<? super Unit> continuation);

    Object deleteAccount(Function1<? super RealNameAccount, Boolean> function1, Continuation<? super Unit> continuation);

    com.tencent.ecommerce.base.list.b<RealNameAccount> getListOperator();

    BaseListDataSource<RealNameAccountsReqInfo, RealNameAccount, String> getRealNameListDataSource();

    Object updateAccount(RealNameAccount realNameAccount, Function1<? super RealNameAccount, Boolean> function1, Continuation<? super Unit> continuation);
}
