package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StModifyDownLoadSwitchReq;
import feedcloud.FeedCloudWrite$StModifyDownLoadSwitchRsp;

/* loaded from: classes4.dex */
public class QFSSettingDownloadPermissionRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StModifyDownLoadSwitchReq mRequest;

    public QFSSettingDownloadPermissionRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudWrite$StModifyDownLoadSwitchReq feedCloudWrite$StModifyDownLoadSwitchReq = new FeedCloudWrite$StModifyDownLoadSwitchReq();
        this.mRequest = feedCloudWrite$StModifyDownLoadSwitchReq;
        feedCloudWrite$StModifyDownLoadSwitchReq.feedID.set(feedCloudMeta$StFeed.f398449id.get());
        this.mRequest.posterID.set(feedCloudMeta$StFeed.poster.f398463id.get());
        this.mRequest.createTime.set(feedCloudMeta$StFeed.createTime.get());
        this.mRequest.downLoadOper.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.ModifyDownLoadSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudWrite$StModifyDownLoadSwitchRsp, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$StModifyDownLoadSwitchRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudWrite$StModifyDownLoadSwitchRsp>() { // from class: feedcloud.FeedCloudWrite$StModifyDownLoadSwitchRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isSuccess"}, new Object[]{Boolean.FALSE}, FeedCloudWrite$StModifyDownLoadSwitchRsp.class);
            public final PBBoolField isSuccess = PBField.initBool(false);
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
