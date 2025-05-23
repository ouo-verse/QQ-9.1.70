package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudWrite$StDoBrowseReportReq;
import feedcloud.FeedCloudWrite$StDoBrowseReportRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoBrowseReportRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$StDoBrowseReportReq mRequest;

    public QCircleDoBrowseReportRequest(int i3, List<String> list) {
        this(i3, list, 0, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoBrowseReport";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    public QCircleDoBrowseReportRequest(int i3, List<String> list, int i16, ByteStringMicro byteStringMicro) {
        FeedCloudWrite$StDoBrowseReportReq feedCloudWrite$StDoBrowseReportReq = new FeedCloudWrite$StDoBrowseReportReq();
        this.mRequest = feedCloudWrite$StDoBrowseReportReq;
        feedCloudWrite$StDoBrowseReportReq.vv_count.set(i3);
        feedCloudWrite$StDoBrowseReportReq.source.set(i16);
        if (list != null) {
            feedCloudWrite$StDoBrowseReportReq.feed_ids.addAll(list);
        }
        if (byteStringMicro != null) {
            feedCloudWrite$StDoBrowseReportReq.trans_info.set(byteStringMicro);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudWrite$StDoBrowseReportRsp, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$StDoBrowseReportRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudWrite$StDoBrowseReportRsp>() { // from class: feedcloud.FeedCloudWrite$StDoBrowseReportRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bubble_text", "jump_url"}, new Object[]{"", ""}, FeedCloudWrite$StDoBrowseReportRsp.class);
            public final PBStringField bubble_text = PBField.initString("");
            public final PBStringField jump_url = PBField.initString("");
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
