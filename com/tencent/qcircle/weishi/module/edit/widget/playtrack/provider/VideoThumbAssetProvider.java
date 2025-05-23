package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.utils.ListUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes22.dex */
public class VideoThumbAssetProvider {
    private static final int END_OFFSET = 100;
    private static final int ONE_SEC = 1000;
    private static final String TAG = "VideoThumbAssetProvider";
    private String mAssetId;
    private BaseVideoThumbAssetCache mCoverCache;
    private BaseVideoThumbGenerator mCoverGenerator;
    private Bitmap mDefaultBitmap;
    private String mGroupId;
    private long mSourceTimeDuration;
    private VideoThumbListener mUserVideoThumbListener;
    private VideoThumbListener mDefaultVideoThumbListener = new VideoThumbListener() { // from class: com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbAssetProvider.1
        @Override // com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbListener
        public void onThumbGenerated(Object obj, final CMTime cMTime, final Bitmap bitmap) {
            HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbAssetProvider.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoThumbAssetProvider.this.mCoverCache != null) {
                        VideoThumbAssetProvider.this.mCoverCache.addCover(cMTime, bitmap);
                    }
                    String valueOf = String.valueOf(cMTime.getTimeUs() / 1000);
                    List list = (List) VideoThumbAssetProvider.this.mTagTable.get(valueOf);
                    if (list != null) {
                        VideoThumbAssetProvider.this.mTagTable.remove(valueOf);
                        if (VideoThumbAssetProvider.this.mUserVideoThumbListener != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                VideoThumbAssetProvider.this.mUserVideoThumbListener.onThumbGenerated(it.next(), cMTime, bitmap);
                            }
                        }
                    }
                }
            });
        }
    };
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> mTagTable = new ConcurrentHashMap<>();
    private int mAssetType = 1;

    public VideoThumbAssetProvider(String str) {
        this.mGroupId = str;
    }

    private Bitmap getBitmapByNormalizedTime(long j3, Object obj) {
        BaseVideoThumbAssetCache.SeekResult cover = this.mCoverCache.getCover(j3);
        if (cover.bitmap == null) {
            sendGenerateRequest(obj, j3);
            return this.mDefaultBitmap;
        }
        if (cover.isNormalized) {
            sendGenerateRequest(obj, j3);
        }
        return cover.bitmap;
    }

    private long getNormalizedSeekTime(long j3, long j16) {
        long j17 = j3 / 1000;
        if (j3 % 1000 >= 500) {
            j17++;
        }
        long j18 = j17 * 1000;
        if (j18 < 0) {
            j18 = 0;
        }
        if (j18 > j16) {
            return j16 - 100;
        }
        return j18;
    }

    private void initGeneratorAndCache(TAVSource tAVSource, int i3, int i16, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache, RunnableHandler runnableHandler) {
        this.mCoverCache = new VideoThumbVideoCache(this.mAssetId, lruCache);
        VideoThumbVideoGenerator videoThumbVideoGenerator = new VideoThumbVideoGenerator();
        this.mCoverGenerator = videoThumbVideoGenerator;
        videoThumbVideoGenerator.init(tAVSource);
        this.mCoverGenerator.setCoverHeight(i16);
        this.mCoverGenerator.setCoverWidth(i3);
        this.mCoverGenerator.setVideoThumbListener(this.mDefaultVideoThumbListener);
        this.mCoverGenerator.setGenerateHandler(runnableHandler);
    }

    private void sendGenerateRequest(Object obj, long j3) {
        if (this.mCoverGenerator == null) {
            return;
        }
        String valueOf = String.valueOf(j3);
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = this.mTagTable.get(valueOf);
        if (copyOnWriteArrayList != null) {
            if (!copyOnWriteArrayList.contains(obj)) {
                copyOnWriteArrayList.add(obj);
                return;
            }
            return;
        }
        CopyOnWriteArrayList<Object> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList2.add(obj);
        this.mTagTable.put(valueOf, copyOnWriteArrayList2);
        Logger.i(TAG, "sendGenerateRequest time:" + j3 + ",Object:" + obj);
        this.mCoverGenerator.generateCoverByTime(CMTime.fromMs(j3));
    }

    public Bitmap getAbsoluteBitmapByTime(long j3, Object obj) {
        if (this.mAssetType == 2) {
            return getBitmapByNormalizedTime(0L, obj);
        }
        return getBitmapByNormalizedTime(getNormalizedSeekTime(j3, this.mSourceTimeDuration), obj);
    }

    public String getAssetId() {
        return this.mAssetId;
    }

    public long getCache() {
        BaseVideoThumbAssetCache baseVideoThumbAssetCache = this.mCoverCache;
        if (baseVideoThumbAssetCache != null) {
            return baseVideoThumbAssetCache.getCacheSize();
        }
        return 0L;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void init(VideoResourceModel videoResourceModel, int i3, int i16, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache, RunnableHandler runnableHandler) {
        this.mAssetId = videoResourceModel.getPath();
        this.mSourceTimeDuration = videoResourceModel.getSourceTimeDuration();
        initGeneratorAndCache(videoResourceModel, i3, i16, lruCache, runnableHandler);
    }

    public void pause() {
        BaseVideoThumbGenerator baseVideoThumbGenerator = this.mCoverGenerator;
        if (baseVideoThumbGenerator != null) {
            baseVideoThumbGenerator.pause();
        }
    }

    public void release() {
        Logger.i(TAG, "release:" + getAssetId());
        BaseVideoThumbGenerator baseVideoThumbGenerator = this.mCoverGenerator;
        if (baseVideoThumbGenerator != null) {
            baseVideoThumbGenerator.release();
            this.mCoverGenerator = null;
        }
        BaseVideoThumbAssetCache baseVideoThumbAssetCache = this.mCoverCache;
        if (baseVideoThumbAssetCache != null) {
            baseVideoThumbAssetCache.release();
            this.mCoverCache = null;
        }
    }

    public void releaseBitmap(long j3) {
        BaseVideoThumbAssetCache baseVideoThumbAssetCache = this.mCoverCache;
        if (baseVideoThumbAssetCache != null) {
            baseVideoThumbAssetCache.releaseLowMemory(j3);
        }
    }

    public void resume() {
        BaseVideoThumbGenerator baseVideoThumbGenerator = this.mCoverGenerator;
        if (baseVideoThumbGenerator != null) {
            baseVideoThumbGenerator.resume();
        }
    }

    public void setDefaultBitmap(Bitmap bitmap) {
        this.mDefaultBitmap = bitmap;
    }

    public void setThumbListener(VideoThumbListener videoThumbListener) {
        this.mUserVideoThumbListener = videoThumbListener;
    }

    public void init(TAVSource tAVSource, String str, int i3, int i16, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache, RunnableHandler runnableHandler) {
        this.mAssetId = str;
        this.mSourceTimeDuration = tAVSource.getAsset().getDuration().getTimeUs() / 1000;
        initGeneratorAndCache(tAVSource, i3, i16, lruCache, runnableHandler);
    }

    private void initGeneratorAndCache(VideoResourceModel videoResourceModel, int i3, int i16, LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> lruCache, RunnableHandler runnableHandler) {
        int type = videoResourceModel.getType();
        this.mAssetType = type;
        if (type == 2) {
            this.mCoverCache = new VideoThumbImageCache(videoResourceModel.getPath(), lruCache);
            VideoThumbImageGenerator videoThumbImageGenerator = new VideoThumbImageGenerator();
            this.mCoverGenerator = videoThumbImageGenerator;
            videoThumbImageGenerator.setAssetId(videoResourceModel.getPath());
            this.mCoverGenerator.setCoverHeight(i16);
            this.mCoverGenerator.setCoverWidth(i3);
        } else if (type == 1) {
            URLAsset uRLAsset = new URLAsset(videoResourceModel.getPath());
            float f16 = uRLAsset.getNaturalSize().height;
            float f17 = uRLAsset.getNaturalSize().width;
            float f18 = i3;
            float f19 = (f16 * f18) / f17;
            float f26 = i16;
            if (f19 < f26) {
                f18 = (f17 * f26) / f16;
                f19 = f26;
            }
            TAVClip tAVClip = new TAVClip(uRLAsset);
            tAVClip.getResource().setSourceTimeRange(new CMTimeRange(new CMTime(((float) videoResourceModel.getSourceTimeStart()) / 1000.0f), new CMTime(((float) videoResourceModel.getSourceTimeDuration()) / 1000.0f)));
            TAVComposition tAVComposition = new TAVComposition((List<TAVClip>) ListUtils.listWithObjects(tAVClip));
            tAVComposition.setRenderSize(new CGSize(f18, f19));
            TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
            this.mCoverCache = new VideoThumbVideoCache(videoResourceModel.getPath(), lruCache);
            VideoThumbVideoGenerator videoThumbVideoGenerator = new VideoThumbVideoGenerator();
            this.mCoverGenerator = videoThumbVideoGenerator;
            videoThumbVideoGenerator.init(buildSource);
            this.mCoverGenerator.setCoverHeight(f19);
            this.mCoverGenerator.setCoverWidth(f18);
        }
        this.mCoverGenerator.setVideoThumbListener(this.mDefaultVideoThumbListener);
        this.mCoverGenerator.setGenerateHandler(runnableHandler);
    }
}
