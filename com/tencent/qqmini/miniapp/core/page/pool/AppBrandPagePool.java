package com.tencent.qqmini.miniapp.core.page.pool;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes23.dex */
public class AppBrandPagePool {
    public static final String TAG = "AppBrandPagePool";
    private final ConcurrentLinkedQueue<AppBrandPage> mBrandPageList = new ConcurrentLinkedQueue<>();
    private PageWebviewPool mPageWebviewPool;

    public AppBrandPagePool(IMiniAppContext iMiniAppContext) {
        this.mPageWebviewPool = new PageWebviewPool(iMiniAppContext);
    }

    public void destroyCachePage() {
        this.mBrandPageList.clear();
        PageWebviewPool pageWebviewPool = this.mPageWebviewPool;
        if (pageWebviewPool != null) {
            pageWebviewPool.destroyCachePage();
        }
    }

    public void destroyPageWebviewCache() {
        PageWebviewPool pageWebviewPool = this.mPageWebviewPool;
        if (pageWebviewPool != null) {
            pageWebviewPool.destroyCachePage();
        }
    }

    public AppBrandPage getAppBrandPage(IMiniAppContext iMiniAppContext, AppBrandPageContainer appBrandPageContainer) {
        QMLog.d(TAG, "mBrandPageList size : " + this.mBrandPageList.size());
        AppBrandPage poll = this.mBrandPageList.poll();
        if (poll == null) {
            QMLog.i(TAG, "getAppBrandPage form new BrandPageWebview.");
            return new AppBrandPage(iMiniAppContext, appBrandPageContainer);
        }
        QMLog.i(TAG, "getAppBrandPage from cache.");
        return poll;
    }

    public EmbeddedState getEmbeddedState(AppBrandPageContainer appBrandPageContainer) {
        PageWebviewPool pageWebviewPool;
        if (this.mBrandPageList.size() > 0 && (pageWebviewPool = this.mPageWebviewPool) != null) {
            return pageWebviewPool.getEmbeddedState(appBrandPageContainer);
        }
        return null;
    }

    public PageWebviewPool getPageWebviewPool() {
        return this.mPageWebviewPool;
    }

    public void initBaseJs(AppBrandPageContainer appBrandPageContainer, BaselibLoader.BaselibContent baselibContent) {
        PageWebviewPool pageWebviewPool = this.mPageWebviewPool;
        if (pageWebviewPool != null) {
            pageWebviewPool.initBaseJs(appBrandPageContainer, baselibContent);
        }
    }

    public void preLoadAppBrandPage(IMiniAppContext iMiniAppContext, AppBrandPageContainer appBrandPageContainer) {
        if (iMiniAppContext == null) {
            return;
        }
        if (this.mBrandPageList.size() <= 0) {
            QMLog.d(TAG, "preLoadAppBrandPage");
            this.mBrandPageList.add(new AppBrandPage(iMiniAppContext, appBrandPageContainer));
        }
        PageWebviewPool pageWebviewPool = this.mPageWebviewPool;
        if (pageWebviewPool != null) {
            pageWebviewPool.preLoadAppBrandPage(appBrandPageContainer);
        }
    }
}
