package com.tencent.mobileqq.tvideo.account.tenvideo.model.request;

import com.squareup.wire.ProtoAdapter;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectToken;
import com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tvideo.CurLoginToken;
import tvideo.LoginRequest;
import tvideo.LoginResponse;
import tvideo.TokenKeyType;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/model/request/VideoLoginRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoPbBaseRequest;", "Ltvideo/LoginRequest;", "Ltvideo/LoginResponse;", "", "getCallee", "getFunc", "getRequest", "Lcom/squareup/wire/ProtoAdapter;", "getResponseAdapter", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "qqToken", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "", QCircleDaTongConstant.ElementParamValue.MANUAL, "Z", "", "Ltvideo/CurLoginToken;", "tokenList", "Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class VideoLoginRequest extends TVideoPbBaseRequest<LoginRequest, LoginResponse> {
    private final boolean manual;

    @NotNull
    private final TVideoQQConnectToken qqToken;

    @NotNull
    private final List<CurLoginToken> tokenList;

    public VideoLoginRequest(@NotNull TVideoQQConnectToken qqToken, boolean z16) {
        List<CurLoginToken> listOf;
        Intrinsics.checkNotNullParameter(qqToken, "qqToken");
        this.qqToken = qqToken;
        this.manual = z16;
        CurLoginToken build = new CurLoginToken.a().c("102031143").e(TokenKeyType.TOKEN_KEY_TYPE_QQ_HULIAN).h(qqToken.getOpenId()).g(qqToken.getAccessToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026                 .build()");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(build);
        this.tokenList = listOf;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getCallee() {
        return "com.tencent.spp_rpc.bazel.RpcLogin";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getFunc() {
        return "/com.tencent.spp_rpc.bazel.RpcLogin/Login";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest
    @NotNull
    public ProtoAdapter<LoginResponse> getResponseAdapter() {
        ProtoAdapter<LoginResponse> ADAPTER = LoginResponse.ADAPTER;
        Intrinsics.checkNotNullExpressionValue(ADAPTER, "ADAPTER");
        return ADAPTER;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest
    @NotNull
    public LoginRequest getRequest() {
        LoginRequest build = new LoginRequest.a().c(this.tokenList).d(false).b(this.manual).e(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026\n                .build()");
        return build;
    }
}
