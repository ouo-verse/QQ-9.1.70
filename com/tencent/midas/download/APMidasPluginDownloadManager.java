package com.tencent.midas.download;

import android.content.Context;
import com.tencent.midas.comm.APLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public class APMidasPluginDownloadManager {
    private static final int MAX_CURRENCY_DOWNLOAD_THREAD = 1;
    private static final String TAG = "APMidasPluginDownloadManager";
    private ExecutorService executorService = getExecutorService();

    APMidasPluginDownloadManager() {
    }

    private synchronized void enqueue(APMidasPluginDownloadWorker aPMidasPluginDownloadWorker) {
        if (aPMidasPluginDownloadWorker == null) {
            APLog.e(TAG, "Cannot enqueue null worker!");
        } else {
            this.executorService.execute(aPMidasPluginDownloadWorker);
        }
    }

    private ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = ProxyExecutors.newFixedThreadPool(1, threadFactory("Plugin Download Thread", false));
        }
        return this.executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startDownload(Context context, ArrayList<APMidasPluginDownInfo> arrayList, IAPMidasPluginDownListener iAPMidasPluginDownListener) {
        new APMidasPluginDownloadManager().enqueue(new APMidasPluginDownloadWorker(context, arrayList, context.getApplicationContext().getDir("midaspluginsTemp", 0), iAPMidasPluginDownListener));
    }

    private static ThreadFactory threadFactory(final String str, final boolean z16) {
        return new ThreadFactory() { // from class: com.tencent.midas.download.APMidasPluginDownloadManager.1
            private AtomicInteger netThreadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                BaseThread baseThread = new BaseThread(runnable, str + " " + this.netThreadCount.getAndIncrement());
                baseThread.setPriority(10);
                baseThread.setDaemon(z16);
                return baseThread;
            }
        };
    }
}
