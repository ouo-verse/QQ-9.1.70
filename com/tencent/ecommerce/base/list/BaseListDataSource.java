package com.tencent.ecommerce.base.list;

import ADV_REPORT.mobile_adv_report_req;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.IListRepository;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0006\u001a\u00020\u0005J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000bH\u0016J+\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016J'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0016J/\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR:\u0010\"\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "REQUEST", "BEAN", "EXTRA", "", "", "b", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "g", "(Ljava/lang/Object;)Lcom/tencent/ecommerce/base/list/IListRepository$a;", "Lkotlin/Function1;", "", "predicate", "j", "newBean", "k", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "bean", "a", "(Ljava/lang/Object;)V", "e", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "c", "extra", tl.h.F, "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "getMemoryCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setMemoryCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "memoryCacheMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class BaseListDataSource<REQUEST, BEAN, EXTRA> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<REQUEST, IListRepository.Result<BEAN, EXTRA>> memoryCacheMap = new ConcurrentHashMap<>();

    static /* synthetic */ Object f(BaseListDataSource baseListDataSource, Object obj, Continuation continuation) {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new IListRepository.Result(true, emptyList, false, null);
    }

    static /* synthetic */ Object i(BaseListDataSource baseListDataSource, Object obj, Object obj2, Continuation continuation) {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new IListRepository.Result(true, emptyList, false, null);
    }

    public final void b() {
        this.memoryCacheMap.clear();
    }

    public abstract Object c(REQUEST request, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation);

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(REQUEST request, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation) {
        BaseListDataSource$loadFirstPageFromServerAndCache$1 baseListDataSource$loadFirstPageFromServerAndCache$1;
        Object coroutine_suspended;
        int i3;
        BaseListDataSource<REQUEST, BEAN, EXTRA> baseListDataSource;
        IListRepository.Result result;
        if (continuation instanceof BaseListDataSource$loadFirstPageFromServerAndCache$1) {
            baseListDataSource$loadFirstPageFromServerAndCache$1 = (BaseListDataSource$loadFirstPageFromServerAndCache$1) continuation;
            int i16 = baseListDataSource$loadFirstPageFromServerAndCache$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                baseListDataSource$loadFirstPageFromServerAndCache$1.label = i16 - Integer.MIN_VALUE;
                Object obj = baseListDataSource$loadFirstPageFromServerAndCache$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = baseListDataSource$loadFirstPageFromServerAndCache$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    baseListDataSource$loadFirstPageFromServerAndCache$1.L$0 = this;
                    baseListDataSource$loadFirstPageFromServerAndCache$1.L$1 = request;
                    baseListDataSource$loadFirstPageFromServerAndCache$1.label = 1;
                    obj = c(request, baseListDataSource$loadFirstPageFromServerAndCache$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    baseListDataSource = this;
                } else if (i3 == 1) {
                    request = (REQUEST) baseListDataSource$loadFirstPageFromServerAndCache$1.L$1;
                    baseListDataSource = (BaseListDataSource) baseListDataSource$loadFirstPageFromServerAndCache$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = (IListRepository.Result) obj;
                if (result.isSucceeded) {
                    baseListDataSource.memoryCacheMap.put(request, result);
                }
                return result;
            }
        }
        baseListDataSource$loadFirstPageFromServerAndCache$1 = new BaseListDataSource$loadFirstPageFromServerAndCache$1(this, continuation);
        Object obj2 = baseListDataSource$loadFirstPageFromServerAndCache$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = baseListDataSource$loadFirstPageFromServerAndCache$1.label;
        if (i3 != 0) {
        }
        result = (IListRepository.Result) obj2;
        if (result.isSucceeded) {
        }
        return result;
    }

    public Object e(REQUEST request, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation) {
        return f(this, request, continuation);
    }

    public IListRepository.Result<BEAN, EXTRA> g(REQUEST request) {
        List emptyList;
        IListRepository.Result<BEAN, EXTRA> result = this.memoryCacheMap.get(request);
        if (result != null) {
            return result;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new IListRepository.Result<>(true, emptyList, false, null);
    }

    public Object h(REQUEST request, EXTRA extra, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation) {
        return i(this, request, extra, continuation);
    }

    public void j(final Function1<? super BEAN, Boolean> predicate) {
        List mutableList;
        boolean removeAll;
        List list;
        Iterator<T> it = this.memoryCacheMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ((IListRepository.Result) entry.getValue()).d());
            removeAll = CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<BEAN, Boolean>() { // from class: com.tencent.ecommerce.base.list.BaseListDataSource$remove$$inlined$forEach$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return Boolean.valueOf(invoke2((BaseListDataSource$remove$$inlined$forEach$lambda$1<BEAN>) obj));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(BEAN bean) {
                    return ((Boolean) predicate.invoke(bean)).booleanValue();
                }
            });
            if (removeAll) {
                IListRepository.Result result = (IListRepository.Result) entry.getValue();
                list = CollectionsKt___CollectionsKt.toList(mutableList);
                this.memoryCacheMap.put(entry.getKey(), IListRepository.Result.b(result, false, list, false, null, 13, null));
            }
        }
    }

    public void k(BEAN newBean, Function1<? super BEAN, Boolean> predicate) {
        List mutableList;
        List list;
        Iterator<T> it = this.memoryCacheMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ((IListRepository.Result) entry.getValue()).d());
            List<mobile_adv_report_req> list2 = mutableList;
            boolean z16 = false;
            int i3 = 0;
            for (mobile_adv_report_req mobile_adv_report_reqVar : list2) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (predicate.invoke(mobile_adv_report_reqVar).booleanValue()) {
                    mutableList.set(i3, newBean);
                    z16 = true;
                }
                i3 = i16;
            }
            if (z16) {
                IListRepository.Result result = (IListRepository.Result) entry.getValue();
                list = CollectionsKt___CollectionsKt.toList(list2);
                this.memoryCacheMap.put(entry.getKey(), IListRepository.Result.b(result, false, list, false, null, 13, null));
            }
        }
    }

    public void a(BEAN bean) {
    }
}
