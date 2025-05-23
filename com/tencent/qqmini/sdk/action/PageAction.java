package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;

@MiniKeep
/* loaded from: classes23.dex */
public class PageAction implements Action<AppPageInfo> {
    private static final int GET_APP_PAGE_INFO = 1;
    private static final int GET_WEB_VIEW_URL = 2;
    private int action = 1;
    private int flag;
    private IMiniAppContext miniAppContext;

    public static PageAction obtain(IMiniAppContext iMiniAppContext) {
        PageAction pageAction = new PageAction();
        pageAction.miniAppContext = iMiniAppContext;
        return pageAction;
    }

    public int getPageId() {
        this.action = 1;
        this.flag = 1;
        AppPageInfo appPageInfo = (AppPageInfo) this.miniAppContext.performAction(this);
        if (appPageInfo != null) {
            return appPageInfo.pageId;
        }
        return 0;
    }

    public String getPageUrl() {
        this.action = 1;
        this.flag = 2;
        AppPageInfo appPageInfo = (AppPageInfo) this.miniAppContext.performAction(this);
        if (appPageInfo != null) {
            return appPageInfo.pageUrl;
        }
        return null;
    }

    public int getSurfaceViewHeight() {
        this.action = 1;
        this.flag = 32;
        AppPageInfo appPageInfo = (AppPageInfo) this.miniAppContext.performAction(this);
        if (appPageInfo != null) {
            return appPageInfo.surfaceViewHeight;
        }
        return 0;
    }

    public int getSurfaceViewWidth() {
        this.action = 1;
        this.flag = 16;
        AppPageInfo appPageInfo = (AppPageInfo) this.miniAppContext.performAction(this);
        if (appPageInfo != null) {
            return appPageInfo.surfaceViewWidth;
        }
        return 0;
    }

    public String getWebViewUrlForShare() {
        this.action = 1;
        this.flag = 64;
        AppPageInfo appPageInfo = (AppPageInfo) this.miniAppContext.performAction(this);
        if (appPageInfo != null) {
            return appPageInfo.webViewUrl;
        }
        return null;
    }

    public int getWindowHeight() {
        this.action = 1;
        this.flag = 8;
        AppPageInfo appPageInfo = (AppPageInfo) this.miniAppContext.performAction(this);
        if (appPageInfo != null) {
            return appPageInfo.windowHeight;
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public AppPageInfo perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page != null && this.action == 1) {
            return page.getPageInfo(this.flag);
        }
        return null;
    }
}
