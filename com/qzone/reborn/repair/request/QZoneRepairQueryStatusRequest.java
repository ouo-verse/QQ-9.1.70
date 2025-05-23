package com.qzone.reborn.repair.request;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$QueryStatusReq;
import qzone.SuperResolution$QueryStatusRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/repair/request/QZoneRepairQueryStatusRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "(Ljava/lang/String;)V", "queryStatusReq", "Lqzone/SuperResolution$QueryStatusReq;", "getTaskId", "()Ljava/lang/String;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneRepairQueryStatusRequest extends QZoneBaseRequest {
    private SuperResolution$QueryStatusReq queryStatusReq;
    private final String taskId;

    public QZoneRepairQueryStatusRequest(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.taskId = taskId;
        SuperResolution$QueryStatusReq superResolution$QueryStatusReq = new SuperResolution$QueryStatusReq();
        this.queryStatusReq = superResolution$QueryStatusReq;
        superResolution$QueryStatusReq.task_id.set(taskId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.SuperResolution$QueryStatusRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new SuperResolution$QueryStatusRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.super_resolution.SuperResolution.QueryStatus";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.queryStatusReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "queryStatusReq.toByteArray()");
        return byteArray;
    }

    public final String getTaskId() {
        return this.taskId;
    }
}
