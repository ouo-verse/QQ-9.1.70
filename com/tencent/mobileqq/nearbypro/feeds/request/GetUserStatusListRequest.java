package com.tencent.mobileqq.nearbypro.feeds.request;

import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import up4.a;
import up4.b;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/request/GetUserStatusListRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "Lup4/a;", "Lup4/b;", "T", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "pbReq", "Lup4/a;", "getPbReq", "()Lup4/a;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "cmd", "Ljava/lang/String;", "getCmd", "()Ljava/lang/String;", "tinyId", "", "reqScene", "repCount", "attachInfo", "<init>", "(Ljava/lang/String;II[B)V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GetUserStatusListRequest extends NearbyProBasePBRequest<a, b> {
    public static final int GET_LIST_PER_PAGE_COUNT = 10;

    @NotNull
    private final String cmd;

    @NotNull
    private final a pbReq;

    @NotNull
    private final Function0<b> pbRspConstructor;

    public /* synthetic */ GetUserStatusListRequest(String str, int i3, int i16, byte[] bArr, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 10 : i16, (i17 & 8) != 0 ? new byte[0] : bArr);
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        T t16 = (T) new b();
        try {
            T t17 = (T) b.c(convertInputStreamtoByteArray);
            Intrinsics.checkNotNullExpressionValue(t17, "parseFrom(convertInputStreamtoByteArray)");
            return t17;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return t16;
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public String getCmd() {
        return this.cmd;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public Function0<b> getPbRspConstructor() {
        return this.pbRspConstructor;
    }

    public GetUserStatusListRequest(@NotNull String tinyId, int i3, int i16, @NotNull byte[] attachInfo) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        a aVar = new a();
        aVar.f439761a = tinyId;
        aVar.f439763c = attachInfo;
        aVar.f439764d = i3;
        aVar.f439762b = i16;
        aVar.f439765e = com.tencent.mobileqq.nearbypro.request.a.a();
        this.pbReq = aVar;
        this.pbRspConstructor = new Function0<b>() { // from class: com.tencent.mobileqq.nearbypro.feeds.request.GetUserStatusListRequest$pbRspConstructor$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return new b();
            }
        };
        this.cmd = "trpc.lplan.feed_svr.StatusRead.SsoGetUserStatusList";
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public a getPbReq() {
        return this.pbReq;
    }
}
