package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k extends ListItemRenderNode {
    public k(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.ListItemRenderNode, com.tencent.mtt.hippy.uimanager.RenderNode
    public void updateLayout(int i3, int i16, int i17, int i18) {
        int i19;
        View a16 = this.mComponentManager.f337640b.a(this.mId);
        if (a16 != null) {
            i19 = a16.getTop();
        } else {
            i19 = 0;
        }
        super.updateLayout(i3, i19, i17, i18);
        this.mY = i19;
    }
}
