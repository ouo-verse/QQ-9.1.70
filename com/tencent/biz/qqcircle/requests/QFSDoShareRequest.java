package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudWrite$ShareItem;
import feedcloud.FeedCloudWrite$StDoShareReq;
import feedcloud.FeedCloudWrite$StDoShareRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSDoShareRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$StDoShareReq mRequest;

    public QFSDoShareRequest(List<FeedCloudWrite$ShareItem> list, String str) {
        FeedCloudWrite$StDoShareReq feedCloudWrite$StDoShareReq = new FeedCloudWrite$StDoShareReq();
        this.mRequest = feedCloudWrite$StDoShareReq;
        feedCloudWrite$StDoShareReq.items.addAll(list);
        feedCloudWrite$StDoShareReq.feedID.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoShare";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudWrite$StDoShareRsp> messageMicro = new MessageMicro<FeedCloudWrite$StDoShareRsp>() { // from class: feedcloud.FeedCloudWrite$StDoShareRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudWrite$StDoShareRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
