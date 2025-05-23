package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.ui.MorePanel;

@ProxyService(proxy = ShareProxy.class)
/* loaded from: classes23.dex */
public class ShareProxyDefault implements ShareProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public int getDefaultShareTarget() {
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public boolean isShareTargetAvailable(Context context, int i3) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public boolean shareGamePicture(Activity activity, ShareData shareData) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void showSharePanel(IMiniAppContext iMiniAppContext) {
        MorePanel.show(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void onJsShareAppMessage(Object obj) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void onJsShareAppPictureMessage(Object obj) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void share(Activity activity, ShareData shareData) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void shareGameStructMessage(ShareData shareData, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void sharePic(Activity activity, ShareData shareData) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void onShareActivityResult(int i3, int i16, Intent intent) {
    }
}
