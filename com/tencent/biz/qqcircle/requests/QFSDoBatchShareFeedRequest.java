package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite$ShareTarget;
import feedcloud.FeedCloudWrite$StDoBatchShareFeedReq;
import feedcloud.FeedCloudWrite$StDoBatchShareFeedRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSDoBatchShareFeedRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "feedId", "", "shareTargets", "", "Lfeedcloud/FeedCloudWrite$ShareTarget;", "leaveMsg", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudWrite$StDoBatchShareFeedReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QFSDoBatchShareFeedRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudWrite$StDoBatchShareFeedReq request;

    public QFSDoBatchShareFeedRequest(@NotNull String feedId, @NotNull List<FeedCloudWrite$ShareTarget> shareTargets, @NotNull String leaveMsg) {
        boolean z16;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(shareTargets, "shareTargets");
        Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
        FeedCloudWrite$StDoBatchShareFeedReq feedCloudWrite$StDoBatchShareFeedReq = new FeedCloudWrite$StDoBatchShareFeedReq();
        this.request = feedCloudWrite$StDoBatchShareFeedReq;
        feedCloudWrite$StDoBatchShareFeedReq.feedID.set(feedId);
        feedCloudWrite$StDoBatchShareFeedReq.targets.set(shareTargets);
        if (leaveMsg.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            feedCloudWrite$StDoBatchShareFeedReq.text.set(leaveMsg);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudWrite$StDoBatchShareFeedRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new FeedCloudWrite$StDoBatchShareFeedRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSDoBatchShareFeedRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoBatchShareFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
