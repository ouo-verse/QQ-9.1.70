package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qzone.QZQQVideoSwitch$SetReq;
import qzone.QZQQVideoSwitch$SetRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QCircleQZoneVideoWindowStatusSetRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZQQVideoSwitch$SetReq;", "req", "Lqzone/QZQQVideoSwitch$SetReq;", "getReq", "()Lqzone/QZQQVideoSwitch$SetReq;", "", "localPopWindowStatus", "<init>", "(I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QCircleQZoneVideoWindowStatusSetRequest extends QCircleBaseRequest {

    @NotNull
    private final QZQQVideoSwitch$SetReq req;

    public QCircleQZoneVideoWindowStatusSetRequest(int i3) {
        QZQQVideoSwitch$SetReq qZQQVideoSwitch$SetReq = new QZQQVideoSwitch$SetReq();
        this.req = qZQQVideoSwitch$SetReq;
        qZQQVideoSwitch$SetReq.pop_window_status.set(i3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZQQVideoSwitch$SetRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZQQVideoSwitch$SetRsp>() { // from class: qzone.QZQQVideoSwitch$SetRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, QZQQVideoSwitch$SetRsp.class);
            public final PBInt32Field ret = PBField.initInt32(0);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            QLog.e("QCircleQZoneVideoWindowStatusSetRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.qzone_wezone_connect.Switch.Set";
    }

    @NotNull
    public final QZQQVideoSwitch$SetReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
