package com.tencent.hippykotlin.demo.pages.qzone.album.personal_album_member_list.request;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumMemberListReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumMemberListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class QZPersonalAlbumGetAlbumMemberListRequest extends QZoneBaseRequest<GetAlbumMemberListReq, GetAlbumMemberListRsp> {
    public String albumId;
    public StUser owner;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetAlbumMemberListRsp decodeBusiRsp(byte[] bArr) {
        return (GetAlbumMemberListRsp) i.b(new GetAlbumMemberListRsp(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetAlbumMemberListReq getBusiReq() {
        return new GetAlbumMemberListReq(this.albumId, this.owner);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commreader.MediaCommReader.GetAlbumMemberList";
    }

    public QZPersonalAlbumGetAlbumMemberListRequest(String str, StUser stUser) {
        super(null, 1, null);
        this.albumId = str;
        this.owner = stUser;
    }
}
