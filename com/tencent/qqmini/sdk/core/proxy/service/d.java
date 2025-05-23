package com.tencent.qqmini.sdk.core.proxy.service;

import android.widget.ImageView;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;

/* compiled from: P */
@ProxyService(proxy = HippyPageProxy.class)
/* loaded from: classes23.dex */
public class d implements HippyPageProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void downloadJSBundle(String str, int i3) {
        QMLog.i("HippyPageProxyDefault", "downloadJsBundle openHippySchemeUrl:" + str + " from:" + i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void openHippyPage(IMiniAppContext iMiniAppContext, String str, String str2, int i3, HashMap<String, String> hashMap) {
        QMLog.i("HippyPageProxyDefault", "openHippyPage url:" + str + ", title:" + str2 + ", from:" + i3 + ",extraData:" + hashMap);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void closeHippyPage() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy
    public void setRoundDrawable(ImageView imageView, String str) {
    }
}
