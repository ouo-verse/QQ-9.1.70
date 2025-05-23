package com.tencent.biz.qqcircle.comment.recpic;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import feedcloud.BusinessScene;
import feedcloud.MultiInferTextReq;
import feedcloud.MultiInferTextRsp;
import feedcloud.TextPipeline;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSInferTextRequest extends QCircleBaseRequest {
    private final String mText;
    private final List<TextPipeline> pipelines;
    private final BusinessScene scene;

    public QFSInferTextRequest(String str, List<TextPipeline> list, BusinessScene businessScene) {
        this.mText = str;
        this.pipelines = list;
        this.scene = businessScene;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.clip_infer_svr.ClipInferSvr.MultiInferText";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        MultiInferTextReq.a aVar = new MultiInferTextReq.a();
        aVar.f398514b = this.mText;
        aVar.f398513a = 1;
        aVar.f398516d.addAll(this.pipelines);
        aVar.f398515c = this.scene;
        return aVar.build().encode();
    }

    public String getText() {
        return this.mText;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MultiInferTextRsp decode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MultiInferTextRsp.ADAPTER.decode(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public QFSInferTextRequest(String str, BusinessScene businessScene) {
        this.mText = str;
        this.pipelines = new ArrayList();
        this.scene = businessScene;
    }
}
