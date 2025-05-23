package com.tencent.biz.richframework.network.cache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.biz.richframework.network.util.Encrypt;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class Cache {
    protected static ArrayList<String[]> jobs = new ArrayList<>();
    protected static int threadCount = 0;

    public abstract boolean cacheExists(String str);

    public abstract void clear();

    public abstract String get(String str);

    public String getCacheName(String str) {
        return Encrypt.md5(str);
    }

    public abstract CacheInputStream getStream(String str);

    public void lazySet(String str, String str2) {
        jobs.add(new String[]{str, str2});
        new BaseThread(new Runnable() { // from class: com.tencent.biz.richframework.network.cache.Cache.1
            @Override // java.lang.Runnable
            public void run() {
                Cache.this.runJob();
            }
        }).start();
    }

    public abstract void remove(String str);

    protected synchronized void runJob() {
        int i3 = threadCount;
        if (i3 >= 1) {
            return;
        }
        threadCount = i3 + 1;
        while (jobs.size() > 0) {
            String[] remove = jobs.remove(0);
            set(remove[0], remove[1]);
            try {
                LockMethodProxy.sleep(100L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        threadCount--;
    }

    public abstract boolean set(String str, String str2);

    public abstract boolean setStream(String str, InputStream inputStream);

    public abstract long size();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class CacheInputStream {
        private InputStream mInputStream;
        private DiskLruCache.Snapshot mSnapshot;

        public CacheInputStream() {
            this.mInputStream = null;
            this.mSnapshot = null;
        }

        public void close() {
            InputStream inputStream = this.mInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            DiskLruCache.Snapshot snapshot = this.mSnapshot;
            if (snapshot != null) {
                snapshot.close();
            }
        }

        public FileDescriptor getFileDescriptor() {
            InputStream inputStream = this.mInputStream;
            if (inputStream != null) {
                try {
                    return ((FileInputStream) inputStream).getFD();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            return null;
        }

        public InputStream getInputStream() {
            return this.mInputStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.mInputStream = inputStream;
        }

        public void setSnapshot(DiskLruCache.Snapshot snapshot) {
            this.mSnapshot = snapshot;
        }

        public CacheInputStream(DiskLruCache.Snapshot snapshot, InputStream inputStream) {
            this.mSnapshot = snapshot;
            this.mInputStream = inputStream;
        }
    }

    public void interrupt(String str) {
    }
}
