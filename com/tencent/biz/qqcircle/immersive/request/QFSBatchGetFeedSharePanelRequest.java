package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StBatchGetFeedSharePanelReq;
import feedcloud.FeedCloudRead$StBatchGetFeedSharePanelRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/QFSBatchGetFeedSharePanelRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudRead$StBatchGetFeedSharePanelReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudRead$StBatchGetFeedSharePanelReq;", "getRequest", "()Lfeedcloud/FeedCloudRead$StBatchGetFeedSharePanelReq;", "", "feedIds", "", "source", "shareStyleType", "<init>", "(Ljava/util/List;II)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSBatchGetFeedSharePanelRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudRead$StBatchGetFeedSharePanelReq request;

    public QFSBatchGetFeedSharePanelRequest(@NotNull List<String> feedIds, int i3, int i16) {
        Intrinsics.checkNotNullParameter(feedIds, "feedIds");
        FeedCloudRead$StBatchGetFeedSharePanelReq feedCloudRead$StBatchGetFeedSharePanelReq = new FeedCloudRead$StBatchGetFeedSharePanelReq();
        this.request = feedCloudRead$StBatchGetFeedSharePanelReq;
        feedCloudRead$StBatchGetFeedSharePanelReq.feed_id.set(feedIds);
        feedCloudRead$StBatchGetFeedSharePanelReq.source.set(i3);
        feedCloudRead$StBatchGetFeedSharePanelReq.shareStyleType.set(i16);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudRead$StBatchGetFeedSharePanelRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new FeedCloudRead$StBatchGetFeedSharePanelRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSBatchGetFeedSharePanelRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader_feeds.ComReaderFeeds.BatchGetFeedSharePanel";
    }

    @NotNull
    public final FeedCloudRead$StBatchGetFeedSharePanelReq getRequest() {
        return this.request;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
