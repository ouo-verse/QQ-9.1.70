package com.tencent.thumbplayer.snapshot;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.snapshot.ITPSnapshotor;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPFieldCalledByNative;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import com.tencent.thumbplayer.snapshot.TPSelfDevSnapshotor;

/* loaded from: classes26.dex */
public class TPSelfDevSnapshotor implements ITPSnapshotor {
    private static final int INVALID_TASK_ID = -1;
    private static final String TAG = "TPSelfDevSnapshotor";
    private ITPSnapshotor.ITPSnapshotorListener mListener;
    private Handler mListenerHandler;

    @TPFieldCalledByNative
    private long mSelfDevSnapshotorContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class ThreadSwitchListener implements ITPSnapshotor.ITPSnapshotorListener {
        ThreadSwitchListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1(int i3, long j3, TPError tPError) {
            TPSelfDevSnapshotor.this.mListener.onError(i3, j3, tPError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(int i3, long j3, long j16, TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPSelfDevSnapshotor.this.mListener.onSuccess(i3, j3, j16, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
        public void onError(final int i3, final long j3, @NonNull final TPError tPError) {
            if (TPSelfDevSnapshotor.this.mListenerHandler != null) {
                TPSelfDevSnapshotor.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.snapshot.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSelfDevSnapshotor.ThreadSwitchListener.this.lambda$onError$1(i3, j3, tPError);
                    }
                });
            } else {
                TPSelfDevSnapshotor.this.mListener.onError(i3, j3, tPError);
            }
        }

        @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
        public void onSuccess(final int i3, final long j3, final long j16, @NonNull final TPVideoFrameBuffer tPVideoFrameBuffer) {
            if (TPSelfDevSnapshotor.this.mListenerHandler != null) {
                TPSelfDevSnapshotor.this.mListenerHandler.post(new Runnable() { // from class: com.tencent.thumbplayer.snapshot.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSelfDevSnapshotor.ThreadSwitchListener.this.lambda$onSuccess$0(i3, j3, j16, tPVideoFrameBuffer);
                    }
                });
            } else {
                TPSelfDevSnapshotor.this.mListener.onSuccess(i3, j3, j16, tPVideoFrameBuffer);
            }
        }
    }

    private native int native_init(ITPMediaAsset iTPMediaAsset, ITPSnapshotor.ITPSnapshotorListener iTPSnapshotorListener);

    private native void native_release();

    private native int native_snapshotAsyncAtPosition(long j3, TPSnapshotParams tPSnapshotParams);

    private native int native_snapshotAsyncForPositions(long[] jArr, TPSnapshotParams tPSnapshotParams);

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public void init(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPSnapshotor.ITPSnapshotorListener iTPSnapshotorListener) throws TPLoadLibraryException, UnsupportedOperationException {
        Handler handler;
        this.mListener = iTPSnapshotorListener;
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            handler = null;
        } else {
            handler = new Handler(myLooper);
        }
        this.mListenerHandler = handler;
        ThreadSwitchListener threadSwitchListener = new ThreadSwitchListener();
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                if (native_init(iTPMediaAsset, threadSwitchListener) == 0) {
                    return;
                } else {
                    throw new UnsupportedOperationException("Failed to initialize");
                }
            } catch (UnsatisfiedLinkError e16) {
                throw new TPLoadLibraryException("Failed to load native libraries", e16);
            }
        }
        throw new TPLoadLibraryException("native libraries not successfully loaded");
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public void release() {
        try {
            native_release();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16, "[release] Failed to reflect native method");
        }
        Handler handler = this.mListenerHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public int snapshotAsyncAtPosition(long j3, @Nullable TPSnapshotParams tPSnapshotParams) throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            int native_snapshotAsyncAtPosition = native_snapshotAsyncAtPosition(j3, tPSnapshotParams);
            if (-1 != native_snapshotAsyncAtPosition) {
                return native_snapshotAsyncAtPosition;
            }
            throw new UnsupportedOperationException("Failed to snapshotAsyncAtPosition");
        } catch (UnsatisfiedLinkError e16) {
            throw new TPLoadLibraryException("Failed to load native libraries", e16);
        }
    }

    @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor
    public int snapshotAsyncForPositions(long[] jArr, @Nullable TPSnapshotParams tPSnapshotParams) throws TPLoadLibraryException, UnsupportedOperationException {
        try {
            int native_snapshotAsyncForPositions = native_snapshotAsyncForPositions(jArr, tPSnapshotParams);
            if (-1 != native_snapshotAsyncForPositions) {
                return native_snapshotAsyncForPositions;
            }
            throw new UnsupportedOperationException("Failed to snapshotAsyncForPositions");
        } catch (UnsatisfiedLinkError e16) {
            throw new TPLoadLibraryException("Failed to load native libraries", e16);
        }
    }
}
