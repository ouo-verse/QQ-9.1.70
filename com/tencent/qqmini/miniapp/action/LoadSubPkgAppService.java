package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* loaded from: classes23.dex */
public class LoadSubPkgAppService implements Action<Boolean> {
    private String url;

    public static LoadSubPkgAppService obtain(String str) {
        LoadSubPkgAppService loadSubPkgAppService = new LoadSubPkgAppService();
        loadSubPkgAppService.url = str;
        return loadSubPkgAppService;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        if (baseRuntime instanceof AppBrandRuntime) {
            ((AppBrandRuntime) baseRuntime).loadSubPkgAppService(this.url);
        }
        return Boolean.TRUE;
    }
}
