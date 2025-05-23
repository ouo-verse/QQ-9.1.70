package com.tencent.superplayer.framecheck;

import com.tencent.superplayer.framecheck.FrameComparePipeLine;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EmptyVideoFrameCheckHelper implements IVideoFrameCheckHelper {
    private static EmptyVideoFrameCheckHelper mInstance;

    EmptyVideoFrameCheckHelper() {
    }

    public static EmptyVideoFrameCheckHelper getInstance() {
        if (mInstance == null) {
            mInstance = new EmptyVideoFrameCheckHelper();
        }
        return mInstance;
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onFirstFrameRendered() {
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerRelease() {
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerReset() {
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerStart() {
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void onPlayerStop() {
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener onVideoFrameCheckListener) {
    }

    @Override // com.tencent.superplayer.framecheck.IVideoFrameCheckHelper
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
    }
}
