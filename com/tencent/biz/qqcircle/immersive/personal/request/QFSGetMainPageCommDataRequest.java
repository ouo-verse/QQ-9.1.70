package com.tencent.biz.qqcircle.immersive.personal.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import feedcloud.FeedCloudRead$StGetMainPageReq;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import qqcircle.QQCircleFeedBase$StMainPageBusiReqData;

/* loaded from: classes4.dex */
public class QFSGetMainPageCommDataRequest extends QCircleBaseRequest implements com.tencent.biz.qqcircle.immersive.personal.request.a {
    private final FeedCloudRead$StGetMainPageReq mRequest;
    private String preFeedId;
    private String uin;

    /* loaded from: classes4.dex */
    class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(BaseRequest baseRequest) {
            com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            cq.f92752a.a(QFSGetMainPageCommDataRequest.this.mRequest.extInfo);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends QCircleBaseRequest.a<QFSGetMainPageCommDataRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudRead$StGetMainPageReq f89009c;

        /* renamed from: d, reason: collision with root package name */
        private final QQCircleFeedBase$StMainPageBusiReqData f89010d;

        /* renamed from: e, reason: collision with root package name */
        private String f89011e;

        public b(String str) {
            FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq = new FeedCloudRead$StGetMainPageReq();
            this.f89009c = feedCloudRead$StGetMainPageReq;
            this.f89010d = new QQCircleFeedBase$StMainPageBusiReqData();
            feedCloudRead$StGetMainPageReq.userId.set(c(str));
        }

        public b e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            if (feedCloudMeta$StFeed != null) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed2.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
                feedCloudMeta$StFeed2.poster.setHasFlag(true);
                feedCloudMeta$StFeed2.poster.f398463id.set(feedCloudMeta$StFeed.poster.f398463id.get());
                feedCloudMeta$StFeed2.createTime.set(feedCloudMeta$StFeed.createTime.get());
                feedCloudMeta$StFeed2.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
                this.f89010d.filter_feeds.add(feedCloudMeta$StFeed2);
            }
            return this;
        }

        public b f(Collection<FeedCloudMeta$StFeed> collection) {
            if (collection != null && !collection.isEmpty()) {
                Iterator<FeedCloudMeta$StFeed> it = collection.iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
            }
            return this;
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public QFSGetMainPageCommDataRequest b() {
            this.f89009c.busiReqData.set(ByteStringMicro.copyFrom(this.f89010d.toByteArray()));
            QFSGetMainPageCommDataRequest qFSGetMainPageCommDataRequest = new QFSGetMainPageCommDataRequest(this.f89009c);
            this.f91858a = qFSGetMainPageCommDataRequest;
            qFSGetMainPageCommDataRequest.e(this.f89009c.userId.get());
            ((QFSGetMainPageCommDataRequest) this.f91858a).d(this.f89011e);
            return (QFSGetMainPageCommDataRequest) this.f91858a;
        }

        public b h(String str) {
            this.f89009c.feedAttchInfo.set(c(str));
            return this;
        }

        public b i(int i3) {
            this.f89009c.draftBoxNum.set(i3);
            return this;
        }

        public b j(int i3) {
            this.f89009c.feed_list_type.set(i3);
            return this;
        }

        public b k(int i3) {
            this.f89009c.from.set(i3);
            return this;
        }

        public b l(int i3, String str, String str2, long j3) {
            String format = String.format(Locale.getDefault(), "uin=%s&feedid=%s&createtime=%d", str, str2, Long.valueOf(j3));
            this.f89010d.reqType.set(i3);
            this.f89010d.entrySchema.set(format);
            this.f89011e = str2;
            return this;
        }
    }

    QFSGetMainPageCommDataRequest(FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq) {
        this.mRequest = feedCloudRead$StGetMainPageReq;
        addRequestInterceptor(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.preFeedId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        this.uin = str;
    }

    public static String getTAG() {
        return "QFSGetMainPageCommDataRequest";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData").second;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.request.a
    public String getPreFeedId() {
        return this.preFeedId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData").first;
    }

    public String getUin() {
        return this.uin;
    }

    public boolean isLoadMore() {
        return !TextUtils.isEmpty(this.mRequest.feedAttchInfo.get());
    }

    public boolean isPrivateProdsReq() {
        FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq = this.mRequest;
        if (feedCloudRead$StGetMainPageReq == null || feedCloudRead$StGetMainPageReq.feed_list_type.get() != 2) {
            return false;
        }
        return true;
    }

    public void setAttachInfo(String str) {
        this.mRequest.feedAttchInfo.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp = new FeedCloudRead$StGetMainPageCommDataRsp();
        try {
            feedCloudRead$StGetMainPageCommDataRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetMainPageCommDataRsp;
    }
}
