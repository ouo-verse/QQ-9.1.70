package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class NioClient {
    private static final String TAG = "NioClient";
    private static Runnable closeTask;
    private static Thread closeThread;
    private static Runnable registrationsTask;
    private static volatile boolean run;
    private static volatile Selector selector;
    private static Thread selectorThread;
    private static Runnable timeoutTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface KeyProcessor {
        void processReadyKey(SelectionKey selectionKey);
    }

    public static void close() {
        close(false);
    }

    private static void processReadyKeys() {
        Iterator<SelectionKey> it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            ((KeyProcessor) next.attachment()).processReadyKey(next);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runSelector() {
        int intValue = Integer.getInteger("dnsjava.nio.selector_timeout", 1000).intValue();
        if (intValue > 0 && intValue <= 1000) {
            while (run) {
                try {
                    if (selector.select(intValue) == 0) {
                        timeoutTask.run();
                    }
                    if (run) {
                        registrationsTask.run();
                        processReadyKeys();
                    }
                } catch (IOException e16) {
                    TVKLogUtil.d(TAG, "A selection operation failed, exception: " + e16);
                } catch (ClosedSelectorException unused) {
                }
            }
            TVKLogUtil.d(TAG, "dnsjava NIO selector thread stopped");
            return;
        }
        throw new IllegalArgumentException("Invalid selector_timeout, must be between 1 and 1000");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Selector selector() throws IOException {
        if (selector == null) {
            synchronized (NioClient.class) {
                if (selector == null) {
                    selector = Selector.open();
                    TVKLogUtil.d(TAG, "Starting dnsjava NIO selector thread");
                    run = true;
                    BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            NioClient.runSelector();
                        }
                    });
                    selectorThread = baseThread;
                    baseThread.setDaemon(true);
                    selectorThread.setName("dnsjava NIO selector");
                    selectorThread.start();
                    BaseThread baseThread2 = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            NioClient.close(true);
                        }
                    });
                    closeThread = baseThread2;
                    baseThread2.setName("dnsjava NIO shutdown hook");
                    try {
                        Runtime.getRuntime().addShutdownHook(closeThread);
                    } catch (Exception e16) {
                        TVKLogUtil.e(TAG, e16, "Failed to addShutdownHook");
                    }
                }
            }
        }
        return selector;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCloseTask(Runnable runnable) {
        closeTask = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setRegistrationsTask(Runnable runnable) {
        registrationsTask = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setTimeoutTask(Runnable runnable) {
        timeoutTask = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void close(boolean z16) {
        run = false;
        if (!z16) {
            try {
                Runtime.getRuntime().removeShutdownHook(closeThread);
            } catch (Exception unused) {
                TVKLogUtil.d(TAG, "Failed to remove shutdown hook, ignoring and continuing close");
            }
        }
        try {
            closeTask.run();
        } catch (Exception e16) {
            TVKLogUtil.d(TAG, "Failed to execute shutdown task, ignoring and continuing close, exception=" + e16);
        }
        selector.wakeup();
        try {
            selector.close();
        } catch (IOException e17) {
            TVKLogUtil.d(TAG, "Failed to properly close selector, ignoring and continuing close, exception=" + e17);
        }
        try {
            try {
                selectorThread.join();
                synchronized (NioClient.class) {
                    selector = null;
                    selectorThread = null;
                    closeThread = null;
                }
            } catch (Throwable th5) {
                synchronized (NioClient.class) {
                    selector = null;
                    selectorThread = null;
                    closeThread = null;
                    throw th5;
                }
            }
        } catch (InterruptedException unused2) {
            Thread.currentThread().interrupt();
            synchronized (NioClient.class) {
                selector = null;
                selectorThread = null;
                closeThread = null;
            }
        }
    }
}
