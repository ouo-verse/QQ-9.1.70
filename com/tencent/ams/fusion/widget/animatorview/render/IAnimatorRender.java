package com.tencent.ams.fusion.widget.animatorview.render;

import com.tencent.ams.fusion.widget.animatorview.IAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAnimatorRender extends IAnimatorView, IFrameRateConfig {
    void postTaskOnRenderThread(Runnable runnable, boolean z16);

    void renderChanged();

    void renderCreate();

    void renderDestroy();
}
