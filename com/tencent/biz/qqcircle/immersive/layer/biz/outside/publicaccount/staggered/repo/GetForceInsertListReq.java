package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/GetForceInsertListReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getCmdName", "", "getRequestByteData", "T", "rspData", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", "", "source", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "action", "<init>", "(ILfeedcloud/FeedCloudMeta$StFeed;I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
final class GetForceInsertListReq extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudRead$StGetFeedListReq request;

    public GetForceInsertListReq(int i3, @NotNull FeedCloudMeta$StFeed feed, int i16) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        JSONObject a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.a(feed);
        JSONObject put = (a16 == null ? new JSONObject() : a16).put("user_action", i16).put("source", i3);
        FeedCloudMeta$StFeed simpleFeed = QCirclePluginUtil.getSimpleFeed(feed);
        PBRepeatMessageField<FeedCloudCommon$BytesEntry> pBRepeatMessageField = simpleFeed.busiTranparent;
        Intrinsics.checkNotNullExpressionValue(pBRepeatMessageField, "newFeed.busiTranparent");
        String jSONObject = put.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "clientSealDataJson.toString()");
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        PbExtKt.c(pBRepeatMessageField, "FeedbackData", bytes);
        feedCloudRead$StGetFeedListReq.from.set(0);
        feedCloudRead$StGetFeedListReq.source.set(i3);
        feedCloudRead$StGetFeedListReq.feed.set(simpleFeed);
        this.request = feedCloudRead$StGetFeedListReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudRead$StGetFeedListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] rspData) {
        ?? r06 = (T) new FeedCloudRead$StGetFeedListRsp();
        try {
            r06.mergeFrom(rspData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GetForceInsertListReq", 1, "decode error, e=" + e16.getMessage(), e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetOfficialAccountRerankedFeedList";
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
