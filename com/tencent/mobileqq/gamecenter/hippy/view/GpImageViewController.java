package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = GpImageViewController.CLASS_NAME)
/* loaded from: classes12.dex */
public class GpImageViewController extends HippyViewController<ImgHeaderView> {
    public static final String CLASS_NAME = "gpImageView";
    private static final String TAG = "GpImageViewController";
    public ImgHeaderView imgHeaderView;
    private int mHippyEngineId = Integer.MIN_VALUE;

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createView(HippyRootView hippyRootView, int i3, HippyEngineContext hippyEngineContext, String str, HippyMap hippyMap) {
        if (hippyEngineContext != null) {
            this.mHippyEngineId = hippyEngineContext.getEngineId();
        }
        return super.createView(hippyRootView, i3, hippyEngineContext, str, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    @HippyControllerProps(defaultType = "map", name = "src")
    public void setSrc(ImgHeaderView imgHeaderView, HippyMap hippyMap) {
        imgHeaderView.setSrc(hippyMap);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new ImgHeaderView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(ImgHeaderView imgHeaderView, String str, HippyArray hippyArray) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "GpImageViewController dispatchFunction: " + str);
        }
        if ("init".equals(str)) {
            imgHeaderView.e(hippyArray);
            imgHeaderView.h();
        } else if ("destory".equals(str)) {
            imgHeaderView.onDestory();
        }
        super.dispatchFunction((GpImageViewController) imgHeaderView, str, hippyArray);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(ImgHeaderView imgHeaderView) {
        imgHeaderView.g();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(ImgHeaderView imgHeaderView) {
        if (imgHeaderView != null) {
            imgHeaderView.onDestory();
        }
    }
}
