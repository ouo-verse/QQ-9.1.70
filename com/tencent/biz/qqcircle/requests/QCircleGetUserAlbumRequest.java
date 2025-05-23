package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$GetUserAlbumListReq;
import feedcloud.FeedCloudRead$GetUserAlbumListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetUserAlbumRequest extends QCircleBaseRequest {
    public static final String TAG = "com.tencent.biz.qqcircle.requests.QCircleGetUserAlbumRequest";
    private final FeedCloudRead$GetUserAlbumListReq mRequest = new FeedCloudRead$GetUserAlbumListReq();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetUserAlbumList";
    }

    public FeedCloudRead$GetUserAlbumListReq getRequest() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetUserAlbumListRsp feedCloudRead$GetUserAlbumListRsp = new FeedCloudRead$GetUserAlbumListRsp();
        try {
            feedCloudRead$GetUserAlbumListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetUserAlbumListRsp;
    }
}
