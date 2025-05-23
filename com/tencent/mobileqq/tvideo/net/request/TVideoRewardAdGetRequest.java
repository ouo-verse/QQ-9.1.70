package com.tencent.mobileqq.tvideo.net.request;

import com.squareup.wire.ProtoAdapter;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateRequest;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/request/TVideoRewardAdGetRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoPbBaseRequest;", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateRequest;", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateResponse;", Const.BUNDLE_KEY_REQUEST, "(Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateRequest;)V", "getCallee", "", "getFunc", "getRequest", "getResponseAdapter", "Lcom/squareup/wire/ProtoAdapter;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TVideoRewardAdGetRequest extends TVideoPbBaseRequest<RewardAdNewUpdateRequest, RewardAdNewUpdateResponse> {

    @NotNull
    private RewardAdNewUpdateRequest request;

    public TVideoRewardAdGetRequest(@NotNull RewardAdNewUpdateRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getCallee() {
        return "com.tencent.tvideo.protocol.pb.QQRewardService";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getFunc() {
        return "/com.tencent.tvideo.protocol.pb.QQRewardService/GetAds";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest
    @NotNull
    public ProtoAdapter<RewardAdNewUpdateResponse> getResponseAdapter() {
        ProtoAdapter<RewardAdNewUpdateResponse> ADAPTER = RewardAdNewUpdateResponse.ADAPTER;
        Intrinsics.checkNotNullExpressionValue(ADAPTER, "ADAPTER");
        return ADAPTER;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest
    @NotNull
    public RewardAdNewUpdateRequest getRequest() {
        return this.request;
    }
}
