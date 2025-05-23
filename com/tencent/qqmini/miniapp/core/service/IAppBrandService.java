package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IAppBrandService extends IJsService {
    int getStatus();

    void initBaseJs(BaselibLoader.BaselibContent baselibContent);

    void initEmbeddedState(EmbeddedState embeddedState);

    void setApkgInfo(ApkgInfo apkgInfo);

    void setAppBrandEventInterface(ServiceEventListener serviceEventListener);
}
