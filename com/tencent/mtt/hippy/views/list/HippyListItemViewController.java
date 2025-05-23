package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderNode;

/* compiled from: P */
@HippyController(isLazyLoad = true, name = "ListViewItem")
/* loaded from: classes20.dex */
public class HippyListItemViewController extends HippyViewController<HippyListItemView> {
    public static final String CLASS_NAME = "ListViewItem";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new ListItemRenderNode(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyListItemView(context);
    }
}
