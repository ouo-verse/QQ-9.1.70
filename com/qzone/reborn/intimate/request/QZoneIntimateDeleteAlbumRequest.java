package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$DeleteAlbumReq;
import qzone.QZIntimateSpaceAlbum$DeleteAlbumRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0015*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001f\u0010\b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateDeleteAlbumRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "spaceId", "Ljava/lang/String;", "getSpaceId", "()Ljava/lang/String;", "albumId", "getAlbumId", "Lqzone/QZIntimateSpaceAlbum$DeleteAlbumReq;", "req", "Lqzone/QZIntimateSpaceAlbum$DeleteAlbumReq;", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateDeleteAlbumRequest<T> extends QZoneIntimateBaseRequest {
    private final String albumId;
    private final QZIntimateSpaceAlbum$DeleteAlbumReq req;
    private final String spaceId;

    public QZoneIntimateDeleteAlbumRequest(String spaceId, String albumId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        this.spaceId = spaceId;
        this.albumId = albumId;
        QZIntimateSpaceAlbum$DeleteAlbumReq qZIntimateSpaceAlbum$DeleteAlbumReq = new QZIntimateSpaceAlbum$DeleteAlbumReq();
        qZIntimateSpaceAlbum$DeleteAlbumReq.space_id.set(spaceId);
        qZIntimateSpaceAlbum$DeleteAlbumReq.album_id.set(albumId);
        this.req = qZIntimateSpaceAlbum$DeleteAlbumReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$DeleteAlbumRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZIntimateSpaceAlbum$DeleteAlbumRsp>() { // from class: qzone.QZIntimateSpaceAlbum$DeleteAlbumRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QZIntimateSpaceAlbum$DeleteAlbumRsp.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            RFWLog.fatal("QZoneIntimateDeleteAlbumRequest", RFWLog.USR, e16);
        }
        return r06;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.DeleteAlbum";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }
}
