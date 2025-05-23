package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$AddRealNameUserReq;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$AddRealNameUserRsp;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$DeleteRealNameUserReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0003\u0011\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameOperateRepo;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "", "hasRealName", "", "updateReadNameAccountFlag", "Lcom/tencent/ecommerce/biz/orders/realname/a;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo$a;", "createAccount", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "accountId", "deleteAccounts", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "_hasRealNameAccountFlag", "getHasRealNameAccount", "()Z", "hasRealNameAccount", "<init>", "()V", "b", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRealNameOperateRepo implements IECRealNameOperateRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private AtomicInteger _hasRealNameAccountFlag = new AtomicInteger(-1);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameOperateRepo$b;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo$a;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<RealNameAccount, IECRealNameOperateRepo.CreateRealNameAccountWrapper> {
        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IECRealNameOperateRepo.CreateRealNameAccountWrapper decodeResponse(byte[] rsp) {
            ECRealNameSvr$AddRealNameUserRsp mergeFrom = new ECRealNameSvr$AddRealNameUserRsp().mergeFrom(rsp);
            return new IECRealNameOperateRepo.CreateRealNameAccountWrapper(mergeFrom.alert_msg.get(), RealNameAccount.INSTANCE.a(mergeFrom.user.get()));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(RealNameAccount params, int channel, JSONObject reqExt) {
            ECRealNameSvr$AddRealNameUserReq eCRealNameSvr$AddRealNameUserReq = new ECRealNameSvr$AddRealNameUserReq();
            eCRealNameSvr$AddRealNameUserReq.name.set(params.name);
            eCRealNameSvr$AddRealNameUserReq.id_card.set(params.identityNumber);
            return eCRealNameSvr$AddRealNameUserReq.toByteArray();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createAccount(RealNameAccount realNameAccount, Continuation<? super ECNetworkResponse<IECRealNameOperateRepo.CreateRealNameAccountWrapper>> continuation) {
        ECRealNameOperateRepo$createAccount$1 eCRealNameOperateRepo$createAccount$1;
        Object coroutine_suspended;
        int i3;
        ECRealNameOperateRepo eCRealNameOperateRepo;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECRealNameOperateRepo$createAccount$1) {
            eCRealNameOperateRepo$createAccount$1 = (ECRealNameOperateRepo$createAccount$1) continuation;
            int i16 = eCRealNameOperateRepo$createAccount$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRealNameOperateRepo$createAccount$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRealNameOperateRepo$createAccount$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRealNameOperateRepo$createAccount$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = new b();
                    eCRealNameOperateRepo$createAccount$1.L$0 = this;
                    eCRealNameOperateRepo$createAccount$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.real_name_svr.RealNameSvr", "/trpc.ecom.real_name_svr.RealNameSvr/AddRealNameUser", bVar, realNameAccount, eCRealNameOperateRepo$createAccount$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCRealNameOperateRepo = this;
                } else if (i3 == 1) {
                    eCRealNameOperateRepo = (ECRealNameOperateRepo) eCRealNameOperateRepo$createAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    IECRealNameOperateRepo.CreateRealNameAccountWrapper createRealNameAccountWrapper = (IECRealNameOperateRepo.CreateRealNameAccountWrapper) eCNetworkResponse.b();
                    if ((createRealNameAccountWrapper != null ? createRealNameAccountWrapper.user : null) != null) {
                        eCRealNameOperateRepo._hasRealNameAccountFlag.set(1);
                    }
                }
                return eCNetworkResponse;
            }
        }
        eCRealNameOperateRepo$createAccount$1 = new ECRealNameOperateRepo$createAccount$1(this, continuation);
        Object obj2 = eCRealNameOperateRepo$createAccount$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRealNameOperateRepo$createAccount$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        return eCNetworkResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteAccounts(String str, Continuation<? super Boolean> continuation) {
        ECRealNameOperateRepo$deleteAccounts$1 eCRealNameOperateRepo$deleteAccounts$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECRealNameOperateRepo$deleteAccounts$1) {
            eCRealNameOperateRepo$deleteAccounts$1 = (ECRealNameOperateRepo$deleteAccounts$1) continuation;
            int i16 = eCRealNameOperateRepo$deleteAccounts$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRealNameOperateRepo$deleteAccounts$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRealNameOperateRepo$deleteAccounts$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRealNameOperateRepo$deleteAccounts$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    c cVar = new c();
                    eCRealNameOperateRepo$deleteAccounts$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.real_name_svr.RealNameSvr", "/trpc.ecom.real_name_svr.RealNameSvr/DeleteRealNameUser", cVar, str, eCRealNameOperateRepo$deleteAccounts$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(((ECNetworkResponse) obj).getCode() == 0);
            }
        }
        eCRealNameOperateRepo$deleteAccounts$1 = new ECRealNameOperateRepo$deleteAccounts$1(this, continuation);
        Object obj2 = eCRealNameOperateRepo$deleteAccounts$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRealNameOperateRepo$deleteAccounts$1.label;
        if (i3 != 0) {
        }
        return Boxing.boxBoolean(((ECNetworkResponse) obj2).getCode() == 0);
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo
    public boolean getHasRealNameAccount() {
        return this._hasRealNameAccountFlag.get() == 1;
    }

    @Override // com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo
    public void updateReadNameAccountFlag(boolean hasRealName) {
        this._hasRealNameAccountFlag.set(hasRealName ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/ECRealNameOperateRepo$c;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkPBContracts<String, Unit> {
        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECRealNameSvr$DeleteRealNameUserReq eCRealNameSvr$DeleteRealNameUserReq = new ECRealNameSvr$DeleteRealNameUserReq();
            eCRealNameSvr$DeleteRealNameUserReq.f105259id.set(params);
            return eCRealNameSvr$DeleteRealNameUserReq.toByteArray();
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        public /* bridge */ /* synthetic */ Unit decodeResponse(byte[] bArr) {
            a(bArr);
            return Unit.INSTANCE;
        }

        public void a(byte[] rsp) {
        }
    }
}
