package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.helpers.k;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase$StPageRedPointInfo;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleTabGetFeedListRequest extends QCircleBaseRequest {
    public static final String CMD_GET_FEED_LIST = "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList";
    private final b mBuilder;
    private int mRealRequestSendCount = 0;
    public FeedCloudRead$StGetFeedListReq mRequest;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(BaseRequest baseRequest) {
            com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            cq.f92752a.a(QCircleTabGetFeedListRequest.this.mRequest.extInfo);
            QCircleTabGetFeedListRequest.this.mRealRequestSendCount++;
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private QCircleTabInfo f91862a;

        /* renamed from: b, reason: collision with root package name */
        private String f91863b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f91864c = "";

        /* renamed from: d, reason: collision with root package name */
        private FeedCloudMeta$StGPSV2 f91865d;

        /* renamed from: e, reason: collision with root package name */
        private int f91866e;

        /* renamed from: f, reason: collision with root package name */
        private QQCircleFeedBase$StPageRedPointInfo f91867f;

        /* renamed from: g, reason: collision with root package name */
        private QCircleFolderBean f91868g;

        /* renamed from: h, reason: collision with root package name */
        private QCircleReportBean f91869h;

        /* renamed from: i, reason: collision with root package name */
        private int f91870i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f91871j;

        private void r(QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
            int i3;
            try {
                i3 = Integer.parseInt(c.x2());
            } catch (Exception e16) {
                e16.printStackTrace();
                i3 = 0;
            }
            QLog.i("QCircleTabGetFeedListRequest", 1, "isNewLayerMode:" + i3);
            if (i3 > 0) {
                qQCircleFeedBase$StFeedListBusiReqData.pageLayoutType.set(i3);
            }
        }

        private void s(FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq) {
            int i3;
            boolean z16;
            QCircleTabInfo qCircleTabInfo = this.f91862a;
            if (qCircleTabInfo != null) {
                i3 = qCircleTabInfo.getSource();
            } else {
                i3 = -1;
            }
            if (i3 != 10) {
                return;
            }
            Pair<Boolean, Integer> i16 = au.i();
            int i17 = 0;
            if (i16 != null) {
                z16 = ((Boolean) i16.first).booleanValue();
            } else {
                z16 = false;
            }
            if (i16 != null) {
                i17 = ((Integer) i16.second).intValue();
            }
            if (z16) {
                feedCloudRead$StGetFeedListReq.extInfo.setHasFlag(true);
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry.key.set("share_message_reply_count");
                feedCloudCommon$Entry.value.set(String.valueOf(i17));
                feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(feedCloudCommon$Entry);
                return;
            }
            String f16 = au.f();
            if (TextUtils.isEmpty(f16)) {
                return;
            }
            feedCloudRead$StGetFeedListReq.extInfo.setHasFlag(true);
            FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry2.key.set("user_latest_group");
            feedCloudCommon$Entry2.value.set(f16);
            feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(feedCloudCommon$Entry2);
        }

        public FeedCloudRead$StGetFeedListReq f() {
            FeedCloudMeta$StFeed simpleFeed;
            FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
            feedCloudRead$StGetFeedListReq.listNum.set(10);
            feedCloudRead$StGetFeedListReq.from.set(0);
            feedCloudRead$StGetFeedListReq.source.set(this.f91862a.getSource());
            String str = this.f91863b;
            if (str != null) {
                feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str);
            }
            feedCloudRead$StGetFeedListReq.adres.set(j.f90213a.j());
            feedCloudRead$StGetFeedListReq.subSource.set(this.f91870i);
            QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
            qQCircleFeedBase$StFeedListBusiReqData.tabAttachInfo.set(this.f91862a.getAttachInfo());
            String str2 = this.f91864c;
            if (str2 != null) {
                qQCircleFeedBase$StFeedListBusiReqData.refreshAttachInfo.set(str2);
                QLog.d("QCircleTabGetFeedListRequest", 2, "QCircleGetFeedListRequest RefreshAttachInfo:" + this.f91864c);
            }
            FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2 = this.f91865d;
            if (feedCloudMeta$StGPSV2 != null) {
                qQCircleFeedBase$StFeedListBusiReqData.gpsInfo.set(feedCloudMeta$StGPSV2);
            }
            QQCircleFeedBase$StPageRedPointInfo qQCircleFeedBase$StPageRedPointInfo = this.f91867f;
            if (qQCircleFeedBase$StPageRedPointInfo != null) {
                qQCircleFeedBase$StFeedListBusiReqData.RedPointInfo.set(qQCircleFeedBase$StPageRedPointInfo);
            }
            qQCircleFeedBase$StFeedListBusiReqData.pullSceneType.set(this.f91866e);
            QCircleFolderBean qCircleFolderBean = this.f91868g;
            if (qCircleFolderBean != null && qCircleFolderBean.getLastPageScheme() != null) {
                qQCircleFeedBase$StFeedListBusiReqData.entrySchema.set(this.f91868g.getLastPageScheme());
            } else {
                qQCircleFeedBase$StFeedListBusiReqData.entrySchema.set(QCirclePluginGlobalInfo.z());
                QCirclePluginGlobalInfo.g0("");
            }
            QCircleFolderBean qCircleFolderBean2 = this.f91868g;
            if (qCircleFolderBean2 != null && qCircleFolderBean2.getFeed() != null && (simpleFeed = QCirclePluginUtil.getSimpleFeed(this.f91868g.getFeed())) != null) {
                simpleFeed.busiTranparent.set(this.f91868g.getFeed().busiTranparent.get());
                feedCloudRead$StGetFeedListReq.feed.set(simpleFeed);
            }
            r(qQCircleFeedBase$StFeedListBusiReqData);
            q(feedCloudRead$StGetFeedListReq);
            s(feedCloudRead$StGetFeedListReq);
            feedCloudRead$StGetFeedListReq.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
            return feedCloudRead$StGetFeedListReq;
        }

        public FeedCloudRead$StGetFeedListReq g() {
            FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
            feedCloudRead$StGetFeedListReq.listNum.set(10);
            feedCloudRead$StGetFeedListReq.from.set(0);
            feedCloudRead$StGetFeedListReq.source.set(this.f91862a.getSource());
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(String.valueOf(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()));
            return feedCloudRead$StGetFeedListReq;
        }

        public b h(String str) {
            this.f91863b = str;
            return this;
        }

        public b i(QCircleFolderBean qCircleFolderBean) {
            this.f91868g = qCircleFolderBean;
            return this;
        }

        public b j(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2) {
            this.f91865d = feedCloudMeta$StGPSV2;
            return this;
        }

        public b k(boolean z16) {
            this.f91871j = z16;
            return this;
        }

        public b l(int i3) {
            this.f91866e = i3;
            return this;
        }

        public b m(String str) {
            this.f91864c = str;
            return this;
        }

        public b n(QCircleReportBean qCircleReportBean) {
            this.f91869h = qCircleReportBean;
            return this;
        }

        public b o(int i3) {
            this.f91870i = i3;
            return this;
        }

        public b p(QCircleTabInfo qCircleTabInfo) {
            this.f91862a = qCircleTabInfo;
            return this;
        }

        protected void q(FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq) {
            feedCloudRead$StGetFeedListReq.extInfo.setHasFlag(true);
            String o16 = QCirclePluginGlobalInfo.o();
            if (!TextUtils.isEmpty(o16)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry.key.set("highExposureForceInsertedFeed");
                feedCloudCommon$Entry.value.set(o16);
                feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(feedCloudCommon$Entry);
            }
            String A = QCirclePluginGlobalInfo.A();
            if (!TextUtils.isEmpty(A)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry2.key.set("forceInsertedFeedTransData");
                feedCloudCommon$Entry2.value.set(A);
                feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(feedCloudCommon$Entry2);
            }
        }
    }

    public QCircleTabGetFeedListRequest(b bVar) {
        this.mBuilder = bVar;
        this.mRequest = bVar.f();
        setTimeout(c.P4());
        this.mRequest.extInfo.mapInfo.add(k.f84627a.f());
        FeedCloudCommon$Entry e16 = com.tencent.biz.qqcircle.sensor.c.f92294a.e();
        if (e16 != null) {
            this.mRequest.extInfo.mapInfo.add(e16);
        }
        setMessageQueueHighProperty(y.a());
        addRequestInterceptor(new a());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return CMD_GET_FEED_LIST;
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
        b bVar = this.mBuilder;
        if (bVar != null && bVar.f91869h != null) {
            return this.mBuilder.f91869h.getDtPageId();
        }
        return super.getExt1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getInfo() {
        HashMap<String, String> hashMap;
        b bVar = this.mBuilder;
        if (bVar != null && bVar.f91868g != null) {
            hashMap = this.mBuilder.f91868g.getAttrs();
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
        return (String) com.tencent.biz.qqcircle.requests.a.d(this.mBuilder.f91862a).second;
    }

    public int getRealRequestSendCount() {
        return this.mRealRequestSendCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getRefer() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq;
        b bVar = this.mBuilder;
        if (bVar == null) {
            return super.getRefer();
        }
        if ((bVar.f91871j && ((feedCloudRead$StGetFeedListReq = this.mRequest) == null || TextUtils.isEmpty(feedCloudRead$StGetFeedListReq.feedAttchInfo.get()))) || !this.mBuilder.f91871j) {
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
        return this.mBuilder.g().toByteArray();
    }

    public int getRequestSource() {
        return this.mBuilder.f91862a.getSource();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) com.tencent.biz.qqcircle.requests.a.d(this.mBuilder.f91862a).first;
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

    public void setAttachInfo(String str) {
        this.mBuilder.f91863b = str;
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
