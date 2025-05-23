package com.tencent.lightquic.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.lightquic.impl.LightQUICNative;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICEngine;", "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/lightquic/api/LightQUICSceneId;", DownloadInfo.spKey_Config, "Lcom/tencent/lightquic/api/LightQUICEngineConfig;", "(Lcom/tencent/lightquic/api/LightQUICSceneId;Lcom/tencent/lightquic/api/LightQUICEngineConfig;)V", "engineId", "", "cancelAllRequest", "", "createQUICRequest", "Lcom/tencent/lightquic/api/LightQUICRequest;", "url", "", "ip", "headers", "", "callback", "Lcom/tencent/lightquic/api/IRequestCallback;", "Lcom/tencent/lightquic/api/LightQUICRequestConfig;", "release", "Companion", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICEngine {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final ConcurrentHashMap<LightQUICSceneId, LightQUICEngine> instanceMap;
    private final long engineId;
    private final LightQUICSceneId sceneId;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICEngine$Companion;", "", "()V", "instanceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/lightquic/api/LightQUICSceneId;", "Lcom/tencent/lightquic/api/LightQUICEngine;", "getInstance", WadlProxyConsts.SCENE_ID, "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final LightQUICEngine getInstance(@NotNull LightQUICSceneId sceneId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (LightQUICEngine) iPatchRedirector.redirect((short) 1, (Object) this, (Object) sceneId);
            }
            Intrinsics.checkNotNullParameter(sceneId, "sceneId");
            ConcurrentHashMap concurrentHashMap = LightQUICEngine.instanceMap;
            Object obj = concurrentHashMap.get(sceneId);
            if (obj == null) {
                LightQUICEngineConfig lightQUICEngineConfig = LightQUICSDKMgr.INSTANCE.getEngineConfigMap$LightQUIC_debug().get(sceneId);
                if (lightQUICEngineConfig == null) {
                    lightQUICEngineConfig = new LightQUICEngineConfig(0.0f, 0.0f, 0.0f, false, false, null, false, null, 0, false, 0, 2047, null);
                }
                obj = new LightQUICEngine(sceneId, lightQUICEngineConfig, null);
                Object putIfAbsent = concurrentHashMap.putIfAbsent(sceneId, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            }
            Intrinsics.checkNotNullExpressionValue(obj, "instanceMap.getOrPut(sce\u2026neConfig())\n            }");
            return (LightQUICEngine) obj;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            instanceMap = new ConcurrentHashMap<>();
        }
    }

    LightQUICEngine(LightQUICSceneId lightQUICSceneId, LightQUICEngineConfig lightQUICEngineConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lightQUICSceneId, (Object) lightQUICEngineConfig);
        } else {
            this.sceneId = lightQUICSceneId;
            this.engineId = LightQUICNative.INSTANCE.createEngine(lightQUICSceneId.getId(), lightQUICEngineConfig);
        }
    }

    public static /* synthetic */ LightQUICRequest createQUICRequest$default(LightQUICEngine lightQUICEngine, String str, String str2, Map map, IRequestCallback iRequestCallback, LightQUICRequestConfig lightQUICRequestConfig, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            lightQUICRequestConfig = null;
        }
        return lightQUICEngine.createQUICRequest(str, str2, map, iRequestCallback, lightQUICRequestConfig);
    }

    public final void cancelAllRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            LightQUICNative.INSTANCE.cancelAllRequest(this.engineId);
        }
    }

    @NotNull
    public final LightQUICRequest createQUICRequest(@NotNull String url, @NotNull String ip5, @Nullable Map<String, String> headers, @NotNull IRequestCallback callback, @Nullable LightQUICRequestConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LightQUICRequest) iPatchRedirector.redirect((short) 1, this, url, ip5, headers, callback, config);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ip5, "ip");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new LightQUICRequest(this.engineId, url, ip5, headers, callback, config);
    }

    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            LightQUICNative.INSTANCE.releaseEngine(this.engineId);
            instanceMap.remove(this.sceneId);
        }
    }

    public /* synthetic */ LightQUICEngine(LightQUICSceneId lightQUICSceneId, LightQUICEngineConfig lightQUICEngineConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(lightQUICSceneId, lightQUICEngineConfig);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, lightQUICSceneId, lightQUICEngineConfig, defaultConstructorMarker);
    }
}
