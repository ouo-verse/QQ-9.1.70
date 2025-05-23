package com.tencent.mobileqq.mini.server.request;

import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr.MiniGameFloatBubbleSvrPB$CloseBubbleReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/MiniGameCloseFloatBubbleRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "appId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "(Ljava/lang/String;Ljava/lang/String;)V", "getCmd", "getRequestData", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCloseFloatBubbleRequest implements BaseMiniAppSSORequest {
    private final String appId;
    private final String taskId;

    public MiniGameCloseFloatBubbleRequest(String appId, String taskId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.appId = appId;
        this.taskId = taskId;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return "miniapp.trpc.minigame.float_bubble_svr.FloatBubbleSvr.CloseBubble";
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        MiniGameFloatBubbleSvrPB$CloseBubbleReq miniGameFloatBubbleSvrPB$CloseBubbleReq = new MiniGameFloatBubbleSvrPB$CloseBubbleReq();
        miniGameFloatBubbleSvrPB$CloseBubbleReq.appid.set(this.appId);
        miniGameFloatBubbleSvrPB$CloseBubbleReq.task_id.set(this.taskId);
        byte[] byteArray = miniGameFloatBubbleSvrPB$CloseBubbleReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
