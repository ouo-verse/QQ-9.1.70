package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.ListRepository;
import com.tencent.ecommerce.repo.ServiceLocator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002\u0011\u0017B\u0007\u00a2\u0006\u0004\b&\u0010'J'\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR-\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR,\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100 8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameListRepo;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameListRepo;", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "", "predicate", "", "deleteAccount", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bean", "addAccount", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAccount", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/list/IListRepository;", "Lcom/tencent/ecommerce/biz/orders/realname/b;", "", "a", "Lkotlin/Lazy;", "getListRepository", "()Lcom/tencent/ecommerce/base/list/IListRepository;", "listRepository", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "b", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "realNameRepo", "Lcom/tencent/ecommerce/base/list/b;", "c", "Lcom/tencent/ecommerce/base/list/b;", "getListOperator", "()Lcom/tencent/ecommerce/base/list/b;", "listOperator", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "d", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "getRealNameListDataSource", "()Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "realNameListDataSource", "<init>", "()V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRealNameListRepo implements IECRealNameListRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy listRepository;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final IECRealNameOperateRepo realNameRepo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.base.list.b<RealNameAccount> listOperator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final BaseListDataSource<RealNameAccountsReqInfo, RealNameAccount, String> realNameListDataSource;

    public ECRealNameListRepo() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ListRepository<RealNameAccountsReqInfo, RealNameAccount, String>>() { // from class: com.tencent.ecommerce.biz.orders.realname.ECRealNameListRepo$listRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ListRepository<RealNameAccountsReqInfo, RealNameAccount, String> invoke() {
                return new ListRepository<>(ECRealNameListRepo.this.getRealNameListDataSource(), ECRealNameListRepo.this.getListOperator(), null, 4, null);
            }
        });
        this.listRepository = lazy;
        this.realNameRepo = ServiceLocator.f104891i.p();
        this.listOperator = new com.tencent.ecommerce.base.list.b<>();
        this.realNameListDataSource = new ECRealNameListRepo$realNameListDataSource$1(this);
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo
    public Object addAccount(RealNameAccount realNameAccount, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object a16 = getListOperator().a(realNameAccount, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return a16 == coroutine_suspended ? a16 : Unit.INSTANCE;
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo
    public Object deleteAccount(Function1<? super RealNameAccount, Boolean> function1, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object c16 = getListOperator().c(function1, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c16 == coroutine_suspended ? c16 : Unit.INSTANCE;
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo
    public com.tencent.ecommerce.base.list.b<RealNameAccount> getListOperator() {
        return this.listOperator;
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo
    public BaseListDataSource<RealNameAccountsReqInfo, RealNameAccount, String> getRealNameListDataSource() {
        return this.realNameListDataSource;
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo
    public Object updateAccount(RealNameAccount realNameAccount, Function1<? super RealNameAccount, Boolean> function1, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object d16 = getListOperator().d(realNameAccount, function1, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d16 == coroutine_suspended ? d16 : Unit.INSTANCE;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameListRepo$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "datas", "b", "Ljava/lang/String;", "cookie", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.realname.ECRealNameListRepo$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class RealNameAccountListWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<RealNameAccount> datas;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String cookie;

        public RealNameAccountListWrapper(List<RealNameAccount> list, String str) {
            this.datas = list;
            this.cookie = str;
        }

        public final List<RealNameAccount> a() {
            return this.datas;
        }

        public int hashCode() {
            List<RealNameAccount> list = this.datas;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.cookie;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "RealNameAccountListWrapper(datas=" + this.datas + ", cookie=" + this.cookie + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RealNameAccountListWrapper)) {
                return false;
            }
            RealNameAccountListWrapper realNameAccountListWrapper = (RealNameAccountListWrapper) other;
            return Intrinsics.areEqual(this.datas, realNameAccountListWrapper.datas) && Intrinsics.areEqual(this.cookie, realNameAccountListWrapper.cookie);
        }
    }
}
