package com.tencent.libra.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GroupKeyCache {
    private volatile boolean mIsShutdown;
    private Executor mMonitorClearedResourcesExecutor;
    private final Map<LibraGroupKey, Set<RequestKeyWeakReference>> mRequestKeyMap = new HashMap();
    private final ReferenceQueue<LibraRequestKey> mRequestKeyReferenceQueue = new ReferenceQueue<>();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class RequestKeyWeakReference extends WeakReference<LibraRequestKey> {
        final LibraGroupKey groupKey;

        @SuppressLint({"RestrictedApi"})
        RequestKeyWeakReference(@NonNull LibraGroupKey libraGroupKey, @NonNull LibraRequestKey libraRequestKey, @NonNull ReferenceQueue<LibraRequestKey> referenceQueue) {
            super(libraRequestKey, referenceQueue);
            this.groupKey = (LibraGroupKey) Preconditions.checkNotNull(libraGroupKey);
        }
    }

    private void cleanReferenceQueue() {
        while (!this.mIsShutdown) {
            try {
                RequestKeyWeakReference requestKeyWeakReference = (RequestKeyWeakReference) this.mRequestKeyReferenceQueue.remove();
                removeCache(requestKeyWeakReference.groupKey, requestKeyWeakReference.get());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void addCache(LibraGroupKey libraGroupKey, LibraRequestKey libraRequestKey) {
        if (libraGroupKey == null) {
            return;
        }
        Set<RequestKeyWeakReference> set = this.mRequestKeyMap.get(libraGroupKey);
        if (set == null) {
            set = new HashSet<>();
            this.mRequestKeyMap.put(libraGroupKey, set);
        }
        set.add(new RequestKeyWeakReference(libraGroupKey, libraRequestKey, this.mRequestKeyReferenceQueue));
    }

    public void clearAll() {
        this.mRequestKeyMap.clear();
    }

    @Nullable
    public synchronized Set<RequestKeyWeakReference> getCache(LibraGroupKey libraGroupKey) {
        if (libraGroupKey == null) {
            return null;
        }
        return this.mRequestKeyMap.get(libraGroupKey);
    }

    public synchronized void removeCache(LibraGroupKey libraGroupKey, LibraRequestKey libraRequestKey) {
        if (libraGroupKey == null) {
            return;
        }
        Set<RequestKeyWeakReference> set = this.mRequestKeyMap.get(libraGroupKey);
        if (set != null) {
            Iterator<RequestKeyWeakReference> it = set.iterator();
            while (it.hasNext()) {
                RequestKeyWeakReference next = it.next();
                if (next == null || Objects.equals(next.get(), libraRequestKey)) {
                    it.remove();
                }
            }
            if (set.isEmpty()) {
                this.mRequestKeyMap.remove(libraGroupKey);
            }
        }
    }

    public void shutdown() {
        this.mIsShutdown = true;
        Executor executor = this.mMonitorClearedResourcesExecutor;
        if (executor instanceof ExecutorService) {
            RFWThreadManager.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }
}
