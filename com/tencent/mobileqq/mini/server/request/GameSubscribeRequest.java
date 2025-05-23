package com.tencent.mobileqq.mini.server.request;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.trpcprotocol.metadream.gc_metadream_user_center.gc_metadream_user_center.GcMetadreamUserCenterPB$AppServiceTplSubReq;
import com.tencent.trpcprotocol.metadream.gc_metadream_user_center.gc_metadream_user_center.GcMetadreamUserCenterPB$AppServiceTplSubRsp;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/GameSubscribeRequest;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "()V", "requestCallback", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/AsyncResult;", "getFilterCmds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "onTrpcRsp", "", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "cmd", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "subscribePARequest", "appId", "callback", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GameSubscribeRequest implements WadlTrpcListener {
    private static final String SUBSCRIBE_PA_CMD = "/v1/1874";
    private static final String TAG = "GameSubscribeRequest";
    private AsyncResult requestCallback;

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        HashSet<String> hashSetOf;
        hashSetOf = SetsKt__SetsKt.hashSetOf(SUBSCRIBE_PA_CMD);
        return hashSetOf;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        try {
            if (Intrinsics.areEqual(cmd, SUBSCRIBE_PA_CMD)) {
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
                if (rsp == null) {
                    AsyncResult asyncResult = this.requestCallback;
                    if (asyncResult != null) {
                        asyncResult.onReceiveResult(false, null);
                    }
                    QLog.e(TAG, 1, "onTrpcRsp: rsp is null.");
                    return;
                }
                GcMetadreamUserCenterPB$AppServiceTplSubRsp gcMetadreamUserCenterPB$AppServiceTplSubRsp = new GcMetadreamUserCenterPB$AppServiceTplSubRsp();
                gcMetadreamUserCenterPB$AppServiceTplSubRsp.mergeFrom(rsp.data.get().toByteArray());
                AsyncResult asyncResult2 = this.requestCallback;
                if (asyncResult2 != null) {
                    asyncResult2.onReceiveResult(gcMetadreamUserCenterPB$AppServiceTplSubRsp.success.get(), null);
                }
                QLog.i(TAG, 1, "onTrpcRsp: result=" + gcMetadreamUserCenterPB$AppServiceTplSubRsp.success.get());
            }
        } catch (Throwable th5) {
            AsyncResult asyncResult3 = this.requestCallback;
            if (asyncResult3 != null) {
                asyncResult3.onReceiveResult(false, null);
            }
            QLog.e(TAG, 1, "onTrpcRsp: exception.", th5);
        }
    }

    public final void subscribePARequest(String appId, AsyncResult callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.requestCallback = callback;
        try {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
            GcMetadreamUserCenterPB$AppServiceTplSubReq gcMetadreamUserCenterPB$AppServiceTplSubReq = new GcMetadreamUserCenterPB$AppServiceTplSubReq();
            gcMetadreamUserCenterPB$AppServiceTplSubReq.appid.set(appId);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(SUBSCRIBE_PA_CMD, false, gcMetadreamUserCenterPB$AppServiceTplSubReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "subscribePARequest: failed, appId=" + appId, e16);
        }
    }
}
