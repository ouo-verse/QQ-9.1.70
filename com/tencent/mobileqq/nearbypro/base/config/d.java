package com.tencent.mobileqq.nearbypro.base.config;

import android.content.Context;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.ErrorRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.request.RspStatusType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016J6\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/config/d;", "Lcom/tencent/mobileqq/nearbypro/base/d;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "Rsp", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/nearbypro/request/b;", "listener", "", "e", "Landroid/content/Context;", "context", "d", "", "a", "<init>", "()V", "b", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d implements com.tencent.mobileqq.nearbypro.base.d<NearbyProBaseRequest> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J9\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0013\u001a\u00020\u0003*\u00020\u0012J\n\u0010\u0014\u001a\u00020\u0003*\u00020\u0005R%\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/config/d$b;", "Rsp", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "", "success", "", "retCode", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "req", "", "retMsg", "Lcom/tencent/mobileqq/nearbypro/request/d;", "c", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "t", "", "onReceive", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Ljava/lang/Object;)V", "", "a", "b", "Lcom/tencent/mobileqq/nearbypro/request/b;", "Lcom/tencent/mobileqq/nearbypro/request/b;", "getListener", "()Lcom/tencent/mobileqq/nearbypro/request/b;", "listener", "<init>", "(Lcom/tencent/mobileqq/nearbypro/request/b;)V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b<Rsp> implements VSDispatchObserver.OnVSRspCallBack<Rsp> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> listener;

        public b(@Nullable com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> bVar) {
            this.listener = bVar;
        }

        private final RspStatus c(boolean success, long retCode, NearbyProBaseRequest req, String retMsg) {
            if (success && !b(retCode)) {
                if (a(req.getTrpcRspRetCode())) {
                    return new RspStatus(RspStatusType.RPC_ERROR, req.getTrpcRspRetCode(), req.getTrpcFailMsg());
                }
                if (a(req.getTrpcRspFuncRetCode())) {
                    return new RspStatus(RspStatusType.RPC_FUNC_ERROR, req.getTrpcRspFuncRetCode(), req.getTrpcFailMsg());
                }
                return new RspStatus(RspStatusType.SUCCESS, retCode, retMsg);
            }
            if (a(req.getSsoResultCode())) {
                return new RspStatus(RspStatusType.SSO_ERROR, req.getSsoResultCode(), req.getSsoFailMsg());
            }
            return new RspStatus(RspStatusType.LOCAL_NET_ERROR, retCode, retMsg);
        }

        public final boolean a(int i3) {
            if (i3 != 0) {
                return true;
            }
            return false;
        }

        public final boolean b(long j3) {
            if (j3 != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(@NotNull BaseRequest req, boolean success, long retCode, @Nullable String retMsg, Rsp t16) {
            String b16;
            String b17;
            Intrinsics.checkNotNullParameter(req, "req");
            if (!(req instanceof NearbyProBaseRequest)) {
                j.c().d(NearbyProBaseRequest.TAG, "OnRecv unsupport!!! " + req);
                com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> bVar = this.listener;
                if (bVar != null) {
                    bVar.a(ErrorRequest.INSTANCE, new RspStatus(RspStatusType.UNKNOWN_ERROR, retCode, retMsg), null);
                    return;
                }
                return;
            }
            NearbyProBaseRequest nearbyProBaseRequest = (NearbyProBaseRequest) req;
            RspStatus c16 = c(success, retCode, nearbyProBaseRequest, retMsg);
            ga2.a c17 = j.c();
            if (!c16.c()) {
                String str = nearbyProBaseRequest.get$cmd();
                b17 = NearbyProNetworkHelperImplKt.b(t16);
                c17.d(NearbyProBaseRequest.TAG, "OnRecv cmd:" + str + " " + c16 + " " + b17);
            } else {
                String str2 = nearbyProBaseRequest.get$cmd();
                b16 = NearbyProNetworkHelperImplKt.b(t16);
                c17.e(NearbyProBaseRequest.TAG, "OnRecv cmd:" + str2 + " " + c16 + " " + b16);
            }
            com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> bVar2 = this.listener;
            if (bVar2 != null) {
                bVar2.a(req, c16, t16);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.base.d
    public void a(@Nullable Context context) {
        VSNetworkHelper.getInstance().cancelRequest(context);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public <Rsp> int c(@Nullable Context context, @NotNull NearbyProBaseRequest request, @Nullable com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> listener) {
        String b16;
        Intrinsics.checkNotNullParameter(request, "request");
        ga2.a c16 = j.c();
        String str = request.get$cmd();
        b16 = NearbyProNetworkHelperImplKt.b(request);
        c16.e(NearbyProBaseRequest.TAG, "OnSend cmd:" + str + " " + b16);
        return VSNetworkHelper.getInstance().sendRequest(context, request, new b(listener));
    }

    @Override // com.tencent.mobileqq.nearbypro.base.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public <Rsp> int b(@NotNull NearbyProBaseRequest request, @Nullable com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> listener) {
        String b16;
        Intrinsics.checkNotNullParameter(request, "request");
        ga2.a c16 = j.c();
        String str = request.get$cmd();
        b16 = NearbyProNetworkHelperImplKt.b(request);
        c16.e(NearbyProBaseRequest.TAG, "OnSend cmd:" + str + " " + b16);
        return VSNetworkHelper.getInstance().sendRequest(request, new b(listener));
    }
}
