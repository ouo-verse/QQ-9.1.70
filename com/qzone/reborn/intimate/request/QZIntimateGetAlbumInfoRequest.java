package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAlbumInfoReq;
import qzone.QZIntimateSpaceAlbum$GetAlbumInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZIntimateGetAlbumInfoRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "spaceId", "", "albumId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAlbumInfoReq", "Lqzone/QZIntimateSpaceAlbum$GetAlbumInfoReq;", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZIntimateGetAlbumInfoRequest<T> extends QZoneIntimateBaseRequest {
    private final String albumId;
    private final QZIntimateSpaceAlbum$GetAlbumInfoReq getAlbumInfoReq;
    private final String spaceId;

    public QZIntimateGetAlbumInfoRequest(String spaceId, String albumId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        this.spaceId = spaceId;
        this.albumId = albumId;
        QZIntimateSpaceAlbum$GetAlbumInfoReq qZIntimateSpaceAlbum$GetAlbumInfoReq = new QZIntimateSpaceAlbum$GetAlbumInfoReq();
        qZIntimateSpaceAlbum$GetAlbumInfoReq.space_id.set(spaceId);
        qZIntimateSpaceAlbum$GetAlbumInfoReq.album_id.set(albumId);
        this.getAlbumInfoReq = qZIntimateSpaceAlbum$GetAlbumInfoReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$GetAlbumInfoRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceAlbum$GetAlbumInfoRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            RFWLog.e(QZoneIntimateBaseRequest.TAG, RFWLog.USR, e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.GetAlbumInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.getAlbumInfoReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "getAlbumInfoReq.toByteArray()");
        return byteArray;
    }
}
