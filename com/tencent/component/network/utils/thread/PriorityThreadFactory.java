package com.tencent.component.network.utils.thread;

import android.os.Process;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class PriorityThreadFactory implements ThreadFactory {
    public static final String FLAG_THREAD_NAME_SPLIT = " sub:";
    private final String mName;
    private final AtomicInteger mNumber = new AtomicInteger();
    private final int mPriority;

    public PriorityThreadFactory(String str, int i3) {
        this.mName = str;
        this.mPriority = i3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new BaseThread(runnable, this.mName + '-' + this.mNumber.getAndIncrement() + " sub:") { // from class: com.tencent.component.network.utils.thread.PriorityThreadFactory.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
                super.run();
            }
        };
    }
}
