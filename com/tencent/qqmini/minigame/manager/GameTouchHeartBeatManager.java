package com.tencent.qqmini.minigame.manager;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniGameProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameTouchHeartBeatManager {

    /* renamed from: a, reason: collision with root package name */
    private long f346513a;

    /* renamed from: b, reason: collision with root package name */
    private IMiniGameProxy.QMiniTouchHeartBeatListener f346514b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f346515c;

    /* renamed from: d, reason: collision with root package name */
    private TritonEngine f346516d;

    /* renamed from: e, reason: collision with root package name */
    private MiniAppInfo f346517e;

    public GameTouchHeartBeatManager(TritonEngine tritonEngine) {
        this.f346513a = 0L;
        this.f346516d = tritonEngine;
        IMiniGameProxy iMiniGameProxy = (IMiniGameProxy) AppLoaderFactory.g().getProxyManager().get(IMiniGameProxy.class);
        if (iMiniGameProxy == null) {
            return;
        }
        this.f346513a = iMiniGameProxy.getBeatInterval();
        IMiniGameProxy.QMiniTouchHeartBeatListener heartBeatListener = iMiniGameProxy.getHeartBeatListener();
        this.f346514b = heartBeatListener;
        if (this.f346513a != 0 && heartBeatListener != null) {
            this.f346515c = new Runnable() { // from class: com.tencent.qqmini.minigame.manager.GameTouchHeartBeatManager.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    ThreadManager.getSubThreadHandler().postDelayed(GameTouchHeartBeatManager.this.f346515c, GameTouchHeartBeatManager.this.f346513a);
                    if (System.currentTimeMillis() - GameTouchHeartBeatManager.this.f() <= GameTouchHeartBeatManager.this.f346513a) {
                        if (GameTouchHeartBeatManager.this.f346517e != null) {
                            str = GameTouchHeartBeatManager.this.f346517e.appId;
                        } else {
                            str = null;
                        }
                        if (GameTouchHeartBeatManager.this.f346514b != null) {
                            GameTouchHeartBeatManager.this.f346514b.onHeartBeat(str);
                        }
                    }
                }
            };
        }
    }

    public void e(MiniAppInfo miniAppInfo) {
        if (this.f346515c == null) {
            return;
        }
        this.f346517e = miniAppInfo;
        ThreadManager.getSubThreadHandler().postDelayed(this.f346515c, this.f346513a);
    }

    public long f() {
        TritonEngine tritonEngine = this.f346516d;
        if (tritonEngine != null) {
            return tritonEngine.getStatisticsManager().getLastTouchTimestamp();
        }
        return 0L;
    }

    public void g() {
        this.f346517e = null;
        if (this.f346515c == null) {
            return;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.f346515c);
    }
}
