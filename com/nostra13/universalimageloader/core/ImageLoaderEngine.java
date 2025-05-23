package com.nostra13.universalimageloader.core;

import android.util.Log;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageLoaderEngine {
    private static final String TAG = "ImageLoaderEngine";
    final ImageLoaderConfiguration configuration;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private final Map<Integer, String> cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> uriLocks = new WeakHashMap();
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final AtomicBoolean networkDenied = new AtomicBoolean(false);
    private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
    private final Object pauseLock = new Object();
    private Executor taskDistributor = DefaultConfigurationFactory.createTaskDistributor();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLoaderEngine(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.configuration = imageLoaderConfiguration;
        this.taskExecutor = imageLoaderConfiguration.taskExecutor;
        this.taskExecutorForCachedImages = imageLoaderConfiguration.taskExecutorForCachedImages;
    }

    private Executor createTaskExecutor() {
        ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
        return DefaultConfigurationFactory.createExecutor(imageLoaderConfiguration.threadPoolSize, imageLoaderConfiguration.threadPriority, imageLoaderConfiguration.tasksProcessingType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExecutorsIfNeed() {
        if (!this.configuration.customExecutor && ((ExecutorService) this.taskExecutor).isShutdown()) {
            this.taskExecutor = createTaskExecutor();
        }
        if (!this.configuration.customExecutorForCachedImages && ((ExecutorService) this.taskExecutorForCachedImages).isShutdown()) {
            this.taskExecutorForCachedImages = createTaskExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocalUri(String str) {
        ImageDownloader.Scheme ofUri = ImageDownloader.Scheme.ofUri(str);
        if (ofUri != ImageDownloader.Scheme.ASSETS && ofUri != ImageDownloader.Scheme.FILE && ofUri != ImageDownloader.Scheme.DRAWABLE) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelDisplayTaskFor(ImageAware imageAware) {
        this.cacheKeysForImageAwares.remove(Integer.valueOf(imageAware.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void denyNetworkDownloads(boolean z16) {
        this.networkDenied.set(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fireCallback(Runnable runnable) {
        this.taskDistributor.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLoadingUriForView(ImageAware imageAware) {
        return this.cacheKeysForImageAwares.get(Integer.valueOf(imageAware.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReentrantLock getLockForUri(String str) {
        ReentrantLock reentrantLock = this.uriLocks.get(str);
        if (reentrantLock == null) {
            ReentrantLock reentrantLock2 = new ReentrantLock();
            this.uriLocks.put(str, reentrantLock2);
            return reentrantLock2;
        }
        return reentrantLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicBoolean getPause() {
        return this.paused;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getPauseLock() {
        return this.pauseLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleSlowNetwork(boolean z16) {
        this.slowNetwork.set(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isNetworkDenied() {
        return this.networkDenied.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSlowNetwork() {
        return this.slowNetwork.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        this.paused.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepareDisplayTaskFor(ImageAware imageAware, String str) {
        this.cacheKeysForImageAwares.put(Integer.valueOf(imageAware.getId()), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.paused.set(false);
        synchronized (this.pauseLock) {
            this.pauseLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (!this.configuration.customExecutor) {
            ((ExecutorService) this.taskExecutor).shutdownNow();
        }
        if (!this.configuration.customExecutorForCachedImages) {
            ((ExecutorService) this.taskExecutorForCachedImages).shutdownNow();
        }
        this.cacheKeysForImageAwares.clear();
        this.uriLocks.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void submit(final LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.taskDistributor.execute(new Runnable() { // from class: com.nostra13.universalimageloader.core.ImageLoaderEngine.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                File file = ImageLoaderEngine.this.configuration.diskCache.get(loadAndDisplayImageTask.getLoadingUri());
                if ((file != null && file.exists()) || ImageLoaderEngine.this.isLocalUri(loadAndDisplayImageTask.getLoadingUri())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ImageLoaderEngine.this.initExecutorsIfNeed();
                try {
                    if (z16) {
                        ImageLoaderEngine.this.taskExecutorForCachedImages.execute(loadAndDisplayImageTask);
                    } else {
                        ImageLoaderEngine.this.taskExecutor.execute(loadAndDisplayImageTask);
                    }
                } catch (Exception e16) {
                    Log.e(ImageLoaderEngine.TAG, "taskExecutor execute exception:", e16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void submit(ProcessAndDisplayImageTask processAndDisplayImageTask) {
        initExecutorsIfNeed();
        this.taskExecutorForCachedImages.execute(processAndDisplayImageTask);
    }
}
