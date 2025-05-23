package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.IWorker;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class PreLoaderPool {
    private static volatile PreLoaderPool sInstance;
    private final AtomicInteger mAtomicInteger = new AtomicInteger(100);
    private final ConcurrentHashMap<String, IWorker> mWorkerMap = new ConcurrentHashMap<>();

    PreLoaderPool() {
    }

    public static PreLoaderPool getInstance() {
        if (sInstance == null) {
            synchronized (PreLoaderPool.class) {
                if (sInstance == null) {
                    sInstance = new PreLoaderPool();
                }
            }
        }
        return sInstance;
    }

    private <T> String preLoadWorker(String str, Worker<T> worker) {
        if (exists(str)) {
            PreLoader.log("preLoader ID is used, please note that remove!");
            remove(str);
        }
        this.mWorkerMap.put(str, worker);
        worker.doPreLoad();
        return str;
    }

    public boolean exists(String str) {
        return this.mWorkerMap.containsKey(str);
    }

    public <T> String preLoad(String str, BasePreLoadTask<T> basePreLoadTask) {
        return preLoadWorker(str, new Worker<>(str, basePreLoadTask, null, this.mAtomicInteger.getAndIncrement()));
    }

    public void remove(String str) {
        if (this.mWorkerMap.containsKey(str)) {
            try {
                IWorker iWorker = this.mWorkerMap.get(str);
                if (iWorker != null) {
                    iWorker.onRemove();
                }
            } catch (Exception e16) {
                PreLoader.log(e16);
            }
            this.mWorkerMap.remove(str);
        }
    }

    public <T> void removeListener(String str, OnTaskListener<T> onTaskListener) {
        try {
            IWorker iWorker = this.mWorkerMap.get(str);
            if (iWorker != null) {
                iWorker.removeListener(onTaskListener);
            }
        } catch (Exception e16) {
            PreLoader.log(e16);
        }
    }

    public <T> void setListener(String str, OnTaskListener<T> onTaskListener) {
        try {
            IWorker iWorker = this.mWorkerMap.get(str);
            if (iWorker != null) {
                iWorker.setListener(onTaskListener);
            }
        } catch (Exception e16) {
            PreLoader.log(e16);
        }
    }
}
