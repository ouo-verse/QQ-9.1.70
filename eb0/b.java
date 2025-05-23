package eb0;

import android.os.Bundle;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements RspInterceptor<QCircleBaseRequest, BaseSenderChain<QCircleBaseRequest>> {
    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void interceptReturnRsp(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain<QCircleBaseRequest> baseSenderChain) {
        baseSenderChain.handleRsp(z16, j3, str, qCircleBaseRequest, obj);
        Bundle extraData = baseSenderChain.getExtraData();
        if ((obj instanceof FeedCloudRead$StGetFeedListRsp) && extraData != null) {
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj;
            boolean z17 = extraData.getBoolean("extra_key_is_load_more");
            if (extraData.getInt("extra_key_tab_type") == 1 && !z17) {
                int i3 = extraData.getInt("extra_key_pull_scene_type");
                if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                    try {
                        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                        qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                        if (qQCircleFeedBase$StFeedListBusiRspData.rspTimestamp.has()) {
                            if (i3 == 1) {
                                EeveeRedpointUtil.saveFollowTabFeedListLastPreRspTimestamp(qQCircleFeedBase$StFeedListBusiRspData.rspTimestamp.get());
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("[requestFeedsData] preload response: ");
                                sb5.append(", followTabFeedListLastPreRspTimestamp: ");
                                sb5.append(qQCircleFeedBase$StFeedListBusiRspData.rspTimestamp.get());
                                sb5.append(", followTabFeedListLastRspTimestamp: ");
                                sb5.append(EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp());
                                QLog.d("QCircleEeveeRedPoint_QCircleFollowTabRspInterceptor", 1, sb5);
                            } else {
                                EeveeRedpointUtil.saveFollowTabFeedListLastRspTimestamp(qQCircleFeedBase$StFeedListBusiRspData.rspTimestamp.get());
                            }
                        }
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
    }
}
