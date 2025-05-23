package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.j;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.list.HippyListView;

@HippyController(isLazyLoad = true, name = HippyPullHeaderViewController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyPullHeaderViewController extends HippyViewController<HippyPullHeaderView> {
    public static final String CLASS_NAME = "PullHeaderView";
    public static final String COLLAPSE_PULL_HEADER = "collapsePullHeader";
    public static final String COLLAPSE_PULL_HEADER_WITH_OPTIONS = "collapsePullHeaderWithOptions";
    public static final String EXPAND_PULL_HEADER = "expandPullHeader";
    private static final String TAG = "HippyPullHeaderViewController";

    private void execListViewFunction(final HippyListView hippyListView, String str, HippyArray hippyArray) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2068662420:
                if (str.equals(EXPAND_PULL_HEADER)) {
                    c16 = 0;
                    break;
                }
                break;
            case -259784513:
                if (str.equals(COLLAPSE_PULL_HEADER)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1503276217:
                if (str.equals(COLLAPSE_PULL_HEADER_WITH_OPTIONS)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                hippyListView.onHeaderRefresh();
                return;
            case 1:
                break;
            case 2:
                HippyMap map = hippyArray.getMap(0);
                if (map == null) {
                    return;
                }
                int i3 = map.getInt("time");
                if (i3 > 0) {
                    hippyListView.postDelayed(new Runnable() { // from class: com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hippyListView.onHeaderRefreshFinish();
                        }
                    }, i3);
                    return;
                }
                break;
            default:
                LogUtils.w(TAG, "Unknown function name: " + str);
                return;
        }
        hippyListView.onHeaderRefreshFinish();
    }

    private void execRecyclerViewFunction(HippyRecyclerView hippyRecyclerView, String str, HippyArray hippyArray) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2068662420:
                if (str.equals(EXPAND_PULL_HEADER)) {
                    c16 = 0;
                    break;
                }
                break;
            case -259784513:
                if (str.equals(COLLAPSE_PULL_HEADER)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1503276217:
                if (str.equals(COLLAPSE_PULL_HEADER_WITH_OPTIONS)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                hippyRecyclerView.getAdapter().enableHeaderRefresh();
                return;
            case 1:
                hippyRecyclerView.getAdapter().onHeaderRefreshCompleted();
                return;
            case 2:
                HippyMap map = hippyArray.getMap(0);
                if (map == null) {
                    return;
                }
                int i3 = map.getInt("time");
                final HippyRecyclerListAdapter adapter = hippyRecyclerView.getAdapter();
                if (adapter == null) {
                    return;
                }
                if (i3 > 0) {
                    hippyRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController.2
                        @Override // java.lang.Runnable
                        public void run() {
                            adapter.onHeaderRefreshCompleted();
                        }
                    }, i3);
                    return;
                } else {
                    adapter.onHeaderRefreshCompleted();
                    return;
                }
            default:
                LogUtils.w(TAG, "Unknown function name: " + str);
                return;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new j(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyPullHeaderView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyPullHeaderView hippyPullHeaderView, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyPullHeaderViewController) hippyPullHeaderView, str, hippyArray);
        View recyclerView = hippyPullHeaderView.getRecyclerView();
        if (recyclerView instanceof HippyListView) {
            execListViewFunction((HippyListView) recyclerView, str, hippyArray);
        } else if (recyclerView instanceof HippyRecyclerView) {
            execRecyclerViewFunction((HippyRecyclerView) recyclerView, str, hippyArray);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyPullHeaderView hippyPullHeaderView) {
        hippyPullHeaderView.onDestroy();
    }
}
