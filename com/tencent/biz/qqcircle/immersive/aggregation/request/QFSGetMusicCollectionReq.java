package com.tencent.biz.qqcircle.immersive.aggregation.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCollectionReq;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCollectionRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetMusicCollectionReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicCollection";
    public static final String COLLECTION_ID_DEFAULT = "default";
    private final QQCircleSmartMatchMusic$GetMusicCollectionReq mRequest;

    public QFSGetMusicCollectionReq() {
        QQCircleSmartMatchMusic$GetMusicCollectionReq qQCircleSmartMatchMusic$GetMusicCollectionReq = new QQCircleSmartMatchMusic$GetMusicCollectionReq();
        this.mRequest = qQCircleSmartMatchMusic$GetMusicCollectionReq;
        qQCircleSmartMatchMusic$GetMusicCollectionReq.collectionID.set("default");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicCollection";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$GetMusicCollectionRsp qQCircleSmartMatchMusic$GetMusicCollectionRsp = new QQCircleSmartMatchMusic$GetMusicCollectionRsp();
        try {
            qQCircleSmartMatchMusic$GetMusicCollectionRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$GetMusicCollectionRsp;
    }
}
