package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* loaded from: classes23.dex */
public class GetPageStringAction implements Action<String> {
    private static final int GET_PAGE_ORIENTATION = 1;
    private int action = -1;
    private IMiniAppContext miniAppContext;

    public static GetPageStringAction obtain(IMiniAppContext iMiniAppContext) {
        GetPageStringAction getPageStringAction = new GetPageStringAction();
        getPageStringAction.miniAppContext = iMiniAppContext;
        return getPageStringAction;
    }

    public String getPageOrientation() {
        this.action = 1;
        return (String) this.miniAppContext.performAction(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        return this.action != 1 ? "" : page.getPageOrientation();
    }
}
