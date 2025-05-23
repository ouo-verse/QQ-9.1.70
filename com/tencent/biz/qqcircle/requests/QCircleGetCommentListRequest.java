package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetCommentListReq;
import feedcloud.FeedCloudRead$StGetCommentListRsp;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetCommentListRequest extends QCircleBaseRequest {
    public static final int COMMENT_LIST_REQ_TYPE_BARRAGE = 1;
    public static final int COMMENT_LIST_REQ_TYPE_UNKNOWN = 0;
    public FeedCloudRead$StGetCommentListReq req;

    public QCircleGetCommentListRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, String str2) {
        this(feedCloudMeta$StFeed, 0, str, i3, str2);
    }

    private boolean a() {
        String b16 = l.b("exp_xsj_cmt_req_reduce");
        if (!TextUtils.isEmpty(b16)) {
            l.i("exp_xsj_cmt_req_reduce");
        }
        boolean equals = TextUtils.equals(b16, "exp_xsj_cmt_req_reduce_B");
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102831", true) && equals) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getAttachInfo() {
        String b16 = l.b("exp_xsj_cmt_req_reduce");
        if (TextUtils.isEmpty(b16)) {
            return super.getAttachInfo();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("S1", b16);
        } catch (JSONException unused) {
            QLog.d(BaseRequest.TAG, 1, "put json param error. ");
        }
        return "exp=" + jSONObject;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommentList";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) a.b("comment_list").second;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getRefer() {
        FeedCloudRead$StGetCommentListReq feedCloudRead$StGetCommentListReq = this.req;
        if (feedCloudRead$StGetCommentListReq != null && !TextUtils.isEmpty(feedCloudRead$StGetCommentListReq.feedAttchInfo.get())) {
            return "0";
        }
        return "1";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) a.b("comment_list").first;
    }

    public QCircleGetCommentListRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, String str, int i16, String str2, String str3) {
        this(feedCloudMeta$StFeed, 0, str, i16, str2);
        this.req.hot_comment_id.set(str3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetCommentListRsp feedCloudRead$StGetCommentListRsp = new FeedCloudRead$StGetCommentListRsp();
        try {
            feedCloudRead$StGetCommentListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetCommentListRsp;
    }

    public QCircleGetCommentListRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, String str, int i16, String str2) {
        FeedCloudRead$StGetCommentListReq feedCloudRead$StGetCommentListReq = new FeedCloudRead$StGetCommentListReq();
        this.req = feedCloudRead$StGetCommentListReq;
        if (feedCloudMeta$StFeed != null) {
            feedCloudRead$StGetCommentListReq.userId.set(feedCloudMeta$StFeed.poster.f398463id.get());
            this.req.feedId.set(feedCloudMeta$StFeed.f398449id.get());
            if (!a()) {
                this.req.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
            }
            if (feedCloudMeta$StFeed.commentExtraInfo.reddotInfo.has()) {
                QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData = new QQCircleFeedBase$StBusiInfoCommentListData();
                qQCircleFeedBase$StBusiInfoCommentListData.comment.setHasFlag(true);
                qQCircleFeedBase$StBusiInfoCommentListData.comment.f398447id.set(feedCloudMeta$StFeed.commentExtraInfo.reddotInfo.commentId.get());
                qQCircleFeedBase$StBusiInfoCommentListData.reply.setHasFlag(true);
                qQCircleFeedBase$StBusiInfoCommentListData.reply.f398460id.set(feedCloudMeta$StFeed.commentExtraInfo.reddotInfo.replyId.get());
                this.req.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StBusiInfoCommentListData.toByteArray()));
            }
            this.req.commentCount.set(feedCloudMeta$StFeed.commentCount.get());
        }
        if (str != null) {
            this.req.feedAttchInfo.set(str);
        }
        this.req.from.set(i3);
        this.req.listNum.set(i16);
        this.req.likeKey.set(str2);
        this.req.replyType.set(1);
    }
}
