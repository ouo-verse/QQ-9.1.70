package com.tencent.mobileqq.vas.hippy.view.waterfall;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends RenderNode {
    public c(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public void remove(int i3) {
        super.remove(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public boolean removeChild(RenderNode renderNode) {
        if (renderNode instanceof b) {
            ((b) renderNode).a(null);
        }
        return super.removeChild(renderNode);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    protected void addChildToPendingList(RenderNode renderNode) {
    }
}
