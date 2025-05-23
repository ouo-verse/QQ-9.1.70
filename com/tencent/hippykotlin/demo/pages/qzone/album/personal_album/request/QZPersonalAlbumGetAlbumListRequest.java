package com.tencent.hippykotlin.demo.pages.qzone.album.personal_album.request;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumListReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class QZPersonalAlbumGetAlbumListRequest extends QZoneBaseRequest<GetAlbumListReq, GetAlbumListRsp> {
    public String attachInfo;
    public StUser owner;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetAlbumListReq getBusiReq() {
        return new GetAlbumListReq(this.owner, null, this.attachInfo, null, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commreader.MediaCommReader.GetAlbumList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetAlbumListRsp getAlbumListRsp) {
        return !(getAlbumListRsp.hasMore != null ? r1.booleanValue() : false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetAlbumListRsp decodeBusiRsp(byte[] bArr) {
        return (GetAlbumListRsp) i.b(new GetAlbumListRsp(null, null, null, null, null, 31, null), bArr);
    }

    public QZPersonalAlbumGetAlbumListRequest(StUser stUser, String str, Integer num) {
        super(null, 1, null);
        this.owner = stUser;
        this.attachInfo = str;
    }
}
