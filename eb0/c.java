package eb0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.utils.ac;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$StDoPushRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements RspInterceptor<QCircleDoRecommendRequest, BaseSenderChain> {
    public String a() {
        return "QCirclePushRspInterceptor";
    }

    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void interceptReturnRsp(boolean z16, long j3, String str, QCircleDoRecommendRequest qCircleDoRecommendRequest, Object obj, BaseSenderChain baseSenderChain) {
        baseSenderChain.handleRsp(z16, j3, str, qCircleDoRecommendRequest, obj);
        if (!(obj instanceof FeedCloudWrite$StDoPushRsp)) {
            return;
        }
        FeedCloudWrite$StDoPushRsp feedCloudWrite$StDoPushRsp = (FeedCloudWrite$StDoPushRsp) obj;
        if (z16 && j3 == 0 && qCircleDoRecommendRequest != null) {
            if (qCircleDoRecommendRequest.getReq() == null || TextUtils.isEmpty(qCircleDoRecommendRequest.getReq().feed.f398449id.get())) {
                QLog.d(a(), 4, "interceptReturnRsp params error");
            }
            String str2 = qCircleDoRecommendRequest.getReq().feed.f398449id.get();
            FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(str2);
            if (f16 != null) {
                int i3 = f16.hasClickCount.get();
                int i16 = feedCloudWrite$StDoPushRsp.consumeFuel.get() + i3;
                ac.d(f16, i16);
                QCirclePushInfoManager.e().p(str2, f16);
                QCirclePushUpdateEvent qCirclePushUpdateEvent = new QCirclePushUpdateEvent(QCirclePluginGlobalInfo.m(), str2, i16);
                qCirclePushUpdateEvent.setStFeed(qCircleDoRecommendRequest.getStFeed());
                SimpleEventBus.getInstance().dispatchEvent(qCirclePushUpdateEvent);
                SimpleEventBus.getInstance().dispatchEvent(new QFSInteractActionEvent(str2, 4));
                w wVar = new w(qCircleDoRecommendRequest.getStFeed().poster.f398463id.get());
                wVar.K();
                wVar.Q(feedCloudWrite$StDoPushRsp.consumeFuel.get());
                wVar.R();
                w wVar2 = new w(QCircleCommonUtil.getCurrentAccount());
                wVar2.K();
                wVar2.V(true);
                wVar2.R();
                if (i3 == 0) {
                    QCirclePushInfoManager.e().b(str2);
                    return;
                }
                return;
            }
            QLog.e(a(), 1, "interceptReturnRsp pushInfo is null");
            return;
        }
        if (qCircleDoRecommendRequest != null && qCircleDoRecommendRequest.getReq() != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleUndoPushUpdateEvent(qCircleDoRecommendRequest.getReq().feed.f398449id.get()));
        }
    }
}
