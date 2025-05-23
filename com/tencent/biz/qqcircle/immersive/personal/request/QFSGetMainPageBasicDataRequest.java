package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import feedcloud.FeedCloudRead$StGetMainPageReq;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StMainPageBusiReqData;

/* loaded from: classes4.dex */
public class QFSGetMainPageBasicDataRequest extends QCircleBaseRequest implements com.tencent.biz.qqcircle.immersive.personal.request.a {
    public static final String NEED_TC_RED_DOT = "need_tc_red_dot";
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
            cq.f92752a.a(QFSGetMainPageBasicDataRequest.this.mRequest.extInfo);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends QCircleBaseRequest.a<QFSGetMainPageBasicDataRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudRead$StGetMainPageReq f89005c;

        /* renamed from: d, reason: collision with root package name */
        private final QQCircleFeedBase$StMainPageBusiReqData f89006d;

        /* renamed from: e, reason: collision with root package name */
        private String f89007e;

        public b(String str) {
            FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq = new FeedCloudRead$StGetMainPageReq();
            this.f89005c = feedCloudRead$StGetMainPageReq;
            this.f89006d = new QQCircleFeedBase$StMainPageBusiReqData();
            feedCloudRead$StGetMainPageReq.userId.set(c(str));
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetMainPageBasicDataRequest b() {
            this.f89005c.busiReqData.set(ByteStringMicro.copyFrom(this.f89006d.toByteArray()));
            QFSGetMainPageBasicDataRequest qFSGetMainPageBasicDataRequest = new QFSGetMainPageBasicDataRequest(this.f89005c);
            this.f91858a = qFSGetMainPageBasicDataRequest;
            qFSGetMainPageBasicDataRequest.e(this.f89005c.userId.get());
            ((QFSGetMainPageBasicDataRequest) this.f91858a).d(this.f89007e);
            return (QFSGetMainPageBasicDataRequest) this.f91858a;
        }

        public b f(int i3) {
            this.f89005c.clientFrom.set(i3);
            return this;
        }

        public b g(HashMap<String, String> hashMap) {
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
            if (hashMap != null && (feedCloudCommon$StCommonExt = this.f89005c.extInfo) != null) {
                if (!feedCloudCommon$StCommonExt.has()) {
                    this.f89005c.extInfo.setHasFlag(true);
                }
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    bh.a(this.f89005c.extInfo.mapInfo, key, value);
                    if (QLog.isColorLevel()) {
                        QLog.i("QFSGetMainPageBasicDataRequest", 2, "setExtInfo key:" + key + ", value" + value);
                    }
                }
            }
            return this;
        }

        public b h(int i3) {
            this.f89005c.from.set(i3);
            return this;
        }

        public b i(String str) {
            bh.a(this.f89005c.extInfo.mapInfo, "feeid", str);
            this.f89007e = str;
            return this;
        }
    }

    QFSGetMainPageBasicDataRequest(FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq) {
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
        return "QFSGetMainPageBasicDataRequest";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageBasicData";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageBasicData").second;
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
        return (String) com.tencent.biz.qqcircle.requests.a.a("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageBasicData").first;
    }

    public String getUin() {
        return this.uin;
    }

    public void setAttachInfo(String str) {
        this.mRequest.feedAttchInfo.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp = new FeedCloudRead$StGetMainPageBasicDataRsp();
        try {
            feedCloudRead$StGetMainPageBasicDataRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i("QFSGetMainPageBasicDataRequest", 2, "decode responseData");
        }
        return feedCloudRead$StGetMainPageBasicDataRsp;
    }
}
