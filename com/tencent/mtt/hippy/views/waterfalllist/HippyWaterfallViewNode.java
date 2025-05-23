package com.tencent.mtt.hippy.views.waterfalllist;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallViewNode extends RenderNode {
    static final String TAG = "HippyWaterfallViewNode";

    public HippyWaterfallViewNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public boolean removeChild(RenderNode renderNode) {
        if (renderNode instanceof HippyWaterfallItemRenderNode) {
            ((HippyWaterfallItemRenderNode) renderNode).setRecycleItemTypeChangeListener(null);
        }
        return super.removeChild(renderNode);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    protected void addChildToPendingList(RenderNode renderNode) {
    }
}
