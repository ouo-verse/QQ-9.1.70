package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* loaded from: classes23.dex */
public class AppSetPageStringAction implements Action<Void> {
    private static final int SET_NAVIBAR_STYLE = 1;
    private int action = -1;
    private IMiniAppContext miniAppContext;
    private String value;

    public static AppSetPageStringAction obtain(IMiniAppContext iMiniAppContext) {
        AppSetPageStringAction appSetPageStringAction = new AppSetPageStringAction();
        appSetPageStringAction.miniAppContext = iMiniAppContext;
        return appSetPageStringAction;
    }

    public void setNaviBarStyle(String str) {
        this.action = 1;
        this.miniAppContext.performAction(this);
        this.value = str;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Void perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (!(page instanceof AppBrandPageContainer)) {
            return null;
        }
        AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) page;
        if (this.action == 1) {
            appBrandPageContainer.setNaviBarStyle(this.value);
        }
        return null;
    }
}
