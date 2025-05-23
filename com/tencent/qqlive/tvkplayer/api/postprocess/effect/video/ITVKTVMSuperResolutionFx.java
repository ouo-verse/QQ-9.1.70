package com.tencent.qqlive.tvkplayer.api.postprocess.effect.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKTVMSuperResolutionFx extends ITVKSuperResolutionFx {
    public static final int SEPARATE_MODE_CENTER_TO_EDGE = 1;
    public static final int SEPARATE_MODE_LEFT_TO_RIGHT = 2;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TVKSeparateMode {
    }

    boolean loadSRModelWithVideoSize(int i3, int i16);

    void setSeparateMode(int i3);

    void setSeparateRatio(float f16);

    void showSeparateLine(boolean z16);
}
