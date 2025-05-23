package db0;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.biz.qqcircle.utils.ac;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$StDoPushReq;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends QCircleFakeInterceptor {

    /* renamed from: c, reason: collision with root package name */
    private e30.b f393500c;

    public f(boolean z16, Object obj) {
        super(z16, obj);
    }

    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void d(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain, Object obj2) {
        String str;
        FeedCloudMeta$StPushList f16;
        if (qCircleBaseRequest instanceof QCircleDoRecommendRequest) {
            QLog.d("QCircleUndoPushReqInterceptor", 1, "\u56de\u9000\u63a8\u5047\u64cd\u4f5c");
            QCircleDoRecommendRequest qCircleDoRecommendRequest = (QCircleDoRecommendRequest) qCircleBaseRequest;
            FeedCloudMeta$StFeed stFeed = qCircleDoRecommendRequest.getStFeed();
            FeedCloudWrite$StDoPushReq req = qCircleDoRecommendRequest.getReq();
            if (stFeed != null && (f16 = QCirclePushInfoManager.e().f((str = stFeed.f398449id.get()))) != null) {
                int undoPushCount = f16.hasClickCount.get() + qCircleDoRecommendRequest.getUndoPushCount();
                if (req != null) {
                    f16.pushBoxViewInfo.set(req.push.pushBoxViewInfo.get());
                }
                ac.d(f16, undoPushCount);
                QCirclePushInfoManager.e().p(str, f16);
                this.f393500c = new e30.b(stFeed);
                w20.a.j().initOrUpdateGlobalState((w20.a) this.f393500c, true);
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePushUpdateEvent(QCirclePluginGlobalInfo.m(), str, undoPushCount));
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void e(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        if (qCircleBaseRequest instanceof QCircleDoRecommendRequest) {
            QLog.d("QCircleUndoPushReqInterceptor", 1, "\u64a4\u9500\u63a8\u5047\u64cd\u4f5c");
            QCircleDoRecommendRequest qCircleDoRecommendRequest = (QCircleDoRecommendRequest) qCircleBaseRequest;
            FeedCloudMeta$StFeed stFeed = qCircleDoRecommendRequest.getStFeed();
            if (stFeed != null && stFeed.busiData.get() != null) {
                String str = stFeed.f398449id.get();
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
                try {
                    qQCircleFeedBase$StFeedBusiReqData.mergeFrom(stFeed.busiData.get().toByteArray());
                    int i3 = qQCircleFeedBase$StFeedBusiReqData.pushList.hasClickCount.get();
                    qCircleDoRecommendRequest.setUndoPushCount(i3);
                    FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(str);
                    ac.c(f16);
                    QCirclePushInfoManager.e().n(str, f16);
                    this.f393500c = new e30.b(stFeed);
                    w20.a.j().initOrUpdateGlobalState((w20.a) this.f393500c, true);
                    SimpleEventBus.getInstance().dispatchEvent(new QCircleUndoPushUpdateEvent(str));
                    w wVar = new w(stFeed.poster.f398463id.get());
                    wVar.K();
                    wVar.Q(-i3);
                    wVar.R();
                    w wVar2 = new w(QCircleCommonUtil.getCurrentAccount());
                    wVar2.K();
                    wVar2.V(false);
                    wVar2.R();
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
