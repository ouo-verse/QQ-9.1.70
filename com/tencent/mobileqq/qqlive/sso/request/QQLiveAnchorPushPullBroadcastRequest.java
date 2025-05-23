package com.tencent.mobileqq.qqlive.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.util.a;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.qqlive.common.api.AegisLogger;
import gr4.p;
import gr4.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0016B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveAnchorPushPullBroadcastRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "requestRoomInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "requestExt", "[B", "requestStreamUrl", "Ljava/lang/String;", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;[BLjava/lang/String;)V", "Companion", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorPushPullBroadcastRequest<T> extends LiveBaseRequest<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private final byte[] requestExt;

    @NotNull
    private final QQLiveAnchorRoomInfo requestRoomInfo;

    @NotNull
    private final String requestStreamUrl;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveAnchorPushPullBroadcastRequest$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sso.request.QQLiveAnchorPushPullBroadcastRequest$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAnchorPushPullBroadcastRequest(@NotNull QQLiveAnchorRoomInfo requestRoomInfo, @NotNull byte[] requestExt, @NotNull String requestStreamUrl) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullParameter(requestRoomInfo, "requestRoomInfo");
        Intrinsics.checkNotNullParameter(requestExt, "requestExt");
        Intrinsics.checkNotNullParameter(requestStreamUrl, "requestStreamUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, requestRoomInfo, requestExt, requestStreamUrl);
            return;
        }
        this.requestRoomInfo = requestRoomInfo;
        this.requestExt = requestExt;
        this.requestStreamUrl = requestStreamUrl;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) convertInputStreamtoByteArray);
        }
        try {
            return (T) q.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveAnchorPushPullBroadcastRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "trpc.qlive.qlive_room_play_svr.QliveRoomPlaySvr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageNano) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        p pVar = new p();
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = this.requestRoomInfo.roomAttr;
        String str2 = qQLiveAnchorDataRoomAttr.roomName;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        pVar.f403169a = str2;
        String str4 = qQLiveAnchorDataRoomAttr.poster;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        pVar.f403170b = str;
        String str5 = qQLiveAnchorDataRoomAttr.poster16v9;
        if (str5 == null) {
            str5 = "";
        }
        pVar.f403171c = str5;
        if (str4 == null) {
            str4 = "";
        }
        pVar.f403172d = str4;
        pVar.f403173e = a.y(qQLiveAnchorDataRoomAttr.tags);
        pVar.f403176h = this.requestExt;
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo = this.requestRoomInfo;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr2 = qQLiveAnchorRoomInfo.roomAttr;
        pVar.f403175g = qQLiveAnchorDataRoomAttr2.roomId;
        String str6 = qQLiveAnchorRoomInfo.roomData.programId;
        if (str6 == null) {
            str6 = "";
        }
        pVar.f403177i = str6;
        pVar.f403179k = 0;
        String str7 = this.requestStreamUrl;
        if (str7 != null) {
            str3 = str7;
        }
        pVar.f403180l = str3;
        pVar.f403181m = r1.gameInfo.f271211id;
        pVar.f403182n = qQLiveAnchorDataRoomAttr2.liveRoomType;
        pVar.f403183o = a.x(qQLiveAnchorDataRoomAttr2.gameInfo);
        pVar.f403184p = a.j(this.requestRoomInfo.roomAttr);
        return pVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PushPullBroadcast";
    }
}
