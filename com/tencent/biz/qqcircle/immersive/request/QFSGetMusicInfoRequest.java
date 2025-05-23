package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.ArrayList;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoReq;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetMusicInfoRequest extends QCircleBaseRequest {
    private final QQCircleSmartMatchMusic$MusicInfoReq req;

    public QFSGetMusicInfoRequest(ArrayList<String> arrayList) {
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
