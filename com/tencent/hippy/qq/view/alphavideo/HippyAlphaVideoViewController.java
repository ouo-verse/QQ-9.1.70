package com.tencent.hippy.qq.view.alphavideo;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = HippyAlphaVideoViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyAlphaVideoViewController extends HippyViewController<HippyAlphaVideoView> {
    public static final String CLASS_NAME = "AlphaVideoView";
    private static final String TAG = "HippyAlphaVideoViewController";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private interface FunctionName {
        public static final String PLAY = "play";
        public static final String STOP = "stop";
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private interface PropName {
        public static final String AUTO_PLAY = "autoPlay";
        public static final String IS_ALPHA_LEFT = "isAlphaLeft";
        public static final String IS_LOOP = "isLoop";
        public static final String REPEAT_COUNT = "repeatCount";
        public static final String SRC = "src";
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HippyAlphaVideoView hippyAlphaVideoView) {
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "autoPlay")
    public void setAutoPlay(HippyAlphaVideoView hippyAlphaVideoView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setAutoPlay call " + z16);
        }
        hippyAlphaVideoView.setAutoPlay(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "isLoop")
    public void setIsLoop(HippyAlphaVideoView hippyAlphaVideoView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setIsLoop call " + z16);
        }
        hippyAlphaVideoView.setIsLoop(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "src")
    public void setSrc(HippyAlphaVideoView hippyAlphaVideoView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setSrc call " + str);
        }
        hippyAlphaVideoView.setUrl(str);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyAlphaVideoView hippyAlphaVideoViewAlphaRight;
        QLog.d(TAG, 1, "createViewImpl AlphaVideoView");
        if (hippyMap.containsKey(PropName.IS_ALPHA_LEFT) && hippyMap.getBoolean(PropName.IS_ALPHA_LEFT)) {
            hippyAlphaVideoViewAlphaRight = new HippyAlphaVideoViewAlphaLeft(context);
        } else {
            hippyAlphaVideoViewAlphaRight = new HippyAlphaVideoViewAlphaRight(context);
        }
        hippyAlphaVideoViewAlphaRight.init();
        if (hippyMap.containsKey("src")) {
            hippyAlphaVideoViewAlphaRight.setUrl(hippyMap.get("src").toString());
        }
        return hippyAlphaVideoViewAlphaRight;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyAlphaVideoView hippyAlphaVideoView, String str, HippyArray hippyArray) {
        if ("play".equals(str)) {
            hippyAlphaVideoView.play();
        } else if ("stop".equals(str)) {
            hippyAlphaVideoView.stop();
        }
        super.dispatchFunction((HippyAlphaVideoViewController) hippyAlphaVideoView, str, hippyArray);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyAlphaVideoView hippyAlphaVideoView) {
        QLog.d(TAG, 1, "onViewDestroy");
        hippyAlphaVideoView.stop();
        super.onViewDestroy((HippyAlphaVideoViewController) hippyAlphaVideoView);
    }
}
