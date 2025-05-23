package com.tencent.mobileqq.tvideo.temporaryauth;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import tvideo.TVideoTemporaryAuth$CheckAuthorizeTabRequest;
import tvideo.TVideoTemporaryAuth$CheckAuthorizeTabResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoCheckTemporaryAuthRequest extends TVideoBaseRequest {
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, tvideo.TVideoTemporaryAuth$CheckAuthorizeTabResponse] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        ?? r06 = (T) new TVideoTemporaryAuth$CheckAuthorizeTabResponse();
        try {
            return (T) ((TVideoTemporaryAuth$CheckAuthorizeTabResponse) r06.mergeFrom(bArr));
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
        return "/trpc.growth.video_server.VideoServer/CheckAuthorizeTab";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoTemporaryAuth$CheckAuthorizeTabRequest tVideoTemporaryAuth$CheckAuthorizeTabRequest = new TVideoTemporaryAuth$CheckAuthorizeTabRequest();
        tVideoTemporaryAuth$CheckAuthorizeTabRequest.authorize_pgid.set(3);
        tVideoTemporaryAuth$CheckAuthorizeTabRequest.authorize_source.set(1);
        return tVideoTemporaryAuth$CheckAuthorizeTabRequest.toByteArray();
    }
}
