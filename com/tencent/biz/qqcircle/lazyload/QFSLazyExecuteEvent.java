package com.tencent.biz.qqcircle.lazyload;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLazyExecuteEvent extends SimpleBaseEvent {
    long mDelayExecuteTime;
    boolean mInMainThread;
    int mNotifyId;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void execute();
    }

    public QFSLazyExecuteEvent(int i3, long j3, boolean z16) {
        this.mNotifyId = i3;
        this.mDelayExecuteTime = j3;
        this.mInMainThread = z16;
    }

    private void b(@NonNull final a aVar) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.1
            @Override // java.lang.Runnable
            public void run() {
                aVar.execute();
                QLog.d("QFSLazyExecuteEvent", 1, "executeInMain,type:", Integer.valueOf(QFSLazyExecuteEvent.this.mNotifyId));
            }
        }, this.mDelayExecuteTime);
    }

    private void e(@NonNull final a aVar) {
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.2
            @Override // java.lang.Runnable
            public void run() {
                aVar.execute();
                QLog.d("QFSLazyExecuteEvent", 1, "executeOnBackground,type:", Integer.valueOf(QFSLazyExecuteEvent.this.mNotifyId));
            }
        }, this.mDelayExecuteTime);
    }

    public int getNotifyId() {
        return this.mNotifyId;
    }

    public void injectExecution(a aVar) {
        if (aVar == null) {
            QLog.e("QFSLazyExecuteEvent", 1, "execute failed,no callback!type:", Integer.valueOf(this.mNotifyId), ",delayTime:", Long.valueOf(this.mDelayExecuteTime));
        } else if (this.mInMainThread) {
            b(aVar);
        } else {
            e(aVar);
        }
    }
}
