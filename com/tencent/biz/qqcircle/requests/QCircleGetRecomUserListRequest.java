package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.helpers.k;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import feedcloud.FeedCloudRead$StGetRecomUserListReq;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase$StGetRecomUserListBusiReqData;
import qqcircle.QQCircleFeedBase$StUserRecomInfoBusiData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetRecomUserListRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetRecomUserListReq mRequest;

    public QCircleGetRecomUserListRequest(String str, int i3, String str2) {
        this(str, i3, str2, 0);
    }

    public static void setMapInfo(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, String str) {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("trigger_id");
        feedCloudCommon$Entry.value.set("1");
        FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry2.key.set("pymk_author_uin");
        feedCloudCommon$Entry2.value.set(str);
        feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry);
        feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry2);
        feedCloudCommon$StCommonExt.setHasFlag(true);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRecomUserList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public QCircleGetRecomUserListRequest(String str, int i3, String str2, int i16) {
        FeedCloudRead$StGetRecomUserListReq feedCloudRead$StGetRecomUserListReq = new FeedCloudRead$StGetRecomUserListReq();
        this.mRequest = feedCloudRead$StGetRecomUserListReq;
        if (str != null) {
            feedCloudRead$StGetRecomUserListReq.attachInfo.set(str);
        }
        QQCircleFeedBase$StGetRecomUserListBusiReqData qQCircleFeedBase$StGetRecomUserListBusiReqData = new QQCircleFeedBase$StGetRecomUserListBusiReqData();
        if (str2 != null) {
            qQCircleFeedBase$StGetRecomUserListBusiReqData.desUserID.set(str2);
            setMapInfo(this.mRequest.extInfo, str2);
            if (i3 == 2 || i3 == 5 || i3 == 1) {
                this.mRequest.extInfo.mapInfo.add(k.f84627a.f());
            }
        }
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StGetRecomUserListBusiReqData.get().toByteArray()));
        this.mRequest.listType.set(i3);
        this.mRequest.sceneID.set(i16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp = new FeedCloudRead$StGetRecomUserListRsp();
        try {
            feedCloudRead$StGetRecomUserListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        List<FeedCloudMeta$StUserRecomInfo> list = feedCloudRead$StGetRecomUserListRsp.userRecoms.get();
        if (!list.isEmpty()) {
            boolean z16 = false;
            for (FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo : list) {
                QQCircleFeedBase$StUserRecomInfoBusiData qQCircleFeedBase$StUserRecomInfoBusiData = new QQCircleFeedBase$StUserRecomInfoBusiData();
                try {
                    qQCircleFeedBase$StUserRecomInfoBusiData.mergeFrom(feedCloudMeta$StUserRecomInfo.busiData.get().toByteArray());
                    if (qQCircleFeedBase$StUserRecomInfoBusiData.recomSource.get() == 1 && !z16) {
                        z16 = true;
                    } else if (qQCircleFeedBase$StUserRecomInfoBusiData.recomSource.get() == 1 && z16) {
                        qQCircleFeedBase$StUserRecomInfoBusiData.recomSource.set(0);
                        feedCloudMeta$StUserRecomInfo.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StUserRecomInfoBusiData.get().toByteArray()));
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                }
            }
        }
        return feedCloudRead$StGetRecomUserListRsp;
    }
}
