package com.tencent.hippykotlin.demo.pages.qzone.album.group_album.request;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMainPageReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMainPageRsp;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class QZQunAlbumGetMainPageRequest extends QZoneBaseRequest<GetMainPageReq, GetMainPageRsp> {
    public String qunId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageRsp decodeBusiRsp(byte[] bArr) {
        return (GetMainPageRsp) i.b(new GetMainPageRsp(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageReq getBusiReq() {
        return new GetMainPageReq(this.qunId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QunAlbum.trpc.qzone.webapp_qun_media.QunMedia.GetMainPage";
    }

    public QZQunAlbumGetMainPageRequest(String str) {
        super(null, 1, 0 == true ? 1 : 0);
        this.qunId = str;
    }
}
