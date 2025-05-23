package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.ArrayList;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoReq;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkBatchGetMusicInfoRequest extends QCircleBaseRequest {
    private final QQCircleSmartMatchMusic$MusicInfoReq req;

    public QQWinkBatchGetMusicInfoRequest(ArrayList<String> arrayList) {
        QQCircleSmartMatchMusic$MusicInfoReq qQCircleSmartMatchMusic$MusicInfoReq = new QQCircleSmartMatchMusic$MusicInfoReq();
        this.req = qQCircleSmartMatchMusic$MusicInfoReq;
        qQCircleSmartMatchMusic$MusicInfoReq.musicMIDList.set(arrayList);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp = new QQCircleSmartMatchMusic$MusicInfoRsp();
        try {
            qQCircleSmartMatchMusic$MusicInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$MusicInfoRsp;
    }
}
