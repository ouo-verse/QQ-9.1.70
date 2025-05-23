package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* loaded from: classes23.dex */
public class AppGetPageStringAction implements Action<String> {
    private static final int GET_NAVIBAR_STYLE = 1;
    private int action = -1;
    private IMiniAppContext miniAppContext;

    public static AppGetPageStringAction obtain(IMiniAppContext iMiniAppContext) {
        AppGetPageStringAction appGetPageStringAction = new AppGetPageStringAction();
        appGetPageStringAction.miniAppContext = iMiniAppContext;
        return appGetPageStringAction;
    }

    public String getNaviBarStyle() {
        this.action = 1;
        return (String) this.miniAppContext.performAction(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page instanceof AppBrandPageContainer) {
            return this.action != 1 ? "" : ((AppBrandPageContainer) page).getNaviBarStyle();
        }
        return null;
    }
}
