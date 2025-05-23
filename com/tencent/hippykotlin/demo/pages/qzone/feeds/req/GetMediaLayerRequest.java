package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMediaLayerReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMediaLayerRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class GetMediaLayerRequest extends QZoneBaseRequest<GetMediaLayerReq, GetMediaLayerRsp> {
    public String attachInfo;
    public String curLloc;
    public int slide;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetMediaLayerRsp getMediaLayerRsp) {
        GetMediaLayerRsp getMediaLayerRsp2 = getMediaLayerRsp;
        return this.slide != 2 ? !getMediaLayerRsp2.nextHasMore : !getMediaLayerRsp2.prevHasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMediaLayerRsp decodeBusiRsp(byte[] bArr) {
        return (GetMediaLayerRsp) i.b(new GetMediaLayerRsp(null, null, 0, null, false, false, 0, null, 255, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMediaLayerReq getBusiReq() {
        return new GetMediaLayerReq(null, this.unionId, this.curLloc, this.attachInfo, this.slide, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetMediaLayer";
    }

    public GetMediaLayerRequest(UnionID unionID, String str, String str2, int i3) {
        super(null, 1, null);
        this.unionId = unionID;
        this.curLloc = str;
        this.attachInfo = str2;
        this.slide = i3;
    }
}
