package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import java.io.IOException;
import trpc.feedcloud.tip_off.SubmitTipOffReq;
import trpc.feedcloud.tip_off.SubmitTipOffRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleReportRequest extends QCircleBaseRequest {
    private final String mCommentId;
    private final String mFeedId;
    private final boolean mIsComment;
    private final String mReplyId;
    private final String mReportType;

    public QCircleReportRequest(String str, String str2, String str3, boolean z16, String str4) {
        this.mFeedId = str;
        this.mCommentId = str2;
        this.mReplyId = str3;
        this.mIsComment = z16;
        this.mReportType = str4;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.yuhengservice.tip_off.TipOff.SubmitTipOff";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        SubmitTipOffReq.a aVar = new SubmitTipOffReq.a();
        aVar.d(this.mFeedId).g(0).f(this.mReportType).a(this.mCommentId);
        if (this.mIsComment) {
            aVar.b(1);
        }
        if (!TextUtils.isEmpty(this.mReplyId)) {
            aVar.i(this.mReplyId);
        }
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public SubmitTipOffRsp decode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return SubmitTipOffRsp.ADAPTER.decode(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
