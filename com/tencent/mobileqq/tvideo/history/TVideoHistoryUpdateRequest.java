package com.tencent.mobileqq.tvideo.history;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.util.List;
import tvideo.TVideoHistory$AddOrUpdateHistoryRequest;
import tvideo.TVideoHistory$AddOrUpdateHistoryResponse;
import tvideo.TVideoHistory$VideoHistoryRecord;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoHistoryUpdateRequest extends TVideoBaseRequest {
    private long dataVersion;
    private List<TVideoHistory$VideoHistoryRecord> recordMsgList;

    public TVideoHistoryUpdateRequest(long j3, List<TVideoHistory$VideoHistoryRecord> list) {
        this.dataVersion = j3;
        this.recordMsgList = list;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.growth.video_server.VideoHistoryServer/AddOrUpdateHistory";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoHistory$AddOrUpdateHistoryRequest tVideoHistory$AddOrUpdateHistoryRequest = new TVideoHistory$AddOrUpdateHistoryRequest();
        tVideoHistory$AddOrUpdateHistoryRequest.data_version.set(this.dataVersion);
        tVideoHistory$AddOrUpdateHistoryRequest.video_history_records.set(this.recordMsgList);
        return tVideoHistory$AddOrUpdateHistoryRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        TVideoHistory$AddOrUpdateHistoryResponse tVideoHistory$AddOrUpdateHistoryResponse = new TVideoHistory$AddOrUpdateHistoryResponse();
        try {
            tVideoHistory$AddOrUpdateHistoryResponse.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return tVideoHistory$AddOrUpdateHistoryResponse;
    }
}
