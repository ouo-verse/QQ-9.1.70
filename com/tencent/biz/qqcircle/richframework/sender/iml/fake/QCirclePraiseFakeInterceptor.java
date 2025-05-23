package com.tencent.biz.qqcircle.richframework.sender.iml.fake;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase$StLikeBusiData;
import qqcircle.QQCircleFeedBase$StPolyLike;

/* loaded from: classes5.dex */
public class QCirclePraiseFakeInterceptor extends QCircleFakeInterceptor {

    /* renamed from: c, reason: collision with root package name */
    private b f92007c;

    public QCirclePraiseFakeInterceptor(boolean z16, Object obj) {
        super(z16, obj);
    }

    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void d(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain, Object obj2) {
        int d16;
        QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike;
        int i3;
        if (qCircleBaseRequest instanceof QCircleDoLikeRequest) {
            QCircleDoLikeRequest qCircleDoLikeRequest = (QCircleDoLikeRequest) qCircleBaseRequest;
            FeedCloudMeta$StFeed stFeed = qCircleDoLikeRequest.getStFeed();
            if (stFeed == null) {
                QLog.d("PL-QCirclePraiseFakeInterceptor", 1, "[resetFake] feed should not be null.");
                return;
            }
            boolean isPraise = qCircleDoLikeRequest.isPraise();
            try {
                QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
                qQCircleFeedBase$StLikeBusiData.mergeFrom(stFeed.likeInfo.busiData.get().toByteArray());
                QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike2 = qQCircleFeedBase$StLikeBusiData.curPolyLikeInfo;
                new QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData().curPolyLikeInfo.set(qQCircleFeedBase$StLikeBusiData.curPolyLikeInfo);
                int i16 = stFeed.likeInfo.count.get();
                boolean z16 = false;
                if (!isPraise) {
                    QQCircleFeedBase$StPolyLike f16 = ha0.b.f("6");
                    d16 = i16 + 1;
                    qQCircleFeedBase$StLikeBusiData.likeIDs.get().add("6");
                    i3 = 1;
                    qQCircleFeedBase$StPolyLike = f16;
                } else {
                    QQCircleFeedBase$StPolyLike f17 = ha0.b.f("");
                    d16 = i16 - ha0.b.d(stFeed);
                    qQCircleFeedBase$StLikeBusiData.likeIDs.get().clear();
                    qQCircleFeedBase$StPolyLike = f17;
                    i3 = 0;
                }
                stFeed.likeInfo.count.set(d16);
                stFeed.likeInfo.status.set(i3);
                if (i3 == 1) {
                    z16 = true;
                }
                w wVar = new w(QCircleCommonUtil.getCurrentAccount());
                wVar.K();
                wVar.T(z16);
                wVar.R();
                final QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent = new QCirclePolyPraiseUpdateEvent(stFeed.f398449id.get(), qQCircleFeedBase$StPolyLike2, qQCircleFeedBase$StPolyLike, i3, d16);
                if (i3 == 1) {
                    qCirclePolyPraiseUpdateEvent.setStFeed(stFeed);
                }
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SimpleEventBus.getInstance().dispatchEvent(qCirclePolyPraiseUpdateEvent);
                    }
                });
                QLog.d("PL-QCirclePraiseFakeInterceptor", 1, "[resetFake] feed id:" + bj.h(stFeed) + " \uff5c request praise: " + isPraise + " | zanType: " + i3 + " | praisedCount: " + d16);
                stFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StLikeBusiData.toByteArray()));
                this.f92007c = new b(stFeed);
                w20.a.j().initOrUpdateGlobalState((w20.a) this.f92007c, true);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("PL-QCirclePraiseFakeInterceptor", 1, "resetFake error:" + e16);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void e(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        QQCircleFeedBase$StPolyLike b16;
        int d16;
        int i3;
        boolean z16;
        if (qCircleBaseRequest instanceof QCircleDoLikeRequest) {
            QCircleDoLikeRequest qCircleDoLikeRequest = (QCircleDoLikeRequest) qCircleBaseRequest;
            boolean isPraise = qCircleDoLikeRequest.isPraise();
            FeedCloudMeta$StFeed stFeed = qCircleDoLikeRequest.getStFeed();
            if (stFeed == null) {
                QLog.e("PL-QCirclePraiseFakeInterceptor", 1, "[startFake] feed is null");
                return;
            }
            QQCircleFeedBase$StPolyLike b17 = ha0.b.b(stFeed);
            int i16 = stFeed.likeInfo.count.get();
            if (isPraise) {
                b16 = ha0.b.f("6");
                i3 = 1;
                d16 = i16 + 1;
            } else {
                b16 = ha0.b.b(stFeed);
                if (b16 == null || (!TextUtils.equals(b16.polyLikeID.get(), "206008") && !TextUtils.equals(b16.polyLikeID.get(), "205993"))) {
                    b16 = ha0.b.f("");
                }
                d16 = i16 - ha0.b.d(stFeed);
                i3 = 0;
            }
            stFeed.likeInfo.count.set(d16);
            stFeed.likeInfo.status.set(i3);
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            w wVar = new w(QCircleCommonUtil.getCurrentAccount());
            wVar.K();
            wVar.T(z16);
            wVar.R();
            final QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent = new QCirclePolyPraiseUpdateEvent(stFeed.f398449id.get(), b17, b16, i3, d16);
            if (z16) {
                qCirclePolyPraiseUpdateEvent.setStFeed(stFeed);
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    SimpleEventBus.getInstance().dispatchEvent(qCirclePolyPraiseUpdateEvent);
                }
            });
            try {
                QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
                qQCircleFeedBase$StLikeBusiData.mergeFrom(stFeed.likeInfo.busiData.get().toByteArray());
                if (isPraise) {
                    qQCircleFeedBase$StLikeBusiData.likeIDs.add("6");
                } else {
                    qQCircleFeedBase$StLikeBusiData.likeIDs.clear();
                }
                QLog.d("PL-QCirclePraiseFakeInterceptor", 1, "[startFake] feed id:" + bj.h(stFeed) + " \uff5c request praise: " + isPraise + " | zanType: " + i3 + " | praisedCount: " + d16);
                stFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StLikeBusiData.toByteArray()));
                this.f92007c = new b(stFeed);
                w20.a.j().initOrUpdateGlobalState((w20.a) this.f92007c, true);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("PL-QCirclePraiseFakeInterceptor", 1, "startFake error:" + e16);
            }
        }
    }
}
