package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.realname.ECRealNameListRepo;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$QueryRealNameListReq;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$QueryRealNameListRsp;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$User;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\rJ'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ/\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/orders/realname/ECRealNameListRepo$realNameListDataSource$1", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/biz/orders/realname/b;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "l", "(Lcom/tencent/ecommerce/biz/orders/realname/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extra", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/ecommerce/biz/orders/realname/b;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DomainData.DOMAIN_NAME, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRealNameListRepo$realNameListDataSource$1 extends BaseListDataSource<RealNameAccountsReqInfo, RealNameAccount, String> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ECRealNameListRepo f103738b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006*\u0001\u0000\b\u008a\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/ecommerce/biz/orders/realname/ECRealNameListRepo$realNameListDataSource$1.ECRealNameListContract", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/orders/realname/b;", "Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameListRepo$b;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "<init>", "(Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameListRepo$realNameListDataSource$1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class a implements IECNetworkPBContracts<RealNameAccountsReqInfo, ECRealNameListRepo.RealNameAccountListWrapper> {
        public a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECRealNameListRepo.RealNameAccountListWrapper decodeResponse(byte[] rsp) {
            int collectionSizeOrDefault;
            ECRealNameSvr$QueryRealNameListRsp mergeFrom = new ECRealNameSvr$QueryRealNameListRsp().mergeFrom(rsp);
            List<ECRealNameSvr$User> list = mergeFrom.users.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(RealNameAccount.INSTANCE.a((ECRealNameSvr$User) it.next()));
            }
            return new ECRealNameListRepo.RealNameAccountListWrapper(arrayList, mergeFrom.cookie.get());
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(RealNameAccountsReqInfo params, int channel, JSONObject reqExt) {
            ECRealNameSvr$QueryRealNameListReq eCRealNameSvr$QueryRealNameListReq = new ECRealNameSvr$QueryRealNameListReq();
            eCRealNameSvr$QueryRealNameListReq.cookie.set(params.cookie);
            return eCRealNameSvr$QueryRealNameListReq.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECRealNameListRepo$realNameListDataSource$1(ECRealNameListRepo eCRealNameListRepo) {
        this.f103738b = eCRealNameListRepo;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(RealNameAccountsReqInfo realNameAccountsReqInfo, Continuation<? super IListRepository.Result<RealNameAccount, String>> continuation) {
        ECRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1 eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1;
        Object coroutine_suspended;
        int i3;
        ECRealNameListRepo$realNameListDataSource$1 eCRealNameListRepo$realNameListDataSource$1;
        IListRepository.Result result;
        IECRealNameOperateRepo iECRealNameOperateRepo;
        if (continuation instanceof ECRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1) {
            eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1 = (ECRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1) continuation;
            int i16 = eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RealNameAccountsReqInfo realNameAccountsReqInfo2 = new RealNameAccountsReqInfo(null, 1, null);
                    eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.L$0 = this;
                    eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.label = 1;
                    obj = n(realNameAccountsReqInfo2, eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCRealNameListRepo$realNameListDataSource$1 = this;
                } else if (i3 == 1) {
                    eCRealNameListRepo$realNameListDataSource$1 = (ECRealNameListRepo$realNameListDataSource$1) eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = (IListRepository.Result) obj;
                if (result.isSucceeded) {
                    iECRealNameOperateRepo = eCRealNameListRepo$realNameListDataSource$1.f103738b.realNameRepo;
                    iECRealNameOperateRepo.updateReadNameAccountFlag(!result.d().isEmpty());
                }
                return result;
            }
        }
        eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1 = new ECRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1(this, continuation);
        Object obj2 = eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1.label;
        if (i3 != 0) {
        }
        result = (IListRepository.Result) obj2;
        if (result.isSucceeded) {
        }
        return result;
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Object h(RealNameAccountsReqInfo realNameAccountsReqInfo, String str, Continuation<? super IListRepository.Result<RealNameAccount, String>> continuation) {
        return n(new RealNameAccountsReqInfo(str), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object n(RealNameAccountsReqInfo realNameAccountsReqInfo, Continuation<? super IListRepository.Result<RealNameAccount, String>> continuation) {
        ECRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1 eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        List<RealNameAccount> emptyList;
        String str;
        String str2;
        List emptyList2;
        if (continuation instanceof ECRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1) {
            eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1 = (ECRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1) continuation;
            int i16 = eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = new a();
                    eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.real_name_svr.RealNameSvr", "/trpc.ecom.real_name_svr.RealNameSvr/QueryRealNameList", aVar, realNameAccountsReqInfo, eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                ECRealNameListRepo.RealNameAccountListWrapper realNameAccountListWrapper = (ECRealNameListRepo.RealNameAccountListWrapper) eCNetworkResponse.b();
                boolean z16 = false;
                if (eCNetworkResponse.getCode() == 0) {
                    cg0.a.a("ECRealNameListRepo", "loadPageFromServer", "load real name list error, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    return new IListRepository.Result(false, emptyList2, false, null);
                }
                if (realNameAccountListWrapper == null || (emptyList = realNameAccountListWrapper.a()) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                if (realNameAccountListWrapper != null && (str2 = realNameAccountListWrapper.cookie) != null) {
                    if (str2.length() > 0) {
                        z16 = true;
                    }
                }
                if (realNameAccountListWrapper == null || (str = realNameAccountListWrapper.cookie) == null) {
                    str = "";
                }
                return new IListRepository.Result(true, emptyList, z16, str);
            }
        }
        eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1 = new ECRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1(this, continuation);
        Object obj2 = eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRealNameListRepo$realNameListDataSource$1$loadPageFromServer$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        ECRealNameListRepo.RealNameAccountListWrapper realNameAccountListWrapper2 = (ECRealNameListRepo.RealNameAccountListWrapper) eCNetworkResponse.b();
        boolean z162 = false;
        if (eCNetworkResponse.getCode() == 0) {
        }
    }
}
