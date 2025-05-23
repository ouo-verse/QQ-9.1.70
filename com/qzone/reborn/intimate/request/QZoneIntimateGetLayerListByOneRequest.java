package com.qzone.reborn.intimate.request;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetMediasListByOneReq;
import qzone.QZIntimateSpaceAlbum$GetMediasListRsp;
import sj.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetLayerListByOneRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateSpaceAlbum$GetMediasListByOneReq;", Const.BUNDLE_KEY_REQUEST, "Lqzone/QZIntimateSpaceAlbum$GetMediasListByOneReq;", "Lsj/c;", "requestBean", "<init>", "(Lsj/c;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateGetLayerListByOneRequest extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceAlbum$GetMediasListByOneReq request;

    public QZoneIntimateGetLayerListByOneRequest(c cVar) {
        QZIntimateSpaceAlbum$GetMediasListByOneReq qZIntimateSpaceAlbum$GetMediasListByOneReq = new QZIntimateSpaceAlbum$GetMediasListByOneReq();
        this.request = qZIntimateSpaceAlbum$GetMediasListByOneReq;
        if (cVar != null) {
            qZIntimateSpaceAlbum$GetMediasListByOneReq.space_id.set(cVar.getSpaceId());
            this.request.album_id.set(cVar.getAlbumId());
            this.request.lloc.set(cVar.getLloc());
            if (cVar.getIsRefresh()) {
                this.request.attach_info.set(cVar.getRightAttachInfo());
            } else if (cVar.getIsFetchLeft()) {
                this.request.attach_info.set(cVar.getLeftAttachInfo());
            } else if (cVar.getIsFetchRight()) {
                this.request.attach_info.set(cVar.getRightAttachInfo());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$GetMediasListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceAlbum$GetMediasListRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.GetMediasListByOne";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
