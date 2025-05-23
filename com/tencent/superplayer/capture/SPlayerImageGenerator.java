package com.tencent.superplayer.capture;

import androidx.annotation.NonNull;
import com.tencent.superplayer.api.ISPlayerImageGenerator;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.snapshot.ITPSnapshotor;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotorFactory;

/* loaded from: classes26.dex */
public class SPlayerImageGenerator implements ISPlayerImageGenerator {
    private static final String TAG = "SPlayerImageGenerator";
    private ITPSnapshotor mTPThumbCapture = TPSnapshotorFactory.createSnapshotor();
    private final String mUrl;

    public SPlayerImageGenerator(String str) {
        this.mUrl = str;
    }

    @Override // com.tencent.superplayer.api.ISPlayerImageGenerator
    public void generateImageAsyncAtTime(long j3, ISPlayerImageGenerator.ImageGeneratorParams imageGeneratorParams, final ISPlayerImageGenerator.Listener listener) {
        try {
            this.mTPThumbCapture.init(TPMediaAssetFactory.createUrlMediaAsset(this.mUrl), new ITPSnapshotor.ITPSnapshotorListener() { // from class: com.tencent.superplayer.capture.SPlayerImageGenerator.1
                @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
                public void onError(int i3, long j16, @NonNull TPError tPError) {
                    ISPlayerImageGenerator.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onCaptureVideoFailed(tPError.getErrorCode());
                    }
                }

                @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
                public void onSuccess(int i3, long j16, long j17, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
                    ISPlayerImageGenerator.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onCaptureVideoSuccess(tPVideoFrameBuffer.toBitmap());
                    }
                }
            });
            if (this.mTPThumbCapture == null) {
                LogUtil.e(TAG, "capture must init player first");
                return;
            }
            TPSnapshotParams tPSnapshotParams = new TPSnapshotParams();
            tPSnapshotParams.setWidth(imageGeneratorParams.width);
            tPSnapshotParams.setHeight(imageGeneratorParams.height);
            tPSnapshotParams.setRequestedPositionMsToleranceAfter(imageGeneratorParams.requestedTimeMsToleranceAfter);
            tPSnapshotParams.setRequestedPositionMsToleranceBefore(imageGeneratorParams.requestedTimeMsToleranceBefore);
            tPSnapshotParams.setPixelFormat(37);
            this.mTPThumbCapture.snapshotAsyncAtPosition(j3, tPSnapshotParams);
        } catch (Exception e16) {
            LogUtil.e(TAG, e16);
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerImageGenerator
    public void release() {
        this.mTPThumbCapture.release();
        this.mTPThumbCapture = null;
    }
}
