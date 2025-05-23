package com.tencent.libra.cache;

import android.annotation.SuppressLint;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;
import com.tencent.libra.cache.EngineResource;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ActiveResources {

    @VisibleForTesting
    final Map<Key, ResourceWeakReference> activeEngineResources;

    /* renamed from: cb, reason: collision with root package name */
    @Nullable
    private volatile DequeuedResourceCallback f118629cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes7.dex */
    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;

        @Nullable
        Resource<?> resource;

        @SuppressLint({"RestrictedApi"})
        ResourceWeakReference(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z16) {
            super(engineResource, referenceQueue);
            Resource<?> resource;
            this.key = (Key) Preconditions.checkNotNull(key);
            if (engineResource.isMemoryCacheable() && z16) {
                resource = (Resource) Preconditions.checkNotNull(engineResource.getResource());
            } else {
                resource = null;
            }
            this.resource = resource;
            this.isCacheable = engineResource.isMemoryCacheable();
        }

        void reset() {
            this.resource = null;
            clear();
        }
    }

    public ActiveResources(boolean z16) {
        this(z16, ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.libra.cache.ActiveResources.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull final Runnable runnable) {
                return new BaseThread(new Runnable() { // from class: com.tencent.libra.cache.ActiveResources.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "libra-active-resources");
            }
        }));
    }

    public synchronized void activate(Key key, EngineResource<?> engineResource) {
        ResourceWeakReference put = this.activeEngineResources.put(key, new ResourceWeakReference(key, engineResource, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed));
        if (put != null) {
            put.reset();
        }
    }

    void cleanReferenceQueue() {
        while (!this.isShutdown) {
            try {
                cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.f118629cb;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.onResourceDequeued();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void cleanupActiveReference(@NonNull ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.activeEngineResources.remove(resourceWeakReference.key);
            if (resourceWeakReference.isCacheable && resourceWeakReference.resource != null) {
                this.listener.onResourceReleased(resourceWeakReference.key, new EngineResource<>(resourceWeakReference.resource, true, false, resourceWeakReference.key, this.listener));
            }
        }
    }

    public void clearAll() {
        this.activeEngineResources.clear();
    }

    public synchronized void deactivate(Key key) {
        ResourceWeakReference remove = this.activeEngineResources.remove(key);
        if (remove != null) {
            remove.reset();
        }
    }

    @Nullable
    public synchronized EngineResource<?> get(Key key) {
        ResourceWeakReference resourceWeakReference = this.activeEngineResources.get(key);
        if (resourceWeakReference == null) {
            return null;
        }
        EngineResource<?> engineResource = resourceWeakReference.get();
        if (engineResource == null) {
            cleanupActiveReference(resourceWeakReference);
        }
        return engineResource;
    }

    @VisibleForTesting
    void setDequeuedResourceCallback(DequeuedResourceCallback dequeuedResourceCallback) {
        this.f118629cb = dequeuedResourceCallback;
    }

    public void setListener(@NonNull EngineResource.ResourceListener resourceListener) {
        this.listener = resourceListener;
    }

    @VisibleForTesting
    void shutdown() {
        this.isShutdown = true;
        Executor executor = this.monitorClearedResourcesExecutor;
        if (executor instanceof ExecutorService) {
            RFWThreadManager.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }

    ActiveResources(boolean z16, Executor executor) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue<>();
        this.isActiveResourceRetentionAllowed = z16;
        this.monitorClearedResourcesExecutor = executor;
        executor.execute(new Runnable() { // from class: com.tencent.libra.cache.ActiveResources.2
            @Override // java.lang.Runnable
            public void run() {
                ActiveResources.this.cleanReferenceQueue();
            }
        });
    }
}
