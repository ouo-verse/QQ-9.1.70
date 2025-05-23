package com.tencent.ams.mosaic.jsengine.component.clickshakebanner;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ClickSlideShakeComponent extends Component {
    void setBannerBackgroundColor(String str);

    void setBannerBottomPadding(int i3);

    void setBannerIconData(String str);

    void setOnBannerClickListener(JSFunction jSFunction);

    void setOnShakeCompleteListener(JSFunction jSFunction);

    void setOnShakingListener(JSFunction jSFunction);

    void setShakeDirectCombine(int[] iArr);

    void setShakeFactor(float f16, float f17, float f18);

    void setShakeSampleRate(int i3);

    void setShakeTimeDuration(int i3);

    void setShakeValue(float f16, int i3);

    void setSubTitle(String str);

    void setTitle(String str);

    void start();

    void stop();
}
