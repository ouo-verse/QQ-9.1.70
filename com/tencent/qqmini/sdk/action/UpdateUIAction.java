package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class UpdateUIAction implements Action<Boolean> {
    private static final String TAG = "UpdateUIEvent";
    public static final int TOGGLE_DEBUG_PANEL = 2;
    public static final int TOGGLE_MONITOR_PANEL = 1;
    public static final int UPDATE_RED_DOT = 3;
    private int what;

    UpdateUIAction() {
    }

    private static UpdateUIAction obtain(int i3) {
        UpdateUIAction updateUIAction = new UpdateUIAction();
        updateUIAction.what = i3;
        return updateUIAction;
    }

    public static Boolean toggleDebugPanel(IMiniAppContext iMiniAppContext) {
        return (Boolean) iMiniAppContext.performAction(obtain(2));
    }

    public static Boolean toggleMonitorPanel(IMiniAppContext iMiniAppContext) {
        return (Boolean) iMiniAppContext.performAction(obtain(1));
    }

    public static Boolean updateRedDot(IMiniAppContext iMiniAppContext) {
        return (Boolean) iMiniAppContext.performAction(obtain(3));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            QMLog.e(TAG, "Failed to perform " + this + ". page is null");
            return Boolean.FALSE;
        }
        int i3 = this.what;
        if (i3 == 1) {
            return Boolean.valueOf(page.toggleMonitorPanel());
        }
        if (i3 == 2) {
            return Boolean.valueOf(page.toggleDebugPanel());
        }
        if (i3 != 3) {
            return Boolean.FALSE;
        }
        ICapsuleButton capsuleButton = page.getCapsuleButton();
        if (capsuleButton != null) {
            capsuleButton.updateRedDotVisible();
        }
        return Boolean.TRUE;
    }
}
