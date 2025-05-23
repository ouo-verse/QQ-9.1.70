package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import android.view.TextureView;
import com.tencent.superplayer.framecheck.FrameComparePipeLine;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoFrameCheckHelper implements IVideoFrameCheckHelper, IFrameCaptureTaskRunner {
    private static final String TAG = "VideoFrameCheckHelper";
    private VideoFrameCaptureTask mFirstFrameCaptureTask;
    private FrameComparePipeLine.OnVideoFrameCheckListener mOnVideoFrameCheckListener;
    private FrameComparePipeLine mPipeLine = new FrameComparePipeLine();
    private TextureView mTextureView;

    private void stopTaskWhenTextureViewNotAvailable() {
        FrameComparePipeLine.OnVideoFrameCheckListener onVideoFrameCheckListener = this.mOnVideoFrameCheckListener;
        if (onVideoFrameCheckListener != null) {
            TextureView textureView = this.mTextureView;
            if (textureView == null) {
                onVideoFrameCheckListener.onVideoFrameCheckResult(4);
            } else if (!textureView.isAvailable()) {
                this.mOnVideoFrameCheckListener.onVideoFrameCheckResult(5);
            }
        }
        this.mPipeLine.stop();
    }

    @Override // com.tencent.superplayer.framecheck.IFrameCaptureTaskRunner
    public Bitmap doCapture(int i3, int i16) {
        TextureView textureView = this.mTextureView;
        if (textureView != null && textureView.isAvailable()) {
            if (i3 == 0 && i16 == 0) {
                return this.mTextureView.getBitmap();
            }
            return this.mTextureView.getBitmap(i3, i16);
        }
        stopTaskWhenTextureViewNotAvailable();
        return null;
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onFirstFrameRendered() {
        FirstFrameCaptureTask firstFrameCaptureTask = new FirstFrameCaptureTask(this);
        this.mFirstFrameCaptureTask = firstFrameCaptureTask;
        this.mPipeLine.addTask(firstFrameCaptureTask);
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerRelease() {
        this.mPipeLine.release();
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerReset() {
        onPlayerStop();
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerStart() {
        TextureView textureView = this.mTextureView;
        if (textureView == null) {
            LogUtil.e(TAG, "onPlayerStart but mTextureView is null");
        } else if (!textureView.isAvailable()) {
            LogUtil.e(TAG, "onPlayerStart but mTextureView is not available");
        }
        this.mPipeLine.addTask(new VideoFrameCaptureTask(this));
        this.mPipeLine.addTask(new VideoFrameCaptureTask(this, true));
        this.mPipeLine.start();
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerStop() {
        this.mPipeLine.reset();
        this.mPipeLine.stop();
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener onVideoFrameCheckListener) {
        this.mOnVideoFrameCheckListener = onVideoFrameCheckListener;
        this.mPipeLine.setOnVideoFrameCheckListener(onVideoFrameCheckListener);
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        if (iSPlayerVideoView == null) {
            this.mTextureView = null;
            LogUtil.e(TAG, "updatePlayerVideoView to null.");
        } else if (iSPlayerVideoView.getRenderView() instanceof TextureView) {
            this.mTextureView = (TextureView) iSPlayerVideoView.getRenderView();
        } else {
            LogUtil.w(TAG, "getTextureView failed...");
        }
    }
}
