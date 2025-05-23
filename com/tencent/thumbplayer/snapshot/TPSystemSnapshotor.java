package com.tencent.thumbplayer.snapshot;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.snapshot.ITPSnapshotor;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.asset.TPAfdMediaAsset;
import com.tencent.thumbplayer.asset.TPPfdMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.common.TPErrorCode;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPSystemSnapshotor implements ITPSnapshotor {
    private static final int STATE_IDLE = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 2;
    private static final String TAG = "TPSystemSnapshotor";
    private static final AtomicInteger sTaskIdGenerator = new AtomicInteger();
    private ITPMediaAsset mMediaAsset;
    private ITPSnapshotor.ITPSnapshotorListener mSnapshotorListener;
    private Handler mWorkerHandler;
    private Handler mListenerHandler = null;
    private MediaMetadataRetriever mRetriever = new MediaMetadataRetriever();
    private boolean mIsDataSourceSet = false;
    private int mState = 0;

    private boolean isDeviceIncompatible() {
        return "Lenovo+K900".equals(TPSystemInfo.getDeviceName());
    }

    private boolean isPixelFormatIncompatible(TPSnapshotParams tPSnapshotParams) {
        int pixelFormat;
        if (tPSnapshotParams == null || (pixelFormat = tPSnapshotParams.getPixelFormat()) == 37 || pixelFormat == 26) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnError$2(int i3, long j3, TPError tPError) {
        this.mSnapshotorListener.onError(i3, j3, tPError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnSuccess$1(int i3, long j3, TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.mSnapshotorListener.onSuccess(i3, j3, j3, tPVideoFrameBuffer);
    }

    private void notifyOnError(final int i3, final long j3) {
        TPLogUtil.e(TAG, "Failed to snapshot. task id=" + i3 + ", position=" + j3);
        final TPError tPError = new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_FAILED);
        Handler handler = this.mListenerHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.thumbplayer.snapshot.e
                @Override // java.lang.Runnable
                public final void run() {
                    TPSystemSnapshotor.this.lambda$notifyOnError$2(i3, j3, tPError);
                }
            });
        } else {
            this.mSnapshotorListener.onError(i3, j3, tPError);
        }
    }

    private void notifyOnSuccess(final int i3, final long j3, final TPVideoFrameBuffer tPVideoFrameBuffer) {
        Handler handler = this.mListenerHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.thumbplayer.snapshot.d
                @Override // java.lang.Runnable
                public final void run() {
                    TPSystemSnapshotor.this.lambda$notifyOnSuccess$1(i3, j3, tPVideoFrameBuffer);
                }
            });
        } else {
            this.mSnapshotorListener.onSuccess(i3, j3, j3, tPVideoFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSource() {
        try {
            int assetType = this.mMediaAsset.getAssetType();
            if (assetType != 1) {
                if (assetType != 2) {
                    if (assetType != 3) {
                        TPLogUtil.e(TAG, "Unknown asset type=" + this.mMediaAsset.getAssetType() + ". WTF is the type checker doing?");
                        this.mIsDataSourceSet = false;
                    } else {
                        this.mRetriever.setDataSource(((TPUrlMediaAsset) this.mMediaAsset).getUrl(), Collections.emptyMap());
                        this.mIsDataSourceSet = true;
                    }
                } else {
                    this.mRetriever.setDataSource(((TPPfdMediaAsset) this.mMediaAsset).getParcelFileDescriptor().getFileDescriptor());
                    this.mIsDataSourceSet = true;
                }
            } else {
                AssetFileDescriptor assetFileDescriptor = ((TPAfdMediaAsset) this.mMediaAsset).getAssetFileDescriptor();
                this.mRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                this.mIsDataSourceSet = true;
            }
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16, "Failed to call setDataSource method");
            this.mIsDataSourceSet = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: snapshot, reason: merged with bridge method [inline-methods] */
    public void lambda$snapshotAsyncForPositions$0(int i3, long[] jArr, TPSnapshotParams tPSnapshotParams) {
        int i16;
        int i17;
        int i18;
        int width;
        int height;
        Bitmap.Config config;
        int i19 = 37;
        if (tPSnapshotParams != null) {
            i17 = tPSnapshotParams.getWidth();
            i18 = tPSnapshotParams.getHeight();
            i16 = tPSnapshotParams.getPixelFormat();
        } else {
            i16 = 37;
            i17 = 0;
            i18 = 0;
        }
        if (i16 == 26) {
            i19 = 26;
        }
        for (long j3 : jArr) {
            if (!this.mIsDataSourceSet) {
                notifyOnError(i3, j3);
            } else {
                Bitmap frameAtTime = this.mRetriever.getFrameAtTime(1000 * j3, 3);
                if (frameAtTime == null) {
                    TPLogUtil.e(TAG, "snapshot image is null");
                    notifyOnError(i3, j3);
                } else {
                    if (i17 > 0) {
                        width = i17;
                    } else {
                        width = frameAtTime.getWidth();
                    }
                    if (i18 > 0) {
                        height = i18;
                    } else {
                        height = frameAtTime.getHeight();
                    }
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(frameAtTime, width, height, true);
                    if (createScaledBitmap != frameAtTime) {
                        frameAtTime.recycle();
                    }
                    if (i19 == 26) {
                        config = Bitmap.Config.ARGB_8888;
                    } else {
                        config = Bitmap.Config.RGB_565;
                    }
                    Bitmap copy = createScaledBitmap.copy(config, false);
                    createScaledBitmap.recycle();
                    if (copy == null) {
                        TPLogUtil.e(TAG, "Transform Bitmap failed");
                        notifyOnError(i3, j3);
                    } else {
                        ByteBuffer allocate = ByteBuffer.allocate(copy.getRowBytes() * copy.getHeight());
                        copy.copyPixelsToBuffer(allocate);
                        copy.recycle();
                        byte[][] bArr = {allocate.array()};
                        TPVideoFrameBuffer tPVideoFrameBuffer = new TPVideoFrameBuffer();
                        tPVideoFrameBuffer.setFormat(i19);
                        tPVideoFrameBuffer.setData(bArr);
                        tPVideoFrameBuffer.setLineSize(new int[]{bArr[0].length});
                        tPVideoFrameBuffer.setWidth(width);
                        tPVideoFrameBuffer.setHeight(height);
                        tPVideoFrameBuffer.setDisplayWidth(width);
                        tPVideoFrameBuffer.setDisplayHeight(height);
                        tPVideoFrameBuffer.setRotation(0);
                        notifyOnSuccess(i3, j3, tPVideoFrameBuffer);
                    }
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public void init(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPSnapshotor.ITPSnapshotorListener iTPSnapshotorListener) throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        if (this.mState == 0) {
            if (iTPSnapshotorListener != null) {
                if (iTPMediaAsset != null && iTPMediaAsset.isValid()) {
                    if (!isDeviceIncompatible()) {
                        int assetType = iTPMediaAsset.getAssetType();
                        if (assetType != 3 && assetType != 2 && assetType != 1) {
                            throw new IllegalArgumentException("Unsupported asset type: " + assetType);
                        }
                        this.mMediaAsset = iTPMediaAsset;
                        this.mWorkerHandler = new Handler(TPThreadPool.getInstance().obtainSharedHandlerThread().getLooper());
                        Looper myLooper = Looper.myLooper();
                        if (myLooper != null) {
                            this.mListenerHandler = new Handler(myLooper);
                        }
                        this.mSnapshotorListener = iTPSnapshotorListener;
                        this.mRetriever = new MediaMetadataRetriever();
                        if (this.mWorkerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.snapshot.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                TPSystemSnapshotor.this.setDataSource();
                            }
                        })) {
                            this.mState = 1;
                            return;
                        }
                        throw new UnsupportedOperationException("Message queue is exiting");
                    }
                    throw new UnsupportedOperationException("Device incompatible");
                }
                throw new IllegalArgumentException("Invalid asset: " + iTPMediaAsset);
            }
            throw new IllegalArgumentException("Listener is null");
        }
        throw new IllegalStateException("Already been initialized");
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public void release() {
        try {
            try {
            } catch (IOException | RuntimeException e16) {
                TPLogUtil.e(TAG, e16, "release method failed");
            }
            if (this.mState != 1) {
                return;
            }
            TPThreadPool.getInstance().recycle(TPThreadPool.getInstance().obtainSharedHandlerThread(), this.mWorkerHandler);
            Handler handler = this.mListenerHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mRetriever.release();
        } finally {
            this.mState = 2;
        }
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public int snapshotAsyncAtPosition(long j3, @Nullable TPSnapshotParams tPSnapshotParams) throws IllegalStateException, UnsupportedOperationException, IllegalArgumentException {
        return snapshotAsyncForPositions(new long[]{j3}, tPSnapshotParams);
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public int snapshotAsyncForPositions(final long[] jArr, @Nullable final TPSnapshotParams tPSnapshotParams) throws IllegalStateException, UnsupportedOperationException, IllegalArgumentException {
        if (this.mState == 1) {
            if (!isPixelFormatIncompatible(tPSnapshotParams)) {
                final int incrementAndGet = sTaskIdGenerator.incrementAndGet();
                if (this.mWorkerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.snapshot.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSystemSnapshotor.this.lambda$snapshotAsyncForPositions$0(incrementAndGet, jArr, tPSnapshotParams);
                    }
                })) {
                    return incrementAndGet;
                }
                throw new UnsupportedOperationException("Message queue is exiting");
            }
            throw new IllegalArgumentException("Incompatible pixel format: " + tPSnapshotParams.getPixelFormat());
        }
        throw new IllegalStateException("snapshotor uninitialized");
    }
}
