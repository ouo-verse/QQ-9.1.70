package com.tencent.mobileqq.minigame.metafarm.network;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatus;
import com.tencent.mobileqq.minigame.proto.MiniGameMetaFarmProfile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J$\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J^\u0010\u0019\u001a\u00020\u000f2T\u0010\u001a\u001aP\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u0001`\u0010H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\\\u0010\u0006\u001aP\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmGetStatusListRequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/metafarm/network/MetaFarmGetStatusListRequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmGetStatusListRequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "getStatusList", "handleGetStatusListRsp", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "setListener", "listener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmGetStatusListRequest {
    public static final String REQUEST_CMD = "/v1/1826";
    private static final String TAG = "MetaFarmGetStatusListRequest";
    private final MetaFarmGetStatusListRequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.metafarm.network.MetaFarmGetStatusListRequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(MetaFarmGetStatusListRequest.REQUEST_CMD);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if (Intrinsics.areEqual(MetaFarmGetStatusListRequest.REQUEST_CMD, cmd)) {
                MetaFarmGetStatusListRequest.this.handleGetStatusListRsp(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super List<MetaFarmStatus>, Unit> requestCallback;

    public void setListener(Function2<? super Boolean, ? super List<MetaFarmStatus>, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        this.requestCallback = listener;
    }

    public void getStatusList() {
        QLog.d(TAG, 1, "getStatusList");
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_CMD, false, new MiniGameMetaFarmProfile.GetPredefinedFarmStatusReq().toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGetStatusListRsp(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        if (ret == 0 && rsp != null && request != null) {
            MiniGameMetaFarmProfile.GetPredefinedFarmStatusRsp getPredefinedFarmStatusRsp = new MiniGameMetaFarmProfile.GetPredefinedFarmStatusRsp();
            getPredefinedFarmStatusRsp.mergeFrom(rsp.data.get().toByteArray());
            List<MiniGameMetaFarmProfile.FarmStatus> list = getPredefinedFarmStatusRsp.statuses.get();
            QLog.d(TAG, 1, "handleGetStatusListRsp statusList:" + list);
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (MiniGameMetaFarmProfile.FarmStatus farmStatus : list) {
                    arrayList.add(new MetaFarmStatus(farmStatus.status_id.get(), farmStatus.icon.get(), farmStatus.desc.get()));
                }
            }
            Function2<? super Boolean, ? super List<MetaFarmStatus>, Unit> function2 = this.requestCallback;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, arrayList);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleGetStatusListRsp ret:" + ret + " rsp:" + rsp);
        Function2<? super Boolean, ? super List<MetaFarmStatus>, Unit> function22 = this.requestCallback;
        if (function22 != null) {
            function22.invoke(Boolean.FALSE, null);
        }
    }
}
