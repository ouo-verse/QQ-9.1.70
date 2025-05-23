package com.tencent.hippykotlin.demo.pages.qzone.album.group_album_detail.request;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMediaListReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMediaListRsp;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QZQunAlbumGetAlbumDetailRequest extends QZoneBaseRequest<GetMediaListReq, GetMediaListRsp> {
    public String albumId;
    public String attachInfo;
    public String qunId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMediaListReq getBusiReq() {
        return new GetMediaListReq(this.qunId, this.albumId, null, null, this.attachInfo, null, null, 108, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QunAlbum.trpc.qzone.webapp_qun_media.QunMedia.GetMediaList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetMediaListRsp getMediaListRsp) {
        return !(getMediaListRsp.nextHasMore != null ? r1.booleanValue() : false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMediaListRsp decodeBusiRsp(byte[] bArr) {
        return (GetMediaListRsp) i.b(new GetMediaListRsp(null, null, null, null, null, null, null, null, null, null, null, 2047, null), bArr);
    }

    public QZQunAlbumGetAlbumDetailRequest(String str, String str2, String str3) {
        super(null, 1, null);
        this.qunId = str;
        this.albumId = str2;
        this.attachInfo = str3;
    }
}
