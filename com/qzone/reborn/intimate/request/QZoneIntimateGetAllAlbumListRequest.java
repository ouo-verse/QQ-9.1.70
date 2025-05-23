package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAllAlbumListByUserReq;
import qzone.QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetAllAlbumListRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "uin", "", "(J)V", "TAG", "", "mGetAlbumListReq", "Lqzone/QZIntimateSpaceAlbum$GetAllAlbumListByUserReq;", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateGetAllAlbumListRequest<T> extends QZoneIntimateBaseRequest {
    private final String TAG = "QZoneIntimateGetAllAlbumListRequest";
    private QZIntimateSpaceAlbum$GetAllAlbumListByUserReq mGetAlbumListReq;

    public QZoneIntimateGetAllAlbumListRequest(long j3) {
        QZIntimateSpaceAlbum$GetAllAlbumListByUserReq qZIntimateSpaceAlbum$GetAllAlbumListByUserReq = new QZIntimateSpaceAlbum$GetAllAlbumListByUserReq();
        this.mGetAlbumListReq = qZIntimateSpaceAlbum$GetAllAlbumListByUserReq;
        qZIntimateSpaceAlbum$GetAllAlbumListByUserReq.uin.set(j3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceAlbum$GetAllAlbumListByUserRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            String str = this.TAG;
            int i3 = RFWLog.USR;
            e16.printStackTrace();
            RFWLog.e(str, i3, Unit.INSTANCE);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.GetAllAlbumListByUser";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetAlbumListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetAlbumListReq.toByteArray()");
        return byteArray;
    }
}
