package com.tencent.mobileqq.tvideo.like;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import tvideo.TVideoLike$UserAttitudeOptionRequest;
import tvideo.TVideoLike$UserAttitudeOptionResponse;

/* loaded from: classes19.dex */
public class TVideoLikePublishRequest extends TVideoBaseRequest {
    private TVideoLike$UserAttitudeOptionRequest likeRequest;

    public TVideoLikePublishRequest(TVideoLike$UserAttitudeOptionRequest tVideoLike$UserAttitudeOptionRequest) {
        this.likeRequest = tVideoLike$UserAttitudeOptionRequest;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tvideo.TVideoLike$UserAttitudeOptionResponse, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        ?? r06 = (T) new TVideoLike$UserAttitudeOptionResponse();
        try {
            return (T) ((TVideoLike$UserAttitudeOptionResponse) r06.mergeFrom(bArr));
        } catch (IOException e16) {
            e16.printStackTrace();
            return r06;
        }
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.growth.video_server.VideoServer/UserAttitudeOption";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.likeRequest.toByteArray();
    }
}
