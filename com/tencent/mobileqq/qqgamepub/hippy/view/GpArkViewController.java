package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = GpArkViewController.CLASS_NAME)
/* loaded from: classes16.dex */
public class GpArkViewController extends HippyViewController<HippyArkView> {
    public static final String CLASS_NAME = "gpArkView";
    private static final String TAG = "QQGamePub_GpArkViewController";
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
        HippyArkView hippyArkView = new HippyArkView(context);
        hippyArkView.b(((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getMsgInfoByHippyMap(hippyMap));
        return hippyArkView;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyArkView hippyArkView, String str, HippyArray hippyArray) {
        try {
            if ("init".equals(str)) {
                hippyArkView.c(hippyArray);
                hippyArkView.g();
            } else if ("destory".equals(str)) {
                hippyArkView.a();
            } else if ("resume".equals(str)) {
                hippyArkView.h();
            } else if ("pause".equals(str)) {
                hippyArkView.f();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        super.dispatchFunction((GpArkViewController) hippyArkView, str, hippyArray);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HippyArkView hippyArkView) {
        hippyArkView.e();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyArkView hippyArkView) {
        if (hippyArkView != null) {
            hippyArkView.a();
        }
    }
}
