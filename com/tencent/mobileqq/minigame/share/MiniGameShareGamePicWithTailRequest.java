package com.tencent.mobileqq.minigame.share;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.share.MiniGamePicShareWithTail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002JN\u0010\u0016\u001a\u00020\r2F\u0010\u0017\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u000eJ(\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005RN\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/share/MiniGameShareGamePicWithTailRequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/share/MiniGameShareGamePicWithTailRequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/share/MiniGameShareGamePicWithTailRequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "handleShareGamePicWithTailRsp", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "setListener", "listener", "shareGamePicWithTail", "appId", "", "picUrl", "scene", "", "receiver", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameShareGamePicWithTailRequest {
    public static final String REQUEST_CMD = "/v1/1736";
    public static final String TAG = "MiniGameShareGamePicWithTailRequest";
    private final MiniGameShareGamePicWithTailRequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.share.MiniGameShareGamePicWithTailRequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(MiniGameShareGamePicWithTailRequest.REQUEST_CMD);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if (Intrinsics.areEqual(MiniGameShareGamePicWithTailRequest.REQUEST_CMD, cmd)) {
                MiniGameShareGamePicWithTailRequest.this.handleShareGamePicWithTailRsp(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super Boolean, Unit> requestCallback;

    public final void shareGamePicWithTail(String appId, String picUrl, int scene, long receiver) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        MiniGamePicShareWithTail.SendMiniGamePicWithTailMsgReq sendMiniGamePicWithTailMsgReq = new MiniGamePicShareWithTail.SendMiniGamePicWithTailMsgReq();
        sendMiniGamePicWithTailMsgReq.appid.set(appId);
        sendMiniGamePicWithTailMsgReq.picUrl.set(picUrl);
        sendMiniGamePicWithTailMsgReq.scene.set(scene);
        sendMiniGamePicWithTailMsgReq.receiver.set(receiver);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_CMD, false, sendMiniGamePicWithTailMsgReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public final void setListener(Function2<? super Boolean, ? super Boolean, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        synchronized (this) {
            this.requestCallback = listener;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleShareGamePicWithTailRsp(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        boolean z16 = true;
        if (ret == 0 && rsp != null && request != null && rsp.data.get() != null) {
            MiniGamePicShareWithTail.SendMiniGamePicWithTailMsgRsp sendMiniGamePicWithTailMsgRsp = new MiniGamePicShareWithTail.SendMiniGamePicWithTailMsgRsp();
            sendMiniGamePicWithTailMsgRsp.mergeFrom(rsp.data.get().toByteArray());
            int i3 = sendMiniGamePicWithTailMsgRsp.isSuccess.get();
            QLog.i(TAG, 2, "handleShareGamePicWithTailRsp isSuccess:" + i3);
            synchronized (this) {
                Function2<? super Boolean, ? super Boolean, Unit> function2 = this.requestCallback;
                if (function2 != null) {
                    Boolean bool = Boolean.TRUE;
                    if (i3 != 1) {
                        z16 = false;
                    }
                    function2.invoke(bool, Boolean.valueOf(z16));
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        QLog.e(TAG, 1, "handleShareGamePicWithTailRsp ret:" + ret + " rsp:" + rsp);
        synchronized (this) {
            Function2<? super Boolean, ? super Boolean, Unit> function22 = this.requestCallback;
            if (function22 != null) {
                Boolean bool2 = Boolean.FALSE;
                function22.invoke(bool2, bool2);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
