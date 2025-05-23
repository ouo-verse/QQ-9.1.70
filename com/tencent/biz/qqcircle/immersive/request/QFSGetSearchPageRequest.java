package com.tencent.biz.qqcircle.immersive.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudRead$StGetSearchPageReq;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.util.ArrayList;
import java.util.List;
import org.light.LightVersionInfo;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* loaded from: classes4.dex */
public class QFSGetSearchPageRequest extends QFSSearchBaseRequest {
    private final FeedCloudRead$StGetSearchPageReq mRequest;

    QFSGetSearchPageRequest(FeedCloudRead$StGetSearchPageReq feedCloudRead$StGetSearchPageReq) {
        this.mRequest = feedCloudRead$StGetSearchPageReq;
        feedCloudRead$StGetSearchPageReq.adRequest.set(j.f90213a.l(new QQCircleFeedBase$StFeedListBusiReqData().entrySchema.get(), 47));
        bh.b(feedCloudRead$StGetSearchPageReq.extInfo.get(), "LightsdkVersion", d());
    }

    private String d() {
        if (TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            return LightVersionInfo.VERSION_NAME;
        }
        String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
        if (split.length <= 3) {
            return LightVersionInfo.VERSION_NAME;
        }
        return split[0] + "." + split[1] + "." + split[2];
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetSearchPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public String getSearchTypeReportData() {
        return cu.b(this.mRequest.searchType.get(), ",");
    }

    public String getWord() {
        return this.mRequest.word.get();
    }

    public void setAttachInfo(String str) {
        this.mRequest.attachInfo.set(str);
    }

    public void setWord(String str) {
        this.mRequest.word.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp = new FeedCloudRead$StGetSearchPageRsp();
        try {
            feedCloudRead$StGetSearchPageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetSearchPageRsp;
    }

    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSGetSearchPageRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudRead$StGetSearchPageReq f89836c;

        public a(String str) {
            str = str == null ? "" : str;
            FeedCloudRead$StGetSearchPageReq feedCloudRead$StGetSearchPageReq = new FeedCloudRead$StGetSearchPageReq();
            this.f89836c = feedCloudRead$StGetSearchPageReq;
            feedCloudRead$StGetSearchPageReq.searchReqScene.set(2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(3);
            feedCloudRead$StGetSearchPageReq.searchType.set(arrayList);
            feedCloudRead$StGetSearchPageReq.word.set(str);
        }

        public a e(List<FeedCloudCommon$Entry> list) {
            bh.c(this.f89836c.extInfo.get(), list);
            return this;
        }

        public a f(String str, String str2) {
            bh.b(this.f89836c.extInfo.get(), str, str2);
            return this;
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public QFSGetSearchPageRequest b() {
            QFSGetSearchPageRequest qFSGetSearchPageRequest = new QFSGetSearchPageRequest(this.f89836c);
            this.f91858a = qFSGetSearchPageRequest;
            return qFSGetSearchPageRequest;
        }

        public a h(String str) {
            if (str == null) {
                str = "";
            }
            this.f89836c.attachInfo.set(str);
            return this;
        }

        public a i(List<String> list) {
            if (list != null && !list.isEmpty()) {
                this.f89836c.filters.set(list);
            }
            return this;
        }

        public a j(int i3) {
            this.f89836c.searchReqScene.set(i3);
            return this;
        }

        public a k(List<Integer> list) {
            this.f89836c.searchType.set(list);
            return this;
        }

        public a l(String str) {
            if (str == null) {
                str = "";
            }
            this.f89836c.word.set(str);
            return this;
        }

        public a() {
            this.f89836c = new FeedCloudRead$StGetSearchPageReq();
        }
    }
}
