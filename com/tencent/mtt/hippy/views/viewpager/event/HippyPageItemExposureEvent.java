package com.tencent.mtt.hippy.views.viewpager.event;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

/* loaded from: classes20.dex */
public class HippyPageItemExposureEvent extends HippyViewEvent {
    public static final String EVENT_PAGER_ITEM_DID_APPEAR = "onDidAppear";
    public static final String EVENT_PAGER_ITEM_DID_DISAPPEAR = "onDidDisAppear";
    public static final String EVENT_PAGER_ITEM_WILL_APPEAR = "onWillAppear";
    public static final String EVENT_PAGER_ITEM_WILL_DISAPPEAR = "onWillDisAppear";

    public HippyPageItemExposureEvent(String str) {
        super(str);
    }

    public void send(View view, int i3) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("position", i3);
        super.send(view, hippyMap);
    }
}
