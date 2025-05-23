package com.tencent.biz.qqcircle.immersive.personal.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleProfile$GetQQGroupsReq;
import qqcircle.QQCircleProfile$GetQQGroupsRsp;
import qqcircle.QQCircleProfile$SimpleFeed;

/* loaded from: classes4.dex */
public class QFSPersonalQQGroupRequest extends QCircleBaseRequest {
    private QQCircleProfile$GetQQGroupsReq mRequest;

    public QFSPersonalQQGroupRequest(String str, boolean z16, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSPersonalQQGroupRequest", 1, "[QFSPersonalQQGroupRequest] hostUin is null");
            return;
        }
        QQCircleProfile$GetQQGroupsReq qQCircleProfile$GetQQGroupsReq = new QQCircleProfile$GetQQGroupsReq();
        this.mRequest = qQCircleProfile$GetQQGroupsReq;
        qQCircleProfile$GetQQGroupsReq.uid.set(str);
        if (i3 == 2 && feedCloudMeta$StFeed != null) {
            QQCircleProfile$SimpleFeed qQCircleProfile$SimpleFeed = new QQCircleProfile$SimpleFeed();
            qQCircleProfile$SimpleFeed.uid.set(feedCloudMeta$StFeed.poster.f398463id.get());
            qQCircleProfile$SimpleFeed.feed_id.set(feedCloudMeta$StFeed.f398449id.get());
            qQCircleProfile$SimpleFeed.create_time.set(feedCloudMeta$StFeed.createTime.get());
            this.mRequest.feed.set(qQCircleProfile$SimpleFeed);
        }
        this.mRequest.source.set(i3);
        this.mRequest.is_pull_allow_bind.set(z16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.GetQQGroups";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleProfile$GetQQGroupsRsp qQCircleProfile$GetQQGroupsRsp = new QQCircleProfile$GetQQGroupsRsp();
        try {
            qQCircleProfile$GetQQGroupsRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleProfile$GetQQGroupsRsp;
    }
}
