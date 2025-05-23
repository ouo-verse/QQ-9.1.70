package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.CloneBatchMediaReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.CloneBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CloneBatchMediaRequest extends QZoneBaseRequest<CloneBatchMediaReq, CloneBatchMediaRsp> {
    public final StUser albumOwner;
    public final String dstAlbumid;
    public final String srcAlbumid;
    public final List<String> srcMediaIds;
    public final UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final CloneBatchMediaRsp decodeBusiRsp(byte[] bArr) {
        return (CloneBatchMediaRsp) i.b(new CloneBatchMediaRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final CloneBatchMediaReq getBusiReq() {
        return new CloneBatchMediaReq(this.srcAlbumid, this.srcMediaIds, this.dstAlbumid, this.albumOwner, this.unionId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commwriter.MediaCommWriter.CloneBatchMedia";
    }

    public CloneBatchMediaRequest(String str, List<String> list, String str2, StUser stUser, UnionID unionID) {
        super(null, 1, null);
        this.srcAlbumid = str;
        this.srcMediaIds = list;
        this.dstAlbumid = str2;
        this.albumOwner = stUser;
        this.unionId = unionID;
    }
}
