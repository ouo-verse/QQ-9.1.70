package com.tencent.mobileqq.qqlive.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import jp4.a;
import jp4.b;
import jp4.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0019B3\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/LivePushRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "roomId", "J", "maxMsgNum", "cookie", "[B", "Ljp4/a;", "ext", "Ljp4/a;", "wantAppId", "<init>", "(Ljava/lang/String;JJ[BLjp4/a;)V", "Companion", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LivePushRequest<T> extends LiveBaseRequest<T> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String MAIN_CMD = "trpc.qlive.room_msg_read_proxy_svr.RoomMsgReadProxySvr";

    @NotNull
    public static final String SUB_CMD = "PullMsgProxy";

    @Nullable
    private final byte[] cookie;

    @Nullable
    private final a ext;
    private final long maxMsgNum;
    private final long roomId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/LivePushRequest$a;", "", "", "LOG_TAG", "Ljava/lang/String;", "MAIN_CMD", "SUB_CMD", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sso.request.LivePushRequest$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePushRequest(@NotNull String wantAppId, long j3, long j16, @Nullable byte[] bArr, @Nullable a aVar) {
        super(wantAppId);
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, wantAppId, Long.valueOf(j3), Long.valueOf(j16), bArr, aVar);
            return;
        }
        this.roomId = j3;
        this.maxMsgNum = j16;
        this.cookie = bArr;
        this.ext = aVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) convertInputStreamtoByteArray);
        }
        try {
            return (T) c.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e("Push|LivePushRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "trpc.qlive.room_msg_read_proxy_svr.RoomMsgReadProxySvr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageNano) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        b bVar = new b();
        bVar.f410795a = this.roomId;
        bVar.f410798d = this.maxMsgNum;
        byte[] bArr = this.cookie;
        if (bArr == null) {
            bArr = WireFormatNano.EMPTY_BYTES;
        }
        bVar.f410796b = bArr;
        bVar.f410797c = this.ext;
        return bVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PullMsgProxy";
    }
}
