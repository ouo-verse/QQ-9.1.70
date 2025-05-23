package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryInfoReq;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkMusicCategoryReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicCategoryInfo";
    private final QQCircleSmartMatchMusic$GetMusicCategoryInfoReq mRequest = new MessageMicro<QQCircleSmartMatchMusic$GetMusicCategoryInfoReq>() { // from class: qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleSmartMatchMusic$GetMusicCategoryInfoReq.class);
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return CMD;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp = new QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp();
        try {
            qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp;
    }
}
