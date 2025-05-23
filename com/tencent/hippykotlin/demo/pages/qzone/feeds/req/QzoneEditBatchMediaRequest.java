package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditBatchMediaReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditPhoto;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneEditBatchMediaRequest extends QZoneBaseRequest<EditBatchMediaReq, EditBatchMediaRsp> {
    public String albumId;
    public final List<EditPhoto> editPhotoList;
    public final List<Integer> operations;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final EditBatchMediaRsp decodeBusiRsp(byte[] bArr) {
        return (EditBatchMediaRsp) i.b(new EditBatchMediaRsp(), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final EditBatchMediaReq getBusiReq() {
        return new EditBatchMediaReq(this.albumId, this.operations, this.editPhotoList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.media_commwriter.MediaCommWriter.EditBatchMedia";
    }

    public QzoneEditBatchMediaRequest(String str, List<Integer> list, List<EditPhoto> list2) {
        super(null, 1, null);
        this.albumId = str;
        this.operations = list;
        this.editPhotoList = list2;
    }
}
