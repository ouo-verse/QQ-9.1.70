package com.qzone.reborn.repair.request;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$UpdateResultReq;
import qzone.SuperResolution$UpdateResultRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/repair/request/QZoneRepairUpdateResultRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "photoSize", "", "status", "", "(Ljava/lang/String;JI)V", "getPhotoSize", "()J", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "getTaskId", "()Ljava/lang/String;", "updateResultReq", "Lqzone/SuperResolution$UpdateResultReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneRepairUpdateResultRequest extends QZoneBaseRequest {
    private final long photoSize;
    private final int status;
    private final String taskId;
    private SuperResolution$UpdateResultReq updateResultReq;

    public /* synthetic */ QZoneRepairUpdateResultRequest(String str, long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.SuperResolution$UpdateResultRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<SuperResolution$UpdateResultRsp>() { // from class: qzone.SuperResolution$UpdateResultRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SuperResolution$UpdateResultRsp.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.super_resolution.SuperResolution.UpdateResult";
    }

    public final long getPhotoSize() {
        return this.photoSize;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.updateResultReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "updateResultReq.toByteArray()");
        return byteArray;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public QZoneRepairUpdateResultRequest(String taskId, long j3, int i3) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.taskId = taskId;
        this.photoSize = j3;
        this.status = i3;
        SuperResolution$UpdateResultReq superResolution$UpdateResultReq = new SuperResolution$UpdateResultReq();
        this.updateResultReq = superResolution$UpdateResultReq;
        superResolution$UpdateResultReq.task_id.set(taskId);
        this.updateResultReq.sr_size.set(j3);
        this.updateResultReq.status.set(i3);
    }
}
