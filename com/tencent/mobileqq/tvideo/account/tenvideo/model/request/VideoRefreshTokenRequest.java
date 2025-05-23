package com.tencent.mobileqq.tvideo.account.tenvideo.model.request;

import bu2.a;
import com.squareup.wire.ProtoAdapter;
import com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest;
import eu2.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tvideo.CurLoginToken;
import tvideo.RefreshSource;
import tvideo.RefreshTokenRequest;
import tvideo.RefreshTokenResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/model/request/VideoRefreshTokenRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoPbBaseRequest;", "Ltvideo/RefreshTokenRequest;", "Ltvideo/RefreshTokenResponse;", "", "getCallee", "getFunc", "getRequest", "Lcom/squareup/wire/ProtoAdapter;", "getResponseAdapter", "Lbu2/a;", "account", "Lbu2/a;", "", "priority", "I", "", "Ltvideo/CurLoginToken;", "tokenList", "Ljava/util/List;", "<init>", "(Lbu2/a;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class VideoRefreshTokenRequest extends TVideoPbBaseRequest<RefreshTokenRequest, RefreshTokenResponse> {

    @NotNull
    private final a account;
    private final int priority;

    @NotNull
    private final List<CurLoginToken> tokenList;

    public VideoRefreshTokenRequest(@NotNull a account, int i3) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.account = account;
        this.priority = i3;
        this.tokenList = f.f397149a.a(account);
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getCallee() {
        return "com.tencent.spp_rpc.bazel.RpcLogin";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getFunc() {
        return "/com.tencent.spp_rpc.bazel.RpcLogin/RefreshToken";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest
    @NotNull
    public ProtoAdapter<RefreshTokenResponse> getResponseAdapter() {
        ProtoAdapter<RefreshTokenResponse> ADAPTER = RefreshTokenResponse.ADAPTER;
        Intrinsics.checkNotNullExpressionValue(ADAPTER, "ADAPTER");
        return ADAPTER;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest
    @NotNull
    public RefreshTokenRequest getRequest() {
        RefreshTokenRequest build = new RefreshTokenRequest.a().c(this.tokenList).e(false).b(this.priority).f(false).d(RefreshSource.SOURCE_NORMAL).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().login_token(to\u2026\n                .build()");
        return build;
    }
}
