package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = HippyLottieViewController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyLottieViewController extends HippyViewController<HippyLottieView> {
    public static final String CLASS_NAME = "LottieView";
    private static final String TAG = "HippyLottieViewController";

    private void play(HippyLottieView hippyLottieView, HippyArray hippyArray) {
        if (hippyLottieView == null) {
            QLog.e(TAG, 1, "play error: view is null");
        } else if (hippyArray != null && hippyArray.size() == 2) {
            hippyLottieView.g(hippyArray.getInt(0), hippyArray.getInt(1));
        } else {
            hippyLottieView.f();
        }
    }

    private void setProgress(HippyLottieView hippyLottieView, HippyArray hippyArray) {
        if (hippyLottieView != null && hippyArray != null && hippyArray.size() != 0) {
            hippyLottieView.setProgress((float) hippyArray.getDouble(0));
        } else {
            QLog.e(TAG, 1, "setProgress error: view or var is null");
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    @HippyControllerProps(defaultType = "number", name = "endFrame")
    public void setEndFrame(HippyLottieView hippyLottieView, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setEndFrame call");
        }
        hippyLottieView.setEndFrame(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "isFitFullXY")
    public void setIsFitFullXY(HippyLottieView hippyLottieView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setIsFitFullXY call");
        }
        if (z16) {
            hippyLottieView.setFitFullScreenXY();
        }
    }

    @HippyControllerProps(defaultType = "number", name = "repeatCount")
    public void setRepeatCount(HippyLottieView hippyLottieView, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setRepeatCount call");
        }
        hippyLottieView.setRepeatCount(i3);
    }

    @HippyControllerProps(defaultType = "number", name = "speed")
    public void setSpeed(HippyLottieView hippyLottieView, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setSpeed call");
        }
        hippyLottieView.setSpeed(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "src")
    public void setSrc(HippyLottieView hippyLottieView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setSrc call");
        }
        hippyLottieView.setSrc(str);
    }

    @HippyControllerProps(defaultType = "number", name = "startFrame")
    public void setStartFrame(HippyLottieView hippyLottieView, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setStartFrame call");
        }
        hippyLottieView.setStartFrame(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "zipSrc")
    public void setZipSrc(HippyLottieView hippyLottieView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setZipSrc call");
        }
        if (!TextUtils.isEmpty(str)) {
            hippyLottieView.setZipSrc(str);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyLottieView hippyLottieView = new HippyLottieView(context);
        hippyLottieView.b(hippyMap);
        return hippyLottieView;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyLottieView hippyLottieView, String str, HippyArray hippyArray) {
        if ("play".equals(str)) {
            play(hippyLottieView, hippyArray);
        } else if ("resume".equals(str)) {
            hippyLottieView.i();
        } else if ("pause".equals(str)) {
            hippyLottieView.e();
        } else if (HippyQQPagView.FunctionName.SET_PROGRESS.equals(str)) {
            setProgress(hippyLottieView, hippyArray);
        }
        super.dispatchFunction((HippyLottieViewController) hippyLottieView, str, hippyArray);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HippyLottieView hippyLottieView) {
        hippyLottieView.d();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyLottieView hippyLottieView) {
        QLog.d(TAG, 1, "onViewDestroy");
        super.onViewDestroy((HippyLottieViewController) hippyLottieView);
        if (hippyLottieView != null) {
            hippyLottieView.a();
        }
    }
}
