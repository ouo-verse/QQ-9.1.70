package com.tencent.hippy.qq.view.pag;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name = HippyQQPagViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyQQPagViewController extends HippyViewController<HippyQQPagView> {
    public static final String CLASS_NAME = "QQPagImageView";

    /* loaded from: classes7.dex */
    private interface PropertyName {
        public static final String AUTO_PLAY = "autoPlay";
        public static final String REPEAT_COUNT = "repeatCount";
        public static final String SCALE_MODE = "scaleMode";
        public static final String SRC = "src";
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyQQPagView(context);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "autoPlay")
    public void setAutoPlay(HippyQQPagView hippyQQPagView, boolean z16) {
        hippyQQPagView.setAutoPlay(z16);
    }

    @HippyControllerProps(defaultType = "number", name = "repeatCount")
    public void setRepeatCount(HippyQQPagView hippyQQPagView, int i3) {
        hippyQQPagView.setRepeatCount(i3);
    }

    @HippyControllerProps(defaultType = "number", name = PropertyName.SCALE_MODE)
    public void setScaleMode(HippyQQPagView hippyQQPagView, int i3) {
        hippyQQPagView.setScaleMode(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "src")
    public void setSrc(HippyQQPagView hippyQQPagView, String str) {
        hippyQQPagView.setSrc(str);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new HippyQQPagView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HippyQQPagView hippyQQPagView) {
        hippyQQPagView.onAfterUpdateProps();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyQQPagView hippyQQPagView) {
        hippyQQPagView.onViewDestroy();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyQQPagView hippyQQPagView, String str, HippyArray hippyArray) {
        hippyQQPagView.dispatchFunction(str, hippyArray, null);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyQQPagView hippyQQPagView, String str, HippyArray hippyArray, Promise promise) {
        hippyQQPagView.dispatchFunction(str, hippyArray, promise);
    }
}
