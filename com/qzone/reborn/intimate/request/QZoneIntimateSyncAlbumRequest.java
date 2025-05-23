package com.qzone.reborn.intimate.request;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$SyncQzoneAlbumReq;
import qzone.QZIntimateSpaceAlbum$SyncQzoneAlbumRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateSyncAlbumRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "space_id", "", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "TAG", "mGetAlbumListReq", "Lqzone/QZIntimateSpaceAlbum$SyncQzoneAlbumReq;", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateSyncAlbumRequest<T> extends QZoneIntimateBaseRequest {
    private final String TAG;
    private QZIntimateSpaceAlbum$SyncQzoneAlbumReq mGetAlbumListReq;

    public QZoneIntimateSyncAlbumRequest(String space_id, ArrayList<String> album_id) {
        Intrinsics.checkNotNullParameter(space_id, "space_id");
        Intrinsics.checkNotNullParameter(album_id, "album_id");
        this.TAG = "QZoneIntimateSyncAlbumRequest";
        QZIntimateSpaceAlbum$SyncQzoneAlbumReq qZIntimateSpaceAlbum$SyncQzoneAlbumReq = new QZIntimateSpaceAlbum$SyncQzoneAlbumReq();
        this.mGetAlbumListReq = qZIntimateSpaceAlbum$SyncQzoneAlbumReq;
        qZIntimateSpaceAlbum$SyncQzoneAlbumReq.space_id.set(space_id);
        this.mGetAlbumListReq.album_id.set(album_id);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceAlbum$SyncQzoneAlbumRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZIntimateSpaceAlbum$SyncQzoneAlbumRsp>() { // from class: qzone.QZIntimateSpaceAlbum$SyncQzoneAlbumRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QZIntimateSpaceAlbum$SyncQzoneAlbumRsp.class);
        };
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
        return "IntimateSpace.trpc.qzone.intimate_space_album.Album.SyncQzoneAlbum";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetAlbumListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetAlbumListReq.toByteArray()");
        return byteArray;
    }
}
