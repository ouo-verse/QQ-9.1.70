package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$SetFeedAdviceReq;
import feedcloud.FeedCloudRead$SetFeedAdviceRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J!\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/QFSSetFeedAdviceReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "adviceId", "getAdviceId", "", "userful", "I", "getUserful", "()I", "Lfeedcloud/FeedCloudRead$SetFeedAdviceReq;", "req", "Lfeedcloud/FeedCloudRead$SetFeedAdviceReq;", "getReq", "()Lfeedcloud/FeedCloudRead$SetFeedAdviceReq;", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSetFeedAdviceReq extends QCircleBaseRequest {

    @NotNull
    public static final String TAG = "QFSSetFeedAdviceReq";

    @NotNull
    private final String adviceId;

    @NotNull
    private final FeedCloudRead$SetFeedAdviceReq req;

    @NotNull
    private final String userId;
    private final int userful;

    public QFSSetFeedAdviceReq() {
        this(null, null, 0, 7, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] responseData) {
        try {
            T t16 = (T) new MessageMicro<FeedCloudRead$SetFeedAdviceRsp>() { // from class: feedcloud.FeedCloudRead$SetFeedAdviceRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudRead$SetFeedAdviceRsp.class);
            }.mergeFrom(responseData);
            if (t16 == null) {
                return null;
            }
            return t16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "decode, error", e16);
            return null;
        }
    }

    @NotNull
    public final String getAdviceId() {
        return this.adviceId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.mainpage_profile_reader.MainpageProfileReader.SetFeedAdvice";
    }

    @NotNull
    public final FeedCloudRead$SetFeedAdviceReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final int getUserful() {
        return this.userful;
    }

    public /* synthetic */ QFSSetFeedAdviceReq(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3);
    }

    public QFSSetFeedAdviceReq(@NotNull String userId, @NotNull String adviceId, int i3) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(adviceId, "adviceId");
        this.userId = userId;
        this.adviceId = adviceId;
        this.userful = i3;
        FeedCloudRead$SetFeedAdviceReq feedCloudRead$SetFeedAdviceReq = new FeedCloudRead$SetFeedAdviceReq();
        feedCloudRead$SetFeedAdviceReq.user_id.set(userId);
        feedCloudRead$SetFeedAdviceReq.advice_id.set(adviceId);
        feedCloudRead$SetFeedAdviceReq.userful.set(i3);
        this.req = feedCloudRead$SetFeedAdviceReq;
    }
}
