package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$GetFeedAdviceReq;
import feedcloud.FeedCloudRead$GetFeedAdviceRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J!\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/QFSGetFeedAdviceReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "userId", "Ljava/lang/String;", "currentFeedId", "", WadlProxyConsts.CREATE_TIME, "J", "Lfeedcloud/FeedCloudRead$GetFeedAdviceReq;", "req", "Lfeedcloud/FeedCloudRead$GetFeedAdviceReq;", "getReq", "()Lfeedcloud/FeedCloudRead$GetFeedAdviceReq;", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGetFeedAdviceReq extends QCircleBaseRequest {

    @NotNull
    public static final String TAG = "QFSGetFeedAdviceReq";
    private final long createTime;

    @NotNull
    private final String currentFeedId;

    @NotNull
    private final FeedCloudRead$GetFeedAdviceReq req;

    @NotNull
    private final String userId;

    public QFSGetFeedAdviceReq() {
        this(null, null, 0L, 7, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] responseData) {
        try {
            T t16 = (T) new FeedCloudRead$GetFeedAdviceRsp().mergeFrom(responseData);
            if (t16 == null) {
                return null;
            }
            return t16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "decode, error", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.mainpage_profile_reader.MainpageProfileReader.GetFeedAdvice";
    }

    @NotNull
    public final FeedCloudRead$GetFeedAdviceReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    public /* synthetic */ QFSGetFeedAdviceReq(String str, String str2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : j3);
    }

    public QFSGetFeedAdviceReq(@NotNull String userId, @NotNull String currentFeedId, long j3) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(currentFeedId, "currentFeedId");
        this.userId = userId;
        this.currentFeedId = currentFeedId;
        this.createTime = j3;
        FeedCloudRead$GetFeedAdviceReq feedCloudRead$GetFeedAdviceReq = new FeedCloudRead$GetFeedAdviceReq();
        feedCloudRead$GetFeedAdviceReq.user_id.set(userId);
        feedCloudRead$GetFeedAdviceReq.feed_id.set(currentFeedId);
        feedCloudRead$GetFeedAdviceReq.create_time.set(j3);
        this.req = feedCloudRead$GetFeedAdviceReq;
    }
}
