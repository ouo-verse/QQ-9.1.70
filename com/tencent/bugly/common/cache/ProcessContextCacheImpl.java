package com.tencent.bugly.common.cache;

import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class ProcessContextCacheImpl implements IProcessContextCache {
    private static final long STORE_INTERVAL = 500;
    private final IProcessContextUpdater updater;
    private final AtomicBoolean isWaitingToStore = new AtomicBoolean(false);
    private ConcurrentHashMap<String, String> cache = null;

    public ProcessContextCacheImpl(IProcessContextUpdater iProcessContextUpdater) {
        this.updater = iProcessContextUpdater;
    }

    private void store(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.cache == null) {
            synchronized (this.isWaitingToStore) {
                if (this.cache == null) {
                    this.cache = new ConcurrentHashMap<>();
                }
            }
        }
        if (str2 != null) {
            this.cache.put(str, str2);
        } else {
            this.cache.put(str, "");
        }
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void apply() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.cache;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty() && this.isWaitingToStore.compareAndSet(false, true)) {
            ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.bugly.common.cache.ProcessContextCacheImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ProcessContextCacheImpl.this.commit();
                    ProcessContextCacheImpl.this.isWaitingToStore.set(false);
                }
            }, 500L);
        }
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void commit() {
        boolean z16;
        ConcurrentHashMap<String, String> concurrentHashMap = this.cache;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            IProcessContextUpdater iProcessContextUpdater = this.updater;
            if (iProcessContextUpdater != null) {
                z16 = iProcessContextUpdater.update(this.cache);
            } else {
                z16 = false;
            }
            if (z16) {
                this.cache.clear();
            }
        }
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void put(String str, boolean z16) {
        store(str, Boolean.toString(z16));
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void put(String str, long j3) {
        store(str, Long.toString(j3));
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void put(String str, double d16) {
        store(str, Double.toString(d16));
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void put(String str, String str2) {
        store(str, str2);
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void put(String str, List<String> list) {
        store(str, ProcessContextUtil.listToString(list));
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextCache
    public void put(String str, JSONObject jSONObject) {
        store(str, jSONObject == null ? "" : jSONObject.toString());
    }
}
