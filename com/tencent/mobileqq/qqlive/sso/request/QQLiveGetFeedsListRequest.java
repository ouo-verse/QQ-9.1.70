package com.tencent.mobileqq.qqlive.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr4.a;
import qr4.c;
import qr4.d;
import qr4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002Bm\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveGetFeedsListRequest;", "T", "Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "toString", "", "roomId", "J", "", "size", "I", "fromId", WadlProxyConsts.SCENE_ID, "Ljava/lang/String;", "", "Lqr4/e;", "penetrateInfo", "[Lqr4/e;", "Lqr4/a;", "penetrateExt", "[Lqr4/a;", "pageSize", "recomInfo", "itemId", "<init>", "(JIILjava/lang/String;[Lqr4/e;[Lqr4/a;ILjava/lang/String;Ljava/lang/String;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveGetFeedsListRequest<T> extends QQLiveBaseRequest<T> {
    static IPatchRedirector $redirector_;
    private final int fromId;

    @NotNull
    private final String itemId;
    private final int pageSize;

    @Nullable
    private final a[] penetrateExt;

    @Nullable
    private final e[] penetrateInfo;

    @NotNull
    private final String recomInfo;
    private final long roomId;

    @NotNull
    private final String sceneId;
    private final int size;

    public /* synthetic */ QQLiveGetFeedsListRequest(long j3, int i3, int i16, String str, e[] eVarArr, a[] aVarArr, int i17, String str2, String str3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? "" : str, (i18 & 16) != 0 ? null : eVarArr, (i18 & 32) != 0 ? null : aVarArr, (i18 & 64) != 0 ? 10 : i17, (i18 & 128) != 0 ? "" : str2, (i18 & 256) != 0 ? "" : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, eVarArr, aVarArr, Integer.valueOf(i17), str2, str3, Integer.valueOf(i18), defaultConstructorMarker);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) convertInputStreamtoByteArray);
        }
        try {
            return (T) d.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveGetFeedsListRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "trpc.qlive.trpc_switch_room_list.trpc_switch_room_list";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageNano) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        c cVar = new c();
        cVar.f429384f = this.roomId;
        cVar.f429383e = this.size;
        cVar.f429380b = this.fromId;
        cVar.f429388j = this.sceneId;
        cVar.f429381c = this.penetrateInfo;
        cVar.f429387i = this.penetrateExt;
        cVar.f429379a = this.pageSize;
        cVar.f429382d = this.recomInfo;
        cVar.f429386h = this.itemId;
        return cVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "GetFeedsList";
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "roomId=" + this.roomId + ", size=" + this.size + ", fromId=" + this.fromId + ", sceneId=" + this.sceneId;
    }

    public QQLiveGetFeedsListRequest(long j3, int i3, int i16, @NotNull String sceneId, @Nullable e[] eVarArr, @Nullable a[] aVarArr, int i17, @NotNull String recomInfo, @NotNull String itemId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(recomInfo, "recomInfo");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), sceneId, eVarArr, aVarArr, Integer.valueOf(i17), recomInfo, itemId);
            return;
        }
        this.roomId = j3;
        this.size = i3;
        this.fromId = i16;
        this.sceneId = sceneId;
        this.penetrateInfo = eVarArr;
        this.penetrateExt = aVarArr;
        this.pageSize = i17;
        this.recomInfo = recomInfo;
        this.itemId = itemId;
    }
}
