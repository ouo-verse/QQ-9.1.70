package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;

/* compiled from: P */
@HippyController(isLazyLoad = true, name = HippyWaterfallItemViewController.CLASS_NAME, names = {HippyWaterfallItemViewController.CLASS_NAME})
/* loaded from: classes20.dex */
public class HippyWaterfallItemViewController extends HippyViewController<HippyWaterfallItemView> {
    public static final String CLASS_NAME = "WaterfallViewItem";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public RenderNode createRenderNode(int i3, HippyMap hippyMap, String str, HippyRootView hippyRootView, ControllerManager controllerManager, boolean z16) {
        return new b(i3, hippyMap, str, hippyRootView, controllerManager, z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyWaterfallItemView(context);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "type")
    public void setListItemType(HippyWaterfallItemView hippyWaterfallItemView, int i3) {
        hippyWaterfallItemView.setType(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected boolean shouldInterceptLayout(View view, int i3, int i16, int i17, int i18) {
        int paddingLeft;
        ViewParent parent = view.getParent();
        if ((parent instanceof ViewGroup) && (paddingLeft = ((ViewGroup) parent).getPaddingLeft()) > 0) {
            int i19 = i3 + paddingLeft;
            view.layout(i19, i16, i17 + i19, i18 + i16);
            return true;
        }
        return false;
    }
}
