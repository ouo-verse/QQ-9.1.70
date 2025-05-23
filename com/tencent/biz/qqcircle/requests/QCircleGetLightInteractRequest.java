package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetLightInteractListReq;
import feedcloud.FeedCloudRead$StGetLightInteractListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetLightInteractRequest extends QCircleBaseRequest {
    private FeedCloudRead$StGetLightInteractListReq req;

    public QCircleGetLightInteractRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, String str2) {
        this(feedCloudMeta$StFeed, str, i3, str2, -1L, 1, new ArrayList());
    }

    private void a(FeedCloudRead$StGetLightInteractListReq feedCloudRead$StGetLightInteractListReq, List<FeedCloudCommon$Entry> list) {
        if (list != null && !list.isEmpty()) {
            if (!feedCloudRead$StGetLightInteractListReq.extInfo.has()) {
                feedCloudRead$StGetLightInteractListReq.extInfo.set(new FeedCloudCommon$StCommonExt());
            }
            feedCloudRead$StGetLightInteractListReq.extInfo.mapInfo.addAll(list);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetLightInteractList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    public QCircleGetLightInteractRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, String str2, long j3, int i16, List<FeedCloudCommon$BytesEntry> list) {
        this(feedCloudMeta$StFeed, str, i3, str2, j3, i16, list, new ArrayList());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp = new FeedCloudRead$StGetLightInteractListRsp();
        try {
            feedCloudRead$StGetLightInteractListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetLightInteractListRsp;
    }

    public QCircleGetLightInteractRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, String str2, long j3, int i16, List<FeedCloudCommon$BytesEntry> list, List<FeedCloudCommon$Entry> list2) {
        FeedCloudRead$StGetLightInteractListReq feedCloudRead$StGetLightInteractListReq = new FeedCloudRead$StGetLightInteractListReq();
        this.req = feedCloudRead$StGetLightInteractListReq;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (i3 == 1) {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            this.req.f398471id.set(qQCircleFeedBase$StFeedBusiReqData.pushList.f398457id.get());
        } else if (i3 == 6 || i3 == 7 || i3 == 19 || i3 == 20) {
            if (TextUtils.isEmpty(str2)) {
                this.req.f398471id.set(feedCloudMeta$StFeed.likeInfo.f398454id.get());
            } else {
                this.req.f398471id.set(str2);
            }
            i3 = i3 == 19 ? 6 : i3 == 20 ? 7 : 2;
        } else if (i3 == 17) {
            feedCloudRead$StGetLightInteractListReq.busiTranparent.set(list);
            i3 = 5;
        } else if (i3 == 31) {
            feedCloudRead$StGetLightInteractListReq.busiTranparent.set(list);
            i3 = 9;
        } else if (i3 == 23) {
            feedCloudRead$StGetLightInteractListReq.busiTranparent.set(list);
            i3 = 8;
        } else {
            feedCloudRead$StGetLightInteractListReq.f398471id.set(feedCloudMeta$StFeed.likeInfo.f398454id.get());
        }
        this.req.feedID.set(feedCloudMeta$StFeed.f398449id.get());
        this.req.hostID.set(feedCloudMeta$StFeed.poster.f398463id.get());
        this.req.type.set(i3);
        if (j3 != -1) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("last_like_time");
            feedCloudCommon$Entry.value.set(String.valueOf(j3));
            this.req.extInfo.mapInfo.add(feedCloudCommon$Entry);
        }
        a(this.req, list2);
        if (str != null) {
            this.req.attachInfo.set(str);
        }
        this.req.source.set(i16);
    }
}
