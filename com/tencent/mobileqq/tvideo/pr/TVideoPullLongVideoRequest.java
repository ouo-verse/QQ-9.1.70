package com.tencent.mobileqq.tvideo.pr;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import tvideo.TVideoQueryBubble$QueryBubbleInfoReq;
import tvideo.TVideoQueryBubble$QueryBubbleInfoResp;

/* loaded from: classes19.dex */
public class TVideoPullLongVideoRequest extends TVideoBaseRequest {
    private String cid;
    private String vid;

    public TVideoPullLongVideoRequest(String str, String str2) {
        this.vid = TextUtils.isEmpty(str) ? "" : str;
        this.cid = TextUtils.isEmpty(str2) ? "" : str2;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/growth/videoserver/QueryBubbleInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoQueryBubble$QueryBubbleInfoReq tVideoQueryBubble$QueryBubbleInfoReq = new TVideoQueryBubble$QueryBubbleInfoReq();
        tVideoQueryBubble$QueryBubbleInfoReq.vid.set(this.vid);
        tVideoQueryBubble$QueryBubbleInfoReq.cid.set(this.cid);
        return tVideoQueryBubble$QueryBubbleInfoReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        TVideoQueryBubble$QueryBubbleInfoResp tVideoQueryBubble$QueryBubbleInfoResp = new TVideoQueryBubble$QueryBubbleInfoResp();
        try {
            tVideoQueryBubble$QueryBubbleInfoResp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return tVideoQueryBubble$QueryBubbleInfoResp;
    }
}
