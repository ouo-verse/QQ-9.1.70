package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = GpTextViewController.CLASS_NAME)
/* loaded from: classes12.dex */
public class GpTextViewController extends HippyViewController<TextHeaderView> {
    public static final String CLASS_NAME = "gpTextView";
    private static final String TAG = "GpTextViewController";
    private int mHippyEngineId = Integer.MIN_VALUE;
    public TextHeaderView textHeaderView;

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
    public void setSrc(TextHeaderView textHeaderView, HippyMap hippyMap) {
        textHeaderView.setSrc(hippyMap);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new TextHeaderView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(TextHeaderView textHeaderView, String str, HippyArray hippyArray) {
        if ("init".equals(str)) {
            textHeaderView.c(hippyArray);
            textHeaderView.e();
        } else if ("destory".equals(str)) {
            textHeaderView.onDestory();
        } else if ("resume".equals(str)) {
            textHeaderView.onResume();
        }
        super.dispatchFunction((GpTextViewController) textHeaderView, str, hippyArray);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(TextHeaderView textHeaderView) {
        textHeaderView.d();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(TextHeaderView textHeaderView) {
        if (textHeaderView != null) {
            textHeaderView.onDestory();
        }
    }
}
