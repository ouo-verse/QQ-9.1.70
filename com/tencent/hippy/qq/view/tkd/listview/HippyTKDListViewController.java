package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListViewController;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
@HippyController(name = "ListView")
/* loaded from: classes7.dex */
public class HippyTKDListViewController extends HippyListViewController {
    private static final String TAG = "HippyQBListViewController";

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTKDListView(context);
    }

    @HippyControllerProps(name = "enableLoadingFooter")
    public void setEnableLoadingFooter(HippyListView hippyListView, boolean z16) {
        if (hippyListView instanceof HippyTKDListView) {
            HippyTKDListView hippyTKDListView = (HippyTKDListView) hippyListView;
            if (z16) {
                hippyTKDListView.mEnableFooter = true;
                hippyTKDListView.setLoadingStatus(2, "");
            } else {
                hippyTKDListView.setLoadingStatus(0, "");
                hippyTKDListView.mEnableFooter = false;
            }
        }
    }

    @HippyControllerProps(name = "enableOnScrollForReport")
    public void setEnableOnScrollForReport(HippyListView hippyListView, boolean z16) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setEnableScrollForReport(z16);
        }
    }

    @HippyControllerProps(name = "enableRefresh")
    public void setEnableRefresh(HippyListView hippyListView, boolean z16) {
        if (hippyListView instanceof HippyTKDListView) {
            HippyTKDListView hippyTKDListView = (HippyTKDListView) hippyListView;
            if (z16 && hippyTKDListView.mEnableRefresh) {
                return;
            }
            hippyTKDListView.setRefreshEnabled(z16);
            HippyArray hippyArray = hippyTKDListView.mRefreshColors;
            if (hippyArray != null && z16) {
                hippyTKDListView.setCustomRefreshColor(HippyTKDSkinHandler.getColor(hippyArray), 0, 0);
            }
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "enableScrollToContentOffset")
    public void setEnableScrollToContentOffset(HippyListView hippyListView, boolean z16) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setEnableScrollToContentOffset(z16);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController
    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "initialContentOffset")
    public void setInitialContentOffset(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setInitialContentOffset(ImmersiveUtils.dpToPx(i3));
        }
    }

    @HippyControllerProps(name = "enableExposureReport")
    public void setOnExposureReport(HippyListView hippyListView, boolean z16) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setEnableExposureReport(z16);
        }
    }

    @HippyControllerProps(name = "onScrollForReportThrottle")
    public void setOnScrollForReportThrottle(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setScrollForReportThrottle(i3);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController
    @HippyControllerProps(name = "preloadItemNumber")
    public void setPreloadItemNumber(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setPreloadItemNumber(i3);
        }
    }

    @HippyControllerProps(name = "refreshColor")
    public void setRefreshColor(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setCustomRefreshColor(i3, 0, 0);
        }
    }

    @HippyControllerProps(name = "refreshColors")
    public void setRefreshColors(HippyListView hippyListView, HippyArray hippyArray) {
        if (hippyListView instanceof HippyTKDListView) {
            HippyTKDListView hippyTKDListView = (HippyTKDListView) hippyListView;
            int color = HippyTKDSkinHandler.getColor(hippyArray);
            hippyTKDListView.setRefreshColors(hippyArray);
            hippyTKDListView.setCustomRefreshColor(color, 0, 0);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "responseToDoubleScroll")
    public void setResponseToDoubleScroll(HippyListView hippyListView, boolean z16) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).handleDoubleScrollResponseChange(z16);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController
    @HippyControllerProps(name = "scrollEventThrottle")
    public void setscrollEventThrottle(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof HippyTKDListView) {
            ((HippyTKDListView) hippyListView).setScrollEventThrottle(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createViewImpl(Context context, HippyMap hippyMap) {
        return new HippyTKDListView(context);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyListView hippyListView, String str, HippyArray hippyArray) {
        super.dispatchFunction(hippyListView, str, hippyArray);
        if (hippyListView instanceof HippyTKDListView) {
            HippyTKDListView hippyTKDListView = (HippyTKDListView) hippyListView;
            int i3 = 6;
            if ("endReachedCompleted".equals(str)) {
                int i16 = hippyArray.getInt(0);
                String string = hippyArray.getString(1);
                if (i16 == 0) {
                    i3 = 2;
                } else if (i16 == 1) {
                    i3 = 4;
                } else if (i16 != 2) {
                    i3 = i16 != 3 ? i16 != 4 ? 1 : 0 : 100;
                }
                hippyTKDListView.setLoadingStatus(i3, string);
                return;
            }
            if ("refreshCompleted".equals(str)) {
                int i17 = hippyArray.getInt(0);
                String string2 = hippyArray.getString(1);
                int i18 = hippyArray.getInt(2);
                hippyTKDListView.completeRefresh(i17 != 0 ? i17 != 1 ? 1 : 3 : 2, string2, hippyArray.getInt(5), hippyArray.getInt(6), hippyArray.getInt(3), ImmersiveUtils.dpToPx(hippyArray.getInt(7)), hippyArray.getString(4), true, i18, hippyArray.getInt(8), null, hippyArray.getInt(9));
                return;
            }
            if ("startRefresh".equals(str)) {
                hippyTKDListView.startRefresh(1);
                return;
            }
            if ("startRefreshWithType".equals(str)) {
                hippyTKDListView.startRefresh(hippyArray.getInt(0));
                return;
            }
            if ("startLoadMore".equals(str)) {
                hippyTKDListView.startLoadMore();
                return;
            }
            if ("callExposureReport".equals(str)) {
                hippyTKDListView.onScrollStateChanged(hippyTKDListView.getScrollState(), hippyTKDListView.getScrollState());
            } else if ("callOnScroll".equals(str)) {
                ((HippyTKDListViewAdapter) hippyTKDListView.getAdapter()).checkOnScrollEvent();
            } else if ("setRefreshPromptInfo".equals(str)) {
                hippyTKDListView.setRefreshPromptInfo(hippyArray.getString(0), hippyArray.getInt(1), ImmersiveUtils.dpToPx(hippyArray.getInt(2)), hippyArray.getString(3), ImmersiveUtils.dpToPx(hippyArray.getInt(4)), ImmersiveUtils.dpToPx(hippyArray.getInt(5)), hippyArray.size() >= 7 ? ImmersiveUtils.dpToPx(hippyArray.getInt(6)) : 0);
            }
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyListView hippyListView, String str, HippyArray hippyArray, Promise promise) {
        super.dispatchFunction((HippyTKDListViewController) hippyListView, str, hippyArray, promise);
        if (hippyListView instanceof HippyTKDListView) {
            HippyTKDListView hippyTKDListView = (HippyTKDListView) hippyListView;
            if ("getVisibleItems".equals(str)) {
                promise.resolve(hippyTKDListView.getVisibleItems());
                return;
            }
            if ("refreshCompleted".equals(str)) {
                int i3 = hippyArray.getInt(0);
                String string = hippyArray.getString(1);
                int i16 = hippyArray.getInt(2);
                hippyTKDListView.completeRefresh(i3 != 0 ? i3 != 1 ? 1 : 3 : 2, string, hippyArray.getInt(5), hippyArray.getInt(6), hippyArray.getInt(3), ImmersiveUtils.dpToPx(hippyArray.getInt(7)), hippyArray.getString(4), true, i16, hippyArray.getInt(8), promise, hippyArray.getInt(9));
            }
        }
    }
}
