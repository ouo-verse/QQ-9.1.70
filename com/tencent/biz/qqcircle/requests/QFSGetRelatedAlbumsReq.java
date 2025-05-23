package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedAlbum$GetRelatedAlbumsReq;
import qqcircle.QQCircleFeedAlbum$GetRelatedAlbumsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSGetRelatedAlbumsReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "albumId", "", "attachInfo", "", "(JLjava/lang/String;)V", Const.BUNDLE_KEY_REQUEST, "Lqqcircle/QQCircleFeedAlbum$GetRelatedAlbumsReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QFSGetRelatedAlbumsReq extends QCircleBaseRequest {

    @NotNull
    private final QQCircleFeedAlbum$GetRelatedAlbumsReq request;

    public QFSGetRelatedAlbumsReq(long j3, @NotNull String attachInfo) {
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        QQCircleFeedAlbum$GetRelatedAlbumsReq qQCircleFeedAlbum$GetRelatedAlbumsReq = new QQCircleFeedAlbum$GetRelatedAlbumsReq();
        this.request = qQCircleFeedAlbum$GetRelatedAlbumsReq;
        qQCircleFeedAlbum$GetRelatedAlbumsReq.album_id.set(j3);
        qQCircleFeedAlbum$GetRelatedAlbumsReq.attach_info.set(attachInfo);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qqcircle.QQCircleFeedAlbum$GetRelatedAlbumsRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new QQCircleFeedAlbum$GetRelatedAlbumsRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGetRelatedAlbumsReq", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.feed_album.Reader.GetRelatedAlbums";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
