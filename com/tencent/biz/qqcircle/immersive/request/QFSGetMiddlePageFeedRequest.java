package com.tencent.biz.qqcircle.immersive.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import uq3.c;
import z20.h;

/* loaded from: classes4.dex */
public class QFSGetMiddlePageFeedRequest extends QCircleBaseRequest {
    private final String mCmd;
    private String mDtPageId;
    private QCircleInitBean mInitBean;
    private boolean mIsRefresh;
    public FeedCloudRead$StGetFeedListReq mRequest;

    /* loaded from: classes4.dex */
    class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(BaseRequest baseRequest) {
            com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            cq.f92752a.b(QFSGetMiddlePageFeedRequest.this.mRequest);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    public QFSGetMiddlePageFeedRequest(QCircleInitBean qCircleInitBean, String str, boolean z16) {
        String str2;
        String dtFromPageId;
        if (b(qCircleInitBean)) {
            str2 = "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetQQContactFriendHeadFeedList";
        } else {
            str2 = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        }
        this.mCmd = str2;
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        this.mInitBean = qCircleInitBean;
        this.mIsRefresh = z16;
        if (qCircleInitBean == null) {
            return;
        }
        FeedCloudMeta$StFeed simpleFeed = QCirclePluginUtil.getSimpleFeed(qCircleInitBean.getFeed());
        if (str == null && !z16) {
            this.mRequest.feed.set(simpleFeed);
            this.mRequest.feed.busiTranparent.set(qCircleInitBean.getFeed().busiTranparent.get());
            if (simpleFeed != null) {
                QLog.i("QFSGetMiddlePageFeedRequest", 1, "feedId = " + simpleFeed.f398449id.get());
            }
        }
        if (qCircleInitBean.getExtraTypeInfo() != null) {
            this.mRequest.source.set(qCircleInitBean.getExtraTypeInfo().sourceType);
            if (qCircleInitBean.getExtraTypeInfo().subSource != 0) {
                this.mRequest.subSource.set(qCircleInitBean.getExtraTypeInfo().subSource);
            }
        }
        this.mRequest.listNum.set(10);
        if (str != null) {
            this.mRequest.feedAttchInfo.set(str);
        }
        QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qCircleInitBean.getFeedListBusiReq();
        if (this.mRequest.source.get() == 63 && qCircleInitBean.getHotEventInfo() != null) {
            feedListBusiReq.tagId.set(qCircleInitBean.getHotEventInfo().getId());
        }
        if (!z16) {
            feedListBusiReq.detailFeed.set(simpleFeed);
            e(qCircleInitBean, feedListBusiReq);
        }
        a(feedListBusiReq);
        if (qCircleInitBean.isMiddlePage()) {
            this.mRequest.isMiddlePage.set(true);
        }
        PBBytesField pBBytesField = this.mRequest.adres;
        j jVar = j.f90213a;
        String str3 = feedListBusiReq.entrySchema.get();
        if (qCircleInitBean.getFromReportBean() == null) {
            dtFromPageId = "";
        } else {
            dtFromPageId = qCircleInitBean.getFromReportBean().getDtFromPageId();
        }
        pBBytesField.set(jVar.m(str3, dtFromPageId));
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
        this.mRequest.extInfo.mapInfo.add(r.H());
        setTimeout(c.P4());
        addRequestInterceptor(new a());
    }

    private void a(QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
        int i3;
        try {
            i3 = Integer.parseInt(c.x2());
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        QLog.i("QFSGetMiddlePageFeedRequest", 1, "isNewLayerMode:" + i3);
        if (i3 > 0) {
            qQCircleFeedBase$StFeedListBusiReqData.pageLayoutType.set(i3);
        }
    }

    private boolean b(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            return QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE.equals(qCircleInitBean.getSchemeAttrs().get("xsj_custom_pgid"));
        }
        return false;
    }

    private boolean c() {
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null && this.mInitBean.getExtraTypeInfo().sourceType == 90) {
            return true;
        }
        return false;
    }

    private boolean d() {
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null && this.mInitBean.getExtraTypeInfo().sourceType == 15) {
            return true;
        }
        return false;
    }

    private void e(QCircleInitBean qCircleInitBean, QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
        HashMap<String, String> schemeAttrs;
        String str;
        String str2;
        if (qCircleInitBean == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null) {
            return;
        }
        if (schemeAttrs.containsKey("key_scheme") && (str2 = schemeAttrs.get("key_scheme")) != null) {
            qQCircleFeedBase$StFeedListBusiReqData.entrySchema.set(str2);
        }
        if (schemeAttrs.containsKey("transdata") && (str = schemeAttrs.get("transdata")) != null) {
            qQCircleFeedBase$StFeedListBusiReqData.schemaTrans.set(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return this.mCmd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public int getCount(@Nullable Object obj) {
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        if ((obj instanceof FeedCloudRead$StGetFeedListRsp) && (pBRepeatMessageField = ((FeedCloudRead$StGetFeedListRsp) obj).vecFeed) != null) {
            return pBRepeatMessageField.get().size();
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

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        if (b(this.mInitBean)) {
            return (String) com.tencent.biz.qqcircle.requests.a.b("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetQQContactFriendHeadFeedList").second;
        }
        if (c()) {
            return (String) com.tencent.biz.qqcircle.requests.a.b("detail_from_qzone").second;
        }
        if (d()) {
            return (String) com.tencent.biz.qqcircle.requests.a.b("new_style_detail_feed_list").second;
        }
        return super.getMethodName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getRefer() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq;
        if ((!this.mIsRefresh && ((feedCloudRead$StGetFeedListReq = this.mRequest) == null || TextUtils.isEmpty(feedCloudRead$StGetFeedListReq.feedAttchInfo.get()))) || this.mIsRefresh) {
            return "1";
        }
        return "0";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return getRequestByteData();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        if (b(this.mInitBean)) {
            if (!h.b()) {
                return "";
            }
            return (String) com.tencent.biz.qqcircle.requests.a.b("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetQQContactFriendHeadFeedList").first;
        }
        if (c()) {
            return (String) com.tencent.biz.qqcircle.requests.a.b("detail_from_qzone").first;
        }
        if (d()) {
            return (String) com.tencent.biz.qqcircle.requests.a.b("new_style_detail_feed_list").first;
        }
        return super.getServiceName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getType() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = this.mRequest;
        if (feedCloudRead$StGetFeedListReq != null) {
            return String.valueOf(feedCloudRead$StGetFeedListReq.source.get());
        }
        return super.getType();
    }

    public void setDtPageId(String str) {
        this.mDtPageId = str;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
