package com.tencent.biz.richframework.network.request;

import NS_QQ_STORY_CLIENT.CLIENT$StBatchGetMusicInfoReq;
import NS_QQ_STORY_CLIENT.CLIENT$StBatchGetMusicInfoRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BatchGetMusicInfoRequest extends VSBaseRequest {
    private final CLIENT$StBatchGetMusicInfoReq req;

    public BatchGetMusicInfoRequest(ArrayList<String> arrayList) {
        CLIENT$StBatchGetMusicInfoReq cLIENT$StBatchGetMusicInfoReq = new CLIENT$StBatchGetMusicInfoReq();
        this.req = cLIENT$StBatchGetMusicInfoReq;
        cLIENT$StBatchGetMusicInfoReq.needLyric.set(1);
        cLIENT$StBatchGetMusicInfoReq.vecSongMid.set(arrayList);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "LightAppSvc.qq_story_client.BatchGetMusicInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CLIENT$StBatchGetMusicInfoRsp cLIENT$StBatchGetMusicInfoRsp = new CLIENT$StBatchGetMusicInfoRsp();
        try {
            cLIENT$StBatchGetMusicInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return cLIENT$StBatchGetMusicInfoRsp;
    }
}
