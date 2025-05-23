package com.tencent.qfsmonet.api.module.singleinput;

import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IMonetGaussianBlurVideoOverlayModule extends IMonetSingleInputModule {
    void setBlurBackgroundSize(int i3, int i16);

    void setBlurRect(float f16, float f17, float f18, float f19);

    void setOverlayRect(float f16, float f17, float f18, float f19);
}
