package com.tencent.tav.extractor.wrapper;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExtractorLoader {
    private static Handler loadHandler;
    private static HandlerThread loadThread;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class ExtractorLoaderRunnable implements Runnable {
        private AssetExtractor extractor;

        ExtractorLoaderRunnable(AssetExtractor assetExtractor) {
            this.extractor = assetExtractor;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ExtractorWrapperPool.contains(this.extractor.getSourcePath())) {
                ExtractorWrapper extractorWrapper = new ExtractorWrapper(this.extractor.getSourcePath());
                extractorWrapper.checkAndLoad(this.extractor);
                ExtractorWrapperPool.put(extractorWrapper);
                this.extractor = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class VideoPathLoaderRunnable implements Runnable {
        private String videoPath;

        VideoPathLoaderRunnable(String str) {
            this.videoPath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ExtractorWrapperPool.contains(this.videoPath)) {
                AssetExtractor assetExtractor = new AssetExtractor();
                assetExtractor.setDataSource(this.videoPath);
                ExtractorWrapper extractorWrapper = new ExtractorWrapper(this.videoPath);
                extractorWrapper.checkAndLoad(assetExtractor);
                ExtractorWrapperPool.put(extractorWrapper);
            }
        }
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ExtractorLoader");
        loadThread = baseHandlerThread;
        baseHandlerThread.start();
    }

    public static void cacheExtractor(String str) {
        checkAndStart();
        loadHandler.post(new VideoPathLoaderRunnable(str));
    }

    private static void checkAndStart() {
        if (loadHandler == null && loadThread.getLooper() != null) {
            loadHandler = new Handler(loadThread.getLooper());
        }
    }

    public static void cacheExtractor(AssetExtractor assetExtractor) {
        checkAndStart();
        loadHandler.post(new ExtractorLoaderRunnable(assetExtractor));
    }
}
