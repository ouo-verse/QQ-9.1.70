package org.apache.commons.io;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileCleaningTracker {
    Thread reaper;

    /* renamed from: q, reason: collision with root package name */
    ReferenceQueue<Object> f423531q = new ReferenceQueue<>();
    final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet());
    final List<String> deleteFailures = Collections.synchronizedList(new ArrayList());
    volatile boolean exitWhenFinished = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class Reaper extends BaseThread {
        Reaper() {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (FileCleaningTracker.this.exitWhenFinished && FileCleaningTracker.this.trackers.size() <= 0) {
                    return;
                }
                try {
                    Tracker tracker = (Tracker) FileCleaningTracker.this.f423531q.remove();
                    FileCleaningTracker.this.trackers.remove(tracker);
                    if (!tracker.delete()) {
                        FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
                    }
                    tracker.clear();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Tracker extends PhantomReference<Object> {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        Tracker(String str, FileDeleteStrategy fileDeleteStrategy, Object obj, ReferenceQueue<? super Object> referenceQueue) {
            super(obj, referenceQueue);
            this.path = str;
            this.deleteStrategy = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }

        public String getPath() {
            return this.path;
        }
    }

    private synchronized void addTracker(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (!this.exitWhenFinished) {
            if (this.reaper == null) {
                Reaper reaper = new Reaper();
                this.reaper = reaper;
                reaper.start();
            }
            this.trackers.add(new Tracker(str, fileDeleteStrategy, obj, this.f423531q));
        } else {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
    }

    public synchronized void exitWhenFinished() {
        this.exitWhenFinished = true;
        Thread thread = this.reaper;
        if (thread != null) {
            synchronized (thread) {
                this.reaper.interrupt();
            }
        }
    }

    public List<String> getDeleteFailures() {
        return this.deleteFailures;
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public void track(File file, Object obj) {
        track(file, obj, (FileDeleteStrategy) null);
    }

    public void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (file != null) {
            addTracker(file.getPath(), obj, fileDeleteStrategy);
            return;
        }
        throw new NullPointerException("The file must not be null");
    }

    public void track(String str, Object obj) {
        track(str, obj, (FileDeleteStrategy) null);
    }

    public void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (str != null) {
            addTracker(str, obj, fileDeleteStrategy);
            return;
        }
        throw new NullPointerException("The path must not be null");
    }
}
