package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = GpMsgHelperViewController.CLASS_NAME)
/* loaded from: classes16.dex */
public class GpMsgHelperViewController extends HippyViewController<GpMsgHelperView> {
    public static final String CLASS_NAME = "gpMsgHelperView";
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

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new GpMsgHelperView(context, this.mHippyEngineId);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(GpMsgHelperView gpMsgHelperView) {
        if (gpMsgHelperView != null) {
            try {
                gpMsgHelperView.c();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
