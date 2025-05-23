package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowMemoryAlbum$PushNotificationMemoryAlbumReq;
import qshadow.ShadowMemoryAlbum$PushNotificationMemoryAlbumRsp;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkPushNotificationMemoryAlbumReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "content", "", "jumpSchema", "(Ljava/lang/String;Ljava/lang/String;)V", "mReq", "Lqshadow/ShadowMemoryAlbum$PushNotificationMemoryAlbumReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkPushNotificationMemoryAlbumReq extends QCircleBaseRequest {

    @NotNull
    private final ShadowMemoryAlbum$PushNotificationMemoryAlbumReq mReq;

    public QQWinkPushNotificationMemoryAlbumReq(@NotNull String content, @NotNull String jumpSchema) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(jumpSchema, "jumpSchema");
        ShadowMemoryAlbum$PushNotificationMemoryAlbumReq shadowMemoryAlbum$PushNotificationMemoryAlbumReq = new ShadowMemoryAlbum$PushNotificationMemoryAlbumReq();
        shadowMemoryAlbum$PushNotificationMemoryAlbumReq.content.set(content);
        shadowMemoryAlbum$PushNotificationMemoryAlbumReq.jump_url.set(jumpSchema);
        this.mReq = shadowMemoryAlbum$PushNotificationMemoryAlbumReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qshadow.ShadowMemoryAlbum$PushNotificationMemoryAlbumRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<ShadowMemoryAlbum$PushNotificationMemoryAlbumRsp>() { // from class: qshadow.ShadowMemoryAlbum$PushNotificationMemoryAlbumRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ShadowMemoryAlbum$PushNotificationMemoryAlbumRsp.class);
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
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_memory_album_notification";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }
}
