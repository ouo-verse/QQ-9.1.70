package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.f;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@HippyController(name = "ListView")
/* loaded from: classes20.dex */
public class HippyListViewController extends HippyViewController<HippyListView> {
    public static final String CLASS_NAME = "ListView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new f(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyListView(context, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void deleteChild(ViewGroup viewGroup, View view, int i3) {
        if (view instanceof RecyclerViewItem) {
            ((RecyclerViewItem) view).removeAllViews();
        }
        if (i3 >= 0 && (viewGroup instanceof HippyListView)) {
            ((HippyListView) viewGroup).getRecycler().updateHolderPositionWhenDelete(i3);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "exposureEventEnabled")
    public void setExposureEventEnable(HippyListView hippyListView, boolean z16) {
        hippyListView.setExposureEventEnable(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "initialContentOffset")
    public void setInitialContentOffset(HippyListView hippyListView, int i3) {
        hippyListView.setInitialContentOffset((int) PixelUtil.dp2px(i3));
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_BEGIN)
    public void setMomentumScrollBeginEventEnable(HippyListView hippyListView, boolean z16) {
        hippyListView.setMomentumScrollBeginEventEnable(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_END)
    public void setMomentumScrollEndEventEnable(HippyListView hippyListView, boolean z16) {
        hippyListView.setMomentumScrollEndEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "overScrollEnabled")
    public void setOverScrollEnabled(HippyListView hippyListView, boolean z16) {
        hippyListView.setOverScrollEnabled(z16);
    }

    @HippyControllerProps(name = "preloadItemNumber")
    public void setPreloadItemNumber(HippyListView hippyListView, int i3) {
        RecyclerViewBase.Adapter adapter = hippyListView.getAdapter();
        if (adapter instanceof HippyListAdapter) {
            ((HippyListAdapter) adapter).setPreloadItemNumber(i3);
        }
    }

    @HippyControllerProps(name = "rowShouldSticky")
    public void setRowShouldSticky(HippyListView hippyListView, boolean z16) {
        hippyListView.setHasSuspentedItem(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_BEGIN_DRAG)
    public void setScrollBeginDragEventEnable(HippyListView hippyListView, boolean z16) {
        hippyListView.setScrollBeginDragEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = ScrollerAttr.SCROLL_ENABLED)
    public void setScrollEnable(HippyListView hippyListView, boolean z16) {
        hippyListView.setScrollEnable(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_END_DRAG)
    public void setScrollEndDragEventEnable(HippyListView hippyListView, boolean z16) {
        hippyListView.setScrollEndDragEventEnable(z16);
    }

    @HippyControllerProps(defaultNumber = PreDownloadConstants.SYS_BUSY_VALUE_FPS, defaultType = "number", name = "scrollEventThrottle")
    public void setscrollEventThrottle(HippyListView hippyListView, int i3) {
        hippyListView.setScrollEventThrottle(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createViewImpl(Context context, HippyMap hippyMap) {
        boolean z16;
        int i3 = 1;
        if (hippyMap != null) {
            i3 = 1 ^ (hippyMap.getBoolean("horizontal") ? 1 : 0);
            z16 = hippyMap.getBoolean(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        } else {
            z16 = false;
        }
        HippyListView hippyListView = new HippyListView(context, i3);
        hippyListView.setOnScrollEventEnable(z16);
        return hippyListView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyListView hippyListView, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyListViewController) hippyListView, str, hippyArray);
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1101593308:
                if (str.equals("scrollToContentOffset")) {
                    c16 = 0;
                    break;
                }
                break;
            case -716578934:
                if (str.equals("scrollToIndex")) {
                    c16 = 1;
                    break;
                }
                break;
            case 2055128589:
                if (str.equals("scrollToTop")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                hippyListView.scrollToContentOffset(hippyArray.getDouble(0), hippyArray.getDouble(1), hippyArray.getBoolean(2), hippyArray.getInt(3));
                return;
            case 1:
                hippyListView.scrollToIndex(hippyArray.getInt(0), hippyArray.getInt(1), hippyArray.getBoolean(2), hippyArray.getInt(3));
                return;
            case 2:
                hippyListView.scrollToTop(null);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View getChildAt(HippyListView hippyListView, int i3) {
        return ((HippyListAdapter) hippyListView.getAdapter()).getRecyclerItemView(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public int getChildCount(HippyListView hippyListView) {
        return ((HippyListAdapter) hippyListView.getAdapter()).getRecyclerItemCount();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onBatchComplete(HippyListView hippyListView) {
        super.onBatchComplete((HippyListViewController) hippyListView);
        hippyListView.setListData();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyListView hippyListView) {
        CopyOnWriteArrayList<RecyclerView.OnListScrollListener> copyOnWriteArrayList;
        super.onViewDestroy((HippyListViewController) hippyListView);
        if (hippyListView == null || (copyOnWriteArrayList = hippyListView.mListScrollListeners) == null) {
            return;
        }
        copyOnWriteArrayList.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void addView(ViewGroup viewGroup, View view, int i3) {
    }
}
