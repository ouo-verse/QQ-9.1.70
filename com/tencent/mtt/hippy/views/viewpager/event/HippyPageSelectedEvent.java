package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

/* loaded from: classes20.dex */
public class HippyPageSelectedEvent extends HippyViewEvent {
    public static final String EVENT_NAME = "onPageSelected";
    private final View mTarget;

    public HippyPageSelectedEvent(View view) {
        super("onPageSelected");
        this.mTarget = view;
    }

    public void send(int i3) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("position", i3);
        super.send(this.mTarget, hippyMap);
    }
}
