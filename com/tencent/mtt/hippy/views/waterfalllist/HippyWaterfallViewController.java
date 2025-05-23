package com.tencent.mtt.hippy.views.waterfalllist;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView;

/* compiled from: P */
@HippyController(name = "WaterfallView", names = {WaterFallComponentName.CONTAINER_ALIAS})
/* loaded from: classes20.dex */
public class HippyWaterfallViewController extends HippyViewController<HippyWaterfallView> {
    static final String TAG = "WaterfallView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new HippyWaterfallViewNode(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyWaterfallView(context);
    }

    protected int dpToPx(int i3) {
        return (int) PixelUtil.dp2px(i3);
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "bannerViewMatch")
    public void setBannerViewMatch(HippyWaterfallView hippyWaterfallView, boolean z16) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setBannerViewMatch(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = WaterFallComponentName.PROPERTY_COLUMN_SPACING)
    public void setColumnSpacing(HippyWaterfallView hippyWaterfallView, int i3) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setColumnSpacing(dpToPx(i3));
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "containBannerView")
    public void setContainBannerView(HippyWaterfallView hippyWaterfallView, boolean z16) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setContainBannerView(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = WaterFallComponentName.PROPERTY_CONTENT_INSET)
    public void setContentInset(HippyWaterfallView hippyWaterfallView, HippyMap hippyMap) {
        hippyWaterfallView.setPadding(dpToPx(hippyMap.getInt("left")), dpToPx(hippyMap.getInt("top")), dpToPx(hippyMap.getInt("right")), dpToPx(hippyMap.getInt("bottom")));
    }

    @HippyControllerProps(name = "enableLoadingFooter")
    public void setEnableLoadingFooter(HippyWaterfallView hippyWaterfallView, boolean z16) {
        if (z16) {
            hippyWaterfallView.mEnableFooter = true;
            hippyWaterfallView.setLoadingStatus(2, "");
        } else {
            hippyWaterfallView.setLoadingStatus(0, "");
            hippyWaterfallView.mEnableFooter = false;
        }
    }

    @HippyControllerProps(name = "enableOnScrollForReport")
    public void setEnableOnScrollForReport(HippyWaterfallView hippyWaterfallView, boolean z16) {
        hippyWaterfallView.setEnableScrollForReport(z16);
    }

    @HippyControllerProps(name = "enableRefresh")
    public void setEnableRefresh(HippyWaterfallView hippyWaterfallView, boolean z16) {
        if (z16 && hippyWaterfallView.mEnableRefresh) {
            return;
        }
        hippyWaterfallView.setRefreshEnabled(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = WaterFallComponentName.PROPERTY_ITEM_SPACING)
    public void setItemSpacing(HippyWaterfallView hippyWaterfallView, int i3) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setItemGap(dpToPx(i3));
    }

    @HippyControllerProps(defaultNumber = 2.0d, defaultType = "number", name = WaterFallComponentName.PROPERTY_COLUMNS)
    public void setNumberOfColumns(HippyWaterfallView hippyWaterfallView, int i3) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setColumns(i3);
    }

    @HippyControllerProps(name = "enableExposureReport")
    public void setOnExposureReport(HippyWaterfallView hippyWaterfallView, boolean z16) {
        hippyWaterfallView.setEnableExposureReport(z16);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "paddingStartZero")
    public void setPaddingStartZero(HippyWaterfallView hippyWaterfallView, boolean z16) {
        ((HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager()).setPaddingStartZero(z16);
    }

    @HippyControllerProps(name = "preloadItemNumber")
    public void setPreloadItemNumber(HippyWaterfallView hippyWaterfallView, int i3) {
        hippyWaterfallView.setPreloadItemNumber(i3);
    }

    @HippyControllerProps(name = "refreshColor")
    public void setRefreshColor(HippyWaterfallView hippyWaterfallView, int i3) {
        hippyWaterfallView.setCustomRefreshColor(i3, 0, 0);
    }

    @HippyControllerProps(name = "refreshColors")
    public void setRefreshColors(HippyWaterfallView hippyWaterfallView, HippyArray hippyArray) {
        hippyWaterfallView.setRefreshColors(hippyArray);
    }

    @HippyControllerProps(defaultNumber = PreDownloadConstants.SYS_BUSY_VALUE_FPS, defaultType = "number", name = "scrollEventThrottle")
    public void setScrollEventThrottle(HippyWaterfallView hippyWaterfallView, int i3) {
        hippyWaterfallView.setScrollEventThrottle(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyWaterfallView hippyWaterfallView, String str, HippyArray hippyArray) {
        Log.e("WaterfallView", "dispatchFunction " + str + hippyArray.toString());
        super.dispatchFunction((HippyWaterfallViewController) hippyWaterfallView, str, hippyArray);
        str.hashCode();
        int i3 = 6;
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1194184615:
                if (str.equals("startRefreshWithType")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1101593308:
                if (str.equals("scrollToContentOffset")) {
                    c16 = 1;
                    break;
                }
                break;
            case -716578934:
                if (str.equals("scrollToIndex")) {
                    c16 = 2;
                    break;
                }
                break;
            case 304763924:
                if (str.equals("endReachedCompleted")) {
                    c16 = 3;
                    break;
                }
                break;
            case 950998041:
                if (str.equals("startRefresh")) {
                    c16 = 4;
                    break;
                }
                break;
            case 978210091:
                if (str.equals("setRefreshPromptInfo")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1756924336:
                if (str.equals("refreshCompleted")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1963419417:
                if (str.equals("callExposureReport")) {
                    c16 = 7;
                    break;
                }
                break;
            case 1972516829:
                if (str.equals("startLoadMore")) {
                    c16 = '\b';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                hippyWaterfallView.startRefresh(hippyArray.getInt(0));
                return;
            case 1:
                hippyWaterfallView.scrollToContentOffset(hippyArray.getDouble(0), hippyArray.getDouble(1), hippyArray.getBoolean(2));
                return;
            case 2:
                hippyWaterfallView.scrollToIndex(hippyArray.getInt(0), hippyArray.getInt(1), hippyArray.getBoolean(2));
                return;
            case 3:
                int i16 = hippyArray.getInt(0);
                String string = hippyArray.getString(1);
                if (i16 == 0) {
                    i3 = 2;
                } else if (i16 == 1) {
                    i3 = 4;
                } else if (i16 != 2) {
                    i3 = i16 != 3 ? i16 != 4 ? 1 : 0 : 100;
                }
                hippyWaterfallView.setLoadingStatus(i3, string);
                return;
            case 4:
                Log.e("leo", "startRefresh");
                return;
            case 5:
                hippyWaterfallView.setRefreshPromptInfo(hippyArray.getString(0), hippyArray.getInt(1), hippyArray.getInt(2), hippyArray.getString(3), hippyArray.getInt(4), hippyArray.getInt(5));
                return;
            case 6:
                handleRefreshCompleted(hippyWaterfallView, hippyArray);
                return;
            case 7:
                hippyWaterfallView.onScrollStateChanged(hippyWaterfallView.getScrollState(), hippyWaterfallView.getScrollState());
                return;
            case '\b':
                hippyWaterfallView.startLoadMore();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View getChildAt(HippyWaterfallView hippyWaterfallView, int i3) {
        return ((HippyWaterfallView.HippyWaterfallAdapter) hippyWaterfallView.getAdapter()).getRecyclerItemView(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public int getChildCount(HippyWaterfallView hippyWaterfallView) {
        return ((HippyWaterfallView.HippyWaterfallAdapter) hippyWaterfallView.getAdapter()).getRecyclerItemCount();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onBatchComplete(HippyWaterfallView hippyWaterfallView) {
        Log.d("WaterfallView", "onBatchComplete #" + hippyWaterfallView.getId());
        super.onBatchComplete((HippyWaterfallViewController) hippyWaterfallView);
        hippyWaterfallView.setListData();
    }

    private void handleRefreshCompleted(HippyWaterfallView hippyWaterfallView, HippyArray hippyArray) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void addView(ViewGroup viewGroup, View view, int i3) {
    }
}
