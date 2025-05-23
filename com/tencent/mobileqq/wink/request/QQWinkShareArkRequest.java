package com.tencent.mobileqq.wink.request;

import com.dataline.util.j;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowShareArkMessage$PushMessageReply;
import qshadow.ShadowShareArkMessage$PushMessageRequest;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B7\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkShareArkRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "materialServiceId", "I", "Lqshadow/ShadowShareArkMessage$PushMessageRequest;", "mReq", "Lqshadow/ShadowShareArkMessage$PushMessageRequest;", "type", "", "uin", "groupID", "sdkVersion", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "<init>", "(IJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkShareArkRequest extends QCircleBaseRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private ShadowShareArkMessage$PushMessageRequest mReq;
    private final int materialServiceId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkShareArkRequest$a;", "", "", "serviceId", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.request.QQWinkShareArkRequest$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int serviceId) {
            if (serviceId != 6 && serviceId != 7 && serviceId != 9) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    public QQWinkShareArkRequest(int i3, long j3, @NotNull String groupID, int i16, @NotNull String sdkVersion, @NotNull String materialId) {
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(groupID, "groupID");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        this.materialServiceId = i16;
        ShadowShareArkMessage$PushMessageRequest shadowShareArkMessage$PushMessageRequest = new ShadowShareArkMessage$PushMessageRequest();
        shadowShareArkMessage$PushMessageRequest.serviceType.set(i3);
        PBStringField pBStringField = shadowShareArkMessage$PushMessageRequest.receiverID;
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(String.valueOf(j3));
        pBStringField.set(PluginBaseInfoHelper.Base64Helper.encodeToString(encodeToByteArray, 0));
        shadowShareArkMessage$PushMessageRequest.prompt.set(j.d(QCircleDynamicNameApiImpl.ORIGIN_OLD_NAME));
        shadowShareArkMessage$PushMessageRequest.groupID.set(groupID);
        shadowShareArkMessage$PushMessageRequest.serviceId.set(i16);
        shadowShareArkMessage$PushMessageRequest.sdkVersion.set(sdkVersion);
        shadowShareArkMessage$PushMessageRequest.materialId.set(materialId);
        this.mReq = shadowShareArkMessage$PushMessageRequest;
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
        if (INSTANCE.a(this.materialServiceId)) {
            return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_share_material_qzone";
        }
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_share_material";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }
}
