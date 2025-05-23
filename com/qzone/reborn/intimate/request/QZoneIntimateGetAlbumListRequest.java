package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAlbumListReq;
import qzone.QZIntimateSpaceAlbum$GetAlbumListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\b\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetAlbumListRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "spaceId", "", "attachInfo", "scene", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "TAG", "mGetAlbumListReq", "Lqzone/QZIntimateSpaceAlbum$GetAlbumListReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateGetAlbumListRequest extends QZoneIntimateBaseRequest {
    private final String TAG;
    private QZIntimateSpaceAlbum$GetAlbumListReq mGetAlbumListReq;

    public QZoneIntimateGetAlbumListRequest(String spaceId, String attachInfo, int i3) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.TAG = "QZoneIntimateGetAlbumListRequest";
        QZIntimateSpaceAlbum$GetAlbumListReq qZIntimateSpaceAlbum$GetAlbumListReq = new QZIntimateSpaceAlbum$GetAlbumListReq();
        this.mGetAlbumListReq = qZIntimateSpaceAlbum$GetAlbumListReq;
        qZIntimateSpaceAlbum$GetAlbumListReq.space_id.set(spaceId);
        this.mGetAlbumListReq.attach_info.set(attachInfo);
        this.mGetAlbumListReq.scene.set(i3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$GetAlbumListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceAlbum$GetAlbumListRsp();
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
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.GetAlbumList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetAlbumListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetAlbumListReq.toByteArray()");
        return byteArray;
    }
}
