package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetLayerTailpageRecommendReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetLayerTailpageRecommendRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class GetLayerTailPageRecommendRequest extends QZoneBaseRequest<GetLayerTailpageRecommendReq, GetLayerTailpageRecommendRsp> {
    public String currentAlbumId;
    public StUser owner;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetLayerTailpageRecommendRsp decodeBusiRsp(byte[] bArr) {
        return (GetLayerTailpageRecommendRsp) i.b(new GetLayerTailpageRecommendRsp(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetLayerTailpageRecommendReq getBusiReq() {
        return new GetLayerTailpageRecommendReq(this.currentAlbumId, this.owner);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commreader.MediaCommReader.GetLayerTailpageRecommend";
    }

    public GetLayerTailPageRecommendRequest(String str, StUser stUser) {
        super(null, 1, null);
        this.currentAlbumId = str;
        this.owner = stUser;
    }
}
