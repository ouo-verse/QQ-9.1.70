package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.tav.coremedia.CMTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoThumbVideoCache extends BaseVideoThumbAssetCache {
    private static final String TAG = "VideoThumbVideoCache";
    private CopyOnWriteArrayList<BaseVideoThumbAssetCache.BitmapPoint> mBitmapList;
    private HashSet<String> mGeneratingRecorder;

    public VideoThumbVideoCache(String str, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache) {
        super(str, lruCache);
        this.mBitmapList = new CopyOnWriteArrayList<>();
        this.mGeneratingRecorder = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseVideoThumbAssetCache.SeekListResult commonBinarySearch(List<BaseVideoThumbAssetCache.BitmapPoint> list, long j3, boolean z16) {
        int size = list.size() - 1;
        BaseVideoThumbAssetCache.SeekListResult seekListResult = new BaseVideoThumbAssetCache.SeekListResult();
        seekListResult.index = 0;
        seekListResult.isNormalized = true;
        if (!list.isEmpty() && j3 >= list.get(0).time) {
            if (j3 > list.get(size).time) {
                if (z16) {
                    seekListResult.index = list.size();
                } else {
                    seekListResult.index = size;
                }
                return seekListResult;
            }
            int i3 = 0;
            while (i3 <= size) {
                int i16 = (i3 + size) / 2;
                if (list.get(i16).time > j3) {
                    size = i16 - 1;
                } else if (list.get(i16).time < j3) {
                    i3 = i16 + 1;
                } else {
                    seekListResult.index = i16;
                    seekListResult.isNormalized = false;
                    return seekListResult;
                }
            }
            BaseVideoThumbAssetCache.SeekListResult seekListResult2 = new BaseVideoThumbAssetCache.SeekListResult();
            seekListResult2.index = i3;
            seekListResult2.isNormalized = true;
            return seekListResult2;
        }
        return seekListResult;
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public void addCover(CMTime cMTime, Bitmap bitmap) {
        long timeUs = cMTime.getTimeUs() / 1000;
        Logger.i(TAG, "addCover: " + timeUs);
        if (!this.mGeneratingRecorder.contains(String.valueOf(timeUs))) {
            this.mGeneratingRecorder.add(String.valueOf(timeUs));
            this.mBitmapList.add(commonBinarySearch(this.mBitmapList, timeUs, true).index, new BaseVideoThumbAssetCache.BitmapPoint(bitmap, timeUs));
            int allocationByteCount = bitmap.getAllocationByteCount();
            this.mCacheSize += allocationByteCount;
            this.mLruCache.put(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, timeUs), Integer.valueOf(allocationByteCount));
        }
        Logger.i(TAG, "mCacheSize: " + this.mCacheSize);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public BaseVideoThumbAssetCache.SeekResult getCover(long j3) {
        if (this.mBitmapList.isEmpty()) {
            return new BaseVideoThumbAssetCache.SeekResult(null, false);
        }
        BaseVideoThumbAssetCache.SeekListResult commonBinarySearch = commonBinarySearch(this.mBitmapList, j3, false);
        BaseVideoThumbAssetCache.BitmapPoint bitmapPoint = this.mBitmapList.get(commonBinarySearch.index);
        this.mLruCache.get(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, j3));
        return new BaseVideoThumbAssetCache.SeekResult(bitmapPoint.bitmap, commonBinarySearch.isNormalized);
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public void release() {
        Iterator<BaseVideoThumbAssetCache.BitmapPoint> it = this.mBitmapList.iterator();
        while (it.hasNext()) {
            BaseVideoThumbAssetCache.BitmapPoint next = it.next();
            Bitmap bitmap = next.bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                next.bitmap.recycle();
            }
            this.mLruCache.remove(new BaseVideoThumbAssetCache.LRUKey(this.mAssetId, next.time));
        }
        this.mBitmapList.clear();
        this.mGeneratingRecorder.clear();
    }

    @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache
    public void releaseLowMemory(final long j3) {
        HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoCache.1
            @Override // java.lang.Runnable
            public void run() {
                VideoThumbVideoCache videoThumbVideoCache = VideoThumbVideoCache.this;
                BaseVideoThumbAssetCache.SeekListResult commonBinarySearch = videoThumbVideoCache.commonBinarySearch(videoThumbVideoCache.mBitmapList, j3, false);
                Logger.i(VideoThumbVideoCache.TAG, "bitmap start recycle:" + commonBinarySearch.isNormalized);
                if (!commonBinarySearch.isNormalized) {
                    BaseVideoThumbAssetCache.BitmapPoint bitmapPoint = (BaseVideoThumbAssetCache.BitmapPoint) VideoThumbVideoCache.this.mBitmapList.remove(commonBinarySearch.index);
                    VideoThumbVideoCache.this.mGeneratingRecorder.remove(String.valueOf(bitmapPoint.time));
                    VideoThumbVideoCache.this.mCacheSize -= bitmapPoint.bitmap.getAllocationByteCount();
                    Bitmap bitmap = bitmapPoint.bitmap;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        Logger.i(VideoThumbVideoCache.TAG, "bitmap recycle:" + bitmapPoint.time);
                        bitmapPoint.bitmap.recycle();
                    }
                }
            }
        });
    }
}
