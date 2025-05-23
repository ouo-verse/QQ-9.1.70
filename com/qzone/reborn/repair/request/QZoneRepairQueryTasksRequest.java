package com.qzone.reborn.repair.request;

import android.util.Log;
import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$QueryTasksReq;
import qzone.SuperResolution$QueryTasksRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/repair/request/QZoneRepairQueryTasksRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "attachInfo", "", "(Ljava/lang/String;)V", "queryTasksReq", "Lqzone/SuperResolution$QueryTasksReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneRepairQueryTasksRequest extends QZoneBaseRequest {
    private SuperResolution$QueryTasksReq queryTasksReq;

    public QZoneRepairQueryTasksRequest(String attachInfo) {
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        SuperResolution$QueryTasksReq superResolution$QueryTasksReq = new SuperResolution$QueryTasksReq();
        this.queryTasksReq = superResolution$QueryTasksReq;
        superResolution$QueryTasksReq.attach_info.set(attachInfo);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.SuperResolution$QueryTasksRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new SuperResolution$QueryTasksRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "decode error: ", Log.getStackTraceString(e16));
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.super_resolution.SuperResolution.QueryTasks";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.queryTasksReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "queryTasksReq.toByteArray()");
        return byteArray;
    }
}
