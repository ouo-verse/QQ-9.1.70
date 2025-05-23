package com.tencent.qqmini.miniapp.core.page.pool;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class PageWebviewPool {
    private static final String TAG = "PageWebviewPool";
    private ConcurrentHashMap<AppBrandPageContainer, BrandPageWebview> mAppBrandPageMap = new ConcurrentHashMap<>();
    private BaselibLoader.BaselibContent mBaselibContent;
    private IMiniAppContext mContext;

    public PageWebviewPool(IMiniAppContext iMiniAppContext) {
        this.mContext = iMiniAppContext;
    }

    public void destroyCachePage() {
        try {
            Iterator<Map.Entry<AppBrandPageContainer, BrandPageWebview>> it = this.mAppBrandPageMap.entrySet().iterator();
            while (it.hasNext()) {
                BrandPageWebview value = it.next().getValue();
                if (value != null) {
                    value.cleanUp();
                }
                it.remove();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "destroyCachePage error:", e16);
        }
    }

    public BrandPageWebview getAppBrandPage(AppBrandPageContainer appBrandPageContainer) {
        BrandPageWebview remove = this.mAppBrandPageMap.remove(appBrandPageContainer);
        if (remove == null) {
            QMLog.i(TAG, "get page form new BrandPageWebview.");
            remove = new BrandPageWebview(this.mContext, appBrandPageContainer);
            BaselibLoader.BaselibContent baselibContent = this.mBaselibContent;
            if (baselibContent != null) {
                remove.initBaseJs(baselibContent);
            }
        } else {
            QMLog.i(TAG, "get page from cache.");
        }
        return remove;
    }

    public EmbeddedState getEmbeddedState(AppBrandPageContainer appBrandPageContainer) {
        BrandPageWebview brandPageWebview;
        ConcurrentHashMap<AppBrandPageContainer, BrandPageWebview> concurrentHashMap = this.mAppBrandPageMap;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (brandPageWebview = this.mAppBrandPageMap.get(appBrandPageContainer)) != null && brandPageWebview.getRealView() != null) {
            return brandPageWebview.getRealView().getEmbeddedState();
        }
        return null;
    }

    public void initBaseJs(AppBrandPageContainer appBrandPageContainer, BaselibLoader.BaselibContent baselibContent) {
        this.mBaselibContent = baselibContent;
        BrandPageWebview brandPageWebview = this.mAppBrandPageMap.get(appBrandPageContainer);
        if (brandPageWebview != null && this.mBaselibContent != null) {
            brandPageWebview.initBaseJs(baselibContent);
        }
    }

    public void preLoadAppBrandPage(AppBrandPageContainer appBrandPageContainer) {
        if (this.mAppBrandPageMap.containsKey(appBrandPageContainer)) {
            return;
        }
        QMLog.i(TAG, "preLoad page");
        BrandPageWebview brandPageWebview = new BrandPageWebview(this.mContext, appBrandPageContainer);
        BaselibLoader.BaselibContent baselibContent = this.mBaselibContent;
        if (baselibContent != null) {
            brandPageWebview.initBaseJs(baselibContent);
        }
        this.mAppBrandPageMap.put(appBrandPageContainer, brandPageWebview);
    }
}
