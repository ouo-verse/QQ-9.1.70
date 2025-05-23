package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;

/* compiled from: P */
@ProxyService(proxy = VideoPlayerProviderProxy.class)
/* loaded from: classes34.dex */
public class bx implements VideoPlayerProviderProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy
    public String getUrl(String str) {
        return OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(str));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy
    public ReliableVideoPlayer getVideoPlayer() {
        return new as();
    }
}
