package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.StickViewListener;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ViewStickEventHelper implements StickViewListener {
    public static final String IS_SHOW = "isShow";
    public static final String ON_VIEW_SUSPEND_LISTENER = "onViewSuspendListener";
    private View view;

    public ViewStickEventHelper(View view) {
        this.view = view;
    }

    private void notifyStickEvent(boolean z16) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean(IS_SHOW, z16);
        new HippyViewEvent(ON_VIEW_SUSPEND_LISTENER).send(this.view, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.StickViewListener
    public void onStickAttached(int i3) {
        notifyStickEvent(true);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.StickViewListener
    public void onStickDetached(int i3) {
        notifyStickEvent(false);
    }
}
