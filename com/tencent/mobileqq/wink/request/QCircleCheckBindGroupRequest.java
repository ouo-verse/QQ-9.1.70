package com.tencent.mobileqq.wink.request;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$CheckBindGroupReq;
import qqcircle.QQCircleProfile$CheckBindGroupRsp;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QCircleCheckBindGroupRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "groupIDList", "", "", "(Ljava/util/List;)V", "req", "Lqqcircle/QQCircleProfile$CheckBindGroupReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QCircleCheckBindGroupRequest extends QCircleBaseRequest {

    @NotNull
    private final QQCircleProfile$CheckBindGroupReq req;

    public QCircleCheckBindGroupRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qqcircle.QQCircleProfile$CheckBindGroupRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QQCircleProfile$CheckBindGroupRsp();
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
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.CheckBindGroup";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    public QCircleCheckBindGroupRequest(@Nullable List<Long> list) {
        QQCircleProfile$CheckBindGroupReq qQCircleProfile$CheckBindGroupReq = new QQCircleProfile$CheckBindGroupReq();
        this.req = qQCircleProfile$CheckBindGroupReq;
        if (list != null) {
            qQCircleProfile$CheckBindGroupReq.groupIDList.set(list);
        }
    }

    public /* synthetic */ QCircleCheckBindGroupRequest(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }
}
