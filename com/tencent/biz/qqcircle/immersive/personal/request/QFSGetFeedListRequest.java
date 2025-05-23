package com.tencent.biz.qqcircle.immersive.personal.request;

import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StMainPageSortFeedListReq;
import qqcircle.QQCircleFeedBase$ViewedFeed;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetFeedListRequest extends QCircleBaseRequest implements com.tencent.biz.qqcircle.immersive.personal.request.a {
    private final FeedCloudRead$StGetFeedListReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(BaseRequest baseRequest) {
            com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            cq.f92752a.a(QFSGetFeedListRequest.this.mRequest.extInfo);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    public QFSGetFeedListRequest(FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq) {
        this.mRequest = feedCloudRead$StGetFeedListReq;
        setTimeout(c.P4());
        addRequestInterceptor(new a());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        int i3 = this.mRequest.source.get();
        if (i3 != 0 && i3 != 1) {
            if (i3 != 7 && i3 != 8 && i3 != 9) {
                if (i3 != 42) {
                    if (i3 != 57) {
                        return "";
                    }
                    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetViewHistoryFeedList";
                }
                return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListLike";
            }
            return QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        }
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpageSortFeedList";
    }

    public List<QQCircleFeedBase$ViewedFeed> getHistorySent() {
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        try {
            qQCircleFeedBase$StFeedListBusiReqData.mergeFrom(this.mRequest.busiReqData.get().toByteArray());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return qQCircleFeedBase$StFeedListBusiReqData.viewed_feed_data.feeds.get();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a(getCmd()).second;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.request.a
    public String getPreFeedId() {
        return this.mRequest.feed.f398449id.get();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a(getCmd()).first;
    }

    public int getSourceType() {
        int i3 = this.mRequest.source.get();
        if (i3 != 9) {
            if (i3 != 42) {
                if (i3 != 57) {
                    return 0;
                }
                return ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP;
            }
            return ErrorCode.ERROR_APPID_NOT_FOUND;
        }
        return ErrorCode.ERROR_VERIFY_FAILED;
    }

    public String getUin() {
        return this.mRequest.dstUserId.get();
    }

    public void setAttachInfo(String str) {
        this.mRequest.feedAttchInfo.set(str);
    }

    public void setRefreshAttachInfo(String str) {
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        if (!this.mRequest.busiReqData.has()) {
            qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        } else {
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(this.mRequest.busiReqData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
        qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.set(str);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiRspData.toByteArray()));
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudRead$StGetFeedListRsp decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends QCircleBaseRequest.a<QFSGetFeedListRequest> {

        /* renamed from: c, reason: collision with root package name */
        protected final FeedCloudRead$StGetFeedListReq f89002c;

        /* renamed from: d, reason: collision with root package name */
        protected final QQCircleFeedBase$StFeedListBusiReqData f89003d;

        public b() {
            this.f89002c = new FeedCloudRead$StGetFeedListReq();
            this.f89003d = new QQCircleFeedBase$StFeedListBusiReqData();
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetFeedListRequest b() {
            this.f89002c.busiReqData.set(ByteStringMicro.copyFrom(this.f89003d.toByteArray()));
            this.f89002c.listNum.set(30);
            return new QFSGetFeedListRequest(this.f89002c);
        }

        public b f(String str) {
            this.f89002c.feedAttchInfo.set(c(str));
            return this;
        }

        public b g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f89002c.feed.get().f398449id.set(feedCloudMeta$StFeed.f398449id.get());
            this.f89002c.feed.createTime.set(feedCloudMeta$StFeed.createTime.get());
            this.f89002c.feed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
            return this;
        }

        public b h(int i3) {
            this.f89002c.from.set(i3);
            return this;
        }

        public b i(String str) {
            this.f89003d.entrySchema.set(c(str));
            return this;
        }

        public b j(int i3) {
            QQCircleFeedBase$StMainPageSortFeedListReq qQCircleFeedBase$StMainPageSortFeedListReq = new QQCircleFeedBase$StMainPageSortFeedListReq();
            qQCircleFeedBase$StMainPageSortFeedListReq.sortField.set(i3);
            this.f89003d.mainPageSortFeedListReq.set(qQCircleFeedBase$StMainPageSortFeedListReq);
            return this;
        }

        public b k(int i3) {
            this.f89002c.source.set(i3);
            return this;
        }

        public b l(String str) {
            this.f89003d.tagName.set(str);
            return this;
        }

        public b m(List<QQCircleFeedBase$ViewedFeed> list) {
            if (list == null) {
                return this;
            }
            this.f89003d.viewed_feed_data.feeds.set(list);
            this.f89003d.viewed_feed_data.setHasFlag(true);
            return this;
        }

        public b(String str) {
            FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
            this.f89002c = feedCloudRead$StGetFeedListReq;
            this.f89003d = new QQCircleFeedBase$StFeedListBusiReqData();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(str);
            feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
            feedCloudRead$StGetFeedListReq.feed.set(feedCloudMeta$StFeed);
            if (str != null) {
                feedCloudRead$StGetFeedListReq.dstUserId.set(str);
            }
        }
    }
}
