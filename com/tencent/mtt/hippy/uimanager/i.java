package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i extends ListItemRenderNode {
    public i(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.ListItemRenderNode
    public int a() {
        return getClassName().hashCode();
    }

    @Override // com.tencent.mtt.hippy.uimanager.ListItemRenderNode
    public boolean b() {
        return true;
    }

    @Override // com.tencent.mtt.hippy.uimanager.ListItemRenderNode
    public boolean shouldSticky() {
        return false;
    }
}
