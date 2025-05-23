package com.tencent.mobileqq.tvideo.like;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import tvideo.TVideoLike$GetAttitudeInfoRequest;
import tvideo.TVideoLike$GetAttitudeInfoResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoLikeDataRequest extends TVideoBaseRequest {
    private final String vid;

    public TVideoLikeDataRequest(String str) {
        this.vid = str;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tvideo.TVideoLike$GetAttitudeInfoResponse, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        ?? r06 = (T) new TVideoLike$GetAttitudeInfoResponse();
        try {
            return (T) ((TVideoLike$GetAttitudeInfoResponse) r06.mergeFrom(bArr));
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
        return "/trpc.growth.video_server.VideoServer/GetAttitudeInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoLike$GetAttitudeInfoRequest tVideoLike$GetAttitudeInfoRequest = new TVideoLike$GetAttitudeInfoRequest();
        tVideoLike$GetAttitudeInfoRequest.vid.set(this.vid);
        tVideoLike$GetAttitudeInfoRequest.get_option_type.set(0);
        return tVideoLike$GetAttitudeInfoRequest.toByteArray();
    }
}
