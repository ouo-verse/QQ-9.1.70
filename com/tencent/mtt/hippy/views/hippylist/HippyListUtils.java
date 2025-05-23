package com.tencent.mtt.hippy.views.hippylist;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.f;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyListUtils {
    HippyListUtils() {
    }

    public static boolean isHorizontalLayout(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return layoutManager.canScrollHorizontally();
        }
        return false;
    }

    public static boolean isLinearLayout(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager() instanceof LinearLayoutManager;
    }

    public static boolean isVerticalLayout(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return layoutManager.canScrollVertically();
        }
        return false;
    }

    public static void setListItemNodeLazy(RenderNode renderNode) {
        for (int i3 = 0; i3 < renderNode.getChildCount(); i3++) {
            RenderNode childAt = renderNode.getChildAt(i3);
            if (childAt instanceof ListItemRenderNode) {
                childAt.setLazy(true);
            } else {
                setListItemNodeLazy(childAt);
            }
        }
    }

    public static void updateListView(HippyEngineContext hippyEngineContext, RenderNode renderNode) {
        for (int i3 = 0; i3 < renderNode.getChildCount(); i3++) {
            RenderNode childAt = renderNode.getChildAt(i3);
            if (childAt instanceof f) {
                hippyEngineContext.getRenderManager().getControllerManager().a(childAt.getClassName(), childAt.getId());
                return;
            }
            updateListView(hippyEngineContext, childAt);
        }
    }
}
