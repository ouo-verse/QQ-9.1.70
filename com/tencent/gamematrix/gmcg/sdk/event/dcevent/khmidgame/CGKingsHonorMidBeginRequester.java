package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.event.CGDcEventHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGKingsHonorMidBeginRequester {
    private final ResultListener mResultListener;
    private CGHandlerTimer.TimerTask mSendBeginRequestTask;
    private int mRetryTimes = 0;
    private final CGHandlerTimer mHandlerTimer = new CGHandlerTimer();
    private final List<CGDcEventKingsHonorMidBeginRequest> mBeginReqQueue = new ArrayList(7);

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onKingsHonorMidGameBeginTimeout();
    }

    public CGKingsHonorMidBeginRequester(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    public int getRetryTimes() {
        return this.mRetryTimes;
    }

    @Nullable
    public Integer receiveBeginRequestAck(CGKingsHonorMidAckMessage cGKingsHonorMidAckMessage) {
        int size = this.mBeginReqQueue.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (cGKingsHonorMidAckMessage.ack == this.mBeginReqQueue.get(i3).seq) {
                this.mHandlerTimer.cancel(this.mSendBeginRequestTask);
                this.mRetryTimes = i3;
                this.mBeginReqQueue.clear();
                CGLog.w(CGStringUtil.format("\u6b8b\u5c40\u5f00\u59cb\u6d88\u606f\u91cd\u8bd5%d\u6b21", Integer.valueOf(this.mRetryTimes)));
                return Integer.valueOf(this.mRetryTimes);
            }
        }
        return null;
    }

    public void sendBeginRequest(final CGDcEventHelper cGDcEventHelper, final CGKingsHonorMidGameConfig cGKingsHonorMidGameConfig) {
        if (this.mSendBeginRequestTask == null) {
            this.mSendBeginRequestTask = new CGHandlerTimer.TimerTask() { // from class: com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidBeginRequester.1
                @Override // com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer.TimerTask
                public void doRun() {
                    if (CGKingsHonorMidBeginRequester.this.mBeginReqQueue.size() > 7) {
                        if (CGKingsHonorMidBeginRequester.this.mResultListener != null) {
                            CGKingsHonorMidBeginRequester.this.mResultListener.onKingsHonorMidGameBeginTimeout();
                            return;
                        }
                        CGKingsHonorMidBeginRequester.this.mBeginReqQueue.clear();
                    }
                    CGLog.i(CGStringUtil.format("\u7b2c%d\u6b21\u53d1\u9001\u6b8b\u5c40\u5f00\u59cb\u6d88\u606f", Integer.valueOf(CGKingsHonorMidBeginRequester.this.mBeginReqQueue.size() + 1)));
                    cGKingsHonorMidGameConfig.retryTimes = CGKingsHonorMidBeginRequester.this.mBeginReqQueue.size();
                    CGDcEventKingsHonorMidBeginRequest cGDcEventKingsHonorMidBeginRequest = new CGDcEventKingsHonorMidBeginRequest(cGKingsHonorMidGameConfig);
                    cGDcEventHelper.sendDcEventRequest(cGDcEventKingsHonorMidBeginRequest);
                    CGKingsHonorMidBeginRequester.this.mBeginReqQueue.add(cGDcEventKingsHonorMidBeginRequest);
                    CGKingsHonorMidBeginRequester.this.sendBeginRequest(500L);
                }
            };
        }
        sendBeginRequest(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBeginRequest(long j3) {
        this.mHandlerTimer.schedule(this.mSendBeginRequestTask, j3, TimeUnit.MILLISECONDS);
    }
}
