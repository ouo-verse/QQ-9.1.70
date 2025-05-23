package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

/* loaded from: classes20.dex */
public class HippyPageScrollStateChangedEvent extends HippyViewEvent {
    public static final String EVENT_NAME = "onPageScrollStateChanged";
    private final View mTarget;

    public HippyPageScrollStateChangedEvent(View view) {
        super("onPageScrollStateChanged");
        this.mTarget = view;
    }

    public void send(String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("pageScrollState", str);
        super.send(this.mTarget, hippyMap);
    }
}
