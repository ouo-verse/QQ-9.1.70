package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleRight$CountCircleRightReq;
import qqcircle.QQCircleRight$CountCircleRightRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSCountCircleRightRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lqqcircle/QQCircleRight$CountCircleRightReq;", Const.BUNDLE_KEY_REQUEST, "Lqqcircle/QQCircleRight$CountCircleRightReq;", "getRequest", "()Lqqcircle/QQCircleRight$CountCircleRightReq;", "", "rightType", "<init>", "(I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSCountCircleRightRequest extends QCircleBaseRequest {

    @NotNull
    private final QQCircleRight$CountCircleRightReq request;

    public QFSCountCircleRightRequest(int i3) {
        QQCircleRight$CountCircleRightReq qQCircleRight$CountCircleRightReq = new QQCircleRight$CountCircleRightReq();
        this.request = qQCircleRight$CountCircleRightReq;
        qQCircleRight$CountCircleRightReq.rightType.set(i3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleRight$CountCircleRightRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new QQCircleRight$CountCircleRightRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSCountCircleRightRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleright.CircleRight.CountCircleRight";
    }

    @NotNull
    public final QQCircleRight$CountCircleRightReq getRequest() {
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
