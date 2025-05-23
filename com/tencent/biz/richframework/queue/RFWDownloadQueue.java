package com.tencent.biz.richframework.queue;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadQueue implements Handler.Callback {
    private static volatile RFWDownloadQueue sQueueInstance;
    private final RFWDownloadQueueDispatcher mQueueDispatcher;
    private final Handler mQueueHandler;
    private final RFWDownloadStateProgressBox mStateProgressBox;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface QueryBizTaskStateCallback {
        void onTaskListRsp(List<RFWDownloadTaskStateData> list);
    }

    RFWDownloadQueue() {
        Handler createNewThreadHandler = RFWThreadManager.createNewThreadHandler("DQ-RFWDownloadQueue", 0, this);
        this.mQueueHandler = createNewThreadHandler;
        RFWDownloadStateProgressBox rFWDownloadStateProgressBox = new RFWDownloadStateProgressBox();
        this.mStateProgressBox = rFWDownloadStateProgressBox;
        this.mQueueDispatcher = new RFWDownloadQueueDispatcher(createNewThreadHandler, rFWDownloadStateProgressBox);
    }

    @NonNull
    private Handler getDownloadQueueHandler() {
        return this.mQueueHandler;
    }

    public static RFWDownloadQueue getInstance() {
        if (sQueueInstance == null) {
            synchronized (RFWDownloadQueue.class) {
                if (sQueueInstance == null) {
                    sQueueInstance = new RFWDownloadQueue();
                }
            }
        }
        return sQueueInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDownloadListener$0(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        this.mStateProgressBox.addDownloadListener(rFWDownloadQueueStrategy, rFWDownloadQueueResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTask$1(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
        this.mQueueDispatcher.addTask(rFWDownloadQueueStrategy, rFWDownloadQueueTaskInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelBizAllTask$8(RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        this.mQueueDispatcher.cancelBizAllTask(rFWDownloadQueueStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelTask$9(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        this.mQueueDispatcher.cancelTask(rFWDownloadQueueStrategy, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$continueTask$5(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        this.mQueueDispatcher.continueTask(rFWDownloadQueueStrategy, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pauseTask$3(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        this.mQueueDispatcher.pauseTask(rFWDownloadQueueStrategy, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryBizTaskStateList$6(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, QueryBizTaskStateCallback queryBizTaskStateCallback) {
        this.mQueueDispatcher.getBizTaskStateList(rFWDownloadQueueStrategy, queryBizTaskStateCallback);
    }

    private void triggerClearCurrentTask(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof RFWDownloadTask)) {
            return;
        }
        this.mQueueDispatcher.clearCurrentTask((RFWDownloadTask) obj);
    }

    private void triggerRunNextTask(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof RFWDownloadQueueStrategy)) {
            return;
        }
        this.mQueueDispatcher.triggerRunNextTask((RFWDownloadQueueStrategy) obj);
    }

    public void addDownloadListener(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$addDownloadListener$0(rFWDownloadQueueStrategy, rFWDownloadQueueResultListener);
            }
        });
    }

    public void addTask(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$addTask$1(rFWDownloadQueueStrategy, rFWDownloadQueueTaskInfo);
            }
        });
    }

    public void cancelBizAllTask(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.c
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$cancelBizAllTask$8(rFWDownloadQueueStrategy);
            }
        });
    }

    public void cancelTask(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final String str) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.f
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$cancelTask$9(rFWDownloadQueueStrategy, str);
            }
        });
    }

    public void continueTask(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final String str) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.e
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$continueTask$5(rFWDownloadQueueStrategy, str);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1001) {
            if (i3 != 1002) {
                return false;
            }
            triggerClearCurrentTask(message);
            return true;
        }
        triggerRunNextTask(message);
        return true;
    }

    public void pauseTask(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final String str) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.g
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$pauseTask$3(rFWDownloadQueueStrategy, str);
            }
        });
    }

    public void queryBizTaskStateList(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final QueryBizTaskStateCallback queryBizTaskStateCallback) {
        getDownloadQueueHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.queue.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueue.this.lambda$queryBizTaskStateList$6(rFWDownloadQueueStrategy, queryBizTaskStateCallback);
            }
        });
    }
}
