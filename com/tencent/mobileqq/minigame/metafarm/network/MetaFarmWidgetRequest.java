package com.tencent.mobileqq.minigame.metafarm.network;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetData;
import com.tencent.mobileqq.minigame.proto.MetaFarmWidgetProto;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002JR\u0010\u001a\u001a\u00020\u000e2H\u0010\u001b\u001aD\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\u000fH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005RP\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmWidgetRequest;", "", "()V", "mTrpcListener", "com/tencent/mobileqq/minigame/metafarm/network/MetaFarmWidgetRequest$mTrpcListener$1", "Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmWidgetRequest$mTrpcListener$1;", "requestCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData;", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "getWidgetData", "source", "", "handleGetWidgetDataRsp", "ret", "", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "setListener", "listener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmWidgetRequest {
    public static final String REQUEST_CMD = "/v1/1856";
    private static final String TAG = "MetaFarmWidgetRequest";
    private final MetaFarmWidgetRequest$mTrpcListener$1 mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.mobileqq.minigame.metafarm.network.MetaFarmWidgetRequest$mTrpcListener$1
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(MetaFarmWidgetRequest.REQUEST_CMD);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            if (Intrinsics.areEqual(MetaFarmWidgetRequest.REQUEST_CMD, cmd)) {
                MetaFarmWidgetRequest.this.handleGetWidgetDataRsp(ret, rsp, request);
            }
        }
    };
    private Function2<? super Boolean, ? super MetaFarmWidgetData, Unit> requestCallback;

    public void setListener(Function2<? super Boolean, ? super MetaFarmWidgetData, Unit> listener) {
        if (listener != null) {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
        } else {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
        }
        this.requestCallback = listener;
    }

    public void getWidgetData(int source) {
        QLog.d(TAG, 1, "getWidgetData");
        MetaFarmWidgetProto.GetWidgetReq getWidgetReq = new MetaFarmWidgetProto.GetWidgetReq();
        getWidgetReq.source.set(source);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(REQUEST_CMD, false, getWidgetReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGetWidgetDataRsp(long ret, TrpcProxy.TrpcInovkeRsp rsp, Intent request) {
        if (ret == 0 && rsp != null && request != null) {
            MetaFarmWidgetProto.GetWidgetRsp getWidgetRsp = new MetaFarmWidgetProto.GetWidgetRsp();
            getWidgetRsp.mergeFrom(rsp.data.get().toByteArray());
            MetaFarmWidgetData metaFarmWidgetData = new MetaFarmWidgetData();
            metaFarmWidgetData.setPullTs(NetConnInfoCenter.getServerTimeMillis());
            metaFarmWidgetData.setNextPullGapSecond(getWidgetRsp.next_pull_gap_second.get());
            String str = getWidgetRsp.jump_url.get();
            Intrinsics.checkNotNullExpressionValue(str, "getWidgetRsp.jump_url.get()");
            metaFarmWidgetData.setJumpUrl(str);
            MetaFarmWidgetProto.UserInfo userInfo = getWidgetRsp.user_info.get();
            metaFarmWidgetData.setUserInfo(new MetaFarmWidgetData.UserInfo());
            MetaFarmWidgetData.UserInfo userInfo2 = metaFarmWidgetData.getUserInfo();
            if (userInfo2 != null) {
                String str2 = userInfo.nick.get();
                Intrinsics.checkNotNullExpressionValue(str2, "userInfo.nick.get()");
                userInfo2.setNick(str2);
            }
            MetaFarmWidgetData.UserInfo userInfo3 = metaFarmWidgetData.getUserInfo();
            if (userInfo3 != null) {
                String str3 = userInfo.avatar.get();
                Intrinsics.checkNotNullExpressionValue(str3, "userInfo.avatar.get()");
                userInfo3.setAvatar(str3);
            }
            MetaFarmWidgetData.UserInfo userInfo4 = metaFarmWidgetData.getUserInfo();
            if (userInfo4 != null) {
                userInfo4.setLevel(userInfo.level.get());
            }
            MetaFarmWidgetData.UserInfo userInfo5 = metaFarmWidgetData.getUserInfo();
            if (userInfo5 != null) {
                String str4 = userInfo.level_icon.get();
                Intrinsics.checkNotNullExpressionValue(str4, "userInfo.level_icon.get()");
                userInfo5.setLevelIconUrl(str4);
            }
            MetaFarmWidgetData.UserInfo userInfo6 = metaFarmWidgetData.getUserInfo();
            if (userInfo6 != null) {
                userInfo6.setCoin(userInfo.coin.get());
            }
            MetaFarmWidgetData.UserInfo userInfo7 = metaFarmWidgetData.getUserInfo();
            if (userInfo7 != null) {
                String str5 = userInfo.coin_desc.get();
                Intrinsics.checkNotNullExpressionValue(str5, "userInfo.coin_desc.get()");
                userInfo7.setCoinDesc(str5);
            }
            MetaFarmWidgetData.UserInfo userInfo8 = metaFarmWidgetData.getUserInfo();
            if (userInfo8 != null) {
                String str6 = userInfo.coin_icon.get();
                Intrinsics.checkNotNullExpressionValue(str6, "userInfo.coin_icon.get()");
                userInfo8.setCoinIconUrl(str6);
            }
            MetaFarmWidgetData.UserInfo userInfo9 = metaFarmWidgetData.getUserInfo();
            if (userInfo9 != null) {
                userInfo9.setStealableTimes(userInfo.stealable_times.get());
            }
            MetaFarmWidgetData.UserInfo userInfo10 = metaFarmWidgetData.getUserInfo();
            if (userInfo10 != null) {
                userInfo10.setBlessingTimes(userInfo.blessing_times.get());
            }
            List<MetaFarmWidgetProto.CropCard> list = getWidgetRsp.cards.get();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                MetaFarmWidgetData.CropCard cropCard = new MetaFarmWidgetData.CropCard();
                String str7 = list.get(i3).icon.get();
                Intrinsics.checkNotNullExpressionValue(str7, "cards[i].icon.get()");
                cropCard.setIcon(str7);
                String str8 = list.get(i3).text.get();
                Intrinsics.checkNotNullExpressionValue(str8, "cards[i].text.get()");
                cropCard.setText(str8);
                cropCard.setTextHighlight(list.get(i3).text_highlight.get());
                String str9 = list.get(i3).time_text.get();
                Intrinsics.checkNotNullExpressionValue(str9, "cards[i].time_text.get()");
                cropCard.setTimeText(str9);
                cropCard.setTimestamp(list.get(i3).time_stamp.get());
                metaFarmWidgetData.getCards().add(cropCard);
            }
            QLog.d(TAG, 1, "handleGetWidgetDataRsp");
            Function2<? super Boolean, ? super MetaFarmWidgetData, Unit> function2 = this.requestCallback;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, metaFarmWidgetData);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "handleGetWidgetDataRsp ret:" + ret + " rsp:" + rsp);
        Function2<? super Boolean, ? super MetaFarmWidgetData, Unit> function22 = this.requestCallback;
        if (function22 != null) {
            function22.invoke(Boolean.FALSE, null);
        }
    }
}
