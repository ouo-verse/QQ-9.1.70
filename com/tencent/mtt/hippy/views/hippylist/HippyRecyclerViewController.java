package com.tencent.mtt.hippy.views.hippylist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.HippyLinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.f;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;

/* compiled from: P */
@HippyController(name = "ListView", names = {"RecyclerView"})
/* loaded from: classes20.dex */
public class HippyRecyclerViewController<HRW extends HippyRecyclerViewWrapper> extends HippyViewController<HRW> {
    public static final String CLASS_NAME = "ListView";
    public static final String EXTRA_CLASS_NAME = "RecyclerView";
    public static final String HORIZONTAL = "horizontal";
    public static final String SCROLL_TO_CONTENT_OFFSET = "scrollToContentOffset";
    public static final String SCROLL_TO_INDEX = "scrollToIndex";
    public static final String SCROLL_TO_TOP = "scrollToTop";

    private HippyRecyclerListAdapter getAdapter(HRW hrw) {
        return hrw.getRecyclerView().getAdapter();
    }

    public static HippyRecyclerView initDefault(Context context, HippyMap hippyMap, HippyRecyclerView hippyRecyclerView) {
        HippyLinearLayoutManager hippyLinearLayoutManager = new HippyLinearLayoutManager(context);
        hippyRecyclerView.setItemAnimator(null);
        boolean z16 = false;
        if (hippyMap != null) {
            if (hippyMap.containsKey("horizontal")) {
                hippyLinearLayoutManager.setOrientation(0);
            }
            z16 = hippyMap.getBoolean(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        }
        hippyRecyclerView.setLayoutManager(hippyLinearLayoutManager);
        hippyRecyclerView.setHippyEngineContext(((HippyInstanceContext) context).getEngineContext());
        hippyRecyclerView.initRecyclerView();
        hippyRecyclerView.getRecyclerViewEventHelper().setOnScrollEventEnable(z16);
        return hippyRecyclerView;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new f(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return createViewImpl(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void deleteChild(ViewGroup viewGroup, View view) {
        super.deleteChild(viewGroup, view);
        ((HippyRecyclerViewWrapper) viewGroup).getRecyclerView().disableRecycle(view);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.OVER_PULL)
    public void setBounces(HRW hrw, boolean z16) {
        HippyRecyclerView recyclerView = hrw.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setEnableOverPull(z16);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "exposureEventEnabled")
    public void setExposureEventEnable(HRW hrw, boolean z16) {
        hrw.getRecyclerViewEventHelper().setExposureEventEnable(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "horizontal")
    public void setHorizontalEnable(HRW hrw, boolean z16) {
        int i3;
        RecyclerView.LayoutManager layoutManager = hrw.getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int orientation = linearLayoutManager.getOrientation();
        if (z16) {
            if (orientation != 0) {
                i3 = 0;
            } else {
                return;
            }
        } else if (orientation == 0) {
            i3 = 1;
        } else {
            return;
        }
        linearLayoutManager.setOrientation(i3);
        hrw.getRecyclerView().getAdapter().onLayoutOrientationChanged();
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "initialContentOffset")
    public void setInitialContentOffset(HRW hrw, int i3) {
        hrw.getRecyclerView().setInitialContentOffset((int) PixelUtil.dp2px(i3));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "itemViewCacheSize")
    public void setItemViewCacheSize(HRW hrw, int i3) {
        hrw.getRecyclerView().setItemViewCacheSize(Math.max(i3, 2));
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_BEGIN)
    public void setMomentumScrollBeginEventEnable(HRW hrw, boolean z16) {
        hrw.getRecyclerViewEventHelper().setMomentumScrollBeginEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_END)
    public void setMomentumScrollEndEventEnable(HRW hrw, boolean z16) {
        hrw.getRecyclerViewEventHelper().setMomentumScrollEndEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "onScrollEnable")
    public void setOnScrollEventEnable(HRW hrw, boolean z16) {
        hrw.getRecyclerViewEventHelper().setOnScrollEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "overScrollEnabled")
    public void setOverScrollEnable(HRW hrw, boolean z16) {
        int i3;
        HippyRecyclerView recyclerView = hrw.getRecyclerView();
        if (recyclerView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            recyclerView.setOverScrollMode(i3);
        }
        setBounces(hrw, z16);
    }

    @HippyControllerProps(name = "preloadItemNumber")
    public void setPreloadItemNumber(HRW hrw, int i3) {
        hrw.getRecyclerViewEventHelper().setPreloadItemNumber(i3);
    }

    @HippyControllerProps(name = "rowShouldSticky")
    public void setRowShouldSticky(HRW hrw, boolean z16) {
        hrw.setRowShouldSticky(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_BEGIN_DRAG)
    public void setScrollBeginDragEventEnable(HRW hrw, boolean z16) {
        hrw.getRecyclerViewEventHelper().setScrollBeginDragEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = ScrollerAttr.SCROLL_ENABLED)
    public void setScrollEnable(HRW hrw, boolean z16) {
        hrw.setScrollEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_END_DRAG)
    public void setScrollEndDragEventEnable(HRW hrw, boolean z16) {
        hrw.getRecyclerViewEventHelper().setScrollEndDragEventEnable(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "suspendViewListener")
    public void setSuspendViewListener(HRW hrw, int i3) {
        HippyRecyclerView recyclerView = hrw.getRecyclerView();
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        recyclerView.enableStickEvent(z16);
    }

    @HippyControllerProps(defaultNumber = PreDownloadConstants.SYS_BUSY_VALUE_FPS, defaultType = "number", name = "scrollEventThrottle")
    public void setscrollEventThrottle(HRW hrw, int i3) {
        hrw.getRecyclerViewEventHelper().setScrollEventThrottle(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyRecyclerView initDefault = initDefault(context, hippyMap, new HippyRecyclerView(context));
        initDefault.setEnableOverPull(HippyListUtils.isVerticalLayout(initDefault) && (hippyMap != null && hippyMap.getBoolean(NodeProps.OVER_PULL)));
        return new HippyRecyclerViewWrapper(context, initDefault);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HRW hrw, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyRecyclerViewController<HRW>) hrw, str, hippyArray);
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
                hrw.scrollToContentOffset(hippyArray.getDouble(0), hippyArray.getDouble(1), hippyArray.getBoolean(2), hippyArray.getInt(3));
                return;
            case 1:
                hrw.scrollToIndex(hippyArray.getInt(0), hippyArray.getInt(1), hippyArray.getBoolean(2), hippyArray.getInt(3));
                return;
            case 2:
                hrw.scrollToTop();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View getChildAt(HRW hrw, int i3) {
        return hrw.getChildAtWithCaches(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public int getChildCount(HRW hrw) {
        return hrw.getChildCountWithCaches();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HRW hrw) {
        super.onAfterUpdateProps((HippyRecyclerViewController<HRW>) hrw);
        hrw.getRecyclerView().onAfterUpdateProps();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onBatchComplete(HRW hrw) {
        super.onBatchComplete((HippyRecyclerViewController<HRW>) hrw);
        hrw.onBatchComplete();
        hrw.setListData();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onBatchStart(HRW hrw) {
        super.onBatchStart((HippyRecyclerViewController<HRW>) hrw);
        hrw.onBatchStart();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HRW hrw) {
        hrw.getRecyclerView().onDestroy();
    }
}
