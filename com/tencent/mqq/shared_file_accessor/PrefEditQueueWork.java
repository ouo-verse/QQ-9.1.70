package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class PrefEditQueueWork {
    private static final int MSG_RUN = 0;
    private final Object mLock;
    private final Object mProcessingLock;
    private final Handler mWorkHandler;
    private final HandlerThread mWorkThread;
    private final LinkedList<Runnable> mWorks;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static final class Holder {
        static final PrefEditQueueWork INSTANCE = new PrefEditQueueWork();

        Holder() {
        }
    }

    /* loaded from: classes21.dex */
    private final class WorkHandler extends Handler {
        WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                PrefEditQueueWork.this.processPendingWork();
            }
        }
    }

    public static PrefEditQueueWork getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingWork() {
        LinkedList linkedList;
        synchronized (this.mProcessingLock) {
            synchronized (this.mLock) {
                linkedList = new LinkedList(this.mWorks);
                this.mWorks.clear();
                this.mWorkHandler.removeMessages(0);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    public void queue(Runnable runnable) {
        synchronized (this.mLock) {
            if (!this.mWorks.contains(runnable)) {
                this.mWorks.add(runnable);
            }
            this.mWorkHandler.sendEmptyMessage(0);
        }
    }

    PrefEditQueueWork() {
        this.mWorks = new LinkedList<>();
        this.mLock = new Object();
        this.mProcessingLock = new Object();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("pref-queue-work-thread", -2);
        this.mWorkThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mWorkHandler = new WorkHandler(baseHandlerThread.getLooper());
    }
}
