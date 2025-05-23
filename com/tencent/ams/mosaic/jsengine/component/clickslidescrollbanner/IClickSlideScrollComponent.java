package com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface IClickSlideScrollComponent extends GestureComponent {
    void setBackgroundHighLightColor(String str);

    void setHideClickSlideGuideAnim(boolean z16);

    void setInteractionType(int i3);

    void setScrollAroundAngle(int i3);

    void setScrollBannerBottomMargin(float f16);

    void setScrollBannerHeight(float f16);

    void setScrollBannerLeftMargin(float f16);

    void setScrollBannerRightMargin(float f16);

    void setScrollBarRightGuideType(int i3);

    void setScrollIconBase64(String str);

    void setScrollIconUrl(String str);

    void setScrollListener(JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3);

    void setScrollTotalTime(int i3);

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    @Deprecated
    void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2);

    void setSubTitle(String str);

    void setTitle(String str);

    void setTriggerAngle(int i3);

    void start();

    void stop();
}
