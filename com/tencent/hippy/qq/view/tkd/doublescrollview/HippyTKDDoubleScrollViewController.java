package com.tencent.hippy.qq.view.tkd.doublescrollview;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.utils.PixelUtil;

/* compiled from: P */
@HippyController(name = HippyTKDDoubleScrollViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyTKDDoubleScrollViewController extends HippyGroupController<HippyTKDDoubleScrollView> {
    public static final String CLASS_NAME = "TKDDoubleScrollView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTKDDoubleScrollView(context);
    }

    @HippyControllerProps(name = "enableDoubleScroll")
    public void enableDoubleScroll(HippyTKDDoubleScrollView hippyTKDDoubleScrollView, boolean z16) {
        hippyTKDDoubleScrollView.setEnableDoubleScroll(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyTKDDoubleScrollView hippyTKDDoubleScrollView, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyTKDDoubleScrollViewController) hippyTKDDoubleScrollView, str, hippyArray);
        if (!"scrollTo".equals(str) || hippyArray == null) {
            return;
        }
        int round = Math.round(PixelUtil.dp2px(hippyArray.getDouble(0)));
        int round2 = Math.round(PixelUtil.dp2px(hippyArray.getDouble(1)));
        hippyArray.getBoolean(2);
        hippyTKDDoubleScrollView.scrollTo(round, round2);
        hippyTKDDoubleScrollView.setHidden(false);
    }
}
