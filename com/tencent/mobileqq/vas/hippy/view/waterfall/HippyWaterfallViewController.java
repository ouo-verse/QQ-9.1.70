package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;

/* compiled from: P */
@HippyController(name = "WaterfallView")
/* loaded from: classes20.dex */
public class HippyWaterfallViewController extends HippyViewController<HippyWaterfallView> {
    public static final String CLASS_NAME = "WaterfallView";
    static final String TAG = "WaterfallView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new c(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyWaterfallView(context);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "bannerViewMatch")
    public void setBannerViewMatch(HippyWaterfallView hippyWaterfallView, boolean z16) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setBannerViewMatch(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "containBannerView")
    public void setContainBannerView(HippyWaterfallView hippyWaterfallView, boolean z16) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setContainBannerView(z16);
    }

    @HippyControllerProps(defaultType = "map", name = WaterFallComponentName.PROPERTY_CONTENT_INSET)
    public void setContentInset(HippyWaterfallView hippyWaterfallView, HippyMap hippyMap) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).m(new Rect(ViewUtils.dip2px(hippyMap.getInt("left")), ViewUtils.dip2px(hippyMap.getInt("top")), ViewUtils.dip2px(hippyMap.getInt("right")), ViewUtils.dip2px(hippyMap.getInt("bottom"))));
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "enableLoadingFooter")
    public void setEnableLoadingFooter(HippyWaterfallView hippyWaterfallView, boolean z16) {
        if (z16) {
            hippyWaterfallView.f309535i = true;
            hippyWaterfallView.setLoadingStatus(2, "");
        } else {
            hippyWaterfallView.setLoadingStatus(0, "");
            hippyWaterfallView.f309535i = false;
        }
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "enableOnScrollForReport")
    public void setEnableOnScrollForReport(HippyWaterfallView hippyWaterfallView, boolean z16) {
        hippyWaterfallView.setEnableScrollForReport(z16);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "enableRefresh")
    public void setEnableRefresh(HippyWaterfallView hippyWaterfallView, boolean z16) {
        if (z16 && hippyWaterfallView.f309536m) {
            return;
        }
        hippyWaterfallView.setRefreshEnabled(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "itemGap")
    public void setItemGap(HippyWaterfallView hippyWaterfallView, int i3) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setItemGap(ViewUtils.dip2px(i3));
    }

    @HippyControllerProps(defaultNumber = 2.0d, defaultType = "number", name = WaterFallComponentName.PROPERTY_COLUMNS)
    public void setNumberOfColumns(HippyWaterfallView hippyWaterfallView, int i3) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setColumns(i3);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "enableExposureReport")
    public void setOnExposureReport(HippyWaterfallView hippyWaterfallView, boolean z16) {
        hippyWaterfallView.setEnableExposureReport(z16);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "paddingStartZero")
    public void setPaddingStartZero(HippyWaterfallView hippyWaterfallView, boolean z16) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setPaddingStartZero(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "preloadItemNumber")
    public void setPreloadItemNumber(HippyWaterfallView hippyWaterfallView, int i3) {
        hippyWaterfallView.setPreloadItemNumber(i3);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "preloadPixel")
    public void setPreloadPixel(HippyWaterfallView hippyWaterfallView, int i3) {
        hippyWaterfallView.setPreloadPixel(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyWaterfallView hippyWaterfallView, String str, HippyArray hippyArray) {
        Log.e("WaterfallView", "dispatchFunction " + str + hippyArray.toString());
        super.dispatchFunction((HippyWaterfallViewController) hippyWaterfallView, str, hippyArray);
        str.hashCode();
        int i3 = 4;
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
            case 304763924:
                if (str.equals("endReachedCompleted")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1963419417:
                if (str.equals("callExposureReport")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1972516829:
                if (str.equals("startLoadMore")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                hippyWaterfallView.scrollToContentOffset(hippyArray.getDouble(0), hippyArray.getDouble(1), hippyArray.getBoolean(2));
                return;
            case 1:
                hippyWaterfallView.scrollToIndex(hippyArray.getInt(0), hippyArray.getInt(1), hippyArray.getBoolean(2));
                return;
            case 2:
                int i16 = hippyArray.getInt(0);
                String string = hippyArray.getString(1);
                if (i16 == 0) {
                    i3 = 2;
                } else if (i16 != 1) {
                    i3 = i16 != 2 ? i16 != 3 ? i16 != 4 ? 1 : 0 : 100 : 6;
                }
                hippyWaterfallView.setLoadingStatus(i3, string);
                return;
            case 3:
                hippyWaterfallView.onScrollStateChanged(hippyWaterfallView.getScrollState(), hippyWaterfallView.getScrollState());
                return;
            case 4:
                hippyWaterfallView.startLoadMore();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View getChildAt(HippyWaterfallView hippyWaterfallView, int i3) {
        return ((a) hippyWaterfallView.getAdapter()).getRecyclerItemView(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public int getChildCount(HippyWaterfallView hippyWaterfallView) {
        return ((a) hippyWaterfallView.getAdapter()).getRecyclerItemCount();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onBatchComplete(HippyWaterfallView hippyWaterfallView) {
        Log.d("WaterfallView", "onBatchComplete #" + hippyWaterfallView.getId());
        super.onBatchComplete((HippyWaterfallViewController) hippyWaterfallView);
        hippyWaterfallView.setListData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void addView(ViewGroup viewGroup, View view, int i3) {
    }
}
