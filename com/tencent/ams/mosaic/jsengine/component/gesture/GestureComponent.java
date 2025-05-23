package com.tencent.ams.mosaic.jsengine.component.gesture;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface GestureComponent {
    void setGestureClickHotArea(int i3, int i16, int i17, int i18);

    void setGestureColor(String str);

    void setGestureSlideHotArea(int i3, int i16, int i17, int i18);

    void setGestureSlideValidHeight(int i3);

    void setGestureStrokeWidth(int i3);

    void setGestureVisible(boolean z16);

    void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2);
}
