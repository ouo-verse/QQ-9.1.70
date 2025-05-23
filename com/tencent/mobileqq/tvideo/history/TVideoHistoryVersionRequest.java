package com.tencent.mobileqq.tvideo.history;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import tvideo.TVideoHistory$GetDataVersionRequest;
import tvideo.TVideoHistory$GetDataVersionResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoHistoryVersionRequest extends TVideoBaseRequest {
    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.growth.video_server.VideoHistoryServer/GetDataVersion";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return new MessageMicro<TVideoHistory$GetDataVersionRequest>() { // from class: tvideo.TVideoHistory$GetDataVersionRequest
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TVideoHistory$GetDataVersionRequest.class);
        }.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        TVideoHistory$GetDataVersionResponse tVideoHistory$GetDataVersionResponse = new TVideoHistory$GetDataVersionResponse();
        try {
            tVideoHistory$GetDataVersionResponse.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return tVideoHistory$GetDataVersionResponse;
    }
}
