package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.graphics.SurfaceTexture;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes12.dex */
public interface IFilterProcessService extends IBaseService {
    SurfaceTexture initFilterProcess();

    void onDraw();

    void update();
}
