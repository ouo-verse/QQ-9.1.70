package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleThank$QuickThankPSVReq;
import qqcircle.QQCircleThank$QuickThankPSVRsp;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSQuickThankPSVRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lqqcircle/QQCircleThank$QuickThankPSVReq;", Const.BUNDLE_KEY_REQUEST, "Lqqcircle/QQCircleThank$QuickThankPSVReq;", "getRequest", "()Lqqcircle/QQCircleThank$QuickThankPSVReq;", "", "startTime", "", "categoryId", "<init>", "(JI)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSQuickThankPSVRequest extends QCircleBaseRequest {

    @NotNull
    private final QQCircleThank$QuickThankPSVReq request;

    public QFSQuickThankPSVRequest(long j3, int i3) {
        QQCircleThank$QuickThankPSVReq qQCircleThank$QuickThankPSVReq = new QQCircleThank$QuickThankPSVReq();
        this.request = qQCircleThank$QuickThankPSVReq;
        qQCircleThank$QuickThankPSVReq.start_time.set(j3);
        qQCircleThank$QuickThankPSVReq.category_id.set(i3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleThank$QuickThankPSVRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new MessageMicro<QQCircleThank$QuickThankPSVRsp>() { // from class: qqcircle.QQCircleThank$QuickThankPSVRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"thanked_feed_ids"}, new Object[]{""}, QQCircleThank$QuickThankPSVRsp.class);
            public final PBRepeatField<String> thanked_feed_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSQuickThankPSVRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circle_thank.CircleThank.QuickThankPSV";
    }

    @NotNull
    public final QQCircleThank$QuickThankPSVReq getRequest() {
        return this.request;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
