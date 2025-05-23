package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryTopListReq;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkCategoryTopMusicReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicCategoryTopList";
    private final QQCircleSmartMatchMusic$GetMusicCategoryTopListReq mRequest;

    public QQWinkCategoryTopMusicReq(String str) {
        QQCircleSmartMatchMusic$GetMusicCategoryTopListReq qQCircleSmartMatchMusic$GetMusicCategoryTopListReq = new QQCircleSmartMatchMusic$GetMusicCategoryTopListReq();
        this.mRequest = qQCircleSmartMatchMusic$GetMusicCategoryTopListReq;
        qQCircleSmartMatchMusic$GetMusicCategoryTopListReq.categoryID.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return CMD;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp = new QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp();
        try {
            qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp;
    }
}
