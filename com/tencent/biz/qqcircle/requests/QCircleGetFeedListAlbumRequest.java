package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudRead$LoadMoreFeedInfo;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetFeedListAlbumRequest extends QCircleBaseRequest {
    private final int mListNum = 10;
    public FeedCloudRead$StGetFeedListReq mRequest = new FeedCloudRead$StGetFeedListReq();

    public QCircleGetFeedListAlbumRequest(QCircleAlbumBean qCircleAlbumBean, String str, int i3) {
        if (qCircleAlbumBean != null && qCircleAlbumBean.getFeedAlbumInfo() != null) {
            if (i3 == 2) {
                this.mRequest.feed.set(QCirclePluginUtil.getSimpleFeed(qCircleAlbumBean.getFeed()));
                this.mRequest.feed.busiTranparent.set(qCircleAlbumBean.getFeed().busiTranparent.get());
            } else if (i3 == 0) {
                this.mRequest.feedAttchInfo.set(str);
                FeedCloudRead$LoadMoreFeedInfo feedCloudRead$LoadMoreFeedInfo = new FeedCloudRead$LoadMoreFeedInfo();
                feedCloudRead$LoadMoreFeedInfo.load_more_type.set(0);
                this.mRequest.load_more_info.set(feedCloudRead$LoadMoreFeedInfo);
            } else if (i3 == 1) {
                FeedCloudRead$LoadMoreFeedInfo feedCloudRead$LoadMoreFeedInfo2 = new FeedCloudRead$LoadMoreFeedInfo();
                feedCloudRead$LoadMoreFeedInfo2.load_more_type.set(1);
                feedCloudRead$LoadMoreFeedInfo2.page_up_attach_info.set(str);
                this.mRequest.load_more_info.set(feedCloudRead$LoadMoreFeedInfo2);
            }
            this.mRequest.source.set(52);
            this.mRequest.listNum.set(10);
            QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qCircleAlbumBean.getFeedListBusiReq();
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = new FeedCloudMeta$FeedAlbum();
            feedCloudMeta$FeedAlbum.f398441id.set(qCircleAlbumBean.getFeedAlbumInfo().mAlbumId);
            feedListBusiReq.album_info.set(feedCloudMeta$FeedAlbum);
            this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListAlbum";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        try {
            return this.mRequest.toByteArray();
        } catch (Throwable th5) {
            QLog.e("QCircleGetAlbumFeedListRequest", 1, "[getRequestByteData] ex: ", th5);
            return new byte[0];
        }
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
