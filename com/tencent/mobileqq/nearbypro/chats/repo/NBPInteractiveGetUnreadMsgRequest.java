package com.tencent.mobileqq.nearbypro.chats.repo;

import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/repo/NBPInteractiveGetUnreadMsgRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "withExtraInfo", "", "(Z)V", "getWithExtraInfo", "()Z", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
final class NBPInteractiveGetUnreadMsgRequest extends NearbyProBaseRequest {
    private final boolean withExtraInfo;

    public NBPInteractiveGetUnreadMsgRequest(boolean z16) {
        this.withExtraInfo = z16;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        T t16 = (T) new tp4.b();
        try {
            T t17 = (T) tp4.b.c(convertInputStreamtoByteArray);
            Intrinsics.checkNotNullExpressionValue(t17, "parseFrom(convertInputStreamtoByteArray)");
            return t17;
        } catch (InvalidProtocolBufferMicroException e16) {
            j.c().d("NBPInteractiveGetUnreadMsgRequest", "parse error: " + e16);
            return t16;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.lplan.like_svr.Like.SsoGetUnreadMsg";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        tp4.a aVar = new tp4.a();
        if (this.withExtraInfo) {
            aVar.f437066a = com.tencent.mobileqq.nearbypro.request.a.a();
        }
        return com.tencent.mobileqq.nearbypro.request.c.c(aVar);
    }

    public final boolean getWithExtraInfo() {
        return this.withExtraInfo;
    }
}
