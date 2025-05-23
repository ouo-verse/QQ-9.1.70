package com.tencent.biz.subscribe.videoplayer;

import android.content.Context;
import android.support.annotation.NonNull;

/* loaded from: classes5.dex */
public class CleanVideoPlayerView extends VideoPlayerView {
    public CleanVideoPlayerView(@NonNull Context context) {
        super(context);
        setOnClickListener(null);
        setCleanMode(true);
    }

    @Override // com.tencent.biz.subscribe.videoplayer.VideoPlayerView, com.tencent.biz.subscribe.framework.BaseVideoView
    public void R() {
        super.R();
    }
}
