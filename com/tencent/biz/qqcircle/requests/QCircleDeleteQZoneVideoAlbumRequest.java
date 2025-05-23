package com.tencent.biz.qqcircle.requests;

import feedcloud.DeleteAlbumReq;
import feedcloud.DeleteAlbumRsp;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDeleteQZoneVideoAlbumRequest extends QCircleBaseRequest {
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.qqvideo_album.QQVideoAlbum.DeleteAlbum";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return new DeleteAlbumReq.a().build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public DeleteAlbumRsp decode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return DeleteAlbumRsp.ADAPTER.decode(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
