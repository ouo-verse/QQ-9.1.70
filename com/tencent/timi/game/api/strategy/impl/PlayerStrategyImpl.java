package com.tencent.timi.game.api.strategy.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.api.strategy.IPlayerStrategy;
import com.tencent.timi.game.api.strategy.impl.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes26.dex */
public class PlayerStrategyImpl implements IPlayerStrategy, a.InterfaceC9921a {
    private static final boolean DEFAULT_IS_WEAKNETWORK = false;
    private static final boolean DEFAULT_PRELOAD_ENABLE = true;
    private static final String tag = "PlayerStrategy|PlayerStrategyImpl";
    private final IAegisLogApi aegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private boolean isInit = false;
    private long roomId = 0;
    private final a downloadStrategy = new tf4.a();
    private boolean isUserSelectDefinition = false;
    private final List<IPlayerStrategy.NetworkListener> networkListenerList = new CopyOnWriteArrayList();
    private boolean isWeakNetwork = false;
    private boolean isPreloadEnable = true;

    private void logE(String str) {
        this.aegisLogApi.e(tag, str);
    }

    private void logI(String str) {
        this.aegisLogApi.i(tag, str);
    }

    private void notifyNetworkChange(boolean z16, boolean z17) {
        Iterator<IPlayerStrategy.NetworkListener> it = this.networkListenerList.iterator();
        while (it.hasNext()) {
            it.next().onNetworkChange(z16, z17);
        }
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void addNetworkListener(IPlayerStrategy.NetworkListener networkListener) {
        if (networkListener == null || this.networkListenerList.contains(networkListener)) {
            return;
        }
        this.networkListenerList.add(networkListener);
        networkListener.onNetworkChange(isWeakNetwork(), isPreloadEnable());
        logI("addNetworkListener list:" + this.networkListenerList.size() + " networkListener:" + networkListener);
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void destroy() {
        if (!this.isInit) {
            logI("PlayerStrategyImpl had destroy " + this);
            return;
        }
        this.isInit = false;
        logI("PlayerStrategyImpl destroy " + this);
        this.downloadStrategy.a();
        this.networkListenerList.clear();
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void init() {
        if (this.isInit) {
            logI("PlayerStrategyImpl had init " + this);
            return;
        }
        this.isInit = true;
        logI("PlayerStrategyImpl init " + this);
        this.downloadStrategy.c(this);
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public boolean isPreloadEnable() {
        if (!this.isInit) {
            logI("\u672a\u521d\u59cb\u5316 isPreloadEnable \u9ed8\u8ba4\u5f00\u542f\u3002");
            return true;
        }
        logI("isPreloadEnable:" + this.isPreloadEnable);
        return this.isPreloadEnable;
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public boolean isWeakNetwork() {
        if (!this.isInit) {
            logI("\u672a\u521d\u59cb\u5316 isWeakNetwork \u9ed8\u8ba4\u5f00\u542f\u3002");
            return false;
        }
        logI("isWeakNetwork:" + this.isWeakNetwork);
        return this.isWeakNetwork;
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void onLiveHallHippyPause() {
        logI("\u79bb\u5f00\u5927\u5385\u9875 onLiveHallHippyPause");
        this.downloadStrategy.f();
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void onLiveHallHippyResume() {
        logI("\u8fdb\u5165\u5927\u5385\u9875 onLiveHallHippyResume");
        this.downloadStrategy.g();
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void onPageIn(long j3) {
        logI("onPageIn:" + j3);
        if (!this.isInit) {
            logI("\u672a\u521d\u59cb\u5316 onPageIn");
        } else {
            this.roomId = j3;
            this.downloadStrategy.h(j3);
        }
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void onPageOut(long j3) {
        logI("onPageOut:" + j3);
        if (!this.isInit) {
            logI("\u672a\u521d\u59cb\u5316 onPageOut");
        } else if (this.roomId == j3) {
            this.downloadStrategy.i(j3);
            this.roomId = 0L;
        }
    }

    @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy
    public void removeNetworkListener(IPlayerStrategy.NetworkListener networkListener) {
        this.networkListenerList.remove(networkListener);
        logI("removeNetworkListener list:" + this.networkListenerList.size() + " networkListener:" + networkListener);
    }

    @Override // com.tencent.timi.game.api.strategy.impl.a.InterfaceC9921a
    public void slowDownloadNetworkChange(boolean z16, boolean z17) {
        if (this.isWeakNetwork != z16 || this.isPreloadEnable != z17) {
            logI("\u7f51\u7edc\u4e0b\u8f7d\u72b6\u6001\u53d1\u751f\u53d8\u5316: isWeakNet:" + this.isWeakNetwork + "->" + z16 + " isPreload:" + this.isPreloadEnable + "->" + z17);
            this.isWeakNetwork = z16;
            this.isPreloadEnable = z17;
            notifyNetworkChange(z16, z17);
        }
    }
}
