package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.immersive.personal.publishguide.NegFeedbackType;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudPubGuideSvr$NegativeFeedbackReq;
import feedcloud.FeedCloudPubGuideSvr$NegativeFeedbackRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J!\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/request/QFSPublishGuideBannerNegativeFeedbackReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/NegFeedbackType;", "negFeedbackType", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/NegFeedbackType;", "bannerId", "Ljava/lang/String;", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/NegFeedbackType;Ljava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublishGuideBannerNegativeFeedbackReq extends QCircleBaseRequest {

    @Nullable
    private final String bannerId;

    @NotNull
    private final NegFeedbackType negFeedbackType;

    public /* synthetic */ QFSPublishGuideBannerNegativeFeedbackReq(NegFeedbackType negFeedbackType, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(negFeedbackType, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] responseData) {
        try {
            T t16 = (T) new MessageMicro<FeedCloudPubGuideSvr$NegativeFeedbackRsp>() { // from class: feedcloud.FeedCloudPubGuideSvr$NegativeFeedbackRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudPubGuideSvr$NegativeFeedbackRsp.class);
            }.mergeFrom(responseData);
            if (t16 == null) {
                return null;
            }
            return t16;
        } catch (Exception e16) {
            QLog.e("QFSPublishGuideBannerNegativeFeedbackReq", 1, "decode, error", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.pub_guide_svr.PubGuideSvr.NegativeFeedback";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        FeedCloudPubGuideSvr$NegativeFeedbackReq feedCloudPubGuideSvr$NegativeFeedbackReq = new FeedCloudPubGuideSvr$NegativeFeedbackReq();
        feedCloudPubGuideSvr$NegativeFeedbackReq.feedback_type.set(this.negFeedbackType.getCode());
        feedCloudPubGuideSvr$NegativeFeedbackReq.type.set(1);
        if (this.negFeedbackType == NegFeedbackType.SINGLE_CLOSE) {
            feedCloudPubGuideSvr$NegativeFeedbackReq.f398468id.set(this.bannerId);
        }
        byte[] byteArray = feedCloudPubGuideSvr$NegativeFeedbackReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "NegativeFeedbackReq()\n  \u2026           .toByteArray()");
        return byteArray;
    }

    public QFSPublishGuideBannerNegativeFeedbackReq(@NotNull NegFeedbackType negFeedbackType, @Nullable String str) {
        Intrinsics.checkNotNullParameter(negFeedbackType, "negFeedbackType");
        this.negFeedbackType = negFeedbackType;
        this.bannerId = str;
    }
}
