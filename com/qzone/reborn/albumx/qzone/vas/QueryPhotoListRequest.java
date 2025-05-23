package com.qzone.reborn.albumx.qzone.vas;

import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$QueryPhotoListReq;
import qzone.QZonePhotoDegrade$QueryPhotoListRsp;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/QueryPhotoListRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "status", "", "count", "cookie", "", "(IILjava/lang/String;)V", "getCookie", "()Ljava/lang/String;", "getCount", "()I", Const.BUNDLE_KEY_REQUEST, "Lqzone/QZonePhotoDegrade$QueryPhotoListReq;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QueryPhotoListRequest extends QZoneBaseRequest {
    private final String cookie;
    private final int count;
    private QZonePhotoDegrade$QueryPhotoListReq request;
    private final int status;

    public QueryPhotoListRequest(int i3, int i16, String cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        this.status = i3;
        this.count = i16;
        this.cookie = cookie;
        QZonePhotoDegrade$QueryPhotoListReq qZonePhotoDegrade$QueryPhotoListReq = new QZonePhotoDegrade$QueryPhotoListReq();
        this.request = qZonePhotoDegrade$QueryPhotoListReq;
        qZonePhotoDegrade$QueryPhotoListReq.status.set(i3);
        this.request.cookie.set(cookie);
        this.request.count.set(i16);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZonePhotoDegrade$QueryPhotoListRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZonePhotoDegrade$QueryPhotoListRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.photo_degrade.PhotoDegradeRead.QueryPhotoList";
    }

    public final String getCookie() {
        return this.cookie;
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }

    public final int getStatus() {
        return this.status;
    }
}
