package com.tencent.hippykotlin.demo.pages.qzone.album.personal_album_detail.request;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetPhotoListReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetPhotoListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import com.tencent.mobileqq.startup.step.InitSkin;

/* loaded from: classes33.dex */
public final class QZPersonalAlbumGetAlbumDetailRequest extends QZoneBaseRequest<GetPhotoListReq, GetPhotoListRsp> {
    public String albumId;
    public String attachInfo;
    public StUser owner;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetPhotoListReq getBusiReq() {
        return new GetPhotoListReq(this.owner, this.albumId, this.attachInfo, null, null, null, null, null, null, null, 1016, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commreader.MediaCommReader.GetAlbumMediaList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetPhotoListRsp getPhotoListRsp) {
        return !(getPhotoListRsp.hasMore != null ? r1.booleanValue() : false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetPhotoListRsp decodeBusiRsp(byte[] bArr) {
        return (GetPhotoListRsp) i.b(new GetPhotoListRsp(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null), bArr);
    }

    public QZPersonalAlbumGetAlbumDetailRequest(StUser stUser, String str, String str2) {
        super(null, 1, null);
        this.owner = stUser;
        this.albumId = str;
        this.attachInfo = str2;
    }
}
