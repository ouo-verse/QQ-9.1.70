package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedDetailReq;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase$StFeedDetailBizReqData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGetFeedDetailRequest extends QCircleBaseRequest {
    private String mDtPageId;
    private QCircleInitBean mInitBean;
    public FeedCloudRead$StGetFeedDetailReq mRequest;

    public QFSGetFeedDetailRequest(String str, boolean z16) {
        this(str, z16, 0, null, null);
    }

    private int a(int i3, QCircleInitBean qCircleInitBean) {
        int i16;
        if (qCircleInitBean != null) {
            i16 = qCircleInitBean.getExtraTypeInfo().sourceType;
        } else {
            i16 = 0;
        }
        if (i16 == 1002) {
            return 3;
        }
        return i3;
    }

    private void b(QCircleInitBean qCircleInitBean, @NonNull FeedCloudRead$StGetFeedDetailReq feedCloudRead$StGetFeedDetailReq) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && qCircleInitBean.getSchemeAttrs().size() != 0) {
            String str = qCircleInitBean.getSchemeAttrs().get("trace_id");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("qq_trace_id");
            feedCloudCommon$Entry.value.set(str);
            feedCloudRead$StGetFeedDetailReq.extInfo.mapInfo.add(feedCloudCommon$Entry);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public int getCount(@Nullable Object obj) {
        if ((obj instanceof FeedCloudRead$StGetFeedDetailRsp) && ((FeedCloudRead$StGetFeedDetailRsp) obj).feed != null) {
            return 1;
        }
        return super.getCount(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getExt1() {
        return this.mDtPageId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getInfo() {
        HashMap<String, String> hashMap;
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean != null) {
            hashMap = qCircleInitBean.getSchemeAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap != null && hashMap.size() > 0) {
            return hashMap.get("xsj_main_entrance");
        }
        return super.getInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getRefer() {
        return "1";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    public void setDtPageId(String str) {
        this.mDtPageId = str;
    }

    public QFSGetFeedDetailRequest(String str, boolean z16, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleInitBean qCircleInitBean) {
        FeedCloudMeta$StFeed simpleFeed;
        this.mInitBean = qCircleInitBean;
        FeedCloudRead$StGetFeedDetailReq feedCloudRead$StGetFeedDetailReq = new FeedCloudRead$StGetFeedDetailReq();
        this.mRequest = feedCloudRead$StGetFeedDetailReq;
        feedCloudRead$StGetFeedDetailReq.feedId.set(str);
        this.mRequest.useUGCStore.set(z16);
        this.mRequest.from.set(a(i3, qCircleInitBean));
        b(qCircleInitBean, this.mRequest);
        if (feedCloudMeta$StFeed != null && (simpleFeed = QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed)) != null) {
            simpleFeed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
            this.mRequest.entryFeed.set(simpleFeed);
        }
        if (qCircleInitBean != null) {
            if (qCircleInitBean.isMiddlePage()) {
                this.mRequest.isMiddlePage.set(true);
            }
            if (qCircleInitBean.getSchemeAttrs() == null || !qCircleInitBean.getSchemeAttrs().containsKey("key_scheme")) {
                return;
            }
            String str2 = qCircleInitBean.getSchemeAttrs().get("key_scheme");
            QQCircleFeedBase$StFeedDetailBizReqData qQCircleFeedBase$StFeedDetailBizReqData = new QQCircleFeedBase$StFeedDetailBizReqData();
            if (str2 != null) {
                qQCircleFeedBase$StFeedDetailBizReqData.entrySchema.set(str2);
            }
            this.mRequest.bizReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedDetailBizReqData.toByteArray()));
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp = new FeedCloudRead$StGetFeedDetailRsp();
        try {
            feedCloudRead$StGetFeedDetailRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedDetailRsp;
    }
}
