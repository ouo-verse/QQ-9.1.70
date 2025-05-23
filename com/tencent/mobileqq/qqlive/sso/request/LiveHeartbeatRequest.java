package com.tencent.mobileqq.qqlive.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lt3.a;
import lt3.b;
import lt3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0007B!\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b \u0010!J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J!\u0010\u0011\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/LiveHeartbeatRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "linkMicType", "", "Llt3/a;", "a", "(I)[Llt3/a;", "b", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "roomId", "J", "I", "getLinkMicType", "()I", "setLinkMicType", "(I)V", "Llt3/b;", "req", "Llt3/b;", "lastLinkMicType", "wantAppId", "<init>", "(Ljava/lang/String;JI)V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveHeartbeatRequest<T> extends LiveBaseRequest<T> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int LINK_MIC_TYPE_MULTICHAT = 1;
    public static final int LINK_MIC_TYPE_NORMAL = 0;
    private int lastLinkMicType;
    private int linkMicType;

    @NotNull
    private final b req;
    private final long roomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/LiveHeartbeatRequest$a;", "", "", "HEART_BEAT_LIVEPLAY", "Ljava/lang/String;", "", "LINK_MIC_TYPE_MULTICHAT", "I", "LINK_MIC_TYPE_NORMAL", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sso.request.LiveHeartbeatRequest$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ LiveHeartbeatRequest(String str, long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final a[] a(int linkMicType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b(linkMicType));
        Object[] array = arrayList.toArray(new a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (a[]) array;
    }

    private final a b(int linkMicType) {
        a aVar = new a();
        aVar.f415538a = "liveplay";
        byte[] bytes = String.valueOf(linkMicType).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        aVar.f415539b = bytes;
        return aVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) convertInputStreamtoByteArray);
        }
        try {
            return (T) c.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|LiveHeartbeatRequest", "decode", "error, ", e16);
            return null;
        }
    }

    public final int getLinkMicType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.linkMicType;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "trpc.qlive.media_hb4opensdk.MediaLogic";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MessageNano) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int i3 = this.lastLinkMicType;
        int i16 = this.linkMicType;
        if (i3 != i16) {
            this.req.f415548i = a(i16);
            this.lastLinkMicType = this.linkMicType;
        }
        return this.req;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "SendHB";
    }

    public final void setLinkMicType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.linkMicType = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveHeartbeatRequest(@NotNull String wantAppId, long j3, int i3) {
        super(wantAppId);
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, wantAppId, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        this.roomId = j3;
        this.linkMicType = i3;
        b bVar = new b();
        this.req = bVar;
        this.lastLinkMicType = -1;
        bVar.f415543d = (int) j3;
        bVar.f415540a = com.tencent.mobileqq.qqlive.config.a.INSTANCE.a(wantAppId).a().e();
        bVar.f415544e = 1;
        bVar.f415541b = 4;
        bVar.f415548i = a(this.linkMicType);
    }
}
