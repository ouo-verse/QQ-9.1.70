package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CheckJsServiceAction implements Action<Boolean> {
    private static final int IS_PAGEWEBVIEW_CALL = 1;
    private static final int IS_SERVICE_OR_MAINCONTEXT_CALL = 2;
    private int action = -1;
    private IJsService mJsService;
    private IMiniAppContext mMiniAppContext;

    CheckJsServiceAction() {
    }

    public static CheckJsServiceAction obtain(IMiniAppContext iMiniAppContext) {
        CheckJsServiceAction checkJsServiceAction = new CheckJsServiceAction();
        checkJsServiceAction.mMiniAppContext = iMiniAppContext;
        return checkJsServiceAction;
    }

    public boolean isPageWebviewCall(IJsService iJsService) {
        this.mJsService = iJsService;
        this.action = 1;
        return ((Boolean) this.mMiniAppContext.performAction(this)).booleanValue();
    }

    public boolean isServiceOrMainContext(IJsService iJsService) {
        this.mJsService = iJsService;
        this.action = 2;
        return ((Boolean) this.mMiniAppContext.performAction(this)).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        IJsService jsService = baseRuntime.getJsService();
        int i3 = this.action;
        if (i3 == 1) {
            return Boolean.valueOf(this.mJsService != jsService);
        }
        if (i3 != 2) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(this.mJsService == jsService);
    }
}
