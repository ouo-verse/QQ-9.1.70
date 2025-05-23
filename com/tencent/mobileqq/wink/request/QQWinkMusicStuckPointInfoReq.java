package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfoReq;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfoRsp;

/* loaded from: classes21.dex */
public class QQWinkMusicStuckPointInfoReq extends QCircleBaseRequest {
    private final QQCircleSmartMatchMusic$MusicStuckPointInfoReq mReq;

    public QQWinkMusicStuckPointInfoReq(List<String> list) {
        QQCircleSmartMatchMusic$MusicStuckPointInfoReq qQCircleSmartMatchMusic$MusicStuckPointInfoReq = new QQCircleSmartMatchMusic$MusicStuckPointInfoReq();
        this.mReq = qQCircleSmartMatchMusic$MusicStuckPointInfoReq;
        qQCircleSmartMatchMusic$MusicStuckPointInfoReq.musicMIDList.set(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicStuckPointInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$MusicStuckPointInfoRsp qQCircleSmartMatchMusic$MusicStuckPointInfoRsp = new QQCircleSmartMatchMusic$MusicStuckPointInfoRsp();
        try {
            qQCircleSmartMatchMusic$MusicStuckPointInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$MusicStuckPointInfoRsp;
    }
}
