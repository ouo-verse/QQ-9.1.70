package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$ModifyAlbumReq;
import qzone.QZIntimateSpaceAlbum$ModifyAlbumRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u001bB\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001f\u0010\b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateModifyAlbumRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "getAlbumInfo", "()Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "", "", "maskList", "Ljava/util/List;", "getMaskList", "()Ljava/util/List;", "Lqzone/QZIntimateSpaceAlbum$ModifyAlbumReq;", "req", "Lqzone/QZIntimateSpaceAlbum$ModifyAlbumReq;", "<init>", "(Lqzone/QZoneBaseAlbumMeta$AlbumInfo;Ljava/util/List;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateModifyAlbumRequest<T> extends QZoneIntimateBaseRequest {
    private final QZoneBaseAlbumMeta$AlbumInfo albumInfo;
    private final List<Integer> maskList;
    private final QZIntimateSpaceAlbum$ModifyAlbumReq req;

    public QZoneIntimateModifyAlbumRequest(QZoneBaseAlbumMeta$AlbumInfo albumInfo, List<Integer> maskList) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(maskList, "maskList");
        this.albumInfo = albumInfo;
        this.maskList = maskList;
        QZIntimateSpaceAlbum$ModifyAlbumReq qZIntimateSpaceAlbum$ModifyAlbumReq = new QZIntimateSpaceAlbum$ModifyAlbumReq();
        qZIntimateSpaceAlbum$ModifyAlbumReq.album_info.set(albumInfo);
        qZIntimateSpaceAlbum$ModifyAlbumReq.mask.set(maskList);
        this.req = qZIntimateSpaceAlbum$ModifyAlbumReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateSpaceAlbum$ModifyAlbumRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZIntimateSpaceAlbum$ModifyAlbumRsp>() { // from class: qzone.QZIntimateSpaceAlbum$ModifyAlbumRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QZIntimateSpaceAlbum$ModifyAlbumRsp.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            RFWLog.fatal("QZoneIntimateModifyAlbumRequest", RFWLog.USR, e16);
        }
        return r06;
    }

    public final QZoneBaseAlbumMeta$AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.ModifyAlbum";
    }

    public final List<Integer> getMaskList() {
        return this.maskList;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
