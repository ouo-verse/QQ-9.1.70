package com.tencent.mobileqq.minigame.metafarm.network;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.proto.MiniGameMetaFarmProfile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002JP\u0010\u001b\u001a\u00020\u000e2F\u0010\u001c\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005RZ\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmSetStatusRequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/metafarm/network/MetaFarmSetStatusRequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmSetStatusRequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "getRequestCallback", "()Lkotlin/jvm/functions/Function2;", "setRequestCallback", "(Lkotlin/jvm/functions/Function2;)V", "handleSetStatusRsp", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "setListener", "listener", "setStatus", "status", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmSetStatusRequest {
    public static final String REQUEST_CMD = "/v1/1825";
    private static final String TAG = "MetaFarmSetStatusRequest";
    private final MetaFarmSetStatusRequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.metafarm.network.MetaFarmSetStatusRequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(MetaFarmSetStatusRequest.REQUEST_CMD);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if (Intrinsics.areEqual(MetaFarmSetStatusRequest.REQUEST_CMD, cmd)) {
                MetaFarmSetStatusRequest.this.handleSetStatusRsp(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super Integer, Unit> requestCallback;

    public final Function2<Boolean, Integer, Unit> getRequestCallback() {
        return this.requestCallback;
    }

    public void setListener(Function2<? super Boolean, ? super Integer, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        this.requestCallback = listener;
    }

    public final void setRequestCallback(Function2<? super Boolean, ? super Integer, Unit> function2) {
        this.requestCallback = function2;
    }

    public void setStatus(int status) {
        QLog.d(TAG, 1, "setStatus status:" + status);
        MiniGameMetaFarmProfile.SetFarmStatusReq setFarmStatusReq = new MiniGameMetaFarmProfile.SetFarmStatusReq();
        setFarmStatusReq.status.set(status);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_CMD, false, setFarmStatusReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSetStatusRsp(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        if (ret == 0 && rsp != null && request != null) {
            MiniGameMetaFarmProfile.SetFarmStatusRsp setFarmStatusRsp = new MiniGameMetaFarmProfile.SetFarmStatusRsp();
            setFarmStatusRsp.mergeFrom(rsp.data.get().toByteArray());
            int i3 = setFarmStatusRsp.status.get();
            QLog.d(TAG, 1, "handleSetStatusRsp status:" + i3);
            Function2<? super Boolean, ? super Integer, Unit> function2 = this.requestCallback;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, Integer.valueOf(i3));
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleSetStatusRsp ret:" + ret + " rsp:" + rsp);
        Function2<? super Boolean, ? super Integer, Unit> function22 = this.requestCallback;
        if (function22 != null) {
            function22.invoke(Boolean.FALSE, null);
        }
    }
}
