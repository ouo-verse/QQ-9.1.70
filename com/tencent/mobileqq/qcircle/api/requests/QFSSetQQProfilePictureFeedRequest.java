package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$SetQQProfilePictureFeedReq;
import feedcloud.FeedCloudDatacard$SetQQProfilePictureFeedRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/requests/QFSSetQQProfilePictureFeedRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudDatacard$SetQQProfilePictureFeedReq;", "(Lfeedcloud/FeedCloudDatacard$SetQQProfilePictureFeedReq;)V", "getRequest", "()Lfeedcloud/FeedCloudDatacard$SetQQProfilePictureFeedReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "Companion", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSSetQQProfilePictureFeedRequest extends QCircleBaseRequest {

    @NotNull
    private static final String TAG = "QFSSetQQProfilePictureFeedRequest";

    @NotNull
    private final FeedCloudDatacard$SetQQProfilePictureFeedReq request;

    public QFSSetQQProfilePictureFeedRequest(@NotNull FeedCloudDatacard$SetQQProfilePictureFeedReq request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [feedcloud.FeedCloudDatacard$SetQQProfilePictureFeedRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new MessageMicro<FeedCloudDatacard$SetQQProfilePictureFeedRsp>() { // from class: feedcloud.FeedCloudDatacard$SetQQProfilePictureFeedRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudDatacard$SetQQProfilePictureFeedRsp.class);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.datacard.DataCard.SetPFPFeed";
    }

    @NotNull
    public final FeedCloudDatacard$SetQQProfilePictureFeedReq getRequest() {
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
