package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleSmartMatchMusic$ModMusicCollectionReq;
import qqcircle.QQCircleSmartMatchMusic$ModMusicCollectionRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkModMusicCollectionReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.ModMusicCollection";
    public static final String COLLECTION_ID_DEFAULT = "default";
    public static final int MOD_MUSIC_COLLECTION_CMD_ADD = 1;
    public static final int MOD_MUSIC_COLLECTION_CMD_DEL = 2;
    private final QQCircleSmartMatchMusic$ModMusicCollectionReq mRequest;

    public QQWinkModMusicCollectionReq(String str, int i3) {
        QQCircleSmartMatchMusic$ModMusicCollectionReq qQCircleSmartMatchMusic$ModMusicCollectionReq = new QQCircleSmartMatchMusic$ModMusicCollectionReq();
        this.mRequest = qQCircleSmartMatchMusic$ModMusicCollectionReq;
        qQCircleSmartMatchMusic$ModMusicCollectionReq.collectionID.set("default");
        qQCircleSmartMatchMusic$ModMusicCollectionReq.mid.set(str);
        qQCircleSmartMatchMusic$ModMusicCollectionReq.modCmd.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.ModMusicCollection";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$ModMusicCollectionRsp qQCircleSmartMatchMusic$ModMusicCollectionRsp = new QQCircleSmartMatchMusic$ModMusicCollectionRsp();
        try {
            qQCircleSmartMatchMusic$ModMusicCollectionRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$ModMusicCollectionRsp;
    }
}
