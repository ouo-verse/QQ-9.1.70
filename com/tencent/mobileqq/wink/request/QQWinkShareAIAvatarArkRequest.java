package com.tencent.mobileqq.wink.request;

import android.util.Base64;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowShareArkMessage$DisplayInfo;
import qshadow.ShadowShareArkMessage$JumpInfo;
import qshadow.ShadowShareArkMessage$PushArkMessageRequest;
import qshadow.ShadowShareArkMessage$PushMessageReply;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkShareAIAvatarArkRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqshadow/ShadowShareArkMessage$PushArkMessageRequest;", "mReq", "Lqshadow/ShadowShareArkMessage$PushArkMessageRequest;", "businessId", "", "receiverType", "receiverId", "Lqshadow/ShadowShareArkMessage$JumpInfo;", "jumpInfo", "Lqshadow/ShadowShareArkMessage$DisplayInfo;", "displayInfo", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lqshadow/ShadowShareArkMessage$JumpInfo;Lqshadow/ShadowShareArkMessage$DisplayInfo;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkShareAIAvatarArkRequest extends QCircleBaseRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private ShadowShareArkMessage$PushArkMessageRequest mReq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkShareAIAvatarArkRequest$a;", "", "", "serviceId", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.request.QQWinkShareAIAvatarArkRequest$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int serviceId) {
            boolean z16;
            boolean z17 = true;
            if (serviceId == 100) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (serviceId != 101) {
                z17 = false;
            }
            return z16 | z17;
        }

        Companion() {
        }
    }

    public QQWinkShareAIAvatarArkRequest(@NotNull String businessId, int i3, @NotNull String receiverId, @NotNull ShadowShareArkMessage$JumpInfo jumpInfo, @NotNull ShadowShareArkMessage$DisplayInfo displayInfo) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(receiverId, "receiverId");
        Intrinsics.checkNotNullParameter(jumpInfo, "jumpInfo");
        Intrinsics.checkNotNullParameter(displayInfo, "displayInfo");
        ShadowShareArkMessage$PushArkMessageRequest shadowShareArkMessage$PushArkMessageRequest = new ShadowShareArkMessage$PushArkMessageRequest();
        shadowShareArkMessage$PushArkMessageRequest.businessId.set(businessId);
        shadowShareArkMessage$PushArkMessageRequest.receiverType.set(i3);
        PBStringField pBStringField = shadowShareArkMessage$PushArkMessageRequest.receiverId;
        byte[] bytes = receiverId.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        pBStringField.set(Base64.encodeToString(bytes, 2));
        shadowShareArkMessage$PushArkMessageRequest.jumpInfo.set(jumpInfo);
        shadowShareArkMessage$PushArkMessageRequest.displayInfo.set(displayInfo);
        this.mReq = shadowShareArkMessage$PushArkMessageRequest;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.ShadowShareArkMessage$PushMessageReply] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new ShadowShareArkMessage$PushMessageReply();
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
}
