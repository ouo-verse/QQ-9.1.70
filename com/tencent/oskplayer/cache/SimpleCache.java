package com.tencent.oskplayer.cache;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SimpleCache implements Cache {
    private static final String LOG_TAG = "SimpleCache";
    private final File cacheDir;
    private final CacheEvictor evictor;
    private long totalSpace;
    private final HashMap<String, CacheSpan> lockedSpans = new HashMap<>();
    private final HashMap<String, TreeSet<CacheSpan>> cachedSpans = new HashMap<>();
    private final HashMap<String, ArrayList<Cache.Listener>> listeners = new HashMap<>();

    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new BaseThread() { // from class: com.tencent.oskplayer.cache.SimpleCache.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.initialize();
                }
            }
        }.start();
        conditionVariable.block();
    }

    private boolean addSpan(CacheSpan cacheSpan) {
        TreeSet<CacheSpan> treeSet = this.cachedSpans.get(cacheSpan.key);
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            this.cachedSpans.put(cacheSpan.key, treeSet);
        }
        boolean add = treeSet.add(cacheSpan);
        this.totalSpace += cacheSpan.length;
        notifySpanAdded(cacheSpan);
        return add;
    }

    private void deleteDir(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteDir(file2);
            }
            file2.delete();
        }
    }

    private CacheSpan getSpan(CacheSpan cacheSpan) {
        String str = cacheSpan.key;
        long j3 = cacheSpan.position;
        TreeSet<CacheSpan> treeSet = this.cachedSpans.get(str);
        if (treeSet == null) {
            return CacheSpan.createOpenHole(str, cacheSpan.position);
        }
        CacheSpan floor = treeSet.floor(cacheSpan);
        if (floor != null) {
            long j16 = floor.position;
            if (j16 <= j3 && j3 < j16 + floor.length) {
                if (floor.file.exists()) {
                    return floor;
                }
                removeStaleSpans();
                return getSpan(cacheSpan);
            }
        }
        CacheSpan ceiling = treeSet.ceiling(cacheSpan);
        if (ceiling == null) {
            return CacheSpan.createOpenHole(str, cacheSpan.position);
        }
        long j17 = cacheSpan.position;
        return CacheSpan.createClosedHole(str, j17, ceiling.position - j17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
        }
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.length() == 0) {
                file.delete();
            } else {
                CacheSpan createCacheEntry = CacheSpan.createCacheEntry(file);
                if (createCacheEntry == null) {
                    file.delete();
                } else if (!addSpan(createCacheEntry)) {
                    PlayerUtils.log(3, LOG_TAG, "remove duplicated span " + createCacheEntry.file);
                    removeSpan(createCacheEntry);
                }
            }
        }
    }

    private void notifySpanAdded(CacheSpan cacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanAdded(this, cacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, cacheSpan);
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanTouched(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanTouched(this, cacheSpan, cacheSpan2);
            }
        }
        this.evictor.onSpanTouched(this, cacheSpan, cacheSpan2);
    }

    private void removeStaleSpans() {
        Iterator<Map.Entry<String, TreeSet<CacheSpan>>> it = this.cachedSpans.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<CacheSpan> it5 = it.next().getValue().iterator();
            boolean z16 = true;
            while (it5.hasNext()) {
                CacheSpan next = it5.next();
                if (!next.file.exists()) {
                    it5.remove();
                    if (next.isCached) {
                        this.totalSpace -= next.length;
                    }
                    notifySpanRemoved(next);
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                it.remove();
            }
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.listeners.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void commitFile(File file) {
        boolean z16;
        CacheSpan createCacheEntry = CacheSpan.createCacheEntry(file);
        if (createCacheEntry != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        Assertions.checkState(this.lockedSpans.containsKey(createCacheEntry.key));
        if (!file.exists()) {
            return;
        }
        if (file.length() == 0) {
            file.delete();
        } else {
            addSpan(createCacheEntry);
            notifyAll();
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void evictOneSpan() {
        CacheEvictor cacheEvictor = this.evictor;
        if (cacheEvictor != null) {
            cacheEvictor.evictOne(this);
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized long getCacheSpace() {
        return this.totalSpace;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public long getCachedBytesFromEnd(String str) {
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        long j3 = 0;
        if (cachedSpans != null) {
            CacheSpan last = cachedSpans.last();
            if (last != null && last.isCached) {
                long j16 = last.totalLength;
                if (j16 >= 0 && last.position + last.length < j16) {
                    return 0L;
                }
            }
            if (last != null && last.totalLength >= 0) {
                for (CacheSpan cacheSpan : cachedSpans.descendingSet()) {
                    if (!cacheSpan.isCached) {
                        return j3;
                    }
                    j3 += cacheSpan.length;
                }
            }
        }
        return j3;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized long getCachedBytesFromStart(String str) {
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        long j3 = 0;
        if (cachedSpans != null) {
            CacheSpan first = cachedSpans.first();
            if (first != null && first.isCached && first.totalLength >= 0 && first.position != 0) {
                return 0L;
            }
            if (first != null && first.totalLength >= 0) {
                for (CacheSpan cacheSpan : cachedSpans) {
                    if (!cacheSpan.isCached) {
                        return j3;
                    }
                    j3 += cacheSpan.length;
                }
            }
        }
        return j3;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized double getCachedSizeRate(String str) {
        double d16;
        CacheSpan first;
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        if (cachedSpans != null && (first = cachedSpans.first()) != null) {
            long j3 = first.totalLength;
            long j16 = 0;
            if (j3 > 0) {
                for (CacheSpan cacheSpan : cachedSpans) {
                    if (!cacheSpan.isCached) {
                        return j16;
                    }
                    j16 += cacheSpan.length;
                }
                d16 = j16 / j3;
                return d16;
            }
        }
        d16 = 0.0d;
        return d16;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        TreeSet treeSet;
        TreeSet<CacheSpan> treeSet2 = this.cachedSpans.get(str);
        if (treeSet2 == null) {
            treeSet = null;
        } else {
            treeSet = new TreeSet((SortedSet) treeSet2);
        }
        return treeSet;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized FileType getContentType(String str) {
        CacheSpan first;
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        if (cachedSpans != null && (first = cachedSpans.first()) != null && first.totalLength >= 0) {
            return first.fileType;
        }
        return FileType.UNKNOWN;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized Set<String> getKeys() {
        return new HashSet(this.cachedSpans.keySet());
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized long getRemainUnCachedBytes(String str) {
        long j3;
        CacheSpan first;
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        if (cachedSpans != null && (first = cachedSpans.first()) != null) {
            long j16 = first.totalLength;
            long j17 = 0;
            if (j16 > 0) {
                for (CacheSpan cacheSpan : cachedSpans) {
                    if (!cacheSpan.isCached) {
                        return j17;
                    }
                    j17 += cacheSpan.length;
                }
                j3 = j16 - j17;
                return j3;
            }
        }
        j3 = -1;
        return j3;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized long getTotalLength(String str) {
        CacheSpan first;
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        if (cachedSpans != null && (first = cachedSpans.first()) != null) {
            long j3 = first.totalLength;
            if (j3 >= 0) {
                return j3;
            }
        }
        return -1L;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized boolean isCached(String str, long j3, long j16) {
        TreeSet<CacheSpan> treeSet = this.cachedSpans.get(str);
        if (treeSet == null) {
            return false;
        }
        CacheSpan floor = treeSet.floor(CacheSpan.createLookup(str, j3));
        if (floor != null) {
            long j17 = floor.position;
            long j18 = floor.length;
            if (j17 + j18 > j3) {
                long j19 = j3 + j16;
                long j26 = j17 + j18;
                if (j26 >= j19) {
                    return true;
                }
                for (CacheSpan cacheSpan : treeSet.tailSet(floor, false)) {
                    long j27 = cacheSpan.position;
                    if (j27 > j26) {
                        return false;
                    }
                    j26 = Math.max(j26, j27 + cacheSpan.length);
                    if (j26 >= j19) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        boolean z16;
        if (cacheSpan == this.lockedSpans.remove(cacheSpan.key)) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        notifyAll();
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void removeAll() {
        Iterator<Map.Entry<String, TreeSet<CacheSpan>>> it = this.cachedSpans.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<CacheSpan> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                CacheSpan next = it5.next();
                it5.remove();
                if (next.isCached) {
                    this.totalSpace -= next.length;
                }
                notifySpanRemoved(next);
            }
            it.remove();
        }
        deleteDir(this.cacheDir);
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void removeByKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        if (cachedSpans == null) {
            return;
        }
        Iterator<CacheSpan> it = cachedSpans.iterator();
        while (it.hasNext()) {
            removeSpan(it.next());
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void removeListener(String str, Cache.Listener listener) {
        ArrayList<Cache.Listener> arrayList = this.listeners.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty()) {
                this.listeners.remove(str);
            }
        }
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized void removeSpan(CacheSpan cacheSpan) {
        TreeSet<CacheSpan> treeSet = this.cachedSpans.get(cacheSpan.key);
        this.totalSpace -= cacheSpan.length;
        cacheSpan.file.delete();
        if (treeSet == null || treeSet.isEmpty()) {
            this.cachedSpans.remove(cacheSpan.key);
        }
        notifySpanRemoved(cacheSpan);
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized File startFile(String str, long j3, long j16, FileType fileType, long j17) {
        Assertions.checkState(this.lockedSpans.containsKey(str));
        if (!this.cacheDir.exists()) {
            removeStaleSpans();
            this.cacheDir.mkdirs();
        }
        this.evictor.onStartFile(this, str, j3, j17);
        return CacheSpan.getCacheFileName(this.cacheDir, str, j3, j16, fileType, System.currentTimeMillis());
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized CacheSpan startReadWrite(String str, long j3) throws InterruptedException {
        CacheSpan startReadWriteNonBlocking;
        CacheSpan createLookup = CacheSpan.createLookup(str, j3);
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(createLookup);
            if (startReadWriteNonBlocking == null) {
                LockMethodProxy.wait(this);
            }
        }
        return startReadWriteNonBlocking;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized CacheSpan startReadWriteNonBlocking(String str, long j3) {
        return startReadWriteNonBlocking(CacheSpan.createLookup(str, j3));
    }

    private synchronized CacheSpan startReadWriteNonBlocking(CacheSpan cacheSpan) {
        CacheSpan span = getSpan(cacheSpan);
        if (span.isCached) {
            return span;
        }
        if (this.lockedSpans.containsKey(cacheSpan.key)) {
            return null;
        }
        this.lockedSpans.put(cacheSpan.key, span);
        return span;
    }

    @Override // com.tencent.oskplayer.cache.Cache
    public synchronized boolean isCached(String str) {
        CacheSpan first;
        NavigableSet<CacheSpan> cachedSpans = getCachedSpans(str);
        if (cachedSpans != null && (first = cachedSpans.first()) != null) {
            long j3 = first.totalLength;
            long j16 = 0;
            if (j3 >= 0) {
                for (CacheSpan cacheSpan : cachedSpans) {
                    if (!cacheSpan.isCached) {
                        return false;
                    }
                    j16 += cacheSpan.length;
                }
                if (j16 >= j3) {
                    return true;
                }
            }
        }
        return false;
    }
}
