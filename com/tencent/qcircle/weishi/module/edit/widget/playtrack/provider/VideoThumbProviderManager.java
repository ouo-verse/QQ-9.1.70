package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class VideoThumbProviderManager implements IVideoThumbProviderManager {
    public static final float DEFAULT_HEIGHT = 53.0f;
    public static final float DEFAULT_WIDTH = 40.0f;
    private static int MAX_SIZE = 4096;
    private static final String TAG = "VideoThumbProviderManager";
    private static volatile VideoThumbProviderManager sInstance;
    private Bitmap mDefaultBitmap;
    private Handler mHandler;
    private LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> mLruCache;
    private ArrayList<VideoThumbAssetProvider> mVideoThumbAssetProviders = new ArrayList<>();
    private ArrayList<VideoThumbListener> mVideoThumbListeners = new ArrayList<>();
    private VideoThumbListener mSubVideoThumbListener = new VideoThumbListener() { // from class: com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager.1
        @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbListener
        public void onThumbGenerated(Object obj, CMTime cMTime, Bitmap bitmap) {
            Iterator it = VideoThumbProviderManager.this.mVideoThumbListeners.iterator();
            while (it.hasNext()) {
                ((VideoThumbListener) it.next()).onThumbGenerated(obj, cMTime, bitmap);
            }
        }
    };
    private RunnableHandler mRunnableHandler = new RunnableHandler() { // from class: com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager.2
        @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.RunnableHandler
        public void postRunnable(Runnable runnable) {
            VideoThumbProviderManager.this.mHandler.postAtFrontOfQueue(runnable);
        }

        @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.RunnableHandler
        public void runnableFailAndReleaseCache() {
            long cacheSize = VideoThumbProviderManager.this.getCacheSize();
            int size = VideoThumbProviderManager.this.mVideoThumbAssetProviders.size();
            VideoThumbProviderManager.this.mLruCache.trimToSize(VideoThumbProviderManager.this.mLruCache.maxSize() / 2);
            Logger.e(VideoThumbProviderManager.TAG, "runnableFailAndReleaseCache currentCacheSize:" + cacheSize + ",size:" + size);
        }
    };
    private int mWidth = ViewUtils.dip2px(40.0f);
    private int mHeight = ViewUtils.dip2px(53.0f);

    /* loaded from: classes22.dex */
    private class VideoThumbLruCache extends LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> {
        VideoThumbLruCache(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        public void entryRemoved(boolean z16, @NonNull BaseVideoThumbAssetCache.LRUKey lRUKey, @NonNull Integer num, @Nullable Integer num2) {
            super.entryRemoved(z16, (boolean) lRUKey, num, num2);
            if (z16) {
                VideoThumbProviderManager videoThumbProviderManager = VideoThumbProviderManager.this;
                VideoThumbAssetProvider findVideoThumbAssetProviderByAssetPath = videoThumbProviderManager.findVideoThumbAssetProviderByAssetPath(lRUKey.assetId, videoThumbProviderManager.mVideoThumbAssetProviders);
                if (findVideoThumbAssetProviderByAssetPath != null) {
                    findVideoThumbAssetProviderByAssetPath.releaseBitmap(lRUKey.time);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        public int sizeOf(@NonNull BaseVideoThumbAssetCache.LRUKey lRUKey, @NonNull Integer num) {
            return num.intValue() / 1024;
        }
    }

    VideoThumbProviderManager() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG, 0);
        baseHandlerThread.start();
        this.mHandler = new Handler(baseHandlerThread.getLooper());
        int i3 = MAX_SIZE;
        if (!TextUtils.isEmpty("")) {
            try {
                i3 = Integer.parseInt("");
            } catch (NumberFormatException e16) {
                Logger.e(TAG, "constructor", e16);
            }
        }
        Logger.i(TAG, "maxSizeStr:,maxSize:" + i3);
        this.mLruCache = new VideoThumbLruCache(i3);
    }

    private VideoThumbAssetProvider createProvider(TAVSource tAVSource, String str, String str2) {
        if (tAVSource == null) {
            Logger.e(TAG, "assetPath is null");
            return null;
        }
        VideoThumbAssetProvider videoThumbAssetProvider = new VideoThumbAssetProvider(str2);
        videoThumbAssetProvider.init(tAVSource, str, this.mWidth, this.mHeight, this.mLruCache, this.mRunnableHandler);
        videoThumbAssetProvider.setThumbListener(this.mSubVideoThumbListener);
        videoThumbAssetProvider.setDefaultBitmap(this.mDefaultBitmap);
        return videoThumbAssetProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoThumbAssetProvider findVideoThumbAssetProviderByAssetPath(String str, ArrayList<VideoThumbAssetProvider> arrayList) {
        Iterator<VideoThumbAssetProvider> it = arrayList.iterator();
        while (it.hasNext()) {
            VideoThumbAssetProvider next = it.next();
            if (TextUtils.equals(str, next.getAssetId())) {
                return next;
            }
        }
        return null;
    }

    public static VideoThumbProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (VideoThumbProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new VideoThumbProviderManager();
                }
            }
        }
        return sInstance;
    }

    public static void initLruCacheSize(int i3) {
        MAX_SIZE = i3;
    }

    private void releaseGroup(ArrayList<VideoThumbAssetProvider> arrayList, String str, List<String> list) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<VideoThumbAssetProvider> it = arrayList.iterator();
        while (it.hasNext()) {
            VideoThumbAssetProvider next = it.next();
            if (TextUtils.equals(next.getGroupId(), str) && !list.contains(next.getAssetId())) {
                arrayList2.add(next);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            VideoThumbAssetProvider videoThumbAssetProvider = (VideoThumbAssetProvider) it5.next();
            arrayList.remove(videoThumbAssetProvider);
            videoThumbAssetProvider.release();
        }
    }

    private void resetProvider(TAVSource tAVSource, String str, String str2) {
        Logger.i(TAG, "resetProvider start:" + str);
        ArrayList arrayList = new ArrayList();
        if (findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders) != null) {
            Logger.i(TAG, "resetProvider find:" + str);
        } else {
            Logger.i(TAG, "resetProvider can't find:" + str);
            if (tAVSource == null) {
                Logger.e(TAG, "assetPath is null");
                return;
            }
            VideoThumbAssetProvider createProvider = createProvider(tAVSource, str, str2);
            if (createProvider == null) {
                Logger.e(TAG, "newProvider is null");
                return;
            }
            this.mVideoThumbAssetProviders.add(createProvider);
        }
        arrayList.add(str);
        releaseGroup(this.mVideoThumbAssetProviders, str2, arrayList);
    }

    public boolean addProvider(TAVSource tAVSource, String str) {
        VideoThumbAssetProvider findVideoThumbAssetProviderByAssetPath = findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders);
        Logger.i(TAG, "addProvider:" + str);
        if (findVideoThumbAssetProviderByAssetPath != null) {
            return false;
        }
        Logger.i(TAG, "addProvider can't find:" + str);
        VideoThumbAssetProvider createProvider = createProvider(tAVSource, str, "");
        if (createProvider == null) {
            Logger.e(TAG, "newProvider is null");
            return false;
        }
        this.mVideoThumbAssetProviders.add(createProvider);
        return true;
    }

    public boolean checkProviderIsExist(String str) {
        if (findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public Bitmap getBitmapByTime(long j3, Object obj, String str) {
        if (this.mHeight == 0 && this.mWidth == 0) {
            return this.mDefaultBitmap;
        }
        if (this.mVideoThumbAssetProviders.isEmpty()) {
            return this.mDefaultBitmap;
        }
        VideoThumbAssetProvider findVideoThumbAssetProviderByAssetPath = findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders);
        if (findVideoThumbAssetProviderByAssetPath == null) {
            return this.mDefaultBitmap;
        }
        return findVideoThumbAssetProviderByAssetPath.getAbsoluteBitmapByTime(j3, obj);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public long getCacheSize() {
        Iterator<VideoThumbAssetProvider> it = this.mVideoThumbAssetProviders.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().getCache();
        }
        return j3;
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void initWidthAndHeight(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
        Logger.i(TAG, "mWidth:" + this.mWidth + "mHeight:" + this.mHeight);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void pause() {
        Iterator<VideoThumbAssetProvider> it = this.mVideoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
        Logger.i(TAG, "pause");
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void registerListener(VideoThumbListener videoThumbListener) {
        if (!this.mVideoThumbListeners.contains(videoThumbListener)) {
            this.mVideoThumbListeners.add(videoThumbListener);
            Logger.i(TAG, "registerListener addSuccess");
        }
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void release(String str) {
        releaseGroup(this.mVideoThumbAssetProviders, str, new ArrayList());
        Logger.i(TAG, "release:" + str);
    }

    public void releaseBitmapCacheByKey(@NonNull BaseVideoThumbAssetCache.LRUKey lRUKey) {
        LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.remove(lRUKey);
        }
    }

    public void releaseProviderByAssetPath(String str) {
        Logger.i(TAG, "releaseProviderByAssetPath:" + str);
        VideoThumbAssetProvider findVideoThumbAssetProviderByAssetPath = findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders);
        if (findVideoThumbAssetProviderByAssetPath != null) {
            Logger.i(TAG, "releaseProviderByAssetPath success");
            this.mVideoThumbAssetProviders.remove(findVideoThumbAssetProviderByAssetPath);
            findVideoThumbAssetProviderByAssetPath.release();
        }
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void reset(MediaResourceModel mediaResourceModel, String str) {
        if (this.mWidth == 0 || this.mHeight == 0) {
            return;
        }
        resetProvider(mediaResourceModel, str);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void resume() {
        Iterator<VideoThumbAssetProvider> it = this.mVideoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            it.next().resume();
        }
        Logger.i(TAG, "resume");
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void setDefaultBitmap(Bitmap bitmap) {
        this.mDefaultBitmap = bitmap;
        Iterator<VideoThumbAssetProvider> it = this.mVideoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            it.next().setDefaultBitmap(bitmap);
        }
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void unRegisterListener(VideoThumbListener videoThumbListener) {
        Logger.i(TAG, "unRegisterListener removeSuccess:" + this.mVideoThumbListeners.remove(videoThumbListener));
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IVideoThumbProviderManager
    public void reset(TAVSource tAVSource, String str, String str2) {
        if (this.mWidth == 0 || this.mHeight == 0) {
            return;
        }
        resetProvider(tAVSource, str, str2);
    }

    private void resetProvider(MediaResourceModel mediaResourceModel, String str) {
        if (mediaResourceModel == null) {
            Logger.e(TAG, "mediaResourceModel is null");
            return;
        }
        Logger.i(TAG, "resetProvider start");
        ArrayList arrayList = new ArrayList();
        Iterator<MediaClipModel> it = mediaResourceModel.getVideos().iterator();
        while (it.hasNext()) {
            VideoResourceModel resource = it.next().getResource();
            String path = resource.getPath();
            if (findVideoThumbAssetProviderByAssetPath(path, this.mVideoThumbAssetProviders) == null) {
                Logger.i(TAG, "resetProvider can't find:" + path);
                VideoThumbAssetProvider videoThumbAssetProvider = new VideoThumbAssetProvider(str);
                videoThumbAssetProvider.init(resource, this.mWidth, this.mHeight, this.mLruCache, this.mRunnableHandler);
                videoThumbAssetProvider.setThumbListener(this.mSubVideoThumbListener);
                videoThumbAssetProvider.setDefaultBitmap(this.mDefaultBitmap);
                this.mVideoThumbAssetProviders.add(videoThumbAssetProvider);
            } else {
                Logger.i(TAG, "resetProvider find:" + path);
            }
            arrayList.add(path);
        }
        releaseGroup(this.mVideoThumbAssetProviders, str, arrayList);
    }
}
