package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoThanksReq;
import feedcloud.FeedCloudWrite$StDoThanksRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dBE\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSDoThanksRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "", "thank", "Z", "Lfeedcloud/FeedCloudWrite$StDoThanksReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudWrite$StDoThanksReq;", "getRequest", "()Lfeedcloud/FeedCloudWrite$StDoThanksReq;", "", "thanksType", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "userId", "likeId", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "<init>", "(ZILfeedcloud/FeedCloudMeta$StFeed;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSDoThanksRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudWrite$StDoThanksReq request;
    private final boolean thank;

    public QFSDoThanksRequest(boolean z16, int i3, @NotNull FeedCloudMeta$StFeed feed, @NotNull String userId, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.thank = z16;
        FeedCloudWrite$StDoThanksReq feedCloudWrite$StDoThanksReq = new FeedCloudWrite$StDoThanksReq();
        this.request = feedCloudWrite$StDoThanksReq;
        feedCloudWrite$StDoThanksReq.thanksType.set(i3);
        feedCloudWrite$StDoThanksReq.feed.setHasFlag(true);
        feedCloudWrite$StDoThanksReq.feed.f398449id.set(feed.f398449id.get());
        feedCloudWrite$StDoThanksReq.feed.poster.setHasFlag(true);
        feedCloudWrite$StDoThanksReq.feed.poster.f398463id.set(feed.poster.f398463id.get());
        feedCloudWrite$StDoThanksReq.feed.createTime.set(feed.createTime.get());
        feedCloudWrite$StDoThanksReq.like.setHasFlag(true);
        feedCloudWrite$StDoThanksReq.like.f398454id.set(str == null ? "" : str);
        feedCloudWrite$StDoThanksReq.like.postUser.setHasFlag(true);
        feedCloudWrite$StDoThanksReq.like.postUser.f398463id.set(userId);
        if (str2 != null) {
            feedCloudWrite$StDoThanksReq.comment.setHasFlag(true);
            feedCloudWrite$StDoThanksReq.comment.f398447id.set(str2);
        }
        if (str3 != null) {
            feedCloudWrite$StDoThanksReq.reply.setHasFlag(true);
            feedCloudWrite$StDoThanksReq.reply.f398460id.set(str3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [feedcloud.FeedCloudWrite$StDoThanksRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new MessageMicro<FeedCloudWrite$StDoThanksRsp>() { // from class: feedcloud.FeedCloudWrite$StDoThanksRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "like", "busiRspData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudWrite$StDoThanksRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public FeedCloudMeta$StLike like = new FeedCloudMeta$StLike();
            public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSDoThanksRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        if (this.thank) {
            return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoThanks";
        }
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.UnDoThanks";
    }

    @NotNull
    public final FeedCloudWrite$StDoThanksReq getRequest() {
        return this.request;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
