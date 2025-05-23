package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.xaction.log.b;
import feedcloud.FeedCloudAigcsvr$QueryReq;
import feedcloud.FeedCloudAigcsvr$QueryRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/request/WinkMaliQueryRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMaliQueryRequest extends QCircleBaseRequest {

    @NotNull
    private final String taskId;

    public WinkMaliQueryRequest(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.taskId = taskId;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudAigcsvr$QueryRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new FeedCloudAigcsvr$QueryRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            b.c("WinkMaliQueryRequest", 1, "[decode] ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.aigcsvr.Aigcsvr.Query";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        FeedCloudAigcsvr$QueryReq feedCloudAigcsvr$QueryReq = new FeedCloudAigcsvr$QueryReq();
        feedCloudAigcsvr$QueryReq.task_id.set(this.taskId);
        byte[] byteArray = feedCloudAigcsvr$QueryReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "QueryReq().apply {\n     \u2026)\n        }.toByteArray()");
        return byteArray;
    }
}
