package com.tencent.hippykotlin.demo.pages.qzone.album.group_album.request;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetAlbumListReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetAlbumListRsp;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QZQunAlbumGetAlbumListRequest extends QZoneBaseRequest<GetAlbumListReq, GetAlbumListRsp> {
    public String attachInfo;
    public String qunId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetAlbumListReq getBusiReq() {
        return new GetAlbumListReq(this.qunId, this.attachInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QunAlbum.trpc.qzone.webapp_qun_media.QunMedia.GetAlbumList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetAlbumListRsp getAlbumListRsp) {
        return !(getAlbumListRsp.hasMore != null ? r1.booleanValue() : false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetAlbumListRsp decodeBusiRsp(byte[] bArr) {
        return (GetAlbumListRsp) i.b(new GetAlbumListRsp(null, null, null, null, null, 31, null), bArr);
    }

    public QZQunAlbumGetAlbumListRequest(String str, String str2) {
        super(null, 1, 0 == true ? 1 : 0);
        this.qunId = str;
        this.attachInfo = str2;
    }
}
