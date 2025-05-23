package com.tencent.mobileqq.wink.templatelibrary.meme.request;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudSeedsvr$SEAGICancelReq;
import feedcloud.FeedCloudSeedsvr$SEAGICancelRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/meme/request/WinkMemeCancelTaskRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "type", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "(ILjava/lang/String;)V", "req", "Lfeedcloud/FeedCloudSeedsvr$SEAGICancelReq;", "getTaskId", "()Ljava/lang/String;", "getType", "()I", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkMemeCancelTaskRequest extends VSBaseRequest {

    @NotNull
    private final FeedCloudSeedsvr$SEAGICancelReq req;

    @NotNull
    private final String taskId;
    private final int type;

    public WinkMemeCancelTaskRequest(int i3, @NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.type = i3;
        this.taskId = taskId;
        FeedCloudSeedsvr$SEAGICancelReq feedCloudSeedsvr$SEAGICancelReq = new FeedCloudSeedsvr$SEAGICancelReq();
        feedCloudSeedsvr$SEAGICancelReq.taskType.set(i3);
        feedCloudSeedsvr$SEAGICancelReq.taskID.set(taskId);
        this.req = feedCloudSeedsvr$SEAGICancelReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudSeedsvr$SEAGICancelRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new MessageMicro<FeedCloudSeedsvr$SEAGICancelRsp>() { // from class: feedcloud.FeedCloudSeedsvr$SEAGICancelRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudSeedsvr$SEAGICancelRsp.class);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (Exception e16) {
            QLog.w("WinkMemeQueryRequest", 1, "[decode]", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.seedsvr.Seedsvr.AGICancel";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    public final int getType() {
        return this.type;
    }
}
