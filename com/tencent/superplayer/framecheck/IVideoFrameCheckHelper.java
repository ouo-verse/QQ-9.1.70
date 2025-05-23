package com.tencent.superplayer.framecheck;

import com.tencent.superplayer.framecheck.FrameComparePipeLine;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IVideoFrameCheckHelper {
    void onFirstFrameRendered();

    void onPlayerRelease();

    void onPlayerReset();

    void onPlayerStart();

    void onPlayerStop();

    void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener onVideoFrameCheckListener);

    void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView);
}
