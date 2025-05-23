package com.tencent.mobileqq.minigame.share;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.share.MiniGameArkShare;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016J$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002JP\u0010!\u001a\u00020\u000e2F\u0010\"\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005RZ\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/minigame/share/MiniGameGetShareArkRequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/share/MiniGameGetShareArkRequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/share/MiniGameGetShareArkRequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "getRequestCallback", "()Lkotlin/jvm/functions/Function2;", "setRequestCallback", "(Lkotlin/jvm/functions/Function2;)V", "getArkJson", "appId", "title", "desc", WadlProxyConsts.KEY_JUMP_URL, "preview", "handleGetArkJsonRsp", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "setListener", "listener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniGameGetShareArkRequest {
    public static final String REQUEST_CMD = "/v1/1735";
    private static final String TAG = "MiniGameGetShareArkRequest";
    private final MiniGameGetShareArkRequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.share.MiniGameGetShareArkRequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(MiniGameGetShareArkRequest.REQUEST_CMD);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if (Intrinsics.areEqual(MiniGameGetShareArkRequest.REQUEST_CMD, cmd)) {
                MiniGameGetShareArkRequest.this.handleGetArkJsonRsp(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super String, Unit> requestCallback;

    public void getArkJson(String appId, String title, String desc, String jumpUrl, String preview) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(preview, "preview");
        MiniGameArkShare.GenMiniGameArkJsonReq genMiniGameArkJsonReq = new MiniGameArkShare.GenMiniGameArkJsonReq();
        genMiniGameArkJsonReq.appid.set(appId);
        genMiniGameArkJsonReq.title.set(title);
        genMiniGameArkJsonReq.desc.set(desc);
        genMiniGameArkJsonReq.jump_url.set(jumpUrl);
        genMiniGameArkJsonReq.preview.set(preview);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_CMD, false, genMiniGameArkJsonReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public final Function2<Boolean, String, Unit> getRequestCallback() {
        return this.requestCallback;
    }

    public void setListener(Function2<? super Boolean, ? super String, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        this.requestCallback = listener;
    }

    public final void setRequestCallback(Function2<? super Boolean, ? super String, Unit> function2) {
        this.requestCallback = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGetArkJsonRsp(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        if (ret == 0 && rsp != null && request != null) {
            MiniGameArkShare.GenMiniGameArkJsonRsp genMiniGameArkJsonRsp = new MiniGameArkShare.GenMiniGameArkJsonRsp();
            genMiniGameArkJsonRsp.mergeFrom(rsp.data.get().toByteArray());
            String str = genMiniGameArkJsonRsp.ark_json.get();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleGetArkJsonRsp arkJson:" + str);
            }
            Function2<? super Boolean, ? super String, Unit> function2 = this.requestCallback;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, str);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleGetArkJsonRsp ret:" + ret + " rsp:" + rsp);
        Function2<? super Boolean, ? super String, Unit> function22 = this.requestCallback;
        if (function22 != null) {
            function22.invoke(Boolean.FALSE, null);
        }
    }
}
