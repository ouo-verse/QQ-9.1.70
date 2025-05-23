package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.minigame.proxy.MiniGameCmdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public final class GameProxyServiceScope {
    public static final Map PROXY_SERVICES;

    static {
        HashMap hashMap = new HashMap();
        PROXY_SERVICES = hashMap;
        hashMap.put(CmdProxy.class, MiniGameCmdProxyImpl.class);
    }
}
