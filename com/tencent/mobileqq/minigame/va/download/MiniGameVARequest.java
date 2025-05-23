package com.tencent.mobileqq.minigame.va.download;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.download.DownloadManagerProto;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0004\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016JP\u0010\u001f\u001a\u00020\u000e2F\u0010 \u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005RZ\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MiniGameVARequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/va/download/MiniGameVARequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVARequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "getRequestCallback", "()Lkotlin/jvm/functions/Function2;", "setRequestCallback", "(Lkotlin/jvm/functions/Function2;)V", "handleGameDownload", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "requestGameDownload", "appId", "", PushClientConstants.TAG_PKG_NAME, "setListener", "listener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniGameVARequest {
    private static final String APPID = "appId";
    private static final String CHANNEL_ID = "10000144";
    private static final String REQUEST_DOWNLOAD_CMD = "/v1/836";
    private static final String TAG = "MiniGameVARequest";
    private final MiniGameVARequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.va.download.MiniGameVARequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("/v1/836");
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if ("/v1/836".equals(cmd)) {
                MiniGameVARequest.this.handleGameDownload(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super MiniGameDownloadData, Unit> requestCallback;

    public final Function2<Boolean, MiniGameDownloadData, Unit> getRequestCallback() {
        return this.requestCallback;
    }

    public void requestGameDownload(String appId, String pkgName) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        DownloadManagerProto.QueryDownloadReq queryDownloadReq = new DownloadManagerProto.QueryDownloadReq();
        queryDownloadReq.platform.set(1);
        queryDownloadReq.channel_id.set("10000144");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(appId);
        queryDownloadReq.app_ids.set(listOf);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_DOWNLOAD_CMD, false, queryDownloadReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        Bundle bundle = new Bundle();
        bundle.putString("appId", appId);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    public void setListener(Function2<? super Boolean, ? super MiniGameDownloadData, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        this.requestCallback = listener;
    }

    public final void setRequestCallback(Function2<? super Boolean, ? super MiniGameDownloadData, Unit> function2) {
        this.requestCallback = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGameDownload(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        if (ret == 0 && rsp != null && request != null) {
            String stringExtra = request.getStringExtra("appId");
            DownloadManagerProto.QueryDownloadRsp queryDownloadRsp = new DownloadManagerProto.QueryDownloadRsp();
            queryDownloadRsp.mergeFrom(rsp.data.get().toByteArray());
            List<DownloadManagerProto.Download> list = queryDownloadRsp.apps.get();
            if (list != null) {
                for (DownloadManagerProto.Download download : list) {
                    if (download.appid.get().equals(stringExtra)) {
                        MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
                        String str = download.appid.get();
                        Intrinsics.checkNotNullExpressionValue(str, "app.appid.get()");
                        miniGameDownloadData.setGameId(str);
                        String str2 = download.app_icon.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "app.app_icon.get()");
                        miniGameDownloadData.setGameIcon(str2);
                        String str3 = download.app_name.get();
                        Intrinsics.checkNotNullExpressionValue(str3, "app.app_name.get()");
                        miniGameDownloadData.setGameName(str3);
                        miniGameDownloadData.setPkgName(download.pkg_name.get());
                        miniGameDownloadData.setVersionCode(download.version_code.get());
                        miniGameDownloadData.setDownloadUrl(download.download_url.get());
                        miniGameDownloadData.setTickets(download.tickets.get());
                        miniGameDownloadData.setMiniVersionCode(download.min_update_version_code.get());
                        miniGameDownloadData.setSize(download.pkg_size.get());
                        Function2<? super Boolean, ? super MiniGameDownloadData, Unit> function2 = this.requestCallback;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, miniGameDownloadData);
                        }
                    }
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleGameDownload ret:" + ret + " rsp:" + rsp);
        Function2<? super Boolean, ? super MiniGameDownloadData, Unit> function22 = this.requestCallback;
        if (function22 != null) {
            function22.invoke(Boolean.FALSE, null);
        }
    }
}
