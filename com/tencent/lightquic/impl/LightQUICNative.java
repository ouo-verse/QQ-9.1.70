package com.tencent.lightquic.impl;

import android.util.Log;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.lightquic.api.ILightQUICLogListener;
import com.tencent.lightquic.api.IRequestCallback;
import com.tencent.lightquic.api.LightQUICEngineConfig;
import com.tencent.lightquic.api.LightQUICRequestConfig;
import com.tencent.mobileqq.msfcore.MSFKernel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0086 J\u0019\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086 JE\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086 J\u0011\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0019\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086 J\u0011\u0010\u001d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0086 J\u0019\u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0086 \u00a8\u0006!"}, d2 = {"Lcom/tencent/lightquic/impl/LightQUICNative;", "", "()V", "cancelAllRequest", "", "engineId", "", "cancelRequest", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "createEngine", WadlProxyConsts.SCENE_ID, "", "engineConfig", "Lcom/tencent/lightquic/api/LightQUICEngineConfig;", "createQUICRequest", "url", "", "ip", "headers", "", "callback", "Lcom/tencent/lightquic/api/IRequestCallback;", DownloadInfo.spKey_Config, "Lcom/tencent/lightquic/api/LightQUICRequestConfig;", "releaseEngine", "setLogListener", "logLevel", "listener", "Lcom/tencent/lightquic/api/ILightQUICLogListener;", "startRequest", "startRequestWithBody", "body", "", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICNative {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final LightQUICNative INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new LightQUICNative();
        try {
            System.loadLibrary(MSFKernel.LIGHT_QUIC_LIB);
        } catch (Exception e16) {
            Log.e("LightQUICNative", "load QUIC so error, e = " + e16.getMessage());
        }
    }

    LightQUICNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public final native void cancelAllRequest(long engineId);

    public final native void cancelRequest(long requestId);

    public final native long createEngine(int sceneId, @NotNull LightQUICEngineConfig engineConfig);

    public final native long createQUICRequest(long engineId, @NotNull String url, @NotNull String ip5, @NotNull Map<String, String> headers, @NotNull IRequestCallback callback, @NotNull LightQUICRequestConfig config);

    public final native void releaseEngine(long engineId);

    public final native void setLogListener(int logLevel, @NotNull ILightQUICLogListener listener);

    public final native void startRequest(long requestId);

    public final native void startRequestWithBody(long requestId, @NotNull byte[] body);
}
