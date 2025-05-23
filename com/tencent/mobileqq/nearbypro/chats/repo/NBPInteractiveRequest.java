package com.tencent.mobileqq.nearbypro.chats.repo;

import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/repo/NBPInteractiveRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "", "getCmdName", "", "getRequestByteData", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "fetchCount", "I", "fetchCookie", "[B", "Lwp4/a;", "req", "Lwp4/a;", "<init>", "(I[B)V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPInteractiveRequest extends NearbyProBaseRequest {

    @NotNull
    public static final String TAG = "NBPInteractiveRequest";

    @NotNull
    private final byte[] fetchCookie;
    private final int fetchCount;

    @NotNull
    private wp4.a req;

    public NBPInteractiveRequest(int i3, @NotNull byte[] fetchCookie) {
        Intrinsics.checkNotNullParameter(fetchCookie, "fetchCookie");
        this.fetchCount = i3;
        this.fetchCookie = fetchCookie;
        wp4.a aVar = new wp4.a();
        aVar.f446033b = i3;
        aVar.f446032a = com.tencent.mobileqq.nearbypro.request.a.a();
        aVar.f446034c = fetchCookie;
        this.req = aVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        T t16 = (T) new wp4.b();
        try {
            T t17 = (T) wp4.b.c(convertInputStreamtoByteArray);
            Intrinsics.checkNotNullExpressionValue(t17, "parseFrom(convertInputStreamtoByteArray)");
            return t17;
        } catch (InvalidProtocolBufferMicroException e16) {
            j.c().d(TAG, "decode NBPInteractiveRequest error: " + e16);
            return t16;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "trpc.lplan.interact_svr.Interact.SsoGetInteractMsgList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return com.tencent.mobileqq.nearbypro.request.c.c(this.req);
    }
}
