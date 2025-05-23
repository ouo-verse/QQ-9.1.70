package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.tg.cfg.VideoOption;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NEADI {
    void loadAd(int i3);

    void loadAd(int i3, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i3);

    void setMinVideoDuration(int i3);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i3);
}
