package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleFeedAlbum$DeleteAlbumReq;
import qqcircle.QQCircleFeedAlbum$DeleteAlbumRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDeleteAlbumRequest extends QCircleBaseRequest {
    public static final String TAG = "com.tencent.biz.qqcircle.requests.QCircleDeleteAlbumRequest";
    private QQCircleFeedAlbum$DeleteAlbumReq mRequest;

    public QCircleDeleteAlbumRequest(long j3) {
        QQCircleFeedAlbum$DeleteAlbumReq qQCircleFeedAlbum$DeleteAlbumReq = new QQCircleFeedAlbum$DeleteAlbumReq();
        this.mRequest = qQCircleFeedAlbum$DeleteAlbumReq;
        qQCircleFeedAlbum$DeleteAlbumReq.album_id.set(j3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.feed_album.Writer.DeleteAlbum";
    }

    public QQCircleFeedAlbum$DeleteAlbumReq getRequest() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleFeedAlbum$DeleteAlbumRsp> messageMicro = new MessageMicro<QQCircleFeedAlbum$DeleteAlbumRsp>() { // from class: qqcircle.QQCircleFeedAlbum$DeleteAlbumRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleFeedAlbum$DeleteAlbumRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
