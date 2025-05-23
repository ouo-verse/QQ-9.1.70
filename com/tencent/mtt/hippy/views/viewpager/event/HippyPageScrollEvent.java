package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

/* loaded from: classes20.dex */
public class HippyPageScrollEvent extends HippyViewEvent {
    public static final String EVENT_NAME = "onPageScroll";
    private final View mTarget;

    public HippyPageScrollEvent(View view) {
        super(EVENT_NAME);
        this.mTarget = view;
    }

    public void send(int i3, float f16) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("position", i3);
        hippyMap.pushDouble("offset", f16);
        super.send(this.mTarget, hippyMap);
    }
}
