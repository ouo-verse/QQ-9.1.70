package com.qzone.reborn.repair.request;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$UploadReq;
import qzone.SuperResolution$UploadRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/repair/request/QZoneRepairUploadRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "albumId", "srUrl", "batchId", "", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "getBatchId", "()J", "getContent", "getSrUrl", "getTaskId", "uploadReq", "Lqzone/SuperResolution$UploadReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneRepairUploadRequest extends QZoneBaseRequest {
    private final String albumId;
    private final long batchId;
    private final String content;
    private final String srUrl;
    private final String taskId;
    private SuperResolution$UploadReq uploadReq;

    public QZoneRepairUploadRequest(String taskId, String albumId, String srUrl, long j3, String content) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(srUrl, "srUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        this.taskId = taskId;
        this.albumId = albumId;
        this.srUrl = srUrl;
        this.batchId = j3;
        this.content = content;
        SuperResolution$UploadReq superResolution$UploadReq = new SuperResolution$UploadReq();
        this.uploadReq = superResolution$UploadReq;
        superResolution$UploadReq.task_id.set(taskId);
        this.uploadReq.album_id.set(albumId);
        this.uploadReq.sr_url.set(srUrl);
        this.uploadReq.batch_id.set(j3);
        this.uploadReq.content.set(content);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.SuperResolution$UploadRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<SuperResolution$UploadRsp>() { // from class: qzone.SuperResolution$UploadRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SuperResolution$UploadRsp.class);
        };
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

    public final long getBatchId() {
        return this.batchId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.super_resolution.SuperResolution.Upload";
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.uploadReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "uploadReq.toByteArray()");
        return byteArray;
    }

    public final String getSrUrl() {
        return this.srUrl;
    }

    public final String getTaskId() {
        return this.taskId;
    }
}
