package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.list.HippyListView;

@HippyController(isLazyLoad = true, name = HippyPullFooterViewController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyPullFooterViewController extends HippyViewController<HippyPullFooterView> {
    public static final String CLASS_NAME = "PullFooterView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new i(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyPullFooterView(context);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "sticky")
    public void setStickEnabled(HippyPullFooterView hippyPullFooterView, boolean z16) {
        hippyPullFooterView.setStickEnabled(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyPullFooterView hippyPullFooterView, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyPullFooterViewController) hippyPullFooterView, str, hippyArray);
        KeyEvent.Callback recyclerView = hippyPullFooterView.getRecyclerView();
        if (str.equals("collapsePullFooter")) {
            if (recyclerView instanceof HippyRecyclerView) {
                ((HippyRecyclerView) recyclerView).getAdapter().onFooterRefreshCompleted();
            } else if (recyclerView instanceof HippyListView) {
                ((HippyListView) recyclerView).onFooterRefreshFinish();
            } else if (recyclerView instanceof IFooterContainer) {
                ((IFooterContainer) recyclerView).onFooterRefreshFinish();
            }
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyPullFooterView hippyPullFooterView) {
        hippyPullFooterView.onDestroy();
    }
}
