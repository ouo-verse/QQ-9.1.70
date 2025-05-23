package com.tencent.mtt.hippy.views.refresh;

import android.view.View;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.utils.HippyViewUtil;
import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FooterUtil {
    public static void checkFooterBinding(RecyclerViewBase recyclerViewBase, View view) {
        if (view instanceof HippyPullFooterView) {
            ((HippyPullFooterView) view).setRecyclerView(recyclerViewBase);
        }
    }

    public static boolean isFooterView(View view) {
        return HippyViewUtil.getRenderNode(view) instanceof i;
    }

    public static void sendFooterReleasedEvent(HippyPullFooterView hippyPullFooterView) {
        IFooterContainer iFooterContainer;
        int i3;
        if (hippyPullFooterView.getRecyclerView() instanceof IFooterContainer) {
            iFooterContainer = (IFooterContainer) hippyPullFooterView.getRecyclerView();
        } else {
            iFooterContainer = null;
        }
        if (iFooterContainer != null) {
            i3 = iFooterContainer.getFooterState();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            if (iFooterContainer != null) {
                iFooterContainer.setFooterState(1);
            }
            new HippyViewEvent("onFooterReleased").send(hippyPullFooterView, null);
        }
        if (iFooterContainer instanceof HippyWaterfallView) {
            ((HippyWaterfallView) iFooterContainer).startLoadMore();
        }
    }
}
