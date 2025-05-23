package com.tencent.thumbplayer.api.snapshot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;

/* loaded from: classes26.dex */
public interface ITPSnapshotor {

    /* loaded from: classes26.dex */
    public interface ITPSnapshotorListener {
        void onError(int i3, long j3, @NonNull TPError tPError);

        void onSuccess(int i3, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    void init(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPSnapshotorListener iTPSnapshotorListener) throws IllegalArgumentException, IllegalStateException, TPLoadLibraryException, UnsupportedOperationException;

    void release();

    int snapshotAsyncAtPosition(long j3, @Nullable TPSnapshotParams tPSnapshotParams) throws IllegalStateException, TPLoadLibraryException, UnsupportedOperationException;

    int snapshotAsyncForPositions(long[] jArr, @Nullable TPSnapshotParams tPSnapshotParams) throws IllegalStateException, TPLoadLibraryException, UnsupportedOperationException;
}
