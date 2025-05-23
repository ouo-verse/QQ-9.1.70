package com.tencent.mobileqq.tvideo.net.request;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPageRequest;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPageResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoIntroductionRequest extends TVideoBaseRequest {
    private final String cid;

    public TVideoIntroductionRequest(String str) {
        this.cid = str;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.growth.video_server.VideoServer/VideoBriefIntroductionPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        VideoBriefIntro$VideoBriefIntroductionPageRequest videoBriefIntro$VideoBriefIntroductionPageRequest = new VideoBriefIntro$VideoBriefIntroductionPageRequest();
        videoBriefIntro$VideoBriefIntroductionPageRequest.cid.set(this.cid);
        return videoBriefIntro$VideoBriefIntroductionPageRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        VideoBriefIntro$VideoBriefIntroductionPageResponse videoBriefIntro$VideoBriefIntroductionPageResponse = new VideoBriefIntro$VideoBriefIntroductionPageResponse();
        try {
            videoBriefIntro$VideoBriefIntroductionPageResponse.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return videoBriefIntro$VideoBriefIntroductionPageResponse;
    }
}
