package com.tencent.mobileqq.mini.server.request;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/ClearFarmNoticeNumRedDotRequest;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "()V", "requestCallback", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/AsyncResult;", "getFilterCmds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "onTrpcRsp", "", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "cmd", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "callback", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ClearFarmNoticeNumRedDotRequest implements WadlTrpcListener {
    private static final String CMD = "/v1/1973";
    private static final String TAG = "ClearFarmNoticeNumRedDo";
    private AsyncResult requestCallback;

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        HashSet<String> hashSetOf;
        hashSetOf = SetsKt__SetsKt.hashSetOf(CMD);
        return hashSetOf;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        PBInt32Field pBInt32Field;
        if (Intrinsics.areEqual(cmd, CMD)) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
            AsyncResult asyncResult = this.requestCallback;
            if (asyncResult != null) {
                boolean z16 = false;
                if (rsp != null && (pBInt32Field = rsp.ret) != null && pBInt32Field.get() == 0) {
                    z16 = true;
                }
                asyncResult.onReceiveResult(z16, null);
            }
        }
    }

    public final void request(AsyncResult callback) {
        this.requestCallback = callback;
        try {
            QRouteApi api = QRoute.api(IQQGameTrpcService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQGameTrpcService::class.java)");
            IQQGameTrpcService iQQGameTrpcService = (IQQGameTrpcService) api;
            iQQGameTrpcService.addListener(this);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = iQQGameTrpcService.createTrpcInvokeReq(CMD, false, new byte[0]);
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            iQQGameTrpcService.requestTrpc(trpcListReq, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "request: exception.", e16);
        }
    }
}
