package com.tencent.mobileqq.vas.hippy.view.waterfall;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends RenderNode {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public b(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        super(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    public int getType() {
        HippyMap props = getProps();
        if (props != null && props.containsKey("type")) {
            return props.getInt("type");
        }
        return -1;
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    @NotNull
    public String toString() {
        return "[type:" + getType() + "]" + super.toString();
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public void updateLayout(int i3, int i16, int i17, int i18) {
        super.updateLayout(i3, 0, i17, i18);
    }

    @Override // com.tencent.mtt.hippy.uimanager.RenderNode
    public void updateNode(HippyMap hippyMap) {
        getProps().getInt("type");
        hippyMap.getInt("type");
        super.updateNode(hippyMap);
    }

    public void a(a aVar) {
    }
}
