package com.qq.e.comm.pi;

import android.view.View;
import com.qq.e.tg.TangramAlphaVideoPlayInfo;

/* loaded from: classes3.dex */
public interface TangramAlphaVideoPlayer extends TangramWidget {
    View getVideoView();

    void setPlayInfo(TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo);

    void setPlayListener(TangramAlphaVideoPlayListener tangramAlphaVideoPlayListener);

    void start();

    void stop();
}
