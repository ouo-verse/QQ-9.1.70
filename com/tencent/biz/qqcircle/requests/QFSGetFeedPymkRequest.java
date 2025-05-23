package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudRead$StGetRecomUserListReq;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase$StGetRecomUserListBusiReqData;

/* loaded from: classes5.dex */
public class QFSGetFeedPymkRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetRecomUserListReq mRequest;

    public QFSGetFeedPymkRequest(String str, List<FeedCloudCommon$Entry> list) {
        FeedCloudRead$StGetRecomUserListReq feedCloudRead$StGetRecomUserListReq = new FeedCloudRead$StGetRecomUserListReq();
        this.mRequest = feedCloudRead$StGetRecomUserListReq;
        if (str != null) {
            feedCloudRead$StGetRecomUserListReq.attachInfo.set(str);
        }
        if (list != null) {
            this.mRequest.extInfo.mapInfo.set(list);
        }
        QQCircleFeedBase$StGetRecomUserListBusiReqData qQCircleFeedBase$StGetRecomUserListBusiReqData = new QQCircleFeedBase$StGetRecomUserListBusiReqData();
        qQCircleFeedBase$StGetRecomUserListBusiReqData.desUserID.set(QCircleCommonUtil.getCurrentAccount());
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StGetRecomUserListBusiReqData.get().toByteArray()));
        this.mRequest.listType.set(4);
        this.mRequest.needStFeeds.set(true);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRecomUserList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp = new FeedCloudRead$StGetRecomUserListRsp();
        try {
            feedCloudRead$StGetRecomUserListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetRecomUserListRsp;
    }
}
