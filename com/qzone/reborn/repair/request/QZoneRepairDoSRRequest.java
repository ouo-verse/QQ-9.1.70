package com.qzone.reborn.repair.request;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$DoSRReq;
import qzone.SuperResolution$DoSRRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/repair/request/QZoneRepairDoSRRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "albumId", "lloc", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "doSRReq", "Lqzone/SuperResolution$DoSRReq;", "getLloc", "getTaskId", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneRepairDoSRRequest extends QZoneBaseRequest {
    private final String albumId;
    private SuperResolution$DoSRReq doSRReq;
    private final String lloc;
    private final String taskId;

    public QZoneRepairDoSRRequest(String taskId, String albumId, String lloc, String url) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(url, "url");
        this.taskId = taskId;
        this.albumId = albumId;
        this.lloc = lloc;
        SuperResolution$DoSRReq superResolution$DoSRReq = new SuperResolution$DoSRReq();
        this.doSRReq = superResolution$DoSRReq;
        superResolution$DoSRReq.task_id.set(taskId);
        this.doSRReq.album_id.set(albumId);
        this.doSRReq.lloc.set(lloc);
        this.doSRReq.url.set(url);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.SuperResolution$DoSRRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new SuperResolution$DoSRRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.super_resolution.SuperResolution.DoSR";
    }

    public final String getLloc() {
        return this.lloc;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.doSRReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "doSRReq.toByteArray()");
        return byteArray;
    }

    public final String getTaskId() {
        return this.taskId;
    }
}
