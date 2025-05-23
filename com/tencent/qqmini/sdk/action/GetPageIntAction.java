package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* loaded from: classes23.dex */
public class GetPageIntAction implements Action<Integer> {
    private static final int GET_NAVIBAR_TEXT_STYLE = 3;
    private static final int GET_NAVIBAR_VISIBILITY = 2;
    private static final int GET_TABBAR_VISIBILITY = 1;
    private int action = -1;
    private IMiniAppContext miniAppContext;

    public static GetPageIntAction obtain(IMiniAppContext iMiniAppContext) {
        GetPageIntAction getPageIntAction = new GetPageIntAction();
        getPageIntAction.miniAppContext = iMiniAppContext;
        return getPageIntAction;
    }

    public int getNaviBarTextStyle() {
        this.action = 3;
        return ((Integer) this.miniAppContext.performAction(this)).intValue();
    }

    public int getNaviBarVisibility() {
        this.action = 2;
        return ((Integer) this.miniAppContext.performAction(this)).intValue();
    }

    public int getTabBarVisibility() {
        this.action = 1;
        return ((Integer) this.miniAppContext.performAction(this)).intValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Integer perform(BaseRuntime baseRuntime) {
        int tabBarVisibility;
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        int i3 = this.action;
        if (i3 == 1) {
            tabBarVisibility = page.getTabBarVisibility();
        } else if (i3 != 2) {
            tabBarVisibility = i3 != 3 ? -1 : page.getNaviBarTextStyle();
        } else {
            tabBarVisibility = page.getNaviBarVisibility();
        }
        return Integer.valueOf(tabBarVisibility);
    }
}
