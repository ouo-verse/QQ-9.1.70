package com.tencent.mtt.hippy.views.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

@HippyController(name = "ViewPager")
/* loaded from: classes20.dex */
public class HippyViewPagerController extends HippyViewController<HippyViewPager> {
    public static final String CLASS_NAME = "ViewPager";
    private static final String FUNC_NEXT_PAGE = "next";
    private static final String FUNC_PREV_PAGE = "prev";
    private static final String FUNC_SET_INDEX = "setIndex";
    private static final String FUNC_SET_PAGE = "setPage";
    private static final String FUNC_SET_PAGE_WITHOUT_ANIM = "setPageWithoutAnimation";
    private static final String TAG = "HippyViewPagerController";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void addView(ViewGroup viewGroup, View view, int i3) {
        LogUtils.d(TAG, "addView: " + viewGroup.hashCode() + ", index=" + i3);
        if ((viewGroup instanceof HippyViewPager) && (view instanceof HippyViewPagerItem)) {
            ((HippyViewPager) viewGroup).addViewToAdapter((HippyViewPagerItem) view, i3);
        } else {
            LogUtils.e(TAG, "add view got invalid params");
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyViewPager(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void deleteChild(ViewGroup viewGroup, View view) {
        LogUtils.d(TAG, "deleteChild: " + viewGroup.hashCode());
        if ((viewGroup instanceof HippyViewPager) && (view instanceof HippyViewPagerItem)) {
            ((HippyViewPager) viewGroup).removeViewFromAdapter((HippyViewPagerItem) view);
        } else {
            LogUtils.e(TAG, "delete view got invalid params");
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "initialPage")
    public void setInitialPage(HippyViewPager hippyViewPager, int i3) {
        hippyViewPager.setInitialPageIndex(i3);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "offscreenPageLimit")
    public void setOffscreenPageLimit(HippyViewPager hippyViewPager, int i3) {
        hippyViewPager.setOffscreenPageLimit(i3);
    }

    @HippyControllerProps(defaultString = NodeProps.VISIBLE, defaultType = HippyControllerProps.STRING, name = "overflow")
    public void setOverflow(HippyViewPager hippyViewPager, String str) {
        HippyViewGroup.setOverflow(str, hippyViewPager);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "pageMargin")
    public void setPageMargin(HippyViewPager hippyViewPager, float f16) {
        hippyViewPager.setPageMargin((int) PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = ScrollerAttr.SCROLL_ENABLED)
    public void setScrollEnabled(HippyViewPager hippyViewPager, boolean z16) {
        hippyViewPager.setScrollEnabled(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new HippyViewPager(context, hippyMap != null && ((hippyMap.containsKey("direction") && hippyMap.getString("direction").equals("vertical")) || hippyMap.containsKey("vertical")));
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View getChildAt(HippyViewPager hippyViewPager, int i3) {
        return hippyViewPager.getViewFromAdapter(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public int getChildCount(HippyViewPager hippyViewPager) {
        return hippyViewPager.getAdapter().getCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onManageChildComplete(HippyViewPager hippyViewPager) {
        hippyViewPager.setChildCountAndUpdate(hippyViewPager.getAdapter().getItemViewSize());
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyViewPager hippyViewPager, String str, HippyArray hippyArray) {
        int i3;
        HippyMap map;
        if (hippyViewPager == null) {
            return;
        }
        int currentItem = hippyViewPager.getCurrentItem();
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -445763635:
                if (str.equals(FUNC_SET_PAGE_WITHOUT_ANIM)) {
                    c16 = 0;
                    break;
                }
                break;
            case 3377907:
                if (str.equals(FUNC_NEXT_PAGE)) {
                    c16 = 1;
                    break;
                }
                break;
            case 3449395:
                if (str.equals(FUNC_PREV_PAGE)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1395059088:
                if (str.equals(FUNC_SET_INDEX)) {
                    c16 = 3;
                    break;
                }
                break;
            case 1984860689:
                if (str.equals(FUNC_SET_PAGE)) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (hippyArray != null) {
                    Object obj = hippyArray.get(0);
                    if (obj instanceof Number) {
                        hippyViewPager.switchToPage(((Number) obj).intValue(), false);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (currentItem < hippyViewPager.getAdapter().getCount() - 1) {
                    i3 = currentItem + 1;
                    break;
                } else {
                    return;
                }
            case 2:
                if (currentItem > 0) {
                    i3 = currentItem - 1;
                    break;
                } else {
                    return;
                }
            case 3:
                if (hippyArray == null || hippyArray.size() <= 0 || (map = hippyArray.getMap(0)) == null || map.size() <= 0 || !map.containsKey("index")) {
                    return;
                }
                hippyViewPager.switchToPage(map.getInt("index"), !map.containsKey("animated") || map.getBoolean("animated"));
                return;
            case 4:
                if (hippyArray != null) {
                    Object obj2 = hippyArray.get(0);
                    if (obj2 instanceof Number) {
                        hippyViewPager.switchToPage(((Number) obj2).intValue(), true);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
        hippyViewPager.switchToPage(i3, true);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyViewPager hippyViewPager, String str, HippyArray hippyArray, Promise promise) {
        if (hippyViewPager == null) {
            return;
        }
        str.hashCode();
        if (str.equals(FUNC_SET_INDEX)) {
            if (hippyArray != null && hippyArray.size() > 0) {
                HippyMap map = hippyArray.getMap(0);
                if (map != null && map.size() > 0 && map.containsKey("index")) {
                    int i3 = map.getInt("index");
                    boolean z16 = !map.containsKey("animated") || map.getBoolean("animated");
                    hippyViewPager.setCallBackPromise(promise);
                    hippyViewPager.switchToPage(i3, z16);
                    return;
                }
            }
            if (promise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("msg", "invalid parameter!");
                promise.resolve(hippyMap);
            }
        }
    }
}
