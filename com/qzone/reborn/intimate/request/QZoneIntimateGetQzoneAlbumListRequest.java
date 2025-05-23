package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetQzoneAlbumListReq;
import qzone.QZIntimateSpaceAlbum$GetQzoneAlbumListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetQzoneAlbumListRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "attachInfo", "", "spaceId", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "mGetAlbumListReq", "Lqzone/QZIntimateSpaceAlbum$GetQzoneAlbumListReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateGetQzoneAlbumListRequest extends QZoneIntimateBaseRequest {
    private final String TAG;
    private QZIntimateSpaceAlbum$GetQzoneAlbumListReq mGetAlbumListReq;

    public QZoneIntimateGetQzoneAlbumListRequest(String attachInfo, String spaceId) {
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.TAG = "QZoneIntimateGetQzoneAlbumListRequest";
        QZIntimateSpaceAlbum$GetQzoneAlbumListReq qZIntimateSpaceAlbum$GetQzoneAlbumListReq = new QZIntimateSpaceAlbum$GetQzoneAlbumListReq();
        this.mGetAlbumListReq = qZIntimateSpaceAlbum$GetQzoneAlbumListReq;
        qZIntimateSpaceAlbum$GetQzoneAlbumListReq.attach_info.set(attachInfo);
        this.mGetAlbumListReq.space_id.set(spaceId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$GetQzoneAlbumListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceAlbum$GetQzoneAlbumListRsp();
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
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.GetQzoneAlbumList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetAlbumListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetAlbumListReq.toByteArray()");
        return byteArray;
    }
}
