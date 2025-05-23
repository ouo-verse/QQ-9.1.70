package com.tencent.mtt.hippy.views.scroll;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* compiled from: P */
@HippyController(name = HippyScrollViewController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyScrollViewController<T extends ViewGroup & HippyScrollView> extends HippyGroupController {
    public static final String CLASS_NAME = "ScrollView";
    protected static final String SCROLL_TO = "scrollTo";
    private static final String SCROLL_TO_WITHOPTIONS = "scrollToWithOptions";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(View view, String str, HippyArray hippyArray) {
        super.dispatchFunction(view, str, hippyArray);
        if (view instanceof HippyScrollView) {
            if (TextUtils.equals(SCROLL_TO, str)) {
                int round = Math.round(PixelUtil.dp2px(hippyArray.getDouble(0)));
                int round2 = Math.round(PixelUtil.dp2px(hippyArray.getDouble(1)));
                if (hippyArray.getBoolean(2)) {
                    ((HippyScrollView) view).callSmoothScrollTo(round, round2, 0);
                } else {
                    view.scrollTo(round, round2);
                }
            }
            if (TextUtils.equals(SCROLL_TO_WITHOPTIONS, str) && hippyArray != null && hippyArray.size() > 0) {
                HippyMap map = hippyArray.getMap(0);
                int round3 = Math.round(PixelUtil.dp2px(map.getInt(HippyTKDListViewAdapter.X)));
                int round4 = Math.round(PixelUtil.dp2px(map.getInt("y")));
                int i3 = map.getInt("duration");
                if (i3 > 0) {
                    ((HippyScrollView) view).callSmoothScrollTo(round3, round4, i3);
                } else {
                    view.scrollTo(round3, round4);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onBatchComplete(View view) {
        super.onBatchComplete(view);
        if (view instanceof HippyScrollView) {
            ((HippyScrollView) view).scrollToInitContentOffset();
        }
    }

    @HippyControllerProps(name = "contentOffset4Reuse")
    public void setContentOffset4Reuse(HippyScrollView hippyScrollView, HippyMap hippyMap) {
        hippyScrollView.setContentOffset4Reuse(hippyMap);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "flingEnabled")
    public void setFlingEnabled(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setFlingEnabled(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "initialContentOffset")
    public void setInitialContentOffset(HippyScrollView hippyScrollView, int i3) {
        hippyScrollView.setInitialContentOffset((int) PixelUtil.dp2px(i3));
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_BEGIN)
    public void setMomentumScrollBeginEventEnable(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setMomentumScrollBeginEventEnable(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_END)
    public void setMomentumScrollEndEventEnable(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setMomentumScrollEndEventEnable(z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @HippyControllerProps(defaultString = NodeProps.VISIBLE, defaultType = HippyControllerProps.STRING, name = "overflow")
    public void setOverflow(HippyScrollView hippyScrollView, String str) {
        if (hippyScrollView instanceof ViewGroup) {
            HippyViewGroup.setOverflow(str, (ViewGroup) hippyScrollView);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = ScrollerAttr.PAGING_ENABLED)
    public void setPagingEnabled(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setPagingEnabled(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_BEGIN_DRAG)
    public void setScrollBeginDragEventEnable(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setScrollBeginDragEventEnable(z16);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = ScrollerAttr.SCROLL_ENABLED)
    public void setScrollEnabled(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setScrollEnabled(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyScrollViewEventHelper.EVENT_TYPE_END_DRAG)
    public void setScrollEndDragEventEnable(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.setScrollEndDragEventEnable(z16);
    }

    @HippyControllerProps(defaultNumber = PreDownloadConstants.SYS_BUSY_VALUE_FPS, defaultType = "number", name = "scrollEventThrottle")
    public void setScrollEventThrottle(HippyScrollView hippyScrollView, int i3) {
        hippyScrollView.setScrollEventThrottle(i3);
    }

    @HippyControllerProps(defaultNumber = 5.0d, defaultType = "number", name = "scrollMinOffset")
    public void setScrollMinOffset(HippyScrollView hippyScrollView, int i3) {
        hippyScrollView.setScrollMinOffset(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "showScrollIndicator")
    public void setShowScrollIndicator(HippyScrollView hippyScrollView, boolean z16) {
        hippyScrollView.showScrollIndicator(z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView] */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        boolean z16;
        boolean z17;
        if (hippyMap != null) {
            z16 = hippyMap.getBoolean("horizontal");
            z17 = hippyMap.getBoolean(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        } else {
            z16 = false;
            z17 = false;
        }
        HippyVerticalScrollView hippyHorizontalScrollView = z16 ? new HippyHorizontalScrollView(context) : new HippyVerticalScrollView(context);
        hippyHorizontalScrollView.setScrollEventEnable(z17);
        return hippyHorizontalScrollView;
    }
}
