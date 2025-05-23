package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowShareArkMessage$DisplayInfo;
import qshadow.ShadowShareArkMessage$JumpInfo;
import qshadow.ShadowShareArkMessage$PushArkMessageReply;
import qshadow.ShadowShareArkMessage$PushArkMessageRequest;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u001d\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkPushArkMessageRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "busId", "", "receiverType", "", "receiverId", "jumpInfo", "Lqshadow/ShadowShareArkMessage$JumpInfo;", "displayInfo", "Lqshadow/ShadowShareArkMessage$DisplayInfo;", "(Ljava/lang/String;ILjava/lang/String;Lqshadow/ShadowShareArkMessage$JumpInfo;Lqshadow/ShadowShareArkMessage$DisplayInfo;)V", "mReq", "Lqshadow/ShadowShareArkMessage$PushArkMessageRequest;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkPushArkMessageRequest extends QCircleBaseRequest {

    @NotNull
    private final String busId;

    @NotNull
    private ShadowShareArkMessage$PushArkMessageRequest mReq;

    public /* synthetic */ QQWinkPushArkMessageRequest(String str, int i3, String str2, ShadowShareArkMessage$JumpInfo shadowShareArkMessage$JumpInfo, ShadowShareArkMessage$DisplayInfo shadowShareArkMessage$DisplayInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, (i16 & 8) != 0 ? null : shadowShareArkMessage$JumpInfo, (i16 & 16) != 0 ? null : shadowShareArkMessage$DisplayInfo);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.ShadowShareArkMessage$PushArkMessageReply] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<ShadowShareArkMessage$PushArkMessageReply>() { // from class: qshadow.ShadowShareArkMessage$PushArkMessageReply
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ShadowShareArkMessage$PushArkMessageReply.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_share_business";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }

    public QQWinkPushArkMessageRequest(@NotNull String busId, int i3, @NotNull String receiverId, @Nullable ShadowShareArkMessage$JumpInfo shadowShareArkMessage$JumpInfo, @Nullable ShadowShareArkMessage$DisplayInfo shadowShareArkMessage$DisplayInfo) {
        Intrinsics.checkNotNullParameter(busId, "busId");
        Intrinsics.checkNotNullParameter(receiverId, "receiverId");
        this.busId = busId;
        ShadowShareArkMessage$PushArkMessageRequest shadowShareArkMessage$PushArkMessageRequest = new ShadowShareArkMessage$PushArkMessageRequest();
        shadowShareArkMessage$PushArkMessageRequest.businessId.set(busId);
        shadowShareArkMessage$PushArkMessageRequest.receiverId.set(receiverId);
        shadowShareArkMessage$PushArkMessageRequest.receiverType.set(i3);
        if (shadowShareArkMessage$DisplayInfo != null) {
            shadowShareArkMessage$PushArkMessageRequest.displayInfo = shadowShareArkMessage$DisplayInfo;
        }
        if (shadowShareArkMessage$JumpInfo != null) {
            shadowShareArkMessage$PushArkMessageRequest.jumpInfo = shadowShareArkMessage$JumpInfo;
        }
        this.mReq = shadowShareArkMessage$PushArkMessageRequest;
    }
}
