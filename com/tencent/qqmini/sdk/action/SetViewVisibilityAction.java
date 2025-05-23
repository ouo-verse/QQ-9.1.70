package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetViewVisibilityAction implements Action<Void> {
    private static final int SET_NAVIBAR_VISIBILITY = 2;
    private static final int SET_TABBAR_VISIBILITY = 1;
    private int action = -1;
    private int mVisibility;
    private IMiniAppContext miniAppContext;

    public static SetViewVisibilityAction obtain(IMiniAppContext iMiniAppContext) {
        SetViewVisibilityAction setViewVisibilityAction = new SetViewVisibilityAction();
        setViewVisibilityAction.miniAppContext = iMiniAppContext;
        return setViewVisibilityAction;
    }

    public void setNaviBarVisibility(int i3) {
        this.action = 2;
        this.mVisibility = i3;
        this.miniAppContext.performAction(this);
    }

    public void setTabBarVisibility(int i3) {
        this.action = 1;
        this.mVisibility = i3;
        this.miniAppContext.performAction(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Void perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        int i3 = this.action;
        if (i3 == 1) {
            page.setTabBarVisibility(this.mVisibility);
        } else if (i3 == 2) {
            page.setNaviVisibility(this.mVisibility);
        }
        return null;
    }
}
