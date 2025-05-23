package com.tencent.mobileqq.wink.templatelibrary.request;

import com.tencent.mobileqq.wink.request.WinkMsfBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudActivityLandingPage$GetActivityTopicListReq;
import feedcloud.FeedCloudActivityLandingPage$GetActivityTopicListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/request/WinkInspirationTopicRequest;", "Lcom/tencent/mobileqq/wink/request/WinkMsfBaseRequest;", "bizId", "", "limit", "offset", "(III)V", "req", "Lfeedcloud/FeedCloudActivityLandingPage$GetActivityTopicListReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkInspirationTopicRequest extends WinkMsfBaseRequest {

    @NotNull
    private final FeedCloudActivityLandingPage$GetActivityTopicListReq req;

    public WinkInspirationTopicRequest(int i3, int i16, int i17) {
        FeedCloudActivityLandingPage$GetActivityTopicListReq feedCloudActivityLandingPage$GetActivityTopicListReq = new FeedCloudActivityLandingPage$GetActivityTopicListReq();
        feedCloudActivityLandingPage$GetActivityTopicListReq.biz_id.set(i3);
        feedCloudActivityLandingPage$GetActivityTopicListReq.limit.set(i16);
        feedCloudActivityLandingPage$GetActivityTopicListReq.offset.set(i17);
        this.req = feedCloudActivityLandingPage$GetActivityTopicListReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudActivityLandingPage$GetActivityTopicListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new FeedCloudActivityLandingPage$GetActivityTopicListRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (Exception e16) {
            QLog.w("WinkInspirationTopicRequest", 1, "[decode]", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.activitylandingpage.ActivityLandingPageSvr.GetActivityTopicList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
