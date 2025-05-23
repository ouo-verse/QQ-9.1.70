package com.tencent.thumbplayer.core.codec.tmediacodec.pools;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.FormatWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.ThreadManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class CodecWrapperManager implements CodecWrapperTransformation {
    public static final String TAG = "CodecWrapperManager";
    private final CodecWrapperPool mKeepCodecPool;
    private final CodecWrapperPool mRunningCodecPool;

    public CodecWrapperManager() {
        CodecWrapperPool codecWrapperPool = new CodecWrapperPool(2, "keep");
        this.mKeepCodecPool = codecWrapperPool;
        this.mRunningCodecPool = new CodecWrapperPool(Integer.MAX_VALUE, "running");
        codecWrapperPool.setActionCallback(new PoolActionCallback() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperManager.2
            @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.PoolActionCallback
            public void onErase(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
                if (LogUtils.isLogEnable()) {
                    LogUtils.d("CodecWrapperManager", "onErase codecWrapper:" + reuseCodecWrapper);
                }
                reuseCodecWrapper.recycle();
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperTransformation
    public void clearAndReleaseAll() {
        if (LogUtils.isLogEnable()) {
            LogUtils.i("CodecWrapperManager", "clearAndReleaseAll");
        }
        this.mRunningCodecPool.clear();
        this.mKeepCodecPool.clear();
    }

    public void clearAndReleaseKeepPool() {
        this.mKeepCodecPool.clear();
    }

    @NonNull
    public final String getDumpInfo() {
        return "runningPool:" + this.mRunningCodecPool + " keepPool:" + this.mKeepCodecPool;
    }

    public boolean isKeepPoolFull() {
        return this.mKeepCodecPool.isFull();
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperTransformation
    @Nullable
    public ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper formatWrapper) {
        ReuseCodecWrapper obtain = this.mKeepCodecPool.obtain(formatWrapper);
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "obtainCodecWrapper codecWrapper:" + obtain);
        }
        return obtain;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperTransformation
    public void removeFromRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "removeFromRunning codecWrapper:" + reuseCodecWrapper);
        }
        this.mRunningCodecPool.remove(reuseCodecWrapper);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperTransformation
    public void transToKeep(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "transTokeep codecWrapper:" + reuseCodecWrapper);
        }
        this.mRunningCodecPool.remove(reuseCodecWrapper);
        this.mKeepCodecPool.put(reuseCodecWrapper);
        CodecCallback callback = reuseCodecWrapper.getCallback();
        if (callback != null) {
            callback.onTransToKeepPool();
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperTransformation
    public void transToRunning(@NonNull final ReuseCodecWrapper reuseCodecWrapper) {
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "transToRunning codecWrapper:" + reuseCodecWrapper);
        }
        this.mKeepCodecPool.remove(reuseCodecWrapper);
        this.mRunningCodecPool.put(reuseCodecWrapper);
        ThreadManager.postOnSubThread(new Runnable() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.pools.CodecWrapperManager.1
            @Override // java.lang.Runnable
            public void run() {
                CodecCallback callback = reuseCodecWrapper.getCallback();
                if (callback != null) {
                    callback.onTransToRunningPool();
                }
            }
        });
    }
}
