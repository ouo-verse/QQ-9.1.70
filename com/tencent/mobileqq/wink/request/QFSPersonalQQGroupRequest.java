package com.tencent.mobileqq.wink.request;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$GetQQGroupsReq;
import qqcircle.QQCircleProfile$GetQQGroupsRsp;
import w53.b;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QFSPersonalQQGroupRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "hostUin", "", "isOwner", "", "(Ljava/lang/String;Z)V", "req", "Lqqcircle/QQCircleProfile$GetQQGroupsReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QFSPersonalQQGroupRequest extends QCircleBaseRequest {

    @NotNull
    private final QQCircleProfile$GetQQGroupsReq req;

    public QFSPersonalQQGroupRequest(@Nullable String str, boolean z16) {
        boolean z17;
        QQCircleProfile$GetQQGroupsReq qQCircleProfile$GetQQGroupsReq = new QQCircleProfile$GetQQGroupsReq();
        this.req = qQCircleProfile$GetQQGroupsReq;
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            b.c(BaseRequest.TAG, "hostUin is null");
        } else {
            qQCircleProfile$GetQQGroupsReq.uid.set(str);
            qQCircleProfile$GetQQGroupsReq.is_pull_allow_bind.set(z16);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qqcircle.QQCircleProfile$GetQQGroupsRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QQCircleProfile$GetQQGroupsRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            b.d(BaseRequest.TAG, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.GetQQGroups";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
