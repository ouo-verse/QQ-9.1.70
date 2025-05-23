package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QFSGalleryMainPageBean;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGalleryMixFeedListRequest extends QCircleBaseRequest {
    private final int mListNum = 10;
    public FeedCloudRead$StGetFeedListReq mRequest;

    public QFSGalleryMixFeedListRequest(QFSGalleryMainPageBean qFSGalleryMainPageBean, String str, String str2) {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        this.mRequest = feedCloudRead$StGetFeedListReq;
        if (qFSGalleryMainPageBean == null) {
            return;
        }
        if (str != null) {
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str);
        }
        this.mRequest.source.set(76);
        this.mRequest.listNum.set(10);
        this.mRequest.subSource.set(qFSGalleryMainPageBean.getSource());
        this.mRequest.from.set(10);
        QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qFSGalleryMainPageBean.getFeedListBusiReq();
        feedListBusiReq.entrySchema.set(qFSGalleryMainPageBean.getScheme());
        if (!TextUtils.isEmpty(str2)) {
            feedListBusiReq.refreshAttachInfo.set(str2);
        }
        this.mRequest.adres.set(j.f90213a.l(feedListBusiReq.entrySchema.get(), 76));
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
        setTimeout(c.P4());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader_feeds.ComReaderFeeds.GetGalleryFeeds";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getRequestKey() {
        if (!TextUtils.isEmpty(super.getRequestKey())) {
            return super.getRequestKey();
        }
        return getCmd() + VSNetworkHelper.getInstance().getNetworkImpl().getAccountId() + VSNetworkHelper.getInstance().getNetworkImpl().getQUA() + Arrays.toString(getRequestByteKey());
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
