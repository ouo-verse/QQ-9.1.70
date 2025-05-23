package com.tencent.mobileqq.minigame.danmaku;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.danmaku.MiniGameDanmaku;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsData;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016J$\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\\\u0010\u001d\u001a\u00020\u000f2R\u0010\u001e\u001aN\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u0001`\u0010H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005Rf\u0010\u0006\u001aN\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u0001`\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/danmaku/MiniGameDanmakuRequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/danmaku/MiniGameDanmakuRequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/danmaku/MiniGameDanmakuRequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/TipsData;", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "getRequestCallback", "()Lkotlin/jvm/functions/Function2;", "setRequestCallback", "(Lkotlin/jvm/functions/Function2;)V", "getDanmaku", "handleGetDanmakuRsp", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "setListener", "listener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniGameDanmakuRequest {
    public static final String REQUEST_CMD = "/v1/1805";
    private static final String TAG = "MiniGameDanmakuRequest";
    private final MiniGameDanmakuRequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.danmaku.MiniGameDanmakuRequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(MiniGameDanmakuRequest.REQUEST_CMD);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if (Intrinsics.areEqual(MiniGameDanmakuRequest.REQUEST_CMD, cmd)) {
                MiniGameDanmakuRequest.this.handleGetDanmakuRsp(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super List<TipsData>, Unit> requestCallback;

    public void getDanmaku() {
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_CMD, false, new MiniGameDanmaku.GetLoadingTipsReq().toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    public final Function2<Boolean, List<TipsData>, Unit> getRequestCallback() {
        return this.requestCallback;
    }

    public void setListener(Function2<? super Boolean, ? super List<TipsData>, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        this.requestCallback = listener;
    }

    public final void setRequestCallback(Function2<? super Boolean, ? super List<TipsData>, Unit> function2) {
        this.requestCallback = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGetDanmakuRsp(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        if (ret == 0 && rsp != null && request != null) {
            MiniGameDanmaku.GetLoadingTipsRsp getLoadingTipsRsp = new MiniGameDanmaku.GetLoadingTipsRsp();
            getLoadingTipsRsp.mergeFrom(rsp.data.get().toByteArray());
            List<MiniGameDanmaku.Tips> list = getLoadingTipsRsp.tips_list.get();
            QLog.d(TAG, 1, "handleGetDanmakuRsp tipsList:" + list);
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (MiniGameDanmaku.Tips tips : list) {
                    ArrayList arrayList2 = new ArrayList();
                    List<MiniGameDanmaku.Element> list2 = tips.element_list.get();
                    Intrinsics.checkNotNullExpressionValue(list2, "it.element_list.get()");
                    for (MiniGameDanmaku.Element element : list2) {
                        int i3 = element.type.get();
                        String str = element.content.get();
                        Intrinsics.checkNotNullExpressionValue(str, "element.content.get()");
                        String str2 = element.textcolor.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "element.textcolor.get()");
                        arrayList2.add(new TipsElementData(i3, str, str2, false, 8, null));
                    }
                    arrayList.add(new TipsData(arrayList2));
                }
            }
            Function2<? super Boolean, ? super List<TipsData>, Unit> function2 = this.requestCallback;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, arrayList);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleGetDanmakuRsp ret:" + ret + " rsp:" + rsp);
        Function2<? super Boolean, ? super List<TipsData>, Unit> function22 = this.requestCallback;
        if (function22 != null) {
            function22.invoke(Boolean.FALSE, null);
        }
    }
}
