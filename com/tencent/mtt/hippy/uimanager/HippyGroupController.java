package com.tencent.mtt.hippy.uimanager;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class HippyGroupController<T extends ViewGroup & HippyViewBase> extends HippyViewController<T> {
    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_INTERCEPT_PULL_UP_EVENT)
    public void setInterceptPullUp(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, NodeProps.ON_INTERCEPT_PULL_UP_EVENT, z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_INTERCEPT_TOUCH_EVENT)
    public void setInterceptTouch(T t16, boolean z16) {
        if (!handleGestureBySelf()) {
            setGestureType(t16, NodeProps.ON_INTERCEPT_TOUCH_EVENT, z16);
        }
    }
}
