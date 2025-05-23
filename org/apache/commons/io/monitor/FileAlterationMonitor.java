package org.apache.commons.io.monitor;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FileAlterationMonitor implements Runnable {
    private final long interval;
    private final List<FileAlterationObserver> observers;
    private volatile boolean running;
    private Thread thread;
    private ThreadFactory threadFactory;

    public FileAlterationMonitor() {
        this(10000L);
    }

    public void addObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            this.observers.add(fileAlterationObserver);
        }
    }

    public long getInterval() {
        return this.interval;
    }

    public Iterable<FileAlterationObserver> getObservers() {
        return this.observers;
    }

    public void removeObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver == null) {
            return;
        }
        do {
        } while (this.observers.remove(fileAlterationObserver));
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.running) {
            Iterator<FileAlterationObserver> it = this.observers.iterator();
            while (it.hasNext()) {
                it.next().checkAndNotify();
            }
            if (this.running) {
                try {
                    LockMethodProxy.sleep(this.interval);
                } catch (InterruptedException unused) {
                }
            } else {
                return;
            }
        }
    }

    public synchronized void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public synchronized void start() throws Exception {
        if (!this.running) {
            Iterator<FileAlterationObserver> it = this.observers.iterator();
            while (it.hasNext()) {
                it.next().initialize();
            }
            this.running = true;
            ThreadFactory threadFactory = this.threadFactory;
            if (threadFactory != null) {
                this.thread = threadFactory.newThread(this);
            } else {
                this.thread = new BaseThread(this);
            }
            this.thread.start();
        } else {
            throw new IllegalStateException("Monitor is already running");
        }
    }

    public synchronized void stop() throws Exception {
        stop(this.interval);
    }

    public FileAlterationMonitor(long j3) {
        this.observers = new CopyOnWriteArrayList();
        this.thread = null;
        this.running = false;
        this.interval = j3;
    }

    public synchronized void stop(long j3) throws Exception {
        if (this.running) {
            this.running = false;
            try {
                this.thread.join(j3);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            Iterator<FileAlterationObserver> it = this.observers.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
        } else {
            throw new IllegalStateException("Monitor is not running");
        }
    }

    public FileAlterationMonitor(long j3, FileAlterationObserver... fileAlterationObserverArr) {
        this(j3);
        if (fileAlterationObserverArr != null) {
            for (FileAlterationObserver fileAlterationObserver : fileAlterationObserverArr) {
                addObserver(fileAlterationObserver);
            }
        }
    }
}
