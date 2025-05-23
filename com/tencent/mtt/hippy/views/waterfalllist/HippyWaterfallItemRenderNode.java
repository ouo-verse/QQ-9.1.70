package com.tencent.mtt.hippy.views.waterfalllist;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallItemRenderNode extends RenderNode {
    static final String TAG = "HippyWaterfallItemNode";
    IRecycleItemTypeChange mRecycleItemTypeChangeListener;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface IRecycleItemTypeChange {
        void onRecycleItemTypeChanged(int i3, int i16, HippyWaterfallItemRenderNode hippyWaterfallItemRenderNode);
    }

    public HippyWaterfallItemRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    public int getType() {
        HippyMap props = getProps();
        if (props != null && props.containsKey("type")) {
            return props.getInt("type");
        }
        return -1;
    }

    public void setRecycleItemTypeChangeListener(IRecycleItemTypeChange iRecycleItemTypeChange) {
        this.mRecycleItemTypeChangeListener = iRecycleItemTypeChange;
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public String toString() {
        return "[type:" + getType() + "]" + super.toString();
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public void updateNode(HippyMap hippyMap) {
        int i3 = getProps().getInt("type");
        int i16 = hippyMap.getInt("type");
        IRecycleItemTypeChange iRecycleItemTypeChange = this.mRecycleItemTypeChangeListener;
        if (iRecycleItemTypeChange != null && i3 != i16) {
            iRecycleItemTypeChange.onRecycleItemTypeChanged(i3, i16, this);
        }
        super.updateNode(hippyMap);
    }
}
