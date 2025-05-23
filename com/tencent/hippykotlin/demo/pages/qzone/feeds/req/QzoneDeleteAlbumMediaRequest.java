package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.DeleteAlbumMediaReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.DeleteAlbumMediaRsp;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneDeleteAlbumMediaRequest extends QZoneBaseRequest<DeleteAlbumMediaReq, DeleteAlbumMediaRsp> {
    public String albumId;
    public List<String> mediaIdList;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteAlbumMediaRsp decodeBusiRsp(byte[] bArr) {
        return (DeleteAlbumMediaRsp) i.b(new DeleteAlbumMediaRsp(), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteAlbumMediaReq getBusiReq() {
        return new DeleteAlbumMediaReq(this.albumId, this.mediaIdList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commwriter.MediaCommWriter.DeleteAlbumMedia";
    }

    public QzoneDeleteAlbumMediaRequest(String str, List<String> list) {
        super(null, 1, null);
        this.albumId = str;
        this.mediaIdList = list;
    }
}
