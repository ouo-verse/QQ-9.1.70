package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f extends RenderNode {
    public f(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public boolean removeChild(RenderNode renderNode) {
        if (renderNode instanceof ListItemRenderNode) {
            ((ListItemRenderNode) renderNode).a((IRecycleItemTypeChange) null);
        }
        return super.removeChild(renderNode);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    protected void addChildToPendingList(RenderNode renderNode) {
    }
}
