package com.tencent.lightquic.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.lightquic.impl.LightQUICNative;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICSDKMgr;", "", "()V", "engineConfigMap", "", "Lcom/tencent/lightquic/api/LightQUICSceneId;", "Lcom/tencent/lightquic/api/LightQUICEngineConfig;", "getEngineConfigMap$LightQUIC_debug", "()Ljava/util/Map;", "configEngine", "", WadlProxyConsts.SCENE_ID, "engineConfig", "setLogListener", "logLevel", "", "listener", "Lcom/tencent/lightquic/api/ILightQUICLogListener;", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICSDKMgr {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final LightQUICSDKMgr INSTANCE;

    @NotNull
    private static final Map<LightQUICSceneId, LightQUICEngineConfig> engineConfigMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new LightQUICSDKMgr();
            engineConfigMap = new LinkedHashMap();
        }
    }

    LightQUICSDKMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public final void configEngine(@NotNull LightQUICSceneId sceneId, @NotNull LightQUICEngineConfig engineConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sceneId, (Object) engineConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(engineConfig, "engineConfig");
        engineConfigMap.put(sceneId, engineConfig);
    }

    @NotNull
    public final Map<LightQUICSceneId, LightQUICEngineConfig> getEngineConfigMap$LightQUIC_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Map) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return engineConfigMap;
    }

    public final void setLogListener(int logLevel, @NotNull ILightQUICLogListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, logLevel, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            LightQUICNative.INSTANCE.setLogListener(logLevel, listener);
        }
    }
}
